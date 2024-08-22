package com.baidu.talos.core.devsupport.bubble.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.message.interactionupgrade.InteractionUtils;
import com.baidu.talos.TalosAppRuntimeInit;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.R;
import com.baidu.talos.core.devsupport.bubble.ArrowView;
import com.baidu.talos.core.devsupport.bubble.BubblePosition;

public class BubbleBaseView {
    protected static final boolean DEBUG = Debug.isDebug();
    private static final String TAG = "BubbleViews";
    public View mAnchorLayer;
    public View mAnchorView;
    public ArrowView mArrowDown;
    public ArrowView mArrowLeft;
    public ArrowView mArrowRight;
    public ArrowView mArrowUp;
    protected int mBgColorDay = -1000;
    protected int mBgColorNight = -1000;
    public View mBgView;
    public ArrowView mBubbleArrow;
    public ViewGroup mBubbleContent;
    public TextView mBubbleText;
    public View mBubbleView;
    protected boolean mIsShadowDeviate = true;
    public ViewGroup mRootView;
    protected int mShadowColorDay = -1000;

    public void setDayModeBackground(int color) {
        this.mBgColorDay = color;
    }

    public void setNightModeBackground(int color) {
        this.mBgColorNight = color;
    }

    public void setDayModeShadowColor(int color) {
        this.mShadowColorDay = color;
    }

    public void setIsShadowDeviate(boolean isShadowDeviate) {
        this.mIsShadowDeviate = isShadowDeviate;
    }

    public int getBgColorDay() {
        return this.mBgColorDay;
    }

    public int getBgColorNight() {
        return this.mBgColorNight;
    }

    public int getBgColor() {
        int i2 = this.mBgColorDay;
        if (i2 != -1000) {
            return i2;
        }
        return TalosAppRuntimeInit.getAppContext().getResources().getColor(R.color.talos_dev_bubble_bg_color);
    }

    public void resetAll() {
        this.mRootView = null;
        this.mBubbleView = null;
        this.mBubbleContent = null;
        this.mBubbleArrow = null;
        this.mBubbleText = null;
        this.mAnchorView = null;
        this.mArrowUp = null;
        this.mArrowDown = null;
        this.mBgView = null;
        this.mAnchorLayer = null;
    }

