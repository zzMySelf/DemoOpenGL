package com.baidu.searchbox.live.master.permission;

import android.app.Activity;
import com.baidu.searchbox.live.interfaces.permission.RequestSystemPermissionCallBack;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/live/master/permission/UserPermissionCallback;", "", "showPermissionWindow", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/searchbox/live/interfaces/permission/RequestSystemPermissionCallBack;", "source", "", "context", "Landroid/app/Activity;", "permissions", "", "(Ljava/lang/String;Landroid/app/Activity;[Ljava/lang/String;)Ljava/lang/ref/WeakReference;", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserPermissionCallback.kt */
public interface UserPermissionCallback {
    WeakReference<RequestSystemPermissionCallBack> showPermissionWindow(String str, Activity activity, String[] strArr);
}
