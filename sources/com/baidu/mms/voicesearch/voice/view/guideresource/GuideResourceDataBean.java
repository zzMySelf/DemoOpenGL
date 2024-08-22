package com.baidu.mms.voicesearch.voice.view.guideresource;

import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.guidewordsview.horizontalview.GuideWordsBean;
import com.baidu.mms.voicesearch.voice.bean.dao.AssistantSugBean;
import com.baidu.searchbox.hissug.data.model.SearchHistory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/guideresource/GuideResourceDataBean;", "", "()V", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "canDisplay", "", "getCanDisplay", "()Z", "setCanDisplay", "(Z)V", "commandUrl", "getCommandUrl", "setCommandUrl", "historyItem", "Lcom/baidu/searchbox/hissug/data/model/SearchHistory;", "getHistoryItem", "()Lcom/baidu/searchbox/hissug/data/model/SearchHistory;", "setHistoryItem", "(Lcom/baidu/searchbox/hissug/data/model/SearchHistory;)V", "iconUrl", "getIconUrl", "setIconUrl", "sugItem", "Lcom/baidu/mms/voicesearch/voice/bean/dao/AssistantSugBean$SugItemBean;", "getSugItem", "()Lcom/baidu/mms/voicesearch/voice/bean/dao/AssistantSugBean$SugItemBean;", "setSugItem", "(Lcom/baidu/mms/voicesearch/voice/bean/dao/AssistantSugBean$SugItemBean;)V", "title", "getTitle", "setTitle", "type", "", "getType", "()I", "setType", "(I)V", "wordsItem", "Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/guidewordsview/horizontalview/GuideWordsBean$WordsItemBean;", "getWordsItem", "()Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/guidewordsview/horizontalview/GuideWordsBean$WordsItemBean;", "setWordsItem", "(Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/guidewordsview/horizontalview/GuideWordsBean$WordsItemBean;)V", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuideResourceDataBean.kt */
public final class GuideResourceDataBean {
    private String bgColor;
    private boolean canDisplay = true;
    private String commandUrl;
    private SearchHistory historyItem;
    private String iconUrl;
    private AssistantSugBean.SugItemBean sugItem;
    private String title;
    private int type = -1;
    private GuideWordsBean.WordsItemBean wordsItem;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(String str) {
        this.bgColor = str;
    }

    public final String getCommandUrl() {
        return this.commandUrl;
    }

    public final void setCommandUrl(String str) {
        this.commandUrl = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    public final SearchHistory getHistoryItem() {
        return this.historyItem;
    }

    public final void setHistoryItem(SearchHistory searchHistory) {
        this.historyItem = searchHistory;
    }

    public final GuideWordsBean.WordsItemBean getWordsItem() {
        return this.wordsItem;
    }

    public final void setWordsItem(GuideWordsBean.WordsItemBean wordsItemBean) {
        this.wordsItem = wordsItemBean;
    }

    public final AssistantSugBean.SugItemBean getSugItem() {
        return this.sugItem;
    }

    public final void setSugItem(AssistantSugBean.SugItemBean sugItemBean) {
        this.sugItem = sugItemBean;
    }

    public final boolean getCanDisplay() {
        return this.canDisplay;
    }

    public final void setCanDisplay(boolean z) {
        this.canDisplay = z;
    }
}
