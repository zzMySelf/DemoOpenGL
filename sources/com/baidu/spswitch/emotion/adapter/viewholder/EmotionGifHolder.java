package com.baidu.spswitch.emotion.adapter.viewholder;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.R;
import com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter;
import com.baidu.spswitch.emotion.bean.EmotionGifItemModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class EmotionGifHolder extends BDEmotionDynamicAdapter.BaseEmotionHolder<EmotionGifItemModel> {
    private final SimpleDraweeView mGifView;
    private RelativeLayout mRootView;

    public EmotionGifHolder(View itemView, int itemType) {
        super(itemView, itemType);
        itemView.setBackground(ContextCompat.getDrawable(itemView.getContext(), R.drawable.emotion_text_background));
        this.mRootView = (RelativeLayout) itemView.findViewById(R.id.root_view);
        this.mGifView = (SimpleDraweeView) itemView.findViewById(R.id.item_img);
    }

    public void onBindViewHolder(int position, EmotionGifItemModel model) {
        if (model != null && !TextUtils.isEmpty(model.url)) {
            ((GenericDraweeHierarchy) this.mGifView.getHierarchy()).setPlaceholderImage(R.drawable.emotion_image_item_placeholder);
            int padding = 0;
            ((GenericDraweeHierarchy) this.mGifView.getHierarchy()).setFadeDuration(0);
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setOverlayColor(ContextCompat.getColor(AppRuntime.getAppContext(), R.color.emotion_gif_panel_bg));
            ((GenericDraweeHierarchy) this.mGifView.getHierarchy()).setRoundingParams(roundingParams);
            ((GenericDraweeHierarchy) this.mGifView.getHierarchy()).setUseGlobalColorFilter(!model.isSearchIcon);
            ((GenericDraweeHierarchy) this.mGifView.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            int size = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.emotion_dynamic_item_size);
            this.mGifView.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(this.mGifView.getController())).setAutoPlayAnimations(true)).setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(model.url)).setResizeOptions(new ResizeOptions(size, size)).build())).build());
            if (model.isSearchIcon) {
                padding = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.emotion_gif_search_padding);
            }
            this.mRootView.setPadding(padding, padding, padding, padding);
        }
    }
}
