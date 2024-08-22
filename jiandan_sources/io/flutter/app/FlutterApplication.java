package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.CallSuper;
import io.flutter.FlutterInjector;

public class FlutterApplication extends Application {
    public Activity mCurrentActivity = null;

    public Activity getCurrentActivity() {
        return this.mCurrentActivity;
    }

    @CallSuper
    public void onCreate() {
        super.onCreate();
        FlutterInjector.instance().flutterLoader().startInitialization(this);
    }

    public void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = activity;
    }
}
