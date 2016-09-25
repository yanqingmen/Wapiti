# -*- coding: utf-8 -*-
"""
util of pywapiti
"""
import pywapiti


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