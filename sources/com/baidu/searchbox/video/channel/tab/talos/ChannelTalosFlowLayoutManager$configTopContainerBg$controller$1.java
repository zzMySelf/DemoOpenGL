package com.baidu.searchbox.video.channel.tab.talos;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.searchbox.video.detail.utils.VideoImmersionUtils;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/video/channel/tab/talos/ChannelTalosFlowLayoutManager$configTopContainerBg$controller$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onFailure", "", "id", "", "throwable", "", "onFinalImageSet", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTalosFlowLayoutManager.kt */
public final class ChannelTalosFlowLayoutManager$configTopContainerBg$controller$1 extends BaseControllerListener<ImageInfo> {
    final /* synthetic */ ChannelTalosFlowLayoutManager this$0;

    ChannelTalosFlowLayoutManager$configTopContainerBg$controller$1(ChannelTalosFlowLayoutManager $receiver) {
        this.this$0 = $receiver;
    }

    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
        Intrinsics.checkNotNullParameter(id, "id");
        int imageHeight = 0;
        int imageWidth = imageInfo != null ? imageInfo.getWidth() : 0;
        if (imageInfo != null) {
            imageHeight = imageInfo.getHeight();
        }
        if (imageWidth > 0 && imageHeight > 0) {
            float targetHeight = (((float) imageHeight) / ((float) imageWidth)) * ((float) ChannelTalosFlowLayoutManager.DEVICE_WIDTH);
            if (targetHeight >= ((float) (VideoImmersionUtils.getStatusBarHeight() + ChannelTalosFlowLayoutManager.FLOW_TAB_HEIGHT))) {
                RelativeLayout access$getTopContainer$p = this.this$0.topContainer;
                ViewGroup.LayoutParams targetLayoutParams = access$getTopContainer$p != null ? access$getTopContainer$p.getLayoutParams() : null;
                if (targetLayoutParams != null) {
                    targetLayoutParams.height = (int) targetHeight;
                }
                RelativeLayout access$getTopContainer$p2 = this.this$0.topContainer;
                if (access$getTopContainer$p2 != null) {
                    access$getTopContainer$p2.setLayoutParams(targetLayoutParams);
                }
            }
        }
    }

    public void onFailure(String id, Throwable throwable) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }
}
