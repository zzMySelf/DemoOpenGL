package com.baidu.searchbox.redux.impl;

import com.baidu.searchbox.redux.Dispatcher;
import com.baidu.searchbox.redux.StateHolder;

public interface Thunk {
    void thunk(StateHolder stateHolder, Dispatcher dispatcher, Object obj);
}
