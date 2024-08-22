package com.baidu.searchbox.gamecore.widget.dialog.gameguide;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.base.utils.UIUtils;
import com.baidu.searchbox.base.widget.BaseDialog;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.config.GameConfigDataManager;
import com.baidu.searchbox.gamecore.config.data.model.GameGuideDialogData;
import com.baidu.searchbox.gamecore.ubc.GameCenterUBCUtil;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.searchbox.gamecore.widget.view.VideoSurfaceView;
import com.baidu.searchbox.net.MediaPlayerTracker;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import java.util.Map;

public class GameGuideDialog extends BaseDialog {
    public static final String KEY_FIRST_OLD_GAMECENTER_TIME = "first_old_gamecenter_time";
    private static final String NEW_GAME_CENTER_SCHEME = "baiduboxapp://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/home/index?_baiduboxapp=%7B%22from%22%3A%221241009500000000%22%2C%22ext%22%3A%7B%7D%7D";
    private static final String SCHEME_NAME = "scheme_name";
    private static final String SCHEME_TYPE = "scheme_type";
    private static final long SECOND_TIME = 1000;
    private static final String USER_KIND = "user_kind";
    /* access modifiers changed from: private */
    public Boolean isVideo = true;
    private ImageView mCloseButton;
    /* access modifiers changed from: private */
    public TextView mCountDownText;
    /* access modifiers changed from: private */
    public CountDownTimer mCountDownTimer;
    /* access modifiers changed from: private */
    public HashMap<String, String> mExtInfo;
    private GameGuideDialogData mGameGuideDialogData;
    /* access modifiers changed from: private */
    public SimpleDraweeView mImage;
    private Button mPlayButton;
    /* access modifiers changed from: private */
    public String mScheme = NEW_GAME_CENTER_SCHEME;
    /* access modifiers changed from: private */
    public VideoSurfaceView mVideoView;
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    public Boolean needCountDown = true;

    public GameGuideDialog(Context context) {
        super(context, R.style.NoTitleDialog);
        init();
    }