    public void removeBGView() {
        View view2;
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null && this.mBubbleView != null && (view2 = this.mBgView) != null) {
            viewGroup.removeView(view2);
        }
    }

    public void removeAnchorView() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null && this.mBubbleView != null && this.mBgView != null) {
            viewGroup.removeView(this.mAnchorLayer);
        }
    }

    public void removemBubbleView() {
        View view2;
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null && (view2 = this.mBubbleView) != null && this.mBgView != null) {
            viewGroup.removeView(view2);
        }
    }

    public String getAnchorViewName() {
        View view2 = this.mAnchorView;
        return view2 != null ? view2.getClass().getSimpleName() : InteractionUtils.PAID_NULL;
    }

    public boolean isValidate() {
        return (this.mAnchorView == null || this.mRootView == null) ? false : true;
    }

    public void checkSafe(View view2) {
        if (view2 != null && view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
    }

    public void safeAddBGView() {
        View view2 = this.mBgView;
        if (view2 != null) {
            checkSafe(view2);
            this.mRootView.addView(this.mBgView);
        }
    }

    public void safeAddAnchorView() {
        View view2 = this.mAnchorLayer;
        if (view2 != null) {
            checkSafe(view2);
            this.mRootView.addView(this.mAnchorLayer);
        }
    }

    public void safeAddBubbleView() {
        if (this.mBubbleView != null) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "——>check bubble view begin");
            }
            checkSafe(this.mBubbleView);
            if (z) {
                Log.d(TAG, "——>check bubble view end");
            }
            this.mBubbleView.setVisibility(4);
            this.mRootView.addView(this.mBubbleView);
        }
    }

    public void resetAnchorParams() {
        ViewGroup.LayoutParams params;
        View view2 = this.mAnchorLayer;
        if (view2 != null && (params = view2.getLayoutParams()) != null) {
            params.width = 0;
            params.height = 0;
            this.mAnchorLayer.setLayoutParams(params);
        }
    }

    public void setBubbleClick(View.OnClickListener listener) {
        View view2 = this.mBubbleView;
        if (view2 != null) {
            view2.setOnClickListener(listener);
        }
    }

    public void setBGClick(View.OnClickListener listener) {
        View view2 = this.mBgView;
        if (view2 != null) {
            view2.setOnClickListener(listener);
        }
    }

    public void setAnchorClick(View.OnClickListener listener) {
        View view2 = this.mAnchorLayer;
        if (view2 != null) {
            view2.setOnClickListener(listener);
        }
    }

    public void postAnchorView(Runnable action) {
        View view2 = this.mAnchorView;
        if (view2 != null) {
            view2.post(action);
        }
    }

    public void showBubbleOnLocation(int[] bubblePos) {
        View view2 = this.mBubbleView;
        if (view2 != null) {
            view2.setX((float) bubblePos[0]);
            this.mBubbleView.setY((float) bubblePos[1]);
            this.mBubbleContent.setVisibility(0);
            this.mBubbleView.setVisibility(0);
            this.mBubbleArrow.setVisibility(0);
            this.mBgView.setVisibility(0);
        }
    }

    public void showAnchorLayer() {
        View view2 = this.mAnchorLayer;
        if (view2 != null && this.mAnchorView != null) {
            ViewGroup.LayoutParams lp = view2.getLayoutParams();
            lp.width = this.mAnchorView.getMeasuredWidth();
            lp.height = this.mAnchorView.getMeasuredHeight();
            this.mAnchorLayer.setLayoutParams(lp);
            int[] anchorPos = new int[2];
            this.mAnchorView.getLocationOnScreen(anchorPos);
            int[] rootPos = new int[2];
            this.mRootView.getLocationOnScreen(rootPos);
            this.mAnchorLayer.setX((float) (anchorPos[0] - rootPos[0]));
            this.mAnchorLayer.setY((float) (anchorPos[1] - rootPos[1]));
        }
    }

    /* renamed from: com.baidu.talos.core.devsupport.bubble.views.BubbleBaseView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$talos$core$devsupport$bubble$BubblePosition;

        static {
            int[] iArr = new int[BubblePosition.values().length];
            $SwitchMap$com$baidu$talos$core$devsupport$bubble$BubblePosition = iArr;
            try {
                iArr[BubblePosition.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$talos$core$devsupport$bubble$BubblePosition[BubblePosition.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$talos$core$devsupport$bubble$BubblePosition[BubblePosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$talos$core$devsupport$bubble$BubblePosition[BubblePosition.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$talos$core$devsupport$bubble$BubblePosition[BubblePosition.INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public void showArrowView(BubblePosition position) {
        dismissAllArrowView();
        switch (AnonymousClass1.$SwitchMap$com$baidu$talos$core$devsupport$bubble$BubblePosition[position.ordinal()]) {
            case 1:
                this.mArrowUp.setDirection(2);
                this.mBubbleArrow = this.mArrowUp;
                if (Build.VERSION.SDK_INT <= 25) {
                    ViewGroup.MarginLayoutParams as = (ViewGroup.MarginLayoutParams) this.mBubbleArrow.getLayoutParams();
                    as.setMargins(as.leftMargin, as.topMargin, as.rightMargin, as.bottomMargin - ((int) this.mBubbleArrow.dpToPixel(1.0f)));
                    this.mBubbleArrow.setLayoutParams(as);
                    return;
                }
                return;
            case 2:
                this.mArrowDown.setDirection(4);
                this.mBubbleArrow = this.mArrowDown;
                return;
            case 3:
                this.mArrowLeft.setDirection(1);
                this.mBubbleArrow = this.mArrowLeft;
                if (Build.VERSION.SDK_INT <= 25) {
                    ViewGroup.MarginLayoutParams as2 = (ViewGroup.MarginLayoutParams) this.mBubbleArrow.getLayoutParams();
                    as2.setMargins(as2.leftMargin, as2.topMargin, as2.rightMargin - ((int) this.mBubbleArrow.dpToPixel(1.0f)), as2.bottomMargin);
                    this.mBubbleArrow.setLayoutParams(as2);
                    return;
                }
                return;
            case 4:
                this.mArrowRight.setDirection(3);
                this.mBubbleArrow = this.mArrowRight;
                return;
            default:
                return;
        }
    }

    public void dismissAllArrowView() {
        this.mArrowUp.setVisibility(8);
        this.mArrowDown.setVisibility(8);
        this.mArrowLeft.setVisibility(8);
        this.mArrowRight.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public int getBubbleViewResId() {
        return R.layout.talos_dev_bubble_tip;
    }

    public boolean initViewIfNeed() {
        if (this.mBubbleView != null) {
            return false;
        }
        View inflate = LayoutInflater.from(this.mAnchorView.getContext()).inflate(getBubbleViewResId(), this.mRootView, false);
        this.mBubbleView = inflate;
        inflate.setVisibility(4);
        this.mBubbleContent = (ViewGroup) this.mBubbleView.findViewById(R.id.bubble_content);
        this.mArrowUp = (ArrowView) this.mBubbleView.findViewById(R.id.bubble_arrow_up);
        this.mArrowDown = (ArrowView) this.mBubbleView.findViewById(R.id.bubble_arrow_down);
        this.mArrowLeft = (ArrowView) this.mBubbleView.findViewById(R.id.bubble_arrow_left);
        this.mArrowRight = (ArrowView) this.mBubbleView.findViewById(R.id.bubble_arrow_right);
        int color = getBgColor();
        if (this.mBubbleContent.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.mBubbleContent.getBackground()).setColor(color);
        }
        this.mBubbleContent.setVisibility(4);
        this.mArrowUp.setArrowViewColor(color);
        this.mArrowDown.setArrowViewColor(color);
        this.mArrowLeft.setArrowViewColor(color);
        this.mArrowRight.setArrowViewColor(color);
        View view2 = new View(this.mAnchorView.getContext());
        this.mBgView = view2;
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mBgView.setVisibility(4);
        this.mAnchorLayer = new View(this.mAnchorView.getContext());
        return true;
    }

    public void setAnchor(View anchor) {
        boolean z = DEBUG;
        if (!z || anchor != null) {
            this.mAnchorView = anchor;
            if (anchor != null) {
                ViewGroup viewGroup = (ViewGroup) anchor.getRootView().findViewById(16908290);
                this.mRootView = viewGroup;
                if (viewGroup == null) {
                    this.mRootView = getContentViewFromWindow(this.mAnchorView);
                }
                if (z && this.mRootView == null) {
                    Log.e(TAG, "anchor view must be a child of android.R.id.content");
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("anchor view must not be null !!!");
    }

    public void setAnchorAndRootView(View anchor, ViewGroup rootView) {
        boolean z = DEBUG;
        if (!z || anchor != null) {
            this.mAnchorView = anchor;
            this.mRootView = rootView;
            if (rootView == null && anchor != null) {
                ViewGroup viewGroup = (ViewGroup) anchor.getRootView().findViewById(16908290);
                this.mRootView = viewGroup;
                if (viewGroup == null) {
                    this.mRootView = getContentViewFromWindow(this.mAnchorView);
                }
                if (z && this.mRootView == null) {
                    throw new IllegalArgumentException("root view must be a child of android.R.id.content");
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("anchor view must not be null !!!");
    }

    private ViewGroup getContentViewFromWindow(View anchor) {
        Context context = anchor.getContext();
        if (context instanceof Activity) {
            return (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        return null;
    }

    public boolean isViewsValidate() {
        return (this.mAnchorView == null || this.mRootView == null || this.mBubbleView == null) ? false : true;
    }

    public void updateBubble(int color, int txtColor) {
        ArrowView arrowView;
        TextView textView;
        ViewGroup viewGroup = this.mBubbleContent;
        if (viewGroup != null && (viewGroup.getBackground() instanceof GradientDrawable) && (arrowView = this.mBubbleArrow) != null && (arrowView instanceof ArrowView) && (textView = this.mBubbleText) != null && textView.getVisibility() == 0 && !TextUtils.isEmpty(this.mBubbleText.getText())) {
            ((GradientDrawable) this.mBubbleContent.getBackground()).setColor(color);
            this.mBubbleArrow.setArrowViewColor(color);
            this.mBubbleText.setTextColor(txtColor);
        }
    }

    public void updateViewUI() {
    }
}
