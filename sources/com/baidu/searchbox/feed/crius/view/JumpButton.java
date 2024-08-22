package com.baidu.searchbox.feed.crius.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.searchbox.crius.render.OpacityController;
import com.baidu.searchbox.crius.ui.IOpacitySupport;
import com.baidu.searchbox.feed.core.R;

public class JumpButton extends AppCompatTextView implements IOpacitySupport {
    private OpacityController mOpacityController;

    public JumpButton(Context context) {
        super(context);
        init();
    }

    public JumpButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public JumpButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setGravity(17);
        setTextSize((float) getResources().getDimensionPixelSize(R.dimen.feed_template_t2));
    }

    public void setOpacityController(OpacityController controller) {
        this.mOpacityController = controller;
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean pressed) {
        super.dispatchSetPressed(pressed);
        OpacityController opacityController = this.mOpacityController;
        if (opacityController != null) {
            opacityController.updateOpacity(this, pressed);
        }
    }
}
