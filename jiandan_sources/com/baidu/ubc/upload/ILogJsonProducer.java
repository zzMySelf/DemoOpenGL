package com.baidu.ubc.upload;

import android.util.JsonWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public interface ILogJsonProducer {
    String ad();

    JSONObject de() throws JSONException;

    void qw(JsonWriter jsonWriter) throws IOException;
}
