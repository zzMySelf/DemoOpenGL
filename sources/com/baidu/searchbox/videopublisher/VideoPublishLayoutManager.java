package com.baidu.searchbox.videopublisher;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.api.AbsLayoutManager;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.videopublisher.night.NightModeState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020-H\u0016J\u0018\u00105\u001a\u00020-2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020-H\u0002R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\r8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0012\u0010\tR#\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0015\u0010\tR#\u0010\u0017\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\tR#\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001b\u0010\tR#\u0010\u001d\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001e\u0010\tR#\u0010 \u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b!\u0010\tR#\u0010#\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b$\u0010\tR#\u0010&\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b'\u0010\tR#\u0010)\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b*\u0010\t¨\u0006;"}, d2 = {"Lcom/baidu/searchbox/videopublisher/VideoPublishLayoutManager;", "Lcom/baidu/searchbox/feed/detail/arch/api/AbsLayoutManager;", "Landroid/view/ViewGroup;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "campaignContainer", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getCampaignContainer", "()Landroid/widget/FrameLayout;", "campaignContainer$delegate", "Lkotlin/Lazy;", "campaignTopicContainer", "Landroid/widget/LinearLayout;", "getCampaignTopicContainer", "()Landroid/widget/LinearLayout;", "campaignTopicContainer$delegate", "groupContainer", "getGroupContainer", "groupContainer$delegate", "locationContainer", "getLocationContainer", "locationContainer$delegate", "mountContainer", "getMountContainer", "mountContainer$delegate", "rightsContainer", "getRightsContainer", "rightsContainer$delegate", "saveVideoContainer", "getSaveVideoContainer", "saveVideoContainer$delegate", "titleContainer", "getTitleContainer", "titleContainer$delegate", "topbarContainer", "getTopbarContainer", "topbarContainer$delegate", "topicContainer", "getTopicContainer", "topicContainer$delegate", "videoContainer", "getVideoContainer", "videoContainer$delegate", "addView", "", "view", "Landroid/view/View;", "type", "", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "inflate", "initManager", "componentManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "context", "Landroid/content/Context;", "updateUI", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPublishLayoutManager.kt */
public final class VideoPublishLayoutManager extends AbsLayoutManager<ViewGroup> implements LifecycleOwner {
    private final Lazy campaignContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$campaignContainer$2(this));
    private final Lazy campaignTopicContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$campaignTopicContainer$2(this));
    private final Lazy groupContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$groupContainer$2(this));
    private final Lazy locationContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$locationContainer$2(this));
    private final Lazy mountContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$mountContainer$2(this));
    private final Lazy rightsContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$rightsContainer$2(this));
    private final Lazy saveVideoContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$saveVideoContainer$2(this));
    private final Lazy titleContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$titleContainer$2(this));
    private final Lazy topbarContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$topbarContainer$2(this));
    private final Lazy topicContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$topicContainer$2(this));
    private final Lazy videoContainer$delegate = LazyKt.lazy(new VideoPublishLayoutManager$videoContainer$2(this));

    private final FrameLayout getTopbarContainer() {
        return (FrameLayout) this.topbarContainer$delegate.getValue();
    }

    private final FrameLayout getVideoContainer() {
        return (FrameLayout) this.videoContainer$delegate.getValue();
    }

    private final FrameLayout getTitleContainer() {
        return (FrameLayout) this.titleContainer$delegate.getValue();
    }

    private final FrameLayout getTopicContainer() {
        return (FrameLayout) this.topicContainer$delegate.getValue();
    }

    private final FrameLayout getMountContainer() {
        return (FrameLayout) this.mountContainer$delegate.getValue();
    }

    private final FrameLayout getLocationContainer() {
        return (FrameLayout) this.locationContainer$delegate.getValue();
    }

    private final FrameLayout getRightsContainer() {
        return (FrameLayout) this.rightsContainer$delegate.getValue();
    }

    private final FrameLayout getGroupContainer() {
        return (FrameLayout) this.groupContainer$delegate.getValue();
    }

    private final FrameLayout getCampaignContainer() {
        return (FrameLayout) this.campaignContainer$delegate.getValue();
    }

    public final LinearLayout getCampaignTopicContainer() {
        return (LinearLayout) this.campaignTopicContainer$delegate.getValue();
    }

    private final FrameLayout getSaveVideoContainer() {
        return (FrameLayout) this.saveVideoContainer$delegate.getValue();
    }

    public void initManager(ComponentArchManager componentManager, Context context) {
        NightModeState $this$initManager_u24lambda_u2d1;
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
        Intrinsics.checkNotNullParameter(context, "context");
        super.initManager(componentManager, context);
        View inflate = View.inflate(context, R.layout.video_publisher_root_layout, (ViewGroup) null);
        if (inflate != null) {
            setContainer((ViewGroup) inflate);
            updateUI();
            Store store = componentManager.getStore();
            if (!(store == null || ($this$initManager_u24lambda_u2d1 = (NightModeState) store.subscribe(NightModeState.class)) == null)) {
                $this$initManager_u24lambda_u2d1.isNightMode().observe(this, new VideoPublishLayoutManager$$ExternalSyntheticLambda0(this));
            }
            getManager().registerServices(VideoILayoutManagerService.class, new VideoPublisherLayoutManagerService(this));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* access modifiers changed from: private */
    /* renamed from: initManager$lambda-1$lambda-0  reason: not valid java name */
    public static final void m7221initManager$lambda1$lambda0(VideoPublishLayoutManager this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateUI();
    }

    private final void updateUI() {
        ViewGroup $this$updateUI_u24lambda_u2d2 = getContainer();
        $this$updateUI_u24lambda_u2d2.setBackgroundColor(ContextCompat.getColor($this$updateUI_u24lambda_u2d2.getContext(), R.color.GC9));
    }

    public void addView(View view2, int type) {
        Intrinsics.checkNotNullParameter(view2, "view");
        if (type == R.id.video_publisher_topbar_cmp_id) {
            getTopbarContainer().addView(view2);
        } else if (type == R.id.video_publisher_video_cmp_id) {
            getVideoContainer().addView(view2);
        } else if (type == R.id.video_publisher_title_cmp_id) {
            getTitleContainer().addView(view2);
        } else if (type == R.id.video_publisher_topic_cmp_id) {
            getTopicContainer().addView(view2);
        } else if (type == R.id.video_publisher_mount_cmp_id) {
            getMountContainer().addView(view2);
        } else if (type == R.id.video_publisher_location_cmp_id) {
            getLocationContainer().addView(view2);
        } else if (type == R.id.video_publisher_rights_cmp_id) {
            getRightsContainer().addView(view2);
        } else if (type == R.id.video_publisher_group_cmp_id) {
            getGroupContainer().addView(view2);
        } else if (type == R.id.video_publisher_campaign_cmp_id) {
            getCampaignContainer().addView(view2);
        } else if (type == R.id.video_publisher_save_video_cmp_id) {
            getSaveVideoContainer().addView(view2);
        }
    }

    public void inflate() {
        inflateComponentView("video_publisher_topbar_cmp", R.id.video_publisher_topbar_cmp_id);
        inflateComponentView("video_publisher_video_cmp", R.id.video_publisher_video_cmp_id);
        inflateComponentView("video_publisher_title_cmp", R.id.video_publisher_title_cmp_id);
        inflateComponentView("video_publisher_topic_cmp", R.id.video_publisher_topic_cmp_id);
        inflateComponentView("video_publisher_mount_cmp", R.id.video_publisher_mount_cmp_id);
        inflateComponentView("video_publisher_location_cmp", R.id.video_publisher_location_cmp_id);
        inflateComponentView("video_publisher_rights_cmp", R.id.video_publisher_rights_cmp_id);
        inflateComponentView("video_publisher_group_cmp", R.id.video_publisher_group_cmp_id);
        inflateComponentView("video_publisher_group_tip_cmp", R.id.video_publisher_group_tip_cmp_id);
        inflateComponentView("dynamic_publisher_campaign_cmp", R.id.video_publisher_campaign_cmp_id);
        inflateComponentView("video_publisher_save_video_cmp", R.id.video_publisher_save_video_cmp_id);
    }

    public Lifecycle getLifecycle() {
        return getManager().getLifecycle();
    }
}
