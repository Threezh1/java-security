package point_jackjson;

import java.io.IOException;

public class Vuln {
    String cmd;

    Vuln(){
        System.out.println("init");
    }

    public String getCmd() {
        System.out.println("get");
        return cmd;
    }

    public void setCmd(String cmd) throws IOException {
        System.out.println("set");
        this.cmd = cmd;
        Runtime.getRuntime().exec(cmd);
    }
}