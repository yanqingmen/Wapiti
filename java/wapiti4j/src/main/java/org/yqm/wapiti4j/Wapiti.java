package org.yqm.wapiti4j;

/**
 * Created by hzx on 16-9-25.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yqm.wapiti4j.util.NativeLibLoader;
import org.yqm.wapiti4j.wrapper.fancy_raw_s;
import org.yqm.wapiti4j.wrapper.mdl_s;
import org.yqm.wapiti4j.wrapper.opt_s;
import org.yqm.wapiti4j.wrapper.pywapiti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Wapiti {
    private static final Log logger = LogFactory.getLog(Wapiti.class);

    static {
        try {
            NativeLibLoader.initWapiti();
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public static List<String> tag_seq(mdl_s mdl, List<String> seq) {
        fancy_raw_s input = pywapiti.rdr_new_fancy_raw();
        fancy_raw_s output = pywapiti.rdr_new_fancy_raw();

        seq2FancyRaw(seq, input);
        pywapiti.tag_seq(mdl, input, output);
        List<String> tag_list = fancyRaw2Seq(output);

        return tag_list;
    }

    private static void seq2FancyRaw(List<String> seq, fancy_raw_s raw_input) {
        for(String item: seq) {
            pywapiti.rdr_add_raw_line(raw_input, item, item.getBytes().length+1);
        }
    }

    private static List<String> fancyRaw2Seq(fancy_raw_s raw_output) {
        List<String> seqList = new ArrayList<String>();

        for(int i=0; i<raw_output.getLen(); i++) {
            seqList.add(pywapiti.rdr_get_raw_line(raw_output, i));
        }

        return seqList;
    }
}