package com.baidu.searchbox.noveladapter.share;

import com.baidu.searchbox.NoProGuard;
import org.json.JSONObject;

public interface INovelSearchboxOnSocialListener extends NoProGuard {
    void onCancel();

    void onFail(int i2, String str);

    void onStart();

    void onSuccess(JSONObject jSONObject);
}
