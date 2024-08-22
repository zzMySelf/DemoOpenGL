package com.baidu.searchbox.bigimage.comp.root.preview;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.ioc.IImageNightMode;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u001b\u001a\u00020\u000fH\u0002R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/root/preview/PreviewOffBtnComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;)V", "previewBt", "previewIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "previewTv", "Landroid/widget/TextView;", "hidePreviewBt", "", "animate", "", "onBindViewModel", "viewModel", "onCreateViewModel", "onFontSizeChange", "info", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "onNightModeChange", "isNightMode", "showPreviewBt", "updatePreviewBtnBg", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewOffBtnComp.kt */
public final class PreviewOffBtnComp extends BaseExtSlaveComponent<BaseViewModel> {
    private final View previewBt;
    private final ImageView previewIcon;
    private final TextView previewTv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewOffBtnComp(LifecycleOwner owner, View view2) {
        super(owner, view2);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.previewBt = view2;
        this.previewTv = (TextView) view2.findViewById(R.id.previewTv);
        this.previewIcon = (ImageView) view2.findViewById(R.id.previewIcon);
    }

    public final void showPreviewBt(boolean animate) {
        this.previewBt.setVisibility(0);
        if (animate) {
            this.previewBt.setAlpha(0.0f);
            this.previewBt.animate().alpha(1.0f).setDuration(300).start();
            return;
        }
        this.previewBt.setAlpha(1.0f);
    }

    public final void hidePreviewBt(boolean animate) {
        if (animate) {
            this.previewBt.setVisibility(0);
            this.previewBt.animate().alpha(0.0f).setDuration(300).withEndAction(new PreviewOffBtnComp$$ExternalSyntheticLambda0(this)).start();
            return;
        }
        this.previewBt.setAlpha(0.0f);
        this.previewBt.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: hidePreviewBt$lambda-0  reason: not valid java name */
    public static final void m16468hidePreviewBt$lambda0(PreviewOffBtnComp this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.previewBt.setVisibility(8);
    }

    public BaseViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get("PreviewOffBtnComp", BaseViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(\"PreviewOff…aseViewModel::class.java)");
        return (BaseViewModel) viewModel;
    }

    public void onBindViewModel(BaseViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        IImageNightMode.Companion.getImpl().setImageDrawable(this.previewIcon, R.drawable.search_big_image_preview_off);
        IImageNightMode.Companion.getImpl().setTextColor(this.previewTv, R.color.SC261);
        updatePreviewBtnBg();
    }

    public void onFontSizeChange(FontSizeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onFontSizeChange(info);
        FontSizeExtKt.updateTextSize$default(this.previewTv, 0, 1, (Object) null);
        FontSizeExtKt.updateSize$default(this.previewIcon, 0, 1, (Object) null);
        updatePreviewBtnBg();
    }

    private final void updatePreviewBtnBg() {
        GradientDrawable $this$updatePreviewBtnBg_u24lambda_u2d1 = new GradientDrawable();
        $this$updatePreviewBtnBg_u24lambda_u2d1.setCornerRadius(FontSizeHelper.getScaledSizeRes(3, R.dimen.wallpaper_preview_bg_radius_big));
        $this$updatePreviewBtnBg_u24lambda_u2d1.setColor(Color.parseColor("#66333333"));
        this.previewBt.setBackground($this$updatePreviewBtnBg_u24lambda_u2d1);
    }
}
