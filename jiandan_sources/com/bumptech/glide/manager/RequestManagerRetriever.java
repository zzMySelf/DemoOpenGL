package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import fe.rg.qw.ad;
import fe.rg.qw.ggg.i;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.pf.rg;
import fe.rg.qw.th;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: i  reason: collision with root package name */
    public static final RequestManagerFactory f3746i = new qw();
    @VisibleForTesting

    /* renamed from: ad  reason: collision with root package name */
    public final Map<FragmentManager, RequestManagerFragment> f3747ad = new HashMap();
    @VisibleForTesting

    /* renamed from: de  reason: collision with root package name */
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f3748de = new HashMap();

    /* renamed from: fe  reason: collision with root package name */
    public final Handler f3749fe;
    public volatile th qw;

    /* renamed from: rg  reason: collision with root package name */
    public final RequestManagerFactory f3750rg;

    /* renamed from: th  reason: collision with root package name */
    public final ArrayMap<View, Fragment> f3751th = new ArrayMap<>();

    /* renamed from: uk  reason: collision with root package name */
    public final Bundle f3752uk = new Bundle();

    /* renamed from: yj  reason: collision with root package name */
    public final ArrayMap<View, android.app.Fragment> f3753yj = new ArrayMap<>();

    public interface RequestManagerFactory {
        @NonNull
        th qw(@NonNull ad adVar, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    public class qw implements RequestManagerFactory {
        @NonNull
        public th qw(@NonNull ad adVar, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new th(adVar, lifecycle, requestManagerTreeNode, context);
        }
    }

    public RequestManagerRetriever(@Nullable RequestManagerFactory requestManagerFactory) {
        this.f3750rg = requestManagerFactory == null ? f3746i : requestManagerFactory;
        this.f3749fe = new Handler(Looper.getMainLooper(), this);
    }

    public static boolean nn(Activity activity) {
        return !activity.isFinishing();
    }

    @TargetApi(17)
    public static void qw(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static void rg(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment next : collection) {
                if (!(next == null || next.getView() == null)) {
                    map.put(next.getView(), next);
                    rg(next.getChildFragmentManager().getFragments(), map);
                }
            }
        }
    }

    @Nullable
    public final Activity ad(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return ad(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @NonNull
    public final SupportRequestManagerFragment ddd(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f3748de.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.setParentFragmentHint(fragment);
            if (z) {
                supportRequestManagerFragment.getGlideLifecycle().fe();
            }
            this.f3748de.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add((Fragment) supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f3749fe.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    @TargetApi(26)
    @Deprecated
    public final void de(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment next : fragmentManager.getFragments()) {
                if (next.getView() != null) {
                    arrayMap.put(next.getView(), next);
                    de(next.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        fe(fragmentManager, arrayMap);
    }

    @Deprecated
    public final void fe(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.f3752uk.putInt("key", i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f3752uk, "key");
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    if (Build.VERSION.SDK_INT >= 17) {
                        de(fragment.getChildFragmentManager(), arrayMap);
                    }
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    @NonNull
    @Deprecated
    public RequestManagerFragment ggg(Activity activity) {
        return vvv(activity.getFragmentManager(), (android.app.Fragment) null, nn(activity));
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
            obj2 = this.f3747ad.remove(obj3);
        } else if (i2 != 2) {
            z = false;
            obj = null;
            if (z && obj4 == null && Log.isLoggable("RMRetriever", 5)) {
                "Failed to remove expected request manager fragment, manager: " + obj;
            }
            return z;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj2 = this.f3748de.remove(obj3);
        }
        Object obj5 = obj3;
        obj4 = obj2;
        obj = obj5;
        "Failed to remove expected request manager fragment, manager: " + obj;
        return z;
    }

    @NonNull
    public th i(@NonNull Activity activity) {
        if (i.ppp()) {
            return pf(activity.getApplicationContext());
        }
        qw(activity);
        return uk(activity, activity.getFragmentManager(), (android.app.Fragment) null, nn(activity));
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public th m253if(@NonNull View view) {
        if (i.ppp()) {
            return pf(view.getContext().getApplicationContext());
        }
        uk.fe(view);
        uk.rg(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity ad2 = ad(view.getContext());
        if (ad2 == null) {
            return pf(view.getContext().getApplicationContext());
        }
        if (ad2 instanceof FragmentActivity) {
            Fragment yj2 = yj(view, (FragmentActivity) ad2);
            return yj2 != null ? m254switch(yj2) : i(ad2);
        }
        android.app.Fragment th2 = th(view, ad2);
        if (th2 == null) {
            return i(ad2);
        }
        return o(th2);
    }

    @NonNull
    public final th mmm(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment ddd = ddd(fragmentManager, fragment, z);
        th requestManager = ddd.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        th qw2 = this.f3750rg.qw(ad.de(context), ddd.getGlideLifecycle(), ddd.getRequestManagerTreeNode(), context);
        ddd.setRequestManager(qw2);
        return qw2;
    }

    @TargetApi(17)
    @NonNull
    @Deprecated
    public th o(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (i.ppp() || Build.VERSION.SDK_INT < 17) {
            return pf(fragment.getActivity().getApplicationContext());
        } else {
            return uk(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }

    @NonNull
    public th pf(@NonNull Context context) {
        if (context != null) {
            if (i.ggg() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return when((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return i((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return pf(((ContextWrapper) context).getBaseContext());
                }
            }
            return ppp(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public final th ppp(@NonNull Context context) {
        if (this.qw == null) {
            synchronized (this) {
                if (this.qw == null) {
                    this.qw = this.f3750rg.qw(ad.de(context.getApplicationContext()), new fe.rg.qw.pf.ad(), new rg(), context.getApplicationContext());
                }
            }
        }
        return this.qw;
    }

    @NonNull
    /* renamed from: switch  reason: not valid java name */
    public th m254switch(@NonNull Fragment fragment) {
        uk.rg(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (i.ppp()) {
            return pf(fragment.getActivity().getApplicationContext());
        }
        return mmm(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @Deprecated
    @Nullable
    public final android.app.Fragment th(@NonNull View view, @NonNull Activity activity) {
        this.f3753yj.clear();
        de(activity.getFragmentManager(), this.f3753yj);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f3753yj.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f3753yj.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    public final th uk(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment vvv = vvv(fragmentManager, fragment, z);
        th requestManager = vvv.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        th qw2 = this.f3750rg.qw(ad.de(context), vvv.getGlideLifecycle(), vvv.getRequestManagerTreeNode(), context);
        vvv.setRequestManager(qw2);
        return qw2;
    }

    @NonNull
    public final RequestManagerFragment vvv(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = this.f3747ad.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.setParentFragmentHint(fragment);
            if (z) {
                requestManagerFragment.getGlideLifecycle().fe();
            }
            this.f3747ad.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f3749fe.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @NonNull
    public th when(@NonNull FragmentActivity fragmentActivity) {
        if (i.ppp()) {
            return pf(fragmentActivity.getApplicationContext());
        }
        qw(fragmentActivity);
        return mmm(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, nn(fragmentActivity));
    }

    @NonNull
    public SupportRequestManagerFragment xxx(FragmentActivity fragmentActivity) {
        return ddd(fragmentActivity.getSupportFragmentManager(), (Fragment) null, nn(fragmentActivity));
    }

    @Nullable
    public final Fragment yj(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f3751th.clear();
        rg(fragmentActivity.getSupportFragmentManager().getFragments(), this.f3751th);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f3751th.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f3751th.clear();
        return fragment;
    }
}
