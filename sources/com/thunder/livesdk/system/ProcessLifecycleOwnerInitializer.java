package com.thunder.livesdk.system;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import java.util.HashSet;

public class ProcessLifecycleOwnerInitializer extends ContentProvider implements Application.ActivityLifecycleCallbacks {
    private HashSet<Integer> m_activity_hashes = new HashSet<>();

    public boolean onCreate() {
        Context appCtx = getContext().getApplicationContext();
        if (appCtx instanceof Application) {
            ((Application) appCtx).registerActivityLifecycleCallbacks(this);
            return false;
        }
        throw new RuntimeException("no application instance!");
    }

    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        LcLogger.d("onActivityCreated " + activity);
    }

    public void onActivityStarted(Activity activity) {
        LcLogger.d("onActivityStarted " + activity);
        LifecycleEventDispatcher.dispatchEvent(true);
        this.m_activity_hashes.add(Integer.valueOf(activity.hashCode()));
    }

    public void onActivityResumed(Activity activity) {
        LcLogger.d("onActivityResumed " + activity);
    }

    public void onActivityPaused(Activity activity) {
        LcLogger.d("onActivityPaused " + activity);
    }

    public void onActivityStopped(Activity activity) {
        LcLogger.d("onActivityStopped " + activity);
        if (this.m_activity_hashes.contains(Integer.valueOf(activity.hashCode()))) {
            LifecycleEventDispatcher.dispatchEvent(false);
            this.m_activity_hashes.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        LcLogger.d("onActivitySaveInstanceState " + activity);
    }

    public void onActivityDestroyed(Activity activity) {
        LcLogger.d("onActivityDestroyed " + activity);
    }
}
