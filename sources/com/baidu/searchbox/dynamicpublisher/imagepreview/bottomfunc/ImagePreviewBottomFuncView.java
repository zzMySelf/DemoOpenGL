package com.baidu.searchbox.dynamicpublisher.imagepreview.bottomfunc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.mvp.common.MvpUbcModel;
import com.baidu.searchbox.publisher.image.interfaces.IPublisherImageEditInterface;
import com.baidu.searchbox.publishercomponent.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020.R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\fR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR9\u0010\"\u001a!\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0017\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/imagepreview/bottomfunc/ImagePreviewBottomFuncView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnChangePic", "Landroid/widget/Button;", "getBtnChangePic", "()Landroid/widget/Button;", "btnChangePic$delegate", "Lkotlin/Lazy;", "btnDeletePic", "getBtnDeletePic", "btnDeletePic$delegate", "btnEditPic", "getBtnEditPic", "btnEditPic$delegate", "onChangePicClickListener", "Lkotlin/Function0;", "", "getOnChangePicClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnChangePicClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onDeletePicClickListener", "getOnDeletePicClickListener", "setOnDeletePicClickListener", "onEditPicClickListener", "getOnEditPicClickListener", "setOnEditPicClickListener", "onUbcActionListener", "Lkotlin/Function1;", "Lcom/baidu/searchbox/mvp/common/MvpUbcModel;", "Lkotlin/ParameterName;", "name", "mvpUbcModel", "getOnUbcActionListener", "()Lkotlin/jvm/functions/Function1;", "setOnUbcActionListener", "(Lkotlin/jvm/functions/Function1;)V", "setChangePicButtonVisible", "visible", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImagePreviewBottomFuncView.kt */
public final class ImagePreviewBottomFuncView extends RelativeLayout {
    public Map<Integer, View> _$_findViewCache;
    private final Lazy btnChangePic$delegate;
    private final Lazy btnDeletePic$delegate;
    private final Lazy btnEditPic$delegate;
    private Function0<Unit> onChangePicClickListener;
    private Function0<Unit> onDeletePicClickListener;
    private Function0<Unit> onEditPicClickListener;
    private Function1<? super MvpUbcModel, Unit> onUbcActionListener;

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
    public ImagePreviewBottomFuncView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.btnChangePic$delegate = LazyKt.lazy(new ImagePreviewBottomFuncView$btnChangePic$2(this));
        this.btnEditPic$delegate = LazyKt.lazy(new ImagePreviewBottomFuncView$btnEditPic$2(this));
        this.btnDeletePic$delegate = LazyKt.lazy(new ImagePreviewBottomFuncView$btnDeletePic$2(this));
        View.inflate(context, R.layout.dynamic_publisher_image_preview_bottom_func_view, this);
        getBtnChangePic().setOnClickListener(new ImagePreviewBottomFuncView$$ExternalSyntheticLambda0(this));
        getBtnEditPic().setOnClickListener(new ImagePreviewBottomFuncView$$ExternalSyntheticLambda1(this));
        getBtnDeletePic().setOnClickListener(new ImagePreviewBottomFuncView$$ExternalSyntheticLambda2(this));
        if (((IPublisherImageEditInterface) ServiceManager.getService(IPublisherImageEditInterface.SERVICE_REFERENCE)).isImagePluginInstalled()) {
            getBtnEditPic().setVisibility(0);
        } else {
            getBtnEditPic().setVisibility(8);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImagePreviewBottomFuncView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final Button getBtnChangePic() {
        Object value = this.btnChangePic$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-btnChangePic>(...)");
        return (Button) value;
    }

    private final Button getBtnEditPic() {
        Object value = this.btnEditPic$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-btnEditPic>(...)");
        return (Button) value;
    }

    private final Button getBtnDeletePic() {
        Object value = this.btnDeletePic$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-btnDeletePic>(...)");
        return (Button) value;
    }

    public final Function0<Unit> getOnChangePicClickListener() {
        return this.onChangePicClickListener;
    }

    public final void setOnChangePicClickListener(Function0<Unit> function0) {
        this.onChangePicClickListener = function0;
    }

    public final Function0<Unit> getOnEditPicClickListener() {
        return this.onEditPicClickListener;
    }

    public final void setOnEditPicClickListener(Function0<Unit> function0) {
        this.onEditPicClickListener = function0;
    }

    public final Function0<Unit> getOnDeletePicClickListener() {
        return this.onDeletePicClickListener;
    }

    public final void setOnDeletePicClickListener(Function0<Unit> function0) {
        this.onDeletePicClickListener = function0;
    }

    public final Function1<MvpUbcModel, Unit> getOnUbcActionListener() {
        return this.onUbcActionListener;
    }

    public final void setOnUbcActionListener(Function1<? super MvpUbcModel, Unit> function1) {
        this.onUbcActionListener = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m18092_init_$lambda0(ImagePreviewBottomFuncView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onChangePicClickListener;
        if (function0 != null) {
            function0.invoke();
        }
        Function1<? super MvpUbcModel, Unit> function1 = this$0.onUbcActionListener;
        if (function1 != null) {
            function1.invoke(new MvpUbcModel((String) null, (String) null, "picture_change_clk", (String) null, (String) null, (JSONObject) null, 59, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m18093_init_$lambda1(ImagePreviewBottomFuncView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onEditPicClickListener;
        if (function0 != null) {
            function0.invoke();
        }
        Function1<? super MvpUbcModel, Unit> function1 = this$0.onUbcActionListener;
        if (function1 != null) {
            function1.invoke(new MvpUbcModel((String) null, (String) null, "picture_edit_clk", (String) null, (String) null, (JSONObject) null, 59, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m18094_init_$lambda2(ImagePreviewBottomFuncView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onDeletePicClickListener;
        if (function0 != null) {
            function0.invoke();
        }
        Function1<? super MvpUbcModel, Unit> function1 = this$0.onUbcActionListener;
        if (function1 != null) {
            function1.invoke(new MvpUbcModel((String) null, (String) null, "picture_delete_clk", (String) null, (String) null, (JSONObject) null, 59, (DefaultConstructorMarker) null));
        }
    }

    public final void setChangePicButtonVisible(boolean visible) {
        getBtnChangePic().setVisibility(visible ? 0 : 8);
    }
}
