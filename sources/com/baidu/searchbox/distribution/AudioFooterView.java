package com.baidu.searchbox.distribution;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.list.widget.IRefreshFooter;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.ui.pullrefresh.LoadingAnimView;
import java.util.Map;

public class AudioFooterView extends LinearLayout implements IRefreshFooter {
    public static final int ALREADY_IN_THE_END = 14;
    private static final int COMMENT_NO_MORE_DATA_STATE = 15;
    public static final int DEFAULT_STATE = 0;
    public static final int LOAD_ERROR_STATE = 13;
    public static final int NO_MORE_DATA_STATE = 12;
    private static final String TAG = "RefreshableListPage";
    public static final int TYPE_STRING = 1996554240;
    public static final int TYPE_TEXT_COLOR = 1996685312;
    public static final int TYPE_TRAFFIC_STRING = 1996619776;
    private int forceVisiblility;
    private FrameLayout mCommentNoMoreDataContainer;
    private int mCommonBackgroundColor;
    private int mCurrentState;
    private DisplayStyle mDisplayStyle;
    private TextView mHintTextView;
    private boolean mIsNightMode;
    private ViewGroup mLoadingMoreContainer;
    private ViewGroup mNoMoreDataContainer;
    private LoadingAnimView mProgressbar;
    private ImageView mRightCircle;
    private final SparseIntArray mState2ResId;
    private OnStateChangedListener mStateChangedListener;
    private TextView mTextView;

    public interface OnStateChangedListener {
        void onStateChanged(int i2);
    }

    private SparseIntArray createDefaultStyleMap() {
        SparseIntArray map = new SparseIntArray();
        map.append(1996554243, R.string.feed_pull_to_load_footer_message);
        map.append(1996554240, R.string.feed_pull_to_load_footer_message);
        map.append(1996554252, R.string.feed_pull_to_refresh_feed_no_more_data);
        map.append(1996554253, R.string.feed_pull_to_refresh_feed_occur_error);
        map.append(1996554254, R.string.feed_pull_to_refresh_feed_in_the_end);
        map.append(1996619779, R.string.feed_pull_to_load_footer_message_for_free_traffic);
        map.append(1996619776, R.string.feed_pull_to_load_footer_message_for_free_traffic);
        map.append(1996619788, R.string.feed_pull_to_refresh_feed_no_more_data_for_free_traffic);
        map.append(1996619789, R.string.feed_pull_to_refresh_feed_occur_error_for_free_traffic);
        map.append(1996619790, R.string.feed_pull_to_refresh_feed_in_the_end);
        map.append(1996685315, R.color.feed_no_date_text_normal_new);
        map.append(1996685312, R.color.feed_no_date_text_normal_new);
        map.append(1996685324, R.color.feed_no_date_text_normal_new);
        map.append(1996685325, R.color.feed_no_date_text_normal_new);
        map.append(1996685326, R.color.feed_no_date_text_normal_new);
        return map;
    }

    public SparseIntArray getStyleMap() {
        return this.mState2ResId;
    }

    public void setCommonBackgroundColor(int commonBackgroundColor) {
        this.mCommonBackgroundColor = commonBackgroundColor;
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.mStateChangedListener = listener;
    }

