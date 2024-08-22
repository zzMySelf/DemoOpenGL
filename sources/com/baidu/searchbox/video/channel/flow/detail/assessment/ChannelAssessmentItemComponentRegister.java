package com.baidu.searchbox.video.channel.flow.detail.assessment;

import com.baidu.searchbox.feed.detail.arch.api.AbsComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.ComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/detail/assessment/ChannelAssessmentItemComponentRegister;", "Lcom/baidu/searchbox/feed/detail/arch/api/AbsComponentFactory;", "()V", "collectComponent", "", "collectPlugin", "Companion", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelAssessmentItemComponentRegister.kt */
public final class ChannelAssessmentItemComponentRegister extends AbsComponentFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<ChannelAssessmentItemComponentRegister> factory$delegate = LazyKt.lazy(ChannelAssessmentItemComponentRegister$Companion$factory$2.INSTANCE);

    public void collectComponent() {
        register("flow_assessment_cmp_poster", ChannelAssessmentItemComponentRegister$collectComponent$1.INSTANCE);
        register("flow_assessment_cmp_center_card", ChannelAssessmentItemComponentRegister$collectComponent$2.INSTANCE);
    }

    public void collectPlugin() {
        register(ChannelAssessmentItemComponentRegister$collectPlugin$1.INSTANCE);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/detail/assessment/ChannelAssessmentItemComponentRegister$Companion;", "", "()V", "factory", "Lcom/baidu/searchbox/video/channel/flow/detail/assessment/ChannelAssessmentItemComponentRegister;", "getFactory", "()Lcom/baidu/searchbox/video/channel/flow/detail/assessment/ChannelAssessmentItemComponentRegister;", "factory$delegate", "Lkotlin/Lazy;", "getComponentFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/ComponentFactory;", "getPlugins", "", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChannelAssessmentItemComponentRegister.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final ChannelAssessmentItemComponentRegister getFactory() {
            return (ChannelAssessmentItemComponentRegister) ChannelAssessmentItemComponentRegister.factory$delegate.getValue();
        }

        public final ComponentFactory getComponentFactory() {
            return getFactory().getComponentFactory();
        }

        public final List<IPlugin> getPlugins() {
            return getFactory().getPlugins();
        }
    }
}
