package com.baidu.swan.gamecenter.appmanager.model;

public class OperateFailResult extends OperateResult {
    public OperateFailResult(int status, String result) {
        super("onFail", status, result);
    }
}
