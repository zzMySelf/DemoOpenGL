package com.baidu.searchbox.iminteract.imrichtext;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.baidu.searchbox.comment.model.ForwardCommentInfo;

public interface IRichTextFormatter {
    void formatContentForEmotion(Spannable spannable, CharSequence charSequence, TextView textView, Context context);

    SpannableString formatContentForForwardComment(TextView textView, ForwardCommentInfo forwardCommentInfo, CharSequence charSequence, int i2, boolean z);

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
}
