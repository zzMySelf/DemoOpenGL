package com.baidu.sofire.e;

import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.ReadcardCallback;

public class a extends Callback {
    public final ReadcardCallback a;

    public a(ReadcardCallback readcardCallback) {
        this.a = readcardCallback;
    }

    public Object onBegin(Object... objArr) {
        ReadcardCallback readcardCallback = this.a;
        if (readcardCallback == null) {
            return null;
        }
        readcardCallback.onBegin();
        return null;
    }

    public Object onEnd(Object... objArr) {
        try {
            ReadcardCallback readcardCallback = this.a;
            if (readcardCallback == null) {
                return null;
            }
            readcardCallback.onSuccess(objArr[0]);
            return null;
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return null;
        }
    }

    public Object onError(Object... objArr) {
        try {
            ReadcardCallback readcardCallback = this.a;
            if (readcardCallback == null) {
                return null;
            }
            readcardCallback.onFailure(objArr[0].intValue(), objArr[1], objArr[2]);
            return null;
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return null;
        }
    }
}
