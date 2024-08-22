package com.tera.scan.framework.kernel.architecture.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tera.scan.themeskin.base.SkinBaseFragment;
import fe.mmm.qw.p030switch.rg.de;

public abstract class BaseFragment extends SkinBaseFragment implements IView, IBackKeyListener {
    public boolean isDestroying = false;
    public View mLayoutView;

    public View findViewById(int i2) {
        View view = this.mLayoutView;
        if (view == null) {
            return null;
        }
        return view.findViewById(i2);
    }

    public Context getContext() {
        if (getActivity() == null) {
            return null;
        }
        if (getActivity() == null || getActivity().isFinishing()) {
            return getActivity().getApplicationContext();
        }
        return getActivity();
    }

    public <T> T getService(String str) {
        return ((OldBaseActivity) getActivity()).getService(str);
    }

    public boolean isDestroying() {
        return isRemoving() || this.isDestroying;
    }

    public boolean onBackKeyPressed() {
        FragmentActivity activity = getActivity();
        return activity != null && (activity instanceof OldBaseActivity) && ((OldBaseActivity) activity).backFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.isDestroying = false;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        this.isDestroying = true;
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        de.qw().de(getActivity(), this);
    }

    public void onResume() {
        super.onResume();
        de.qw().rg(getActivity(), this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    public void showError(int i2) {
    }

    public void showError(int i2, String str) {
    }

    public void showError(String str) {
    }

    public void showSuccess(int i2) {
    }

    public void showSuccess(String str) {
    }

    public void startProgress(int i2) {
    }

    public void stopProgress(int i2) {
    }

    public void updateArguments(Bundle bundle) {
    }
}
