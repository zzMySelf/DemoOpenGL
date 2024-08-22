package com.baidu.searchbox.message.interactionupgrade;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.logging.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.notification.NotificationMsgData;
import com.baidu.searchbox.IMSharedPrefsWrapper;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.card.utils.InteractShieldRelationUtils;
import com.baidu.searchbox.card.utils.MD5Utils;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.message.interactionupgrade.ubc.InteractionUpgradeUBCUtil;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.push.mymessagefragment.util.PushNotifyPerformanceFlowUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class InteractionUpgradeAllFragment extends InteractionUpgradeBaseFragment {
    private static final String ALREADY_SHOW_SHIELD = "already_show_shield";
    private static final int CLOSE_MESSAGE = 1001;
    private static final int EXPAND_WIDTH = 12;
    private static final String TAG = InteractionUpgradeAllFragment.class.getSimpleName();
    Handler mHandler = new InteractionHandle(this);

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = super.onCreateView(inflater, container, savedInstanceState);
        PushNotifyPerformanceFlowUtil.addEvent("P2");
        this.mFragmentName = "all";
        if (this.mPushNotifyEmpty != null) {
            this.mPushNotifyEmpty.setTitle(R.string.message_interaction_empty);
        }
        return this.rootView;
    }

    public void onFragmentFirstVisible() {
        PushNotifyPerformanceFlowUtil.addEvent("P3");
        super.onFragmentFirstVisible();
    }

    public void onResume() {
        super.onResume();
        InteractionUpgradeUBCUtil.interactPageUBCEvent(InteractionUpgradeUBCUtil.UBC_PAGE_HUDONG_DETAIL_KEY, "0", "show");
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
        ImageView closeView;
        super.onDestroy();
        setAllMessageRead();
        if (!(this.mMessageShieldGuideLayout == null || (closeView = (ImageView) this.mMessageShieldGuideLayout.findViewById(R.id.message_shield_guide_close)) == null)) {
            closeView.removeCallbacks((Runnable) null);
        }
        BdEventBus.Companion.getDefault().unregister(this);
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    private void setAllMessageRead() {
        IMBoxManager.setMsgReadByChatTypes(MessageRuntime.getAppContext(), getChatTypes(), 0);
    }

    private static class FetchNotificationDataListener implements IFetchNotificationDataListener {
        private WeakReference<InteractionUpgradeAllFragment> ref;

        public FetchNotificationDataListener(InteractionUpgradeAllFragment fragment) {
            this.ref = new WeakReference<>(fragment);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
            r0 = (com.baidu.searchbox.message.interactionupgrade.InteractionUpgradeAllFragment) r0.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFetchResult(final java.util.List<com.baidu.android.imsdk.notification.NotificationMsgData> r3, final boolean r4) {
            /*
                r2 = this;
                java.lang.ref.WeakReference<com.baidu.searchbox.message.interactionupgrade.InteractionUpgradeAllFragment> r0 = r2.ref
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                java.lang.Object r0 = r0.get()
                com.baidu.searchbox.message.interactionupgrade.InteractionUpgradeAllFragment r0 = (com.baidu.searchbox.message.interactionupgrade.InteractionUpgradeAllFragment) r0
                if (r0 != 0) goto L_0x000e
                return
            L_0x000e:
                com.baidu.searchbox.message.interactionupgrade.InteractionUpgradeAllFragment$FetchNotificationDataListener$1 r1 = new com.baidu.searchbox.message.interactionupgrade.InteractionUpgradeAllFragment$FetchNotificationDataListener$1
                r1.<init>(r0, r4, r3)
                com.baidu.android.util.concurrent.UiThreadUtil.runOnUiThread(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.message.interactionupgrade.InteractionUpgradeAllFragment.FetchNotificationDataListener.onFetchResult(java.util.List, boolean):void");
        }
    }

    private String getAlreadyShowShieldKey() {
        try {
            String imLoginSucceededUid = AccountManager.getLoginSucceededUid(getContext());
            if (TextUtils.isEmpty(imLoginSucceededUid)) {
                return ALREADY_SHOW_SHIELD;
            }
            return ALREADY_SHOW_SHIELD + MD5Utils.md5(imLoginSucceededUid);
        } catch (Exception e2) {
            if (MessageRuntime.GLOBAL_DEBUG) {
                Log.e(TAG, "getAlreadyShowShieldKey error: " + e2.getMessage());
            }
            return ALREADY_SHOW_SHIELD;
        }
    }

    /* access modifiers changed from: private */
    public void checkMessageShieldGuide(List<NotificationMsgData> list) {
        if (!IMSharedPrefsWrapper.getInstance().getBoolean(getAlreadyShowShieldKey(), false) && list != null && list.size() > 0) {
            boolean needShow = false;
            for (NotificationMsgData data : list) {
                if (data != null) {
                    needShow = InteractShieldRelationUtils.checkCanShieldType(data) || InteractShieldRelationUtils.checkCanShieldArticle(data) || InteractShieldRelationUtils.checkCanShieldUser(data);
                    if (needShow) {
                        break;
                    }
                }
            }
            if (needShow) {
                showShieldGuide();
            }
        }
    }

    private void showShieldGuide() {
        if (this.mMessageShieldGuideLayout != null) {
            IMSharedPrefsWrapper.getInstance().putBoolean(getAlreadyShowShieldKey(), true);
            ImageView ivShieldGuide = (ImageView) this.mMessageShieldGuideLayout.findViewById(R.id.message_shield_guide_image);
            TextView tvTipText = (TextView) this.mMessageShieldGuideLayout.findViewById(R.id.message_shield_guide_tip);
            final ImageView ivCloseView = (ImageView) this.mMessageShieldGuideLayout.findViewById(R.id.message_shield_guide_close);
            ivCloseView.post(new Runnable() {
                public void run() {
                    Rect bounds = new Rect();
                    ivCloseView.getHitRect(bounds);
                    bounds.left -= 12;
                    bounds.top -= 12;
                    bounds.right += 12;
                    bounds.bottom += 12;
                    InteractionUpgradeAllFragment.this.mMessageShieldGuideLayout.setTouchDelegate(new TouchDelegate(bounds, ivCloseView));
                }
            });
            ivCloseView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (InteractionUpgradeAllFragment.this.mMessageShieldGuideLayout != null) {
                        InteractionUpgradeAllFragment.this.mMessageShieldGuideLayout.startAnimation(AnimationUtils.loadAnimation(InteractionUpgradeAllFragment.this.getContext(), R.anim.message_system_off_layout_exit));
                        InteractionUpgradeAllFragment.this.mMessageShieldGuideLayout.setVisibility(8);
                    }
                }
            });
            Resources resources = getResources();
            this.mMessageShieldGuideLayout.setBackgroundDrawable(resources.getDrawable(R.drawable.message_system_off_new_bg));
            tvTipText.setText(getString(R.string.message_system_hide_guide_tip));
            FontSizeTextViewExtKt.setScaledSizeRes(tvTipText, 0, R.dimen.message_dimens_14dp);
            tvTipText.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC6));
            ivCloseView.setBackgroundDrawable(resources.getDrawable(R.drawable.interaction_message_shield_guide_close));
            FontSizeViewExtKt.setScaledSizeRes(ivCloseView, 0, R.dimen.message_dimens_10dp, R.dimen.message_dimens_10dp);
            this.mMessageShieldGuideLayout.setVisibility(0);
            this.mMessageShieldGuideLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.message_system_off_layout_enter));
            ivShieldGuide.setImageDrawable(ContextCompat.getDrawable(this.mActivity, R.drawable.interaction_message_shield_guide_icon));
            FontSizeViewExtKt.setScaledSizeRes(ivShieldGuide, 0, R.dimen.message_dimens_20dp, R.dimen.message_dimens_20dp);
            Message closeMessage = new Message();
            closeMessage.what = 1001;
            this.mHandler.sendMessageDelayed(closeMessage, 7000);
        }
    }

    /* access modifiers changed from: private */
    public void closeMessageShieldGuide() {
        try {
            if (isDetached() || this.mMessageShieldGuideLayout == null) {
                return;
            }
            if (this.mMessageShieldGuideLayout.getVisibility() == 0) {
                this.mMessageShieldGuideLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.message_system_off_layout_exit));
                this.mMessageShieldGuideLayout.setVisibility(8);
                IMSharedPrefsWrapper.getInstance().putBoolean(ALREADY_SHOW_SHIELD, true);
            }
        } catch (Exception e2) {
            if (MessageRuntime.GLOBAL_DEBUG) {
                Log.d(TAG, "closeMessageShieldGuide error: " + e2.getMessage());
            }
        }
    }

    private static class InteractionHandle extends Handler {
        private WeakReference<InteractionUpgradeAllFragment> mRef;

        public InteractionHandle(InteractionUpgradeAllFragment fragment) {
            this.mRef = new WeakReference<>(fragment);
        }

        public void handleMessage(Message msg) {
            WeakReference<InteractionUpgradeAllFragment> weakReference = this.mRef;
            if (weakReference != null && weakReference.get() != null && msg.what == 1001) {
                ((InteractionUpgradeAllFragment) this.mRef.get()).closeMessageShieldGuide();
            }
        }
    }
}
