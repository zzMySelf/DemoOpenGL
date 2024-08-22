package com.baidu.searchbox.ad.charge;

import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.feed.ad.R;
import java.util.Map;

public class AreaChargeUtil {
    public static String area2Cmd(String area, Map<String, String> areaMap, Map<String, String> cmdMap, String backupCmd) {
        String cmd = null;
        String areaCmdKey = null;
        if (areaMap != null) {
            areaCmdKey = areaMap.get(area);
            if (TextUtils.isEmpty(areaCmdKey)) {
                areaCmdKey = areaMap.get("default");
            }
        }
        if (TextUtils.isEmpty(areaCmdKey)) {
            areaCmdKey = area;
        }
        if (cmdMap != null) {
            cmd = cmdMap.get(areaCmdKey);
        }
        if (TextUtils.equals(cmd, "__CMD_NONE__")) {
            return null;
        }
        if (TextUtils.isEmpty(cmd)) {
            return backupCmd;
        }
        return cmd;
    }

    public static String area2Charge(String area, Map<String, String> areaChargeMap, Map<String, String> chargeMap, String backupCharge) {
        String charge = null;
        String areaChargeKey = null;
        if (areaChargeMap != null) {
            areaChargeKey = areaChargeMap.get(area);
            if (TextUtils.isEmpty(areaChargeKey)) {
                areaChargeKey = areaChargeMap.get("default");
            }
        }
        if (TextUtils.isEmpty(areaChargeKey)) {
            areaChargeKey = area;
        }
        if (chargeMap != null) {
            charge = chargeMap.get(areaChargeKey);
        }
        if (TextUtils.equals(charge, "__CHARGE_URL_NONE__")) {
            return null;
        }
        if (TextUtils.isEmpty(charge)) {
            return backupCharge;
        }
        return charge;
    }

    public static void setAreaTag(View view2, String area) {
        view2.setTag(R.id.ad_charge_area_tag, area);
    }

    public static String getAreaTag(View view2, String defaultArea) {
        Object tag = view2.getTag(R.id.ad_charge_area_tag);
        if (!(tag instanceof String) || TextUtils.isEmpty((String) tag)) {
            return defaultArea;
        }
        return (String) tag;
    }

    public static String getAreaTag(View view2) {
        return getAreaTag(view2, "default");
    }
}
