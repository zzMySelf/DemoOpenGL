package com.baidu.searchbox.dynamic.template.player.layer;

import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.dynamic.template.R;
import com.baidu.searchbox.dynamic.template.player.DynamicPlayerManager;
import com.baidu.searchbox.dynamic.template.video.DynamicVideoItemData;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.template.statistic.ITemplateStatistics;
import com.baidu.searchbox.feed.template.statistic.TemplateStatisticsTable;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.BasePlayerLayer;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.utils.BdVolumeUtils;
import com.baidu.searchbox.ui.TouchStateListener;

public class DynamicVideoLayer extends BasePlayerLayer implements View.OnClickListener {
    private static final int DELAY_HIDE_VOL_DURATION = 5000;
    private static final int HIDE_VOL_ICON = 0;
    private static final String HOT_DISCUSSION_VIDEO_IS_SHOW_PROGRESS_TIPS = "is_show_quick_progress_tips";
    private static final String HOT_DISCUSSION_VIDEO_IS_SHOW_VOICE_TIPS = "is_show_voice_tips";
    public static final String HOT_DISCUSSION_VIDEO_VOICE_SETTING = "voice_setting";
    private static final int START_SHOW_ANIMATOR_TIME = 3;
    protected static boolean sVoiceTipsShowFailed = false;
    protected FeedBaseModel mBaseModel;
    protected String mBusiness;
    private ViewGroup mContainer;
    private boolean mIsWeiboSource = false;
    protected ListVideoListener mListVideoListener;
    protected ImageView mMuteButton;
    protected boolean mProgressLottiePlayed = false;
    private LinearLayout mProgressTipsLayout;
    private TextView mProgressTipsText;
    protected TextView mRemainTime;

    public interface ListVideoListener {
        void onError();

        void onGoMiniVideoPage();

        void onInfo(VideoEvent videoEvent);

        void onLoopReplayed();

        void onMuteBtnClick(boolean z);

        void onProgressChanged(int i2, int i3);

        void onStartPlaying();
    }

    public DynamicVideoLayer(String business) {
        this.mBusiness = business;
    }

