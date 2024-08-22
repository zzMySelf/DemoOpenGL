package com.baidu.swan.card.api.component.touch;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.utils.SwanUIUtils;
import com.baidu.swan.card.card.SwanCardController;
import com.baidu.swan.card.render.engine.event.msg.SwanAppWebMessage;
import com.baidu.swan.card.utils.SwanAppLibConfig;

public class SwanAppTouchListener implements View.OnTouchListener {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final int LONG_PRESS_INTERVAL = 350;
    public static final String SWAN_CORE_SPLIT = "1.12.0";
    private static final String TAG = "SwanAppTouchListener";
    private static final int TAP_PRESS_MOVE_DISTANCE = 10;
    private boolean isSendToMaster = false;
    private TouchPosition mDownPosition;
    private long mDownTime;
    private LongPressRunnable mLongPressRunnable = new LongPressRunnable();
    private String mSlaveId;
    private String mViewId;
    private String mViewType;
    private int[] mWebViewLocation = new int[2];

    public SwanAppTouchListener(String slaveId, String viewId, String viewType) {
        this.mSlaveId = slaveId;
        this.mViewId = viewId;
        this.mViewType = viewType;
        setSendTarget();
        syncWebViewLocation();
    }

    public boolean onTouch(View v, MotionEvent event) {
        handleEvent(v, event);
        return true;
    }

    private void setSendTarget() {
        this.isSendToMaster = false;
    }

