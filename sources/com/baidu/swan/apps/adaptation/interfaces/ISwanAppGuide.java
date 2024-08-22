package com.baidu.swan.apps.adaptation.interfaces;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.guide.SwanAppGuideDialogChecker;
import com.baidu.swan.apps.guide.SwanAppGuideDialogManager;
import com.baidu.swan.apps.runtime.SwanApp;

public interface ISwanAppGuide {
    void addToBookshelfSuccessGuide(Context context);

    boolean checkShowFavGuide(Activity activity);

    void downloadGuideRes(String str);

    void failAuthFollow(SwanApp swanApp);

    void failAuthUnFollow(SwanApp swanApp);

    String getFavorSuccessTip(Context context);

    void launchBookShelf(CallbackHandler callbackHandler);

    void showGuideDialog(Activity activity, String str, String str2, SwanAppGuideDialogChecker swanAppGuideDialogChecker, SwanAppGuideDialogManager.OnGuideDialogCloseListener onGuideDialogCloseListener);

    boolean showToppingGuideIfNeeded(Activity activity);
}
