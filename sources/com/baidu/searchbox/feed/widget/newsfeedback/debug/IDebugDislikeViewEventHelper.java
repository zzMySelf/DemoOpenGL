package com.baidu.searchbox.feed.widget.newsfeedback.debug;

import android.view.View;
import com.baidu.searchbox.feed.widget.newsfeedback.Callback;
import com.baidu.searchbox.lightbrowser.model.FeedItemTag;
import java.util.List;

public interface IDebugDislikeViewEventHelper {
    View.OnTouchListener getTouchListener();

    void setCallback(Callback callback);

    void setTags(List<FeedItemTag> list);
}
