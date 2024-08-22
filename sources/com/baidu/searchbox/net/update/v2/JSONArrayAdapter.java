package com.baidu.searchbox.net.update.v2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.json.JSONArray;

public class JSONArrayAdapter extends TypeAdapter<JSONArray> {
    public void write(JsonWriter out, JSONArray value) throws IOException {
        out.jsonValue(value.toString());
    }

    public JSONArray read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.BEGIN_ARRAY) {
            return JSONParser.readJSONArray(in);
        }
        return null;
    }
}
