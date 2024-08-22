package com.baidu.sofire.l;

import android.content.Context;
import com.baidu.sofire.j.a;

public class s {
    public static int a = -1;

    public static boolean a(Context context) {
        int i2;
        if (context == null) {
            return false;
        }
        int k = c.k(context);
        if (k != 1 || (i2 = a) == -1) {
            boolean z = !c.a(context, ".ffnpp");
            if (k == 1) {
                if (!z && a.a(context).c.getBoolean("s_a_pl", false) && !z) {
                    c.a(context, ".ffnpp", 0);
                    z = true;
                }
                if (z) {
                    a = 1;
                } else {
                    a = 2;
                }
            }
            return z;
        } else if (i2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
