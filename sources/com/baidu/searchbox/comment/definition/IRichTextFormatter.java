package com.baidu.searchbox.comment.definition;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.comment.model.ForwardCommentInfo;
import com.baidu.searchbox.comment.model.ForwardCommentUBC;

public interface IRichTextFormatter {
    void addAuthor(Spannable spannable, int i2, int i3, Context context, int i4);

    SpannableString addCommentPkTag(int i2, SpannableString spannableString);

    void addStar(Spannable spannable, CharSequence charSequence, int i2, int i3);

    SpannableStringBuilder formatCommentTimeAndArea(String str, String str2);

    SpannableString formatCommentUser(TextView textView, int i2, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, ReplyClickUbcModel replyClickUbcModel);

    SpannableString formatContentForCommentInputTip(CharSequence charSequence, ForwardCommentInfo forwardCommentInfo, boolean z);

    void formatContentForEmotion(Spannable spannable, CharSequence charSequence, TextView textView, Context context);

    SpannableString formatContentForForwardComment(TextView textView, ForwardCommentInfo forwardCommentInfo, CharSequence charSequence, int i2, boolean z, String str, ClickableSpanListener clickableSpanListener);

    SpannableString formatContentForForwardComment(ForwardCommentInfo forwardCommentInfo, CharSequence charSequence, int i2, boolean z, String str, ClickableSpanListener clickableSpanListener);

    void forwardCommentUBCEvent(String str, String str2, String str3);

    void setForwardCommentUBC(ForwardCommentUBC forwardCommentUBC);

    void setTempDelegate(ITemplateDelegate iTemplateDelegate);

    public static class Utils {

        public interface IsExceedMaxLineCallback {
            void doSomething(boolean z, int[] iArr);
        }

        /* access modifiers changed from: private */
        public static boolean isExceedMaxLine(TextView textView, CharSequence content, int maxLine, int[] outArr) {
            if (textView == null) {
                return false;
            }
            TextPaint textPaint = textView.getPaint();
            int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
            int width2 = width <= 0 ? Integer.MAX_VALUE : width;
            CharSequence charSequence = content;
            TextPaint textPaint2 = textPaint;
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint2, width2, Layout.Alignment.ALIGN_NORMAL, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
            outArr[0] = staticLayout.getLineCount();
            if (staticLayout.getLineCount() > maxLine) {
                return true;
            }
            return false;
        }

        public static void isExceedMaxLineAsyncIfNeeded(TextView textView, CharSequence content, int maxLine, int[] outArr, IsExceedMaxLineCallback callback) {
            if (textView != null) {
                if (ViewCompat.isLaidOut(textView)) {
                    callback.doSomething(isExceedMaxLine(textView, content, maxLine, outArr), outArr);
                    return;
                }
                final TextView textView2 = textView;
                final CharSequence charSequence = content;
                final int i2 = maxLine;
                final int[] iArr = outArr;
                final IsExceedMaxLineCallback isExceedMaxLineCallback = callback;
                textView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        textView2.getViewTreeObserver().removeOnPreDrawListener(this);
                        isExceedMaxLineCallback.doSomething(Utils.isExceedMaxLine(textView2, charSequence, i2, iArr), iArr);
                        return true;
                    }
                });
            }
        }
    }

    public static abstract class PressedClickableSpan extends ClickableSpan {
        private boolean isCanPress;
        private int mNormalColor;
        private boolean mPressed;
        private int mPressedColor;

        public PressedClickableSpan(int normalColor, int pressedColor, boolean canPress) {
            this.mNormalColor = normalColor;
            this.mPressedColor = pressedColor;
            this.isCanPress = canPress;
        }

        public boolean isPressed() {
            return this.mPressed;
        }

        public void setPressed(boolean pressed) {
            this.mPressed = pressed;
        }

        public void updateDrawState(TextPaint ds) {
            boolean z;
            if (!this.isCanPress || !(z = this.mPressed)) {
                ds.setColor(this.mNormalColor);
            } else if (z) {
                ds.setColor(this.mPressedColor);
            }
        }
    }

    public static class ReplyClickUbcModel {
        public final String mCommentPage;
        public final String mLogId;
        public final String mNid;
        public final String mPage;
        public final String mSource;
        public final String mTopicId;
        public final String mcExt;

        public ReplyClickUbcModel(String page, String source, String topicId, String logId, String nid, String cExt, String commentPage) {
            this.mPage = page;
            this.mSource = source;
            this.mTopicId = topicId;
            this.mLogId = logId;
            this.mNid = nid;
            this.mcExt = cExt;
            this.mCommentPage = commentPage;
        }
    }
}
