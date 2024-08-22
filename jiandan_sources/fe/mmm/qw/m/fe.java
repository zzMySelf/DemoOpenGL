package fe.mmm.qw.m;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("AndroidBug5497Workaround")
public final class fe {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public static final qw f8022yj = new qw((DefaultConstructorMarker) null);

    /* renamed from: ad  reason: collision with root package name */
    public int f8023ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public FrameLayout.LayoutParams f8024de;

    /* renamed from: fe  reason: collision with root package name */
    public int f8025fe;
    @Nullable
    public View qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f8026rg;

    /* renamed from: th  reason: collision with root package name */
    public int f8027th;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void qw(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            new fe(activity, (DefaultConstructorMarker) null);
        }
    }

    public fe(Activity activity) {
        ViewTreeObserver viewTreeObserver;
        this.f8026rg = true;
        this.f8027th = activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("status_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE));
        View findViewById = activity.findViewById(16908290);
        FrameLayout.LayoutParams layoutParams = null;
        FrameLayout frameLayout = findViewById instanceof FrameLayout ? (FrameLayout) findViewById : null;
        View childAt = frameLayout != null ? frameLayout.getChildAt(0) : null;
        this.qw = childAt;
        if (!(childAt == null || (viewTreeObserver = childAt.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(new ad(this));
        }
        View view = this.qw;
        ViewGroup.LayoutParams layoutParams2 = view != null ? view.getLayoutParams() : null;
        this.f8024de = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : layoutParams;
    }

    public /* synthetic */ fe(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    public static final void qw(fe feVar) {
        Intrinsics.checkNotNullParameter(feVar, "this$0");
        if (feVar.f8026rg) {
            View view = feVar.qw;
            feVar.f8025fe = view != null ? view.getHeight() : 0;
            feVar.f8026rg = false;
        }
        try {
            feVar.de();
        } catch (Exception e) {
            LoggerKt.d$default("AndroidBug5497 error:" + e, (Object) null, 1, (Object) null);
        }
    }

    public final int ad() {
        Rect rect = new Rect();
        View view = this.qw;
        if (view != null) {
            view.getWindowVisibleDisplayFrame(rect);
        }
        return rect.bottom - rect.top;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r1 = r1.getRootView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void de() {
        /*
            r5 = this;
            int r0 = r5.ad()
            int r1 = r5.f8023ad
            if (r0 == r1) goto L_0x004b
            android.view.View r1 = r5.qw
            if (r1 == 0) goto L_0x0017
            android.view.View r1 = r1.getRootView()
            if (r1 == 0) goto L_0x0017
            int r1 = r1.getHeight()
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            int r2 = r1 - r0
            int r3 = r1 / 4
            if (r2 <= r3) goto L_0x0039
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 19
            if (r3 < r4) goto L_0x0030
            android.widget.FrameLayout$LayoutParams r3 = r5.f8024de
            if (r3 != 0) goto L_0x0029
            goto L_0x0042
        L_0x0029:
            int r1 = r1 - r2
            int r2 = r5.f8027th
            int r1 = r1 + r2
            r3.height = r1
            goto L_0x0042
        L_0x0030:
            android.widget.FrameLayout$LayoutParams r3 = r5.f8024de
            if (r3 != 0) goto L_0x0035
            goto L_0x0042
        L_0x0035:
            int r1 = r1 - r2
            r3.height = r1
            goto L_0x0042
        L_0x0039:
            android.widget.FrameLayout$LayoutParams r1 = r5.f8024de
            if (r1 != 0) goto L_0x003e
            goto L_0x0042
        L_0x003e:
            int r2 = r5.f8025fe
            r1.height = r2
        L_0x0042:
            android.view.View r1 = r5.qw
            if (r1 == 0) goto L_0x0049
            r1.requestLayout()
        L_0x0049:
            r5.f8023ad = r0
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.m.fe.de():void");
    }
}
