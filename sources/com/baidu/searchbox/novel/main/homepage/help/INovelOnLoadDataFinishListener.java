package com.baidu.searchbox.novel.main.homepage.help;

public interface INovelOnLoadDataFinishListener<T> {
    void onLoadFailed();

    void onLoadSuccess(T t);
}
