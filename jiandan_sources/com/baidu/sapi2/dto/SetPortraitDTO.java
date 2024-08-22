package com.baidu.sapi2.dto;

import com.baidu.sapi2.NoProguard;

public class SetPortraitDTO extends SapiDTO implements NoProguard {
    public static final int PORTRAIT_TYPE_CARTOON = 2;
    public static final int PORTRAIT_TYPE_DEFAULT = 0;
    public static final int PORTRAIT_TYPE_PRODUCT_DEFINE = 1;
    public String bduss;
    public String contentType;
    public byte[] file;
    public int portraitAttribute = 0;
    public int portraitType = 0;
}
