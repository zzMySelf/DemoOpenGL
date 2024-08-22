package com.baidu.searchbox.feed.biserialdetail.content.ad;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.feed.ad.util.FeedAdLogUtil;
import com.baidu.searchbox.feed.base.DefaultViewContext;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.FeedTemplateManager;
import com.baidu.searchbox.feed.base.IFeedTemplate;
import com.baidu.searchbox.feed.base.TplViewCaster;
import com.baidu.searchbox.feed.biserialdetail.content.ad.phoenixnest.PNAdViewFactory;
import com.baidu.searchbox.feed.biserialdetail.content.ad.phoenixnest.view.BasePNAdView;
import com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.BiSerialDynamicAdModel;
import com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.PNAdItem;
import com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.PNAdModel;
import com.baidu.searchbox.feed.biserialdetail.net.phoenixnestad.BiSerialDynamicAdParser;
import com.baidu.searchbox.feed.biserialdetail.ubc.DynamicDetailStatisticsHelper;
import com.baidu.searchbox.feed.controller.FeedDataManager;
import com.baidu.searchbox.feed.controller.PageViewHelper;
import com.baidu.searchbox.feed.controller.TabDataManagerFactory;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.template.FeedAdBaseView;
import com.baidu.searchbox.feed.template.common.ExtraData;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u00042\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/content/ad/DynamicDetailBannerAdManager$requestAd$callback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lcom/baidu/searchbox/feed/biserialdetail/model/phoenixnestad/BiSerialDynamicAdModel;", "handleFeedAd", "", "response", "handlePNAd", "onFail", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "statusCode", "", "parseResponse", "Lokhttp3/Response;", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDetailBannerAdManager.kt */
public final class DynamicDetailBannerAdManager$requestAd$callback$1 extends ResponseCallback<BiSerialDynamicAdModel> {
    final /* synthetic */ DynamicDetailBannerAdManager this$0;

    DynamicDetailBannerAdManager$requestAd$callback$1(DynamicDetailBannerAdManager $receiver) {
        this.this$0 = $receiver;
    }

    public BiSerialDynamicAdModel parseResponse(Response response, int statusCode) {
        boolean z = true;
        if (response == null || !response.isSuccessful()) {
            z = false;
        }
        if (!z) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            DynamicDetailBannerAdManager$requestAd$callback$1 dynamicDetailBannerAdManager$requestAd$callback$1 = this;
            ResponseBody body = response.body();
            byte[] responseBytes = body != null ? body.bytes() : null;
            if (responseBytes == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(responseBytes, "response.body()?.bytes() ?: return null");
            return BiSerialDynamicAdParser.INSTANCE.parse(new String(responseBytes, Charsets.UTF_8));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            if (Result.m8974exceptionOrNullimpl(Result.m8971constructorimpl(ResultKt.createFailure(th2))) != null) {
                return null;
            }
            throw new KotlinNothingValueException();
        }
    }

