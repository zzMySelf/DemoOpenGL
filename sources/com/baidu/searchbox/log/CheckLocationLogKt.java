package com.baidu.searchbox.log;

import android.util.Log;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.location.IPLocationInfo;
import com.baidu.searchbox.location.IPLocationManager;
import com.baidu.searchbox.location.LocationInfo;
import com.baidu.searchbox.ubc.LocationUbcKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006\u001a\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006\u001a\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r\u001a$\u0010\u000e\u001a\u00020\u0001*\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"LOCATION_LOG_INFO", "", "TAG", "YA_LOG_CHANGE_INFO", "YA_LOG_CHECK_INFO", "ipLocation", "Lcom/baidu/searchbox/location/LocationInfo;", "checkLocationForLog", "", "location", "setIpLocationForLog", "setLifecycleChange", "isForeground", "", "yaLog", "ip", "source", "lib-location-business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckLocationLog.kt */
public final class CheckLocationLogKt {
    private static final String LOCATION_LOG_INFO = "%s:%s:%s:%s:%s:%s:%s:%s:%s:%s:%s:%s:%s";
    private static final String TAG = "CheckLocationLog";
    private static final String YA_LOG_CHANGE_INFO = "{%s}:{%s}:{%s}";
    private static final String YA_LOG_CHECK_INFO = "{%s}:{%s}:{%s}:{%s}";
    private static LocationInfo ipLocation;

    public static final void checkLocationForLog(LocationInfo location) {
        Intrinsics.checkNotNullParameter(location, "location");
        ExecutorUtilsExt.postOnSerial(new CheckLocationLogKt$$ExternalSyntheticLambda0(location), "checkLocationLog");
    }

