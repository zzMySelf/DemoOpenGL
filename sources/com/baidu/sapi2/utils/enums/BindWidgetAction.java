package com.baidu.sapi2.utils.enums;

import com.baidu.searchbox.account.dto.BoxWebBindWidgetDTOKt;

public enum BindWidgetAction {
    BIND_MOBILE(BoxWebBindWidgetDTOKt.BIND_MOBILE, "绑定手机"),
    BIND_EMAIL(BoxWebBindWidgetDTOKt.BIND_EMAIL, "绑定邮箱"),
    REBIND_MOBILE(BoxWebBindWidgetDTOKt.REBIND_MOBILE, "换绑手机"),
    REBIND_EMAIL(BoxWebBindWidgetDTOKt.REBIND_EMAIL, "换绑邮箱"),
    UNBIND_MOBILE(BoxWebBindWidgetDTOKt.UNBIND_MOBILE, "解绑手机"),
    UNBIND_EMAIL(BoxWebBindWidgetDTOKt.UNBIND_EMAIL, "解绑邮箱");
    
    private String name;
    private String uri;

    private BindWidgetAction(String uri2, String name2) {
        this.uri = uri2;
        this.name = name2;
    }

    public String getUri() {
        return this.uri;
    }

    public String getName() {
        return this.name;
    }
}
