package com.baidu.webkit.internal.blink;

import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;

/* compiled from: BlinkEngineInstallerFile */
final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private String f3964a;

    public b(String str, EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        super(engineManager, webkitInstallListener);
        if (str != null) {
            String substring = str.substring(7);
            if (new File(substring).isFile()) {
                this.f3964a = substring;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean c() {
        return this.f3964a != null;
    }

    /* access modifiers changed from: protected */
    public final String d() {
        return this.f3964a;
    }
}
