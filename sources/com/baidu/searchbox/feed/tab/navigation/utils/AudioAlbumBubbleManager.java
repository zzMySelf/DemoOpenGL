package com.baidu.searchbox.feed.tab.navigation.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.home.NewHomeFun;
import com.baidu.searchbox.feed.tab.navigation.manager.TabNavDataManager;
import com.baidu.searchbox.feed.tab.navigation.manager.TabNavSchemeProcessor;
import com.baidu.searchbox.feed.util.FeedTabStateDelegate;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import org.json.JSONObject;

public class AudioAlbumBubbleManager {
    public static final String AUDIO_TAB_ID = "125";
    public static final String AUDIO_VIP_TAB_ID = "129";
    public static final String HAS_SHOWN_RADIO_ALBUM_BUBBLE = "has_shown_radio_album_bubble";
    private static final int LIMIT_SHOW_VIP_GUIDE_BUBBLE_COUNT = 5;
    public static final String SHOWN_VIP_AUDIO_BUBBLE_COUNT = "show_vip_audio_bubble_count";
    public static final String SHOWN_VIP_RADIO_ALBUM_BUBBLE = "shown_vip_radio_album_bubble";
    private static final String TAG = "AudioAlbumBubbleManager";
    private static boolean isShowVipGuideBubble = true;
    /* access modifiers changed from: private */
    public BubbleManager mBubbleManager;
    private String vipBubbleTips;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final AudioAlbumBubbleManager INSTANCE = new AudioAlbumBubbleManager();

