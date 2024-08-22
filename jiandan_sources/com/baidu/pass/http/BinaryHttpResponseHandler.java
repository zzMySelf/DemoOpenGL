package com.baidu.pass.http;

import android.os.Looper;
import com.baidu.pass.a;
import java.util.HashMap;

public class BinaryHttpResponseHandler extends HttpResponseHandler implements a {
    public String[] a;

    public BinaryHttpResponseHandler(Looper looper) {
        super(looper);
        this.a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
    }

    public void a(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        if (hashMap == null || hashMap.get("Content-Type") == null) {
            b(new HttpErrorException(i2, "None or more than one Content-Type Header found!"), (String) null);
            return;
        }
        String str = hashMap.get("Content-Type");
        String[] strArr = this.a;
        int length = strArr.length;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            } else if (strArr[i3].equalsIgnoreCase(str)) {
                z = true;
                break;
            } else {
                i3++;
            }
        }
        if (!z) {
            b(new HttpErrorException(i2, "Content-Type not allowed!"), (String) null);
        } else {
            onSuccess(i2, bArr);
        }
    }

    public void c(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.executCallbackInChildThread) {
            a(i2, hashMap, bArr);
            return;
        }
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i2), hashMap, bArr}));
    }

    public void onSuccess(int i2, byte[] bArr) {
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr) {
        this(looper, strArr, false);
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr, boolean z) {
        super(looper);
        this.a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
        this.a = strArr;
        this.executCallbackInChildThread = z;
    }
}
