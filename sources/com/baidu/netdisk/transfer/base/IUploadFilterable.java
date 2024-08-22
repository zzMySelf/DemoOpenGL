package com.baidu.netdisk.transfer.base;

import android.net.Uri;
import android.util.Pair;

public interface IUploadFilterable {
    Pair<Boolean, Boolean> filter(Uri uri);

    void initFilterData(UploadInfoList uploadInfoList);
}
