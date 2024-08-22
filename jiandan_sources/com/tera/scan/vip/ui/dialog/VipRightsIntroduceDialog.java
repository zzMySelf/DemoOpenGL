package com.tera.scan.vip.ui.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentManager;
import com.tera.scan.framework.kernel.BaseApplication;
import fe.mmm.qw.k.i.ad;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/tera/scan/vip/ui/dialog/VipRightsIntroduceDialog;", "", "()V", "from", "", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "resultCallback", "Lcom/tera/scan/vip/ui/dialog/VipRightsIntroduceDialog$VipRightsIntroduceCallback;", "source", "getSource", "setSource", "setResultCallback", "", "callback", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "Companion", "VipRightsIntroduceCallback", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VipRightsIntroduceDialog {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public VipRightsIntroduceCallback f7465ad;
    @Nullable
    public String qw;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/tera/scan/vip/ui/dialog/VipRightsIntroduceDialog$VipRightsIntroduceCallback;", "", "callback", "", "result", "", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface VipRightsIntroduceCallback {
        void qw(@NotNull String str);
    }

    public final void ad(@Nullable String str) {
        this.qw = str;
    }

    public final void de(@Nullable VipRightsIntroduceCallback vipRightsIntroduceCallback) {
        this.f7465ad = vipRightsIntroduceCallback;
    }

    public final void fe(@Nullable String str) {
    }

    public final void rg(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Context context = BaseApplication.mContext;
        if (context != null) {
            String str2 = this.qw;
            if (str2 == null) {
                str2 = "";
            }
            ad.ad(context, str2, new VipRightsIntroduceDialog$show$1(this, new Handler(Looper.getMainLooper())));
        }
    }
}
