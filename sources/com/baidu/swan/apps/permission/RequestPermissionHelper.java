package com.baidu.swan.apps.permission;

import android.app.Activity;
import android.content.Context;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.uuid.utils.PermissionUtils;
import java.util.ArrayList;

public class RequestPermissionHelper {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static String TAG = "RequestPermissionHelper";

    @Deprecated
    public static void handleSystemAuthorized(String permissionName, String[] permissionNames, int reqCode, Context context, RequestPermissionListener listener) {
        if (checkContextIsActivity(context, listener) && !checkHasPermission(context, permissionName, listener)) {
            requestPermissionExt(context, permissionNames, reqCode, listener);
        }
    }

    public static void handleSystemAuthorizedWithDialog(String permissionName, String[] permissionNames, int reqCode, Context context, RequestPermissionListener listener) {
        if (checkContextIsActivity(context, listener) && !checkHasPermission(context, permissionName, listener)) {
            requestPermissionWithDialog(context, permissionNames, reqCode, listener);
        }
    }

    @Deprecated
    public static void requestPermissions(String[] permissionNames, int reqCode, Context context, RequestPermissionListener listener) {
        if (checkContextIsActivity(context, listener)) {
            ArrayList<String> permissionList = getUnauthorizedPermissionList(context, permissionNames);
            if (!checkPermissionListIsEmpty(permissionList, listener)) {
                requestPermissionExt(context, (String[]) permissionList.toArray(new String[0]), reqCode, listener);
            }
        }
    }

    public static void requestPermissionsWithDialog(String[] permissionNames, int reqCode, Context context, RequestPermissionListener listener) {
        if (checkContextIsActivity(context, listener)) {
            ArrayList<String> permissionList = getUnauthorizedPermissionList(context, permissionNames);
            if (!checkPermissionListIsEmpty(permissionList, listener)) {
                requestPermissionWithDialog(context, (String[]) permissionList.toArray(new String[0]), reqCode, listener);
            }
        }
    }

    @Deprecated
    public static void requestPermissionExt(Context context, String[] permissionNames, int reqCode, RequestPermissionListener listener) {
        if (checkContextIsActivity(context, listener)) {
            ArrayList<String> permissionList = getUnauthorizedPermissionList(context, permissionNames);
            if (!checkPermissionListIsEmpty(permissionList, listener)) {
                SwanAppPermission.getInstance().requestPermissions((Activity) context, reqCode, (String[]) permissionList.toArray(new String[0]), new DefaultPermissionCallback(reqCode, listener));
            }
        }
    }

    public static void requestPermissionWithDialog(Context context, String[] permissionNames, int reqCode, RequestPermissionListener listener) {
        if (checkContextIsActivity(context, listener)) {
            ArrayList<String> permissionList = getUnauthorizedPermissionList(context, permissionNames);
            if (!checkPermissionListIsEmpty(permissionList, listener)) {
                SwanAppRuntime.getDangerousPermissionManager().requestPermissions(context, reqCode, (String[]) permissionList.toArray(new String[0]), new DialogPermissionCallback(context, reqCode, listener));
            }
        }
    }

    static boolean checkContextIsActivity(Context context, RequestPermissionListener listener) {
        if (context instanceof Activity) {
            return true;
        }
        listener.onAuthorizedFailed(2, "method should be called after setActivityRef");
        if (!DEBUG) {
            return false;
        }
        throw new IllegalStateException("this method should be called after setActivityRef");
    }

    static boolean checkHasPermission(Context context, String permissionName, RequestPermissionListener listener) {
        if (!PermissionUtils.hasPermission(context, permissionName)) {
            return false;
        }
        listener.onAuthorizedSuccess("permission has already granted");
        return true;
    }

    static ArrayList<String> getUnauthorizedPermissionList(Context context, String[] permissionNames) {
        ArrayList<String> permissionList = new ArrayList<>();
        for (String permission : permissionNames) {
            if (!PermissionUtils.hasPermission(context, permission)) {
                permissionList.add(permission);
            }
        }
        return permissionList;
    }

    static boolean checkPermissionListIsEmpty(ArrayList<String> permissionList, RequestPermissionListener listener) {
        if (permissionList != null && !permissionList.isEmpty()) {
            return false;
        }
        listener.onAuthorizedSuccess("permission has already granted");
        return true;
    }
}
