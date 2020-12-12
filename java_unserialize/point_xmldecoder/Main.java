package point_xmldecoder;

import java.beans.XMLDecoder;
import java.io.*;

public class Main{
    public static void main(String[] args){
        String poc = "/Users/threezh1/IdeaProjects/java_unserialize/src/point_xmldecoder/poc.xml";
        try {
            FileInputStream file = new FileInputStream(poc);
            XMLDecoder decoder = new XMLDecoder(file);
            decoder.readObject();
            decoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

