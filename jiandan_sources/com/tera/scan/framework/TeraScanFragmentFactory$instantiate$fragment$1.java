package com.tera.scan.framework;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012r\u0010\u0002\u001an\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001 \n*6\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "it", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "className", "Landroidx/fragment/app/FragmentActivity;", "activity", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TeraScanFragmentFactory$instantiate$fragment$1 extends Lambda implements Function1<Function2<? super String, ? super FragmentActivity, ? extends Fragment>, Fragment> {
    public final /* synthetic */ String $className;
    public final /* synthetic */ TeraScanFragmentFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TeraScanFragmentFactory$instantiate$fragment$1(String str, TeraScanFragmentFactory teraScanFragmentFactory) {
        super(1);
        this.$className = str;
        this.this$0 = teraScanFragmentFactory;
    }

    @Nullable
    public final Fragment invoke(Function2<? super String, ? super FragmentActivity, ? extends Fragment> function2) {
        return (Fragment) function2.invoke(this.$className, this.this$0.getActivity());
    }
}
