package com.baidu.sapi2.httpwrap;

import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.Map;

public class HttpHashMapWrap extends HttpHashMap implements NoProguard {
    public HttpHashMapWrap() {
        putAll(Utils.buildCommonParams());
    }

    public void doSign(String str) {
        Map map = getMap();
        if (map != null && !map.containsKey("sig")) {
            put("sig", SapiUtils.calculateSig(getMap(), str));
        }
    }
}
