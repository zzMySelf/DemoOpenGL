package com.baidu.searchbox.feed.template.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.feed.biserial.bean.FeedBiseralItemData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBurnoutItemChildData;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.template.R;
import com.baidu.searchbox.feed.template.biserial.FeedBiserialScreenUtil;
import com.baidu.searchbox.feed.util.FeedScreenUtil;
import com.baidu.searchbox.ui.UnifyTextView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0019H\u0002J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\"\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u001dR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/feed/template/view/FeedBurnoutItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemImage", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "itemModel", "Lcom/baidu/searchbox/feed/model/FeedBurnoutItemChildData;", "itemTitle", "Lcom/baidu/searchbox/ui/UnifyTextView;", "itemWidth", "", "resourceTypeImage", "Landroid/widget/ImageView;", "root", "Landroid/view/View;", "getBurnoutItemWidth", "recordShow", "", "setRootViewBackground", "trySetVideoPlayIconVisible", "itemData", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "updateImage", "Lcom/baidu/searchbox/feed/biserial/bean/FeedBiseralItemData;", "updateImageSize", "updateTitleView", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "updateUi", "model", "pos", "", "parentModel", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBurnoutItemView.kt */
public final class FeedBurnoutItemView extends RelativeLayout {
    private FeedDraweeView itemImage;
    private FeedBurnoutItemChildData itemModel;
    private UnifyTextView itemTitle;
    private float itemWidth;
    private ImageView resourceTypeImage;
    private View root = LayoutInflater.from(getContext()).inflate(R.layout.feed_burnout_item_view_layout, this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBurnoutItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setRootViewBackground();
        View findViewById = findViewById(R.id.feed_burnout_item_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.feed_burnout_item_image)");
        this.itemImage = (FeedDraweeView) findViewById;
        View findViewById2 = findViewById(R.id.feed_burnout_item_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.feed_burnout_item_title)");
        this.itemTitle = (UnifyTextView) findViewById2;
        View findViewById3 = findViewById(R.id.feed_burnout_item_type_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.feed_burnout_item_type_icon)");
        this.resourceTypeImage = (ImageView) findViewById3;
        this.itemWidth = getBurnoutItemWidth(context);
        setLayoutParams(new FrameLayout.LayoutParams((int) this.itemWidth, -2));
    }

    public final void updateUi(FeedBurnoutItemChildData model, int pos, FeedBaseModel parentModel) {
        if (parentModel != null && model != null) {
            this.itemModel = model;
            Ref.ObjectRef feedBaseModel = new Ref.ObjectRef();
            feedBaseModel.element = model.getFeedBaseModel();
            FeedBaseModel feedBaseModel2 = (FeedBaseModel) feedBaseModel.element;
            FeedItemData feedItemData = null;
            if ((feedBaseModel2 != null ? feedBaseModel2.data : null) instanceof FeedBiseralItemData) {
                FeedBaseModel feedBaseModel3 = (FeedBaseModel) feedBaseModel.element;
                if (feedBaseModel3 != null) {
                    feedItemData = feedBaseModel3.data;
                }
                if (feedItemData != null) {
                    FeedBiseralItemData itemData = (FeedBiseralItemData) feedItemData;
                    updateImage(itemData);
                    trySetVideoPlayIconVisible(itemData);
                    updateTitleView((FeedBaseModel) feedBaseModel.element);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.biserial.bean.FeedBiseralItemData");
                }
            }
            setOnClickListener(new FeedBurnoutItemView$updateUi$1(feedBaseModel, this, parentModel, model, pos));
        }
    }