    public void onSuccess(BiSerialDynamicAdModel response, int statusCode) {
        this.this$0.bannerAdContainer.removeAllViews();
        handlePNAd(response);
        handleFeedAd(response);
        this.this$0.bannerAdContainer.post(new DynamicDetailBannerAdManager$requestAd$callback$1$$ExternalSyntheticLambda5(this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-2  reason: not valid java name */
    public static final void m18523onSuccess$lambda2(DynamicDetailBannerAdManager this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        if (this$02.bannerAdContainer.getChildCount() > 0) {
            this$02.handleAdShow();
        } else {
            this$02.handleAdHide();
        }
    }

    private final void handlePNAd(BiSerialDynamicAdModel response) {
        PNAdModel it;
        PNAdItem adItem;
        if (response != null && (it = response.getPnAdModel()) != null) {
            DynamicDetailBannerAdManager dynamicDetailBannerAdManager = this.this$0;
            BasePNAdView pnAdView = PNAdViewFactory.INSTANCE.createPNAdView(it, dynamicDetailBannerAdManager.context);
            if (pnAdView != null) {
                dynamicDetailBannerAdManager.bannerAdContainer.addView(pnAdView);
                List<PNAdItem> ads = it.getAds();
                if (ads != null && (adItem = (PNAdItem) CollectionsKt.getOrNull(ads, 0)) != null) {
                    dynamicDetailBannerAdManager.pnAdItem = adItem;
                    pnAdView.setOnClickListener(new DynamicDetailBannerAdManager$requestAd$callback$1$$ExternalSyntheticLambda0(dynamicDetailBannerAdManager, adItem));
                    dynamicDetailBannerAdManager.pnBannerAdView = pnAdView;
                    dynamicDetailBannerAdManager.bannerAdContainer.post(new DynamicDetailBannerAdManager$requestAd$callback$1$$ExternalSyntheticLambda1(dynamicDetailBannerAdManager));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePNAd$lambda-5$lambda-3  reason: not valid java name */
    public static final void m18521handlePNAd$lambda5$lambda3(DynamicDetailBannerAdManager this$02, PNAdItem $adItem, View view2) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter($adItem, "$adItem");
        FeedRouter.invoke(this$02.context, $adItem.getAdSkipUrl(), false);
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePNAd$lambda-5$lambda-4  reason: not valid java name */
    public static final void m18522handlePNAd$lambda5$lambda4(DynamicDetailBannerAdManager this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        if (this$02.isPnBannerAdShowing()) {
            this$02.reportPnAdShow();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r4 = r4.ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleFeedAd(com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.BiSerialDynamicAdModel r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0050
            com.baidu.searchbox.feed.model.FeedFlowModel r0 = r7.getFeedAdModel()
            if (r0 == 0) goto L_0x0050
            com.baidu.searchbox.feed.biserialdetail.content.ad.DynamicDetailBannerAdManager r1 = r6.this$0
            r2 = 0
            java.util.ArrayList<com.baidu.searchbox.feed.model.FeedBaseModel> r3 = r0.feedBaseModelList
            if (r3 == 0) goto L_0x004f
            java.lang.String r4 = "feedBaseModelList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            java.lang.Object r3 = kotlin.collections.CollectionsKt.getOrNull(r3, r4)
            com.baidu.searchbox.feed.model.FeedBaseModel r3 = (com.baidu.searchbox.feed.model.FeedBaseModel) r3
            if (r3 != 0) goto L_0x0020
            goto L_0x004f
        L_0x0020:
            com.baidu.searchbox.feed.model.FeedItemData r4 = r3.data
            if (r4 == 0) goto L_0x002b
            com.baidu.searchbox.feed.ad.model.AdModuleData r4 = r4.ad
            if (r4 == 0) goto L_0x002b
            com.baidu.searchbox.feed.model.FeedAdData r4 = r4.feed
            goto L_0x002c
        L_0x002b:
            r4 = 0
        L_0x002c:
            if (r4 != 0) goto L_0x002f
            goto L_0x0032
        L_0x002f:
            r5 = 1
            r4.isDynamicDetailBannerAd = r5
        L_0x0032:
            r1.bannerAdModel = r3
            com.baidu.searchbox.feed.model.FeedItemData r4 = r3.data
            boolean r4 = com.baidu.searchbox.feed.ad.util.FeedAdUtil.isEmptyOrder(r4)
            if (r4 != 0) goto L_0x004a
            android.widget.LinearLayout r4 = r1.bannerAdContainer
            com.baidu.searchbox.feed.biserialdetail.content.ad.DynamicDetailBannerAdManager$requestAd$callback$1$$ExternalSyntheticLambda4 r5 = new com.baidu.searchbox.feed.biserialdetail.content.ad.DynamicDetailBannerAdManager$requestAd$callback$1$$ExternalSyntheticLambda4
            r5.<init>(r3, r1)
            r4.post(r5)
            goto L_0x004d
        L_0x004a:
            r1.reportAdShow()
        L_0x004d:
            goto L_0x0050
        L_0x004f:
            return
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.biserialdetail.content.ad.DynamicDetailBannerAdManager$requestAd$callback$1.handleFeedAd(com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.BiSerialDynamicAdModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFeedAd$lambda-9$lambda-8  reason: not valid java name */
    public static final void m18518handleFeedAd$lambda9$lambda8(FeedBaseModel $model, DynamicDetailBannerAdManager this$02) {
        Intrinsics.checkNotNullParameter($model, "$model");
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        IFeedTemplate iFeedTemplate = FeedTemplateManager.SERVICE.getFeedTemplate((CharSequence) $model.layout);
        Intrinsics.checkNotNullExpressionValue(iFeedTemplate, "SERVICE.getFeedTemplate(model.layout)");
        FeedTemplate feedTemplate = (FeedTemplate) iFeedTemplate.createItemView(new DefaultViewContext("").setContext(this$02.context));
        if (feedTemplate != null) {
            feedTemplate.update($model, new ExtraData());
        }
        if (feedTemplate != null) {
            feedTemplate.applyRoundUiPolicy();
        }
        View view2 = TplViewCaster.castToView(feedTemplate);
        if (view2 instanceof FeedAdBaseView) {
            ((FeedAdBaseView) view2).setOnClickListener(new DynamicDetailBannerAdManager$requestAd$callback$1$$ExternalSyntheticLambda2(this$02, $model, feedTemplate));
            if (this$02.bannerAdContainer.getChildCount() > 0) {
                this$02.addAdDivider();
            }
            this$02.bannerAdContainer.addView(view2);
            this$02.bannerAdView = (FeedAdBaseView) view2;
            this$02.bannerAdContainer.post(new DynamicDetailBannerAdManager$requestAd$callback$1$$ExternalSyntheticLambda3(this$02));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFeedAd$lambda-9$lambda-8$lambda-6  reason: not valid java name */
    public static final void m18519handleFeedAd$lambda9$lambda8$lambda6(DynamicDetailBannerAdManager this$02, FeedBaseModel $model, FeedTemplate $feedTemplate, View it) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter($model, "$model");
        FeedDataManager dataManager = TabDataManagerFactory.getDataManager("1");
        PageViewHelper.handleCmdAction(this$02.context, dataManager, $model, $feedTemplate, (Intent) null, false);
        FeedAdLogUtil.reportAdClick(dataManager, this$02.context, $model, (String) null);
        DynamicDetailStatisticsHelper access$getUbsHelper$p = this$02.ubsHelper;
        if (access$getUbsHelper$p != null) {
            access$getUbsHelper$p.bannerAdClick($model, this$02.dynamicModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFeedAd$lambda-9$lambda-8$lambda-7  reason: not valid java name */
    public static final void m18520handleFeedAd$lambda9$lambda8$lambda7(DynamicDetailBannerAdManager this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        if (this$02.isBannerAdShowing()) {
            this$02.reportAdShow();
        }
    }

    public void onFail(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.this$0.handleAdHide();
    }
}
