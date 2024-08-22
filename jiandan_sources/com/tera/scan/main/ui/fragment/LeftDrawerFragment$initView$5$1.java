package com.tera.scan.main.ui.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LeftDrawerFragment$initView$5$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ LeftDrawerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LeftDrawerFragment$initView$5$1(LeftDrawerFragment leftDrawerFragment) {
        super(1);
        this.this$0 = leftDrawerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r4 = r0.getPackageInfo(r4.getPackageName(), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r4 == null) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(boolean r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x003d
            com.tera.scan.main.ui.fragment.LeftDrawerFragment r4 = r3.this$0
            android.content.Context r4 = r4.getContext()
            if (r4 == 0) goto L_0x0021
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            if (r0 == 0) goto L_0x001e
            java.lang.String r4 = r4.getPackageName()
            r1 = 0
            android.content.pm.PackageInfo r4 = r0.getPackageInfo(r4, r1)
            if (r4 == 0) goto L_0x001e
            java.lang.String r4 = r4.versionName
            goto L_0x001f
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r4 != 0) goto L_0x0023
        L_0x0021:
            java.lang.String r4 = ""
        L_0x0023:
            com.tera.scan.main.ui.fragment.LeftDrawerFragment r0 = r3.this$0
            android.content.Context r0 = r0.getContext()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "https://pan.baidu.com/embed/service_scan?theme=light&client=scan_android&from=main&version="
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            fe.mmm.qw.l.de.ad(r0, r4)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.ui.fragment.LeftDrawerFragment$initView$5$1.invoke(boolean):void");
    }
}
