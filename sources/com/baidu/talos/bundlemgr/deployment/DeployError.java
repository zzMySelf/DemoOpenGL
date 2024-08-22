package com.baidu.talos.bundlemgr.deployment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DeployError {
    public static final int APS_NETWORK_ECODE = 8027;
    public static final String APS_NETWORK_EMSG = "aps network error ";
    public static final int BIZ_NAME_NOT_MATCH_ECODE = 8011;
    public static final String BIZ_NAME_NOT_MATCH_EMSG = "biz name not match ";
    public static final int BUNDLE_INFO_NULL_ECODE = 8001;
    public static final String BUUNDLE_INFO_NUULL_EMSG = "bundle info null ";
    public static final int CHECK_BUNDLE_FILE_MD5_FAILED_ECODE = 8019;
    public static final String CHECK_BUNDLE_FILE_MD5_FAILED_EMSG = " check bundle md5 failed ";
    public static final int CHECK_MD5_FAILED_ECODE = 8007;
    public static final String CHECK_MD5_FAILED_EMSG = "check md5 failed ";
    public static final int CHECK_SIGN_FAILED_ECODE = 8005;
    public static final String CHECK_SIGN_FAILED_EMSG = "check sign failed ";
    public static final int DEPLOY_MANIFEST_NOT_UPDATE_ECODE = 8021;
    public static final String DEPLOY_MANIFEST_NOT_UPDATE_EMSG = " server data not update manifest ";
    public static final int DEPLOY_MANIFEST_SERIAL_ECODE = 8023;
    public static final String DEPLOY_MANIFEST_SERIAL_EMSG = " manifest serial fail ";
    public static final int DEPLOY_OTHER_EXCEPTION_ECODE = 8017;
    public static final String DEPLOY_OTHER_EXCEPTION_EMSG = "deploy other exception: ";
    public static final String DEPLOY_PACKAGE_EXCEPTION_EMSG = "deploy package fail ";
    public static final int DEPLOY_PACKAGE_FAIL_ECODE = 8018;
    public static final int DEPLOY_PARSE_MANIFEST_ECODE = 8020;
    public static final String DEPLOY_PARSE_MANIFEST_EMSG = " parse manifest error ";
    public static final int DEPLOY_PKG_INTERRUPT_ECODE = 8013;
    public static final String DEPLOY_PKG_INTERRUPT_EMSG = "download pkgconfig interrupt ";
    public static final int DEPLOY_PKG_TRANSFER_THREAD_FAIL_ECODE = 8014;
    public static final String DEPLOY_PKG_TRANSFER_THREAD_FAIL_EMSG = "transfer deploy thread fail ";
    public static final int DEPLOY_SUBPKG_FAILED_ECODE = 8012;
    public static final String DEPLOY_SUBPKG_FAILED_EMSG = "deploy subpkg failed ";
    public static final int DEPLOY_SUCCESS = 0;
    public static final String DEPLOY_TYPE_DOWNLOAD = "download";
    public static final String DEPLOY_TYPE_LOCAL_ASSET = "local_asset";
    public static final String DEPLOY_TYPE_LOCAL_SDCARD = "local_sdcard";
    public static final String DEPLOY_TYPE_OTHER = "other";
    public static final String DEPLOY_TYPE_PRESET = "preset";
    public static final String DEPLOY_TYPE_SCAN = "scan";
    public static final String DOWNLOAD_FAILED_EXCEPTION_EMSG = "download file exception ";
    public static final int DOWNLOAD_FAILE_EXCEPTION_ECODE = 8008;
    public static final int ERROR_PKGINFO_ECODE = 8009;
    public static final String ERROR_PKGINFO_EMSG = "pkginfo error";
    public static final int NETWORK_UNAVALIABLE_ECODE = 8003;
    public static final String NETWORK_UNAVALIABLE_EMSG = "network unavaliable ";
    public static final int NETWORK_WEAK_ECODE = 8022;
    public static final String NETWORK_WEAK_EMSG = "network weak error ";
    public static final int PARSE_SUBPKG_FAIL_ECODE = 8016;
    public static final String PARSE_SUBPKG_FAIL_EMSG = "sub package parse fail ";
    public static final int RN_VERSION_NOT_MATCH_ECODE = 8015;
    public static final String RN_VERSION_NOT_MATCH_EMSG = "rn version not match ";
    public static final String UBC_DEPLOY_BUNDLE_TYPE = "dpmBundle";
    public static final String UNBR_FILE_FAILED_DETAIL_EMSG = "unbr file failed msg ";
    public static final int UNBR_FILE_FAILED_ECODE = 8024;
    public static final String UNBR_FILE_FAILED_EMSG = "unbr file failed ";
    public static final int UNBR_FILE_FAILED_MSG_ECODE = 8025;
    public static final int UNBR_NOT_RETYE_FILE_FAILED_MSG_ECODE = 8026;
    public static final String UNBR_NOT_RETYE_FILE_FAILED_MSG_EMSG = "unbr file failed msg not retye ";
    public static final int UNZIP_FILE_FAILED_ECODE = 8006;
    public static final String UNZIP_FILE_FAILED_EMSG = "unzip file failed ";
    public static final int UPDATE_BUNDLE_PARAMS_ERROR_ECODE = 8002;
    public static final String UPDATE_BUNDLE_PARAMS_ERROR_EMSG = "update bundle params error ";
    public static final int VERSION_CODE_NOT_MATCH_ECODE = 8010;
    public static final String VERSION_CODE_NOT_MATCH_EMSG = "version code not match ";
    public int mErrorCode;
    public String mErrorMsg;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DEPLOY_TYPE {
    }

    public DeployError(int errorCode, String errorMsg) {
        this.mErrorCode = errorCode;
        this.mErrorMsg = errorMsg;
    }
}
