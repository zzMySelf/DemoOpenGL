package com.baidu.iknow.android.advisorysdk.net.api.common;

import com.baidu.searchbox.NoProGuard;

public enum RefundStatus implements NoProGuard {
    USERCHECK("待咨询师售后"),
    COSTOMERCHECK("待消费者确认"),
    PLATFORMCHECK("待平台售后"),
    REFUNDED("退款成功"),
    CANCEL("售后关闭");
    
    private String label;

    private RefundStatus(String label2) {
        this.label = label2;
    }

    public String getLabel() {
        return this.label;
    }

    public static RefundStatus valueOf(int ordinal) {
        for (RefundStatus item : values()) {
            if (item.ordinal() == ordinal) {
                return item;
            }
        }
        return USERCHECK;
    }
}
