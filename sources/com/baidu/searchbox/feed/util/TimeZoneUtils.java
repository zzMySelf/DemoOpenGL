package com.baidu.searchbox.feed.util;

import android.content.Context;
import android.provider.Settings;
import com.baidu.android.util.devices.DeviceUtils;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/util/TimeZoneUtils;", "", "()V", "getTimeZoneId", "", "getTimeZoneInfo", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "isTimeZoneAutomatic", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeZoneUtils.kt */
public final class TimeZoneUtils {
    public static final TimeZoneUtils INSTANCE = new TimeZoneUtils();

    private TimeZoneUtils() {
    }

    @JvmStatic
    public static final String getTimeZoneId() {
        return TimeZone.getDefault().getID();
    }

    @JvmStatic
    public static final boolean isTimeZoneAutomatic(Context context) {
        Object obj;
        if (context == null) {
            return false;
        }
        TimeZoneUtils timeZoneUtils = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            boolean z = true;
            if (!DeviceUtils.OSInfo.hasJellyBeanMR1()) {
                z = false;
            } else if (Settings.Global.getInt(context.getContentResolver(), "auto_time_zone") != 1) {
                z = false;
            }
            obj = Result.m8971constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final JSONObject getTimeZoneInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getTimeZoneInfo_u24lambda_u2d1 = jSONObject;
        try {
            $this$getTimeZoneInfo_u24lambda_u2d1.put("timezone_id", getTimeZoneId());
            $this$getTimeZoneInfo_u24lambda_u2d1.put("is_auto", isTimeZoneAutomatic(context) ? "1" : "0");
        } catch (Exception e$iv) {
            Exception exc = e$iv;
        }
        return jSONObject;
    }
}
