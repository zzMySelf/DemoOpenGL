package com.baidu.searchbox.toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.common.toolbar.R;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.rewardsystem.newtimer.constants.NewTimerConstants;
import com.baidu.searchbox.ui.SelectorTextView;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
import com.baidu.spswitch.emotion.EmotionLoader;
import com.baidu.spswitch.emotion.EmotionType;
import com.facebook.drawee.view.SimpleDraweeView;

public class CommentInputLayout extends LinearLayout implements IFontSizeViewListener {
    private static final float DISABLED_ALPHA = 0.5f;
    private static final float EMOTION_RATIO = 1.2f;
    private SelectorImageView mCommentEmojiIcon;
    private SelectorImageView mCommentEmojiIcon1;
    private SelectorImageView mCommentEmojiIcon2;
    private View mCommentHotContainer;
    private SelectorImageView mCommentHotIcon;
    private SimpleDraweeView mCommentHotIconAnim;
    /* access modifiers changed from: private */
    public SelectorTextView mCommentInputGuide;
    private ICommentInputLayoutCallback mCommentInputLayoutCallback;
    /* access modifiers changed from: private */
    public SelectorTextView mCommentInputView;
    private AnimatorSet mGuideAnim;
    private AnimatorSet mGuideEndAnim;
    /* access modifiers changed from: private */
    public boolean mIsGuideShowing;
    private boolean mIsResponseFontSize = false;

    public CommentInputLayout(Context context) {
        super(context);
        initLayout(context);
    }

