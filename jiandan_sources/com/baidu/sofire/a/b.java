package com.baidu.sofire.a;

import android.content.Context;
import com.baidu.sofire.b.l;
import com.baidu.sofire.l.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class b {
    public static Map<String, c> a = new HashMap();

    public static void a(Context context, int i2, File file, File file2) {
        try {
            if (c.a(file)) {
                if (!c.a(file2)) {
                    l.a(file, file2);
                }
                if (!a.containsKey(file.getAbsolutePath())) {
                    c cVar = new c(context, i2, file.getAbsolutePath(), file2.getAbsolutePath());
                    cVar.startWatching();
                    a.put(file.getAbsolutePath(), cVar);
                }
            }
        } catch (Throwable unused) {
            int i3 = a.a;
        }
    }

    public static void a(File file) {
        if (file != null) {
            try {
                c cVar = a.get(file.getAbsolutePath());
                if (cVar != null) {
                    cVar.stopWatching();
                    a.remove(file.getAbsolutePath());
                    cVar.a();
                }
            } catch (Throwable unused) {
                int i2 = a.a;
            }
        }
    }
}
