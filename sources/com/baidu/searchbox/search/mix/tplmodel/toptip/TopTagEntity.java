package com.baidu.searchbox.search.mix.tplmodel.toptip;

import com.baidu.browser.explore.toptip.TopTipConstantKt;
import com.baidu.searchbox.download.center.ui.fusion.manager.decoder.ParseJsonKey;
import com.baidu.searchbox.feed.container.creator.PageParams;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0006\u0001\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010|\u001a\u00020\rJ\u0006\u0010}\u001a\u00020\u0004J\u0010\u0010~\u001a\u0004\u0018\u00010m2\u0006\u0010\u001a\u00020\rJ\n\u0010\u0001\u001a\u00030\u0001H\u0016J\b\u0010\u0001\u001a\u00030\u0001J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u0010\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u001a\u00020\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001c\u0010%\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001e\u0010(\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR\u001e\u0010+\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001c\u00101\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001c\u00104\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\u001a\u00107\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011R\u001c\u0010:\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001c\u0010=\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001e\u0010@\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR\u001c\u0010C\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001c\u0010F\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001c\u0010I\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001c\u0010L\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR.\u0010O\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010Pj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0006\"\u0004\bX\u0010\bR\u001c\u0010Y\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0006\"\u0004\b[\u0010\bR\u001c\u0010\\\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0006\"\u0004\b^\u0010\bR\u001c\u0010_\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0006\"\u0004\ba\u0010\bR\u001c\u0010b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0006\"\u0004\bd\u0010\bR\u001c\u0010e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0006\"\u0004\bg\u0010\bR.\u0010h\u001a\u0016\u0012\u0004\u0012\u00020i\u0018\u00010Pj\n\u0012\u0004\u0012\u00020i\u0018\u0001`QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010S\"\u0004\bk\u0010UR.\u0010l\u001a\u0016\u0012\u0004\u0012\u00020m\u0018\u00010Pj\n\u0012\u0004\u0012\u00020m\u0018\u0001`QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010S\"\u0004\bo\u0010UR \u0010p\u001a\b\u0018\u00010qR\u00020\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001c\u0010v\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0006\"\u0004\bx\u0010\bR\u001c\u0010y\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0006\"\u0004\b{\u0010\b¨\u0006\u0001"}, d2 = {"Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity;", "Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopResultEntity;", "()V", "bgColorEnd", "", "getBgColorEnd", "()Ljava/lang/String;", "setBgColorEnd", "(Ljava/lang/String;)V", "bgColorStart", "getBgColorStart", "setBgColorStart", "bgHeight", "", "getBgHeight", "()I", "setBgHeight", "(I)V", "bgImage", "getBgImage", "setBgImage", "defaultEndBgColor", "getDefaultEndBgColor", "setDefaultEndBgColor", "defaultEndBgColorAlpha", "", "getDefaultEndBgColorAlpha", "()Ljava/lang/Double;", "setDefaultEndBgColorAlpha", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "defaultEndBgColorBlackAlphaAndroid", "getDefaultEndBgColorBlackAlphaAndroid", "setDefaultEndBgColorBlackAlphaAndroid", "defaultEndBgColorBlackAndroid", "getDefaultEndBgColorBlackAndroid", "setDefaultEndBgColorBlackAndroid", "defaultStartBgColor", "getDefaultStartBgColor", "setDefaultStartBgColor", "defaultStartBgColorAlpha", "getDefaultStartBgColorAlpha", "setDefaultStartBgColorAlpha", "defaultStartBgColorBlackAlphaAndroid", "getDefaultStartBgColorBlackAlphaAndroid", "setDefaultStartBgColorBlackAlphaAndroid", "defaultStartBgColorBlackAndroid", "getDefaultStartBgColorBlackAndroid", "setDefaultStartBgColorBlackAndroid", "defaultTxtColor", "getDefaultTxtColor", "setDefaultTxtColor", "defaultTxtColorBlackAndroid", "getDefaultTxtColorBlackAndroid", "setDefaultTxtColorBlackAndroid", "naSrcId", "getNaSrcId", "setNaSrcId", "nightBgColorEnd", "getNightBgColorEnd", "setNightBgColorEnd", "nightBgColorStart", "getNightBgColorStart", "setNightBgColorStart", "rightBgAlpha", "getRightBgAlpha", "setRightBgAlpha", "rightBgColor", "getRightBgColor", "setRightBgColor", "rightIcon", "getRightIcon", "setRightIcon", "rightJumpType", "getRightJumpType", "setRightJumpType", "rightJumpUrl", "getRightJumpUrl", "setRightJumpUrl", "rightSubList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRightSubList", "()Ljava/util/ArrayList;", "setRightSubList", "(Ljava/util/ArrayList;)V", "rightTitle", "getRightTitle", "setRightTitle", "selectEndBgColor", "getSelectEndBgColor", "setSelectEndBgColor", "selectEndBgColorBlackAndroid", "getSelectEndBgColorBlackAndroid", "setSelectEndBgColorBlackAndroid", "selectStartBgColor", "getSelectStartBgColor", "setSelectStartBgColor", "selectStartBgColorBlackAndroid", "getSelectStartBgColorBlackAndroid", "setSelectStartBgColorBlackAndroid", "selectTxtColor", "getSelectTxtColor", "setSelectTxtColor", "subTitleInfos", "Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity$GaokaoSubTitleInfo;", "getSubTitleInfos", "setSubTitleInfos", "tagList", "Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity$TopTagItem;", "getTagList", "setTagList", "timeLineInfo", "Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity$GaokaoTimeLineInfo;", "getTimeLineInfo", "()Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity$GaokaoTimeLineInfo;", "setTimeLineInfo", "(Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity$GaokaoTimeLineInfo;)V", "titleImage", "getTitleImage", "setTitleImage", "topOper", "getTopOper", "setTopOper", "getCurrSelectPos", "getRightContent", "getTagInfo", "pos", "isOk", "", "needShowRightBtn", "parseJson", "", "jsonObject", "Lorg/json/JSONObject;", "parseToJson", "setCurrSelectPos", "GaokaoSubTitleInfo", "GaokaoTimeLineInfo", "TopTagItem", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopTagEntity.kt */
public final class TopTagEntity extends TopResultEntity {
    private String bgColorEnd;
    private String bgColorStart;
    private int bgHeight;
    private String bgImage;
    private String defaultEndBgColor;
    private Double defaultEndBgColorAlpha;
    private Double defaultEndBgColorBlackAlphaAndroid;
    private String defaultEndBgColorBlackAndroid;
    private String defaultStartBgColor;
    private Double defaultStartBgColorAlpha;
    private Double defaultStartBgColorBlackAlphaAndroid;
    private String defaultStartBgColorBlackAndroid;
    private String defaultTxtColor;
    private String defaultTxtColorBlackAndroid;
    private int naSrcId = -1;
    private String nightBgColorEnd;
    private String nightBgColorStart;
    private Double rightBgAlpha;
    private String rightBgColor;
    private String rightIcon;
    private String rightJumpType;
    private String rightJumpUrl;
    private ArrayList<String> rightSubList;
    private String rightTitle;
    private String selectEndBgColor;
    private String selectEndBgColorBlackAndroid;
    private String selectStartBgColor;
    private String selectStartBgColorBlackAndroid;
    private String selectTxtColor;
    private ArrayList<GaokaoSubTitleInfo> subTitleInfos;
    private ArrayList<TopTagItem> tagList;
    private GaokaoTimeLineInfo timeLineInfo;
    private String titleImage;
    private String topOper;

    public TopTagEntity() {
        Double valueOf = Double.valueOf(1.0d);
        this.rightBgAlpha = valueOf;
        this.defaultStartBgColorAlpha = valueOf;
        this.defaultStartBgColorBlackAlphaAndroid = valueOf;
        this.defaultEndBgColorAlpha = valueOf;
        this.defaultEndBgColorBlackAlphaAndroid = valueOf;
    }

    public final String getBgImage() {
        return this.bgImage;
    }

    public final void setBgImage(String str) {
        this.bgImage = str;
    }

    public final int getBgHeight() {
        return this.bgHeight;
    }

    public final void setBgHeight(int i2) {
        this.bgHeight = i2;
    }

    public final String getTitleImage() {
        return this.titleImage;
    }

    public final void setTitleImage(String str) {
        this.titleImage = str;
    }

    public final ArrayList<GaokaoSubTitleInfo> getSubTitleInfos() {
        return this.subTitleInfos;
    }

    public final void setSubTitleInfos(ArrayList<GaokaoSubTitleInfo> arrayList) {
        this.subTitleInfos = arrayList;
    }

    public final String getRightIcon() {
        return this.rightIcon;
    }

    public final void setRightIcon(String str) {
        this.rightIcon = str;
    }

    public final String getRightTitle() {
        return this.rightTitle;
    }

    public final void setRightTitle(String str) {
        this.rightTitle = str;
    }

    public final String getRightJumpUrl() {
        return this.rightJumpUrl;
    }

    public final void setRightJumpUrl(String str) {
        this.rightJumpUrl = str;
    }

    public final String getRightJumpType() {
        return this.rightJumpType;
    }

    public final void setRightJumpType(String str) {
        this.rightJumpType = str;
    }

    public final Double getRightBgAlpha() {
        return this.rightBgAlpha;
    }

    public final void setRightBgAlpha(Double d2) {
        this.rightBgAlpha = d2;
    }

    public final String getRightBgColor() {
        return this.rightBgColor;
    }

    public final void setRightBgColor(String str) {
        this.rightBgColor = str;
    }

    public final String getTopOper() {
        return this.topOper;
    }

    public final void setTopOper(String str) {
        this.topOper = str;
    }

    public final ArrayList<String> getRightSubList() {
        return this.rightSubList;
    }

    public final void setRightSubList(ArrayList<String> arrayList) {
        this.rightSubList = arrayList;
    }

    public final ArrayList<TopTagItem> getTagList() {
        return this.tagList;
    }

    public final void setTagList(ArrayList<TopTagItem> arrayList) {
        this.tagList = arrayList;
    }

    public final String getSelectTxtColor() {
        return this.selectTxtColor;
    }

    public final void setSelectTxtColor(String str) {
        this.selectTxtColor = str;
    }

    public final String getSelectStartBgColor() {
        return this.selectStartBgColor;
    }

    public final void setSelectStartBgColor(String str) {
        this.selectStartBgColor = str;
    }

    public final String getSelectStartBgColorBlackAndroid() {
        return this.selectStartBgColorBlackAndroid;
    }

    public final void setSelectStartBgColorBlackAndroid(String str) {
        this.selectStartBgColorBlackAndroid = str;
    }

    public final String getSelectEndBgColor() {
        return this.selectEndBgColor;
    }

    public final void setSelectEndBgColor(String str) {
        this.selectEndBgColor = str;
    }

    public final String getSelectEndBgColorBlackAndroid() {
        return this.selectEndBgColorBlackAndroid;
    }

    public final void setSelectEndBgColorBlackAndroid(String str) {
        this.selectEndBgColorBlackAndroid = str;
    }

    public final String getDefaultTxtColor() {
        return this.defaultTxtColor;
    }

    public final void setDefaultTxtColor(String str) {
        this.defaultTxtColor = str;
    }

    public final String getDefaultTxtColorBlackAndroid() {
        return this.defaultTxtColorBlackAndroid;
    }

    public final void setDefaultTxtColorBlackAndroid(String str) {
        this.defaultTxtColorBlackAndroid = str;
    }

    public final String getDefaultStartBgColor() {
        return this.defaultStartBgColor;
    }

    public final void setDefaultStartBgColor(String str) {
        this.defaultStartBgColor = str;
    }

    public final String getDefaultStartBgColorBlackAndroid() {
        return this.defaultStartBgColorBlackAndroid;
    }

    public final void setDefaultStartBgColorBlackAndroid(String str) {
        this.defaultStartBgColorBlackAndroid = str;
    }

    public final Double getDefaultStartBgColorAlpha() {
        return this.defaultStartBgColorAlpha;
    }

    public final void setDefaultStartBgColorAlpha(Double d2) {
        this.defaultStartBgColorAlpha = d2;
    }

    public final Double getDefaultStartBgColorBlackAlphaAndroid() {
        return this.defaultStartBgColorBlackAlphaAndroid;
    }

    public final void setDefaultStartBgColorBlackAlphaAndroid(Double d2) {
        this.defaultStartBgColorBlackAlphaAndroid = d2;
    }

    public final String getDefaultEndBgColor() {
        return this.defaultEndBgColor;
    }

    public final void setDefaultEndBgColor(String str) {
        this.defaultEndBgColor = str;
    }

    public final String getDefaultEndBgColorBlackAndroid() {
        return this.defaultEndBgColorBlackAndroid;
    }

    public final void setDefaultEndBgColorBlackAndroid(String str) {
        this.defaultEndBgColorBlackAndroid = str;
    }

    public final Double getDefaultEndBgColorAlpha() {
        return this.defaultEndBgColorAlpha;
    }

    public final void setDefaultEndBgColorAlpha(Double d2) {
        this.defaultEndBgColorAlpha = d2;
    }

    public final Double getDefaultEndBgColorBlackAlphaAndroid() {
        return this.defaultEndBgColorBlackAlphaAndroid;
    }

    public final void setDefaultEndBgColorBlackAlphaAndroid(Double d2) {
        this.defaultEndBgColorBlackAlphaAndroid = d2;
    }

    public final GaokaoTimeLineInfo getTimeLineInfo() {
        return this.timeLineInfo;
    }

    public final void setTimeLineInfo(GaokaoTimeLineInfo gaokaoTimeLineInfo) {
        this.timeLineInfo = gaokaoTimeLineInfo;
    }

    public final String getBgColorStart() {
        return this.bgColorStart;
    }

    public final void setBgColorStart(String str) {
        this.bgColorStart = str;
    }

    public final String getBgColorEnd() {
        return this.bgColorEnd;
    }

    public final void setBgColorEnd(String str) {
        this.bgColorEnd = str;
    }

    public final String getNightBgColorStart() {
        return this.nightBgColorStart;
    }

    public final void setNightBgColorStart(String str) {
        this.nightBgColorStart = str;
    }

    public final String getNightBgColorEnd() {
        return this.nightBgColorEnd;
    }

    public final void setNightBgColorEnd(String str) {
        this.nightBgColorEnd = str;
    }

    public final int getNaSrcId() {
        return this.naSrcId;
    }

    public final void setNaSrcId(int i2) {
        this.naSrcId = i2;
    }

    public JSONObject parseToJson() {
        JSONObject headerJson = new JSONObject();
        JSONArray rightSubListJson = new JSONArray();
        ArrayList<String> $this$forEach$iv = this.rightSubList;
        if ($this$forEach$iv != null) {
            for (String it : $this$forEach$iv) {
                rightSubListJson.put(it);
            }
        }
        JSONObject rightJson = new JSONObject();
        String str = "text";
        rightJson.put("icon", this.rightIcon).put(str, this.rightTitle).put("url_scheme", this.rightJumpUrl).put("url_scheme_type", this.rightJumpType).put("sublist", rightSubListJson).put("bgColor", this.rightBgColor).put("bgColorAlpha", this.rightBgAlpha);
        JSONObject tabInfoJson = new JSONObject();
        JSONArray tagListJson = new JSONArray();
        ArrayList<TopTagItem> $this$forEach$iv2 = this.tagList;
        if ($this$forEach$iv2 != null) {
            for (TopTagItem it2 : $this$forEach$iv2) {
                JSONObject itemJson = new JSONObject();
                itemJson.put(str, it2.getText());
                itemJson.put("timeLine", it2.getTimeLine());
                itemJson.put("url", it2.getUrl());
                itemJson.put("selected", it2.getSelected());
                tagListJson.put(itemJson);
                rightSubListJson = rightSubListJson;
            }
        }
        tabInfoJson.put(ParseJsonKey.GROUP_TAB_LIST, tagListJson);
        tabInfoJson.put("selectTxtColor", this.selectTxtColor);
        tabInfoJson.put("selectStartBgColor", this.selectStartBgColor);
        tabInfoJson.put("selectStartBgColorBlackAndroid", this.selectStartBgColorBlackAndroid);
        tabInfoJson.put("selectEndBgColor", this.selectEndBgColor);
        tabInfoJson.put("selectEndBgColorBlackAndroid", this.selectEndBgColorBlackAndroid);
        tabInfoJson.put("defaultTxtColor", this.defaultTxtColor);
        tabInfoJson.put("defaultTxtColorBlackAndroid", this.defaultTxtColorBlackAndroid);
        tabInfoJson.put("defaultStartBgColor", this.defaultStartBgColor);
        tabInfoJson.put("defaultStartBgColorBlackAndroid", this.defaultStartBgColorBlackAndroid);
        tabInfoJson.put("defaultStartBgColorAlpha", this.defaultStartBgColorAlpha);
        tabInfoJson.put("defaultStartBgColorBlackAlphaAndroid", this.defaultStartBgColorBlackAlphaAndroid);
        tabInfoJson.put("defaultEndBgColor", this.defaultEndBgColor);
        tabInfoJson.put("defaultEndBgColorBlackAndroid", this.defaultEndBgColorBlackAndroid);
        tabInfoJson.put("defaultEndBgColorAlpha", this.defaultEndBgColorAlpha);
        tabInfoJson.put("defaultEndBgColorBlackAlphaAndroid", this.defaultEndBgColorBlackAlphaAndroid);
        JSONObject naInfoJson = new JSONObject();
        naInfoJson.put("bgColorStart", this.bgColorStart).put("bgColorEnd", this.bgColorEnd).put("nightBgColorStart", this.nightBgColorStart).put("nightBgColorEnd", this.nightBgColorEnd).put("top_oper", this.topOper).put("topNAViewHeight", this.bgHeight);
        JSONArray subTitleInfoJson = new JSONArray();
        ArrayList<GaokaoSubTitleInfo> $this$forEach$iv3 = this.subTitleInfos;
        if ($this$forEach$iv3 != null) {
            for (GaokaoSubTitleInfo it3 : $this$forEach$iv3) {
                JSONObject itemJson2 = new JSONObject();
                itemJson2.put(str, it3.getText());
                itemJson2.put("type", it3.getType());
                itemJson2.put("color", it3.getColor());
                subTitleInfoJson.put(itemJson2);
                tagListJson = tagListJson;
                str = str;
            }
        }
        JSONObject timeLineJson = new JSONObject();
        GaokaoTimeLineInfo it4 = this.timeLineInfo;
        if (it4 != null) {
            timeLineJson.put("selectedTab", it4.getSelectedTab()).put("defaultLineColor", it4.getDefaultLineColor()).put("defaultLineColorBlackAndroid", it4.getDefaultLineColorBlackAndroid()).put("selectedLineColor", it4.getSelectedLineColor()).put("selectedLineColorBlackAndroid", it4.getSelectedLineColorBlackAndroid()).put("defaultPointColor", it4.getDefaultPointColor()).put("defaultPointColorBlackAndroid", it4.getDefaultPointColorBlackAndroid()).put("selectedPointColor", it4.getSelectedPointColor()).put("selectedPointColorBlackAndroid", it4.getSelectedPointColorBlackAndroid());
        }
        headerJson.put("bgImage", this.bgImage).put("titleImage", this.titleImage).put("subTitles", subTitleInfoJson).put("jumpInfo", rightJson).put(PageParams.KEY_TAB_INFO, tabInfoJson).put("naInfo", naInfoJson).put("timeLine", timeLineJson).put("naSrcID", this.naSrcId);
        JSONObject dataJson = new JSONObject();
        dataJson.put("headerConf", headerJson);
        JSONObject jsonObject = super.parseToJson().put(TopTipConstantKt.DATA_JSON, dataJson);
        Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
        return jsonObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01e6, code lost:
        if (r4.optBoolean("selected") == true) goto L_0x01ec;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseJson(org.json.JSONObject r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            super.parseJson(r19)
            java.lang.String r2 = "dataJson"
            org.json.JSONObject r2 = r1.optJSONObject(r2)
            if (r2 == 0) goto L_0x001c
            java.lang.String r4 = "headerConf"
            org.json.JSONObject r2 = r2.optJSONObject(r4)
            goto L_0x001d
        L_0x001c:
            r2 = 0
        L_0x001d:
            if (r2 == 0) goto L_0x0026
            java.lang.String r4 = "bgImage"
            java.lang.String r4 = r2.optString(r4)
            goto L_0x0027
        L_0x0026:
            r4 = 0
        L_0x0027:
            r0.bgImage = r4
            r4 = -1
            if (r2 == 0) goto L_0x0034
            java.lang.String r5 = "naSrcID"
            int r5 = r2.optInt(r5, r4)
            goto L_0x0035
        L_0x0034:
            r5 = r4
        L_0x0035:
            r0.naSrcId = r5
            if (r2 == 0) goto L_0x0041
            java.lang.String r5 = "titleImage"
            java.lang.String r5 = r2.optString(r5)
            goto L_0x0042
        L_0x0041:
            r5 = 0
        L_0x0042:
            r0.titleImage = r5
            if (r2 == 0) goto L_0x004e
            java.lang.String r5 = "subTitles"
            org.json.JSONArray r5 = r2.optJSONArray(r5)
            goto L_0x004f
        L_0x004e:
            r5 = 0
        L_0x004f:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r0.subTitleInfos = r6
            java.lang.String r6 = "text"
            if (r5 == 0) goto L_0x009f
            r7 = r5
            r8 = 0
            r9 = 0
            int r10 = r5.length()
        L_0x0062:
            if (r9 >= r10) goto L_0x009d
            org.json.JSONObject r11 = r5.optJSONObject(r9)
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoSubTitleInfo r12 = new com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoSubTitleInfo
            r12.<init>()
            if (r11 == 0) goto L_0x0074
            java.lang.String r13 = r11.optString(r6)
            goto L_0x0075
        L_0x0074:
            r13 = 0
        L_0x0075:
            r12.setText(r13)
            if (r11 == 0) goto L_0x0082
            java.lang.String r13 = "type"
            java.lang.String r13 = r11.optString(r13)
            goto L_0x0083
        L_0x0082:
            r13 = 0
        L_0x0083:
            r12.setType(r13)
            if (r11 == 0) goto L_0x008f
            java.lang.String r13 = "color"
            java.lang.String r13 = r11.optString(r13)
            goto L_0x0090
        L_0x008f:
            r13 = 0
        L_0x0090:
            r12.setColor(r13)
            java.util.ArrayList<com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoSubTitleInfo> r13 = r0.subTitleInfos
            if (r13 == 0) goto L_0x009a
            r13.add(r12)
        L_0x009a:
            int r9 = r9 + 1
            goto L_0x0062
        L_0x009d:
        L_0x009f:
            if (r2 == 0) goto L_0x00a9
            java.lang.String r7 = "naInfo"
            org.json.JSONObject r7 = r2.optJSONObject(r7)
            goto L_0x00aa
        L_0x00a9:
            r7 = 0
        L_0x00aa:
            if (r7 == 0) goto L_0x00b3
            java.lang.String r8 = "bgColorStart"
            java.lang.String r8 = r7.optString(r8)
            goto L_0x00b4
        L_0x00b3:
            r8 = 0
        L_0x00b4:
            r0.bgColorStart = r8
            if (r7 == 0) goto L_0x00bf
            java.lang.String r8 = "bgColorEnd"
            java.lang.String r8 = r7.optString(r8)
            goto L_0x00c0
        L_0x00bf:
            r8 = 0
        L_0x00c0:
            r0.bgColorEnd = r8
            if (r7 == 0) goto L_0x00cc
            java.lang.String r8 = "nightBgColorStart"
            java.lang.String r8 = r7.optString(r8)
            goto L_0x00cd
        L_0x00cc:
            r8 = 0
        L_0x00cd:
            r0.nightBgColorStart = r8
            if (r7 == 0) goto L_0x00d9
            java.lang.String r8 = "nightBgColorEnd"
            java.lang.String r8 = r7.optString(r8)
            goto L_0x00da
        L_0x00d9:
            r8 = 0
        L_0x00da:
            r0.nightBgColorEnd = r8
            if (r7 == 0) goto L_0x00e6
            java.lang.String r8 = "top_oper"
            java.lang.String r8 = r7.optString(r8)
            goto L_0x00e7
        L_0x00e6:
            r8 = 0
        L_0x00e7:
            r0.topOper = r8
            if (r7 == 0) goto L_0x00f3
            java.lang.String r9 = "topNAViewHeight"
            int r9 = r7.optInt(r9)
            goto L_0x00f4
        L_0x00f3:
            r9 = 0
        L_0x00f4:
            r0.bgHeight = r9
            if (r2 == 0) goto L_0x0100
            java.lang.String r9 = "jumpInfo"
            org.json.JSONObject r9 = r2.optJSONObject(r9)
            goto L_0x0101
        L_0x0100:
            r9 = 0
        L_0x0101:
            if (r9 == 0) goto L_0x010a
            java.lang.String r10 = "icon"
            java.lang.String r10 = r9.optString(r10)
            goto L_0x010b
        L_0x010a:
            r10 = 0
        L_0x010b:
            r0.rightIcon = r10
            if (r9 == 0) goto L_0x0114
            java.lang.String r10 = r9.optString(r6)
            goto L_0x0115
        L_0x0114:
            r10 = 0
        L_0x0115:
            r0.rightTitle = r10
            if (r9 == 0) goto L_0x0121
            java.lang.String r10 = "url_scheme"
            java.lang.String r10 = r9.optString(r10)
            goto L_0x0122
        L_0x0121:
            r10 = 0
        L_0x0122:
            r0.rightJumpUrl = r10
            if (r9 == 0) goto L_0x012e
            java.lang.String r10 = "url_scheme_type"
            java.lang.String r10 = r9.optString(r10)
            goto L_0x012f
        L_0x012e:
            r10 = 0
        L_0x012f:
            r0.rightJumpType = r10
            if (r9 == 0) goto L_0x013a
            java.lang.String r10 = "bgColor"
            java.lang.String r10 = r9.optString(r10)
            goto L_0x013b
        L_0x013a:
            r10 = 0
        L_0x013b:
            r0.rightBgColor = r10
            if (r9 == 0) goto L_0x014a
            java.lang.String r10 = "bgColorAlpha"
            double r10 = r9.optDouble(r10)
            java.lang.Double r10 = java.lang.Double.valueOf(r10)
            goto L_0x014b
        L_0x014a:
            r10 = 0
        L_0x014b:
            r0.rightBgAlpha = r10
            if (r9 == 0) goto L_0x0157
            java.lang.String r10 = "sublist"
            org.json.JSONArray r10 = r9.optJSONArray(r10)
            goto L_0x0158
        L_0x0157:
            r10 = 0
        L_0x0158:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r0.rightSubList = r11
            if (r10 == 0) goto L_0x017a
            r11 = r10
            r12 = 0
            r13 = 0
            int r14 = r10.length()
        L_0x0168:
            if (r13 >= r14) goto L_0x0178
            java.util.ArrayList<java.lang.String> r15 = r0.rightSubList
            if (r15 == 0) goto L_0x0175
            java.lang.String r3 = r10.optString(r13)
            r15.add(r3)
        L_0x0175:
            int r13 = r13 + 1
            goto L_0x0168
        L_0x0178:
        L_0x017a:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r0.tagList = r3
            if (r2 == 0) goto L_0x018b
            java.lang.String r3 = "tabInfo"
            org.json.JSONObject r3 = r2.optJSONObject(r3)
            goto L_0x018c
        L_0x018b:
            r3 = 0
        L_0x018c:
            if (r3 == 0) goto L_0x0196
            java.lang.String r11 = "tabList"
            org.json.JSONArray r11 = r3.optJSONArray(r11)
            goto L_0x0197
        L_0x0196:
            r11 = 0
        L_0x0197:
            java.lang.String r12 = "timeLine"
            if (r11 == 0) goto L_0x0204
            r13 = r11
            r14 = 0
            r15 = 0
            int r8 = r11.length()
        L_0x01a3:
            if (r15 >= r8) goto L_0x0200
            org.json.JSONObject r4 = r11.optJSONObject(r15)
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$TopTagItem r16 = new com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$TopTagItem
            r16.<init>()
            r17 = r16
            if (r4 == 0) goto L_0x01b9
            java.lang.String r16 = r4.optString(r6)
            r1 = r16
            goto L_0x01ba
        L_0x01b9:
            r1 = 0
        L_0x01ba:
            r16 = r5
            r5 = r17
            r5.setText(r1)
            if (r4 == 0) goto L_0x01c8
            java.lang.String r1 = r4.optString(r12)
            goto L_0x01c9
        L_0x01c8:
            r1 = 0
        L_0x01c9:
            r5.setTimeLine(r1)
            if (r4 == 0) goto L_0x01d6
            java.lang.String r1 = "url"
            java.lang.String r1 = r4.optString(r1)
            goto L_0x01d7
        L_0x01d6:
            r1 = 0
        L_0x01d7:
            r5.setUrl(r1)
            r1 = 1
            if (r4 == 0) goto L_0x01e9
            r17 = r6
            java.lang.String r6 = "selected"
            boolean r6 = r4.optBoolean(r6)
            if (r6 != r1) goto L_0x01eb
            goto L_0x01ec
        L_0x01e9:
            r17 = r6
        L_0x01eb:
            r1 = 0
        L_0x01ec:
            r5.setSelected(r1)
            java.util.ArrayList<com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$TopTagItem> r1 = r0.tagList
            if (r1 == 0) goto L_0x01f6
            r1.add(r5)
        L_0x01f6:
            int r15 = r15 + 1
            r1 = r19
            r5 = r16
            r6 = r17
            r4 = -1
            goto L_0x01a3
        L_0x0200:
            r16 = r5
            goto L_0x0206
        L_0x0204:
            r16 = r5
        L_0x0206:
            if (r3 == 0) goto L_0x0211
            java.lang.String r1 = "selectTxtColor"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x0212
        L_0x0211:
            r1 = 0
        L_0x0212:
            r0.selectTxtColor = r1
            if (r3 == 0) goto L_0x021e
            java.lang.String r1 = "selectStartBgColor"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x021f
        L_0x021e:
            r1 = 0
        L_0x021f:
            r0.selectStartBgColor = r1
            if (r3 == 0) goto L_0x022b
            java.lang.String r1 = "selectStartBgColorBlackAndroid"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x022c
        L_0x022b:
            r1 = 0
        L_0x022c:
            r0.selectStartBgColorBlackAndroid = r1
            if (r3 == 0) goto L_0x0238
            java.lang.String r1 = "selectEndBgColor"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x0239
        L_0x0238:
            r1 = 0
        L_0x0239:
            r0.selectEndBgColor = r1
            if (r3 == 0) goto L_0x0245
            java.lang.String r1 = "selectEndBgColorBlackAndroid"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x0246
        L_0x0245:
            r1 = 0
        L_0x0246:
            r0.selectEndBgColorBlackAndroid = r1
            if (r3 == 0) goto L_0x0251
            java.lang.String r1 = "defaultTxtColor"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x0252
        L_0x0251:
            r1 = 0
        L_0x0252:
            r0.defaultTxtColor = r1
            if (r3 == 0) goto L_0x025d
            java.lang.String r1 = "defaultTxtColorBlackAndroid"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x025e
        L_0x025d:
            r1 = 0
        L_0x025e:
            r0.defaultTxtColorBlackAndroid = r1
            if (r3 == 0) goto L_0x0269
            java.lang.String r1 = "defaultStartBgColor"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x026a
        L_0x0269:
            r1 = 0
        L_0x026a:
            r0.defaultStartBgColor = r1
            if (r3 == 0) goto L_0x0275
            java.lang.String r1 = "defaultStartBgColorBlackAndroid"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x0276
        L_0x0275:
            r1 = 0
        L_0x0276:
            r0.defaultStartBgColorBlackAndroid = r1
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r3 == 0) goto L_0x0287
            java.lang.String r1 = "defaultStartBgColorAlpha"
            double r13 = r3.optDouble(r1, r4)
            java.lang.Double r1 = java.lang.Double.valueOf(r13)
            goto L_0x0288
        L_0x0287:
            r1 = 0
        L_0x0288:
            r0.defaultStartBgColorAlpha = r1
            if (r3 == 0) goto L_0x0297
            java.lang.String r1 = "defaultStartBgColorBlackAlphaAndroid"
            double r13 = r3.optDouble(r1, r4)
            java.lang.Double r1 = java.lang.Double.valueOf(r13)
            goto L_0x0298
        L_0x0297:
            r1 = 0
        L_0x0298:
            r0.defaultStartBgColorBlackAlphaAndroid = r1
            if (r3 == 0) goto L_0x02a3
            java.lang.String r1 = "defaultEndBgColor"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x02a4
        L_0x02a3:
            r1 = 0
        L_0x02a4:
            r0.defaultEndBgColor = r1
            if (r3 == 0) goto L_0x02af
            java.lang.String r1 = "defaultEndBgColorBlackAndroid"
            java.lang.String r1 = r3.optString(r1)
            goto L_0x02b0
        L_0x02af:
            r1 = 0
        L_0x02b0:
            r0.defaultEndBgColorBlackAndroid = r1
            if (r3 == 0) goto L_0x02bf
            java.lang.String r1 = "defaultEndBgColorAlpha"
            double r13 = r3.optDouble(r1, r4)
            java.lang.Double r1 = java.lang.Double.valueOf(r13)
            goto L_0x02c0
        L_0x02bf:
            r1 = 0
        L_0x02c0:
            r0.defaultEndBgColorAlpha = r1
            if (r3 == 0) goto L_0x02cf
            java.lang.String r1 = "defaultEndBgColorBlackAlphaAndroid"
            double r4 = r3.optDouble(r1, r4)
            java.lang.Double r1 = java.lang.Double.valueOf(r4)
            goto L_0x02d0
        L_0x02cf:
            r1 = 0
        L_0x02d0:
            r0.defaultEndBgColorBlackAlphaAndroid = r1
            if (r2 == 0) goto L_0x02d9
            org.json.JSONObject r1 = r2.optJSONObject(r12)
            goto L_0x02da
        L_0x02d9:
            r1 = 0
        L_0x02da:
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo r4 = new com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo
            r4.<init>()
            r0.timeLineInfo = r4
            if (r1 == 0) goto L_0x02ec
            java.lang.String r5 = "selectedTab"
            r6 = -1
            int r5 = r1.optInt(r5, r6)
            goto L_0x02ee
        L_0x02ec:
            r6 = -1
            r5 = r6
        L_0x02ee:
            r4.setSelectedTab(r5)
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo r4 = r0.timeLineInfo
            if (r4 != 0) goto L_0x02f6
            goto L_0x0303
        L_0x02f6:
            if (r1 == 0) goto L_0x02ff
            java.lang.String r5 = "defaultLineColor"
            java.lang.String r5 = r1.optString(r5)
            goto L_0x0300
        L_0x02ff:
            r5 = 0
        L_0x0300:
            r4.setDefaultLineColor(r5)
        L_0x0303:
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo r4 = r0.timeLineInfo
            if (r4 != 0) goto L_0x0308
            goto L_0x0315
        L_0x0308:
            if (r1 == 0) goto L_0x0311
            java.lang.String r5 = "defaultLineColorBlackAndroid"
            java.lang.String r5 = r1.optString(r5)
            goto L_0x0312
        L_0x0311:
            r5 = 0
        L_0x0312:
            r4.setDefaultLineColorBlackAndroid(r5)
        L_0x0315:
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo r4 = r0.timeLineInfo
            if (r4 != 0) goto L_0x031a
            goto L_0x0328
        L_0x031a:
            if (r1 == 0) goto L_0x0324
            java.lang.String r5 = "selectedLineColor"
            java.lang.String r5 = r1.optString(r5)
            goto L_0x0325
        L_0x0324:
            r5 = 0
        L_0x0325:
            r4.setSelectedLineColor(r5)
        L_0x0328:
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo r4 = r0.timeLineInfo
            if (r4 != 0) goto L_0x032d
            goto L_0x033b
        L_0x032d:
            if (r1 == 0) goto L_0x0337
            java.lang.String r5 = "selectedLineColorBlackAndroid"
            java.lang.String r5 = r1.optString(r5)
            goto L_0x0338
        L_0x0337:
            r5 = 0
        L_0x0338:
            r4.setSelectedLineColorBlackAndroid(r5)
        L_0x033b:
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo r4 = r0.timeLineInfo
            if (r4 != 0) goto L_0x0340
            goto L_0x034d
        L_0x0340:
            if (r1 == 0) goto L_0x0349
            java.lang.String r5 = "defaultPointColor"
            java.lang.String r5 = r1.optString(r5)
            goto L_0x034a
        L_0x0349:
            r5 = 0
        L_0x034a:
            r4.setDefaultPointColor(r5)
        L_0x034d:
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo r4 = r0.timeLineInfo
            if (r4 != 0) goto L_0x0352
            goto L_0x035f
        L_0x0352:
            if (r1 == 0) goto L_0x035b
            java.lang.String r5 = "defaultPointColorBlackAndroid"
            java.lang.String r5 = r1.optString(r5)
            goto L_0x035c
        L_0x035b:
            r5 = 0
        L_0x035c:
            r4.setDefaultPointColorBlackAndroid(r5)
        L_0x035f:
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo r4 = r0.timeLineInfo
            if (r4 != 0) goto L_0x0364
            goto L_0x0372
        L_0x0364:
            if (r1 == 0) goto L_0x036e
            java.lang.String r5 = "selectedPointColor"
            java.lang.String r5 = r1.optString(r5)
            goto L_0x036f
        L_0x036e:
            r5 = 0
        L_0x036f:
            r4.setSelectedPointColor(r5)
        L_0x0372:
            com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity$GaokaoTimeLineInfo r4 = r0.timeLineInfo
            if (r4 != 0) goto L_0x0377
            goto L_0x0385
        L_0x0377:
            if (r1 == 0) goto L_0x0381
            java.lang.String r5 = "selectedPointColorBlackAndroid"
            java.lang.String r5 = r1.optString(r5)
            goto L_0x0382
        L_0x0381:
            r5 = 0
        L_0x0382:
            r4.setSelectedPointColorBlackAndroid(r5)
        L_0x0385:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.mix.tplmodel.toptip.TopTagEntity.parseJson(org.json.JSONObject):void");
    }

    public boolean isOk() {
        return this.bgHeight > 0;
    }

    public final TopTagItem getTagInfo(int pos) {
        ArrayList<TopTagItem> arrayList;
        ArrayList<TopTagItem> arrayList2 = this.tagList;
        if ((arrayList2 != null ? arrayList2.size() : 0) <= pos || (arrayList = this.tagList) == null) {
            return null;
        }
        return arrayList.get(pos);
    }

    public final String getRightContent() {
        String str = "";
        ArrayList<String> $this$forEach$iv = this.rightSubList;
        if ($this$forEach$iv != null) {
            for (String it : $this$forEach$iv) {
                str = str + it + ' ';
            }
        }
        return StringsKt.trim((CharSequence) str).toString();
    }

    public final int getCurrSelectPos() {
        TopTagItem topTagItem;
        ArrayList<TopTagItem> arrayList = this.tagList;
        int size = arrayList != null ? arrayList.size() : 0;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<TopTagItem> arrayList2 = this.tagList;
            boolean z = true;
            if (arrayList2 == null || (topTagItem = arrayList2.get(i2)) == null || !topTagItem.getSelected()) {
                z = false;
            }
            if (z) {
                return i2;
            }
        }
        return 0;
    }

    public final void setCurrSelectPos(int pos) {
        int i2 = 0;
        ArrayList<TopTagItem> arrayList = this.tagList;
        int size = arrayList != null ? arrayList.size() : 0;
        while (i2 < size) {
            ArrayList<TopTagItem> arrayList2 = this.tagList;
            TopTagItem topTagItem = arrayList2 != null ? arrayList2.get(i2) : null;
            if (topTagItem != null) {
                topTagItem.setSelected(i2 == pos);
            }
            i2++;
        }
    }

    public final boolean needShowRightBtn() {
        CharSequence charSequence = this.rightTitle;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        Collection collection = this.rightSubList;
        return !(collection == null || collection.isEmpty());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity$TopTagItem;", "", "()V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "timeLine", "getTimeLine", "setTimeLine", "url", "getUrl", "setUrl", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TopTagEntity.kt */
    public static final class TopTagItem {
        private boolean selected;
        private String text;
        private String timeLine;
        private String url;

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            this.text = str;
        }

        public final String getTimeLine() {
            return this.timeLine;
        }

        public final void setTimeLine(String str) {
            this.timeLine = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final boolean getSelected() {
            return this.selected;
        }

        public final void setSelected(boolean z) {
            this.selected = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity$GaokaoSubTitleInfo;", "", "()V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "text", "getText", "setText", "type", "getType", "setType", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TopTagEntity.kt */
    public static final class GaokaoSubTitleInfo {
        private String color;
        private String text;
        private String type;

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            this.text = str;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            this.type = str;
        }

        public final String getColor() {
            return this.color;
        }

        public final void setColor(String str) {
            this.color = str;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity$GaokaoTimeLineInfo;", "", "(Lcom/baidu/searchbox/search/mix/tplmodel/toptip/TopTagEntity;)V", "defaultLineColor", "", "getDefaultLineColor", "()Ljava/lang/String;", "setDefaultLineColor", "(Ljava/lang/String;)V", "defaultLineColorBlackAndroid", "getDefaultLineColorBlackAndroid", "setDefaultLineColorBlackAndroid", "defaultPointColor", "getDefaultPointColor", "setDefaultPointColor", "defaultPointColorBlackAndroid", "getDefaultPointColorBlackAndroid", "setDefaultPointColorBlackAndroid", "selectedLineColor", "getSelectedLineColor", "setSelectedLineColor", "selectedLineColorBlackAndroid", "getSelectedLineColorBlackAndroid", "setSelectedLineColorBlackAndroid", "selectedPointColor", "getSelectedPointColor", "setSelectedPointColor", "selectedPointColorBlackAndroid", "getSelectedPointColorBlackAndroid", "setSelectedPointColorBlackAndroid", "selectedTab", "", "getSelectedTab", "()I", "setSelectedTab", "(I)V", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TopTagEntity.kt */
    public final class GaokaoTimeLineInfo {
        private String defaultLineColor;
        private String defaultLineColorBlackAndroid;
        private String defaultPointColor;
        private String defaultPointColorBlackAndroid;
        private String selectedLineColor;
        private String selectedLineColorBlackAndroid;
        private String selectedPointColor;
        private String selectedPointColorBlackAndroid;
        private int selectedTab = -1;

        public GaokaoTimeLineInfo() {
        }

        public final int getSelectedTab() {
            return this.selectedTab;
        }

        public final void setSelectedTab(int i2) {
            this.selectedTab = i2;
        }

        public final String getDefaultLineColor() {
            return this.defaultLineColor;
        }

        public final void setDefaultLineColor(String str) {
            this.defaultLineColor = str;
        }

        public final String getDefaultLineColorBlackAndroid() {
            return this.defaultLineColorBlackAndroid;
        }

        public final void setDefaultLineColorBlackAndroid(String str) {
            this.defaultLineColorBlackAndroid = str;
        }

        public final String getSelectedLineColor() {
            return this.selectedLineColor;
        }

        public final void setSelectedLineColor(String str) {
            this.selectedLineColor = str;
        }

        public final String getSelectedLineColorBlackAndroid() {
            return this.selectedLineColorBlackAndroid;
        }

        public final void setSelectedLineColorBlackAndroid(String str) {
            this.selectedLineColorBlackAndroid = str;
        }

        public final String getDefaultPointColor() {
            return this.defaultPointColor;
        }

        public final void setDefaultPointColor(String str) {
            this.defaultPointColor = str;
        }

        public final String getDefaultPointColorBlackAndroid() {
            return this.defaultPointColorBlackAndroid;
        }

        public final void setDefaultPointColorBlackAndroid(String str) {
            this.defaultPointColorBlackAndroid = str;
        }

        public final String getSelectedPointColor() {
            return this.selectedPointColor;
        }

        public final void setSelectedPointColor(String str) {
            this.selectedPointColor = str;
        }

        public final String getSelectedPointColorBlackAndroid() {
            return this.selectedPointColorBlackAndroid;
        }

        public final void setSelectedPointColorBlackAndroid(String str) {
            this.selectedPointColorBlackAndroid = str;
        }
    }
}
