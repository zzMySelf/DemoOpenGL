package com.baidu.live.plugin.prepare;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/live/plugin/prepare/PreLoadRuntime;", "", "()V", "preLoadHelper", "Lcom/baidu/live/plugin/prepare/PreLoadRuntime$PreLoadHelper;", "getPreLoadHelper", "setPreLoadHelper", "", "helper", "Companion", "InstallMediaPluginCallback", "PreLoadHelper", "lib-live-plugin-prepare_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreLoadRuntime.kt */
public final class PreLoadRuntime {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final PreLoadRuntime sInstance = new PreLoadRuntime();
    private PreLoadHelper preLoadHelper;

    private PreLoadRuntime() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/live/plugin/prepare/PreLoadRuntime$Companion;", "", "()V", "sInstance", "Lcom/baidu/live/plugin/prepare/PreLoadRuntime;", "getInstance", "lib-live-plugin-prepare_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PreLoadRuntime.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PreLoadRuntime getInstance() {
            return PreLoadRuntime.sInstance;
        }
    }

    public final void setPreLoadHelper(PreLoadHelper helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        this.preLoadHelper = helper;
    }

    public final PreLoadHelper getPreLoadHelper() {
        return this.preLoadHelper;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/live/plugin/prepare/PreLoadRuntime$InstallMediaPluginCallback;", "", "onInstallResult", "", "code", "", "Companion", "lib-live-plugin-prepare_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PreLoadRuntime.kt */
    public interface InstallMediaPluginCallback {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int INSTALL_SUCCESS = 41;

        void onInstallResult(int i2);

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/live/plugin/prepare/PreLoadRuntime$InstallMediaPluginCallback$Companion;", "", "()V", "INSTALL_SUCCESS", "", "lib-live-plugin-prepare_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PreLoadRuntime.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int INSTALL_SUCCESS = 41;

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000f"}, d2 = {"Lcom/baidu/live/plugin/prepare/PreLoadRuntime$PreLoadHelper;", "", "getFirstPluginType", "", "getNpsRequestStateStr", "", "isNpsRequestError", "", "isNpsRequestInProgress", "isNpsRequestSuccess", "preInstallMediaPlugin", "", "callback", "Lcom/baidu/live/plugin/prepare/PreLoadRuntime$InstallMediaPluginCallback;", "Companion", "lib-live-plugin-prepare_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PreLoadRuntime.kt */
    public interface PreLoadHelper {
        public static final Companion Companion = Companion.$$INSTANCE;

        int getFirstPluginType();

        String getNpsRequestStateStr();

        boolean isNpsRequestError();

        boolean isNpsRequestInProgress();

        boolean isNpsRequestSuccess();

        void preInstallMediaPlugin(InstallMediaPluginCallback installMediaPluginCallback);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/live/plugin/prepare/PreLoadRuntime$PreLoadHelper$Companion;", "", "()V", "CONFIG_TYPE_DEF", "", "getCONFIG_TYPE_DEF", "()I", "setCONFIG_TYPE_DEF", "(I)V", "CONFIG_TYPE_DOWNLOAD", "getCONFIG_TYPE_DOWNLOAD", "setCONFIG_TYPE_DOWNLOAD", "CONFIG_TYPE_INSTALL", "getCONFIG_TYPE_INSTALL", "setCONFIG_TYPE_INSTALL", "CONFIG_TYPE_PRESET", "getCONFIG_TYPE_PRESET", "setCONFIG_TYPE_PRESET", "lib-live-plugin-prepare_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PreLoadRuntime.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static int CONFIG_TYPE_DEF;
            private static int CONFIG_TYPE_DOWNLOAD = 3;
            private static int CONFIG_TYPE_INSTALL = 2;
            private static int CONFIG_TYPE_PRESET = 1;

            private Companion() {
            }

            public final int getCONFIG_TYPE_DEF() {
                return CONFIG_TYPE_DEF;
            }

            public final void setCONFIG_TYPE_DEF(int i2) {
                CONFIG_TYPE_DEF = i2;
            }

            public final int getCONFIG_TYPE_PRESET() {
                return CONFIG_TYPE_PRESET;
            }

            public final void setCONFIG_TYPE_PRESET(int i2) {
                CONFIG_TYPE_PRESET = i2;
            }

            public final int getCONFIG_TYPE_INSTALL() {
                return CONFIG_TYPE_INSTALL;
            }

            public final void setCONFIG_TYPE_INSTALL(int i2) {
                CONFIG_TYPE_INSTALL = i2;
            }

            public final int getCONFIG_TYPE_DOWNLOAD() {
                return CONFIG_TYPE_DOWNLOAD;
            }

            public final void setCONFIG_TYPE_DOWNLOAD(int i2) {
                CONFIG_TYPE_DOWNLOAD = i2;
            }
        }
    }
}
