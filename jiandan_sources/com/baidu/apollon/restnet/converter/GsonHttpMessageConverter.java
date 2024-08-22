package com.baidu.apollon.restnet.converter;

import android.text.TextUtils;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.http.a;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.json.JSONException;

public class GsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    public static final Charset a = Charset.forName("UTF-8");

    private Charset a(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.j())) {
            return a;
        }
        return Charset.forName(aVar.j());
    }

    public Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        InputStreamReader inputStreamReader = new InputStreamReader(eVar.c(), a(eVar.d()));
        String copyToString = FileCopyUtils.copyToString(inputStreamReader);
        a(copyToString);
        if (ApollonConstants.DEBUG) {
            int length = copyToString.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 2000;
                LogUtil.i("ServerResponse", i3 > length ? copyToString.substring(i2) : copyToString.substring(i2, i3));
                i2 = i3;
            }
        }
        try {
            Object fromJson = JsonUtils.fromJson(copyToString, cls);
            inputStreamReader.close();
            return fromJson;
        } catch (JSONException e) {
            throw new RestRuntimeException("Could not read JSON: " + e.getMessage(), e);
        }
    }
}
