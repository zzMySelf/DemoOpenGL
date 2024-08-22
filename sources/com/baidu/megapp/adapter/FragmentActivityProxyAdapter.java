package com.baidu.megapp.adapter;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.loader.app.LoaderManager;

public interface FragmentActivityProxyAdapter extends ActivityProxyAdapter {
    FragmentManager proxyGetSupportFragmentManager();

    LoaderManager proxyGetSupportLoaderManager();

    void proxyOnAttachFragment(Fragment fragment);

    void proxySetFinishOnTouchOutside(boolean z);

    void proxyStartActivityFromFragment(Fragment fragment, Intent intent, int i2);
}
