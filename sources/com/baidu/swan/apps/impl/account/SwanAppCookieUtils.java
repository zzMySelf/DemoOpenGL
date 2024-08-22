package com.baidu.swan.apps.impl.account;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.app.account.IWebKitAbility;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.openwidget.engine.web.cookie.OpenWidgetCookieUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.account.SwanAppAccount;
import com.baidu.swan.apps.process.ipc.SwanProcessCallManager;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.util.SwanAppUrlUtils;
import java.util.List;

public class SwanAppCookieUtils {
    private static final String BDUSS = "BDUSS";
    private static final String BDUSS_BFESS = "BDUSS_BFESS";
    public static String BDUSS_DOMAINS = OpenWidgetCookieUtils.BDUSS_DOMAINS;
    public static String COOKIE_MAP = OpenWidgetCookieUtils.COOKIE_MAP;
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String DELETED = "deleted";
    private static String FUNC_NAME_CLEARSESSION_SETSESSION = "Clear_Set_Session";
    private static String FUNC_NAME_SETSESSION = "Set_Session";
    private static final String HTTPS_URL_PREFIX = "https://www.";
    private static final String HTTP_URL_PREFIX = "http://www.";
    public static final String KEY_FUNC_NAME = "funcName";
    private static final String PTOKEN = "PTOKEN";
    public static String PTOKEN_DOMAINS = OpenWidgetCookieUtils.PTOKEN_DOMAINS;
    public static final String SESSION_BDUSS = "BoxAccount_bduss";
    public static final String SESSION_PTOKEN = "BoxAccount_ptoken";
    private static final String TAG = "SwanAppCookieUtils";

    public static void syncCookieAnyProcess(Context context) {
        String funcName = getFuncName();
        if (ProcessUtils.isMainProcess()) {
            syncCookie(context, funcName, (Bundle) null);
        } else {
            syncCookieWithDelegation(context, funcName);
        }
    }

    private static void syncCookieWithDelegation(Context context, String funcName) {
        Bundle result = SwanProcessCallManager.callMainProcessSync(GetCookieDomainsDelegation.class, (Bundle) null);
        if (result != null) {
            syncCookie(context, funcName, result);
        }
    }

