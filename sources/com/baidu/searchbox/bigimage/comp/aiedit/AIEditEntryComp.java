package com.baidu.searchbox.bigimage.comp.aiedit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.comp.aiedit.model.AIEditInfoModel;
import com.baidu.searchbox.bigimage.comp.aiedit.view.AIEditEntryButton;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.root.ImageInvokeParams;
import com.baidu.searchbox.bigimage.model.BigImageAsset;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0016J\u001c\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u000eH\u0016J\u001c\u0010,\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u000eH\u0007J\u0017\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0002\u00102J\u0016\u00103\u001a\u00020\u001b2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002J\b\u00107\u001a\u00020\u001bH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00060\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00068"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/aiedit/AIEditEntryComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/bigimage/comp/aiedit/AIEditEntryVM;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;)V", "entryButtonList", "", "Lcom/baidu/searchbox/bigimage/comp/aiedit/view/AIEditEntryButton;", "entryLayout", "kotlin.jvm.PlatformType", "value", "", "isFuncRootVisible", "()Z", "setFuncRootVisible", "(Z)V", "needShowStat", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "params", "getParams", "()Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "setParams", "(Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;)V", "addEntryToParent", "", "parent", "Landroid/view/ViewGroup;", "clearEntryParent", "onBindViewModel", "viewModel", "onCreateViewModel", "onFontSizeChange", "info", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "onImageSelected", "invokeParams", "Lcom/baidu/searchbox/bigimage/comp/root/ImageInvokeParams;", "imageInfo", "Lcom/baidu/searchbox/bigimage/model/BigImageAsset;", "onNightModeChange", "isNightMode", "onShowStat", "showOrDismissIfSupport", "show", "updateEntry", "showEntry", "", "(Ljava/lang/Integer;)V", "updateEntryButton", "infoModelList", "", "Lcom/baidu/searchbox/bigimage/comp/aiedit/model/AIEditInfoModel;", "updateEntryLayoutVisibility", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIEditEntryComp.kt */
public final class AIEditEntryComp extends BaseExtSlaveComponent<AIEditEntryVM> {
    private final List<AIEditEntryButton> entryButtonList = new ArrayList();
    private final View entryLayout = LayoutInflater.from(getContext()).inflate(R.layout.ai_edit_entry, (ViewGroup) null, false);
    private boolean isFuncRootVisible;
    private boolean needShowStat;
    private ImagePageParams params;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AIEditEntryComp(LifecycleOwner owner, View view2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        onFontSizeChange(FontSizeInfo.Companion.getInfo());
    }

    public final ImagePageParams getParams() {
        return this.params;
    }

    public final void setParams(ImagePageParams value) {
        this.params = value;
        ((AIEditEntryVM) getViewModel()).updateData(value);
    }

    public final boolean isFuncRootVisible() {
        return this.isFuncRootVisible;
    }

    public final void setFuncRootVisible(boolean value) {
        this.isFuncRootVisible = value;
        ImagePageParams imagePageParams = this.params;
        BigImageAsset bigImageAsset = null;
        ImageInvokeParams invokeParams = imagePageParams != null ? imagePageParams.getInvokeParams() : null;
        ImagePageParams imagePageParams2 = this.params;
        if (imagePageParams2 != null) {
            bigImageAsset = imagePageParams2.getImageInfo();
        }
        onShowStat(invokeParams, bigImageAsset);
    }

    public final void showOrDismissIfSupport(boolean show) {
        AIEditEntryVM aIEditEntryVM = (AIEditEntryVM) getViewModel();
        ImagePageParams imagePageParams = this.params;
        BigImageAsset bigImageAsset = null;
        boolean supportAIEditEntry = aIEditEntryVM.supportAIEditEntry(imagePageParams != null ? imagePageParams.getImageInfo() : null);
        int i2 = 4;
        if (supportAIEditEntry) {
            View view2 = this.entryLayout;
            if (show) {
                i2 = 0;
            }
            view2.setVisibility(i2);
        } else {
            this.entryLayout.setVisibility(4);
        }
        ImagePageParams imagePageParams2 = this.params;
        ImageInvokeParams invokeParams = imagePageParams2 != null ? imagePageParams2.getInvokeParams() : null;
        ImagePageParams imagePageParams3 = this.params;
        if (imagePageParams3 != null) {
            bigImageAsset = imagePageParams3.getImageInfo();
        }
        onShowStat(invokeParams, bigImageAsset);
    }

    public final void onImageSelected(ImageInvokeParams invokeParams, BigImageAsset imageInfo) {
        this.needShowStat = true;
        onShowStat(invokeParams, imageInfo);
    }

