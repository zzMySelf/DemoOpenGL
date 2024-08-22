package com.baidu.searchbox.video.feedflow.detail.dynamic;

import com.baidu.searchbox.feed.detail.arch.api.AbsComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.ComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/DynamicItemComponentRegister;", "Lcom/baidu/searchbox/feed/detail/arch/api/AbsComponentFactory;", "()V", "collectComponent", "", "collectPlugin", "Companion", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicItemComponentRegister.kt */
public final class DynamicItemComponentRegister extends AbsComponentFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<DynamicItemComponentRegister> factory$delegate = LazyKt.lazy(DynamicItemComponentRegister$Companion$factory$2.INSTANCE);

    public void collectComponent() {
        register("video_flow_cmp_mask", DynamicItemComponentRegister$collectComponent$1.INSTANCE);
        register("video_flow_cmp_author", DynamicItemComponentRegister$collectComponent$2.INSTANCE);
        register("video_flow_cmp_like", DynamicItemComponentRegister$collectComponent$3.INSTANCE);
        register("video_flow_cmp_comment", DynamicItemComponentRegister$collectComponent$4.INSTANCE);
        register("video_flow_cmp_favor", DynamicItemComponentRegister$collectComponent$5.INSTANCE);
        register("video_flow_cmp_share", DynamicItemComponentRegister$collectComponent$6.INSTANCE);
        register("video_flow_cmp_summary", DynamicItemComponentRegister$collectComponent$7.INSTANCE);
        register("flow_video_publish_info_time", DynamicItemComponentRegister$collectComponent$8.INSTANCE);
        register("video_flow_net_error", DynamicItemComponentRegister$collectComponent$9.INSTANCE);
        register("flow_video_offline", DynamicItemComponentRegister$collectComponent$10.INSTANCE);
        register("flow_video_default_combo_praise", DynamicItemComponentRegister$collectComponent$11.INSTANCE);
        register("flow_video_single_line_banner", DynamicItemComponentRegister$collectComponent$12.INSTANCE);
        register("flow_video_goods_big_banner", DynamicItemComponentRegister$collectComponent$13.INSTANCE);
        register("flow_video_preview_component", DynamicItemComponentRegister$collectComponent$14.INSTANCE);
        register("flow_video_one_to_n", DynamicItemComponentRegister$collectComponent$15.INSTANCE);
        register("flow_dynamic_item_carousel_pic_component", DynamicItemComponentRegister$collectComponent$16.INSTANCE);
        register("flow_dynamic_item_long_pic_btn_component", DynamicItemComponentRegister$collectComponent$17.INSTANCE);
        register("flow_dynamic_item_carousel_progress_bar_component", DynamicItemComponentRegister$collectComponent$18.INSTANCE);
        register("flow_dynamic_item_single_seek_bar_component", DynamicItemComponentRegister$collectComponent$19.INSTANCE);
        register("flow_video_play_btn_component", DynamicItemComponentRegister$collectComponent$20.INSTANCE);
        register("flow_video_second_jump_switch", DynamicItemComponentRegister$collectComponent$21.INSTANCE);
        register("flow_video_dynamic_bgm_title", DynamicItemComponentRegister$collectComponent$22.INSTANCE);
        register("flow_video_favor_bottom_toast_component", DynamicItemComponentRegister$collectComponent$23.INSTANCE);
        register("flow_video_recommend_next_content_component", DynamicItemComponentRegister$collectComponent$24.INSTANCE);
        register("flow_video_bottom_banner_place_holder", DynamicItemComponentRegister$collectComponent$25.INSTANCE);
        register("flow_video_bottom_banner", DynamicItemComponentRegister$collectComponent$26.INSTANCE);
    }

    public void collectPlugin() {
        register(DynamicItemComponentRegister$collectPlugin$1.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$2.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$3.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$4.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$5.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$6.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$7.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$8.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$9.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$10.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$11.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$12.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$13.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$14.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$15.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$16.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$17.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$18.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$19.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$20.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$21.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$22.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$23.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$24.INSTANCE);
        register(DynamicItemComponentRegister$collectPlugin$25.INSTANCE);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/DynamicItemComponentRegister$Companion;", "", "()V", "factory", "Lcom/baidu/searchbox/video/feedflow/detail/dynamic/DynamicItemComponentRegister;", "getFactory", "()Lcom/baidu/searchbox/video/feedflow/detail/dynamic/DynamicItemComponentRegister;", "factory$delegate", "Lkotlin/Lazy;", "getComponentFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/ComponentFactory;", "getPlugins", "", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicItemComponentRegister.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final DynamicItemComponentRegister getFactory() {
            return (DynamicItemComponentRegister) DynamicItemComponentRegister.factory$delegate.getValue();
        }

        public final ComponentFactory getComponentFactory() {
            return getFactory().getComponentFactory();
        }

        public final List<IPlugin> getPlugins() {
            return getFactory().getPlugins();
        }
    }
}
