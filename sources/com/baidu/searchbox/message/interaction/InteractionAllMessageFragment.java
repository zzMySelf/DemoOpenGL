package com.baidu.searchbox.message.interaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.push.mymessagefragment.util.PushNotifyPerformanceFlowUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class InteractionAllMessageFragment extends InteractionBaseMessageFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = super.onCreateView(inflater, container, savedInstanceState);
        PushNotifyPerformanceFlowUtil.addEvent("P2");
        return this.rootView;
    }

    public void onFragmentFirstVisible() {
        PushNotifyPerformanceFlowUtil.addEvent("P3");
        super.onFragmentFirstVisible();
    }

    public void requestList() {
        this.isLoading = true;
        IMBoxManager.getPaMsgByChatTypeAndPaidList(this.mActivity, getChatTypes(), (List<Long>) null, this.mMsgId, 20, new FetchNotificationDataListener(this));
    }

    public static List<Integer> getChatTypes() {
        List<Integer> list = new ArrayList<>();
        list.add(29);
        list.add(19);
        return list;
    }

    public void onDestroy() {
        super.onDestroy();
        setAllMessageRead();
    }

    private void setAllMessageRead() {
        IMBoxManager.setMsgReadByChatTypes(MessageRuntime.getAppContext(), getChatTypes(), 0);
    }

    private static class FetchNotificationDataListener implements IFetchNotificationDataListener {
        private WeakReference<InteractionAllMessageFragment> ref;

        public FetchNotificationDataListener(InteractionAllMessageFragment fragment) {
            this.ref = new WeakReference<>(fragment);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
            r0 = (com.baidu.searchbox.message.interaction.InteractionAllMessageFragment) r0.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFetchResult(final java.util.List<com.baidu.android.imsdk.notification.NotificationMsgData> r3, final boolean r4) {
            /*
                r2 = this;
                java.lang.ref.WeakReference<com.baidu.searchbox.message.interaction.InteractionAllMessageFragment> r0 = r2.ref
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                java.lang.Object r0 = r0.get()
                com.baidu.searchbox.message.interaction.InteractionAllMessageFragment r0 = (com.baidu.searchbox.message.interaction.InteractionAllMessageFragment) r0
                if (r0 != 0) goto L_0x000e
                return
            L_0x000e:
                com.baidu.searchbox.message.interaction.InteractionAllMessageFragment$FetchNotificationDataListener$1 r1 = new com.baidu.searchbox.message.interaction.InteractionAllMessageFragment$FetchNotificationDataListener$1
                r1.<init>(r0, r4, r3)
                com.baidu.android.util.concurrent.UiThreadUtil.runOnUiThread(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.message.interaction.InteractionAllMessageFragment.FetchNotificationDataListener.onFetchResult(java.util.List, boolean):void");
        }
    }
}
