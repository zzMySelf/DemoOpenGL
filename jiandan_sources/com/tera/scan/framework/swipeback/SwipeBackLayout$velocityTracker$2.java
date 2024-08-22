package com.tera.scan.framework.swipeback;

import android.view.VelocityTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwipeBackLayout$velocityTracker$2 extends Lambda implements Function0<VelocityTracker> {
    public static final SwipeBackLayout$velocityTracker$2 INSTANCE = new SwipeBackLayout$velocityTracker$2();

    public SwipeBackLayout$velocityTracker$2() {
        super(0);
    }

    public final VelocityTracker invoke() {
        return VelocityTracker.obtain();
    }
}
