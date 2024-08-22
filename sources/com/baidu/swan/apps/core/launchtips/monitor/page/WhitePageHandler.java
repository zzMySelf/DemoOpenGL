package com.baidu.swan.apps.core.launchtips.monitor.page;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.core.fragment.SwanAppBaseFragment;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.swan.apps.core.launchtips.scene.SceneWhiteScreenTips;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.monitor.MonitorUtils;
import com.baidu.swan.apps.monitor.parser.ErrorPageParser;
import com.baidu.swan.apps.monitor.parser.GridErrorPageParser;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.util.SwanAppUtils;

final class WhitePageHandler extends AbsEventHandler<EventRecheck> {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "WhitePageHandler";
    private final ErrorPageParser mDefaultParser = ErrorPageParser.Factory.getScreenParser(ErrorPageParser.SIMPLE_PARSER);
    private final GridErrorPageParser mGridScreenshotParser = ((GridErrorPageParser) ErrorPageParser.Factory.getScreenParser(ErrorPageParser.GRID_PARSER));

    public WhitePageHandler(Looper looper) {
        super(looper);
    }

    /* access modifiers changed from: protected */
    public void handleCapture(EventRecheck event) {
        if (event != null) {
            if (isTopPage(event.webViewId)) {
                sendParseCaptureEvent(event);
            } else if (DEBUG) {
                Log.d(TAG, ">> stop to capture, page is not top, webViewId =" + event.webViewId);
            }
        }
    }

    private void sendParseCaptureEvent(final EventRecheck event) {
        if (event != null) {
            if (DEBUG) {
                Log.d(TAG, ">> start to get capture.");
            }
            SwanAppUtils.runOnUiThread(new Runnable() {
                public void run() {
                    Bitmap capture = SwanAppUIUtils.getFullScreenshot();
                    if (capture != null) {
                        Message.obtain(WhitePageHandler.this, 2, EventRecheck.createParseEvent(event.webViewId, capture)).sendToTarget();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void handleParse(EventRecheck event) {
        if (event != null) {
            if (isTopPage(event.webViewId)) {
                Bitmap capture = event.capture;
                SwanAppBaseFragment fragment = MonitorUtils.getTopFragment();
                View webView = SwanAppController.getInstance().getBdWebViewBySlaveId(event.webViewId);
                if (capture != null && fragment != null && webView != null) {
                    boolean z = DEBUG;
                    if (z) {
                        Log.d(TAG, ">> start parsing capture");
                    }
                    Rect rect = MonitorUtils.getCheckRect(capture, fragment, webView);
                    this.mDefaultParser.setFilterColor(MonitorUtils.getPageBgColor(fragment));
                    if (MonitorUtils.hasNAView() || !this.mDefaultParser.isErrorPage(capture, rect)) {
                        double ratio = this.mGridScreenshotParser.getRealWhiteScreenRatio(capture, rect);
                        SceneWhiteScreenTips whiteScreenTips = new SceneWhiteScreenTips();
                        if (MonitorUtils.hasLoadingView() && ratio >= 0.5d) {
                            if (z) {
                                Log.d(TAG, ">> capture is part white screen ratio: " + ratio);
                            }
                            whiteScreenTips.setSceneType(SceneType.SCENE_WHITE_SCREEN_L3);
                            whiteScreenTips.handleWhiteScreenEvent(event.webViewId);
                        } else if (ratio >= 0.7d) {
                            if (z) {
                                Log.d(TAG, ">> capture is part white screen ratio: " + ratio);
                            }
                            whiteScreenTips.setSceneType(SceneType.SCENE_WHITE_SCREEN_L2);
                            whiteScreenTips.handleWhiteScreenEvent(event.webViewId);
                        } else {
                            WhitePageMonitor.getInstance().checkException();
                        }
                    } else {
                        if (z) {
                            Log.d(TAG, ">> capture is full white screen.");
                        }
                        SceneWhiteScreenTips sceneWhiteScreenTips = new SceneWhiteScreenTips();
                        sceneWhiteScreenTips.setSceneType(SceneType.SCENE_WHITE_SCREEN_L1);
                        sceneWhiteScreenTips.handleWhiteScreenEvent(event.webViewId);
                    }
                } else if (DEBUG) {
                    Log.d(TAG, ">> stop to parse capture, capture or fragment or webView is null.");
                }
            } else if (DEBUG) {
                Log.d(TAG, ">> stop to parse capture, page is not top, webViewId = " + event.webViewId);
            }
        }
    }

    private boolean isTopPage(String webViewId) {
        return TextUtils.equals(SwanAppUtils.getTopWebViewId(), webViewId);
    }
}
