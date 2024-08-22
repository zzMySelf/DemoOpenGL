package com.baidu.searchbox.sport.olympic.sport.sportspanel.panel;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.event.OpenUrlEvent;
import com.baidu.searchbox.sport.page.olympic.schedule.SchemeUtilsKt;
import com.baidu.searchbox.sport.page.olympic.schedule.comp.OlympicScheduleConfig;
import com.baidu.searchbox.sport.page.olympic.schedule.item.base.BaseOlympicSchModel;
import com.baidu.searchbox.sport.page.olympic.schedule.item.multimatch.OlympicSchMultiMatchModel;
import com.baidu.searchbox.sport.page.olympic.schedule.item.vsmatch.OlympicScheduleVSMatchModel;
import com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicChildScheduleList;
import com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicSchedule;
import com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicScheduleDate;
import com.baidu.searchbox.sport.page.olympic.schedule.model.repo.OlympicChildScheduleRepo;
import com.facebook.common.internal.Ints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscription;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001e\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/sport/sportspanel/panel/OlympicSchedulePanelViewModel;", "Lcom/baidu/searchbox/sport/olympic/sport/sportspanel/panel/BaseOlympicPanelViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "anchorPosition", "Landroidx/lifecycle/MutableLiveData;", "", "getAnchorPosition", "()Landroidx/lifecycle/MutableLiveData;", "config", "Lcom/baidu/searchbox/sport/page/olympic/schedule/comp/OlympicScheduleConfig;", "getConfig", "()Lcom/baidu/searchbox/sport/page/olympic/schedule/comp/OlympicScheduleConfig;", "setConfig", "(Lcom/baidu/searchbox/sport/page/olympic/schedule/comp/OlympicScheduleConfig;)V", "parentId", "", "getParentId", "()Ljava/lang/String;", "setParentId", "(Ljava/lang/String;)V", "anchorToTargetSchedule", "", "schedule", "Lcom/baidu/searchbox/sport/page/olympic/schedule/model/OlympicSchedule;", "appendChildSchedules", "dataList", "", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "generateItemModel", "Lcom/baidu/searchbox/sport/page/olympic/schedule/item/base/BaseOlympicSchModel;", "backgroundRes", "getScheduleRepo", "Lrx/Subscription;", "jumpToScheduleDetail", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicSchedulePanelViewModel.kt */
public final class OlympicSchedulePanelViewModel extends BaseOlympicPanelViewModel {
    private final MutableLiveData<Integer> anchorPosition = new MutableLiveData<>();
    private OlympicScheduleConfig config;
    private String parentId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OlympicSchedulePanelViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final void setParentId(String str) {
        this.parentId = str;
    }

    public final OlympicScheduleConfig getConfig() {
        return this.config;
    }

    public final void setConfig(OlympicScheduleConfig olympicScheduleConfig) {
        this.config = olympicScheduleConfig;
    }

    public final MutableLiveData<Integer> getAnchorPosition() {
        return this.anchorPosition;
    }

    private final void appendChildSchedules(List<OlympicSchedule> dataList, UniqueId token) {
        for (OlympicSchedule it : dataList) {
            addMapping(it, generateItemModel$default(this, it, token, 0, 4, (Object) null));
        }
    }

    private final BaseOlympicSchModel generateItemModel(OlympicSchedule schedule, UniqueId token, int backgroundRes) {
        if (schedule.isVS()) {
            return new OlympicScheduleVSMatchModel(schedule, (OlympicScheduleDate) null, (OlympicSchedule) null, token, backgroundRes);
        }
        return new OlympicSchMultiMatchModel(schedule, (OlympicScheduleDate) null, (OlympicSchedule) null, token, backgroundRes);
    }

    static /* synthetic */ BaseOlympicSchModel generateItemModel$default(OlympicSchedulePanelViewModel olympicSchedulePanelViewModel, OlympicSchedule olympicSchedule, UniqueId uniqueId, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return olympicSchedulePanelViewModel.generateItemModel(olympicSchedule, uniqueId, i2);
    }

    public final void jumpToScheduleDetail(OlympicSchedule schedule) {
        UniqueId $this$jumpToScheduleDetail_u24lambda_u2d1;
        if (schedule != null && ($this$jumpToScheduleDetail_u24lambda_u2d1 = getToken()) != null) {
            BdEventBus.Companion.getDefault().post(new OpenUrlEvent($this$jumpToScheduleDetail_u24lambda_u2d1, SchemeUtilsKt.buildScheduleScheme(schedule, this.config)));
        }
    }

    public Subscription getScheduleRepo() {
        Subscription subscribe = OlympicChildScheduleRepo.Companion.getChildScheduleRepo().getChildSchedules(this.parentId).subscribe(new OlympicSchedulePanelViewModel$$ExternalSyntheticLambda0(this), new OlympicSchedulePanelViewModel$$ExternalSyntheticLambda1(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "OlympicChildScheduleRepo…r: ${it.message}\")\n    })");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: getScheduleRepo$lambda-3  reason: not valid java name */
    public static final void m3588getScheduleRepo$lambda3(OlympicSchedulePanelViewModel this$0, OlympicChildScheduleList it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isShowLoading().setValue(false);
        this$0.isShowErrorView().setValue(false);
        this$0.clearData();
        UniqueId token = super.getToken();
        if (token != null) {
            if (it == null || it.getSchedules().isEmpty()) {
                this$0.isShowErrorView().setValue(true);
                return;
            }
            OlympicChildScheduleList $this$getScheduleRepo_u24lambda_u2d3_u24lambda_u2d2 = it;
            this$0.appendChildSchedules($this$getScheduleRepo_u24lambda_u2d3_u24lambda_u2d2.getSchedules(), token);
            this$0.anchorToTargetSchedule($this$getScheduleRepo_u24lambda_u2d3_u24lambda_u2d2.getSelectedSchedule());
            this$0.getPanelContainerHeight().setValue(Integer.valueOf(this$0.getMinHeight()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getScheduleRepo$lambda-4  reason: not valid java name */
    public static final void m3589getScheduleRepo$lambda4(OlympicSchedulePanelViewModel this$0, Throwable it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isShowLoading().setValue(false);
        this$0.isShowErrorView().setValue(true);
        if (AppConfig.isDebug()) {
            Log.d("OlympicSchedulePanelVM", "loadError: " + it.getMessage());
        }
    }

    private final void anchorToTargetSchedule(OlympicSchedule schedule) {
        if (schedule != null) {
            this.anchorPosition.setValue(Integer.valueOf(Ints.max(0, indexOfKey(schedule))));
        }
    }
}