    public CommentInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public CommentInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    private void initLayout(Context context) {
        LayoutInflater.from(context).inflate(R.layout.common_comment_intput_layout, this, true);
        setIsResponseFontSize(true);
        SelectorTextView selectorTextView = (SelectorTextView) findViewById(R.id.toolbar_comment_input_view);
        this.mCommentInputView = selectorTextView;
        selectorTextView.setPadding(getResources().getDimensionPixelOffset(R.dimen.common_toolbar_commentinput_padding), 0, 0, 0);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mCommentInputView, 0, R.dimen.common_toolbar_commentinput_hint_size, 2);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.toolbar_item_comment_input_bg_normal));
        this.mCommentInputView.setText(R.string.common_tool_bar_item_comment_input_text);
        this.mCommentInputView.setSingleLine(true);
        this.mCommentInputView.setEllipsize(TextUtils.TruncateAt.END);
        this.mCommentInputView.setGravity(16);
        this.mCommentHotContainer = findViewById(R.id.comments_hot_comment);
        this.mCommentHotIcon = (SelectorImageView) findViewById(R.id.comments_hot_comment_icon);
        this.mCommentHotIconAnim = (SimpleDraweeView) findViewById(R.id.hot_comment_icon_anim);
        this.mCommentEmojiIcon = (SelectorImageView) findViewById(R.id.toolbar_comment_input_emoji);
        this.mCommentEmojiIcon1 = (SelectorImageView) findViewById(R.id.toolbar_comment_input_emoji_1);
        this.mCommentEmojiIcon2 = (SelectorImageView) findViewById(R.id.toolbar_comment_input_emoji_2);
        this.mCommentInputGuide = (SelectorTextView) findViewById(R.id.toolbar_comment_input_guide_view);
        onFontSizeChange();
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.mCommentInputView.setEnabled(enabled);
        this.mCommentHotIcon.setEnabled(enabled);
        this.mCommentEmojiIcon.setEnabled(enabled);
        this.mCommentEmojiIcon1.setEnabled(enabled);
        this.mCommentEmojiIcon2.setEnabled(enabled);
        this.mCommentInputGuide.setEnabled(enabled);
        ICommentInputLayoutCallback iCommentInputLayoutCallback = this.mCommentInputLayoutCallback;
        if (iCommentInputLayoutCallback != null) {
            iCommentInputLayoutCallback.onSetEnabled(enabled);
        }
    }

    public SelectorTextView getCommentInputView() {
        return this.mCommentInputView;
    }

    public SelectorTextView getCommentInputGuide() {
        return this.mCommentInputGuide;
    }

    public SelectorImageView getCommentHotIcon() {
        return this.mCommentHotIcon;
    }

    public SimpleDraweeView getCommentHotIconAnim() {
        return this.mCommentHotIconAnim;
    }

    public SelectorImageView getCommentEmojiIcon() {
        return this.mCommentEmojiIcon;
    }

    public SelectorImageView getCommentEmojiIcon1() {
        return this.mCommentEmojiIcon1;
    }

    public SelectorImageView getCommentEmojiIcon2() {
        return this.mCommentEmojiIcon2;
    }

    public void setCommentHotOpen(boolean open) {
        Drawable drawable;
        SelectorImageView selectorImageView = this.mCommentHotIcon;
        if (open) {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.common_tool_bar_item_barrage_open);
        } else {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.common_tool_bar_item_barrage_close);
        }
        selectorImageView.setImageDrawable(drawable);
    }

    public void setCommentHotDisable() {
        setCommentHotOpen(false);
        this.mCommentHotIcon.setEnabled(false);
        this.mCommentHotIcon.setAlpha(0.5f);
    }

    public View getCommentHotView() {
        return this.mCommentHotContainer;
    }

    public void setSupportDark(boolean dark) {
        this.mCommentHotIcon.setSupportDark(Boolean.valueOf(dark));
        this.mCommentEmojiIcon.setSupportDark(Boolean.valueOf(dark));
        this.mCommentEmojiIcon1.setSupportDark(Boolean.valueOf(dark));
        this.mCommentEmojiIcon2.setSupportDark(Boolean.valueOf(dark));
    }

    public boolean isResponseFontSize() {
        return this.mIsResponseFontSize;
    }

    public void setIsResponseFontSize(boolean isResponseFontSize) {
        this.mIsResponseFontSize = isResponseFontSize;
        SelectorImageView selectorImageView = this.mCommentHotIcon;
        if (selectorImageView != null) {
            selectorImageView.setIsResponseFontSize(isResponseFontSize);
        }
        SelectorImageView selectorImageView2 = this.mCommentEmojiIcon;
        if (selectorImageView2 != null) {
            selectorImageView2.setIsResponseFontSize(isResponseFontSize);
        }
        SelectorImageView selectorImageView3 = this.mCommentEmojiIcon1;
        if (selectorImageView3 != null) {
            selectorImageView3.setIsResponseFontSize(isResponseFontSize);
        }
        SelectorImageView selectorImageView4 = this.mCommentEmojiIcon2;
        if (selectorImageView4 != null) {
            selectorImageView4.setIsResponseFontSize(isResponseFontSize);
        }
        onFontSizeChange();
    }

    public void onFontSizeChange() {
        SelectorTextView selectorTextView;
        SelectorTextView selectorTextView2 = this.mCommentInputView;
        if (selectorTextView2 != null) {
            if (this.mIsResponseFontSize) {
                FontSizeTextViewExtKt.setScaledSize(selectorTextView2, 0, 0, ((float) getResources().getDimensionPixelSize(R.dimen.common_toolbar_commentinput_hint_size)) * 1.0f, 2);
            } else {
                selectorTextView2.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.common_toolbar_commentinput_hint_size));
            }
            this.mCommentInputView.setText(EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), this.mCommentInputView.getText(), (TextView) this.mCommentInputView, 1.2f), TextView.BufferType.SPANNABLE);
        }
        SelectorImageView selectorImageView = this.mCommentHotIcon;
        if (selectorImageView != null) {
            selectorImageView.onFontSizeChange();
        }
        SelectorImageView selectorImageView2 = this.mCommentEmojiIcon;
        if (selectorImageView2 != null) {
            selectorImageView2.onFontSizeChange();
        }
        SelectorImageView selectorImageView3 = this.mCommentEmojiIcon1;
        if (selectorImageView3 != null) {
            selectorImageView3.onFontSizeChange();
        }
        SelectorImageView selectorImageView4 = this.mCommentEmojiIcon2;
        if (selectorImageView4 != null) {
            selectorImageView4.onFontSizeChange();
        }
        if (isResponseFontSize() && (selectorTextView = this.mCommentInputGuide) != null) {
            FontSizeTextViewExtKt.setScaledSize(selectorTextView, 0, 0, ((float) getResources().getDimensionPixelSize(R.dimen.common_toolbar_commentinput_hint_size)) * 1.0f, 2);
            this.mCommentInputGuide.setText(EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), this.mCommentInputGuide.getText(), (TextView) this.mCommentInputGuide, 1.2f), TextView.BufferType.SPANNABLE);
        }
        if (isResponseFontSize()) {
            FontSizeViewExtKt.setScaledHeightRes(this, 0, R.dimen.common_toolbar_commentinput_height, 2);
            Drawable inputDrawable = ContextCompat.getDrawable(getContext(), R.drawable.toolbar_item_comment_input_bg_normal);
            if (inputDrawable instanceof GradientDrawable) {
                ((GradientDrawable) inputDrawable).setCornerRadius(FontSizeHelper.getScaledSizeRes(0, R.dimen.toolbar_comment_input_corner_radius));
                setBackground(inputDrawable);
            }
        }
    }

    public void startCommentInputGuide(SpannableString spannableString, boolean withAnim) {
        if (this.mCommentInputGuide != null && this.mCommentInputView != null) {
            this.mCommentInputGuide.setText(EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), (CharSequence) spannableString, (TextView) this.mCommentInputGuide, 1.2f), TextView.BufferType.SPANNABLE);
            if (!withAnim) {
                this.mCommentInputGuide.setVisibility(0);
                this.mCommentInputGuide.setAlpha(1.0f);
                this.mCommentInputGuide.setTranslationY(0.0f);
                this.mCommentInputView.setVisibility(8);
                this.mIsGuideShowing = true;
                return;
            }
            int transY = this.mCommentInputView.getMeasuredHeight();
            if (this.mGuideAnim == null) {
                AnimatorSet buildCommentInputGuideAnim = buildCommentInputGuideAnim(transY, this.mCommentInputView, this.mCommentInputGuide);
                this.mGuideAnim = buildCommentInputGuideAnim;
                buildCommentInputGuideAnim.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animation) {
                        CommentInputLayout.this.mCommentInputView.setVisibility(8);
                    }

                    public void onAnimationStart(Animator animation) {
                        CommentInputLayout.this.mCommentInputGuide.setVisibility(0);
                        boolean unused = CommentInputLayout.this.mIsGuideShowing = true;
                    }
                });
            }
            this.mGuideAnim.start();
        }
    }

    private AnimatorSet buildCommentInputGuideAnim(int transY, View fromView, View toView) {
        int i2 = transY;
        View view2 = fromView;
        View view3 = toView;
        ObjectAnimator fromTransAnim = ObjectAnimator.ofFloat(view2, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{0.0f, (float) (-i2)});
        ObjectAnimator fromAlphaAnim = ObjectAnimator.ofFloat(view2, "alpha", new float[]{0.0f});
        AnimatorSet fromAnim = new AnimatorSet();
        fromAnim.setDuration(320);
        fromAnim.playTogether(new Animator[]{fromTransAnim, fromAlphaAnim});
        ObjectAnimator toTransAnim = ObjectAnimator.ofFloat(view3, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{(float) i2, 0.0f});
        ObjectAnimator toAlphaAnim = ObjectAnimator.ofFloat(view3, "alpha", new float[]{1.0f});
        AnimatorSet toAnim = new AnimatorSet();
        toAnim.setDuration(320);
        toAnim.setStartDelay(160);
        toAnim.playTogether(new Animator[]{toTransAnim, toAlphaAnim});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{fromAnim, toAnim});
        return animatorSet;
    }

    public void endCommentInputGuide(boolean withAnim) {
        SelectorTextView selectorTextView;
        if (this.mCommentInputGuide != null && (selectorTextView = this.mCommentInputView) != null) {
            if (!withAnim) {
                selectorTextView.setVisibility(0);
                this.mCommentInputView.setTranslationY(0.0f);
                this.mCommentInputView.setAlpha(1.0f);
                this.mCommentInputGuide.setVisibility(8);
                this.mIsGuideShowing = false;
                return;
            }
            int transY = selectorTextView.getMeasuredHeight();
            if (this.mGuideEndAnim == null) {
                AnimatorSet buildCommentInputGuideAnim = buildCommentInputGuideAnim(-transY, this.mCommentInputGuide, this.mCommentInputView);
                this.mGuideEndAnim = buildCommentInputGuideAnim;
                buildCommentInputGuideAnim.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animation) {
                        CommentInputLayout.this.mCommentInputGuide.setVisibility(8);
                    }

                    public void onAnimationStart(Animator animation) {
                        CommentInputLayout.this.mCommentInputView.setVisibility(0);
                        boolean unused = CommentInputLayout.this.mIsGuideShowing = false;
                    }
                });
            }
            this.mGuideEndAnim.start();
        }
    }

    public void releaseAnim() {
        AnimatorSet animatorSet = this.mGuideAnim;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mGuideAnim.end();
            this.mGuideAnim = null;
        }
        AnimatorSet animatorSet2 = this.mGuideEndAnim;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.mGuideEndAnim.end();
            this.mGuideEndAnim = null;
        }
    }

    public boolean isGuideShowing() {
        return this.mIsGuideShowing;
    }

    public void setCommentInputLayoutCallback(ICommentInputLayoutCallback callback) {
        this.mCommentInputLayoutCallback = callback;
    }
}
