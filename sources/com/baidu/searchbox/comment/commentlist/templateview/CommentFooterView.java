package com.baidu.searchbox.comment.commentlist.templateview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.commentlist.business.TemplateDelegate;
import com.baidu.searchbox.comment.definition.IBusinessManager;
import com.baidu.searchbox.comment.definition.ICommentSubBusiness;
import com.baidu.searchbox.comment.definition.ICommentView;
import com.baidu.searchbox.comment.definition.ISubBusiness;
import com.baidu.searchbox.comment.definition.ITemplateDelegate;
import com.baidu.searchbox.comment.model.CommentConditionData;
import com.baidu.searchbox.comment.params.CommonAttrs;
import com.baidu.searchbox.comment.view.LoadingAnimView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.ubc.Flow;

public class CommentFooterView extends LinearLayout implements View.OnClickListener, ICommentView<CommentConditionData> {
    public static final int ALREADY_IN_THE_END = 4;
    public static final int COMMENT_NO_MORE_DATA_STATE = 5;
    public static final int DEFAULT_STATE = -1;
    public static final int LOADING_MORE_STATE = 1;
    public static final int LOAD_ERROR_STATE = 3;
    public static final int NO_MORE_DATA_STATE = 2;
    private CommonAttrs commonAttrs;
    private boolean isUpdatedExtraBottomPadding;
    private FrameLayout mCommentNoMoreDataContainer;
    private ICommentSubBusiness mCommentSubBusiness;
    private int mCurrentState;
    private TextView mHintTextView;
    private boolean mIsClassicTheme;
    private boolean mIsNightMode;
    private ViewGroup mLoadingMoreContainer;
    private ViewGroup mNoMoreDataContainer;
    private LoadingAnimView mProgressbar;
    private ImageView mRightCircle;
    private TemplateDelegate mTemplateDelegate;
    private TextView mTextView;

