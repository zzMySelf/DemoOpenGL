package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import android.content.Context;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.business.TitleBarParams;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public interface a {
    void checkClodDown(String str, List<String> list, String str2);

    void closeTopWebview();

    void closeWindow();

    void customNaviBar(TitleBarParams titleBarParams);

    String exeSSCommand(String str, String str2, String str3);

    void executeJsFunction(String str, String str2);

    Activity getActivity();

    String getCellHashStamps();

    Context getContext();

    String getLoadTimeLine();

    void historyGo(int i2);

    void insertPhoneNumToAddressBook(String str, String str2);

    boolean isActiveCell();

    boolean isPreloaded();

    void loadAlubm(String str);

    void messageForwarding(Context context, String str);

    void openInNewWebView(String str, String str2);

    void preLoadException(String str);

    void preLoadUrl(ArrayList<String> arrayList, int i2);

    void rmFromPreloadPool();

    void rpaPerception(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2);

    void selectPhoneFromAddressBook();

    JSONObject setFullScreenInMainThread(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2);

    void setHalfLightBridgeStyle(Context context, Double d, String str, int i2);

    void setIsCheckPermission(boolean z);

    void setMenuInMainThread(JSONArray jSONArray);

    void setScreenVertical(boolean z);

    void setSubMenu(String str, String str2, String str3, int i2, String str4, String str5, int i3, int i4);

    void setTitlesInMainThread(String str, String str2, boolean z);

    void showTitleFloatView(boolean z, String str);

    void startNewLightApp(Context context, String str, String str2, boolean z, boolean z2, Double d, String str3);
}
