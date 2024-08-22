package com.baidu.searchbox.novel.main.homepage.bean;

import com.baidu.searchbox.novel.common.utils.NovelPadUtilsWrapper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NovelHomePageRecommendData extends NovelHomePageRecommendBaseData {
    private static final String TYPE_DOUBLE_ROW_PUSH_BOOK = "doubleRowPushBook";
    private static final String TYPE_GUESS_LIKE = "guessLikeTopic";
    private static final String TYPE_HOT_SEARCH = "hotSearchWordAggregation";
    private static final String TYPE_HOT_TALK = "hotTopics";
    private static final String TYPE_INFORMATION_FLOW = "informationFlow";
    private static final String TYPE_LIMIT_WELFARE = "sevenDayLimitWelfare";
    private static final String TYPE_LIMIT_WELFARE_POP = "sevenDayLimitWelfarePop";
    private static final String TYPE_NEW_USER = "newUserbookRecommend";
    private static final String TYPE_RANKING = "feedtabRankTab";
    private static final String TYPE_RECOMMEND_BANNER = "swipeDayNight";
    private static final String TYPE_SIGN_IN = "bookRecommend";
    private static final String TYPE_SIGN_IN_LIST = "multiBookRecommend";
    private List<NovelHomePageRecommendBaseData> dataList;
    private String guessLikeModuleId;
    private String pageId;
    private JSONObject refreshParam;
    private JSONObject welfarePopJson;

    public int getType() {
        return -1;
    }

    public List<NovelHomePageRecommendBaseData> getDataList() {
        return this.dataList;
    }

    public void addData(NovelHomePageRecommendBaseData data) {
        if (this.dataList == null) {
            this.dataList = new ArrayList();
        }
        this.dataList.add(data);
    }

    public void addData(List<NovelHomePageRecommendBaseData> data) {
        if (this.dataList == null) {
            this.dataList = new ArrayList();
        }
        int position = this.dataList.size();
        if (lastIsLoadMore()) {
            position--;
        }
        this.dataList.addAll(position, data);
    }

    public JSONObject getWelfarePopJson() {
        return this.welfarePopJson;
    }

    public void setWelfarePopJson(JSONObject welfarePopJson2) {
        this.welfarePopJson = welfarePopJson2;
    }

    public NovelHomePageRecommendBaseData getData(int position) {
        List<NovelHomePageRecommendBaseData> list = this.dataList;
        if (list == null || position >= list.size() || position < 0) {
            return null;
        }
        return this.dataList.get(position);
    }

    public int getDataSize() {
        List<NovelHomePageRecommendBaseData> list = this.dataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public JSONObject getRefreshParam() {
        return this.refreshParam;
    }

    public void setRefreshParam(JSONObject refreshParam2) {
        this.refreshParam = refreshParam2;
    }

    public boolean lastIsLoadMore() {
        int size;
        List<NovelHomePageRecommendBaseData> list = this.dataList;
        if (list != null && (size = list.size()) > 0) {
            return this.dataList.get(size - 1) instanceof NovelHomePageRecommendFooterData;
        }
        return false;
    }

    public static NovelHomePageRecommendData formJson(JSONObject data) {
        return formJson(data, true);
    }

    public static NovelHomePageRecommendData formJson(JSONObject data, boolean isFromCache) {
        NovelHomePageRecommendBaseData guessData;
        JSONObject welfarePopBean;
        if (data == null) {
            return null;
        }
        NovelHomePageRecommendData recommendData = new NovelHomePageRecommendData();
        JSONArray array = data.optJSONArray("novel");
        JSONObject refreshParam2 = data.optJSONObject("refreshParam");
        if (refreshParam2 != null) {
            recommendData.setRefreshParam(refreshParam2);
        }
        JSONObject sevenDayLimitWelfarePopObj = data.optJSONObject(TYPE_LIMIT_WELFARE_POP);
        if (!(sevenDayLimitWelfarePopObj == null || isFromCache || (welfarePopBean = NovelHomePageRecommendLimitedWelfarePopData.fromJson(sevenDayLimitWelfarePopObj)) == null)) {
            recommendData.setWelfarePopJson(welfarePopBean);
        }
        recommendData.setPageId(data.optString("page_id"));
        if (array != null && array.length() > 0) {
            int length = array.length();
            for (int index = 0; index < length; index++) {
                JSONObject jsonObject = array.optJSONObject(index);
                if (jsonObject != null) {
                    NovelHomePageRecommendBaseData itemData = null;
                    List<NovelHomePageRecommendBaseData> itemDataList = null;
                    String type = jsonObject.optString("type");
                    char c2 = 65535;
                    switch (type.hashCode()) {
                        case -1968093085:
                            if (type.equals(TYPE_HOT_SEARCH)) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case -1956017518:
                            if (type.equals(TYPE_RANKING)) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -1620993226:
                            if (type.equals(TYPE_RECOMMEND_BANNER)) {
                                c2 = 10;
                                break;
                            }
                            break;
                        case -1463909824:
                            if (type.equals(TYPE_LIMIT_WELFARE)) {
                                c2 = 8;
                                break;
                            }
                            break;
                        case -731239471:
                            if (type.equals(TYPE_HOT_TALK)) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case -134027327:
                            if (type.equals(TYPE_GUESS_LIKE)) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 7547859:
                            if (type.equals(TYPE_SIGN_IN)) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 826805288:
                            if (type.equals(TYPE_NEW_USER)) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1153403674:
                            if (type.equals(TYPE_SIGN_IN_LIST)) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1302426746:
                            if (type.equals(TYPE_INFORMATION_FLOW)) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case 2008822924:
                            if (type.equals(TYPE_DOUBLE_ROW_PUSH_BOOK)) {
                                c2 = 9;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            itemData = NovelHomePageRecommendNewUserData.fromJson(jsonObject);
                            break;
                        case 1:
                            itemData = NovelHomePageRecommendSignInData.fromJson(jsonObject);
                            break;
                        case 2:
                            if (!NovelPadUtilsWrapper.isTabletDevice()) {
                                itemData = NovelHomePageMultiRecommendSignInData.fromJson(jsonObject);
                                break;
                            } else {
                                itemData = null;
                                break;
                            }
                        case 3:
                            itemData = NovelHomePageRecommendRankingData.fromJson(jsonObject);
                            break;
                        case 4:
                            itemData = NovelHomePageRecommendHotTalkData.fromJson(jsonObject);
                            break;
                        case 5:
                            itemData = NovelHomePageRecommendHotSearchData.fromJson(jsonObject);
                            break;
                        case 6:
                            itemDataList = NovelHomePageRecommendGuessLikeData.fromJson(jsonObject);
                            if (itemDataList != null && !itemDataList.isEmpty() && (guessData = itemDataList.get(0)) != null && (guessData instanceof NovelHomePageRecommendGuessLikeData)) {
                                recommendData.setGuessLikeModuleId(((NovelHomePageRecommendGuessLikeData) guessData).getModuleId());
                                break;
                            }
                        case 7:
                            itemData = NovelHomePageRecommendInformationFlowData.fromJson(jsonObject);
                            break;
                        case 8:
                            itemData = NovelHomePageRecommendLimitedWelfareData.fromJson(jsonObject);
                            break;
                        case 9:
                            itemData = NovelHomePageRecommendPushBookData.parseJson(jsonObject);
                            break;
                        case 10:
                            itemData = NovelHomePageRecommendBannerData.parseJson(jsonObject);
                            break;
                    }
                    if (itemData != null) {
                        recommendData.addData(itemData);
                    }
                    if (itemDataList != null) {
                        recommendData.addData(itemDataList);
                    }
                }
            }
        }
        return recommendData;
    }

    public String getGuessLikeModuleId() {
        return this.guessLikeModuleId;
    }

    public void setGuessLikeModuleId(String guessLikeModuleId2) {
        this.guessLikeModuleId = guessLikeModuleId2;
    }

    public String getPageId() {
        return this.pageId;
    }

    public void setPageId(String pageId2) {
        this.pageId = pageId2;
    }
}
