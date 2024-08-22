package com.baidu.searchbox.video.detail.plugin.service;

import com.baidu.searchbox.video.detail.listener.PayCallBack;
import com.baidu.searchbox.video.detail.plugin.component.right.PayComponent;
import com.baidu.searchbox.video.detail.service.adapter.PayAdapter;

public class PayService extends PayAdapter {
    private PayComponent mPlugin;

    public PayService(PayComponent plugin) {
        this.mPlugin = plugin;
    }

    public String getName() {
        return PayService.class.getName();
    }

    public void startPayment(PayCallBack callBack) {
        this.mPlugin.startPayment(callBack);
    }

    public void startSinglePayment(PayCallBack callBack, Boolean isSingle) {
        this.mPlugin.startSinglePayment(callBack, isSingle);
    }
}
