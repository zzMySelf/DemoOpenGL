package com.baidu.searchbox.video.feedflow.detail.thirdParty.statistic;

import com.baidu.searchbox.account.im.GroupMemberAdapter;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.ext.common.UbcBean;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import java.util.Random;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J2\u0010\u0011\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/thirdParty/statistic/ThirdPartyStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "random$delegate", "Lkotlin/Lazy;", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "reportThirdPartyData", "", "isDisplay", "", "isFromBanner", "dxxh5ItemId", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThirdPartyStatisticMiddleware.kt */
public final class ThirdPartyStatisticMiddleware implements Middleware<CommonState> {
    private final Lazy random$delegate = BdPlayerUtils.lazyNone(ThirdPartyStatisticMiddleware$random$2.INSTANCE);

    private final Random getRandom() {
        return (Random) this.random$delegate.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.StarSelectedModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel} */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.baidu.searchbox.video.feedflow.detail.banner.model.StarSelectedModel] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r9, com.baidu.searchbox.feed.detail.frame.Action r10, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.thirdParty.ThirdPartyReportAction
            if (r0 == 0) goto L_0x0021
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r1 = r8
            r2 = r9
            reportThirdPartyData$default(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x010c
        L_0x0021:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.thirdParty.ThirdPartyDisPlayAction
            if (r0 == 0) goto L_0x0032
            r3 = 1
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r1 = r8
            r2 = r9
            reportThirdPartyData$default(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x010c
        L_0x0032:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.banner.BannerAction.BannerClickAction
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x005f
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.banner.BannerAction$BannerClickAction r0 = (com.baidu.searchbox.video.feedflow.detail.banner.BannerAction.BannerClickAction) r0
            com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModel r0 = r0.getData()
            if (r0 == 0) goto L_0x0049
            boolean r0 = r0.getNeedh5Click()
            if (r0 != r1) goto L_0x0049
            r0 = r1
            goto L_0x004a
        L_0x0049:
            r0 = r2
        L_0x004a:
            if (r0 == 0) goto L_0x010c
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.banner.BannerAction$BannerClickAction r0 = (com.baidu.searchbox.video.feedflow.detail.banner.BannerAction.BannerClickAction) r0
            com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModel r0 = r0.getData()
            java.lang.String r0 = r0.getDxxh5ItemId()
            r8.reportThirdPartyData(r9, r2, r1, r0)
            goto L_0x010c
        L_0x005f:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.banner.goods.AutoPopupBigBannerItemClickAction
            r3 = 0
            if (r0 == 0) goto L_0x008d
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.banner.goods.AutoPopupBigBannerItemClickAction r0 = (com.baidu.searchbox.video.feedflow.detail.banner.goods.AutoPopupBigBannerItemClickAction) r0
            com.baidu.searchbox.video.inf.ListPanelItemModel r0 = r0.getModel()
            java.lang.Object r0 = r0.getData()
            boolean r4 = r0 instanceof com.baidu.searchbox.video.feedflow.detail.banner.model.StarSelectedModel
            if (r4 == 0) goto L_0x0076
            r3 = r0
            com.baidu.searchbox.video.feedflow.detail.banner.model.StarSelectedModel r3 = (com.baidu.searchbox.video.feedflow.detail.banner.model.StarSelectedModel) r3
        L_0x0076:
            if (r3 == 0) goto L_0x010c
            r0 = r3
            r3 = 0
            boolean r4 = r0.getNeedh5Click()
            if (r4 == 0) goto L_0x008a
            java.lang.String r4 = r0.getDxxh5ItemId()
            r8.reportThirdPartyData(r9, r2, r1, r4)
        L_0x008a:
            goto L_0x010c
        L_0x008d:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction
            if (r0 == 0) goto L_0x00cd
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction r0 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction) r0
            com.baidu.searchbox.video.inf.ListPanelItemModel r0 = r0.getModel()
            java.lang.String r0 = r0.getLayout()
            java.lang.String r4 = "common_panel"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x010c
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction r0 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction) r0
            com.baidu.searchbox.video.inf.ListPanelItemModel r0 = r0.getModel()
            java.lang.Object r0 = r0.getData()
            boolean r4 = r0 instanceof com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel
            if (r4 == 0) goto L_0x00b6
            r3 = r0
            com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel r3 = (com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel) r3
        L_0x00b6:
            if (r3 == 0) goto L_0x010c
            r0 = r3
            r3 = 0
            boolean r4 = r0.getNeedh5Click()
            if (r4 == 0) goto L_0x00cb
            java.lang.String r4 = r0.getDxxh5ItemId()
            r8.reportThirdPartyData(r9, r2, r1, r4)
        L_0x00cb:
            goto L_0x010c
        L_0x00cd:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction
            if (r0 == 0) goto L_0x010c
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction r0 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction) r0
            com.baidu.searchbox.video.inf.ListPanelItemModel r0 = r0.getModel()
            java.lang.String r0 = r0.getLayout()
            java.lang.String r4 = "download_panel"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x010c
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction r0 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction) r0
            com.baidu.searchbox.video.inf.ListPanelItemModel r0 = r0.getModel()
            java.lang.Object r0 = r0.getData()
            boolean r4 = r0 instanceof com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel
            if (r4 == 0) goto L_0x00f6
            r3 = r0
            com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel r3 = (com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel) r3
        L_0x00f6:
            if (r3 == 0) goto L_0x010c
            r0 = r3
            r3 = 0
            boolean r4 = r0.getNeedh5Click()
            if (r4 == 0) goto L_0x010b
            java.lang.String r4 = r0.getDxxh5ItemId()
            r8.reportThirdPartyData(r9, r2, r1, r4)
        L_0x010b:
        L_0x010c:
            com.baidu.searchbox.feed.detail.frame.Action r0 = r11.next(r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.thirdParty.statistic.ThirdPartyStatisticMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }

    static /* synthetic */ void reportThirdPartyData$default(ThirdPartyStatisticMiddleware thirdPartyStatisticMiddleware, Store store, boolean z, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        if ((i2 & 8) != 0) {
            str = "";
        }
        thirdPartyStatisticMiddleware.reportThirdPartyData(store, z, z2, str);
    }

    private final void reportThirdPartyData(Store<CommonState> store, boolean isDisplay, boolean isFromBanner, String dxxh5ItemId) {
        String markId = new StringBuilder().append(getRandom().nextInt(10000)).append(GroupMemberAdapter.MANAGER_CHAR).append(System.currentTimeMillis()).toString();
        String value = isDisplay ? "show" : "read";
        JSONArray action = new JSONArray();
        if (!isFromBanner) {
            VideoFlowUBCHelper videoFlowUBCHelper = VideoFlowUBCHelper.INSTANCE;
            CommonState state = store.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            if (commonState != null) {
                obj = commonState.select(UbcBean.class);
            }
            JSONObject $this$reportThirdPartyData_u24lambda_u2d3 = new JSONObject();
            $this$reportThirdPartyData_u24lambda_u2d3.put("getUrlNum", markId);
            Unit unit = Unit.INSTANCE;
            videoFlowUBCHelper.upload6306((UbcBean) obj, "start", value, $this$reportThirdPartyData_u24lambda_u2d3);
            JSONArray $this$reportThirdPartyData_u24lambda_u2d4 = action;
            if (isDisplay) {
                $this$reportThirdPartyData_u24lambda_u2d4.put("show");
                $this$reportThirdPartyData_u24lambda_u2d4.put("click");
            } else {
                $this$reportThirdPartyData_u24lambda_u2d4.put("read");
            }
            Store<CommonState> store2 = store;
        } else {
            VideoFlowUBCHelper videoFlowUBCHelper2 = VideoFlowUBCHelper.INSTANCE;
            JSONObject $this$reportThirdPartyData_u24lambda_u2d5 = new JSONObject();
            $this$reportThirdPartyData_u24lambda_u2d5.put("getUrlNum", markId);
            Unit unit2 = Unit.INSTANCE;
            videoFlowUBCHelper2.upload6581Ubc(store, "start", "click", $this$reportThirdPartyData_u24lambda_u2d5);
            action.put("h5_click");
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new ThirdPartyStatisticMiddleware$reportThirdPartyData$5(store, isFromBanner, dxxh5ItemId, action, isDisplay, value, markId, (Continuation<? super ThirdPartyStatisticMiddleware$reportThirdPartyData$5>) null), 2, (Object) null);
    }
}
