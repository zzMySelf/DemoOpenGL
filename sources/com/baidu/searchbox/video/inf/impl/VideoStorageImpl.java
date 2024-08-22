package com.baidu.searchbox.video.inf.impl;

import com.baidu.searchbox.video.detail.utils.VideoSharedPrefsUtils;
import com.baidu.searchbox.video.inf.VideoStorageService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J$\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u0018\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/video/inf/impl/VideoStorageImpl;", "Lcom/baidu/searchbox/video/inf/VideoStorageService;", "()V", "getBoolean", "", "key", "", "defValue", "type", "", "getFloat", "", "getInt", "getLong", "", "getQuickBoolean", "getQuickInt", "getString", "putBoolean", "", "value", "putFloat", "putInt", "putLong", "putQuickBoolean", "putQuickInt", "putString", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoStorageImpl.kt */
public final class VideoStorageImpl implements VideoStorageService {
    public float getFloat(String key, float defValue, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        return VideoSharedPrefsUtils.getFloat(key, defValue, type);
    }

    public void putQuickInt(String key, int value, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        VideoSharedPrefsUtils.putQuickInt(key, value, type);
    }

    public boolean getBoolean(String key, boolean defValue, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        return VideoSharedPrefsUtils.getBoolean(key, defValue, type);
    }

    public void putLong(String key, long value, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        VideoSharedPrefsUtils.putLong(key, value, type);
    }

    public void putFloat(String key, float value, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        VideoSharedPrefsUtils.putFloat(key, value, type);
    }

    public int getQuickInt(String key, int defValue, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        return VideoSharedPrefsUtils.getQuickInt(key, defValue, type);
    }

    public void putQuickBoolean(String key, boolean value, int type) {
        VideoSharedPrefsUtils.putQuickBoolean(key, value, type);
    }

    public boolean getQuickBoolean(String key, boolean defValue, int type) {
        return VideoSharedPrefsUtils.getQuickBoolean(key, defValue, type);
    }

    public void putInt(String key, int value, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        VideoSharedPrefsUtils.putInt(key, value, type);
    }

    public int getInt(String key, int defValue, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        return VideoSharedPrefsUtils.getInt(key, defValue, type);
    }

    public String getString(String key, String defValue, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        return VideoSharedPrefsUtils.getString(key, defValue, type);
    }

    public void putBoolean(String key, boolean value, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        VideoSharedPrefsUtils.putBoolean(key, value, type);
    }

    public long getLong(String key, long defValue, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        return VideoSharedPrefsUtils.getLong(key, defValue, type);
    }

    public void putString(String key, String value, int type) {
        Intrinsics.checkNotNullParameter(key, "key");
        VideoSharedPrefsUtils.putString(key, value, type);
    }
}
