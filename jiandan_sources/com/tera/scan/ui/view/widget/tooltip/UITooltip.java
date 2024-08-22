package com.tera.scan.ui.view.widget.tooltip;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.baidu.android.common.others.lang.StringUtil;
import fe.mmm.qw.f.ad.de.qw;
import fe.mmm.qw.f.de.de.de.ad;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\n\u0001\u0001\u0001\u0001\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010d\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u0013H\u0002J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iH\u0003J\u0006\u0010j\u001a\u00020\u001bJ+\u0010k\u001a\u00020\u00002#\u0010l\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017J+\u0010m\u001a\u00020\u00002#\u0010l\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017J+\u0010n\u001a\u00020\u00002#\u0010l\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017J+\u0010o\u001a\u00020\u00002#\u0010l\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017J+\u0010p\u001a\u00020\u00002#\u0010l\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017J\b\u0010q\u001a\u00020\u001bH\u0002J\b\u0010r\u001a\u00020\u001bH\u0002JD\u0010s\u001a\u0004\u0018\u00010<2\u0006\u0010t\u001a\u00020\u00112\b\u0010u\u001a\u0004\u0018\u00010\u00112\u0006\u0010v\u001a\u00020\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0w2\u0006\u0010x\u001a\u00020g2\b\b\u0002\u0010y\u001a\u00020\fH\u0002J\u0006\u0010z\u001a\u00020\u001bJ\u0014\u0010{\u001a\u0004\u0018\u00010\u00002\b\u0010|\u001a\u0004\u0018\u00010<H\u0002J\"\u0010}\u001a\u00020\u00132\u0006\u0010~\u001a\u00020\u00132\u0006\u0010\u001a\u00020\u00132\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0019\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020E2\u0007\u0010\u0001\u001a\u00020EJ\u0019\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020E2\u0007\u0010\u0001\u001a\u00020EJ%\u0010\u0001\u001a\u00020\u001b2\u0006\u0010t\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010y\u001a\u00020\fH\u0002J\t\u0010\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u0001\u001a\u00020\u001bH\u0002J\u0013\u0010\u0001\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011H\u0002J\u0011\u0010\u0001\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020,H\u0002J\u0011\u0010\u0001\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0011H\u0002J#\u0010\u0001\u001a\u00020\u001b2\u0006\u0010t\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010y\u001a\u00020\fJ%\u0010\u0001\u001a\u00020\u001b2\u0006\u0010t\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010y\u001a\u00020\fH\u0002J\u0011\u0010\u0001\u001a\u00020\u001b2\b\u0010X\u001a\u0004\u0018\u00010AJ\u0012\u0010\u0001\u001a\u00020\u001b2\t\b\u0001\u0010\u0001\u001a\u00020\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00118F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R+\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000R$\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u001e\u001a\u0004\u0018\u00010,8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R+\u00103\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010CR\u0011\u0010D\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0011\u0010H\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bI\u0010GR\u000e\u0010J\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\b\u0018\u00010LR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u000e¢\u0006\u0002\n\u0000R+\u0010O\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R+\u0010S\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WXD¢\u0006\u0002\n\u0000R$\u0010X\u001a\u0004\u0018\u00010A2\b\u0010\u001e\u001a\u0004\u0018\u00010A8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u000e\u0010[\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/tera/scan/ui/view/widget/tooltip/UITooltip;", "", "context", "Landroid/content/Context;", "builder", "Lcom/tera/scan/ui/view/widget/tooltip/UITooltip$Builder;", "(Landroid/content/Context;Lcom/tera/scan/ui/view/widget/tooltip/UITooltip$Builder;)V", "activateDelay", "", "activateRunnable", "Ljava/lang/Runnable;", "activated", "", "anchorPoint", "Landroid/graphics/Point;", "anchorView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "animationStyleResId", "", "animator", "Landroid/animation/ValueAnimator;", "clickFunc", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tooltip", "", "closePolicy", "Lcom/tera/scan/ui/view/widget/tooltip/ClosePolicy;", "<set-?>", "contentView", "getContentView", "()Landroid/view/View;", "drawable", "Lcom/tera/scan/ui/view/widget/tooltip/UITooltipTextDrawable;", "enterAnimation", "exitAnimation", "failureFunc", "floatingAnimation", "Lcom/tera/scan/ui/view/widget/tooltip/UITooltip$Animation;", "followAnchor", "gravities", "", "Lcom/tera/scan/ui/view/widget/tooltip/UITooltip$Gravity;", "gravity", "getGravity", "()Lcom/tera/scan/ui/view/widget/tooltip/UITooltip$Gravity;", "handler", "Landroid/os/Handler;", "hasAnchorView", "hiddenFunc", "hideRunnable", "isCustomView", "isShowing", "()Z", "isVisible", "layoutInsetDecor", "mContentView", "mCurrentPosition", "Lcom/tera/scan/ui/view/widget/tooltip/UITooltip$Positions;", "mNewLocation", "", "mOldLocation", "mText", "", "maxWidth", "Ljava/lang/Integer;", "offsetX", "", "getOffsetX", "()F", "offsetY", "getOffsetY", "padding", "popupView", "Lcom/tera/scan/ui/view/widget/tooltip/UITooltip$TooltipViewContainer;", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "prepareFun", "safeArea", "showArrow", "showDuration", "shownFunc", "sizeTolerance", "softInputMode", "tag", "", "text", "getText", "()Ljava/lang/CharSequence;", "textStyleResId", "textView", "Landroid/widget/TextView;", "textViewIdRes", "tooltipCustomView", "tooltipLayoutIdRes", "windowLayoutType", "windowManager", "Landroid/view/WindowManager;", "computeFlags", "curFlags", "createPopupLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "token", "Landroid/os/IBinder;", "dismiss", "doOnClick", "func", "doOnFailure", "doOnHidden", "doOnPrepare", "doOnShown", "fadeIn", "fadeOut", "findPosition", "parent", "anchor", "offset", "Ljava/util/ArrayList;", "params", "fitToScreen", "hide", "invokePopup", "positions", "makeSafeX", "x", "contentWidth", "displayFrame", "Landroid/graphics/Rect;", "offsetBy", "xoff", "yoff", "offsetTo", "postShow", "preparePopup", "removeCallbacks", "removeListeners", "setupAnimation", "setupListeners", "show", "showWithCatch", "update", "res", "Animation", "Builder", "Gravity", "Positions", "TooltipViewContainer", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UITooltip {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f7379ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Handler f7380de;

    /* renamed from: fe  reason: collision with root package name */
    public long f7381fe;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public View f7382i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public Function1<? super UITooltip, Unit> f316if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final Runnable f7383o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final Runnable f7384pf;
    @NotNull
    public final String qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public ad f7385rg;

    /* renamed from: th  reason: collision with root package name */
    public long f7386th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f7387uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public ValueAnimator f7388yj;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/tera/scan/ui/view/widget/tooltip/UITooltip$Gravity;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "TOP", "BOTTOM", "CENTER", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Gravity {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        CENTER
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J0\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014J(\u0010\u0019\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001dH\u0017R@\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/tera/scan/ui/view/widget/tooltip/UITooltip$TooltipViewContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tera/scan/ui/view/widget/tooltip/UITooltip;Landroid/content/Context;)V", "sizeChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "", "tag", "", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onSizeChanged", "oldw", "oldh", "onTouchEvent", "Landroid/view/MotionEvent;", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TooltipViewContainer extends FrameLayout {
        @NotNull
        public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
        @Nullable
        public Function2<? super Integer, ? super Integer, Unit> sizeChange;
        @NotNull
        public final String tag;
        public final /* synthetic */ UITooltip this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TooltipViewContainer(@NotNull UITooltip uITooltip, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = uITooltip;
            this.tag = "TooltipViewContainer";
            setClipChildren(false);
            setClipToPadding(false);
        }

        public void _$_clearFindViewByIdCache() {
            this._$_findViewCache.clear();
        }

        @Nullable
        public View _$_findCachedViewById(int i2) {
            Map<Integer, View> map = this._$_findViewCache;
            View view = map.get(Integer.valueOf(i2));
            if (view != null) {
                return view;
            }
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }

        public boolean dispatchKeyEvent(@NotNull KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
            if (!this.this$0.xxx() || !this.this$0.f7379ad || !this.this$0.f7387uk) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getKeyCode() != 4) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 == null) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyDispatcherState2.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    qw.qw.qw(this.tag, "Back pressed, close the tooltip");
                    this.this$0.vvv();
                    return true;
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                int[] iArr = {-1, -1};
                getLocationOnScreen(iArr);
                qw qwVar = qw.qw;
                String str = this.tag;
                qwVar.qw(str, "globalVisibleRect: " + iArr[0] + StringUtil.ARRAY_ELEMENT_SEPARATOR + iArr[1]);
                offsetTopAndBottom(-iArr[1]);
            }
        }

        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            Function2<? super Integer, ? super Integer, Unit> function2 = this.sizeChange;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
            Function1 rg2;
            Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
            if (!this.this$0.xxx() || !this.this$0.f7379ad || !this.this$0.f7387uk) {
                return false;
            }
            qw qwVar = qw.qw;
            String str = this.tag;
            qwVar.qw(str, "onTouchEvent: " + motionEvent);
            qw qwVar2 = qw.qw;
            String str2 = this.tag;
            qwVar2.qw(str2, "event position: " + motionEvent.getX() + StringUtil.ARRAY_ELEMENT_SEPARATOR + motionEvent.getY());
            Rect rect = new Rect();
            this.this$0.f7382i.getGlobalVisibleRect(rect);
            boolean contains = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            if (motionEvent.getAction() == 0 && contains && (rg2 = this.this$0.f316if) != null) {
                rg2.invoke(this.this$0);
            }
            this.this$0.f7385rg.qw();
            throw null;
        }
    }

    public final void ddd() {
        throw null;
    }

    public final void ggg() {
        throw null;
    }

    public final void nn(View view, Gravity gravity, boolean z) {
        throw null;
    }

    public final void vvv() {
        throw null;
    }

    public final boolean xxx() {
        throw null;
    }
}
