package com.baidu.searchbox.text.span;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

public class CustomLinkMovementMethod extends LinkMovementMethod {
    private CustomClickableSpan mPressedSpan;

    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        CustomClickableSpan customClickableSpan;
        if (event.getAction() == 0) {
            CustomClickableSpan pressedSpan = getPressedSpan(widget, buffer, event);
            this.mPressedSpan = pressedSpan;
            if (pressedSpan != null) {
                pressedSpan.setIsPressed(true);
                Selection.setSelection(buffer, buffer.getSpanStart(this.mPressedSpan), buffer.getSpanEnd(this.mPressedSpan));
                return true;
            }
        } else if (event.getAction() == 1) {
            boolean isClick = false;
            CustomClickableSpan customClickableSpan2 = this.mPressedSpan;
            if (customClickableSpan2 != null) {
                isClick = customClickableSpan2.getIsPressed();
                this.mPressedSpan.setIsPressed(false);
                Selection.removeSelection(buffer);
            }
            CustomClickableSpan customClickableSpan3 = getPressedSpan(widget, buffer, event);
            if (customClickableSpan3 != null) {
                if (isClick) {
                    customClickableSpan3.onClick(widget);
                }
                return true;
            }
        } else if (event.getAction() == 3 && (customClickableSpan = this.mPressedSpan) != null) {
            customClickableSpan.setIsPressed(false);
            Selection.removeSelection(buffer);
        }
        return super.onTouchEvent(widget, buffer, event);
    }

    private CustomClickableSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent event) {
        int x = ((int) event.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) event.getY()) - textView.getTotalPaddingTop();
        int x2 = x + textView.getScrollX();
        int y2 = y + textView.getScrollY();
        Layout layout = textView.getLayout();
        int off = layout.getOffsetForHorizontal(layout.getLineForVertical(y2), (float) x2);
        CustomClickableSpan[] link = (CustomClickableSpan[]) spannable.getSpans(off, off, CustomClickableSpan.class);
        if (link.length > 0) {
            return link[0];
        }
        return null;
    }
}
