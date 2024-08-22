package com.baidu.searchbox.player.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.player.control.model.VulcanClarityItem;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.player.utils.LayerUtil;
import com.baidu.searchbox.videoplayer.vulcan.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001OB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ.\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00130,2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000206\u0018\u000109H\u0003J\b\u0010:\u001a\u000206H\u0002J\b\u0010;\u001a\u00020'H\u0002J\u0006\u0010<\u001a\u000206J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J,\u0010A\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00130,2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000206\u0018\u000109J\u0012\u0010B\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0006\u0010E\u001a\u000206J\u001a\u0010F\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020\u0013H\u0002J\u001a\u0010J\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u00010D2\u0006\u0010I\u001a\u00020\u0013H\u0002J\b\u0010L\u001a\u000206H\u0002J\u001a\u0010M\u001a\u0002062\b\u0010N\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020\u0013H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b$\u0010!R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0019\u001a\u0004\b(\u0010)R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006P"}, d2 = {"Lcom/baidu/searchbox/player/widget/VideoVulcanClarityMenuView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clarityChangedListener", "Lcom/baidu/searchbox/player/widget/VideoVulcanClarityMenuView$VideoClarityChangedListener;", "getClarityChangedListener", "()Lcom/baidu/searchbox/player/widget/VideoVulcanClarityMenuView$VideoClarityChangedListener;", "setClarityChangedListener", "(Lcom/baidu/searchbox/player/widget/VideoVulcanClarityMenuView$VideoClarityChangedListener;)V", "clarityViewGroup", "Landroid/widget/LinearLayout;", "currentClarity", "Lcom/baidu/searchbox/player/control/model/VulcanClarityItem;", "itemSelectedBg", "Landroid/graphics/drawable/Drawable;", "getItemSelectedBg", "()Landroid/graphics/drawable/Drawable;", "itemSelectedBg$delegate", "Lkotlin/Lazy;", "itemTextColorSelector", "Landroid/content/res/ColorStateList;", "getItemTextColorSelector", "()Landroid/content/res/ColorStateList;", "itemTextColorSelector$delegate", "itemTextDescColor", "getItemTextDescColor", "()I", "itemTextDescColor$delegate", "itemTextSelectedColor", "getItemTextSelectedColor", "itemTextSelectedColor$delegate", "labelImageView", "Landroid/widget/ImageView;", "getLabelImageView", "()Landroid/widget/ImageView;", "labelImageView$delegate", "oldClarityItemList", "", "unityLayerMenuGradientView", "Lcom/baidu/searchbox/player/widget/VideoVulcanLayerMenuGradientView;", "visibleListener", "Lcom/baidu/searchbox/player/widget/OnPanelVisibleListener;", "getVisibleListener", "()Lcom/baidu/searchbox/player/widget/OnPanelVisibleListener;", "setVisibleListener", "(Lcom/baidu/searchbox/player/widget/OnPanelVisibleListener;)V", "addItemViewByOpt", "", "clarityItemList", "callback", "Lkotlin/Function1;", "clearItemView", "createLabelImageView", "dismiss", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "initClarityList", "onClick", "v", "Landroid/view/View;", "show", "updateClarityNumResource", "clarityNumTextView", "Landroid/widget/TextView;", "clarityItem", "updateLoginMarkerResource", "itemView", "updateResource", "updateTitleResource", "titleTextView", "VideoClarityChangedListener", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoVulcanClarityMenuView.kt */
public final class VideoVulcanClarityMenuView extends ConstraintLayout implements View.OnClickListener {
    public Map<Integer, View> _$_findViewCache;
    private VideoClarityChangedListener clarityChangedListener;
    private LinearLayout clarityViewGroup;
    private VulcanClarityItem currentClarity;
    private final Lazy itemSelectedBg$delegate;
    private final Lazy itemTextColorSelector$delegate;
    private final Lazy itemTextDescColor$delegate;
    private final Lazy itemTextSelectedColor$delegate;
    private final Lazy labelImageView$delegate;
    private List<VulcanClarityItem> oldClarityItemList;
    private VideoVulcanLayerMenuGradientView unityLayerMenuGradientView;
    private OnPanelVisibleListener visibleListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/widget/VideoVulcanClarityMenuView$VideoClarityChangedListener;", "", "onClarityChanged", "", "clarityItem", "Lcom/baidu/searchbox/player/control/model/VulcanClarityItem;", "oldClarityItem", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoVulcanClarityMenuView.kt */
    public interface VideoClarityChangedListener {
        void onClarityChanged(VulcanClarityItem vulcanClarityItem, VulcanClarityItem vulcanClarityItem2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoVulcanClarityMenuView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoVulcanClarityMenuView(Context context, AttributeSet attributeSet) {
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
    public VideoVulcanClarityMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.labelImageView$delegate = BdPlayerUtils.lazyNone(new VideoVulcanClarityMenuView$labelImageView$2(this));
        this.itemTextColorSelector$delegate = BdPlayerUtils.lazyNone(new VideoVulcanClarityMenuView$itemTextColorSelector$2(context));
        this.itemTextSelectedColor$delegate = BdPlayerUtils.lazyNone(new VideoVulcanClarityMenuView$itemTextSelectedColor$2(context));
        this.itemTextDescColor$delegate = BdPlayerUtils.lazyNone(new VideoVulcanClarityMenuView$itemTextDescColor$2(context));
        this.itemSelectedBg$delegate = BdPlayerUtils.lazyNone(new VideoVulcanClarityMenuView$itemSelectedBg$2(context));
        View.inflate(context, R.layout.videoplayer_vulcan_clarity_menu_layout, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View findViewById = findViewById(R.id.view_clarity_full_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.view_clarity_full_mask)");
        this.unityLayerMenuGradientView = (VideoVulcanLayerMenuGradientView) findViewById;
        View findViewById2 = findViewById(R.id.view_clarity_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.view_clarity_container)");
        this.clarityViewGroup = (LinearLayout) findViewById2;
        setOnClickListener(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoVulcanClarityMenuView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final VideoClarityChangedListener getClarityChangedListener() {
        return this.clarityChangedListener;
    }

    public final void setClarityChangedListener(VideoClarityChangedListener videoClarityChangedListener) {
        this.clarityChangedListener = videoClarityChangedListener;
    }

    public final OnPanelVisibleListener getVisibleListener() {
        return this.visibleListener;
    }

    public final void setVisibleListener(OnPanelVisibleListener onPanelVisibleListener) {
        this.visibleListener = onPanelVisibleListener;
    }

    private final ImageView getLabelImageView() {
        return (ImageView) this.labelImageView$delegate.getValue();
    }

    private final ColorStateList getItemTextColorSelector() {
        return (ColorStateList) this.itemTextColorSelector$delegate.getValue();
    }

    private final int getItemTextSelectedColor() {
        return ((Number) this.itemTextSelectedColor$delegate.getValue()).intValue();
    }

    private final int getItemTextDescColor() {
        return ((Number) this.itemTextDescColor$delegate.getValue()).intValue();
    }

    private final Drawable getItemSelectedBg() {
        return (Drawable) this.itemSelectedBg$delegate.getValue();
    }

    public static /* synthetic */ void initClarityList$default(VideoVulcanClarityMenuView videoVulcanClarityMenuView, List list, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        videoVulcanClarityMenuView.initClarityList(list, function1);
    }

    public final void initClarityList(List<VulcanClarityItem> clarityItemList, Function1<? super VulcanClarityItem, Unit> callback) {
        Intrinsics.checkNotNullParameter(clarityItemList, "clarityItemList");
        if (!Intrinsics.areEqual((Object) this.oldClarityItemList, (Object) clarityItemList)) {
            clearItemView();
            addItemViewByOpt(clarityItemList, callback);
            this.oldClarityItemList = new ArrayList(clarityItemList);
            return;
        }
        updateResource();
    }

    static /* synthetic */ void addItemViewByOpt$default(VideoVulcanClarityMenuView videoVulcanClarityMenuView, List list, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        videoVulcanClarityMenuView.addItemViewByOpt(list, function1);
    }

    private final void addItemViewByOpt(List<VulcanClarityItem> clarityItemList, Function1<? super VulcanClarityItem, Unit> callback) {
        View itemView;
        Function1<? super VulcanClarityItem, Unit> function1 = callback;
        for (VulcanClarityItem clarityItem : clarityItemList) {
            if (clarityItem.isHorizontalStyle()) {
                itemView = LayoutInflater.from(getContext()).inflate(R.layout.videoplayer_vulcan_clarity_menu_item_horizontal_layout, (ViewGroup) null);
            } else {
                itemView = LayoutInflater.from(getContext()).inflate(R.layout.videoplayer_vulcan_clarity_menu_item_vertical_layout, (ViewGroup) null);
            }
            View findViewById = itemView.findViewById(R.id.clarity_container);
            LinearLayout container = findViewById instanceof LinearLayout ? (LinearLayout) findViewById : null;
            View findViewById2 = itemView.findViewById(R.id.clarity_num_text_view);
            TextView clarityNumTextView = findViewById2 instanceof TextView ? (TextView) findViewById2 : null;
            View findViewById3 = itemView.findViewById(R.id.title_text_view);
            TextView titleTextView = findViewById3 instanceof TextView ? (TextView) findViewById3 : null;
            itemView.setTag(R.id.clarity_num_text_view, clarityNumTextView);
            itemView.setTag(R.id.title_text_view, titleTextView);
            itemView.setTag(clarityItem);
            updateClarityNumResource(clarityNumTextView, clarityItem);
            updateTitleResource(titleTextView, clarityItem);
            updateLoginMarkerResource(itemView, clarityItem);
            if (container != null) {
                LinearLayout $this$addItemViewByOpt_u24lambda_u2d2_u24lambda_u2d1 = container;
                $this$addItemViewByOpt_u24lambda_u2d2_u24lambda_u2d1.setTag(clarityItem);
                if (clarityItem.getSelected()) {
                    $this$addItemViewByOpt_u24lambda_u2d2_u24lambda_u2d1.setSelected(true);
                    this.currentClarity = clarityItem;
                    if (function1 != null) {
                        function1.invoke(clarityItem);
                    }
                    $this$addItemViewByOpt_u24lambda_u2d2_u24lambda_u2d1.setBackground(getItemSelectedBg());
                } else {
                    $this$addItemViewByOpt_u24lambda_u2d2_u24lambda_u2d1.setSelected(false);
                    $this$addItemViewByOpt_u24lambda_u2d2_u24lambda_u2d1.setBackground((Drawable) null);
                }
                $this$addItemViewByOpt_u24lambda_u2d2_u24lambda_u2d1.setOnClickListener(new VideoVulcanClarityMenuView$$ExternalSyntheticLambda0(this));
            }
            this.clarityViewGroup.addView(itemView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addItemViewByOpt$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2443addItemViewByOpt$lambda2$lambda1$lambda0(VideoVulcanClarityMenuView this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = view2.getTag();
        VulcanClarityItem selectedClarity = tag instanceof VulcanClarityItem ? (VulcanClarityItem) tag : null;
        if (selectedClarity != null) {
            if (!Intrinsics.areEqual((Object) selectedClarity, (Object) this$0.currentClarity)) {
                VideoClarityChangedListener videoClarityChangedListener = this$0.clarityChangedListener;
                if (videoClarityChangedListener != null) {
                    videoClarityChangedListener.onClarityChanged(selectedClarity, this$0.currentClarity);
                }
                if (!selectedClarity.getDisallowIntercept()) {
                    this$0.currentClarity = selectedClarity;
                }
            }
            this$0.dismiss();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.baidu.searchbox.player.control.model.VulcanClarityItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateResource() {
        /*
            r8 = this;
            android.widget.LinearLayout r0 = r8.clarityViewGroup
            int r0 = r0.getChildCount()
            r1 = 0
        L_0x0007:
            if (r1 >= r0) goto L_0x0045
            android.widget.LinearLayout r2 = r8.clarityViewGroup
            android.view.View r2 = r2.getChildAt(r1)
            int r3 = com.baidu.searchbox.videoplayer.vulcan.R.id.clarity_num_text_view
            java.lang.Object r3 = r2.getTag(r3)
            boolean r4 = r3 instanceof android.widget.TextView
            r5 = 0
            if (r4 == 0) goto L_0x001d
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x001e
        L_0x001d:
            r3 = r5
        L_0x001e:
            int r4 = com.baidu.searchbox.videoplayer.vulcan.R.id.title_text_view
            java.lang.Object r4 = r2.getTag(r4)
            boolean r6 = r4 instanceof android.widget.TextView
            if (r6 == 0) goto L_0x002b
            android.widget.TextView r4 = (android.widget.TextView) r4
            goto L_0x002c
        L_0x002b:
            r4 = r5
        L_0x002c:
            java.lang.Object r6 = r2.getTag()
            boolean r7 = r6 instanceof com.baidu.searchbox.player.control.model.VulcanClarityItem
            if (r7 == 0) goto L_0x0037
            r5 = r6
            com.baidu.searchbox.player.control.model.VulcanClarityItem r5 = (com.baidu.searchbox.player.control.model.VulcanClarityItem) r5
        L_0x0037:
            if (r5 == 0) goto L_0x0042
            r8.updateClarityNumResource(r3, r5)
            r8.updateTitleResource(r4, r5)
            r8.updateLoginMarkerResource(r2, r5)
        L_0x0042:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.widget.VideoVulcanClarityMenuView.updateResource():void");
    }

    private final void clearItemView() {
        this.clarityViewGroup.removeAllViews();
    }

    /* access modifiers changed from: private */
    public final ImageView createLabelImageView() {
        ImageView imageView = new ImageView(getContext());
        ImageView $this$createLabelImageView_u24lambda_u2d4 = imageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams $this$createLabelImageView_u24lambda_u2d4_u24lambda_u2d3 = layoutParams;
        $this$createLabelImageView_u24lambda_u2d4_u24lambda_u2d3.gravity = 16;
        $this$createLabelImageView_u24lambda_u2d4_u24lambda_u2d3.setMargins(BdPlayerUtils.dp2px($this$createLabelImageView_u24lambda_u2d4, -20.0f), BdPlayerUtils.dp2px($this$createLabelImageView_u24lambda_u2d4, 1.0f), 0, 0);
        $this$createLabelImageView_u24lambda_u2d4.setLayoutParams(layoutParams);
        return imageView;
    }

    public void onClick(View v) {
        if (Intrinsics.areEqual((Object) v, (Object) this)) {
            dismiss();
        }
    }

    public final void show() {
        LayerUtil.enterAnim$default(this, (String) null, 0.0f, 3, (Object) null);
        OnPanelVisibleListener onPanelVisibleListener = this.visibleListener;
        if (onPanelVisibleListener != null) {
            onPanelVisibleListener.onShow();
        }
    }

    public final void dismiss() {
        LayerUtil.exitAnim$default(this, (String) null, 0.0f, 3, (Object) null);
        OnPanelVisibleListener onPanelVisibleListener = this.visibleListener;
        if (onPanelVisibleListener != null) {
            onPanelVisibleListener.onDismiss();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

    private final void updateLoginMarkerResource(View itemView, VulcanClarityItem clarityItem) {
        if (!StringsKt.isBlank(clarityItem.getExt())) {
            BdPlayerUtils.removeViewFromParent(getLabelImageView());
            ViewGroup viewGroup = itemView instanceof ViewGroup ? (ViewGroup) itemView : null;
            if (viewGroup != null) {
                viewGroup.addView(getLabelImageView());
            }
            getLabelImageView().setVisibility(0);
            FontSizeImageViewExtKt.setScaledImageDrawableRes$default(getLabelImageView(), 0, R.drawable.videoplayer_vulcan_menu_clarity, 0, 4, (Object) null);
        }
    }

    private final void updateTitleResource(TextView titleTextView, VulcanClarityItem clarityItem) {
        if (titleTextView != null) {
            TextView $this$updateTitleResource_u24lambda_u2d5 = titleTextView;
            $this$updateTitleResource_u24lambda_u2d5.setText(clarityItem.getTitleText());
            if (clarityItem.isHorizontalStyle()) {
                $this$updateTitleResource_u24lambda_u2d5.setTextColor(getItemTextColorSelector());
                LayerUtil.setFontTypeface($this$updateTitleResource_u24lambda_u2d5, true);
            } else {
                $this$updateTitleResource_u24lambda_u2d5.setTextColor(getItemTextDescColor());
            }
            if (clarityItem.getSelected()) {
                $this$updateTitleResource_u24lambda_u2d5.setTextColor(getItemTextSelectedColor());
            }
            FontSizeHelperKt.setVideoScaledSizeRes$default($this$updateTitleResource_u24lambda_u2d5, R.dimen.videoplayer_vulcan_dp_15, 0, 0, 6, (Object) null);
        }
    }

    private final void updateClarityNumResource(TextView clarityNumTextView, VulcanClarityItem clarityItem) {
        int i2;
        if (clarityNumTextView != null) {
            TextView $this$updateClarityNumResource_u24lambda_u2d6 = clarityNumTextView;
            $this$updateClarityNumResource_u24lambda_u2d6.setText(clarityItem.getNumText());
            LayerUtil.setFontTypeface($this$updateClarityNumResource_u24lambda_u2d6, true);
            if (clarityItem.getSelected()) {
                $this$updateClarityNumResource_u24lambda_u2d6.setTextColor(getItemTextSelectedColor());
            } else {
                $this$updateClarityNumResource_u24lambda_u2d6.setTextColor(getItemTextColorSelector());
            }
            if (clarityItem.isHorizontalStyle()) {
                FontSizeHelperKt.setVideoScaledSizeRes$default($this$updateClarityNumResource_u24lambda_u2d6, R.dimen.videoplayer_vulcan_dp_18, 0, 0, 6, (Object) null);
                return;
            }
            if (clarityItem.getSelected()) {
                i2 = R.dimen.videoplayer_vulcan_dp_18;
            } else {
                i2 = R.dimen.videoplayer_vulcan_dp_15;
            }
            FontSizeHelperKt.setVideoScaledSizeRes$default($this$updateClarityNumResource_u24lambda_u2d6, i2, 0, 0, 6, (Object) null);
        }
    }
}
