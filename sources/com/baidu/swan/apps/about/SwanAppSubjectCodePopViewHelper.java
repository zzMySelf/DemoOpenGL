package com.baidu.swan.apps.about;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.view.ShadowRoundRectView;

public class SwanAppSubjectCodePopViewHelper {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    /* access modifiers changed from: private */
    public static final int SAFE_DISTANCE = SwanAppUIUtils.dp2px(36.51f);
    /* access modifiers changed from: private */
    public static final int SAFE_MARGIN = SwanAppUIUtils.dp2px(14.78f);
    private static final String TAG = "SwanAppSubjectCodePopView";
    /* access modifiers changed from: private */
    public int mArrowMarginLeft;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public int mMaxWidth;
    /* access modifiers changed from: private */
    public int mOffsetY;
    /* access modifiers changed from: private */
    public int mPosX;
    /* access modifiers changed from: private */
    public int mPosY;
    /* access modifiers changed from: private */
    public View mRootView;
    private final String mSubjectCode;
    /* access modifiers changed from: private */
    public ImageView mSubjectCodeArrow;
    private TextView mSubjectCodeKey;
    private ShadowRoundRectView mSubjectCodeTextShadow;
    /* access modifiers changed from: private */
    public View mSubjectCodeTextView;
    private TextView mSubjectCodeValue;
    private View mSubjectCodeView;
    /* access modifiers changed from: private */
    public int mViewMarginTop;
    private int mVisibility;

