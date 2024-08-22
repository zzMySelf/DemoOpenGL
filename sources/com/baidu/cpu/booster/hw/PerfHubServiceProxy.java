package com.baidu.cpu.booster.hw;

import android.content.Context;
import com.baidu.cpu.booster.BoosterConstants;
import com.baidu.cpu.booster.stats.CpuStatsUtils;
import com.baidu.swan.hide.api.bypass.utils.ReflectUtils;
import java.lang.reflect.Method;

class PerfHubServiceProxy implements BoosterConstants {
    private static final String PERF_HUB_CLASS = "com.hisi.perfhub.PerfHub";
    private static final String PERF_HUB_METHOD = "perfEvent";
    private Object mPerf;
    private Method mPerfMethod;

    private PerfHubServiceProxy(Class<?> service) {
        if (service != null) {
            try {
                this.mPerf = ReflectUtils.newInstance(service);
                Method method = ReflectUtils.getMethod(service, PERF_HUB_METHOD, Integer.TYPE, String.class, int[].class);
                this.mPerfMethod = method;
                if (method != null) {
                    method.setAccessible(true);
                }
            } catch (Throwable t) {
                CpuStatsUtils.exceptionHandler("PerfHubServiceProxy: message = " + t.getMessage(), t);
            }
        }
    }

    public int perfEvent(int eventId, String pkgName, int... payload) {
        int i2 = -1;
        if (!initOk()) {
            return -1;
        }
        try {
            Object retVal = this.mPerfMethod.invoke(this.mPerf, new Object[]{Integer.valueOf(eventId), pkgName, payload});
            if (retVal != null) {
                i2 = ((Integer) retVal).intValue();
            }
            return i2;
        } catch (Throwable t) {
            CpuStatsUtils.exceptionHandler("perfEvent: message = " + t.getMessage(), t);
            return -1;
        }
    }

    public boolean initOk() {
        return (this.mPerf == null || this.mPerfMethod == null) ? false : true;
    }

    public static PerfHubServiceProxy getProxy(Context context) {
        Class<?> clazz = null;
        try {
            clazz = ReflectUtils.forName(PERF_HUB_CLASS, true);
        } catch (Throwable t) {
            CpuStatsUtils.exceptionHandler("getProxy: message = " + t.getMessage(), t);
        }
        return new PerfHubServiceProxy(clazz);
    }
}
