package com.baidu.bdtask.model;

import com.baidu.bdtask.model.rule.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\t0\u0006\"\b\b\u0000\u0010\t*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/bdtask/model/TaskModelCreatorFactory;", "", "()V", "taskModelCreatorMap", "", "", "Lcom/baidu/bdtask/model/ITaskModelCreator;", "Lcom/baidu/bdtask/model/ITaskModelData;", "createModelCreator", "T", "key", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, a<? extends ITaskModelData>> f10949a = new HashMap();

    public b() {
        a aVar = new a(this);
        this.f10949a.put(aVar.a(), aVar);
        com.baidu.bdtask.model.guide.a aVar2 = new com.baidu.bdtask.model.guide.a(this);
        this.f10949a.put(aVar2.a(), aVar2);
        com.baidu.bdtask.model.ui.a aVar3 = new com.baidu.bdtask.model.ui.a(this);
        this.f10949a.put(aVar3.a(), aVar3);
        com.baidu.bdtask.model.meter.a aVar4 = new com.baidu.bdtask.model.meter.a(this);
        this.f10949a.put(aVar4.a(), aVar4);
        com.baidu.bdtask.model.info.a aVar5 = new com.baidu.bdtask.model.info.a(this);
        this.f10949a.put(aVar5.a(), aVar5);
        com.baidu.bdtask.model.response.a aVar6 = new com.baidu.bdtask.model.response.a(this);
        this.f10949a.put(aVar6.a(), aVar6);
        com.baidu.bdtask.model.b.a aVar7 = new com.baidu.bdtask.model.b.a(this);
        this.f10949a.put(aVar7.a(), aVar7);
        com.baidu.bdtask.model.a.a aVar8 = new com.baidu.bdtask.model.a.a(this);
        this.f10949a.put(aVar8.a(), aVar8);
    }

    public final <T extends ITaskModelData> a<? extends T> a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        if (this.f10949a.get(str) != null) {
            a<? extends ITaskModelData> aVar = this.f10949a.get(str);
            if (aVar != null) {
                return aVar;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
        }
        throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
    }
}
