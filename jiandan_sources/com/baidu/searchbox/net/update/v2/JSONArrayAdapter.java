package com.baidu.searchbox.net.update.v2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import fe.fe.ddd.ggg.qw.de.rg;
import java.io.IOException;
import org.json.JSONArray;

public class JSONArrayAdapter extends TypeAdapter<JSONArray> {
    /* renamed from: ad */
    public void write(JsonWriter jsonWriter, JSONArray jSONArray) throws IOException {
        jsonWriter.jsonValue(jSONArray.toString());
    }

    /* renamed from: qw */
    public JSONArray read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            return rg.qw(jsonReader);
        }
        return null;
    }
}
