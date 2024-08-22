package com.baidu.webkit.v8linker;

import android.content.Context;
import java.io.File;

public class ZeusV8Linker {
    public static final int LOAD_FAILED = 0;
    public static final int LOAD_NOT_FOUND = 2;
    public static final int LOAD_SUCCEED = 1;
    public static final int SWAN_ID = 1;
    public static final int TALOS_ID = 2;
    public static final int ZEUS_ID = 0;

    public interface LibraryInstaller {
        void installLibrary(Context context, String[] strArr, String str, File file, ZeusV8LinkerInstance zeusV8LinkerInstance);
    }

    public interface LibraryLoader {
        void loadLibrary(String str);

        void loadPath(String str);

        String mapLibraryName(String str);

        String[] supportedAbis();

        String unmapLibraryName(String str);
    }

    public interface Logger {
        void log(String str);
    }

    public static int loadV8Library(ClassLoader classLoader, Context context, int i2) {
        return loadV8Library(classLoader, context, i2, (String) null);
    }

    public static int loadV8Library(ClassLoader classLoader, Context context, int i2, String str) {
        return new ZeusV8LinkerInstance().loadV8Library(classLoader, context, i2, str);
    }

    public static ZeusV8LinkerInstance setV8LibPath(String str) {
        return new ZeusV8LinkerInstance().setV8LibPath(str);
    }

    public static ZeusV8LinkerInstance log(Logger logger) {
        return new ZeusV8LinkerInstance().log(logger);
    }

    private ZeusV8Linker() {
    }
}
