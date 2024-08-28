package jsonfiles;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {
    public static String findDestinationValue(String jsonContent) {
        JSONObject jsonObject = new JSONObject(jsonContent);
        return findDestinationValue(jsonObject);
    }

    private static String findDestinationValue(JSONObject jsonObject) {
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            if (key.equals("destination")) {
                return value.toString();
            } else if (value instanceof JSONObject) {
                String result = findDestinationValue((JSONObject) value);
                if (result != null) {
                    return result;
                }
            } else if (value instanceof JSONArray) {
                for (Object item : (JSONArray) value) {
                    if (item instanceof JSONObject) {
                        String result = findDestinationValue((JSONObject) item);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
        }
        return null;
    }
}
