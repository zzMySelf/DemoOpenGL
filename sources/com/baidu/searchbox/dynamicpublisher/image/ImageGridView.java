package com.baidu.searchbox.dynamicpublisher.image;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.publishercomponent.R;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.utils.LocalPreviewUtils;
import com.baidu.searchbox.ugc.utils.LogUtil;
import com.baidu.searchbox.ugc.view.DragGridView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0014J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010-\u001a\u00020\u00152\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010/\u001a\u00020\bJ\u0010\u00100\u001a\u0002012\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\bH\u0014J\b\u00105\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\bH\u0016J\u001a\u00108\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010\u000e2\u0006\u00109\u001a\u00020\bH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u000e¢\u0006\u0002\n\u0000R7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R7\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R7\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageGridView;", "Lcom/baidu/searchbox/ugc/view/DragGridView;", "Lcom/baidu/searchbox/dynamicpublisher/image/IBaseDragGridView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gridAdapter", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageGridAdapter;", "imageList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "Lkotlin/collections/ArrayList;", "onClickDeleteListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pos", "", "getOnClickDeleteListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickDeleteListener", "(Lkotlin/jvm/functions/Function1;)V", "onClickImageListener", "getOnClickImageListener", "setOnClickImageListener", "onClickMoreListener", "Lkotlin/Function0;", "getOnClickMoreListener", "()Lkotlin/jvm/functions/Function0;", "setOnClickMoreListener", "(Lkotlin/jvm/functions/Function0;)V", "onClickQualityListener", "getOnClickQualityListener", "setOnClickQualityListener", "exchangePosition", "draggedPos", "targetPos", "getGridView", "Landroid/view/View;", "hideDownloading", "newImage", "initAdapter", "images", "maxImageNum", "isMorePosition", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refresh", "refreshByPosition", "position", "showDownloading", "clickPosition", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageGridView.kt */
public final class ImageGridView extends DragGridView implements IBaseDragGridView {
    public Map<Integer, View> _$_findViewCache;
    private ImageGridAdapter gridAdapter;
    private ArrayList<ImageStruct> imageList;
    private Function1<? super Integer, Unit> onClickDeleteListener;
    private Function1<? super Integer, Unit> onClickImageListener;
    private Function0<Unit> onClickMoreListener;
    private Function1<? super Integer, Unit> onClickQualityListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageGridView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageGridView(Context context, AttributeSet attributeSet) {
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
    public ImageGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.imageList = new ArrayList<>();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams $this$_init__u24lambda_u2d0 = layoutParams;
        $this$_init__u24lambda_u2d0.topMargin = DeviceUtils.ScreenInfo.dp2px(context, 19.0f);
        $this$_init__u24lambda_u2d0.bottomMargin = DeviceUtils.ScreenInfo.dp2px(context, 3.0f);
        setLayoutTransition(new LayoutTransition());
        setLayoutParams(layoutParams);
        setCacheColorHint(ContextCompat.getColor(context, R.color.dynamic_publisher_transparent));
        setSelector(ContextCompat.getDrawable(context, R.color.dynamic_publisher_transparent));
        setVerticalSpacing(DeviceUtils.ScreenInfo.dp2px(context, 3.0f));
        setHorizontalSpacing(DeviceUtils.ScreenInfo.dp2px(context, 3.0f));
        setStretchMode(2);
        setNumColumns(3);
        setOnItemClickListener(new ImageGridView$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageGridView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final Function0<Unit> getOnClickMoreListener() {
        return this.onClickMoreListener;
    }

    public final void setOnClickMoreListener(Function0<Unit> function0) {
        this.onClickMoreListener = function0;
    }

    public final Function1<Integer, Unit> getOnClickImageListener() {
        return this.onClickImageListener;
    }

    public final void setOnClickImageListener(Function1<? super Integer, Unit> function1) {
        this.onClickImageListener = function1;
    }

    public final Function1<Integer, Unit> getOnClickDeleteListener() {
        return this.onClickDeleteListener;
    }

    public final void setOnClickDeleteListener(Function1<? super Integer, Unit> function1) {
        this.onClickDeleteListener = function1;
    }

    public final Function1<Integer, Unit> getOnClickQualityListener() {
        return this.onClickQualityListener;
    }

    public final void setOnClickQualityListener(Function1<? super Integer, Unit> function1) {
        this.onClickQualityListener = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m18075_init_$lambda1(ImageGridView this$0, AdapterView adapterView, View view2, int position, long j2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isDragMode() && this$0.gridAdapter != null && LocalPreviewUtils.unFastClick()) {
            ImageGridAdapter imageGridAdapter = this$0.gridAdapter;
            boolean z = true;
            if (imageGridAdapter == null || !imageGridAdapter.isMorePosition(position)) {
                z = false;
            }
            if (z) {
                Function0<Unit> function0 = this$0.onClickMoreListener;
                if (function0 != null) {
                    function0.invoke();
                }
            } else if (this$0.imageList.get(position).status != 0) {
                Function1<? super Integer, Unit> function1 = this$0.onClickQualityListener;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(position));
                }
            } else {
                Function1<? super Integer, Unit> function12 = this$0.onClickImageListener;
                if (function12 != null) {
                    function12.invoke(Integer.valueOf(position));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int itemHeight;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getCount() > 0 && getChildAt(0) != null && (itemHeight = getChildAt(0).getMeasuredHeight()) > 0) {
            setMeasuredDimension(widthMeasureSpec, ((((getCount() - 1) / getNumColumns()) + 1) * itemHeight) + (getVerticalSpacing() * ((getCount() - 1) / getNumColumns())));
        }
    }

    public final void initAdapter(ArrayList<ImageStruct> images, int maxImageNum) {
        Intrinsics.checkNotNullParameter(images, "images");
        this.imageList = images;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(context, images, maxImageNum, getNumColumns(), getHorizontalSpacing());
        this.gridAdapter = imageGridAdapter;
        setAdapter(imageGridAdapter);
        ImageGridAdapter imageGridAdapter2 = this.gridAdapter;
        Intrinsics.checkNotNull(imageGridAdapter2);
        imageGridAdapter2.setOnClickDeleteListener(this.onClickDeleteListener);
    }

    public void refresh() {
        ImageGridAdapter imageGridAdapter = this.gridAdapter;
        if (imageGridAdapter != null) {
            imageGridAdapter.notifyDataSetChanged();
        }
    }

    public void refreshByPosition(int position) {
        ImageGridAdapter imageGridAdapter = this.gridAdapter;
        if (imageGridAdapter != null) {
            imageGridAdapter.notifyDataSetChanged();
        }
    }

    public View getGridView() {
        return this;
    }

    public boolean isMorePosition(int pos) {
        ImageGridAdapter imageGridAdapter = this.gridAdapter;
        return imageGridAdapter != null && imageGridAdapter.isMorePosition(pos);
    }

    /* access modifiers changed from: protected */
    public void exchangePosition(int draggedPos, int targetPos) {
        try {
            ImageStruct item = this.imageList.get(draggedPos);
            Intrinsics.checkNotNullExpressionValue(item, "imageList[draggedPos]");
            this.imageList.remove(draggedPos);
            this.imageList.add(targetPos, item);
            refresh();
        } catch (Exception e2) {
            LogUtil.d(Log.getStackTraceString(e2));
        }
    }

    public void showDownloading(ImageStruct newImage, int clickPosition) {
    }

    public void hideDownloading(ImageStruct newImage) {
    }
}