    /* JADX WARNING: type inference failed for: r5v11, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void syncCookie(android.content.Context r8, java.lang.String r9, android.os.Bundle r10) {
        /*
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            r1 = 0
            r2 = 0
            java.lang.String r3 = "BoxAccount_ptoken"
            java.lang.String r4 = "BoxAccount_bduss"
            if (r10 != 0) goto L_0x001e
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = ""
            r5.put(r4, r6)
            r5.put(r3, r6)
            java.util.Map r0 = com.baidu.swan.apps.impl.account.AccountUtils.getSessions((android.content.Context) r8, (java.util.Map<java.lang.String, java.lang.String>) r5)
            goto L_0x004b
        L_0x001e:
            java.lang.String r5 = COOKIE_MAP
            java.io.Serializable r5 = r10.getSerializable(r5)
            if (r5 == 0) goto L_0x002f
            java.lang.String r5 = COOKIE_MAP
            java.io.Serializable r5 = r10.getSerializable(r5)
            r0 = r5
            java.util.Map r0 = (java.util.Map) r0
        L_0x002f:
            java.lang.String r5 = BDUSS_DOMAINS
            boolean r5 = r10.containsKey(r5)
            if (r5 == 0) goto L_0x003d
            java.lang.String r5 = BDUSS_DOMAINS
            java.util.ArrayList r1 = r10.getStringArrayList(r5)
        L_0x003d:
            java.lang.String r5 = PTOKEN_DOMAINS
            boolean r5 = r10.containsKey(r5)
            if (r5 == 0) goto L_0x004b
            java.lang.String r5 = PTOKEN_DOMAINS
            java.util.ArrayList r2 = r10.getStringArrayList(r5)
        L_0x004b:
            if (r0 != 0) goto L_0x0059
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0058
            java.lang.String r3 = "SwanAppCookieUtils"
            java.lang.String r4 = "cookie is invalid"
            android.util.Log.w(r3, r4)
        L_0x0058:
            return
        L_0x0059:
            java.util.Set r5 = r0.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0061:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x008d
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = android.text.TextUtils.equals(r6, r4)
            if (r7 == 0) goto L_0x007d
            java.lang.Object r7 = r0.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            syncBdussCookie(r8, r7, r9, r1)
            goto L_0x008c
        L_0x007d:
            boolean r7 = android.text.TextUtils.equals(r6, r3)
            if (r7 == 0) goto L_0x008c
            java.lang.Object r7 = r0.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            syncPtokenCookie(r8, r7, r9, r2)
        L_0x008c:
            goto L_0x0061
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.account.SwanAppCookieUtils.syncCookie(android.content.Context, java.lang.String, android.os.Bundle):void");
    }

    private static void syncBdussCookie(Context context, String bduss, String funcName, List<String> bdussDomains) {
        String newBdussBfessCookie;
        String newCookie;
        if (bdussDomains == null) {
            bdussDomains = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getAuthorizedDomains(context.getApplicationContext());
        }
        if (bdussDomains != null) {
            for (String domain : bdussDomains) {
                if (TextUtils.isEmpty(bduss)) {
                    newCookie = SwanAppUrlUtils.getCookieStr(domain, "BDUSS", "deleted", 0);
                    newBdussBfessCookie = SwanAppUrlUtils.getCookieStr(domain, BDUSS_BFESS, "deleted", 0);
                } else {
                    newCookie = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).buildBDUSSCookie(domain, bduss);
                    newBdussBfessCookie = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).buildBDUSSBFESSCookie(domain, bduss);
                }
                IWebKitAbility.Impl.get().setCookieManualWithBdussOperate(HTTP_URL_PREFIX + domain, newCookie, false, funcName);
                IWebKitAbility.Impl.get().setCookieManualWithBdussOperate(HTTP_URL_PREFIX + domain, newBdussBfessCookie, false, funcName);
                IWebKitAbility.Impl.get().setCookieManualWithBdussOperate("https://www." + domain, newCookie, false, funcName);
                IWebKitAbility.Impl.get().setCookieManualWithBdussOperate("https://www." + domain, newBdussBfessCookie, false, funcName);
            }
        } else if (DEBUG) {
            Log.w(TAG, "bduss domains is invalid");
        }
    }

    private static void syncPtokenCookie(Context context, String ptoken, String funcName, List<String> ptokenDomains) {
        String newCookie;
        if (ptokenDomains == null) {
            ptokenDomains = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getAuthorizedDomainsForPtoken(context);
        }
        if (ptokenDomains != null) {
            for (String domain : ptokenDomains) {
                if (TextUtils.isEmpty(ptoken)) {
                    newCookie = SwanAppUrlUtils.getCookieStr(domain, PTOKEN, "deleted", 0);
                } else {
                    newCookie = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).buildPtokenCookie(domain, ptoken);
                }
                IWebKitAbility.Impl.get().setCookieManualWithBdussOperate(HTTP_URL_PREFIX + domain, newCookie, false, funcName);
                IWebKitAbility.Impl.get().setCookieManualWithBdussOperate("https://www." + domain, newCookie, false, funcName);
            }
        } else if (DEBUG) {
            Log.w(TAG, "ptoken domains is invalid");
        }
    }

    private static String getFuncName() {
        SwanAppAccount account = null;
        SwanApp swanApp = SwanApp.getOrNull();
        if (swanApp != null) {
            account = swanApp.getAccount();
        }
        if (account == null) {
            return FUNC_NAME_CLEARSESSION_SETSESSION;
        }
        return FUNC_NAME_SETSESSION;
    }
}
