package com.baidu.apollon.base;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.LogUtil;
import java.util.Iterator;
import java.util.LinkedList;

public class ApollonBaseActivity extends Activity implements NoProguard {
    public static final String a = "ApollonBaseActivity";
    public static LinkedList<ApollonBaseActivity> mActivityStack = new LinkedList<>();
    public static int mLiveActivityNum = 0;
    public int mFlag = -1;

    public static void addLiveActivityNum() {
        mLiveActivityNum++;
    }

    public static synchronized void addToTask(ApollonBaseActivity apollonBaseActivity) {
        synchronized (ApollonBaseActivity.class) {
            mActivityStack.remove(apollonBaseActivity);
            mActivityStack.add(apollonBaseActivity);
        }
    }

    public static synchronized void clearTask() {
        synchronized (ApollonBaseActivity.class) {
            Iterator it = mActivityStack.iterator();
            while (it.hasNext()) {
                ((ApollonBaseActivity) it.next()).finish();
            }
        }
    }

    public static synchronized void clearTaskExcept(ApollonBaseActivity apollonBaseActivity) {
        synchronized (ApollonBaseActivity.class) {
            Iterator it = mActivityStack.iterator();
            while (it.hasNext()) {
                ApollonBaseActivity apollonBaseActivity2 = (ApollonBaseActivity) it.next();
                if (apollonBaseActivity2 != apollonBaseActivity) {
                    apollonBaseActivity2.finish();
                }
            }
        }
    }

    public static synchronized void clearTasksTopOf(ApollonBaseActivity apollonBaseActivity) {
        synchronized (ApollonBaseActivity.class) {
            LogUtil.d(a, "clearTasksTopOf. stack size = " + mActivityStack.size());
            int size = mActivityStack.size() + -1;
            while (true) {
                if (size <= 0) {
                    break;
                }
                ApollonBaseActivity apollonBaseActivity2 = mActivityStack.get(size);
                if (apollonBaseActivity2 == apollonBaseActivity) {
                    break;
                }
                apollonBaseActivity2.finish();
                size--;
            }
        }
    }

    public static synchronized void clearTasksWithFlag(int i2) {
        synchronized (ApollonBaseActivity.class) {
            LogUtil.d(a, "clearTasksWithFlag. stack size = " + mActivityStack.size());
            Iterator it = mActivityStack.iterator();
            while (it.hasNext()) {
                ApollonBaseActivity apollonBaseActivity = (ApollonBaseActivity) it.next();
                if (apollonBaseActivity.mFlag == i2) {
                    apollonBaseActivity.finish();
                    apollonBaseActivity.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static void decLiveActivityNum() {
        mLiveActivityNum--;
    }

    public static ApollonBaseActivity getTopActivity() throws Throwable {
        return mActivityStack.getLast();
    }

    public static boolean isAppInForeground() {
        return mLiveActivityNum > 0;
    }

    public static synchronized void removeFromTask(ApollonBaseActivity apollonBaseActivity) {
        synchronized (ApollonBaseActivity.class) {
            mActivityStack.remove(apollonBaseActivity);
        }
    }

    public Activity getActivity() {
        return this;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addToTask(this);
    }

    public void onDestroy() {
        super.onDestroy();
        removeFromTask(this);
    }

    public void onPause() {
        super.onPause();
        decLiveActivityNum();
    }

    public void onResume() {
        super.onResume();
        addLiveActivityNum();
    }
}
