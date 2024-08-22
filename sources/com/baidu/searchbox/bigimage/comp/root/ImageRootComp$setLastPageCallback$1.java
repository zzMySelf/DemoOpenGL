package com.baidu.searchbox.bigimage.comp.root;

import android.graphics.drawable.Drawable;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.widget.BigImageViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/bigimage/comp/root/ImageRootComp$setLastPageCallback$1", "Lcom/baidu/searchbox/bigimage/widget/BigImageViewPager$LastPageDragCallback;", "onDragStart", "", "onSpringBackEnd", "onSpringBackStart", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageRootComp.kt */
public final class ImageRootComp$setLastPageCallback$1 implements BigImageViewPager.LastPageDragCallback {
    final /* synthetic */ ImageRootComp this$0;

    ImageRootComp$setLastPageCallback$1(ImageRootComp $receiver) {
        this.this$0 = $receiver;
    }

    public void onDragStart() {
        this.this$0.setLastPageDragOngoing(true);
        this.this$0.getView().setBackgroundColor(this.this$0.getContext().getResources().getColor(R.color.search_big_image_mask_bg));
    }

    public void onSpringBackStart() {
        UniversalToast.makeText(this.this$0.getContext(), R.string.search_big_image_load_end).show();
        this.this$0.loadMorePrefetcher.onLastImgDragStat();
    }

    public void onSpringBackEnd() {
        this.this$0.setLastPageDragOngoing(false);
        this.this$0.getView().setBackground((Drawable) null);
    }
}
