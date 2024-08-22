package com.baidu.searchbox.mall.container;

import com.baidu.searchbox.browserenhanceengine.container.Container;
import com.baidu.searchbox.browserenhanceengine.container.ContainerModel;
import com.baidu.searchbox.mall.InterfaceAdapter;
import com.baidu.searchbox.mall.SearchEntrance;
import com.baidu.searchbox.mall.comp.root.MallRootParams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/mall/container/MallContainerModel;", "Lcom/baidu/searchbox/browserenhanceengine/container/ContainerModel;", "()V", "params", "Lcom/baidu/searchbox/mall/comp/root/MallRootParams;", "(Lcom/baidu/searchbox/mall/comp/root/MallRootParams;)V", "getParams", "()Lcom/baidu/searchbox/mall/comp/root/MallRootParams;", "setParams", "generateParamsFromJson", "json", "", "getContainerClass", "Ljava/lang/Class;", "Lcom/baidu/searchbox/browserenhanceengine/container/Container;", "getGon", "Lcom/google/gson/Gson;", "load", "", "paramsToJson", "toJsonString", "lib-mall-bee-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MallContainerModel.kt */
public final class MallContainerModel extends ContainerModel {
    private MallRootParams params;

    public final MallRootParams getParams() {
        return this.params;
    }

    public final void setParams(MallRootParams mallRootParams) {
        this.params = mallRootParams;
    }

    public MallContainerModel() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MallContainerModel(MallRootParams params2) {
        this();
        Intrinsics.checkNotNullParameter(params2, "params");
        this.params = params2;
    }

    public String toJsonString() {
        return paramsToJson();
    }

    public boolean load(String json) {
        MallRootParams generateParamsFromJson = generateParamsFromJson(json == null ? "" : json);
        this.params = generateParamsFromJson;
        return generateParamsFromJson != null;
    }

    private final MallRootParams generateParamsFromJson(String json) {
        try {
            return (MallRootParams) getGon().fromJson(json, MallRootParams.class);
        } catch (Exception e2) {
            if (MallContainerModelKt.DEBUG) {
                e2.printStackTrace();
            }
            MallRootParams mallRootParams = null;
            return null;
        }
    }

    private final String paramsToJson() {
        try {
            MallRootParams it = this.params;
            if (it == null) {
                return "";
            }
            String json = getGon().toJson((Object) it);
            if (json == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(json, "getGon().toJson(it) ?: \"\"");
            return json;
        } catch (Exception e2) {
            if (!MallContainerModelKt.DEBUG) {
                return "";
            }
            e2.printStackTrace();
            return "";
        }
    }

    private final Gson getGon() {
        Gson create = new GsonBuilder().serializeNulls().registerTypeAdapter(SearchEntrance.class, new InterfaceAdapter()).create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder()\n          …archEntrance>()).create()");
        return create;
    }

    public Class<Container<ContainerModel>> getContainerClass() {
        return MallContainer.class;
    }
}
