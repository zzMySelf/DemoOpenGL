package com.baidu.searchbox.video.detail.export;

import android.net.Uri;
import com.baidu.searchbox.video.detail.dependency.impl.scheme.VideoUnitedSchemeUtilityImpl_Factory;
import java.util.HashMap;

public interface IVideoUnitedSchemeUtility {
    public static final IVideoUnitedSchemeUtility EMPTY = new IVideoUnitedSchemeUtility() {
        public String getAction(Uri uri) {
            return null;
        }

        public boolean isUnitedScheme(String text) {
            return false;
        }

        public boolean isUnitedScheme(Uri uri) {
            return false;
        }

        public HashMap<String, String> getParams(String scheme) {
            return null;
        }
    };

    String getAction(Uri uri);

    HashMap<String, String> getParams(String str);

    boolean isUnitedScheme(Uri uri);

    boolean isUnitedScheme(String str);

    public static class Impl {
        public static IVideoUnitedSchemeUtility get() {
            return VideoUnitedSchemeUtilityImpl_Factory.get();
        }
    }
}
