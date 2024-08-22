package com.baidu.sofire.xclient.privacycontrol;

public class PrivacyControlConfig {
    public final boolean a;
    public final boolean b;
    public final String c;

    public static class Builder {
        public String deviceId = "";
        public boolean isDebug = false;
        public boolean valueCache = false;

        public PrivacyControlConfig build() {
            return new PrivacyControlConfig(this);
        }

        public Builder setCacheSwitch(boolean z) {
            this.valueCache = z;
            return this;
        }

        public Builder setDebugModel(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }
    }

    public PrivacyControlConfig(Builder builder) {
        this.a = builder.isDebug;
        this.b = builder.valueCache;
        this.c = builder.deviceId;
    }
}
