package com.baidu.wallet.lightapp.base.datamodel;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;

public class LightAppDeviceInfoModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public DeviceInfo data = new DeviceInfo();
    }

    public static class DeviceInfo implements NoProguard {
        public String BAIDUCUID = "";
        public String appversioncode = "";
        public String appversionname = "";
        public String brand = "";
        public String cuid = "";
        public String ip = "";
        public String model = "";
        public String name = "";
        public String networktype = "";
        public String os = "";
        public String ua = "";
        public String version = "";
    }

    public LightAppDeviceInfoModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppDeviceInfoModel(int i2) {
        this();
        this.result = i2;
    }
}
