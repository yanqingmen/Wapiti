# -*- coding: utf-8 -*
"""
训练crf模型
"""

import pywapiti

# 模型类型
TYPE_LIST = ["maxent", "memm", "crf"]

# 训练算法
TRAIN_LIST = {"l-bfgs": pywapiti.trn_lbfgs,
              "sgd-l1": pywapiti.trn_sgdl1,
              "bcd": pywapiti.trn_bcd,
              "rprop": pywapiti.trn_rprop,
              "rprop+": pywapiti.trn_rprop,
              "rprop-": pywapiti.trn_rprop}


def do_train(mdl=pywapiti.mdl_s()):
    """
    训练模型
    :param mdl:
    :return:
    """
    assert mdl.opt.type in TYPE_LIST,\
        "unknown model type: " + mdl.opt.type\
        + ", must be one of " + str(TYPE_LIST)

    assert mdl.opt.algo in TRAIN_LIST,\
        "unknown algorithm: " + mdl.opt.algo\
        + ", must be one of " + str(TRAIN_LIST)

    assert mdl.opt.input is not None,\
        "input opt should not be None for training job"

    if mdl.opt.model is not None:
        print "* load previous model"
        file_stream = pywapiti.fancy_fopen(mdl.opt.model, "r")
        pywapiti.mdl_load(file_stream)
        pywapiti.fancy_fclose(file_stream)

    if mdl.opt.pattern is not None:
        print "* Load patterns"
        file_stream = pywapiti.fancy_fopen(mdl.opt.pattern, "r")
        pywapiti.rdr_loadpat(mdl.reader, file_stream)
        pywapiti.fancy_fclose(file_stream)
        pywapiti.qrk_lock(mdl.reader.obs, False)

    print "* Load training data"
    file_stream = pywapiti.fancy_fopen(mdl.opt.input, "r")
    mdl.train = pywapiti.rdr_readdat(mdl.reader, file_stream, True)
    pywapiti.fancy_fclose(file_stream)
    pywapiti.qrk_lock(mdl.reader.lbl, True)
    pywapiti.qrk_lock(mdl.reader.obs, True)

    if mdl.opt.devel is not None:
        print "* Load development data"
        file_stream = pywapiti.fancy_fopen(mdl.opt.devel, "r")
        mdl.devel = pywapiti.rdr_readdat(mdl.reader, file_stream, True)
        pywapiti.fancy_fclose(file_stream)

    if mdl.theta is None:
        print "* Initialize the model"
    else:
        print "* Resync the model"
    pywapiti.mdl_sync(mdl)

    # display some statistics
    print "* Summary"
    print " nb train: ", mdl.train.nseq
    if mdl.devel is not None:
        print " nb devel: ", mdl.devel.nseq
    print " nb labels: ", mdl.nlbl
    print " nb blocks: ", mdl.nobs
    print " nb features: ", mdl.nftr
    print "* Train the model with: ", mdl.opt.algo

    pywapiti.uit_setup(mdl)
    TRAIN_LIST[mdl.opt.algo](mdl)
    pywapiti.uit_cleanup(mdl)

    # compact not supported now
    # TODO

    # save the trained model
    print "* Save the model"
    file_stream = pywapiti.fancy_fopen(mdl.opt.output, "w")
    pywapiti.mdl_save(mdl, file_stream)
    pywapiti.fancy_fclose(file_stream)
    print "Done"
