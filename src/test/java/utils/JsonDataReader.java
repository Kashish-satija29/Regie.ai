package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {
    private static JsonNode root;

    static {
        ObjectMapper mapper = new ObjectMapper();
        try {
            root = mapper.readTree(new File("src/test/resources/testData/devData.json"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read JSON file", e);
        }
    }

    public static String get(String scenario, String key) {
        return root.path(scenario).path(key).asText();
    }
}
