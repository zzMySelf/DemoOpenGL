package com.alipay.sdk.m.j;

import com.alipay.sdk.app.OpenAuthTask;
import com.baidu.pass.permissions.PermissionsHelperActivity;

public enum c {
    SUCCEEDED(OpenAuthTask.OK, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    ACTIVITY_NOT_START_EXIT(6007, "支付未完成"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(PermissionsHelperActivity.e, "支付结果确认中");
    
    public int a;
    public String b;

    /* access modifiers changed from: public */
    c(int i2, String str) {
        this.a = i2;
        this.b = str;
    }

    public void a(int i2) {
        this.a = i2;
    }

    public int b() {
        return this.a;
    }

    public static c b(int i2) {
        if (i2 == 4001) {
            return PARAMS_ERROR;
        }
        if (i2 == 5000) {
            return DOUBLE_REQUEST;
        }
        if (i2 == 8000) {
            return PAY_WAITTING;
        }
        if (i2 == 9000) {
            return SUCCEEDED;
        }
        if (i2 == 6001) {
            return CANCELED;
        }
        if (i2 != 6002) {
            return FAILED;
        }
        return NETWORK_ERROR;
    }

    public void a(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }
}
