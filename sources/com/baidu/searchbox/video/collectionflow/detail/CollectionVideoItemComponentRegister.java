package com.baidu.searchbox.video.collectionflow.detail;

import com.baidu.searchbox.feed.detail.arch.SlotComponentUnit;
import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.api.AbsComponentFactory;
import com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.provider.CollectionVideoItemUnitProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/detail/CollectionVideoItemComponentRegister;", "Lcom/baidu/searchbox/feed/detail/arch/api/AbsComponentFactory;", "provider", "Lcom/baidu/searchbox/video/feedflow/provider/CollectionVideoItemUnitProvider;", "(Lcom/baidu/searchbox/video/feedflow/provider/CollectionVideoItemUnitProvider;)V", "getProvider", "()Lcom/baidu/searchbox/video/feedflow/provider/CollectionVideoItemUnitProvider;", "collectComponent", "", "collectPlugin", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionVideoItemComponentRegister.kt */
public final class CollectionVideoItemComponentRegister extends AbsComponentFactory {
    private final CollectionVideoItemUnitProvider provider;

    public CollectionVideoItemComponentRegister(CollectionVideoItemUnitProvider provider2) {
        Intrinsics.checkNotNullParameter(provider2, "provider");
        this.provider = provider2;
        collect();
    }

    public final CollectionVideoItemUnitProvider getProvider() {
        return this.provider;
    }

    public void collectComponent() {
        register("video_flow_cmp_player", new CollectionVideoItemComponentRegister$collectComponent$1$1(this.provider.getPlayerUnit()));
        register("video_flow_cmp_poster", CollectionVideoItemComponentRegister$collectComponent$2.INSTANCE);
        register("video_flow_cmp_mask", CollectionVideoItemComponentRegister$collectComponent$3.INSTANCE);
        register("video_flow_cmp_reward_bubble", CollectionVideoItemComponentRegister$collectComponent$4.INSTANCE);
        register("video_flow_cmp_author", CollectionVideoItemComponentRegister$collectComponent$5.INSTANCE);
        register("video_flow_cmp_like", CollectionVideoItemComponentRegister$collectComponent$6.INSTANCE);
        register("video_flow_cmp_comment", CollectionVideoItemComponentRegister$collectComponent$7.INSTANCE);
        register("video_flow_cmp_favor", CollectionVideoItemComponentRegister$collectComponent$8.INSTANCE);
        register("video_flow_cmp_share", CollectionVideoItemComponentRegister$collectComponent$9.INSTANCE);
        register("video_flow_cmp_summary", CollectionVideoItemComponentRegister$collectComponent$10.INSTANCE);
        register("flow_barrage_input_bar", CollectionVideoItemComponentRegister$collectComponent$11.INSTANCE);
        register("video_flow_cmp_seekbar", CollectionVideoItemComponentRegister$collectComponent$12.INSTANCE);
        register("video_flow_gesture", new CollectionVideoItemComponentRegister$collectComponent$13$1(this.provider.getGestureUnit().createComponent()));
        register("flow_video_long_press_speed", CollectionVideoItemComponentRegister$collectComponent$14.INSTANCE);
        register("video_flow_net_error", CollectionVideoItemComponentRegister$collectComponent$15.INSTANCE);
        register("flow_video_offline", CollectionVideoItemComponentRegister$collectComponent$16.INSTANCE);
        register("flow_video_default_combo_praise", CollectionVideoItemComponentRegister$collectComponent$17.INSTANCE);
        register("flow_video_single_line_banner", CollectionVideoItemComponentRegister$collectComponent$18.INSTANCE);
        register("video_flow_full_play", CollectionVideoItemComponentRegister$collectComponent$19.INSTANCE);
        if (DIFactory.INSTANCE.getConfig().getShowPlayerSpeedOutSwitch()) {
            register("video_flow_player_speed_out", CollectionVideoItemComponentRegister$collectComponent$20.INSTANCE);
        }
        register("video_flow_cmp_top_title", CollectionVideoItemComponentRegister$collectComponent$21.INSTANCE);
        register("video_flow_cmp_top_image_title", CollectionVideoItemComponentRegister$collectComponent$22.INSTANCE);
        register("flow_video_one_to_n", CollectionVideoItemComponentRegister$collectComponent$23.INSTANCE);
        register("flow_video_goods_big_banner", CollectionVideoItemComponentRegister$collectComponent$24.INSTANCE);
        register("flow_service_explain_web_page_component", CollectionVideoItemComponentRegister$collectComponent$25.INSTANCE);
        register("flow_video_danger_hint", CollectionVideoItemComponentRegister$collectComponent$26.INSTANCE);
        register("flow_video_landscape_fold_view", CollectionVideoItemComponentRegister$collectComponent$27.INSTANCE);
        register("flow_video_collection_auto_next_guide_component", CollectionVideoItemComponentRegister$collectComponent$28.INSTANCE);
        register("flow_video_collection_back_guide_component", CollectionVideoItemComponentRegister$collectComponent$29.INSTANCE);
        register("flow_video_air_timer_count", CollectionVideoItemComponentRegister$collectComponent$30.INSTANCE);
        register("flow_video_exclusive_label", CollectionVideoItemComponentRegister$collectComponent$31.INSTANCE);
        register("flow_video_preview_component", CollectionVideoItemComponentRegister$collectComponent$32.INSTANCE);
        register("flow_video_bottom_banner", CollectionVideoItemComponentRegister$collectComponent$33.INSTANCE);
        register("flow_video_hot_comment", CollectionVideoItemComponentRegister$collectComponent$34.INSTANCE);
        register("video_flow_rumor", CollectionVideoItemComponentRegister$collectComponent$35.INSTANCE);
        register("flow_video_chatroom_entrance_component", CollectionVideoItemComponentRegister$collectComponent$36.INSTANCE);
        register("video_flow_cmp_barrage", CollectionVideoItemComponentRegister$collectComponent$37.INSTANCE);
        register("flow_video_comment_bubble_component", CollectionVideoItemComponentRegister$collectComponent$38.INSTANCE);
        register("flow_video_hot_vote_component", CollectionVideoItemComponentRegister$collectComponent$39.INSTANCE);
        register("flow_video_challenge", CollectionVideoItemComponentRegister$collectComponent$40.INSTANCE);
        register("video_flow_short_play_payment_guide_component", CollectionVideoItemComponentRegister$collectComponent$41.INSTANCE);
        SlotComponentUnit $this$collectComponent_u24lambda_u2d2 = this.provider.getVideoSummaryNewUnit();
        if ($this$collectComponent_u24lambda_u2d2 != null) {
            register("flow_video_item_summary_list_new_component", new CollectionVideoItemComponentRegister$collectComponent$42$1($this$collectComponent_u24lambda_u2d2));
        }
        SlotComponentUnit $this$collectComponent_u24lambda_u2d3 = this.provider.getOcrSummaryUnit();
        if ($this$collectComponent_u24lambda_u2d3 != null) {
            register("flow_video_content_summary", new CollectionVideoItemComponentRegister$collectComponent$43$1($this$collectComponent_u24lambda_u2d3));
        }
        SlotComponentUnit $this$collectComponent_u24lambda_u2d4 = this.provider.getOcrSummaryPanelUnit();
        if ($this$collectComponent_u24lambda_u2d4 != null) {
            register("flow_video_content_summary_panel", new CollectionVideoItemComponentRegister$collectComponent$44$1($this$collectComponent_u24lambda_u2d4));
        }
        register("flow_video_pk", CollectionVideoItemComponentRegister$collectComponent$45.INSTANCE);
        register("flow_video_celebrity_recognition", CollectionVideoItemComponentRegister$collectComponent$46.INSTANCE);
        register("flow_video_celebrity_recognition_big_card", CollectionVideoItemComponentRegister$collectComponent$47.INSTANCE);
        register("flow_video_short_play_auto_unlock_component", CollectionVideoItemComponentRegister$collectComponent$48.INSTANCE);
        register("flow_video_favor_bottom_toast_component", CollectionVideoItemComponentRegister$collectComponent$49.INSTANCE);
        register("flow_barrage_icon_entrance", CollectionVideoItemComponentRegister$collectComponent$50.INSTANCE);
    }

