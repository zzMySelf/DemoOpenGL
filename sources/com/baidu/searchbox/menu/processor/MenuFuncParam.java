package com.baidu.searchbox.menu.processor;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/menu/processor/MenuFuncParam;", "", "()V", "ext", "", "", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "mainParam", "getMainParam", "()Ljava/lang/String;", "setMainParam", "(Ljava/lang/String;)V", "preTaskResult", "getPreTaskResult", "setPreTaskResult", "Companion", "lib-menu-processor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MenuFuncParam.kt */
public final class MenuFuncParam {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXT_KEY_BUSINESS_SOURCE = "business_source";
    private Map<String, String> ext;
    private String mainParam;
    private Map<String, String> preTaskResult;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/menu/processor/MenuFuncParam$Companion;", "", "()V", "EXT_KEY_BUSINESS_SOURCE", "", "lib-menu-processor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MenuFuncParam.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getMainParam() {
        return this.mainParam;
    }

    public final void setMainParam(String str) {
        this.mainParam = str;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final void setExt(Map<String, String> map) {
        this.ext = map;
    }

    public final Map<String, String> getPreTaskResult() {
        return this.preTaskResult;
    }

    public final void setPreTaskResult(Map<String, String> map) {
        this.preTaskResult = map;
    }
}
