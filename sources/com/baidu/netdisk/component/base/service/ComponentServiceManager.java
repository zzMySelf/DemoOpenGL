package com.baidu.netdisk.component.base.service;

import android.app.Notification;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

public class ComponentServiceManager {
    private static final String TAG = "ComponentServiceManager";
    private static ComponentServiceManager mInstance;
    private ArrayList<IComponentService> mIComponentServiceList = new ArrayList<>();

    private ComponentServiceManager() {
    }

    public static synchronized ComponentServiceManager getInstance() {
        ComponentServiceManager componentServiceManager;
        synchronized (ComponentServiceManager.class) {
            if (mInstance == null) {
                mInstance = new ComponentServiceManager();
            }
            componentServiceManager = mInstance;
        }
        return componentServiceManager;
    }

    public void registerComponentService(IComponentService componentService) {
        ArrayList<IComponentService> arrayList;
        if (componentService != null && (arrayList = this.mIComponentServiceList) != null && arrayList.contains(componentService)) {
            this.mIComponentServiceList.add(componentService);
        }
    }

    public void unregisterComponentService(IComponentService componentService) {
        ArrayList<IComponentService> arrayList;
        if (componentService != null && (arrayList = this.mIComponentServiceList) != null && arrayList.contains(componentService)) {
            this.mIComponentServiceList.remove(componentService);
        }
    }

    public void onCreate() {
        ArrayList<IComponentService> arrayList = this.mIComponentServiceList;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<IComponentService> it = this.mIComponentServiceList.iterator();
            while (it.hasNext()) {
                it.next().onCreate();
            }
        }
    }

    public void onStart(Intent intent, int startId) {
        ArrayList<IComponentService> arrayList = this.mIComponentServiceList;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<IComponentService> it = this.mIComponentServiceList.iterator();
            while (it.hasNext()) {
                it.next().onStart(intent, startId);
            }
        }
    }

    public void onDestroy() {
        ArrayList<IComponentService> arrayList = this.mIComponentServiceList;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<IComponentService> it = this.mIComponentServiceList.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }

    public void onStartForeground(int id, Notification notification) {
        ArrayList<IComponentService> arrayList = this.mIComponentServiceList;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<IComponentService> it = this.mIComponentServiceList.iterator();
            while (it.hasNext()) {
                it.next().startForeground(id, notification);
            }
        }
    }

    public void onStopForeground(boolean removeNotification) {
        ArrayList<IComponentService> arrayList = this.mIComponentServiceList;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<IComponentService> it = this.mIComponentServiceList.iterator();
            while (it.hasNext()) {
                it.next().stopForeground(removeNotification);
            }
        }
    }
}
