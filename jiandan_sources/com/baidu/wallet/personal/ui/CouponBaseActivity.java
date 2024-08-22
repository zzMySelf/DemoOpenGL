package com.baidu.wallet.personal.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.LogUtil;

public class CouponBaseActivity extends BeanActivity {
    public Resources mResources = null;

    public static class a extends Resources {
        public float a;
        public float b;
        public int c;

        public a(Resources resources) {
            super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        }

        private void a(DisplayMetrics displayMetrics) {
            if (this.a == 0.0f) {
                float f = displayMetrics.density;
                float f2 = displayMetrics.scaledDensity;
                float f3 = ((float) displayMetrics.widthPixels) / 360.0f;
                this.a = f3;
                this.b = (f2 / f) * f3;
                this.c = (int) (f3 * 160.0f);
            }
        }

        private void b(DisplayMetrics displayMetrics) {
            displayMetrics.density = this.a;
            displayMetrics.densityDpi = this.c;
        }

        public DisplayMetrics getDisplayMetrics() {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(super.getDisplayMetrics());
            a(displayMetrics);
            b(displayMetrics);
            return displayMetrics;
        }
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        if (this.mResources == null) {
            Configuration configuration = new Configuration(resources.getConfiguration());
            configuration.setToDefaults();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            this.mResources = new a(super.getResources());
            LogUtil.d("CouponBaseActivity", "getResources config = " + configuration);
        }
        Resources resources2 = this.mResources;
        return resources2 != null ? resources2 : resources;
    }

    public void handleResponse(int i2, Object obj, String str) {
    }
}
