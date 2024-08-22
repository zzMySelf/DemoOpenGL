package com.baidu.searchbox.talos.tokenizor.textselect;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.talos.tokenizor.LACUtilsWrapper;
import com.baidu.talos.adapter.TokenizorInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/talos/tokenizor/textselect/TextSelectTokenizorImpl;", "Lcom/baidu/talos/adapter/TokenizorInterface;", "()V", "cutString", "", "input", "isForceStringCutMode", "", "Companion", "lib-talos-adapter-searchbox-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextSelectTokenizorImpl.kt */
public final class TextSelectTokenizorImpl implements TokenizorInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean DEBUG = AppConfig.isDebug();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/talos/tokenizor/textselect/TextSelectTokenizorImpl$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "lib-talos-adapter-searchbox-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextSelectTokenizorImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getDEBUG() {
            return TextSelectTokenizorImpl.DEBUG;
        }

        public final void setDEBUG(boolean z) {
            TextSelectTokenizorImpl.DEBUG = z;
        }
    }

    public String cutString(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return LACUtilsWrapper.INSTANCE.stringCut(input);
    }

    public boolean isForceStringCutMode() {
        return false;
    }
}
