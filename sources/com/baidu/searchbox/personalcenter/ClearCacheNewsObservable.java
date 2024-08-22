package com.baidu.searchbox.personalcenter;

import android.content.Context;
import com.baidu.android.common.DataObservable;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/personalcenter/ClearCacheNewsObservable;", "Lcom/baidu/searchbox/personalcenter/IPersonalCenterDataObserver;", "()V", "mClearCacheObservable", "com/baidu/searchbox/personalcenter/ClearCacheNewsObservable$mClearCacheObservable$1", "Lcom/baidu/searchbox/personalcenter/ClearCacheNewsObservable$mClearCacheObservable$1;", "mHasRead", "", "getDataObservable", "Lcom/baidu/android/common/DataObservable;", "hasItemRead", "context", "Landroid/content/Context;", "hasRead", "queryUpdatesCount", "", "retractUpdates", "", "setHasRead", "setItemHasRead", "lib-personal-center-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheNewsObservable.kt */
public final class ClearCacheNewsObservable implements IPersonalCenterDataObserver {
    public static final ClearCacheNewsObservable INSTANCE = new ClearCacheNewsObservable();
    private static final ClearCacheNewsObservable$mClearCacheObservable$1 mClearCacheObservable = new ClearCacheNewsObservable$mClearCacheObservable$1();
    private static boolean mHasRead = true;

    private ClearCacheNewsObservable() {
    }

    public void setItemHasRead(Context context, boolean hasRead) {
        mHasRead = hasRead;
        mClearCacheObservable.notifyObservers();
    }

    public DataObservable getDataObservable() {
        return mClearCacheObservable;
    }

    public boolean hasRead(Context context) {
        return true;
    }

    public void retractUpdates() {
        setItemHasRead(AppRuntime.getAppContext(), true);
    }

    public boolean hasItemRead(Context context) {
        return mHasRead;
    }

    public void setHasRead(Context context, boolean hasRead) {
    }

    public int queryUpdatesCount() {
        return mHasRead ^ true ? 1 : 0;
    }
}
