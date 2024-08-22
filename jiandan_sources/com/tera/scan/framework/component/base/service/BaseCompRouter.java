package com.tera.scan.framework.component.base.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tera.scan.framework.kernel.service.ISchedulerService;
import fe.mmm.qw.a.yj.qw.de;
import fe.mmm.qw.i.qw;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Keep
public class BaseCompRouter {
    public static final String TAG = "BaseCompRouter";
    public boolean hasInitMap = false;
    public Map<String, Object> mRouterBinderCache = new HashMap();
    public Map<String, Class<?>> mRouterBinderMapper = new HashMap();
    public Map<String, ISchedulerService> mRouterSchedulerCache = new HashMap();
    public Map<String, Class<?>> mRouterSchedulerMapper = new HashMap();

    public <T> T getBinderService(String str, de deVar, Context context) {
        Class<de> cls = de.class;
        if (!this.hasInitMap) {
            initMap();
        }
        qw.uk(TAG, "getBinderService  className:" + str);
        if (this.mRouterBinderCache.containsKey(str)) {
            return this.mRouterBinderCache.get(str);
        }
        try {
            if (this.mRouterBinderMapper.containsKey(str)) {
                T newInstance = this.mRouterBinderMapper.get(str).getConstructor(new Class[]{cls, Context.class}).newInstance(new Object[]{deVar, context});
                this.mRouterBinderCache.put(str, newInstance);
                return newInstance;
            }
        } catch (NoSuchMethodException e) {
            qw.uk(TAG, "check the generated class:" + str + "; it should have a default 'public accessible' and 'none parameter' constructor");
            e.printStackTrace();
        } catch (InstantiationException e2) {
            qw.uk(TAG, "check the generated class:" + str + "; it should have a default 'public accessible' and 'none parameter' constructor");
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            qw.uk(TAG, "check the generated class:" + str + "; it should have a default 'public accessible' and 'none parameter' constructor");
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        qw.uk(TAG, "getBinderService  mRouterSchedulerCache");
        if (this.mRouterSchedulerCache.containsKey(str)) {
            return this.mRouterSchedulerCache.get(str);
        }
        try {
            if (this.mRouterSchedulerMapper.containsKey(str)) {
                T t = (ISchedulerService) this.mRouterSchedulerMapper.get(str).getConstructor(new Class[]{cls}).newInstance(new Object[]{deVar});
                this.mRouterSchedulerCache.put(str, t);
                return t;
            }
        } catch (NoSuchMethodException e5) {
            qw.uk(TAG, "check the generated class:" + str + "; it should have a default 'public accessible' and 'none parameter' constructor");
            e5.printStackTrace();
        } catch (InstantiationException e6) {
            qw.uk(TAG, "check the generated class:" + str + "; it should have a default 'public accessible' and 'none parameter' constructor");
            e6.printStackTrace();
        } catch (IllegalAccessException e7) {
            qw.uk(TAG, "check the generated class:" + str + "; it should have a default 'public accessible' and 'none parameter' constructor");
            e7.printStackTrace();
        } catch (InvocationTargetException e8) {
            e8.printStackTrace();
        }
        qw.uk(TAG, "no match service type:" + str);
        return null;
    }

    public ISchedulerService getSchedulerService(Intent intent, de deVar) {
        if (!this.hasInitMap) {
            initMap();
        }
        String stringExtra = intent.getStringExtra("com.mars.EXTRA_SERVICE_COMPONENT");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        qw.uk(TAG, "getSchedulerService  componentName:" + stringExtra);
        if (this.mRouterSchedulerCache.containsKey(stringExtra)) {
            return this.mRouterSchedulerCache.get(stringExtra);
        }
        try {
            if (this.mRouterSchedulerMapper.containsKey(stringExtra)) {
                ISchedulerService iSchedulerService = (ISchedulerService) this.mRouterSchedulerMapper.get(stringExtra).getConstructor(new Class[]{de.class}).newInstance(new Object[]{deVar});
                this.mRouterSchedulerCache.put(stringExtra, iSchedulerService);
                return iSchedulerService;
            }
        } catch (NoSuchMethodException e) {
            qw.uk(TAG, "check the generated class:" + stringExtra + "; it should have a default 'public accessible' and 'none parameter' constructor");
            e.printStackTrace();
        } catch (InstantiationException e2) {
            qw.uk(TAG, "check the generated class:" + stringExtra + "; it should have a default 'public accessible' and 'none parameter' constructor");
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            qw.uk(TAG, "check the generated class:" + stringExtra + "; it should have a default 'public accessible' and 'none parameter' constructor");
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        qw.uk(TAG, "no match service type:" + stringExtra);
        return null;
    }

    public void initMap() {
        this.hasInitMap = true;
    }
}
