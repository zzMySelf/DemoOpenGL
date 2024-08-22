package com.baidu.searchbox.search.hottopic.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/search/hottopic/view/HotItemView;", "Lcom/baidu/searchbox/search/hottopic/view/BaseHotItemView;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getElementPadding", "", "getImageSize", "", "getIndexPadding", "getIndexWidth", "getItemHeight", "getItemHeightPadding", "getItemLRPadding", "getItemTextSize", "lib_hot_topic_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotItemView.kt */
public final class HotItemView extends BaseHotItemView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HotItemView(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public float getItemHeight() {
        return HotItemViewKt.itemHeight;
    }

    public float getItemHeightPadding() {
        return HotItemViewKt.itemHeightPadding;
    }

    public float getIndexWidth() {
        return HotItemViewKt.indexWidth;
    }

    public int getIndexPadding() {
        return HotItemViewKt.indexPadding;
    }

    public float getImageSize() {
        return HotItemViewKt.imageSize;
    }

    public float getItemTextSize() {
        return HotItemViewKt.itemTextSize;
    }

    public float getItemLRPadding() {
        return HotItemViewKt.itemLRPadding;
    }

    public int getElementPadding() {
        return HotItemViewKt.elementPadding;
    }
}
