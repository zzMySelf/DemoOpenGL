package com.mars.united.core.os.security.biometric;

import androidx.biometric.BiometricPrompt;
import androidx.lifecycle.MutableLiveData;
import com.baidu.android.common.others.lang.StringUtil;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.ggg.ad.qw.ad.ad;
import fe.ggg.ad.qw.de.th.rg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mars/united/core/os/security/biometric/BiometricAuthenticationCallback;", "Landroidx/biometric/BiometricPrompt$AuthenticationCallback;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "", "(Landroidx/lifecycle/MutableLiveData;)V", "onAuthenticationError", "", "errorCode", "", "errString", "", "onAuthenticationFailed", "onAuthenticationSucceeded", "result", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Tag("BiometricAuthenticationCallback")
public final class BiometricAuthenticationCallback extends BiometricPrompt.AuthenticationCallback {
    @NotNull
    public final MutableLiveData<Boolean> qw;

    public BiometricAuthenticationCallback(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "liveData");
        this.qw = mutableLiveData;
    }

    public void onAuthenticationError(int i2, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "errString");
        super.onAuthenticationError(i2, charSequence);
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(ad.qw("Authentication error: " + charSequence + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2), (Object) null, 1, (Object) null);
        }
        rg.yj(this.qw, Boolean.FALSE);
    }

    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(ad.qw("fail"), (Object) null, 1, (Object) null);
        }
        rg.yj(this.qw, Boolean.FALSE);
    }

    public void onAuthenticationSucceeded(@NotNull BiometricPrompt.AuthenticationResult authenticationResult) {
        Intrinsics.checkNotNullParameter(authenticationResult, "result");
        super.onAuthenticationSucceeded(authenticationResult);
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(ad.qw("信息匹配成功"), (Object) null, 1, (Object) null);
        }
        rg.yj(this.qw, Boolean.TRUE);
    }
}
