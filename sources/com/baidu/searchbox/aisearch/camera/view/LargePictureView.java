package com.baidu.searchbox.aisearch.camera.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.aisearch.camera.R;
import com.baidu.searchbox.aisearch.camera.runtime.AISearchCameraRuntime;
import com.baidu.searchbox.aisearch.camera.runtime.IAISearchCameraStat;
import com.baidu.searchbox.aisearch.camera.uitls.ViewExtKt;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002./B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\nH\u0007J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0007J\b\u0010-\u001a\u00020'H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 @@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00060"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/view/LargePictureView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defInt", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "confirmCallback", "Lcom/baidu/searchbox/aisearch/camera/view/LargePictureView$ConfirmCallback;", "finishTextView", "Landroid/widget/TextView;", "getFinishTextView", "()Landroid/widget/TextView;", "finishTextView$delegate", "Lkotlin/Lazy;", "imageOnly", "", "ivImageView", "Lcom/baidu/searchbox/aisearch/camera/view/ZoomStatImageView;", "getIvImageView", "()Lcom/baidu/searchbox/aisearch/camera/view/ZoomStatImageView;", "ivImageView$delegate", "menuBottom", "getMenuBottom", "()Landroid/widget/FrameLayout;", "menuBottom$delegate", "menuTop", "getMenuTop", "menuTop$delegate", "value", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "pageToken", "getPageToken$lib_aisearch_camera_release", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setPageToken$lib_aisearch_camera_release", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "hideMenu", "", "setConfirmCallback", "cb", "setImageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "showMenu", "Companion", "ConfirmCallback", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LargePictureView.kt */
public final class LargePictureView extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "LargePictureView";
    public Map<Integer, View> _$_findViewCache;
    private ConfirmCallback confirmCallback;
    private final Lazy finishTextView$delegate;
    private boolean imageOnly;
    private final Lazy ivImageView$delegate;
    private final Lazy menuBottom$delegate;
    private final Lazy menuTop$delegate;
    private UniqueId pageToken;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/view/LargePictureView$ConfirmCallback;", "", "onConfirm", "", "bitmap", "Landroid/graphics/Bitmap;", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LargePictureView.kt */
    public interface ConfirmCallback {
        void onConfirm(Bitmap bitmap);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LargePictureView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LargePictureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LargePictureView(Context context, AttributeSet attrs, int defInt) {
        super(context, attrs, defInt);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.ivImageView$delegate = LazyKt.lazy(new LargePictureView$ivImageView$2(this));
        this.finishTextView$delegate = LazyKt.lazy(new LargePictureView$finishTextView$2(this));
        this.menuTop$delegate = LazyKt.lazy(new LargePictureView$menuTop$2(this));
        this.menuBottom$delegate = LazyKt.lazy(new LargePictureView$menuBottom$2(this));
        setBackground(ResourcesCompat.getDrawable(AppRuntime.getAppContext().getResources(), R.drawable.aisearch_large_picture_background_color, (Resources.Theme) null));
        LayoutInflater.from(context).inflate(R.layout.aisearch_confirm_layout, this, true);
        getIvImageView().setZoomRange(1.0f, 4.0f);
        getIvImageView().setSingleTapListener(new LargePictureView$$ExternalSyntheticLambda0(this));
        ViewExtKt.addPressedState(getFinishTextView(), 0.4f, 1.0f);
        getFinishTextView().setOnClickListener(new LargePictureView$$ExternalSyntheticLambda1(this));
        getMenuTop().setOnTouchListener(new LargePictureView$$ExternalSyntheticLambda2());
        getMenuBottom().setOnTouchListener(new LargePictureView$$ExternalSyntheticLambda3());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LargePictureView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/view/LargePictureView$Companion;", "", "()V", "TAG", "", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LargePictureView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final ZoomStatImageView getIvImageView() {
        Object value = this.ivImageView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivImageView>(...)");
        return (ZoomStatImageView) value;
    }

    private final TextView getFinishTextView() {
        Object value = this.finishTextView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-finishTextView>(...)");
        return (TextView) value;
    }

    private final FrameLayout getMenuTop() {
        Object value = this.menuTop$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-menuTop>(...)");
        return (FrameLayout) value;
    }

    private final FrameLayout getMenuBottom() {
        Object value = this.menuBottom$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-menuBottom>(...)");
        return (FrameLayout) value;
    }

    public final UniqueId getPageToken$lib_aisearch_camera_release() {
        return this.pageToken;
    }

    public final void setPageToken$lib_aisearch_camera_release(UniqueId value) {
        this.pageToken = value;
        getIvImageView().setPageToken$lib_aisearch_camera_release(value);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m15131_init_$lambda0(LargePictureView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.imageOnly) {
            this$0.showMenu();
        } else {
            this$0.hideMenu();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m15132_init_$lambda2(LargePictureView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IAISearchCameraStat cameraStat = AISearchCameraRuntime.INSTANCE.getCameraStat();
        UniqueId uniqueId = this$0.pageToken;
        HashMap $this$lambda_u2d2_u24lambda_u2d1 = new HashMap();
        $this$lambda_u2d2_u24lambda_u2d1.put("pic_confirm", "send");
        Unit unit = Unit.INSTANCE;
        cameraStat.onModuleClick(uniqueId, "pic_confirm", "pic_confirm", $this$lambda_u2d2_u24lambda_u2d1);
        Drawable drawable = this$0.getIvImageView().getDrawable();
        Bitmap bitmap = null;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        }
        Bitmap bitmap2 = bitmap;
        ConfirmCallback confirmCallback2 = this$0.confirmCallback;
        if (confirmCallback2 != null) {
            confirmCallback2.onConfirm(bitmap2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final boolean m15133_init_$lambda3(View v, MotionEvent event) {
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-4  reason: not valid java name */
    public static final boolean m15134_init_$lambda4(View v, MotionEvent event) {
        return true;
    }

    public final void setConfirmCallback(ConfirmCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.confirmCallback = cb;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        getIvImageView().setImageBitmap(bitmap);
        showMenu();
    }

    private final void showMenu() {
        this.imageOnly = false;
        getMenuTop().setVisibility(0);
        getMenuBottom().setVisibility(0);
    }

    private final void hideMenu() {
        this.imageOnly = true;
        getMenuTop().setVisibility(8);
        getMenuBottom().setVisibility(8);
    }
}
