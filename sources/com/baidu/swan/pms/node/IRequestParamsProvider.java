package com.baidu.swan.pms.node;

import org.json.JSONArray;
import org.json.JSONObject;

public interface IRequestParamsProvider {
    JSONArray buildArrayParams(Decorator<JSONArray> decorator);

    JSONObject buildParams(Decorator<JSONObject> decorator);
}
