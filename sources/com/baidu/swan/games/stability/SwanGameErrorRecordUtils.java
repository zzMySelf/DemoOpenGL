package com.baidu.swan.games.stability;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.games.stability.errormsg.RequestErrorMsg;
import com.baidu.swan.games.stability.errormsg.StorageErrorMsg;
import com.baidu.swan.games.stability.errormsg.SubPackageErrorMsg;
import com.baidu.swan.games.stability.errormsg.SwanGameErrorMsg;

public class SwanGameErrorRecordUtils {
    public static void recordJsError(String errMsg) {
        SwanGameErrorMsg errorMsg = new SwanGameErrorMsg();
        errorMsg.errMsg = errMsg;
        SwanGameErrorCollection.getInstance().add(new SwanGameError(10000, errorMsg));
    }

    public static void recordFileError(String errMsg) {
        SwanGameErrorMsg errorMsg = new SwanGameErrorMsg();
        errorMsg.errMsg = errMsg;
        SwanGameErrorCollection.getInstance().add(new SwanGameError(20000, errorMsg));
    }

    public static void recordStorageError(String key, String errMsg) {
        StorageErrorMsg storageErrorMsg = new StorageErrorMsg();
        storageErrorMsg.key = key;
        storageErrorMsg.errMsg = errMsg;
        SwanGameErrorCollection.getInstance().add(new SwanGameError(30000, storageErrorMsg));
    }

    public static void recordLoginError(CallbackHandler handler, String errMsg) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(handler)) {
            SwanGameErrorMsg errorMsg = new SwanGameErrorMsg();
            errorMsg.errMsg = errMsg;
            SwanGameErrorCollection.getInstance().add(new SwanGameError(40000, errorMsg));
        }
    }

    public static void recordAuthorizeError(CallbackHandler handler, String errMsg) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(handler)) {
            SwanGameErrorMsg errorMsg = new SwanGameErrorMsg();
            errorMsg.errMsg = errMsg;
            SwanGameErrorCollection.getInstance().add(new SwanGameError(50000, errorMsg));
        }
    }

    public static void recordGetUserInfoError(CallbackHandler handler, String errMsg) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(handler)) {
            SwanGameErrorMsg errorMsg = new SwanGameErrorMsg();
            errorMsg.errMsg = errMsg;
            SwanGameErrorCollection.getInstance().add(new SwanGameError(60000, errorMsg));
        }
    }

    public static void recordRequestError(String url, int code, String message, boolean hasNet) {
        RequestErrorMsg errorMsg = new RequestErrorMsg();
        errorMsg.url = url;
        errorMsg.errCode = code;
        errorMsg.f3733net = hasNet;
        errorMsg.errMsg = message;
        SwanGameErrorCollection.getInstance().add(new SwanGameError(70000, errorMsg));
    }

    public static void recordDownloadFileError(String url, int code, String message, boolean hasNet) {
        RequestErrorMsg errorMsg = new RequestErrorMsg();
        errorMsg.url = url;
        errorMsg.errCode = code;
        errorMsg.f3733net = hasNet;
        errorMsg.errMsg = message;
        SwanGameErrorCollection.getInstance().add(new SwanGameError(100000, errorMsg));
    }

    public static void recordUploadError(String url, int code, String message, boolean hasNet) {
        RequestErrorMsg errorMsg = new RequestErrorMsg();
        errorMsg.url = url;
        errorMsg.errCode = code;
        errorMsg.f3733net = hasNet;
        errorMsg.errMsg = message;
        SwanGameErrorCollection.getInstance().add(new SwanGameError(110000, errorMsg));
    }

    public static void recordSubpackageError(String packageName, int errCode, String message) {
        SubPackageErrorMsg errorMsg = new SubPackageErrorMsg();
        errorMsg.packageName = packageName;
        errorMsg.errCode = errCode;
        errorMsg.errMsg = message;
        SwanGameErrorCollection.getInstance().add(new SwanGameError(80000, errorMsg));
    }

    public static void recordCheckSessionError(CallbackHandler handler, String errMsg) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(handler)) {
            SwanGameErrorMsg errorMsg = new SwanGameErrorMsg();
            errorMsg.errMsg = errMsg;
            SwanGameErrorCollection.getInstance().add(new SwanGameError(90000, errorMsg));
        }
    }

    public static void recordUserInfoButtonShowEarlyError(String errMsg) {
        SwanGameErrorMsg errorMsg = new SwanGameErrorMsg();
        errorMsg.errMsg = errMsg;
        SwanGameErrorCollection.getInstance().add(new SwanGameError(120000, errorMsg));
    }
}
