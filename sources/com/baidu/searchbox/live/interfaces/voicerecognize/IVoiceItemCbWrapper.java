package com.baidu.searchbox.live.interfaces.voicerecognize;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH&¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/voicerecognize/IVoiceItemCbWrapper;", "", "executeVoiceItem", "", "name", "", "param", "data", "", "offSet", "", "length", "onMicInitializeFailed", "reason", "onMicInitializeSuccess", "onMicInitializingBegin", "onMicReleased", "onRecognationStatusChanged", "status", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: IVoiceItemCbWrapper.kt */
public interface IVoiceItemCbWrapper {
    void executeVoiceItem(String str, String str2, byte[] bArr, int i2, int i3);

    void onMicInitializeFailed(int i2);

    void onMicInitializeSuccess();

    void onMicInitializingBegin();

    void onMicReleased();

    void onRecognationStatusChanged(int i2);
}
