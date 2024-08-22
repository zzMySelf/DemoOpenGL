package com.baidu.searchbox.player.plugin;

import android.text.SpannableStringBuilder;
import android.view.View;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.event.VulcanGuideEvent;
import com.baidu.searchbox.player.event.VulcanMenuEvent;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.model.TipsConfig;
import com.baidu.searchbox.player.p001const.MenuTipType;
import com.baidu.searchbox.videoplayer.vulcan.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/player/plugin/VulcanPlayerMirrorPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "isMirrorState", "", "attachManager", "", "manager", "Lcom/baidu/searchbox/player/plugin/PluginManager;", "getBindPlayer", "Lcom/baidu/searchbox/player/BaseVulcanVideoPlayer;", "getSubscribeEvent", "", "onLayerEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "setPlayerMirrorStatus", "updateMenuMirrorStatus", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanPlayerMirrorPlugin.kt */
public final class VulcanPlayerMirrorPlugin extends AbsPlugin {
    private boolean isMirrorState;

    public int[] getSubscribeEvent() {
        return new int[]{3};
    }

    public void onLayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual((Object) event.getAction(), (Object) VulcanMenuEvent.ACTION_LAND_MENU_MIRROR_CLICK)) {
            this.isMirrorState = !this.isMirrorState;
            setPlayerMirrorStatus();
        } else if (Intrinsics.areEqual((Object) event.getAction(), (Object) VulcanMenuEvent.ACTION_SHOW_MORE_PANEL)) {
            updateMenuMirrorStatus();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r0.getPlayerKernelLayer();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachManager(com.baidu.searchbox.player.plugin.PluginManager r3) {
        /*
            r2 = this;
            java.lang.String r0 = "manager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            super.attachManager(r3)
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r0 = r2.getBindPlayer()
            if (r0 == 0) goto L_0x001a
            com.baidu.searchbox.player.layer.BaseKernelLayer r0 = r0.getPlayerKernelLayer()
            if (r0 == 0) goto L_0x001a
            android.view.View r0 = r0.getContentView()
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            if (r0 != 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            r1 = 0
            r0.setRotationY(r1)
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.plugin.VulcanPlayerMirrorPlugin.attachManager(com.baidu.searchbox.player.plugin.PluginManager):void");
    }

    private final void setPlayerMirrorStatus() {
        String tipContent;
        BaseKernelLayer playerKernelLayer;
        BaseKernelLayer playerKernelLayer2;
        View view2 = null;
        if (this.isMirrorState) {
            BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
            if (!(bindPlayer == null || (playerKernelLayer2 = bindPlayer.getPlayerKernelLayer()) == null)) {
                view2 = playerKernelLayer2.getContentView();
            }
            if (view2 != null) {
                view2.setRotationY(180.0f);
            }
            String string = getContext().getString(R.string.videoplayer_vulcan_mirror_open_tip);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…r_vulcan_mirror_open_tip)");
            tipContent = string;
        } else {
            BaseVulcanVideoPlayer bindPlayer2 = getBindPlayer();
            if (!(bindPlayer2 == null || (playerKernelLayer = bindPlayer2.getPlayerKernelLayer()) == null)) {
                view2 = playerKernelLayer.getContentView();
            }
            if (view2 != null) {
                view2.setRotationY(0.0f);
            }
            String string2 = getContext().getString(R.string.videoplayer_vulcan_mirror_close_tip);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…_vulcan_mirror_close_tip)");
            tipContent = string2;
        }
        VideoEvent event = LayerEvent.obtainEvent(VulcanGuideEvent.ACTION_GUIDE_LEFT_BOTTOM_TIPS_SHOW);
        Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(VulcanGuideE…DE_LEFT_BOTTOM_TIPS_SHOW)");
        event.putExtra(1, TipsConfig.Companion.obtainCommonTipConfig$default(TipsConfig.Companion, VulcanPlayerMirrorPlugin.class.getSimpleName(), new SpannableStringBuilder(tipContent), 0, 0, 0, false, 60, (Object) null));
        sendEvent(event);
    }

    private final void updateMenuMirrorStatus() {
        VideoEvent event = LayerEvent.obtainEvent(VulcanMenuEvent.ACTION_MIRROR_STATUS_CHANGED);
        Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(VulcanMenuEv…ON_MIRROR_STATUS_CHANGED)");
        event.putExtra(5, Boolean.valueOf(this.isMirrorState));
        event.putExtra(6, true);
        event.putExtra(3, MenuTipType.NoTip.INSTANCE);
        sendEvent(event);
    }

    public BaseVulcanVideoPlayer getBindPlayer() {
        BDVideoPlayer bindPlayer = super.getBindPlayer();
        if (bindPlayer instanceof BaseVulcanVideoPlayer) {
            return (BaseVulcanVideoPlayer) bindPlayer;
        }
        return null;
    }
}
