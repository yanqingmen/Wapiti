package org.yqm.wapiti4j;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hzx on 16-9-25.
 */
public class PredictorTest {
    public static void main(String[] args) {
        String modelPath = "./example/example_model";
        List<String> testSeq = Arrays.asList("Confidence NN",
                "in IN", "the DT", "pound NN");

        Predictor pred = new Predictor(modelPath);

        List<String> tags = pred.predict(testSeq);

        System.out.println(tags);
    }
}