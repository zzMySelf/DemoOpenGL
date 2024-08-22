package com.baidu.sofire.l;

import com.baidu.sofire.a.a;
import java.security.SecureRandom;
import java.util.Random;

public class v {
    public static Random a = new SecureRandom();

    public static String a() {
        try {
            int nextInt = a.nextInt();
            if (nextInt <= 0) {
                return String.valueOf(nextInt);
            }
            return "-" + nextInt;
        } catch (Throwable unused) {
            int i2 = a.a;
            return "-1";
        }
    }
}
