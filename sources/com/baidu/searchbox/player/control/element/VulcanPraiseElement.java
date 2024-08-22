package com.baidu.searchbox.player.control.element;

import android.view.View;
import com.baidu.searchbox.player.control.model.PraiseInfo;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.event.VulcanControlEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.widget.VideoVulcanPraiseViewWrapper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/player/control/element/VulcanPraiseElement;", "Lcom/baidu/searchbox/player/control/element/VulcanControlLayerElement;", "()V", "likeViewWrapper", "Lcom/baidu/searchbox/player/widget/VideoVulcanPraiseViewWrapper;", "getLikeViewWrapper", "()Lcom/baidu/searchbox/player/widget/VideoVulcanPraiseViewWrapper;", "likeViewWrapper$delegate", "Lkotlin/Lazy;", "getContentView", "Landroid/view/View;", "initElement", "", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanPraiseElement.kt */
public final class VulcanPraiseElement extends VulcanControlLayerElement {
    private final Lazy likeViewWrapper$delegate = BdPlayerUtils.lazyNone(new VulcanPraiseElement$likeViewWrapper$2(this));

    private final VideoVulcanPraiseViewWrapper getLikeViewWrapper() {
        return (VideoVulcanPraiseViewWrapper) this.likeViewWrapper$delegate.getValue();
    }

    public void initElement() {
    }

    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case -962768311:
                if (action.equals(VulcanControlEvent.ACTION_VULCAN_SET_PRAISE)) {
                    Object extra = event.getExtra(9);
                    if (!(extra instanceof PraiseInfo)) {
                        extra = null;
                    }
                    PraiseInfo praise = (PraiseInfo) extra;
                    if (praise != null) {
                        getLikeViewWrapper().setPraiseInfo(praise);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public View getContentView() {
        return getLikeViewWrapper().getView();
    }
}
