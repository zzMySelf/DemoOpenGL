package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.common.net.MediaType;
import io.flutter.plugin.common.MethodCall;
import java.util.HashMap;
import java.util.Map;

public class ImagePickerCache {
    public static final String FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY = "flutter_image_picker_image_path";
    public static final String MAP_KEY_ERROR_CODE = "errorCode";
    public static final String MAP_KEY_ERROR_MESSAGE = "errorMessage";
    public static final String MAP_KEY_IMAGE_QUALITY = "imageQuality";
    public static final String MAP_KEY_MAX_HEIGHT = "maxHeight";
    public static final String MAP_KEY_MAX_WIDTH = "maxWidth";
    public static final String MAP_KEY_PATH = "path";
    public static final String MAP_KEY_TYPE = "type";
    @VisibleForTesting
    public static final String SHARED_PREFERENCES_NAME = "flutter_image_picker_shared_preference";
    public static final String SHARED_PREFERENCE_ERROR_CODE_KEY = "flutter_image_picker_error_code";
    public static final String SHARED_PREFERENCE_ERROR_MESSAGE_KEY = "flutter_image_picker_error_message";
    public static final String SHARED_PREFERENCE_IMAGE_QUALITY_KEY = "flutter_image_picker_image_quality";
    public static final String SHARED_PREFERENCE_MAX_HEIGHT_KEY = "flutter_image_picker_max_height";
    public static final String SHARED_PREFERENCE_MAX_WIDTH_KEY = "flutter_image_picker_max_width";
    public static final String SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY = "flutter_image_picker_pending_image_uri";
    public static final String SHARED_PREFERENCE_TYPE_KEY = "flutter_image_picker_type";
    public SharedPreferences prefs;

    public ImagePickerCache(Context context) {
        this.prefs = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    private void setMaxDimension(Double d, Double d2, int i2) {
        SharedPreferences.Editor edit = this.prefs.edit();
        if (d != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, Double.doubleToRawLongBits(d.doubleValue()));
        }
        if (d2 != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, Double.doubleToRawLongBits(d2.doubleValue()));
        }
        if (i2 <= -1 || i2 >= 101) {
            edit.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100);
        } else {
            edit.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, i2);
        }
        edit.apply();
    }

    private void setType(String str) {
        this.prefs.edit().putString(SHARED_PREFERENCE_TYPE_KEY, str).apply();
    }

    public void clear() {
        this.prefs.edit().clear().apply();
    }

    public Map<String, Object> getCacheMap() {
        boolean z;
        HashMap hashMap = new HashMap();
        boolean z2 = true;
        if (this.prefs.contains(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY)) {
            hashMap.put("path", this.prefs.getString(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, ""));
            z = true;
        } else {
            z = false;
        }
        if (this.prefs.contains(SHARED_PREFERENCE_ERROR_CODE_KEY)) {
            hashMap.put("errorCode", this.prefs.getString(SHARED_PREFERENCE_ERROR_CODE_KEY, ""));
            if (this.prefs.contains(SHARED_PREFERENCE_ERROR_MESSAGE_KEY)) {
                hashMap.put(MAP_KEY_ERROR_MESSAGE, this.prefs.getString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, ""));
            }
        } else {
            z2 = z;
        }
        if (z2) {
            if (this.prefs.contains(SHARED_PREFERENCE_TYPE_KEY)) {
                hashMap.put("type", this.prefs.getString(SHARED_PREFERENCE_TYPE_KEY, ""));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_MAX_WIDTH_KEY)) {
                hashMap.put(MAP_KEY_MAX_WIDTH, Double.valueOf(Double.longBitsToDouble(this.prefs.getLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, 0))));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_MAX_HEIGHT_KEY)) {
                hashMap.put(MAP_KEY_MAX_HEIGHT, Double.valueOf(Double.longBitsToDouble(this.prefs.getLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, 0))));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_IMAGE_QUALITY_KEY)) {
                hashMap.put(MAP_KEY_IMAGE_QUALITY, Integer.valueOf(this.prefs.getInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100)));
            } else {
                hashMap.put(MAP_KEY_IMAGE_QUALITY, 100);
            }
        }
        return hashMap;
    }

    public String retrievePendingCameraMediaUriPath() {
        return this.prefs.getString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, "");
    }

    public void saveDimensionWithMethodCall(MethodCall methodCall) {
        int i2;
        Double d = (Double) methodCall.argument(MAP_KEY_MAX_WIDTH);
        Double d2 = (Double) methodCall.argument(MAP_KEY_MAX_HEIGHT);
        if (methodCall.argument(MAP_KEY_IMAGE_QUALITY) == null) {
            i2 = 100;
        } else {
            i2 = ((Integer) methodCall.argument(MAP_KEY_IMAGE_QUALITY)).intValue();
        }
        setMaxDimension(d, d2, i2);
    }

    public void savePendingCameraMediaUriPath(Uri uri) {
        this.prefs.edit().putString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, uri.getPath()).apply();
    }

    public void saveResult(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        SharedPreferences.Editor edit = this.prefs.edit();
        if (str != null) {
            edit.putString(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, str);
        }
        if (str2 != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_CODE_KEY, str2);
        }
        if (str3 != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, str3);
        }
        edit.apply();
    }

    public void saveTypeWithMethodCallName(String str) {
        if (str.equals(ImagePickerPlugin.METHOD_CALL_IMAGE)) {
            setType(MediaType.IMAGE_TYPE);
        } else if (str.equals(ImagePickerPlugin.METHOD_CALL_VIDEO)) {
            setType(MediaType.VIDEO_TYPE);
        }
    }
}
