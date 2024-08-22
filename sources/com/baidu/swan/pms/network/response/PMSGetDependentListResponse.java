package com.baidu.swan.pms.network.response;

import com.baidu.swan.pms.model.PMSPlugin;
import java.util.List;

public class PMSGetDependentListResponse {
    public int errorCode;
    public String errorMsg;
    public List<PMSPlugin> pkgDependentList;
}
