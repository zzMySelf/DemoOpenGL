package com.baidu.searchbox.paywall.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.paywall.PaywallUtil;
import com.baidu.searchbox.paywall.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/paywall/view/PaywallColumnBandVH;", "Lcom/baidu/searchbox/paywall/view/PaywallBaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "adapter", "Lcom/baidu/searchbox/paywall/view/PaywallAdapter;", "(Landroid/view/ViewGroup;Lcom/baidu/searchbox/paywall/view/PaywallAdapter;)V", "boughtText", "Landroid/widget/TextView;", "couponInfoTv", "coverImg", "Lcom/facebook/drawee/view/SimpleDraweeView;", "divideLine", "Landroid/view/View;", "source", "titleTv", "typeImage", "Landroid/widget/ImageView;", "updateContentTv", "updateTag", "updateTimeTv", "updateItem", "", "lib-paywall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallColumnBandVH.kt */
public final class PaywallColumnBandVH extends PaywallBaseViewHolder {
    private final TextView boughtText;
    private final TextView couponInfoTv;
    private final SimpleDraweeView coverImg;
    private final View divideLine;
    private final TextView source;
    private final TextView titleTv;
    private final ImageView typeImage;
    private final TextView updateContentTv;
    private final ImageView updateTag;
    private final TextView updateTimeTv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaywallColumnBandVH(ViewGroup parent, PaywallAdapter adapter) {
        super(R.layout.paywall_column_band, parent, adapter);
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        View findViewById = this.itemView.findViewById(R.id.cover_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.cover_img)");
        this.coverImg = (SimpleDraweeView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.update_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.update_tag)");
        this.updateTag = (ImageView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.type);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.type)");
        this.typeImage = (ImageView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.title)");
        this.titleTv = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.update_content);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.update_content)");
        this.updateContentTv = (TextView) findViewById5;
        View findViewById6 = this.itemView.findViewById(R.id.coupon_info);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.coupon_info)");
        this.couponInfoTv = (TextView) findViewById6;
        View findViewById7 = this.itemView.findViewById(R.id.update_time);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.update_time)");
        this.updateTimeTv = (TextView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R.id.source);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.source)");
        this.source = (TextView) findViewById8;
        View findViewById9 = this.itemView.findViewById(R.id.bottom_text_divide_line);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.….bottom_text_divide_line)");
        this.divideLine = findViewById9;
        View findViewById10 = this.itemView.findViewById(R.id.bought_text);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.id.bought_text)");
        this.boughtText = (TextView) findViewById10;
    }

    public void updateItem() {
        Resources resources = getAdapter().getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "adapter.context.resources");
        this.itemView.setBackground(resources.getDrawable(R.drawable.paywall_band_item_bg_selector));
        this.coverImg.setImageURI(getItemData().cover);
        this.typeImage.setImageResource(PaywallUtil.INSTANCE.getTplidImageId(getItemData().tplid));
        this.titleTv.setText(getItemData().title);
        this.titleTv.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC1));
        if (TextUtils.isEmpty(getItemData().source)) {
            this.source.setVisibility(8);
        } else {
            this.source.setVisibility(0);
            this.source.setText(getItemData().source);
            this.source.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC4));
        }
        if (TextUtils.isEmpty(getItemData().lastChapter)) {
            this.updateContentTv.setVisibility(8);
        } else {
            this.updateContentTv.setVisibility(0);
            this.updateContentTv.setText(resources.getString(R.string.paywall_column_band_update_prefix) + getItemData().lastChapter);
            this.updateContentTv.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC3));
        }
        if (TextUtils.isEmpty(getItemData().couponInfo)) {
            this.couponInfoTv.setVisibility(8);
        } else {
            this.couponInfoTv.setVisibility(0);
            this.couponInfoTv.setText(getItemData().couponInfo);
            this.couponInfoTv.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC62));
        }
        String updateTimeStr = PaywallUtil.INSTANCE.getModifyTimeStr(getItemData().modifyTime);
        if (updateTimeStr == null) {
            this.updateTimeTv.setVisibility(8);
        } else {
            this.updateTimeTv.setVisibility(0);
            this.updateTimeTv.setText(updateTimeStr);
            this.updateTimeTv.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC4));
        }
        if (getAdapter().isEditState()) {
            getSelectIcon().setVisibility(0);
            getSelectIcon().setImageDrawable(resources.getDrawable(com.baidu.android.common.ui.style.R.drawable.download_title_select_selector));
            getSelectIcon().setSelected(getAdapter().isItemSelected(getItemData().thirdId));
        } else {
            getSelectIcon().setVisibility(8);
        }
        if (getItemData().status != null) {
            String str = getItemData().status;
            if (Intrinsics.areEqual((Object) str, (Object) "1")) {
                this.updateTag.setImageDrawable(resources.getDrawable(R.drawable.paywall_item_update_tag));
                this.updateTag.setVisibility(0);
            } else if (Intrinsics.areEqual((Object) str, (Object) "2")) {
                this.updateTag.setImageDrawable(resources.getDrawable(R.drawable.paywall_item_off_shelf_tag));
                this.updateTag.setVisibility(0);
            } else {
                this.updateTag.setVisibility(8);
            }
        } else {
            this.updateTag.setVisibility(8);
        }
        boolean hasBought = !TextUtils.isEmpty(getItemData().ownType) && (TextUtils.equals(getItemData().ownType, "1") || TextUtils.equals(getItemData().ownType, "6"));
        this.divideLine.setVisibility(8);
        if (hasBought) {
            this.boughtText.setVisibility(0);
            this.boughtText.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC4));
            if (updateTimeStr != null || !TextUtils.isEmpty(getItemData().source)) {
                this.divideLine.setVisibility(0);
                this.divideLine.setBackground(resources.getDrawable(com.baidu.android.common.ui.style.R.color.GC4));
            }
            String str2 = getItemData().ownType;
            if (Intrinsics.areEqual((Object) str2, (Object) "1")) {
                this.boughtText.setText(resources.getString(R.string.paywall_bought));
            } else if (Intrinsics.areEqual((Object) str2, (Object) "6")) {
                String buyNum = getItemData().buyNum;
                Integer buyNumInt = buyNum != null ? StringsKt.toIntOrNull(buyNum) : null;
                if (buyNumInt != null) {
                    if (buyNumInt.intValue() > 99) {
                        buyNum = "99+";
                    }
                    this.boughtText.setText(resources.getString(R.string.paywall_single_resource_bought_text, new Object[]{buyNum}));
                    return;
                }
                this.boughtText.setText(resources.getString(R.string.paywall_bought));
            }
        } else {
            this.boughtText.setVisibility(8);
        }
    }
}
