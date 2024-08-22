package com.baidu.chatsearch.aisearch.resultpage.utils;

import com.baidu.chatsearch.model.sug.model.SSAgentSugModel;
import com.baidu.chatsearch.model.ubc.AgentStatus;
import com.baidu.chatsearch.model.ubc.SugStatus;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J$\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J&\u0010\u001a\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&¨\u0006#"}, d2 = {"Lcom/baidu/chatsearch/aisearch/resultpage/utils/ISSAiSearchUbc;", "", "addAgentStatus", "", "sugStatus", "Lcom/baidu/chatsearch/model/ubc/AgentStatus;", "addSugStatus", "Lcom/baidu/chatsearch/model/ubc/SugStatus;", "clickAgent", "agentId", "", "agentName", "info", "infoRank", "", "clickBlank", "page", "clickInputDelete", "clickRecommend", "word", "clickResultInput", "clickReturn", "clickSearch", "clickSug", "agentSug", "Lcom/baidu/chatsearch/model/sug/model/SSAgentSugModel$AgentSug;", "recommendExpose", "showList", "", "duration", "", "moment", "showAgent", "showBottomBar", "showSug", "lib-chatsearch-resultpage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISSAiSearchUbc.kt */
public interface ISSAiSearchUbc {
    void addAgentStatus(AgentStatus agentStatus);

    void addSugStatus(SugStatus sugStatus);

    void clickAgent(String str, String str2, String str3, int i2);

    void clickBlank(String str);

    void clickInputDelete();

    void clickRecommend(String str);

    void clickResultInput();

    void clickReturn();

    void clickSearch();

    void clickSug(String str, int i2, SSAgentSugModel.AgentSug agentSug);

    void recommendExpose(List<String> list, long j2, String str);

    void showAgent();

    void showBottomBar();

    void showSug();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ISSAiSearchUbc.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void clickBlank$default(ISSAiSearchUbc iSSAiSearchUbc, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "search";
                }
                iSSAiSearchUbc.clickBlank(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickBlank");
        }

        public static /* synthetic */ void clickSug$default(ISSAiSearchUbc iSSAiSearchUbc, String str, int i2, SSAgentSugModel.AgentSug agentSug, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    agentSug = null;
                }
                iSSAiSearchUbc.clickSug(str, i2, agentSug);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickSug");
        }
    }
}
