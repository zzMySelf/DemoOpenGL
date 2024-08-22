package com.baidu.searchbox.search.tab.implement.player.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.player.utils.ViewUtil;
import com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonBigImageModel;
import com.baidu.searchbox.search.tab.utils.SearchVideoTcUtils;
import com.baidu.searchbox.search.tab.utils.VideoLoftCmdUtils;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils;
import com.baidu.searchbox.videoplayer.widget.R;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoCommonPlayerNodeSeekBar extends View {
    private static final int BUFFERING_PAINT_COLOR = -2039584;
    private static final float DEFAULT_MAX = 100.0f;
    private static final BdSeekBarStyle DEFAULT_STYLE = BdSeekBarStyle.LINE;
    public static final int KEYFRAME_MESSAGE = 2;
    private static final float MIN_MAX = 0.1f;
    private static final int MIN_ROUND_HEIGHT = 5;
    public static final int PLAYED_PAINT_COLOR = -16738561;
    public static final int PROGRESS_MESSAGE = 1;
    private static final boolean SEEKBAR_SCALE_FLAG = true;
    private static final int STYLE_DEFAULT = 0;
    private static final int STYLE_LINE = 1;
    private static final int STYLE_ROUND_RECT = 2;
    private static final String TAG = "SearchTabSeekBar";
    private static final int UI_DRAG_TRACE_COLOR = -2130706433;
    private static final int UI_SEEKBAR_DEFAULT_PADDING = 0;
    private static final int UI_SEEKBAR_DEFAULT_WIDTH = 50;
    private static final int UI_SEEKBAR_RIGHT_PADDING = 5;
    private static final int UI_SEEKBAR_SELECT_HEGHT = 3;
    private static final int UI_SEEKBAR_THUMB_PADDING = 0;
    private static final int UI_SEEKBAR_TRACE_HEIGHT = 1;
    private static final int UI_SELECT_COLOR_START = -16366706;
    private static final float UI_THUMB_SCALE = 1.5f;
    public static final int UI_TRACE_COLOR = 1291845632;
    private static final int UI_TRANSLATE_Y = 0;
    private PlayerAttachInfo attachInfo;
    private int currentProgress;
    private float increaseValue;
    private int initFrameCircleHeight;
    private float initFrameLineHeight;
    private float inlineCircleRadius;
    private boolean isFirstUpdate;
    boolean isStartSendMsg;
    private final Paint mBufferingPaint;
    private int mBufferingProgress;
    private final Context mContext;
    private final int mDefaultWidth;
    private float mDensity;
    private SeekBarDirect mDirect;
    private final RectF mDrawRectF;
    protected boolean mIsDragable;
    private Paint mKeyFrameCyclePaint;
    public VideoCommonBigImageModel.KeyFrameInfo mKeyFrameInfo;
    private RectF mKeyFrameLine;
    private RectF mKeyFrameLineBg;
    private Paint mKeyFrameLineBgPaint;
    private Paint mKeyFrameLinePaint;
    private float mKeyFrameNodeX;
    private Paint mKeyFrameRingPaint;
    private OnBdSeekBarChangeListener mListener;
    private float mMax;
    private boolean mNeedThumbScale;
    private Paint mNodeCyclePaint;
    private Paint mNodeRingPaint;
    private final Paint mPaint;
    private float mProgress;
    /* access modifiers changed from: private */
    public ProgressListener mProgressListener;
    private BdSeeBarStatus mSeeBarStatus;
    private final Paint mSeekPaint;
    private LinearGradient mSeekShader;
    private BdSeekBarStyle mStyle;
    private Bitmap mThumb;
    private int mThumbPadding;
    private Bitmap mThumbScale;
    private final PorterDuffXfermode mTracePorterDuffXfermode;
    private final int mTranslateY;
    private final int mUIRightSpace;
    private final int mUISpace;
    private int mUITraceHeight;
    /* access modifiers changed from: private */
    public int maxDuration;
    public List<Double> nodeList;
    private float outCircleRadius;
    /* access modifiers changed from: private */
    public ProgressHandler progressHandler;

    enum BdSeeBarStatus {
        None,
        Seek
    }

    public enum BdSeekBarStyle {
        LINE,
        ROUND_RECT
    }

    public interface OnBdSeekBarChangeListener {
        void onProgressChanged(VideoCommonPlayerNodeSeekBar videoCommonPlayerNodeSeekBar, int i2, boolean z);

        void onStartTrackingTouch(VideoCommonPlayerNodeSeekBar videoCommonPlayerNodeSeekBar);

        void onStopTrackingTouch(VideoCommonPlayerNodeSeekBar videoCommonPlayerNodeSeekBar);
    }

    public interface ProgressListener {
        int getCurrentProgress();

        int getVideoDuration();
    }

    public enum SeekBarDirect {
        Vertical,
        Horizontal
    }

    public VideoCommonPlayerNodeSeekBar(Context aContext, int height) {
        this(aContext, DEFAULT_STYLE, height);
    }

    public VideoCommonPlayerNodeSeekBar(Context aContext, AttributeSet aAttrs) {
        this(aContext, aAttrs, DEFAULT_STYLE, 1);
    }

    public VideoCommonPlayerNodeSeekBar(Context aContext, AttributeSet aAttrs, int aDefStyle) {
        this(aContext, aAttrs, aDefStyle, DEFAULT_STYLE, 1);
    }

    public VideoCommonPlayerNodeSeekBar(Context aContext, BdSeekBarStyle aStyle, int height) {
        this(aContext, (AttributeSet) null, aStyle, height);
    }

    public VideoCommonPlayerNodeSeekBar(Context aContext, AttributeSet aAttrs, BdSeekBarStyle aStyle, int height) {
        this(aContext, aAttrs, 0, aStyle, height);
    }

    public VideoCommonPlayerNodeSeekBar(Context aContext, AttributeSet aAttrs, int aDefStyle, BdSeekBarStyle aStyle, int height) {
        super(aContext, aAttrs, aDefStyle);
        this.mSeeBarStatus = BdSeeBarStatus.None;
        this.mTranslateY = 0;
        this.mNeedThumbScale = true;
        this.mDirect = SeekBarDirect.Horizontal;
        this.mIsDragable = true;
        this.isStartSendMsg = false;
        this.mContext = aContext;
        this.progressHandler = new ProgressHandler(new WeakReference(this));
        setClickable(true);
        TypedArray styledAttributes = getContext().obtainStyledAttributes(aAttrs, R.styleable.BdThumbSeekBar);
        int style = styledAttributes.getInt(R.styleable.BdThumbSeekBar_bdThumbSeekBarStyle, 0);
        styledAttributes.recycle();
        switch (style) {
            case 1:
                this.mStyle = BdSeekBarStyle.LINE;
                break;
            case 2:
                this.mStyle = BdSeekBarStyle.ROUND_RECT;
                break;
            default:
                this.mStyle = aStyle;
                break;
        }
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.videoplayer_seek_bar_bg_color));
        int seekColor = R.color.videoplayer_seek_bar_played_color;
        int bufferColor = R.color.videoplayer_seek_bar_buffered_color;
        Paint paint2 = new Paint();
        this.mSeekPaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(getResources().getColor(seekColor));
        Paint paint3 = new Paint();
        this.mBufferingPaint = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(getResources().getColor(bufferColor));
        this.mMax = 100.0f;
        this.mProgress = 0.0f;
        this.mBufferingProgress = 0;
        if (aContext != null) {
            if (this.mThumb == null) {
                this.mThumb = BitmapFactory.decodeResource(aContext.getResources(), R.drawable.videoplayer_new_player_seekbar_thumb);
            }
            this.mThumbPadding = ViewUtil.dp2px(0.0f);
        }
        if (this.mThumbScale == null) {
            scaleThumb(1.5f);
        }
        this.mDrawRectF = new RectF();
        this.mDensity = 1.5f;
        if (aContext != null) {
            this.mDensity = aContext.getResources().getDisplayMetrics().density;
        }
        float f2 = this.mDensity;
        this.mUISpace = (int) (0.0f * f2);
        this.mUIRightSpace = (int) (f2 * 5.0f);
        setUiTraceHeight(height);
        this.mDefaultWidth = (int) (this.mDensity * 50.0f);
        this.mTracePorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        initView();
        this.initFrameCircleHeight = getContext().getResources().getDimensionPixelOffset(com.baidu.searchbox.search.video.business.R.dimen.dimens_11dp);
    }

    /* access modifiers changed from: protected */
    public void initView() {
    }

    public void syncPos(int position, int duration, int buffer) {
        setMax((float) duration);
        setBufferingProgress(duration);
        setProgress(position);
        if (!this.isStartSendMsg) {
            Message progressMessage = Message.obtain();
            progressMessage.what = 1;
            this.progressHandler.sendMessage(progressMessage);
            this.isStartSendMsg = true;
        }
    }

    public void updateFrameInfo(VideoCommonBigImageModel.KeyFrameInfo frameInfo, PlayerAttachInfo attachInfo2) {
        this.mKeyFrameInfo = frameInfo;
        this.attachInfo = attachInfo2;
    }

    public void updateProgress(int progress) {
        this.currentProgress = progress;
    }

    public void updateMaxDuration(int duration) {
        this.maxDuration = duration;
    }

    private static class ProgressHandler extends Handler {
        private WeakReference<VideoCommonPlayerNodeSeekBar> seekBarWeak;

        public ProgressHandler(WeakReference<VideoCommonPlayerNodeSeekBar> seekBarWeak2) {
            this.seekBarWeak = seekBarWeak2;
        }

        public void handleMessage(Message msg) {
            VideoCommonPlayerNodeSeekBar seekBar;
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    WeakReference<VideoCommonPlayerNodeSeekBar> weakReference = this.seekBarWeak;
                    if (weakReference != null && (seekBar = (VideoCommonPlayerNodeSeekBar) weakReference.get()) != null) {
                        int currentProgress = seekBar.mProgressListener.getCurrentProgress();
                        int duration = seekBar.mProgressListener.getVideoDuration();
                        if (AppConfig.isDebug()) {
                            Log.d(VideoCommonPlayerNodeSeekBar.TAG, "当前进度：" + currentProgress + "，总时长：" + duration);
                        }
                        seekBar.updateProgress(currentProgress);
                        int unused = seekBar.maxDuration = duration;
                        if (seekBar.maxDuration > 0) {
                            seekBar.invalidate();
                        }
                        Message message = Message.obtain();
                        message.what = 1;
                        seekBar.progressHandler.sendMessageDelayed(message, (long) seekBar.maxDuration);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void syncPos(int position, int buffer) {
        setBufferingProgress(buffer);
        setProgress(position);
    }

    public void setMaxDuration(int duration) {
        setMax((float) duration);
    }

    public void setSeekBarDirect(SeekBarDirect aDirect) {
        this.mDirect = aDirect;
    }

    public void setStyle(BdSeekBarStyle style) {
        this.mStyle = style;
    }

    public void setUiTraceHeight(int height) {
        this.mUITraceHeight = (int) (((double) (((float) height) * this.mDensity)) + 0.5d);
    }

    public void setThumbBitmap(Bitmap bitmap) {
        this.mThumb = bitmap;
    }

    public void setScaleThumbBitmap(Bitmap bitmap) {
        this.mThumbScale = bitmap;
    }

    public void setDragable(boolean dragable) {
        this.mIsDragable = dragable;
    }

    public boolean isDragble() {
        return this.mIsDragable;
    }

    public void setMax(float aMax) {
        this.mMax = aMax;
    }

    public float getMax() {
        return this.mMax;
    }

    public void setProgress(int aProgress) {
        setProgress((float) aProgress);
    }

    public void setProgress(float aProgress) {
        this.mProgress = aProgress;
    }

    public void setThumbScaleVisible(boolean visible) {
        this.mNeedThumbScale = visible;
    }

    public void setProgressColor(int color) {
        this.mSeekPaint.setColor(color);
    }

    public void setProgressShare(Shader shader) {
        this.mSeekPaint.setShader(shader);
    }

    public void setProgressBackgroundColor(int color) {
        this.mPaint.setColor(color);
    }

    public void setBufferColor(int color) {
        Paint paint = this.mBufferingPaint;
        if (paint != null) {
            paint.setColor(color);
        }
    }

    public void setBufferingProgress(int aProgress) {
        this.mBufferingProgress = aProgress;
    }

    public int getProgress() {
        return (int) this.mProgress;
    }

    public void setOnSeekBarChangeListener(OnBdSeekBarChangeListener aListener) {
        this.mListener = aListener;
    }

    public boolean onTouchEvent(MotionEvent aEvent) {
        VideoCommonBigImageModel.KeyFrameInfo keyFrameInfo;
        if (this.mDirect == SeekBarDirect.Horizontal && (keyFrameInfo = this.mKeyFrameInfo) != null && !TextUtils.isEmpty(keyFrameInfo.keyCmd) && this.mKeyFrameLineBg != null) {
            switch (aEvent.getAction()) {
                case 1:
                    if (aEvent.getX() >= this.mKeyFrameLineBg.left && aEvent.getX() <= this.mKeyFrameLineBg.right) {
                        String cmd = this.mKeyFrameInfo.keyCmd;
                        String newCmd = VideoLoftCmdUtils.updateCmd(new UnitedSchemeEntity(Uri.parse(cmd)), (View) null, this, Integer.valueOf(this.mKeyFrameInfo.startTime), (Integer) null, "1");
                        if (!TextUtils.isEmpty(newCmd)) {
                            cmd = newCmd;
                        }
                        setTag(com.baidu.searchbox.search.video.business.R.id.video_search_cmd, cmd);
                        PlayerAttachInfo playerAttachInfo = this.attachInfo;
                        if (!(playerAttachInfo == null || playerAttachInfo.getModel() == null || this.attachInfo.getPlayHelper() == null || !(this.attachInfo.getModel().data instanceof VideoCommonBigImageModel))) {
                            VideoCommonBigImageModel model = (VideoCommonBigImageModel) this.attachInfo.getModel().data;
                            String extLogInfo = null;
                            String autoDuration = null;
                            if (model.searchVideoInfo != null) {
                                autoDuration = this.attachInfo.getPlayHelper().getCurrentVideoPlayDuration(model.searchVideoInfo.vid);
                                if (model.searchVideoInfo.extLogInfo != null) {
                                    extLogInfo = model.searchVideoInfo.extLogInfo.getExtLogString();
                                }
                            }
                            SearchVideoTcUtils.clickTc(extLogInfo, false, (String) null, "probar_clk", autoDuration, (String) null, (String) null);
                        }
                        Router.invoke(getContext(), cmd);
                        break;
                    }
            }
        }
        if (!this.mIsDragable) {
            return true;
        }
        if (this.mDirect == SeekBarDirect.Horizontal) {
            float x = aEvent.getX();
            if (x < this.mDrawRectF.left) {
                x = this.mDrawRectF.left;
            } else if (x > this.mDrawRectF.right) {
                x = this.mDrawRectF.right;
            }
            setProgress(((x - this.mDrawRectF.left) * this.mMax) / (this.mDrawRectF.right - this.mDrawRectF.left));
        } else {
            float y = aEvent.getY();
            if (y < this.mDrawRectF.top) {
                y = this.mDrawRectF.top;
            } else if (y > this.mDrawRectF.bottom) {
                y = this.mDrawRectF.bottom;
            }
            setProgress(((this.mDrawRectF.bottom - y) * this.mMax) / (this.mDrawRectF.bottom - this.mDrawRectF.top));
        }
        if (this.mListener != null) {
            this.mSeeBarStatus = BdSeeBarStatus.Seek;
            this.mListener.onProgressChanged(this, (int) this.mProgress, true);
        }
        switch (aEvent.getAction()) {
            case 0:
                OnBdSeekBarChangeListener onBdSeekBarChangeListener = this.mListener;
                if (onBdSeekBarChangeListener != null) {
                    onBdSeekBarChangeListener.onStartTrackingTouch(this);
                    this.mSeeBarStatus = BdSeeBarStatus.Seek;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                OnBdSeekBarChangeListener onBdSeekBarChangeListener2 = this.mListener;
                if (onBdSeekBarChangeListener2 != null) {
                    onBdSeekBarChangeListener2.onStopTrackingTouch(this);
                    this.mSeeBarStatus = BdSeeBarStatus.None;
                }
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
        }
        invalidate();
        return true;
    }

    public void onMeasure(int aWidthMeasureSpec, int aHeightMeasureSpec) {
        specifyPadding();
        setMeasuredDimension(measureWidth(aWidthMeasureSpec), measureHeight(aHeightMeasureSpec));
        computeDrawRect();
    }

    private void specifyPadding() {
        int leftPadding = getPaddingLeft();
        if (leftPadding <= 0) {
            leftPadding = this.mUISpace;
        }
        int topPadding = getPaddingTop();
        if (topPadding <= 0) {
            topPadding = this.mUISpace;
        }
        int rightPadding = getPaddingRight();
        if (rightPadding <= 0) {
            if (this.mNeedThumbScale) {
                rightPadding = this.mUISpace + this.mUIRightSpace;
            } else {
                rightPadding = this.mUISpace;
            }
        }
        int bottomPadding = getPaddingBottom();
        if (bottomPadding <= 0) {
            bottomPadding = this.mUISpace;
        }
        setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
    }

    private void computeDrawRect() {
        if (this.mDirect == SeekBarDirect.Horizontal) {
            this.mDrawRectF.left = (float) getPaddingLeft();
            this.mDrawRectF.right = (float) (getMeasuredWidth() - getPaddingRight());
            this.mDrawRectF.top = (float) getPaddingTop();
            RectF rectF = this.mDrawRectF;
            rectF.bottom = rectF.top + ((float) this.mUITraceHeight);
            VideoCommonBigImageModel.KeyFrameInfo keyFrameInfo = this.mKeyFrameInfo;
            if (keyFrameInfo != null && keyFrameInfo.startTime > 0 && this.mKeyFrameInfo.endTime >= this.mKeyFrameInfo.startTime && this.maxDuration > 0) {
                this.initFrameLineHeight = getResources().getDimension(com.baidu.searchbox.search.video.business.R.dimen.dimens_4dp);
                this.mKeyFrameNodeX = (float) (((double) ((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft())) * ((((double) this.mKeyFrameInfo.startTime) * 1.0d) / ((double) this.maxDuration)));
                RectF rectF2 = new RectF();
                this.mKeyFrameLine = rectF2;
                rectF2.left = this.mKeyFrameNodeX;
                this.mKeyFrameLine.top = (float) (getPaddingTop() - InvokerUtils.dip2pix(1.0f));
                RectF rectF3 = this.mKeyFrameLine;
                rectF3.bottom = rectF3.top + this.initFrameLineHeight;
                RectF rectF4 = new RectF();
                this.mKeyFrameLineBg = rectF4;
                rectF4.left = this.mKeyFrameNodeX;
                RectF rectF5 = this.mKeyFrameLineBg;
                rectF5.right = rectF5.left + ((float) (((double) ((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft())) * ((((double) (this.mKeyFrameInfo.endTime - this.mKeyFrameInfo.startTime)) * 1.0d) / ((double) this.maxDuration))));
                this.mKeyFrameLineBg.top = (float) (getPaddingTop() - InvokerUtils.dip2pix(1.0f));
                RectF rectF6 = this.mKeyFrameLineBg;
                rectF6.bottom = rectF6.top + this.initFrameLineHeight;
                if (this.mKeyFrameRingPaint == null) {
                    Paint paint = new Paint();
                    this.mKeyFrameRingPaint = paint;
                    paint.setAntiAlias(true);
                    this.mKeyFrameRingPaint.setColor(getResources().getColor(com.baidu.searchbox.search.video.business.R.color.r_white));
                    this.mKeyFrameRingPaint.setShadowLayer(5.0f, 0.0f, 3.0f, Color.parseColor("#33000000"));
                }
                if (this.mKeyFrameCyclePaint == null) {
                    Paint paint2 = new Paint();
                    this.mKeyFrameCyclePaint = paint2;
                    paint2.setAntiAlias(true);
                    this.mKeyFrameCyclePaint.setColor(getResources().getColor(com.baidu.searchbox.search.video.business.R.color.search_tab_frame_cycle_bg));
                }
                if (this.mKeyFrameLineBgPaint == null) {
                    Paint paint3 = new Paint();
                    this.mKeyFrameLineBgPaint = paint3;
                    paint3.setAntiAlias(true);
                    this.mKeyFrameLineBgPaint.setColor(getResources().getColor(com.baidu.searchbox.search.video.business.R.color.search_tab_frame_line_bg));
                }
                if (this.mKeyFrameLinePaint == null) {
                    Paint paint4 = new Paint();
                    this.mKeyFrameLinePaint = paint4;
                    paint4.setAntiAlias(true);
                    this.mKeyFrameLinePaint.setColor(getResources().getColor(com.baidu.searchbox.search.video.business.R.color.white_40));
                    return;
                }
                return;
            }
            return;
        }
        this.mDrawRectF.top = (float) getPaddingTop();
        this.mDrawRectF.bottom = (float) (getMeasuredHeight() - getPaddingBottom());
        this.mDrawRectF.left = (float) ((((getMeasuredWidth() - this.mUITraceHeight) + getPaddingLeft()) - getPaddingRight()) >> 1);
        RectF rectF7 = this.mDrawRectF;
        rectF7.right = rectF7.left + ((float) this.mUITraceHeight);
    }

    private int measureWidth(int widthMeasureSpec) {
        int specMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int specSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int thumbWidth = this.mThumb.getWidth();
        int paddingLeft = getPaddingLeft() + thumbWidth + getPaddingRight();
        int i2 = this.mDefaultWidth;
        int width = paddingLeft + i2;
        if (specMode == Integer.MIN_VALUE) {
            if (width - i2 <= specSize) {
                return width;
            }
            scaleThumb(((float) ((specSize - getPaddingLeft()) - getPaddingRight())) / ((float) thumbWidth));
            return specSize;
        } else if (specMode != 1073741824) {
            return width;
        } else {
            if (width - i2 > specSize) {
                scaleThumb(((float) ((specSize - getPaddingLeft()) - getPaddingRight())) / ((float) this.mThumb.getHeight()));
            }
            return specSize;
        }
    }

    private int measureHeight(int aHeightMeasureSpec) {
        int specMode = View.MeasureSpec.getMode(aHeightMeasureSpec);
        int specSize = View.MeasureSpec.getSize(aHeightMeasureSpec);
        int height = specSize;
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$search$tab$implement$player$view$VideoCommonPlayerNodeSeekBar$BdSeekBarStyle[this.mStyle.ordinal()]) {
            case 1:
                height = this.mUITraceHeight + getPaddingTop() + getPaddingBottom();
                break;
            case 2:
                height = this.mThumb.getHeight() + getPaddingTop() + getPaddingBottom();
                break;
        }
        if (specMode == Integer.MIN_VALUE) {
            if (height <= specSize) {
                return height;
            }
            scaleThumb(((float) ((specSize - getPaddingTop()) - getPaddingBottom())) / ((float) this.mThumb.getHeight()));
            return specSize;
        } else if (specMode != 1073741824) {
            return height;
        } else {
            if (height > specSize) {
                scaleThumb(((float) ((specSize - getPaddingTop()) - getPaddingBottom())) / ((float) this.mThumb.getHeight()));
            }
            return specSize;
        }
    }

    /* renamed from: com.baidu.searchbox.search.tab.implement.player.view.VideoCommonPlayerNodeSeekBar$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$search$tab$implement$player$view$VideoCommonPlayerNodeSeekBar$BdSeekBarStyle;

        static {
            int[] iArr = new int[BdSeekBarStyle.values().length];
            $SwitchMap$com$baidu$searchbox$search$tab$implement$player$view$VideoCommonPlayerNodeSeekBar$BdSeekBarStyle = iArr;
            try {
                iArr[BdSeekBarStyle.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$search$tab$implement$player$view$VideoCommonPlayerNodeSeekBar$BdSeekBarStyle[BdSeekBarStyle.ROUND_RECT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private void scaleThumb(float scale) {
        if (scale > 0.0f) {
            Matrix m = new Matrix();
            m.postScale(scale, scale);
            Bitmap bitmap = this.mThumb;
            this.mThumbScale = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.mThumb.getHeight(), m, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas aCanvas) {
        float drawRectRange;
        float drawRectLeft = this.mDrawRectF.left;
        if (this.mDirect == SeekBarDirect.Horizontal) {
            drawRectRange = Math.abs(this.mDrawRectF.right - this.mDrawRectF.left);
        } else {
            drawRectRange = Math.abs(this.mDrawRectF.bottom - this.mDrawRectF.top);
        }
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$search$tab$implement$player$view$VideoCommonPlayerNodeSeekBar$BdSeekBarStyle[this.mStyle.ordinal()]) {
            case 1:
                aCanvas.drawRect(this.mDrawRectF, this.mPaint);
                calcHorizontalProgressDrawRect(aCanvas, drawRectRange);
                break;
            case 2:
                if (this.mNeedThumbScale) {
                    this.mPaint.setColor(-2130706433);
                }
                int i2 = this.mUITraceHeight;
                int radiusX = i2 >> 1;
                int radiusY = i2 >> 1;
                if (i2 < 5) {
                    radiusX = 0;
                    radiusY = 0;
                }
                int saveCount = aCanvas.save();
                aCanvas.drawRoundRect(this.mDrawRectF, (float) radiusX, (float) radiusY, this.mPaint);
                calcProgressDrawRect((float) this.mBufferingProgress, drawRectRange);
                aCanvas.drawRoundRect(this.mDrawRectF, (float) radiusX, (float) radiusY, this.mBufferingPaint);
                calcProgressDrawRect(this.mProgress, drawRectRange);
                this.mSeekPaint.setXfermode(this.mTracePorterDuffXfermode);
                aCanvas.drawRoundRect(this.mDrawRectF, (float) radiusX, (float) radiusY, this.mSeekPaint);
                aCanvas.restoreToCount(saveCount);
                drawThumb(aCanvas, drawRectLeft, drawRectRange);
                break;
        }
        computeDrawRect();
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.mProgressListener = progressListener;
    }

    public void setFirstUpdateProgress(boolean isFirst) {
        this.isFirstUpdate = isFirst;
    }

    public void stop() {
        this.isStartSendMsg = false;
        this.currentProgress = 0;
        this.maxDuration = 0;
        ProgressHandler progressHandler2 = this.progressHandler;
        if (progressHandler2 != null) {
            progressHandler2.removeCallbacksAndMessages((Object) null);
        }
    }

    private void calcHorizontalProgressDrawRect(Canvas aCanvas, float drawRectRange) {
        if (this.isFirstUpdate && this.maxDuration > 0) {
            this.increaseValue = (((float) ((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft())) / ((float) this.maxDuration)) / 1000.0f;
            this.isFirstUpdate = false;
        }
        int i2 = this.currentProgress;
        if (i2 > 0) {
            float currentWidth = this.increaseValue * ((float) i2);
            if (currentWidth > drawRectRange) {
                currentWidth = drawRectRange;
            }
            RectF rectF = this.mDrawRectF;
            rectF.right = rectF.left + currentWidth;
            aCanvas.drawRect(this.mDrawRectF, this.mSeekPaint);
            drawNode(aCanvas);
            drawKeyFrame(aCanvas);
        }
    }

    private void drawKeyFrame(Canvas canvas) {
        VideoCommonBigImageModel.KeyFrameInfo keyFrameInfo = this.mKeyFrameInfo;
        if (keyFrameInfo != null && keyFrameInfo.startTime > 0 && this.mKeyFrameInfo.endTime >= this.mKeyFrameInfo.startTime && this.maxDuration > 0) {
            if (this.mKeyFrameRingPaint == null) {
                computeDrawRect();
            }
            this.inlineCircleRadius = this.mContext.getResources().getDimension(com.baidu.searchbox.search.video.business.R.dimen.dimens_2half);
            this.outCircleRadius = this.mContext.getResources().getDimension(com.baidu.searchbox.search.video.business.R.dimen.dimens_3half_dp);
            this.mKeyFrameLineBg.top = (float) getPaddingTop();
            RectF rectF = this.mKeyFrameLineBg;
            rectF.bottom = rectF.top + ((float) this.mUITraceHeight);
            this.mKeyFrameLine.top = (float) getPaddingTop();
            RectF rectF2 = this.mKeyFrameLine;
            rectF2.bottom = rectF2.top + ((float) this.mUITraceHeight);
            canvas.drawRect(this.mKeyFrameLineBg, this.mKeyFrameLineBgPaint);
            if (this.mDrawRectF.right >= this.mKeyFrameLine.left && this.mDrawRectF.right <= this.mKeyFrameLineBg.right) {
                this.mKeyFrameLine.right = this.mDrawRectF.right;
                canvas.drawRect(this.mKeyFrameLine, this.mKeyFrameLinePaint);
            } else if (this.mDrawRectF.right > this.mKeyFrameLineBg.right) {
                this.mKeyFrameLine.right = this.mKeyFrameLineBg.right;
                canvas.drawRect(this.mKeyFrameLine, this.mKeyFrameLinePaint);
            }
            float cy = this.mDrawRectF.top + ((this.mDrawRectF.bottom - this.mDrawRectF.top) / 2.0f);
            canvas.drawCircle(this.mKeyFrameNodeX, cy, this.outCircleRadius, this.mKeyFrameRingPaint);
            canvas.drawCircle(this.mKeyFrameNodeX, cy, this.inlineCircleRadius, this.mKeyFrameCyclePaint);
        }
    }

    private void drawNode(Canvas canvas) {
        List<Double> list = this.nodeList;
        if (list != null && list.size() > 0) {
            if (this.mNodeCyclePaint == null) {
                Paint paint = new Paint();
                this.mNodeCyclePaint = paint;
                paint.setAntiAlias(true);
                this.mNodeCyclePaint.setColor(getResources().getColor(com.baidu.searchbox.search.video.business.R.color.search_tab_seekbar_node_cycle_bg));
            }
            if (this.mNodeRingPaint == null) {
                Paint paint2 = new Paint();
                this.mNodeRingPaint = paint2;
                paint2.setAntiAlias(true);
                this.mNodeRingPaint.setStrokeWidth(getResources().getDimension(com.baidu.searchbox.search.video.business.R.dimen.search_tab_seekbar_node_selected_ring_width));
                this.mNodeRingPaint.setStyle(Paint.Style.STROKE);
                this.mNodeRingPaint.setColor(getResources().getColor(com.baidu.searchbox.search.video.business.R.color.search_tab_seekbar_node_ring_bg));
            }
            double currentProgressPercent = ((double) this.currentProgress) / ((double) (this.maxDuration * 1000));
            int nodeListSize = this.nodeList.size();
            for (int i2 = 0; i2 < nodeListSize; i2++) {
                double node = this.nodeList.get(i2).doubleValue();
                if (currentProgressPercent < node) {
                    drawNormalNode(canvas, node);
                } else if (i2 == nodeListSize - 1) {
                    drawSelectedNode(canvas, node);
                } else if (currentProgressPercent >= this.nodeList.get(i2 + 1).doubleValue()) {
                    drawPlayedNode(canvas, node);
                } else {
                    drawSelectedNode(canvas, node);
                }
            }
        }
    }

    private void drawSelectedNode(Canvas canvas, double node) {
        float cy = this.mDrawRectF.top + ((this.mDrawRectF.bottom - this.mDrawRectF.top) / 2.0f);
        float cx = (float) (((double) ((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft())) * node);
        this.mNodeCyclePaint.setColor(getResources().getColor(com.baidu.searchbox.search.video.business.R.color.search_tab_seekbar_node_cycle_selected_bg));
        canvas.drawCircle(cx, cy, this.mContext.getResources().getDimension(com.baidu.searchbox.search.video.business.R.dimen.search_tab_seekbar_node_selected_cycle_radius), this.mNodeCyclePaint);
        canvas.drawCircle(cx, cy, this.mContext.getResources().getDimension(com.baidu.searchbox.search.video.business.R.dimen.search_tab_seekbar_node_selected_ring_radius), this.mNodeRingPaint);
    }

    private void drawNormalNode(Canvas canvas, double node) {
        float cy = this.mDrawRectF.top + ((this.mDrawRectF.bottom - this.mDrawRectF.top) / 2.0f);
        this.mNodeCyclePaint.setColor(getResources().getColor(com.baidu.searchbox.search.video.business.R.color.search_tab_seekbar_node_cycle_bg));
        canvas.drawCircle((float) (((double) ((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft())) * node), cy, this.mContext.getResources().getDimension(com.baidu.searchbox.search.video.business.R.dimen.search_tab_seekbar_node_normal_cycle_radius), this.mNodeCyclePaint);
    }

    private void drawPlayedNode(Canvas canvas, double node) {
        float cy = this.mDrawRectF.top + ((this.mDrawRectF.bottom - this.mDrawRectF.top) / 2.0f);
        this.mNodeCyclePaint.setColor(getResources().getColor(com.baidu.searchbox.search.video.business.R.color.search_tab_seekbar_node_cycle_played_bg));
        canvas.drawCircle((float) (((double) ((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft())) * node), cy, this.mContext.getResources().getDimension(com.baidu.searchbox.search.video.business.R.dimen.search_tab_seekbar_node_cycle_radius), this.mNodeCyclePaint);
    }

    public void setNodeList(List<Double> nodeList2) {
        this.nodeList = nodeList2;
    }

    private void drawThumb(Canvas aCanvas, float drawRectLeft, float drawRectWidth) {
        int thumbWidth;
        if (!this.mNeedThumbScale) {
            return;
        }
        if (this.mDirect == SeekBarDirect.Horizontal) {
            if (this.mSeeBarStatus == BdSeeBarStatus.Seek) {
                thumbWidth = this.mThumbScale.getWidth();
            } else {
                thumbWidth = this.mThumb.getWidth();
            }
            int left = (int) (this.mDrawRectF.right - ((float) (thumbWidth >> 1)));
            int i2 = this.mThumbPadding;
            if (((float) left) < ((float) (-i2)) + drawRectLeft) {
                left = (int) (((float) (-i2)) + drawRectLeft);
            } else if (((float) ((left + thumbWidth) - i2)) > drawRectWidth + drawRectLeft) {
                left = (int) (((drawRectWidth + drawRectLeft) - ((float) thumbWidth)) + ((float) i2));
            }
            if (this.mSeeBarStatus == BdSeeBarStatus.Seek) {
                aCanvas.drawBitmap(this.mThumbScale, (float) left, (float) (((((getMeasuredHeight() - this.mThumbScale.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + 0), (Paint) null);
            } else {
                aCanvas.drawBitmap(this.mThumb, (float) Math.max(left, -this.mThumbPadding), (float) (((((getMeasuredHeight() - this.mThumb.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + 0), (Paint) null);
            }
        } else {
            int top = (int) (this.mDrawRectF.top - ((float) (this.mThumb.getHeight() >> 1)));
            if (this.mSeeBarStatus == BdSeeBarStatus.Seek) {
                aCanvas.drawBitmap(this.mThumbScale, (float) ((((getMeasuredWidth() - this.mThumbScale.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1), (float) top, (Paint) null);
            } else {
                aCanvas.drawBitmap(this.mThumb, (float) ((((getMeasuredWidth() - this.mThumb.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1), (float) top, (Paint) null);
            }
        }
    }

    public void onNightChanged() {
    }

    private void calcProgressDrawRect(float drawBufferingProgress, float drawRectRange) {
        if (drawBufferingProgress < 0.0f) {
            drawBufferingProgress = 0.0f;
        }
        if (drawBufferingProgress > this.mMax) {
            drawBufferingProgress = this.mMax;
        }
        if (this.mDirect == SeekBarDirect.Horizontal) {
            float f2 = this.mMax;
            if (f2 > 0.1f) {
                drawBufferingProgress = (drawBufferingProgress * drawRectRange) / f2;
            }
            RectF rectF = this.mDrawRectF;
            rectF.right = rectF.left + drawBufferingProgress;
            return;
        }
        float f3 = this.mMax;
        if (f3 > 0.1f) {
            drawBufferingProgress = (drawBufferingProgress * drawRectRange) / f3;
        }
        RectF rectF2 = this.mDrawRectF;
        rectF2.top = rectF2.bottom - drawBufferingProgress;
    }
}
