package com.baidu.searchbox.video.feedflow.tab.hot.hotEmpty;

import android.view.MotionEvent;
import com.baidu.searchbox.video.feedflow.flow.empty.IFlowEmptyService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/hot/hotEmpty/HotTabEmptyServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/flow/empty/IFlowEmptyService;", "component", "Lcom/baidu/searchbox/video/feedflow/tab/hot/hotEmpty/HotTabEmptyComponent;", "(Lcom/baidu/searchbox/video/feedflow/tab/hot/hotEmpty/HotTabEmptyComponent;)V", "click", "", "consumeEvent", "", "event", "Landroid/view/MotionEvent;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotTabEmptyServiceImpl.kt */
public final class HotTabEmptyServiceImpl implements IFlowEmptyService {
    private final HotTabEmptyComponent component;

    public HotTabEmptyServiceImpl(HotTabEmptyComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public boolean consumeEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.component.consumeEvent(event);
    }

    public void click() {
        this.component.click();
    }
}
