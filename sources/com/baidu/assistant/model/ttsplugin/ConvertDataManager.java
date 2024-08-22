package com.baidu.assistant.model.ttsplugin;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.assistant.model.constants.ModelClickSite;
import com.baidu.assistant.model.constants.ModelClickType;
import com.baidu.assistant.model.constants.ModelResultType;
import com.baidu.assistant.model.data.ModelClothData;
import com.baidu.assistant.model.ttsplugin.data.CmdData;
import com.baidu.assistant.model.ttsplugin.data.EventList;
import com.baidu.assistant.model.ttsplugin.data.JsErrorInfo;
import com.baidu.assistant.model.ttsplugin.data.LipConfigData;
import com.baidu.assistant.model.ttsplugin.data.NaErrorInfo;
import com.baidu.assistant.model.ttsplugin.data.OpacityData;
import com.baidu.assistant.model.ttsplugin.data.TransformData;
import com.baidu.assistant.model.ttsplugin.data.TransformDataItem;
import com.baidu.assistant.model.ttsplugin.data.TtsContants;
import com.baidu.assistant.model.ttsplugin.data.TtsData;
import com.baidu.assistant.model.ttsplugin.data.TtsEvent;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tts.plugin.api.IHumanPlugin;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 a2\u00020\u0001:\u0001aB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001J\u0016\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\tJ\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tJ\u000e\u0010'\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020\tJ\u001a\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\tJ\u0010\u0010,\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010\tJ\u0010\u0010.\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010\tJ1\u0010/\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u001002\u0006\u0010&\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u0001H02\b\u00101\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u00102J\u0016\u00103\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\tJ\u0006\u00104\u001a\u00020\u001cJ\u001a\u00105\u001a\u00020\u001c2\b\u00106\u001a\u0004\u0018\u00010\t2\b\u00101\u001a\u0004\u0018\u00010\tJ\u000e\u00107\u001a\u00020\u001c2\u0006\u0010 \u001a\u000208J\u0010\u00109\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010\tJ \u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010\u001f\u001a\u00020\u001aJ:\u0010?\u001a\u0004\u0018\u00010\t2\b\u0010@\u001a\u0004\u0018\u00010\t2\b\u0010A\u001a\u0004\u0018\u00010\t2\b\u0010B\u001a\u0004\u0018\u00010\t2\b\u0010C\u001a\u0004\u0018\u00010\t2\b\u0010D\u001a\u0004\u0018\u00010\tJ\u0010\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\tJ\u0006\u0010H\u001a\u00020\u001cJ\u0006\u0010I\u001a\u00020\u001cJ/\u0010J\u001a\u00020\u001c\"\u0004\b\u0000\u001002\u0006\u0010&\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u0001H02\b\u00101\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010KJ%\u0010L\u001a\u00020\u001c\"\u0004\b\u0000\u001002\u0006\u0010&\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u0001H0H\u0002¢\u0006\u0002\u0010MJ/\u0010L\u001a\u00020\u001c\"\u0004\b\u0000\u001002\u0006\u0010&\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u0001H02\b\u00101\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010KJ\u0018\u0010N\u001a\u00020\u001c2\u0006\u00106\u001a\u00020O2\b\u0010 \u001a\u0004\u0018\u00010\tJ\u000e\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\tJ\u001a\u0010R\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\t2\b\u0010T\u001a\u0004\u0018\u00010\tJ\u0016\u0010U\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020VJ\u000e\u0010W\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u001aJ\u000e\u0010X\u001a\u00020\u001c2\u0006\u0010Y\u001a\u00020\tJ\u000e\u0010Z\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\tJ\u001e\u0010[\u001a\u00020\u001c2\u0006\u0010\\\u001a\u00020V2\u0006\u0010]\u001a\u00020V2\u0006\u0010^\u001a\u00020VJ\u0006\u0010_\u001a\u00020\u001cJ\u0006\u0010`\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/baidu/assistant/model/ttsplugin/ConvertDataManager;", "", "()V", "DEBUG", "", "appContext", "Landroid/content/Context;", "businessInfos", "Ljava/util/HashMap;", "", "isInitPlugin", "()Z", "setInitPlugin", "(Z)V", "isPause", "setPause", "lipVersion", "getLipVersion", "()Ljava/lang/String;", "setLipVersion", "(Ljava/lang/String;)V", "listener", "Lcom/baidu/assistant/model/ttsplugin/TtsPluginListener;", "npsPlugin", "Lcom/baidu/assistant/model/ttsplugin/NpsPlugin;", "viewType", "", "addDataObserver", "", "Observer", "addElement", "type", "info", "audioCallBackByNA", "checkPlugin", "clearAnimateBuffer", "convertClickName", "Lcom/baidu/assistant/model/constants/ModelClickSite;", "name", "convertClickType", "Lcom/baidu/assistant/model/constants/ModelClickType;", "convertTalosEvent", "eventName", "params", "coverErrorType", "Lcom/baidu/assistant/model/constants/ModelResultType;", "coverJsErrorType", "createCMD", "T", "id", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "delElement", "destory", "eventList", "event", "executeAction", "Lcom/google/gson/JsonObject;", "getLipConfig", "style", "init", "context", "container", "Landroid/view/View;", "initModel", "dress", "furniture", "camera", "scene", "bg", "parseTtsData", "Lcom/baidu/assistant/model/ttsplugin/data/TtsData;", "data", "pause", "resume", "sendBussinessCMD", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "sendCMD", "(Ljava/lang/String;Ljava/lang/Object;)V", "sendEvent", "Lcom/baidu/assistant/model/ttsplugin/data/TtsEvent;", "setActionStatus", "status", "setBusinessConfig", "key", "value", "setOpacity", "", "setRotation", "setSceneBgColor", "color", "setSpecialFaceStatus", "setTransform", "x", "y", "z", "speakCallBackByNA", "stop", "Companion", "lib-model-ttsplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConvertDataManager.kt */
public final class ConvertDataManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "Model-ConvertData";
    /* access modifiers changed from: private */
    public final boolean DEBUG = AppConfig.isDebug();
    /* access modifiers changed from: private */
    public Context appContext;
    private HashMap<String, String> businessInfos = new HashMap<>();
    private boolean isInitPlugin;
    private boolean isPause;
    private String lipVersion = "";
    /* access modifiers changed from: private */
    public TtsPluginListener listener;
    private final NpsPlugin npsPlugin = new NpsPlugin();
    private int viewType;

    public final String getLipVersion() {
        return this.lipVersion;
    }

    public final void setLipVersion(String str) {
        this.lipVersion = str;
    }

    public final boolean isPause() {
        return this.isPause;
    }

    public final void setPause(boolean z) {
        this.isPause = z;
    }

    public final boolean isInitPlugin() {
        return this.isInitPlugin;
    }

    public final void setInitPlugin(boolean z) {
        this.isInitPlugin = z;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/assistant/model/ttsplugin/ConvertDataManager$Companion;", "", "()V", "TAG", "", "lib-model-ttsplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConvertDataManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void init(Context context, View container, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.appContext = context.getApplicationContext();
        this.listener = new TtsPluginListener();
        this.viewType = type;
        this.isInitPlugin = false;
        try {
            this.npsPlugin.loadPlugin(new ConvertDataManager$init$1(type, this, container, context));
        } catch (Exception e2) {
            if (this.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026 A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045 A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072 A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085 A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091 A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098 A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b5 A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9 A[Catch:{ Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cf A[Catch:{ Exception -> 0x00f8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String initModel(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            java.lang.String r6 = "init"
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00f8 }
            r7 = 0
            r8 = 1
            if (r0 == 0) goto L_0x001c
            int r0 = r0.length()     // Catch:{ Exception -> 0x00f8 }
            if (r0 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r0 = r7
            goto L_0x001d
        L_0x001c:
            r0 = r8
        L_0x001d:
            if (r0 == 0) goto L_0x0026
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
        L_0x0024:
            r12 = r0
            goto L_0x0034
        L_0x0026:
            com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonElement r0 = r0.parse((java.lang.String) r2)     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x00f8 }
            goto L_0x0024
        L_0x0034:
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00f8 }
            if (r0 == 0) goto L_0x0042
            int r0 = r0.length()     // Catch:{ Exception -> 0x00f8 }
            if (r0 != 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r0 = r7
            goto L_0x0043
        L_0x0042:
            r0 = r8
        L_0x0043:
            if (r0 == 0) goto L_0x004c
            com.google.gson.JsonArray r0 = new com.google.gson.JsonArray     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
        L_0x004a:
            r11 = r0
            goto L_0x005a
        L_0x004c:
            com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonElement r0 = r0.parse((java.lang.String) r3)     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonArray r0 = r0.getAsJsonArray()     // Catch:{ Exception -> 0x00f8 }
            goto L_0x004a
        L_0x005a:
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00f8 }
            if (r0 == 0) goto L_0x0068
            int r0 = r0.length()     // Catch:{ Exception -> 0x00f8 }
            if (r0 != 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r0 = r7
            goto L_0x0069
        L_0x0068:
            r0 = r8
        L_0x0069:
            if (r0 == 0) goto L_0x0072
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
        L_0x0070:
            r13 = r0
            goto L_0x0080
        L_0x0072:
            com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonElement r0 = r0.parse((java.lang.String) r4)     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x00f8 }
            goto L_0x0070
        L_0x0080:
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00f8 }
            if (r0 == 0) goto L_0x008e
            int r0 = r0.length()     // Catch:{ Exception -> 0x00f8 }
            if (r0 != 0) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            r0 = r7
            goto L_0x008f
        L_0x008e:
            r0 = r8
        L_0x008f:
            if (r0 == 0) goto L_0x0098
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
        L_0x0096:
            r14 = r0
            goto L_0x00a6
        L_0x0098:
            com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonElement r0 = r0.parse((java.lang.String) r5)     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x00f8 }
            goto L_0x0096
        L_0x00a6:
            r0 = r22
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00f8 }
            if (r0 == 0) goto L_0x00b2
            int r0 = r0.length()     // Catch:{ Exception -> 0x00f8 }
            if (r0 != 0) goto L_0x00b3
        L_0x00b2:
            r7 = r8
        L_0x00b3:
            if (r7 == 0) goto L_0x00b9
            java.lang.String r0 = ""
            r15 = r0
            goto L_0x00bb
        L_0x00b9:
            r15 = r22
        L_0x00bb:
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
            com.baidu.assistant.model.ttsplugin.data.InitModelData r7 = new com.baidu.assistant.model.ttsplugin.data.InitModelData     // Catch:{ Exception -> 0x00f8 }
            r10 = 1
            r9 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r0 = r0.toJson((java.lang.Object) r7)     // Catch:{ Exception -> 0x00f8 }
            boolean r7 = r1.DEBUG     // Catch:{ Exception -> 0x00f8 }
            if (r7 == 0) goto L_0x00e7
            java.lang.String r7 = "Model-ConvertData"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f8 }
            r8.<init>()     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r9 = "initModel data = "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x00f8 }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00f8 }
            android.util.Log.d(r7, r8)     // Catch:{ Exception -> 0x00f8 }
        L_0x00e7:
            com.google.gson.JsonParser r7 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x00f8 }
            r7.<init>()     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonElement r7 = r7.parse((java.lang.String) r0)     // Catch:{ Exception -> 0x00f8 }
            com.google.gson.JsonObject r7 = r7.getAsJsonObject()     // Catch:{ Exception -> 0x00f8 }
            r1.sendCMD(r6, r7)     // Catch:{ Exception -> 0x00f8 }
            return r0
        L_0x00f8:
            r0 = move-exception
            com.google.gson.JsonObject r10 = new com.google.gson.JsonObject
            r10.<init>()
            com.google.gson.JsonArray r9 = new com.google.gson.JsonArray
            r9.<init>()
            com.google.gson.JsonObject r11 = new com.google.gson.JsonObject
            r11.<init>()
            com.google.gson.JsonObject r12 = new com.google.gson.JsonObject
            r12.<init>()
            java.lang.String r14 = ""
            com.google.gson.Gson r15 = new com.google.gson.Gson
            r15.<init>()
            com.baidu.assistant.model.ttsplugin.data.InitModelData r13 = new com.baidu.assistant.model.ttsplugin.data.InitModelData
            r8 = 1
            r7 = r13
            r16 = r0
            r0 = r13
            r13 = r14
            r7.<init>(r8, r9, r10, r11, r12, r13)
            java.lang.String r0 = r15.toJson((java.lang.Object) r0)
            com.google.gson.JsonParser r7 = new com.google.gson.JsonParser
            r7.<init>()
            com.google.gson.JsonElement r7 = r7.parse((java.lang.String) r0)
            com.google.gson.JsonObject r7 = r7.getAsJsonObject()
            r1.sendCMD(r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.assistant.model.ttsplugin.ConvertDataManager.initModel(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public final void setOpacity(int type, float value) {
        sendCMD(TtsContants.SETOPACITY, new JsonParser().parse(new Gson().toJson((Object) new OpacityData(type, value))).getAsJsonObject());
    }

    private final <T> void sendCMD(String name, T params) {
        sendCMD(name, params, "");
    }

    private final <T> String createCMD(String name, T params, String id) {
        try {
            return new Gson().toJson((Object) new CmdData(name, params, id, this.businessInfos.get("business"), this.businessInfos.get("module"), this.businessInfos.get("event")));
        } catch (Exception e2) {
            if (!this.DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    private final <T> void sendBussinessCMD(String name, T params, String id) {
        String cmd = createCMD(name, params, id);
        CharSequence charSequence = cmd;
        if (!(charSequence == null || charSequence.length() == 0)) {
            sendEvent(TtsEvent.TALOSBUSINESSEVENT, cmd);
        }
    }

    private final <T> void sendCMD(String name, T params, String id) {
        String createCMD = createCMD(name, params, id);
        if (this.viewType == 0) {
            CharSequence charSequence = createCMD;
            if (!(charSequence == null || charSequence.length() == 0)) {
                sendEvent(TtsEvent.TALOSEVENT, createCMD);
                return;
            }
            return;
        }
        IHumanPlugin it = this.npsPlugin.getPlugin();
        if (it != null) {
            if (this.DEBUG) {
                Log.d(TAG, "tts sendCMD =" + createCMD);
            }
            it.sendCMD(createCMD);
        }
    }

    public final void setTransform(float x, float y, float z) {
        sendCMD(TtsContants.TRANSFORMSCENE, new JsonParser().parse(new Gson().toJson((Object) new TransformData(new TransformDataItem(x, y, z)))).getAsJsonObject());
    }

    public final ModelClickSite convertClickName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.DEBUG) {
            Log.d(TAG, "cliick tts name =" + name);
        }
        switch (name.hashCode()) {
            case -819536195:
                if (name.equals(TtsContants.ARM)) {
                    return ModelClickSite.CLICK_ARM;
                }
                break;
            case -819526033:
                if (name.equals(TtsContants.LEGS)) {
                    return ModelClickSite.CLICK_LEGS;
                }
                break;
            case 364208481:
                if (name.equals(TtsContants.BODY)) {
                    return ModelClickSite.CLICK_BODY;
                }
                break;
            case 364314140:
                if (name.equals(TtsContants.FACE)) {
                    return ModelClickSite.CLICK_FACE;
                }
                break;
            case 364327981:
                if (name.equals(TtsContants.FOOT)) {
                    return ModelClickSite.CLICK_FOOT;
                }
                break;
            case 364373921:
                if (name.equals(TtsContants.HAIR)) {
                    return ModelClickSite.CLICK_HAIR;
                }
                break;
            case 364374062:
                if (name.equals(TtsContants.HAND)) {
                    return ModelClickSite.CLICK_HAND;
                }
                break;
        }
        return ModelClickSite.CLICK_BLANK;
    }

    public final boolean addElement(int type, String info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (type == 0) {
            try {
                ModelClothData data = (ModelClothData) new Gson().fromJson(info, ModelClothData.class);
                sendBussinessCMD(TtsContants.ADDDRESS, new JsonParser().parse(data.getParam()).getAsJsonObject(), data.getId());
                return true;
            } catch (Exception e2) {
                return false;
            }
        } else {
            sendBussinessCMD(TtsContants.ADDFURNITURE, new JsonParser().parse(info).getAsJsonArray(), "");
            return true;
        }
    }

    public final void delElement(int type, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (type == 0) {
            sendCMD(TtsContants.DELDRESS, name);
        } else {
            sendCMD(TtsContants.DELFURNITURE, name);
        }
    }

    public final ModelClickType convertClickType(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.DEBUG) {
            Log.d(TAG, "cliick tts type =" + type);
        }
        return ModelClickType.CLICK;
    }

    public final ModelResultType coverJsErrorType(String info) {
        if (this.DEBUG) {
            Log.d(TAG, "加载发生错误  =" + info);
        }
        if (info != null) {
            try {
                String status = ((JsErrorInfo) new Gson().fromJson(info, JsErrorInfo.class)).getStatus();
                if (Intrinsics.areEqual((Object) status, (Object) "5")) {
                    ModelResultType modelResultType = ModelResultType.INITERROR;
                } else if (Intrinsics.areEqual((Object) status, (Object) "4")) {
                    ModelResultType modelResultType2 = ModelResultType.RUNERROR;
                } else {
                    ModelResultType modelResultType3 = ModelResultType.UNKOWNERROR;
                }
            } catch (Exception e2) {
                ModelResultType modelResultType4 = ModelResultType.UNKOWNERROR;
            }
        }
        return ModelResultType.UNKOWNERROR;
    }

    public final ModelResultType coverErrorType(String info) {
        if (this.DEBUG) {
            Log.d(TAG, "加载发生错误  =" + info);
        }
        CharSequence charSequence = info;
        if (charSequence == null || charSequence.length() == 0) {
            return ModelResultType.UNKOWNERROR;
        }
        try {
            int type = ((NaErrorInfo) new Gson().fromJson(info, NaErrorInfo.class)).getType();
            if (type == ModelResultType.TALOSERROR.ordinal()) {
                return ModelResultType.TALOSERROR;
            }
            if (type == ModelResultType.TALOSUPDATEERROR.ordinal()) {
                return ModelResultType.TALOSUPDATEERROR;
            }
            if (type == ModelResultType.PLUGINERROR.ordinal()) {
                return ModelResultType.PLUGINERROR;
            }
            return ModelResultType.UNKOWNERROR;
        } catch (Exception e2) {
            return ModelResultType.UNKOWNERROR;
        }
    }

    public final void speakCallBackByNA() {
        sendCMD(TtsContants.SPEAKCALLBACK, "");
    }

    public final void audioCallBackByNA() {
        sendCMD(TtsContants.AUDIOCALLBACK, "");
    }

    public final void setSceneBgColor(String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        sendCMD(TtsContants.BGCOLOR, color);
    }

    public final void setActionStatus(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        sendCMD(TtsContants.ANIAMTIONSTATUS, status);
    }

    public final void setSpecialFaceStatus(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        sendCMD(TtsContants.FACESTATUS, status);
    }

    public final void addDataObserver(Object Observer) {
        Intrinsics.checkNotNullParameter(Observer, "Observer");
        if (this.DEBUG) {
            Log.d(TAG, "addDataObserver");
        }
        TtsPluginListener ttsPluginListener = this.listener;
        if (ttsPluginListener != null) {
            ttsPluginListener.addObserver(Observer);
        }
    }

    public final void resume() {
        if (this.isPause) {
            this.isPause = false;
            setActionStatus("resume");
            setSpecialFaceStatus("resume");
        }
    }

    public final void pause() {
        if (!this.isPause) {
            this.isPause = true;
            setActionStatus("pause");
            setSpecialFaceStatus("pause");
        }
    }

    public final void stop() {
        if (this.DEBUG) {
            Log.d(TAG, "stop");
        }
        pause();
    }

    public final void setRotation(int status) {
        sendCMD(TtsContants.ROTATION, Integer.valueOf(status));
    }

    public final void clearAnimateBuffer() {
        sendCMD(TtsContants.CLEARANIMATEBUFFER, "");
    }

    public final void executeAction(JsonObject info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.DEBUG) {
            Log.d(TAG, "executeAction =" + info);
        }
        JsonArray action = new JsonArray();
        action.add((JsonElement) info);
        JsonArray data = new JsonArray();
        data.add((JsonElement) action);
        try {
            sendCMD(TtsContants.NATIVEEVENT, new JsonParser().parse(new Gson().toJson((Object) new EventList(data))).getAsJsonObject());
        } catch (Exception e2) {
            if (this.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public final void eventList(String event, String id) {
        if (this.DEBUG) {
            Log.d(TAG, "eventList =" + event);
        }
        this.isPause = false;
        try {
            sendCMD(TtsContants.NATIVEEVENT, new JsonParser().parse(new Gson().toJson((Object) new EventList(new JsonParser().parse(event).getAsJsonArray()))).getAsJsonObject(), id);
        } catch (Exception e2) {
            if (this.DEBUG) {
                e2.printStackTrace();
            }
            TtsPluginListener ttsPluginListener = this.listener;
            if (ttsPluginListener != null) {
                ttsPluginListener.sendEvent(TtsEvent.EVENTLIST, id);
            }
        }
    }

    public final void convertTalosEvent(String eventName, String params) {
        TtsPluginListener ttsPluginListener;
        if (this.DEBUG) {
            Log.d(TAG, "convertTalosEvent = " + eventName + " params =" + params);
        }
        CharSequence charSequence = eventName;
        if (!(charSequence == null || charSequence.length() == 0)) {
            if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.PAGEREADY.getValue())) {
                TtsPluginListener ttsPluginListener2 = this.listener;
                if (ttsPluginListener2 != null) {
                    ttsPluginListener2.sendEvent(TtsEvent.PAGEREADY, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.MODELREADY.getValue())) {
                TtsPluginListener ttsPluginListener3 = this.listener;
                if (ttsPluginListener3 != null) {
                    ttsPluginListener3.sendEvent(TtsEvent.MODELREADY, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.EVENTLIST.getValue())) {
                TtsPluginListener ttsPluginListener4 = this.listener;
                if (ttsPluginListener4 != null) {
                    ttsPluginListener4.sendEvent(TtsEvent.EVENTLIST, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.STARTSPEAKER.getValue())) {
                TtsPluginListener ttsPluginListener5 = this.listener;
                if (ttsPluginListener5 != null) {
                    ttsPluginListener5.sendEvent(TtsEvent.STARTSPEAKER, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.EMITEVENT.getValue())) {
                TtsPluginListener ttsPluginListener6 = this.listener;
                if (ttsPluginListener6 != null) {
                    ttsPluginListener6.sendEvent(TtsEvent.EMITEVENT, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.STOPSPEAK.getValue())) {
                TtsPluginListener ttsPluginListener7 = this.listener;
                if (ttsPluginListener7 != null) {
                    ttsPluginListener7.sendEvent(TtsEvent.STOPSPEAK, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.STARTAUDIO.getValue())) {
                TtsPluginListener ttsPluginListener8 = this.listener;
                if (ttsPluginListener8 != null) {
                    ttsPluginListener8.sendEvent(TtsEvent.STARTAUDIO, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.STOPAUDIO.getValue())) {
                TtsPluginListener ttsPluginListener9 = this.listener;
                if (ttsPluginListener9 != null) {
                    ttsPluginListener9.sendEvent(TtsEvent.STOPAUDIO, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.ONJSERROR.getValue())) {
                TtsPluginListener ttsPluginListener10 = this.listener;
                if (ttsPluginListener10 != null) {
                    ttsPluginListener10.sendEvent(TtsEvent.ONJSERROR, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.ONERROR.getValue())) {
                TtsPluginListener ttsPluginListener11 = this.listener;
                if (ttsPluginListener11 != null) {
                    ttsPluginListener11.sendEvent(TtsEvent.ONERROR, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.CHABGECLOTHCOMPLETE.getValue())) {
                TtsPluginListener ttsPluginListener12 = this.listener;
                if (ttsPluginListener12 != null) {
                    ttsPluginListener12.sendEvent(TtsEvent.CHABGECLOTHCOMPLETE, params);
                }
            } else if (Intrinsics.areEqual((Object) eventName, (Object) TtsEvent.TOPDLCREADY.getValue()) && (ttsPluginListener = this.listener) != null) {
                ttsPluginListener.sendEvent(TtsEvent.TOPDLCREADY, params);
            }
        }
    }

    public final void destory() {
        if (this.DEBUG) {
            Log.d(TAG, "destory");
        }
        TtsPluginListener ttsPluginListener = this.listener;
        if (ttsPluginListener != null) {
            ttsPluginListener.unregisterObservers();
        }
        this.listener = null;
        this.appContext = null;
        try {
            this.npsPlugin.destory();
            this.isInitPlugin = false;
        } catch (Exception e2) {
            if (this.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public final String getLipConfig(String style) {
        String lipData = new Gson().toJson((Object) new LipConfigData(this.lipVersion, style));
        if (this.DEBUG) {
            Log.d(TAG, "lipData =" + lipData);
        }
        Intrinsics.checkNotNullExpressionValue(lipData, "lipData");
        return lipData;
    }

    public final TtsData parseTtsData(String data) {
        if (data == null) {
            return new TtsData("", "");
        }
        try {
            TtsData ttsData = (TtsData) new Gson().fromJson(data, TtsData.class);
            Intrinsics.checkNotNullExpressionValue(ttsData, "ttsData");
            return ttsData;
        } catch (Exception e2) {
            return new TtsData("", "");
        }
    }

    public final void sendEvent(TtsEvent event, String info) {
        Intrinsics.checkNotNullParameter(event, "event");
        TtsPluginListener ttsPluginListener = this.listener;
        if (ttsPluginListener != null) {
            ttsPluginListener.sendEvent(event, info);
        }
    }

    public final void checkPlugin() {
        if (this.npsPlugin.isLoadError()) {
            try {
                this.npsPlugin.checkPlugin(new ConvertDataManager$checkPlugin$1(this));
            } catch (Exception e2) {
                if (this.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void setBusinessConfig(String key, String value) {
        CharSequence charSequence = key;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = value;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                HashMap<String, String> hashMap = this.businessInfos;
                Intrinsics.checkNotNull(key);
                Intrinsics.checkNotNull(value);
                hashMap.put(key, value);
            }
        }
    }
}
