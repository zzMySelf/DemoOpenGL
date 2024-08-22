package com.baidu.swan.apps.core.pms;

import com.baidu.swan.apps.trace.ErrCode;
import com.baidu.swan.pms.model.PMSPackage;

public class PkgDownloadError extends Throwable {
    private ErrCode mErrCode;
    private PMSPackage mPackage;

    public PkgDownloadError(PMSPackage pkg, ErrCode errCode) {
        super(errCode.desc());
        this.mPackage = pkg;
        this.mErrCode = errCode;
    }

    public PMSPackage getPackage() {
        return this.mPackage;
    }

    public ErrCode getErrCode() {
        return this.mErrCode;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (this.mPackage != null) {
            builder.append(" -> package: ");
            builder.append(this.mPackage.toString());
        }
        if (this.mErrCode != null) {
            builder.append(" -> ErrCode: ");
            builder.append(this.mErrCode.toString());
        }
        return builder.toString();
    }
}
