# -*- coding: utf-8 -*-
"""
利用 crf model 进行预测
"""
import pywapiti


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