package com.baidu.searchbox.discovery.novel;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.discovery.novel.base.NovelBaseActionBarBaseActivity;
import com.baidu.searchbox.environment.dinovel.pluginentrance.PluginLoadCallbackImpl;
import com.baidu.searchbox.nps.PluginInvokeManager;

class DiscoveryNovelCommentActivity extends NovelBaseActionBarBaseActivity implements NoProGuard {
    DiscoveryNovelCommentActivity() {
    }

    public void onCreate(Bundle savedInstanceState) {
        if (!SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            super.onCreate(savedInstanceState);
            boolean result = PluginInvokeManager.getInstance().isPluginInit();
            Intent intent = getIntent();
            if (intent != null) {
                intent.setComponent(new ComponentName(this, "com.baidu.searchbox.newreader.discovery.novel.DiscoveryNovelCommentActivity"));
                if (!result) {
                    PluginInvokeManager.getInstance().invokeNovel(true, new PluginLoadCallbackImpl(this));
                    return;
                }
                startActivity(intent);
                finish();
            }
        }
    }
}
