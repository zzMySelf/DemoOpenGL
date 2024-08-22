package com.baidu.searchbox.discovery.picture;

import com.baidu.searchbox.picture.model.LightPictureUgcModel;

public interface OnResponseDataListener {
    void onError();

    void onResult(LightPictureUgcModel lightPictureUgcModel);
}
