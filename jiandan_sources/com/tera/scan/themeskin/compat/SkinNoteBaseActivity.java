package com.tera.scan.themeskin.compat;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import com.tera.scan.themeskin.listener.IDynamicNewView;
import com.tera.scan.themeskin.listener.ISkinUpdate;
import com.tera.scan.themeskin.loader.LayoutInflaterFactory;
import fe.mmm.qw.d.de.ad;
import fe.mmm.qw.d.de.de;
import fe.mmm.qw.d.fe.uk;
import fe.mmm.qw.d.fe.yj;
import fe.mmm.qw.d.qw;
import java.util.List;

public class SkinNoteBaseActivity extends AppCompatActivity implements ISkinUpdate, IDynamicNewView {
    public static final String TAG = "skinTheme/SkinBaseActivity";
    public boolean hasMongoAttah = false;
    public boolean mIsActivityDark = false;
    public LayoutInflaterFactory mLayoutInflaterFactory = new LayoutInflaterFactory();
    public LinearLayout mMongoliaView;
    public ad mSkinInflaterFactory;

    private void addMongoliaView() {
        if (!isActivityDark() && !this.hasMongoAttah) {
            this.hasMongoAttah = true;
            this.mMongoliaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            ((ViewGroup) getWindow().findViewById(16908290)).addView(this.mMongoliaView);
        }
    }

    public void changeStatusColor() {
        if (qw.fe()) {
            uk.yj(this);
        }
    }

    public void dynamicAddFontView(TextView textView) {
        this.mSkinInflaterFactory.rg(this, textView);
    }

    public void dynamicAddView(View view, List<fe.mmm.qw.d.ad.ggg.ad> list) {
        this.mSkinInflaterFactory.yj(this, view, list);
    }

    public ad getInflaterFactory() {
        return this.mSkinInflaterFactory;
    }

    public boolean isActivityDark() {
        return this.mIsActivityDark;
    }

    public void onCreate(Bundle bundle) {
        this.mSkinInflaterFactory = new ad(this);
        this.mLayoutInflaterFactory = new LayoutInflaterFactory();
        LayoutInflaterCompat.setFactory2(getLayoutInflater(), this.mLayoutInflaterFactory);
        if (isActivityDark()) {
            this.mLayoutInflaterFactory.addIntercept(this.mSkinInflaterFactory);
        }
        super.onCreate(bundle);
        if (this.mMongoliaView == null) {
            this.mMongoliaView = new LinearLayout(this);
        }
        setActivityBg();
    }

    public void onDestroy() {
        super.onDestroy();
        de.when().uk(this);
        this.mSkinInflaterFactory.fe();
    }

    public void onResume() {
        super.onResume();
        addMongoliaView();
        changeStatusColor();
        de.when().yj(this);
    }

    public void onThemeUpdate() {
        fe.mmm.qw.d.fe.ad.ad("skinTheme/SkinBaseActivity", "onThemeUpdate");
        if (isActivityDark()) {
            this.mSkinInflaterFactory.de();
        }
        changeStatusColor();
        setActivityBg();
    }

    public void setActivityBg() {
        if (qw.rg(this)) {
            this.mMongoliaView.setVisibility(8);
            return;
        }
        this.mMongoliaView.setVisibility(0);
        if (!isActivityDark()) {
            this.mMongoliaView.setBackgroundColor(yj.th());
        }
    }

    public void dynamicAddView(View view, String str, int i2) {
        this.mSkinInflaterFactory.th(this, view, str, i2);
    }
}
