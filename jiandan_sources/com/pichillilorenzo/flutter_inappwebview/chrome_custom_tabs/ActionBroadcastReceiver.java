package com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;

public class ActionBroadcastReceiver extends BroadcastReceiver {
    public static final String CHROME_MANAGER_ID = "com.pichillilorenzo.flutter_inappwebview.ChromeCustomTabs.CHROME_MANAGER_ID";
    public static final String KEY_ACTION_ID = "com.pichillilorenzo.flutter_inappwebview.ChromeCustomTabs.ACTION_ID";
    public static final String KEY_ACTION_VIEW_ID = "com.pichillilorenzo.flutter_inappwebview.ChromeCustomTabs.ACTION_VIEW_ID";
    public static final String KEY_URL_TITLE = "android.intent.extra.SUBJECT";
    public static final String LOG_TAG = "ActionBroadcastReceiver";

    public void onReceive(Context context, Intent intent) {
        String dataString = intent.getDataString();
        if (dataString != null) {
            Bundle extras = intent.getExtras();
            String string = extras.getString(KEY_ACTION_VIEW_ID);
            int i2 = extras.getInt(KEY_ACTION_ID);
            String string2 = extras.getString(KEY_URL_TITLE);
            BinaryMessenger binaryMessenger = ChromeSafariBrowserManager.shared.get(extras.getString(CHROME_MANAGER_ID)).plugin.messenger;
            MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_chromesafaribrowser_" + string);
            HashMap hashMap = new HashMap();
            hashMap.put("url", dataString);
            hashMap.put("title", string2);
            hashMap.put("id", Integer.valueOf(i2));
            methodChannel.invokeMethod("onChromeSafariBrowserItemActionPerform", hashMap);
        }
    }
}
