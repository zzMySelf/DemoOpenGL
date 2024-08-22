package com.baidu.searchbox.player.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.ext.widget.iconfont.IconFontImageView;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.common.matrixstyle.StyleMode;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.player.helper.BarrageLayerController;
import com.baidu.searchbox.player.helper.VideoDownloadHelper;
import com.baidu.searchbox.player.utils.BdVideoAnimationUtils;
import com.baidu.searchbox.player.utils.BdVideoDebug;
import com.baidu.searchbox.player.utils.VideoPlayerSpUtil;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideo;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.constants.VideoPlayerConstants;
import com.baidu.searchbox.video.videoplayer.control.BarrageViewController;
import com.baidu.searchbox.video.videoplayer.event.DanmakuSwitchEvent;
import com.baidu.searchbox.video.videoplayer.event.VideoActionEvent;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerSettings;
import com.baidu.searchbox.video.videoplayer.ui.full.BdVideoBattery;
import com.baidu.searchbox.video.videoplayer.widget.BdTextProgressView;
import com.baidu.searchbox.videoplayer.ui.R;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Locale;

public class BdLayerTitleBarView extends FrameLayout implements View.OnClickListener {
    private static final String TAG = "BdVideoTitleBarView";
    private ImageView mAirPlay;
    private ImageView mBackbtn;
    private boolean mBarrageForceHide;
    private IconFontImageView mBarrageSwitchBtn;
    private BdVideoBattery mBatteryHull;
    private RelativeLayout mContainerRl;
    private final Context mContext;
    private ImageView mDownloadBtn;
    /* access modifiers changed from: private */
    public final WeakReference<ImageView> mDownloadBtnWeakReference;
    private View mFunctionContainer;
    private ITitleBarClick mListener;
    private ImageView mSharePanel;
    private BdTextProgressView mSystemTime;
    private TextView mVideoTitle;

    public interface ITitleBarClick {
        void onAirPlayClick();

        void onBack();

        void onBarrageClick(boolean z);

        void onDownLoad();

        void onShareClick();
    }

