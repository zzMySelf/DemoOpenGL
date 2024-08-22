package com.tera.scan.framework.framework;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/tera/scan/framework/framework/FrameworkLifecycle;", "", "onActivityActive", "", "activity", "Landroid/app/Activity;", "onActivityCreateStart", "onActivityCreated", "onActivityDestory", "onActivityPause", "onBaseApplicationCreate", "onFragmentPause", "fragment", "Landroidx/fragment/app/Fragment;", "onFragmentResume", "onWindowFocusChanged", "hasFocu", "", "framework-android_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FrameworkLifecycle {
    void ad(@NotNull Activity activity);

    void de(@Nullable Activity activity, @NotNull Fragment fragment);

    void fe();

    void i(@NotNull Activity activity);

    void qw(@NotNull Activity activity);

    void rg(@Nullable Activity activity, @NotNull Fragment fragment);

    void th(@NotNull Activity activity, boolean z);

    void uk(@NotNull Activity activity);

    void yj(@NotNull Activity activity);
}
