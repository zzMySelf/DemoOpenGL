package com.baidu.ubc.constants;

public enum EnumConstants$Trigger {
    DEFAULT("other"),
    COLD_START("coldStart"),
    UPLOAD_ALL("uploadAll"),
    FOREGROUND_TO_BACKGROUND("foreToBack"),
    NETWORK_AVAILABLE("network"),
    TIMER_ARRIVED("timer"),
    LOG_TOO_MANY("numberLimit"),
    REAL("uploadReal"),
    UNREAL("uploadNonReal"),
    REAL_APPEND_UNREAL("realAppendUnreal"),
    DIRECT_LOG("directLog"),
    BEFORE_AGREE_PRIVACY("beforePrivacy");
    
    public final String value;

    /* access modifiers changed from: public */
    EnumConstants$Trigger(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
