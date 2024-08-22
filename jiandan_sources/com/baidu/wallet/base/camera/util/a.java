package com.baidu.wallet.base.camera.util;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class a {
    public int a = -1;

    /* renamed from: com.baidu.wallet.base.camera.util.a$a  reason: collision with other inner class name */
    public class C0061a implements FileFilter {
        public Pattern a = Pattern.compile("cpu\\d{1,2}");

        public boolean accept(File file) {
            return this.a.matcher(file.getName()).matches();
        }
    }

    public static class b {
        public static a a = new a();
    }

    public static int a() {
        if (-1 == b.a.a) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C0061a());
                b.a.a = listFiles.length;
            } catch (Exception e) {
                e.printStackTrace();
                b.a.a = 1;
            }
        }
        return b.a.a;
    }
}
