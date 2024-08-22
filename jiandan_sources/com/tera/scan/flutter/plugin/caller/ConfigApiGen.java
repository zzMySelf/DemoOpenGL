package com.tera.scan.flutter.plugin.caller;

import androidx.annotation.Keep;

@Keep
public interface ConfigApiGen {
    boolean getEnabledCustomSQLite();

    String getMispanConfig(String str);

    boolean globalConfigGetBoolean(String str, boolean z, boolean z2);

    float globalConfigGetFloat(String str, float f, boolean z);

    int globalConfigGetInt(String str, int i2, boolean z);

    long globalConfigGetLong(String str, long j, boolean z);

    String globalConfigGetString(String str, String str2, boolean z);

    boolean globalConfigHas(String str, boolean z);

    void globalConfigPutBoolean(String str, boolean z, boolean z2);

    void globalConfigPutFloat(String str, float f, boolean z);

    void globalConfigPutInt(String str, int i2, boolean z);

    void globalConfigPutLong(String str, long j, boolean z);

    void globalConfigPutString(String str, String str2, boolean z);

    boolean isFilePermissionsSwitchOpen();

    boolean personalConfigGetBoolean(String str, boolean z, boolean z2);

    float personalConfigGetFloat(String str, float f, boolean z);

    int personalConfigGetInt(String str, int i2, boolean z);

    long personalConfigGetLong(String str, long j, boolean z);

    String personalConfigGetString(String str, String str2, boolean z);

    boolean personalConfigHas(String str, boolean z);

    void personalConfigPutBoolean(String str, boolean z, boolean z2);

    void personalConfigPutFloat(String str, float f, boolean z);

    void personalConfigPutInt(String str, int i2, boolean z);

    void personalConfigPutLong(String str, long j, boolean z);

    void personalConfigPutString(String str, String str2, boolean z);

    String serverConfigGetString(String str, String str2);
}
