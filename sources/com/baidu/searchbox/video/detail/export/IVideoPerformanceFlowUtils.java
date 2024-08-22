package com.baidu.searchbox.video.detail.export;

import android.content.Context;
import com.baidu.searchbox.video.detail.dependency.impl.lightbrowser.VideoPerformanceFlowUtilsImpl_Factory;
import com.baidu.ubc.Flow;

public interface IVideoPerformanceFlowUtils {
    public static final IVideoPerformanceFlowUtils EMPTY = new IVideoPerformanceFlowUtils() {
        public String getPerformanceExtra(Context context, String url, String slog) {
            return null;
        }

        public String getPerformanceContentString(String page, String type, String value, String action, String from, String currentContextId, String extra) {
            return null;
        }

        public String appendPerformanceContentString(String frameSource, String businessType) {
            return null;
        }

        public void setValue(String value) {
        }

        public Flow instanceFlow(String contextId) {
            return null;
        }

        public void resetFlow() {
        }

        public void resetFlow(String contextId) {
        }

        public void endFlow() {
        }

        public void addEvent(String id) {
        }
    };

    void addEvent(String str);

    String appendPerformanceContentString(String str, String str2);

    void endFlow();

    String getPerformanceContentString(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    String getPerformanceExtra(Context context, String str, String str2);

    Flow instanceFlow(String str);

    void resetFlow();

    void resetFlow(String str);

    void setValue(String str);

    public static class Impl {
        public static IVideoPerformanceFlowUtils get() {
            return VideoPerformanceFlowUtilsImpl_Factory.get();
        }
    }
}
