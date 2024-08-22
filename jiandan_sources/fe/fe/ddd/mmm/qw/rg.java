package fe.fe.ddd.mmm.qw;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.DeviceUtil;

@TargetApi(26)
public class rg extends qw {
    public FragmentManager.FragmentLifecycleCallbacks qw;

    public class qw extends FragmentManager.FragmentLifecycleCallbacks {
        public qw() {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            super.onFragmentCreated(fragmentManager, fragment, bundle);
            if (fragment != null) {
                rg.this.qw(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
            }
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
            super.onFragmentResumed(fragmentManager, fragment);
            if (fragment != null) {
                rg.this.ad(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
            }
        }
    }

    public final FragmentManager.FragmentLifecycleCallbacks de() {
        return new qw();
    }

    public boolean fe(@NonNull Activity activity) {
        if (!DeviceUtil.OSInfo.hasOreo()) {
            return false;
        }
        if (this.qw == null) {
            this.qw = de();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.registerFragmentLifecycleCallbacks(this.qw, true);
        }
        return true;
    }

    public boolean rg(@NonNull Activity activity) {
        FragmentManager fragmentManager;
        if (!DeviceUtil.OSInfo.hasOreo()) {
            return false;
        }
        if (this.qw == null || (fragmentManager = activity.getFragmentManager()) == null) {
            return true;
        }
        fragmentManager.unregisterFragmentLifecycleCallbacks(this.qw);
        return true;
    }
}
