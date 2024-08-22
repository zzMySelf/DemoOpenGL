package com.baidu.searchbox.player.layer;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.ab.PlayerAbManager;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.ControlLayerElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.IVideoSeekBarListener;
import com.baidu.searchbox.player.model.ClarityUrlList;
import com.baidu.searchbox.player.ubc.IControlLayerUbcDispatcher;
import com.baidu.searchbox.player.ui.BdLayerSeekBar;
import com.baidu.searchbox.player.utils.BdClarityUtil;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.VideoPlayerRuntime;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils;
import com.baidu.searchbox.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.searchbox.video.videoplayer.widget.PlayDrawable;
import com.baidu.searchbox.videoplayer.business.R;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbsControlLayer extends BaseElementLayer<FrameLayout, ControlLayerElement> implements View.OnClickListener, IVideoSeekBarListener {
    protected static final int MSG_HIDE_PANEL = 1;
    private static final int PANEL_HIDE_DELAY_TIME = 3000;
    protected ArrayList<Button> mClarityBtnList;
    protected Button mClarityButton;
    protected LinearLayout mClarityPanel;
    protected FrameLayout.LayoutParams mClarityPanelParams = new FrameLayout.LayoutParams(-2, InvokerUtils.di2pi(33.0f));
    protected String mCurrentClarity;
    protected boolean mIsNeedBubble;
    protected ImageView mPlayBtn;
    protected PlayDrawable mPlayDrawable;
    protected BdLayerSeekBar mSeekBar;
    protected int mStartSeekBarPos;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onControlEventNotify(com.baidu.searchbox.player.event.VideoEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getAction()
            int r1 = r0.hashCode()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1530009462: goto L_0x002e;
                case -333704320: goto L_0x0024;
                case 720027695: goto L_0x001a;
                case 906917140: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0038
        L_0x0010:
            java.lang.String r1 = "control_event_resume"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = r3
            goto L_0x0039
        L_0x001a:
            java.lang.String r1 = "control_event_pause"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = r4
            goto L_0x0039
        L_0x0024:
            java.lang.String r1 = "control_event_show_tip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = r5
            goto L_0x0039
        L_0x002e:
            java.lang.String r1 = "control_event_sync_progress"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = r2
            goto L_0x0039
        L_0x0038:
            r0 = -1
        L_0x0039:
            switch(r0) {
                case 0: goto L_0x0051;
                case 1: goto L_0x004d;
                case 2: goto L_0x0045;
                case 3: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0063
        L_0x003d:
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable r0 = r6.mPlayDrawable
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable$IconState r1 = com.baidu.searchbox.video.videoplayer.widget.PlayDrawable.IconState.PAUSE_STATE
            r0.switchToIconState(r1)
            goto L_0x0063
        L_0x0045:
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable r0 = r6.mPlayDrawable
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable$IconState r1 = com.baidu.searchbox.video.videoplayer.widget.PlayDrawable.IconState.PLAY_STATE
            r0.switchToIconState(r1)
            goto L_0x0063
        L_0x004d:
            r6.togglePanelVisible(r2)
            goto L_0x0063
        L_0x0051:
            int r0 = r7.getIntExtra(r5)
            int r1 = r7.getIntExtra(r4)
            int r2 = r7.getIntExtra(r3)
            com.baidu.searchbox.player.ui.BdLayerSeekBar r3 = r6.mSeekBar
            r3.syncPos(r0, r1, r2)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.layer.AbsControlLayer.onControlEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public void initClarity() {
        int i2;
        ArrayList<Button> arrayList = this.mClarityBtnList;
        if (arrayList != null) {
            arrayList.clear();
            this.mClarityPanel.removeAllViews();
        }
        BdVideoSeries series = getBindPlayer().getVideoSeries();
        ClarityUrlList clarityUrls = null;
        if (series != null) {
            clarityUrls = series.getClarityList();
        }
        if (clarityUrls == null || clarityUrls.size() < 2) {
            this.mClarityButton.setEnabled(false);
            this.mClarityButton.setText(this.mContext.getResources().getString(R.string.clarity_sd));
            return;
        }
        this.mClarityButton.setText(clarityUrls.getDefaultTitle());
        this.mClarityButton.setEnabled(true);
        this.mClarityBtnList = new ArrayList<>(clarityUrls.size());
        if (clarityUrls.getCurrentClarityUrl() != null) {
            this.mCurrentClarity = clarityUrls.getCurrentClarityUrl().getKey();
        }
        Iterator it = clarityUrls.iterator();
        while (it.hasNext()) {
            final ClarityUrlList.ClarityUrl clarityUrl = (ClarityUrlList.ClarityUrl) it.next();
            Button clarityBtn = new Button(this.mContext);
            clarityBtn.setPadding(0, 0, 0, 0);
            clarityBtn.setBackgroundResource(17170445);
            clarityBtn.setGravity(17);
            clarityBtn.setTextSize(0, (float) InvokerUtils.di2pi(12.0f));
            if (clarityUrl.getRank() == clarityUrls.getDefaultClarity()) {
                i2 = this.mContext.getResources().getColor(R.color.video_player_clarity_bt_selected);
            } else {
                i2 = this.mContext.getResources().getColor(R.color.video_player_clarity_bt_unselected);
            }
            clarityBtn.setTextColor(i2);
            clarityBtn.setText(clarityUrl.getTitle());
            clarityBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    BdClarityUtil.setUserOptionClarity(clarityUrl.getOriginRank());
                    String videoUrl = clarityUrl.getUrl();
                    if (!PlayerAbManager.isPackageUrlParamsEnable()) {
                        String url = VideoPlayerRuntime.getVideoPlayerContext().getCDNReplaceURL(videoUrl);
                        if (!TextUtils.equals(url, videoUrl)) {
                            videoUrl = url;
                            AbsControlLayer.this.getBindPlayer().setHasReplaceUrl(true);
                        }
                        clarityUrl.setUrl(videoUrl);
                    }
                    if (AbsControlLayer.this.getStatDispatcher() != null) {
                        AbsControlLayer.this.getStatDispatcher().onClarityChange(AbsControlLayer.this.mCurrentClarity, clarityUrl.getKey(), AbsControlLayer.this.getBindPlayer().isFullMode());
                    }
                    AbsControlLayer.this.getBindPlayer().changeClarityUrl(clarityUrl);
                    AbsControlLayer.this.refreshClarityBtnState((Button) v);
                    AbsControlLayer.this.mClarityButton.setText(clarityUrl.getTitle());
                    AbsControlLayer.this.mClarityPanel.setVisibility(8);
                }
            });
            this.mClarityPanel.addView(clarityBtn, this.mClarityPanelParams);
            this.mClarityBtnList.add(clarityBtn);
        }
    }

    /* access modifiers changed from: private */
    public void refreshClarityBtnState(Button clickedBtn) {
        ArrayList<Button> arrayList = this.mClarityBtnList;
        if (arrayList != null && arrayList.size() >= 1 && clickedBtn != null) {
            Iterator<Button> it = this.mClarityBtnList.iterator();
            while (it.hasNext()) {
                Button clarityBtn = it.next();
                if (clarityBtn.equals(clickedBtn)) {
                    clarityBtn.setTextColor(this.mContext.getResources().getColor(R.color.video_player_clarity_bt_selected));
                    clarityBtn.setClickable(false);
                } else {
                    clarityBtn.setTextColor(this.mContext.getResources().getColor(R.color.video_player_clarity_bt_unselected));
                    clarityBtn.setClickable(true);
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPlayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getAction()
            int r1 = r0.hashCode()
            r2 = 0
            r3 = 1
            switch(r1) {
                case -882902390: goto L_0x003a;
                case -525235558: goto L_0x002f;
                case -461848373: goto L_0x0024;
                case 154871702: goto L_0x0019;
                case 1370689931: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0045
        L_0x000e:
            java.lang.String r1 = "player_event_on_info"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r2
            goto L_0x0046
        L_0x0019:
            java.lang.String r1 = "player_event_on_complete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 3
            goto L_0x0046
        L_0x0024:
            java.lang.String r1 = "player_event_on_error"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 2
            goto L_0x0046
        L_0x002f:
            java.lang.String r1 = "player_event_on_prepared"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r3
            goto L_0x0046
        L_0x003a:
            java.lang.String r1 = "player_event_set_data"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 4
            goto L_0x0046
        L_0x0045:
            r0 = -1
        L_0x0046:
            switch(r0) {
                case 0: goto L_0x0060;
                case 1: goto L_0x0052;
                case 2: goto L_0x004e;
                case 3: goto L_0x004e;
                case 4: goto L_0x004a;
                default: goto L_0x0049;
            }
        L_0x0049:
            goto L_0x0094
        L_0x004a:
            r4.initClarity()
            goto L_0x0094
        L_0x004e:
            r4.togglePanelVisible(r2)
            goto L_0x0094
        L_0x0052:
            com.baidu.searchbox.player.ui.BdLayerSeekBar r0 = r4.mSeekBar
            com.baidu.searchbox.player.BaseVideoPlayer r1 = r4.getBindPlayer()
            int r1 = r1.getDuration()
            r0.setDuration(r1)
            goto L_0x0094
        L_0x0060:
            int r0 = r5.getIntExtra(r3)
            r1 = 904(0x388, float:1.267E-42)
            if (r0 == r1) goto L_0x0083
            r1 = 956(0x3bc, float:1.34E-42)
            if (r0 != r1) goto L_0x006d
            goto L_0x0083
        L_0x006d:
            r1 = 702(0x2be, float:9.84E-43)
            if (r1 != r0) goto L_0x0094
            com.baidu.searchbox.player.BaseVideoPlayer r1 = r4.getBindPlayer()
            boolean r1 = r1.isPlaying()
            if (r1 == 0) goto L_0x0094
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable r1 = r4.mPlayDrawable
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable$IconState r2 = com.baidu.searchbox.video.videoplayer.widget.PlayDrawable.IconState.PAUSE_STATE
            r1.switchToIconState(r2)
            goto L_0x0094
        L_0x0083:
            r4.showBubble()
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable r1 = r4.mPlayDrawable
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable$IconState r2 = com.baidu.searchbox.video.videoplayer.widget.PlayDrawable.IconState.PAUSE_STATE
            r1.switchToIconState(r2)
            android.widget.ImageView r1 = r4.mPlayBtn
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable r2 = r4.mPlayDrawable
            r1.setImageDrawable(r2)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.layer.AbsControlLayer.onPlayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getAction()
            int r1 = r0.hashCode()
            r2 = 6
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            switch(r1) {
                case -1225548796: goto L_0x0057;
                case -915923721: goto L_0x004d;
                case -316059751: goto L_0x0043;
                case -150836531: goto L_0x0039;
                case -150198673: goto L_0x002f;
                case -21461611: goto L_0x0025;
                case 1231554669: goto L_0x001b;
                case 2064424334: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0061
        L_0x0011:
            java.lang.String r1 = "layer_event_position_slide"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r6
            goto L_0x0062
        L_0x001b:
            java.lang.String r1 = "layer_event_lock_screen"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = 4
            goto L_0x0062
        L_0x0025:
            java.lang.String r1 = "layer_event_touch_down"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r4
            goto L_0x0062
        L_0x002f:
            java.lang.String r1 = "layer_event_click_net_tip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = 5
            goto L_0x0062
        L_0x0039:
            java.lang.String r1 = "layer_event_double_click"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r5
            goto L_0x0062
        L_0x0043:
            java.lang.String r1 = "layer_event_adjust_light"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r2
            goto L_0x0062
        L_0x004d:
            java.lang.String r1 = "layer_event_adjust_volume"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = 7
            goto L_0x0062
        L_0x0057:
            java.lang.String r1 = "layer_event_praise_anim_start"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r3
            goto L_0x0062
        L_0x0061:
            r0 = -1
        L_0x0062:
            switch(r0) {
                case 0: goto L_0x00af;
                case 1: goto L_0x009e;
                case 2: goto L_0x0081;
                case 3: goto L_0x007d;
                case 4: goto L_0x0070;
                case 5: goto L_0x006c;
                case 6: goto L_0x0067;
                case 7: goto L_0x0067;
                default: goto L_0x0065;
            }
        L_0x0065:
            goto L_0x00d0
        L_0x0067:
            r7.togglePanelVisible(r6)
            goto L_0x00d0
        L_0x006c:
            r7.togglePanelVisible(r5)
            goto L_0x00d0
        L_0x0070:
            android.os.Handler r0 = r7.mHandler
            com.baidu.searchbox.player.layer.AbsControlLayer$2 r1 = new com.baidu.searchbox.player.layer.AbsControlLayer$2
            r1.<init>()
            r2 = 100
            r0.postDelayed(r1, r2)
            goto L_0x00d0
        L_0x007d:
            r7.clearDismissPanelMsg()
            goto L_0x00d0
        L_0x0081:
            java.lang.String r0 = "AbsControlLayer"
            java.lang.String r1 = "receive touch down event"
            com.baidu.searchbox.player.utils.BdVideoLog.d((java.lang.String) r0, (java.lang.String) r1)
            android.view.ViewGroup r0 = r7.mContainer
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0095
            r0 = r5
            goto L_0x0096
        L_0x0095:
            r0 = r6
        L_0x0096:
            if (r0 != 0) goto L_0x0099
            goto L_0x009a
        L_0x0099:
            r5 = r6
        L_0x009a:
            r7.togglePanelVisible(r5)
            goto L_0x00d0
        L_0x009e:
            boolean r0 = r8.getBooleanExtra(r2)
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable r1 = r7.mPlayDrawable
            if (r0 == 0) goto L_0x00a9
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable$IconState r2 = com.baidu.searchbox.video.videoplayer.widget.PlayDrawable.IconState.PAUSE_STATE
            goto L_0x00ab
        L_0x00a9:
            com.baidu.searchbox.video.videoplayer.widget.PlayDrawable$IconState r2 = com.baidu.searchbox.video.videoplayer.widget.PlayDrawable.IconState.PLAY_STATE
        L_0x00ab:
            r1.switchToIconState(r2)
            goto L_0x00d0
        L_0x00af:
            r7.togglePanelVisible(r6)
            int r0 = r8.getIntExtra(r4)
            int r1 = r8.getIntExtra(r3)
            com.baidu.searchbox.player.ui.BdLayerSeekBar r2 = r7.mSeekBar
            int r3 = r0 + r1
            r2.setPosition(r3)
            com.baidu.searchbox.player.ubc.IControlLayerUbcDispatcher r2 = r7.getStatDispatcher()
            if (r2 == 0) goto L_0x00d0
            com.baidu.searchbox.player.ubc.IControlLayerUbcDispatcher r2 = r7.getStatDispatcher()
            int r3 = r0 + r1
            r2.onSeekBarDrags(r0, r3)
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.layer.AbsControlLayer.onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        super.onPlayerStatusChanged(status, old);
        if (status == PlayerStatus.PLAYING || status == PlayerStatus.PREPARED || status == PlayerStatus.PREPARING) {
            this.mPlayDrawable.switchToIconState(PlayDrawable.IconState.PAUSE_STATE);
        } else {
            this.mPlayDrawable.switchToIconState(PlayDrawable.IconState.PLAY_STATE);
        }
    }

    public void onClick(View v) {
        if (v.equals(this.mPlayBtn)) {
            if (getBindPlayer().isPlaying()) {
                getBindPlayer().pause(1);
                this.mPlayDrawable.toggle(true);
                getBindPlayer().getPlayerCallbackManager().onPauseBtnClick();
            } else {
                if (getBindPlayer().isPause()) {
                    getBindPlayer().resume();
                } else {
                    getBindPlayer().start();
                }
                this.mPlayDrawable.toggle(true);
                getBindPlayer().getPlayerCallbackManager().onStartBtnClick();
            }
            if (getStatDispatcher() != null) {
                getStatDispatcher().onVideoPlay(getBindPlayer().isPlaying());
            }
        } else if (v.equals(this.mClarityButton)) {
            toggleClarityList();
        }
    }

    public void toggleClarityList() {
        LinearLayout linearLayout = this.mClarityPanel;
        linearLayout.setVisibility(linearLayout.getVisibility() == 0 ? 8 : 0);
    }

    public void onProgressChanged(BdThumbSeekBar seekBar, int progress, boolean fromUser) {
    }

    public void onStartTrackingTouch(BdThumbSeekBar seekBar) {
        this.mStartSeekBarPos = getBindPlayer().getPosition();
        clearDismissPanelMsg();
    }

    public void onStopTrackingTouch(BdThumbSeekBar seekBar) {
        VideoEvent event = LayerEvent.obtainEvent(LayerEvent.ACTION_SEEK);
        event.putExtra(1, Integer.valueOf(seekBar.getProgress()));
        sendEvent(event);
        dismissPanelDelay(3000);
        if (getStatDispatcher() != null) {
            getStatDispatcher().onSeekBarDrags(this.mStartSeekBarPos, seekBar.getProgress());
        }
        this.mStartSeekBarPos = 0;
    }

    public void onProgressForward() {
    }

    /* access modifiers changed from: protected */
    public void dismissPanelDelay(int time) {
        clearDismissPanelMsg();
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), (long) time);
    }

    private void clearDismissPanelMsg() {
        this.mHandler.removeMessages(1);
    }

    public void togglePanelVisible(boolean isVisible) {
        this.mHandler.removeMessages(2);
        boolean z = true;
        boolean isAllow = !BaseVideoPlayer.isOrientationLock() || !getBindPlayer().isFullMode();
        if (!isVisible || !isAllow) {
            z = false;
        }
        boolean isVisible2 = z;
        VideoEvent postEvent = LayerEvent.obtainEvent(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED);
        postEvent.putExtra(9, Boolean.valueOf(isVisible2));
        sendEvent(postEvent);
        getBindPlayer().getPlayerCallbackManager().onPanelVisibilityChanged(isVisible2);
        if (isVisible2) {
            ((FrameLayout) this.mContainer).setVisibility(0);
            onPanelVisible();
            dismissPanelDelay(3000);
            if (getStatDispatcher() != null) {
                getStatDispatcher().onPanelVisibilityChanged(getBindPlayer().isFullMode());
                return;
            }
            return;
        }
        this.mClarityPanel.setVisibility(8);
        onPanelGone();
    }

    public void syncStatus() {
        this.mPlayDrawable.switchToIconState(getBindPlayer().isPause() ? PlayDrawable.IconState.PLAY_STATE : PlayDrawable.IconState.PAUSE_STATE);
    }

    /* access modifiers changed from: protected */
    public IControlLayerUbcDispatcher getStatDispatcher() {
        return getBindPlayer().getStatDispatcher();
    }

    /* access modifiers changed from: protected */
    public void handleLayerMessage(Message msg) {
        super.handleLayerMessage(msg);
        if (msg.what == 1) {
            togglePanelVisible(false);
        }
    }

    public void onLayerRelease() {
        super.onLayerRelease();
        this.mSeekBar.setSeekBarHolderListener((IVideoSeekBarListener) null);
    }

    /* access modifiers changed from: protected */
    public void onPanelVisible() {
    }

    /* access modifiers changed from: protected */
    public void onPanelGone() {
    }

    /* access modifiers changed from: protected */
    public void showBubble() {
    }
}
