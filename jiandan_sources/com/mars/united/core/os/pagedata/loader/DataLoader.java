package com.mars.united.core.os.pagedata.loader;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.ubc.UBCManager;
import com.google.android.gms.actions.SearchIntents;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.united.core.util.scheduler.ITaskScheduler;
import fe.ggg.ad.qw.de.yj.ad.de;
import fe.ggg.ad.qw.de.yj.ad.fe;
import fe.ggg.ad.qw.de.yj.qw.qw;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u00000\u0011\u0012!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ!\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:H\u0000¢\u0006\u0002\b;J\u0018\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0007J\u001d\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u000203H\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u000208H\u0000¢\u0006\u0002\bFR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R(\u0010(\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100X\u0004¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u000203\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00028\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u00000\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u000203\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/mars/united/core/os/pagedata/loader/DataLoader;", "T", "V", "Lcom/mars/united/core/os/pagedata/data/DataVersion;", "Landroidx/lifecycle/LifecycleObserver;", "customTag", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "contentResolver", "Landroid/content/ContentResolver;", "notifyUrl", "", "Landroid/net/Uri;", "query", "Lcom/mars/united/core/os/pagedata/database/Query;", "parserData", "Lkotlin/Function1;", "Landroid/database/Cursor;", "obtainVersion", "", "Lkotlin/ParameterName;", "name", "dataVersion", "taskScheduler", "Lcom/mars/united/core/util/scheduler/ITaskScheduler;", "gapTime", "", "looper", "Landroid/os/Looper;", "(Ljava/lang/String;Landroidx/lifecycle/Lifecycle;Landroid/content/ContentResolver;Ljava/util/List;Lcom/mars/united/core/os/pagedata/database/Query;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/mars/united/core/util/scheduler/ITaskScheduler;JLandroid/os/Looper;)V", "curDataVersion", "Lcom/mars/united/core/os/pagedata/data/DataVersion;", "curLifeState", "Landroidx/lifecycle/Lifecycle$State;", "curLoadTaskId", "dataLoaderImpl", "Lcom/mars/united/core/os/pagedata/loader/IDataLoader;", "getDataLoaderImpl", "()Lcom/mars/united/core/os/pagedata/loader/IDataLoader;", "dataResultHandler", "Lcom/mars/united/core/os/pagedata/loader/IDataResultHandler;", "getDataResultHandler", "()Lcom/mars/united/core/os/pagedata/loader/IDataResultHandler;", "setDataResultHandler", "(Lcom/mars/united/core/os/pagedata/loader/IDataResultHandler;)V", "databaseVersion", "handler", "Lcom/mars/united/core/os/pagedata/loader/NoUiDataLoaderHandler;", "lastLoadInfo", "Lkotlin/Pair;", "Lkotlin/ranges/IntRange;", "observer", "Lcom/mars/united/core/os/pagedata/database/DatabaseObserver;", "requestLoadInfo", "handleDataResult", "", "resultData", "Lcom/mars/united/core/os/pagedata/database/ResultData;", "handleDataResult$core_release", "lifeState", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "loadDataRange", "triggerPosition", "dataRange", "loadDataRange$core_release", "upgradeDataVersion", "upgradeDataVersion$core_release", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DataLoader<T, V extends fe.ggg.ad.qw.de.yj.qw.qw> implements LifecycleObserver {
    @Nullable
    public IDataResultHandler<T, V> aaa;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f6620ad;
    @Nullable
    public volatile String ddd;
    @Nullable
    public Pair<Integer, IntRange> ggg;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final de f6621i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final ITaskScheduler f270if;
    @NotNull
    public volatile Lifecycle.State mmm = Lifecycle.State.CREATED;
    public int nn;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final Function1<Cursor, T> f6622o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final Function1<Integer, V> f6623pf;
    @NotNull
    public final fe.ggg.ad.qw.de.yj.ad.ad ppp;
    @NotNull
    public final IDataLoader qqq;

    /* renamed from: switch  reason: not valid java name */
    public final long f271switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Lifecycle f6624th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final List<Uri> f6625uk;
    @Nullable
    public Pair<Integer, IntRange> vvv;
    @NotNull
    public final fe.ggg.ad.qw.de.yj.de.qw<T, V> when;
    @Nullable
    public V xxx;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final ContentResolver f6626yj;

    public static final class ad implements IDataLoader {
        public ad(DataLoader<T, V> dataLoader) {
        }
    }

    public /* synthetic */ class qw {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DataLoader(@NotNull String str, @NotNull Lifecycle lifecycle, @NotNull ContentResolver contentResolver, @NotNull List<? extends Uri> list, @NotNull de deVar, @NotNull Function1<? super Cursor, ? extends T> function1, @NotNull Function1<? super Integer, ? extends V> function12, @NotNull ITaskScheduler iTaskScheduler, long j, @NotNull Looper looper) {
        Intrinsics.checkNotNullParameter(str, "customTag");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(list, "notifyUrl");
        Intrinsics.checkNotNullParameter(deVar, SearchIntents.EXTRA_QUERY);
        Intrinsics.checkNotNullParameter(function1, "parserData");
        Intrinsics.checkNotNullParameter(function12, "obtainVersion");
        Intrinsics.checkNotNullParameter(iTaskScheduler, "taskScheduler");
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.f6620ad = str;
        this.f6624th = lifecycle;
        this.f6626yj = contentResolver;
        this.f6625uk = list;
        this.f6621i = deVar;
        this.f6622o = function1;
        this.f6623pf = function12;
        this.f270if = iTaskScheduler;
        this.f271switch = j;
        fe.ggg.ad.qw.de.yj.de.qw<T, V> qwVar = new fe.ggg.ad.qw.de.yj.de.qw<>(this.f271switch, new WeakReference(this), looper);
        this.when = qwVar;
        fe.ggg.ad.qw.de.yj.ad.ad adVar = new fe.ggg.ad.qw.de.yj.ad.ad(qwVar, this.f6626yj, this.f6625uk, new DataLoader$observer$1(this));
        adVar.de();
        Unit unit = Unit.INSTANCE;
        this.ppp = adVar;
        this.f6624th.addObserver(this);
        this.qqq = new ad(this);
    }

    @NotNull
    public final IDataLoader getDataLoaderImpl() {
        return this.qqq;
    }

    @Nullable
    public final IDataResultHandler<T, V> getDataResultHandler() {
        return this.aaa;
    }

    public final void handleDataResult$core_release(@NotNull fe<T, V> feVar) {
        Intrinsics.checkNotNullParameter(feVar, "resultData");
        feVar.qw();
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public final void lifeState(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, UBCManager.CONTENT_KEY_SOURCE);
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("lifeState change to ", event)), (Object) null, 1, (Object) null);
        }
        int i2 = qw.$EnumSwitchMapping$0[event.ordinal()];
        if (i2 == 1) {
            V v = this.xxx;
            if (v == null) {
                this.when.ad();
            } else {
                v.qw();
                throw null;
            }
        } else if (i2 == 2) {
            String str = this.ddd;
            if (str != null) {
                this.f270if.qw(str);
            }
        } else if (i2 == 3) {
            this.ppp.fe();
            String str2 = this.ddd;
            if (str2 != null) {
                this.f270if.qw(str2);
            }
            IDataResultHandler<T, V> iDataResultHandler = this.aaa;
            if (iDataResultHandler != null) {
                iDataResultHandler.destroy();
            }
        }
        Lifecycle.State currentState = lifecycleOwner.getLifecycle().getCurrentState();
        Intrinsics.checkNotNullExpressionValue(currentState, "source.lifecycle.currentState");
        this.mmm = currentState;
    }

    public final void loadDataRange$core_release(int i2, @NotNull IntRange intRange) {
        int i3 = i2;
        IntRange intRange2 = intRange;
        Intrinsics.checkNotNullParameter(intRange2, "dataRange");
        this.ggg = TuplesKt.to(Integer.valueOf(i2), intRange2);
        if (this.mmm.isAtLeast(Lifecycle.State.STARTED)) {
            Pair<Integer, IntRange> pair = this.vvv;
            boolean z = false;
            if (pair != null && pair.getFirst().intValue() == i3) {
                String str = this.ddd;
                if (str != null && this.f270if.ad(str)) {
                    z = true;
                }
                if (!z) {
                    ITaskScheduler iTaskScheduler = this.f270if;
                    fe.ggg.ad.qw.de.yj.ad.qw qwVar = r2;
                    fe.ggg.ad.qw.de.yj.ad.qw qwVar2 = new fe.ggg.ad.qw.de.yj.ad.qw(this.f6620ad, this.f6626yj, this.f6621i, this.nn, intRange, this.xxx, this.f6622o, this.f6623pf, this.when);
                    this.ddd = iTaskScheduler.de(qwVar);
                    if (Logger.INSTANCE.getEnable()) {
                        LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw("loadDataRange start same load=" + this.vvv + " task=" + this.ddd), (Object) null, 1, (Object) null);
                    }
                } else if (Logger.INSTANCE.getEnable()) {
                    LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw("loadDataRange already has load=" + this.vvv + " task=" + this.ddd), (Object) null, 1, (Object) null);
                }
            } else {
                String str2 = this.ddd;
                if (str2 != null) {
                    this.f270if.qw(str2);
                }
                this.ddd = this.f270if.de(new fe.ggg.ad.qw.de.yj.ad.qw(this.f6620ad, this.f6626yj, this.f6621i, this.nn, intRange, this.xxx, this.f6622o, this.f6623pf, this.when));
                if (Logger.INSTANCE.getEnable()) {
                    LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw("loadDataRange start load=" + i3 + Ascii.CASE_MASK + intRange2 + " task=" + this.ddd), (Object) null, 1, (Object) null);
                }
            }
            this.vvv = TuplesKt.to(Integer.valueOf(i2), intRange2);
        } else if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw("loadDataRange ignore " + this.ggg + "lifeState state=" + this.mmm), (Object) null, 1, (Object) null);
        }
    }

    public final void setDataResultHandler(@Nullable IDataResultHandler<T, V> iDataResultHandler) {
        this.aaa = iDataResultHandler;
    }

    public final void upgradeDataVersion$core_release() {
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw("upgradeDataVersion"), (Object) null, 1, (Object) null);
        }
        this.nn++;
        this.xxx = null;
        Pair<Integer, IntRange> pair = this.ggg;
        if (pair != null) {
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus("loadData lastLoadInfo=", pair)), (Object) null, 1, (Object) null);
            }
            loadDataRange$core_release(pair.getFirst().intValue(), pair.getSecond());
        } else if (Logger.INSTANCE.getEnable()) {
            LoggerKt.w$default(fe.ggg.ad.qw.ad.ad.qw("loadData dataVersion=" + this.nn + " loadInfo=" + pair), (Object) null, 1, (Object) null);
        }
    }
}
