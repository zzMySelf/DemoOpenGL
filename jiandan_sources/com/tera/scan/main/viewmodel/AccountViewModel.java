package com.tera.scan.main.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.net.MediaType;
import fe.mmm.qw.xxx.rg.qw;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/tera/scan/main/viewmodel/AccountViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_loadingLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "_logoutResult", "Lcom/tera/scan/main/data/LogOutResult;", "loadingLiveData", "Landroidx/lifecycle/LiveData;", "getLoadingLiveData", "()Landroidx/lifecycle/LiveData;", "logoutResult", "getLogoutResult", "logout", "", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountViewModel extends AndroidViewModel {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final LiveData<Boolean> f7003ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final MutableLiveData<qw> f7004de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final LiveData<qw> f7005fe;
    @NotNull
    public final MutableLiveData<Boolean> qw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.qw = mutableLiveData;
        this.f7003ad = mutableLiveData;
        MutableLiveData<qw> mutableLiveData2 = new MutableLiveData<>();
        this.f7004de = mutableLiveData2;
        this.f7005fe = mutableLiveData2;
    }

    @NotNull
    public final LiveData<Boolean> getLoadingLiveData() {
        return this.f7003ad;
    }

    @NotNull
    public final LiveData<qw> getLogoutResult() {
        return this.f7005fe;
    }

    public final void logout() {
        this.qw.setValue(Boolean.TRUE);
        fe.mmm.qw.qw.qw.qw.m1001if(new AccountViewModel$logout$1(this));
    }
}
