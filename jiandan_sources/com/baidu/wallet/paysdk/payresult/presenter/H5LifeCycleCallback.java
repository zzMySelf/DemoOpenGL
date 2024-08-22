package com.baidu.wallet.paysdk.payresult.presenter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class H5LifeCycleCallback implements Application.ActivityLifecycleCallbacks, Parcelable, NoProguard {
    public static final Parcelable.Creator<H5LifeCycleCallback> CREATOR = new Parcelable.Creator<H5LifeCycleCallback>() {
        /* renamed from: a */
        public H5LifeCycleCallback createFromParcel(Parcel parcel) {
            return new H5LifeCycleCallback(parcel);
        }

        /* renamed from: a */
        public H5LifeCycleCallback[] newArray(int i2) {
            return new H5LifeCycleCallback[i2];
        }
    };
    public static CopyOnWriteArrayList<H5LifeCycleCallback> sCache = new CopyOnWriteArrayList<>();
    public int mHash;

    public H5LifeCycleCallback(Parcel parcel) {
        this.mHash = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        Iterator<H5LifeCycleCallback> it = sCache.iterator();
        while (it.hasNext()) {
            H5LifeCycleCallback next = it.next();
            if (!(next == null || next.mHash != this.mHash || next == this)) {
                next.onActivityDestroyed(activity);
            }
        }
        BaiduWalletDelegate.getInstance().removeH5LifeCycleCb(activity, this);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void pop() {
        sCache.remove(this);
    }

    public void push() {
        sCache.addIfAbsent(this);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mHash);
    }

    public H5LifeCycleCallback() {
        this.mHash = hashCode();
    }
}
