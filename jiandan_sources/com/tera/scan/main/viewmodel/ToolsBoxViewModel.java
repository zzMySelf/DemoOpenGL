package com.tera.scan.main.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import i.qw.Cif;
import i.qw.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/tera/scan/main/viewmodel/ToolsBoxViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "mergeImages", "Landroidx/lifecycle/LiveData;", "", "context", "Landroid/content/Context;", "imageList", "", "savePath", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToolsBoxViewModel extends ViewModel {
    @NotNull
    public final LiveData<String> mergeImages(@NotNull Context context, @NotNull List<String> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "imageList");
        Intrinsics.checkNotNullParameter(str, "savePath");
        MutableLiveData mutableLiveData = new MutableLiveData();
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), u.qw(), (CoroutineStart) null, new ToolsBoxViewModel$mergeImages$1(mutableLiveData, list, str, (Continuation<? super ToolsBoxViewModel$mergeImages$1>) null), 2, (Object) null);
        return mutableLiveData;
    }
}
