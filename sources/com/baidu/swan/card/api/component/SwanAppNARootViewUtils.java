package com.baidu.swan.card.api.component;

import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.baidu.swan.card.render.jscontainer.interfaces.ISwanAppWebView;

public class SwanAppNARootViewUtils {
    public static FrameLayout.LayoutParams generateLayoutParams(ISwanAppWebView mNgWebView, SwanAppRectPosition position) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(position.getWidth(), position.getHeight());
        int offX = 0;
        int offY = 0;
        if (position.isFixed()) {
            offX = mNgWebView.getWebViewScrollX();
            offY = mNgWebView.getWebViewScrollY();
        }
        layoutParams.leftMargin = position.getLeft() + offX;
        layoutParams.topMargin = position.getTop() + offY;
        if (position.hasGravity()) {
            layoutParams.leftMargin = position.getLeft();
            layoutParams.topMargin = position.getTop();
            if (position.isFixTop()) {
                layoutParams.topMargin = position.getFixedTop();
            }
            if (position.isFixBottom()) {
                layoutParams.bottomMargin = position.getFixedBottom();
                layoutParams.topMargin = 0;
            }
            if (position.isFixLeft()) {
                layoutParams.leftMargin = position.getFixedLeft();
            }
            if (position.isFixRight()) {
                layoutParams.rightMargin = position.getFixedRight();
                layoutParams.leftMargin = 0;
            }
            layoutParams.gravity = (position.isFixBottom() ? 80 : 48) | (position.isFixRight() ? GravityCompat.END : GravityCompat.START);
        }
        return layoutParams;
    }

    public static void fillViewTag(SwanAppNARootViewTag viewTag, SwanAppRectPosition position) {
        viewTag.setOriginLeft(position.getLeft());
        viewTag.setOriginTop(position.getTop());
        if (position.isFixed()) {
            viewTag.addFlags(1);
        } else {
            viewTag.removeFlags(1);
        }
    }
}
