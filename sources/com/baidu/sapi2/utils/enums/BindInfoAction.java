package com.baidu.sapi2.utils.enums;

public enum BindInfoAction {
    BIND_MOBILE("0", "绑定手机"),
    BIND_EMAIL("1", "绑定邮箱");
    
    private String name;
    private String value;

    private BindInfoAction(String value2, String name2) {
        this.value = value2;
        this.name = name2;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
