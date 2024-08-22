package com.mars.united.core.os.database;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.united.core.util.scheduler.BaseMultiTask;
import com.mars.united.core.util.scheduler.ITaskScheduler;
import com.mars.united.core.util.scheduler.ThreadPriority;
import fe.ggg.ad.qw.de.rg.fe;
import fe.ggg.ad.qw.de.rg.th;
import fe.ggg.ad.qw.de.rg.yj;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("CursorLiveData")
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\b\u0007\u0018\u0000 >*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002>?Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\r\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0012¢\u0006\u0002\u0010\u0013J\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u000200H\u0002J \u00101\u001a\u00020+2\u0006\u00102\u001a\u0002032\u000e\u0010-\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u000004H\u0016J\u0018\u00105\u001a\u00020+2\u000e\u0010-\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u000004H\u0016J\b\u00106\u001a\u00020+H\u0014J\b\u00107\u001a\u00020+H\u0014J\u001a\u00108\u001a\u00020+2\u0010\u0010-\u001a\f\u0012\b\b\u0000\u0012\u0004\u0018\u00018\u000004H\u0016J\b\u00109\u001a\u00020+H\u0002J\u0018\u0010:\u001a\u00020+2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<H\u0002J\u000e\u0010=\u001a\u00020\u000b*\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0(X\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/mars/united/core/os/database/CursorLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "taskScheduler", "Lcom/mars/united/core/util/scheduler/ITaskScheduler;", "parser", "Lkotlin/Function1;", "Landroid/database/Cursor;", "gapTimeMillis", "", "customDebugTag", "", "extraNotifyUrisInfo", "Lkotlin/Pair;", "Landroid/content/Context;", "", "Landroid/net/Uri;", "getCursor", "Lkotlin/Function0;", "(Lcom/mars/united/core/util/scheduler/ITaskScheduler;Lkotlin/jvm/functions/Function1;JLjava/lang/String;Lkotlin/Pair;Lkotlin/jvm/functions/Function0;)V", "handler", "com/mars/united/core/os/database/CursorLiveData$handler$1", "Lcom/mars/united/core/os/database/CursorLiveData$handler$1;", "value", "", "ignoreChange", "getIgnoreChange", "()Z", "setIgnoreChange", "(Z)V", "lastObserverName", "lastUpdateTime", "mCursor", "mIsAwaiting", "mObserver", "Lcom/mars/united/core/os/database/CursorLiveData$CustomContentObserver;", "mRunningTaskId", "needUpdate", "getNeedUpdate", "weakRef", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LiveData;", "destroy", "", "initObserverName", "observer", "", "newInstanceLoadTask", "Lcom/mars/united/core/util/scheduler/BaseMultiTask;", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Observer;", "observeForever", "onActive", "onInactive", "removeObserver", "startLoadTask", "updateResult", "result", "Lcom/mars/united/core/os/database/LoadResult;", "getIdentify", "Companion", "CustomContentObserver", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CursorLiveData<T> extends MutableLiveData<T> {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    public static boolean ggg;
    public static volatile boolean vvv;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Function1<Cursor, T> f6589ad;

    /* renamed from: de  reason: collision with root package name */
    public final long f6590de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final String f6591fe;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f6592i;

    /* renamed from: if  reason: not valid java name */
    public boolean f266if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final de f6593o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public Cursor f6594pf;
    @NotNull
    public final ad ppp;
    @NotNull
    public final ITaskScheduler qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public final Pair<Context, List<Uri>> f6595rg;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public String f267switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Function0<Cursor> f6596th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public String f6597uk;
    public long when;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final WeakReference<LiveData<?>> f6598yj;

    public static final class ad extends ContentObserver implements UriObserver {
        @Nullable

        /* renamed from: ad  reason: collision with root package name */
        public Cursor f6599ad;
        @Nullable

        /* renamed from: de  reason: collision with root package name */
        public String f6600de;
        @Nullable

        /* renamed from: fe  reason: collision with root package name */
        public ContentResolver f6601fe;
        @NotNull
        public final WeakReference<LiveData<?>> qw;
        @Nullable

        /* renamed from: rg  reason: collision with root package name */
        public List<? extends Uri> f6602rg;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.List<? extends android.net.Uri>} */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ad(@org.jetbrains.annotations.NotNull java.lang.ref.WeakReference<androidx.lifecycle.LiveData<?>> r4) {
            /*
                r3 = this;
                java.lang.String r0 = "liveDataRef"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                android.os.Handler r0 = new android.os.Handler
                android.os.Looper r1 = android.os.Looper.getMainLooper()
                r0.<init>(r1)
                r3.<init>(r0)
                r3.qw = r4
                java.lang.Object r4 = r4.get()
                boolean r0 = r4 instanceof com.mars.united.core.os.database.CursorLiveData
                r1 = 0
                if (r0 == 0) goto L_0x001f
                com.mars.united.core.os.database.CursorLiveData r4 = (com.mars.united.core.os.database.CursorLiveData) r4
                goto L_0x0020
            L_0x001f:
                r4 = r1
            L_0x0020:
                if (r4 != 0) goto L_0x0024
                r4 = r1
                goto L_0x0028
            L_0x0024:
                java.lang.String r4 = r4.f6591fe
            L_0x0028:
                r3.f6600de = r4
                java.lang.ref.WeakReference<androidx.lifecycle.LiveData<?>> r4 = r3.qw
                java.lang.Object r4 = r4.get()
                boolean r0 = r4 instanceof com.mars.united.core.os.database.CursorLiveData
                if (r0 == 0) goto L_0x0037
                com.mars.united.core.os.database.CursorLiveData r4 = (com.mars.united.core.os.database.CursorLiveData) r4
                goto L_0x0038
            L_0x0037:
                r4 = r1
            L_0x0038:
                if (r4 != 0) goto L_0x003c
            L_0x003a:
                r4 = r1
                goto L_0x0057
            L_0x003c:
                kotlin.Pair r4 = r4.f6595rg
                if (r4 != 0) goto L_0x0043
                goto L_0x003a
            L_0x0043:
                java.lang.Object r4 = r4.getFirst()
                android.content.Context r4 = (android.content.Context) r4
                if (r4 != 0) goto L_0x004c
                goto L_0x003a
            L_0x004c:
                android.content.Context r4 = r4.getApplicationContext()
                if (r4 != 0) goto L_0x0053
                goto L_0x003a
            L_0x0053:
                android.content.ContentResolver r4 = r4.getContentResolver()
            L_0x0057:
                r3.f6601fe = r4
                java.lang.ref.WeakReference<androidx.lifecycle.LiveData<?>> r4 = r3.qw
                java.lang.Object r4 = r4.get()
                boolean r0 = r4 instanceof com.mars.united.core.os.database.CursorLiveData
                if (r0 == 0) goto L_0x0066
                com.mars.united.core.os.database.CursorLiveData r4 = (com.mars.united.core.os.database.CursorLiveData) r4
                goto L_0x0067
            L_0x0066:
                r4 = r1
            L_0x0067:
                if (r4 != 0) goto L_0x006a
                goto L_0x0078
            L_0x006a:
                kotlin.Pair r4 = r4.f6595rg
                if (r4 != 0) goto L_0x0071
                goto L_0x0078
            L_0x0071:
                java.lang.Object r4 = r4.getSecond()
                r1 = r4
                java.util.List r1 = (java.util.List) r1
            L_0x0078:
                r3.f6602rg = r1
                if (r1 != 0) goto L_0x007d
                goto L_0x0097
            L_0x007d:
                java.util.Iterator r4 = r1.iterator()
            L_0x0081:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x0097
                java.lang.Object r0 = r4.next()
                android.net.Uri r0 = (android.net.Uri) r0
                android.content.ContentResolver r1 = r3.f6601fe
                if (r1 != 0) goto L_0x0092
                goto L_0x0081
            L_0x0092:
                r2 = 1
                r1.registerContentObserver(r0, r2, r3)
                goto L_0x0081
            L_0x0097:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mars.united.core.os.database.CursorLiveData.ad.<init>(java.lang.ref.WeakReference):void");
        }

        public final void ad(ContentResolver contentResolver, ContentObserver contentObserver) {
            try {
                contentResolver.unregisterContentObserver(contentObserver);
            } catch (Throwable th2) {
                fe.ggg.ad.qw.ad.ad.ad(th2, "CursorLiveData(" + this.f6600de + ')');
            }
        }

        public final void de(Cursor cursor, ContentObserver contentObserver) {
            try {
                cursor.unregisterContentObserver(contentObserver);
            } catch (Throwable th2) {
                fe.ggg.ad.qw.ad.ad.ad(th2, "CursorLiveData(" + this.f6600de + ')');
            }
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public final void fe(@NotNull Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            Cursor cursor2 = this.f6599ad;
            if (cursor2 != null) {
                de(cursor2, this);
            }
            cursor.registerContentObserver(this);
            this.f6599ad = cursor;
        }

        public void onChange(boolean z) {
            LiveData liveData = (LiveData) this.qw.get();
            if (liveData == null || !(liveData instanceof CursorLiveData)) {
                qw();
                return;
            }
            if (Logger.INSTANCE.getEnable()) {
                StringBuilder sb = new StringBuilder();
                CursorLiveData cursorLiveData = (CursorLiveData) liveData;
                sb.append(cursorLiveData.f6591fe);
                sb.append(" onChange hasActiveObservers=");
                sb.append(liveData.hasActiveObservers());
                sb.append(" ignoreChange=");
                sb.append(cursorLiveData.getIgnoreChange());
                sb.append(" uri=");
                Cursor access$getMCursor$p = cursorLiveData.f6594pf;
                sb.append(access$getMCursor$p == null ? null : access$getMCursor$p.getNotificationUri());
                sb.append(Ascii.CASE_MASK);
                LoggerKt.v$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
            }
            CursorLiveData cursorLiveData2 = (CursorLiveData) liveData;
            if (!cursorLiveData2.getIgnoreChange()) {
                cursorLiveData2.th();
            } else {
                cursorLiveData2.f266if = true;
            }
        }

        public void qw() {
            if (Logger.INSTANCE.getEnable()) {
                StringBuilder sb = new StringBuilder();
                sb.append("CursorLiveData(");
                sb.append(this.f6600de);
                sb.append(") unregisterObserver liveData=");
                sb.append(this.qw.get());
                sb.append(" hasActiveObservers=");
                LiveData liveData = (LiveData) this.qw.get();
                sb.append(liveData == null ? null : Boolean.valueOf(liveData.hasActiveObservers()));
                sb.append(" hasObservers=");
                LiveData liveData2 = (LiveData) this.qw.get();
                sb.append(liveData2 == null ? null : Boolean.valueOf(liveData2.hasObservers()));
                sb.append(" currentCursor=");
                sb.append(this.f6599ad);
                LoggerKt.v$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
            }
            ContentResolver contentResolver = this.f6601fe;
            if (contentResolver != null) {
                ad(contentResolver, this);
            }
            this.f6601fe = null;
            this.f6602rg = null;
            Cursor cursor = this.f6599ad;
            if (cursor != null) {
                de(cursor, this);
            }
            this.f6599ad = null;
        }
    }

    public static final class de extends Handler {
        public final /* synthetic */ CursorLiveData<T> qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public de(CursorLiveData<T> cursorLiveData, Looper looper) {
            super(looper);
            this.qw = cursorLiveData;
        }

        public void dispatchMessage(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "msg");
            int i2 = message.what;
            if (i2 == 1) {
                if (this.qw.getIgnoreChange() || this.qw.f267switch != null) {
                    CursorLiveData<T> cursorLiveData = this.qw;
                    if (Logger.INSTANCE.getEnable()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(cursorLiveData.f6591fe);
                        sb.append(" dispatchMessage startTask ignoreChange=");
                        sb.append(cursorLiveData.getIgnoreChange());
                        sb.append(" mRunningTaskId=");
                        sb.append(cursorLiveData.f267switch);
                        sb.append(" uri=");
                        Cursor access$getMCursor$p = cursorLiveData.f6594pf;
                        sb.append(access$getMCursor$p == null ? null : access$getMCursor$p.getNotificationUri());
                        sb.append(Ascii.CASE_MASK);
                        LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
                    }
                    this.qw.f266if = true;
                    return;
                }
                this.qw.f266if = false;
                CursorLiveData<T> cursorLiveData2 = this.qw;
                if (Logger.INSTANCE.getEnable()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cursorLiveData2.f6591fe);
                    sb2.append(" dispatchMessage startTask real uri=");
                    Cursor access$getMCursor$p2 = cursorLiveData2.f6594pf;
                    sb2.append(access$getMCursor$p2 == null ? null : access$getMCursor$p2.getNotificationUri());
                    LoggerKt.v$default(fe.ggg.ad.qw.ad.ad.qw(sb2.toString()), (Object) null, 1, (Object) null);
                }
                CursorLiveData<T> cursorLiveData3 = this.qw;
                cursorLiveData3.f267switch = cursorLiveData3.qw.fe(this.qw.rg());
            } else if (i2 == 2) {
                Object obj = message.obj;
                this.qw.yj(obj instanceof th ? (th) obj : null);
                this.qw.f267switch = null;
                if (this.qw.de()) {
                    this.qw.th();
                }
            }
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CursorLiveData(ITaskScheduler iTaskScheduler, Function1 function1, long j, String str, Pair pair, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iTaskScheduler, function1, (i2 & 4) != 0 ? 1500 : j, (i2 & 8) != 0 ? "default_tag" : str, (i2 & 16) != 0 ? null : pair, function0);
    }

    public final String ad(Cursor cursor) {
        Object notificationUri;
        StringBuilder sb = new StringBuilder();
        sb.append("observer(");
        sb.append(this.f6597uk);
        sb.append(")_tag(");
        sb.append(this.f6591fe);
        sb.append(")_uri(");
        Object obj = StringUtil.NULL_STRING;
        if (!(cursor == null || (notificationUri = cursor.getNotificationUri()) == null)) {
            obj = notificationUri;
        }
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }

    public final boolean de() {
        return this.f6594pf == null || (!this.f6592i && this.f266if);
    }

    public final void fe(Object obj) {
        if (this.f6597uk == null) {
            if (!ggg) {
                this.f6597uk = obj.toString();
                return;
            }
            StackTraceElement[] stackTrace = new IllegalStateException().getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "IllegalStateException().stackTrace");
            int length = stackTrace.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                int i4 = i3 + 1;
                if (i3 >= 2) {
                    String className = stackTraceElement.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "stackTraceElement.className");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) SapiDeviceInfo.OS_TYPE, false, 2, (Object) null)) {
                        this.f6597uk = stackTraceElement.getClassName() + ':' + stackTraceElement.getMethodName() + ':' + stackTraceElement.getLineNumber();
                        return;
                    }
                }
                i2++;
                i3 = i4;
            }
        }
    }

    public final boolean getIgnoreChange() {
        return this.f6592i;
    }

    public void observe(@NotNull LifecycleOwner lifecycleOwner, @NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observe(lifecycleOwner, observer);
        if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6591fe);
            sb.append(" observe observer=");
            sb.append(observer);
            sb.append(" needUpdate=");
            sb.append(de());
            sb.append(" ignoreChange=");
            sb.append(getIgnoreChange());
            sb.append(" uri=");
            Cursor cursor = this.f6594pf;
            sb.append(cursor == null ? null : cursor.getNotificationUri());
            sb.append(" extraNotifyUrisInfo=");
            sb.append(this.f6595rg);
            sb.append(" mIsAwaiting=");
            sb.append(this.f266if);
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
        }
        fe(observer);
    }

    public void observeForever(@NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observeForever(observer);
        if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6591fe);
            sb.append(" observeForever observer=");
            sb.append(observer);
            sb.append(" needUpdate=");
            sb.append(de());
            sb.append(" ignoreChange=");
            sb.append(getIgnoreChange());
            sb.append(" uri=");
            Cursor cursor = this.f6594pf;
            sb.append(cursor == null ? null : cursor.getNotificationUri());
            sb.append(" extraNotifyUrisInfo=");
            sb.append(this.f6595rg);
            sb.append(" mIsAwaiting=");
            sb.append(this.f266if);
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
        }
        fe(observer);
    }

    public void onActive() {
        super.onActive();
        boolean z = true;
        if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6591fe);
            sb.append(" onActive needUpdate=");
            sb.append(de());
            sb.append(" ignoreChange=");
            sb.append(getIgnoreChange());
            sb.append(" uri=");
            Cursor cursor = this.f6594pf;
            sb.append(cursor == null ? null : cursor.getNotificationUri());
            sb.append(" extraNotifyUrisInfo=");
            sb.append(this.f6595rg);
            sb.append(" mIsAwaiting=");
            sb.append(this.f266if);
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            z = false;
        }
        if (!z) {
            throw new IllegalStateException((this.f6591fe + " current Thread{" + Thread.currentThread().getName() + "} is not ui Thread").toString());
        } else if (de()) {
            th();
        }
    }

    public void onInactive() {
        super.onInactive();
        if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6591fe);
            sb.append(" onInactive needUpdate=");
            sb.append(de());
            sb.append(" ignoreChange=");
            sb.append(getIgnoreChange());
            sb.append(" uri=");
            Cursor cursor = this.f6594pf;
            sb.append(cursor == null ? null : cursor.getNotificationUri());
            sb.append(" extraNotifyUrisInfo=");
            sb.append(this.f6595rg);
            sb.append(" mIsAwaiting=");
            sb.append(this.f266if);
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
        }
    }

    public final void qw() {
        if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6591fe);
            sb.append(" destroy uri=");
            Cursor cursor = this.f6594pf;
            sb.append(cursor == null ? null : cursor.getNotificationUri());
            sb.append(Ascii.CASE_MASK);
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
        }
        this.f6593o.removeMessages(1);
        String str = this.f267switch;
        if (str != null) {
            this.qw.qw(str);
        }
        this.f267switch = null;
    }

    public void removeObserver(@NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.removeObserver(observer);
        if (!hasObservers()) {
            qw();
        }
        if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6591fe);
            sb.append(" removeObserver observer=");
            sb.append(observer);
            sb.append(" needUpdate=");
            sb.append(de());
            sb.append(" ignoreChange=");
            sb.append(getIgnoreChange());
            sb.append(" uri=");
            Cursor cursor = this.f6594pf;
            sb.append(cursor == null ? null : cursor.getNotificationUri());
            sb.append(" extraNotifyUrisInfo=");
            sb.append(this.f6595rg);
            sb.append(" mIsAwaiting=");
            sb.append(this.f266if);
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
        }
    }

    public final BaseMultiTask rg() {
        String str = this.f6591fe;
        return new yj(str, "CursorLiveData(" + hashCode() + ")_" + ad(this.f6594pf), vvv, this.f6589ad, this.f6593o, this.f6596th, getValue() == null ? ThreadPriority.HIGH : ThreadPriority.MIDDLE);
    }

    public final void setIgnoreChange(boolean z) {
        this.f6592i = z;
        if (de()) {
            th();
        }
        if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6591fe);
            sb.append(" ignoreChange value=");
            sb.append(z);
            sb.append(" field=");
            sb.append(this.f6592i);
            sb.append(" mIsAwaiting=");
            sb.append(this.f266if);
            sb.append(" uri=");
            Cursor cursor = this.f6594pf;
            sb.append(cursor == null ? null : cursor.getNotificationUri());
            sb.append(Ascii.CASE_MASK);
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
        }
    }

    public final void th() {
        if (!hasActiveObservers()) {
            if (Logger.INSTANCE.getEnable()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6591fe);
                sb.append(" startLoadTask no ActiveObservers uri=");
                Cursor cursor = this.f6594pf;
                sb.append(cursor == null ? null : cursor.getNotificationUri());
                sb.append(Ascii.CASE_MASK);
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
            }
            this.f266if = true;
        } else if (!this.f6593o.hasMessages(1)) {
            long currentTimeMillis = System.currentTimeMillis() - this.when;
            long j = this.f6590de - currentTimeMillis;
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(this.f6591fe + " startLoadTask dataKeepTimeMillis=" + currentTimeMillis + ", gapTime=" + j + ", gapTimeMillis=" + this.f6590de), (Object) null, 1, (Object) null);
            }
            if (this.f6594pf == null || j <= 0) {
                this.f6593o.sendEmptyMessage(1);
            } else {
                this.f6593o.sendEmptyMessageDelayed(1, j);
            }
        } else if (Logger.INSTANCE.getEnable()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f6591fe);
            sb2.append(" startLoadTask already has Msg uri=");
            Cursor cursor2 = this.f6594pf;
            sb2.append(cursor2 == null ? null : cursor2.getNotificationUri());
            sb2.append(Ascii.CASE_MASK);
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(sb2.toString()), (Object) null, 1, (Object) null);
        }
    }

    public final void yj(th<T> thVar) {
        Cursor qw2 = thVar == null ? null : thVar.qw();
        if (qw2 == null) {
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.e$default(fe.ggg.ad.qw.ad.ad.qw(Intrinsics.stringPlus(this.f6591fe, " dispatchMessage updateValue cursor is null")), (Object) null, 1, (Object) null);
            }
        } else if (this.f6592i) {
            qw2.close();
            this.f266if = true;
        } else {
            if (thVar.de() == 1) {
                this.when = System.currentTimeMillis();
                setValue(thVar.ad());
            }
            this.f6594pf = qw2;
            this.ppp.fe(qw2);
            fe.qw.qw(this.f6598yj, this.ppp, qw2);
        }
    }

    public CursorLiveData(@NotNull ITaskScheduler iTaskScheduler, @NotNull Function1<? super Cursor, ? extends T> function1, long j, @NotNull String str, @Nullable Pair<? extends Context, ? extends List<? extends Uri>> pair, @NotNull Function0<? extends Cursor> function0) {
        Intrinsics.checkNotNullParameter(iTaskScheduler, "taskScheduler");
        Intrinsics.checkNotNullParameter(function1, "parser");
        Intrinsics.checkNotNullParameter(str, "customDebugTag");
        Intrinsics.checkNotNullParameter(function0, "getCursor");
        this.qw = iTaskScheduler;
        this.f6589ad = function1;
        this.f6590de = j;
        this.f6591fe = str;
        this.f6595rg = pair;
        this.f6596th = function0;
        this.f6598yj = fe.qw.de(this);
        this.f6593o = new de(this, Looper.getMainLooper());
        this.f266if = true;
        this.ppp = new ad(this.f6598yj);
    }
}
