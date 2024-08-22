package com.baidu.searchbox.lockscreen.parser;

import com.baidu.searchbox.lockscreen.model.LockScreenItemData;
import org.json.JSONObject;

public abstract class LockScreenItemDataParser {
    public abstract LockScreenItemData parseItemData(JSONObject jSONObject);
}
