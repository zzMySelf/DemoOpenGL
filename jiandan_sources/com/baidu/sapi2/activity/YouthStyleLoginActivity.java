package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.RoundWebview;
import com.baidu.sapi2.views.swipeback.SwipeBackLayout;

public class YouthStyleLoginActivity extends LoginActivity {
    public SwipeBackLayout L;
    public ImageView M;

    public void onCreate(Bundle bundle) {
        setContentView(R.layout.layout_sapi_sdk_youth_style_login_activity);
        this.mNeedSetContentView = false;
        super.onCreate(bundle);
        this.L = (SwipeBackLayout) findViewById(R.id.sbl_root_view);
        this.M = (ImageView) findViewById(R.id.iv_pick_up_arrow);
        this.L.setDirectionMode(4);
        this.sapiWebView.setOverScrollMode(2);
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView instanceof RoundWebview) {
            ((RoundWebview) sapiWebView).a(getResources().getDimension(R.dimen.sapi_sdk_youth_style_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_youth_style_webview_radius), 0.0f, 0.0f);
        }
        this.M.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                YouthStyleLoginActivity.this.onClose();
            }
        });
    }
}
