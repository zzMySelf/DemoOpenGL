package com.baidu.wallet.paysdk.datamodel;

import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;

public class DxmAddress implements NoProguard, Serializable {
    public String address = "";
    public String cityId = "";
    public String cityName = "";
    public String countyId = "";
    public String countyName = "";
    public String provinceId = "";
    public String provinceName = "";
}
