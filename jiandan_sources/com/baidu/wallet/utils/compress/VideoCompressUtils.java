package com.baidu.wallet.utils.compress;

import android.content.Context;
import android.net.Uri;
import com.baidu.wallet.core.NoProguard;

public class VideoCompressUtils implements NoProguard {

    public interface ProgressListener extends NoProguard {
        void onFinish(boolean z);

        void onProgress(float f);

        void onStart();
    }

    public static void convertVideo(Context context, Uri uri, String str, ProgressListener progressListener) {
        new f(progressListener).execute(new Object[]{context, uri, str});
    }
}
