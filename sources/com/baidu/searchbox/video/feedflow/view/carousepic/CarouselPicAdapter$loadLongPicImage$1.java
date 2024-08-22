package com.baidu.searchbox.video.feedflow.view.carousepic;

import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.video.feedflow.view.carousepic.gesture.view.large.SupportLargeDraweeView;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0007H\u0014J\u001c\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0007H\u0014¨\u0006\n"}, d2 = {"com/baidu/searchbox/video/feedflow/view/carousepic/CarouselPicAdapter$loadLongPicImage$1", "Lcom/facebook/datasource/BaseDataSubscriber;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "onFailureImpl", "", "failure", "Lcom/facebook/datasource/DataSource;", "onNewResultImpl", "dataSource", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselPicAdapter.kt */
public final class CarouselPicAdapter$loadLongPicImage$1 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    final /* synthetic */ LongPicViewHolder $holder;
    final /* synthetic */ CarouselPicModel $imageModel;
    final /* synthetic */ SupportLargeDraweeView $imageView;
    final /* synthetic */ BdShimmerView $loadingView;
    final /* synthetic */ CarouselPicAdapter this$0;

    CarouselPicAdapter$loadLongPicImage$1(CarouselPicAdapter $receiver, LongPicViewHolder $holder2, CarouselPicModel $imageModel2, BdShimmerView $loadingView2, SupportLargeDraweeView $imageView2) {
        this.this$0 = $receiver;
        this.$holder = $holder2;
        this.$imageModel = $imageModel2;
        this.$loadingView = $loadingView2;
        this.$imageView = $imageView2;
    }

    /* access modifiers changed from: protected */
    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.this$0.loadLocalFileCache(this.$holder, this.$imageModel);
    }

    /* access modifiers changed from: protected */
    public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> failure) {
        Function2<CarouselPicModel, Boolean, Unit> onCarouselPicLoadResult;
        Intrinsics.checkNotNullParameter(failure, "failure");
        this.this$0.hideLoading(this.$loadingView, this.$imageView);
        this.$imageModel.setLoadSuccess(false);
        CarouselPicView picView = this.this$0.getPicView();
        if (picView != null && (onCarouselPicLoadResult = picView.getOnCarouselPicLoadResult()) != null) {
            onCarouselPicLoadResult.invoke(this.$imageModel, false);
        }
    }
}