    public void initLayer() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.mContext, R.layout.dynamic_video_layer, (ViewGroup) null);
        this.mContainer = viewGroup;
        this.mMuteButton = (ImageView) viewGroup.findViewById(R.id.hotdiscussion_video_mute_icon);
        this.mRemainTime = (TextView) this.mContainer.findViewById(R.id.hotdiscussion_video_time_remain);
        this.mProgressTipsLayout = (LinearLayout) this.mContainer.findViewById(R.id.moment_quick_change_tips_layout);
        this.mProgressTipsText = (TextView) this.mContainer.findViewById(R.id.hotdiscussion_quick_change_text);
        init();
        updateMuteIcon(DynamicPlayerManager.isVideoMute());
        this.mContainer.setVisibility(0);
    }

    public View getContentView() {
        return this.mContainer;
    }

    /* access modifiers changed from: protected */
    public void handleLayerMessage(Message msg) {
        super.handleLayerMessage(msg);
        if (msg.what == 0 && !this.mIsWeiboSource) {
            changeVolumeAndTimeVisibility(4);
            this.mHandler.removeMessages(0);
        }
    }

    public void onControlEventNotify(VideoEvent event) {
        if ("control_event_sync_progress".equals(event.getAction())) {
            int position = ((Integer) event.getExtra(1)).intValue();
            ListVideoListener listVideoListener = this.mListVideoListener;
            if (listVideoListener != null) {
                listVideoListener.onProgressChanged(position, event.getIntExtra(2));
            }
        } else if ("control_event_start".equals(event.getAction())) {
            boolean isMute = getBindPlayer().isMute();
            updateMuteIcon(isMute);
            DynamicPlayerManager.setVideoMute(isMute, true);
            this.mProgressLottiePlayed = false;
            updateMuteIcon(DynamicPlayerManager.isVideoMute());
            processCountDownTask();
            setRemainTimeGone();
            sVoiceTipsShowFailed = true;
        } else if ("control_event_stop".equals(event.getAction())) {
            hideProgressLottie();
        } else if ("control_event_resume".equals(event.getAction())) {
            processCountDownTask();
        }
    }

    /* access modifiers changed from: protected */
    public void setRemainTimeGone() {
    }

    private void sendHideVolumeMessage() {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageDelayed(0, 5000);
    }

    public void initOrUpdateVideoTime(String videoDuration) {
        if (videoDuration == null || TextUtils.isEmpty(videoDuration)) {
            this.mRemainTime.setVisibility(4);
            return;
        }
        if (this.mRemainTime.getVisibility() != 0) {
            this.mRemainTime.setVisibility(0);
            this.mRemainTime.setBackground(ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.dynamic_image_label_bg, (Resources.Theme) null));
            this.mRemainTime.setTextColor(ContextCompat.getColor(FeedRuntime.getAppContext(), R.color.dynamic_video_remain_text_color));
        }
        this.mRemainTime.setText(videoDuration);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r5) {
        /*
            r4 = this;
            super.onLayerEventNotify(r5)
            java.lang.String r0 = r5.getAction()
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 0
            switch(r1) {
                case -1623513910: goto L_0x0047;
                case -552621273: goto L_0x003c;
                case -552580917: goto L_0x0031;
                case -21461611: goto L_0x0026;
                case 1673877948: goto L_0x001c;
                case 2064424334: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0052
        L_0x0011:
            java.lang.String r1 = "layer_event_position_slide"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = 3
            goto L_0x0053
        L_0x001c:
            java.lang.String r1 = "action_mute_sync_to_all_player"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = 2
            goto L_0x0053
        L_0x0026:
            java.lang.String r1 = "layer_event_touch_down"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = 5
            goto L_0x0053
        L_0x0031:
            java.lang.String r1 = "layer_event_switch_half"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r3
            goto L_0x0053
        L_0x003c:
            java.lang.String r1 = "layer_event_switch_full"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0053
        L_0x0047:
            java.lang.String r1 = "layer_event_position_slide_complete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r2
            goto L_0x0053
        L_0x0052:
            r0 = -1
        L_0x0053:
            switch(r0) {
                case 0: goto L_0x0079;
                case 1: goto L_0x006e;
                case 2: goto L_0x006a;
                case 3: goto L_0x0061;
                case 4: goto L_0x005b;
                case 5: goto L_0x0057;
                default: goto L_0x0056;
            }
        L_0x0056:
            goto L_0x007f
        L_0x0057:
            r4.hideProgressLottie()
            goto L_0x007f
        L_0x005b:
            android.widget.ImageView r0 = r4.mMuteButton
            r0.setVisibility(r3)
            goto L_0x007f
        L_0x0061:
            r4.hideProgressLottie()
            android.widget.ImageView r0 = r4.mMuteButton
            r0.setVisibility(r2)
            goto L_0x007f
        L_0x006a:
            r4.sycVideoMute()
            goto L_0x007f
        L_0x006e:
            android.view.ViewGroup r0 = r4.mContainer
            r1 = 8
            r0.setVisibility(r1)
            r4.hideProgressLottie()
            goto L_0x007f
        L_0x0079:
            android.view.ViewGroup r0 = r4.mContainer
            r0.setVisibility(r3)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamic.template.player.layer.DynamicVideoLayer.onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public void onPlayerEventNotify(VideoEvent event) {
        super.onPlayerEventNotify(event);
        ListVideoListener listVideoListener = this.mListVideoListener;
        if (listVideoListener != null) {
            listVideoListener.onInfo(event);
        }
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        ListVideoListener listVideoListener;
        super.onPlayerStatusChanged(status, old);
        if (status == PlayerStatus.COMPLETE) {
            this.mMuteButton.setVisibility(8);
            this.mRemainTime.setVisibility(8);
        } else if (status == PlayerStatus.PLAYING) {
            ListVideoListener listVideoListener2 = this.mListVideoListener;
            if (listVideoListener2 != null) {
                listVideoListener2.onStartPlaying();
            }
        } else if (status == PlayerStatus.ERROR && (listVideoListener = this.mListVideoListener) != null) {
            listVideoListener.onError();
        }
    }

    public void onSystemEventNotify(VideoEvent event) {
        if ("system_event_volume_changed".equals(event.getAction()) && getBindPlayer().isPlaying() && event.getExtra(4) != null) {
            int currVolume = ((Integer) event.getExtra(4)).intValue();
            boolean isVideoMute = DynamicPlayerManager.isVideoMute();
            processCountDownTask();
            if (isVideoMute && currVolume > 0) {
                switchVolumeMode();
            } else if (!isVideoMute && currVolume == 0) {
                switchVolumeMode();
            }
        }
    }

    public int[] getSubscribeEvent() {
        return new int[]{2, 5, 1, 3, 4};
    }

    private void init() {
        this.mMuteButton.setOnTouchListener(new TouchStateListener());
        this.mMuteButton.setOnClickListener(this);
        this.mRemainTime.setBackground(ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.dynamic_image_label_bg, (Resources.Theme) null));
        this.mRemainTime.setTextColor(ContextCompat.getColor(FeedRuntime.getAppContext(), R.color.dynamic_label_text_color));
        containerAddClickListener();
    }

    /* access modifiers changed from: protected */
    public void containerAddClickListener() {
        this.mContainer.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void updateMuteIcon(boolean isMute) {
        this.mMuteButton.setImageDrawable(ContextCompat.getDrawable(this.mContext, isMute ? R.drawable.dynamic_video_mute : R.drawable.dynamic_video_non_mute));
    }

    public void onClick(View view2) {
        ListVideoListener listVideoListener;
        if (view2 == this.mMuteButton) {
            addVoiceStatis(true, false);
            processCountDownTask();
            switchVolumeMode();
            ListVideoListener listVideoListener2 = this.mListVideoListener;
            if (listVideoListener2 != null) {
                listVideoListener2.onMuteBtnClick(DynamicPlayerManager.isVideoMute());
            }
        } else if (view2 == this.mContainer && (listVideoListener = this.mListVideoListener) != null) {
            listVideoListener.onGoMiniVideoPage();
        }
    }

    private void sycVideoMute() {
        boolean isMute = getBindPlayer().isPlayerMute() || BdVolumeUtils.getVolume(this.mContext) <= 0;
        DynamicPlayerManager.setVideoMute(isMute, true);
        updateMuteIcon(isMute);
        getBindPlayer().setMuteMode(isMute);
    }

    private void switchVolumeMode() {
        boolean isMute = DynamicPlayerManager.isVideoMute();
        if (isMute && BdVolumeUtils.getVolume(getActivity()) == 0) {
            BdVolumeUtils.setVolume(getAppContext(), (int) (((double) BdVolumeUtils.getMaxVolume(getAppContext())) * 0.35d));
        }
        boolean isMute2 = !isMute;
        DynamicPlayerManager.setVideoMute(isMute2, true);
        updateMuteIcon(isMute2);
        getBindPlayer().setGlobalMuteMode(isMute2);
        VideoSessionManager.getInstance().sendEventToAll(LayerEvent.obtainEvent(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
    }

    private void addVoiceStatis(boolean isClick, boolean isShowTips) {
        ITemplateStatistics templateStatistics = TemplateStatisticsTable.getInstance().get(this.mBusiness);
        if (templateStatistics != null) {
            templateStatistics.muteIconStatis(isClick && DynamicPlayerManager.isVideoMute(), isShowTips, this.mBusiness);
        }
    }

    private void hideProgressLottie() {
        if (this.mProgressTipsLayout.getVisibility() != 8) {
            this.mProgressTipsLayout.setVisibility(8);
        }
        if (this.mProgressTipsText.getVisibility() != 8) {
            this.mProgressTipsText.setVisibility(8);
        }
    }

    public void setListVideoListener(ListVideoListener listVideoListener) {
        this.mListVideoListener = listVideoListener;
    }

    public void setFeedBaseModel(FeedBaseModel baseModel) {
        this.mBaseModel = baseModel;
        if (baseModel.data instanceof DynamicVideoItemData) {
            initVolumeAndTimeBehavior((DynamicVideoItemData) this.mBaseModel.data);
        }
    }

    public void initVolumeAndTimeBehavior(DynamicVideoItemData videoData) {
        boolean isWeiboSource = videoData.isWeiboSource();
        this.mIsWeiboSource = isWeiboSource;
        if (isWeiboSource) {
            this.mMuteButton.setVisibility(8);
        } else {
            this.mMuteButton.setVisibility(0);
        }
        initOrUpdateVideoTime(videoData.duration);
    }

    private void processCountDownTask() {
        if (this.mIsWeiboSource) {
            this.mMuteButton.setVisibility(8);
            return;
        }
        changeVolumeAndTimeVisibility(0);
        sendHideVolumeMessage();
    }

    private void changeVolumeAndTimeVisibility(int visibility) {
        ImageView imageView = this.mMuteButton;
        if (imageView != null) {
            imageView.setVisibility(visibility);
        }
        TextView textView = this.mRemainTime;
        if (textView != null && !TextUtils.isEmpty(textView.getText())) {
            this.mRemainTime.setVisibility(visibility);
        }
    }
}
