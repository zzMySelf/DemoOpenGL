package com.baidu.searchbox.mvp.publishresult;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.dynamicpublisher.task.BdTaskManager;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.mvp.common.MvpCommonPageChangeAction;
import com.baidu.searchbox.mvp.common.MvpCommonPageExtKt;
import com.baidu.searchbox.mvp.common.MvpCommonPageId;
import com.baidu.searchbox.mvp.common.MvpCommonPageModel;
import com.baidu.searchbox.mvp.common.MvpUbcUtil;
import com.baidu.searchbox.mvp.common.MvpUbcUtilKt;
import com.baidu.searchbox.mvp.container.IMvpLayoutManagerService;
import com.baidu.searchbox.mvp.util.MvpTransitionUtil;
import com.baidu.searchbox.mvp.widget.PublishResultShareView;
import com.baidu.searchbox.ugc.model.MvpTask;
import com.baidu.searchbox.ugc.utils.CardAnimationUtil;
import com.baidu.searchbox.ugc.utils.UgcSharePrefsUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nl.dionsegijn.konfetti.xml.KonfettiView;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\u0012\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/mvp/publishresult/MvpPublishResultComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "autoClose", "", "getAutoClose", "()Z", "autoClose$delegate", "Lkotlin/Lazy;", "isPublishSuc", "Ljava/lang/Boolean;", "konfettiView", "Lnl/dionsegijn/konfetti/xml/KonfettiView;", "nid", "", "publishResultView", "Lcom/baidu/searchbox/mvp/widget/PublishResultShareView;", "getPublishResultView", "()Lcom/baidu/searchbox/mvp/widget/PublishResultShareView;", "publishResultView$delegate", "rootView", "Landroid/view/ViewGroup;", "createView", "Landroid/view/View;", "getNid", "getValue", "goHomePage", "", "onAttachToManager", "onCheckTask", "Lcom/baidu/searchbox/ugc/model/MvpTask;", "onRelease", "publishSucAction", "showBlindBoxScatterflowers", "ubcReport", "type", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MvpPublishResultComponent.kt */
public final class MvpPublishResultComponent extends LiveDataComponent {
    private final Lazy autoClose$delegate = LazyKt.lazy(new MvpPublishResultComponent$autoClose$2(this));
    private Boolean isPublishSuc = false;
    /* access modifiers changed from: private */
    public KonfettiView konfettiView;
    private String nid;
    private final Lazy publishResultView$delegate = LazyKt.lazy(new MvpPublishResultComponent$publishResultView$2(this));
    /* access modifiers changed from: private */
    public ViewGroup rootView;

    private final PublishResultShareView getPublishResultView() {
        return (PublishResultShareView) this.publishResultView$delegate.getValue();
    }

    private final boolean getAutoClose() {
        return ((Boolean) this.autoClose$delegate.getValue()).booleanValue();
    }

    public View createView() {
        getPublishResultView().setGoFeedBackAction(new MvpPublishResultComponent$createView$1(this));
        getPublishResultView().setGoHomePageAction(new MvpPublishResultComponent$createView$2(this));
        getPublishResultView().setVisibility(8);
        return getPublishResultView();
    }