    /* access modifiers changed from: private */
    /* renamed from: checkLocationForLog$lambda-3  reason: not valid java name */
    public static final void m260checkLocationForLog$lambda3(LocationInfo $location) {
        LocationInfo locationInfo;
        String ipYaLog;
        LocationInfo locationInfo2 = $location;
        Intrinsics.checkNotNullParameter(locationInfo2, "$location");
        try {
            Result.Companion companion = Result.Companion;
            NetWorkUtils.NetType networkType = NetWorkUtils.getNetworkType(AppRuntime.getAppContext());
            String type = networkType != null ? networkType.type : null;
            String gpsYaLog = yaLog$default(locationInfo2, (String) null, (String) null, 3, (Object) null);
            String format = String.format(YA_LOG_CHANGE_INFO, Arrays.copyOf(new Object[]{"GPS", gpsYaLog, String.valueOf(type)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LocationYaLogger.INSTANCE.log(LocationYaLoggerKt.YA_LOG_TAG_CHANGE, format);
            LocationInfo locationInfo3 = ipLocation;
            if (locationInfo3 != null) {
                LocationInfo $this$checkLocationForLog_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1 = locationInfo3;
                if (IPLocationManager.INSTANCE.isLocationValid()) {
                    ipLocation = null;
                    if (!(locationInfo2.cityCode == null || $this$checkLocationForLog_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.cityCode == null)) {
                        String str = locationInfo2.cityCode;
                        Intrinsics.checkNotNullExpressionValue(str, "location.cityCode");
                        if (str.length() > 0) {
                            String str2 = $this$checkLocationForLog_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.cityCode;
                            Intrinsics.checkNotNullExpressionValue(str2, "cityCode");
                            if (str2.length() > 0) {
                                String isSame = LocationUbcKt.UBC_LOCATION_CHECK_VALUE_NOT_SAME;
                                if (locationInfo2.cityCode.equals($this$checkLocationForLog_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.cityCode)) {
                                    isSame = "same";
                                }
                                LocationUbcKt.checkLocationUbc(isSame);
                                LocationInfo locationInfo4 = IPLocationManager.INSTANCE.getLocationInfo();
                                IPLocationInfo $this$checkLocationForLog_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = locationInfo4 instanceof IPLocationInfo ? (IPLocationInfo) locationInfo4 : null;
                                if ($this$checkLocationForLog_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 != null) {
                                    ipYaLog = yaLog($this$checkLocationForLog_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0, $this$checkLocationForLog_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.getIp(), $this$checkLocationForLog_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.getSource());
                                } else {
                                    ipYaLog = null;
                                }
                                String format2 = String.format(YA_LOG_CHECK_INFO, Arrays.copyOf(new Object[]{isSame, ipYaLog, gpsYaLog, String.valueOf(type)}, 4));
                                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                                String str3 = format2;
                                LocationYaLogger.INSTANCE.log(LocationYaLoggerKt.YA_LOG_TAG_CHECK, str3);
                                if (AppConfig.isDebug()) {
                                    Log.d(TAG, str3);
                                }
                                String str4 = str3;
                            }
                        }
                    }
                }
                locationInfo = locationInfo3;
            } else {
                locationInfo = null;
            }
            Result.m8971constructorimpl(locationInfo);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public static final void setIpLocationForLog(LocationInfo location) {
        Intrinsics.checkNotNullParameter(location, "location");
        ipLocation = location;
        ExecutorUtilsExt.postOnSerial(new CheckLocationLogKt$$ExternalSyntheticLambda1(location), "setIpLocationForLog");
    }

    /* access modifiers changed from: private */
    /* renamed from: setIpLocationForLog$lambda-6  reason: not valid java name */
    public static final void m261setIpLocationForLog$lambda6(LocationInfo $location) {
        Intrinsics.checkNotNullParameter($location, "$location");
        try {
            Result.Companion companion = Result.Companion;
            NetWorkUtils.NetType networkType = NetWorkUtils.getNetworkType(AppRuntime.getAppContext());
            String ipYaLog = null;
            String type = networkType != null ? networkType.type : null;
            IPLocationInfo iPLocationInfo = $location instanceof IPLocationInfo ? (IPLocationInfo) $location : null;
            if (iPLocationInfo != null) {
                IPLocationInfo $this$setIpLocationForLog_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4 = iPLocationInfo;
                ipYaLog = yaLog($this$setIpLocationForLog_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4, $this$setIpLocationForLog_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4.getIp(), $this$setIpLocationForLog_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4.getSource());
            }
            String message = String.format(YA_LOG_CHANGE_INFO, Arrays.copyOf(new Object[]{"IP", ipYaLog, String.valueOf(type)}, 3));
            Intrinsics.checkNotNullExpressionValue(message, "format(this, *args)");
            LocationYaLogger.INSTANCE.log(LocationYaLoggerKt.YA_LOG_TAG_CHANGE, message);
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public static final void setLifecycleChange(boolean isForeground) {
        if (!isForeground) {
            ExecutorUtilsExt.postOnElastic(new CheckLocationLogKt$$ExternalSyntheticLambda2(), "setLifecycleChange", 2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setLifecycleChange$lambda-8  reason: not valid java name */
    public static final void m262setLifecycleChange$lambda8() {
        try {
            Result.Companion companion = Result.Companion;
            LocationYaLogger.INSTANCE.flush();
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    static /* synthetic */ String yaLog$default(LocationInfo locationInfo, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return yaLog(locationInfo, str, str2);
    }

    private static final String yaLog(LocationInfo $this$yaLog, String ip, String source) {
        String format = String.format(LOCATION_LOG_INFO, Arrays.copyOf(new Object[]{$this$yaLog.country, $this$yaLog.countryCode, $this$yaLog.province, $this$yaLog.city, $this$yaLog.cityCode, $this$yaLog.street, String.valueOf($this$yaLog.longitude), String.valueOf($this$yaLog.latitude), $this$yaLog.coorType, String.valueOf($this$yaLog.time), String.valueOf($this$yaLog.locType), String.valueOf(ip), String.valueOf(source)}, 13));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }
}
