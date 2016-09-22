#-*- coding: utf-8 -*-
"""
pywapiti 示例
"""

import pywapiti
from train import do_train
from predict import load_model, do_label

def get_non_default_members(obj):
    """
    :param obj:
    :return:
    """
    members = []
    for member in dir(obj):
        if member.startswith("__") and member.endswith("__"):
            continue
        else:
            members.append(member)
    return members


def get_member_value(obj, name):
    return getattr(obj, name)


def set_member_value(obj, name, value):
    setattr(obj, name, value)


def copy_opts(src_opts, new_opts):
    """
    复制参数
    :param new_opts:
    :param src_opts:
    :return:
    """
    assert type(new_opts) == type(src_opts),\
        "type of two opts not equal,"\
        + str(type(new_opts)) + "!=" + str(type(src_opts))

    for member_name in get_non_default_members(src_opts):
        if member_name == "this":
            continue
        value = get_member_value(src_opts, member_name)
        if str(type(value)).find("pywapiti.opt_s") >= 0:
            copy_opts(value, get_member_value(new_opts, member_name))
        else:
            # print "set member: ", member_name, "value", value
            set_member_value(new_opts, member_name, value)


def create_default_opt():
    new_opt = pywapiti.opt_s()
    copy_opts(pywapiti.opt_defaults, new_opt)
    return new_opt


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
