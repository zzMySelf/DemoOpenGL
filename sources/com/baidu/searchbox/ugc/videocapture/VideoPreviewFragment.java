package com.baidu.searchbox.ugc.videocapture;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.appframework.fragment.BaseFragment;
import com.baidu.searchbox.publisher.base.Utils;
import com.baidu.searchbox.publisher.videobusiness.R;
import com.baidu.searchbox.rewardsystem.newtimer.constants.NewTimerConstants;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import java.util.Locale;

public class VideoPreviewFragment extends BaseFragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    private static final String EXTRA_PARAMS = "params";
    private static final String EXTRA_VIDEO_PARAMS = "video_params";
    private static final int SEEK_TIME_SCHEDULE = 200;
    private static final int UPDATE_VIDEO_SEEKBAR = 0;
    /* access modifiers changed from: private */
    public String heigthVideo;
    private ObjectAnimator mAnimatorBackIv;
    private ObjectAnimator mAnimatorCompleteIv;
    private ImageView mBackIv;
    private ImageView mCompleteIv;
    private String mFileName;
    private boolean mIsNeedDeleteFile = true;
    private boolean mIsStart = true;
    /* access modifiers changed from: private */
    public OnResultListener mOnResultListener;
    private int mProgress;
    private View mProgressbarLayout;
    private View mRootView;
    /* access modifiers changed from: private */
    public SeekBar mSeekBar;
    private TextView mVideoCurTimeText;
    private VideoParams mVideoParams;
    private TextView mVideoTotalTimeText;
    /* access modifiers changed from: private */
    public VideoView mVideoView;
    private int totalTime;
    /* access modifiers changed from: private */
    public Handler videoHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (VideoPreviewFragment.this.mVideoView.isPlaying()) {
                        VideoPreviewFragment.this.mSeekBar.setProgress(VideoPreviewFragment.this.mVideoView.getCurrentPosition());
                        VideoPreviewFragment.this.videoHandler.sendEmptyMessageDelayed(0, 200);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    /* access modifiers changed from: private */
    public String widthVideo;

    public interface OnResultListener {
        void onCancel();

        void onOK(String str);
    }

    public static VideoPreviewFragment newInstance(String fileName, VideoParams params) {
        VideoPreviewFragment fragment = new VideoPreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("params", fileName);
        bundle.putSerializable(EXTRA_VIDEO_PARAMS, params);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view2 = inflater.inflate(R.layout.ugc_video_capture_preview_fragment, (ViewGroup) null);
        this.mRootView = view2;
        this.mVideoParams = (VideoParams) getArguments().getSerializable(EXTRA_VIDEO_PARAMS);
        this.mFileName = getArguments().getString("params");
        this.mBackIv = (ImageView) view2.findViewById(R.id.back_iv);
        this.mCompleteIv = (ImageView) view2.findViewById(R.id.complete_iv);
        this.mVideoView = (VideoView) view2.findViewById(R.id.video_view);
        this.mSeekBar = (SeekBar) view2.findViewById(R.id.ugc_videoseekBar);
        this.mVideoCurTimeText = (TextView) view2.findViewById(R.id.ugc_videocurtime);
        this.mVideoTotalTimeText = (TextView) view2.findViewById(R.id.ugc_videototaltime);
        this.mProgressbarLayout = view2.findViewById(R.id.ugc_videocontrollerlayout);
        this.mBackIv.setOnClickListener(this);
        this.mCompleteIv.setOnClickListener(this);
        updateUi();
        startAnimator(true, (Runnable) null);
        if (!TextUtils.isEmpty(this.mFileName)) {
            try {
                MediaMetadataRetriever mmr = FileUtils.getMediaMetadataRetriever(this.mFileName);
                if (mmr != null) {
                    this.totalTime = Integer.parseInt(mmr.extractMetadata(9));
                    this.heigthVideo = mmr.extractMetadata(19);
                    this.widthVideo = mmr.extractMetadata(18);
                    mmr.release();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.mVideoView.getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            view2.findViewById(R.id.ugc_capture_preview_fragment_root).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    try {
                        View fragmentRoot = view2.findViewById(R.id.ugc_capture_preview_fragment_root);
                        int heigth = fragmentRoot.getHeight();
                        int width = fragmentRoot.getWidth();
                        if (heigth > 0 && width > 0 && Integer.parseInt(VideoPreviewFragment.this.heigthVideo) > 0 && Integer.parseInt(VideoPreviewFragment.this.widthVideo) > 0) {
                            if (((float) (heigth / width)) < Float.parseFloat(VideoPreviewFragment.this.widthVideo) / Float.parseFloat(VideoPreviewFragment.this.heigthVideo)) {
                                params.height = heigth;
                                params.width = (Integer.parseInt(VideoPreviewFragment.this.heigthVideo) * heigth) / Integer.parseInt(VideoPreviewFragment.this.widthVideo);
                                VideoPreviewFragment.this.mVideoView.setLayoutParams(params);
                            } else if (((float) (heigth / width)) == Float.parseFloat(VideoPreviewFragment.this.widthVideo) / Float.parseFloat(VideoPreviewFragment.this.heigthVideo)) {
                                params.height = heigth;
                                params.width = width;
                                VideoPreviewFragment.this.mVideoView.setLayoutParams(params);
                            } else {
                                params.width = width;
                                params.height = (Integer.parseInt(VideoPreviewFragment.this.widthVideo) * width) / Integer.parseInt(VideoPreviewFragment.this.heigthVideo);
                                VideoPreviewFragment.this.mVideoView.setLayoutParams(params);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
        this.mSeekBar.setOnSeekBarChangeListener(this);
        this.mVideoView.setOnCompletionListener(this);
        this.mVideoView.setOnErrorListener(this);
        this.mVideoView.setOnPreparedListener(this);
        try {
            this.mSeekBar.setEnabled(false);
            this.mVideoView.setVideoURI(Uri.parse(this.mFileName));
            this.mVideoView.start();
        } catch (Exception e3) {
            e3.printStackTrace();
            playError();
        }
        UgcUBCUtils.ubcUgcPublishBehavior(UgcUBCUtils.UBC_UGC_VIDEO_PREVIEW_PAGE, "display", "1");
        return view2;
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        updateUi();
    }

    private void updateUi() {
        View view2 = this.mRootView;
        if (view2 != null) {
            UiBaseUtils.setViewColor(view2.findViewById(R.id.ugc_capture_preview_fragment_root), com.baidu.searchbox.ugc.album.R.color.ugc_common_black);
        }
        UiBaseUtils.setImageResource(this.mBackIv, com.baidu.searchbox.ugc.base.R.drawable.ugc_capture_back_selector);
        UiBaseUtils.setImageResource(this.mCompleteIv, com.baidu.searchbox.ugc.base.R.drawable.ugc_capture_complete_selector);
        UiBaseUtils.setProgressResource(this.mSeekBar, com.baidu.searchbox.ugc.base.R.drawable.ugc_video_progress_drawable);
        UiBaseUtils.setProgressThumb(this.mSeekBar, com.baidu.searchbox.ugc.base.R.drawable.ugc_video_progress_thumb);
        UiBaseUtils.setTextResource(this.mVideoCurTimeText, com.baidu.searchbox.ugc.album.R.color.ugc_video_curtime);
        UiBaseUtils.setTextResource(this.mVideoTotalTimeText, com.baidu.searchbox.ugc.album.R.color.ugc_video_curtime);
    }

    public void onPrepared(MediaPlayer mp) {
        if (this.mIsStart) {
            long[] time = Utils.getMinuteAndSecond(this.totalTime);
            this.mVideoTotalTimeText.setText(String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Long.valueOf(time[0]), Long.valueOf(time[1])}));
            this.mSeekBar.setMax(this.totalTime);
            this.mSeekBar.setEnabled(true);
            this.videoHandler.sendEmptyMessage(0);
            this.mIsStart = false;
            return;
        }
        this.mVideoView.seekTo(this.mProgress);
        this.mVideoView.start();
        this.videoHandler.sendEmptyMessage(0);
    }

    public void onCompletion(MediaPlayer mp) {
        try {
            this.mVideoView.setVideoURI(Uri.parse(this.mFileName));
            this.mVideoView.start();
        } catch (Exception e2) {
            e2.printStackTrace();
            playError();
        }
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        playError();
        return true;
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        long[] time = Utils.getMinuteAndSecond(progress);
        this.mVideoCurTimeText.setText(String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Long.valueOf(time[0]), Long.valueOf(time[1])}));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.mVideoView.pause();
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.mVideoView.seekTo(this.mSeekBar.getProgress());
        this.mVideoView.start();
        this.videoHandler.sendEmptyMessage(0);
    }

    private void startAnimator(boolean isShowButtonsAnimator, Runnable animatorFinishCallback) {
        int moveToCompleteIv;
        int moveToBackIv;
        int moveFromCompleteIv;
        int moveFromBackIv;
        String propertyName;
        int rotation = getActivity().getWindowManager().getDefaultDisplay().getRotation();
        int moveDistance = getResources().getDimensionPixelSize(com.baidu.searchbox.ugc.album.R.dimen.video_capture_preview_control_button_move);
        if (rotation == 0) {
            propertyName = "translationX";
            if (isShowButtonsAnimator) {
                this.mBackIv.setTranslationX((float) moveDistance);
                this.mCompleteIv.setTranslationX((float) (-moveDistance));
                moveFromBackIv = 0;
                moveFromCompleteIv = 0;
                moveToBackIv = -moveDistance;
                moveToCompleteIv = moveDistance;
            } else {
                moveFromBackIv = -moveDistance;
                moveFromCompleteIv = moveDistance;
                moveToBackIv = 0;
                moveToCompleteIv = 0;
            }
        } else {
            propertyName = NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY;
            if (isShowButtonsAnimator) {
                moveFromBackIv = 0;
                moveFromCompleteIv = 0;
                moveToBackIv = moveDistance;
                moveToCompleteIv = -moveDistance;
            } else {
                moveFromBackIv = moveDistance;
                moveFromCompleteIv = -moveDistance;
                moveToBackIv = 0;
                moveToCompleteIv = 0;
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mBackIv, propertyName, new float[]{(float) moveFromBackIv, (float) moveToBackIv});
        this.mAnimatorBackIv = ofFloat;
        ofFloat.setDuration(300);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mCompleteIv, propertyName, new float[]{(float) moveFromCompleteIv, (float) moveToCompleteIv});
        this.mAnimatorCompleteIv = ofFloat2;
        ofFloat2.setDuration(300);
        final Runnable runnable = animatorFinishCallback;
        this.mAnimatorBackIv.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }

            public void onAnimationEnd(Animator animation) {
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        this.mAnimatorBackIv.start();
        this.mAnimatorCompleteIv.start();
    }

    public void onClick(View v) {
        int i2 = v.getId();
        if (i2 == R.id.back_iv) {
            startAnimator(false, new Runnable() {
                public void run() {
                    if (VideoPreviewFragment.this.mOnResultListener != null) {
                        VideoPreviewFragment.this.mOnResultListener.onCancel();
                    }
                }
            });
            UgcUBCUtils.clickLayerStatistics(0, UgcUBCUtils.mVideoShootcheckBtnPage);
        } else if (i2 == R.id.complete_iv) {
            this.mIsNeedDeleteFile = false;
            OnResultListener onResultListener = this.mOnResultListener;
            if (onResultListener != null) {
                onResultListener.onOK(this.mFileName);
            }
            UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mVideoShootcheckBtnPage);
            UgcUBCUtils.ubcUgcPublishBehavior(UgcUBCUtils.UBC_UGC_VIDEO_PREVIEW_PAGE, UgcUBCUtils.UBC_UGC_BTN_FINISH_CLK_TYPE, "1");
        }
    }

    public void onStart() {
        super.onStart();
        UgcUBCUtils.enterUgc();
    }

    public void onStop() {
        UgcUBCUtils.exitPages(1, UgcUBCUtils.mPublishShootpreviewPage);
        try {
            this.mProgress = this.mSeekBar.getProgress();
            this.mVideoView.pause();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onStop();
    }

    private void playError() {
        UniversalToast.makeText(getContext().getApplicationContext(), com.baidu.searchbox.ugc.album.R.string.video_capture_video_preview_play_error).showToast();
        OnResultListener onResultListener = this.mOnResultListener;
        if (onResultListener != null) {
            onResultListener.onCancel();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mVideoView.stopPlayback();
        this.videoHandler.removeMessages(0);
        ObjectAnimator objectAnimator = this.mAnimatorBackIv;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.mAnimatorCompleteIv;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        if (this.mIsNeedDeleteFile) {
            VideoUtils.deleteFile(this.mFileName);
        }
    }

    public void setOnResultListener(OnResultListener listener) {
        this.mOnResultListener = listener;
    }
}
