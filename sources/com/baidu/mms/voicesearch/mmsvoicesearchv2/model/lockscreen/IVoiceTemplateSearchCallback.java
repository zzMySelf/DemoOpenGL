package com.baidu.mms.voicesearch.mmsvoicesearchv2.model.lockscreen;

import com.baidu.ttsplugin.google.gson.JsonObject;

public interface IVoiceTemplateSearchCallback {
    void onError(int i2, Exception exc);

    void onSuccess(String str, JsonObject jsonObject);
}
