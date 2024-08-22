package com.baidu.searchbox.mall.comp.sug.item;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.mall.R;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemComponent;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/mall/comp/sug/item/SugItemComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemComponent;", "Lcom/baidu/searchbox/mall/comp/sug/item/SugItemData;", "Lcom/baidu/searchbox/mall/comp/sug/item/SugItemViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "ivInput", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "ivSearch", "tvSuggestion", "Landroid/widget/TextView;", "bindSuggestion", "", "viewModel", "onBindViewModel", "onCreateView", "onCreateViewModel", "onFontSizeChange", "info", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "onNightModeChange", "isNightMode", "", "updateIvInputSize", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SugItemComp.kt */
public final class SugItemComp extends BaseExtItemComponent<SugItemData, SugItemViewModel> {
    private final ImageView ivInput;
    private final ImageView ivSearch;
    private final TextView tvSuggestion;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SugItemComp(LifecycleOwner owner, View view2, UniqueId token) {
        super(owner, view2);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        this.ivSearch = (ImageView) view2.findViewById(R.id.iv_search);
        this.tvSuggestion = (TextView) view2.findViewById(R.id.tv_suggestion);
        ImageView imageView = (ImageView) view2.findViewById(R.id.iv_input);
        this.ivInput = imageView;
        imageView.setOnClickListener(new SugItemComp$$ExternalSyntheticLambda1(this, token));
        onFontSizeChange(FontSizeInfo.Companion.getInfo());
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m413_init_$lambda0(SugItemComp this$0, UniqueId $token, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($token, "$token");
        ((SugItemViewModel) this$0.getViewModel()).handleInputClick$lib_search_mall_release($token);
    }

    public void onCreateView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public SugItemViewModel onCreateViewModel() {
        return new SugItemViewModel();
    }

    public void onBindViewModel(SugItemViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel(viewModel, owner);
        bindSuggestion(viewModel, owner);
    }

    private final void bindSuggestion(SugItemViewModel viewModel, LifecycleOwner owner) {
        viewModel.getSuggestion().observe(owner, new SugItemComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindSuggestion$lambda-1  reason: not valid java name */
    public static final void m414bindSuggestion$lambda1(SugItemComp this$0, SpannableString it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tvSuggestion.setTypeface(Typeface.DEFAULT);
        this$0.tvSuggestion.setText(it);
    }

    public void onNightModeChange(boolean isNightMode) {
        ResWrapper.setBackground(getView(), R.drawable.sug_list_click_area_bg);
        ResWrapper.setTextColor(this.tvSuggestion, R.color.GC1);
        ResWrapper.setImageDrawable(this.ivSearch, R.drawable.sug_search_icon);
        ResWrapper.setImageDrawable(this.ivInput, R.drawable.sug_input_icon);
    }

    public void onFontSizeChange(FontSizeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onFontSizeChange(info);
        FontSizeExtKt.updateSize(this.ivSearch, 0);
        updateIvInputSize();
    }

    private final void updateIvInputSize() {
        int viewSize = this.ivInput.getPaddingLeft() + FontSizeExtKt.getScaleSize(0, ViewExKt.getDpF(16.0f)) + this.ivInput.getPaddingRight();
        ViewGroup.LayoutParams lp = this.ivInput.getLayoutParams();
        if (lp != null) {
            ViewGroup.LayoutParams $this$updateIvInputSize_u24lambda_u2d2 = lp;
            $this$updateIvInputSize_u24lambda_u2d2.width = viewSize;
            $this$updateIvInputSize_u24lambda_u2d2.height = viewSize;
            this.ivInput.setLayoutParams($this$updateIvInputSize_u24lambda_u2d2);
        }
    }
}
