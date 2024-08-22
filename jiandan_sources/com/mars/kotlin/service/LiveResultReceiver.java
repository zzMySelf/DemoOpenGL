package com.mars.kotlin.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import androidx.lifecycle.MutableLiveData;
import com.mars.kotlin.service.Result;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H$¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/mars/kotlin/service/LiveResultReceiver;", "T", "Landroid/os/ResultReceiver;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/mars/kotlin/service/Result;", "asLiveData", "()Landroidx/lifecycle/MutableLiveData;", "Landroid/os/Bundle;", "resultData", "getData", "(Landroid/os/Bundle;)Ljava/lang/Object;", "", "resultCode", "", "onReceiveResult", "(ILandroid/os/Bundle;)V", "returnValue", "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "service_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public abstract class LiveResultReceiver<T> extends ResultReceiver {
    public final MutableLiveData<Result<T>> returnValue = new MutableLiveData<>();

    public LiveResultReceiver() {
        super(new Handler(Looper.getMainLooper()));
    }

    @NotNull
    public final MutableLiveData<Result<T>> asLiveData() {
        return this.returnValue;
    }

    public abstract T getData(@Nullable Bundle bundle);

    public void onReceiveResult(int i2, @Nullable Bundle bundle) {
        Object obj;
        MutableLiveData<Result<T>> mutableLiveData = this.returnValue;
        if (i2 == 1) {
            obj = new Result.Success(getData(bundle));
        } else if (i2 != 2) {
            if (i2 == 3) {
                obj = new Result.Operating(getData(bundle));
            } else {
                throw new IllegalStateException("unknown result state " + i2);
            }
        } else if (bundle != null && bundle.containsKey(Extra.ERROR_NETWORK)) {
            obj = new Result.NetworkError(bundle);
        } else if (bundle == null || !bundle.containsKey(Extra.ERROR)) {
            obj = new Result.UnknownError(bundle);
        } else {
            obj = new Result.ServerError(Integer.valueOf(bundle.getInt(Extra.ERROR)), bundle.getString(Extra.ERROR_SERVER_MESSAGE), bundle);
        }
        mutableLiveData.setValue(obj);
    }
}
