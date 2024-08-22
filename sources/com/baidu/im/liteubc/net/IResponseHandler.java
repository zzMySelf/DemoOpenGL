package com.baidu.im.liteubc.net;

public interface IResponseHandler {
    void onFailure(int i2, byte[] bArr);

    void onSuccess(int i2, byte[] bArr);
}
