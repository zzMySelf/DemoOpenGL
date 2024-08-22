package com.baidu.searchbox.video.feedflow.detail.floating.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.PowerManager;
import android.view.Window;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.searchbox.MessageSchemeManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.export.IVideoFeedReportUtils;
import com.baidu.searchbox.video.detail.export.IVideoSearchBeeUtils;
import com.baidu.searchbox.video.detail.export.ReportClick;
import com.baidu.searchbox.video.detail.export.ReportShow;
import com.baidu.searchbox.video.detail.export.ShowItem;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.player.player.VideoFlowPlayer;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.list.BatchItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.CommonItemData;
import com.baidu.searchbox.video.feedflow.flow.list.DynamicItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.InterestItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.trace.PageIdManagerStateKt;
import com.baidu.searchbox.video.feedflow.ubc.UBC6101Or6102;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import com.baidu.swan.api.SwanAppApi;
import com.baidu.swan.games.view.desktopguide.DesktopGuideConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rH\u0002\u001a\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001c\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002\u001aU\u0010\u0015\u001a\u00020\u00162\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001f\u001a\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0011\u001a\u0012\u0010\"\u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0011\u001a\u001a\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0002\u001a\u0012\u0010&\u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0011\u001a\u0010\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)\u001a\u0006\u0010*\u001a\u00020\u000b\u001a\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-H\u0002\u001a\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u000200H\u0002\u001ac\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u00103\u001a\u0006\u0012\u0002\b\u00030\r2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u00104\u001a*\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\u0006\u00109\u001a\u00020\u0002\u001a7\u0010:\u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\u00112%\b\u0002\u0010;\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u000f\u0018\u00010<\u001a9\u0010@\u001a\u0004\u0018\u00010A2\b\u0010!\u001a\u0004\u0018\u00010\u00112%\b\u0002\u0010;\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u000f\u0018\u00010<\u001a\f\u0010B\u001a\u00020\u000b*\u0004\u0018\u00010C\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u000e\u0010\t\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"BANNER_AUTO_SHOW_FLOATING_WHITE_LIST", "", "", "DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST", "Ljava/util/ArrayList;", "getDISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST", "()Ljava/util/ArrayList;", "NEED_FINISH_ACTIVITY_LIST", "getNEED_FINISH_ACTIVITY_LIST", "REQUEST_PARAM_SMALL_WINDOW", "checkValidModel", "", "model", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "finishAllTopOfTargetActivity", "", "targetActivity", "Landroid/app/Activity;", "fixFrom", "from", "page", "getExt", "Lorg/json/JSONObject;", "intentData", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "autoPlayNext", "isManualInvoke", "source", "pageId", "pageSq", "", "(Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;Lcom/baidu/searchbox/video/detail/core/model/IntentData;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lorg/json/JSONObject;", "isActivityFinish", "activity", "isFlowPage", "isInAutoShowFloatingWhiteList", "cmd", "bannerType", "isNeedFinishListPage", "isScreenOn", "context", "Landroid/content/Context;", "isSwanProcessForeground", "reportData", "reportClick", "Lcom/baidu/searchbox/video/detail/export/ReportClick;", "reportDataSync", "reportShow", "Lcom/baidu/searchbox/video/detail/export/ReportShow;", "reportShowAndClick", "pos", "curItemModel", "(ILcom/baidu/searchbox/video/detail/core/model/IntentData;Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "reportUbc6101Or6102", "ubcId", "type", "value", "triggerSource", "showGuideDialog", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isOk", "showRetainFloatingDialog", "Lcom/baidu/android/ext/widget/dialog/BoxAlertDialog;", "isPlayerActiveStatus", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/VideoFlowPlayer;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowFloatingUtils.kt */
public final class FlowFloatingUtilsKt {
    private static final List<String> BANNER_AUTO_SHOW_FLOATING_WHITE_LIST = CollectionsKt.listOf("poi");
    private static final ArrayList<String> DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST;
    private static final ArrayList<String> NEED_FINISH_ACTIVITY_LIST;
    public static final String REQUEST_PARAM_SMALL_WINDOW = "small_window";

    static {
        ArrayList arrayList = new ArrayList(5);
        ArrayList $this$DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST_u24lambda_u2d0 = arrayList;
        $this$DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST_u24lambda_u2d0.add(MessageSchemeManager.IM_CHECK_VIDEO_FLOW_ACTIVITY);
        $this$DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST_u24lambda_u2d0.add("com.baidu.searchbox.video.collectionflow.CollectionFlowActivity");
        $this$DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST_u24lambda_u2d0.add("com.baidu.searchbox.video.feedflow.tab.VideoTabActivity");
        $this$DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST_u24lambda_u2d0.add("com.baidu.searchbox.video.linkageflow.VideoFlowLinkageHalfActivity");
        $this$DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST_u24lambda_u2d0.add("com.baidu.searchbox.video.linkageflow.VideoFlowLinkageFullActivity");
        DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST = arrayList;
        ArrayList $this$NEED_FINISH_ACTIVITY_LIST_u24lambda_u2d1 = new ArrayList(1);
        $this$NEED_FINISH_ACTIVITY_LIST_u24lambda_u2d1.add("com.baidu.share.core.handler.transactivity.BaiduHiTransActivity");
        NEED_FINISH_ACTIVITY_LIST = $this$NEED_FINISH_ACTIVITY_LIST_u24lambda_u2d1;
    }

    public static final ArrayList<String> getDISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST() {
        return DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST;
    }

    public static final ArrayList<String> getNEED_FINISH_ACTIVITY_LIST() {
        return NEED_FINISH_ACTIVITY_LIST;
    }

    public static /* synthetic */ void reportShowAndClick$default(int i2, IntentData intentData, ItemModel itemModel, boolean z, boolean z2, String str, String str2, Integer num, int i3, Object obj) {
        int i4;
        boolean z3;
        boolean z4;
        int i5 = i3;
        if ((i5 & 1) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i5 & 8) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i5 & 16) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        reportShowAndClick(i4, intentData, itemModel, z3, z4, (i5 & 32) != 0 ? "" : str, (i5 & 64) != 0 ? "" : str2, (i5 & 128) != 0 ? 0 : num);
    }

    public static final void reportShowAndClick(int pos, IntentData intentData, ItemModel<?> curItemModel, boolean autoPlayNext, boolean isManualInvoke, String source, String pageId, Integer pageSq) {
        JSONObject ext;
        ItemModel<?> itemModel = curItemModel;
        Intrinsics.checkNotNullParameter(itemModel, "curItemModel");
        if (intentData != null) {
            IntentData intentData2 = intentData;
            int position = pos < 0 ? curItemModel.getRunTimeStatus().getPosition() : pos;
            if (position >= 0 && checkValidModel(curItemModel)) {
                if (curItemModel.getData() instanceof VideoItemModel) {
                    ext = getExt(curItemModel, intentData2, autoPlayNext, isManualInvoke, source, pageId, pageSq);
                } else {
                    ext = new JSONObject();
                }
                VideoFlowUBCHelper.INSTANCE.appendVideoShowTypeExt(ext, itemModel);
                String fromFixed = fixFrom(intentData2.from, intentData2.page);
                String nid = curItemModel.getNid();
                String valueOf = String.valueOf(position);
                String jSONObject = ext.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "ext.toString()");
                reportData(new ReportClick(fromFixed, nid, "clk", valueOf, jSONObject, (String) null, (String) null, (String) null, (String) null, (JSONObject) null, DesktopGuideConstants.BAR_DEFAULT_WIDTH, (DefaultConstructorMarker) null));
                if (!curItemModel.getRunTimeStatus().isReportShow()) {
                    curItemModel.setToShown();
                    String nid2 = curItemModel.getNid();
                    String valueOf2 = String.valueOf(position);
                    String jSONObject2 = ext.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "ext.toString()");
                    reportDataSync(new ReportShow(fromFixed, "display", CollectionsKt.listOf(new ShowItem(nid2, valueOf2, jSONObject2, (String) null, 8, (DefaultConstructorMarker) null)), (String) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null));
                }
            }
        }
    }

    public static /* synthetic */ void reportUbc6101Or6102$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        reportUbc6101Or6102(str, str2, str3, str4);
    }

    public static final void reportUbc6101Or6102(String ubcId, String type, String value, String triggerSource) {
        Intrinsics.checkNotNullParameter(ubcId, "ubcId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(triggerSource, "triggerSource");
        VideoFlowUBCHelper.INSTANCE.upload6101Or6102Ubc(ubcId, type, value, triggerSource);
    }

    private static final boolean checkValidModel(ItemModel<?> model) {
        boolean z;
        boolean z2;
        boolean z3;
        Object data = model != null ? model.getData() : null;
        if (data instanceof VideoItemModel) {
            z = true;
        } else {
            z = data instanceof BatchItemModel;
        }
        if (z) {
            z2 = true;
        } else {
            z2 = data instanceof DynamicItemModel;
        }
        if (z2) {
            z3 = true;
        } else {
            z3 = data instanceof InterestItemModel;
        }
        if (z3) {
            return true;
        }
        return false;
    }

    static /* synthetic */ JSONObject getExt$default(ItemModel itemModel, IntentData intentData, boolean z, boolean z2, String str, String str2, Integer num, int i2, Object obj) {
        Integer num2;
        String str3 = (i2 & 16) != 0 ? "" : str;
        String str4 = (i2 & 32) != 0 ? "" : str2;
        if ((i2 & 64) != 0) {
            num2 = 0;
        } else {
            num2 = num;
        }
        return getExt(itemModel, intentData, z, z2, str3, str4, num2);
    }

    private static final JSONObject getExt(ItemModel<?> model, IntentData intentData, boolean autoPlayNext, boolean isManualInvoke, String source, String pageId, Integer pageSq) {
        String extString;
        JSONObject jSONObject;
        IntentData intentData2 = intentData;
        try {
            String page = intentData2.page;
            CommonItemData commonItemData = model.getCommonItemData();
            if (commonItemData == null || (extString = commonItemData.getExt()) == null) {
                extString = "";
            }
            int i2 = 1;
            JSONObject ext = StringsKt.isBlank(extString) ^ true ? new JSONObject(extString) : new JSONObject();
            ext.putOpt("status", "portrait");
            CommonItemData commonItemData2 = model.getCommonItemData();
            if (commonItemData2 == null || (jSONObject = commonItemData2.getExtLogJo()) == null) {
                String str = source;
                String str2 = pageId;
                Integer num = pageSq;
                jSONObject = null;
            } else {
                JSONObject $this$getExt_u24lambda_u2d3 = jSONObject;
                $this$getExt_u24lambda_u2d3.put("projection", 0);
                if (!autoPlayNext) {
                    i2 = 0;
                }
                $this$getExt_u24lambda_u2d3.putOpt("autoPlay", Integer.valueOf(i2));
                Boolean bool = intentData2.isColdLaunchRestore;
                Intrinsics.checkNotNullExpressionValue(bool, "intentData.isColdLaunchRestore");
                if (bool.booleanValue()) {
                    $this$getExt_u24lambda_u2d3.put("coldstart", "1");
                }
                $this$getExt_u24lambda_u2d3.putOpt("playerMode", "microplayer");
                $this$getExt_u24lambda_u2d3.putOpt("playerPosition", BdBoxActivityManager.isForeground() ? UBC6101Or6102.TriggerSource.TRIGGER_IN_APP : UBC6101Or6102.TriggerSource.TRIGGER_OUT_APP);
                $this$getExt_u24lambda_u2d3.putOpt("startMode", isManualInvoke ? "manual" : "auto");
                try {
                    $this$getExt_u24lambda_u2d3.putOpt("startSource", source);
                    try {
                        $this$getExt_u24lambda_u2d3.putOpt("page_id", pageId);
                    } catch (Exception e2) {
                        Integer num2 = pageSq;
                        return new JSONObject();
                    }
                    try {
                        $this$getExt_u24lambda_u2d3.putOpt(PageIdManagerStateKt.PARAMS_PAGE_SEQ, pageSq);
                        VideoFlowUBCHelper.INSTANCE.appendFoldScreenInfo($this$getExt_u24lambda_u2d3);
                        Unit unit = Unit.INSTANCE;
                    } catch (Exception e3) {
                        return new JSONObject();
                    }
                } catch (Exception e4) {
                    String str3 = pageId;
                    Integer num22 = pageSq;
                    return new JSONObject();
                }
            }
            ext.putOpt("ext_log", jSONObject);
            ext.putOpt("netType", DIFactory.INSTANCE.getNetType());
            ext.putOpt("page", page);
            return ext;
        } catch (Exception e5) {
            String str4 = source;
            String str32 = pageId;
            Integer num222 = pageSq;
            return new JSONObject();
        }
    }

    private static final String fixFrom(String from, String page) {
        if (Intrinsics.areEqual((Object) from, (Object) "search")) {
            return from;
        }
        String realFrom = page == null ? "land_page" : page;
        if (VideoBizUtilsKt.isUnstableFrom(realFrom)) {
            return realFrom;
        }
        return "land_page";
    }

    private static final void reportData(ReportClick reportClick) {
        IVideoFeedReportUtils.Impl.INSTANCE.get().reportData(reportClick);
    }

    private static final void reportDataSync(ReportShow reportShow) {
        IVideoFeedReportUtils.Impl.INSTANCE.get().reportDataSync(reportShow);
    }

    public static final boolean isPlayerActiveStatus(VideoFlowPlayer $this$isPlayerActiveStatus) {
        if ($this$isPlayerActiveStatus == null) {
            return false;
        }
        if ($this$isPlayerActiveStatus.isPlaying() || ($this$isPlayerActiveStatus.isPause() && $this$isPlayerActiveStatus.getPauseType() == 5)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void showGuideDialog$default(Activity activity, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        showGuideDialog(activity, function1);
    }

    public static final void showGuideDialog(Activity activity, Function1<? super Boolean, Unit> callback) {
        if (activity != null) {
            Activity activity2 = activity;
            if (!isActivityFinish(activity)) {
                try {
                    BoxAlertDialog alertDialog = new BoxAlertDialog.Builder(activity).setTitle(R.string.video_flow_floating_guide_dialog_title).setMessage(R.string.video_flow_floating_guide_dialog_message).setCancelable(false).setNegativeButton(R.string.video_flow_floating_guide_dialog_cancel, (DialogInterface.OnClickListener) new FlowFloatingUtilsKt$$ExternalSyntheticLambda0(callback)).setPositiveButton(R.string.video_flow_floating_guide_dialog_ok, (DialogInterface.OnClickListener) new FlowFloatingUtilsKt$$ExternalSyntheticLambda1(callback)).create();
                    Intrinsics.checkNotNullExpressionValue(alertDialog, "Builder(activity)\n      …                .create()");
                    alertDialog.show();
                } catch (Exception e2) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showGuideDialog$lambda-6$lambda-4  reason: not valid java name */
    public static final void m11370showGuideDialog$lambda6$lambda4(Function1 $callback, DialogInterface dialogInterface, int i2) {
        if ($callback != null) {
            $callback.invoke(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showGuideDialog$lambda-6$lambda-5  reason: not valid java name */
    public static final void m11371showGuideDialog$lambda6$lambda5(Function1 $callback, DialogInterface dialogInterface, int i2) {
        if ($callback != null) {
            $callback.invoke(true);
        }
    }

    public static /* synthetic */ BoxAlertDialog showRetainFloatingDialog$default(Activity activity, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        return showRetainFloatingDialog(activity, function1);
    }

    public static final BoxAlertDialog showRetainFloatingDialog(Activity activity, Function1<? super Boolean, Unit> callback) {
        Window window;
        if (activity != null) {
            Activity activity2 = activity;
            if (isActivityFinish(activity)) {
                return null;
            }
            try {
                BoxAlertDialog alertDialog = new BoxAlertDialog.Builder(activity).setTitle(R.string.video_flow_floating_retain_dialog_title).setMessage(R.string.video_flow_floating_retain_dialog_message).setCancelable(false).setNegativeButton(R.string.video_flow_floating_retain_dialog_cancel, (DialogInterface.OnClickListener) new FlowFloatingUtilsKt$$ExternalSyntheticLambda2(callback)).setPositiveButton(R.string.video_flow_floating_retain_dialog_ok, (DialogInterface.OnClickListener) new FlowFloatingUtilsKt$$ExternalSyntheticLambda3(callback)).create();
                Intrinsics.checkNotNullExpressionValue(alertDialog, "Builder(activity)\n      …                .create()");
                if (activity.getResources().getConfiguration().orientation == 2 && (window = alertDialog.getWindow()) != null) {
                    window.setLayout(DIFactory.INSTANCE.getDisplayHeight(), -2);
                }
                alertDialog.show();
                return alertDialog;
            } catch (Exception e2) {
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: showRetainFloatingDialog$lambda-9$lambda-7  reason: not valid java name */
    public static final void m11372showRetainFloatingDialog$lambda9$lambda7(Function1 $callback, DialogInterface dialogInterface, int i2) {
        if ($callback != null) {
            $callback.invoke(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showRetainFloatingDialog$lambda-9$lambda-8  reason: not valid java name */
    public static final void m11373showRetainFloatingDialog$lambda9$lambda8(Function1 $callback, DialogInterface dialogInterface, int i2) {
        if ($callback != null) {
            $callback.invoke(true);
        }
    }

    public static final boolean isActivityFinish(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed());
    }

    public static final void finishAllTopOfTargetActivity(Activity targetActivity) {
        Activity activity;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        LinkedList activityStack = BdBoxActivityManager.getActivityStack();
        if (activityStack != null) {
            for (int index = activityStack.size() - 1; index > 0; index--) {
                WeakReference activityWrapper = activityStack.get(index);
                if (!(activityWrapper == null || (activity = (Activity) activityWrapper.get()) == null)) {
                    if (!Intrinsics.areEqual((Object) activity, (Object) targetActivity)) {
                        activity.finish();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static final boolean isSwanProcessForeground() {
        return SwanAppApi.getSwanLifecycleRuntime().hasSwanProcessForeground();
    }

    public static final boolean isInAutoShowFloatingWhiteList(String cmd, String bannerType) {
        if (cmd == null) {
            return false;
        }
        boolean isMatchCmd = StringsKt.startsWith$default(cmd, "baiduboxapp://browser/invokeTalosBeeLandingPage", false, 2, (Object) null) || StringsKt.startsWith$default(cmd, "baiduboxapp://talos/invokeTalosPage", false, 2, (Object) null);
        boolean isMatchBannerType = CollectionsKt.contains(BANNER_AUTO_SHOW_FLOATING_WHITE_LIST, bannerType);
        if (!isMatchCmd || !isMatchBannerType) {
            return false;
        }
        return true;
    }

    public static final boolean isScreenOn(Context context) {
        PowerManager powerManager = null;
        Object systemService = context != null ? context.getSystemService("power") : null;
        if (systemService instanceof PowerManager) {
            powerManager = (PowerManager) systemService;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            if (powerManager == null || !powerManager.isInteractive()) {
                return false;
            }
            return true;
        } else if (powerManager == null || !powerManager.isScreenOn()) {
            return false;
        } else {
            return true;
        }
    }

    public static /* synthetic */ boolean isFlowPage$default(Activity activity, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            activity = null;
        }
        return isFlowPage(activity);
    }

    public static final boolean isFlowPage(Activity activity) {
        if (activity == null) {
            return false;
        }
        Activity curActivity = activity;
        if (IVideoSearchBeeUtils.Impl.INSTANCE.get().isSearchFlowCPage()) {
            return true;
        }
        return DISABLE_CLOSE_FLOATING_ON_ACTIVITY_START_LIST.contains(curActivity.getComponentName().getClassName());
    }

    public static /* synthetic */ boolean isNeedFinishListPage$default(Activity activity, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            activity = null;
        }
        return isNeedFinishListPage(activity);
    }

    public static final boolean isNeedFinishListPage(Activity activity) {
        if (activity != null) {
            return NEED_FINISH_ACTIVITY_LIST.contains(activity.getComponentName().getClassName());
        }
        return false;
    }
}
