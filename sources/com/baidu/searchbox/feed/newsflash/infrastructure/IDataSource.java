package com.baidu.searchbox.feed.newsflash.infrastructure;

import java.util.List;

public interface IDataSource<T, Param> {
    void getSourceAsync(Param param);

    List<T> getSourceSync(Param param);
}
