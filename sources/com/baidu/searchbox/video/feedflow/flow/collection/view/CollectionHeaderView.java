package com.baidu.searchbox.video.feedflow.flow.collection.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.player.utils.ViewUtil;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.LimbicView;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0007H\u0002J\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\nJ\u000e\u00101\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/view/CollectionHeaderView;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/LimbicView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeClickListener", "Landroid/view/View$OnClickListener;", "flClose", "Landroid/widget/FrameLayout;", "flTitle", "Landroid/widget/LinearLayout;", "flTitleContainer", "headerData", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelHeaderModel;", "ivClose", "Landroid/widget/ImageView;", "ivIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "ivRightArrow", "llSubTitle", "llSubtitleClickListener", "tvSubtitle", "Landroid/widget/TextView;", "tvTitle", "bindData", "", "data", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionCommonModel;", "changeStyle", "style", "clearIconBg", "isLandscape", "", "isLongVideoType", "isPaymentType", "isSubscribeType", "layoutTitle", "gravityStart", "setFontAndPictureSize", "setHeaderView4LandscapeBlackStyle", "setHeaderView4PortraitBlackStyle", "setHeaderView4PortraitWhiteStyle", "setIcon", "setOnCloseClickListener", "listener", "setOnLLSubtitleClickListener", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionHeaderView.kt */
public final class CollectionHeaderView extends LimbicView {
    private View.OnClickListener closeClickListener;
    private final FrameLayout flClose;
    private final LinearLayout flTitle;
    private final FrameLayout flTitleContainer;
    private CollectionPanelHeaderModel headerData;
    private final ImageView ivClose;
    private final SimpleDraweeView ivIcon;
    private final ImageView ivRightArrow;
    private final LinearLayout llSubTitle;
    private View.OnClickListener llSubtitleClickListener;
    private final TextView tvSubtitle;
    private final TextView tvTitle;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CollectionHeaderView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CollectionHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CollectionHeaderView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.video_flow_collection_panel_header, this);
        View findViewById = findViewById(R.id.fl_title_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fl_title_container)");
        this.flTitleContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.fl_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fl_title)");
        this.flTitle = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_title)");
        TextView textView = (TextView) findViewById3;
        this.tvTitle = textView;
        View findViewById4 = findViewById(R.id.tv_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_subtitle)");
        this.tvSubtitle = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.iv_right_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_right_arrow)");
        this.ivRightArrow = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.ll_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ll_subtitle)");
        LinearLayout linearLayout = (LinearLayout) findViewById6;
        this.llSubTitle = linearLayout;
        View findViewById7 = findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.iv_close)");
        this.ivClose = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.fl_close);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.fl_close)");
        FrameLayout frameLayout = (FrameLayout) findViewById8;
        this.flClose = frameLayout;
        textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        textView.getPaint().setStrokeWidth(0.5f);
        frameLayout.setOnClickListener(new CollectionHeaderView$$ExternalSyntheticLambda0(this));
        View findViewById9 = findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.iv_icon)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById9;
        this.ivIcon = simpleDraweeView;
        GenericDraweeHierarchy $this$_init__u24lambda_u2d1 = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy();
        if ($this$_init__u24lambda_u2d1 != null) {
            $this$_init__u24lambda_u2d1.setUseGlobalColorFilter(false);
        }
        linearLayout.setOnClickListener(new CollectionHeaderView$$ExternalSyntheticLambda1(this));
        ExpandTouchAreaHelper.expandTouchArea(this, linearLayout, ViewUtil.dp2px(7.0f), BdPlayerUtils.dp2px(this, 7.0f), BdPlayerUtils.dp2px(this, 7.0f), BdPlayerUtils.dp2px(this, 8.0f));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m6227_init_$lambda0(CollectionHeaderView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.closeClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this$0.flClose);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m6228_init_$lambda2(CollectionHeaderView this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.llSubtitleClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
        if ((r2.length() > 0) == true) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        r5 = r0.getTitle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindData(com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = com.baidu.searchbox.video.feedflow.flow.collection.view.CollectionHeaderViewKt.isCollectionHeader(r8)
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r0 = com.baidu.searchbox.video.feedflow.flow.collection.view.CollectionHeaderViewKt.getCollectionPanelHeaderModel(r8)
            if (r0 == 0) goto L_0x00a1
            r1 = 0
            r7.headerData = r0
            android.widget.LinearLayout r2 = r7.flTitle
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x002c
            java.lang.String r5 = r0.getTitle()
            if (r5 == 0) goto L_0x002c
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            r5 = r5 ^ r3
            if (r5 != r3) goto L_0x002c
            r5 = r3
            goto L_0x002d
        L_0x002c:
            r5 = r4
        L_0x002d:
            if (r5 == 0) goto L_0x0031
            r5 = r4
            goto L_0x0032
        L_0x0031:
            r5 = 4
        L_0x0032:
            r2.setVisibility(r5)
            android.widget.TextView r2 = r7.tvTitle
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r5 = r7.headerData
            r6 = 0
            if (r5 == 0) goto L_0x0041
            java.lang.String r5 = r5.getTitle()
            goto L_0x0042
        L_0x0041:
            r5 = r6
        L_0x0042:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r2 = r7.headerData
            if (r2 == 0) goto L_0x005b
            java.lang.String r2 = r2.getSubtitle()
            if (r2 == 0) goto L_0x005b
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 != r3) goto L_0x005b
            r2 = r3
            goto L_0x005c
        L_0x005b:
            r2 = r4
        L_0x005c:
            if (r2 == 0) goto L_0x0066
            android.widget.LinearLayout r2 = r7.llSubTitle
            r3 = 8
            r2.setVisibility(r3)
            goto L_0x009f
        L_0x0066:
            android.widget.TextView r2 = r7.tvSubtitle
            r2.setVisibility(r4)
            android.widget.TextView r2 = r7.tvSubtitle
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r5 = r7.headerData
            if (r5 == 0) goto L_0x0075
            java.lang.String r6 = r5.getSubtitle()
        L_0x0075:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
            android.widget.LinearLayout r2 = r7.llSubTitle
            r2.setVisibility(r4)
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r2 = r7.headerData
            if (r2 == 0) goto L_0x0097
            java.lang.String r2 = r2.getDetailCmd()
            if (r2 == 0) goto L_0x0097
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0093
            r2 = r3
            goto L_0x0094
        L_0x0093:
            r2 = r4
        L_0x0094:
            if (r2 != r3) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r3 = r4
        L_0x0098:
            if (r3 == 0) goto L_0x009f
            android.widget.ImageView r2 = r7.ivRightArrow
            r2.setVisibility(r4)
        L_0x009f:
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.collection.view.CollectionHeaderView.bindData(com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r4v8, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setIcon(int r7) {
        /*
            r6 = this;
            r6.clearIconBg()
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            r1 = 1065353216(0x3f800000, float:1.0)
            r0.setAlpha(r1)
            boolean r0 = r6.isLandscape(r7)
            r2 = 8
            r3 = 1
            r4 = 0
            r5 = 0
            if (r0 == 0) goto L_0x0068
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r0 = r6.headerData
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = r0.getLandscapeIcon()
            if (r0 == 0) goto L_0x002a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            r0 = r0 ^ r3
            if (r0 != r3) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r3 = r5
        L_0x002b:
            if (r3 == 0) goto L_0x0041
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            r0.setVisibility(r5)
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r1 = r6.headerData
            if (r1 == 0) goto L_0x003c
            java.lang.String r4 = r1.getLandscapeIcon()
        L_0x003c:
            r0.setImageURI((java.lang.String) r4)
            goto L_0x00f1
        L_0x0041:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r0 = r6.headerData
            if (r0 == 0) goto L_0x004a
            android.graphics.drawable.Drawable r0 = r0.getLandscapeDraw()
            goto L_0x004b
        L_0x004a:
            r0 = r4
        L_0x004b:
            if (r0 == 0) goto L_0x0061
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            r0.setVisibility(r5)
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r1 = r6.headerData
            if (r1 == 0) goto L_0x005c
            android.graphics.drawable.Drawable r4 = r1.getLandscapeDraw()
        L_0x005c:
            r0.setBackground(r4)
            goto L_0x00f1
        L_0x0061:
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            r0.setVisibility(r2)
            goto L_0x00f1
        L_0x0068:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r0 = r6.headerData
            if (r0 == 0) goto L_0x007d
            java.lang.String r0 = r0.getPortraitIcon()
            if (r0 == 0) goto L_0x007d
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            r0 = r0 ^ r3
            if (r0 != r3) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r3 = r5
        L_0x007e:
            if (r3 == 0) goto L_0x00cd
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            r0.setVisibility(r5)
            switch(r7) {
                case 2: goto L_0x00b6;
                case 3: goto L_0x0089;
                default: goto L_0x0088;
            }
        L_0x0088:
            goto L_0x00cc
        L_0x0089:
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            boolean r2 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()
            if (r2 == 0) goto L_0x009a
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r2 = r6.headerData
            if (r2 == 0) goto L_0x00a2
            java.lang.String r4 = r2.getPortraitDartIcon()
            goto L_0x00a2
        L_0x009a:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r2 = r6.headerData
            if (r2 == 0) goto L_0x00a2
            java.lang.String r4 = r2.getPortraitIcon()
        L_0x00a2:
            r0.setImageURI((java.lang.String) r4)
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            boolean r2 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()
            if (r2 == 0) goto L_0x00b1
            r1 = 1051595899(0x3eae147b, float:0.34)
            goto L_0x00b2
        L_0x00b1:
        L_0x00b2:
            r0.setAlpha(r1)
            goto L_0x00cc
        L_0x00b6:
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r1 = r6.headerData
            if (r1 == 0) goto L_0x00c0
            java.lang.String r4 = r1.getPortraitDartIcon()
        L_0x00c0:
            r0.setImageURI((java.lang.String) r4)
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            r1 = 1061997773(0x3f4ccccd, float:0.8)
            r0.setAlpha(r1)
            goto L_0x00f1
        L_0x00cc:
            goto L_0x00f1
        L_0x00cd:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r0 = r6.headerData
            if (r0 == 0) goto L_0x00d6
            android.graphics.drawable.Drawable r0 = r0.getPortraitDraw()
            goto L_0x00d7
        L_0x00d6:
            r0 = r4
        L_0x00d7:
            if (r0 == 0) goto L_0x00ec
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            r0.setVisibility(r5)
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel r1 = r6.headerData
            if (r1 == 0) goto L_0x00e8
            android.graphics.drawable.Drawable r4 = r1.getPortraitDraw()
        L_0x00e8:
            r0.setBackground(r4)
            goto L_0x00f1
        L_0x00ec:
            com.facebook.drawee.view.SimpleDraweeView r0 = r6.ivIcon
            r0.setVisibility(r2)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.collection.view.CollectionHeaderView.setIcon(int):void");
    }

    private final boolean isLandscape(int style) {
        switch (style) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    private final void clearIconBg() {
        this.ivIcon.setBackground((Drawable) null);
        this.ivIcon.setImageURI((Uri) null, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setHeaderView4PortraitWhiteStyle() {
        /*
            r13 = this;
            r0 = 3
            r13.setIcon(r0)
            android.widget.TextView r0 = r13.tvTitle
            android.content.Context r1 = r13.getContext()
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC14
            int r1 = com.baidu.searchbox.video.detail.utils.ResourceUtils.getColor(r1, r2)
            r0.setTextColor(r1)
            android.widget.TextView r2 = r13.tvSubtitle
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_H_X03
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.baidu.searchbox.player.utils.FontSizeHelperKt.setVideoScaledSizeRes$default(r2, r3, r4, r5, r6, r7)
            android.widget.ImageView r0 = r13.ivClose
            r1 = 0
            r0.setBackgroundResource(r1)
            android.widget.ImageView r0 = r13.ivClose
            int r2 = com.baidu.searchbox.video.feedflow.component.R.drawable.video_flow_collection_panel_close_portrait
            r0.setBackgroundResource(r2)
            boolean r0 = r13.isPaymentType()
            r2 = 1
            if (r0 != 0) goto L_0x003b
            boolean r0 = r13.isSubscribeType()
            if (r0 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r0 = r1
            goto L_0x003c
        L_0x003b:
            r0 = r2
        L_0x003c:
            r13.layoutTitle(r0)
            android.widget.TextView r0 = r13.tvSubtitle
            android.content.Context r3 = r13.getContext()
            int r4 = com.baidu.searchbox.feed.styles.R.color.FC113
            int r3 = com.baidu.searchbox.video.detail.utils.ResourceUtils.getColor(r3, r4)
            r0.setTextColor(r3)
            android.widget.FrameLayout r0 = r13.flTitleContainer
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r3 = r0 instanceof android.widget.LinearLayout.LayoutParams
            r4 = 0
            if (r3 == 0) goto L_0x005c
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            goto L_0x005d
        L_0x005c:
            r0 = r4
        L_0x005d:
            if (r0 == 0) goto L_0x0093
            r3 = 0
            r0.leftMargin = r1
            android.widget.LinearLayout r5 = r13.llSubTitle
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L_0x0079
            android.content.res.Resources r5 = r13.getResources()
            int r6 = com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X067
            int r5 = r5.getDimensionPixelOffset(r6)
            r0.topMargin = r5
            r0.bottomMargin = r1
            goto L_0x0091
        L_0x0079:
            android.content.res.Resources r1 = r13.getResources()
            int r5 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X004
            int r1 = r1.getDimensionPixelOffset(r5)
            r0.topMargin = r1
            android.content.res.Resources r1 = r13.getResources()
            int r5 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X004
            int r1 = r1.getDimensionPixelOffset(r5)
            r0.bottomMargin = r1
        L_0x0091:
        L_0x0093:
            android.widget.LinearLayout r0 = r13.llSubTitle
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r1 = r0 instanceof android.widget.LinearLayout.LayoutParams
            if (r1 == 0) goto L_0x00a0
            r4 = r0
            android.widget.LinearLayout$LayoutParams r4 = (android.widget.LinearLayout.LayoutParams) r4
        L_0x00a0:
            if (r4 == 0) goto L_0x00e4
            r0 = r4
            r1 = 0
            boolean r3 = r13.isPaymentType()
            if (r3 != 0) goto L_0x00ca
            boolean r3 = r13.isSubscribeType()
            if (r3 == 0) goto L_0x00b1
            goto L_0x00ca
        L_0x00b1:
            android.content.res.Resources r3 = r13.getResources()
            int r4 = com.baidu.searchbox.feed.styles.R.dimen.F_W_X01
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.leftMargin = r3
            android.content.res.Resources r3 = r13.getResources()
            int r4 = com.baidu.searchbox.feed.styles.R.dimen.F_W_X01
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.rightMargin = r3
            goto L_0x00e2
        L_0x00ca:
            android.content.res.Resources r3 = r13.getResources()
            int r4 = com.baidu.searchbox.video.feedflow.component.R.dimen.video_flow_dimens_15dp
            int r3 = r3.getDimensionPixelSize(r4)
            r0.leftMargin = r3
            android.content.res.Resources r3 = r13.getResources()
            int r4 = com.baidu.searchbox.feed.styles.R.dimen.F_W_X01
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.rightMargin = r3
        L_0x00e2:
        L_0x00e4:
            android.widget.LinearLayout r0 = r13.llSubTitle
            r0.setGravity(r2)
            android.widget.LinearLayout r0 = r13.llSubTitle
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x00fd
            android.widget.TextView r1 = r13.tvSubtitle
            r2 = 1098907648(0x41800000, float:16.0)
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            com.baidu.searchbox.player.utils.FontSizeHelperKt.setVideoScaledSize$default(r1, r2, r3, r4, r5, r6)
            goto L_0x0108
        L_0x00fd:
            android.widget.TextView r7 = r13.tvSubtitle
            r8 = 1096810496(0x41600000, float:14.0)
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            com.baidu.searchbox.player.utils.FontSizeHelperKt.setVideoScaledSize$default(r7, r8, r9, r10, r11, r12)
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.collection.view.CollectionHeaderView.setHeaderView4PortraitWhiteStyle():void");
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setHeaderView4LandscapeBlackStyle() {
        /*
            r9 = this;
            com.facebook.drawee.view.SimpleDraweeView r0 = r9.ivIcon
            r1 = 8
            r0.setVisibility(r1)
            android.widget.TextView r0 = r9.tvTitle
            android.content.Context r1 = r9.getContext()
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC409
            int r1 = com.baidu.searchbox.video.detail.utils.ResourceUtils.getColor(r1, r2)
            r0.setTextColor(r1)
            android.widget.TextView r2 = r9.tvSubtitle
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X004
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.baidu.searchbox.player.utils.FontSizeHelperKt.setVideoScaledSizeRes$default(r2, r3, r4, r5, r6, r7)
            android.widget.ImageView r0 = r9.ivClose
            r1 = 0
            r0.setBackgroundResource(r1)
            android.widget.ImageView r0 = r9.ivClose
            int r2 = com.baidu.searchbox.video.feedflow.component.R.drawable.video_flow_collection_panel_close_normal_dark
            r0.setBackgroundResource(r2)
            android.widget.LinearLayout r0 = r9.flTitle
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r2 = r0 instanceof android.widget.FrameLayout.LayoutParams
            r3 = 0
            if (r2 == 0) goto L_0x003c
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            goto L_0x003d
        L_0x003c:
            r0 = r3
        L_0x003d:
            if (r0 == 0) goto L_0x005a
            r2 = 0
            android.content.res.Resources r4 = r9.getResources()
            int r5 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X017
            int r4 = r4.getDimensionPixelOffset(r5)
            r0.leftMargin = r4
            android.content.res.Resources r4 = r9.getResources()
            int r5 = com.baidu.searchbox.video.feedflow.component.R.dimen.video_flow_collection_landscape_title_right
            int r4 = r4.getDimensionPixelOffset(r5)
            r0.rightMargin = r4
        L_0x005a:
            android.widget.LinearLayout r0 = r9.flTitle
            r2 = 8388611(0x800003, float:1.1754948E-38)
            r0.setGravity(r2)
            android.widget.TextView r0 = r9.tvSubtitle
            android.content.Context r4 = r9.getContext()
            int r5 = com.baidu.searchbox.feed.styles.R.color.FC408
            int r4 = com.baidu.searchbox.video.detail.utils.ResourceUtils.getColor(r4, r5)
            r0.setTextColor(r4)
            android.widget.FrameLayout r0 = r9.flTitleContainer
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r4 = r0 instanceof android.widget.LinearLayout.LayoutParams
            if (r4 == 0) goto L_0x007e
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            goto L_0x007f
        L_0x007e:
            r0 = r3
        L_0x007f:
            if (r0 == 0) goto L_0x00a5
            r4 = 0
            android.content.res.Resources r5 = r9.getResources()
            int r6 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X06600003
            int r5 = r5.getDimensionPixelOffset(r6)
            r0.topMargin = r5
            android.widget.LinearLayout r5 = r9.llSubTitle
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L_0x0097
            goto L_0x00a1
        L_0x0097:
            android.content.res.Resources r1 = r9.getResources()
            int r5 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X017
            int r1 = r1.getDimensionPixelOffset(r5)
        L_0x00a1:
            r0.bottomMargin = r1
        L_0x00a5:
            android.widget.LinearLayout r0 = r9.llSubTitle
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r1 = r0 instanceof android.widget.LinearLayout.LayoutParams
            if (r1 == 0) goto L_0x00b2
            r3 = r0
            android.widget.LinearLayout$LayoutParams r3 = (android.widget.LinearLayout.LayoutParams) r3
        L_0x00b2:
            if (r3 == 0) goto L_0x00e8
            r0 = r3
            r1 = 0
            android.content.res.Resources r3 = r9.getResources()
            int r4 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X017
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.leftMargin = r3
            android.content.res.Resources r3 = r9.getResources()
            int r4 = com.baidu.searchbox.feed.styles.R.dimen.F_J_X08
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.topMargin = r3
            android.content.res.Resources r3 = r9.getResources()
            int r4 = com.baidu.searchbox.video.feedflow.component.R.dimen.video_flow_collection_landscape_title_right
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.rightMargin = r3
            android.content.res.Resources r3 = r9.getResources()
            int r4 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X017
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.bottomMargin = r3
        L_0x00e8:
            android.widget.LinearLayout r0 = r9.llSubTitle
            r0.setGravity(r2)
            android.widget.TextView r3 = r9.tvSubtitle
            r4 = 1093664768(0x41300000, float:11.0)
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            com.baidu.searchbox.player.utils.FontSizeHelperKt.setVideoScaledSize$default(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.collection.view.CollectionHeaderView.setHeaderView4LandscapeBlackStyle():void");
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setHeaderView4PortraitBlackStyle() {
        /*
            r8 = this;
            com.facebook.drawee.view.SimpleDraweeView r0 = r8.ivIcon
            r1 = 8
            r0.setVisibility(r1)
            android.widget.TextView r0 = r8.tvTitle
            android.content.Context r1 = r8.getContext()
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC410
            int r1 = com.baidu.searchbox.video.detail.utils.ResourceUtils.getColor(r1, r2)
            r0.setTextColor(r1)
            android.widget.TextView r2 = r8.tvSubtitle
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X004
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.baidu.searchbox.player.utils.FontSizeHelperKt.setVideoScaledSizeRes$default(r2, r3, r4, r5, r6, r7)
            android.widget.ImageView r0 = r8.ivClose
            r1 = 0
            r0.setBackgroundResource(r1)
            android.widget.ImageView r0 = r8.ivClose
            int r2 = com.baidu.searchbox.video.feedflow.component.R.drawable.video_flow_collection_panel_close_normal_dark
            r0.setBackgroundResource(r2)
            r0 = 1
            r8.layoutTitle(r0)
            android.widget.TextView r0 = r8.tvSubtitle
            android.content.Context r2 = r8.getContext()
            int r3 = com.baidu.searchbox.feed.styles.R.color.FC408
            int r2 = com.baidu.searchbox.video.detail.utils.ResourceUtils.getColor(r2, r3)
            r0.setTextColor(r2)
            android.widget.FrameLayout r0 = r8.flTitleContainer
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r2 = r0 instanceof android.widget.LinearLayout.LayoutParams
            r3 = 0
            if (r2 == 0) goto L_0x004f
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            goto L_0x0050
        L_0x004f:
            r0 = r3
        L_0x0050:
            if (r0 == 0) goto L_0x0078
            r2 = 0
            r0.leftMargin = r1
            android.content.res.Resources r4 = r8.getResources()
            int r5 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X004
            int r4 = r4.getDimensionPixelOffset(r5)
            r0.topMargin = r4
            android.widget.LinearLayout r4 = r8.llSubTitle
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L_0x006a
            goto L_0x0074
        L_0x006a:
            android.content.res.Resources r1 = r8.getResources()
            int r4 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X004
            int r1 = r1.getDimensionPixelOffset(r4)
        L_0x0074:
            r0.bottomMargin = r1
        L_0x0078:
            android.widget.LinearLayout r0 = r8.llSubTitle
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r1 = r0 instanceof android.widget.LinearLayout.LayoutParams
            if (r1 == 0) goto L_0x0085
            r3 = r0
            android.widget.LinearLayout$LayoutParams r3 = (android.widget.LinearLayout.LayoutParams) r3
        L_0x0085:
            if (r3 == 0) goto L_0x00bb
            r0 = r3
            r1 = 0
            android.content.res.Resources r2 = r8.getResources()
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X001
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.leftMargin = r2
            android.content.res.Resources r2 = r8.getResources()
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_J_X08
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.topMargin = r2
            android.content.res.Resources r2 = r8.getResources()
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_W_X01
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.rightMargin = r2
            android.content.res.Resources r2 = r8.getResources()
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X004
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.bottomMargin = r2
        L_0x00bb:
            android.widget.LinearLayout r0 = r8.llSubTitle
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r0.setGravity(r1)
            android.widget.TextView r2 = r8.tvSubtitle
            r3 = 1093664768(0x41300000, float:11.0)
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.baidu.searchbox.player.utils.FontSizeHelperKt.setVideoScaledSize$default(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.collection.view.CollectionHeaderView.setHeaderView4PortraitBlackStyle():void");
    }

    public void changeStyle(int style) {
        switch (style) {
            case 1:
                setHeaderView4LandscapeBlackStyle();
                break;
            case 2:
                setHeaderView4PortraitBlackStyle();
                break;
            case 3:
                setHeaderView4PortraitWhiteStyle();
                break;
            default:
                setHeaderView4PortraitWhiteStyle();
                break;
        }
        setFontAndPictureSize();
    }

    private final void setFontAndPictureSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.ivIcon, com.baidu.searchbox.feed.styles.R.dimen.F_H_X15, com.baidu.searchbox.feed.styles.R.dimen.F_H_X15, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.ivClose, com.baidu.searchbox.feed.styles.R.dimen.F_T_X125, com.baidu.searchbox.feed.styles.R.dimen.F_T_X125, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.ivRightArrow, R.dimen.video_flow_dimens_10dp, R.dimen.video_flow_dimens_10dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.tvTitle, R.dimen.video_flow_dimens_14dp, 0, 0, 6, (Object) null);
    }

    public final void setOnLLSubtitleClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.llSubtitleClickListener = listener;
    }

    public final void setOnCloseClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.closeClickListener = listener;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void layoutTitle(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0036
            android.widget.LinearLayout r1 = r4.flTitle
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            boolean r2 = r1 instanceof android.widget.FrameLayout.LayoutParams
            if (r2 == 0) goto L_0x0010
            r0 = r1
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
        L_0x0010:
            if (r0 == 0) goto L_0x002d
            r1 = 0
            android.content.res.Resources r2 = r4.getResources()
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X001
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.leftMargin = r2
            android.content.res.Resources r2 = r4.getResources()
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_H_X50
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.rightMargin = r2
        L_0x002d:
            android.widget.LinearLayout r0 = r4.flTitle
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r0.setGravity(r1)
            goto L_0x0066
        L_0x0036:
            android.widget.LinearLayout r1 = r4.flTitle
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            boolean r2 = r1 instanceof android.widget.FrameLayout.LayoutParams
            if (r2 == 0) goto L_0x0043
            r0 = r1
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
        L_0x0043:
            if (r0 == 0) goto L_0x0060
            r1 = 0
            android.content.res.Resources r2 = r4.getResources()
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_W_X01
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.leftMargin = r2
            android.content.res.Resources r2 = r4.getResources()
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_W_X01
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.rightMargin = r2
        L_0x0060:
            android.widget.LinearLayout r0 = r4.flTitle
            r1 = 1
            r0.setGravity(r1)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.collection.view.CollectionHeaderView.layoutTitle(boolean):void");
    }

    private final boolean isPaymentType() {
        CollectionPanelHeaderModel collectionPanelHeaderModel = this.headerData;
        return Intrinsics.areEqual((Object) collectionPanelHeaderModel != null ? collectionPanelHeaderModel.getType() : null, (Object) "payment");
    }

    private final boolean isSubscribeType() {
        CollectionPanelHeaderModel collectionPanelHeaderModel = this.headerData;
        return Intrinsics.areEqual((Object) collectionPanelHeaderModel != null ? collectionPanelHeaderModel.getType() : null, (Object) "subscribe");
    }

    private final boolean isLongVideoType() {
        CollectionPanelHeaderModel collectionPanelHeaderModel = this.headerData;
        return Intrinsics.areEqual((Object) collectionPanelHeaderModel != null ? collectionPanelHeaderModel.getType() : null, (Object) "program");
    }
}
