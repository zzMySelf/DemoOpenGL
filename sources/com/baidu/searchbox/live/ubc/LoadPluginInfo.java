package com.baidu.searchbox.live.ubc;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0002-.Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J}\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LoadPluginInfo;", "", "status1", "", "plugin1_version", "", "error1_code", "status2", "plugin2_version", "error2_code", "plugin_page", "ext_info", "", "load_first_plugin_duration", "load_second_plugin_duration", "(ILjava/lang/String;IILjava/lang/String;IILjava/util/Map;II)V", "getError1_code", "()I", "getError2_code", "getExt_info", "()Ljava/util/Map;", "getLoad_first_plugin_duration", "getLoad_second_plugin_duration", "getPlugin1_version", "()Ljava/lang/String;", "getPlugin2_version", "getPlugin_page", "getStatus1", "getStatus2", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "PluginLoadStatus", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LoadPlayerRoomEvent.kt */
public final class LoadPluginInfo {
    private final int error1_code;
    private final int error2_code;
    private final Map<String, String> ext_info;
    private final int load_first_plugin_duration;
    private final int load_second_plugin_duration;
    private final String plugin1_version;
    private final String plugin2_version;
    private final int plugin_page;
    private final int status1;
    private final int status2;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LoadPluginInfo$PluginLoadStatus;", "", "(Ljava/lang/String;I)V", "DEFAULT", "LOADING", "LOAD_SUCCESS", "LOAD_FAIL", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LoadPlayerRoomEvent.kt */
    public enum PluginLoadStatus {
        DEFAULT,
        LOADING,
        LOAD_SUCCESS,
        LOAD_FAIL
    }

    public static /* synthetic */ LoadPluginInfo copy$default(LoadPluginInfo loadPluginInfo, int i2, String str, int i3, int i4, String str2, int i5, int i6, Map map, int i7, int i8, int i9, Object obj) {
        LoadPluginInfo loadPluginInfo2 = loadPluginInfo;
        int i10 = i9;
        return loadPluginInfo.copy((i10 & 1) != 0 ? loadPluginInfo2.status1 : i2, (i10 & 2) != 0 ? loadPluginInfo2.plugin1_version : str, (i10 & 4) != 0 ? loadPluginInfo2.error1_code : i3, (i10 & 8) != 0 ? loadPluginInfo2.status2 : i4, (i10 & 16) != 0 ? loadPluginInfo2.plugin2_version : str2, (i10 & 32) != 0 ? loadPluginInfo2.error2_code : i5, (i10 & 64) != 0 ? loadPluginInfo2.plugin_page : i6, (i10 & 128) != 0 ? loadPluginInfo2.ext_info : map, (i10 & 256) != 0 ? loadPluginInfo2.load_first_plugin_duration : i7, (i10 & 512) != 0 ? loadPluginInfo2.load_second_plugin_duration : i8);
    }

    public final int component1() {
        return this.status1;
    }

    public final int component10() {
        return this.load_second_plugin_duration;
    }

    public final String component2() {
        return this.plugin1_version;
    }

    public final int component3() {
        return this.error1_code;
    }

    public final int component4() {
        return this.status2;
    }

    public final String component5() {
        return this.plugin2_version;
    }

    public final int component6() {
        return this.error2_code;
    }

    public final int component7() {
        return this.plugin_page;
    }

    public final Map<String, String> component8() {
        return this.ext_info;
    }

    public final int component9() {
        return this.load_first_plugin_duration;
    }