    private final void onShowStat(ImageInvokeParams invokeParams, BigImageAsset imageInfo) {
        if (this.needShowStat && ((AIEditEntryVM) getViewModel()).supportAIEditEntry(imageInfo) && this.isFuncRootVisible && this.entryLayout.getVisibility() == 0) {
            AIEditStatUtilKt.onAIBtShowStat(invokeParams, imageInfo);
            this.needShowStat = false;
        }
    }

    public AIEditEntryVM onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(AIEditEntryVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(AIEditEntryVM::class.java)");
        return (AIEditEntryVM) viewModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewModel$lambda-0  reason: not valid java name */
    public static final void m16123onBindViewModel$lambda0(AIEditEntryComp this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateEntry(it);
    }

    public void onBindViewModel(AIEditEntryVM viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        viewModel.getShowEntry().observe(owner, new AIEditEntryComp$$ExternalSyntheticLambda0(this));
        viewModel.getEntryButtonList().observe(owner, new AIEditEntryComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewModel$lambda-1  reason: not valid java name */
    public static final void m16124onBindViewModel$lambda1(AIEditEntryComp this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null) {
            this$0.updateEntryButton(it);
        }
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        for (AIEditEntryButton it : this.entryButtonList) {
            it.onNightModeChange(isNightMode);
        }
    }

    private final void updateEntry(Integer showEntry) {
        if (showEntry != null && showEntry.intValue() == 1) {
            FrameLayout frameLayout = (FrameLayout) getView().findViewById(R.id.aiEditEntryBottom);
            Intrinsics.checkNotNullExpressionValue(frameLayout, "view.aiEditEntryBottom");
            addEntryToParent(frameLayout);
            FrameLayout frameLayout2 = (FrameLayout) getView().findViewById(R.id.aiEditEntryTop);
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "view.aiEditEntryTop");
            clearEntryParent(frameLayout2);
            updateEntryLayoutVisibility();
        } else if (showEntry != null && showEntry.intValue() == 2) {
            FrameLayout frameLayout3 = (FrameLayout) getView().findViewById(R.id.aiEditEntryTop);
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "view.aiEditEntryTop");
            addEntryToParent(frameLayout3);
            FrameLayout frameLayout4 = (FrameLayout) getView().findViewById(R.id.aiEditEntryBottom);
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "view.aiEditEntryBottom");
            clearEntryParent(frameLayout4);
            updateEntryLayoutVisibility();
        } else {
            FrameLayout frameLayout5 = (FrameLayout) getView().findViewById(R.id.aiEditEntryBottom);
            Intrinsics.checkNotNullExpressionValue(frameLayout5, "view.aiEditEntryBottom");
            clearEntryParent(frameLayout5);
            FrameLayout frameLayout6 = (FrameLayout) getView().findViewById(R.id.aiEditEntryTop);
            Intrinsics.checkNotNullExpressionValue(frameLayout6, "view.aiEditEntryTop");
            clearEntryParent(frameLayout6);
        }
    }

    private final void updateEntryLayoutVisibility() {
        this.entryLayout.setVisibility(this.isFuncRootVisible ? 0 : 4);
    }

    private final void updateEntryButton(List<AIEditInfoModel> infoModelList) {
        View view2 = this.entryLayout;
        LinearLayout entryRoot = view2 instanceof LinearLayout ? (LinearLayout) view2 : null;
        if (entryRoot != null) {
            entryRoot.removeAllViews();
            this.entryButtonList.clear();
            int index = 0;
            for (Object item$iv : infoModelList) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                AIEditInfoModel info = (AIEditInfoModel) item$iv;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                AIEditEntryButton button = new AIEditEntryButton(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMarginStart(index > 0 ? AIEditEntryCompKt.getEDIT_BUTTON_SPACE() : 0);
                button.updateModel(info);
                button.setOnClickListener(new AIEditEntryComp$updateEntryButton$1$1(this, info));
                entryRoot.addView(button, layoutParams);
                this.entryButtonList.add(button);
                index = index$iv;
            }
        }
    }

    private final void addEntryToParent(ViewGroup parent) {
        ViewGroup $this$addEntryToParent_u24lambda_u2d5 = parent;
        $this$addEntryToParent_u24lambda_u2d5.removeAllViews();
        ViewParent parent2 = this.entryLayout.getParent();
        ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.entryLayout);
        }
        $this$addEntryToParent_u24lambda_u2d5.addView(this.entryLayout, -2, -2);
        $this$addEntryToParent_u24lambda_u2d5.setVisibility(0);
    }

    private final void clearEntryParent(ViewGroup parent) {
        ViewGroup $this$clearEntryParent_u24lambda_u2d6 = parent;
        $this$clearEntryParent_u24lambda_u2d6.removeAllViews();
        $this$clearEntryParent_u24lambda_u2d6.setVisibility(8);
    }

    public void onFontSizeChange(FontSizeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onFontSizeChange(info);
        for (AIEditEntryButton it : this.entryButtonList) {
            it.onFontSizeChange(info);
        }
    }
}
