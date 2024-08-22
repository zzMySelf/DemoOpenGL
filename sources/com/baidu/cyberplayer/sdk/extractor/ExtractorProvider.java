package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.util.Map;

public abstract class ExtractorProvider {
    public abstract Bundle getMediaMeta();

    public abstract void release();

    public abstract void setDataSource(Context context, Uri uri);

    public abstract void setDataSource(Context context, Uri uri, Map<String, String> map);

    public abstract void setDataSource(FileDescriptor fileDescriptor);

    public abstract void setDataSource(String str);

    public void setOption(int category, String name, long value) {
    }
}
