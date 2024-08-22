package com.baidu.spswitch.handler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.spswitch.IPanelConflictLayout;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.spswitch.utils.SoftInputUtil;
import com.baidu.spswitch.utils.ViewUtil;

public class SPSwitchRootLayoutHandler {
    private static final boolean DEBUG = SPConfig.isDebug();
    private static final String TAG = SPSwitchRootLayoutHandler.class.getSimpleName();
    private Context mContext;
    private int mOldHeight = -1;
    private IPanelConflictLayout mPanelLayout;
    private final View mRootLayout;

    public SPSwitchRootLayoutHandler(View rootLayout) {
        this.mRootLayout = rootLayout;
        this.mContext = rootLayout.getContext();
    }

    public void handleBeforeMeasure(int width, int height) {
        Context context = this.mContext;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (ViewUtil.isTranslucentStatus(activity) && this.mRootLayout.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.mRootLayout.getWindowVisibleDisplayFrame(rect);
                height = rect.bottom - rect.top;
                if (DEBUG) {
                    Log.d(TAG, "TranslucentStatus && FitsSystemWindows = true, height: " + height);
                }
            }
            if (ViewUtil.isSystemUILayoutFullScreen(activity) && this.mRootLayout.getFitsSystemWindows()) {
                Rect rect2 = new Rect();
                this.mRootLayout.getWindowVisibleDisplayFrame(rect2);
                height = rect2.bottom - rect2.top;
                if (DEBUG) {
                    Log.d(TAG, "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + height);
                }
            }
        }
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "onMeasure, width: " + width + " height: " + height);
        }
        if (height >= 0) {
            int i2 = this.mOldHeight;
            if (i2 < 0) {
                if (z) {
                    Log.d(TAG, "onMeasure, oldHeight < 0, oldHeight: " + this.mOldHeight);
                }
                this.mOldHeight = height;
                return;
            }
            int offset = i2 - height;
            if (offset != 0) {
                this.mOldHeight = height;
                IPanelConflictLayout panel = getPanelLayout(this.mRootLayout);
                if (panel != null) {
                    int visible = ((LinearLayout) panel).getVisibility();
                    if (z) {
                        Log.d(TAG, "panel visibility: " + visible);
                    }
                    if (Math.abs(offset) < SoftInputUtil.getMinSoftInputHeight(this.mRootLayout.getContext())) {
                        if (z) {
                            Log.d(TAG, "layout change min, not caused by softinput/panel switch!");
                        }
                    } else if (Math.abs(offset) > SoftInputUtil.getMaxSoftInputHeight(this.mRootLayout.getContext())) {
                        if (z) {
                            Log.d(TAG, "layout change max , but not caused by softinput/panel switch!");
                        }
                    } else if (offset > 0) {
                        if (z) {
                            Log.d(TAG, "offset > 0, offset : " + offset + ", panel->handleHide...");
                        }
                        panel.handleHide();
                    } else {
                        if (z) {
                            Log.d(TAG, "offset < 0, offset : " + offset + ", panel->handleShow...");
                        }
                        panel.handleShow();
                    }
                } else if (z) {
                    Log.d(TAG, "cannot find the valid panel layout, give up!");
                }
            } else if (z) {
                Log.d(TAG, "offset == 0, break;");
            }
        }
    }

    private IPanelConflictLayout getPanelLayout(View view2) {
        IPanelConflictLayout iPanelConflictLayout = this.mPanelLayout;
        if (iPanelConflictLayout != null) {
            return iPanelConflictLayout;
        }
        if (view2 instanceof IPanelConflictLayout) {
            IPanelConflictLayout iPanelConflictLayout2 = (IPanelConflictLayout) view2;
            this.mPanelLayout = iPanelConflictLayout2;
            return iPanelConflictLayout2;
        } else if (!(view2 instanceof ViewGroup)) {
            return null;
        } else {
            ViewGroup parent = (ViewGroup) view2;
            for (int i2 = 0; i2 < parent.getChildCount(); i2++) {
                IPanelConflictLayout v = getPanelLayout(parent.getChildAt(i2));
                if (v != null) {
                    this.mPanelLayout = v;
                    return v;
                }
            }
            return null;
        }
    }
}
