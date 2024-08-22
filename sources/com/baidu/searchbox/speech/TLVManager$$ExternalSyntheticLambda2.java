package com.baidu.searchbox.speech;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TLVManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ TLVInputStream f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ TLVManager$$ExternalSyntheticLambda2(TLVInputStream tLVInputStream, String str, String str2) {
        this.f$0 = tLVInputStream;
        this.f$1 = str;
        this.f$2 = str2;
    }

    public final void run() {
        TLVManager.m3325saveDiskCache$lambda6(this.f$0, this.f$1, this.f$2);
    }
}
