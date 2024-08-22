package com.baidu.ar.auth;

import android.content.Context;

public interface IOfflineAuthenticator {
    boolean checkLicense(Context context, byte[] bArr);
}
