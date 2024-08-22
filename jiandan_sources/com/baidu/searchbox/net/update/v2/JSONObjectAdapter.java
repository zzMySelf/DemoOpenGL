package com.baidu.searchbox.net.update.v2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import fe.fe.ddd.ggg.qw.de.rg;
import java.io.IOException;
import org.json.JSONObject;

public class JSONObjectAdapter extends TypeAdapter<JSONObject> {
    /* renamed from: ad */
    public void write(JsonWriter jsonWriter, JSONObject jSONObject) throws IOException {
        jsonWriter.jsonValue(jSONObject.toString());
    }

    /* renamed from: qw */
    public JSONObject read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
            return rg.ad(jsonReader);
        }
        return null;
    }
}
