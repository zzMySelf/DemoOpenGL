package com.baidu.searchbox.novel.main.net;

import com.baidu.searchbox.story.net.base.NovelActionDataParser;
import com.baidu.searchbox.story.net.base.NovelBaseTask;
import com.baidu.searchbox.story.net.base.ParamPair;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class FeedTabTask extends NovelBaseTask<FeedTabInfo> {
    public static final String ACTION_TYPE = "nafeedtab";
    private String mData = getPostData();

    public FeedTabTask() {
        super(getFeedTabParser(), false, ACTION_TYPE, 999);
    }

    private static SimpleDataParser<FeedTabInfo> getFeedTabParser() {
        return new SimpleDataParser<FeedTabInfo>() {
            public FeedTabInfo parseData(JSONObject data) {
                if (!FeedTabInfo.checkAvailable(data)) {
                    return null;
                }
                FeedTabInfo.saveData(data);
                return null;
            }
        };
    }

    private String getPostData() {
        return "";
    }

    /* access modifiers changed from: protected */
    public List<ParamPair<?>> getParamList() {
        List<ParamPair<?>> list = new ArrayList<>(1);
        list.add(new ParamPair("data", this.mData));
        return list;
    }

    /* access modifiers changed from: protected */
    public NovelActionDataParser<FeedTabInfo> getParser() {
        return null;
    }
}
