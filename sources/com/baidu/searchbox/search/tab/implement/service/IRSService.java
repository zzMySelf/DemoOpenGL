package com.baidu.searchbox.search.tab.implement.service;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.search.tab.core.service.IService;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonRSModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/service/IRSService;", "Lcom/baidu/searchbox/search/tab/core/service/IService;", "handleRSInsert", "", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "newFeeds", "rsData", "Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonRSModel;", "requestType", "", "(Ljava/util/List;Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonRSModel;Ljava/lang/Integer;)Ljava/util/List;", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IRSService.kt */
public interface IRSService extends IService {
    List<FeedBaseModel> handleRSInsert(List<FeedBaseModel> list, VideoCommonRSModel videoCommonRSModel, Integer num);
}
