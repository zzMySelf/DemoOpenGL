package com.baidu.wallet.lightapp.ability.datamodle;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;

public class NativeAbilityDeviceInfoModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public String aesdata;
        public String aeskey;
        public DeviceInfo data = new DeviceInfo();
    }

    public static class DeviceInfo implements NoProguard {
        public String BAIDUCUID = "";
        public String appversioncode = "";
        public String appversionname = "";
        public String brand = "";
        public String cuid = "";
        public String imei = "";
        public String ip = "";
        public String model = "";
        public String name = "";
        public String networktype = "";
        public String os = "";
        public String ua = "";
        public String version = "";
    }

    public NativeAbilityDeviceInfoModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public NativeAbilityDeviceInfoModel(int i2) {
        this();
        this.result = i2;
    }
}
