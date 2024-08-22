package com.baidu.sapi2.dto;

import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.List;

public class AccountCenterDTO extends SapiWebDTO {
    public static final PassNameValuePair HIDE_PERSONAL_DATA = new PassNameValuePair("personalData", "0");
    public static final PassNameValuePair HIDE_REAL_NAME = new PassNameValuePair("realname", "0");
    public static String REFER_ACCOUNT_CENTER = "account_center";
    public static String REFER_ACCOUNT_CHECK = "account_check";
    public String accountToolsUrl;
    public Drawable backBtnDrawable;
    public String bduss;
    public boolean handleLogin = false;
    public boolean isBoldTitle;
    public boolean isFromAccountTools;
    public boolean isFromGuideRealName;
    public boolean logoutAfterBdussInvalid = true;
    public List<PassNameValuePair> paramsList = new ArrayList();
    public String refer = REFER_ACCOUNT_CENTER;
    public int shieldOption = 0;
}
