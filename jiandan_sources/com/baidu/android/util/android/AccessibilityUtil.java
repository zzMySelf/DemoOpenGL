package com.baidu.android.util.android;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import fe.fe.ddd.i.qw.qw;

public class AccessibilityUtil {
    public static final String MODE_ACCESSIBILITY_TAG = "talkback";

    public static void addTalkBackChangeListener(AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) qw.qw().getSystemService("accessibility");
        if (accessibilityManager != null) {
            accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }

    public static boolean isEnabled() {
        try {
            for (AccessibilityServiceInfo id : ((AccessibilityManager) qw.qw().getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1)) {
                if (id.getId().toLowerCase().contains(MODE_ACCESSIBILITY_TAG)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isTalkBackOpened() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) qw.qw().getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    public static void removeTalkBackChangeListener(AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) qw.qw().getSystemService("accessibility");
        if (accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }
}
