package com.baidu.searchbox.video.feedflow.detail.landscapelistpanel;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.inf.ListPanelModel;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002 !B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\b\u0010\u001f\u001a\u00020\u0018H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelHeader;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "closeClickListener", "Lcom/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelHeader$IOnCloseClickListener;", "data", "Lcom/baidu/searchbox/video/inf/ListPanelModel;", "flowVideoIvClose", "Landroid/widget/ImageView;", "flowVideoIvLeft", "Lcom/facebook/drawee/view/SimpleDraweeView;", "flowVideoTvLeft", "Landroid/widget/TextView;", "flowVideoTvTitle", "leftClickListener", "Lcom/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelHeader$IOnLeftClickListener;", "leftContainer", "Landroid/widget/LinearLayout;", "bindData", "", "onClick", "v", "Landroid/view/View;", "registerCloseClickListener", "listener", "registerLeftClickListener", "setFontAndPictureSize", "IOnCloseClickListener", "IOnLeftClickListener", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeListPanelHeader.kt */
public final class LandscapeListPanelHeader extends FrameLayout implements View.OnClickListener {
    private IOnCloseClickListener closeClickListener;
    private ListPanelModel data;
    private ImageView flowVideoIvClose;
    private SimpleDraweeView flowVideoIvLeft;
    private TextView flowVideoTvLeft;
    private TextView flowVideoTvTitle;
    private IOnLeftClickListener leftClickListener;
    private LinearLayout leftContainer;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelHeader$IOnCloseClickListener;", "", "onCloseClicked", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LandscapeListPanelHeader.kt */
    public interface IOnCloseClickListener {
        void onCloseClicked();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelHeader$IOnLeftClickListener;", "", "onLeftClicked", "", "scheme", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LandscapeListPanelHeader.kt */
    public interface IOnLeftClickListener {
        void onLeftClicked(String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LandscapeListPanelHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.video_flow_landscape_list_panel_header, this);
        View findViewById = findViewById(R.id.flow_video_iv_left);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.flow_video_iv_left)");
        this.flowVideoIvLeft = (SimpleDraweeView) findViewById;
        View findViewById2 = findViewById(R.id.flow_video_tv_left);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.flow_video_tv_left)");
        this.flowVideoTvLeft = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.flow_video_tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.flow_video_tv_title)");
        this.flowVideoTvTitle = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.flow_video_iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.flow_video_iv_close)");
        this.flowVideoIvClose = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.flow_video_left_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.flow_video_left_container)");
        this.leftContainer = (LinearLayout) findViewById5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LandscapeListPanelHeader(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final void setFontAndPictureSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.flowVideoIvLeft, R.dimen.video_flow_dimens_19dp, R.dimen.video_flow_dimens_19dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.flowVideoTvLeft, com.baidu.searchbox.feed.styles.R.dimen.F_T_X054, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.flowVideoTvTitle, com.baidu.searchbox.feed.styles.R.dimen.F_T_X052, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.flowVideoIvClose, R.dimen.video_flow_dimens_22dp, R.dimen.video_flow_dimens_22dp, 0, 0, 12, (Object) null);
    }

    public final void bindData(ListPanelModel data2) {
        setFontAndPictureSize();
        this.data = data2;
        String str = null;
        if (TextUtils.isEmpty(data2 != null ? data2.getSubTitleIconLandscape() : null)) {
            this.flowVideoIvLeft.setVisibility(8);
        } else {
            this.flowVideoIvLeft.setVisibility(0);
            this.flowVideoIvLeft.setImageURI(data2 != null ? data2.getSubTitleIconLandscape() : null);
            ((GenericDraweeHierarchy) this.flowVideoIvLeft.getHierarchy()).setUseGlobalColorFilter(false);
        }
        this.flowVideoTvLeft.setText(data2 != null ? data2.getSubTitle() : null);
        this.leftContainer.setOnClickListener(this);
        TextView textView = this.flowVideoTvTitle;
        if (data2 != null) {
            str = data2.getTitle();
        }
        textView.setText(str);
        this.flowVideoIvClose.setOnClickListener(this);
    }

    public void onClick(View v) {
        IOnCloseClickListener iOnCloseClickListener;
        String scheme;
        IOnLeftClickListener iOnLeftClickListener;
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i2 = R.id.flow_video_left_container;
        if (valueOf != null && valueOf.intValue() == i2) {
            ListPanelModel listPanelModel = this.data;
            if (listPanelModel != null && (scheme = listPanelModel.getSubTitleCmd()) != null && (iOnLeftClickListener = this.leftClickListener) != null) {
                iOnLeftClickListener.onLeftClicked(scheme);
                return;
            }
            return;
        }
        int i3 = R.id.flow_video_iv_close;
        if (valueOf != null && valueOf.intValue() == i3 && (iOnCloseClickListener = this.closeClickListener) != null) {
            iOnCloseClickListener.onCloseClicked();
        }
    }

    public final void registerLeftClickListener(IOnLeftClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.leftClickListener = listener;
    }

    public final void registerCloseClickListener(IOnCloseClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.closeClickListener = listener;
    }
}
