package com.baidu.searchbox.feed.topicdetail.ubc;

import android.util.Log;
import com.baidu.searchbox.account.im.GroupMemberAdapter;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.topicdetail.bean.TopicSearchLogInfo;
import com.baidu.searchbox.feed.topicdetail.bean.TopicTcClickInfo;
import com.baidu.searchbox.feed.topicdetail.manager.TopicDetailPageInfoManager;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u001c\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0017H\u0002\u001a\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"BAI_DU_ID", "", "CLICK_INFO", "FROM", "LID", "PU", "REF", "TC_ACTION_DETA", "TC_ACTION_FLLOW", "TC_ACTION_FOLD", "TC_ACTION_LIKE", "TC_ACTION_SPRE", "TC_ACTION_VIDEO", "TC_TYPE_B", "TC_TYPE_NA", "TC_TYPE_O", "TC_URL", "getTcWParams", "infoManager", "Lcom/baidu/searchbox/feed/topicdetail/manager/TopicDetailPageInfoManager;", "sendLogRequest", "", "params", "", "userActionTcReport", "tcClickInfo", "Lcom/baidu/searchbox/feed/topicdetail/bean/TopicTcClickInfo;", "lib-feed-topic-detail_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopicBiserialTcUtil.kt */
public final class TopicBiserialTcUtilKt {
    private static final String BAI_DU_ID = "baiduid";
    private static final String CLICK_INFO = "clk_info";
    private static final String FROM = "from";
    private static final String LID = "lid";
    private static final String PU = "pu";
    private static final String REF = "ref";
    public static final String TC_ACTION_DETA = "ht_a_deta";
    public static final String TC_ACTION_FLLOW = "ht_a_foll";
    public static final String TC_ACTION_FOLD = "ht_a_fold";
    public static final String TC_ACTION_LIKE = "ht_a_like";
    public static final String TC_ACTION_SPRE = "ht_a_spre";
    public static final String TC_ACTION_VIDEO = "ht_a_vide";
    public static final String TC_TYPE_B = "b";
    public static final String TC_TYPE_NA = "na";
    public static final String TC_TYPE_O = "o";
    private static final String TC_URL = "https://m.baidu.com/tc";

    public static final void userActionTcReport(TopicTcClickInfo tcClickInfo, TopicDetailPageInfoManager infoManager) {
        Intrinsics.checkNotNullParameter(tcClickInfo, "tcClickInfo");
        if (infoManager != null) {
            try {
                TopicSearchLogInfo topicSearchLogInfo = infoManager.getTopicSearchLogInfo();
                if (topicSearchLogInfo != null) {
                    Map params = new HashMap();
                    params.put("lid", topicSearchLogInfo.getLid());
                    params.put("ref", topicSearchLogInfo.getRef());
                    params.put("pu", topicSearchLogInfo.getPu());
                    params.put("t", String.valueOf(System.currentTimeMillis()));
                    boolean z = true;
                    if (tcClickInfo.getCyc().length() > 0) {
                        params.put("cyc", tcClickInfo.getCyc());
                    }
                    params.put("baiduid", topicSearchLogInfo.getBaiduId());
                    params.put("from", topicSearchLogInfo.getFrom());
                    params.put("w", getTcWParams(infoManager));
                    JSONObject clickObj = topicSearchLogInfo.getClickInfo();
                    if (tcClickInfo.getType().length() > 0) {
                        clickObj.put("type", tcClickInfo.getType());
                    }
                    if (tcClickInfo.getAction().length() > 0) {
                        clickObj.put("action", tcClickInfo.getAction());
                    }
                    if (tcClickInfo.getOrder() >= 0) {
                        clickObj.put("order", tcClickInfo.getOrder());
                    }
                    if (tcClickInfo.getNid().length() > 0) {
                        clickObj.put("nid", tcClickInfo.getNid());
                    }
                    if (tcClickInfo.getSrc().length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        clickObj.put("src", tcClickInfo.getSrc());
                    }
                    JSONObject it = tcClickInfo.getSlog();
                    if (it != null) {
                        clickObj.put("slog", it);
                    }
                    String jSONObject = clickObj.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "clickObj.toString()");
                    params.put("clk_info", jSONObject);
                    sendLogRequest(params);
                }
            } catch (Exception e2) {
                if (FeedRuntime.GLOBAL_DEBUG) {
                    Log.d("userActionTcReport", e2.toString());
                }
            }
        }
    }

    private static final String getTcWParams(TopicDetailPageInfoManager infoManager) {
        StringBuilder append = new StringBuilder().append(infoManager.getHasLoadedItemsNum()).append(GroupMemberAdapter.MANAGER_CHAR).append(infoManager.getCurrentListSize()).append(GroupMemberAdapter.MANAGER_CHAR);
        TopicSearchLogInfo topicSearchLogInfo = infoManager.getTopicSearchLogInfo();
        return append.append(topicSearchLogInfo != null ? topicSearchLogInfo.getQ() : null).toString();
    }

    private static final void sendLogRequest(Map<String, String> params) {
        ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(FeedRuntime.getAppContext()).getRequest().url("https://m.baidu.com/tc")).addUrlParams(params)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(false, false))).build().executeAsync(new TopicBiserialTcUtilKt$sendLogRequest$1());
    }
}
