package com.baidu.wallet.paysdk.datamodel;

import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;

public class DxmJob implements NoProguard, Serializable {
    public String jobId = "";
    public String jobName = "";
    public String lowerJobId = "";
    public String lowerJobName = "";
}
