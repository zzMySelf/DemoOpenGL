package com.baidu.searchbox.kankan.detail.video.layer;

import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.kankan.detail.R;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.BasePlayerLayer;
import com.baidu.searchbox.player.ubc.IPosterLayerUbcDispatcher;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

public class LandPosterLayer extends BasePlayerLayer {
    private SimpleDraweeView mPoster;
    private FrameLayout mPosterContainer = new FrameLayout(this.mContext);
    private View mShaderView;

    public LandPosterLayer() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.community_layer_poster_layout, this.mPosterContainer);
        this.mPosterContainer = frameLayout;
        this.mPoster = (SimpleDraweeView) frameLayout.findViewById(R.id.image_poster);
        this.mShaderView = this.mPosterContainer.findViewById(R.id.image_shader_top);
    }

    public View getContentView() {
        return this.mPosterContainer;
    }

    private void loadPoster() {
        BdVideoLog.d("posterLayer load poster");
        String posterUrl = "";
        BdVideoSeries series = getBindPlayer().getVideoSeries();
        if (series != null) {
            posterUrl = series.getPoster();
        }
        InvokerUtils.getPrefetchBitmap(posterUrl, this.mPoster, new InvokerUtils.GetPrefetchBitmapListener() {
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                BdVideoLog.d("posterLayer load poster success.");
                if (LandPosterLayer.this.getStatDispatcher() != null) {
                    LandPosterLayer.this.getStatDispatcher().onPosterLoad(0);
                }
            }

            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
                if (LandPosterLayer.this.getStatDispatcher() != null) {
                    LandPosterLayer.this.getStatDispatcher().onPosterLoad(2);
                }
            }
        });
        if (getStatDispatcher() != null) {
            getStatDispatcher().onPosterLoad(1);
        }
    }

    private void showPoster() {
        BdVideoLog.d("posterLayer show poster");
        this.mShaderView.setVisibility(0);
        this.mPoster.setVisibility(0);
    }

    public void onPlayerEventNotify(VideoEvent event) {
        if ("player_event_on_info".equals(event.getAction())) {
            if (((Integer) event.getExtra(1)).intValue() == 904) {
                hidePoster();
            }
        } else if ("player_event_set_data".equals(event.getAction()) || "player_event_attach".equals(event.getAction())) {
            loadPoster();
        } else if ("player_event_detach".equals(event.getAction())) {
            this.mPoster.setImageURI("");
        }
    }

    /* access modifiers changed from: private */
    public IPosterLayerUbcDispatcher getStatDispatcher() {
        BDVideoPlayer player = getBindPlayer();
        if (player.getStatDispatcher() instanceof IPosterLayerUbcDispatcher) {
            return (IPosterLayerUbcDispatcher) player.getStatDispatcher();
        }
        return null;
    }

    private void hidePoster() {
        this.mShaderView.setVisibility(8);
        this.mPoster.setVisibility(8);
    }

    public void onLayerEventNotify(VideoEvent event) {
        if ("layer_event_show_poster".equals(event.getAction())) {
            showPoster();
        } else if ("layer_event_hide_poster".equals(event.getAction())) {
            hidePoster();
        }
    }

    public void onControlEventNotify(VideoEvent event) {
        if ("control_event_start".equals(event.getAction())) {
            showPoster();
        }
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        super.onPlayerStatusChanged(status, old);
        if (status == PlayerStatus.PLAYING) {
            hidePoster();
        }
    }

    public void sendEvent(VideoEvent event) {
        super.sendEvent(event);
    }

    public int[] getSubscribeEvent() {
        return new int[]{4, 2, 5, 3};
    }
}
