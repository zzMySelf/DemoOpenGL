package com.baidu.searchbox.paywall.view;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.paywall.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/paywall/view/PaywallDocBandVH;", "Lcom/baidu/searchbox/paywall/view/PaywallBaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "adapter", "Lcom/baidu/searchbox/paywall/view/PaywallAdapter;", "(Landroid/view/ViewGroup;Lcom/baidu/searchbox/paywall/view/PaywallAdapter;)V", "boughtTv", "Landroid/widget/TextView;", "couponInfoTv", "coverContainer", "Landroid/widget/FrameLayout;", "coverImg", "Lcom/facebook/drawee/view/SimpleDraweeView;", "coverImgPointF", "Landroid/graphics/PointF;", "getCoverImgPointF", "()Landroid/graphics/PointF;", "coverImgPointF$delegate", "Lkotlin/Lazy;", "divideLine", "Landroid/view/View;", "docType", "Landroid/widget/ImageView;", "sourceTv", "titleTv", "updateTag", "setTopMargin", "", "view", "topMargin", "", "updateItem", "Companion", "lib-paywall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallDocBandVH.kt */
public final class PaywallDocBandVH extends PaywallBaseViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String RES_DRAWABLE_URI_PREFIX = "res://drawable/";
    private final TextView boughtTv;
    private final TextView couponInfoTv;
    private final FrameLayout coverContainer;
    private final SimpleDraweeView coverImg;
    private final Lazy coverImgPointF$delegate = LazyKt.lazy(PaywallDocBandVH$coverImgPointF$2.INSTANCE);
    private final View divideLine;
    private final ImageView docType;
    private final TextView sourceTv;
    private final TextView titleTv;
    private final ImageView updateTag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/paywall/view/PaywallDocBandVH$Companion;", "", "()V", "RES_DRAWABLE_URI_PREFIX", "", "lib-paywall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaywallDocBandVH.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaywallDocBandVH(ViewGroup parent, PaywallAdapter adapter) {
        super(R.layout.paywall_doc_band, parent, adapter);
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        View findViewById = this.itemView.findViewById(R.id.cover_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.cover_container)");
        this.coverContainer = (FrameLayout) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.cover_img);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.cover_img)");
        this.coverImg = (SimpleDraweeView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.title)");
        this.titleTv = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.update_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.update_tag)");
        this.updateTag = (ImageView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.iv_doc_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.iv_doc_tag)");
        this.docType = (ImageView) findViewById5;
        View findViewById6 = this.itemView.findViewById(R.id.coupon_info);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.coupon_info)");
        this.couponInfoTv = (TextView) findViewById6;
        View findViewById7 = this.itemView.findViewById(R.id.source);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.source)");
        this.sourceTv = (TextView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R.id.bought_text);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.bought_text)");
        this.boughtTv = (TextView) findViewById8;
        View findViewById9 = this.itemView.findViewById(R.id.bottom_text_divide_line);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.….bottom_text_divide_line)");
        this.divideLine = findViewById9;
    }

    private final PointF getCoverImgPointF() {
        return (PointF) this.coverImgPointF$delegate.getValue();
    }

    /* JADX WARNING: type inference failed for: r5v32, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateItem() {
        /*
            r9 = this;
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r0 = r9.getItemData()
            if (r0 == 0) goto L_0x0238
            com.baidu.searchbox.paywall.view.PaywallAdapter r0 = r9.getAdapter()
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L_0x0012
            goto L_0x0238
        L_0x0012:
            com.baidu.searchbox.paywall.view.PaywallAdapter r0 = r9.getAdapter()
            android.content.Context r0 = r0.getContext()
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r1 = "adapter.context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r9.getAdapterPosition()
            r2 = 1
            if (r1 != r2) goto L_0x003a
            android.view.View r1 = r9.itemView
            java.lang.String r2 = "itemView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            int r2 = com.baidu.searchbox.paywall.R.dimen.paywall_doc_item_top_margin
            int r2 = r0.getDimensionPixelOffset(r2)
            r9.setTopMargin(r1, r2)
        L_0x003a:
            android.view.View r1 = r9.itemView
            int r2 = com.baidu.searchbox.paywall.R.drawable.paywall_band_item_bg_selector
            android.graphics.drawable.Drawable r2 = r0.getDrawable(r2)
            r1.setBackground(r2)
            int r1 = com.baidu.searchbox.paywall.R.drawable.paywall_doc_item_cover_container_bg
            android.widget.FrameLayout r2 = r9.coverContainer
            r3 = 0
            android.graphics.drawable.Drawable r4 = androidx.core.content.res.ResourcesCompat.getDrawable(r0, r1, r3)
            r2.setBackground(r4)
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r2 = r9.getItemData()
            java.lang.String r2 = r2.cover
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r4 = r9.getItemData()
            int r4 = r4.resourceType
            switch(r4) {
                case 21: goto L_0x006e;
                case 22: goto L_0x006e;
                case 23: goto L_0x0060;
                case 24: goto L_0x006e;
                case 25: goto L_0x006e;
                case 26: goto L_0x0060;
                case 27: goto L_0x0060;
                case 28: goto L_0x006e;
                default: goto L_0x0060;
            }
        L_0x0060:
            com.facebook.drawee.view.SimpleDraweeView r4 = r9.coverImg
            com.facebook.drawee.interfaces.DraweeHierarchy r4 = r4.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r4 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r4
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r5 = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP
            r4.setActualImageScaleType(r5)
            goto L_0x008a
        L_0x006e:
            com.facebook.drawee.view.SimpleDraweeView r4 = r9.coverImg
            com.facebook.drawee.interfaces.DraweeHierarchy r4 = r4.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r4 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r4
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r5 = com.facebook.drawee.drawable.ScalingUtils.ScaleType.FOCUS_CROP
            r4.setActualImageScaleType(r5)
            com.facebook.drawee.view.SimpleDraweeView r4 = r9.coverImg
            com.facebook.drawee.interfaces.DraweeHierarchy r4 = r4.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r4 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r4
            android.graphics.PointF r5 = r9.getCoverImgPointF()
            r4.setActualImageFocusPoint(r5)
        L_0x008a:
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00a4
            int r4 = com.baidu.searchbox.paywall.R.drawable.paywall_doc_item_cover_bg
            com.facebook.drawee.view.SimpleDraweeView r5 = r9.coverImg
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.getDrawable(r0, r4, r3)
            r5.setBackground(r6)
            com.facebook.drawee.view.SimpleDraweeView r5 = r9.coverImg
            r5.setImageURI((java.lang.String) r2)
            goto L_0x00c7
        L_0x00a4:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "res://drawable/"
            java.lang.StringBuilder r4 = r4.append(r5)
            com.baidu.searchbox.paywall.PaywallUtil r5 = com.baidu.searchbox.paywall.PaywallUtil.INSTANCE
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r6 = r9.getItemData()
            int r5 = r5.getDocCoverDrawableId(r6)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.facebook.drawee.view.SimpleDraweeView r5 = r9.coverImg
            r5.setImageURI((java.lang.String) r4)
        L_0x00c7:
            com.baidu.searchbox.paywall.PaywallUtil r4 = com.baidu.searchbox.paywall.PaywallUtil.INSTANCE
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r5 = r9.getItemData()
            int r4 = r4.getDocCoverTagIconId(r5)
            android.widget.ImageView r5 = r9.docType
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.getDrawable(r0, r4, r3)
            r5.setImageDrawable(r6)
            android.widget.TextView r5 = r9.titleTv
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r6 = r9.getItemData()
            java.lang.String r6 = r6.title
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            android.widget.TextView r5 = r9.titleTv
            int r6 = com.baidu.android.common.ui.style.R.color.GC1
            int r6 = r0.getColor(r6)
            r5.setTextColor(r6)
            android.widget.TextView r5 = r9.sourceTv
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r6 = r9.getItemData()
            java.lang.String r6 = r6.source
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            android.widget.TextView r5 = r9.sourceTv
            int r6 = com.baidu.android.common.ui.style.R.color.GC4
            int r6 = r0.getColor(r6)
            r5.setTextColor(r6)
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r5 = r9.getItemData()
            java.lang.String r5 = r5.couponInfo
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r6 = 8
            r7 = 0
            if (r5 == 0) goto L_0x0121
            android.widget.TextView r5 = r9.couponInfoTv
            r5.setVisibility(r6)
            goto L_0x013e
        L_0x0121:
            android.widget.TextView r5 = r9.couponInfoTv
            r5.setVisibility(r7)
            android.widget.TextView r5 = r9.couponInfoTv
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r8 = r9.getItemData()
            java.lang.String r8 = r8.couponInfo
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r5.setText(r8)
            android.widget.TextView r5 = r9.couponInfoTv
            int r8 = com.baidu.android.common.ui.style.R.color.GC62
            int r8 = r0.getColor(r8)
            r5.setTextColor(r8)
        L_0x013e:
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r5 = r9.getItemData()
            java.lang.String r5 = r5.couponInfo
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x016b
            android.widget.TextView r5 = r9.titleTv
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            boolean r8 = r5 instanceof android.widget.LinearLayout.LayoutParams
            if (r8 == 0) goto L_0x0159
            r3 = r5
            android.widget.LinearLayout$LayoutParams r3 = (android.widget.LinearLayout.LayoutParams) r3
        L_0x0159:
            if (r3 == 0) goto L_0x016b
            int r5 = com.baidu.searchbox.paywall.R.dimen.paywall_doc_item_title_margin
            int r5 = r0.getDimensionPixelOffset(r5)
            r3.bottomMargin = r5
            android.widget.TextView r5 = r9.titleTv
            r8 = r3
            android.view.ViewGroup$LayoutParams r8 = (android.view.ViewGroup.LayoutParams) r8
            r5.setLayoutParams(r8)
        L_0x016b:
            com.baidu.searchbox.paywall.view.PaywallAdapter r3 = r9.getAdapter()
            boolean r3 = r3.isEditState()
            if (r3 == 0) goto L_0x019f
            android.widget.ImageView r3 = r9.getSelectIcon()
            r3.setVisibility(r7)
            android.widget.ImageView r3 = r9.getSelectIcon()
            int r5 = com.baidu.android.common.ui.style.R.drawable.download_title_select_selector
            android.graphics.drawable.Drawable r5 = r0.getDrawable(r5)
            r3.setImageDrawable(r5)
            android.widget.ImageView r3 = r9.getSelectIcon()
            com.baidu.searchbox.paywall.view.PaywallAdapter r5 = r9.getAdapter()
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r8 = r9.getItemData()
            java.lang.String r8 = r8.thirdId
            boolean r5 = r5.isItemSelected(r8)
            r3.setSelected(r5)
            goto L_0x01a6
        L_0x019f:
            android.widget.ImageView r3 = r9.getSelectIcon()
            r3.setVisibility(r6)
        L_0x01a6:
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r3 = r9.getItemData()
            java.lang.String r3 = r3.status
            java.lang.String r5 = "1"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r8 == 0) goto L_0x01c5
            int r3 = com.baidu.searchbox.paywall.R.drawable.paywall_item_update_tag
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            android.widget.ImageView r8 = r9.updateTag
            r8.setImageDrawable(r3)
            android.widget.ImageView r8 = r9.updateTag
            r8.setVisibility(r7)
            goto L_0x01e3
        L_0x01c5:
            java.lang.String r8 = "2"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r8)
            if (r3 == 0) goto L_0x01de
            int r3 = com.baidu.searchbox.paywall.R.drawable.paywall_item_off_shelf_tag
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            android.widget.ImageView r8 = r9.updateTag
            r8.setImageDrawable(r3)
            android.widget.ImageView r8 = r9.updateTag
            r8.setVisibility(r7)
            goto L_0x01e3
        L_0x01de:
            android.widget.ImageView r3 = r9.updateTag
            r3.setVisibility(r6)
        L_0x01e3:
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r3 = r9.getItemData()
            java.lang.String r3 = r3.ownType
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r3 = android.text.TextUtils.equals(r3, r5)
            android.view.View r5 = r9.divideLine
            r5.setVisibility(r6)
            if (r3 == 0) goto L_0x0232
            android.widget.TextView r5 = r9.boughtTv
            r5.setVisibility(r7)
            android.widget.TextView r5 = r9.boughtTv
            int r6 = com.baidu.searchbox.paywall.R.string.paywall_bought
            java.lang.CharSequence r6 = r0.getText(r6)
            r5.setText(r6)
            android.widget.TextView r5 = r9.boughtTv
            int r6 = com.baidu.android.common.ui.style.R.color.GC4
            int r6 = r0.getColor(r6)
            r5.setTextColor(r6)
            com.baidu.searchbox.paywall.privatemodel.PaywallItem r5 = r9.getItemData()
            java.lang.String r5 = r5.source
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0237
            android.view.View r5 = r9.divideLine
            r5.setVisibility(r7)
            android.view.View r5 = r9.divideLine
            int r6 = com.baidu.android.common.ui.style.R.color.GC4
            android.graphics.drawable.Drawable r6 = r0.getDrawable(r6)
            r5.setBackground(r6)
            goto L_0x0237
        L_0x0232:
            android.widget.TextView r5 = r9.boughtTv
            r5.setVisibility(r6)
        L_0x0237:
            return
        L_0x0238:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.paywall.view.PaywallDocBandVH.updateItem():void");
    }

    private final void setTopMargin(View view2, int topMargin) {
        if (view2.getLayoutParams() instanceof RecyclerView.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                layoutParams2.topMargin = topMargin;
                view2.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
    }
}
