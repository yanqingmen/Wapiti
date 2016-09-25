#-*- coding: utf-8 -*-
"""
pywapiti 示例
"""

import pywapiti
from train import do_train
from predict import load_model, do_label
from util import create_default_opt


def train_crf(train_path, pattern_path, model_path):
    """
    train a crf model
    :param train_path:
    :param pattern_path:
    :param model_path:
    :return:
    """
    opt = create_default_opt()
    opt.input = train_path
    opt.pattern = pattern_path
    opt.output = model_path
    opt.maxiter = 10
    opt.nthread = 4

    crf_model = pywapiti.mdl_new(
        pywapiti.rdr_new(opt.maxent))
    crf_model.opt = opt
    do_train(crf_model)


def test_crf(model_path, test_path, label_path):
    """
    do label use a pre-trained crf model
    :param model_path:
    :param test_path:
    :param label_path:
    :return:
    """
    opt = create_default_opt()
    crf_model = pywapiti.mdl_new(
        pywapiti.rdr_new(opt.maxent))
    crf_model.opt = opt
    crf_model = load_model(crf_model, model_path)
    do_label(crf_model, test_path, label_path)


if __name__ == "__main__":
    import sys
    if not len(sys.argv) == 4:
        print "usage: python", __file__, "model_path data_path labeled_path"
    else:
        test_crf(model_path=sys.argv[1],
                 test_path=sys.argv[2],
                 label_path=sys.argv[3])