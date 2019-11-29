package test.com.solutions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TestMapJacksonSerialization {

    @Test
    public void testHashMapJsonSerialization() throws IOException {

        Map<String, Boolean> mapObject = new HashMap<>();
        mapObject.put("1003", Boolean.TRUE);
        mapObject.put("1005", Boolean.TRUE);
        mapObject.put("1009", Boolean.TRUE);
        mapObject.put("101", Boolean.TRUE);
        mapObject.put("1014", Boolean.FALSE);
        mapObject.put("1015", Boolean.TRUE);
        mapObject.put("102", Boolean.FALSE);
        mapObject.put("1021", Boolean.TRUE);
        mapObject.put("1027", Boolean.TRUE);
        mapObject.put("103", Boolean.TRUE);
        mapObject.put("104", Boolean.TRUE);
        mapObject.put("105", Boolean.TRUE);
        mapObject.put("106", Boolean.TRUE);
        mapObject.put("107", Boolean.FALSE);
        mapObject.put("108", Boolean.TRUE);

        StringWriter sw = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(sw, mapObject);

        System.out.println(sw.toString());

    }

    @Test
    public void testHashMapJsonDeSerialization() throws IOException {
        String mapStr = "{\"1021\":true,\"101\":true,\"1005\":true,\"102\":false,\"1027\":true,\"1015\":true,\"103\":true," +
                "\"1003\":true,\"1014\":false,\"104\":true,\"105\":true,\"106\":true,\"107\":false,\"108\":true,\"1009\":true}";

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Boolean> accountMap = objectMapper.readValue(mapStr, Map.class);

        Assert.assertTrue(accountMap.get("1005"));
        Assert.assertFalse(accountMap.get("102"));
    }
}
