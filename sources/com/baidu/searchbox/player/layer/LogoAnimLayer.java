package com.baidu.searchbox.player.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.ubc.ILogoAnimLayerUbcDispatcher;
import com.baidu.searchbox.video.plugin.videoplayer.logo.VideoAnimLogoHelper;
import com.baidu.searchbox.video.plugin.videoplayer.logo.VideoLogoApkDownloader;
import com.baidu.searchbox.videoplayer.ui.R;

public class LogoAnimLayer extends BasePlayerLayer {
    public String mAnimLogoDownloadScheme;
    private boolean mAnimLogoEnable;
    public String mAnimLogoJumpScheme;
    private float mAnimLogoProgress = 0.0f;
    private FrameLayout mContainer;
    public String mDownloadToast;
    private boolean mIsADShow = false;
    private boolean mIsPanelShow = false;
    private VideoAnimLogoHelper mVideoAnimLogoHelper;

    public void initLayer() {
        super.initLayer();
        this.mContainer = new FrameLayout(this.mContext);
    }

    public View getContentView() {
        return this.mContainer;
    }

    public void onControlEventNotify(VideoEvent event) {
        if ("control_event_sync_progress".equals(event.getAction())) {
            int position = event.getIntExtra(1);
            int duration = event.getIntExtra(2);
            if (this.mAnimLogoEnable && this.mVideoAnimLogoHelper == null && this.mIsPanelShow && !this.mIsADShow && VideoAnimLogoHelper.showAble(position, duration)) {
                addAnimLogo();
            }
        }
    }

    private void addAnimLogo() {
        if (this.mVideoAnimLogoHelper == null) {
            this.mAnimLogoEnable = false;
            VideoAnimLogoHelper videoAnimLogoHelper = new VideoAnimLogoHelper();
            this.mVideoAnimLogoHelper = videoAnimLogoHelper;
            videoAnimLogoHelper.addLogoAnim(this.mContainer, false, new OnCompositionLoadedListener() {
                public void onCompositionLoaded(LottieComposition composition) {
                    LogoAnimLayer.this.onAnimLogoLoaded();
                }
            }, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    LogoAnimLayer.this.removeAnimLogo();
                }
            }, new View.OnClickListener() {
                public void onClick(View v) {
                    LogoAnimLayer.this.onAnimLogoClick();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onAnimLogoLoaded() {
        VideoAnimLogoHelper videoAnimLogoHelper = this.mVideoAnimLogoHelper;
        if (videoAnimLogoHelper != null) {
            videoAnimLogoHelper.play(this.mAnimLogoProgress);
        }
        if (getStatDispatcher() != null) {
            getStatDispatcher().onAnimLogoShowUBC();
        }
    }

    /* access modifiers changed from: private */
    public void removeAnimLogo() {
        if (this.mVideoAnimLogoHelper != null) {
            VideoAnimLogoHelper valHelp = this.mVideoAnimLogoHelper;
            this.mVideoAnimLogoHelper = null;
            if (valHelp != null) {
                valHelp.removeAnimLogo();
            }
        }
    }

    /* access modifiers changed from: private */
    public void onAnimLogoClick() {
        Activity act;
        if (getStatDispatcher() != null) {
            getStatDispatcher().onAnimLogoClickUBC();
        }
        try {
            Intent schemeIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.mAnimLogoJumpScheme));
            schemeIntent.setFlags(268435456);
            this.mContext.startActivity(schemeIntent);
        } catch (Exception e2) {
            if (!TextUtils.isEmpty(this.mAnimLogoDownloadScheme) && (act = getBindPlayer().getActivity()) != null) {
                VideoLogoApkDownloader.download(act, this.mAnimLogoDownloadScheme);
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) this.mContext.getString(R.string.videoplayer_loading_app)).setDuration(3).showToast();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r5) {
        /*
            r4 = this;
            super.onLayerEventNotify(r5)
            java.lang.String r0 = r5.getAction()
            int r1 = r0.hashCode()
            r2 = 0
            r3 = 1
            switch(r1) {
                case -1638530599: goto L_0x0025;
                case -1496842788: goto L_0x001b;
                case 88214150: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x002f
        L_0x0011:
            java.lang.String r1 = "layer_event_ad_show"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r3
            goto L_0x0030
        L_0x001b:
            java.lang.String r1 = "layer_event_ad_finish"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = 2
            goto L_0x0030
        L_0x0025:
            java.lang.String r1 = "layer_event_panel_visible_changed"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0010
            r0 = r2
            goto L_0x0030
        L_0x002f:
            r0 = -1
        L_0x0030:
            switch(r0) {
                case 0: goto L_0x003a;
                case 1: goto L_0x0037;
                case 2: goto L_0x0034;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x0047
        L_0x0034:
            r4.mIsADShow = r2
            goto L_0x0047
        L_0x0037:
            r4.mIsADShow = r3
            goto L_0x0047
        L_0x003a:
            r0 = 9
            boolean r0 = r5.getBooleanExtra(r0)
            r4.mIsPanelShow = r0
            r0 = r0 ^ r3
            r4.setAnimLogVisible(r0)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.layer.LogoAnimLayer.onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    private void setAnimLogVisible(boolean visible) {
        if (this.mVideoAnimLogoHelper != null && this.mContainer.getVisibility() == 0) {
            this.mVideoAnimLogoHelper.setAnimLogoVisibility(!visible);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPlayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r3) {
        /*
            r2 = this;
            super.onPlayerEventNotify(r3)
            java.lang.String r0 = r3.getAction()
            int r1 = r0.hashCode()
            switch(r1) {
                case -882902390: goto L_0x0025;
                case -461848373: goto L_0x001a;
                case 154871702: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0030
        L_0x000f:
            java.lang.String r1 = "player_event_on_complete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = 1
            goto L_0x0031
        L_0x001a:
            java.lang.String r1 = "player_event_on_error"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = 0
            goto L_0x0031
        L_0x0025:
            java.lang.String r1 = "player_event_set_data"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = 2
            goto L_0x0031
        L_0x0030:
            r0 = -1
        L_0x0031:
            switch(r0) {
                case 0: goto L_0x0058;
                case 1: goto L_0x0058;
                case 2: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x005c
        L_0x0035:
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r2.getBindPlayer()
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r0 = r0.getVideoSeries()
            if (r0 == 0) goto L_0x005c
            boolean r1 = r0.ismAnimLogoEnable()
            r2.mAnimLogoEnable = r1
            java.lang.String r1 = r0.getAnimLogoJumpScheme()
            r2.mAnimLogoJumpScheme = r1
            java.lang.String r1 = r0.getAnimLogoDownloadScheme()
            r2.mAnimLogoDownloadScheme = r1
            java.lang.String r1 = r0.getAnimLogoDownloadToast()
            r2.mDownloadToast = r1
            goto L_0x005c
        L_0x0058:
            r2.removeAnimLogo()
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.layer.LogoAnimLayer.onPlayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public int[] getSubscribeEvent() {
        return new int[]{2, 3, 4};
    }

    private ILogoAnimLayerUbcDispatcher getStatDispatcher() {
        if (getBindPlayer().getStatDispatcher() instanceof ILogoAnimLayerUbcDispatcher) {
            return (ILogoAnimLayerUbcDispatcher) getBindPlayer().getStatDispatcher();
        }
        return null;
    }
}
