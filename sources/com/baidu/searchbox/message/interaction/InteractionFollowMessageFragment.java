package com.baidu.searchbox.message.interaction;

import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.notification.NotificationMsgData;
import com.baidu.android.util.concurrent.UiThreadUtil;
import java.util.ArrayList;
import java.util.List;

public class InteractionFollowMessageFragment extends InteractionBaseMessageFragment {
    public void requestList() {
        this.isLoading = true;
        IMBoxManager.getPaMsgByChatTypeAndPaidList(this.mActivity, (List<Integer>) null, getPaIds(), this.mMsgId, 20, new IFetchNotificationDataListener() {
            public void onFetchResult(final List<NotificationMsgData> list, final boolean hasMore) {
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        InteractionFollowMessageFragment.this.mHasMore = hasMore;
                        InteractionFollowMessageFragment.this.isLoading = false;
                        if (InteractionFollowMessageFragment.this.isFirstRequest && InteractionFollowMessageFragment.this.mLoadingView != null) {
                            if (InteractionFollowMessageFragment.this.mLoadingView.isAnimationStarted()) {
                                InteractionFollowMessageFragment.this.mLoadingView.setVisibility(8);
                            } else {
                                InteractionFollowMessageFragment.this.mLoadingView.stopShimmerAnimation();
                                InteractionFollowMessageFragment.this.mLoadingView.setVisibility(8);
                            }
                        }
                        if (!InteractionFollowMessageFragment.this.handleEmpty(list)) {
                            List list = list;
                            if (list != null && list.size() > 0) {
                                List list2 = list;
                                if (list2.get(list2.size() - 1) != null) {
                                    List list3 = list;
                                    if (((NotificationMsgData) list3.get(list3.size() - 1)).getMsg() != null) {
                                        InteractionFollowMessageFragment interactionFollowMessageFragment = InteractionFollowMessageFragment.this;
                                        List list4 = list;
                                        interactionFollowMessageFragment.mMsgId = ((NotificationMsgData) list4.get(list4.size() - 1)).getMsg().getMsgId();
                                    }
                                }
                            }
                            InteractionFollowMessageFragment.this.setData(list, hasMore);
                            InteractionFollowMessageFragment.this.mPushAdapter.notifyDataSetChanged();
                        }
                        InteractionFollowMessageFragment.this.isFirstRequest = false;
                    }
                });
            }
        });
    }

    public static List<Long> getPaIds() {
        List<Long> list = new ArrayList<>();
        list.add(Long.valueOf(InteractionMessageState.getFollowPaid()));
        return list;
    }
}