    private final void updateImage(FeedBiseralItemData itemData) {
        updateImageSize(itemData);
        this.itemImage.setPlaceHolderWithCenterCrop(ResourcesCompat.getDrawable(getResources(), R.drawable.feed_biserial_item_img_default, (Resources.Theme) null));
        ImageRequestBuilder imageBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(itemData.getImageUrl()));
        if (!(this.itemImage.getLayoutParams().width == 0 || this.itemImage.getLayoutParams().height == 0)) {
            imageBuilder.setResizeOptions(new ResizeOptions((int) (((double) this.itemImage.getLayoutParams().width) * 0.8d), (int) (((double) this.itemImage.getLayoutParams().height) * 0.8d), 0.0f, 0.0f, 12, (DefaultConstructorMarker) null));
        }
        AbstractDraweeController controller = ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(imageBuilder.build())).setOldController(this.itemImage.getController())).setControllerListener(new BaseControllerListener())).build();
        Intrinsics.checkNotNullExpressionValue(controller, "newDraweeControllerBuild…\n                .build()");
        this.itemImage.setController(controller);
    }

    private final void updateImageSize(FeedBiseralItemData itemData) {
        ViewGroup.LayoutParams params = this.itemImage.getLayoutParams();
        if (itemData.getWhRatio() <= 0.0d) {
            if (params != null) {
                params.height = (int) this.itemWidth;
            }
        } else if (params != null) {
            params.height = (int) (((double) this.itemWidth) / itemData.getWhRatio());
        }
        if (params != null) {
            params.width = (int) (this.itemWidth + 0.5f);
        }
        this.itemImage.setLayoutParams(params);
        FeedBiserialScreenUtil feedBiserialScreenUtil = FeedBiserialScreenUtil.INSTANCE;
        FeedDraweeView feedDraweeView = this.itemImage;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FeedBiserialScreenUtil.changeEPStyleImageBgWithTopCorner$default(feedBiserialScreenUtil, feedDraweeView, context, (Integer) null, 4, (Object) null);
    }

    private final void trySetVideoPlayIconVisible(FeedItemData itemData) {
        if (itemData instanceof FeedBiseralItemData) {
            if (TextUtils.equals(((FeedBiseralItemData) itemData).getTplType(), "video")) {
                this.resourceTypeImage.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.feed_biserial_video_play_icon, (Resources.Theme) null));
                this.resourceTypeImage.setVisibility(0);
                return;
            } else if (TextUtils.equals(((FeedBiseralItemData) itemData).getTplType(), "text")) {
                this.resourceTypeImage.setVisibility(0);
                this.resourceTypeImage.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.feed_biserial_text_icon, (Resources.Theme) null));
                return;
            }
        }
        this.resourceTypeImage.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r3 = r5.data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateTitleView(com.baidu.searchbox.feed.model.FeedBaseModel r5) {
        /*
            r4 = this;
            com.baidu.searchbox.ui.UnifyTextView r0 = r4.itemTitle
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
            r2 = 0
            if (r5 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedItemData r3 = r5.data
            if (r3 == 0) goto L_0x0010
            java.lang.String r3 = r3.title
            goto L_0x0011
        L_0x0010:
            r3 = r2
        L_0x0011:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.<init>(r3)
            com.baidu.searchbox.feed.util.processor.FeedEmotionTextProcessor.createEmotionText(r0, r5, r1)
            com.baidu.searchbox.ui.UnifyTextView r0 = r4.itemTitle
            if (r5 == 0) goto L_0x0024
            com.baidu.searchbox.feed.model.FeedItemData r1 = r5.data
            if (r1 == 0) goto L_0x0024
            java.lang.String r1 = r1.title
            goto L_0x0025
        L_0x0024:
            r1 = r2
        L_0x0025:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.widget.TextView$BufferType r3 = android.widget.TextView.BufferType.NORMAL
            r0.setTextWithUnifiedPadding(r1, r3)
            com.baidu.searchbox.ui.UnifyTextView r0 = r4.itemTitle
            android.content.Context r1 = r4.getContext()
            int r3 = com.baidu.searchbox.feed.styles.R.color.FC1
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r3)
            r0.setTextColor(r1)
            com.baidu.searchbox.ui.UnifyTextView r0 = r4.itemTitle
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            r3 = 1
            com.baidu.searchbox.kotlinx.ViewExtensionsKt.enableBold$default(r0, r1, r3, r2)
            com.baidu.searchbox.ui.UnifyTextView r0 = r4.itemTitle
            int r1 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X300
            r2 = 0
            float r1 = com.baidu.searchbox.config.FontSizeHelper.getScaledSizeRes(r2, r1)
            r0.setTextSize(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.view.FeedBurnoutItemView.updateTitleView(com.baidu.searchbox.feed.model.FeedBaseModel):void");
    }

    private final void setRootViewBackground() {
        View view2 = this.root;
        if (view2 != null) {
            FeedBiserialScreenUtil feedBiserialScreenUtil = FeedBiserialScreenUtil.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            view2.setBackground(feedBiserialScreenUtil.getEPStyleItemBg(context));
        }
    }

    private final float getBurnoutItemWidth(Context context) {
        return (((float) FeedScreenUtil.getScreenWidth(context)) - ((((float) context.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X001)) * 2.0f) + ((float) context.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X062)))) / ((float) 2);
    }

    public final void recordShow() {
        if (getLocalVisibleRect(new Rect())) {
            FeedBurnoutItemChildData feedBurnoutItemChildData = this.itemModel;
            boolean z = false;
            if (feedBurnoutItemChildData != null && !feedBurnoutItemChildData.hasDisplayed) {
                z = true;
            }
            if (z) {
                FeedBurnoutItemChildData feedBurnoutItemChildData2 = this.itemModel;
                if (feedBurnoutItemChildData2 != null) {
                    feedBurnoutItemChildData2.hasDisplayed = true;
                }
                FeedBurnoutItemChildData feedBurnoutItemChildData3 = this.itemModel;
                if (feedBurnoutItemChildData3 != null) {
                    feedBurnoutItemChildData3.displayTimeMillis = System.currentTimeMillis();
                }
            }
        }
    }
}
