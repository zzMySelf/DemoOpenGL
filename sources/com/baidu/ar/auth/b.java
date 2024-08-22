package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import java.util.List;

public interface b {
    Bitmap a(Context context);

    List<Integer> a(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback);

    List<Integer> a(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2);

    void a(Context context, IAuthCallback iAuthCallback);

    void a(byte[] bArr, String str, String str2, String str3);

    boolean a();

    boolean a(int i2);

    boolean a(Context context, byte[] bArr);

    void b(int i2);

    void b(Context context);

    boolean c(int i2);

    void release();
}
