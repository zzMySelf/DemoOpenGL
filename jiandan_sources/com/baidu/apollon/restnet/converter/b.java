package com.baidu.apollon.restnet.converter;

import android.text.TextUtils;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.http.a;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.FileCopyUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class b extends AbstractHttpMessageConverter<Object> {
    public static final Charset a = Charset.forName("UTF-8");

    private Charset a(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.j())) {
            return a;
        }
        return Charset.forName(aVar.j());
    }

    public Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        String copyToString = FileCopyUtils.copyToString(new InputStreamReader(eVar.c(), a(eVar.d())));
        a(copyToString);
        return copyToString;
    }
}
