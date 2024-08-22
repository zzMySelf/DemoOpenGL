package fe.fe.ddd.mmm.qw;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class th extends qw {
    public FragmentManager.FragmentLifecycleCallbacks qw;

    public class qw extends FragmentManager.FragmentLifecycleCallbacks {
        public qw() {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            super.onFragmentCreated(fragmentManager, fragment, bundle);
            if (fragment != null) {
                th.this.qw(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
            }
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
            super.onFragmentResumed(fragmentManager, fragment);
            if (fragment != null) {
                th.this.ad(fragment, fragment.getUserVisibleHint(), fragment.getActivity());
            }
        }
    }

    public final FragmentManager.FragmentLifecycleCallbacks de() {
        return new qw();
    }

    public boolean fe(@NonNull Activity activity) {
        if (!(activity instanceof FragmentActivity)) {
            return false;
        }
        if (this.qw == null) {
            this.qw = de();
        }
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        if (supportFragmentManager != null) {
            supportFragmentManager.registerFragmentLifecycleCallbacks(this.qw, true);
        }
        return true;
    }

    public boolean rg(@NonNull Activity activity) {
        FragmentManager supportFragmentManager;
        if (!(activity instanceof FragmentActivity)) {
            return false;
        }
        if (this.qw == null || (supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager()) == null) {
            return true;
        }
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(this.qw);
        return true;
    }
}
