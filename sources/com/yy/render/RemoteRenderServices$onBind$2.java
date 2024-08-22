package com.yy.render;

import android.os.Bundle;
import android.view.Surface;
import com.vivo.push.PushClientConstants;
import com.yy.render.IRemoteRender;
import com.yy.render.trans.RenderDataHandler;
import com.yy.render.util.RLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J&\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0015\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0016\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0018H\u0016J:\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\"\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u001a\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\"\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006#"}, d2 = {"com/yy/render/RemoteRenderServices$onBind$2", "Lcom/yy/render/IRemoteRender$Stub;", "addContentView", "", "channelId", "", "clazz", "kill", "registerDataListener", "", "className", "listener", "Lcom/yy/render/ITransDataListener;", "removeContentView", "sendBundle", "data", "Landroid/os/Bundle;", "sendBundleForBoolean", "sendBundleForStr", "sendData", "sendData2Channel", "sendDataForBoolean", "sendDataForStr", "setListener", "Lcom/yy/render/IRemoteListener;", "surfaceChanged", "surface", "Landroid/view/Surface;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "unRegisterDataListener", "render_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RemoteRenderServices.kt */
public final class RemoteRenderServices$onBind$2 extends IRemoteRender.Stub {
    final /* synthetic */ RemoteRenderServices this$0;

    RemoteRenderServices$onBind$2(RemoteRenderServices $outer) {
        this.this$0 = $outer;
    }

    public void kill() {
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public void surfaceCreated(String channelId, Surface surface, String className) {
        Intrinsics.checkParameterIsNotNull(channelId, "channelId");
        Intrinsics.checkParameterIsNotNull(className, PushClientConstants.TAG_CLASS_NAME);
        this.this$0.serverSurfaceCreated(channelId, surface, className);
    }

    public void surfaceChanged(String channelId, Surface surface, String className, int format, int width, int height) {
        Intrinsics.checkParameterIsNotNull(channelId, "channelId");
        Intrinsics.checkParameterIsNotNull(className, PushClientConstants.TAG_CLASS_NAME);
        this.this$0.serverSurfaceChanged(channelId, surface, className, format, width, height);
    }

    public void surfaceDestroyed(String channelId, Surface surface) {
        Intrinsics.checkParameterIsNotNull(channelId, "channelId");
        this.this$0.serverSurfaceDestroyed(channelId, surface);
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a8, code lost:
        r0.printStackTrace();
        com.yy.render.util.RLog.Companion.e("[RenderServices] sendData2Channel ex: " + r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendData2Channel(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00c9
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0014
            goto L_0x00c9
        L_0x0014:
            com.yy.render.util.RLog$Companion r0 = com.yy.render.util.RLog.Companion
            java.lang.String r1 = "sub_process_view"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[RenderServices] get data channelId: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r3 = ", data: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r2 = r2.toString()
            r0.e(r1, r2)
            com.yy.render.RenderViewHandler$Companion r0 = com.yy.render.RenderViewHandler.Companion     // Catch:{ Exception -> 0x00a7 }
            com.yy.render.RenderViewHandler r0 = r0.getInstance()     // Catch:{ Exception -> 0x00a7 }
            if (r6 != 0) goto L_0x0045
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ Exception -> 0x00a7 }
        L_0x0045:
            com.yy.render.view.RenderView r0 = r0.getPlatformView(r6)     // Catch:{ Exception -> 0x00a7 }
            if (r0 != 0) goto L_0x0099
            com.yy.render.RemoteRenderServices r1 = r5.this$0     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class r1 = r1.lock     // Catch:{ Exception -> 0x00a7 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x00a7 }
            r2 = 0
            com.yy.render.RemoteRenderServices r3 = r5.this$0     // Catch:{ all -> 0x0096 }
            java.util.LinkedHashMap r3 = r3.message     // Catch:{ all -> 0x0096 }
            java.lang.Object r3 = r3.get(r6)     // Catch:{ all -> 0x0096 }
            if (r3 != 0) goto L_0x006f
            com.yy.render.RemoteRenderServices r3 = r5.this$0     // Catch:{ all -> 0x0096 }
            java.util.LinkedHashMap r3 = r3.message     // Catch:{ all -> 0x0096 }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x0096 }
            java.util.LinkedList r4 = new java.util.LinkedList     // Catch:{ all -> 0x0096 }
            r4.<init>()     // Catch:{ all -> 0x0096 }
            r3.put(r6, r4)     // Catch:{ all -> 0x0096 }
        L_0x006f:
            com.yy.render.RemoteRenderServices r3 = r5.this$0     // Catch:{ all -> 0x0096 }
            java.util.LinkedHashMap r3 = r3.message     // Catch:{ all -> 0x0096 }
            java.lang.Object r3 = r3.get(r6)     // Catch:{ all -> 0x0096 }
            java.util.LinkedList r3 = (java.util.LinkedList) r3     // Catch:{ all -> 0x0096 }
            if (r3 != 0) goto L_0x0080
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0096 }
        L_0x0080:
            if (r7 != 0) goto L_0x0085
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0096 }
        L_0x0085:
            r3.add(r7)     // Catch:{ all -> 0x0096 }
            com.yy.render.RemoteRenderServices r4 = r5.this$0     // Catch:{ all -> 0x0096 }
            java.util.LinkedHashMap r4 = r4.message     // Catch:{ all -> 0x0096 }
            java.lang.Object r4 = r4.put(r6, r3)     // Catch:{ all -> 0x0096 }
            java.util.LinkedList r4 = (java.util.LinkedList) r4     // Catch:{ all -> 0x0096 }
            monitor-exit(r1)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00c7
        L_0x0096:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ Exception -> 0x00a7 }
            throw r2     // Catch:{ Exception -> 0x00a7 }
        L_0x0099:
            com.yy.render.RemoteRenderServices r1 = r5.this$0     // Catch:{ Exception -> 0x00a7 }
            r1.sendCacheMessage(r0, r6)     // Catch:{ Exception -> 0x00a7 }
            if (r7 != 0) goto L_0x00a3
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ Exception -> 0x00a7 }
        L_0x00a3:
            r0.onDataFromMainProcess(r7)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00c7
        L_0x00a7:
            r0 = move-exception
            r0.printStackTrace()
            com.yy.render.util.RLog$Companion r1 = com.yy.render.util.RLog.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[RenderServices] sendData2Channel ex: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.e(r2)
        L_0x00c7:
            return
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.render.RemoteRenderServices$onBind$2.sendData2Channel(java.lang.String, java.lang.String):void");
    }

    public boolean registerDataListener(String channelId, String className, ITransDataListener listener) {
        return RenderDataHandler.Companion.getInstance().registerDataListener(this.this$0.mContext, channelId, className, listener);
    }

    public boolean unRegisterDataListener(String channelId, ITransDataListener listener) {
        return RenderDataHandler.Companion.getInstance().unRegisterDataListener(channelId, listener);
    }

    public void sendData(String channelId, String data) {
        RenderDataHandler.Companion.getInstance().onDataFromClient(channelId, data);
    }

    public String sendDataForStr(String channelId, String data) {
        return RenderDataHandler.Companion.getInstance().onDataFromClientForStr(channelId, data);
    }

    public boolean sendDataForBoolean(String channelId, String data) {
        return RenderDataHandler.Companion.getInstance().onDataFromClientForBoolean(channelId, data);
    }

    public void sendBundle(String channelId, Bundle data) {
        RenderDataHandler.Companion.getInstance().onBundleFromClient(channelId, data);
    }

    public boolean sendBundleForBoolean(String channelId, Bundle data) {
        return RenderDataHandler.Companion.getInstance().onBundleFromClientForBoolean(channelId, data);
    }

    public String sendBundleForStr(String channelId, Bundle data) {
        return RenderDataHandler.Companion.getInstance().onBundleFromClientForStr(channelId, data);
    }

    public void setListener(IRemoteListener listener) {
        RLog.Companion.i(RLog.TAG, "[RenderServices] invokeClient");
        if (listener == null) {
            RLog.Companion.i(RLog.TAG, "[RenderServices] IRemoteListener is null");
        } else {
            RLog.Companion.i(RLog.TAG, "[RenderServices] IRemoteListener is normal");
        }
        synchronized (this) {
            if (listener != null) {
                RenderCallbackHandler.Companion.getInstance().register(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void addContentView(String channelId, String clazz) {
        Intrinsics.checkParameterIsNotNull(channelId, "channelId");
        Intrinsics.checkParameterIsNotNull(clazz, com.baidu.nps.main.manager.Bundle.EXTRA_KEY_CLAZZ);
        RLog.Companion.i(RLog.TAG, "[RenderServices](addContentView) " + channelId);
        this.this$0.mainHandler.post(new RemoteRenderServices$onBind$2$addContentView$1(this, channelId, clazz));
    }

    public void removeContentView(String channelId) {
        this.this$0.mainHandler.post(new RemoteRenderServices$onBind$2$removeContentView$1(channelId));
    }
}
