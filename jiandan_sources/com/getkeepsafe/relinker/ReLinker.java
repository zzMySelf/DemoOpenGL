package com.getkeepsafe.relinker;

import android.content.Context;
import fe.pf.qw.ad;
import java.io.File;

public class ReLinker {

    public interface LibraryInstaller {
        void qw(Context context, String[] strArr, String str, File file, ad adVar);
    }

    public interface LibraryLoader {
        String ad(String str);

        String[] de();

        void fe(String str);

        void loadLibrary(String str);

        String qw(String str);
    }

    public interface LoadListener {
        void qw(Throwable th2);

        void success();
    }

    public interface Logger {
        void log(String str);
    }

    public static void ad(Context context, String str, String str2, LoadListener loadListener) {
        new ad().th(context, str, str2, loadListener);
    }

    public static void qw(Context context, String str) {
        ad(context, str, (String) null, (LoadListener) null);
    }
}
