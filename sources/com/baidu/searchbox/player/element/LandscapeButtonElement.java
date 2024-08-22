package com.baidu.searchbox.player.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.videoplayer.framework.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/player/element/LandscapeButtonElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "Landroid/view/View$OnClickListener;", "()V", "landButton", "Landroid/widget/ImageView;", "getContentView", "Landroid/view/View;", "initElement", "", "onClick", "v", "onParentVisibleChanged", "visibility", "", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeButtonElement.kt */
public class LandscapeButtonElement extends AbsElement implements View.OnClickListener {
    private ImageView landButton;

    public View getContentView() {
        ImageView imageView = this.landButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("landButton");
            imageView = null;
        }
        return imageView;
    }

    public void initElement() {
        ImageView $this$initElement_u24lambda_u2d0 = new ImageView(getContext());
        this.landButton = $this$initElement_u24lambda_u2d0;
        int size = BdPlayerUtils.dp2px($this$initElement_u24lambda_u2d0, 16.0f);
        $this$initElement_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(size, size));
        $this$initElement_u24lambda_u2d0.setImageResource(R.drawable.bdvideoplayer_switch_land);
        $this$initElement_u24lambda_u2d0.setOnClickListener(this);
    }

    public void onParentVisibleChanged(int visibility) {
        ImageView imageView = null;
        if (visibility == 0) {
            BDVideoPlayer videoPlayer = getVideoPlayer();
            UniversalPlayer universalPlayer = videoPlayer instanceof UniversalPlayer ? (UniversalPlayer) videoPlayer : null;
            if (universalPlayer != null && !universalPlayer.isFullMode()) {
                ImageView imageView2 = this.landButton;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("landButton");
                } else {
                    imageView = imageView2;
                }
                imageView.setVisibility(0);
                return;
            }
        }
        ImageView imageView3 = this.landButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("landButton");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    public void onClick(View v) {
        BDVideoPlayer videoPlayer = getVideoPlayer();
        UniversalPlayer universalPlayer = videoPlayer instanceof UniversalPlayer ? (UniversalPlayer) videoPlayer : null;
        if (universalPlayer != null) {
            universalPlayer.switchToFull(1);
        }
    }
}
