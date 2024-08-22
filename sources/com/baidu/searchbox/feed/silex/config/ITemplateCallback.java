package com.baidu.searchbox.feed.silex.config;

import android.view.View;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.model.FeedBaseModel;

public interface ITemplateCallback {
    void onBindViewHolder(FeedTemplate feedTemplate, int i2);

    void onItemChildViewClick(FeedTemplate feedTemplate, View view2, int i2);

    boolean onItemViewClick(FeedTemplate feedTemplate, View view2, int i2);

    void onItemViewDelete(FeedBaseModel feedBaseModel, int i2);

    void onItemViewLongClick(FeedTemplate feedTemplate, View view2, int i2);

    void onItemViewShow(FeedTemplate feedTemplate, int i2);

    void onViewHolderBindFirstly();
}
