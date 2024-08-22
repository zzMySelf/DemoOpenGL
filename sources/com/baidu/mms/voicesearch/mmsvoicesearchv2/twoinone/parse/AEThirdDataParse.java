package com.baidu.mms.voicesearch.mmsvoicesearchv2.twoinone.parse;

import com.baidu.mms.voicesearch.mmsvoicesearchv2.twoinone.ExceptionStatisticProcessor;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.twoinone.TransportStreamManager;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.twoinone.parse.ae.BaseAEPackageParse;
import okio.Buffer;

public class AEThirdDataParse extends BaseThirdDataParse {
    public static final String AE = "ae";
    private Buffer mAEDataBuf;

    public AEThirdDataParse(TransportStreamManager.TLVObservable observable) {
        super(observable);
    }

    public void releaseParse() {
        try {
            Buffer buffer = this.mAEDataBuf;
            if (buffer != null) {
                buffer.clear();
            }
        } catch (Throwable th2) {
        }
        this.mAEDataBuf = null;
        BaseAEPackageParse.release();
    }

    public void initParse() {
        this.mAEDataBuf = new Buffer();
        BaseAEPackageParse.init(this.parseObservable);
    }

    public String getType() {
        return AE;
    }

    public void parseBody(Buffer buffer) {
        try {
            if (!isEmptyPackage()) {
                buffer.readAll(this.mAEDataBuf);
                BaseAEPackageParse.parse(this.mAEDataBuf, this.parseObservable);
            }
        } catch (Throwable th2) {
            ExceptionStatisticProcessor.addErrorType("1004", true);
            this.parseObservable.notifyObservers(4);
        }
    }
}
