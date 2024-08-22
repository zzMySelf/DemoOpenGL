package com.baidu.searchbox.search.tab.helper;

import com.baidu.searchbox.feed.widget.newsfeedback.FeedbackPop;
import com.baidu.searchbox.search.tab.core.manager.IComponentManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/search/tab/helper/RecommendVideoOperateHelper$handleUnlike$callback$1", "Lcom/baidu/searchbox/feed/widget/newsfeedback/FeedbackPop$NotInterestCallback;", "onReport", "", "onUnlike", "subTagItem", "Lcom/baidu/searchbox/lightbrowser/model/SubTagItem;", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendVideoOperateHelper.kt */
public final class RecommendVideoOperateHelper$handleUnlike$callback$1 implements FeedbackPop.NotInterestCallback {
    final /* synthetic */ IComponentManager $componentManager;
    final /* synthetic */ int $position;
    final /* synthetic */ RecommendVideoOperateHelper this$0;

    RecommendVideoOperateHelper$handleUnlike$callback$1(RecommendVideoOperateHelper $receiver, IComponentManager $componentManager2, int $position2) {
        this.this$0 = $receiver;
        this.$componentManager = $componentManager2;
        this.$position = $position2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.baidu.searchbox.feed.list.adapter.PageAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.baidu.searchbox.feed.list.adapter.PageAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.baidu.searchbox.feed.list.adapter.PageAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.baidu.searchbox.feed.list.adapter.PageAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.baidu.searchbox.feed.list.adapter.PageAdapter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUnlike(com.baidu.searchbox.lightbrowser.model.SubTagItem r8) {
        /*
            r7 = this;
            com.baidu.searchbox.search.tab.helper.RecommendVideoOperateHelper r0 = r7.this$0
            r1 = 1
            r0.mNeedDeleteVideo = r1
            com.baidu.searchbox.search.tab.helper.RecommendVideoOperateHelper r0 = r7.this$0
            com.baidu.searchbox.feed.model.FeedBaseModel r1 = r0.mFeedBaseModel
            r0.handleTcClickReport(r1)
            com.baidu.searchbox.search.tab.core.manager.IComponentManager r0 = r7.$componentManager
            if (r0 == 0) goto L_0x0054
            java.lang.Class<com.baidu.searchbox.search.tab.implement.service.IVideoListViewService> r1 = com.baidu.searchbox.search.tab.implement.service.IVideoListViewService.class
            com.baidu.searchbox.search.tab.core.service.IService r0 = r0.getService(r1)
            com.baidu.searchbox.search.tab.implement.service.IVideoListViewService r0 = (com.baidu.searchbox.search.tab.implement.service.IVideoListViewService) r0
            if (r0 == 0) goto L_0x0054
            com.baidu.searchbox.search.tab.implement.view.VideoCommonListPage r0 = r0.getLoftListPage()
            if (r0 == 0) goto L_0x0054
            int r1 = r7.$position
            r2 = 0
            androidx.recyclerview.widget.RecyclerView r3 = r0.getRecyclerView()
            r4 = 0
            if (r3 == 0) goto L_0x0037
            androidx.recyclerview.widget.RecyclerView$Adapter r3 = r3.getAdapter()
            goto L_0x0038
        L_0x0037:
            r3 = r4
        L_0x0038:
            r5 = r3
            r6 = 0
            boolean r5 = r5 instanceof com.baidu.searchbox.feed.list.adapter.PageAdapter
            if (r5 == 0) goto L_0x003f
            r4 = r3
        L_0x003f:
            if (r4 == 0) goto L_0x0051
            r3 = r4
            r4 = 0
            r5 = r3
            com.baidu.searchbox.feed.list.adapter.PageAdapter r5 = (com.baidu.searchbox.feed.list.adapter.PageAdapter) r5
            r5 = r3
            com.baidu.searchbox.feed.list.adapter.PageAdapter r5 = (com.baidu.searchbox.feed.list.adapter.PageAdapter) r5
            r5.removeItem(r1)
            r0.postVideoAutoPlay()
        L_0x0051:
            goto L_0x0055
        L_0x0054:
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.helper.RecommendVideoOperateHelper$handleUnlike$callback$1.onUnlike(com.baidu.searchbox.lightbrowser.model.SubTagItem):void");
    }

    public void onReport() {
    }
}
