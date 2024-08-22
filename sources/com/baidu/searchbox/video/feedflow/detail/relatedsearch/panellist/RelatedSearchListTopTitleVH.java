package com.baidu.searchbox.video.feedflow.detail.relatedsearch.panellist;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.player.utils.LayerUtil;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.list.RelatedSearchModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0002J\f\u0010!\u001a\u00020\u0012*\u00020\u0014H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/relatedsearch/panellist/RelatedSearchListTopTitleVH;", "Lcom/baidu/searchbox/video/feedflow/detail/relatedsearch/panellist/RelatedSearchListBaseVH;", "Lcom/baidu/searchbox/video/feedflow/flow/list/VideoItemModel;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "edgeDrawable", "Landroid/graphics/drawable/GradientDrawable;", "edgeDrawableTop", "edgeMaskBottom", "edgeMaskTop", "ivPoster", "Lcom/facebook/drawee/view/SimpleDraweeView;", "tvDurationInPoster", "Landroid/widget/TextView;", "tvTagInPoster", "tvTitleInPoster", "addZero", "", "num", "", "bindDurationText", "", "itemModel", "bindImageView", "initEdgeDrawable", "initEdgeDrawableTop", "onBindData", "data", "setFontAndPictureSize", "setViewHeight", "isMiniVideo", "", "formatToTime", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedSearchListTopTitleVH.kt */
public final class RelatedSearchListTopTitleVH extends RelatedSearchListBaseVH<VideoItemModel> {
    private final GradientDrawable edgeDrawable;
    private final GradientDrawable edgeDrawableTop;
    private final View edgeMaskBottom;
    private final View edgeMaskTop;
    private final SimpleDraweeView ivPoster;
    private final TextView tvDurationInPoster;
    private final TextView tvTagInPoster;
    private final TextView tvTitleInPoster;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RelatedSearchListTopTitleVH(View view2) {
        super(view2);
        Intrinsics.checkNotNullParameter(view2, "view");
        View findViewById = view2.findViewById(R.id.iv_poster);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.iv_poster)");
        this.ivPoster = (SimpleDraweeView) findViewById;
        View findViewById2 = view2.findViewById(R.id.tv_duration_in_poster);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tv_duration_in_poster)");
        TextView textView = (TextView) findViewById2;
        this.tvDurationInPoster = textView;
        View findViewById3 = view2.findViewById(R.id.view_edge_mask_in_poster_top);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.v…_edge_mask_in_poster_top)");
        this.edgeMaskTop = findViewById3;
        View findViewById4 = view2.findViewById(R.id.view_edge_mask_in_poster_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.v…ge_mask_in_poster_bottom)");
        this.edgeMaskBottom = findViewById4;
        View findViewById5 = view2.findViewById(R.id.tv_title_in_poster);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.tv_title_in_poster)");
        TextView textView2 = (TextView) findViewById5;
        this.tvTitleInPoster = textView2;
        View findViewById6 = view2.findViewById(R.id.tv_tag_in_poster);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.tv_tag_in_poster)");
        this.tvTagInPoster = (TextView) findViewById6;
        GradientDrawable initEdgeDrawableTop = initEdgeDrawableTop();
        this.edgeDrawableTop = initEdgeDrawableTop;
        GradientDrawable initEdgeDrawable = initEdgeDrawable();
        this.edgeDrawable = initEdgeDrawable;
        findViewById3.setBackground(initEdgeDrawableTop);
        findViewById4.setBackground(initEdgeDrawable);
        LayerUtil.setFontFakeBold(textView2, true, 1.0f);
        LayerUtil.setFontFakeBold(textView, true, 1.0f);
    }

    public void onBindData(VideoItemModel data) {
        CharSequence charSequence;
        int color;
        if (data != null) {
            VideoItemModel itemModel = data;
            setFontAndPictureSize();
            bindImageView(data);
            this.edgeMaskTop.setBackground(this.edgeDrawableTop);
            this.edgeMaskBottom.setBackground(this.edgeDrawable);
            TextView textView = this.tvTitleInPoster;
            if (!StringsKt.isBlank(itemModel.getTitle())) {
                charSequence = itemModel.getTitle();
            } else {
                if (!(!StringsKt.isBlank(itemModel.getAuthorName()))) {
                    String publishTime = itemModel.getPublishTime();
                    if (publishTime == null) {
                        publishTime = "";
                    }
                    if (!(!StringsKt.isBlank(publishTime))) {
                        charSequence = "";
                    }
                }
                charSequence = itemModel.getAuthorName() + itemModel.getPublishTime() + this.tvTitleInPoster.getContext().getResources().getString(R.string.video_flow_collection_detail_title_default);
            }
            textView.setText(charSequence);
            bindDurationText(data);
            this.tvTagInPoster.setVisibility(8);
            RelatedSearchModel $this$onBindData_u24lambda_u2d1_u24lambda_u2d0 = itemModel.getRelatedSearch();
            if ($this$onBindData_u24lambda_u2d1_u24lambda_u2d0 != null) {
                if (!StringsKt.isBlank($this$onBindData_u24lambda_u2d1_u24lambda_u2d0.getTag())) {
                    this.tvTagInPoster.setText($this$onBindData_u24lambda_u2d1_u24lambda_u2d0.getTag());
                    this.tvTagInPoster.setVisibility(0);
                }
                try {
                    if (!StringsKt.isBlank($this$onBindData_u24lambda_u2d1_u24lambda_u2d0.getTagColor())) {
                        color = Color.parseColor($this$onBindData_u24lambda_u2d1_u24lambda_u2d0.getTagColor());
                    } else {
                        color = ResourceUtils.getColor(this.tvTitleInPoster.getContext(), R.color.video_flow_color_white);
                    }
                } catch (Exception e2) {
                    color = ResourceUtils.getColor(this.tvTitleInPoster.getContext(), R.color.video_flow_color_white);
                }
                this.tvTagInPoster.setTextColor(color);
            }
        }
    }

    private final GradientDrawable initEdgeDrawableTop() {
        int topColor = ResourceUtils.getColor(this.edgeMaskTop.getContext(), R.color.video_flow_color_66000000);
        int bottomColor = ResourceUtils.getColor(this.edgeMaskTop.getContext(), R.color.video_flow_color_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable $this$initEdgeDrawableTop_u24lambda_u2d2 = gradientDrawable;
        $this$initEdgeDrawableTop_u24lambda_u2d2.setGradientType(0);
        $this$initEdgeDrawableTop_u24lambda_u2d2.setColors(new int[]{topColor, bottomColor});
        $this$initEdgeDrawableTop_u24lambda_u2d2.setShape(0);
        $this$initEdgeDrawableTop_u24lambda_u2d2.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        return gradientDrawable;
    }

    private final void setFontAndPictureSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.tvTitleInPoster, R.dimen.video_flow_dimens_13dp, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.tvDurationInPoster, R.dimen.video_flow_dimens_10dp, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.tvTagInPoster, R.dimen.video_flow_dimens_10dp, 0, 0, 6, (Object) null);
    }

    private final GradientDrawable initEdgeDrawable() {
        int topColor = ResourceUtils.getColor(this.edgeMaskBottom.getContext(), R.color.video_flow_color_transparent);
        int bottomColor = ResourceUtils.getColor(this.edgeMaskBottom.getContext(), R.color.video_flow_color_66000000);
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable $this$initEdgeDrawable_u24lambda_u2d3 = gradientDrawable;
        $this$initEdgeDrawable_u24lambda_u2d3.setGradientType(0);
        $this$initEdgeDrawable_u24lambda_u2d3.setColors(new int[]{topColor, bottomColor});
        $this$initEdgeDrawable_u24lambda_u2d3.setShape(0);
        $this$initEdgeDrawable_u24lambda_u2d3.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        return gradientDrawable;
    }

    private final void bindImageView(VideoItemModel itemModel) {
        String poster;
        RelatedSearchModel relatedSearch = itemModel.getRelatedSearch();
        boolean isHorizontalImage = relatedSearch != null ? relatedSearch.isHorizontalImage() : true;
        RelatedSearchModel relatedSearch2 = itemModel.getRelatedSearch();
        if (relatedSearch2 == null || (poster = relatedSearch2.getPosterImage()) == null) {
            poster = "";
        }
        if (StringsKt.isBlank(poster) && (!StringsKt.isBlank(itemModel.getHorizontalCover()))) {
            poster = itemModel.getHorizontalCover();
            isHorizontalImage = true;
        }
        if (StringsKt.isBlank(poster) && (!StringsKt.isBlank(itemModel.getVideoInfo()))) {
            try {
                JSONObject jsonObject = new JSONObject(itemModel.getVideoInfo());
                Integer intOrNull = StringsKt.toIntOrNull(itemModel.getVideoWidth());
                int videoWidth = intOrNull != null ? intOrNull.intValue() : 0;
                Integer intOrNull2 = StringsKt.toIntOrNull(itemModel.getVideoHeight());
                int videoHeight = intOrNull2 != null ? intOrNull2.intValue() : 0;
                String imgUrl = jsonObject.optString("posterImage");
                if (!(videoWidth == 0 || videoHeight == 0)) {
                    Intrinsics.checkNotNullExpressionValue(imgUrl, "imgUrl");
                    if (!StringsKt.isBlank(imgUrl)) {
                        isHorizontalImage = videoWidth > videoHeight;
                        poster = imgUrl;
                    }
                }
            } catch (Exception e2) {
            }
        }
        setViewHeight(this.ivPoster, isHorizontalImage);
        int placeHolderImage = R.drawable.video_flow_recommend_panel_placeholder_bg;
        GenericDraweeHierarchy $this$bindImageView_u24lambda_u2d4 = (GenericDraweeHierarchy) this.ivPoster.getHierarchy();
        if ($this$bindImageView_u24lambda_u2d4 != null) {
            $this$bindImageView_u24lambda_u2d4.setUseGlobalColorFilter(false);
            $this$bindImageView_u24lambda_u2d4.setPlaceholderImage(placeHolderImage, ScalingUtils.ScaleType.CENTER_CROP);
            Drawable topLevelDrawable = $this$bindImageView_u24lambda_u2d4.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                topLevelDrawable.clearColorFilter();
            }
        }
        if (true ^ StringsKt.isBlank(poster)) {
            this.ivPoster.setImageURI(poster);
            this.ivPoster.setVisibility(0);
            return;
        }
        this.ivPoster.setVisibility(8);
    }

    private final void setViewHeight(View view2, boolean isMiniVideo) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = (int) (((double) ((DIFactory.INSTANCE.getDisplayWidth() - view2.getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_23dp)) / 2)) * (isMiniVideo ? 0.75d : 1.333d));
        view2.setLayoutParams(layoutParams);
    }

    private final void bindDurationText(VideoItemModel itemModel) {
        this.tvDurationInPoster.setVisibility(8);
        boolean z = true;
        if (!StringsKt.isBlank(itemModel.getVideoInfo())) {
            try {
                BdVideoSeries videoSeries = itemModel.getVideoSeries();
                String duration = videoSeries != null ? formatToTime(videoSeries.getDuration()) : null;
                if (duration == null || !(!StringsKt.isBlank(duration))) {
                    z = false;
                }
                if (z) {
                    this.tvDurationInPoster.setText(duration);
                    this.tvDurationInPoster.setVisibility(0);
                }
            } catch (Exception e2) {
            }
        }
    }

    private final String formatToTime(int $this$formatToTime) {
        String minute = addZero($this$formatToTime / 60);
        return minute + AbstractJsonLexerKt.COLON + addZero($this$formatToTime % 60);
    }

    private final String addZero(int num) {
        if (num <= 0) {
            return "00";
        }
        if (num < 10) {
            return new StringBuilder().append('0').append(num).toString();
        }
        return String.valueOf(num);
    }
}
