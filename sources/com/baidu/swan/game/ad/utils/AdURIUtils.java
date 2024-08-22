package com.baidu.swan.game.ad.utils;

import java.util.HashMap;
import java.util.Map;

public class AdURIUtils {
    public static String getRequestAdUrl(String urlPage, HashMap<String, String> map) {
        StringBuilder params = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        String finalURL = urlPage + "?code2=" + new AdBase64().encode(params.toString() + "b" + System.currentTimeMillis() + "=1");
        StringBuilder sb = new StringBuilder();
        sb.append("&b" + System.currentTimeMillis()).append("=").append("1");
        return finalURL + sb.toString();
    }
}
