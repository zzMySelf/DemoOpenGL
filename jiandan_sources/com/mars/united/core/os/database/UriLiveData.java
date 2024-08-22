package com.mars.united.core.os.database;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("UriLiveData")
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0014\b\u0007\u0018\u0000 8*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u000389:BW\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0011¢\u0006\u0002\u0010\u0012J\b\u0010(\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020+H\u0002J \u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.2\u000e\u0010*\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000/H\u0016J\u0018\u00100\u001a\u00020\u00062\u000e\u0010*\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000/H\u0016J\b\u00101\u001a\u00020\u0006H\u0014J\b\u00102\u001a\u00020\u0006H\u0014J\u001a\u00103\u001a\u00020\u00062\u0010\u0010*\u001a\f\u0012\b\b\u0000\u0012\u0004\u0018\u00018\u00000/H\u0016J\b\u00104\u001a\u00020\u0006H\u0002J\u0017\u00105\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u00107R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001aR\u0018\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0&X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/mars/united/core/os/database/UriLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "asyncTaskHandler", "Lkotlin/Function1;", "Ljava/lang/Runnable;", "", "gapTimeMillis", "", "customDebugTag", "", "extraNotifyUrisInfo", "Lkotlin/Pair;", "Landroid/content/Context;", "", "Landroid/net/Uri;", "getData", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;JLjava/lang/String;Lkotlin/Pair;Lkotlin/jvm/functions/Function0;)V", "handler", "com/mars/united/core/os/database/UriLiveData$handler$1", "Lcom/mars/united/core/os/database/UriLiveData$handler$1;", "value", "", "ignoreChange", "getIgnoreChange", "()Z", "setIgnoreChange", "(Z)V", "lastObserverName", "lastUpdateTime", "mIsAwaiting", "mIsRunning", "mObserver", "Lcom/mars/united/core/os/database/UriLiveData$CustomContentObserver;", "needUpdate", "getNeedUpdate", "weakRef", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LiveData;", "destroy", "initObserverName", "observer", "", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Observer;", "observeForever", "onActive", "onInactive", "removeObserver", "startLoadTask", "updateResult", "result", "(Ljava/lang/Object;)V", "Companion", "CustomContentObserver", "DataTask", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UriLiveData<T> extends MutableLiveData<T> {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    public static boolean when;

    /* renamed from: ad  reason: collision with root package name */
    public final long f6603ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f6604de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final Pair<Context, List<Uri>> f6605fe;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final fe f6606i;

    /* renamed from: if  reason: not valid java name */
    public long f268if;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6607o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f6608pf;
    @NotNull
    public final Function1<Runnable, Unit> qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final Function0<T> f6609rg;
    @NotNull

    /* renamed from: switch  reason: not valid java name */
    public final ad f269switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final WeakReference<LiveData<?>> f6610th;

    /* renamed from: uk  reason: collision with root package name */
    public volatile boolean f6611uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public String f6612yj;

    @Tag("UriLiveData_CustomContentObserver")
    public static final class ad extends ContentObserver implements UriObserver {
        @Nullable

        /* renamed from: ad  reason: collision with root package name */
        public String f6613ad;
        @Nullable

        /* renamed from: de  reason: collision with root package name */
        public ContentResolver f6614de;
        @Nullable

        /* renamed from: fe  reason: collision with root package name */
        public List<? extends Uri> f6615fe;
        @NotNull
        public final WeakReference<LiveData<?>> qw;

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
                boolean r0 = r4 instanceof com.mars.united.core.os.database.UriLiveData
                r1 = 0
                if (r0 == 0) goto L_0x001f
                com.mars.united.core.os.database.UriLiveData r4 = (com.mars.united.core.os.database.UriLiveData) r4
                goto L_0x0020
            L_0x001f:
                r4 = r1
            L_0x0020:
                if (r4 != 0) goto L_0x0024
                r4 = r1
                goto L_0x0028
            L_0x0024:
                java.lang.String r4 = r4.f6604de
            L_0x0028:
                r3.f6613ad = r4
                java.lang.ref.WeakReference<androidx.lifecycle.LiveData<?>> r4 = r3.qw
                java.lang.Object r4 = r4.get()
                boolean r0 = r4 instanceof com.mars.united.core.os.database.UriLiveData
                if (r0 == 0) goto L_0x0037
                com.mars.united.core.os.database.UriLiveData r4 = (com.mars.united.core.os.database.UriLiveData) r4
                goto L_0x0038
            L_0x0037:
                r4 = r1
            L_0x0038:
                if (r4 != 0) goto L_0x003c
            L_0x003a:
                r4 = r1
                goto L_0x0054
            L_0x003c:
                kotlin.Pair r4 = r4.f6605fe
                java.lang.Object r4 = r4.getFirst()
                android.content.Context r4 = (android.content.Context) r4
                if (r4 != 0) goto L_0x0049
                goto L_0x003a
            L_0x0049:
                android.content.Context r4 = r4.getApplicationContext()
                if (r4 != 0) goto L_0x0050
                goto L_0x003a
            L_0x0050:
                android.content.ContentResolver r4 = r4.getContentResolver()
            L_0x0054:
                r3.f6614de = r4
                java.lang.ref.WeakReference<androidx.lifecycle.LiveData<?>> r4 = r3.qw
                java.lang.Object r4 = r4.get()
                boolean r0 = r4 instanceof com.mars.united.core.os.database.UriLiveData
                if (r0 == 0) goto L_0x0063
                com.mars.united.core.os.database.UriLiveData r4 = (com.mars.united.core.os.database.UriLiveData) r4
                goto L_0x0064
            L_0x0063:
                r4 = r1
            L_0x0064:
                if (r4 != 0) goto L_0x0067
                goto L_0x0072
            L_0x0067:
                kotlin.Pair r4 = r4.f6605fe
                java.lang.Object r4 = r4.getSecond()
                r1 = r4
                java.util.List r1 = (java.util.List) r1
            L_0x0072:
                r3.f6615fe = r1
                if (r1 != 0) goto L_0x0077
                goto L_0x0091
            L_0x0077:
                java.util.Iterator r4 = r1.iterator()
            L_0x007b:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x0091
                java.lang.Object r0 = r4.next()
                android.net.Uri r0 = (android.net.Uri) r0
                android.content.ContentResolver r1 = r3.f6614de
                if (r1 != 0) goto L_0x008c
                goto L_0x007b
            L_0x008c:
                r2 = 1
                r1.registerContentObserver(r0, r2, r3)
                goto L_0x007b
            L_0x0091:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mars.united.core.os.database.UriLiveData.ad.<init>(java.lang.ref.WeakReference):void");
        }

        public final void ad(ContentResolver contentResolver, ContentObserver contentObserver) {
            try {
                contentResolver.unregisterContentObserver(contentObserver);
            } catch (Throwable th2) {
                fe.ggg.ad.qw.ad.ad.ad(th2, "UriLiveData(" + this.f6613ad + ')');
            }
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            LiveData liveData = (LiveData) this.qw.get();
            if (liveData == null || !(liveData instanceof UriLiveData)) {
                qw();
                return;
            }
            if (Logger.INSTANCE.getEnable()) {
                StringBuilder sb = new StringBuilder();
                UriLiveData uriLiveData = (UriLiveData) liveData;
                sb.append(uriLiveData.f6604de);
                sb.append(" onChange hasActiveObservers=");
                sb.append(liveData.hasActiveObservers());
                sb.append(" ignoreChange=");
                sb.append(uriLiveData.getIgnoreChange());
                sb.append(Ascii.CASE_MASK);
                LoggerKt.v$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
            }
            UriLiveData uriLiveData2 = (UriLiveData) liveData;
            if (!uriLiveData2.getIgnoreChange()) {
                uriLiveData2.fe();
            } else {
                uriLiveData2.f6607o = true;
            }
        }

        public void qw() {
            if (Logger.INSTANCE.getEnable()) {
                StringBuilder sb = new StringBuilder();
                sb.append("UriLiveData(");
                sb.append(this.f6613ad);
                sb.append(") unregisterObserver liveData=");
                sb.append(this.qw.get());
                sb.append(" hasActiveObservers=");
                LiveData liveData = (LiveData) this.qw.get();
                sb.append(liveData == null ? null : Boolean.valueOf(liveData.hasActiveObservers()));
                sb.append(" hasObservers=");
                LiveData liveData2 = (LiveData) this.qw.get();
                sb.append(liveData2 == null ? null : Boolean.valueOf(liveData2.hasObservers()));
                sb.append(Ascii.CASE_MASK);
                LoggerKt.v$default(fe.ggg.ad.qw.ad.ad.qw(sb.toString()), (Object) null, 1, (Object) null);
            }
            ContentResolver contentResolver = this.f6614de;
            if (contentResolver != null) {
                ad(contentResolver, this);
            }
            this.f6614de = null;
            this.f6615fe = null;
        }
    }

    @Tag("UriLiveData_DataTask")
    public final class de implements Runnable {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final Function0<T> f6616ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ UriLiveData<T> f6617th;

        public de(@NotNull UriLiveData uriLiveData, Function0<? extends T> function0) {
            Intrinsics.checkNotNullParameter(uriLiveData, "this$0");
            Intrinsics.checkNotNullParameter(function0, "getData");
            this.f6617th = uriLiveData;
            this.f6616ad = function0;
        }

        public final void qw() {
            Object obj;
            UriLiveData<T> uriLiveData = this.f6617th;
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(uriLiveData.f6604de + '-' + uriLiveData.hashCode() + " DataTask performStart extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default((Iterable) uriLiveData.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
            }
            try {
                obj = this.f6616ad.invoke();
            } catch (Throwable th2) {
                fe.ggg.ad.qw.ad.ad.ad(th2, this.f6617th.f6604de);
                obj = null;
            }
            UriLiveData<T> uriLiveData2 = this.f6617th;
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(uriLiveData2.f6604de + '-' + uriLiveData2.hashCode() + " DataTask finished result=" + obj + " extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default((Iterable) uriLiveData2.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
            }
            this.f6617th.f6606i.sendMessage(this.f6617th.f6606i.obtainMessage(2, obj));
        }

        public void run() {
            try {
                qw();
            } catch (Throwable th2) {
                fe.ggg.ad.qw.ad.ad.ad(th2, this.f6617th.f6604de);
            }
        }

        @NotNull
        public String toString() {
            return this.f6617th.f6604de + '-' + this.f6617th.hashCode() + " DataTask(" + CollectionsKt___CollectionsKt.joinToString$default((Iterable) this.f6617th.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ')';
        }
    }

    public static final class fe extends Handler {
        public final /* synthetic */ UriLiveData<T> qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public fe(UriLiveData<T> uriLiveData, Looper looper) {
            super(looper);
            this.qw = uriLiveData;
        }

        public void dispatchMessage(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "msg");
            int i2 = message.what;
            if (i2 == 1) {
                if (this.qw.getIgnoreChange() || this.qw.f6608pf) {
                    UriLiveData<T> uriLiveData = this.qw;
                    if (Logger.INSTANCE.getEnable()) {
                        LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(uriLiveData.f6604de + '-' + uriLiveData.hashCode() + " dispatchMessage startTask ignoreChange=" + uriLiveData.getIgnoreChange() + ", mIsRunning=" + uriLiveData.f6608pf + ", extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default((Iterable) uriLiveData.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
                    }
                    this.qw.f6607o = true;
                    return;
                }
                this.qw.f6607o = false;
                this.qw.f6608pf = true;
                UriLiveData<T> uriLiveData2 = this.qw;
                if (Logger.INSTANCE.getEnable()) {
                    LoggerKt.v$default(fe.ggg.ad.qw.ad.ad.qw(uriLiveData2.f6604de + '-' + uriLiveData2.hashCode() + " dispatchMessage startTask real, extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default((Iterable) uriLiveData2.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
                }
                Function1 access$getAsyncTaskHandler$p = this.qw.qw;
                UriLiveData<T> uriLiveData3 = this.qw;
                access$getAsyncTaskHandler$p.invoke(new de(uriLiveData3, uriLiveData3.f6609rg));
            } else if (i2 == 2) {
                this.qw.rg(message.obj);
                this.qw.f6608pf = false;
                if (this.qw.ad()) {
                    this.qw.fe();
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
    public /* synthetic */ UriLiveData(Function1 function1, long j, String str, Pair pair, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i2 & 2) != 0 ? 500 : j, (i2 & 4) != 0 ? "default_tag" : str, pair, function0);
    }

    public final boolean ad() {
        return !this.f6611uk && this.f6607o;
    }

    public final void de(Object obj) {
        if (this.f6612yj == null) {
            if (!when) {
                this.f6612yj = obj.toString();
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
                        this.f6612yj = stackTraceElement.getClassName() + ':' + stackTraceElement.getMethodName() + ':' + stackTraceElement.getLineNumber();
                        return;
                    }
                }
                i2++;
                i3 = i4;
            }
        }
    }

    public final void fe() {
        if (!hasActiveObservers()) {
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(this.f6604de + '-' + hashCode() + " startLoadTask no ActiveObservers extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default(this.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
            }
            this.f6607o = true;
        } else if (!this.f6606i.hasMessages(1)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f268if;
            long j = this.f6603ad - currentTimeMillis;
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(this.f6604de + " startLoadTask dataKeepTimeMillis=" + currentTimeMillis + ", gapTime=" + j + ", gapTimeMillis=" + this.f6603ad), (Object) null, 1, (Object) null);
            }
            if (getValue() == null || j <= 0) {
                this.f6606i.sendEmptyMessage(1);
            } else {
                this.f6606i.sendEmptyMessageDelayed(1, j);
            }
        } else if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(this.f6604de + '-' + hashCode() + " startLoadTask already has Msg extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default(this.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
        }
    }

    public final boolean getIgnoreChange() {
        return this.f6611uk;
    }

    public void observe(@NotNull LifecycleOwner lifecycleOwner, @NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observe(lifecycleOwner, observer);
        de(observer);
    }

    public void observeForever(@NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observeForever(observer);
        de(observer);
    }

    public void onActive() {
        super.onActive();
        boolean z = true;
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(this.f6604de + '-' + hashCode() + " onActive needUpdate=" + ad() + " ignoreChange=" + getIgnoreChange() + ", mIsAwaiting=" + this.f6607o + ", extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default(this.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            z = false;
        }
        if (!z) {
            throw new IllegalStateException((this.f6604de + '-' + hashCode() + " current Thread{" + Thread.currentThread().getName() + "} is not ui Thread").toString());
        } else if (ad()) {
            fe();
        }
    }

    public void onInactive() {
        super.onInactive();
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(this.f6604de + '-' + hashCode() + " onInactive needUpdate=" + ad() + ", ignoreChange=" + getIgnoreChange() + ", mIsAwaiting=" + this.f6607o + ", extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default(this.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
        }
    }

    public final void qw() {
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(this.f6604de + '-' + hashCode() + " destroy extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default(this.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
        }
        this.f6606i.removeMessages(1);
    }

    public void removeObserver(@NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.removeObserver(observer);
        if (!hasObservers()) {
            qw();
        }
    }

    public final void rg(T t) {
        if (this.f6611uk) {
            this.f6607o = true;
            return;
        }
        setValue(t);
        this.f268if = System.currentTimeMillis();
        fe.ggg.ad.qw.de.rg.fe.qw.qw(this.f6610th, this.f269switch, t instanceof Closeable ? (Closeable) t : null);
    }

    public final void setIgnoreChange(boolean z) {
        this.f6611uk = z;
        if (ad()) {
            fe();
        }
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(fe.ggg.ad.qw.ad.ad.qw(this.f6604de + '-' + hashCode() + " ignoreChange value=" + z + " field=" + this.f6611uk + ", mIsAwaiting=" + this.f6607o + ", extraNotifyUrisInfo=" + CollectionsKt___CollectionsKt.joinToString$default(this.f6605fe.getSecond(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), (Object) null, 1, (Object) null);
        }
    }

    public UriLiveData(@NotNull Function1<? super Runnable, Unit> function1, long j, @NotNull String str, @NotNull Pair<? extends Context, ? extends List<? extends Uri>> pair, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function1, "asyncTaskHandler");
        Intrinsics.checkNotNullParameter(str, "customDebugTag");
        Intrinsics.checkNotNullParameter(pair, "extraNotifyUrisInfo");
        Intrinsics.checkNotNullParameter(function0, "getData");
        this.qw = function1;
        this.f6603ad = j;
        this.f6604de = str;
        this.f6605fe = pair;
        this.f6609rg = function0;
        this.f6610th = fe.ggg.ad.qw.de.rg.fe.qw.de(this);
        this.f6606i = new fe(this, Looper.getMainLooper());
        this.f6607o = true;
        this.f269switch = new ad(this.f6610th);
    }
}
