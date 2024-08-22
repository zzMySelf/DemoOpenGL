package com.baidu.searchbox.bigimage.monetize.immersive;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.monetize.BaseBigImageAdComp;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010#\u001a\u00020$H\u0017J\b\u0010%\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006,"}, d2 = {"Lcom/baidu/searchbox/bigimage/monetize/immersive/ImmersiveAdComp;", "Lcom/baidu/searchbox/bigimage/monetize/BaseBigImageAdComp;", "Lcom/baidu/searchbox/bigimage/monetize/immersive/ImmersiveAdViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "buttonView", "Landroid/widget/Button;", "getButtonView", "()Landroid/widget/Button;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "introView", "Landroid/widget/TextView;", "getIntroView", "()Landroid/widget/TextView;", "panelView", "getPanelView", "()Landroid/view/View;", "tipView", "getTipView", "titleView", "getTitleView", "webView", "Lcom/baidu/searchbox/ng/browser/NgWebView;", "getWebView", "()Lcom/baidu/searchbox/ng/browser/NgWebView;", "setWebView", "(Lcom/baidu/searchbox/ng/browser/NgWebView;)V", "onCreate", "", "onCreateViewModel", "onFontSizeChange", "info", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "onNightModeChange", "isNightMode", "", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImmersiveAdComp.kt */
public final class ImmersiveAdComp extends BaseBigImageAdComp<ImmersiveAdViewModel> {
    private final Button buttonView;
    private final SimpleDraweeView imageView;
    private final TextView introView;
    private final View panelView;
    private final TextView tipView;
    private final TextView titleView;
    private final UniqueId token;
    private NgWebView webView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImmersiveAdComp(LifecycleOwner owner, View view2, UniqueId token2) {
        super(owner, view2, token2);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(token2, "token");
        this.token = token2;
        View findViewById = view2.findViewById(R.id.big_image_ad_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.big_image_ad_title)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = view2.findViewById(R.id.big_image_ad_intro);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.big_image_ad_intro)");
        this.introView = (TextView) findViewById2;
        View findViewById3 = view2.findViewById(R.id.big_image_ad_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.big_image_ad_tip)");
        this.tipView = (TextView) findViewById3;
        View findViewById4 = view2.findViewById(R.id.big_image_ad_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.big_image_ad_button)");
        this.buttonView = (Button) findViewById4;
        View findViewById5 = view2.findViewById(R.id.big_image_ad_panel);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.big_image_ad_panel)");
        this.panelView = findViewById5;
        View findViewById6 = view2.findViewById(R.id.big_image_ad);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.big_image_ad)");
        this.imageView = (SimpleDraweeView) findViewById6;
    }

    public TextView getTitleView() {
        return this.titleView;
    }

    public TextView getIntroView() {
        return this.introView;
    }

    public TextView getTipView() {
        return this.tipView;
    }

    public Button getButtonView() {
        return this.buttonView;
    }

    public View getPanelView() {
        return this.panelView;
    }

    public SimpleDraweeView getImageView() {
        return this.imageView;
    }

    public NgWebView getWebView() {
        return this.webView;
    }

    public void setWebView(NgWebView ngWebView) {
        this.webView = ngWebView;
    }

    public void onCreate() {
        super.onCreate();
        getView().setOnTouchListener(new ImmersiveAdComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final boolean m16533onCreate$lambda0(ImmersiveAdComp this$0, View view2, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAdGestureDetector$lib_search_bigimage_release().onTouchEvent(event);
        return true;
    }

    public ImmersiveAdViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get("ImmersiveAdComp", ImmersiveAdViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this)\n            .ge…eAdViewModel::class.java)");
        return (ImmersiveAdViewModel) viewModel;
    }

    public void onNightModeChange(boolean isNightMode) {
        Resources resources = getContext().getResources();
        if (isNightMode) {
            getView().setBackgroundColor(resources.getColor(R.color.search_big_image_bg_e_night));
            getTitleView().setTextColor(resources.getColor(R.color.search_big_image_font_a_night));
            getTipView().setTextColor(resources.getColor(R.color.search_big_image_font_d_night));
            getIntroView().setTextColor(resources.getColor(R.color.search_big_image_font_d_night));
            getButtonView().setTextColor(resources.getColor(R.color.search_big_image_ad_btn_text_night));
            getButtonView().setBackgroundResource(R.drawable.search_big_image_ad_btn_bg_night);
            return;
        }
        getView().setBackgroundColor(resources.getColor(R.color.search_big_image_bg_e_night));
        getTitleView().setTextColor(resources.getColor(R.color.search_big_image_font_a));
        getTipView().setTextColor(resources.getColor(R.color.search_big_image_font_d));
        getIntroView().setTextColor(resources.getColor(R.color.search_big_image_font_d));
        getButtonView().setTextColor(resources.getColor(R.color.search_big_image_ad_btn_text));
        getButtonView().setBackgroundResource(R.drawable.search_big_image_ad_btn_bg);
    }

    public void onFontSizeChange(FontSizeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onFontSizeChange(info);
        FontSizeExtKt.updateTextSize$default(getIntroView(), 0, 1, (Object) null);
        FontSizeExtKt.updateTextSize$default(getTitleView(), 0, 1, (Object) null);
        FontSizeExtKt.updateTextSize$default(getTipView(), 0, 1, (Object) null);
        FontSizeExtKt.updateTextSize$default(getButtonView(), 0, 1, (Object) null);
    }
}
