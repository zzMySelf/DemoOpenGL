package com.baidu.sapi2.dto;

import android.os.Bundle;

public class RealNameDTO extends SapiWebDTO {
    public static final int JUNIOR_REAL_NAME = 1;
    public static final int SENIOR_REAL_NAME = 0;
    public String bduss;
    public String customRealNameUrl;
    public Bundle extraParams;
    public boolean needCbKey;
    public int realNameLevel;
    public String scene;
}
