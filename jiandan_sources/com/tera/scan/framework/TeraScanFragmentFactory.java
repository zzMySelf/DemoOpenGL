package com.tera.scan.framework;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\u000f\u001a\u00020\u001028\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\tJ\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006RF\u0010\u0007\u001a:\u00126\u00124\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/tera/scan/framework/TeraScanFragmentFactory;", "Landroidx/fragment/app/FragmentFactory;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "instantiators", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "className", "Landroidx/fragment/app/Fragment;", "addFragmentInstantiator", "", "instantiator", "instantiate", "classLoader", "Ljava/lang/ClassLoader;", "framework-android_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TeraScanFragmentFactory extends FragmentFactory {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final CopyOnWriteArrayList<Function2<String, FragmentActivity, Fragment>> f6944ad = new CopyOnWriteArrayList<>();
    @NotNull
    public final FragmentActivity qw;

    public TeraScanFragmentFactory(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.qw = fragmentActivity;
    }

    public final void addFragmentInstantiator(@NotNull Function2<? super String, ? super FragmentActivity, ? extends Fragment> function2) {
        Intrinsics.checkNotNullParameter(function2, "instantiator");
        this.f6944ad.add(function2);
    }

    @NotNull
    public final FragmentActivity getActivity() {
        return this.qw;
    }

    @NotNull
    public Fragment instantiate(@NotNull ClassLoader classLoader, @NotNull String str) {
        R r;
        boolean z;
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(str, "className");
        Iterator<R> it = SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.f6944ad), new TeraScanFragmentFactory$instantiate$fragment$1(str, this)).iterator();
        while (true) {
            if (!it.hasNext()) {
                r = null;
                break;
            }
            r = it.next();
            if (((Fragment) r) != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Fragment fragment = (Fragment) r;
        if (fragment != null) {
            return fragment;
        }
        Fragment instantiate = super.instantiate(classLoader, str);
        Intrinsics.checkNotNullExpressionValue(instantiate, "super.instantiate(classLoader, className)");
        return instantiate;
    }
}
