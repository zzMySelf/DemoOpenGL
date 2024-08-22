package com.baidu.sapi2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Stack;

public class ActivityStackManager implements Application.ActivityLifecycleCallbacks {
    public Stack<Activity> stack;

    public static class Instance {
        public static ActivityStackManager INSTANCE = new ActivityStackManager();
    }

    public static ActivityStackManager getInstance() {
        return Instance.INSTANCE;
    }

    public void addActivity(Activity activity) {
        this.stack.add(activity);
    }

    public void finishActivity(Activity activity) {
        this.stack.pop().finish();
    }

    public void finishActivityClass(Class<Activity> cls) {
        if (cls != null) {
            Iterator it = this.stack.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                if (activity.getClass().equals(cls)) {
                    it.remove();
                    finishActivity(activity);
                }
            }
        }
    }

    public void finishAllActivity() {
        while (!this.stack.isEmpty()) {
            this.stack.pop().finish();
        }
    }

    public Activity getPenultimateActivity() {
        if (this.stack.isEmpty() || this.stack.size() < 2) {
            return null;
        }
        Stack<Activity> stack2 = this.stack;
        return (Activity) stack2.get(stack2.size() - 2);
    }

    public Activity getRealTopActivity() {
        int size = this.stack.size();
        if (size < 2) {
            return getTopActivity();
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Activity activity = (Activity) this.stack.get(i2);
            if (activity != null && !activity.isFinishing()) {
                return activity;
            }
        }
        return null;
    }

    public Activity getTopActivity() {
        if (!this.stack.isEmpty()) {
            return (Activity) this.stack.lastElement();
        }
        return null;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        addActivity(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        removeActivity(activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void register(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean removeActivity(Activity activity) {
        return this.stack.remove(activity);
    }

    public int searchActivity(Activity activity) {
        return this.stack.search(activity);
    }

    public void unRegister(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public ActivityStackManager() {
        this.stack = new Stack<>();
    }
}
