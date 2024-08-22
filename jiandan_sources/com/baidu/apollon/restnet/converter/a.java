package com.baidu.apollon.restnet.converter;

import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.FileCopyUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class a extends AbstractHttpMessageConverter<byte[]> {
    /* renamed from: c */
    public byte[] b(Class<?> cls, e eVar) throws IOException {
        long h = eVar.d().h();
        if (h < 0) {
            return FileCopyUtils.copyToByteArray(eVar.c());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) h);
        FileCopyUtils.copy(eVar.c(), (OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
