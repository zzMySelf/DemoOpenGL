package fe.fe.ddd.ggg.qw.de;

import android.content.Context;
import com.google.gson.TypeAdapter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.json.JSONException;

public abstract class qw<T> {
    public final ad<T> ad() {
        return new ad<>();
    }

    public abstract boolean de(Context context, String str, String str2, ad<T> adVar);

    public final Type fe() {
        for (Class cls = getClass(); cls != null; cls = cls.getSuperclass()) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            }
        }
        return null;
    }

    public abstract void qw(Context context, String str, String str2, fe.fe.ddd.ggg.qw.qw qwVar) throws JSONException;

    public abstract String rg(Context context, String str, String str2);

    public TypeAdapter<T> th() {
        return null;
    }
}
