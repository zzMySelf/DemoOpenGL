package com.baidu.searchbox.combinepublisher;

import com.baidu.searchbox.feed.detail.arch.api.AbsComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.ComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/combinepublisher/CombinedPublishComponentRegister;", "Lcom/baidu/searchbox/feed/detail/arch/api/AbsComponentFactory;", "()V", "collectComponent", "", "collectPlugin", "Companion", "lib-publisher-dynamic_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CombinedPublishComponentRegister.kt */
public final class CombinedPublishComponentRegister extends AbsComponentFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<CombinedPublishComponentRegister> factory$delegate = LazyKt.lazy(CombinedPublishComponentRegister$Companion$factory$2.INSTANCE);

    public void collectComponent() {
        register("combine_publisher_bottom_bar_cmp", CombinedPublishComponentRegister$collectComponent$1.INSTANCE);
    }

    public void collectPlugin() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/combinepublisher/CombinedPublishComponentRegister$Companion;", "", "()V", "factory", "Lcom/baidu/searchbox/combinepublisher/CombinedPublishComponentRegister;", "getFactory", "()Lcom/baidu/searchbox/combinepublisher/CombinedPublishComponentRegister;", "factory$delegate", "Lkotlin/Lazy;", "getComponentFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/ComponentFactory;", "getPlugins", "", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "lib-publisher-dynamic_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CombinedPublishComponentRegister.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final CombinedPublishComponentRegister getFactory() {
            return (CombinedPublishComponentRegister) CombinedPublishComponentRegister.factory$delegate.getValue();
        }

        public final List<IPlugin> getPlugins() {
            return getFactory().getPlugins();
        }

        public final ComponentFactory getComponentFactory() {
            return getFactory().getComponentFactory();
        }
    }
}
