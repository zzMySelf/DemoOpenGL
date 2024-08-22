package com.tera.scan.main;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.xxx.pf.de;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/tera/scan/main/MainActivity$initListener$3", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "onDrawerClosed", "", "drawerView", "Landroid/view/View;", "onDrawerOpened", "onDrawerSlide", "slideOffset", "", "onDrawerStateChanged", "newState", "", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MainActivity$initListener$3 implements DrawerLayout.DrawerListener {
    public final /* synthetic */ MainActivity qw;

    public MainActivity$initListener$3(MainActivity mainActivity) {
        this.qw = mainActivity;
    }

    public void onDrawerClosed(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "drawerView");
        ((DrawerLayout) this.qw._$_findCachedViewById(R.id.main_drawer)).setDrawerLockMode(1);
    }

    public void onDrawerOpened(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "drawerView");
        ((DrawerLayout) this.qw._$_findCachedViewById(R.id.main_drawer)).setDrawerLockMode(0);
        LoggerKt.d$default("onDrawerOpened", (Object) null, 1, (Object) null);
        de.fe("PCntr", "PCntr", (String) null, (Map) null, 12, (Object) null);
    }

    public void onDrawerSlide(@NotNull View view, float f) {
        Intrinsics.checkNotNullParameter(view, "drawerView");
    }

    public void onDrawerStateChanged(int i2) {
    }
}
