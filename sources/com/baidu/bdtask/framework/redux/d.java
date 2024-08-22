package com.baidu.bdtask.framework.redux;

import com.baidu.bdtask.framework.redux.a;
import com.baidu.bdtask.framework.redux.c;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.feed.detail.arch.anno.UnicastReceiverType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B½\u0002\u0012B\u0010\u0006\u001a>\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00000\u0007j\b\u0012\u0004\u0012\u00028\u0000`\f\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012é\u0001\b\u0002\u0010\r\u001aâ\u0001\u0012Ý\u0001\u0012Ú\u0001\u0012A\u0012?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\u000fj\u0011`\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0013¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0014\u0012l\u0012j\u0012A\u0012?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\u000fj\u0011`\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012#\u0012!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00110\u000f0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u00150\u000e¢\u0006\u0002\u0010\u0016J\u0015\u0010)\u001a\u00020\u00102\u0006\u0010\n\u001a\u00028\u0001H\u0003¢\u0006\u0002\u0010*J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0004H\u0017J\b\u0010+\u001a\u00020\u0010H\u0016JY\u0010,\u001a\u00020\u0010\"\u0004\b\u0002\u0010-\"\u000e\b\u0003\u0010.*\b\u0012\u0004\u0012\u0002H-0/2\u0006\u00100\u001a\u0002H.2,\u00101\u001a(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00028\u000102\u0018\u00010\u000fH\u0016¢\u0006\u0002\u00103R:\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00182\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0018@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001a\u0010\u001bR9\u0010\u001c\u001a!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 RJ\u0010\u0006\u001a>\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00000\u0007j\b\u0012\u0004\u0012\u00028\u0000`\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010!R.\u0010\"\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00028\u0001\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00064"}, d2 = {"Lcom/baidu/bdtask/framework/redux/Store;", "State", "Lcom/baidu/bdtask/framework/redux/StateType;", "AT", "Lcom/baidu/bdtask/framework/redux/Action;", "Lcom/baidu/bdtask/framework/redux/IStore;", "reducer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "state", "Lcom/baidu/bdtask/framework/redux/Reducer;", "middleware", "", "Lkotlin/Function1;", "", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", "dispatch", "Lkotlin/Function0;", "getState", "Lcom/baidu/bdtask/framework/redux/Middleware;", "(Lkotlin/jvm/functions/Function2;Lcom/baidu/bdtask/framework/redux/StateType;Ljava/util/List;)V", "value", "Lkotlin/Pair;", "_state", "set_state", "(Lkotlin/Pair;)V", "dispatchFunction", "getDispatchFunction", "()Lkotlin/jvm/functions/Function1;", "setDispatchFunction", "(Lkotlin/jvm/functions/Function1;)V", "()Lcom/baidu/bdtask/framework/redux/StateType;", "subscription", "Lcom/baidu/bdtask/framework/redux/SubscriptionBox;", "", "getSubscription", "()Lcom/baidu/bdtask/framework/redux/SubscriptionBox;", "setSubscription", "(Lcom/baidu/bdtask/framework/redux/SubscriptionBox;)V", "_defaultDispatch", "(Lcom/baidu/bdtask/framework/redux/Action;)V", "releaseSubscribe", "setSubscribe", "SelectedState", "S", "Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;", "subscriber", "transform", "Lcom/baidu/bdtask/framework/redux/Subscription;", "(Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;Lkotlin/jvm/functions/Function1;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class d<State extends c<State>, AT extends a> {

    /* renamed from: a  reason: collision with root package name */
    private f<State, Object, AT> f10833a;

    /* renamed from: b  reason: collision with root package name */
    private Pair<? extends State, ? extends AT> f10834b;

    /* renamed from: c  reason: collision with root package name */
    private Function1<? super a, Unit> f10835c;

    /* renamed from: d  reason: collision with root package name */
    private final Function2<a, State, State> f10836d;

    public d(Function2<? super a, ? super State, ? extends State> function2, State state, List<? extends Function2<? super Function1<? super a, Unit>, ? super Function0<? extends State>, ? extends Function1<? super Function1<? super a, Unit>, ? extends Function1<? super a, Unit>>>> list) {
        Intrinsics.checkParameterIsNotNull(function2, UnicastReceiverType.REDUCER);
        Intrinsics.checkParameterIsNotNull(state, "state");
        Intrinsics.checkParameterIsNotNull(list, UnicastReceiverType.MIDDLEWARE);
        this.f10836d = function2;
        this.f10834b = new Pair<>(state, null);
        a(new Pair(state, null));
        Function1<? super a, Unit> store$dispatchFunction$1 = new Store$dispatchFunction$1(this);
        for (Function2 invoke : CollectionsKt.reversed(list)) {
            store$dispatchFunction$1 = (Function1) ((Function1) invoke.invoke(new Store$$special$$inlined$fold$lambda$1(this), new Store$$special$$inlined$fold$lambda$2(this))).invoke(store$dispatchFunction$1);
        }
        this.f10835c = store$dispatchFunction$1;
    }

    private final void a(Pair<? extends State, ? extends AT> pair) {
        this.f10834b = pair;
        f<State, Object, AT> fVar = this.f10833a;
        if (fVar != null) {
            fVar.a((c) pair.getFirst(), (a) pair.getSecond());
        }
    }

    public State a() {
        return (c) this.f10834b.getFirst();
    }

    public Function1<a, Unit> b() {
        return this.f10835c;
    }

    /* access modifiers changed from: private */
    public final synchronized void b(AT at) {
        a(new Pair((c) this.f10836d.invoke(at, a()), at));
    }

    public <SelectedState, S extends b<SelectedState>> void a(S s, Function1<? super e<State, AT>, e<SelectedState, AT>> function1) {
        Intrinsics.checkParameterIsNotNull(s, "subscriber");
        if (this.f10833a == null) {
            e eVar = new e();
            this.f10833a = new f<>(eVar, function1 != null ? function1.invoke(eVar) : null, s);
        }
    }

    public synchronized void a(a aVar) {
        Intrinsics.checkParameterIsNotNull(aVar, "action");
        DebugTrace.debug$default(DebugTrace.INSTANCE, "dispatch：" + aVar.e(), "state", (Function0) null, 4, (Object) null);
        b().invoke(aVar);
    }
}