    private void init() {
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.game_minigame_guide_dialog);
        this.mImage = (SimpleDraweeView) findViewById(R.id.game_guide_image_top);
        this.mVideoView = (VideoSurfaceView) findViewById(R.id.game_guide_video);
        int radius = UIUtils.dip2px(getContext(), 12.0f);
        this.mVideoView.setCornerRadius((float) radius, (float) radius, 0.0f, 0.0f);
        this.mPlayButton = (Button) findViewById(R.id.game_guide_play_game);
        this.mCountDownText = (TextView) findViewById(R.id.game_guide_countdown_text);
        this.mCloseButton = (ImageView) findViewById(R.id.game_guide_dialog_exit);
        this.mGameGuideDialogData = GameConfigDataManager.getInstance().getGameGuideDialogData();
        this.mExtInfo = new HashMap<>();
        parseData();
        initListener();
    }

    private void parseData() {
        if (this.mGameGuideDialogData != null) {
            this.mImage.setImageResource(R.drawable.game_guide_picture_bg);
            if (!TextUtils.isEmpty(this.mGameGuideDialogData.getImageurl())) {
                this.mImage.setImageURI(this.mGameGuideDialogData.getImageurl());
                this.mImage.setVisibility(0);
            } else {
                this.mImage.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mGameGuideDialogData.getVideo())) {
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                this.mediaPlayer = mediaPlayer2;
                try {
                    MediaPlayerTracker.setDataSource(mediaPlayer2, this.mGameGuideDialogData.getVideo());
                    this.mVideoView.setMediaPlayer(this.mediaPlayer);
                } catch (Exception e2) {
                    this.mediaPlayer.release();
                    e2.printStackTrace();
                }
                this.isVideo = true;
            } else {
                this.mVideoView.setVisibility(8);
            }
            HashMap<String, String> hashMap = this.mExtInfo;
            if (hashMap != null) {
                hashMap.put(USER_KIND, GameCenterUtils.getUserKind());
                if (!TextUtils.isEmpty(this.mGameGuideDialogData.getSchemename())) {
                    this.mExtInfo.put(SCHEME_NAME, this.mGameGuideDialogData.getSchemename());
                }
                this.mExtInfo.put(SCHEME_TYPE, this.mGameGuideDialogData.getSchemetype() + "");
            }
            if (!TextUtils.isEmpty(this.mGameGuideDialogData.getText())) {
                this.mPlayButton.setText(this.mGameGuideDialogData.getText());
            }
            if (this.mGameGuideDialogData.getCountdownswitch() != null) {
                this.needCountDown = this.mGameGuideDialogData.getCountdownswitch();
            }
            if (!TextUtils.isEmpty(this.mGameGuideDialogData.getScheme())) {
                this.mScheme = this.mGameGuideDialogData.getScheme();
            }
        }
    }

    public void show() {
        super.show();
        if (this.needCountDown.booleanValue()) {
            GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "show", GameUBCConst.VALUE_NEW_GAMEGUIDE_COUNTDOWN_DIALOG, GameUBCConst.PAGE_FIND_PAGE, (Map<String, String>) this.mExtInfo);
            this.mCountDownTimer = new CountDownTimer(3000, 1000) {
                public void onTick(long millisUntilFinished) {
                    GameGuideDialog.this.mCountDownText.setText(GameGuideDialog.this.getContext().getResources().getString(R.string.game_count_down_text, new Object[]{Long.valueOf((millisUntilFinished / 1000) + 1)}));
                }

                public void onFinish() {
                    GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, GameUBCConst.TYPE_AUTO_ENTER, GameUBCConst.VALUE_NEW_GAMEGUIDE_COUNTDOWN_DIALOG, GameUBCConst.PAGE_FIND_PAGE, (Map<String, String>) GameGuideDialog.this.mExtInfo);
                    SchemeRouter.invokeSchemeForInner(GameGuideDialog.this.getContext(), Uri.parse(GameGuideDialog.this.mScheme));
                    try {
                        if (GameGuideDialog.this.isShowing()) {
                            GameGuideDialog.this.dismiss();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            };
        } else {
            GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "show", GameUBCConst.VALUE_NEW_GAMEGUIDE_DIALOG, GameUBCConst.PAGE_FIND_PAGE, (Map<String, String>) this.mExtInfo);
            this.mCountDownText.setVisibility(8);
        }
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    if (GameGuideDialog.this.isVideo.booleanValue() && GameGuideDialog.this.mVideoView != null && GameGuideDialog.this.isShowing()) {
                        GameGuideDialog.this.mImage.setVisibility(8);
                        GameGuideDialog.this.mVideoView.setVisibility(0);
                        if (GameGuideDialog.this.needCountDown.booleanValue()) {
                            GameGuideDialog.this.mCountDownTimer.start();
                        }
                        GameGuideDialog.this.mediaPlayer.start();
                    }
                }
            });
        } else if (this.needCountDown.booleanValue()) {
            this.mCountDownTimer.start();
        }
    }

    public void dismiss() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            if (mediaPlayer2.isPlaying()) {
                this.mediaPlayer.stop();
            }
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mCountDownTimer = null;
        }
        super.dismiss();
    }

    private void initListener() {
        this.mCloseButton.setOnTouchListener(alphaChange());
        this.mCloseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (GameGuideDialog.this.needCountDown.booleanValue()) {
                    GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "close_click", GameUBCConst.VALUE_NEW_GAMEGUIDE_COUNTDOWN_DIALOG, GameUBCConst.PAGE_FIND_PAGE, (Map<String, String>) GameGuideDialog.this.mExtInfo);
                } else {
                    GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "close_click", GameUBCConst.VALUE_NEW_GAMEGUIDE_DIALOG, GameUBCConst.PAGE_FIND_PAGE, (Map<String, String>) GameGuideDialog.this.mExtInfo);
                }
                GameGuideDialog.this.dismiss();
            }
        });
        this.mPlayButton.setOnTouchListener(alphaChange());
        this.mPlayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (GameGuideDialog.this.needCountDown.booleanValue()) {
                    GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, GameUBCConst.TYPE_ENTER_CLICK, GameUBCConst.VALUE_NEW_GAMEGUIDE_COUNTDOWN_DIALOG, GameUBCConst.PAGE_FIND_PAGE, (Map<String, String>) GameGuideDialog.this.mExtInfo);
                } else {
                    GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, GameUBCConst.TYPE_ENTER_CLICK, GameUBCConst.VALUE_NEW_GAMEGUIDE_DIALOG, GameUBCConst.PAGE_FIND_PAGE, (Map<String, String>) GameGuideDialog.this.mExtInfo);
                }
                SchemeRouter.invokeSchemeForInner(GameGuideDialog.this.getContext(), Uri.parse(GameGuideDialog.this.mScheme));
                GameGuideDialog.this.dismiss();
            }
        });
    }

    public void cancel() {
        super.cancel();
        if (this.needCountDown.booleanValue()) {
            GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "back_click", GameUBCConst.VALUE_NEW_GAMEGUIDE_COUNTDOWN_DIALOG, GameUBCConst.PAGE_FIND_PAGE, (Map<String, String>) this.mExtInfo);
        } else {
            GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "back_click", GameUBCConst.VALUE_NEW_GAMEGUIDE_DIALOG, GameUBCConst.PAGE_FIND_PAGE, (Map<String, String>) this.mExtInfo);
        }
    }

    private View.OnTouchListener alphaChange() {
        return new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        v.setAlpha(0.2f);
                        return false;
                    case 1:
                    case 3:
                        v.setAlpha(1.0f);
                        return false;
                    default:
                        return false;
                }
            }
        };
    }
}
