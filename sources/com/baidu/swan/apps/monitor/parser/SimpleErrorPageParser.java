package com.baidu.swan.apps.monitor.parser;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import java.util.Iterator;

class SimpleErrorPageParser extends ErrorPageParser {
    private static final int GREY_BACKGROUND = -657931;
    private static final String TAG = "SimpleErrorPageParser";

    SimpleErrorPageParser() {
    }

    public boolean isErrorPage(Bitmap screenshot, Rect rect) {
        if (DEBUG) {
            Log.d(TAG, "SimpleErrorPageParser: start error page parse");
        }
        if (screenshot == null) {
            return false;
        }
        if (!isValidRect(screenshot, rect)) {
            rect = new Rect(0, 0, screenshot.getWidth(), screenshot.getHeight());
        }
        try {
            int color = screenshot.getPixel(rect.left + 1, rect.top + 1);
            boolean isValidColor = color == -1 || color == -657931;
            if (!isValidColor && this.mColorSet != null) {
                Iterator it = this.mColorSet.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((Integer) it.next()).intValue() == color) {
                            isValidColor = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (!isValidColor) {
                return false;
            }
            for (int i2 = rect.left + 1; i2 < rect.right - 1; i2++) {
                for (int j2 = rect.top + 1; j2 < rect.bottom - 1; j2++) {
                    if (color != screenshot.getPixel(i2, j2)) {
                        if (SwanAppLibConfig.DEBUG) {
                            Log.d(TAG, "非白屏, 图片大小 " + screenshot.getWidth() + " x " + screenshot.getHeight() + "; rect + " + rect.toShortString() + "; (" + i2 + "," + j2 + ")");
                        }
                        return false;
                    }
                }
            }
            if (DEBUG) {
                Log.d(TAG, "白屏, 图片大小 " + rect.width() + " x " + rect.height());
            }
            return true;
        } catch (IllegalArgumentException e2) {
            if (DEBUG) {
                Log.d(TAG, "W:" + screenshot.getWidth() + "; H:" + screenshot.getHeight());
                e2.printStackTrace();
            }
            return false;
        }
    }
}
