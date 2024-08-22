package com.baidu.searchbox.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.searchbox.ui.animview.praise.IExPraiseAnimListener;
import com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback;
import com.baidu.searchbox.ui.animview.praise.PraiseEnvironment;
import com.baidu.searchbox.ui.animview.praise.PraiseInfoManager;
import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.searchbox.ui.animview.praise.ioc.ILoginStatusListener;
import com.baidu.searchbox.ui.animview.praise.resource.PraiseEventIconResource;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.searchbox.ui.animview.util.LinkageControlUtil;
import java.text.DecimalFormat;

public class CoolPraiseView extends LinearLayout {
    private static final long BILLION = 100000000;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static final int LONG_PRESS_TIME_MS = 550;
    private static final long MILLION = 10000;
    private static final String NET_ERROR_TIP = "网络不给力，请稍后重试";
    private static final int REMOVE_VIEW_DELAY_TIME_MS = 200;
    private static final int START_DELAY_TIME_MS = 560;
    private static final String TAG = "CoolPraiseView";
    private ComboPraiseManager mComboPraiseManager;
    private Context mContext;
    /* access modifiers changed from: private */
    public CoolPraiseGuideLottieView mCoolPraiseGuideLottieView;
    /* access modifiers changed from: private */
    public PressedAlphaImageView mCopyPressedImageView;
    private boolean mDisableAnimation = false;
    private ExtraTouchEventListener mExtraTouchEventListener;
    /* access modifiers changed from: private */
    public AnimatorSet mGuideAnimator;
    /* access modifiers changed from: private */
    public int mGuidePlayRepeatCount;
    /* access modifiers changed from: private */
    public ViewGroup mGuidePlayRootView;
    /* access modifiers changed from: private */
    public boolean mIsAnimCancelling;
    /* access modifiers changed from: private */
    public boolean mIsGuideBubbleAnimPlaying = false;
    /* access modifiers changed from: private */
    public boolean mIsGuideHandAnimPlaying = false;
    /* access modifiers changed from: private */
    public boolean mIsLongPressing = false;
    /* access modifiers changed from: private */
    public boolean mIsPlayingAnim = false;
    /* access modifiers changed from: private */
    public boolean mIsPraised = false;
    /* access modifiers changed from: private */
    public int[] mLocation = new int[4];
    private Runnable mLongClick = new Runnable() {
        public void run() {
            boolean unused = CoolPraiseView.this.mIsLongPressing = true;
            if (CoolPraiseView.this.mLongPressListener != null) {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "#mLongClick, longPress start with no praise anim");
                }
                CoolPraiseView.this.mLongPressListener.onLongPressStart();
            }
        }
    };
    /* access modifiers changed from: private */
    public LongPressListener mLongPressListener;
    /* access modifiers changed from: private */
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public OnClickPraiseListener mOnClickPraiseListener = null;
    /* access modifiers changed from: private */
    public boolean mPraiseAnimBlock;
    /* access modifiers changed from: private */
    public boolean mPraiseAnimPrevented;
    private boolean mPraiseCntsDefaultTextShow = true;
    private int mPraiseCntsMarginLeft;
    private TextView mPraiseCntsView;
    /* access modifiers changed from: private */
    public int mPraiseCount = 0;
    private boolean mPraiseEnabled = true;
    /* access modifiers changed from: private */
    public PressedAlphaImageView mPraiseIcon;
    /* access modifiers changed from: private */
    public String mPraiseId;
    /* access modifiers changed from: private */
    public String mPraiseIdPrefix = "";
    /* access modifiers changed from: private */
    public String mPraiseSource;
    private int mPraisedRes = R.drawable.comment_item_like_icon_selector;
    private Drawable mPraisedResDrawable;
    private ColorStateList mPraisedTextColorStateList;
    /* access modifiers changed from: private */
    public boolean mReversePraiseStatus;
    /* access modifiers changed from: private */
    public boolean mStatusProtecting;
    private int mUnPraisedRes = R.drawable.comment_item_unlike_icon_selector;
    private Drawable mUnPraisedResDrawable;
    private ColorStateList mUnPraisedTextColorStateList;
    private LinearLayout mWrapperLayout;

    public interface ExtraTouchEventListener {
        void onTouchEvent(MotionEvent motionEvent);
    }

    public interface LongPressListener {
        void onLongPressCancel();

        void onLongPressStart();
    }

    public interface OnClickPraiseListener {
        void onClick(boolean z, int i2);
    }

    static /* synthetic */ int access$2308(CoolPraiseView x0) {
        int i2 = x0.mGuidePlayRepeatCount;
        x0.mGuidePlayRepeatCount = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$508(CoolPraiseView x0) {
        int i2 = x0.mPraiseCount;
        x0.mPraiseCount = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$510(CoolPraiseView x0) {
        int i2 = x0.mPraiseCount;
        x0.mPraiseCount = i2 - 1;
        return i2;
    }

    public CoolPraiseView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public CoolPraiseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CoolPraiseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray;
        float praiseHeight;
        float praiseWidth;
        float marginLeft;
        int paddingLeft;
        boolean showCount;
        boolean isTextBold;
        AttributeSet attributeSet = attrs;
        LayoutInflater.from(context).inflate(com.baidu.android.common.widget.praise.R.layout.cool_praise_view, this, true);
        this.mPraiseIcon = (PressedAlphaImageView) findViewById(com.baidu.android.common.widget.praise.R.id.video_detail_like_icon);
        this.mPraiseCntsView = (TextView) findViewById(com.baidu.android.common.widget.praise.R.id.video_detail_like_text);
        this.mWrapperLayout = (LinearLayout) findViewById(com.baidu.android.common.widget.praise.R.id.video_detail_like);
        if (attributeSet != null) {
            typedArray = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.widget.praise.R.styleable.coolPraiseView);
        } else {
            Context context2 = context;
            typedArray = null;
        }
        float textSize = 0.0f;
        if (typedArray != null) {
            praiseHeight = typedArray.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pHeight, 0.0f);
        } else {
            praiseHeight = 0.0f;
        }
        if (typedArray != null) {
            praiseWidth = typedArray.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pWidth, 0.0f);
        } else {
            praiseWidth = 0.0f;
        }
        if (typedArray != null) {
            marginLeft = typedArray.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pMarginLeft, 0.0f);
        } else {
            marginLeft = 0.0f;
        }
        if (typedArray != null) {
            paddingLeft = (int) typedArray.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pPaddingLeft, 0.0f);
        } else {
            paddingLeft = 0;
        }
        if (typedArray != null) {
            textSize = typedArray.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pTextSize, 0.0f);
        }
        if (typedArray != null) {
            showCount = typedArray.getBoolean(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pShowText, true);
        } else {
            showCount = true;
        }
        if (typedArray != null) {
            isTextBold = typedArray.getBoolean(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pTextBold, false);
        } else {
            isTextBold = false;
        }
        if (typedArray != null) {
            typedArray.recycle();
        }
        if (isTextBold) {
            this.mPraiseCntsView.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            this.mPraiseCntsView.setTypeface(Typeface.defaultFromStyle(0));
        }
        initPraiseDefaultIcon();
        LinearLayout linearLayout = this.mWrapperLayout;
        linearLayout.setPadding(paddingLeft, linearLayout.getPaddingTop(), this.mWrapperLayout.getPaddingRight(), this.mWrapperLayout.getPaddingBottom());
        LinearLayout.LayoutParams imagelp = (LinearLayout.LayoutParams) this.mPraiseIcon.getLayoutParams();
        imagelp.width = (int) praiseWidth;
        imagelp.height = (int) praiseHeight;
        this.mPraiseIcon.setLayoutParams(imagelp);
        this.mPraiseIcon.setDrawingCacheEnabled(true);
        this.mPraiseCntsView.setVisibility(showCount ? 0 : 8);
        LinearLayout.LayoutParams textLp = (LinearLayout.LayoutParams) this.mPraiseCntsView.getLayoutParams();
        textLp.leftMargin = (int) marginLeft;
        this.mPraiseCntsView.setLayoutParams(textLp);
        this.mPraiseCntsView.setTextSize(0, textSize);
        this.mPraiseCntsMarginLeft = (int) marginLeft;
        setPraiseUnProtected(false);
        initPraiseManager();
    }

    public View getIconView() {
        return this.mPraiseIcon;
    }

    public boolean isPraiseEnabled() {
        return this.mPraiseEnabled;
    }

    public void setPraiseable(boolean canPraise) {
        this.mPraiseEnabled = canPraise;
    }

    public void setOnClickPraiseListener(OnClickPraiseListener onClickPraiseListener) {
        this.mOnClickPraiseListener = onClickPraiseListener;
    }

    public boolean getIsPraisedState() {
        return this.mIsPraised;
    }

    @Deprecated
    public static String displayLikeCount(int count, String unit) {
        return convertLikeCount(count);
    }

    public static String convertLikeCount(int count) {
        double outNumber;
        String unit;
        if (count <= 0) {
            return "";
        }
        if (((long) count) < 10000) {
            return count + "";
        }
        if (((long) count) < 100000000) {
            unit = AppRuntime.getAppContext().getResources().getString(com.baidu.android.common.widget.praise.R.string.praise_ten_thousand);
            outNumber = ((double) count) / 10000.0d;
        } else {
            unit = AppRuntime.getAppContext().getResources().getString(com.baidu.android.common.widget.praise.R.string.praise_billion_unit);
            outNumber = ((double) count) / 1.0E8d;
        }
        return new DecimalFormat("####.#").format(outNumber) + unit;
    }

    public static String getLikeCountWithTenThousand(int count) {
        return convertLikeCount(count);
    }

    public void setPraise(boolean isPraised) {
        if (!this.mStatusProtecting && !this.mIsPlayingAnim) {
            setPraiseUnProtected(isPraised);
        }
    }

    public void disableStatusProtecting() {
        this.mStatusProtecting = false;
    }

    /* access modifiers changed from: private */
    public void setPraiseUnProtected(boolean isPraised) {
        this.mIsPraised = isPraised;
        if (this.mUnPraisedTextColorStateList == null) {
            this.mUnPraisedTextColorStateList = AppRuntime.getAppContext().getResources().getColorStateList(R.color.comment_item_unlike_text_color_selector);
        }
        if (this.mPraisedTextColorStateList == null) {
            this.mPraisedTextColorStateList = AppRuntime.getAppContext().getResources().getColorStateList(R.color.comment_item_like_text_color_selector);
        }
        if (isPraised) {
            Drawable drawable = this.mPraisedResDrawable;
            if (drawable != null) {
                this.mPraiseIcon.setImageDrawable(drawable);
            } else {
                this.mPraiseIcon.setImageDrawable(AppRuntime.getAppContext().getResources().getDrawable(this.mPraisedRes));
            }
            ColorStateList colorStateList = this.mPraisedTextColorStateList;
            if (colorStateList != null) {
                this.mPraiseCntsView.setTextColor(colorStateList);
                return;
            }
            return;
        }
        Drawable drawable2 = this.mUnPraisedResDrawable;
        if (drawable2 != null) {
            this.mPraiseIcon.setImageDrawable(drawable2);
        } else {
            this.mPraiseIcon.setImageDrawable(AppRuntime.getAppContext().getResources().getDrawable(this.mUnPraisedRes));
        }
        ColorStateList colorStateList2 = this.mUnPraisedTextColorStateList;
        if (colorStateList2 != null) {
            this.mPraiseCntsView.setTextColor(colorStateList2);
        }
    }

    public CoolPraiseView setPraiseStateIconRes(int unPraisedRes, int praisedRes) {
        this.mUnPraisedResDrawable = null;
        this.mPraisedResDrawable = null;
        this.mUnPraisedRes = unPraisedRes;
        this.mPraisedRes = praisedRes;
        setPraise(this.mIsPraised);
        return this;
    }

    private static ColorStateList getPressedColorStateList(int normalColor, int pressedColor) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{pressedColor, normalColor});
    }

    public CoolPraiseView setPraiseStateTextColor(int normalColor, int praisedColor) {
        ColorStateList unPraisedColorList = null;
        ColorStateList praisedColorList = null;
        try {
            unPraisedColorList = ColorStateList.valueOf(normalColor);
            praisedColorList = ColorStateList.valueOf(praisedColor);
        } catch (Resources.NotFoundException e2) {
        }
        return setPraiseStateTextRes(unPraisedColorList, praisedColorList);
    }

    public CoolPraiseView setPraiseStateTextRes(int unPraisedTextColor, int unPraisedTextColorPressed, int praisedTextColor, int praisedTextColorPressed) {
        return setPraiseStateTextRes(getPressedColorStateList(unPraisedTextColor, unPraisedTextColorPressed), getPressedColorStateList(praisedTextColor, praisedTextColorPressed));
    }

    public CoolPraiseView setPraiseStateTextRes(int unPraisedTextRes, int praisedTextRes) {
        ColorStateList unPraisedColorList = null;
        ColorStateList praisedColorList = null;
        try {
            unPraisedColorList = AppRuntime.getAppContext().getResources().getColorStateList(unPraisedTextRes);
            praisedColorList = AppRuntime.getAppContext().getResources().getColorStateList(praisedTextRes);
        } catch (Resources.NotFoundException e2) {
        }
        return setPraiseStateTextRes(unPraisedColorList, praisedColorList);
    }

    public CoolPraiseView setPraiseStateTextRes(ColorStateList unPraisedTextColorList, ColorStateList praisedTextColorList) {
        this.mUnPraisedTextColorStateList = unPraisedTextColorList;
        this.mPraisedTextColorStateList = praisedTextColorList;
        setPraise(this.mIsPraised);
        return this;
    }

    public synchronized void setPraiseIconResByNameReal(String name, boolean isDisableAnimation, int unPraisedTextRes, int praisedTextRes, Runnable callback) {
        this.mDisableAnimation = isDisableAnimation;
        String type = name + ".png";
        boolean isNightMode = NightModeHelper.getNightModeSwitcherState();
        this.mPraiseIcon.refreshDrawableState();
        Drawable praiseIconDrawableByName = PraiseEventIconResource.getPraiseIconDrawableByName(type, isNightMode, false);
        this.mUnPraisedResDrawable = praiseIconDrawableByName;
        if (praiseIconDrawableByName != null) {
            if (praiseIconDrawableByName.getConstantState() != null) {
                this.mUnPraisedResDrawable = this.mUnPraisedResDrawable.getConstantState().newDrawable().mutate();
            }
        } else if (unPraisedTextRes > 0) {
            this.mUnPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(unPraisedTextRes);
        }
        Drawable praiseIconDrawableByName2 = PraiseEventIconResource.getPraiseIconDrawableByName(type, isNightMode, true);
        this.mPraisedResDrawable = praiseIconDrawableByName2;
        if (praiseIconDrawableByName2 != null) {
            if (praiseIconDrawableByName2.getConstantState() != null) {
                this.mPraisedResDrawable = this.mPraisedResDrawable.getConstantState().newDrawable().mutate();
            }
        } else if (praisedTextRes > 0) {
            this.mPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(praisedTextRes);
        }
        setPraise(this.mIsPraised);
        requestLayout();
        invalidate();
        if (callback != null) {
            callback.run();
        }
    }

    public synchronized void setPraiseIconResByName(String name, boolean isDisableAnimation, int unPraisedTextRes, int praisedTextRes, Runnable callback) {
        final String str = name;
        final boolean z = isDisableAnimation;
        final int i2 = unPraisedTextRes;
        final int i3 = praisedTextRes;
        final Runnable runnable = callback;
        postDelayed(new Runnable() {
            public void run() {
                CoolPraiseView.this.setPraiseIconResByNameReal(str, z, i2, i3, runnable);
            }
        }, 50);
    }

    public synchronized void setPraiseIconResByName(String name, boolean isDisableAnimation, int unPraisedTextRes, int praisedTextRes) {
        setPraiseIconResByName(name, isDisableAnimation, unPraisedTextRes, praisedTextRes, (Runnable) null);
    }

    @Deprecated
    public CoolPraiseView setPraiseTextColor(int color) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{color});
        if (this.mIsPraised) {
            this.mPraisedTextColorStateList = colorStateList;
        } else {
            this.mUnPraisedTextColorStateList = colorStateList;
        }
        this.mPraiseCntsView.setTextColor(colorStateList);
        return this;
    }

    @Deprecated
    public CoolPraiseView setPraiseIcon(int resId) {
        this.mPraiseIcon.setImageDrawable(getResources().getDrawable(resId));
        return this;
    }

    public CoolPraiseView setUBC(String ubcSource, String nid) {
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.setUBCParams(new ComboPraiseUBC(ubcSource, nid));
        }
        return this;
    }

    public CoolPraiseView setUBC(String ubcSource, String nid, String strategyInfo) {
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.setUBCParams(new ComboPraiseUBC(ubcSource, nid, strategyInfo));
        }
        return this;
    }

    public CoolPraiseView setUBC(String ubcSource) {
        return setUBC(ubcSource, "");
    }

    public CoolPraiseView setPraiseSource(String praiseSource) {
        this.mPraiseSource = praiseSource;
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.setPraiseSource(praiseSource);
            setPraiseCount(this.mPraiseCount);
        }
        return this;
    }

    public CoolPraiseView setPraiseId(String praiseId) {
        this.mPraiseId = praiseId;
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.setPraiseId(praiseId);
        }
        return this;
    }

    public CoolPraiseView setPraiseCount(int count) {
        this.mPraiseCount = count;
        if (count <= 0) {
            this.mPraiseCount = 0;
            if (this.mPraiseCntsDefaultTextShow) {
                this.mPraiseCntsView.setText(getResources().getString(com.baidu.android.common.widget.praise.R.string.praise_text));
                setPraiseCntsLeftMargin(this.mPraiseCntsMarginLeft, false);
            } else {
                this.mPraiseCntsView.setText("");
                setPraiseCntsLeftMargin(0, false);
            }
            if (PraiseEnvironment.isFirstPraiseAnimSupported(this.mPraiseSource)) {
                if (DEBUG) {
                    Log.d(TAG, "isFirstPraiseAnimSupported return true");
                }
                this.mPraiseCntsView.setText(getResources().getString(com.baidu.android.common.widget.praise.R.string.praise_firstpraise));
            }
        } else {
            setPraiseCntsLeftMargin(this.mPraiseCntsMarginLeft, false);
            this.mPraiseCntsView.setText(getLikeCountWithTenThousand(count));
        }
        return this;
    }

    public CoolPraiseView setPraiseCount(String count) {
        try {
            setPraiseCount(Integer.parseInt(count));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        return this;
    }

    public CoolPraiseView setLikeLayoutLp(LinearLayout.LayoutParams lp) {
        this.mWrapperLayout.setLayoutParams(lp);
        return this;
    }

    public CoolPraiseView setLikeLayoutBgDrawable(Drawable bgDrawable) {
        this.mWrapperLayout.setBackground(bgDrawable);
        return this;
    }

    private boolean doLoginIfNecessary() {
        if (!PraiseEnvironment.isPraiseLoginSupported(this.mPraiseSource)) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseLoginSupported return false, so doLoginIfNecessary=true");
            }
            return true;
        } else if (this.mPraiseAnimBlock) {
            if (DEBUG) {
                Log.d(TAG, "mPraiseAnimBlock is true, so doLoginIfNecessary=false");
            }
            return false;
        } else if (!NetWorkUtils.isNetworkConnected()) {
            this.mPraiseAnimBlock = true;
            UniversalToast.makeText(this.mContext, (CharSequence) "网络不给力，请稍后重试").showToast();
            if (DEBUG) {
                Log.d(TAG, "isNetworkConnected return false, so doLoginIfNecessary=false");
            }
            return false;
        } else if (ComboPraiseRuntime.getContext().isLogin()) {
            if (DEBUG) {
                Log.d(TAG, "isLogin return true, so doLoginIfNecessary=true");
            }
            return true;
        } else {
            ComboPraiseRuntime.getContext().doLogin(this.mContext, new ILoginStatusListener() {
                public void loginSuccess() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "loginSuccess, performClick");
                    }
                    CoolPraiseView.this.performClick();
                }

                public void loginFail() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "loginFail");
                    }
                }
            });
            this.mPraiseAnimBlock = true;
            if (DEBUG) {
                Log.d(TAG, "doLogin, so doLoginIfNecessary=false");
            }
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (!doLoginIfNecessary() || ((PraiseEnvironment.isCancelPraiseEnabled(this.mPraiseSource) && this.mIsPraised) || this.mDisableAnimation || !ComboPraiseManager.isPraiseEnabled(this.mPraiseSource) || this.mPraiseAnimBlock)) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "Praise Animation disabled or prevented or praised");
                if (Build.VERSION.SDK_INT >= 19) {
                    Log.d(TAG, "pos2:" + MotionEvent.actionToString(ev.getAction()));
                } else {
                    Log.d(TAG, "pos2:" + ev.getAction());
                }
            }
            switch (ev.getAction()) {
                case 0:
                    ExtraTouchEventListener extraTouchEventListener = this.mExtraTouchEventListener;
                    if (extraTouchEventListener != null) {
                        extraTouchEventListener.onTouchEvent(ev);
                    }
                    if (z) {
                        Log.d(TAG, "#onTouchEvent, post longClick runnable");
                    }
                    this.mMainHandler.postDelayed(this.mLongClick, 550);
                    if (this.mPraiseAnimBlock) {
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    ExtraTouchEventListener extraTouchEventListener2 = this.mExtraTouchEventListener;
                    if (extraTouchEventListener2 != null) {
                        extraTouchEventListener2.onTouchEvent(ev);
                    }
                    this.mStatusProtecting = false;
                    this.mPraiseAnimBlock = false;
                    LinkageControlUtil.notifyEnableLinkageScroll();
                    if (handleLongPressEnd()) {
                        return true;
                    }
                    break;
            }
            return super.onTouchEvent(ev);
        }
        boolean z2 = DEBUG;
        if (z2) {
            Log.d(TAG, "Praise Animation Triggered");
            if (DeviceUtil.OSInfo.hasKitKat()) {
                Log.d(TAG, "pos1:" + MotionEvent.actionToString(ev.getAction()));
            } else {
                Log.d(TAG, "pos1:" + ev.getAction());
            }
        }
        if (this.mPraiseCount == 0 && !this.mStatusProtecting) {
            this.mComboPraiseManager.setFirstPraiseAnimEnabled(true);
        }
        this.mComboPraiseManager.onTouchForNA(ev);
        ExtraTouchEventListener extraTouchEventListener3 = this.mExtraTouchEventListener;
        if (extraTouchEventListener3 != null) {
            extraTouchEventListener3.onTouchEvent(ev);
        }
        switch (ev.getAction()) {
            case 0:
                this.mStatusProtecting = true;
                requestDisallowInterceptTouchEvent(true);
                this.mPraiseAnimPrevented = false;
                break;
            case 1:
            case 3:
                this.mStatusProtecting = false;
                LinkageControlUtil.notifyEnableLinkageScroll();
                break;
        }
        if (!this.mPraiseAnimPrevented) {
            return true;
        }
        if (z2) {
            Log.d(TAG, "Praise Animation Prevented");
        }
        requestDisallowInterceptTouchEvent(false);
        this.mPraiseAnimBlock = true;
        return false;
    }

    private boolean handleLongPressEnd() {
        if (!this.mIsLongPressing) {
            if (DEBUG) {
                Log.d(TAG, "#handleLongPressEnd, remove longPress runnable");
            }
            this.mMainHandler.removeCallbacks(this.mLongClick);
        } else {
            this.mIsLongPressing = false;
            this.mPraiseIcon.setPressed(false);
            if (DEBUG) {
                Log.d(TAG, "#handleLongPressEnd, handle longPressCancel ");
            }
            LongPressListener longPressListener = this.mLongPressListener;
            if (longPressListener != null) {
                longPressListener.onLongPressCancel();
                return true;
            }
        }
        return false;
    }

    private void resetTouchEvent(MotionEvent ev) {
        ViewParent parent = getParent();
        while (parent != null && !(parent instanceof ListView) && !(parent instanceof RecyclerView)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            if (DEBUG) {
                Log.d(TAG, parent.getClass().getSimpleName() + ", resetTouchEvent");
            }
            ev.setAction(3);
            ((View) parent).dispatchTouchEvent(ev);
            ev.setAction(0);
            ((View) parent).dispatchTouchEvent(ev);
        }
    }

    public CoolPraiseView disablePraiseAnimation(boolean disable) {
        if (this.mStatusProtecting) {
            return this;
        }
        this.mDisableAnimation = disable;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        initPraiseLocation();
    }

    /* access modifiers changed from: private */
    public void initPraiseLocation() {
        this.mPraiseIcon.getLocationOnScreen(this.mLocation);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mContext = context;
        initView(context, attrs);
        setup();
    }

    private void setup() {
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!CoolPraiseView.this.mIsPlayingAnim) {
                    if (CoolPraiseView.this.isPraiseEnabled()) {
                        if (!CoolPraiseView.this.mIsPraised) {
                            CoolPraiseView.access$508(CoolPraiseView.this);
                            CoolPraiseView.this.setPraiseUnProtected(true);
                            CoolPraiseView coolPraiseView = CoolPraiseView.this;
                            coolPraiseView.setPraiseCount(coolPraiseView.mPraiseCount);
                        } else if (PraiseEnvironment.isCancelPraiseEnabled(CoolPraiseView.this.mPraiseSource)) {
                            CoolPraiseView.access$510(CoolPraiseView.this);
                            CoolPraiseView.this.setPraiseUnProtected(false);
                            CoolPraiseView coolPraiseView2 = CoolPraiseView.this;
                            coolPraiseView2.setPraiseCount(coolPraiseView2.mPraiseCount);
                            PraiseInfoManager.getInstance().updatePraiseCounts(PraiseInfoManager.makePraiseInfoKey(CoolPraiseView.this.mPraiseSource, CoolPraiseView.this.mPraiseIdPrefix + CoolPraiseView.this.mPraiseId), 0);
                        }
                        if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                            CoolPraiseView.this.mOnClickPraiseListener.onClick(CoolPraiseView.this.mIsPraised, CoolPraiseView.this.mPraiseCount);
                            if (!CoolPraiseView.DEBUG) {
                                return;
                            }
                            if (CoolPraiseView.this.mIsPraised) {
                                Log.d(CoolPraiseView.TAG, "onClick called from setup, praiseStatus:false->true, praiseCnt:" + (CoolPraiseView.this.mPraiseCount - 1) + "->" + CoolPraiseView.this.mPraiseCount);
                            } else {
                                Log.d(CoolPraiseView.TAG, "onClick called from setup, praiseStatus:true->false, praiseCnt:" + (CoolPraiseView.this.mPraiseCount + 1) + "->" + CoolPraiseView.this.mPraiseCount);
                            }
                        }
                    } else if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                        CoolPraiseView.this.mOnClickPraiseListener.onClick(CoolPraiseView.this.mIsPraised, CoolPraiseView.this.mPraiseCount);
                        if (CoolPraiseView.DEBUG) {
                            Log.d(CoolPraiseView.TAG, "onClick called from setup, praiseStatus:" + CoolPraiseView.this.mIsPraised + "praiseCnt:" + CoolPraiseView.this.mPraiseCount);
                        }
                    }
                }
            }
        });
    }

    private void initPraiseManager() {
        if (DEBUG) {
            Log.d(TAG, "initPraiseManager");
        }
        ComboPraiseManager comboPraiseManager = new ComboPraiseManager((Activity) this.mContext, "");
        this.mComboPraiseManager = comboPraiseManager;
        comboPraiseManager.setPraiseManagerCallback(new IPraiseManagerCallback() {
            public int getAnchorLeft() {
                CoolPraiseView.this.initPraiseLocation();
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorLeft:" + CoolPraiseView.this.mLocation[0]);
                }
                return CoolPraiseView.this.mLocation[0];
            }

            public int getAnchorTop() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorTop:" + CoolPraiseView.this.mLocation[1]);
                }
                return CoolPraiseView.this.mLocation[1];
            }

            public int getAnchorWidth() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorWidth:" + CoolPraiseView.this.mPraiseIcon.getWidth());
                }
                return CoolPraiseView.this.mPraiseIcon.getWidth();
            }

            public int getAnchorHeight() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorHeight:" + CoolPraiseView.this.mPraiseIcon.getHeight());
                }
                return CoolPraiseView.this.mPraiseIcon.getHeight();
            }

            public String getPraiseSource() {
                return CoolPraiseView.this.mPraiseSource;
            }

            public String getPraiseId() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getPraiseId:" + CoolPraiseView.this.mPraiseIdPrefix + CoolPraiseView.this.mPraiseId);
                }
                return CoolPraiseView.this.mPraiseIdPrefix + CoolPraiseView.this.mPraiseId;
            }
        });
        this.mComboPraiseManager.setPraiseAnimListener(new IExPraiseAnimListener() {
            public void onPraiseAnimStart() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "onPraiseAnimStart--" + CoolPraiseView.this.mPraiseId);
                }
                boolean unused = CoolPraiseView.this.mIsPlayingAnim = true;
                if (!CoolPraiseView.this.mIsPraised) {
                    CoolPraiseView.access$508(CoolPraiseView.this);
                    CoolPraiseView coolPraiseView = CoolPraiseView.this;
                    coolPraiseView.setPraiseCount(coolPraiseView.mPraiseCount);
                    CoolPraiseView.this.setPraiseUnProtected(true);
                    if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                        CoolPraiseView.this.mOnClickPraiseListener.onClick(true, CoolPraiseView.this.mPraiseCount);
                        if (CoolPraiseView.DEBUG) {
                            Log.d(CoolPraiseView.TAG, "onClick called from onPraiseAnimStart, praiseStatus:false->true, praiseCnt:" + (CoolPraiseView.this.mPraiseCount - 1) + "->" + CoolPraiseView.this.mPraiseCount);
                        }
                    }
                    CoolPraiseView coolPraiseView2 = CoolPraiseView.this;
                    boolean unused2 = coolPraiseView2.mIsPraised = !coolPraiseView2.mIsPraised;
                    boolean unused3 = CoolPraiseView.this.mReversePraiseStatus = true;
                }
                if (CoolPraiseView.this.mStatusProtecting) {
                    LinkageControlUtil.notifyDisableLinkageScroll();
                }
                BdEventBus.Companion.getDefault().post(new PraiseAnimState(1, CoolPraiseView.this));
            }

            public void onPraiseAnimPrevented(int reasonCode) {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "onPraiseAnimPrevented--" + CoolPraiseView.this.mPraiseId + ", reason:" + reasonCode);
                }
                if (reasonCode == 1) {
                    boolean unused = CoolPraiseView.this.mIsAnimCancelling = true;
                }
                boolean unused2 = CoolPraiseView.this.mPraiseAnimPrevented = true;
                LinkageControlUtil.notifyDisableLinkageScroll();
                BdEventBus.Companion.getDefault().post(new PraiseAnimState(3, CoolPraiseView.this));
            }

            public void onPraiseAnimEnd() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "onPraiseAnimEnd--" + CoolPraiseView.this.mPraiseId);
                }
                boolean unused = CoolPraiseView.this.mIsPlayingAnim = false;
                if (CoolPraiseView.this.mReversePraiseStatus) {
                    CoolPraiseView coolPraiseView = CoolPraiseView.this;
                    boolean unused2 = coolPraiseView.mIsPraised = !coolPraiseView.mIsPraised;
                    boolean unused3 = CoolPraiseView.this.mReversePraiseStatus = false;
                }
                if (CoolPraiseView.this.mIsAnimCancelling) {
                    boolean unused4 = CoolPraiseView.this.mIsAnimCancelling = false;
                    if (CoolPraiseView.this.mIsPraised) {
                        CoolPraiseView.access$510(CoolPraiseView.this);
                        CoolPraiseView coolPraiseView2 = CoolPraiseView.this;
                        coolPraiseView2.setPraiseCount(coolPraiseView2.mPraiseCount);
                        CoolPraiseView.this.setPraiseUnProtected(false);
                        if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                            CoolPraiseView.this.mOnClickPraiseListener.onClick(false, CoolPraiseView.this.mPraiseCount);
                            if (CoolPraiseView.DEBUG) {
                                Log.d(CoolPraiseView.TAG, "onClick called from onPraiseAnimEnd, praiseStatus:true->false, praiseCnt:" + (CoolPraiseView.this.mPraiseCount + 1) + "->" + CoolPraiseView.this.mPraiseCount);
                            }
                        }
                    }
                }
                boolean unused5 = CoolPraiseView.this.mStatusProtecting = false;
                boolean unused6 = CoolPraiseView.this.mPraiseAnimBlock = false;
                LinkageControlUtil.notifyEnableLinkageScroll();
                BdEventBus.Companion.getDefault().post(new PraiseAnimState(2, CoolPraiseView.this));
            }
        });
    }

    public CoolPraiseView setPraiseIconPressedAlpha(float alpha) {
        this.mPraiseIcon.setPressedAlpha(alpha);
        return this;
    }

    public CoolPraiseView setPrefixForPraiseId(String idStr) {
        this.mPraiseIdPrefix = idStr;
        return this;
    }

    public static class PraiseAnimState {
        public static final int ANIM_STATE_PREVENTED = 3;
        public static final int ANIM_STATE_STARTED = 1;
        public static final int ANIM_STATE_STOPPED = 2;
        private int animState = -1;
        private CoolPraiseView praiseView;

        public PraiseAnimState(int animState2) {
            this.animState = animState2;
        }

        public PraiseAnimState(int animState2, CoolPraiseView praiseView2) {
            this.animState = animState2;
            this.praiseView = praiseView2;
        }

        public int getAnimState() {
            return this.animState;
        }

        public CoolPraiseView getPraiseView() {
            return this.praiseView;
        }
    }

    public void setExtraTouchEventListener(ExtraTouchEventListener extraTouchEventListener) {
        this.mExtraTouchEventListener = extraTouchEventListener;
    }

    public void setPraiseLayoutLeftPadding(int padding) {
        LinearLayout linearLayout = this.mWrapperLayout;
        if (linearLayout != null) {
            linearLayout.setPadding(padding, linearLayout.getPaddingTop(), this.mWrapperLayout.getPaddingRight(), this.mWrapperLayout.getPaddingBottom());
        }
    }

    public void setPraiseIconSize(int width, int height) {
        PressedAlphaImageView pressedAlphaImageView = this.mPraiseIcon;
        if (pressedAlphaImageView != null) {
            LinearLayout.LayoutParams imagelp = (LinearLayout.LayoutParams) pressedAlphaImageView.getLayoutParams();
            imagelp.width = width;
            imagelp.height = height;
            this.mPraiseIcon.setLayoutParams(imagelp);
        }
    }

    public void setPraiseCntsVisibility(boolean isShow) {
        TextView textView = this.mPraiseCntsView;
        if (textView != null) {
            textView.setVisibility(isShow ? 0 : 8);
        }
    }

    public void setPraiseCntsDefaultTextVisibility(boolean isShow) {
        this.mPraiseCntsDefaultTextShow = isShow;
    }

    public void setPraiseCntsTextSize(int unit, float size) {
        TextView textView = this.mPraiseCntsView;
        if (textView != null) {
            textView.setTextSize(unit, size);
        }
    }

    public void setPraiseCntsLeftMargin(int margin) {
        setPraiseCntsLeftMargin(margin, true);
    }

    private void setPraiseCntsLeftMargin(int margin, boolean cacheMargin) {
        if (cacheMargin) {
            this.mPraiseCntsMarginLeft = margin;
        }
        TextView textView = this.mPraiseCntsView;
        if (textView != null) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).leftMargin = margin;
        }
    }

    public void setPraiseCntsTopMargin(int margin) {
        TextView textView = this.mPraiseCntsView;
        if (textView != null) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = margin;
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PressedAlphaImageView pressedAlphaImageView = this.mPraiseIcon;
        if (pressedAlphaImageView != null) {
            pressedAlphaImageView.setScaleType(scaleType);
        }
    }

    public boolean guidePlay(ViewGroup rootView, boolean useRules, boolean isAdapterNotch, boolean mEnableImmersion) {
        if (isGuideAnimPlaying()) {
            return false;
        }
        if (useRules && !ControlShowManager.getInstance().canShow()) {
            return false;
        }
        int[] location = new int[2];
        this.mPraiseIcon.getLocationOnScreen(location);
        int centerX = location[0] + (this.mPraiseIcon.getWidth() / 2);
        int centerY = location[1] + (this.mPraiseIcon.getHeight() / 2);
        if (rootView == null) {
            this.mGuidePlayRootView = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
        } else {
            this.mGuidePlayRootView = rootView;
        }
        playHand(centerX, centerY);
        playBubble(centerX, centerY);
        return true;
    }

    public void cancelGuidePlay() {
        if (isGuideAnimPlaying()) {
            post(new Runnable() {
                public void run() {
                    if (CoolPraiseView.this.mGuideAnimator != null) {
                        CoolPraiseView.this.mGuideAnimator.cancel();
                    }
                    if (!(CoolPraiseView.this.mGuidePlayRootView == null || CoolPraiseView.this.mCopyPressedImageView == null)) {
                        CoolPraiseView.this.mGuidePlayRootView.removeView(CoolPraiseView.this.mCopyPressedImageView);
                        CoolPraiseView.this.mPraiseIcon.setVisibility(0);
                    }
                    if (CoolPraiseView.this.mGuidePlayRootView != null && CoolPraiseView.this.mCoolPraiseGuideLottieView != null) {
                        CoolPraiseView.this.mCoolPraiseGuideLottieView.cancel();
                        CoolPraiseView.this.mGuidePlayRootView.removeView(CoolPraiseView.this.mCoolPraiseGuideLottieView);
                    }
                }
            });
        }
    }

    private boolean isGuideAnimPlaying() {
        return this.mIsGuideHandAnimPlaying || this.mIsGuideBubbleAnimPlaying;
    }

    private void playHand(int centerX, int centerY) {
        try {
            this.mGuideAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), com.baidu.android.common.widget.praise.R.animator.bd_praise_guide_animator);
            this.mIsGuideHandAnimPlaying = true;
            this.mCopyPressedImageView = new PressedAlphaImageView(getContext());
            FrameLayout.LayoutParams lps = new FrameLayout.LayoutParams(this.mPraiseIcon.getWidth(), this.mPraiseIcon.getHeight());
            lps.leftMargin = centerX - (this.mPraiseIcon.getWidth() / 2);
            lps.topMargin = centerY - (this.mPraiseIcon.getHeight() / 2);
            this.mCopyPressedImageView.setImageBitmap(this.mPraiseIcon.getDrawingCache());
            this.mGuidePlayRootView.addView(this.mCopyPressedImageView, lps);
            this.mGuidePlayRepeatCount = 0;
            this.mGuideAnimator.setTarget(this.mCopyPressedImageView);
            this.mCopyPressedImageView.setPivotX(0.0f);
            this.mCopyPressedImageView.setPivotY((float) this.mPraiseIcon.getHeight());
            this.mCopyPressedImageView.invalidate();
            this.mGuideAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    if (CoolPraiseView.this.mGuidePlayRepeatCount >= 1) {
                        CoolPraiseView.this.mMainHandler.postDelayed(new Runnable() {
                            public void run() {
                                CoolPraiseView.this.mGuidePlayRootView.removeView(CoolPraiseView.this.mCopyPressedImageView);
                                boolean unused = CoolPraiseView.this.mIsGuideHandAnimPlaying = false;
                            }
                        }, 200);
                        CoolPraiseView.this.mPraiseIcon.setVisibility(0);
                        return;
                    }
                    CoolPraiseView.this.mGuideAnimator.setStartDelay(560);
                    CoolPraiseView.this.mGuideAnimator.start();
                    CoolPraiseView.access$2308(CoolPraiseView.this);
                }

                public void onAnimationStart(Animator animation) {
                    CoolPraiseView.this.mPraiseIcon.setVisibility(4);
                }
            });
            this.mGuideAnimator.start();
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void playBubble(int centerX, int centerY) {
        this.mIsGuideBubbleAnimPlaying = true;
        this.mCoolPraiseGuideLottieView = new CoolPraiseGuideLottieView(getContext());
        FrameLayout.LayoutParams lps = new FrameLayout.LayoutParams(this.mCoolPraiseGuideLottieView.getRealWidth(), this.mCoolPraiseGuideLottieView.getRealHeigth());
        lps.leftMargin = centerX - (this.mCoolPraiseGuideLottieView.getRealWidth() / 2);
        lps.topMargin = centerY - this.mCoolPraiseGuideLottieView.getRealHeigth();
        this.mGuidePlayRootView.addView(this.mCoolPraiseGuideLottieView, lps);
        this.mCoolPraiseGuideLottieView.setAnimatorListenerAdapter(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                CoolPraiseView.this.mMainHandler.postDelayed(new Runnable() {
                    public void run() {
                        CoolPraiseView.this.mGuidePlayRootView.removeView(CoolPraiseView.this.mCoolPraiseGuideLottieView);
                        boolean unused = CoolPraiseView.this.mIsGuideBubbleAnimPlaying = false;
                    }
                }, 200);
            }
        });
        this.mCoolPraiseGuideLottieView.play();
    }

    private void initPraiseDefaultIcon() {
        this.mUnPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.comment_item_unlike_icon_selector);
        this.mPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.comment_item_like_icon_selector);
    }

    public void setLongPressListener(LongPressListener listener) {
        if (this.mLongPressListener == null) {
            this.mLongPressListener = listener;
            this.mComboPraiseManager.setComboPraiseLongPressListener(new ComboPraiseManager.ComboPraiseLongPressListener() {
                public void onComboPraiseLongPressStart() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "#ComboPraiseLongPressListener: start, mIsPlayingAnim: " + CoolPraiseView.this.mIsPlayingAnim);
                    }
                    if (CoolPraiseView.this.mLongPressListener != null && !CoolPraiseView.this.mIsPlayingAnim) {
                        CoolPraiseView.this.mLongPressListener.onLongPressStart();
                    }
                }

                public void onComboPraiseLongPressCancel() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "#ComboPraiseLongPressListener: cancel, mIsPlayingAnim: " + CoolPraiseView.this.mIsPlayingAnim);
                    }
                    if (CoolPraiseView.this.mLongPressListener != null && !CoolPraiseView.this.mIsPlayingAnim) {
                        CoolPraiseView.this.mLongPressListener.onLongPressCancel();
                    }
                }
            });
        }
    }

    public void clearLongPressCallback() {
        if (this.mLongPressListener != null) {
            this.mLongPressListener = null;
        }
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.clearLongPressCallback();
        }
    }

    public void performAnimPrevented() {
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.performAnimPrevented();
        }
    }

    public Drawable getUnPraisedResDrawable() {
        Drawable drawable = this.mUnPraisedResDrawable;
        if (drawable != null) {
            return drawable;
        }
        if (this.mUnPraisedRes <= 0) {
            return null;
        }
        try {
            return AppRuntime.getAppContext().getResources().getDrawable(this.mUnPraisedRes);
        } catch (Exception e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public Drawable getPraisedResDrawable() {
        Drawable drawable = this.mPraisedResDrawable;
        if (drawable != null) {
            return drawable;
        }
        if (this.mPraisedRes <= 0) {
            return null;
        }
        try {
            return AppRuntime.getAppContext().getResources().getDrawable(this.mPraisedRes);
        } catch (Exception e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public boolean isPlayingAnim() {
        return this.mIsPlayingAnim;
    }

    public void enableVibrate(boolean enable) {
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.setEnableVibrate(enable);
        }
    }
}
