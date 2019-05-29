package com.cybozu.labs.langdetect;
import java.util.ArrayList;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;

class Test {
    
    public void init(String profileDirectory) throws LangDetectException {
        DetectorFactory.loadProfile(profileDirectory);
    }

    public String detect(String text) throws LangDetectException {
        Detector detector = DetectorFactory.create();
        detector.append(text);
        return detector.detect();
    }

    @SuppressWarnings("rawtypes")
    public ArrayList detectLangs(String text) throws LangDetectException 
{ 
    Detector detector = DetectorFactory.create(); detector.append(text); return detector.getProbabilities(); 
    }
    
    public static void main(String args [])
    {
        Test test = new Test();
        try {
            test.init("/home/sajjadafridi/Desktop/app/language-detection-master/profiles/");
            System.out.println(test.detect("who are you"));
        } catch (LangDetectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
