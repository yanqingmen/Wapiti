# -*- coding: utf-8 -*-
"""
利用 crf model 进行预测
"""
import pywapiti
from util import create_default_opt


def load_model(mdl, model_path):
    file_stream = pywapiti.fancy_fopen(model_path, "r")
    pywapiti.mdl_load(mdl, file_stream)
    pywapiti.fancy_fclose(file_stream)
    return mdl


def do_label(mdl, data_path, labeled_path):
    file_in_stream = pywapiti.fancy_fopen(data_path, "r")
    file_out_stream = pywapiti.fancy_fopen(labeled_path, "w")
    print "* Label sequences"
    pywapiti.tag_label(mdl, file_in_stream, file_out_stream)
    print "* Done"
    pywapiti.fancy_fclose(file_in_stream)
    pywapiti.fancy_fclose(file_out_stream)


class Predictor(object):
    """
    crf predictor
    """
    def __init__(self, model_path):
        self.model_path = model_path
        self.crf_model = self._init_model(model_path)

    def predict(self, seq):
        fancy_input = pywapiti.rdr_new_fancy_raw()
        fancy_output = pywapiti.rdr_new_fancy_raw()
        self._seq2fancy_raw(seq, fancy_input)
        pywapiti.tag_seq(self.crf_model, fancy_input, fancy_output)
        tags = self._fancy_raw2seq(fancy_output)
        # free wapiti objs
        pywapiti.rdr_free_fancy_raw(fancy_input)
        pywapiti.rdr_free_fancy_raw(fancy_output) 
        return tags

    @staticmethod
    def _init_model(model_path):
        opt = create_default_opt()
        crf_model = pywapiti.mdl_new(
            pywapiti.rdr_new(opt.maxent))
        crf_model.opt = opt
        crf_model = load_model(crf_model, model_path)
        return crf_model

    @staticmethod
    def _seq2fancy_raw(seq, fancy_raw):
        for item in seq:
            pywapiti.rdr_add_raw_line(fancy_raw, item, len(item)+1)
        return fancy_raw

    @staticmethod
    def _fancy_raw2seq(fancy_raw):
        seq = []
        for i in xrange(fancy_raw.len):
            seq.append(pywapiti.rdr_get_raw_line(fancy_raw, i))
        return seq