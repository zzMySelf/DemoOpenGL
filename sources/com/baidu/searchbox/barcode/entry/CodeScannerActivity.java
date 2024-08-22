package com.baidu.searchbox.barcode.entry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.idl.barcode.BarcodeResult;
import com.baidu.searchbox.QRCodeScannerActivity;
import com.baidu.searchbox.barcode.R;
import com.baidu.searchbox.barcode.ioc.BarcodeRuntime;
import com.baidu.searchbox.barcode.util.UIUtil;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.database.OEMConfiguartion;

public class CodeScannerActivity extends QRCodeScannerActivity {
    private static final String KEY_NEED_DELETE_PHOTO_SEARCH = "KEY_NEED_DELETE_PHOTO_SEARCH";
    private int mResultCode;
    private Intent mResultData;

    public static final class CodeScannerCaller {
        public static final String CARD = "6";
        public static final String CLK_DECODE_BARCODE = "14";
        public static final String FEED_PICTURE_CLK_SEARCH = "16";
        public static final String FEED_PICTURE_LONG_CLICK = "15";
        public static final String FE_CARD = "7";
        public static final String FROM_ADD_FRIEND = "12";
        public static final String HOME_MENU = "11";
        public static final String KEY_FROM = "from";
        public static final String KEY_FROM_POSITION = "fromPosition";
        public static final String KEY_IMG_RESULT = "imageResult";
        public static final String KEY_REFERER = "referer";
        public static final String KEY_RESULT = "result";
        public static final String NOTIFICATION = "4";
        public static final String OTHER = "3";
        public static final String PICTURE_BROWSER_CLK_SEARCH = "18";
        public static final String PICTURE_BROWSER_LONG_CLICK = "17";
        public static final String PICTURE_PERSONAL_CENTER_SCAN = "21";
        public static final String PLUGIN_CENTER = "8";
        public static final String QR_LOGIN = "10";
        public static final String SEARCH_BOX = "0";
        public static final String SEARCH_BOX_WEB_CAMERA = "5";
        public static final String SHORT_CUT = "2";
        public static final String SWAN_PICTURE_CLK_SEARCH = "34";
        public static final String SWAN_PICTURE_LONG_CLICK = "33";
        public static final String WALLET = "9";
        public static final String WEB_PICTURE = "13";
        public static final String WISE = "1";

        private CodeScannerCaller() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            if (isFromWallet()) {
                startSearchBoxBarcode(intent);
            } else if (!intent.hasExtra("from") || !TextUtils.equals("godeye", intent.getStringExtra("from"))) {
                intent.putExtra("category", "BARCODE");
                handleIntent(intent);
            } else {
                initBarcodeView(getIntent(), savedInstanceState);
            }
        }
    }

    public static void showCodeScannerActivity(Context context, BarcodeResult barcodeResult) {
        Intent intent = new Intent(context, CodeScannerActivity.class);
        Bundle params = new Bundle();
        params.putByteArray("code", barcodeResult.code);
        params.putString("encoding", barcodeResult.encoding);
        params.putInt("codeType", barcodeResult.codeType);
        intent.putExtra("barcode_result", params);
        intent.putExtra("from", "godeye");
        ActivityUtils.startActivitySafely(context, intent);
    }

    public static void startCodeScannerActivity(Context context, String from) {
        if (context != null) {
            Intent intent = new Intent(context, CodeScannerActivity.class);
            intent.putExtra("from", from);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            ActivityUtils.startActivitySafely(context, intent);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Intent intent = getIntent();
        if (intent != null && TextUtils.equals(intent.getStringExtra("from"), "4")) {
            overridePendingTransition(0, 0);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void setActivityResult(int resultCode, Intent data) {
        this.mResultCode = resultCode;
        this.mResultData = data;
        setResult(resultCode, data);
    }

    private void startSearchBoxBarcode(Intent intent) {
        if (intent != null) {
            if (intent.getBooleanExtra("isFastSearch", false)) {
                UIUtil.collapseStatusBar(this);
            }
            TextUtils.isEmpty(intent.getStringExtra("from"));
        }
        try {
            SharedPreferences pref = getSharedPreferences(BarcodeRuntime.getBarcodeContext().getSpAppShortcut(), 0);
            if (pref.getBoolean(KEY_NEED_DELETE_PHOTO_SEARCH, true)) {
                String shortcutName = getString(R.string.code_scanner_icon_name);
                BarcodeRuntime.getBarcodeContext().deleteShortcutByName(this, getPackageName(), com.baidu.searchbox.CodeScannerActivity.class.getCanonicalName(), shortcutName);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean(KEY_NEED_DELETE_PHOTO_SEARCH, false);
                editor.apply();
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
        if (OEMConfiguartion.getInstance(this).isCreateScannerShortcut()) {
            BarcodeRuntime.getBarcodeContext().parseDeskIconProtocol(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFromWallet() {
        Intent intent = getIntent();
        if (intent != null) {
            return TextUtils.equals(intent.getStringExtra("from"), "9");
        }
        return false;
    }
}