        private Holder() {
        }
    }

    public static AudioAlbumBubbleManager getInstance() {
        return Holder.INSTANCE;
    }

    public void setVipBubbleTips(String tips) {
        this.vipBubbleTips = tips;
    }

    public void showTTSBubble(View viewToAttach, BubbleManager.OnBubbleEventListener callback) {
        showTTSBubble(viewToAttach, "", callback, "");
    }

    public void showTTSBubble(View viewToAttach, String tableID, BubbleManager.OnBubbleEventListener callback) {
        showTTSBubble(viewToAttach, tableID, callback, "");
    }

    public void showTTSBubble(View viewToAttach, BubbleManager.OnBubbleEventListener callback, String tip) {
        showTTSBubble(viewToAttach, "", callback, tip);
    }

    public void showTTSBubble(View viewToAttach, final String tableID, final BubbleManager.OnBubbleEventListener callback, String tip) {
        if (viewToAttach != null) {
            if (NewHomeFun.INSTANCE.isNewHome() && !FeedTabStateDelegate.getInstance().isTabVisible()) {
                FeedUtil.newHomeLog(TAG, "[showTTSBubble]: 新首页且FeedTab隐藏时 不应该显示，tableID: " + tableID);
            } else if (NewHomeFun.INSTANCE.isNewHome() || !FeedTabStateDelegate.getInstance().isOldHomeTabHide()) {
                Context context = viewToAttach.getContext();
                int bgColor = context.getResources().getColor(R.color.feed_bubble_bg_color);
                int duration = TextUtils.isEmpty(tip) ? 10000 : 5000;
                String text = getBubbleTips(context, tableID);
                if (TextUtils.isEmpty(text)) {
                    text = TextUtils.isEmpty(tip) ? context.getResources().getString(R.string.audio_bubble_text) : tip;
                }
                if (!TextUtils.isEmpty(text)) {
                    BubbleManager build = BubbleManager.getBuilder().setText(text).setAnchor(viewToAttach).setBackground(bgColor).enableClkDismiss(true).setForceShowPosition(BubblePosition.DOWN).setAutoDismissInterval(duration).setPaddingBetweenAnchor(-6.0f).setOnBubbleEventListener(new BubbleManager.OnBubbleEventListener() {
                        public void onBubbleDismiss() {
                            BubbleManager.OnBubbleEventListener onBubbleEventListener = callback;
                            if (onBubbleEventListener != null) {
                                onBubbleEventListener.onBubbleDismiss();
                            }
                            BubbleManager unused = AudioAlbumBubbleManager.this.mBubbleManager = null;
                        }

                        public void onBubbleShow() {
                            BubbleManager.OnBubbleEventListener onBubbleEventListener = callback;
                            if (onBubbleEventListener != null) {
                                onBubbleEventListener.onBubbleShow();
                            }
                            AudioAlbumBubbleManager.this.setAudioBubbleSwitchFlag(tableID);
                        }

                        public void onBubbleClick() {
                            BubbleManager.OnBubbleEventListener onBubbleEventListener = callback;
                            if (onBubbleEventListener != null) {
                                onBubbleEventListener.onBubbleClick();
                            }
                            AudioAlbumBubbleManager.this.dismissBubble();
                        }
                    }).build();
                    this.mBubbleManager = build;
                    build.showBubble();
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getBubbleTips(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = this;
            int r0 = r4.hashCode()
            switch(r0) {
                case 48692: goto L_0x0012;
                case 48696: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x001c
        L_0x0008:
            java.lang.String r0 = "129"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 1
            goto L_0x001d
        L_0x0012:
            java.lang.String r0 = "125"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x001d
        L_0x001c:
            r0 = -1
        L_0x001d:
            switch(r0) {
                case 0: goto L_0x0026;
                case 1: goto L_0x0023;
                default: goto L_0x0020;
            }
        L_0x0020:
            java.lang.String r0 = ""
            return r0
        L_0x0023:
            java.lang.String r0 = r2.vipBubbleTips
            return r0
        L_0x0026:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.baidu.searchbox.feed.core.R.string.audio_bubble_text
            java.lang.String r0 = r0.getString(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.tab.navigation.utils.AudioAlbumBubbleManager.getBubbleTips(android.content.Context, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAudioBubbleSwitchFlag(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case 48692: goto L_0x0014;
                case 48696: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x001e
        L_0x000a:
            java.lang.String r0 = "129"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r1
            goto L_0x001f
        L_0x0014:
            java.lang.String r0 = "125"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r2
            goto L_0x001f
        L_0x001e:
            r0 = -1
        L_0x001f:
            switch(r0) {
                case 0: goto L_0x0042;
                case 1: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0048
        L_0x0023:
            boolean r0 = r4.isOnTheVipSubscriptionWay()
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = "shown_vip_radio_album_bubble"
            com.baidu.android.util.sp.PreferenceUtils.setBoolean(r0, r2)
            goto L_0x0048
        L_0x0030:
            java.lang.String r0 = "show_vip_audio_bubble_count"
            int r1 = com.baidu.android.util.sp.PreferenceUtils.getInt(r0, r2)
            r3 = 5
            if (r1 >= r3) goto L_0x0041
            int r3 = r1 + 1
            com.baidu.android.util.sp.PreferenceUtils.setInt(r0, r3)
            isShowVipGuideBubble = r2
        L_0x0041:
            goto L_0x0048
        L_0x0042:
            java.lang.String r0 = "has_shown_radio_album_bubble"
            com.baidu.android.util.sp.PreferenceUtils.setBoolean(r0, r1)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.tab.navigation.utils.AudioAlbumBubbleManager.setAudioBubbleSwitchFlag(java.lang.String):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean getAudioBubbleSwitchFlag(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case 48692: goto L_0x0014;
                case 48696: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x001e
        L_0x000a:
            java.lang.String r0 = "129"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r1
            goto L_0x001f
        L_0x0014:
            java.lang.String r0 = "125"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r2
            goto L_0x001f
        L_0x001e:
            r0 = -1
        L_0x001f:
            switch(r0) {
                case 0: goto L_0x003e;
                case 1: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0045
        L_0x0023:
            boolean r0 = r3.isOnTheVipSubscriptionWay()
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = "shown_vip_radio_album_bubble"
            boolean r0 = com.baidu.android.util.sp.PreferenceUtils.getBoolean(r0, r1)
            return r0
        L_0x0031:
            java.lang.String r0 = "show_vip_audio_bubble_count"
            int r0 = com.baidu.android.util.sp.PreferenceUtils.getInt(r0, r2)
            r1 = 5
            if (r0 >= r1) goto L_0x0045
            boolean r1 = isShowVipGuideBubble
            return r1
        L_0x003e:
            java.lang.String r0 = "has_shown_radio_album_bubble"
            boolean r0 = com.baidu.android.util.sp.PreferenceUtils.getBoolean(r0, r2)
            return r0
        L_0x0045:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.tab.navigation.utils.AudioAlbumBubbleManager.getAudioBubbleSwitchFlag(java.lang.String):boolean");
    }

    public void dismissBubble() {
        BubbleManager bubbleManager = this.mBubbleManager;
        if (bubbleManager != null && !bubbleManager.isDismissed()) {
            this.mBubbleManager.dismissBubble();
            this.mBubbleManager = null;
        }
    }

    public void insertTab(String tabID) {
        if (isAccordInsertCondition(tabID)) {
            int position = TabNavDataManager.getInstance().getAllAddedMultiTabItemList().size() - 1;
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("tab_id", tabID);
                jsonObject.put(TabNavSchemeProcessor.TAB_INDEX, position);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            TabNavSchemeProcessor.getInstance().processInsert(jsonObject, 4);
        }
    }

    public boolean isAccordInsertCondition(String tableID) {
        if (TextUtils.equals(tableID, "129") && !TextUtils.isEmpty(this.vipBubbleTips)) {
            return getAudioBubbleSwitchFlag(tableID);
        }
        if (getAudioBubbleSwitchFlag(tableID)) {
            return false;
        }
        if (TabNavDataManager.getInstance().getTabType(tableID) != 0) {
            return true;
        }
        setAudioBubbleSwitchFlag(tableID);
        return false;
    }

    public boolean isOnTheVipSubscriptionWay() {
        return TextUtils.equals(this.vipBubbleTips, AppRuntime.getAppContext().getResources().getString(R.string.audio_bubble_vip_subscription));
    }
}