    public void onAttachToManager() {
        MvpPublishResultState $this$onAttachToManager_u24lambda_u2d5;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d5 = (MvpPublishResultState) store.subscribe((Class<T>) MvpPublishResultState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d5.getShow().observe(this, new MvpPublishResultComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d5.isPublishSuc().observe(this, new MvpPublishResultComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d5.getNid().observe(this, new MvpPublishResultComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d5.getTitle().observe(this, new MvpPublishResultComponent$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-0  reason: not valid java name */
    public static final void m1462onAttachToManager$lambda5$lambda0(MvpPublishResultComponent this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.ubcReport("display");
            MvpTransitionUtil.INSTANCE.show(this$0.getPublishResultView());
            return;
        }
        MvpTransitionUtil.INSTANCE.hide(this$0.getPublishResultView());
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-2  reason: not valid java name */
    public static final void m1463onAttachToManager$lambda5$lambda2(MvpPublishResultComponent this$0, Boolean it) {
        String taskId;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isPublishSuc = it;
        this$0.getPublishResultView().showPublishFailed(!it.booleanValue());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            MvpTask result = this$0.onCheckTask();
            if (!(result == null || (taskId = result.getTaskId()) == null || !Intrinsics.areEqual((Object) result.getTaskType(), (Object) "publish"))) {
                BdTaskManager.INSTANCE.onTimeCountMissionCompleted(taskId);
            }
            if (!UgcSharePrefsUtils.getMvpPublisherPublishSuc()) {
                UgcSharePrefsUtils.putMvpPublisherPublishSuc();
                this$0.showBlindBoxScatterflowers();
                return;
            }
            this$0.publishSucAction();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-3  reason: not valid java name */
    public static final void m1464onAttachToManager$lambda5$lambda3(MvpPublishResultComponent this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.nid = it;
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-4  reason: not valid java name */
    public static final void m1465onAttachToManager$lambda5$lambda4(MvpPublishResultComponent this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPublishResultView().renderTitle(it);
    }

    private final void showBlindBoxScatterflowers() {
        IMvpLayoutManagerService iMvpLayoutManagerService = (IMvpLayoutManagerService) getManager().getService(IMvpLayoutManagerService.class);
        ViewGroup rootContainer = iMvpLayoutManagerService != null ? iMvpLayoutManagerService.getRootContainer() : null;
        this.rootView = rootContainer;
        if (rootContainer != null) {
            ViewGroup viewGroup = rootContainer;
            KonfettiView addKonfettiViewView = CardAnimationUtil.addKonfettiViewView(rootContainer, new MvpPublishResultComponent$showBlindBoxScatterflowers$1$1(this));
            this.konfettiView = addKonfettiViewView;
            CardAnimationUtil.festive(addKonfettiViewView);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = (com.baidu.searchbox.mvp.common.MvpCommonState) (r0 = r0.getState()).select(com.baidu.searchbox.mvp.common.MvpCommonState.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void goHomePage() {
        /*
            r11 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r11.getStore()
            if (r0 == 0) goto L_0x001d
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x001d
            java.lang.Class<com.baidu.searchbox.mvp.common.MvpCommonState> r1 = com.baidu.searchbox.mvp.common.MvpCommonState.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.mvp.common.MvpCommonState r0 = (com.baidu.searchbox.mvp.common.MvpCommonState) r0
            if (r0 == 0) goto L_0x001d
            com.baidu.searchbox.mvp.common.MvpCommonPageId r0 = r0.getFirstPageId()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 == 0) goto L_0x003c
            r2 = r0
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.Store r8 = r11.getStore()
            if (r8 == 0) goto L_0x003c
            com.baidu.searchbox.mvp.common.MvpCommonPageChangeAction$ChangeCommonPageAction r9 = new com.baidu.searchbox.mvp.common.MvpCommonPageChangeAction$ChangeCommonPageAction
            com.baidu.searchbox.mvp.common.MvpCommonPageModel r10 = new com.baidu.searchbox.mvp.common.MvpCommonPageModel
            r3 = 0
            r4 = 1
            r5 = 2
            r6 = 0
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            r9.<init>(r10)
            com.baidu.searchbox.feed.detail.frame.Action r9 = (com.baidu.searchbox.feed.detail.frame.Action) r9
            r8.dispatch(r9)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.mvp.publishresult.MvpPublishResultComponent.goHomePage():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        r0 = (r0 = (com.baidu.searchbox.mvp.common.MvpCommonState) (r0 = r0.getState()).select(com.baidu.searchbox.mvp.common.MvpCommonState.class)).getInitModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.ugc.model.MvpTask onCheckTask() {
        /*
            r3 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r3.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0024
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x0024
            java.lang.Class<com.baidu.searchbox.mvp.common.MvpCommonState> r2 = com.baidu.searchbox.mvp.common.MvpCommonState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.mvp.common.MvpCommonState r0 = (com.baidu.searchbox.mvp.common.MvpCommonState) r0
            if (r0 == 0) goto L_0x0024
            com.baidu.searchbox.mvp.common.MvpInitModel r0 = r0.getInitModel()
            if (r0 == 0) goto L_0x0024
            com.baidu.searchbox.ugc.webjs.UgcSchemeModel r0 = r0.getUgcSchemeModel()
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            com.baidu.searchbox.ugc.model.MvpTask$Companion r2 = com.baidu.searchbox.ugc.model.MvpTask.Companion
            boolean r2 = r2.checkIsInTask(r0)
            if (r2 == 0) goto L_0x0033
            if (r0 == 0) goto L_0x0032
            com.baidu.searchbox.ugc.model.MvpTask r1 = r0.taskInfo
        L_0x0032:
            return r1
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.mvp.publishresult.MvpPublishResultComponent.onCheckTask():com.baidu.searchbox.ugc.model.MvpTask");
    }

    /* access modifiers changed from: private */
    public final void publishSucAction() {
        Store<AbsState> store;
        if (getAutoClose()) {
            Store<AbsState> store2 = getStore();
            if (store2 != null) {
                StoreExtKt.postDelay(store2, MvpCommonPageChangeAction.CloseMvpPublisher.INSTANCE, 3000);
                return;
            }
            return;
        }
        MvpTask result = onCheckTask();
        if (result == null || !Intrinsics.areEqual((Object) result.getTaskType(), (Object) "publish")) {
            Store<AbsState> store3 = getStore();
            if (store3 != null) {
                StoreExtKt.postDelay(store3, new MvpCommonPageChangeAction.ChangeCommonPageAction(new MvpCommonPageModel(MvpCommonPageId.RECOMMEND_CARD, (Object) null, true, 2, (DefaultConstructorMarker) null)), 5000);
            }
        } else if (result.getTaskId() != null && (store = getStore()) != null) {
            StoreExtKt.postDelay(store, MvpCommonPageChangeAction.CloseMvpPublisher.INSTANCE, 5000);
        }
    }

    /* access modifiers changed from: private */
    public final void ubcReport(String type) {
        ComponentArchManager manager = getManager();
        String value = getValue();
        Store<AbsState> store = getStore();
        String sourceFrom = store != null ? MvpCommonPageExtKt.getSourceFrom(store) : null;
        String mvpCardType = MvpUbcUtilKt.getMvpCardType(getManager());
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$ubcReport_u24lambda_u2d9 = jSONObject;
        String nid2 = getNid();
        CharSequence charSequence = nid2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            $this$ubcReport_u24lambda_u2d9.put("nid", nid2);
        }
        $this$ubcReport_u24lambda_u2d9.put("card_id", MvpUbcUtilKt.getMvpCardId(getManager()));
        MvpUbcUtilKt.mvpUbcEvent7502$default(manager, mvpCardType, MvpUbcUtil.MVP_PUBLISH_PAGE, type, sourceFrom, value, jSONObject, false, 64, (Object) null);
    }

    private final String getValue() {
        String errorReason;
        AbsState state;
        MvpPublishResultState it;
        AbsState state2;
        MvpPublishResultState mvpPublishResultState;
        MutableLiveData<MvpPublishResultModel> mvpResultModel;
        MvpPublishResultModel value;
        Store<AbsState> store = getStore();
        if (store == null || (state2 = store.getState()) == null || (mvpPublishResultState = (MvpPublishResultState) state2.select(MvpPublishResultState.class)) == null || (mvpResultModel = mvpPublishResultState.getMvpResultModel()) == null || (value = mvpResultModel.getValue()) == null) {
            errorReason = null;
        } else {
            errorReason = value.getErrorReason();
        }
        if (!TextUtils.isEmpty(errorReason)) {
            return errorReason;
        }
        Store<AbsState> store2 = getStore();
        if (store2 == null || (state = store2.getState()) == null || (it = (MvpPublishResultState) state.select(MvpPublishResultState.class)) == null || !Intrinsics.areEqual((Object) it.isPublishSuc().getValue(), (Object) true)) {
            return "publish_error";
        }
        return "publish_success";
    }

    private final String getNid() {
        AbsState state;
        MvpPublishResultState it;
        String str = null;
        Store<AbsState> store = getStore();
        if (!(store == null || (state = store.getState()) == null || (it = (MvpPublishResultState) state.select(MvpPublishResultState.class)) == null || !Intrinsics.areEqual((Object) it.isPublishSuc().getValue(), (Object) true))) {
            str = it.getNid().getValue();
        }
        return str;
    }

    public void onRelease() {
        super.onRelease();
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            viewGroup.removeView(this.konfettiView);
        }
    }
}
