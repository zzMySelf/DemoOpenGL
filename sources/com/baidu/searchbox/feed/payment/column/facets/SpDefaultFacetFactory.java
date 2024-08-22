package com.baidu.searchbox.feed.payment.column.facets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/facets/SpDefaultFacetFactory;", "Lcom/baidu/searchbox/feed/payment/column/facets/SpFacetFactory;", "()V", "createBackToolBarFacet", "Lcom/baidu/searchbox/feed/payment/column/facets/SpBackToolBarFacet;", "spColumnContext", "Lcom/baidu/searchbox/feed/payment/column/facets/SpColumnContext;", "createBottomGuideBarFacet", "Lcom/baidu/searchbox/feed/payment/column/facets/SpBottomGuideBarFacet;", "createCombinationBuyGuideFacet", "Lcom/baidu/searchbox/feed/payment/column/facets/SpCombinationBuyGuideFacet;", "createFloatingLocatingFacet", "Lcom/baidu/searchbox/feed/payment/column/facets/SpFloatingLocatingFacet;", "createPayStateViewFacet", "Lcom/baidu/searchbox/feed/payment/column/facets/SpPayStateViewFacet;", "spTitlePaneContext", "Lcom/baidu/searchbox/feed/payment/column/facets/SpTitlePaneContext;", "createPresentDialogComponent", "Lcom/baidu/searchbox/feed/payment/column/facets/SpPresentDialogFacet;", "createStateLayerFacet", "Lcom/baidu/searchbox/feed/payment/column/facets/SpStateLayerFacet;", "createTabPagerFacet", "Lcom/baidu/searchbox/feed/payment/column/facets/SpTabPagerFacet;", "createTitlePaneFacet", "Lcom/baidu/searchbox/feed/payment/column/facets/SpTitlePaneFacet;", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpFacetFactory.kt */
public class SpDefaultFacetFactory implements SpFacetFactory {
    public SpStateLayerFacet createStateLayerFacet(SpColumnContext spColumnContext) {
        Intrinsics.checkNotNullParameter(spColumnContext, "spColumnContext");
        return new SpStateLayerFacet(spColumnContext);
    }

    public SpBackToolBarFacet createBackToolBarFacet(SpColumnContext spColumnContext) {
        Intrinsics.checkNotNullParameter(spColumnContext, "spColumnContext");
        return new SpBackToolBarFacet(spColumnContext);
    }

    public SpTabPagerFacet createTabPagerFacet(SpColumnContext spColumnContext) {
        Intrinsics.checkNotNullParameter(spColumnContext, "spColumnContext");
        return new SpTabPagerFacet(spColumnContext);
    }

    public SpTitlePaneFacet createTitlePaneFacet(SpColumnContext spColumnContext) {
        Intrinsics.checkNotNullParameter(spColumnContext, "spColumnContext");
        return new SpTitlePaneFacet(spColumnContext);
    }

    public SpPresentDialogFacet createPresentDialogComponent(SpColumnContext spColumnContext) {
        Intrinsics.checkNotNullParameter(spColumnContext, "spColumnContext");
        return new SpPresentDialogFacet(spColumnContext);
    }

    public SpPayStateViewFacet createPayStateViewFacet(SpTitlePaneContext spTitlePaneContext) {
        Intrinsics.checkNotNullParameter(spTitlePaneContext, "spTitlePaneContext");
        return new SpPayStateViewFacet(spTitlePaneContext);
    }

    public SpFloatingLocatingFacet createFloatingLocatingFacet(SpColumnContext spColumnContext) {
        Intrinsics.checkNotNullParameter(spColumnContext, "spColumnContext");
        return new SpFloatingLocatingFacet(spColumnContext);
    }

    public SpCombinationBuyGuideFacet createCombinationBuyGuideFacet(SpColumnContext spColumnContext) {
        Intrinsics.checkNotNullParameter(spColumnContext, "spColumnContext");
        return new SpCombinationBuyGuideFacet(spColumnContext);
    }

    public SpBottomGuideBarFacet createBottomGuideBarFacet(SpColumnContext spColumnContext) {
        Intrinsics.checkNotNullParameter(spColumnContext, "spColumnContext");
        return new SpBottomGuideBarFacet(spColumnContext);
    }
}
