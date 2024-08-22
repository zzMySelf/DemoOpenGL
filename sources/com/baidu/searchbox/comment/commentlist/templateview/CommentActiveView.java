package com.baidu.searchbox.comment.commentlist.templateview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.definition.IBusinessManager;
import com.baidu.searchbox.comment.definition.ICommentSubBusiness;
import com.baidu.searchbox.comment.definition.ICommentView;
import com.baidu.searchbox.comment.definition.ISubBusiness;
import com.baidu.searchbox.comment.model.CommentActiveData;
import com.baidu.searchbox.comment.model.CommentPanelModel;
import com.baidu.searchbox.comment.params.CommonAttrs;
import com.baidu.searchbox.comment.sp.CommentSpWrapper;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.comment.util.CommentActiveShowHelper;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.facebook.drawee.view.SimpleDraweeView;

public class CommentActiveView extends LinearLayout implements ICommentView<CommentActiveData> {
    private CommonAttrs mAttrs;
    /* access modifiers changed from: private */
    public ICommentSubBusiness mCommentSubBusiness;
    private SimpleDraweeView mCommentTopBackground;
    private TextView mCommentTopBanner;
    private TextView mCommentTopCloseView;
    private TextView mCommentTopTitle;
    private View mRootView;
    private View mSplitLine;

    public CommentActiveView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommentActiveView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentActiveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    public View getViewInstance() {
        return this;
    }

    public Class<CommentActiveData> getDataType() {
        return CommentActiveData.class;
    }

    public void onSetBusinessManager(IBusinessManager businessManager) {
        if (businessManager != null) {
            this.mCommentSubBusiness = (ICommentSubBusiness) businessManager.findBusiness(ISubBusiness.SubBusinessEnum.COMMENT);
        }
    }

    public void onSetCommonAttrs(CommonAttrs attrs) {
        this.mAttrs = attrs;
    }

    private void initLayout(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.bdcomment_top_text_layout, this, true);
        setOrientation(1);
        this.mCommentTopTitle = (TextView) findViewById(R.id.bdcomment_top_text_title);
        this.mCommentTopBanner = (TextView) findViewById(R.id.bdcomment_top_text_banner);
        this.mCommentTopCloseView = (TextView) findViewById(R.id.bdcomment_top_close);
        this.mSplitLine = findViewById(R.id.bdcomment_top_split_line);
        this.mCommentTopBackground = (SimpleDraweeView) findViewById(R.id.bdcomment_top_active_background);
        notifyNightMode();
    }

    public void onBindView(int position, final CommentActiveData value) {
        if (value != null) {
            setTopTextTitle(value.getHighLightText());
            setTopTextBanner(value.getBannerText());
            ICommentSubBusiness iCommentSubBusiness = this.mCommentSubBusiness;
            if (iCommentSubBusiness != null) {
                setTopBackground(iCommentSubBusiness.getCommentPanelModel());
            }
            this.mCommentTopCloseView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (CommentActiveView.this.mCommentSubBusiness != null) {
                        CommentActiveView.this.updateCloseEvent();
                        CommentActiveView.this.setCommentTopUbcEvent("close", value.getBannerText());
                        CommentActiveView.this.mCommentSubBusiness.removeActiveData();
                    }
                }
            });
            this.mRootView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    CommentActiveShowHelper.recordActiveClick(value.getActiveId());
                    CommentActiveView.this.setCommentTopUbcEvent("click", value.getBannerText());
                    if (!TextUtils.isEmpty(value.getActiveLinkUrl())) {
                        BaseRouter.invokeScheme(CommentRuntime.getAppContext(), Uri.parse(value.getActiveLinkUrl()), "inside");
                    }
                }
            });
            updateSplitView();
        }
    }

    private void updateSplitView() {
        CommonAttrs commonAttrs = this.mAttrs;
        if (commonAttrs != null && !TextUtils.isEmpty(commonAttrs.commentTitleExtensionData)) {
            this.mSplitLine.setVisibility(8);
        }
    }

    private void setTopBackground(CommentPanelModel commentPanelModel) {
        if (commentPanelModel == null) {
            this.mCommentTopBackground.setVisibility(8);
            return;
        }
        CommonAttrs commonAttrs = this.mAttrs;
        if (commonAttrs == null || !commonAttrs.isLinkageScroll) {
            this.mCommentTopBackground.setVisibility(8);
        } else {
            this.mCommentTopBackground.setImageURI(commentPanelModel.getBackgroundPicture());
        }
    }

    private void setTopTextTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            this.mCommentTopTitle.setText(title);
        }
    }

    private void setTopTextBanner(String banner) {
        if (!TextUtils.isEmpty(banner)) {
            this.mCommentTopBanner.setText(banner);
        }
    }

    public void updateCloseEvent() {
        CommentSpWrapper.setCommentTopLastCloseTime(String.valueOf(System.currentTimeMillis()));
    }

    public void setCommentTopUbcEvent(String type, String value) {
        CommonAttrs commonAttrs = this.mAttrs;
        if (commonAttrs != null) {
            BDCommentStatisticHelper.commentTopUBCEvent(commonAttrs.source, type, this.mAttrs.nid, this.mAttrs.topicId, value, this.mAttrs.mcExt);
        }
    }

    private void notifyNightMode() {
        Context context = CommentRuntime.getAppContext();
        Resources resources = context.getResources();
        this.mCommentTopTitle.setTextColor(ContextCompat.getColor(context, com.baidu.searchbox.interaction.styles.R.color.IC208));
        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{ContextCompat.getColor(context, R.color.comment_top_text_start), ContextCompat.getColor(context, R.color.comment_top_text_middle), ContextCompat.getColor(context, R.color.comment_top_text_end)});
        drawable.setCornerRadius(resources.getDimension(R.dimen.comment_dimen_3_5dp));
        this.mCommentTopTitle.setBackground(drawable);
        this.mCommentTopTitle.setTextSize(0, FontSizeHelper.getScaledSize(0, resources.getDimension(R.dimen.comment_dimen_9dp)));
        this.mCommentTopBanner.setTextColor(ContextCompat.getColor(context, com.baidu.searchbox.interaction.styles.R.color.IC174));
        this.mCommentTopBanner.setTextSize(0, FontSizeHelper.getScaledSize(0, resources.getDimension(R.dimen.comment_dimen_12dp)));
        this.mCommentTopCloseView.setTextColor(ContextCompat.getColor(context, com.baidu.searchbox.interaction.styles.R.color.IC253));
        this.mCommentTopCloseView.setTextSize(0, FontSizeHelper.getScaledSize(0, resources.getDimension(R.dimen.comment_dimen_11dp)));
        this.mSplitLine.setBackgroundColor(ContextCompat.getColor(context, com.baidu.searchbox.interaction.styles.R.color.IC241));
    }

    public void onNotifyNightMode() {
        notifyNightMode();
    }
}
