package com.baidu.searchbox.feed.ioc;

import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.flow.RefreshablePage;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedPolicyModel;
import java.util.List;

public interface IFeedAdTrueViewController {
    public static final IFeedAdTrueViewController EMPTY = new IFeedAdTrueViewController() {
        public void onViewPause(List<FeedBaseModel> list, int firstVisibleItemPos, int lastVisibleItemPos) {
        }

        public void onViewResume(List<FeedBaseModel> list, int firstVisibleItemPos, int lastVisibleItemPos) {
        }

        public void onFeedRefresh(FeedPolicyModel mFeedPolicyModel, List<FeedBaseModel> list, String sceneType, String sceneContent) {
        }

        public void onCollectTrueView(List<FeedBaseModel> list, FeedBaseModel model) {
        }

        public void notifyRefreshFinish(RefreshablePage page, List<FeedBaseModel> list, int currentPullState) {
        }
    };
    public static final String KEY_SCENE_TYPE_EXTEND = "extendType";
    public static final String KEY_SCENE_TYPE_REFRESH = "refreshType";
    public static final String VALUE_SCENE_CONTENT_BACKGROUND = "background";

    void notifyRefreshFinish(RefreshablePage refreshablePage, List<FeedBaseModel> list, int i2);

    void onCollectTrueView(List<FeedBaseModel> list, FeedBaseModel feedBaseModel);

    void onFeedRefresh(FeedPolicyModel feedPolicyModel, List<FeedBaseModel> list, String str, String str2);

    void onViewPause(List<FeedBaseModel> list, int i2, int i3);

    void onViewResume(List<FeedBaseModel> list, int i2, int i3);

    public static class Impl {
        private static IFeedAdTrueViewController sController = FeedRuntime.getFeedAdTrueViewController();

        public static IFeedAdTrueViewController get() {
            if (sController == null) {
                sController = IFeedAdTrueViewController.EMPTY;
            }
            return sController;
        }
    }
}
