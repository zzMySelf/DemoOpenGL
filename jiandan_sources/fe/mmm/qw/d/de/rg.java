package fe.mmm.qw.d.de;

import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.collection.ArrayMap;
import java.lang.reflect.Constructor;
import java.util.Map;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static final Map<String, Constructor<? extends View>> f7699ad = new ArrayMap();

    /* renamed from: de  reason: collision with root package name */
    public static final Class<?>[] f7700de = {Context.class, AttributeSet.class};

    /* renamed from: fe  reason: collision with root package name */
    public static final String[] f7701fe = {"android.widget.", "android.view.", "android.webkit."};
    public static final Object[] qw = new Object[2];

    public static View ad(Context context, String str, AttributeSet attributeSet) {
        if ("view".equals(str)) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            qw[0] = context;
            qw[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (String qw2 : f7701fe) {
                    View qw3 = qw(context, str, qw2);
                    if (qw3 != null) {
                        return qw3;
                    }
                }
                Object[] objArr = qw;
                objArr[0] = null;
                objArr[1] = null;
                return null;
            }
            View qw4 = qw(context, str, (String) null);
            Object[] objArr2 = qw;
            objArr2[0] = null;
            objArr2[1] = null;
            return qw4;
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr3 = qw;
            objArr3[0] = null;
            objArr3[1] = null;
        }
    }

    public static View qw(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Constructor<? extends U> constructor = f7699ad.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(f7700de);
                f7699ad.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(qw);
    }
}
