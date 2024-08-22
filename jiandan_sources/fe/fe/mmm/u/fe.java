package fe.fe.mmm.u;

import android.text.TextUtils;
import android.util.JsonWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class fe {
    public static void qw(JsonWriter jsonWriter, Object obj) throws IOException {
        Object opt;
        if (obj == null || obj == JSONObject.NULL) {
            jsonWriter.nullValue();
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            jsonWriter.beginArray();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                Object opt2 = jSONArray.opt(i2);
                if (opt2 != null) {
                    qw(jsonWriter, opt2);
                }
            }
            jsonWriter.endArray();
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            jsonWriter.beginObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (opt = jSONObject.opt(next)) != null) {
                    jsonWriter.name(next);
                    qw(jsonWriter, opt);
                }
            }
            jsonWriter.endObject();
        } else if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
        } else if (obj instanceof String) {
            jsonWriter.value((String) obj);
        } else if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
        } else {
            jsonWriter.value(obj.toString());
        }
    }
}
