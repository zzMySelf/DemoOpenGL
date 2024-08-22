package com.tera.scan.app;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import com.tera.scan.framework.framework.FrameworkLifecycle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/framework/framework/FrameworkLifecycle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FrameworkInitializerKt$initFramework$2 extends Lambda implements Function0<FrameworkLifecycle> {
    public static final FrameworkInitializerKt$initFramework$2 INSTANCE = new FrameworkInitializerKt$initFramework$2();

    public static final class qw implements FrameworkLifecycle {
        public void ad(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        public void de(@Nullable Activity activity, @NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }

        public void fe() {
        }

        public void i(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        public void qw(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        public void rg(@Nullable Activity activity, @NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }

        public void th(@NotNull Activity activity, boolean z) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        public void uk(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        public void yj(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }
    }

    public FrameworkInitializerKt$initFramework$2() {
        super(0);
    }

    @NotNull
    public final FrameworkLifecycle invoke() {
        return new qw();
    }
}