    private void syncWebViewLocation() {
        View webview = SwanCardController.getInstance().getBdWebViewBySlaveId(this.mSlaveId);
        if (webview != null) {
            webview.getLocationOnScreen(this.mWebViewLocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0066, code lost:
        if (isValidMoveDistance(new com.baidu.swan.card.api.component.touch.SwanAppTouchListener.TouchPosition(r11, (double) r13.getX(), (double) r13.getY())) == false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleEvent(android.view.View r12, android.view.MotionEvent r13) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x00a3
            if (r13 == 0) goto L_0x00a3
            java.lang.String r0 = r11.mSlaveId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00a3
            java.lang.String r0 = r11.mViewId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0016
            goto L_0x00a3
        L_0x0016:
            int r0 = r13.getActionMasked()
            r1 = 350(0x15e, double:1.73E-321)
            r3 = 1
            if (r0 != 0) goto L_0x004c
            int r4 = r13.getPointerCount()
            if (r4 != r3) goto L_0x004c
            com.baidu.swan.card.api.component.touch.SwanAppTouchListener$TouchPosition r4 = new com.baidu.swan.card.api.component.touch.SwanAppTouchListener$TouchPosition
            float r5 = r13.getX()
            double r7 = (double) r5
            float r5 = r13.getY()
            double r9 = (double) r5
            r5 = r4
            r6 = r11
            r5.<init>(r7, r9)
            r11.mDownPosition = r4
            long r4 = r13.getEventTime()
            r11.mDownTime = r4
            com.baidu.swan.card.api.component.touch.SwanAppTouchListener$LongPressRunnable r4 = r11.mLongPressRunnable
            r4.setEvent(r13)
            com.baidu.swan.card.api.component.touch.SwanAppTouchListener$LongPressRunnable r4 = r11.mLongPressRunnable
            r12.postDelayed(r4, r1)
            r11.syncWebViewLocation()
            goto L_0x006d
        L_0x004c:
            if (r0 == r3) goto L_0x0068
            r4 = 3
            if (r0 == r4) goto L_0x0068
            com.baidu.swan.card.api.component.touch.SwanAppTouchListener$TouchPosition r4 = new com.baidu.swan.card.api.component.touch.SwanAppTouchListener$TouchPosition
            float r5 = r13.getX()
            double r7 = (double) r5
            float r5 = r13.getY()
            double r9 = (double) r5
            r5 = r4
            r6 = r11
            r5.<init>(r7, r9)
            boolean r4 = r11.isValidMoveDistance(r4)
            if (r4 != 0) goto L_0x006d
        L_0x0068:
            com.baidu.swan.card.api.component.touch.SwanAppTouchListener$LongPressRunnable r4 = r11.mLongPressRunnable
            r12.removeCallbacks(r4)
        L_0x006d:
            com.baidu.swan.card.render.engine.event.msg.SwanAppWebMessage r4 = r11.createWebMessage(r13)
            r11.sendEventToWebView(r4)
            if (r0 != r3) goto L_0x00a2
            com.baidu.swan.card.api.component.touch.SwanAppTouchListener$TouchPosition r3 = new com.baidu.swan.card.api.component.touch.SwanAppTouchListener$TouchPosition
            float r4 = r13.getX()
            double r7 = (double) r4
            float r4 = r13.getY()
            double r9 = (double) r4
            r5 = r3
            r6 = r11
            r5.<init>(r7, r9)
            boolean r3 = r11.isValidMoveDistance(r3)
            if (r3 == 0) goto L_0x00a2
            long r3 = r13.getEventTime()
            long r5 = r11.mDownTime
            long r3 = r3 - r5
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a2
            java.lang.String r1 = "tap"
            com.baidu.swan.card.render.engine.event.msg.SwanAppWebMessage r1 = r11.createWebMessage(r13, r1)
            r11.sendEventToWebView(r1)
        L_0x00a2:
            return
        L_0x00a3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "params is null, slaveId = "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r11.mSlaveId
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = " ; viewId = "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r11.mViewId
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "SwanAppTouchListener"
            com.baidu.swan.card.utils.SwanCardLog.e(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.card.api.component.touch.SwanAppTouchListener.handleEvent(android.view.View, android.view.MotionEvent):void");
    }

    /* access modifiers changed from: private */
    public void sendEventToWebView(SwanAppWebMessage webMessage) {
        if (DEBUG) {
            Log.d(TAG, "sendEventToWebView = " + webMessage.mData);
        }
        SwanCardController.getInstance().sendJSMessage(this.mSlaveId, webMessage);
    }

    /* access modifiers changed from: private */
    public SwanAppWebMessage createWebMessage(MotionEvent event, String action) {
        SwanAppTouchHelper touchHelper = new SwanAppTouchHelper(event, action);
        touchHelper.setWebViewPosition(this.mWebViewLocation);
        SwanAppWebMessage webMessage = new SwanAppWebMessage();
        webMessage.mData = SwanAppEventHelper.getEventJson(this.mSlaveId, this.mViewId, this.mViewType, touchHelper.getTouchAction(), touchHelper.genJsonObject());
        return webMessage;
    }

    private SwanAppWebMessage createWebMessage(MotionEvent event) {
        SwanAppTouchHelper touchHelper = new SwanAppTouchHelper(event);
        touchHelper.setWebViewPosition(this.mWebViewLocation);
        SwanAppWebMessage webMessage = new SwanAppWebMessage();
        webMessage.mData = SwanAppEventHelper.getEventJson(this.mSlaveId, this.mViewId, this.mViewType, touchHelper.getTouchAction(), touchHelper.genJsonObject());
        return webMessage;
    }

    private boolean isValidMoveDistance(TouchPosition movePotion) {
        TouchPosition touchPosition = this.mDownPosition;
        return touchPosition != null && touchPosition.getDistance(movePotion) <= ((double) SwanUIUtils.dp2px(10.0f));
    }

    private class LongPressRunnable implements Runnable {
        private MotionEvent mEvent;
        private SwanAppWebMessage mWebMessage;

        private LongPressRunnable() {
        }

        /* access modifiers changed from: private */
        public void setEvent(MotionEvent event) {
            this.mEvent = event;
            this.mWebMessage = SwanAppTouchListener.this.createWebMessage(event, "longtap");
        }

        public void run() {
            SwanAppTouchListener.this.sendEventToWebView(this.mWebMessage);
        }
    }

    private class TouchPosition {
        private double x;
        private double y;

        public TouchPosition(double x2, double y2) {
            this.x = x2;
            this.y = y2;
        }

        public double getDistance(TouchPosition position) {
            if (position == null) {
                return Double.MAX_VALUE;
            }
            double power = Math.pow(position.x - this.x, 2.0d) + Math.pow(position.y - this.y, 2.0d);
            if (power <= 0.0d) {
                return 0.0d;
            }
            return Math.sqrt(power);
        }
    }
}
