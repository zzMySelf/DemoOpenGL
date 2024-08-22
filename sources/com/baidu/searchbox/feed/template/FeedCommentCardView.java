package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.feed.controller.FeedDataReportUtils;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedCommentCard;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.spswitch.emotion.EmotionLoader;
import com.baidu.spswitch.emotion.EmotionType;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedCommentCardView extends FrameLayout implements View.OnClickListener {
    private EllipsizeTextView mCommentText;
    private int mContentTextDefaultColor;
    private Context mContext;
    private FeedBaseModel mFeedBaseModel;
    private FeedCommentCard mFeedCommentCard;
    private int mTextSize;
    private EllipsizeTextView mTypeText;
    private int mTypeTextDefaultColor;

    public FeedCommentCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FeedCommentCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedCommentCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        this.mTextSize = getResources().getDimensionPixelSize(R.dimen.feed_template_new_t7_5);
        this.mTypeTextDefaultColor = R.color.feed_comment_card_default_type_color;
        this.mContentTextDefaultColor = R.color.feed_comment_card_default_comment_text_color;
        EllipsizeTextView ellipsizeTextView = new EllipsizeTextView(this.mContext);
        this.mTypeText = ellipsizeTextView;
        ellipsizeTextView.setTextSize(0, (float) this.mTextSize);
        this.mTypeText.setIncludeFontPadding(false);
        TypedValue typeOutValue = new TypedValue();
        getResources().getValue(R.dimen.feed_template_t4_line_space, typeOutValue, true);
        EllipsizeTextView ellipsizeTextView2 = this.mTypeText;
        ellipsizeTextView2.setLineSpacing(ellipsizeTextView2.getLineSpacingExtra(), typeOutValue.getFloat());
        addView(this.mTypeText, new FrameLayout.LayoutParams(-2, -2));
        EllipsizeTextView ellipsizeTextView3 = new EllipsizeTextView(this.mContext);
        this.mCommentText = ellipsizeTextView3;
        ellipsizeTextView3.setTextSize(0, (float) this.mTextSize);
        this.mCommentText.setMaxLines(2);
        this.mCommentText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCommentText.setIncludeFontPadding(false);
        TypedValue lineSpaceOutValue = new TypedValue();
        getResources().getValue(R.dimen.feed_template_t4_line_space, lineSpaceOutValue, true);
        EllipsizeTextView ellipsizeTextView4 = this.mCommentText;
        ellipsizeTextView4.setLineSpacing(ellipsizeTextView4.getLineSpacingExtra(), lineSpaceOutValue.getFloat());
        addView(this.mCommentText, new FrameLayout.LayoutParams(-1, -2));
        setBackground(getResources().getDrawable(R.drawable.feed_view_corner_bg));
        setVisibility(8);
        setOnClickListener(this);
    }

    private boolean isNeedShow(FeedBaseModel feedBaseModel) {
        FeedCommentCard feedCommentCard;
        if (feedBaseModel == null || feedBaseModel.data == null || (feedCommentCard = feedBaseModel.data.feedCommentCard) == null || TextUtils.isEmpty(feedCommentCard.type) || TextUtils.isEmpty(feedCommentCard.typeText) || TextUtils.isEmpty(feedCommentCard.text) || TextUtils.isEmpty(feedCommentCard.commentScheme) || TextUtils.isEmpty(feedCommentCard.typeColor) || TextUtils.isEmpty(feedCommentCard.textColor) || TextUtils.isEmpty(feedCommentCard.bgColor)) {
            return false;
        }
        return true;
    }

    public void update(FeedBaseModel feedBaseModel) {
        this.mFeedBaseModel = feedBaseModel;
        if (isNeedShow(feedBaseModel)) {
            setVisibility(0);
            this.mFeedCommentCard = feedBaseModel.data.feedCommentCard;
            processText(feedBaseModel.data.feedCommentCard);
            setBackground(getResources().getDrawable(R.drawable.feed_view_corner_bg));
            return;
        }
        setVisibility(8);
    }

    private void processText(FeedCommentCard feedCommentCard) {
        String typeText = feedCommentCard.typeText;
        int typeColor = getAvailableColor(feedCommentCard.typeColor, this.mTypeTextDefaultColor);
        this.mTypeText.setText(typeText);
        this.mTypeText.setTextColor(typeColor);
        String contentText = feedCommentCard.text;
        int contentColor = getAvailableColor(feedCommentCard.textColor, this.mContentTextDefaultColor);
        SpannableString spannableString = EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, this.mContext, contentText, this.mCommentText);
        spannableString.setSpan(new ForegroundColorSpan(contentColor), 0, spannableString.length(), 33);
        int spec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mTypeText.measure(spec, spec);
        spannableString.setSpan(new LeadingMarginSpan.Standard(getResources().getDimensionPixelOffset(R.dimen.feed_template_new_m33) + this.mTypeText.getMeasuredWidth(), 0), 0, spannableString.length(), 33);
        this.mCommentText.setText(spannableString);
    }

    private int getAvailableColor(String deliverColor, int defaultColor) {
        int color = getResources().getColor(defaultColor);
        if (TextUtils.isEmpty(deliverColor) || NightModeHelper.getNightModeSwitcherState()) {
            return color;
        }
        try {
            return Color.parseColor(deliverColor);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return color;
        }
    }

    public void onClick(View v) {
        FeedCommentCard feedCommentCard = this.mFeedCommentCard;
        if (feedCommentCard != null && !TextUtils.isEmpty(feedCommentCard.commentScheme)) {
            FeedRouter.invoke(getContext(), this.mFeedCommentCard.commentScheme, true);
            if (!this.mFeedBaseModel.runtimeStatus.isRead) {
                this.mFeedBaseModel.runtimeStatus.isRead = true;
            }
            String itemId = this.mFeedBaseModel.id;
            int position = this.mFeedBaseModel.runtimeStatus.viewPosition;
            String ext = "";
            if (this.mFeedBaseModel.feedback != null) {
                ext = this.mFeedBaseModel.feedback.ext;
            }
            if (NetWorkUtils.isNetworkConnected(this.mContext)) {
                JSONObject actionInfoObj = new JSONObject();
                try {
                    actionInfoObj.put(FeedDataReportUtils.ACTION_ID_CLICK_STYLE, FeedDataReportUtils.ACTION_CLICK_FROM_FEED_COMMENT);
                    actionInfoObj.put("comment_type", this.mFeedCommentCard.type);
                    FeedDataReportUtils.feedCommentCardClick(itemId, position, ext, actionInfoObj);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                setBackgroundColor(getResources().getColor(R.color.feed_comment_card_default_bg_pressed_color));
                break;
            case 1:
            case 3:
                setBackground(getResources().getDrawable(R.drawable.feed_view_corner_bg));
                break;
        }
        return super.onTouchEvent(event);
    }
}
