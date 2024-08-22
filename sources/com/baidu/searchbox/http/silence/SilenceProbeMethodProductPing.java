package com.baidu.searchbox.http.silence;

import android.content.Context;
import com.baidu.searchbox.http.silence.SilenceProbeResult;
import com.baidu.searchbox.network.probe.PingProbe;
import com.baidu.searchbox.network.probe.ProbeResult;

class SilenceProbeMethodProductPing implements ISilenceProbeMethodProduct {
    SilenceProbeMethodProductPing() {
    }

    public SilenceProbeResult.TaskBean syncProbe(String url, String ip, String method, Context context, int tcpPort) {
        double d2;
        SilenceProbeResult.TaskBean result = new SilenceProbeResult.TaskBean();
        result.setMethod(method);
        String str = ip;
        PingProbe pingProbe = new PingProbe(ip);
        long startTime = System.currentTimeMillis();
        ProbeResult pingResult = pingProbe.execute();
        long endTime = System.currentTimeMillis();
        result.setSuccess(pingResult == null ? false : pingResult.isSuccess());
        result.setErrorCode(pingResult == null ? -1 : pingResult.getErrCode());
        result.setDetail(pingResult == null ? "" : pingResult.getDetail());
        if (pingResult == null) {
            d2 = 0.0d;
        } else {
            d2 = Double.valueOf(String.format("%.2f", new Object[]{Double.valueOf(pingResult.getPingLossRate())})).doubleValue();
        }
        result.setLossRate(d2);
        if (startTime > 0 && endTime > 0 && endTime >= startTime) {
            result.setDuration(endTime - startTime);
        }
        return result;
    }
}
