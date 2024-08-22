package com.baidu.apsaras.scheduler.scenes;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.apsaras.scheduler.common.Token;
import com.baidu.apsaras.scheduler.internal.ApsarasRuntime;
import com.baidu.apsaras.scheduler.internal.utils.ReflectionUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001bR#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR#\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0012\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0013\u0010\rR#\u0010\u0015\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0016\u0010\r¨\u0006!"}, d2 = {"Lcom/baidu/apsaras/scheduler/scenes/ViewClickBooster;", "", "()V", "mQmMessageField", "Lcom/baidu/apsaras/scheduler/internal/utils/ReflectionUtil$ReflectionFieldElement;", "kotlin.jvm.PlatformType", "getMQmMessageField", "()Lcom/baidu/apsaras/scheduler/internal/utils/ReflectionUtil$ReflectionFieldElement;", "mQmMessageField$delegate", "Lkotlin/Lazy;", "messageClass", "Lcom/baidu/apsaras/scheduler/internal/utils/ReflectionUtil$ReflectionClassElement;", "getMessageClass", "()Lcom/baidu/apsaras/scheduler/internal/utils/ReflectionUtil$ReflectionClassElement;", "messageClass$delegate", "messageNextField", "getMessageNextField", "messageNextField$delegate", "messageQueueClass", "getMessageQueueClass", "messageQueueClass$delegate", "performClickClass", "getPerformClickClass", "performClickClass$delegate", "boostForPerformClickOnce", "", "boostForView", "Lcom/baidu/apsaras/scheduler/common/Token;", "view", "Landroid/view/View;", "cancelBoost", "token", "ViewClickBoosterTouchListener", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewClickBooster.kt */
public final class ViewClickBooster {
    public static final ViewClickBooster INSTANCE = new ViewClickBooster();
    private static final Lazy mQmMessageField$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ViewClickBooster$mQmMessageField$2.INSTANCE);
    private static final Lazy messageClass$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ViewClickBooster$messageClass$2.INSTANCE);
    private static final Lazy messageNextField$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ViewClickBooster$messageNextField$2.INSTANCE);
    private static final Lazy messageQueueClass$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ViewClickBooster$messageQueueClass$2.INSTANCE);
    private static final Lazy performClickClass$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ViewClickBooster$performClickClass$2.INSTANCE);

    private ViewClickBooster() {
    }

    /* access modifiers changed from: private */
    public final ReflectionUtil.ReflectionClassElement getMessageQueueClass() {
        Object value = messageQueueClass$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-messageQueueClass>(...)");
        return (ReflectionUtil.ReflectionClassElement) value;
    }

    /* access modifiers changed from: private */
    public final ReflectionUtil.ReflectionClassElement getMessageClass() {
        Object value = messageClass$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-messageClass>(...)");
        return (ReflectionUtil.ReflectionClassElement) value;
    }

    private final ReflectionUtil.ReflectionFieldElement getMQmMessageField() {
        return (ReflectionUtil.ReflectionFieldElement) mQmMessageField$delegate.getValue();
    }

    private final ReflectionUtil.ReflectionFieldElement getMessageNextField() {
        return (ReflectionUtil.ReflectionFieldElement) messageNextField$delegate.getValue();
    }

    private final ReflectionUtil.ReflectionClassElement getPerformClickClass() {
        return (ReflectionUtil.ReflectionClassElement) performClickClass$delegate.getValue();
    }

    public final Token boostForView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        if (!getPerformClickClass().isVaild()) {
            return null;
        }
        ViewClickBoosterTouchListener listener = new ViewClickBoosterTouchListener();
        ViewTouchListenerSetterKt.setTouchListener(view2, listener);
        return listener;
    }

    public final void cancelBoost(Token token) {
        Intrinsics.checkNotNullParameter(token, "token");
        ViewClickBoosterTouchListener viewClickBoosterTouchListener = (ViewClickBoosterTouchListener) token;
        ((ViewClickBoosterTouchListener) token).setCancled(true);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/baidu/apsaras/scheduler/scenes/ViewClickBooster$ViewClickBoosterTouchListener;", "Landroid/view/View$OnTouchListener;", "Lcom/baidu/apsaras/scheduler/common/Token;", "()V", "cancled", "", "getCancled", "()Z", "setCancled", "(Z)V", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ViewClickBooster.kt */
    private static final class ViewClickBoosterTouchListener implements View.OnTouchListener, Token {
        private boolean cancled;

        public final boolean getCancled() {
            return this.cancled;
        }

        public final void setCancled(boolean z) {
            this.cancled = z;
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (!(v == null || event == null)) {
                boolean z = true;
                if (event.getAction() != 1) {
                    z = false;
                }
                if (z) {
                    ApsarasRuntime.INSTANCE.getMainHandler().postAtFrontOfQueue(new ViewClickBooster$ViewClickBoosterTouchListener$$ExternalSyntheticLambda0(v));
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        /* renamed from: onTouch$lambda-0  reason: not valid java name */
        public static final void m12499onTouch$lambda0(View $v) {
            if ($v.isPressed()) {
                ViewClickBooster.INSTANCE.boostForPerformClickOnce();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: android.os.Message} */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r5 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r10 = INSTANCE;
        r11 = r10.getMessageNextField().getValue(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if ((r11 instanceof android.os.Message) == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        r10.getMessageNextField().setValue(r5, r4);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void boostForPerformClickOnce() {
        /*
            r13 = this;
            android.os.MessageQueue r0 = android.os.Looper.myQueue()
            java.lang.String r1 = "myQueue()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            monitor-enter(r0)
            r1 = 0
            com.baidu.apsaras.scheduler.scenes.ViewClickBooster r2 = INSTANCE     // Catch:{ all -> 0x0098 }
            com.baidu.apsaras.scheduler.internal.utils.ReflectionUtil$ReflectionFieldElement r2 = r2.getMQmMessageField()     // Catch:{ all -> 0x0098 }
            java.lang.Object r2 = r2.getValue(r0)     // Catch:{ all -> 0x0098 }
            boolean r3 = r2 instanceof android.os.Message     // Catch:{ all -> 0x0098 }
            r4 = 0
            if (r3 == 0) goto L_0x001d
            android.os.Message r2 = (android.os.Message) r2     // Catch:{ all -> 0x0098 }
            goto L_0x001e
        L_0x001d:
            r2 = r4
        L_0x001e:
            r3 = r2
            r5 = 0
            r6 = r2
            r7 = 0
        L_0x0022:
            if (r6 == 0) goto L_0x0078
            java.lang.Runnable r8 = r6.getCallback()     // Catch:{ all -> 0x0098 }
            if (r8 == 0) goto L_0x0040
            java.lang.Class r9 = r8.getClass()     // Catch:{ all -> 0x0098 }
            com.baidu.apsaras.scheduler.scenes.ViewClickBooster r10 = INSTANCE     // Catch:{ all -> 0x0098 }
            com.baidu.apsaras.scheduler.internal.utils.ReflectionUtil$ReflectionClassElement r10 = r10.getPerformClickClass()     // Catch:{ all -> 0x0098 }
            java.lang.Class r10 = r10.getClazz()     // Catch:{ all -> 0x0098 }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ all -> 0x0098 }
            if (r9 == 0) goto L_0x0040
            r9 = 1
            goto L_0x0041
        L_0x0040:
            r9 = 0
        L_0x0041:
            if (r9 == 0) goto L_0x0063
            if (r5 != 0) goto L_0x0048
            monitor-exit(r0)
            return
        L_0x0048:
            r7 = r6
            com.baidu.apsaras.scheduler.scenes.ViewClickBooster r10 = INSTANCE     // Catch:{ all -> 0x0098 }
            com.baidu.apsaras.scheduler.internal.utils.ReflectionUtil$ReflectionFieldElement r11 = r10.getMessageNextField()     // Catch:{ all -> 0x0098 }
            java.lang.Object r11 = r11.getValue(r6)     // Catch:{ all -> 0x0098 }
            boolean r12 = r11 instanceof android.os.Message     // Catch:{ all -> 0x0098 }
            if (r12 == 0) goto L_0x005a
            r4 = r11
            android.os.Message r4 = (android.os.Message) r4     // Catch:{ all -> 0x0098 }
        L_0x005a:
            com.baidu.apsaras.scheduler.internal.utils.ReflectionUtil$ReflectionFieldElement r10 = r10.getMessageNextField()     // Catch:{ all -> 0x0098 }
            r10.setValue(r5, r4)     // Catch:{ all -> 0x0098 }
            goto L_0x0078
        L_0x0063:
            r5 = r6
            com.baidu.apsaras.scheduler.scenes.ViewClickBooster r10 = INSTANCE     // Catch:{ all -> 0x0098 }
            com.baidu.apsaras.scheduler.internal.utils.ReflectionUtil$ReflectionFieldElement r10 = r10.getMessageNextField()     // Catch:{ all -> 0x0098 }
            java.lang.Object r10 = r10.getValue(r6)     // Catch:{ all -> 0x0098 }
            boolean r11 = r10 instanceof android.os.Message     // Catch:{ all -> 0x0098 }
            if (r11 == 0) goto L_0x0075
            android.os.Message r10 = (android.os.Message) r10     // Catch:{ all -> 0x0098 }
            goto L_0x0076
        L_0x0075:
            r10 = r4
        L_0x0076:
            r6 = r10
            goto L_0x0022
        L_0x0078:
            if (r7 == 0) goto L_0x0084
            com.baidu.apsaras.scheduler.scenes.ViewClickBooster r4 = INSTANCE     // Catch:{ all -> 0x0098 }
            com.baidu.apsaras.scheduler.internal.utils.ReflectionUtil$ReflectionFieldElement r4 = r4.getMessageNextField()     // Catch:{ all -> 0x0098 }
            r4.setValue(r7, r2)     // Catch:{ all -> 0x0098 }
            r2 = r7
        L_0x0084:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x0098 }
            if (r4 != 0) goto L_0x0093
            com.baidu.apsaras.scheduler.scenes.ViewClickBooster r4 = INSTANCE     // Catch:{ all -> 0x0098 }
            com.baidu.apsaras.scheduler.internal.utils.ReflectionUtil$ReflectionFieldElement r4 = r4.getMQmMessageField()     // Catch:{ all -> 0x0098 }
            r4.setValue(r0, r2)     // Catch:{ all -> 0x0098 }
        L_0x0093:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0098 }
            monitor-exit(r0)
            return
        L_0x0098:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apsaras.scheduler.scenes.ViewClickBooster.boostForPerformClickOnce():void");
    }
}
