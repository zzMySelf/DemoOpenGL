package com.baidu.netdisk.trade.privilege;

import ad.qw.qw.qw.qw.ad.ad.ad;
import ad.qw.qw.qw.qw.ad.ad.de;
import ad.qw.qw.qw.qw.ad.ad.qw;
import androidx.annotation.MainThread;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.netdisk.trade.privilege.config.IStore;
import com.baidu.netdisk.trade.privilege.io.model.Privilege;
import i.qw.Cif;
import i.qw.i0;
import i.qw.j;
import i.qw.o;
import i.qw.u;
import i.qw.z0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\bJ\u0010\bJ\u0017\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\r\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001eJ\u0017\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\u001d\u0010%\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0#H\u0007¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020\u0003H\u0001¢\u0006\u0004\b'\u0010\bJ\u000f\u0010)\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010\bJ\u001f\u0010.\u001a\u00020\u00032\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010*H\u0000¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b/\u00100J\u0015\u0010/\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b/\u00101J\u000f\u00102\u001a\u00020\u0003H\u0007¢\u0006\u0004\b2\u0010\bJ\u000f\u00103\u001a\u00020\u0003H\u0007¢\u0006\u0004\b3\u0010\bJ\u0019\u00105\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u00020\u00032\b\u00107\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b8\u00106J!\u0010;\u001a\u00020\u00032\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000109H\u0007¢\u0006\u0004\b;\u0010<R\u001e\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b>\u0010?R\u001e\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020 0C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001a0F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00010C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010E\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006K"}, d2 = {"Lcom/baidu/netdisk/trade/privilege/TradeAccount;", "Lcom/baidu/netdisk/trade/privilege/PCombineProduct;", "p", "", "addPCombineProduct$TradeMemberPrivilege_release", "(Lcom/baidu/netdisk/trade/privilege/PCombineProduct;)V", "addPCombineProduct", "clearProduct$TradeMemberPrivilege_release", "()V", "clearProduct", "", "privilegeId", "fsId", "Lkotlin/Function2;", "", "", "callable", "consumeFreeCount", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/Function2;)V", "getGrowthLevel", "()I", "getLocalGrowthLevel", "getLocalMemberLevel", "getMemberLevel", "Lcom/baidu/netdisk/trade/privilege/MemberProduct;", "product", "", "getMemberOverdueTime", "(Lcom/baidu/netdisk/trade/privilege/MemberProduct;)J", "productName", "(Ljava/lang/String;)J", "id", "Lcom/baidu/netdisk/trade/privilege/io/model/Privilege;", "getPrivilege", "(Ljava/lang/String;)Lcom/baidu/netdisk/trade/privilege/io/model/Privilege;", "Landroidx/lifecycle/Observer;", "onSyncFinish", "getUserPrivilege", "(Landroidx/lifecycle/Observer;)V", "initLocal$TradeMemberPrivilege_release", "initLocal", "initLocalProduct", "", "list", "initPrivilege$TradeMemberPrivilege_release", "(Ljava/util/List;)V", "initPrivilege", "isMember", "(Lcom/baidu/netdisk/trade/privilege/MemberProduct;)Z", "(Ljava/lang/String;)Z", "onLogin", "onLogout", "growthLevelValue", "setGrowthLevel", "(Ljava/lang/Integer;)V", "level", "setMemberLevel", "Lkotlin/Function0;", "callback", "syncUserPrivilege", "(Lkotlin/Function0;)V", "Lcom/baidu/netdisk/trade/privilege/io/model/GrowthLevel;", "growthLevel", "Lcom/baidu/netdisk/trade/privilege/io/model/GrowthLevel;", "Lcom/baidu/netdisk/trade/privilege/io/model/Identity;", "identity", "Lcom/baidu/netdisk/trade/privilege/io/model/Identity;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "privileges", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/lifecycle/MutableLiveData;", "productEndTimeLiveData", "Landroidx/lifecycle/MutableLiveData;", "products", "<init>", "TradeMemberPrivilege_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class TradeAccount {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile qw f910ad;

    /* renamed from: de  reason: collision with root package name */
    public static volatile ad f911de;

    /* renamed from: fe  reason: collision with root package name */
    public static final CopyOnWriteArrayList<Privilege> f912fe = new CopyOnWriteArrayList<>();
    public static final CopyOnWriteArrayList<ad.qw.qw.qw.qw.qw> qw = new CopyOnWriteArrayList<>();

    /* renamed from: rg  reason: collision with root package name */
    public static final TradeAccount f913rg = new TradeAccount();

    public static final class _ extends Lambda implements Function1<ad.qw.qw.qw.qw.qw, Boolean> {

        /* renamed from: _  reason: collision with root package name */
        public final /* synthetic */ ad.qw.qw.qw.qw.qw f914_;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public _(ad.qw.qw.qw.qw.qw qwVar) {
            super(1);
            this.f914_ = qwVar;
        }

        public final boolean _(ad.qw.qw.qw.qw.qw qwVar) {
            return Intrinsics.areEqual((Object) qwVar.qw(), (Object) this.f914_.qw());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(_((ad.qw.qw.qw.qw.qw) obj));
        }
    }

    @DebugMetadata(c = "com.baidu.netdisk.trade.privilege.TradeAccount$consumeFreeCount$1", f = "TradeAccount.kt", i = {0, 0}, l = {248}, m = "invokeSuspend", n = {"$this$launch", "result"}, s = {"L$0", "L$1"})
    public static final class __ extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: _  reason: collision with root package name */
        public CoroutineScope f915_;
        public Object __;
        public Object ___;
        public int ____;
        public final /* synthetic */ String _____;
        public final /* synthetic */ String ______;
        public final /* synthetic */ Function2 a;

        @DebugMetadata(c = "com.baidu.netdisk.trade.privilege.TradeAccount$consumeFreeCount$1$1", f = "TradeAccount.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class _ extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: _  reason: collision with root package name */
            public CoroutineScope f916_;
            public int __;
            public final /* synthetic */ __ ___;
            public final /* synthetic */ Pair ____;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public _(__ __2, Pair pair, Continuation continuation) {
                super(2, continuation);
                this.___ = __2;
                this.____ = pair;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                _ _2 = new _(this.___, this.____, continuation);
                _2.f916_ = (CoroutineScope) obj;
                return _2;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((_) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.__ == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2 function2 = this.___.a;
                    if (function2 != null) {
                        Unit unit = (Unit) function2.invoke(this.____.getFirst(), this.____.getSecond());
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public __(String str, String str2, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this._____ = str;
            this.______ = str2;
            this.a = function2;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            __ __2 = new __(this._____, this.______, this.a, continuation);
            __2.f915_ = (CoroutineScope) obj;
            return __2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((__) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.____;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.f915_;
                Pair<Boolean, Integer> qw = new ad.qw.qw.qw.qw.ad.qw.qw().qw(this._____, this.______);
                z0 de2 = u.de();
                _ _2 = new _(this, qw, (Continuation) null);
                this.__ = coroutineScope;
                this.___ = qw;
                this.____ = 1;
                if (o.yj(de2, _2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 1) {
                Pair pair = (Pair) this.___;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.__;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.baidu.netdisk.trade.privilege.TradeAccount$getUserPrivilege$1", f = "TradeAccount.kt", i = {0}, l = {101}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class ___ extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: _  reason: collision with root package name */
        public CoroutineScope f917_;
        public Object __;
        public int ___;
        public final /* synthetic */ Observer ____;

        @DebugMetadata(c = "com.baidu.netdisk.trade.privilege.TradeAccount$getUserPrivilege$1$2", f = "TradeAccount.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class _ extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: _  reason: collision with root package name */
            public CoroutineScope f918_;
            public int __;
            public final /* synthetic */ ___ ___;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public _(___ ___2, Continuation continuation) {
                super(2, continuation);
                this.___ = ___2;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                _ _2 = new _(this.___, continuation);
                _2.f918_ = (CoroutineScope) obj;
                return _2;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((_) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.__ == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.___.____.onChanged(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ___(Observer observer, Continuation continuation) {
            super(2, continuation);
            this.____ = observer;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            ___ ___2 = new ___(this.____, continuation);
            ___2.f917_ = (CoroutineScope) obj;
            return ___2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((___) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.___;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.f917_;
                IStore de2 = _._._._._.__.f542ad.de();
                if (de2 != null) {
                    new _._._._._.___._.___(de2).fe();
                }
                z0 de3 = u.de();
                _ _2 = new _(this, (Continuation) null);
                this.__ = coroutineScope;
                this.___ = 1;
                if (o.yj(de3, _2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.__;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.baidu.netdisk.trade.privilege.TradeAccount$syncUserPrivilege$1", f = "TradeAccount.kt", i = {0}, l = {88}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.baidu.netdisk.trade.privilege.TradeAccount$____  reason: case insensitive filesystem */
    public static final class C0364____ extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: _  reason: collision with root package name */
        public CoroutineScope f919_;
        public Object __;
        public int ___;
        public final /* synthetic */ IStore ____;
        public final /* synthetic */ Function0 _____;

        @DebugMetadata(c = "com.baidu.netdisk.trade.privilege.TradeAccount$syncUserPrivilege$1$1", f = "TradeAccount.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.baidu.netdisk.trade.privilege.TradeAccount$____$_ */
        public static final class _ extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: _  reason: collision with root package name */
            public CoroutineScope f920_;
            public int __;
            public final /* synthetic */ C0364____ ___;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public _(C0364____ ____, Continuation continuation) {
                super(2, continuation);
                this.___ = ____;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                _ _2 = new _(this.___, continuation);
                _2.f920_ = (CoroutineScope) obj;
                return _2;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((_) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.__ == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function0 function0 = this.___._____;
                    if (function0 != null) {
                        Unit unit = (Unit) function0.invoke();
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0364____(IStore iStore, Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.____ = iStore;
            this._____ = function0;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            C0364____ ____2 = new C0364____(this.____, this._____, continuation);
            ____2.f919_ = (CoroutineScope) obj;
            return ____2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C0364____) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.___;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.f919_;
                IStore iStore = this.____;
                if (iStore == null) {
                    new ad.qw.qw.qw.qw.ad.qw.ad().qw();
                } else {
                    new _._._._._.___._.___(iStore).fe();
                }
                z0 de2 = u.de();
                _ _2 = new _(this, (Continuation) null);
                this.__ = coroutineScope;
                this.___ = 1;
                if (o.yj(de2, _2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.__;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    static {
        new MutableLiveData();
    }

    @JvmStatic
    public static final int fe() {
        qw qwVar = f910ad;
        return qwVar != null ? qwVar.qw() : de.qw();
    }

    public static /* synthetic */ void ggg(TradeAccount tradeAccount, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function0 = null;
        }
        tradeAccount.ppp(function0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        if (r4.intValue() != r2) goto L_0x0018;
     */
    @kotlin.jvm.JvmStatic
    @kotlin.jvm.JvmName(name = "setGrowthLevel")
    /* renamed from: switch  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void m33switch(@org.jetbrains.annotations.Nullable java.lang.Integer r4) {
        /*
            java.lang.Class<com.baidu.netdisk.trade.privilege.TradeAccount> r0 = com.baidu.netdisk.trade.privilege.TradeAccount.class
            monitor-enter(r0)
            _._._._._.__ r1 = _._._._._.__.f542ad     // Catch:{ all -> 0x0032 }
            com.baidu.netdisk.trade.privilege.config.IStore r1 = r1.de()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0030
            int r2 = fe()     // Catch:{ all -> 0x0032 }
            if (r4 != 0) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            int r3 = r4.intValue()     // Catch:{ all -> 0x0032 }
            if (r3 == r2) goto L_0x0030
        L_0x0018:
            if (r4 == 0) goto L_0x0030
            int r2 = r4.intValue()     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "trade_account_identity_level"
            r1.putInt(r3, r2)     // Catch:{ all -> 0x0032 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0032 }
            ad.qw.qw.qw.qw.ad.ad.qw.fe(r4)     // Catch:{ all -> 0x0032 }
            ad.qw.qw.qw.qw.ad.ad.qw r4 = ad.qw.qw.qw.qw.ad.ad.qw.ad(r4)     // Catch:{ all -> 0x0032 }
            f910ad = r4     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r0)
            return
        L_0x0032:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.trade.privilege.TradeAccount.m33switch(java.lang.Integer):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r4.intValue() != r2) goto L_0x001a;
     */
    @kotlin.jvm.JvmStatic
    @kotlin.jvm.JvmName(name = "setMemberLevel")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void when(@org.jetbrains.annotations.Nullable java.lang.Integer r4) {
        /*
            java.lang.Class<com.baidu.netdisk.trade.privilege.TradeAccount> r0 = com.baidu.netdisk.trade.privilege.TradeAccount.class
            monitor-enter(r0)
            _._._._._.__ r1 = _._._._._.__.f542ad     // Catch:{ all -> 0x0034 }
            com.baidu.netdisk.trade.privilege.config.IStore r1 = r1.de()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0032
            com.baidu.netdisk.trade.privilege.TradeAccount r2 = f913rg     // Catch:{ all -> 0x0034 }
            int r2 = r2.rg()     // Catch:{ all -> 0x0034 }
            if (r4 != 0) goto L_0x0014
            goto L_0x001a
        L_0x0014:
            int r3 = r4.intValue()     // Catch:{ all -> 0x0034 }
            if (r3 == r2) goto L_0x0032
        L_0x001a:
            if (r4 == 0) goto L_0x0032
            int r2 = r4.intValue()     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "trade_account_identity_growth_value"
            r1.putInt(r3, r2)     // Catch:{ all -> 0x0034 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0034 }
            ad.qw.qw.qw.qw.ad.ad.ad.fe(r4)     // Catch:{ all -> 0x0034 }
            ad.qw.qw.qw.qw.ad.ad.ad r4 = ad.qw.qw.qw.qw.ad.ad.ad.ad(r4)     // Catch:{ all -> 0x0034 }
            f911de = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r0)
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.trade.privilege.TradeAccount.when(java.lang.Integer):void");
    }

    public final synchronized void ad() {
        qw.clear();
    }

    public final void de(@NotNull String str, @Nullable String str2, @Nullable Function2<? super Boolean, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "privilegeId");
        Job unused = Cif.fe(i0.f6136ad, u.ad(), (CoroutineStart) null, new __(str, str2, function2, (Continuation) null), 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void i(@org.jetbrains.annotations.Nullable java.util.List<com.baidu.netdisk.trade.privilege.io.model.Privilege> r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.concurrent.CopyOnWriteArrayList<com.baidu.netdisk.trade.privilege.io.model.Privilege> r0 = f912fe     // Catch:{ all -> 0x001b }
            r0.clear()     // Catch:{ all -> 0x001b }
            if (r2 == 0) goto L_0x0011
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            if (r0 != 0) goto L_0x0019
            java.util.concurrent.CopyOnWriteArrayList<com.baidu.netdisk.trade.privilege.io.model.Privilege> r0 = f912fe     // Catch:{ all -> 0x001b }
            r0.addAll(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.trade.privilege.TradeAccount.i(java.util.List):void");
    }

    @MainThread
    /* renamed from: if  reason: not valid java name */
    public final synchronized void m34if() {
        f912fe.clear();
        qw.clear();
    }

    public final boolean o(@NotNull MemberProduct memberProduct) {
        Intrinsics.checkNotNullParameter(memberProduct, "product");
        return pf(memberProduct.getCluster());
    }

    public final boolean pf(@NotNull String str) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(str, "productName");
        Iterator<T> it = qw.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            ad.qw.qw.qw.qw.qw qwVar = (ad.qw.qw.qw.qw.qw) t;
            if (qwVar.de() || !Intrinsics.areEqual((Object) qwVar.qw(), (Object) str)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (t != null) {
            return true;
        }
        return false;
    }

    @MainThread
    public final void ppp(@Nullable Function0<Unit> function0) {
        Job unused = Cif.fe(i0.f6136ad, u.ad(), (CoroutineStart) null, new C0364____(_._._._._.__.f542ad.de(), function0, (Continuation) null), 2, (Object) null);
    }

    public final synchronized void qw(@NotNull ad.qw.qw.qw.qw.qw qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, "p");
        CollectionsKt__MutableCollectionsKt.removeAll(qw, new _(qwVar));
        qw.add(qwVar);
    }

    public final int rg() {
        ad adVar = f911de;
        return adVar != null ? adVar.qw() : de.ad();
    }

    public final long th(@NotNull String str) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(str, "productName");
        Iterator<T> it = qw.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            ad.qw.qw.qw.qw.qw qwVar = (ad.qw.qw.qw.qw.qw) t;
            if (!Intrinsics.areEqual((Object) qwVar.qw(), (Object) str) || qwVar.de()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        ad.qw.qw.qw.qw.qw qwVar2 = (ad.qw.qw.qw.qw.qw) t;
        return (qwVar2 != null ? qwVar2.ad() : 0) * 1000;
    }

    @MainThread
    public final void uk(@NotNull Observer<Boolean> observer) {
        Intrinsics.checkNotNullParameter(observer, "onSyncFinish");
        Job unused = Cif.fe(j.qw(u.ad()), (CoroutineContext) null, (CoroutineStart) null, new ___(observer, (Continuation) null), 3, (Object) null);
    }

    @Nullable
    public final synchronized Privilege yj(@NotNull String str) {
        T t;
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator<T> it = f912fe.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((Object) ((Privilege) t).getPrivilegeId(), (Object) str)) {
                break;
            }
        }
        return (Privilege) t;
    }
}
