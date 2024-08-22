package com.baidu.mms.voicesearch.mmsvoicesearchv2.twoinone.parse;

import com.baidu.mms.voicesearch.mmsvoicesearchv2.twoinone.TransportStreamManager;
import java.io.EOFException;
import okio.Buffer;

public class UnknownThirdDataParse extends BaseThirdDataParse {
    public UnknownThirdDataParse(TransportStreamManager.TLVObservable observable) {
        super(observable);
    }

    public String getType() {
        return "";
    }

    public void initParse() {
    }

    public void releaseParse() {
    }

    public void parseBody(Buffer buffer) {
        try {
            buffer.skip(buffer.size());
        } catch (EOFException e2) {
        }
    }
}
