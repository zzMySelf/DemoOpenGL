package com.baidu.searchbox.favor.sync.business.favor.db;

public abstract class RemoteCallBack<T> {
    public abstract void onEnvironmentResult(Exception exc);

    public abstract void onFailResult(String str, String str2);

    public abstract void onSuccessResult(T t);
}
