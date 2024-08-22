package com.baidu.live.arch.api;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\bH&J-\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H&¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/baidu/live/arch/api/IExtLifecycle;", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onNewIntent", "intent", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: IExtLifecycle.kt */
public interface IExtLifecycle {
    void onActivityResult(int i2, int i3, Intent intent);

    void onConfigurationChanged(Configuration configuration);

    boolean onKeyDown(int i2, KeyEvent keyEvent);

    void onNewIntent(Intent intent);

    void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
}
