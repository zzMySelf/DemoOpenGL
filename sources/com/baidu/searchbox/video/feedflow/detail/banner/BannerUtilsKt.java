package com.baidu.searchbox.video.feedflow.detail.banner;

import android.net.Uri;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.banner.view.LinearLayoutWithMaxWidth;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H\u0002\u001a\u001e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H\u0002\u001a\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014\u001a \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"IMAGE_CIRCLE_BORDER_WIDTH", "", "IMAGE_CORNERS_RADIUS", "MIN_TEXT_SIZE", "", "bannerImageCircleHandle", "", "simpleView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bannerImageShapeHandle", "imageView", "isCircle", "", "bannerImageSquareHandle", "fixedTextViewWidth", "textView", "Landroid/widget/TextView;", "generateBannerExt", "Lorg/json/JSONObject;", "value", "", "processingBannerViewWidth", "viewRoot", "Lcom/baidu/searchbox/video/feedflow/detail/banner/view/LinearLayoutWithMaxWidth;", "views", "", "processingMulViewSize", "realProcessingBannerViewWidth", "setBannerImageView", "url", "setBannerImageViewWithShape", "viewUnspecifiedMeasure", "view", "Landroid/view/View;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannerUtils.kt */
public final class BannerUtilsKt {
    private static final float IMAGE_CIRCLE_BORDER_WIDTH = 0.5f;
    private static final float IMAGE_CORNERS_RADIUS = 3.0f;
    private static final int MIN_TEXT_SIZE = 3;

