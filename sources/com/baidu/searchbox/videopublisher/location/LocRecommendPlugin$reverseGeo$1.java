package com.baidu.searchbox.videopublisher.location;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.videopublisher.location.LocationAction;
import com.baidu.ugc.position.ILocationSelectInterface;
import com.baidu.ugc.position.model.PoiModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/videopublisher/location/LocRecommendPlugin$reverseGeo$1", "Lcom/baidu/ugc/position/ILocationSelectInterface$PoiReverseListener;", "onCancel", "", "onSuccess", "poiModels", "", "Lcom/baidu/ugc/position/model/PoiModel;", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocRecommendPlugin.kt */
public final class LocRecommendPlugin$reverseGeo$1 implements ILocationSelectInterface.PoiReverseListener {
    final /* synthetic */ LocRecommendPlugin this$0;

    LocRecommendPlugin$reverseGeo$1(LocRecommendPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onSuccess(List<? extends PoiModel> poiModels) {
        Collection collection = poiModels;
        if (!(collection == null || collection.isEmpty())) {
            ArrayList locationModels = new ArrayList();
            ArrayList $this$onSuccess_u24lambda_u2d1 = locationModels;
            for (PoiModel poi : poiModels) {
                $this$onSuccess_u24lambda_u2d1.add(new LocationMapper().map(poi));
            }
            Store access$getStore = this.this$0.getStore();
            if (access$getStore != null) {
                access$getStore.dispatch(new LocationAction.RecommendSuccess(locationModels));
            }
        }
    }

    public void onCancel() {
    }
}
