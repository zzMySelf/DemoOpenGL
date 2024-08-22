package com.tera.scan.flutter.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import fe.mmm.qw.d.qw;
import fe.mmm.qw.p024if.ad;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.android.FlutterFragment;
import java.util.Stack;

public abstract class FlutterBaseActivity extends FragmentActivity {
    public static final String EXTRA_BACKGROUND_MODE = "background_mode";
    public static final String EXTRA_DART_ENTRYPOINT = "dart_entrypoint";
    public static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
    public Fragment mFragment;
    public boolean mLastCanChangeStatusColor;

    private void configureStatusBarForFullscreenFlutterExperience() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    private void configureWindowForTransparency() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private void removeActivity(FragmentActivity fragmentActivity) {
        Stack<FragmentActivity> activityStack = OldBaseActivity.getActivityStack();
        if (fragmentActivity != null && activityStack != null && activityStack.contains(fragmentActivity)) {
            activityStack.remove(fragmentActivity);
        }
    }

    public FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        if (getIntent().hasExtra("background_mode")) {
            return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
        }
        return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    public abstract Fragment initFragment();

    public void onActivityResult(int i2, int i3, Intent intent) {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            fragment.onActivityResult(i2, i3, intent);
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed() {
        Fragment fragment = this.mFragment;
        if (fragment == null || !(fragment instanceof FlutterFragment)) {
            super.onBackPressed();
        } else {
            ((FlutterFragment) fragment).onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        ad.ad(getApplication());
        this.mLastCanChangeStatusColor = qw.fe();
        qw.o(false);
        configureWindowForTransparency();
        super.onCreate(bundle);
        setContentView((int) R.layout.boost_flutter_activity);
        configureStatusBarForFullscreenFlutterExperience();
        this.mFragment = initFragment();
        OldBaseActivity.getActivityStack().push(this);
    }

    public void onDestroy() {
        removeActivity(this);
        super.onDestroy();
    }

    public void onPause() {
        qw.o(this.mLastCanChangeStatusColor);
        super.onPause();
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            fragment.onRequestPermissionsResult(i2, strArr, iArr);
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onResume() {
        qw.o(false);
        super.onResume();
    }
}
