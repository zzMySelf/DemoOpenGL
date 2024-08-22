package com.dxmpay.apollon.restnet.converter;

import android.text.TextUtils;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.apollon.utils.FileCopyUtils;
import fe.i.qw.th.ad.qw;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class StringHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    /* renamed from: de  reason: collision with root package name */
    public static final Charset f4028de = Charset.forName("UTF-8");

    public Object rg(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        String th2 = th(FileCopyUtils.copyToString(new InputStreamReader(eVar.b(), yj(eVar.c()))));
        fe(th2);
        return th2;
    }

    public final Charset yj(qw qwVar) {
        if (qwVar == null || TextUtils.isEmpty(qwVar.o())) {
            return f4028de;
        }
        return Charset.forName(qwVar.o());
    }
}
