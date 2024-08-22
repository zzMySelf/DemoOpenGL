package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper;

@SuppressLint({"NewApi"})
@KeepForSdk
public final class FragmentWrapper extends IFragmentWrapper.Stub {
    public Fragment zzio;

    public FragmentWrapper(Fragment fragment) {
        this.zzio = fragment;
    }

    @KeepForSdk
    public static FragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    public final Bundle getArguments() {
        return this.zzio.getArguments();
    }

    public final int getId() {
        return this.zzio.getId();
    }

    public final boolean getRetainInstance() {
        return this.zzio.getRetainInstance();
    }

    public final String getTag() {
        return this.zzio.getTag();
    }

    public final int getTargetRequestCode() {
        return this.zzio.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.zzio.getUserVisibleHint();
    }

    public final boolean isAdded() {
        return this.zzio.isAdded();
    }

    public final boolean isDetached() {
        return this.zzio.isDetached();
    }

    public final boolean isHidden() {
        return this.zzio.isHidden();
    }

    public final boolean isInLayout() {
        return this.zzio.isInLayout();
    }

    public final boolean isRemoving() {
        return this.zzio.isRemoving();
    }

    public final boolean isResumed() {
        return this.zzio.isResumed();
    }

    public final boolean isVisible() {
        return this.zzio.isVisible();
    }

    public final void setHasOptionsMenu(boolean z) {
        this.zzio.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.zzio.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.zzio.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.zzio.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.zzio.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i2) {
        this.zzio.startActivityForResult(intent, i2);
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        this.zzio.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final IObjectWrapper zzae() {
        return ObjectWrapper.wrap(this.zzio.getActivity());
    }

    public final IFragmentWrapper zzaf() {
        return wrap(this.zzio.getParentFragment());
    }

    public final IObjectWrapper zzag() {
        return ObjectWrapper.wrap(this.zzio.getResources());
    }

    public final IFragmentWrapper zzah() {
        return wrap(this.zzio.getTargetFragment());
    }

    public final IObjectWrapper zzai() {
        return ObjectWrapper.wrap(this.zzio.getView());
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.zzio.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
