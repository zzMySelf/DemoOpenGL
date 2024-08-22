package com.baidu.wallet.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import com.baidu.wallet.router.LocalRouter;

@SuppressLint({"NewApi"})
public final class NFCUtil {
    public static NFCUtil a;
    public NfcAdapter b;
    public PendingIntent c;
    public IntentFilter[] mFilters;
    public String[][] mTechlist;

    public static class a {
        public static NFCUtil a = new NFCUtil();
    }

    private void a(Activity activity) {
    }

    private void b(Activity activity) {
    }

    public static NFCUtil getInstance() {
        return a.a;
    }

    public void disableForegroundDispatch(Activity activity, boolean z) {
    }

    public void enableForegroundDispatch(Activity activity, boolean z) {
    }

    public NfcAdapter getNFCAdapter(Activity activity) {
        return null;
    }

    public boolean isPhoneNFCEnable(Activity activity) {
        return false;
    }

    public boolean isPhoneSurportNFC(Activity activity) {
        return false;
    }

    public boolean isWalletNFCEnable(Activity activity) {
        return false;
    }

    public boolean isWalletNFCSurport(Activity activity) {
        return LocalRouter.getInstance(activity).isProviderExisted("nfc") && isPhoneSurportNFC(activity);
    }

    public void setWalletNFCEnable(Activity activity, boolean z) {
    }

    public NFCUtil() {
    }
}