    public SwanAppSubjectCodePopViewHelper(Context context, String code) {
        this.mSubjectCode = code;
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        this.mOffsetY = this.mContext.getResources().getDimensionPixelSize(R.dimen.swan_app_about_subject_code_shadow_radius);
        View inflate = View.inflate(context, R.layout.swanapp_about_subject_code_layout, (ViewGroup) null);
        this.mRootView = inflate;
        this.mSubjectCodeArrow = (ImageView) inflate.findViewById(R.id.subject_code_arrow);
        this.mSubjectCodeView = this.mRootView.findViewById(R.id.subject_code_view);
        this.mSubjectCodeTextView = this.mRootView.findViewById(R.id.subject_code_text_view);
        this.mSubjectCodeKey = (TextView) this.mRootView.findViewById(R.id.subject_code_key);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.subject_code_value);
        this.mSubjectCodeValue = textView;
        textView.setText(this.mSubjectCode);
        this.mSubjectCodeTextShadow = (ShadowRoundRectView) this.mRootView.findViewById(R.id.subject_code_shadow_view);
        setShadowView();
        setAllVisibility(4);
    }

    public void computePosition(final int baseX, final int baseY) {
        this.mRootView.measure(0, 0);
        this.mRootView.post(new Runnable() {
            public void run() {
                int viewWidth = SwanAppSubjectCodePopViewHelper.this.mRootView.getMeasuredWidth();
                int displayWidth = SwanAppUIUtils.getDisplayWidth((Context) null);
                if (displayWidth != 0) {
                    float x = (float) ((displayWidth - SwanAppSubjectCodePopViewHelper.SAFE_MARGIN) - viewWidth);
                    if (x >= ((float) baseX)) {
                        x = (float) Math.max(SwanAppSubjectCodePopViewHelper.SAFE_MARGIN, baseX - SwanAppSubjectCodePopViewHelper.SAFE_DISTANCE);
                    }
                    float x2 = Math.max(x, (float) SwanAppSubjectCodePopViewHelper.SAFE_MARGIN);
                    int unused = SwanAppSubjectCodePopViewHelper.this.mMaxWidth = displayWidth - (SwanAppSubjectCodePopViewHelper.SAFE_MARGIN * 2);
                    if (SwanAppSubjectCodePopViewHelper.this.mSubjectCodeTextView.getMeasuredWidth() >= SwanAppSubjectCodePopViewHelper.this.mMaxWidth) {
                        x2 = (float) SwanAppSubjectCodePopViewHelper.SAFE_MARGIN;
                    }
                    int unused2 = SwanAppSubjectCodePopViewHelper.this.mPosX = (int) x2;
                    SwanAppSubjectCodePopViewHelper swanAppSubjectCodePopViewHelper = SwanAppSubjectCodePopViewHelper.this;
                    int unused3 = swanAppSubjectCodePopViewHelper.mPosY = baseY + swanAppSubjectCodePopViewHelper.mContext.getResources().getDimensionPixelSize(R.dimen.swan_app_about_subject_code_arrow_icon_distance);
                    SwanAppSubjectCodePopViewHelper swanAppSubjectCodePopViewHelper2 = SwanAppSubjectCodePopViewHelper.this;
                    int unused4 = swanAppSubjectCodePopViewHelper2.mArrowMarginLeft = Math.max((baseX - swanAppSubjectCodePopViewHelper2.mPosX) - (SwanAppSubjectCodePopViewHelper.this.mSubjectCodeArrow.getWidth() / 2), 0);
                    SwanAppSubjectCodePopViewHelper swanAppSubjectCodePopViewHelper3 = SwanAppSubjectCodePopViewHelper.this;
                    int unused5 = swanAppSubjectCodePopViewHelper3.mViewMarginTop = swanAppSubjectCodePopViewHelper3.mSubjectCodeArrow.getHeight() - SwanAppSubjectCodePopViewHelper.this.mOffsetY;
                    if (SwanAppSubjectCodePopViewHelper.DEBUG) {
                        Log.d(SwanAppSubjectCodePopViewHelper.TAG, "computePosition: mPosX=" + SwanAppSubjectCodePopViewHelper.this.mPosX + " mPosY=" + SwanAppSubjectCodePopViewHelper.this.mPosY);
                        Log.d(SwanAppSubjectCodePopViewHelper.TAG, "computePosition: mArrowMarginLeft=" + SwanAppSubjectCodePopViewHelper.this.mArrowMarginLeft + " mViewMarginTop=" + SwanAppSubjectCodePopViewHelper.this.mViewMarginTop);
                    }
                }
            }
        });
    }

    public void show() {
        setAllVisibility(0);
        calViewPositionParams();
        this.mRootView.post(new Runnable() {
            public void run() {
                SwanAppSubjectCodePopViewHelper.this.mRootView.layout(SwanAppSubjectCodePopViewHelper.this.mPosX, SwanAppSubjectCodePopViewHelper.this.mPosY, SwanAppSubjectCodePopViewHelper.this.mPosX + SwanAppSubjectCodePopViewHelper.this.mRootView.getMeasuredWidth(), SwanAppSubjectCodePopViewHelper.this.mPosY + SwanAppSubjectCodePopViewHelper.this.mRootView.getMeasuredHeight());
            }
        });
    }

    private void calViewPositionParams() {
        int width = Math.min(this.mSubjectCodeTextView.getMeasuredWidth(), this.mMaxWidth);
        RelativeLayout.LayoutParams textParams = (RelativeLayout.LayoutParams) this.mSubjectCodeTextView.getLayoutParams();
        textParams.width = width;
        this.mSubjectCodeTextView.setLayoutParams(textParams);
        FrameLayout.LayoutParams arrowParams = (FrameLayout.LayoutParams) this.mSubjectCodeArrow.getLayoutParams();
        arrowParams.leftMargin = this.mArrowMarginLeft;
        this.mSubjectCodeArrow.setLayoutParams(arrowParams);
        FrameLayout.LayoutParams viewParams = (FrameLayout.LayoutParams) this.mSubjectCodeView.getLayoutParams();
        viewParams.topMargin = this.mViewMarginTop;
        this.mSubjectCodeView.setLayoutParams(viewParams);
    }

    private void setShadowView() {
        this.mSubjectCodeTextShadow.setShadow((float) this.mOffsetY, 0.0f, (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.swan_app_about_subject_code_shadow_offsetY), this.mContext.getResources().getColor(R.color.swan_app_about_subject_code_shadow));
        this.mSubjectCodeTextShadow.setShadowCorner((float) this.mContext.getResources().getDimensionPixelSize(R.dimen.swan_app_about_subject_code_text_bg_corner));
    }

    public void hide() {
        setAllVisibility(4);
    }

    public void setAllVisibility(int visibility) {
        this.mVisibility = visibility;
        this.mSubjectCodeArrow.setVisibility(visibility);
        this.mSubjectCodeTextView.setVisibility(visibility);
        this.mSubjectCodeKey.setVisibility(visibility);
        this.mSubjectCodeValue.setVisibility(visibility);
        this.mSubjectCodeTextShadow.setVisibility(visibility);
        this.mRootView.setVisibility(visibility);
    }

    public boolean isShowing() {
        return this.mVisibility == 0;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