    public static final JSONObject generateBannerExt(String value) {
        CharSequence charSequence = value;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            JSONObject jSONObject = null;
            return null;
        }
        JSONObject $this$generateBannerExt_u24lambda_u2d0 = new JSONObject();
        $this$generateBannerExt_u24lambda_u2d0.putOpt("banner_ext", value);
        return $this$generateBannerExt_u24lambda_u2d0;
    }

    public static final void processingBannerViewWidth(LinearLayoutWithMaxWidth viewRoot, List<TextView> views) {
        Intrinsics.checkNotNullParameter(viewRoot, "viewRoot");
        Intrinsics.checkNotNullParameter(views, "views");
        viewRoot.post(new BannerUtilsKt$$ExternalSyntheticLambda0(viewRoot, views));
    }

    /* access modifiers changed from: private */
    /* renamed from: processingBannerViewWidth$lambda-1  reason: not valid java name */
    public static final void m10703processingBannerViewWidth$lambda1(LinearLayoutWithMaxWidth $viewRoot, List $views) {
        Intrinsics.checkNotNullParameter($viewRoot, "$viewRoot");
        Intrinsics.checkNotNullParameter($views, "$views");
        realProcessingBannerViewWidth($viewRoot, $views);
    }

    private static final void realProcessingBannerViewWidth(LinearLayoutWithMaxWidth viewRoot, List<TextView> views) {
        if (!views.isEmpty()) {
            viewUnspecifiedMeasure(viewRoot);
            if (viewRoot.getMeasuredWidth() > viewRoot.getAllowedMaxWidth() && viewRoot.getAllowedMaxWidth() > 0) {
                if (views.size() != 1) {
                    processingMulViewSize(viewRoot, views);
                } else if (viewRoot.getMeasuredWidth() > viewRoot.getAllowedMaxWidth()) {
                    viewUnspecifiedMeasure(views.get(0));
                    views.get(0).setWidth(views.get(0).getMeasuredWidth() - (viewRoot.getMeasuredWidth() - viewRoot.getAllowedMaxWidth()));
                    viewRoot.setContentCompressed(true);
                    fixedTextViewWidth(views.get(0));
                }
            }
        }
    }

    private static final void processingMulViewSize(LinearLayoutWithMaxWidth viewRoot, List<TextView> views) {
        TextView lastTextView = views.get(views.size() - 1);
        float textMinSize = ((float) lastTextView.getCompoundDrawablePadding()) + (lastTextView.getPaint().getTextSize() * ((float) 3));
        viewUnspecifiedMeasure(lastTextView);
        if (((float) lastTextView.getMeasuredWidth()) > textMinSize) {
            float viewMinSize = ((float) (viewRoot.getMeasuredWidth() - lastTextView.getMeasuredWidth())) + textMinSize;
            if (viewMinSize < ((float) viewRoot.getAllowedMaxWidth())) {
                textMinSize = (((float) viewRoot.getAllowedMaxWidth()) + textMinSize) - viewMinSize;
            }
            lastTextView.setWidth((int) textMinSize);
            viewRoot.setContentCompressed(true);
            fixedTextViewWidth(lastTextView);
        }
        views.remove(views.size() - 1);
        realProcessingBannerViewWidth(viewRoot, views);
    }

    public static final void viewUnspecifiedMeasure(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private static final void fixedTextViewWidth(TextView textView) {
        textView.post(new BannerUtilsKt$$ExternalSyntheticLambda1(textView));
    }

    /* access modifiers changed from: private */
    /* renamed from: fixedTextViewWidth$lambda-2  reason: not valid java name */
    public static final void m10702fixedTextViewWidth$lambda2(TextView $textView) {
        int width;
        Intrinsics.checkNotNullParameter($textView, "$textView");
        Layout layout = $textView.getLayout();
        if ((layout != null ? layout.getEllipsisStart(0) : 0) != 0 && (width = $textView.getCompoundDrawablePadding() + ((int) $textView.getPaint().measureText($textView.getText(), 0, $textView.getLayout().getEllipsisStart(0))) + ((int) $textView.getPaint().measureText((String) $textView.getContext().getResources().getText(R.string.video_flow_banner_ellipsis)))) < $textView.getMeasuredWidth()) {
            $textView.setWidth(width);
        }
    }

    public static final void setBannerImageViewWithShape(SimpleDraweeView simpleView, String url, boolean isCircle) {
        Intrinsics.checkNotNullParameter(simpleView, "simpleView");
        bannerImageShapeHandle(simpleView, isCircle);
        setBannerImageView(simpleView, url);
    }

    public static final void setBannerImageView(SimpleDraweeView simpleView, String url) {
        Intrinsics.checkNotNullParameter(simpleView, "simpleView");
        CharSequence charSequence = url;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            simpleView.setVisibility(0);
            AbstractDraweeController controller = ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(Uri.parse(url)).setTapToRetryEnabled(true)).setOldController(simpleView.getController())).setControllerListener(new BannerUtilsKt$setBannerImageView$controller$1(simpleView))).build();
            Intrinsics.checkNotNullExpressionValue(controller, "simpleView: SimpleDrawee… }\n            }).build()");
            ((GenericDraweeHierarchy) simpleView.getHierarchy()).setUseGlobalColorFilter(false);
            simpleView.setController(controller);
            return;
        }
        simpleView.setVisibility(8);
    }

    private static final void bannerImageShapeHandle(SimpleDraweeView imageView, boolean isCircle) {
        if (isCircle) {
            bannerImageCircleHandle(imageView);
        } else {
            bannerImageSquareHandle(imageView);
        }
    }

    private static final void bannerImageCircleHandle(SimpleDraweeView simpleView) {
        RoundingParams roundingParams = ((GenericDraweeHierarchy) simpleView.getHierarchy()).getRoundingParams();
        if (roundingParams == null) {
            roundingParams = new RoundingParams();
        }
        roundingParams.setRoundAsCircle(true);
        roundingParams.setBorderWidth(DIFactory.INSTANCE.dp2pxf(0.5f));
        roundingParams.setBorderColor(ResourceUtils.getColor(simpleView.getContext(), R.color.video_flow_color_4CFFFFFF));
        ((GenericDraweeHierarchy) simpleView.getHierarchy()).setRoundingParams(roundingParams);
    }

    private static final void bannerImageSquareHandle(SimpleDraweeView simpleView) {
        RoundingParams roundingParams = ((GenericDraweeHierarchy) simpleView.getHierarchy()).getRoundingParams();
        if (roundingParams == null) {
            roundingParams = new RoundingParams();
        }
        roundingParams.setRoundAsCircle(false);
        roundingParams.setBorderWidth(0.0f);
        roundingParams.setCornersRadius(DIFactory.INSTANCE.dp2pxf(3.0f));
        ((GenericDraweeHierarchy) simpleView.getHierarchy()).setRoundingParams(roundingParams);
    }
}
