package com.baidu.searchbox.game.template.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatButton;

public class GameSelectorButton extends AppCompatButton {
    private static final float DISABLED_ALPHA_SCALE_DEFAULT = 0.4f;
    private static final int NORMAL_ALPHA = 1;
    private static final float PRESSED_ALPHA_SCALE_DEFAULT = 0.6f;
    private float disabledAlpha;
    private float pressedAlpha;

    public GameSelectorButton(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public GameSelectorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public GameSelectorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.disabledAlpha = 1.0f;
        this.pressedAlpha = 1.0f;
    }

    public void setDisabledAlphaScale(float disabledAlphaScale) {
        this.disabledAlpha = verify(disabledAlphaScale);
    }

    public void setPressedAlphaScale(float pressedAlphaScale) {
        this.pressedAlpha = verify(pressedAlphaScale);
    }

    private float verify(float value) {
        if (value > 1.0f) {
            return 1.0f;
        }
        if (value < 0.0f) {
            return 0.0f;
        }
        return value;
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!enabled) {
            setAlpha(this.disabledAlpha);
        } else {
            setAlpha(1.0f);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled()) {
            switch (event.getAction()) {
                case 0:
                    setAlpha(this.pressedAlpha);
                    break;
                case 1:
                    setAlpha(1.0f);
                    break;
                case 3:
                    setAlpha(1.0f);
                    break;
            }
        }
        return super.onTouchEvent(event);
    }
}
