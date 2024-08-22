package com.baidu.searchbox.video.feedflow.detail.base;

import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/base/BaseItemComponentServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/detail/base/IBaseItemComponentService;", "baseItemComponent", "Lcom/baidu/searchbox/video/feedflow/detail/base/BaseItemComponent;", "(Lcom/baidu/searchbox/video/feedflow/detail/base/BaseItemComponent;)V", "getBaseItemComponent", "()Lcom/baidu/searchbox/video/feedflow/detail/base/BaseItemComponent;", "getBindModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseItemComponentServiceImpl.kt */
public final class BaseItemComponentServiceImpl implements IBaseItemComponentService {
    private final BaseItemComponent<?> baseItemComponent;

    public BaseItemComponentServiceImpl(BaseItemComponent<?> baseItemComponent2) {
        Intrinsics.checkNotNullParameter(baseItemComponent2, "baseItemComponent");
        this.baseItemComponent = baseItemComponent2;
    }

    public final BaseItemComponent<?> getBaseItemComponent() {
        return this.baseItemComponent;
    }

    public ItemModel<?> getBindModel() {
        return this.baseItemComponent.getBindModel();
    }
}
