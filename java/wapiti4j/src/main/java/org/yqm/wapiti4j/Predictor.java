package org.yqm.wapiti4j;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by hzx on 16-9-25.
 */
public class Predictor {
    private static final Log logger = LogFactory.getLog(Predictor.class);

    Model model;

    public Predictor(String modelPath) {
        model = new Model(modelPath);
    }

    public List<String> predict(List<String> seq) {
        return Wapiti.tag_seq(model.mdl_handler, seq);
    }
}
