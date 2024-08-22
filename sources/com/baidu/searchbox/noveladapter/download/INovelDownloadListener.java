package com.baidu.searchbox.noveladapter.download;

import com.baidu.searchbox.NoProGuard;

public interface INovelDownloadListener extends NoProGuard {
    void onChanged(NovelDownloadBeanWarpper novelDownloadBeanWarpper, String str);
}
