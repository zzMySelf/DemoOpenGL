package com.baidu.sapi2.callback;

import com.baidu.sapi2.share.ShareStorage;
import java.util.List;

public interface ShareModelWithCheckCallback {
    void onFailure(int i2, String str, String str2);

    void onSuccess(List<ShareStorage.StorageModel> list, String str);
}
