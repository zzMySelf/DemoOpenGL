package com.tera.scan.network.network.exception;

import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RemoteException extends Exception {
    public static final long serialVersionUID = -1460894893738016580L;
    public String mAlertMessage;
    public int mErrorCode;
    public RemoteExceptionInfo mErrorInfo;
    public String mErrorMessage;
    public int mPromptType;

    @Deprecated
    public RemoteException(int i2, String str) {
        this(i2, str, (String) null, (RemoteExceptionInfo) null);
    }

    @CheckResult
    @NonNull
    public static RemoteException buildRemoteException(int i2, String str, String str2) {
        return new RemoteException(i2, str2, str);
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public RemoteExceptionInfo getErrorInfo() {
        return this.mErrorInfo;
    }

    @Nullable
    public String getErrorMessage() {
        return TextUtils.isEmpty(this.mErrorMessage) ? this.mAlertMessage : this.mErrorMessage;
    }

    public String getMessage() {
        return "errorCode = " + this.mErrorCode + " " + super.getMessage();
    }

    public String getServerAlertMessage() {
        return this.mAlertMessage;
    }

    public String getServerErrorMessage() {
        return this.mErrorMessage;
    }

    public int getmPromptType() {
        return this.mPromptType;
    }

    @Deprecated
    public RemoteException(int i2, String str, RemoteExceptionInfo remoteExceptionInfo) {
        this(i2, str, (String) null, remoteExceptionInfo);
    }

    public RemoteException(int i2, String str, String str2) {
        this(i2, str, str2, (RemoteExceptionInfo) null);
    }

    public RemoteException(int i2, String str, String str2, int i3) {
        this(i2, str, str2, (RemoteExceptionInfo) null, i3);
    }

    public RemoteException(int i2, String str, String str2, RemoteExceptionInfo remoteExceptionInfo, int i3) {
        super(str);
        this.mErrorCode = i2;
        this.mErrorMessage = str;
        this.mAlertMessage = str2;
        this.mErrorInfo = remoteExceptionInfo;
        this.mPromptType = i3;
    }

    public RemoteException(int i2, String str, String str2, RemoteExceptionInfo remoteExceptionInfo) {
        super(str);
        this.mErrorCode = i2;
        this.mErrorMessage = str;
        this.mAlertMessage = str2;
        this.mErrorInfo = remoteExceptionInfo;
    }
}
