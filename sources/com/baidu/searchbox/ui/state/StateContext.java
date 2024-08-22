package com.baidu.searchbox.ui.state;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.NoProGuard;

public interface StateContext extends NoProGuard {
    Context getContext();

    Intent getIntent();

    void onActivityDestroy();

    void onCreate(Bundle bundle, Bundle bundle2);

    void onDestroy();

    void onPause();

    void onResume();

    void setIntent(Intent intent);

    void setStateResult(int i2, Intent intent);

    void startState(Class<? extends ActivityState> cls);

    void startState(Class<? extends ActivityState> cls, Bundle bundle);

    void startStateForResult(Class<? extends ActivityState> cls, int i2);

    void startStateForResult(Class<? extends ActivityState> cls, int i2, Bundle bundle);
}
