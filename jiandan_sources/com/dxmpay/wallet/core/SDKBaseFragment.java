package com.dxmpay.wallet.core;

import android.app.Activity;
import androidx.fragment.app.Fragment;

public class SDKBaseFragment extends Fragment implements NoProguard {
    public BaseActivity mAct;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void setActivity(BaseActivity baseActivity) {
        this.mAct = baseActivity;
    }
}
