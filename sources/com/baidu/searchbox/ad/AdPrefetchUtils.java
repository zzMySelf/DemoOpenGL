package com.baidu.searchbox.ad;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ad.util.CollectionUtils;
import com.baidu.searchbox.feed.ad.prefetch.AdPrefetchModel;
import com.baidu.searchbox.feed.ad.prefetch.IAdPrefetch;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBaseModelHelper;
import com.baidu.searchbox.feed.parser.FeedFilter;
import java.util.ArrayList;
import java.util.List;

public class AdPrefetchUtils {
    public static List<AdPrefetchModel> generatePrefetchModels(List<FeedBaseModel> modelList) {
        String extraParams;
        ArrayList<AdPrefetchModel> prefetchModelList = new ArrayList<>();
        if (CollectionUtils.isNullOrEmpty((List) modelList)) {
            return prefetchModelList;
        }
        for (FeedBaseModel model : modelList) {
            if (model != null) {
                FeedBaseModelHelper helper = model.getHelper();
                if (FeedFilter.checkAdFeed(model) && !model.runtimeStatus.isAdPrefetch) {
                    model.runtimeStatus.isAdPrefetch = true;
                    int prefetchType = helper.getPrefetchType();
                    if (model.data.ad.ext == null || TextUtils.isEmpty(model.data.ad.ext.extraParams)) {
                        extraParams = "";
                    } else {
                        extraParams = model.data.ad.ext.extraParams;
                    }
                    CollectionUtils.add(prefetchModelList, new AdPrefetchModel(prefetchType, extraParams, helper.getLpRealUrl(), model.id == null ? "" : model.id, helper.getPrefetchHtmlUrl(true), "type_ad_html"));
                }
            }
        }
        return prefetchModelList;
    }

    public static void prefetchAds(List<AdPrefetchModel> modelList, int state, Context ctx) {
        if (!CollectionUtils.isNullOrEmpty((List) modelList)) {
            IAdPrefetch.Impl.Companion.get().prefetchAds(modelList, state, ctx);
        }
    }
}
