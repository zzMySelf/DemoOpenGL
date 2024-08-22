package com.baidu.share.core.platforms;

import android.content.Context;
import android.content.pm.PackageManager;

public class MobileQQ {
    public static final String DEFAULT_PF = "openmobile_android";
    public static final String KEY_ACTION = "key_action";
    public static final String KEY_ERROR_CODE = "key_error_code";
    public static final String KEY_ERROR_DETAIL = "key_error_detail";
    public static final String KEY_ERROR_MSG = "key_error_msg";
    public static final String KEY_PARAMS = "key_params";
    public static final String KEY_REQUEST_CODE = "key_request_code";
    public static final String KEY_RESPONSE = "key_response";
    public static final int MAIN_VERSION = 4;
    public static final String PACKAGE_NAME = "com.tencent.mobileqq";
    public static final String PARAM_PF = "pf";
    public static final String PKG_NAME = "pkg_name";
    public static final String SIGNATURE_HASH = "be910af39a26a4a992c6fd01a143ed19";
    public static final String SSO_ACTIVITY_NAME = "com.tencent.open.agent.AgentActivity";
    public static final int SUB_VERSION = 1;

    public interface IQQFlagType {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_HIDEQZONE = 2;
        public static final int TYPE_POPUPQZONE = 1;
    }

    public interface IQQReqestType {
        public static final int TYPE_AUDIO = 2;
        public static final int TYPE_DEFAULT = 1;
        public static final int TYPE_IMAGE = 5;
    }

    public interface IQZoneRequestType {
        public static final int TYPE_AUDIO = 2;
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_IMAGE = 5;
    }

    private MobileQQ() {
    }

    public static boolean isQQInstalled(Context context) {
        try {
            String[] v = context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName.split("\\.");
            int mainVersion = Integer.parseInt(v[0]);
            int subVersion = Integer.parseInt(v[1]);
            if (mainVersion > 4 || (mainVersion == 4 && subVersion >= 1)) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }
}
