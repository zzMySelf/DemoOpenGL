package com.baidu.searchbox.feed.template.tplinterface;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.prefetch.base.PrefetchItemData;
import java.util.List;

public interface IPrefetch {
    List<PrefetchItemData> generatePrefetchData(FeedBaseModel feedBaseModel, boolean z);

    List<PrefetchItemData> generateVideoPrefetchData(FeedBaseModel feedBaseModel, boolean z);
}
