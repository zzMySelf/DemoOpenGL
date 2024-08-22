package com.baidu.nadcore.widget.txt;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class CustomLinkMovementMethod extends LinkMovementMethod {
    private OnLinkMovementListener mLinkListener;

    public interface OnLinkMovementListener {
        void onLinkTouch(TextView textView, MotionEvent motionEvent);

        void onNoLinkTouch(TextView textView, MotionEvent motionEvent);
    }

    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int action = event.getAction();
        if (action != 1 && action != 0) {
            return Touch.onTouchEvent(widget, buffer, event);
        }
        int x = ((int) event.getX()) - widget.getTotalPaddingLeft();
        int y = ((int) event.getY()) - widget.getTotalPaddingTop();
        int x2 = x + widget.getScrollX();
        int y2 = y + widget.getScrollY();
        Layout layout = widget.getLayout();
        int off = layout.getOffsetForHorizontal(layout.getLineForVertical(y2), (float) x2);
        ClickableSpan[] link = (ClickableSpan[]) buffer.getSpans(off, off, ClickableSpan.class);
        if (link.length != 0) {
            if (action == 1) {
                link[0].onClick(widget);
            } else if (action == 0) {
                Selection.setSelection(buffer, buffer.getSpanStart(link[0]), buffer.getSpanEnd(link[0]));
            }
            OnLinkMovementListener onLinkMovementListener = this.mLinkListener;
            if (onLinkMovementListener != null) {
                onLinkMovementListener.onLinkTouch(widget, event);
            }
            return true;
        }
        OnLinkMovementListener onLinkMovementListener2 = this.mLinkListener;
        if (onLinkMovementListener2 != null) {
            onLinkMovementListener2.onNoLinkTouch(widget, event);
        }
        Selection.removeSelection(buffer);
        super.onTouchEvent(widget, buffer, event);
        return false;
    }

    public void setLinkMovementListener(OnLinkMovementListener listener) {
        this.mLinkListener = listener;
    }
}
