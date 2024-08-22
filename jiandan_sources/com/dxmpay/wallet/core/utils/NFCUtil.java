package com.dxmpay.wallet.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import com.baidu.wallet.router.LocalRouter;

@SuppressLint({"NewApi"})
public final class NFCUtil {
    public IntentFilter[] mFilters;
    public String[][] mTechlist;

    public static class ad {
        public static NFCUtil qw = new NFCUtil();
    }

    public static NFCUtil getInstance() {
        return ad.qw;
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
