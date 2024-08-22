package com.baidu.swan.pms.network;

import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.swan.pms.network.PmsHttp;
import java.lang.String;

public abstract class PMSStatResponseCallback<T extends String> implements StatResponseCallback<T>, PmsHttp.PmsHttpCallback {
}
