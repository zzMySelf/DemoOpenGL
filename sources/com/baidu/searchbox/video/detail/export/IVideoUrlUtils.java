package com.baidu.searchbox.video.detail.export;

import com.baidu.searchbox.video.detail.dependency.impl.others.VideoUrlUtilsImpl_Factory;
import java.util.Map;

public interface IVideoUrlUtils {
    public static final IVideoUrlUtils EMPTY = new IVideoUrlUtils() {
        public String appendParams(String url, Map<String, String> map) {
            return null;
        }

        public String appendParam(String url, String key, String value) {
            return null;
        }
    };

    String appendParam(String str, String str2, String str3);

    String appendParams(String str, Map<String, String> map);

    public static class Impl {
        public static IVideoUrlUtils get() {
            return VideoUrlUtilsImpl_Factory.get();
        }
    }
}
