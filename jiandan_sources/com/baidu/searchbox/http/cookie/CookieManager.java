package com.baidu.searchbox.http.cookie;

import android.webkit.CookieSyncManager;
import java.util.List;

public interface CookieManager {
    public static final CookieManager qw = new qw();

    public class qw implements CookieManager {
        public boolean ad(String str, String str2) {
            return true;
        }

        public boolean de(String str, String str2) {
            return true;
        }

        public void fe(String str, List<String> list) {
            if (list != null && list.size() > 0) {
                try {
                    android.webkit.CookieManager instance = android.webkit.CookieManager.getInstance();
                    for (String cookie : list) {
                        instance.setCookie(str, cookie);
                    }
                    CookieSyncManager.getInstance().sync();
                } catch (Exception unused) {
                }
            }
        }

        public String qw(String str) {
            try {
                return android.webkit.CookieManager.getInstance().getCookie(str);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    boolean ad(String str, String str2);

    boolean de(String str, String str2);

    void fe(String str, List<String> list);

    String qw(String str);
}
