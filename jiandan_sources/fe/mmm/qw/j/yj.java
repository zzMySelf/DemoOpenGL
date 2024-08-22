package fe.mmm.qw.j;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;

public class yj {
    public static Gson qw = new Gson();

    static {
        new JsonParser();
    }

    public static <T> T ad(String str, Type type) {
        return qw.fromJson(str, type);
    }

    public static JSONArray de(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONArray();
        }
        try {
            return new JSONArray(str);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public static String fe(Object obj) {
        return qw.toJson(obj);
    }

    public static <T> T qw(String str, Class<T> cls) {
        return qw.fromJson(str, cls);
    }
}
