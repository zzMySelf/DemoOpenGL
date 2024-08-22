package com.baidu.searchbox.video.feedflow.detail.summary;

import android.view.MotionEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic.ICarouselPicService;
import com.baidu.searchbox.video.feedflow.view.FolderTextViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/summary/SummaryComponent$registerListeners$1", "Lcom/baidu/searchbox/video/feedflow/view/FolderTextViewContainer$DynamicPicTouchEventCallback;", "dynamicPicTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "isDynamicPicNeedConsumeEvent", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SummaryComponent.kt */
public final class SummaryComponent$registerListeners$1 implements FolderTextViewContainer.DynamicPicTouchEventCallback {
    final /* synthetic */ SummaryComponent this$0;

    SummaryComponent$registerListeners$1(SummaryComponent $receiver) {
        this.this$0 = $receiver;
    }

    public boolean isDynamicPicNeedConsumeEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        ICarouselPicService iCarouselPicService = (ICarouselPicService) this.this$0.getManager().getService(ICarouselPicService.class);
        return BdPlayerUtils.orFalse(iCarouselPicService != null ? Boolean.valueOf(iCarouselPicService.isDynamicPicNeedConsumeEvent(ev)) : null);
    }

    public boolean dynamicPicTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        ICarouselPicService iCarouselPicService = (ICarouselPicService) this.this$0.getManager().getService(ICarouselPicService.class);
        return BdPlayerUtils.orFalse(iCarouselPicService != null ? Boolean.valueOf(iCarouselPicService.onHandleTouchEvent(ev)) : null);
    }
}
