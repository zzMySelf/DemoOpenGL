package com.baidu.swan.gamecenter.appmanager.install;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.apps.util.SwanAppRomUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.game.R;
import com.baidu.swan.gamecenter.appmanager.statistics.CommonStatsParams;
import com.baidu.swan.gamecenter.appmanager.statistics.GameCenterStatistic;
import org.json.JSONObject;

public class InstallAntiBlockingActivity extends Activity {
    public static final String KEY_TYPE = "type";
    public static final String KEY_UBC_PARAMS = "ubc_params";
    public static final String PARAM_PACKAGE_NAME = "packageName";
    /* access modifiers changed from: private */
    public String mPackageName;
    /* access modifiers changed from: private */
    public String mType;
    /* access modifiers changed from: private */
    public JSONObject mUbcParams;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        int orientation = SwanAppUtils.releaseFixedOrientation(this);
        super.onCreate(savedInstanceState);
        SwanAppUtils.fixedOrientation(this, orientation);
        GameCenterApkUtil.updateInstallGuideCount();
        setContentView(R.layout.aiapps_install_guide_layout);
        Intent intent = getIntent();
        if (intent != null) {
            this.mType = intent.getStringExtra("type");
            this.mPackageName = intent.getStringExtra("packageName");
            this.mUbcParams = SwanAppJSONUtils.parseString(intent.getStringExtra("ubc_params"));
        }
        ImageView image = (ImageView) findViewById(R.id.install_guide_image);
        View root = findViewById(R.id.install_guide_layout);
        if (TextUtils.equals(this.mType, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.aiapps_install_image_height));
            layoutParams.gravity = 80;
            image.setLayoutParams(layoutParams);
            findViewById(R.id.install_guide_image_mask).setVisibility(0);
            image.setImageResource(R.drawable.aiapps_install_guide_request);
            findViewById(R.id.install_guide_bg_mask).setBackgroundResource(R.color.aiapps_install_guide_mask);
            GameCenterApkUtil.setAuthorizeInstallGuideTime();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.aiapps_install_guide_image_height));
            layoutParams2.gravity = 80;
            image.setLayoutParams(layoutParams2);
            findViewById(R.id.install_guide_image_mask).setVisibility(8);
            if (SwanAppRomUtils.isEmui()) {
                image.setImageResource(R.drawable.aiapps_install_guide_emui);
            } else if (SwanAppRomUtils.isMiui()) {
                image.setImageResource(R.drawable.aiapps_install_guide_miui);
            } else if (SwanAppRomUtils.isVivo()) {
                image.setImageResource(R.drawable.aiapps_install_guide_vivo);
            } else {
                image.setImageResource(R.drawable.aiapps_install_guide_default);
            }
            findViewById(R.id.install_guide_bg_mask).setBackgroundResource(R.color.aiapps_anti_block_mask);
            GameCenterApkUtil.setContinueInstallGuideTime();
        }
        root.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GameCenterStatistic.doAppManagerStats(InstallAntiBlockingActivity.this.mPackageName, TextUtils.equals(InstallAntiBlockingActivity.this.mType, "authorize") ? "authorizeClick" : "continueClick", "success", (String) null, new CommonStatsParams(InstallAntiBlockingActivity.this.mUbcParams));
                InstallAntiBlockingActivity.this.finish();
            }
        });
        GameCenterStatistic.doAppManagerStats(this.mPackageName, this.mType, "success", (String) null, new CommonStatsParams(this.mUbcParams));
    }
}
