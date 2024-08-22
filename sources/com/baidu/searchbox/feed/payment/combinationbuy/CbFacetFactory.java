package com.baidu.searchbox.feed.payment.combinationbuy;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/feed/payment/combinationbuy/CbFacetFactory;", "", "createHeaderFacet", "Lcom/baidu/searchbox/feed/payment/combinationbuy/CbHeaderFacet;", "cbContext", "Lcom/baidu/searchbox/feed/payment/combinationbuy/CombinationBuyContext;", "createListFacet", "Lcom/baidu/searchbox/feed/payment/combinationbuy/CbListFacet;", "createPayTipsFacet", "Lcom/baidu/searchbox/feed/payment/combinationbuy/CbPayTipsFacet;", "createProToolBarFacet", "Lcom/baidu/searchbox/feed/payment/combinationbuy/CbProToolBarFacet;", "createToolBarFacet", "Lcom/baidu/searchbox/feed/payment/combinationbuy/CbToolBarFacet;", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CbFacetFactory.kt */
public interface CbFacetFactory {
    CbHeaderFacet createHeaderFacet(CombinationBuyContext combinationBuyContext);

    CbListFacet createListFacet(CombinationBuyContext combinationBuyContext);

    CbPayTipsFacet createPayTipsFacet(CombinationBuyContext combinationBuyContext);

    CbProToolBarFacet createProToolBarFacet(CombinationBuyContext combinationBuyContext);

    CbToolBarFacet createToolBarFacet(CombinationBuyContext combinationBuyContext);
}
