package com.baidu.searchbox.music.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.bdmediacore.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.tts.utils.FeedTTSPreferenceUtil;
import com.baidu.searchbox.music.MiniPlayerView;
import com.baidu.searchbox.music.statistic.MusicUBCConstant;
import com.baidu.searchbox.music.utils.NovelHelper;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager;

public class VoiceManagementBubbleManager {
    public static final String KEY_HAS_SHOWN_VOICE_MANAGEMENT_BUBBLE = "has_shown_voice_management_bubble";
    /* access modifiers changed from: private */
    public BubbleBaseManager mBubbleManager;
    private String mGuideText;
    /* access modifiers changed from: private */
    public boolean mIsBubbleRquesting;
    /* access modifiers changed from: private */
    public boolean mIsFromOpTask;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final VoiceManagementBubbleManager INSTANCE = new VoiceManagementBubbleManager();

        private Holder() {
        }
    }

    public static VoiceManagementBubbleManager getInstance() {
        return Holder.INSTANCE;
    }

    private VoiceManagementBubbleManager() {
        this.mGuideText = AppRuntime.getAppContext().getString(R.string.media_voice_management_bubble_guide_text);
    }

    public void setGuideText(String guideText) {
        this.mGuideText = guideText;
    }

    public void showBubble(final View anchor, ViewGroup root) {
        if (!this.mIsBubbleRquesting && !NovelHelper.isNovelSource()) {
            this.mIsBubbleRquesting = true;
            if (this.mIsFromOpTask) {
                this.mGuideText = AppRuntime.getAppContext().getResources().getString(R.string.media_optask_bubble_text);
            } else if (TextUtils.isEmpty(this.mGuideText) || FeedTTSPreferenceUtil.getBoolean(KEY_HAS_SHOWN_VOICE_MANAGEMENT_BUBBLE, false)) {
                this.mIsBubbleRquesting = false;
                return;
            }
            this.mBubbleManager = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setText(this.mGuideText).enableAnchorClk(true).setAnchorAndRootView(anchor, root).setForceShowPosition(BubblePosition.UP).setAutoDismissInterval(7000).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new BubbleManager.OnBubbleEventListener() {
                public void onBubbleShow() {
                    if (!VoiceManagementBubbleManager.this.mIsFromOpTask) {
                        MusicUBCConstant.musicEvent(MusicUBCConstant.UBC_MUSIC_ALBUM_EVENT_ID, MusicUBCConstant.UBC_TYPE_MINI_PLAYER_VOICE_BUBBLE_SHOWN, MusicUBCConstant.UBC_MUSIC_SOURCE_MINIBAR_VOICE_MANAGEMENT, "tts", (String) null, (String) null);
                        FeedTTSPreferenceUtil.putBoolean(VoiceManagementBubbleManager.KEY_HAS_SHOWN_VOICE_MANAGEMENT_BUBBLE, true);
                    }
                    boolean unused = VoiceManagementBubbleManager.this.mIsFromOpTask = false;
                    boolean unused2 = VoiceManagementBubbleManager.this.mIsBubbleRquesting = false;
                }

                public void onBubbleDismiss() {
                    BubbleBaseManager unused = VoiceManagementBubbleManager.this.mBubbleManager = null;
                }

                public void onBubbleClick() {
                    anchor.performClick();
                    VoiceManagementBubbleManager.this.dismissBubble();
                }
            }).build();
            if (this.mIsFromOpTask) {
                MiniPlayerView.getInstance().showVoiceDot();
            }
            this.mBubbleManager.showBubble();
        }
    }

    public void dismissBubble() {
        if (isShowing()) {
            this.mBubbleManager.dismissBubble();
            this.mBubbleManager = null;
        }
    }

    public boolean isShowing() {
        BubbleBaseManager bubbleBaseManager = this.mBubbleManager;
        return bubbleBaseManager != null && !bubbleBaseManager.isDismissed();
    }

    public boolean isIsFromOpTask() {
        return this.mIsFromOpTask;
    }

    public void setIsFromOpTask(boolean isFromOpTask) {
        this.mIsFromOpTask = isFromOpTask;
    }
}
