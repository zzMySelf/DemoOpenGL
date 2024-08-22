package com.baidu.searchbox.feed.payment.column.viewmodel;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.feed.config.FeedUrlConfig;
import com.baidu.searchbox.feed.container.creator.PageParams;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.comment.FeedCommentInputDialogKt;
import com.baidu.searchbox.feed.payment.core.model.PayInfo;
import com.baidu.searchbox.feed.payment.model.CommentInfo;
import com.baidu.searchbox.feed.payment.model.PayRequestException;
import com.baidu.searchbox.feed.payment.model.PayServerTransit;
import com.baidu.searchbox.feed.payment.model.RnInfo;
import com.baidu.searchbox.feed.payment.model.SimpleResponse;
import com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData;
import com.baidu.searchbox.feed.payment.model.SpColumnDetailData;
import com.baidu.searchbox.feed.payment.model.SpColumnDetailDataKt;
import com.baidu.searchbox.feed.payment.model.SpColumnPresentData;
import com.baidu.searchbox.feed.payment.model.SpCommentLabelItemData;
import com.baidu.searchbox.feed.payment.model.SpDetailButtonInfo;
import com.baidu.searchbox.feed.payment.model.SpDetailPayInfo;
import com.baidu.searchbox.feed.payment.model.SpDetailShareInfo;
import com.baidu.searchbox.feed.payment.model.SpDetailSubscribeInfo;
import com.baidu.searchbox.feed.payment.model.SpDetailTabInfo;
import com.baidu.searchbox.feed.payment.model.SpOldCommentItemData;
import com.baidu.searchbox.feed.payment.model.Trial;
import com.baidu.searchbox.feed.payment.utils.Event;
import com.baidu.searchbox.feed.payment.utils.PayRequestWrapper;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.feed.tab.update.Tabs;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.feed.util.Preconditions;
import com.baidu.searchbox.socialshare.bean.BaiduShareContent;
import com.baidu.searchbox.socialshare.bean.MediaType;
import com.baidu.searchbox.socialshare.statistics.SharePageEnum;
import com.baidu.swan.games.keyboardmanage.KeyboardApi;
import com.google.gson.Gson;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u00020-H\u0002J\u000e\u0010.\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010/\u001a\u00020\u001bJ\u000e\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202J\b\u00103\u001a\u0004\u0018\u000104J\u0010\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u000207H\u0002J\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109J\u0006\u0010;\u001a\u00020\u0006J\b\u0010<\u001a\u0004\u0018\u00010=J\u001a\u0010>\u001a\u0016\u0012\u0004\u0012\u00020@\u0018\u00010?j\n\u0012\u0004\u0012\u00020@\u0018\u0001`AJ\u0006\u0010B\u001a\u000207J\b\u0010C\u001a\u0004\u0018\u00010\u0006J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000609J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020\u0006J\u0006\u0010H\u001a\u00020\u0006J\u0006\u0010I\u001a\u00020\u0006J\u0006\u0010J\u001a\u00020\u0006J\u0006\u0010K\u001a\u00020\u0006J\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000609J\u0006\u0010M\u001a\u00020\u0006J\u0006\u0010N\u001a\u00020\u0006J\b\u0010O\u001a\u0004\u0018\u00010PJ\u0006\u0010Q\u001a\u00020\u0006J\u0006\u0010R\u001a\u000202J\b\u0010S\u001a\u0004\u0018\u00010\u0006J\u001a\u0010T\u001a\u00020\u00062\b\u0010U\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010V\u001a\u00020\u0006J\u0006\u0010W\u001a\u00020\u0006J\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Y09J\u0006\u0010Z\u001a\u00020\u0006J\u0006\u0010[\u001a\u00020\\J\u0006\u0010]\u001a\u00020\u0006J\b\u0010^\u001a\u0004\u0018\u00010\u0006J\u000e\u0010_\u001a\u00020-2\u0006\u0010`\u001a\u00020aJ\u0016\u0010b\u001a\u00020-2\u0006\u0010c\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020\u001bJ\u0006\u0010e\u001a\u00020\u001bJ\u0006\u0010f\u001a\u00020\u001bJ\u0006\u0010g\u001a\u00020\u001bJ\u0006\u0010h\u001a\u00020\u001bJ\u0006\u0010i\u001a\u00020\u001bJ\u0006\u0010j\u001a\u00020\u001bJ\u0006\u0010k\u001a\u00020\u001bJ\u000e\u0010l\u001a\u00020-2\u0006\u0010m\u001a\u00020aJ\u0006\u0010n\u001a\u00020\u001bJ\u0006\u0010o\u001a\u00020\u001bJ\u0006\u0010p\u001a\u00020\u001bJ\u0006\u0010q\u001a\u00020\u001bJ\u0006\u0010r\u001a\u00020\u001bJ\u0006\u0010s\u001a\u00020\u001bJ\u0006\u0010t\u001a\u00020\u001bJ\u0006\u0010u\u001a\u00020\u001bJ\u000e\u0010v\u001a\u00020\u001b2\u0006\u0010w\u001a\u00020YJ\u0006\u0010x\u001a\u00020\u001bJ\u0006\u0010y\u001a\u00020\u001bJ\u0006\u0010z\u001a\u00020\u001bJ\u0006\u0010{\u001a\u00020\u001bJ\u0006\u0010|\u001a\u00020\u001bJ\u0006\u0010}\u001a\u00020\u001bJ\u0006\u0010~\u001a\u00020\u001bJ\u0006\u0010\u001a\u00020\u001bJ\u0007\u0010\u0001\u001a\u00020\u001bJ\u0007\u0010\u0001\u001a\u00020\u001bJ\u0007\u0010\u0001\u001a\u00020\u001bJ\u0007\u0010\u0001\u001a\u00020\u001bJ\u0007\u0010\u0001\u001a\u00020\u001bJ&\u0010\u0001\u001a\u00020-2\u0006\u0010U\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u00012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0006J\u0019\u0010\u0001\u001a\u00020-2\u0006\u0010U\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u0001J\u0007\u0010\u0001\u001a\u00020\u0006J\b\u0010\u0001\u001a\u00030\u0001J\u0016\u0010\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001J%\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020\u001bJ\u0007\u0010\u0001\u001a\u00020\u0006J\u000f\u0010\u0001\u001a\u0004\u0018\u00010-¢\u0006\u0003\u0010\u0001J+\u0010\u0001\u001a\u00020-2\u0017\u0010\u0001\u001a\u0012\u0012\u0004\u0012\u00020Y0?j\b\u0012\u0004\u0012\u00020Y`A2\u0007\u0010\u0001\u001a\u00020\u0010H\u0002J\u0007\u0010\u0001\u001a\u00020\u001bJ\t\u0010\u0001\u001a\u00020-H\u0016J\u001b\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u001bH\u0002J\u0007\u0010\u0001\u001a\u00020-J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010 \u0001\u001a\u00020-J\u0007\u0010¡\u0001\u001a\u00020\u001bJ1\u0010¢\u0001\u001a\u00020-2(\u0010£\u0001\u001a#\u0012\u0016\u0012\u00140\u001b¢\u0006\u000f\b¥\u0001\u0012\n\b¦\u0001\u0012\u0005\b\b(§\u0001\u0012\u0004\u0012\u00020-\u0018\u00010¤\u0001J\u0013\u0010¨\u0001\u001a\u00020-2\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019¨\u0006«\u0001"}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/viewmodel/SpColumnDetailViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "PAGE_STATE_NORMAL", "", "PAGE_STATE_OFFLINE", "command", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/feed/payment/utils/Event;", "Lkotlin/Pair;", "", "getCommand", "()Landroidx/lifecycle/MutableLiveData;", "detailData", "Lcom/baidu/searchbox/feed/payment/model/SpColumnDetailData;", "getDetailData", "()Lcom/baidu/searchbox/feed/payment/model/SpColumnDetailData;", "setDetailData", "(Lcom/baidu/searchbox/feed/payment/model/SpColumnDetailData;)V", "feedId", "getFeedId", "()Ljava/lang/String;", "setFeedId", "(Ljava/lang/String;)V", "isPresentAfxShowing", "", "()Z", "setPresentAfxShowing", "(Z)V", "isReceivePresent", "payRequest", "Lcom/baidu/searchbox/feed/payment/utils/PayRequestWrapper;", "getPayRequest", "()Lcom/baidu/searchbox/feed/payment/utils/PayRequestWrapper;", "setPayRequest", "(Lcom/baidu/searchbox/feed/payment/utils/PayRequestWrapper;)V", "priceFreeText", "getPriceFreeText", "setPriceFreeText", "resumeId", "getResumeId", "setResumeId", "addCommentCountOfTabLabel", "", "assertFeedIdSame", "canDisplayCommentButton", "consumeTrialCount", "newCount", "", "createShareContent", "Lcom/baidu/searchbox/socialshare/bean/BaiduShareContent;", "formatPrice", "price", "", "getButtonInfo", "", "Lcom/baidu/searchbox/feed/payment/model/SpDetailButtonInfo;", "getColumnType", "getCommentInfo", "Lcom/baidu/searchbox/feed/payment/model/CommentInfo;", "getCommentLabelList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/payment/model/SpCommentLabelItemData;", "Lkotlin/collections/ArrayList;", "getCommentStar", "getCommentThreadId", "getCouponList", "getDeadlineTime", "", "getDelayInfo", "getDelayTipUrl", "getInTrialTip", "getLastReadIdFromServer", "getLastReadTsFromServer", "getListIds", "getOutTrialTip", "getPageType", "getPayInfo", "Lcom/baidu/searchbox/feed/payment/model/SpDetailPayInfo;", "getSecKillTimerBarBgUrl", "getSelectedTabPosition", "getShareSourceOfStats", "getStatsKeyFrom", "id", "defaultValue", "getSubscribedCount", "getTabInfos", "Lcom/baidu/searchbox/feed/tab/update/MultiTabItemInfo;", "getTimerHint", "getTimerRange", "Lkotlin/ranges/LongRange;", "getTrialEndToastTip", "getUkAuthor", "gotoMySubscribe", "activity", "Landroid/content/Context;", "handleSubscribeResult", "reverseSubscribeState", "needSubscribed", "hasChatScheme", "hasContactInfo", "hasCoupon", "hasInvalidButton", "hasSecKillUnPaid", "hasShareInfo", "hasValidTimerForColumn", "invokeAddTabCmd", "context", "isAddCommentMode", "isBigImageLayout", "isChargeable", "isCombinationBuyEnabled", "isDeadlineReach", "isDetailModelValid", "isDiscount", "isFree", "isNaAlias", "tabInfo", "isOpenStyleOpt", "isPayPriceValid", "isPurchasable", "isPurchased", "isRankingInfoLayout", "isSecKillMode", "isSecKillNotStart", "isShowPresentEntrance", "isSmallImageLayout", "isSubscribed", "isTabFromPresent", "isTrialLimitReach", "isTrialValid", "loadDetailData", "serverTransit", "Lcom/baidu/searchbox/feed/payment/model/PayServerTransit;", "selectTabId", "loadPresentData", "makeCommentCountString", "makeCommentFragmentArgs", "Landroid/os/Bundle;", "makeCommentInputArgs", "", "makePayInfo", "Lcom/baidu/searchbox/feed/payment/core/model/PayInfo;", "isPresent", "makePriceTextForColumn", "markDeadlineShowTipDone", "()Lkotlin/Unit;", "mockListTab", "tabInfos", "dt", "needDisplayAddCommentButton", "onCleared", "postSubscribeEvent", "detail", "sendDataChannel", "resetTabFrom", "respDefaultError", "Lcom/baidu/searchbox/feed/payment/model/SimpleResponse;", "setTabFromPresent", "shouldShowCommentTips", "subscribe", "resultCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "updateCommentDetail", "result", "Lcom/baidu/searchbox/feed/payment/model/SpColumnCommentItemData;", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnDetailViewModel.kt */
public final class SpColumnDetailViewModel extends AndroidViewModel {
    private final String PAGE_STATE_NORMAL = "1";
    private final String PAGE_STATE_OFFLINE = "3";
    private final MutableLiveData<Event<Pair<String, Object>>> command = new MutableLiveData<>();
    private SpColumnDetailData detailData;
    private String feedId = "";
    private boolean isPresentAfxShowing;
    private boolean isReceivePresent;
    private PayRequestWrapper payRequest = new PayRequestWrapper();
    private String priceFreeText = "免费";
    private String resumeId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpColumnDetailViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final PayRequestWrapper getPayRequest() {
        return this.payRequest;
    }

    public final void setPayRequest(PayRequestWrapper payRequestWrapper) {
        Intrinsics.checkNotNullParameter(payRequestWrapper, "<set-?>");
        this.payRequest = payRequestWrapper;
    }

    public final MutableLiveData<Event<Pair<String, Object>>> getCommand() {
        return this.command;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final void setFeedId(String str) {
        this.feedId = str;
    }

    public final SpColumnDetailData getDetailData() {
        return this.detailData;
    }

    public final void setDetailData(SpColumnDetailData spColumnDetailData) {
        this.detailData = spColumnDetailData;
    }

    public final String getResumeId() {
        return this.resumeId;
    }

    public final void setResumeId(String str) {
        this.resumeId = str;
    }

    public final boolean isPresentAfxShowing() {
        return this.isPresentAfxShowing;
    }

    public final void setPresentAfxShowing(boolean z) {
        this.isPresentAfxShowing = z;
    }

    public final String getPriceFreeText() {
        return this.priceFreeText;
    }

    public final void setPriceFreeText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.priceFreeText = str;
    }

    public final void loadPresentData(String id, PayServerTransit serverTransit) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(serverTransit, "serverTransit");
        PayRequestWrapper.sendRequestAsync$default(this.payRequest, "283", SpColumnPresentData.class, (String) null, serverTransit.getReceivePostParams(new LinkedHashMap()), (Gson) null, new SpColumnDetailViewModel$$ExternalSyntheticLambda2(this), 20, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadPresentData$lambda-0  reason: not valid java name */
    public static final void m19071loadPresentData$lambda0(SpColumnDetailViewModel this$0, boolean success, SpColumnPresentData result, Exception exc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (success && result != null) {
            if (Intrinsics.areEqual((Object) result.receive.status, (Object) "1")) {
                this$0.command.setValue(new Event(TuplesKt.to(SpColumnViewModelHelperKt.EVENT_KEY_PRESENT_SUCCESS, null)));
            } else {
                this$0.command.setValue(new Event(TuplesKt.to(SpColumnViewModelHelperKt.EVENT_KEY_PRESENT_FAIL, result.receive.err)));
            }
        }
    }

    public static /* synthetic */ void loadDetailData$default(SpColumnDetailViewModel spColumnDetailViewModel, String str, PayServerTransit payServerTransit, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        spColumnDetailViewModel.loadDetailData(str, payServerTransit, str2);
    }

    public final void loadDetailData(String id, PayServerTransit serverTransit, String selectTabId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(serverTransit, "serverTransit");
        Map<String, Object> fillTo = serverTransit.fillTo(new LinkedHashMap());
        CharSequence charSequence = selectTabId;
        if (!(charSequence == null || charSequence.length() == 0)) {
            fillTo.put("tabId", selectTabId);
        }
        PayRequestWrapper.sendRequestAsync$default(this.payRequest, "266", SpColumnDetailData.class, (String) null, fillTo, (Gson) null, new SpColumnDetailViewModel$$ExternalSyntheticLambda0(this, id), 20, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadDetailData$lambda-1  reason: not valid java name */
    public static final void m19070loadDetailData$lambda1(SpColumnDetailViewModel this$0, String $id, boolean success, SpColumnDetailData result, Exception exc) {
        String code;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($id, "$id");
        if (!success || result == null) {
            this$0.command.setValue(new Event(TuplesKt.to("Error", "Network")));
            return;
        }
        this$0.feedId = $id;
        this$0.detailData = result;
        if (Intrinsics.areEqual((Object) result.pageState, (Object) this$0.PAGE_STATE_NORMAL)) {
            this$0.command.setValue(new Event(TuplesKt.to(SpColumnViewModelHelperKt.EVENT_KEY_MODEL_CHANGED, null)));
            return;
        }
        if (Intrinsics.areEqual((Object) result.pageState, (Object) this$0.PAGE_STATE_OFFLINE)) {
            code = SpColumnViewModelHelperKt.EVENT_ERROR_BANNED_TO_POST_VIP;
        } else {
            code = SpColumnViewModelHelperKt.EVENT_ERROR_BANNED_TO_POST;
        }
        this$0.command.setValue(new Event(TuplesKt.to("Error", code)));
    }

    public final boolean isDetailModelValid() {
        return this.detailData != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.columnType;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getPageType() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x0008
            java.lang.String r0 = r0.columnType
            if (r0 != 0) goto L_0x000a
        L_0x0008:
            java.lang.String r0 = ""
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getPageType():java.lang.String");
    }

    public void onCleared() {
        super.onCleared();
        this.detailData = null;
    }

    public final void assertFeedIdSame(String feedId2) {
        Intrinsics.checkNotNullParameter(feedId2, "feedId");
        Preconditions.checkStateFalse(!Intrinsics.areEqual((Object) this.feedId, (Object) feedId2), (Object) null, "assertFeedIdSame: %s == %s", this.feedId, feedId2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.listIds;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> getListIds() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x0008
            java.util.List<java.lang.String> r0 = r0.listIds
            if (r0 != 0) goto L_0x000c
        L_0x0008:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getListIds():java.util.List");
    }

    public final List<MultiTabItemInfo> getTabInfos() {
        ArrayList tabInfos = new ArrayList();
        SpColumnDetailData it = this.detailData;
        if (it != null) {
            for (SpDetailTabInfo tabInfo : it.tabInfos) {
                MultiTabItemInfo itemInfo = new MultiTabItemInfo();
                MultiTabItemInfo $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4 = itemInfo;
                $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mId = tabInfo.type;
                $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mTitle = tabInfo.name;
                $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mUrl = tabInfo.url;
                $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mTabType = tabInfo.id;
                RnInfo rnInfo = tabInfo.rnInfo;
                if (rnInfo != null) {
                    $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mId = tabInfo.id;
                    tabInfo.type = tabInfo.id;
                    $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mBundleId = rnInfo.bundleId;
                    $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mBundleVersion = rnInfo.bundleVersion;
                    $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mModuleName = rnInfo.moduleName;
                    Bundle $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2 = new Bundle();
                    $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.putString("bizparams", rnInfo.bizparams);
                    $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.talosInitParams = $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2;
                }
                $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mNativeView = tabInfo.nativeView;
                if (Intrinsics.areEqual((Object) $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mId, (Object) "comment")) {
                    $this$getTabInfos_u24lambda_u2d5_u24lambda_u2d4.mTitle = makeCommentCountString();
                }
                if (itemInfo.isValidate()) {
                    tabInfos.add(itemInfo);
                }
            }
            mockListTab(tabInfos, it);
        }
        return tabInfos;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.training;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean shouldShowCommentTips() {
        /*
            r5 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r5.detailData
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0012
            com.baidu.searchbox.feed.payment.model.Training r0 = r0.training
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.canComment()
            if (r0 != r1) goto L_0x0012
            r0 = r1
            goto L_0x0013
        L_0x0012:
            r0 = r2
        L_0x0013:
            if (r0 == 0) goto L_0x0041
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r5.detailData
            if (r0 == 0) goto L_0x0020
            com.baidu.searchbox.feed.payment.model.CommentInfo r0 = r0.comment
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = r0.status
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            java.lang.String r3 = "0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0041
            r3 = 0
            java.lang.String r0 = "feed_spcolumn_comment_bubble_last_show_time"
            long r3 = com.baidu.searchbox.feed.FeedPreferenceUtils.getLong(r0, r3)
            boolean r0 = com.baidu.searchbox.feed.util.FeedUtil.isExceedOneDay(r3)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = "feed_spcolumn_comment_bubble_count"
            int r0 = com.baidu.searchbox.feed.FeedPreferenceUtils.getInt(r0, r2)
            r3 = 5
            if (r0 >= r3) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r1 = r2
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.shouldShowCommentTips():boolean");
    }

    public final int getSelectedTabPosition() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData != null) {
            return spColumnDetailData.selectTabIndex;
        }
        return 0;
    }

    public final String getUkAuthor() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData != null) {
            return spColumnDetailData.ukAuthor;
        }
        return null;
    }

    public static /* synthetic */ String getStatsKeyFrom$default(SpColumnDetailViewModel spColumnDetailViewModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        return spColumnDetailViewModel.getStatsKeyFrom(str, str2);
    }

    public final String getStatsKeyFrom(String id, String defaultValue) {
        List<SpDetailTabInfo> list;
        Sequence asSequence;
        Object obj;
        String str;
        Intrinsics.checkNotNullParameter(defaultValue, KeyboardApi.KEYBOARD_DEFAULT_VALUE);
        if (id == null) {
            return defaultValue;
        }
        String type = id;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (!(spColumnDetailData == null || (list = spColumnDetailData.tabInfos) == null || (asSequence = CollectionsKt.asSequence(list)) == null)) {
            Iterator it = asSequence.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((SpDetailTabInfo) obj).type, (Object) type)) {
                    break;
                }
            }
            SpDetailTabInfo spDetailTabInfo = (SpDetailTabInfo) obj;
            if (!(spDetailTabInfo == null || (str = spDetailTabInfo.id) == null)) {
                return str;
            }
        }
        return defaultValue;
    }

    private final void mockListTab(ArrayList<MultiTabItemInfo> tabInfos, SpColumnDetailData dt) {
        Object obj;
        boolean z;
        Iterator it = tabInfos.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            MultiTabItemInfo it2 = (MultiTabItemInfo) obj;
            if (Intrinsics.areEqual((Object) "na", (Object) it2.mId) || Intrinsics.areEqual((Object) "na_view", (Object) it2.mId)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (((MultiTabItemInfo) obj) == null) {
            MultiTabItemInfo multiTabItemInfo = new MultiTabItemInfo();
            MultiTabItemInfo $this$mockListTab_u24lambda_u2d8 = multiTabItemInfo;
            $this$mockListTab_u24lambda_u2d8.mId = "na";
            $this$mockListTab_u24lambda_u2d8.mTitle = "目录(" + dt.listIds.size() + ')';
            $this$mockListTab_u24lambda_u2d8.mUrl = "";
            tabInfos.add(multiTabItemInfo);
        }
    }

    public final boolean isNaAlias(MultiTabItemInfo tabInfo) {
        Intrinsics.checkNotNullParameter(tabInfo, PageParams.KEY_TAB_INFO);
        return Intrinsics.areEqual((Object) tabInfo.mId, (Object) "na_view") && "purchase_common".equals(Tabs.getTabNameByUri(tabInfo.mNativeView));
    }

    public final void setTabFromPresent() {
        this.isReceivePresent = true;
    }

    public final void resetTabFrom() {
        this.isReceivePresent = false;
    }

    public final boolean isTabFromPresent() {
        return this.isReceivePresent;
    }

    public final boolean hasShareInfo() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        return (spColumnDetailData != null ? spColumnDetailData.shareInfo : null) != null;
    }

    public final boolean hasContactInfo() {
        List buttonInfo = getButtonInfo();
        if (buttonInfo != null && (!buttonInfo.isEmpty()) && buttonInfo.get(0).isDataValid() && Intrinsics.areEqual((Object) "chat", (Object) buttonInfo.get(0).type) && !isPurchased()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.present;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isShowPresentEntrance() {
        /*
            r2 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r2.detailData
            if (r0 == 0) goto L_0x000b
            com.baidu.searchbox.feed.payment.model.Present r0 = r0.present
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.isShow
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.isShowPresentEntrance():boolean");
    }

    public final String getShareSourceOfStats() {
        SpDetailShareInfo spDetailShareInfo;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (spDetailShareInfo = spColumnDetailData.shareInfo) == null) {
            return null;
        }
        return spDetailShareInfo.source;
    }

    public final BaiduShareContent createShareContent() {
        SpDetailShareInfo shareInfo;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (shareInfo = spColumnDetailData.shareInfo) == null) {
            return null;
        }
        return new BaiduShareContent.Builder().setTitle(shareInfo.title).setContent(shareInfo.description).setLinkUrl(shareInfo.url).setShareType(1).setMediaType("all").setSource(shareInfo.source).setIconUrl(shareInfo.imageUrl).setSourcePage(SharePageEnum.NA).addRemoveMenuItem(MediaType.BDFRIEND).create();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.payInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isPurchased() {
        /*
            r2 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r2.detailData
            if (r0 == 0) goto L_0x000b
            com.baidu.searchbox.feed.payment.model.SpDetailPayInfo r0 = r0.payInfo
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.payState
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.isPurchased():boolean");
    }

    public final boolean isPurchasable() {
        return !isPurchased() && isChargeable();
    }

    public final boolean isChargeable() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        return Intrinsics.areEqual((Object) spColumnDetailData != null ? spColumnDetailData.isPay : null, (Object) "1");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004f, code lost:
        if ((r1 == 0.0f) != false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String makePriceTextForColumn() {
        /*
            r9 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r9.detailData
            if (r0 == 0) goto L_0x0007
            com.baidu.searchbox.feed.payment.model.SpDetailPayInfo r0 = r0.payInfo
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r0 == 0) goto L_0x001b
            java.lang.String r2 = r0.originalPrice
            if (r2 == 0) goto L_0x001b
            java.lang.Float r2 = kotlin.text.StringsKt.toFloatOrNull(r2)
            if (r2 == 0) goto L_0x001b
            float r2 = r2.floatValue()
            goto L_0x001c
        L_0x001b:
            r2 = r1
        L_0x001c:
            if (r0 == 0) goto L_0x002c
            java.lang.String r3 = r0.currentPrice
            if (r3 == 0) goto L_0x002c
            java.lang.Float r3 = kotlin.text.StringsKt.toFloatOrNull(r3)
            if (r3 == 0) goto L_0x002c
            float r1 = r3.floatValue()
        L_0x002c:
            boolean r3 = r9.isPurchased()
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x00d4
            r3 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00d4
            r5 = 1287568416(0x4cbebc20, float:1.0E8)
            int r6 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r6 > 0) goto L_0x00d4
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 0
            r7 = 1
            r8 = 0
            if (r3 >= 0) goto L_0x0051
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x004e
            r3 = r7
            goto L_0x004f
        L_0x004e:
            r3 = r8
        L_0x004f:
            if (r3 == 0) goto L_0x00d4
        L_0x0051:
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x00d4
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x005b
            goto L_0x00d4
        L_0x005b:
            if (r0 == 0) goto L_0x0063
            java.lang.String r3 = r0.priceUnit
            if (r3 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r4 = r3
        L_0x0063:
            r3 = r4
            int r4 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x006b
            r4 = r7
            goto L_0x006c
        L_0x006b:
            r4 = r8
        L_0x006c:
            r5 = 32
            if (r4 == 0) goto L_0x0090
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r9.priceFreeText
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r9.formatPrice(r2)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r4 = r4.toString()
            goto L_0x00d3
        L_0x0090:
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r7 = r8
        L_0x0096:
            if (r7 != 0) goto L_0x00be
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r9.formatPrice(r1)
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r9.formatPrice(r2)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r4 = r4.toString()
            goto L_0x00d3
        L_0x00be:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r9.formatPrice(r1)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r4 = r4.toString()
        L_0x00d3:
            return r4
        L_0x00d4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.makePriceTextForColumn():java.lang.String");
    }

    private final String formatPrice(float price) {
        String format = new DecimalFormat("#0.##").format(Float.valueOf(price / 100.0f));
        Intrinsics.checkNotNullExpressionValue(format, "DecimalFormat(\"#0.##\").format(price / 100F)");
        return format;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.subscribeInfo).lastArticle;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getLastReadIdFromServer() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x000c
            com.baidu.searchbox.feed.payment.model.SpDetailSubscribeInfo r0 = r0.subscribeInfo
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.lastArticle
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getLastReadIdFromServer():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.subscribeInfo).lastArticleTs;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getLastReadTsFromServer() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x000c
            com.baidu.searchbox.feed.payment.model.SpDetailSubscribeInfo r0 = r0.subscribeInfo
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.lastArticleTs
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = "0"
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getLastReadTsFromServer():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r2 = kotlin.text.StringsKt.toFloatOrNull(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasValidTimerForColumn() {
        /*
            r8 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r8.detailData
            r1 = 0
            if (r0 == 0) goto L_0x0068
            com.baidu.searchbox.feed.payment.model.SpDetailPayInfo r0 = r0.payInfo
            if (r0 != 0) goto L_0x000a
            goto L_0x0068
        L_0x000a:
            java.lang.String r2 = r0.currentPrice
            if (r2 == 0) goto L_0x0019
            java.lang.Float r2 = kotlin.text.StringsKt.toFloatOrNull(r2)
            if (r2 == 0) goto L_0x0019
            float r2 = r2.floatValue()
            goto L_0x001b
        L_0x0019:
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x001b:
            java.lang.String r3 = r0.serverTimestamp
            r4 = -1
            if (r3 == 0) goto L_0x002b
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)
            if (r3 == 0) goto L_0x002b
            int r3 = r3.intValue()
            goto L_0x002c
        L_0x002b:
            r3 = r4
        L_0x002c:
            java.lang.String r5 = r0.endTimestamp
            if (r5 == 0) goto L_0x003a
            java.lang.Integer r5 = kotlin.text.StringsKt.toIntOrNull(r5)
            if (r5 == 0) goto L_0x003a
            int r4 = r5.intValue()
        L_0x003a:
            java.lang.String r5 = r0.isSale
            boolean r6 = r8.isPurchased()
            if (r6 != 0) goto L_0x0066
            if (r5 == 0) goto L_0x0050
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.CharSequence r6 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r6)
            java.lang.String r6 = r6.toString()
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            java.lang.String r7 = "1"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0066
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0066
            if (r3 <= 0) goto L_0x0066
            if (r4 <= 0) goto L_0x0066
            if (r4 <= r3) goto L_0x0066
            r1 = 1
            goto L_0x0067
        L_0x0066:
        L_0x0067:
            return r1
        L_0x0068:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.hasValidTimerForColumn():boolean");
    }

    public final String getTimerHint() {
        String str;
        Float floatOrNull;
        SpColumnDetailData spColumnDetailData = this.detailData;
        String label = null;
        SpDetailPayInfo payInfo = spColumnDetailData != null ? spColumnDetailData.payInfo : null;
        float price = (payInfo == null || (str = payInfo.currentPrice) == null || (floatOrNull = StringsKt.toFloatOrNull(str)) == null) ? -1.0f : floatOrNull.floatValue();
        if (payInfo != null) {
            label = payInfo.saleDescription;
        }
        boolean z = true;
        if (!(price == 0.0f)) {
            CharSequence charSequence = label;
            if (charSequence != null && !StringsKt.isBlank(charSequence)) {
                z = false;
            }
            if (!z) {
                Intrinsics.checkNotNull(label);
                return label;
            }
        }
        return "";
    }

    public final LongRange getTimerRange() {
        String str;
        Long longOrNull;
        String str2;
        Long longOrNull2;
        SpColumnDetailData spColumnDetailData = this.detailData;
        SpDetailPayInfo payInfo = spColumnDetailData != null ? spColumnDetailData.payInfo : null;
        long end = 0;
        long start = (payInfo == null || (str2 = payInfo.serverTimestamp) == null || (longOrNull2 = StringsKt.toLongOrNull(str2)) == null) ? 0 : longOrNull2.longValue();
        if (!(payInfo == null || (str = payInfo.endTimestamp) == null || (longOrNull = StringsKt.toLongOrNull(str)) == null)) {
            end = longOrNull.longValue();
        }
        return new LongRange(start, end);
    }

    public final boolean isPayPriceValid() {
        SpDetailPayInfo spDetailPayInfo;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (spDetailPayInfo = spColumnDetailData.payInfo) == null) {
            return false;
        }
        return spDetailPayInfo.isPayPriceValid();
    }

    public final boolean isFree() {
        SpDetailPayInfo spDetailPayInfo;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (spDetailPayInfo = spColumnDetailData.payInfo) == null) {
            return false;
        }
        return spDetailPayInfo.isFree();
    }

    public final boolean isDiscount() {
        SpDetailPayInfo spDetailPayInfo;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (spDetailPayInfo = spColumnDetailData.payInfo) == null) {
            return false;
        }
        return spDetailPayInfo.isSale();
    }

    public final boolean hasInvalidButton() {
        List buttonInfo = getButtonInfo();
        if (buttonInfo != null && (!buttonInfo.isEmpty()) && buttonInfo.get(0).isDataValid()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.chatInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasChatScheme() {
        /*
            r2 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r2.detailData
            if (r0 == 0) goto L_0x000b
            com.baidu.searchbox.feed.payment.model.SpChatInfo r0 = r0.chatInfo
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.scheme
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 1
            if (r0 == 0) goto L_0x001a
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r0 = 0
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            r0 = r0 ^ r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.hasChatScheme():boolean");
    }

    public static /* synthetic */ PayInfo makePayInfo$default(SpColumnDetailViewModel spColumnDetailViewModel, String str, PayServerTransit payServerTransit, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return spColumnDetailViewModel.makePayInfo(str, payServerTransit, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
        r1 = r1.secKillInfo;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.feed.payment.core.model.PayInfo makePayInfo(java.lang.String r13, com.baidu.searchbox.feed.payment.model.PayServerTransit r14, boolean r15) {
        /*
            r12 = this;
            java.lang.String r0 = "feedId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "serverTransit"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r1 = r12.detailData
            r2 = 0
            if (r1 == 0) goto L_0x001e
            com.baidu.searchbox.feed.payment.model.SpSecKillInfo r1 = r1.secKillInfo
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = r1.status
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            r3 = 0
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x002e
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r4 = 0
            goto L_0x002f
        L_0x002e:
            r4 = 1
        L_0x002f:
            java.lang.String r5 = "liveSeckillState"
            if (r4 == 0) goto L_0x0037
            r14.removeParamsToPassThrough(r5)
            goto L_0x003a
        L_0x0037:
            r14.addParamsToPassThrough(r5, r1)
        L_0x003a:
            r14.fillTo(r0)
            boolean r7 = r12.isFree()
            java.lang.String r1 = "source"
            java.lang.Object r1 = r0.get(r1)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x0052
            java.lang.String r1 = (java.lang.String) r1
            r8 = r1
            goto L_0x0053
        L_0x0052:
            r8 = r2
        L_0x0053:
            java.lang.String r1 = "pass_through"
            java.lang.Object r1 = r0.get(r1)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x0062
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
        L_0x0062:
            r10 = r2
            java.lang.String r9 = "feed"
            r6 = r13
            r11 = r15
            com.baidu.searchbox.feed.payment.core.model.PayInfo r1 = com.baidu.searchbox.feed.payment.core.model.PayInfo.with((java.lang.String) r6, (boolean) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (boolean) r11)
            java.lang.String r2 = "with(feedId, isFree(),\n …\"] as? String, isPresent)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.makePayInfo(java.lang.String, com.baidu.searchbox.feed.payment.model.PayServerTransit, boolean):com.baidu.searchbox.feed.payment.core.model.PayInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.subscribeInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isSubscribed() {
        /*
            r2 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r2.detailData
            if (r0 == 0) goto L_0x000b
            com.baidu.searchbox.feed.payment.model.SpDetailSubscribeInfo r0 = r0.subscribeInfo
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.state
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.isSubscribed():boolean");
    }

    private final SimpleResponse respDefaultError() {
        SimpleResponse $this$respDefaultError_u24lambda_u2d10 = new SimpleResponse();
        $this$respDefaultError_u24lambda_u2d10.setMessage(getApplication().getResources().getString(R.string.spcolumn_fail_subscribe));
        return $this$respDefaultError_u24lambda_u2d10;
    }

    public final void subscribe(Function1<? super Boolean, Unit> resultCallback) {
        SpColumnDetailData detail = this.detailData;
        SpDetailSubscribeInfo subscribeInfo = detail != null ? detail.subscribeInfo : null;
        if (subscribeInfo == null) {
            if (resultCallback != null) {
                resultCallback.invoke(false);
            }
        } else if (Intrinsics.areEqual((Object) subscribeInfo.state, (Object) "1")) {
            postSubscribeEvent(detail, false);
        } else {
            JSONObject jsonObject = new JSONObject();
            try {
                Result.Companion companion = Result.Companion;
                SpColumnDetailViewModel spColumnDetailViewModel = this;
                JSONArray $this$subscribe_u24lambda_u2d12_u24lambda_u2d11 = new JSONArray();
                $this$subscribe_u24lambda_u2d12_u24lambda_u2d11.put(new JSONObject(subscribeInfo.content));
                Unit unit = Unit.INSTANCE;
                jsonObject.put("items", $this$subscribe_u24lambda_u2d12_u24lambda_u2d11);
                Result.m8971constructorimpl(jsonObject.put("cate", "shelf"));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            PayRequestWrapper payRequestWrapper = this.payRequest;
            String shelfActionUrl = FeedUrlConfig.getShelfActionUrl("701");
            Intrinsics.checkNotNullExpressionValue(shelfActionUrl, "getShelfActionUrl(NetReq…rotocol.SpColumn.CMD_701)");
            PayRequestWrapper.doSendRequestAsync$default(payRequestWrapper, shelfActionUrl, "", Map.class, (Gson) null, MapsKt.mapOf(TuplesKt.to("data", jsonObject.toString())), new SpColumnDetailViewModel$$ExternalSyntheticLambda1(this, resultCallback), 8, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribe$lambda-13  reason: not valid java name */
    public static final void m19072subscribe$lambda13(SpColumnDetailViewModel this$0, Function1 $resultCallback, boolean success, Map result, Exception exception) {
        String obj;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SpColumnDetailData data = this$0.detailData;
        if (success && result != null && data != null) {
            Object obj2 = data.subscribeInfo.content.get("third_id");
            String key = obj2 instanceof String ? (String) obj2 : null;
            if (key == null) {
                key = "";
            }
            Object obj3 = result.get(key);
            if (((obj3 == null || (obj = obj3.toString()) == null || (intOrNull = StringsKt.toIntOrNull(obj)) == null) ? -1 : intOrNull.intValue()) == 0) {
                this$0.handleSubscribeResult(true, false);
            } else {
                this$0.command.setValue(new Event(TuplesKt.to("Error", this$0.respDefaultError())));
            }
        } else if (!(exception instanceof PayRequestException)) {
            this$0.command.setValue(new Event(TuplesKt.to("Error", SpColumnViewModelHelperKt.EVENT_ERROR_PULL_OR_PUSH)));
        } else if (((PayRequestException) exception).getResponse().isFromServer()) {
            this$0.command.setValue(new Event(TuplesKt.to("Error", ((PayRequestException) exception).getResponse())));
        } else {
            this$0.command.setValue(new Event(TuplesKt.to("Error", this$0.respDefaultError())));
        }
        if ($resultCallback != null) {
            $resultCallback.invoke(Boolean.valueOf(success));
        }
    }

    public final void handleSubscribeResult(boolean reverseSubscribeState, boolean needSubscribed) {
        String str;
        SpColumnDetailData detail = this.detailData;
        if (detail != null) {
            SpDetailSubscribeInfo subscribeInfo = detail.subscribeInfo;
            String str2 = "1";
            boolean isSubscribed = Intrinsics.areEqual((Object) subscribeInfo.state, (Object) str2);
            if (reverseSubscribeState || isSubscribed != needSubscribed) {
                String count = subscribeInfo.count;
                Long realCount = count != null ? StringsKt.toLongOrNull(count) : null;
                if (realCount != null) {
                    long c2 = realCount.longValue() + (isSubscribed ? -1 : 1);
                    if (c2 <= 0) {
                        str = "0";
                    } else {
                        str = String.valueOf(c2);
                    }
                    subscribeInfo.count = str;
                }
                if (isSubscribed) {
                    str2 = "0";
                }
                subscribeInfo.state = str2;
                postSubscribeEvent(detail, reverseSubscribeState);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void postSubscribeEvent(com.baidu.searchbox.feed.payment.model.SpColumnDetailData r6, boolean r7) {
        /*
            r5 = this;
            com.baidu.searchbox.feed.payment.model.SpDetailSubscribeInfo r0 = r6.subscribeInfo
            androidx.lifecycle.MutableLiveData<com.baidu.searchbox.feed.payment.utils.Event<kotlin.Pair<java.lang.String, java.lang.Object>>> r1 = r5.command
            com.baidu.searchbox.feed.payment.utils.Event r2 = new com.baidu.searchbox.feed.payment.utils.Event
            java.lang.String r3 = "Subscribe"
            r4 = 0
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r2.<init>(r3)
            r1.setValue(r2)
            if (r7 == 0) goto L_0x0033
            android.app.Application r1 = r5.getApplication()
            android.content.Context r1 = (android.content.Context) r1
            java.util.TreeMap<java.lang.String, java.lang.Object> r2 = r0.content
            java.lang.String r3 = "third_id"
            java.lang.Object r2 = r2.get(r3)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x002b
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
        L_0x002b:
            java.lang.String r2 = r0.state
            java.lang.String r3 = "subscribe"
            com.baidu.searchbox.feed.payment.core.datachannel.FeedAssistMsgSender.sendStatusMessage(r1, r4, r3, r2)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.postSubscribeEvent(com.baidu.searchbox.feed.payment.model.SpColumnDetailData, boolean):void");
    }

    public final void gotoMySubscribe(Context activity) {
        String it;
        Intrinsics.checkNotNullParameter(activity, "activity");
        SpColumnDetailData spColumnDetailData = this.detailData;
        SpDetailSubscribeInfo info = spColumnDetailData != null ? spColumnDetailData.subscribeInfo : null;
        if (info != null && (it = info.shelfCmd) != null) {
            Router.invoke(activity, it);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = kotlin.text.StringsKt.toLongOrNull((r0 = (r0 = r0.subscribeInfo).count));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getSubscribedCount() {
        /*
            r8 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r8.detailData
            r1 = 0
            if (r0 == 0) goto L_0x0019
            com.baidu.searchbox.feed.payment.model.SpDetailSubscribeInfo r0 = r0.subscribeInfo
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.count
            if (r0 == 0) goto L_0x0019
            java.lang.Long r0 = kotlin.text.StringsKt.toLongOrNull(r0)
            if (r0 == 0) goto L_0x0019
            long r3 = r0.longValue()
            goto L_0x001a
        L_0x0019:
            r3 = r1
        L_0x001a:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0046
            android.app.Application r0 = r8.getApplication()
            java.lang.String r1 = "getApplication()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.content.res.Resources r1 = r0.getResources()
            int r2 = com.baidu.searchbox.feed.payment.R.string.spcolumn_person_subscribe
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r7 = r0
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r7 = com.baidu.searchbox.feed.util.FeedUtil.convertNumber(r7, r3)
            r5[r6] = r7
            java.lang.String r0 = r1.getString(r2, r5)
            java.lang.String r1 = "{\n            val appCon…ubscribeCount))\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x0048
        L_0x0046:
            java.lang.String r0 = ""
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getSubscribedCount():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r0 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addCommentCountOfTabLabel() {
        /*
            r6 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r6.detailData
            if (r0 == 0) goto L_0x0046
            java.util.List<com.baidu.searchbox.feed.payment.model.SpDetailTabInfo> r0 = r0.tabInfos
            if (r0 == 0) goto L_0x0046
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.baidu.searchbox.feed.payment.model.SpDetailTabInfo r2 = (com.baidu.searchbox.feed.payment.model.SpDetailTabInfo) r2
            r3 = 0
            java.lang.String r4 = r2.type
            java.lang.String r5 = "comment"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x000e
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            com.baidu.searchbox.feed.payment.model.SpDetailTabInfo r1 = (com.baidu.searchbox.feed.payment.model.SpDetailTabInfo) r1
            if (r1 != 0) goto L_0x002d
            goto L_0x0046
        L_0x002d:
            r0 = r1
            java.lang.String r1 = r0.num
            if (r1 == 0) goto L_0x0045
            java.lang.Integer r1 = kotlin.text.StringsKt.toIntOrNull(r1)
            if (r1 == 0) goto L_0x0045
            int r1 = r1.intValue()
            int r2 = r1 + 1
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.num = r2
            return
        L_0x0045:
            return
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.addCommentCountOfTabLabel():void");
    }

    public final String makeCommentCountString() {
        List<SpDetailTabInfo> list;
        Integer num;
        Object obj;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (list = spColumnDetailData.tabInfos) == null) {
            return "";
        }
        Iterator it = list.iterator();
        while (true) {
            num = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((SpDetailTabInfo) obj).type, (Object) "comment")) {
                break;
            }
        }
        SpDetailTabInfo spDetailTabInfo = (SpDetailTabInfo) obj;
        if (spDetailTabInfo == null) {
            return "";
        }
        SpDetailTabInfo tabInfo = spDetailTabInfo;
        String str = tabInfo.num;
        if (str != null) {
            num = StringsKt.toIntOrNull(str);
        }
        Integer commentCount = num;
        if (commentCount != null && commentCount.intValue() <= 0) {
            return "评价";
        }
        CharSequence charSequence = tabInfo.num;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return "评价";
        }
        return "评价(" + tabInfo.num + ')';
    }

    public final boolean canDisplayCommentButton() {
        String commentStatus;
        CommentInfo commentInfo;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (commentInfo = spColumnDetailData.comment) == null || (commentStatus = commentInfo.status) == null) {
            commentStatus = "";
        }
        return !isPurchasable() && !Intrinsics.areEqual((Object) commentStatus, (Object) "2");
    }

    public final boolean needDisplayAddCommentButton() {
        String commentStatus;
        CommentInfo commentInfo;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (commentInfo = spColumnDetailData.comment) == null || (commentStatus = commentInfo.status) == null) {
            commentStatus = "";
        }
        return !Intrinsics.areEqual((Object) commentStatus, (Object) "0");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.comment;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isAddCommentMode() {
        /*
            r2 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r2.detailData
            if (r0 == 0) goto L_0x000b
            com.baidu.searchbox.feed.payment.model.CommentInfo r0 = r0.comment
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.status
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x001c
            boolean r0 = r2.isPurchasable()
            if (r0 != 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.isAddCommentMode():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r1 = r1.comment;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle makeCommentFragmentArgs() {
        /*
            r5 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = r5.feedId
            java.lang.String r2 = "nid"
            r0.putString(r2, r1)
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r1 = r5.detailData
            r2 = 0
            if (r1 == 0) goto L_0x0019
            com.baidu.searchbox.feed.payment.model.CommentInfo r1 = r1.comment
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = r1.id
            goto L_0x001a
        L_0x0019:
            r1 = r2
        L_0x001a:
            java.lang.String r3 = "thread_id"
            r0.putString(r3, r1)
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r1 = r5.detailData
            if (r1 == 0) goto L_0x002b
            com.baidu.searchbox.feed.payment.model.CommentInfo r1 = r1.comment
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = r1.status
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            java.lang.String r3 = "comment_status"
            r0.putString(r3, r1)
            boolean r1 = r5.isPurchasable()
            r3 = 1
            r1 = r1 ^ r3
            java.lang.String r4 = "is_bought"
            r0.putBoolean(r4, r1)
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r1 = r5.detailData
            if (r1 == 0) goto L_0x0044
            com.baidu.searchbox.feed.payment.model.Training r1 = r1.training
            goto L_0x0045
        L_0x0044:
            r1 = r2
        L_0x0045:
            r4 = 0
            if (r1 == 0) goto L_0x005d
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r1 = r5.detailData
            if (r1 == 0) goto L_0x0058
            com.baidu.searchbox.feed.payment.model.Training r1 = r1.training
            if (r1 == 0) goto L_0x0058
            boolean r1 = r1.canComment()
            if (r1 != r3) goto L_0x0058
            r1 = r3
            goto L_0x0059
        L_0x0058:
            r1 = r4
        L_0x0059:
            if (r1 == 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r3 = r4
        L_0x005d:
            java.lang.String r1 = "can_commend"
            r0.putBoolean(r1, r3)
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r1 = r5.detailData
            if (r1 == 0) goto L_0x006c
            com.baidu.searchbox.feed.payment.model.Training r1 = r1.training
            if (r1 == 0) goto L_0x006c
            java.lang.String r2 = r1.commentToast
        L_0x006c:
            java.lang.String r1 = "comment_toast"
            r0.putString(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.makeCommentFragmentArgs():android.os.Bundle");
    }

    public final Map<String, Object> makeCommentInputArgs() {
        CommentInfo commentInfo;
        HashMap map = new HashMap();
        map.put("mode", isAddCommentMode() ? "1" : "0");
        if (isAddCommentMode()) {
            Map map2 = map;
            SpColumnDetailData spColumnDetailData = this.detailData;
            map2.put(FeedCommentInputDialogKt.INPUT_COMMENT_INFO_KEY, (spColumnDetailData == null || (commentInfo = spColumnDetailData.comment) == null) ? null : commentInfo.oldInfo);
        }
        return map;
    }

    public final void updateCommentDetail(SpColumnCommentItemData result) {
        CommentInfo commentInfo;
        if (!isAddCommentMode()) {
            addCommentCountOfTabLabel();
        }
        SpColumnDetailData spColumnDetailData = this.detailData;
        String str = null;
        CommentInfo commentInfo2 = spColumnDetailData != null ? spColumnDetailData.comment : null;
        if (commentInfo2 != null) {
            commentInfo2.status = "1";
        }
        SpColumnDetailData spColumnDetailData2 = this.detailData;
        SpOldCommentItemData oldInfo = (spColumnDetailData2 == null || (commentInfo = spColumnDetailData2.comment) == null) ? null : commentInfo.oldInfo;
        if (oldInfo != null) {
            oldInfo.isAnonymous = result != null ? result.isAnonymous : null;
        }
        if (oldInfo != null) {
            if (result != null) {
                str = result.star;
            }
            oldInfo.star = str;
        }
    }

    public final String getCommentThreadId() {
        CommentInfo commentInfo;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (commentInfo = spColumnDetailData.comment) == null) {
            return null;
        }
        return commentInfo.id;
    }

    public final float getCommentStar() {
        String str;
        Float floatOrNull;
        SpColumnDetailData spColumnDetailData = this.detailData;
        String str2 = null;
        CommentInfo comment = spColumnDetailData != null ? spColumnDetailData.comment : null;
        if (comment != null) {
            str2 = comment.status;
        }
        if (Intrinsics.areEqual((Object) str2, (Object) "2") || comment == null || (str = comment.star) == null || (floatOrNull = StringsKt.toFloatOrNull(str)) == null) {
            return 0.0f;
        }
        return floatOrNull.floatValue();
    }

    public final boolean isSmallImageLayout() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        return Intrinsics.areEqual((Object) spColumnDetailData != null ? spColumnDetailData.layout : null, (Object) "image1");
    }

    public final boolean isBigImageLayout() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        return Intrinsics.areEqual((Object) spColumnDetailData != null ? spColumnDetailData.layout : null, (Object) "bigimage");
    }

    public final boolean isRankingInfoLayout() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        return Intrinsics.areEqual((Object) spColumnDetailData != null ? spColumnDetailData.layout : null, (Object) SpColumnDetailDataKt.LAYOUT_COLUMN_IMAGE1);
    }

    public final void invokeAddTabCmd(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpColumnDetailData spColumnDetailData = this.detailData;
        FeedRouter.invoke(context, spColumnDetailData != null ? spColumnDetailData.addTabCmd : null, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.couponInfo).couponList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> getCouponList() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x000f
            com.baidu.searchbox.feed.payment.model.SpDetailCouponInfo r0 = r0.couponInfo
            if (r0 == 0) goto L_0x000f
            java.util.ArrayList<java.lang.String> r0 = r0.couponList
            if (r0 == 0) goto L_0x000f
            java.util.List r0 = (java.util.List) r0
            goto L_0x0013
        L_0x000f:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getCouponList():java.util.List");
    }

    public final boolean hasCoupon() {
        return !getCouponList().isEmpty();
    }

    public final List<SpDetailButtonInfo> getButtonInfo() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData != null) {
            return spColumnDetailData.buttonInfo;
        }
        return null;
    }

    public final boolean isCombinationBuyEnabled() {
        List it;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (it = spColumnDetailData.buttonInfo) == null) {
            return false;
        }
        for (SpDetailButtonInfo btn : it) {
            if (Intrinsics.areEqual((Object) btn.type, (Object) SpColumnDetailDataKt.BUTTON_INFO_TYPE_COMBINATION_BUY) && Intrinsics.areEqual((Object) btn.state, (Object) "1")) {
                return true;
            }
        }
        return false;
    }

    public final CommentInfo getCommentInfo() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData != null) {
            return spColumnDetailData.comment;
        }
        return null;
    }

    public final SpDetailPayInfo getPayInfo() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData != null) {
            return spColumnDetailData.payInfo;
        }
        return null;
    }

    public final ArrayList<SpCommentLabelItemData> getCommentLabelList() {
        CommentInfo commentInfo;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (commentInfo = spColumnDetailData.comment) == null) {
            return null;
        }
        return commentInfo.labelList;
    }

    public final boolean isTrialValid() {
        Trial trial;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (trial = spColumnDetailData.trial) == null) {
            return false;
        }
        return trial.isValid();
    }

    public final boolean isTrialLimitReach() {
        Trial trial;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (trial = spColumnDetailData.trial) == null) {
            return false;
        }
        return trial.isTrialLimitReach();
    }

    public final boolean isDeadlineReach() {
        Trial trial;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (trial = spColumnDetailData.trial) == null) {
            return false;
        }
        return trial.isDeadlineReach();
    }

    public final Unit markDeadlineShowTipDone() {
        Trial trial;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData == null || (trial = spColumnDetailData.trial) == null) {
            return null;
        }
        trial.markDeadlineShowTipDone();
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.trial).deadlineToastTips;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getTrialEndToastTip() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x000c
            com.baidu.searchbox.feed.payment.model.Trial r0 = r0.trial
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.deadlineToastTips
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getTrialEndToastTip():java.lang.String");
    }

    public final void consumeTrialCount(int newCount) {
        Trial trial;
        SpColumnDetailData spColumnDetailData = this.detailData;
        if (spColumnDetailData != null && (trial = spColumnDetailData.trial) != null) {
            trial.consumeTrialCount(newCount);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.trial).makeInTrialTip();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getInTrialTip() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x0010
            com.baidu.searchbox.feed.payment.model.Trial r0 = r0.trial
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.makeInTrialTip()
            if (r0 != 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            return r0
        L_0x0010:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getInTrialTip():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.trial).inactiveTips;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getOutTrialTip() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x000c
            com.baidu.searchbox.feed.payment.model.Trial r0 = r0.trial
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.inactiveTips
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getOutTrialTip():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.columnType;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getColumnType() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x0008
            java.lang.String r0 = r0.columnType
            if (r0 != 0) goto L_0x000a
        L_0x0008:
            java.lang.String r0 = ""
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getColumnType():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = kotlin.text.StringsKt.toLongOrNull((r0 = (r0 = r0.training).time));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long[] getDeadlineTime() {
        /*
            r6 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r6.detailData
            r1 = 0
            if (r0 == 0) goto L_0x0019
            com.baidu.searchbox.feed.payment.model.Training r0 = r0.training
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.time
            if (r0 == 0) goto L_0x0019
            java.lang.Long r0 = kotlin.text.StringsKt.toLongOrNull(r0)
            if (r0 == 0) goto L_0x0019
            long r3 = r0.longValue()
            goto L_0x001a
        L_0x0019:
            r3 = r1
        L_0x001a:
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r6.detailData
            if (r0 == 0) goto L_0x0030
            com.baidu.searchbox.feed.payment.model.Training r0 = r0.training
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = r0.applyEndTime
            if (r0 == 0) goto L_0x0030
            java.lang.Long r0 = kotlin.text.StringsKt.toLongOrNull(r0)
            if (r0 == 0) goto L_0x0030
            long r1 = r0.longValue()
        L_0x0030:
            r0 = r1
            r2 = 2
            long[] r2 = new long[r2]
            r5 = 0
            r2[r5] = r3
            r5 = 1
            r2[r5] = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getDeadlineTime():long[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.training).delayText;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getDelayInfo() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x000c
            com.baidu.searchbox.feed.payment.model.Training r0 = r0.training
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.delayText
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getDelayInfo():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.training).delayUrl;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getDelayTipUrl() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x000c
            com.baidu.searchbox.feed.payment.model.Training r0 = r0.training
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.delayUrl
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getDelayTipUrl():java.lang.String");
    }

    public final boolean isSecKillMode() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        return (spColumnDetailData != null ? spColumnDetailData.secKillInfo : null) != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r0.secKillInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasSecKillUnPaid() {
        /*
            r2 = this;
            boolean r0 = r2.isSecKillMode()
            if (r0 == 0) goto L_0x001c
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r2.detailData
            if (r0 == 0) goto L_0x0011
            com.baidu.searchbox.feed.payment.model.SpSecKillInfo r0 = r0.secKillInfo
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.isSecKillUnpaid
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.hasSecKillUnPaid():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.secKillInfo).bgUrl;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getSecKillTimerBarBgUrl() {
        /*
            r1 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r1.detailData
            if (r0 == 0) goto L_0x000c
            com.baidu.searchbox.feed.payment.model.SpSecKillInfo r0 = r0.secKillInfo
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.bgUrl
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.getSecKillTimerBarBgUrl():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.secKillInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isSecKillNotStart() {
        /*
            r2 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r2.detailData
            if (r0 == 0) goto L_0x000b
            com.baidu.searchbox.feed.payment.model.SpSecKillInfo r0 = r0.secKillInfo
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.status
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            java.lang.String r1 = "0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel.isSecKillNotStart():boolean");
    }

    public final boolean isOpenStyleOpt() {
        SpColumnDetailData spColumnDetailData = this.detailData;
        return Intrinsics.areEqual((Object) spColumnDetailData != null ? spColumnDetailData.styleOptSwitch : null, (Object) "1");
    }
}
