package com.baidu.swan.apps.util;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.baidu.swan.apps.adaptation.interfaces.IContentHelper;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import java.io.File;

public final class SwanContentUtils {
    private SwanContentUtils() {
    }

    public static IContentHelper ioc() {
        return SwanAppRuntime.getContentHelper();
    }

    public static Uri geProviderUriForFile(Context context, File file) {
        return FileProvider.getUriForFile(context, ioc().getFileProviderAuthority(context), file);
    }
}
