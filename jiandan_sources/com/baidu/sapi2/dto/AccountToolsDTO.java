package com.baidu.sapi2.dto;

import android.content.Context;

public class AccountToolsDTO extends SapiWebDTO {
    public static final int TYPE_APPEAL_ACCOUNT = 4;
    public static final int TYPE_APPEAL_QUERY = 11;
    public static final int TYPE_APP_AUTHORITY = 9;
    public static final int TYPE_CANCEL_ACCOUNT = 3;
    public static final int TYPE_DEVICE_MANAGE = 8;
    public static final int TYPE_FIND_ACCOUNT = 2;
    public static final int TYPE_FROST_ACCOUNT = 1;
    public static final int TYPE_LINK_ACCOUNT = 10;
    public static final int TYPE_LOGIN_PROTECT = 6;
    public static final int TYPE_LOGIN_TYPE = 7;
    public static final int TYPE_MODIFY_PWD = 5;
    public Context context;
    public int toolsType;
}
