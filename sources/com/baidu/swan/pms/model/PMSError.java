package com.baidu.swan.pms.model;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class PMSError {
    public String appInfoMsg;
    public String errorDetail;
    public String errorMsg;
    public int errorNo;
    public int httpCode;
    public String tipMsg;

    public PMSError(int errorNo2, String errorMsg2) {
        this(errorNo2, errorMsg2, "");
    }

    public PMSError(int errorNo2, String errorMsg2, String tipMsg2) {
        this.errorDetail = "";
        this.errorNo = errorNo2;
        this.errorMsg = errorMsg2;
        this.tipMsg = tipMsg2;
    }

    public PMSError(int errorNo2, String errorMsg2, String tipMsg2, String appInfoMsg2) {
        this.errorDetail = "";
        this.errorNo = errorNo2;
        this.errorMsg = errorMsg2;
        this.tipMsg = tipMsg2;
        this.appInfoMsg = appInfoMsg2;
    }

    public PMSError setErrorDetail(String errorDetail2) {
        this.errorDetail = errorDetail2;
        return this;
    }

    public String toString() {
        return "PMSError{errorNo=" + this.errorNo + ", errorMsg='" + this.errorMsg + '\'' + ", httpCode=" + this.httpCode + ", tipMsg='" + this.tipMsg + '\'' + ", errorDetail='" + this.errorDetail + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