    public CommentFooterView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommentFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mCurrentState = 1;
        this.mIsClassicTheme = true;
        this.mIsNightMode = false;
        initLayout(context);
    }

    private void initLayout(Context context) {
        this.mIsNightMode = NightModeHelper.getNightModeSwitcherState();
        LayoutInflater.from(context).inflate(R.layout.comment_pull_to_load_footer, this);
        this.mLoadingMoreContainer = (ViewGroup) findViewById(R.id.pull_to_load_footer_content);
        this.mNoMoreDataContainer = (ViewGroup) findViewById(R.id.pull_to_no_more_data_container);
        this.mCommentNoMoreDataContainer = (FrameLayout) findViewById(R.id.comment_no_more_data_container);
        this.mIsClassicTheme = true;
        this.mProgressbar = (LoadingAnimView) findViewById(R.id.pull_to_load_footer_progressbar);
        this.mHintTextView = (TextView) findViewById(R.id.pull_to_load_footer_hint_textview);
        this.mTextView = (TextView) findViewById(R.id.time_line_text);
        ImageView imageView = (ImageView) findViewById(R.id.feed_refresh_circle);
        this.mRightCircle = imageView;
        imageView.setVisibility(8);
        this.mTextView.setText(R.string.ral_radio_model_reach_end);
        initTheme(this.mIsClassicTheme);
    }

    public View getViewInstance() {
        return this;
    }

    public Class<CommentConditionData> getDataType() {
        return CommentConditionData.class;
    }

    public void onSetCommonAttrs(CommonAttrs attrs) {
        this.commonAttrs = attrs;
        if (attrs != null) {
            this.mTemplateDelegate = new TemplateDelegate(attrs.mViewTemplate);
        }
    }

    public void onSetBusinessManager(IBusinessManager businessManager) {
        if (businessManager != null) {
            this.mCommentSubBusiness = (ICommentSubBusiness) businessManager.findBusiness(ISubBusiness.SubBusinessEnum.COMMENT);
        }
    }

    public void onBindView(int position, CommentConditionData conditionData) {
        CommonAttrs commonAttrs2;
        if (conditionData != null) {
            switch (conditionData.commentStatus) {
                case 0:
                case 5:
                    setState(3, true);
                    setVisibility(0);
                    setOnClickListener(this);
                    break;
                case 2:
                    setState(-1, true);
                    setVisibility(0);
                    setOnClickListener((View.OnClickListener) null);
                    break;
                case 3:
                    setState(2, true);
                    setOnClickListener((View.OnClickListener) null);
                    break;
                default:
                    setVisibility(8);
                    setOnClickListener((View.OnClickListener) null);
                    break;
            }
            if (this.mTemplateDelegate != null) {
                updateTheme(CommentRuntime.getAppContext(), this.mIsClassicTheme, this.mTemplateDelegate);
            }
            if (!this.isUpdatedExtraBottomPadding && this.mNoMoreDataContainer != null && (commonAttrs2 = this.commonAttrs) != null) {
                this.isUpdatedExtraBottomPadding = true;
                setPadding(0, 0, 0, commonAttrs2.extraPanelFooterBottomPadding);
            }
        }
    }

    private void setState(int state, boolean isClassicTheme) {
        this.mCurrentState = state;
        switch (state) {
            case -1:
                this.mLoadingMoreContainer.setVisibility(0);
                this.mNoMoreDataContainer.setVisibility(8);
                this.mCommentNoMoreDataContainer.setVisibility(8);
                TextView textView = this.mHintTextView;
                if (textView != null) {
                    textView.setText(R.string.feed_pull_to_load_footer_message);
                    break;
                }
                break;
            case 1:
                this.mLoadingMoreContainer.setVisibility(0);
                this.mNoMoreDataContainer.setVisibility(8);
                this.mCommentNoMoreDataContainer.setVisibility(8);
                TextView textView2 = this.mHintTextView;
                if (textView2 != null) {
                    textView2.setText(R.string.feed_pull_to_load_footer_message);
                }
                this.mProgressbar.startAnim();
                break;
            case 2:
            case 4:
                this.mLoadingMoreContainer.setVisibility(8);
                this.mNoMoreDataContainer.setVisibility(0);
                this.mCommentNoMoreDataContainer.setVisibility(8);
                TextView textView3 = this.mTextView;
                if (textView3 != null) {
                    textView3.setText(R.string.common_comment_nomore);
                    break;
                }
                break;
            case 3:
                this.mLoadingMoreContainer.setVisibility(8);
                this.mNoMoreDataContainer.setVisibility(0);
                this.mCommentNoMoreDataContainer.setVisibility(8);
                TextView textView4 = this.mTextView;
                if (textView4 != null) {
                    textView4.setText(R.string.feed_pull_to_refresh_feed_occur_error);
                    break;
                }
                break;
            case 5:
                this.mLoadingMoreContainer.setVisibility(8);
                this.mNoMoreDataContainer.setVisibility(8);
                this.mCommentNoMoreDataContainer.setVisibility(0);
                break;
        }
        if (this.mIsClassicTheme != isClassicTheme || this.mIsNightMode != NightModeHelper.getNightModeSwitcherState()) {
            this.mIsClassicTheme = isClassicTheme;
            this.mIsNightMode = NightModeHelper.getNightModeSwitcherState();
            initTheme(this.mIsClassicTheme);
        }
    }

    private void initTheme(boolean isClassicTheme) {
        if (isClassicTheme) {
            setBackgroundColor(ContextCompat.getColor(CommentRuntime.getAppContext(), R.color.feed_loading_more_color_classic));
        } else {
            setBackgroundColor(ContextCompat.getColor(CommentRuntime.getAppContext(), R.color.feed_loading_more_color_trans));
        }
        if (this.mLoadingMoreContainer != null) {
            if (isClassicTheme) {
                this.mHintTextView.setTextColor(ContextCompat.getColor(CommentRuntime.getAppContext(), R.color.feed_load_footer_text_color));
            } else {
                this.mHintTextView.setTextColor(ContextCompat.getColor(CommentRuntime.getAppContext(), R.color.feed_loading_more_text_color_trans));
            }
            this.mHintTextView.setTextSize(0, FontSizeHelper.getScaledSize(0, CommentRuntime.getAppContext().getResources().getDimension(R.dimen.feed_load_footer_text_size)));
            this.mLoadingMoreContainer.setBackgroundColor(ContextCompat.getColor(CommentRuntime.getAppContext(), R.color.feed_load_footer_bg));
        }
        ViewGroup viewGroup = this.mNoMoreDataContainer;
        if (viewGroup == null) {
            return;
        }
        if (isClassicTheme) {
            viewGroup.setBackgroundColor(ContextCompat.getColor(CommentRuntime.getAppContext(), R.color.feed_loading_more_color_classic));
            this.mTextView.setTextColor(ContextCompat.getColor(CommentRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC5));
            this.mTextView.setTextSize(0, FontSizeHelper.getScaledSize(0, CommentRuntime.getAppContext().getResources().getDimension(R.dimen.feed_load_footer_text_size)));
            this.mTextView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        viewGroup.setBackground(ContextCompat.getDrawable(CommentRuntime.getAppContext(), R.drawable.feed_time_line_bg_selector_trans));
        this.mTextView.setTextColor(ContextCompat.getColor(CommentRuntime.getAppContext(), com.baidu.searchbox.interaction.styles.R.color.IC10));
    }

    public void updateTheme(Context context, boolean isClassicTheme, ITemplateDelegate templateDelegate) {
        setBackgroundColor(ContextCompat.getColor(context, templateDelegate.getBackground(this.mCommentSubBusiness.getBusinessType().getPage(), isClassicTheme ? R.color.feed_loading_more_color_classic : R.color.feed_loading_more_color_trans)));
        if (this.mLoadingMoreContainer != null) {
            this.mHintTextView.setTextColor(ContextCompat.getColor(context, templateDelegate.getCommentHintTextColor(isClassicTheme ? R.color.feed_load_footer_text_color : R.color.feed_loading_more_text_color_trans)));
            this.mProgressbar.setColor(templateDelegate.getCommentHintTextColor(R.color.comment_pull_load_footer_image_color));
            this.mLoadingMoreContainer.setBackgroundColor(ContextCompat.getColor(context, templateDelegate.getBackground(this.mCommentSubBusiness.getBusinessType().getPage(), R.color.feed_load_footer_bg)));
        }
        ViewGroup viewGroup = this.mNoMoreDataContainer;
        if (viewGroup != null) {
            if (isClassicTheme) {
                viewGroup.setBackgroundColor(ContextCompat.getColor(context, templateDelegate.getBackground(this.mCommentSubBusiness.getBusinessType().getPage(), R.color.feed_loading_more_color_classic)));
                this.mTextView.setTextColor(ContextCompat.getColor(context, templateDelegate.getCommentHintTextColor(com.baidu.android.common.ui.style.R.color.GC5)));
            } else {
                viewGroup.setBackgroundColor(ContextCompat.getColor(context, templateDelegate.getBackground(this.mCommentSubBusiness.getBusinessType().getPage(), R.drawable.feed_time_line_bg_normal_trans)));
                this.mTextView.setTextColor(ContextCompat.getColor(context, templateDelegate.getCommentHintTextColor(R.color.feed_time_line_text_color_trans)));
            }
        }
        ICommentSubBusiness iCommentSubBusiness = this.mCommentSubBusiness;
        if (iCommentSubBusiness != null) {
            this.mTemplateDelegate.fixUpView(this.mLoadingMoreContainer, iCommentSubBusiness.getBusinessType());
            this.mTemplateDelegate.fixUpView(this.mNoMoreDataContainer, this.mCommentSubBusiness.getBusinessType());
        }
    }

    public void onNotifyNightMode() {
        initTheme(true);
        if (this.mTemplateDelegate != null) {
            updateTheme(CommentRuntime.getAppContext(), this.mIsClassicTheme, this.mTemplateDelegate);
        }
    }

    public void onClick(View v) {
        if (!NetWorkUtils.isConnected(CommentRuntime.getAppContext())) {
            UniversalToast.makeText(CommentRuntime.getAppContext(), R.string.update_toast_bad_net).show();
            return;
        }
        ICommentSubBusiness iCommentSubBusiness = this.mCommentSubBusiness;
        if (iCommentSubBusiness != null) {
            iCommentSubBusiness.requestCommentList((Flow) null, false, true);
        }
        setState(-1, true);
        setOnClickListener((View.OnClickListener) null);
    }
}
