package fe.fe.p007switch.qw;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.dxmpay.CooperService;
import com.baidu.mobstat.dxmpay.ExceptionAnalysis;
import com.baidu.mobstat.dxmpay.SendStrategyEnum;
import com.baidu.mobstat.dxmpay.h;
import com.baidu.mobstat.dxmpay.q;

/* renamed from: fe.fe.switch.qw.uk  reason: invalid package */
public class uk {
    public static void ad(String str) {
        if (str == null || str.equals("")) {
            h.o().uk("[WARNING] The channel you have set is empty");
        }
        CooperService.qqq().uk().f93switch = str;
    }

    public static void de(String str) {
        CooperService.qqq().uk().f3059th = str;
    }

    public static void qw(Context context) {
        SendStrategyEnum sendStrategyEnum = SendStrategyEnum.APP_START;
        try {
            String rg2 = qqq.rg(context, "BaiduMobAd_EXCEPTION_LOG");
            if (!TextUtils.isEmpty(rg2) && "true".equals(rg2)) {
                ExceptionAnalysis.de().fe(context, false);
            }
        } catch (Exception unused) {
        }
        try {
            String rg3 = qqq.rg(context, "BaiduMobAd_SEND_STRATEGY");
            if (!TextUtils.isEmpty(rg3)) {
                if (rg3.equals(SendStrategyEnum.APP_START.name())) {
                    sendStrategyEnum = SendStrategyEnum.APP_START;
                    q.i().o(context, sendStrategyEnum.ordinal());
                } else if (rg3.equals(SendStrategyEnum.ONCE_A_DAY.name())) {
                    sendStrategyEnum = SendStrategyEnum.ONCE_A_DAY;
                    q.i().o(context, sendStrategyEnum.ordinal());
                    q.i().m32switch(context, 24);
                } else if (rg3.equals(SendStrategyEnum.SET_TIME_INTERVAL.name())) {
                    sendStrategyEnum = SendStrategyEnum.SET_TIME_INTERVAL;
                    q.i().o(context, sendStrategyEnum.ordinal());
                }
            }
        } catch (Exception unused2) {
        }
        try {
            String rg4 = qqq.rg(context, "BaiduMobAd_TIME_INTERVAL");
            if (!TextUtils.isEmpty(rg4)) {
                int parseInt = Integer.parseInt(rg4);
                if (sendStrategyEnum.ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal() && parseInt > 0 && parseInt <= 24) {
                    q.i().m32switch(context, parseInt);
                }
            }
        } catch (Exception unused3) {
        }
        try {
            String rg5 = qqq.rg(context, "BaiduMobAd_ONLY_WIFI");
            if (TextUtils.isEmpty(rg5)) {
                return;
            }
            if ("true".equals(rg5)) {
                q.i().pf(context, true);
            } else if ("false".equals(rg5)) {
                q.i().pf(context, false);
            }
        } catch (Exception unused4) {
        }
    }
}
