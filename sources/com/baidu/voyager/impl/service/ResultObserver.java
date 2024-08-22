package com.baidu.voyager.impl.service;

import com.baidu.pyramid.annotation.component.DefaultListHolder;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.voyager.inter.IResultObserver;
import com.baidu.voyager.inter.IResultObserver_ResultObserver_ListProvider;

public class ResultObserver {
    public ListHolder<IResultObserver> mObserverList;

    public void initmObserverList() {
        DefaultListHolder create = DefaultListHolder.create();
        this.mObserverList = create;
        create.setList(new IResultObserver_ResultObserver_ListProvider());
    }

    public ResultObserver() {
        initmObserverList();
    }
}