    public AudioFooterView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AudioFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AudioFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mCurrentState = 0;
        this.mDisplayStyle = new DisplayStyle("style_normal");
        this.mIsNightMode = false;
        this.mState2ResId = createDefaultStyleMap();
        initLayout(context);
    }

    public View getRightCircleIconView() {
        return this.mRightCircle;
    }

    private void initLayout(Context context) {
        this.mIsNightMode = FeedRuntime.getNightMode();
        LayoutInflater.from(context).inflate(R.layout.feed_pull_to_load_footer_new, this);
        this.mLoadingMoreContainer = (ViewGroup) findViewById(R.id.pull_to_load_footer_content);
        this.mNoMoreDataContainer = (ViewGroup) findViewById(R.id.pull_to_no_more_data_container);
        this.mCommentNoMoreDataContainer = (FrameLayout) findViewById(R.id.comment_no_more_data_container);
        this.mProgressbar = (LoadingAnimView) findViewById(R.id.pull_to_load_footer_progressbar);
        this.mHintTextView = (TextView) findViewById(R.id.pull_to_load_footer_hint_textview);
        this.mTextView = (TextView) findViewById(R.id.time_line_text_new);
        ImageView imageView = (ImageView) findViewById(R.id.feed_refresh_circle);
        this.mRightCircle = imageView;
        imageView.setVisibility(0);
        if (FeedUtil.isFreeTrafficMode()) {
            this.mTextView.setText(this.mState2ResId.get(1996619788));
        } else {
            this.mTextView.setText(this.mState2ResId.get(1996554252));
        }
        initTheme();
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        this.forceVisiblility = visibility;
    }

    public void setState(int state) {
        this.mCurrentState = state;
        OnStateChangedListener onStateChangedListener = this.mStateChangedListener;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(state);
        }
        super.setVisibility(this.forceVisiblility);
        switch (this.mCurrentState) {
            case 0:
                this.mLoadingMoreContainer.setVisibility(0);
                this.mNoMoreDataContainer.setVisibility(8);
                this.mCommentNoMoreDataContainer.setVisibility(8);
                TextView textView = this.mHintTextView;
                if (textView != null) {
                    textView.setTextColor(getResources().getColor(this.mState2ResId.get(1996685312 | this.mCurrentState)));
                    if (!FeedUtil.isFreeTrafficMode()) {
                        this.mHintTextView.setText(this.mState2ResId.get(this.mCurrentState | 1996554240));
                        break;
                    } else {
                        this.mHintTextView.setText(this.mState2ResId.get(1996619776 | this.mCurrentState));
                        break;
                    }
                }
                break;
            case 3:
                this.mLoadingMoreContainer.setVisibility(0);
                this.mNoMoreDataContainer.setVisibility(8);
                this.mCommentNoMoreDataContainer.setVisibility(8);
                TextView textView2 = this.mHintTextView;
                if (textView2 != null) {
                    textView2.setTextColor(getStateTextColor());
                    if (FeedUtil.isFreeTrafficMode()) {
                        this.mHintTextView.setText(this.mState2ResId.get(1996619776 | this.mCurrentState));
                    } else {
                        this.mHintTextView.setText(this.mState2ResId.get(this.mCurrentState | 1996554240));
                    }
                }
                this.mProgressbar.startAnim();
                break;
            case 12:
                this.mLoadingMoreContainer.setVisibility(8);
                this.mNoMoreDataContainer.setVisibility(0);
                this.mCommentNoMoreDataContainer.setVisibility(8);
                TextView textView3 = this.mTextView;
                if (textView3 != null) {
                    textView3.setTextColor(getResources().getColor(this.mState2ResId.get(1996685312 | this.mCurrentState)));
                    if (!FeedUtil.isFreeTrafficMode()) {
                        this.mTextView.setText(this.mState2ResId.get(this.mCurrentState | 1996554240));
                        break;
                    } else {
                        this.mTextView.setText(this.mState2ResId.get(1996619776 | this.mCurrentState));
                        break;
                    }
                }
                break;
            case 13:
                this.mLoadingMoreContainer.setVisibility(8);
                this.mNoMoreDataContainer.setVisibility(0);
                this.mCommentNoMoreDataContainer.setVisibility(8);
                TextView textView4 = this.mTextView;
                if (textView4 != null) {
                    textView4.setTextColor(getResources().getColor(this.mState2ResId.get(1996685312 | this.mCurrentState)));
                    if (!FeedUtil.isFreeTrafficMode()) {
                        this.mTextView.setText(this.mState2ResId.get(this.mCurrentState | 1996554240));
                        break;
                    } else {
                        this.mTextView.setText(this.mState2ResId.get(1996619776 | this.mCurrentState));
                        break;
                    }
                }
                break;
            case 14:
                this.mLoadingMoreContainer.setVisibility(8);
                this.mNoMoreDataContainer.setVisibility(0);
                this.mCommentNoMoreDataContainer.setVisibility(8);
                TextView textView5 = this.mTextView;
                if (textView5 != null) {
                    textView5.setTextColor(getResources().getColor(this.mState2ResId.get(1996685312 | this.mCurrentState)));
                    if (!FeedUtil.isFreeTrafficMode()) {
                        this.mTextView.setText(this.mState2ResId.get(this.mCurrentState | 1996554240));
                        break;
                    } else {
                        this.mTextView.setText(this.mState2ResId.get(1996619776 | this.mCurrentState));
                        break;
                    }
                }
                break;
            case 15:
                this.mLoadingMoreContainer.setVisibility(8);
                this.mNoMoreDataContainer.setVisibility(8);
                this.mCommentNoMoreDataContainer.setVisibility(0);
                break;
        }
        if (this.mIsNightMode != FeedRuntime.getNightMode()) {
            this.mIsNightMode = FeedRuntime.getNightMode();
            initTheme();
        }
    }

    private int getStateTextColor() {
        int resId = this.mState2ResId.get(this.mCurrentState | 1996685312);
        if (resId <= 0) {
            return getResources().getColor(R.color.feed_no_date_text_normal_new);
        }
        return getResources().getColor(resId);
    }

    public void setDisplayStyle(DisplayStyle style) {
        if (style != null && !TextUtils.equals(style.style, this.mDisplayStyle.style)) {
            this.mDisplayStyle = style;
            if (TextUtils.equals(style.style, "style_with_bottom_space")) {
                setPadding(0, 0, 0, (int) getResources().getDimension(R.dimen.feed_load_more_container_bottom_space));
            } else {
                setPadding(0, 0, 0, 0);
            }
        }
    }

    public View getContentView() {
        return this;
    }

    public void onStateChanged(int state, Map<String, Object> map) {
        setState(state);
    }

    public int getState() {
        return this.mCurrentState;
    }

    public void setForceVisibility(int visibility) {
        setVisibility(visibility);
    }

    private void initTheme() {
        Resources res = FeedRuntime.getAppContext().getResources();
        int i2 = this.mCommonBackgroundColor;
        if (i2 == 0) {
            setBackgroundColor(res.getColor(R.color.feed_loading_more_color_classic));
        } else {
            setBackgroundColor(res.getColor(i2));
        }
        if (this.mLoadingMoreContainer != null) {
            this.mHintTextView.setTextColor(getStateTextColor());
            if (this.mCommonBackgroundColor == 0) {
                this.mLoadingMoreContainer.setBackgroundColor(getResources().getColor(R.color.feed_load_footer_bg));
            } else {
                this.mLoadingMoreContainer.setBackgroundColor(getResources().getColor(this.mCommonBackgroundColor));
            }
        }
        ViewGroup viewGroup = this.mNoMoreDataContainer;
        if (viewGroup != null) {
            int i3 = this.mCommonBackgroundColor;
            if (i3 == 0) {
                viewGroup.setBackgroundColor(res.getColor(R.color.feed_loading_more_color_classic_new));
            } else {
                viewGroup.setBackgroundColor(res.getColor(i3));
            }
            this.mTextView.setTextColor(getStateTextColor());
            this.mRightCircle.setImageDrawable(getResources().getDrawable(R.drawable.feed_refresh_icon_new));
            this.mTextView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void stopAnimation() {
        LoadingAnimView loadingAnimView = this.mProgressbar;
        if (loadingAnimView != null) {
            loadingAnimView.stopAnim();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (isClickable()) {
            switch (event.getAction()) {
                case 0:
                    setAlpha(0.2f);
                    break;
                case 1:
                case 3:
                    setAlpha(1.0f);
                    break;
            }
        }
        return super.onTouchEvent(event);
    }

    public void applyFeedNightMode() {
        ViewGroup viewGroup = this.mNoMoreDataContainer;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(FeedRuntime.getAppContext().getResources().getColor(R.color.feed_loading_more_color_classic_new));
        }
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextColor(getStateTextColor());
        }
        ImageView imageView = this.mRightCircle;
        if (imageView != null) {
            imageView.setImageDrawable(FeedRuntime.getAppContext().getResources().getDrawable(R.drawable.feed_refresh_icon_new));
        }
        ViewGroup viewGroup2 = this.mLoadingMoreContainer;
        if (viewGroup2 != null) {
            viewGroup2.setBackgroundColor(FeedRuntime.getAppContext().getResources().getColor(R.color.feed_load_footer_bg));
        }
        TextView textView2 = this.mHintTextView;
        if (textView2 != null) {
            textView2.setTextColor(getStateTextColor());
        }
    }

    public void addViewToCommentNoMoreContainer(View view2, FrameLayout.LayoutParams lp) {
        FrameLayout frameLayout = this.mCommentNoMoreDataContainer;
        if (frameLayout != null) {
            frameLayout.addView(view2, lp);
        }
    }

    public static class DisplayStyle {
        public static final String MODE_BOTTOM_SPACE = "style_with_bottom_space";
        public static final String MODE_NORMAL = "style_normal";
        public String style;

        public DisplayStyle(String style2) {
            this.style = style2;
        }
    }
}
