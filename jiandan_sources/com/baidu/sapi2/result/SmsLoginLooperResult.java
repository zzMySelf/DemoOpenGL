package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;

public class SmsLoginLooperResult extends SapiResult implements NoProguard {
    public static final int QR_LOGIN_STATUS_LOGIN_DONE = 0;
    public static final int QR_LOGIN_STATUS_SCAN_DONE = 1;
    public static final int QR_LOGIN_STATUS_UEER_CANCEL = 2;
    public SapiAccount session;
    public int status;
}
