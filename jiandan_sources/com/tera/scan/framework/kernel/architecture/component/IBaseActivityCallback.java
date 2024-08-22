package com.tera.scan.framework.kernel.architecture.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public interface IBaseActivityCallback {
    <T> T getService(String str);

    void onActivityResult(int i2, int i3, Intent intent);

    void onCreate(Bundle bundle);

    void onPause();

    void onStart();

    void onStop();

    void qw(Activity activity);
}
