package com.baidu.searchbox.socialshare.baidu.bdshare;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.android.support.appcompat.ScreenOrientationCompat;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.socialshare.runtime.IAccount;

public class BDShareEntryActivity extends BaseActivity {
    private static final String BAIDU_FRIEND_LIST = "com.baidu.searchbox.account.friendselect.LinkmanListActivity";
    private Bundle mData;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        int orientation = ScreenOrientationCompat.releaseFixedOrientation(this);
        super.onCreate(savedInstanceState);
        ScreenOrientationCompat.fixedOrientation(this, orientation);
        if (!SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            this.mData = getIntent().getExtras();
            IAccount.Impl.get().isLogin(this);
        }
    }

    public void startLinkmanListActivity() {
        if (this.mData != null) {
            Intent intent = new Intent();
            intent.putExtras(this.mData);
            intent.setComponent(new ComponentName(getPackageName(), BAIDU_FRIEND_LIST));
            startActivity(intent);
            finish();
        }
    }
}
