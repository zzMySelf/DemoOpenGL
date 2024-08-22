package com.baidu.swan.apps.util.typedbox;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0002H\u00022\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007\u001a_\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0002H\u00022\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005¢\u0006\u0002\b\u00062\u001d\u0010\b\u001a\u0019\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"modelDataDelegate", "Lcom/baidu/swan/apps/util/typedbox/ModelDataDelegate;", "Model", "Data", "getter", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lcom/baidu/swan/apps/util/typedbox/ModelDataDelegate;", "setter", "Lkotlin/Function2;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/baidu/swan/apps/util/typedbox/ModelDataDelegate;", "lib-swan-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModelDelegate<T>.kt */
public final class ModelDelegate_T_Kt {
    public static final <Model, Data> ModelDataDelegate<Model, Data> modelDataDelegate(Model $this$modelDataDelegate, Function1<? super Model, ? extends Data> getter) {
        Intrinsics.checkNotNullParameter(getter, "getter");
        return modelDataDelegate($this$modelDataDelegate, getter, ModelDelegate_T_Kt$modelDataDelegate$1.INSTANCE);
    }

    public static final <Model, Data> ModelDataDelegate<Model, Data> modelDataDelegate(Model $this$modelDataDelegate, Function1<? super Model, ? extends Data> getter, Function2<? super Model, ? super Data, Unit> setter) {
        Intrinsics.checkNotNullParameter(getter, "getter");
        Intrinsics.checkNotNullParameter(setter, "setter");
        return new ModelDataDelegate<>($this$modelDataDelegate, getter, setter);
    }
}
