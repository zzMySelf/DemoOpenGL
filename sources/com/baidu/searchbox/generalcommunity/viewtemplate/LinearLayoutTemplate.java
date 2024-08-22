package com.baidu.searchbox.generalcommunity.viewtemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.IFeedTplContainer;
import com.baidu.searchbox.feed.base.hot.IDynamicTemplateAttribute;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import java.util.Map;

public class LinearLayoutTemplate extends LinearLayout implements FeedTemplate, IDynamicTemplateAttribute {
    public FeedTemplate.OnChildViewClickListener mChildClickListener;
    private ViewTemplateCommonOpr mTemplateOpr;

    public LinearLayoutTemplate(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinearLayoutTemplate(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearLayoutTemplate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mTemplateOpr = new ViewTemplateCommonOpr(this);
    }

    public void getSize(FeedTemplate.SizeReadyCallback cb) {
        this.mTemplateOpr.getSize(cb);
    }

    public void initialize(Context context) {
        this.mTemplateOpr.initialize(context);
    }

    public void onFontSizeChanged(int fontSizeInPx) {
    }

    public void onClick(View v) {
        if (this.mChildClickListener != null) {
            v.setTag(getFeedModel());
            this.mChildClickListener.onClick(v);
        }
    }

    public void setOnChildViewClickListener(FeedTemplate.OnChildViewClickListener listener) {
        this.mChildClickListener = listener;
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        this.mTemplateOpr.update(feedModel, options);
    }

    public void afterCreateViewHolder() {
    }

    public void beforeBindViewHolder(FeedBaseModel feedModel) {
    }

    public FeedBaseModel getFeedModel() {
        return this.mTemplateOpr.getFeedModel();
    }

    public void hideBottomDivider(boolean needHide) {
    }

    public void updateRefreshTime() {
    }

    public void afterBindViewHolder(FeedBaseModel feedModel) {
    }

    public void applyFontSize() {
    }

    public void applyFeedNightMode() {
        this.mTemplateOpr.applyFeedNightMode();
    }

    public void applyRoundUiPolicy() {
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        this.mTemplateOpr.onFeedNightModeChanged(isNightMode);
    }

    public void setChannelId(String business) {
        this.mTemplateOpr.setChannelId(business);
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        return null;
    }

    public void bindFeedTplContainer(IFeedTplContainer feedTplContainer) {
    }

    public View getRootView() {
        return this;
    }

    public boolean couldShield() {
        return this.mTemplateOpr.couldShield();
    }

    /* access modifiers changed from: protected */
    public String getBusiness() {
        return this.mTemplateOpr.getBusiness();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mTemplateOpr.onDetachedFromWindow(this);
    }

    public boolean needConsumeClick() {
        return false;
    }
}
