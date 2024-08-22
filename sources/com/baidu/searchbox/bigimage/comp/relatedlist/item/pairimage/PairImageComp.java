package com.baidu.searchbox.bigimage.comp.relatedlist.item.pairimage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.ioc.IImageNightMode;
import com.baidu.searchbox.bigimage.utils.BigImageUtils;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemComponent;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.nacomp.extension.widget.GridSpaceItemDecoration;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/relatedlist/item/pairimage/PairImageComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemComponent;", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/item/pairimage/PairImageData;", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/item/pairimage/PairImageViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "adapter", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/item/pairimage/PairImageAdapter;", "itemClickCallback", "Lkotlin/Function1;", "", "", "itemDecoration", "Lcom/baidu/searchbox/nacomp/extension/widget/GridSpaceItemDecoration;", "itemSpace", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "title", "Landroid/widget/TextView;", "titleArrow", "Landroid/widget/ImageView;", "bindColumn", "viewModel", "bindImageList", "bindTitle", "onBindViewModel", "onCreateView", "onCreateViewModel", "onFontSizeChange", "info", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "onNightModeChange", "isNightMode", "", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PairImageComp.kt */
public final class PairImageComp extends BaseExtItemComponent<PairImageData, PairImageViewModel> {
    private final PairImageAdapter adapter;
    private final Function1<Integer, Unit> itemClickCallback;
    private GridSpaceItemDecoration itemDecoration;
    private final int itemSpace = ViewExKt.getDp(3);
    private final RecyclerView recyclerView;
    private final TextView title;
    private final ImageView titleArrow;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PairImageComp(LifecycleOwner owner, View view2, UniqueId token) {
        super(owner, view2);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        this.title = (TextView) view2.findViewById(R.id.title);
        this.titleArrow = (ImageView) view2.findViewById(R.id.title_arrow);
        PairImageAdapter pairImageAdapter = new PairImageAdapter(token);
        this.adapter = pairImageAdapter;
        RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(R.id.pair_image_rv);
        RecyclerView $this$recyclerView_u24lambda_u2d0 = recyclerView2;
        $this$recyclerView_u24lambda_u2d0.setNestedScrollingEnabled(false);
        $this$recyclerView_u24lambda_u2d0.setLayoutManager(new GridLayoutManager($this$recyclerView_u24lambda_u2d0.getContext(), 3));
        $this$recyclerView_u24lambda_u2d0.setAdapter(pairImageAdapter);
        $this$recyclerView_u24lambda_u2d0.setOutlineProvider(new PairImageComp$recyclerView$1$outline$1($this$recyclerView_u24lambda_u2d0));
        $this$recyclerView_u24lambda_u2d0.setClipToOutline(true);
        this.recyclerView = recyclerView2;
        this.itemClickCallback = new PairImageComp$itemClickCallback$1(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m16404onCreateView$lambda1(PairImageComp this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ((PairImageViewModel) this$0.getViewModel()).jumpToShitu(context, 0, true);
    }

    public void onCreateView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        ((TextView) view2.findViewById(R.id.title)).setOnClickListener(new PairImageComp$$ExternalSyntheticLambda0(this));
        ((ImageView) view2.findViewById(R.id.title_arrow)).setOnClickListener(new PairImageComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-2  reason: not valid java name */
    public static final void m16405onCreateView$lambda2(PairImageComp this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ((PairImageViewModel) this$0.getViewModel()).jumpToShitu(context, 0, true);
    }

    public PairImageViewModel onCreateViewModel() {
        return new PairImageViewModel();
    }

    public void onNightModeChange(boolean isNightMode) {
        getView().setBackground(BigImageUtils.getCardBg$default(BigImageUtils.INSTANCE, 0, 1, (Object) null));
        IImageNightMode.Companion.getImpl().setTextColor(this.title, R.color.SC2);
        ImageView imageView = this.titleArrow;
        IImageNightMode impl = IImageNightMode.Companion.getImpl();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FontSizeImageViewExtKt.setScaledImageDrawable$default(imageView, 3, impl.getDrawable(context, R.drawable.search_big_image_pair_image_title_arrow), 0, 4, (Object) null);
    }

    public void onBindViewModel(PairImageViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel(viewModel, owner);
        bindTitle(viewModel, owner);
        bindColumn(viewModel, owner);
        bindImageList(viewModel, owner);
    }

    private final void bindTitle(PairImageViewModel viewModel, LifecycleOwner owner) {
        viewModel.getTitle().observe(owner, new PairImageComp$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindTitle$lambda-3  reason: not valid java name */
    public static final void m16403bindTitle$lambda3(PairImageComp this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.title;
        CharSequence charSequence = it;
        int i2 = 0;
        if (charSequence == null || charSequence.length() == 0) {
            i2 = 8;
        } else {
            this$0.title.setText(it);
        }
        textView.setVisibility(i2);
    }

    private final void bindColumn(PairImageViewModel viewModel, LifecycleOwner owner) {
        viewModel.getColumn().observe(owner, new PairImageComp$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindColumn$lambda-7  reason: not valid java name */
    public static final void m16401bindColumn$lambda7(PairImageComp this$0, Integer it) {
        int column;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null && (column = it.intValue()) > 0) {
            RecyclerView.LayoutManager layoutManager = this$0.recyclerView.getLayoutManager();
            if (layoutManager != null) {
                ((GridLayoutManager) layoutManager).setSpanCount(column);
                GridSpaceItemDecoration $this$bindColumn_u24lambda_u2d7_u24lambda_u2d6_u24lambda_u2d4 = this$0.itemDecoration;
                if ($this$bindColumn_u24lambda_u2d7_u24lambda_u2d6_u24lambda_u2d4 != null) {
                    this$0.recyclerView.removeItemDecoration($this$bindColumn_u24lambda_u2d7_u24lambda_u2d6_u24lambda_u2d4);
                }
                GridSpaceItemDecoration $this$bindColumn_u24lambda_u2d7_u24lambda_u2d6_u24lambda_u2d5 = new GridSpaceItemDecoration(column, this$0.itemSpace, 0, false);
                this$0.recyclerView.addItemDecoration($this$bindColumn_u24lambda_u2d7_u24lambda_u2d6_u24lambda_u2d5);
                this$0.itemDecoration = $this$bindColumn_u24lambda_u2d7_u24lambda_u2d6_u24lambda_u2d5;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        }
    }

    private final void bindImageList(PairImageViewModel viewModel, LifecycleOwner owner) {
        viewModel.getLinkData().observe(owner, new PairImageComp$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindImageList$lambda-9  reason: not valid java name */
    public static final void m16402bindImageList$lambda9(PairImageComp this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null) {
            this$0.adapter.setData(it, this$0.itemClickCallback);
        }
    }

    public void onFontSizeChange(FontSizeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onFontSizeChange(info);
        FontSizeExtKt.updateTextSize$default(this.title, 0, 1, (Object) null);
        FontSizeExtKt.updatePadding$default(this.title, 0, 1, (Object) null);
        ImageView imageView = this.titleArrow;
        IImageNightMode impl = IImageNightMode.Companion.getImpl();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FontSizeImageViewExtKt.setScaledImageDrawable$default(imageView, 3, impl.getDrawable(context, R.drawable.search_big_image_pair_image_title_arrow), 0, 4, (Object) null);
    }
}
