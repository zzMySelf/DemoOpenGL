package com.dxmpay.wallet.core.domain;

import android.content.Context;

public interface a {
    String getAppHost();

    String getAppPayHost();

    String getBackSensorHost();

    String getInitHost();

    String getRecordHost();

    String getRtcHost();

    String getSensortHost();

    String getSpareInitHost();

    String getZhiFuHost();

    void setDomainConfig(String str);

    void setDxmPayContext(Context context);
}
