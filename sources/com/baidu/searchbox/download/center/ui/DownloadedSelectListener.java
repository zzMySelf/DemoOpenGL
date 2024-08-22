package com.baidu.searchbox.download.center.ui;

import com.baidu.searchbox.download.model.CategoryInfoData;

public interface DownloadedSelectListener {
    void changeMode(boolean z);

    void changeSelected(CategoryInfoData categoryInfoData);
}
