package com.baidu.searchbox.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CheckListUtils {
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "CheckListUtils";

    private CheckListUtils() {
    }

    public static boolean writeCache(List<String> whiteList, String fileName) {
        FileOutputStream fos = null;
        try {
            fos = AppRuntime.getAppContext().openFileOutput(fileName, 0);
            if (whiteList.size() == 0) {
                fos.write(new byte[0]);
                Closeables.closeSafely((Closeable) fos);
                return true;
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (String scheme : whiteList) {
                bw.write(scheme);
                bw.newLine();
            }
            bw.close();
            Closeables.closeSafely((Closeable) fos);
            return true;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) fos);
            throw th2;
        }
        Closeables.closeSafely((Closeable) fos);
        return false;
    }

    public static List<String> readCache(String fileName) {
        long startTime = System.currentTimeMillis();
        List<String> whiteList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = AppRuntime.getAppContext().openFileInput(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (!TextUtils.isEmpty(line)) {
                    whiteList.add(line);
                }
            }
            br.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) null);
            throw th2;
        }
        Closeables.closeSafely((Closeable) fis);
        long endTime = System.currentTimeMillis();
        if (DEBUG) {
            Log.d(TAG, "Read WhiteScheme Cache: " + (endTime - startTime));
        }
        return whiteList;
    }

    public static boolean checkInList(String orgnScheme, List<String> list) {
        String orgnFragment;
        String orgnParams;
        String orgnPrefix;
        String whiteFragment;
        String whiteParams;
        String whitePrefix;
        String str;
        String str2 = orgnScheme;
        String str3 = GameCenterUtils.SCHEME_SWAN_SUFFIX;
        int orgnParamIndex = str2.indexOf(str3);
        int orgnFragmentIndex = str2.indexOf("#");
        if (orgnParamIndex >= orgnScheme.length()) {
            orgnParamIndex = 0;
        }
        if (orgnFragmentIndex >= orgnScheme.length()) {
            orgnFragmentIndex = 0;
        }
        if (orgnFragmentIndex > 0 && orgnFragmentIndex < orgnParamIndex) {
            orgnParamIndex = 0;
        }
        if (orgnParamIndex > 0) {
            orgnPrefix = str2.substring(0, orgnParamIndex);
            if (orgnFragmentIndex > 0) {
                orgnParams = str2.substring(orgnParamIndex + 1, orgnFragmentIndex);
                orgnFragment = str2.substring(orgnFragmentIndex + 1);
            } else {
                orgnParams = str2.substring(orgnParamIndex + 1);
                orgnFragment = null;
            }
        } else {
            orgnParams = null;
            if (orgnFragmentIndex > 0) {
                orgnPrefix = str2.substring(0, orgnFragmentIndex);
                orgnFragment = str2.substring(orgnFragmentIndex + 1);
            } else {
                orgnPrefix = orgnScheme;
                orgnFragment = null;
            }
        }
        for (String whiteScheme : list) {
            if (!TextUtils.isEmpty(whiteScheme)) {
                int whiteParamIndex = whiteScheme.indexOf(str3);
                int whiteFragmentIndex = whiteScheme.indexOf("#");
                if (whiteParamIndex >= whiteScheme.length()) {
                    whiteParamIndex = 0;
                }
                if (whiteFragmentIndex >= whiteScheme.length()) {
                    whiteFragmentIndex = 0;
                }
                if (whiteFragmentIndex > 0 && whiteFragmentIndex < whiteParamIndex) {
                    whiteParamIndex = 0;
                }
                if (whiteParamIndex > 0) {
                    whitePrefix = whiteScheme.substring(0, whiteParamIndex);
                    if (whiteFragmentIndex > 0) {
                        String whiteParams2 = whiteScheme.substring(whiteParamIndex + 1, whiteFragmentIndex);
                        whiteFragment = whiteScheme.substring(whiteFragmentIndex + 1);
                        whiteParams = whiteParams2;
                    } else {
                        whiteFragment = null;
                        whiteParams = whiteScheme.substring(whiteParamIndex + 1);
                    }
                } else if (whiteFragmentIndex > 0) {
                    whitePrefix = whiteScheme.substring(0, whiteFragmentIndex);
                    whiteFragment = whiteScheme.substring(whiteFragmentIndex + 1);
                    whiteParams = null;
                } else {
                    whitePrefix = whiteScheme;
                    whiteFragment = null;
                    whiteParams = null;
                }
                if (orgnPrefix.startsWith(whitePrefix)) {
                    if (TextUtils.isEmpty(whiteParams) && TextUtils.isEmpty(whiteFragment)) {
                        return true;
                    }
                    if (TextUtils.isEmpty(whiteParams)) {
                        str = str3;
                    } else if (!TextUtils.isEmpty(orgnParams)) {
                        str = str3;
                        if (!compare(orgnParams.split("&"), whiteParams.split("&"))) {
                            String str4 = orgnScheme;
                            str3 = str;
                        }
                    }
                    if (TextUtils.equals(orgnFragment, whiteFragment)) {
                        return true;
                    }
                    String str5 = orgnScheme;
                    str3 = str;
                }
                String str6 = orgnScheme;
            }
        }
        return false;
    }

    public static boolean compare(String[] array1, String[] array2) {
        Set<String> aTarget = new HashSet<>();
        Set<String> bTarget = new HashSet<>();
        aTarget.addAll(Arrays.asList(array1));
        bTarget.addAll(Arrays.asList(array2));
        if (aTarget.size() != bTarget.size()) {
            return false;
        }
        int temSize = aTarget.size();
        aTarget.addAll(Arrays.asList(array2));
        if (temSize == aTarget.size()) {
            return true;
        }
        return false;
    }

    public static boolean checkInHostList(String url, List<String> list) {
        if (TextUtils.isEmpty(url) || list == null || list.size() == 0) {
            return false;
        }
        String host = Uri.parse(url).getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        for (String whiteScheme : list) {
            if (!TextUtils.isEmpty(whiteScheme) && (whiteScheme.equals(host) || host.endsWith(whiteScheme))) {
                return true;
            }
        }
        return false;
    }

    public static String decrypt(String encodeEncryptText, String key, String ivParameter) {
        try {
            byte[] encryptText = Base64.decode(encodeEncryptText, 2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(key.getBytes(), "AES"), new IvParameterSpec(ivParameter.getBytes()));
            return new String(cipher.doFinal(encryptText));
        } catch (Exception e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static String fixUrl(String inUrl) {
        if (inUrl == null) {
            return "";
        }
        int colon = inUrl.indexOf(58);
        boolean allLower = true;
        for (int index = 0; index < colon; index++) {
            char ch = inUrl.charAt(index);
            if (!Character.isLetter(ch)) {
                break;
            }
            allLower &= Character.isLowerCase(ch);
            if (index == colon - 1 && !allLower) {
                inUrl = inUrl.substring(0, colon).toLowerCase(Locale.getDefault()) + inUrl.substring(colon);
            }
        }
        if (inUrl.startsWith("http://") || inUrl.startsWith("https://") || inUrl.startsWith("rtsp://")) {
            return inUrl;
        }
        if (!inUrl.startsWith("http:") && !inUrl.startsWith("https:") && !inUrl.startsWith("rtsp:")) {
            return inUrl;
        }
        if (inUrl.startsWith("http:/") || inUrl.startsWith("https:/") || inUrl.startsWith("rtsp:/")) {
            return inUrl.replaceFirst("/", "//");
        }
        return inUrl.replaceFirst(":", "://");
    }

    public static String addSchemeIfNeed(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        if (url.startsWith("http://") || url.startsWith("https://") || url.startsWith("rtsp://")) {
            return url;
        }
        return "http://" + url;
    }
}
