package com.baidu.searchbox.video.template.fullitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.video.model.VideoFullItemModel;
import com.baidu.searchbox.ui.PressedImageView;
import com.baidu.searchbox.video.template.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/template/fullitem/LandscapeVideoFlowItemView;", "Lcom/baidu/searchbox/video/template/fullitem/LandscapeVideoFlowItemBaseView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adBackBtn", "Lcom/baidu/searchbox/ui/PressedImageView;", "adTitle", "Landroid/widget/TextView;", "bindData", "", "feedBaseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "position", "getLayoutId", "initSpecialView", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeVideoFlowItemView.kt */
public class LandscapeVideoFlowItemView extends LandscapeVideoFlowItemBaseView {
    private PressedImageView adBackBtn;
    private TextView adTitle;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandscapeVideoFlowItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandscapeVideoFlowItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LandscapeVideoFlowItemView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LandscapeVideoFlowItemView(Context context, AttributeSet attr, int defStyleAttr) {
        super(context, attr, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initSpecialView() {
        ViewGroup.LayoutParams $this$initSpecialView_u24lambda_u2d1_u24lambda_u2d0;
        this.adTitle = (TextView) findViewById(R.id.ad_title);
        this.adBackBtn = (PressedImageView) findViewById(R.id.ad_btn_back);
        SimpleDraweeView $this$initSpecialView_u24lambda_u2d1 = getPosterView();
        if ($this$initSpecialView_u24lambda_u2d1 != null && ($this$initSpecialView_u24lambda_u2d1_u24lambda_u2d0 = $this$initSpecialView_u24lambda_u2d1.getLayoutParams()) != null) {
            Intrinsics.checkNotNullExpressionValue($this$initSpecialView_u24lambda_u2d1_u24lambda_u2d0, "layoutParams");
            $this$initSpecialView_u24lambda_u2d1_u24lambda_u2d0.width = Math.max(DeviceUtils.ScreenInfo.getDisplayWidth($this$initSpecialView_u24lambda_u2d1.getContext()), DeviceUtils.ScreenInfo.getDisplayHeight($this$initSpecialView_u24lambda_u2d1.getContext()));
            $this$initSpecialView_u24lambda_u2d1_u24lambda_u2d0.height = ($this$initSpecialView_u24lambda_u2d1_u24lambda_u2d0.width * 9) / 16;
        }
    }

    public int getLayoutId() {
        return R.layout.video_landscape_flow_item_view;
    }

    public void bindData(FeedBaseModel feedBaseModel, int position) {
        Intrinsics.checkNotNullParameter(feedBaseModel, "feedBaseModel");
        if (feedBaseModel.data instanceof VideoFullItemModel) {
            FeedItemData feedItemData = feedBaseModel.data;
            if (feedItemData != null) {
                VideoFullItemModel videoFullItemModel = (VideoFullItemModel) feedItemData;
                String str = videoFullItemModel.mPoster;
                Intrinsics.checkNotNullExpressionValue(str, "videoFullItemModel.mPoster");
                setPosterView(str);
                setTitleLayerUi();
                VideoFullItemTitleWrapper titleLayer = getTitleLayer();
                if (titleLayer != null) {
                    titleLayer.updateData(videoFullItemModel);
                }
                VideoFullItemTitleWrapper titleLayer2 = getTitleLayer();
                if (titleLayer2 != null) {
                    titleLayer2.setVisibility(0);
                }
                TextView textView = this.adTitle;
                if (textView != null) {
                    textView.setVisibility(4);
                }
                PressedImageView pressedImageView = this.adBackBtn;
                if (pressedImageView != null) {
                    pressedImageView.setVisibility(4);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.video.model.VideoFullItemModel");
        }
    }
}
