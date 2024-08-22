package com.baidu.sapi2.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.views.loadingview.SapiShimmerView;

public class SweepLightLoadingView extends FrameLayout implements NoProguard {
    public View a;
    public SapiShimmerView b;

    public SweepLightLoadingView(Context context) {
        super(context);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_sapi_sdk_sweep_light_loading_view, this, true);
        this.a = inflate;
        this.b = (SapiShimmerView) inflate.findViewById(R.id.sapi_sdk_shimmer_view);
        if (DarkModeUtil.isDarkMode(getContext())) {
            this.b.setType(0);
        } else {
            this.b.setType(1);
        }
    }

    private void b() {
        SapiShimmerView sapiShimmerView = this.b;
        if (sapiShimmerView != null && !sapiShimmerView.b()) {
            this.b.d();
        }
    }

    @TargetApi(11)
    private void c() {
        SapiShimmerView sapiShimmerView = this.b;
        if (sapiShimmerView != null) {
            sapiShimmerView.e();
        }
    }

    public void setVisibility(int i2) {
        if (i2 == 0) {
            b();
        } else {
            c();
        }
        super.setVisibility(i2);
    }

    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
