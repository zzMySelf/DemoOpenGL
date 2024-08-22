package com.tera.scan.framework;

import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import com.tera.scan.framework.swipeback.SwipeArea;
import com.tera.scan.framework.swipeback.SwipeBackLayout;
import com.tera.scan.framework.swipeback.SwipeType;
import fe.mmm.qw.f.fe.ad.ad;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.j.ppp;
import fe.mmm.qw.j.uk;
import fe.mmm.qw.p030switch.yj.de;
import fe.mmm.qw.p030switch.yj.fe;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public abstract class BaseActivity extends OldBaseActivity {
    public static final String TAG = "BaseActivity";
    public final TeraScanFragmentFactory mFragmentFactory = new TeraScanFragmentFactory(this);
    public de mSwipeBackConfig;
    public ad mTitleBar;

    private void checkAndInitSwipeBackConfig() {
        if (this.mSwipeBackConfig == null) {
            this.mSwipeBackConfig = initSwipeBackConfig();
        }
    }

    private void handleEnterAnim() {
        SwipeType fe2 = this.mSwipeBackConfig.fe();
        if (fe2 == SwipeType.LEFT_TO_RIGHT) {
            overridePendingTransition(R.anim.slide_right_enter, 0);
        } else if (fe2 == SwipeType.TOP_TO_DOWN) {
            overridePendingTransition(R.anim.slide_top_enter, 0);
        }
    }

    private void initSwipeBackView() {
        if (shouldSwipeBack()) {
            checkAndInitSwipeBackConfig();
            SwipeType fe2 = this.mSwipeBackConfig.fe();
            if (fe2 == SwipeType.LEFT_TO_RIGHT) {
                installSwipeBackLayout();
            } else if (fe2 == SwipeType.TOP_TO_DOWN) {
                installSwipeBackLayout();
            }
        }
    }

    private void installSwipeBackLayout() {
        try {
            if (!ppp.qw(this)) {
                qw.ad("BaseActivity", "activity to translucent failed");
                return;
            }
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            SwipeBackLayout swipeBackLayout = new SwipeBackLayout(this);
            swipeBackLayout.setSwipeBackConfig(this.mSwipeBackConfig);
            swipeBackLayout.setOnStartSwipe(new fe.mmm.qw.p030switch.ad(this));
            swipeBackLayout.setSwipeProgressCallback(new fe.mmm.qw.p030switch.qw(this));
            swipeBackLayout.setSwipeArea(initSwipeArea());
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup.removeView(viewGroup2);
            swipeBackLayout.addView(viewGroup2);
            viewGroup.addView(swipeBackLayout);
        } catch (Throwable th2) {
            qw.rg("BaseActivity", "init swipe layout failed, err: " + th2.getMessage());
        }
    }

    private boolean shouldSwipeBack() {
        return enableSwipeBack() && fe.qw();
    }

    public void addFragmentInstantiator(Function2<? super String, ? super FragmentActivity, ? extends Fragment> function2) {
        this.mFragmentFactory.addFragmentInstantiator(function2);
        getSupportFragmentManager().setFragmentFactory(this.mFragmentFactory);
    }

    public boolean enableSwipeBack() {
        return false;
    }

    public void finish() {
        de deVar;
        super.finish();
        if (shouldSwipeBack() && (deVar = this.mSwipeBackConfig) != null) {
            SwipeType fe2 = deVar.fe();
            if (fe2 == SwipeType.LEFT_TO_RIGHT) {
                overridePendingTransition(0, R.anim.slide_right_exit);
            } else if (fe2 == SwipeType.TOP_TO_DOWN) {
                overridePendingTransition(0, R.anim.slide_top_exit);
            }
        }
    }

    public ad getTitleBar() {
        return this.mTitleBar;
    }

    public SwipeArea initSwipeArea() {
        return SwipeArea.EDGE_AND_FULL;
    }

    public de initSwipeBackConfig() {
        de deVar = new de();
        deVar.rg(new fe.mmm.qw.p030switch.yj.qw(new RectF(0.0f, 0.0f, 100.0f, (float) uk.qw.qw(this)), (RectF) null));
        return deVar;
    }

    public boolean interceptSwipeBack() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        fe.mmm.qw.h.ad.qw().de(this);
        if (shouldSwipeBack()) {
            checkAndInitSwipeBackConfig();
            handleEnterAnim();
        }
        getSupportFragmentManager().setFragmentFactory(this.mFragmentFactory);
        super.onCreate(bundle);
        qw.ad("BaseActivity", "当前Activity名称: " + getClass().getSimpleName());
    }

    public void onDestroy() {
        ad adVar = this.mTitleBar;
        if (adVar != null) {
            adVar.qw();
        }
        super.onDestroy();
    }

    public /* synthetic */ Unit qw(Float f) {
        if (f.floatValue() < 1.0f) {
            return null;
        }
        swipeToFinish();
        return null;
    }

    public void setContentView(int i2) {
        super.setContentView(i2);
        initSwipeBackView();
    }

    public void swipeToFinish() {
        finish();
        overridePendingTransition(0, 0);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        initSwipeBackView();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        initSwipeBackView();
    }
}
