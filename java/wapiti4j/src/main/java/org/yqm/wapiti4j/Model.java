package org.yqm.wapiti4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yqm.wapiti4j.util.NativeLibLoader;
import org.yqm.wapiti4j.wrapper.mdl_s;

import org.yqm.wapiti4j.wrapper.opt_s;
import org.yqm.wapiti4j.wrapper.pywapiti;

import java.io.IOException;

/**
 * Created by hzx on 16-9-25.
 */
public class Model {
    private static final Log logger = LogFactory.getLog(Model.class);

    static {
        try {
            NativeLibLoader.initWapiti();
        } catch (IOException e) {
            logger.error(e);
        }
    }

    mdl_s mdl_handler;

    public Model(String modelPath) {
        opt_s default_opt = pywapiti.getOpt_defaults();
        this.mdl_handler = pywapiti.mdl_new(pywapiti.rdr_new(default_opt.getMaxent()));
        this.mdl_handler.setOpt(default_opt);
        pywapiti.mdl_load_path(this.mdl_handler, modelPath);
    }

}
