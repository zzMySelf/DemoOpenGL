package com.baidu.searchbox.dynamic.template.forward.origin;

import android.content.Context;
import com.baidu.searchbox.dynamic.template.video.DynamicVideoItemData;
import com.baidu.searchbox.dynamic.template.video.DynamicVideoView;
import com.baidu.searchbox.feed.template.origin.IOriginDecoderFactory;

public class OriginVideoFactory implements IOriginDecoderFactory<DynamicVideoItemData, DynamicVideoView.PostView> {
    public String getType() {
        return "hot_talk_video";
    }

    public DynamicVideoItemData buildOriginModel() {
        return new DynamicVideoItemData();
    }

    public DynamicVideoView.PostView buildOriginTemplate(Context context) {
        return new DynamicVideoView.PostView(context, true);
    }
}
