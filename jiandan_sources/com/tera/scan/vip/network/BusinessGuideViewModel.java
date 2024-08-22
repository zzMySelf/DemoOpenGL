package com.tera.scan.vip.network;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.tera.scan.vip.network.job.GetUserCardInfoJob;
import com.tera.scan.vip.network.model.UserCardInfoResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/tera/scan/vip/network/BusinessGuideViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "getUserCardInfo", "Landroidx/lifecycle/LiveData;", "Lcom/tera/scan/vip/network/model/UserCardInfoResponse;", "context", "Landroid/content/Context;", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BusinessGuideViewModel extends ViewModel {
    @NotNull
    public final LiveData<UserCardInfoResponse> getUserCardInfo(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new GetUserCardInfoJob(context).de();
    }
}