    public BdLayerTitleBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BdLayerTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mVideoTitle = null;
        this.mBatteryHull = null;
        this.mSystemTime = null;
        this.mBarrageForceHide = false;
        this.mContext = context;
        init();
        this.mDownloadBtnWeakReference = new WeakReference<>(this.mDownloadBtn);
    }

    private void init() {
        LayoutInflater.from(this.mContext).cloneInContext(this.mContext).inflate(R.layout.videoplayer_bd_layer_control_titlebar_layout, this);
        this.mContainerRl = (RelativeLayout) findViewById(R.id.main_container);
        ImageView imageView = (ImageView) findViewById(R.id.main_title_back_button);
        this.mBackbtn = imageView;
        imageView.setOnClickListener(this);
        this.mVideoTitle = (TextView) findViewById(R.id.main_title_text);
        ImageView imageView2 = (ImageView) findViewById(R.id.main_download_button);
        this.mDownloadBtn = imageView2;
        imageView2.setOnClickListener(this);
        BdVideoBattery bdVideoBattery = (BdVideoBattery) findViewById(R.id.main_battery_view);
        this.mBatteryHull = bdVideoBattery;
        bdVideoBattery.setImage(com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_player_batteryhull);
        ImageView imageView3 = (ImageView) findViewById(R.id.main_share_button);
        this.mSharePanel = imageView3;
        imageView3.setOnClickListener(this);
        initBarrageSwitchBtn();
        refreshBarrageStatus();
        this.mSystemTime = (BdTextProgressView) findViewById(R.id.main_system_time_text);
        updateTimeText();
        this.mFunctionContainer = findViewById(R.id.top_function_container);
        ImageView imageView4 = (ImageView) findViewById(R.id.iv_air_play_button);
        this.mAirPlay = imageView4;
        imageView4.setOnClickListener(this);
    }

    public void updateTimeText() {
        int hour = Calendar.getInstance().get(11);
        int minute = Calendar.getInstance().get(12);
        this.mSystemTime.setTimeText(String.format(Locale.US, "%02d:%02d", new Object[]{Integer.valueOf(hour), Integer.valueOf(minute)}));
    }

    public void setListener(ITitleBarClick listener) {
        this.mListener = listener;
    }

    private void initBarrageSwitchBtn() {
        IconFontImageView iconFontImageView = (IconFontImageView) findViewById(R.id.main_barrage_button);
        this.mBarrageSwitchBtn = iconFontImageView;
        iconFontImageView.setFontPath(com.baidu.searchbox.common.iconfont.R.string.comment_iconfont_path);
        this.mBarrageSwitchBtn.setIconFontColorId(com.baidu.searchbox.videoplayer.business.R.color.video_barrage_switch_nomal_color);
        this.mBarrageSwitchBtn.setPressedIconFontColorId(com.baidu.searchbox.videoplayer.business.R.color.video_barrage_switch_pressed_color);
        this.mBarrageSwitchBtn.setOnClickListener(this);
        setBarrageVisible(true);
    }

    public void refreshBarrageStatus() {
        toggleBarrageSwitch();
        setBarrageVisible(BarrageLayerController.hasBarrage());
        boolean disable = BarrageViewController.barrageDisable();
        this.mBarrageSwitchBtn.setEnabled(!disable);
        this.mBarrageSwitchBtn.setAlpha(disable ? 0.5f : 1.0f);
    }

    public void show(boolean isAnimate) {
        if (isAnimate) {
            startAnimation(BdVideoAnimationUtils.getTopInAnimation());
        }
        updateTimeText();
        setVisibility(0);
    }

    public void show(boolean isAnimate, boolean hideBg) {
        if (hideBg) {
            this.mContainerRl.setBackgroundColor(getContext().getResources().getColor(R.color.videoplayer_transparent));
        } else {
            this.mContainerRl.setBackground(getCompatDrawable(com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_control_title_background));
        }
        refreshBarrageStatus();
        show(isAnimate);
    }

    public void show(boolean isAnimate, boolean hideBg, boolean isInteractVideo) {
        show(isAnimate, hideBg);
        setOnlyShowBackIcon(isInteractVideo);
    }

    public void setOnlyShowBackIcon(boolean onlyShowBackIcon) {
        View view2 = this.mFunctionContainer;
        if (view2 != null) {
            view2.setVisibility(onlyShowBackIcon ? 8 : 0);
        }
    }

    public void hide(boolean isAnimate) {
        if (isAnimate) {
            startAnimation(BdVideoAnimationUtils.getTopOutAnimation());
        }
        setVisibility(4);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public void setVideoTitle(String aTitle, int titleSize) {
        this.mVideoTitle.setText(aTitle);
        this.mVideoTitle.setTypeface(Typeface.DEFAULT_BOLD);
        this.mVideoTitle.setTextSize(0, (float) titleSize);
    }

    public void updateDownloadBtn(BdVideoSeries bdVideoSeries) {
        if (InvokerSettings.IS_FROM_FEED || StyleMode.INSTANCE.isTeenagerStyle()) {
            this.mDownloadBtn.setVisibility(8);
        } else if (VideoDownloadHelper.checkVideoDownloadDisabled(bdVideoSeries)) {
            this.mDownloadBtn.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_video_full_download_disabled, (Resources.Theme) null));
            this.mDownloadBtn.setEnabled(false);
        } else {
            String uniqueKey = "";
            if (!TextUtils.isEmpty(bdVideoSeries.getVid())) {
                uniqueKey = bdVideoSeries.getVid();
            } else {
                BdVideo bdVideo = bdVideoSeries.getSelectedVideo();
                if (bdVideo != null) {
                    uniqueKey = bdVideo.getPlayUrl();
                }
            }
            VideoDownloadHelper.queryDownloadStatusFromDb(uniqueKey, new VideoDownloadHelper.IQueryDownloadStatusListener() {
                public void onQueryResult(final int downloadStatus) {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            int id;
                            if (BdLayerTitleBarView.this.mDownloadBtnWeakReference.get() != null) {
                                ((ImageView) BdLayerTitleBarView.this.mDownloadBtnWeakReference.get()).setEnabled(true);
                                if (downloadStatus == 200) {
                                    id = com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_new_player_top_download_already_button_selector;
                                } else {
                                    id = com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_new_player_top_download_enable_button_selector;
                                }
                                ((ImageView) BdLayerTitleBarView.this.mDownloadBtnWeakReference.get()).setImageDrawable(BdLayerTitleBarView.this.getCompatDrawable(id));
                            }
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public Drawable getCompatDrawable(int id) {
        ContextCompat.getDrawable(getContext(), id);
        return ResourcesCompat.getDrawable(getContext().getResources(), id, (Resources.Theme) null);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getY() < ((float) BdVideoDebug.BAR_HEIGHT)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void onClick(View v) {
        ITitleBarClick iTitleBarClick;
        if (v.equals(this.mBackbtn)) {
            BdEventBus.Companion.getDefault().post(new VideoActionEvent("back"));
            ITitleBarClick iTitleBarClick2 = this.mListener;
            if (iTitleBarClick2 != null) {
                iTitleBarClick2.onBack();
            }
        } else if (v.equals(this.mDownloadBtn)) {
            ITitleBarClick iTitleBarClick3 = this.mListener;
            if (iTitleBarClick3 != null) {
                iTitleBarClick3.onDownLoad();
            }
        } else if (v.equals(this.mSharePanel)) {
            ITitleBarClick iTitleBarClick4 = this.mListener;
            if (iTitleBarClick4 != null) {
                iTitleBarClick4.onShareClick();
            }
        } else if (v.equals(this.mBarrageSwitchBtn)) {
            boolean isBarrageOpen = BarrageLayerController.isBarrageOn();
            BarrageViewController.saveBarrageSwitchToSp(!isBarrageOpen);
            BarrageLayerController.setBarrageOn(!isBarrageOpen);
            toggleBarrageSwitch();
            if (!isBarrageOpen) {
                BdEventBus.Companion.getDefault().post(new DanmakuSwitchEvent(true));
                ITitleBarClick iTitleBarClick5 = this.mListener;
                if (iTitleBarClick5 != null) {
                    iTitleBarClick5.onBarrageClick(true);
                }
            } else {
                BdEventBus.Companion.getDefault().post(new DanmakuSwitchEvent(false));
                ITitleBarClick iTitleBarClick6 = this.mListener;
                if (iTitleBarClick6 != null) {
                    iTitleBarClick6.onBarrageClick(false);
                }
            }
            VideoPlayerSpUtil.getInstance().putBoolean(VideoPlayerConstants.USER_CLICKED_BARRAGE_BTN, true);
        } else if (v.equals(this.mAirPlay) && (iTitleBarClick = this.mListener) != null) {
            iTitleBarClick.onAirPlayClick();
        }
    }

    public void setDownloadBtnVisible(boolean visible) {
        ImageView imageView = this.mDownloadBtn;
        if (imageView != null) {
            imageView.setVisibility(visible ? 0 : 8);
        }
    }

    public void setBatteryHullVisible(boolean visible) {
        BdVideoBattery bdVideoBattery = this.mBatteryHull;
        if (bdVideoBattery != null) {
            bdVideoBattery.setVisibility(visible ? 0 : 8);
        }
    }

    public void setSystemTimeVisible(boolean visible) {
        BdTextProgressView bdTextProgressView = this.mSystemTime;
        if (bdTextProgressView != null) {
            bdTextProgressView.setVisibility(visible ? 0 : 8);
        }
    }

    private void setBarrageVisible(boolean visible) {
        IconFontImageView iconFontImageView = this.mBarrageSwitchBtn;
        if (iconFontImageView != null && !this.mBarrageForceHide) {
            iconFontImageView.setVisibility(visible ? 0 : 8);
        }
    }

    public void setBarrageForceHide() {
        setBarrageVisible(false);
        this.mBarrageForceHide = true;
    }

    public void changeShareBtnVisibility(int visible) {
        if (visible != this.mSharePanel.getVisibility()) {
            this.mSharePanel.setVisibility(visible);
        }
    }

    private void toggleBarrageSwitch() {
        if (BarrageViewController.getBarrageSwitchFromSp()) {
            this.mBarrageSwitchBtn.setIconFont(com.baidu.searchbox.common.iconfont.R.string.comment_barrage_open);
        } else {
            this.mBarrageSwitchBtn.setIconFont(com.baidu.searchbox.common.iconfont.R.string.comment_barrage_close);
        }
    }

    public void openBarrage() {
        setBarrageVisible(true);
        this.mBarrageSwitchBtn.setIconFont(com.baidu.searchbox.common.iconfont.R.string.comment_barrage_open);
    }

    public void closeBarrage() {
        setBarrageVisible(true);
        this.mBarrageSwitchBtn.setIconFont(com.baidu.searchbox.common.iconfont.R.string.comment_barrage_close);
    }

    public void hideBarrageBtn() {
        setBarrageVisible(false);
    }

    public void disableBarrageSend(boolean disable, BarrageLayerController controller) {
        int newDanmakuSendStatus = !disable;
        int lastDanmakuSendStatus = BarrageViewController.sLastDanmakuSendStatus;
        if (lastDanmakuSendStatus == -1 || lastDanmakuSendStatus != newDanmakuSendStatus) {
            if (disable) {
                BarrageViewController.sBarrageSwitchBeforeDisabled = BarrageViewController.getBarrageSwitchFromSp();
                BarrageViewController.saveBarrageSwitchToSp(false);
                updateBarrageVisibility(false, controller);
            } else {
                if (BarrageViewController.sLastDanmakuSendStatus == -1) {
                    BarrageViewController.sBarrageSwitchBeforeDisabled = BarrageViewController.getBarrageSwitchFromSp();
                }
                BarrageViewController.saveBarrageSwitchToSp(BarrageViewController.sBarrageSwitchBeforeDisabled);
                updateBarrageVisibility(BarrageViewController.sBarrageSwitchBeforeDisabled, controller);
            }
            BarrageViewController.sLastDanmakuSendStatus = (int) newDanmakuSendStatus;
            this.mBarrageSwitchBtn.setEnabled(!disable);
            this.mBarrageSwitchBtn.setAlpha(disable ? 0.5f : 1.0f);
        }
    }

    public void updateBarrageVisibility(boolean isOn, BarrageLayerController controler) {
        if (BarrageViewController.hasBarrage()) {
            BarrageViewController.setBarrageOn(isOn);
            if (isOn) {
                openBarrage();
            } else {
                closeBarrage();
            }
        } else {
            hideBarrageBtn();
        }
    }

    public void updateBarrageVisibility(boolean isOn) {
        if (BarrageViewController.hasBarrage()) {
            BarrageViewController.setBarrageOn(isOn);
            if (isOn) {
                setBarrageVisible(true);
                this.mBarrageSwitchBtn.setIconFont(com.baidu.searchbox.common.iconfont.R.string.comment_barrage_open);
                return;
            }
            setBarrageVisible(true);
            this.mBarrageSwitchBtn.setIconFont(com.baidu.searchbox.common.iconfont.R.string.comment_barrage_close);
            return;
        }
        hideBarrageBtn();
    }

    public void updateAirPlayVisibility(int visibility) {
        this.mAirPlay.setVisibility(visibility);
    }
}
