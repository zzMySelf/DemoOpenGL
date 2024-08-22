package com.baidu.searchbox.dynamicpublisher.locrecommend;

import com.baidu.searchbox.dynamicpublisher.DynamicPublishRuntimeKt;
import com.baidu.searchbox.dynamicpublisher.image.ImageAction;
import com.baidu.searchbox.dynamicpublisher.location.LocationAction;
import com.baidu.searchbox.dynamicpublisher.locrecommend.LocRecommendAction;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.ugc.activity.RecommendLocModel;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.LogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/locrecommend/LocRecommendMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "isForbidden", "", "latLongCache", "", "", "Lcom/baidu/searchbox/ugc/activity/RecommendLocModel;", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "extractImageLatLong", "image", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocRecommendMiddleware.kt */
public final class LocRecommendMiddleware implements Middleware<CommonState> {
    private boolean isForbidden;
    private final Map<String, RecommendLocModel> latLongCache = new LinkedHashMap();

    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        LocRecommendMiddleware locRecommendMiddleware = this;
        Store<CommonState> store2 = store;
        Action action2 = action;
        Next<CommonState> next2 = next;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(next2, "next");
        if (action2 instanceof LocationAction.ShowPlaceLoc) {
            locRecommendMiddleware.isForbidden = true;
        } else if (action2 instanceof ImageAction.UpdateImage) {
            if (!locRecommendMiddleware.isForbidden) {
                Collection images = ((ImageAction.UpdateImage) action2).getImages();
                int i2 = 0;
                if (!(images == null || images.isEmpty())) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList $this$apply_u24lambda_u2d1 = arrayList;
                    int i3 = 0;
                    Iterable<ImageStruct> $this$forEach$iv = ((ImageAction.UpdateImage) action2).getImages();
                    for (ImageStruct image : $this$forEach$iv) {
                        RecommendLocModel model = locRecommendMiddleware.extractImageLatLong(image);
                        if (model == null) {
                            Object[] objArr = new Object[2];
                            objArr[i2] = "LocRecommendMiddleware";
                            objArr[1] = "图片经纬度提取失败: uri=" + image.uriStr;
                            LogUtil.d(objArr);
                            i2 = 0;
                            locRecommendMiddleware = this;
                        } else {
                            LogUtil.d("LocRecommendMiddleware", "图片经纬度提取成功: uri=" + image.uriStr + ", lat=" + model.getLat() + ", long=" + model.getLong());
                            $this$apply_u24lambda_u2d1.add(model);
                            i3 = i3;
                            $this$forEach$iv = $this$forEach$iv;
                            i2 = 0;
                            locRecommendMiddleware = this;
                        }
                    }
                    int i4 = i3;
                    Iterable iterable = $this$forEach$iv;
                    ArrayList latLongs = arrayList;
                    if (latLongs.isEmpty()) {
                        return next2.next(store2, action2);
                    }
                    if (((ImageAction.UpdateImage) action2).getType() == 0) {
                        store2.dispatch(new LocRecommendAction.TriggerRecommend(0, latLongs));
                    } else {
                        store2.dispatch(new LocRecommendAction.TriggerRecommend(1, latLongs));
                    }
                }
            }
            return next2.next(store2, action2);
        }
        return next2.next(store2, action2);
    }

    private final RecommendLocModel extractImageLatLong(ImageStruct image) {
        if (image == null) {
            return null;
        }
        if (this.latLongCache.containsKey(image.uriStr)) {
            return this.latLongCache.get(image.uriStr);
        }
        if (image.latitude == null || image.longitude == null) {
            double[] extractImageLocationInfo = FileUtils.extractImageLocationInfo(DynamicPublishRuntimeKt.getAppContext(), image.uriStr);
            if (extractImageLocationInfo == null) {
                return null;
            }
            double[] latLong = extractImageLocationInfo;
            return new RecommendLocModel(latLong[0], latLong[1], 0, 4, (DefaultConstructorMarker) null);
        }
        Double d2 = image.latitude;
        Intrinsics.checkNotNullExpressionValue(d2, "image.latitude");
        double doubleValue = d2.doubleValue();
        Double d3 = image.longitude;
        Intrinsics.checkNotNullExpressionValue(d3, "image.longitude");
        return new RecommendLocModel(doubleValue, d3.doubleValue(), 0, 4, (DefaultConstructorMarker) null);
    }
}
