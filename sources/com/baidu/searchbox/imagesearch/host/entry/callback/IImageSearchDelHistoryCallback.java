package com.baidu.searchbox.imagesearch.host.entry.callback;

import com.baidu.searchbox.imagesearch.host.entry.result.DeleteHistoryRealResult;

public interface IImageSearchDelHistoryCallback extends BaseCallback<DeleteHistoryRealResult> {
    void onResult(int i2, DeleteHistoryRealResult deleteHistoryRealResult);
}
