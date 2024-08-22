package com.baidu.searchbox.bigimage.comp.infopanels;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.searchbox.bigimage.comp.infopanels.commodity.CommodityInfoPanelsComp;
import com.baidu.searchbox.bigimage.comp.infopanels.pics.IPlayDraftVideo;
import com.baidu.searchbox.bigimage.comp.infopanels.pics.PicsInfoPanelsComp;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\u0018\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/infopanels/InfoPanelsComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/bigimage/comp/infopanels/InfoPanelsViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "params", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "commodityInfoComp", "Lcom/baidu/searchbox/bigimage/comp/infopanels/commodity/CommodityInfoPanelsComp;", "getCommodityInfoComp", "()Lcom/baidu/searchbox/bigimage/comp/infopanels/commodity/CommodityInfoPanelsComp;", "commodityInfoComp$delegate", "Lkotlin/Lazy;", "iPlayDraftVideo", "Lcom/baidu/searchbox/bigimage/comp/infopanels/pics/IPlayDraftVideo;", "getIPlayDraftVideo$lib_search_bigimage_release", "()Lcom/baidu/searchbox/bigimage/comp/infopanels/pics/IPlayDraftVideo;", "setIPlayDraftVideo$lib_search_bigimage_release", "(Lcom/baidu/searchbox/bigimage/comp/infopanels/pics/IPlayDraftVideo;)V", "picsInfoComp", "Lcom/baidu/searchbox/bigimage/comp/infopanels/pics/PicsInfoPanelsComp;", "getPicsInfoComp", "()Lcom/baidu/searchbox/bigimage/comp/infopanels/pics/PicsInfoPanelsComp;", "picsInfoComp$delegate", "bindInfoPanelsInfo", "", "viewModel", "onBindViewModel", "onCreateViewModel", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InfoPanelsComp.kt */
public final class InfoPanelsComp extends BaseExtSlaveComponent<InfoPanelsViewModel> {
    private final Lazy commodityInfoComp$delegate;
    private IPlayDraftVideo iPlayDraftVideo;
    /* access modifiers changed from: private */
    public final ImagePageParams params;
    private final Lazy picsInfoComp$delegate;
    /* access modifiers changed from: private */
    public final UniqueId token;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoPanelsComp(LifecycleOwner owner, View view2, ImagePageParams params2, UniqueId token2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(params2, "params");
        Intrinsics.checkNotNullParameter(token2, "token");
        this.params = params2;
        this.token = token2;
        this.picsInfoComp$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new InfoPanelsComp$picsInfoComp$2(owner, this));
        this.commodityInfoComp$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new InfoPanelsComp$commodityInfoComp$2(owner, this));
        ((InfoPanelsViewModel) getViewModel()).setModel(params2);
    }

    public final IPlayDraftVideo getIPlayDraftVideo$lib_search_bigimage_release() {
        return this.iPlayDraftVideo;
    }

    public final void setIPlayDraftVideo$lib_search_bigimage_release(IPlayDraftVideo iPlayDraftVideo2) {
        this.iPlayDraftVideo = iPlayDraftVideo2;
    }

    private final PicsInfoPanelsComp getPicsInfoComp() {
        return (PicsInfoPanelsComp) this.picsInfoComp$delegate.getValue();
    }

    private final CommodityInfoPanelsComp getCommodityInfoComp() {
        return (CommodityInfoPanelsComp) this.commodityInfoComp$delegate.getValue();
    }

    public InfoPanelsViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(InfoPanelsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this)\n            .ge…elsViewModel::class.java)");
        return (InfoPanelsViewModel) viewModel;
    }

    public void onBindViewModel(InfoPanelsViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        bindInfoPanelsInfo(viewModel);
    }

    private final void bindInfoPanelsInfo(InfoPanelsViewModel viewModel) {
        viewModel.getPanelsType$lib_search_bigimage_release().observe(getLifecycleOwner(), new InfoPanelsComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindInfoPanelsInfo$lambda-1  reason: not valid java name */
    public static final void m16195bindInfoPanelsInfo$lambda1(InfoPanelsComp this$0, PanelsType panelsInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.getView();
        ViewGroup $this$bindInfoPanelsInfo_u24lambda_u2d1_u24lambda_u2d0 = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
        if ($this$bindInfoPanelsInfo_u24lambda_u2d1_u24lambda_u2d0 != null) {
            $this$bindInfoPanelsInfo_u24lambda_u2d1_u24lambda_u2d0.removeAllViews();
            if (panelsInfo == PanelsType.Pic || panelsInfo == PanelsType.PicList) {
                $this$bindInfoPanelsInfo_u24lambda_u2d1_u24lambda_u2d0.addView(this$0.getPicsInfoComp().getView());
            } else if (panelsInfo == PanelsType.Commodity) {
                $this$bindInfoPanelsInfo_u24lambda_u2d1_u24lambda_u2d0.addView(this$0.getCommodityInfoComp().getView());
            }
        }
    }
}
