package com.baidu.searchbox.common.security;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.apollon.heartbeat.a;
import com.baidu.searchbox.common.security.IDeviceInfoAppHost;
import com.baidu.searchbox.common.security.IDeviceInfoService;
import fe.fe.ddd.i.ad.de;
import fe.fe.ddd.i.ad.fe;
import fe.fe.ddd.i.ad.rg;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001xB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010@\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020DH\u0002J\u001e\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\b\u0010J\u001a\u00020KH\u0003J\r\u0010L\u001a\u00020\u001bH\u0000¢\u0006\u0002\bMJ&\u0010N\u001a\u0002022\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\nJ0\u0010N\u001a\u0002022\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\u0004J\u0010\u0010Q\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\u001cH\u0002J\u001e\u0010S\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u001e\u0010T\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ(\u0010T\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u00020\u0004J\u0010\u0010U\u001a\u00020V2\u0006\u0010G\u001a\u00020\u001bH\u0002J\u001e\u0010W\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u0016\u0010X\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u0016\u0010Y\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u0016\u0010Z\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u001e\u0010[\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ(\u0010[\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u00020\u0004J\u0016\u0010\\\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u000e\u0010]\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u001bJ\u0010\u0010^\u001a\u00020_2\b\b\u0002\u0010O\u001a\u00020\nJ\u0012\u0010`\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010b\u001a\u00020_2\u0006\u0010O\u001a\u00020\nH\u0002J\u0016\u0010c\u001a\u00020_2\u0006\u0010d\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020\u0004J \u0010f\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J \u0010g\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J \u0010h\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J \u0010i\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u0018\u0010j\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u000e\u0010k\u001a\u00020_2\u0006\u0010G\u001a\u00020\u001bJ\u0018\u0010l\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u0018\u0010m\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J \u0010n\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u0018\u0010o\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u0010\u0010p\u001a\u00020_2\u0006\u0010G\u001a\u00020\u001bH\u0002J\u0010\u0010q\u001a\u00020_2\u0006\u0010G\u001a\u00020\u001bH\u0002J\u0016\u0010r\u001a\u00020_2\u0006\u0010d\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020\u0004J\u0010\u0010s\u001a\u00020\u00042\u0006\u0010t\u001a\u00020uH\u0002J\u0010\u0010v\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\nH\u0002J\b\u0010w\u001a\u00020_H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u00020\u00068\u0002X\u0004¢\u0006\n\n\u0002\u0010\b\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nXT¢\u0006\u0002\n\u0000R4\u0010\u0018\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a0\u00198\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0002R\u000e\u0010\u001f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceInfoManager;", "", "()V", "DEBUG", "", "DEFAULT_APP_HOST", "com/baidu/searchbox/common/security/DeviceInfoManager$DEFAULT_APP_HOST$1", "getDEFAULT_APP_HOST$annotations", "Lcom/baidu/searchbox/common/security/DeviceInfoManager$DEFAULT_APP_HOST$1;", "DEFAULT_PHONE_TYPE", "", "DEVICE_ALL", "DEVICE_ANDROID_ID", "DEVICE_FLAG_BIT_NUM", "DEVICE_HARMONY_VERSION", "DEVICE_IMEI", "DEVICE_MAC", "DEVICE_MANUFACTURER", "DEVICE_MODEL", "DEVICE_NONE", "DEVICE_NON_SENSITIVE", "DEVICE_OAID", "DEVICE_OPERATOR", "DEVICE_OS_VERSION", "DEVICE_READ_FUNC_MAP", "Landroid/util/SparseArray;", "Lkotlin/Function3;", "Landroid/content/Context;", "", "Lcom/baidu/searchbox/common/security/DeviceIdBag;", "getDEVICE_READ_FUNC_MAP$annotations", "DEVICE_VALUABLE", "ERRNO", "ERRNO_SUCCESS", "GZIP_HEAD_1", "", "GZIP_HEAD_2", "HTTP_STATUS_OK", "MAPPING_CACHE_FILE", "MAPPING_URL", "PURPOSE_LAUNCH_SYNC", "SCENE_LAUNCH", "SDK_DIR", "SP_FILE", "SP_KEY_FORCE_SYNC_CACHE_TIME", "SP_KEY_LAUNCH_SYNC_DONE", "SYNC_JSON_KEY_TIME", "TAG", "mContext", "mDeviceInfoMap", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "mHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", "mInit", "mLaunchSyncStarted", "mMappingCache", "Lcom/baidu/searchbox/common/security/CacheDeviceInfo;", "mMappingCacheFile", "Ljava/io/File;", "mPhoneTypeWhenReadIMEI", "mPhoneTypeWhenReadOperator", "mSyncingDeviceFlag", "checkIPCService", "ipcService", "Lcom/baidu/searchbox/common/security/IDeviceInfoService;", "gZip", "", "data", "getAndroidId", "context", "scene", "purpose", "getAppHost", "Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost;", "getContext", "getContext$lib_security_framework_release", "getDeviceInfo", "deviceFlag", "forceApi", "getEncodeValue", "value", "getHarmonyVersion", "getIMEI", "getLastForceSyncCacheTime", "", "getMacAddress", "getManufacturer", "getModel", "getOAID", "getOperator", "getOsVersion", "hasLaunchMappingDone", "init", "", "isCuidChanged", "cacheDeviceInfo", "postSyncTask", "preInit", "appContext", "needSupportMultiProcess", "readAndroidId", "readHarmonyVersion", "readIMEI", "readMac", "readManufacturer", "readMappingCache", "readModel", "readOAID", "readOperator", "readOsVersion", "saveForceSyncCacheTime", "saveLaunchMappingDone", "setContextAndIPC", "syncMapping", "infoJson", "Lorg/json/JSONObject;", "syncMappingOfFixedDeviceFlag", "writeMappingCache", "SyncTask", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeviceInfoManager {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final SparseArray<Function3<Context, String, String, DeviceIdBag>> f1007ad;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f1008de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public static fe.fe.ddd.i.ad.ad f1009fe;

    /* renamed from: i  reason: collision with root package name */
    public static int f1010i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public static final qw f13if = new qw();
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public static Handler f1011o;

    /* renamed from: pf  reason: collision with root package name */
    public static Context f1012pf;
    @NotNull
    public static final DeviceInfoManager qw = new DeviceInfoManager();

    /* renamed from: rg  reason: collision with root package name */
    public static File f1013rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public static DeviceIdBagMap f1014th = new DeviceIdBagMap();

    /* renamed from: uk  reason: collision with root package name */
    public static int f1015uk;

    /* renamed from: yj  reason: collision with root package name */
    public static int f1016yj;

    public static final class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final int f1017ad;

        public ad(int i2) {
            this.f1017ad = i2;
        }

        public void run() {
            if (DeviceInfoManager.f1008de) {
                boolean unused = DeviceInfoManager.qw.t(this.f1017ad);
            }
        }
    }

    public static final class qw implements IDeviceInfoAppHost {
        public boolean ad() {
            return IDeviceInfoAppHost.qw.rg(this);
        }

        @NotNull
        public String de() {
            return IDeviceInfoAppHost.qw.fe(this);
        }

        @NotNull
        public String getAppName() {
            return IDeviceInfoAppHost.qw.qw(this);
        }

        @NotNull
        public IDeviceInfoAppHost.ad getOAID() {
            return IDeviceInfoAppHost.qw.de(this);
        }

        @NotNull
        public String qw() {
            return IDeviceInfoAppHost.qw.ad(this);
        }
    }

    static {
        SparseArray<Function3<Context, String, String, DeviceIdBag>> sparseArray = new SparseArray<>();
        sparseArray.put(1, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$1.INSTANCE);
        sparseArray.put(2, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$2.INSTANCE);
        sparseArray.put(4, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$3.INSTANCE);
        sparseArray.put(8, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$4.INSTANCE);
        sparseArray.put(16, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$5.INSTANCE);
        sparseArray.put(32, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$6.INSTANCE);
        sparseArray.put(64, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$7.INSTANCE);
        sparseArray.put(128, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8.INSTANCE);
        sparseArray.put(256, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$9.INSTANCE);
        f1007ad = sparseArray;
        new HandlerThread("DeviceInfoManager");
    }

    @NotNull
    public final DeviceIdBag a(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    DeviceIdBag manufacturer = qw2.getManufacturer(str, str2);
                    Intrinsics.checkNotNullExpressionValue(manufacturer, "ipcService!!.getManufacturer(scene, purpose)");
                    return manufacturer;
                } catch (Exception unused) {
                }
            }
            DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) 256);
            return deviceIdBag == null ? m(str, str2) : deviceIdBag;
        }
        DeviceIdBag deviceIdBag2 = (DeviceIdBag) f1014th.get((Object) 256);
        if (deviceIdBag2 == null) {
            deviceIdBag2 = m(str, str2);
        }
        Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_MA…ufacturer(scene, purpose)");
        if (deviceIdBag2.errorCode == 0) {
            g(256);
        }
        return deviceIdBag2;
    }

    @NotNull
    public final DeviceIdBagMap aaa(@NotNull Context context, @NotNull String str, @NotNull String str2, int i2, boolean z) {
        String str3 = str;
        String str4 = str2;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str3, "scene");
        Intrinsics.checkNotNullParameter(str4, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    try {
                        DeviceIdBagMap deviceInfos = qw2.getDeviceInfos(str3, str4, i2, z);
                        Intrinsics.checkNotNullExpressionValue(deviceInfos, "ipcService!!.getDeviceIn…se, deviceFlag, forceApi)");
                        return deviceInfos;
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                }
            }
            int i3 = i2;
            boolean z2 = z;
            DeviceIdBagMap deviceIdBagMap = new DeviceIdBagMap();
            DeviceInfoUtilKt.de(new DeviceInfoManager$getDeviceInfo$1$1(i2, z, deviceIdBagMap, context, str, str2));
            return deviceIdBagMap;
        }
        boolean ad2 = ddd().ad();
        DeviceIdBagMap deviceIdBagMap2 = new DeviceIdBagMap();
        Ref.IntRef intRef = new Ref.IntRef();
        DeviceInfoUtilKt.de(new DeviceInfoManager$getDeviceInfo$result$1$1(i2, new Ref.ObjectRef(), z, context, str, str2, ad2, intRef, deviceIdBagMap2));
        int i4 = intRef.element;
        if (i4 != 0) {
            qw.g(i4);
        }
        return deviceIdBagMap2;
    }

    @NotNull
    public final DeviceIdBag b(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    DeviceIdBag model = qw2.getModel(str, str2);
                    Intrinsics.checkNotNullExpressionValue(model, "ipcService!!.getModel(scene, purpose)");
                    return model;
                } catch (Exception unused) {
                }
            }
            DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) 16);
            return deviceIdBag == null ? n(str, str2) : deviceIdBag;
        }
        DeviceIdBag deviceIdBag2 = (DeviceIdBag) f1014th.get((Object) 16);
        if (deviceIdBag2 == null) {
            deviceIdBag2 = n(str, str2);
        }
        Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_MO…readModel(scene, purpose)");
        if (deviceIdBag2.errorCode == 0) {
            g(16);
        }
        return deviceIdBag2;
    }

    @NotNull
    public final DeviceIdBag c(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    DeviceIdBag oaid = qw2.getOAID(str, str2);
                    Intrinsics.checkNotNullExpressionValue(oaid, "ipcService!!.getOAID(scene, purpose)");
                    return oaid;
                } catch (Exception unused) {
                }
            }
            DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) 8);
            return deviceIdBag == null ? p(str, str2) : deviceIdBag;
        }
        DeviceIdBag deviceIdBag2 = (DeviceIdBag) f1014th.get((Object) 8);
        if (deviceIdBag2 == null) {
            deviceIdBag2 = p(str, str2);
        }
        Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_OA… readOAID(scene, purpose)");
        if (deviceIdBag2.errorCode == 0) {
            g(8);
        }
        return deviceIdBag2;
    }

    @NotNull
    public final DeviceIdBag d(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        return e(context, str, str2, false);
    }

    public final IDeviceInfoAppHost ddd() {
        return f13if;
    }

    @NotNull
    public final DeviceIdBag e(@NotNull Context context, @NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    DeviceIdBag operator = qw2.getOperator(str, str2, z);
                    Intrinsics.checkNotNullExpressionValue(operator, "ipcService!!.getOperator(scene, purpose, forceApi)");
                    return operator;
                } catch (Exception unused) {
                }
            }
            DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) 64);
            return (z || deviceIdBag == null) ? q(context, str, str2) : deviceIdBag;
        }
        DeviceIdBag deviceIdBag2 = (DeviceIdBag) f1014th.get((Object) 64);
        int i2 = 0;
        try {
            Object systemService = context.getSystemService("phone");
            if (systemService != null) {
                i2 = ((TelephonyManager) systemService).getPhoneType();
                if (z || deviceIdBag2 == null || f1015uk != i2) {
                    deviceIdBag2 = q(context, str, str2);
                }
                if (deviceIdBag2.errorCode == 0) {
                    g(64);
                }
                return deviceIdBag2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception unused2) {
        }
    }

    @NotNull
    public final DeviceIdBag eee(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    DeviceIdBag harmonyVersion = qw2.getHarmonyVersion(str, str2);
                    Intrinsics.checkNotNullExpressionValue(harmonyVersion, "ipcService!!.getHarmonyVersion(scene, purpose)");
                    return harmonyVersion;
                } catch (Exception unused) {
                }
            }
            DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) 128);
            return deviceIdBag == null ? j(context, str, str2) : deviceIdBag;
        }
        DeviceIdBag deviceIdBag2 = (DeviceIdBag) f1014th.get((Object) 128);
        if (deviceIdBag2 == null) {
            deviceIdBag2 = j(context, str, str2);
        }
        Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_HA…(context, scene, purpose)");
        if (deviceIdBag2.errorCode == 0) {
            g(128);
        }
        return deviceIdBag2;
    }

    @NotNull
    public final DeviceIdBag f(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    DeviceIdBag osVersion = qw2.getOsVersion(str, str2);
                    Intrinsics.checkNotNullExpressionValue(osVersion, "ipcService!!.getOsVersion(scene, purpose)");
                    return osVersion;
                } catch (Exception unused) {
                }
            }
            DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) 32);
            return deviceIdBag == null ? r(str, str2) : deviceIdBag;
        }
        DeviceIdBag deviceIdBag2 = (DeviceIdBag) f1014th.get((Object) 32);
        if (deviceIdBag2 == null) {
            deviceIdBag2 = r(str, str2);
        }
        Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_OS…OsVersion(scene, purpose)");
        if (deviceIdBag2.errorCode == 0) {
            g(32);
        }
        return deviceIdBag2;
    }

    public final void g(int i2) {
        Handler handler;
        if (((~f1010i) & i2) != 0 && (handler = f1011o) != null) {
            handler.post(new ad(i2));
        }
    }

    public final boolean ggg(IDeviceInfoService iDeviceInfoService) {
        return iDeviceInfoService != null && !(iDeviceInfoService instanceof IDeviceInfoService.Stub);
    }

    public final DeviceIdBag h(Context context, String str, String str2) {
        DeviceIdBag qw2 = fe.fe.ddd.i.ad.qw.qw(context);
        int i2 = qw2.errorCode;
        if (!(i2 == -3 || i2 == -1)) {
            DeviceIdBagMap deviceIdBagMap = f1014th;
            Intrinsics.checkNotNullExpressionValue(qw2, "this");
            deviceIdBagMap.put(4, qw2);
            if (qw.ddd().ad() && DeviceInfoUtilKt.rg(f1009fe, 4, qw2.deviceId)) {
                qw2.errorCode = 3;
            }
        }
        Intrinsics.checkNotNullExpressionValue(qw2, "getAndroidId(context).ap…}\n            }\n        }");
        return qw2;
    }

    public final DeviceIdBag j(Context context, String str, String str2) {
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        f1014th.put(128, deviceIdBag);
        int i2 = 2;
        if (DeviceUtils.isHarmonyOS(context)) {
            String harmonyVersion = DeviceUtils.getHarmonyVersion();
            deviceIdBag.deviceId = harmonyVersion;
            if (!TextUtils.isEmpty(harmonyVersion)) {
                i2 = (!qw.ddd().ad() || !DeviceInfoUtilKt.rg(f1009fe, 128, deviceIdBag.deviceId)) ? 0 : 3;
            }
            deviceIdBag.errorCode = i2;
        } else {
            deviceIdBag.errorCode = 2;
        }
        return deviceIdBag;
    }

    public final DeviceIdBag k(Context context, String str, String str2) {
        DeviceIdBag ad2 = fe.ad(context, false, true);
        int i2 = ad2.errorCode;
        if (!(i2 == -3 || i2 == -2 || i2 == -1)) {
            DeviceIdBagMap deviceIdBagMap = f1014th;
            Intrinsics.checkNotNullExpressionValue(ad2, "this");
            deviceIdBagMap.put(2, ad2);
            if (qw.ddd().ad() && DeviceInfoUtilKt.rg(f1009fe, 2, ad2.deviceId)) {
                ad2.errorCode = 3;
            }
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService != null) {
                    f1016yj = ((TelephonyManager) systemService).getPhoneType();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                }
            } catch (Exception unused) {
            }
        }
        Intrinsics.checkNotNullExpressionValue(ad2, "getImei(context, false, …}\n            }\n        }");
        return ad2;
    }

    public final DeviceIdBag l(Context context, String str, String str2) {
        DeviceIdBag ad2 = rg.ad(context);
        int i2 = ad2.errorCode;
        if (!(i2 == -3 || i2 == -1)) {
            DeviceIdBagMap deviceIdBagMap = f1014th;
            Intrinsics.checkNotNullExpressionValue(ad2, "this");
            deviceIdBagMap.put(1, ad2);
            if (qw.ddd().ad() && DeviceInfoUtilKt.rg(f1009fe, 1, ad2.deviceId)) {
                ad2.errorCode = 3;
            }
        }
        Intrinsics.checkNotNullExpressionValue(ad2, "getHardwareAddress(conte…}\n            }\n        }");
        return ad2;
    }

    public final DeviceIdBag m(String str, String str2) {
        int i2;
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        f1014th.put(256, deviceIdBag);
        String str3 = Build.MANUFACTURER;
        deviceIdBag.deviceId = str3;
        if (TextUtils.isEmpty(str3)) {
            i2 = 2;
        } else {
            i2 = (!qw.ddd().ad() || !DeviceInfoUtilKt.rg(f1009fe, 256, deviceIdBag.deviceId)) ? 0 : 3;
        }
        deviceIdBag.errorCode = i2;
        return deviceIdBag;
    }

    @NotNull
    public final DeviceIdBagMap mmm(@NotNull Context context, @NotNull String str, @NotNull String str2, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        return aaa(context, str, str2, i2, false);
    }

    public final DeviceIdBag n(String str, String str2) {
        int i2;
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        f1014th.put(16, deviceIdBag);
        String str3 = Build.MODEL;
        deviceIdBag.deviceId = str3;
        if (TextUtils.isEmpty(str3)) {
            i2 = 2;
        } else {
            i2 = (!qw.ddd().ad() || !DeviceInfoUtilKt.rg(f1009fe, 16, deviceIdBag.deviceId)) ? 0 : 3;
        }
        deviceIdBag.errorCode = i2;
        return deviceIdBag;
    }

    @NotNull
    public final Context nn() {
        Context context = f1012pf;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    }

    public final DeviceIdBag p(String str, String str2) {
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        IDeviceInfoAppHost.ad oaid = qw.ddd().getOAID();
        int i2 = 2;
        if (oaid.ad()) {
            f1014th.put(8, deviceIdBag);
            deviceIdBag.deviceId = oaid.de();
            deviceIdBag.encodedDeviceId = oaid.qw();
            if (!TextUtils.isEmpty(deviceIdBag.deviceId)) {
                i2 = (!qw.ddd().ad() || !DeviceInfoUtilKt.rg(f1009fe, 8, deviceIdBag.deviceId)) ? 0 : 3;
            }
            deviceIdBag.errorCode = i2;
        } else {
            deviceIdBag.errorCode = 2;
        }
        return deviceIdBag;
    }

    public final DeviceIdBag q(Context context, String str, String str2) {
        int i2;
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        try {
            Object systemService = context.getSystemService("phone");
            if (systemService != null) {
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                deviceIdBag.deviceId = telephonyManager.getSimOperator();
                f1014th.put(64, deviceIdBag);
                f1015uk = telephonyManager.getPhoneType();
                if (TextUtils.isEmpty(deviceIdBag.deviceId)) {
                    i2 = 2;
                } else {
                    i2 = (!qw.ddd().ad() || !DeviceInfoUtilKt.rg(f1009fe, 64, deviceIdBag.deviceId)) ? 0 : 3;
                }
                deviceIdBag.errorCode = i2;
                return deviceIdBag;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception unused) {
        }
    }

    public final String qqq(String str) {
        try {
            String encode = URLEncoder.encode(str, a.h);
            Intrinsics.checkNotNullExpressionValue(encode, "encode(value, \"utf-8\")");
            return encode;
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public final DeviceIdBag r(String str, String str2) {
        int i2;
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        f1014th.put(32, deviceIdBag);
        String str3 = Build.VERSION.RELEASE;
        deviceIdBag.deviceId = str3;
        if (TextUtils.isEmpty(str3)) {
            i2 = 2;
        } else {
            i2 = (!qw.ddd().ad() || !DeviceInfoUtilKt.rg(f1009fe, 32, deviceIdBag.deviceId)) ? 0 : 3;
        }
        deviceIdBag.errorCode = i2;
        return deviceIdBag;
    }

    @NotNull
    public final DeviceIdBag rrr(@NotNull Context context, @NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    DeviceIdBag imei = qw2.getIMEI(str, str2, z);
                    Intrinsics.checkNotNullExpressionValue(imei, "ipcService!!.getIMEI(scene, purpose, forceApi)");
                    return imei;
                } catch (Exception unused) {
                }
            }
            DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) 2);
            return (z || deviceIdBag == null) ? k(context, str, str2) : deviceIdBag;
        }
        DeviceIdBag deviceIdBag2 = (DeviceIdBag) f1014th.get((Object) 2);
        int i2 = 0;
        try {
            Object systemService = context.getSystemService("phone");
            if (systemService != null) {
                i2 = ((TelephonyManager) systemService).getPhoneType();
                if (z || deviceIdBag2 == null || f1016yj != i2) {
                    deviceIdBag2 = k(context, str, str2);
                }
                if (ddd().ad() && deviceIdBag2.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag2.deviceId)) {
                    g(2);
                }
                return deviceIdBag2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception unused2) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f2, code lost:
        if (r2 != null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0107, code lost:
        if (r2 == null) goto L_0x010a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean s(org.json.JSONObject r6) {
        /*
            r5 = this;
            int r0 = r6.length()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            com.baidu.searchbox.common.security.IDeviceInfoAppHost r0 = r5.ddd()
            com.baidu.searchbox.common.security.DeviceInfoManager$qw r2 = f13if
            if (r0 != r2) goto L_0x0011
            return r1
        L_0x0011:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "https://mbd.baidu.com/mapping/update?appname="
            r2.append(r3)
            java.lang.String r3 = r0.getAppName()
            java.lang.String r3 = r5.qqq(r3)
            r2.append(r3)
            java.lang.String r3 = "&ua="
            r2.append(r3)
            java.lang.String r3 = r0.de()
            java.lang.String r3 = r5.qqq(r3)
            r2.append(r3)
            java.lang.String r3 = "&uid="
            r2.append(r3)
            java.lang.String r0 = r0.qw()
            java.lang.String r0 = r5.qqq(r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "j"
            r6.put(r3, r2)
            java.lang.String r6 = r6.toString()
            java.lang.String r2 = "infoJson.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            byte[] r6 = r6.getBytes(r2)
            java.lang.String r2 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            byte[] r6 = r5.vvv(r6)
            if (r6 == 0) goto L_0x010a
            int r2 = r6.length
            r3 = 2
            if (r2 >= r3) goto L_0x0077
            goto L_0x010a
        L_0x0077:
            r2 = 117(0x75, float:1.64E-43)
            r6[r1] = r2
            r2 = 123(0x7b, float:1.72E-43)
            r3 = 1
            r6[r3] = r2
            r2 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.net.URLConnection r0 = r4.openConnection()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            if (r0 == 0) goto L_0x00f8
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.String r4 = "POST"
            r0.setRequestMethod(r4)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r0.setDoOutput(r3)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r0.setDoInput(r3)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r0.setUseCaches(r1)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r2.write(r6)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r2.flush()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            int r6 = r0.getResponseCode()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r6 != r4) goto L_0x00f2
            java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.String r0 = "connection.inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r0 = 8192(0x2000, float:1.14794E-41)
            boolean r4 = r6 instanceof java.io.BufferedInputStream     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            if (r4 == 0) goto L_0x00c0
            java.io.BufferedInputStream r6 = (java.io.BufferedInputStream) r6     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            goto L_0x00c6
        L_0x00c0:
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r4.<init>(r6, r0)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r6 = r4
        L_0x00c6:
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r4.<init>(r6, r0)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.String r6 = kotlin.io.TextStreamsKt.readText(r4)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            if (r0 != 0) goto L_0x00f2
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r0.<init>(r6)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.String r6 = "errno"
            java.lang.String r4 = ""
            java.lang.String r6 = r0.optString(r6, r4)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.String r0 = "0"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            if (r6 == 0) goto L_0x00f2
            if (r2 == 0) goto L_0x00f1
            r2.close()     // Catch:{ Exception -> 0x00f1 }
        L_0x00f1:
            return r3
        L_0x00f2:
            if (r2 == 0) goto L_0x010a
        L_0x00f4:
            r2.close()     // Catch:{ Exception -> 0x010a }
            goto L_0x010a
        L_0x00f8:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.String r0 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r6.<init>(r0)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            throw r6     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
        L_0x0100:
            r6 = move-exception
            if (r2 == 0) goto L_0x0106
            r2.close()     // Catch:{ Exception -> 0x0106 }
        L_0x0106:
            throw r6
        L_0x0107:
            if (r2 == 0) goto L_0x010a
            goto L_0x00f4
        L_0x010a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.common.security.DeviceInfoManager.s(org.json.JSONObject):boolean");
    }

    public final boolean t(int i2) {
        if (f1010i == 0 && f1008de && i2 != 0) {
            try {
                f1010i = i2;
                ArrayList<Number> arrayList = new ArrayList<>();
                if (s(DeviceInfoUtilKt.th(f1014th, i2, arrayList))) {
                    if (f1009fe == null) {
                        fe.fe.ddd.i.ad.ad adVar = new fe.fe.ddd.i.ad.ad();
                        f1009fe = adVar;
                        Intrinsics.checkNotNull(adVar);
                        adVar.de(ddd().qw());
                    }
                    Ref.IntRef intRef = new Ref.IntRef();
                    for (Number intValue : arrayList) {
                        int intValue2 = intValue.intValue();
                        intRef.element |= intValue2;
                        DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) Integer.valueOf(intValue2));
                        if (deviceIdBag != null) {
                            deviceIdBag.errorCode = 3;
                        }
                    }
                    DeviceIdBagMap deviceIdBagMap = f1014th;
                    fe.fe.ddd.i.ad.ad adVar2 = f1009fe;
                    Intrinsics.checkNotNull(adVar2);
                    DeviceInfoUtilKt.qw(deviceIdBagMap, adVar2, intRef.element);
                    u();
                    f1010i = 0;
                    return true;
                }
            } catch (Exception unused) {
            } catch (Throwable th2) {
                f1010i = 0;
                throw th2;
            }
            f1010i = 0;
        }
        return false;
    }

    @NotNull
    public final DeviceIdBag tt(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    DeviceIdBag macAddress = qw2.getMacAddress(str, str2);
                    Intrinsics.checkNotNullExpressionValue(macAddress, "ipcService!!.getMacAddress(scene, purpose)");
                    return macAddress;
                } catch (Exception unused) {
                }
            }
            DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) 1);
            return deviceIdBag == null ? l(context, str, str2) : deviceIdBag;
        }
        DeviceIdBag deviceIdBag2 = (DeviceIdBag) f1014th.get((Object) 1);
        if (deviceIdBag2 == null) {
            deviceIdBag2 = l(context, str, str2);
        }
        Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_MA…(context, scene, purpose)");
        if (ddd().ad() && deviceIdBag2.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag2.deviceId)) {
            g(1);
        }
        return deviceIdBag2;
    }

    public final void u() {
        File file = f1013rg;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
            file = null;
        }
        if (file.exists()) {
            File file2 = f1013rg;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                file2 = null;
            }
            file2.delete();
        }
        File file3 = f1013rg;
        if (file3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
            file3 = null;
        }
        file3.createNewFile();
        File file4 = f1013rg;
        if (file4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
            file4 = null;
        }
        FilesKt__FileReadWriteKt.writeText$default(file4, String.valueOf(f1009fe), (Charset) null, 2, (Object) null);
    }

    public final byte[] vvv(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            e.printStackTrace();
            return bArr2;
        }
    }

    @NotNull
    public final DeviceIdBag xxx(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        if (!fe.fe.vvv.ad.qw.qw.yj()) {
            IDeviceInfoService qw2 = de.qw.qw();
            if (ggg(qw2)) {
                try {
                    Intrinsics.checkNotNull(qw2);
                    DeviceIdBag androidId = qw2.getAndroidId(str, str2);
                    Intrinsics.checkNotNullExpressionValue(androidId, "ipcService!!.getAndroidId(scene, purpose)");
                    return androidId;
                } catch (Exception unused) {
                }
            }
            DeviceIdBag deviceIdBag = (DeviceIdBag) f1014th.get((Object) 4);
            return deviceIdBag == null ? h(context, str, str2) : deviceIdBag;
        }
        DeviceIdBag deviceIdBag2 = (DeviceIdBag) f1014th.get((Object) 4);
        if (deviceIdBag2 == null) {
            deviceIdBag2 = h(context, str, str2);
        }
        Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_AN…(context, scene, purpose)");
        if (ddd().ad() && deviceIdBag2.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag2.deviceId)) {
            g(4);
        }
        return deviceIdBag2;
    }
}
