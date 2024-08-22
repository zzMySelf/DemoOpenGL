package com.baidu.swan.games.storage.result;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.binding.model.JSCommonResult;

public class StorageInfoResult extends JSCommonResult {
    @V8JavascriptField
    public long currentSize;
    @V8JavascriptField
    public String[] keys;
    @V8JavascriptField
    public long limitSize;
}