    public void collectPlugin() {
        register(CollectionVideoItemComponentRegister$collectPlugin$1.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$2.INSTANCE);
        register(new CollectionVideoItemComponentRegister$collectPlugin$3(this));
        register(CollectionVideoItemComponentRegister$collectPlugin$4.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$5.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$6.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$7.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$8.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$9.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$10.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$11.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$12.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$13.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$14.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$15.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$16.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$17.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$18.INSTANCE);
        register(new CollectionVideoItemComponentRegister$collectPlugin$19(this));
        register(CollectionVideoItemComponentRegister$collectPlugin$20.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$21.INSTANCE);
        register(new CollectionVideoItemComponentRegister$collectPlugin$22(this));
        register(CollectionVideoItemComponentRegister$collectPlugin$23.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$24.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$25.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$26.INSTANCE);
        register(new CollectionVideoItemComponentRegister$collectPlugin$27(this));
        register(new CollectionVideoItemComponentRegister$collectPlugin$28(this));
        register(new CollectionVideoItemComponentRegister$collectPlugin$29(this));
        register(CollectionVideoItemComponentRegister$collectPlugin$30.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$31.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$32.INSTANCE);
        SlotUnit $this$collectPlugin_u24lambda_u2d5 = this.provider.getSearchFirstJumpRecUnit();
        if ($this$collectPlugin_u24lambda_u2d5 != null) {
            register(new CollectionVideoItemComponentRegister$collectPlugin$33$1($this$collectPlugin_u24lambda_u2d5));
        }
        register(CollectionVideoItemComponentRegister$collectPlugin$34.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$35.INSTANCE);
        SlotUnit $this$collectPlugin_u24lambda_u2d6 = this.provider.getOcrSummaryPanelDurationUnit();
        if ($this$collectPlugin_u24lambda_u2d6 != null) {
            register(new CollectionVideoItemComponentRegister$collectPlugin$36$1($this$collectPlugin_u24lambda_u2d6));
        }
        register(CollectionVideoItemComponentRegister$collectPlugin$37.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$38.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$39.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$40.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$41.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$42.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$43.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$44.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$45.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$46.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$47.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$48.INSTANCE);
        register(CollectionVideoItemComponentRegister$collectPlugin$49.INSTANCE);
        if (AdReduxExpManager.INSTANCE.getFlowAdCollInsertAdUpdateSwitch()) {
            register(CollectionVideoItemComponentRegister$collectPlugin$50.INSTANCE);
        }
    }
}
