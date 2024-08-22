package com.dxmpay.apollon.restnet.converter;

import android.text.TextUtils;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.apollon.utils.FileCopyUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.LogUtil;
import fe.i.qw.th.ad.qw;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.json.JSONException;

public class GsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    /* renamed from: de  reason: collision with root package name */
    public static final Charset f4027de = Charset.forName("UTF-8");

    public Object rg(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        InputStreamReader inputStreamReader = new InputStreamReader(eVar.b(), yj(eVar.c()));
        String th2 = th(FileCopyUtils.copyToString(inputStreamReader));
        fe(th2);
        if (ApollonConstants.DEBUG) {
            int length = th2.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 2000;
                LogUtil.i("ServerResponse", i3 > length ? th2.substring(i2) : th2.substring(i2, i3));
                i2 = i3;
            }
        }
        try {
            Object fromJson = JsonUtils.fromJson(th2, cls);
            inputStreamReader.close();
            return fromJson;
        } catch (JSONException e) {
            throw new RestRuntimeException("Could not read JSON: " + e.getMessage(), e);
        }
    }

    public final Charset yj(qw qwVar) {
        if (qwVar == null || TextUtils.isEmpty(qwVar.o())) {
            return f4027de;
        }
        return Charset.forName(qwVar.o());
    }
}
