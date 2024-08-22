package com.baidu.assistant.debug.assistant.singletest;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.baidu.assistant.debug.R;
import com.baidu.assistant.debug.activity.AssistantModelDemoActivity;
import com.baidu.assistant.debug.assistant.autoutil.AutoTestState;
import com.baidu.assistant.debug.assistant.autoutil.ModelAutoTestProxy;
import com.baidu.assistant.model.clound.api.pyramd.ModelDownloadInterface;
import com.baidu.assistant.model.data.ModelBundleConfig;
import com.baidu.assistant.model.data.ModelInitConfig;
import com.baidu.assistant.model.data.ModelLoadDataConfig;
import com.baidu.assistant.model.interfaces.ModelManagerInterface;
import com.baidu.assistant.model.pyramd.ModelControllerInterface;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.system.wifi.model.WifiCallbackResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u001fJ\b\u0010%\u001a\u00020\u001fH\u0002J\u0016\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0006\u0010-\u001a\u00020\u001fR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/baidu/assistant/debug/assistant/singletest/ModelSingleTestImpl;", "", "testManager", "Lcom/baidu/assistant/debug/assistant/autoutil/ModelAutoTestProxy;", "(Lcom/baidu/assistant/debug/assistant/autoutil/ModelAutoTestProxy;)V", "POSITION_NAME_X", "", "POSITION_NAME_Y", "POSITION_NAME_Z", "TAG", "kotlin.jvm.PlatformType", "modelInterface", "Lcom/baidu/assistant/model/interfaces/ModelManagerInterface;", "getModelInterface", "()Lcom/baidu/assistant/model/interfaces/ModelManagerInterface;", "setModelInterface", "(Lcom/baidu/assistant/model/interfaces/ModelManagerInterface;)V", "modelParentContainer", "Landroid/widget/FrameLayout;", "getModelParentContainer", "()Landroid/widget/FrameLayout;", "setModelParentContainer", "(Landroid/widget/FrameLayout;)V", "positionValueX", "Landroid/util/TypedValue;", "positionValueY", "positionValueZ", "state", "getTestManager", "()Lcom/baidu/assistant/debug/assistant/autoutil/ModelAutoTestProxy;", "begin", "", "downloadBaseModel", "downloadExtendModel", "getModelConfig", "Lcom/baidu/assistant/model/data/ModelInitConfig;", "initInteractionCallBack", "isNetworkConnected", "loadModel", "product", "business", "networkConnected", "", "context", "Landroid/content/Context;", "onDestroy", "lib-assistant-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModelSingleTestImpl.kt */
public final class ModelSingleTestImpl {
    private final String POSITION_NAME_X = "x";
    private final String POSITION_NAME_Y = "y";
    private final String POSITION_NAME_Z = "z";
    /* access modifiers changed from: private */
    public final String TAG = AssistantModelDemoActivity.class.getSimpleName();
    private ModelManagerInterface modelInterface;
    private FrameLayout modelParentContainer;
    private final TypedValue positionValueX = new TypedValue();
    private final TypedValue positionValueY = new TypedValue();
    private final TypedValue positionValueZ = new TypedValue();
    /* access modifiers changed from: private */
    public String state = "init";
    private final ModelAutoTestProxy testManager;

    public ModelSingleTestImpl(ModelAutoTestProxy testManager2) {
        Intrinsics.checkNotNullParameter(testManager2, "testManager");
        this.testManager = testManager2;
    }

    public final ModelAutoTestProxy getTestManager() {
        return this.testManager;
    }

    public final FrameLayout getModelParentContainer() {
        return this.modelParentContainer;
    }

    public final void setModelParentContainer(FrameLayout frameLayout) {
        this.modelParentContainer = frameLayout;
    }

    public final ModelManagerInterface getModelInterface() {
        return this.modelInterface;
    }

    public final void setModelInterface(ModelManagerInterface modelManagerInterface) {
        this.modelInterface = modelManagerInterface;
    }

    public final void begin() {
        isNetworkConnected();
        downloadBaseModel();
        downloadExtendModel();
        loadModel("autoTest", "loadTest");
    }

