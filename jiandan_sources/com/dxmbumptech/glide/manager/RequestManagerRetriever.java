package com.dxmbumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.dxmbumptech.glide.Glide;
import fe.uk.qw.de;
import fe.uk.qw.p021if.ad;
import fe.uk.qw.p021if.i;
import fe.uk.qw.p021if.th;
import fe.uk.qw.p021if.uk;
import fe.uk.qw.pf.th.fe.ppp;
import fe.uk.qw.rg;
import fe.uk.qw.vvv.o;
import fe.uk.qw.yj;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: yj  reason: collision with root package name */
    public static final RequestManagerFactory f3931yj = new qw();
    @VisibleForTesting

    /* renamed from: ad  reason: collision with root package name */
    public final Map<FragmentManager, RequestManagerFragment> f3932ad = new HashMap();
    @VisibleForTesting

    /* renamed from: de  reason: collision with root package name */
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f3933de = new HashMap();

    /* renamed from: fe  reason: collision with root package name */
    public final Handler f3934fe;
    public volatile yj qw;

    /* renamed from: rg  reason: collision with root package name */
    public final RequestManagerFactory f3935rg;

    /* renamed from: th  reason: collision with root package name */
    public final i f3936th;

    public interface RequestManagerFactory {
        @NonNull
        yj qw(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    public class qw implements RequestManagerFactory {
        @NonNull
        public yj qw(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new yj(glide, lifecycle, requestManagerTreeNode, context);
        }
    }

    public RequestManagerRetriever(@Nullable RequestManagerFactory requestManagerFactory, rg rgVar) {
        new ArrayMap();
        new ArrayMap();
        new Bundle();
        this.f3935rg = requestManagerFactory == null ? f3931yj : requestManagerFactory;
        this.f3934fe = new Handler(Looper.getMainLooper(), this);
        this.f3936th = ad(rgVar);
    }

    public static i ad(rg rgVar) {
        if (!ppp.f5968uk || !ppp.f5969yj) {
            return new fe.uk.qw.p021if.rg();
        }
        if (rgVar.qw(de.fe.class)) {
            return new fe.uk.qw.p021if.yj();
        }
        return new uk();
    }

    @Nullable
    public static Activity de(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return de(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(17)
    public static void qw(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static boolean m267switch(Context context) {
        Activity de2 = de(context);
        return de2 == null || !de2.isFinishing();
    }

    @NonNull
    @Deprecated
    public final yj fe(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        RequestManagerFragment o2 = o(fragmentManager, fragment);
        yj requestManager = o2.getRequestManager();
        if (requestManager == null) {
            requestManager = this.f3935rg.qw(Glide.de(context), o2.getGlideLifecycle(), o2.getRequestManagerTreeNode(), context);
            if (z) {
                requestManager.onStart();
            }
            o2.setRequestManager(requestManager);
        }
        return requestManager;
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        int i2 = message.what;
        Object obj4 = null;
        boolean z = true;
        if (i2 == 1) {
            obj3 = (FragmentManager) message.obj;
            obj2 = this.f3932ad.remove(obj3);
        } else if (i2 != 2) {
            z = false;
            obj = null;
            if (z && obj4 == null && Log.isLoggable("RMRetriever", 5)) {
                "Failed to remove expected request manager fragment, manager: " + obj;
            }
            return z;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj2 = this.f3933de.remove(obj3);
        }
        Object obj5 = obj3;
        obj4 = obj2;
        obj = obj5;
        "Failed to remove expected request manager fragment, manager: " + obj;
        return z;
    }

    @NonNull
    @Deprecated
    public RequestManagerFragment i(Activity activity) {
        return o(activity.getFragmentManager(), (Fragment) null);
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public final SupportRequestManagerFragment m268if(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable androidx.fragment.app.Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.dxmbumptech.glide.manager");
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        SupportRequestManagerFragment supportRequestManagerFragment2 = this.f3933de.get(fragmentManager);
        if (supportRequestManagerFragment2 != null) {
            return supportRequestManagerFragment2;
        }
        SupportRequestManagerFragment supportRequestManagerFragment3 = new SupportRequestManagerFragment();
        supportRequestManagerFragment3.setParentFragmentHint(fragment);
        this.f3933de.put(fragmentManager, supportRequestManagerFragment3);
        fragmentManager.beginTransaction().add((androidx.fragment.app.Fragment) supportRequestManagerFragment3, "com.dxmbumptech.glide.manager").commitAllowingStateLoss();
        this.f3934fe.obtainMessage(2, fragmentManager).sendToTarget();
        return supportRequestManagerFragment3;
    }

    @NonNull
    public final RequestManagerFragment o(@NonNull FragmentManager fragmentManager, @Nullable Fragment fragment) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.dxmbumptech.glide.manager");
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        RequestManagerFragment requestManagerFragment2 = this.f3932ad.get(fragmentManager);
        if (requestManagerFragment2 != null) {
            return requestManagerFragment2;
        }
        RequestManagerFragment requestManagerFragment3 = new RequestManagerFragment();
        requestManagerFragment3.setParentFragmentHint(fragment);
        this.f3932ad.put(fragmentManager, requestManagerFragment3);
        fragmentManager.beginTransaction().add(requestManagerFragment3, "com.dxmbumptech.glide.manager").commitAllowingStateLoss();
        this.f3934fe.obtainMessage(1, fragmentManager).sendToTarget();
        return requestManagerFragment3;
    }

    @NonNull
    public SupportRequestManagerFragment pf(androidx.fragment.app.FragmentManager fragmentManager) {
        return m268if(fragmentManager, (androidx.fragment.app.Fragment) null);
    }

    @NonNull
    public yj rg(@NonNull Activity activity) {
        if (o.ggg()) {
            return th(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return yj((FragmentActivity) activity);
        }
        qw(activity);
        this.f3936th.qw(activity);
        return fe(activity, activity.getFragmentManager(), (Fragment) null, m267switch(activity));
    }

    @NonNull
    public yj th(@NonNull Context context) {
        if (context != null) {
            if (o.vvv() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return yj((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return rg((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return th(contextWrapper.getBaseContext());
                    }
                }
            }
            return uk(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public final yj uk(@NonNull Context context) {
        if (this.qw == null) {
            synchronized (this) {
                if (this.qw == null) {
                    this.qw = this.f3935rg.qw(Glide.de(context.getApplicationContext()), new ad(), new th(), context.getApplicationContext());
                }
            }
        }
        return this.qw;
    }

    @NonNull
    public final yj when(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable androidx.fragment.app.Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = m268if(fragmentManager, fragment);
        yj requestManager = supportRequestManagerFragment.getRequestManager();
        if (requestManager == null) {
            requestManager = this.f3935rg.qw(Glide.de(context), supportRequestManagerFragment.getGlideLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode(), context);
            if (z) {
                requestManager.onStart();
            }
            supportRequestManagerFragment.setRequestManager(requestManager);
        }
        return requestManager;
    }

    @NonNull
    public yj yj(@NonNull FragmentActivity fragmentActivity) {
        if (o.ggg()) {
            return th(fragmentActivity.getApplicationContext());
        }
        qw(fragmentActivity);
        this.f3936th.qw(fragmentActivity);
        return when(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (androidx.fragment.app.Fragment) null, m267switch(fragmentActivity));
    }
}
