package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;

public class ApplyCardEntrance implements NoProguard, Serializable {
    public String desc;
    public String image;
    public String jump_url;
    public String size;

    public float getHeightToWidthRatio() {
        if (TextUtils.isEmpty(this.size)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(this.size);
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }
}