    private final void isNetworkConnected() {
        if (networkConnected(this.testManager.getContext())) {
            ModelAutoTestProxy.updateItemState$default(this.testManager, 1, 1, (String) null, 4, (Object) null);
        } else {
            ModelAutoTestProxy.updateItemState$default(this.testManager, 1, -1, (String) null, 4, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean networkConnected(android.content.Context r7) {
        /*
            r6 = this;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r7.getSystemService(r0)
            if (r0 == 0) goto L_0x0045
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            r3 = 0
            r4 = 1
            if (r1 >= r2) goto L_0x002a
            android.net.NetworkInfo r1 = r0.getActiveNetworkInfo()
            if (r1 == 0) goto L_0x0044
            int r2 = r1.getType()
            if (r2 != r4) goto L_0x0023
            return r4
        L_0x0023:
            int r2 = r1.getType()
            if (r2 != 0) goto L_0x0044
            return r4
        L_0x002a:
            android.net.Network r1 = r0.getActiveNetwork()
            if (r1 == 0) goto L_0x0044
            android.net.NetworkCapabilities r2 = r0.getNetworkCapabilities(r1)
            if (r2 == 0) goto L_0x0044
            boolean r5 = r2.hasTransport(r4)
            if (r5 == 0) goto L_0x003d
            return r4
        L_0x003d:
            boolean r5 = r2.hasTransport(r3)
            if (r5 == 0) goto L_0x0044
            return r4
        L_0x0044:
            return r3
        L_0x0045:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.assistant.debug.assistant.singletest.ModelSingleTestImpl.networkConnected(android.content.Context):boolean");
    }

    public final void initInteractionCallBack() {
        ModelSingleTestImpl$initInteractionCallBack$modelInteractionCallBack$1 modelInteractionCallBack = new ModelSingleTestImpl$initInteractionCallBack$modelInteractionCallBack$1(this);
        ModelManagerInterface modelManagerInterface = this.modelInterface;
        if (modelManagerInterface != null) {
            modelManagerInterface.setInteractionCallBack(modelInteractionCallBack);
        }
    }

    private final void downloadBaseModel() {
        try {
            AutoTestState.INSTANCE.setMatchCurModel(true);
            Object service = ServiceManager.getService(ModelDownloadInterface.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(ModelDownload…erface.SERVICE_REFERENCE)");
            ((ModelDownloadInterface) service).readFile("", "duxiaoxiao", "dxx_base", Float.valueOf(1.33f), "dxx_base_1.33//a_skinFace0.dat", new ModelSingleTestImpl$downloadBaseModel$1(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void downloadExtendModel() {
        ModelDownloadInterface model = (ModelDownloadInterface) ServiceManager.getService(ModelDownloadInterface.SERVICE_REFERENCE);
        Float valueOf = Float.valueOf(1.33f);
        model.downloadModel("", "duxiaoxiao", "dxx_base", valueOf, new ModelSingleTestImpl$downloadExtendModel$1(this));
        model.readExtendFile("", "duxiaoxiao", "dxx_base", valueOf, "dxx_base_1.33//URP_dxx_250_2_data.bin", new ModelSingleTestImpl$downloadExtendModel$2(this));
    }

    public final void loadModel(String product, String business) {
        String str = product;
        String str2 = business;
        Intrinsics.checkNotNullParameter(str, "product");
        Intrinsics.checkNotNullParameter(str2, "business");
        this.modelInterface = ((ModelControllerInterface) ServiceManager.getService(ModelControllerInterface.SERVICE_REFERENCE)).createModelManager(str, str2);
        initInteractionCallBack();
        ModelLoadDataConfig modelLoadData = new ModelLoadDataConfig(getModelConfig(), new ModelBundleConfig("box.rnplugin.tts.digital.human", "talos_tts_digital_human", 0, 0), new ModelSingleTestImpl$loadModel$modelLoadCallBack$1(this, str2), this.testManager.getContext(), false, WifiCallbackResult.ERR_CODE_NOT_INIT);
        ModelManagerInterface modelManagerInterface = this.modelInterface;
        if ((modelManagerInterface != null ? modelManagerInterface.loadModel(modelLoadData) : null) == null) {
            ModelAutoTestProxy.updateItemState$default(this.testManager, 14, -1, (String) null, 4, (Object) null);
            return;
        }
        this.state = "success";
        ModelAutoTestProxy.updateItemState$default(this.testManager, 12, 1, (String) null, 4, (Object) null);
        ModelAutoTestProxy.updateItemState$default(this.testManager, 13, 1, (String) null, 4, (Object) null);
        ModelAutoTestProxy.updateItemState$default(this.testManager, 24, 1, (String) null, 4, (Object) null);
    }

    private final ModelInitConfig getModelConfig() {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Context appContext = AppRuntime.getAppContext();
        if (!(appContext == null || (resources3 = appContext.getResources()) == null)) {
            resources3.getValue(R.dimen.chat_model_x, this.positionValueX, true);
        }
        Context appContext2 = AppRuntime.getAppContext();
        if (!(appContext2 == null || (resources2 = appContext2.getResources()) == null)) {
            resources2.getValue(R.dimen.chat_model_y, this.positionValueY, true);
        }
        Context appContext3 = AppRuntime.getAppContext();
        if (!(appContext3 == null || (resources = appContext3.getResources()) == null)) {
            resources.getValue(R.dimen.chat_model_z, this.positionValueZ, true);
        }
        JSONObject scene = new JSONObject();
        scene.put(this.POSITION_NAME_X, Float.valueOf(this.positionValueX.getFloat()));
        scene.put(this.POSITION_NAME_Y, Float.valueOf(this.positionValueY.getFloat()));
        scene.put(this.POSITION_NAME_Z, Float.valueOf(this.positionValueZ.getFloat()));
        return new ModelInitConfig((String) null, (String) null, (String) null, scene.toString(), (String) null);
    }

    public final void onDestroy() {
        ModelManagerInterface modelManagerInterface = this.modelInterface;
        if (modelManagerInterface != null) {
            modelManagerInterface.destory();
        }
        this.state = "init";
    }
}
