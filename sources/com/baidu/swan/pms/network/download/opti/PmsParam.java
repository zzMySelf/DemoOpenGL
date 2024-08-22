package com.baidu.swan.pms.network.download.opti;

import com.baidu.swan.pms.model.PMSError;
import com.baidu.swan.pms.model.PMSPackage;

final class PmsParam {
    PMSError mError;
    PMSPackage mPkg;

    PmsParam(PMSPackage pkg) {
        this.mPkg = pkg;
    }
}
