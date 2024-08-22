package com.baidu.searchbox.novel.main.youth.net;

import com.baidu.searchbox.novel.granary.data.source.local.core.NovelSpManager;
import com.baidu.searchbox.novel.main.net.SimpleDataParser;
import com.baidu.searchbox.novel.main.youth.bean.NovelHomePageRecommendData;
import com.baidu.searchbox.novel.main.youth.help.NovelHomePageRecommendDataHelper;
import com.baidu.searchbox.story.net.base.NovelActionDataParser;
import com.baidu.searchbox.story.net.base.NovelBaseTask;
import com.baidu.searchbox.story.net.base.NovelHttpStatSubFromId;
import com.baidu.searchbox.story.net.base.ParamPair;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class NovelHomePageRecommendTask extends NovelBaseTask<NovelHomePageRecommendData> {
    private static final String ACTION_TYPE = "selecttab";
    private final String preLoad;

    public NovelHomePageRecommendTask(String preLoad2) {
        super(getParseData(), false, ACTION_TYPE, NovelHttpStatSubFromId.HTTP_STAT_HOME_PAGE_RECOMMEND);
        this.preLoad = preLoad2;
    }

    /* access modifiers changed from: protected */
    public List<ParamPair<?>> getParamList() {
        List<ParamPair<?>> list = new ArrayList<>(1);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fromValue", "na");
            jsonObject.put("pre_load", this.preLoad);
            jsonObject.put("isYoung", "1");
            list.add(new ParamPair("data", jsonObject.toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return list;
    }

    /* access modifiers changed from: protected */
    public NovelActionDataParser<NovelHomePageRecommendData> getParser() {
        return null;
    }

    private static SimpleDataParser<NovelHomePageRecommendData> getParseData() {
        return new NovelHomePageRecommendTask$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ NovelHomePageRecommendData lambda$getParseData$0(JSONObject data) {
        NovelSpManager spManager;
        if (!(data == null || data.length() <= 0 || (spManager = NovelSpManager.getI(NovelHomePageRecommendDataHelper.SP_HOME_PAGE_RECOMMEND_YOUTH)) == null)) {
            spManager.put("novel_home_page_recommend_data", data.toString());
        }
        return NovelHomePageRecommendData.formJson(data, false);
    }
}
