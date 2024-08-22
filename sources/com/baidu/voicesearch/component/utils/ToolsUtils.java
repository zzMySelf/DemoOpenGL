package com.baidu.voicesearch.component.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.voicesearch.component.request.RequestUtil;
import com.baidu.voicesearch.component.vglog.VgLogManager;
import com.baidu.voicesearch.component.voice.VoiceApplicationManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ToolsUtils {
    private static final Pattern DOWNLOAD_URL = Pattern.compile("(http|https)://.+");
    private static final int KEY_REFERER_MAX_LENGTH = 1024;
    private static final int KEY_USER_AGENT_MAX_LENGTH = 512;
    public static final float LOW_LEVEL_STC = 0.37f;
    public static final int MIC_PERMISSION_DENIED = 0;
    public static final int MIC_PERMISSION_GRANTED = 1;
    public static final int MIC_PERMISSION_UNKNOWN = -1;
    public static final String PURPOSE_CHECK_MIC = "s_a_check_mic";
    public static final String PURPOSE_WAKE_ERROR = "s_a_wake_error";
    public static final String SCENE_ID = "svoice";
    public static final String TAG = "ToolsUtils";

    public static String getSystemModel() {
        DeviceIdBag model = DeviceInfoManager.INSTANCE.getModel(SCENE_ID, PURPOSE_CHECK_MIC);
        if (TextUtils.isEmpty(model.deviceId)) {
            return "";
        }
        return model.deviceId;
    }

    public static String getManufacturer() {
        DeviceIdBag model = DeviceInfoManager.INSTANCE.getManufacturer(SCENE_ID, PURPOSE_CHECK_MIC);
        if (TextUtils.isEmpty(model.deviceId)) {
            return "";
        }
        return model.deviceId;
    }

    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.isEmpty() || list.size() <= 0;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() < 1;
    }

    public static String adornUserAgent() {
        String userAagent = !TextUtils.isEmpty(RequestUtil.userAagent) ? RequestUtil.userAagent : "";
        if (userAagent.length() > 512) {
            userAagent = subString(userAagent, 1024, " ");
        }
        RequestUtil.userAagent = userAagent;
        return filterHeaderCharacter(RequestUtil.userAagent);
    }

    public static String adornReferer() {
        if (TextUtils.isEmpty(RequestUtil.referer)) {
            return "";
        }
        String referer = RequestUtil.referer;
        if (referer.length() > 1024) {
            referer = subString(referer, 1024, "&");
        }
        RequestUtil.referer = referer;
        return filterHeaderCharacter(RequestUtil.referer);
    }

    public static String filterHeaderCharacter(String content) {
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int length = content.length();
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = content.charAt(i2);
            if (c2 <= 31 || c2 >= 127) {
                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(c2)}));
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    public static String subString(String text, int maxLength, String regular) {
        if (TextUtils.isEmpty(text)) {
            return "";
        }
        int lastIndex = text.lastIndexOf(regular);
        String newText = text;
        if (lastIndex > 0 && lastIndex < text.length()) {
            newText = text.substring(0, lastIndex);
            if (newText.length() > maxLength) {
                return subString(newText, maxLength, regular);
            }
        }
        return newText;
    }

    public static void addJsonKey(JSONObject jsonObject, String key, Object value) {
        if (jsonObject != null && !jsonObject.has(key)) {
            try {
                jsonObject.put(key, value);
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
        }
    }

    public static String getAssetsFileContent(Context context, String fileName) {
        String content = "";
        if (context == null || TextUtils.isEmpty(fileName)) {
            return "";
        }
        InputStreamReader inputStreamReader = null;
        try {
            InputStream in = context.getAssets().open(fileName);
            if (in != null) {
                inputStreamReader = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = reader.readLine();
                    String line = readLine;
                    if (readLine == null) {
                        break;
                    }
                    content = content + line + "\n";
                }
                inputStreamReader.close();
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e3) {
            Log.e(TAG, "文件读取出错。filename=" + fileName);
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (Throwable th2) {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th2;
        }
        return content;
    }

    public static String getContentFromFile(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return "";
        }
        File styleFile = new File(filePath);
        if (!styleFile.exists()) {
            return "";
        }
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(styleFile);
            char[] buffer = new char[1024];
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int read = fileReader2.read(buffer);
                int hasRead = read;
                if (read <= 0) {
                    break;
                }
                stringBuffer.append(new String(buffer, 0, hasRead));
            }
            String stringBuffer2 = stringBuffer.toString();
            try {
                fileReader2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return stringBuffer2;
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e4) {
                    e = e4;
                }
            }
            return "";
        } catch (IOException e5) {
            e5.printStackTrace();
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e6) {
                    e = e6;
                }
            }
            return "";
        } catch (Exception e7) {
            e7.printStackTrace();
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e8) {
                    e = e8;
                }
            }
            return "";
        } catch (Throwable th2) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            throw th2;
        }
        e.printStackTrace();
        return "";
    }

    public static String getCustomProp(String key) {
        try {
            Class<?> c2 = Class.forName("android.os.SystemProperties");
            return (String) c2.getMethod("get", new Class[]{String.class}).invoke(c2, new Object[]{key});
        } catch (Exception e2) {
            return null;
        }
    }

    private static class MapKeyComparator implements Comparator<String> {
        private MapKeyComparator() {
        }

        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    public static String formatUrlParam(Map<String, String> param, String encode) {
        try {
            List<Map.Entry<String, String>> itmes = new ArrayList<>(param.entrySet());
            Collections.sort(itmes, new Comparator<Map.Entry<String, String>>() {
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return o1.getKey().toString().compareTo(o2.getKey());
                }
            });
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, String> item : itmes) {
                if (!TextUtils.isEmpty(item.getKey())) {
                    sb.append(item.getKey() + "=" + URLEncoder.encode(item.getValue(), encode));
                    sb.append("&");
                }
            }
            String params = sb.toString();
            if (!params.isEmpty()) {
                return params.substring(0, params.length() - 1);
            }
            return params;
        } catch (Exception e2) {
            return "";
        }
    }

    public static boolean isLowLevelStc(float lowLevelStc) {
        VgLogManager.initPhoneScore(VoiceApplicationManager.getApplicationContext());
        return VoiceParamManager.getInstance().getPhoneScore() <= lowLevelStc;
    }

    public static boolean isUrl(String query) {
        if (TextUtils.isEmpty(query)) {
            return false;
        }
        return DOWNLOAD_URL.matcher(query.toLowerCase(Locale.ROOT)).matches();
    }

    public static boolean canGetPermission() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static int hasAudioPermission(Context context) {
        if (context == null || !canGetPermission()) {
            return -1;
        }
        if (context.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            return 1;
        }
        return 0;
    }
}