    public final LoadPluginInfo copy(int i2, String str, int i3, int i4, String str2, int i5, int i6, Map<String, String> map, int i7, int i8) {
        Intrinsics.checkParameterIsNotNull(map, "ext_info");
        return new LoadPluginInfo(i2, str, i3, i4, str2, i5, i6, map, i7, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadPluginInfo)) {
            return false;
        }
        LoadPluginInfo loadPluginInfo = (LoadPluginInfo) obj;
        return this.status1 == loadPluginInfo.status1 && Intrinsics.areEqual((Object) this.plugin1_version, (Object) loadPluginInfo.plugin1_version) && this.error1_code == loadPluginInfo.error1_code && this.status2 == loadPluginInfo.status2 && Intrinsics.areEqual((Object) this.plugin2_version, (Object) loadPluginInfo.plugin2_version) && this.error2_code == loadPluginInfo.error2_code && this.plugin_page == loadPluginInfo.plugin_page && Intrinsics.areEqual((Object) this.ext_info, (Object) loadPluginInfo.ext_info) && this.load_first_plugin_duration == loadPluginInfo.load_first_plugin_duration && this.load_second_plugin_duration == loadPluginInfo.load_second_plugin_duration;
    }

    public int hashCode() {
        int i2 = this.status1 * 31;
        String str = this.plugin1_version;
        int i3 = 0;
        int hashCode = (((((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.error1_code) * 31) + this.status2) * 31;
        String str2 = this.plugin2_version;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.error2_code) * 31) + this.plugin_page) * 31;
        Map<String, String> map = this.ext_info;
        if (map != null) {
            i3 = map.hashCode();
        }
        return ((((hashCode2 + i3) * 31) + this.load_first_plugin_duration) * 31) + this.load_second_plugin_duration;
    }

    public String toString() {
        return "LoadPluginInfo(status1=" + this.status1 + ", plugin1_version=" + this.plugin1_version + ", error1_code=" + this.error1_code + ", status2=" + this.status2 + ", plugin2_version=" + this.plugin2_version + ", error2_code=" + this.error2_code + ", plugin_page=" + this.plugin_page + ", ext_info=" + this.ext_info + ", load_first_plugin_duration=" + this.load_first_plugin_duration + ", load_second_plugin_duration=" + this.load_second_plugin_duration + ")";
    }

    public LoadPluginInfo(int status12, String plugin1_version2, int error1_code2, int status22, String plugin2_version2, int error2_code2, int plugin_page2, Map<String, String> ext_info2, int load_first_plugin_duration2, int load_second_plugin_duration2) {
        Intrinsics.checkParameterIsNotNull(ext_info2, "ext_info");
        this.status1 = status12;
        this.plugin1_version = plugin1_version2;
        this.error1_code = error1_code2;
        this.status2 = status22;
        this.plugin2_version = plugin2_version2;
        this.error2_code = error2_code2;
        this.plugin_page = plugin_page2;
        this.ext_info = ext_info2;
        this.load_first_plugin_duration = load_first_plugin_duration2;
        this.load_second_plugin_duration = load_second_plugin_duration2;
    }

    public final int getStatus1() {
        return this.status1;
    }

    public final String getPlugin1_version() {
        return this.plugin1_version;
    }

    public final int getError1_code() {
        return this.error1_code;
    }

    public final int getStatus2() {
        return this.status2;
    }

    public final String getPlugin2_version() {
        return this.plugin2_version;
    }

    public final int getError2_code() {
        return this.error2_code;
    }

    public final int getPlugin_page() {
        return this.plugin_page;
    }

    public final Map<String, String> getExt_info() {
        return this.ext_info;
    }

    public final int getLoad_first_plugin_duration() {
        return this.load_first_plugin_duration;
    }

    public final int getLoad_second_plugin_duration() {
        return this.load_second_plugin_duration;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B«\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011¢\u0006\u0002\u0010\u0015J\u0006\u0010<\u001a\u00020=J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u0015\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fHÆ\u0003J\t\u0010A\u001a\u00020\u0011HÆ\u0003J\t\u0010B\u001a\u00020\u0011HÆ\u0003J\t\u0010C\u001a\u00020\u0011HÆ\u0003J\t\u0010D\u001a\u00020\u0011HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J¯\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0011HÆ\u0001J\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010R\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003J\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fJ\t\u0010S\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u0005J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003J\t\u0010W\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001a\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001a\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019¨\u0006X"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LoadPluginInfo$Builder;", "", "status1", "", "plugin1_version", "", "error1_code", "status2", "plugin2_version", "error2_code", "plugin_page", "statusyy", "erroryy_type", "erroryy_code", "ext_info", "", "load_first_plugin_start", "", "load_first_plugin_end", "load_second_plugin_start", "load_second_plugin_end", "(ILjava/lang/String;IILjava/lang/String;IIIIILjava/util/Map;JJJJ)V", "getError1_code", "()I", "setError1_code", "(I)V", "getError2_code", "setError2_code", "getErroryy_code", "setErroryy_code", "getErroryy_type", "setErroryy_type", "getExt_info", "()Ljava/util/Map;", "setExt_info", "(Ljava/util/Map;)V", "getLoad_first_plugin_end", "()J", "setLoad_first_plugin_end", "(J)V", "getLoad_first_plugin_start", "setLoad_first_plugin_start", "getLoad_second_plugin_end", "setLoad_second_plugin_end", "getLoad_second_plugin_start", "setLoad_second_plugin_start", "getPlugin1_version", "()Ljava/lang/String;", "setPlugin1_version", "(Ljava/lang/String;)V", "getPlugin2_version", "setPlugin2_version", "getPlugin_page", "setPlugin_page", "getStatus1", "setStatus1", "getStatus2", "setStatus2", "getStatusyy", "setStatusyy", "build", "Lcom/baidu/searchbox/live/ubc/LoadPluginInfo;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "errorYy_code", "errorYy_type", "hashCode", "version", "plugin2Version", "statusYy", "toString", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LoadPlayerRoomEvent.kt */
    public static final class Builder {
        private int error1_code;
        private int error2_code;
        private int erroryy_code;
        private int erroryy_type;
        private Map<String, String> ext_info;
        private long load_first_plugin_end;
        private long load_first_plugin_start;
        private long load_second_plugin_end;
        private long load_second_plugin_start;
        private String plugin1_version;
        private String plugin2_version;
        private int plugin_page;
        private int status1;
        private int status2;
        private int statusyy;

        public Builder() {
            this(0, (String) null, 0, 0, (String) null, 0, 0, 0, 0, 0, (Map) null, 0, 0, 0, 0, 32767, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Builder copy$default(Builder builder, int i2, String str, int i3, int i4, String str2, int i5, int i6, int i7, int i8, int i9, Map map, long j2, long j3, long j4, long j5, int i10, Object obj) {
            Builder builder2 = builder;
            int i11 = i10;
            return builder.copy((i11 & 1) != 0 ? builder2.status1 : i2, (i11 & 2) != 0 ? builder2.plugin1_version : str, (i11 & 4) != 0 ? builder2.error1_code : i3, (i11 & 8) != 0 ? builder2.status2 : i4, (i11 & 16) != 0 ? builder2.plugin2_version : str2, (i11 & 32) != 0 ? builder2.error2_code : i5, (i11 & 64) != 0 ? builder2.plugin_page : i6, (i11 & 128) != 0 ? builder2.statusyy : i7, (i11 & 256) != 0 ? builder2.erroryy_type : i8, (i11 & 512) != 0 ? builder2.erroryy_code : i9, (i11 & 1024) != 0 ? builder2.ext_info : map, (i11 & 2048) != 0 ? builder2.load_first_plugin_start : j2, (i11 & 4096) != 0 ? builder2.load_first_plugin_end : j3, (i11 & 8192) != 0 ? builder2.load_second_plugin_start : j4, (i11 & 16384) != 0 ? builder2.load_second_plugin_end : j5);
        }

        public final int component1() {
            return this.status1;
        }

        public final int component10() {
            return this.erroryy_code;
        }

        public final Map<String, String> component11() {
            return this.ext_info;
        }

        public final long component12() {
            return this.load_first_plugin_start;
        }

        public final long component13() {
            return this.load_first_plugin_end;
        }

        public final long component14() {
            return this.load_second_plugin_start;
        }

        public final long component15() {
            return this.load_second_plugin_end;
        }

        public final String component2() {
            return this.plugin1_version;
        }

        public final int component3() {
            return this.error1_code;
        }

        public final int component4() {
            return this.status2;
        }

        public final String component5() {
            return this.plugin2_version;
        }

        public final int component6() {
            return this.error2_code;
        }

        public final int component7() {
            return this.plugin_page;
        }

        public final int component8() {
            return this.statusyy;
        }

        public final int component9() {
            return this.erroryy_type;
        }

        public final Builder copy(int i2, String str, int i3, int i4, String str2, int i5, int i6, int i7, int i8, int i9, Map<String, String> map, long j2, long j3, long j4, long j5) {
            Intrinsics.checkParameterIsNotNull(map, "ext_info");
            return new Builder(i2, str, i3, i4, str2, i5, i6, i7, i8, i9, map, j2, j3, j4, j5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return this.status1 == builder.status1 && Intrinsics.areEqual((Object) this.plugin1_version, (Object) builder.plugin1_version) && this.error1_code == builder.error1_code && this.status2 == builder.status2 && Intrinsics.areEqual((Object) this.plugin2_version, (Object) builder.plugin2_version) && this.error2_code == builder.error2_code && this.plugin_page == builder.plugin_page && this.statusyy == builder.statusyy && this.erroryy_type == builder.erroryy_type && this.erroryy_code == builder.erroryy_code && Intrinsics.areEqual((Object) this.ext_info, (Object) builder.ext_info) && this.load_first_plugin_start == builder.load_first_plugin_start && this.load_first_plugin_end == builder.load_first_plugin_end && this.load_second_plugin_start == builder.load_second_plugin_start && this.load_second_plugin_end == builder.load_second_plugin_end;
        }

        public int hashCode() {
            int i2 = this.status1 * 31;
            String str = this.plugin1_version;
            int i3 = 0;
            int hashCode = (((((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.error1_code) * 31) + this.status2) * 31;
            String str2 = this.plugin2_version;
            int hashCode2 = (((((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.error2_code) * 31) + this.plugin_page) * 31) + this.statusyy) * 31) + this.erroryy_type) * 31) + this.erroryy_code) * 31;
            Map<String, String> map = this.ext_info;
            if (map != null) {
                i3 = map.hashCode();
            }
            long j2 = this.load_first_plugin_start;
            long j3 = this.load_first_plugin_end;
            long j4 = this.load_second_plugin_start;
            long j5 = this.load_second_plugin_end;
            return ((((((((hashCode2 + i3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)));
        }

        public String toString() {
            return "Builder(status1=" + this.status1 + ", plugin1_version=" + this.plugin1_version + ", error1_code=" + this.error1_code + ", status2=" + this.status2 + ", plugin2_version=" + this.plugin2_version + ", error2_code=" + this.error2_code + ", plugin_page=" + this.plugin_page + ", statusyy=" + this.statusyy + ", erroryy_type=" + this.erroryy_type + ", erroryy_code=" + this.erroryy_code + ", ext_info=" + this.ext_info + ", load_first_plugin_start=" + this.load_first_plugin_start + ", load_first_plugin_end=" + this.load_first_plugin_end + ", load_second_plugin_start=" + this.load_second_plugin_start + ", load_second_plugin_end=" + this.load_second_plugin_end + ")";
        }

        public Builder(int status12, String plugin1_version2, int error1_code2, int status22, String plugin2_version2, int error2_code2, int plugin_page2, int statusyy2, int erroryy_type2, int erroryy_code2, Map<String, String> ext_info2, long load_first_plugin_start2, long load_first_plugin_end2, long load_second_plugin_start2, long load_second_plugin_end2) {
            Map<String, String> map = ext_info2;
            Intrinsics.checkParameterIsNotNull(map, "ext_info");
            this.status1 = status12;
            this.plugin1_version = plugin1_version2;
            this.error1_code = error1_code2;
            this.status2 = status22;
            this.plugin2_version = plugin2_version2;
            this.error2_code = error2_code2;
            this.plugin_page = plugin_page2;
            this.statusyy = statusyy2;
            this.erroryy_type = erroryy_type2;
            this.erroryy_code = erroryy_code2;
            this.ext_info = map;
            this.load_first_plugin_start = load_first_plugin_start2;
            this.load_first_plugin_end = load_first_plugin_end2;
            this.load_second_plugin_start = load_second_plugin_start2;
            this.load_second_plugin_end = load_second_plugin_end2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Builder(int r22, java.lang.String r23, int r24, int r25, java.lang.String r26, int r27, int r28, int r29, int r30, int r31, java.util.Map r32, long r33, long r35, long r37, long r39, int r41, kotlin.jvm.internal.DefaultConstructorMarker r42) {
            /*
                r21 = this;
                r0 = r41
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r1 = r2
                goto L_0x000b
            L_0x0009:
                r1 = r22
            L_0x000b:
                r3 = r0 & 2
                r4 = 0
                if (r3 == 0) goto L_0x0015
                r3 = r4
                java.lang.String r3 = (java.lang.String) r3
                r3 = r4
                goto L_0x0017
            L_0x0015:
                r3 = r23
            L_0x0017:
                r5 = r0 & 4
                if (r5 == 0) goto L_0x001d
                r5 = r2
                goto L_0x001f
            L_0x001d:
                r5 = r24
            L_0x001f:
                r6 = r0 & 8
                if (r6 == 0) goto L_0x0025
                r6 = r2
                goto L_0x0027
            L_0x0025:
                r6 = r25
            L_0x0027:
                r7 = r0 & 16
                if (r7 == 0) goto L_0x002f
                r7 = r4
                java.lang.String r7 = (java.lang.String) r7
                goto L_0x0031
            L_0x002f:
                r4 = r26
            L_0x0031:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x0037
                r7 = r2
                goto L_0x0039
            L_0x0037:
                r7 = r27
            L_0x0039:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x003f
                r8 = r2
                goto L_0x0041
            L_0x003f:
                r8 = r28
            L_0x0041:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x0047
                r9 = r2
                goto L_0x0049
            L_0x0047:
                r9 = r29
            L_0x0049:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x004f
                r10 = r2
                goto L_0x0051
            L_0x004f:
                r10 = r30
            L_0x0051:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L_0x0056
                goto L_0x0058
            L_0x0056:
                r2 = r31
            L_0x0058:
                r11 = r0 & 1024(0x400, float:1.435E-42)
                if (r11 == 0) goto L_0x0061
                java.util.Map r11 = kotlin.collections.MapsKt.emptyMap()
                goto L_0x0063
            L_0x0061:
                r11 = r32
            L_0x0063:
                r12 = r0 & 2048(0x800, float:2.87E-42)
                r13 = 0
                if (r12 == 0) goto L_0x006b
                r15 = r13
                goto L_0x006d
            L_0x006b:
                r15 = r33
            L_0x006d:
                r12 = r0 & 4096(0x1000, float:5.74E-42)
                if (r12 == 0) goto L_0x0074
                r17 = r13
                goto L_0x0076
            L_0x0074:
                r17 = r35
            L_0x0076:
                r12 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r12 == 0) goto L_0x007d
                r19 = r13
                goto L_0x007f
            L_0x007d:
                r19 = r37
            L_0x007f:
                r0 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r0 == 0) goto L_0x0084
                goto L_0x0086
            L_0x0084:
                r13 = r39
            L_0x0086:
                r22 = r1
                r23 = r3
                r24 = r5
                r25 = r6
                r26 = r4
                r27 = r7
                r28 = r8
                r29 = r9
                r30 = r10
                r31 = r2
                r32 = r11
                r33 = r15
                r35 = r17
                r37 = r19
                r39 = r13
                r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r35, r37, r39)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.live.ubc.LoadPluginInfo.Builder.<init>(int, java.lang.String, int, int, java.lang.String, int, int, int, int, int, java.util.Map, long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final int getStatus1() {
            return this.status1;
        }

        public final void setStatus1(int i2) {
            this.status1 = i2;
        }

        public final String getPlugin1_version() {
            return this.plugin1_version;
        }

        public final void setPlugin1_version(String str) {
            this.plugin1_version = str;
        }

        public final int getError1_code() {
            return this.error1_code;
        }

        public final void setError1_code(int i2) {
            this.error1_code = i2;
        }

        public final int getStatus2() {
            return this.status2;
        }

        public final void setStatus2(int i2) {
            this.status2 = i2;
        }

        public final String getPlugin2_version() {
            return this.plugin2_version;
        }

        public final void setPlugin2_version(String str) {
            this.plugin2_version = str;
        }

        public final int getError2_code() {
            return this.error2_code;
        }

        public final void setError2_code(int i2) {
            this.error2_code = i2;
        }

        public final int getPlugin_page() {
            return this.plugin_page;
        }

        public final void setPlugin_page(int i2) {
            this.plugin_page = i2;
        }

        public final int getStatusyy() {
            return this.statusyy;
        }

        public final void setStatusyy(int i2) {
            this.statusyy = i2;
        }

        public final int getErroryy_type() {
            return this.erroryy_type;
        }

        public final void setErroryy_type(int i2) {
            this.erroryy_type = i2;
        }

        public final int getErroryy_code() {
            return this.erroryy_code;
        }

        public final void setErroryy_code(int i2) {
            this.erroryy_code = i2;
        }

        public final Map<String, String> getExt_info() {
            return this.ext_info;
        }

        public final void setExt_info(Map<String, String> map) {
            Intrinsics.checkParameterIsNotNull(map, "<set-?>");
            this.ext_info = map;
        }

        public final long getLoad_first_plugin_start() {
            return this.load_first_plugin_start;
        }

        public final void setLoad_first_plugin_start(long j2) {
            this.load_first_plugin_start = j2;
        }

        public final long getLoad_first_plugin_end() {
            return this.load_first_plugin_end;
        }

        public final void setLoad_first_plugin_end(long j2) {
            this.load_first_plugin_end = j2;
        }

        public final long getLoad_second_plugin_start() {
            return this.load_second_plugin_start;
        }

        public final void setLoad_second_plugin_start(long j2) {
            this.load_second_plugin_start = j2;
        }

        public final long getLoad_second_plugin_end() {
            return this.load_second_plugin_end;
        }

        public final void setLoad_second_plugin_end(long j2) {
            this.load_second_plugin_end = j2;
        }

        public final Builder status1(int status12) {
            this.status1 = status12;
            return this;
        }

        public final Builder plugin1_version(String version) {
            Intrinsics.checkParameterIsNotNull(version, "version");
            this.plugin1_version = version;
            return this;
        }

        public final Builder error1_code(int error1_code2) {
            this.error1_code = error1_code2;
            return this;
        }

        public final Builder status2(int status22) {
            this.status2 = status22;
            return this;
        }

        public final Builder plugin2Version(String version) {
            Intrinsics.checkParameterIsNotNull(version, "version");
            this.plugin2_version = version;
            return this;
        }

        public final Builder error2_code(int error2_code2) {
            this.error2_code = error2_code2;
            return this;
        }

        public final Builder statusYy(int statusyy2) {
            this.statusyy = statusyy2;
            return this;
        }

        public final Builder errorYy_type(int erroryy_type2) {
            this.erroryy_type = erroryy_type2;
            return this;
        }

        public final Builder errorYy_code(int erroryy_code2) {
            this.erroryy_code = erroryy_code2;
            return this;
        }

        public final Builder plugin_page(int plugin_page2) {
            this.plugin_page = plugin_page2;
            return this;
        }

        public final Builder ext_info(Map<String, String> ext_info2) {
            Intrinsics.checkParameterIsNotNull(ext_info2, "ext_info");
            this.ext_info = ext_info2;
            return this;
        }

        public final Builder load_first_plugin_start(long load_first_plugin_start2) {
            this.load_first_plugin_start = load_first_plugin_start2;
            return this;
        }

        public final Builder load_first_plugin_end(long load_first_plugin_end2) {
            this.load_first_plugin_end = load_first_plugin_end2;
            return this;
        }

        public final Builder load_second_plugin_start(long load_second_plugin_start2) {
            this.load_second_plugin_start = load_second_plugin_start2;
            return this;
        }

        public final Builder load_second_plugin_end(long load_second_plugin_end2) {
            this.load_second_plugin_end = load_second_plugin_end2;
            return this;
        }

        public final LoadPluginInfo build() {
            return new LoadPluginInfo(this.status1, this.plugin1_version, this.error1_code, this.status2, this.plugin2_version, this.error2_code, this.plugin_page, this.ext_info, (int) (this.load_first_plugin_end - this.load_first_plugin_start), (int) (this.load_second_plugin_end - this.load_second_plugin_start));
        }
    }
}
