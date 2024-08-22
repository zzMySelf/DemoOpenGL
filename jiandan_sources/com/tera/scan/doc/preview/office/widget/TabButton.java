package com.tera.scan.doc.preview.office.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import fe.mmm.qw.i.qw;

public class TabButton extends RelativeLayout {
    public int index;
    public boolean isScroll;
    public float lastX;
    public float lastY;
    public View line;
    public ITabClickListener listener;
    public boolean mIsAdjustWidth;
    public float mTouchSlop;
    public int size;
    public TextView textView;

    public TabButton(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mTouchSlop = (float) ViewConfiguration.getTouchSlop();
    }

    private boolean isMoveScroll(MotionEvent motionEvent) {
        return Math.sqrt((double) (((motionEvent.getX() - this.lastX) * (motionEvent.getX() - this.lastX)) + ((motionEvent.getY() - this.lastY) * (motionEvent.getY() - this.lastY)))) > ((double) this.mTouchSlop);
    }

    private void onClick() {
        ITabClickListener iTabClickListener = this.listener;
        if (iTabClickListener != null) {
            iTabClickListener.qw("", getText(), this.index);
        }
    }

    private void setContentBackground(int i2) {
        findViewById(R.id.tab_content).setBackgroundColor(getResources().getColor(i2));
    }

    private void setLineVisible(int i2) {
        if (this.line == null) {
            this.line = findViewById(R.id.line);
        }
        this.line.setVisibility(i2);
    }

    private void setTextColor(int i2) {
        if (this.textView == null) {
            this.textView = (TextView) findViewById(R.id.text);
        }
        this.textView.setTextColor(getResources().getColor(i2));
    }

    public String getText() {
        if (this.textView == null) {
            this.textView = (TextView) findViewById(R.id.text);
        }
        return this.textView.getText().toString();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        this.lastX = motionEvent.getX();
        this.lastY = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isScroll = false;
        } else if (action != 1) {
            if (action != 2) {
                return false;
            }
            if (isMoveScroll(motionEvent)) {
                this.isScroll = true;
                return false;
            }
        } else if (this.isScroll) {
            return false;
        } else {
            onClick();
        }
        return true;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public void setIsAdjustWidth(boolean z) {
        this.mIsAdjustWidth = z;
    }

    public void setListener(ITabClickListener iTabClickListener) {
        this.listener = iTabClickListener;
    }

    public void setSelected() {
        qw.ad("tabbutton", "setSelected");
        if (!this.mIsAdjustWidth) {
            setWidth(getResources().getDimensionPixelSize(R.dimen.select_tab_button_width));
        }
        setContentBackground(17170443);
        setTextColor(R.color.color_06a7ff);
    }

    public void setText(String str) {
        if (this.textView == null) {
            this.textView = (TextView) findViewById(R.id.text);
        }
        this.textView.setText(str);
    }

    public void setUnSelected() {
        qw.ad("tabbutton", "setUnSelected");
        if (!this.mIsAdjustWidth) {
            setWidth(getResources().getDimensionPixelSize(R.dimen.tabbutton_width));
        }
        setContentBackground(R.color.color_f9f9f9);
        setTextColor(R.color.color_999999);
        setLineVisible(8);
    }

    public void setWidth(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        qw.ad("tabbutton", "src width:" + layoutParams.width + " dest width:" + i2);
        layoutParams.width = i2;
        setLayoutParams(new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height));
    }

    public TabButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TabButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
