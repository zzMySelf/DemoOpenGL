package com.baidu.searchbox.discovery.novel.guide;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.discovery.novel.base.NovelBaseActivity;
import com.baidu.searchbox.environment.dinovel.pluginentrance.PluginLoadCallbackImpl;
import com.baidu.searchbox.nps.PluginInvokeManager;

public class NovelFloatGuideActivity extends NovelBaseActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean result = PluginInvokeManager.getInstance().isPluginInit();
        Intent intent = getIntent();
        if (intent != null) {
            intent.setComponent(new ComponentName(this, "com.baidu.searchbox.newreader.discovery.novel.guide.NovelFloatGuideActivity"));
        }
        if (!result) {
            PluginInvokeManager.getInstance().invokeNovel(true, new PluginLoadCallbackImpl(this));
            return;
        }
        startActivity(intent);
        finish();
    }
}
