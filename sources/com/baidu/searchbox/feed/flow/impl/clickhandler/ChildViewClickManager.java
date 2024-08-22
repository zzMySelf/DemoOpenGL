package com.baidu.searchbox.feed.flow.impl.clickhandler;

import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FeedFlowContext;
import com.baidu.texas.context.support.StringId;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/feed/flow/impl/clickhandler/ChildViewClickManager;", "", "flowContext", "Lcom/baidu/searchbox/feed/flow/FeedFlowContext;", "(Lcom/baidu/searchbox/feed/flow/FeedFlowContext;)V", "getFlowContext", "()Lcom/baidu/searchbox/feed/flow/FeedFlowContext;", "map", "Ljava/util/HashMap;", "", "Lcom/baidu/searchbox/feed/flow/impl/clickhandler/ItemChildViewClickActionProcessor;", "Lkotlin/collections/HashMap;", "dispatch", "", "key", "action", "Lcom/baidu/searchbox/feed/flow/Actions$ItemChildViewClickAction;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChildViewClickManager.kt */
public final class ChildViewClickManager {
    private final FeedFlowContext flowContext;
    private final HashMap<Integer, ItemChildViewClickActionProcessor> map;

    public ChildViewClickManager(FeedFlowContext flowContext2) {
        Intrinsics.checkNotNullParameter(flowContext2, "flowContext");
        this.flowContext = flowContext2;
        HashMap<Integer, ItemChildViewClickActionProcessor> hashMap = new HashMap<>();
        this.map = hashMap;
        hashMap.put(Integer.valueOf(R.id.feed_tpl_po_text_link_close), new PoTextLinkCloseClick());
        hashMap.put(Integer.valueOf(R.id.feed_template_additional_bar), new AdditionalBarClick());
        hashMap.put(Integer.valueOf(R.id.feed_id_radio_icon_tag), new RadioIconClick());
        hashMap.put(Integer.valueOf(R.id.feed_recommend_view), new RecommendViewClick());
        hashMap.put(Integer.valueOf(R.id.feed_template_big_image_banner_btn_id), new BannerButtonClick());
        hashMap.put(Integer.valueOf(R.id.feed_tpl_follow_delete_id), new BatchFollowBtnClick());
        hashMap.put(Integer.valueOf(R.id.feed_ad_poll_button), new AdPollClick());
        UnlikeClick unlikeClick = new UnlikeClick();
        hashMap.put(Integer.valueOf(R.id.feed_template_base_delete_id), unlikeClick);
        hashMap.put(Integer.valueOf(R.id.tab_video_more_image), unlikeClick);
        VideoAuthorClick videoAuthor = new VideoAuthorClick();
        hashMap.put(Integer.valueOf(R.id.tab_video_author_image), videoAuthor);
        hashMap.put(Integer.valueOf(R.id.tab_video_author_text), videoAuthor);
        HeaderLoginBtnClick headerLoginBtnClick = new HeaderLoginBtnClick();
        hashMap.put(Integer.valueOf(R.id.header_login_btn), headerLoginBtnClick);
        hashMap.put(Integer.valueOf(R.id.header_login_close), headerLoginBtnClick);
        SearchBackViewClick searchBackViewClick = new SearchBackViewClick();
        hashMap.put(Integer.valueOf(R.id.search_back_content), searchBackViewClick);
        hashMap.put(Integer.valueOf(R.id.search_back_close), searchBackViewClick);
        hashMap.put(Integer.valueOf(R.id.feed_slider_bar), new FontSettingClick());
        Map userDataMap = (Map) flowContext2.getUserData(new StringId(ChildViewClickManagerKt.USER_DATA_CHILD_VIEW_CLICK), null);
        if (userDataMap != null) {
            Map map2 = userDataMap;
            hashMap.putAll(userDataMap);
        }
        hashMap.put(Integer.valueOf(R.id.feed_template_click_area), new ChildToItemClick());
    }

    public final FeedFlowContext getFlowContext() {
        return this.flowContext;
    }

    public final boolean dispatch(int key, Actions.ItemChildViewClickAction action, FeedFlowContext flowContext2) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(flowContext2, "flowContext");
        ItemChildViewClickActionProcessor processor = this.map.get(Integer.valueOf(key));
        if (processor == null) {
            return false;
        }
        processor.onClick(action, flowContext2);
        return true;
    }
}
