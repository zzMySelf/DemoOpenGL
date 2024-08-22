package com.baidu.sapi2.callback;

import com.baidu.sapi2.share.ShareStorage;
import java.util.List;

public interface ShareModelResultCallback {
    void onFailure(int i2, String str);

    void onSuccess(List<ShareStorage.StorageModel> list);
}
