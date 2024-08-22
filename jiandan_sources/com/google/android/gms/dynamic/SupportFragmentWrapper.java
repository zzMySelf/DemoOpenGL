package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper;

@KeepForSdk
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {
    public Fragment mFragment;

    public SupportFragmentWrapper(Fragment fragment) {
        this.mFragment = fragment;
    }

    @KeepForSdk
    public static SupportFragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    public final Bundle getArguments() {
        return this.mFragment.getArguments();
    }

    public final int getId() {
        return this.mFragment.getId();
    }

    public final boolean getRetainInstance() {
        return this.mFragment.getRetainInstance();
    }

    public final String getTag() {
        return this.mFragment.getTag();
    }

    public final int getTargetRequestCode() {
        return this.mFragment.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.mFragment.getUserVisibleHint();
    }

    public final boolean isAdded() {
        return this.mFragment.isAdded();
    }

    public final boolean isDetached() {
        return this.mFragment.isDetached();
    }

    public final boolean isHidden() {
        return this.mFragment.isHidden();
    }

    public final boolean isInLayout() {
        return this.mFragment.isInLayout();
    }

    public final boolean isRemoving() {
        return this.mFragment.isRemoving();
    }

    public final boolean isResumed() {
        return this.mFragment.isResumed();
    }

    public final boolean isVisible() {
        return this.mFragment.isVisible();
    }

    public final void setHasOptionsMenu(boolean z) {
        this.mFragment.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.mFragment.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.mFragment.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.mFragment.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.mFragment.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i2) {
        this.mFragment.startActivityForResult(intent, i2);
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        this.mFragment.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final IObjectWrapper zzae() {
        return ObjectWrapper.wrap(this.mFragment.getActivity());
    }

    public final IFragmentWrapper zzaf() {
        return wrap(this.mFragment.getParentFragment());
    }

    public final IObjectWrapper zzag() {
        return ObjectWrapper.wrap(this.mFragment.getResources());
    }

    public final IFragmentWrapper zzah() {
        return wrap(this.mFragment.getTargetFragment());
    }

    public final IObjectWrapper zzai() {
        return ObjectWrapper.wrap(this.mFragment.getView());
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.mFragment.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
