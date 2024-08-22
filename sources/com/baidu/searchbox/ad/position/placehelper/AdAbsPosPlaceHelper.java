package com.baidu.searchbox.ad.position.placehelper;

import com.baidu.searchbox.ad.exp.adconfig.ADConfigManager;
import com.baidu.searchbox.ad.exp.adconfig.ADConfigUtil;
import com.baidu.searchbox.ad.position.strategy.AdPosInsertCase;
import com.baidu.searchbox.ad.position.strategy.AdPosStrategy;
import com.baidu.searchbox.ad.position.strategy.IDynamic2PosParams;
import com.baidu.searchbox.ad.position.strategy.IDynamicPosParams;
import com.baidu.searchbox.ad.position.strategy.IEvenPosParams;
import com.baidu.searchbox.ad.position.strategy.IResetSortParams;
import com.baidu.searchbox.ad.position.strategy.IScreenDistanceParams;
import com.baidu.searchbox.ad.position.type.IAdItemModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u0003*\u0004\b\u0002\u0010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u00052\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\u0012\u0004\u0012\u0002H\u00020\u00072\b\u0012\u0004\u0012\u0002H\u00020\b2\b\u0012\u0004\u0012\u0002H\u00020\t2\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\nB\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010N\u001a\u00020\rH\u0016J\u0017\u0010O\u001a\u0004\u0018\u00010\u00132\u0006\u0010P\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010QJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010R\u001a\u00020\rH\u0016J\u0017\u0010\u0012\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010SJ\b\u0010T\u001a\u00020\u0013H\u0016J\u0017\u0010\u0017\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010SJ\b\u0010U\u001a\u00020\u0013H\u0016J\u0017\u0010\u001a\u001a\u00020\u001b2\b\u0010P\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010VJ\b\u0010W\u001a\u00020\u001bH\u0016J\u0017\u0010\u001f\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010SJ\u0017\u0010X\u001a\u0004\u0018\u00010\u00132\u0006\u0010P\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010QJ\b\u0010Y\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010Z\u001a\u00020\rH\u0016J\u0017\u0010%\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010SJ\b\u0010[\u001a\u00020\u0013H\u0016J\b\u0010\\\u001a\u00020\u0013H\u0016J\u0017\u0010(\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010SJ\b\u0010]\u001a\u00020\u0013H\u0016J\b\u0010^\u001a\u00020\u0013H\u0016J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u0013H\u0016J\u0015\u0010_\u001a\u00020\u00132\u0006\u0010P\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010SJ\b\u00100\u001a\u00020\rH\u0016J\b\u0010`\u001a\u00020\rH\u0016J\b\u0010a\u001a\u00020\rH\u0016J\b\u0010b\u001a\u00020\rH\u0016J\b\u00106\u001a\u00020\u0013H\u0016J\b\u0010c\u001a\u00020\u0013H\u0016J\b\u0010d\u001a\u00020\rH\u0016J\b\u0010e\u001a\u00020\rH\u0016J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iH\u0016J\b\u00109\u001a\u00020\rH\u0016J\b\u0010j\u001a\u00020\rH\u0016J\b\u0010k\u001a\u00020\u0013H\u0016J\u0017\u0010<\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010SJ\b\u0010?\u001a\u00020\u0013H\u0016J\b\u0010l\u001a\u00020\u0013H\u0016J\b\u0010D\u001a\u00020\rH\u0016J\b\u0010m\u001a\u00020\rH\u0016J\u0017\u0010F\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010SJ\u0017\u0010H\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010SJ\b\u0010n\u001a\u00020\u0013H\u0016J\b\u0010o\u001a\u00020\u0013H\u0016J\u001d\u0010p\u001a\u00020g2\u0006\u0010P\u001a\u00028\u00012\u0006\u0010q\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010rJ\b\u0010J\u001a\u00020KH\u0016J\b\u0010s\u001a\u00020KH\u0016R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b \u0010\u0015R\u001b\u0010\"\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b#\u0010\u000fR\u001b\u0010%\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b&\u0010\u0015R\u001b\u0010(\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b)\u0010\u0015R\u001b\u0010+\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b-\u0010\u0011\u001a\u0004\b,\u0010\u0015R\u0014\u0010.\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0015R\u001b\u00100\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b2\u0010\u0011\u001a\u0004\b1\u0010\u000fR\u001b\u00103\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b5\u0010\u0011\u001a\u0004\b4\u0010\u000fR\u001b\u00106\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b7\u0010\u0015R\u001b\u00109\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b:\u0010\u000fR\u001b\u0010<\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b>\u0010\u0011\u001a\u0004\b=\u0010\u0015R\u001b\u0010?\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\bA\u0010\u0011\u001a\u0004\b@\u0010\u0015R\u0014\u0010B\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u000fR\u0014\u0010D\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u000fR\u0014\u0010F\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0015R\u0014\u0010H\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0015R\u0014\u0010J\u001a\u00020K8BX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006t"}, d2 = {"Lcom/baidu/searchbox/ad/position/placehelper/AdAbsPosPlaceHelper;", "E", "AD", "Lcom/baidu/searchbox/ad/position/type/IAdItemModel;", "UGC", "Lcom/baidu/searchbox/ad/position/strategy/IDynamicPosParams;", "Lcom/baidu/searchbox/ad/position/strategy/IDynamic2PosParams;", "Lcom/baidu/searchbox/ad/position/strategy/IScreenDistanceParams;", "Lcom/baidu/searchbox/ad/position/strategy/IEvenPosParams;", "Lcom/baidu/searchbox/ad/position/strategy/IResetSortParams;", "Lcom/baidu/searchbox/ad/position/placehelper/IAdPosPlaceHelper;", "()V", "adControlDynamicCountAdTimeSwitch", "", "getAdControlDynamicCountAdTimeSwitch", "()Z", "adControlDynamicCountAdTimeSwitch$delegate", "Lkotlin/Lazy;", "adControlDynamicIntervalMax", "", "getAdControlDynamicIntervalMax", "()I", "adControlDynamicIntervalMax$delegate", "adControlDynamicIntervalMin", "getAdControlDynamicIntervalMin", "adControlDynamicIntervalMin$delegate", "adControlDynamicScreenInterval", "", "getAdControlDynamicScreenInterval", "()F", "adControlDynamicScreenInterval$delegate", "adControlDynamicTimeInterval", "getAdControlDynamicTimeInterval", "adControlDynamicTimeInterval$delegate", "adControlDynamicTriggerAfterTimeSwitch", "getAdControlDynamicTriggerAfterTimeSwitch", "adControlDynamicTriggerAfterTimeSwitch$delegate", "adControlEvenInterval", "getAdControlEvenInterval", "adControlEvenInterval$delegate", "adControlFirstPos", "getAdControlFirstPos", "adControlFirstPos$delegate", "adControlFirstPvPos", "getAdControlFirstPvPos", "adControlFirstPvPos$delegate", "adControlFirstPvPosTimeReady", "getAdControlFirstPvPosTimeReady", "adControlInsertAfterRequestSwitch", "getAdControlInsertAfterRequestSwitch", "adControlInsertAfterRequestSwitch$delegate", "adControlInsertAfterRequestWithUserPos", "getAdControlInsertAfterRequestWithUserPos", "adControlInsertAfterRequestWithUserPos$delegate", "adControlInsertAhead", "getAdControlInsertAhead", "adControlInsertAhead$delegate", "adControlPvFallbackSwitch", "getAdControlPvFallbackSwitch", "adControlPvFallbackSwitch$delegate", "adControlRefreshFirstPos", "getAdControlRefreshFirstPos", "adControlRefreshFirstPos$delegate", "adControlRequestAhead", "getAdControlRequestAhead", "adControlRequestAhead$delegate", "adControlResetSortInsertRejectedAbandon", "getAdControlResetSortInsertRejectedAbandon", "adControlResetSortRequestAfterInsertRejected", "getAdControlResetSortRequestAfterInsertRejected", "adControlResetSortTimeInterval", "getAdControlResetSortTimeInterval", "adControlResetSortTimeInterval2", "getAdControlResetSortTimeInterval2", "adControlStrategyType", "Lcom/baidu/searchbox/ad/position/strategy/AdPosStrategy;", "getAdControlStrategyType", "()Lcom/baidu/searchbox/ad/position/strategy/AdPosStrategy;", "adControl2ndPvIn1stPos", "adControlDynamicBackFloor", "ad", "(Lcom/baidu/searchbox/ad/position/type/IAdItemModel;)Ljava/lang/Integer;", "adControlDynamicCountAdTimeSwitchDef", "(Lcom/baidu/searchbox/ad/position/type/IAdItemModel;)I", "adControlDynamicIntervalMaxDef", "adControlDynamicIntervalMinDef", "(Lcom/baidu/searchbox/ad/position/type/IAdItemModel;)F", "adControlDynamicScreenIntervalDef", "adControlDynamicTimeIntervalBackFloor", "adControlDynamicTimeIntervalDef", "adControlDynamicTriggerAfterTimeSwitchDef", "adControlEvenIntervalDef", "adControlFirstFloorDef", "adControlFirstPvFloorDef", "adControlFirstPvFloorTimeReadyDef", "adControlGetReqPos", "adControlInsertAfterRequestSwitchDef", "adControlInsertAfterRequestWithUserPosDef", "adControlInsertAfterRequestWithUserPosSwitch", "adControlInsertAheadDef", "adControlInsertRejectedAbandon", "adControlInsertRejectedAbandonDef", "adControlOnResetSortInsertRejected", "", "case", "Lcom/baidu/searchbox/ad/position/strategy/AdPosInsertCase;", "adControlPvFallbackSwitchDef", "adControlRefreshFirstFloorDef", "adControlRequestAheadDef", "adControlResetSortRequestAfterInsertRejectedDef", "adControlResetSortTimeIntervalDef", "adControlResetSortTimeIntervalDef2", "adControlSetReqPos", "reqPos", "(Lcom/baidu/searchbox/ad/position/type/IAdItemModel;I)V", "adControlStrategyTypeDef", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdAbsPosPlaceHelper.kt */
public abstract class AdAbsPosPlaceHelper<E, AD extends IAdItemModel, UGC> implements IDynamicPosParams<AD>, IDynamic2PosParams<AD>, IScreenDistanceParams<AD>, IEvenPosParams<AD>, IResetSortParams<AD>, IAdPosPlaceHelper<E, AD, UGC> {
    private final Lazy adControlDynamicCountAdTimeSwitch$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlDynamicCountAdTimeSwitch$2(this));
    private final Lazy adControlDynamicIntervalMax$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlDynamicIntervalMax$2(this));
    private final Lazy adControlDynamicIntervalMin$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlDynamicIntervalMin$2(this));
    private final Lazy adControlDynamicScreenInterval$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlDynamicScreenInterval$2(this));
    private final Lazy adControlDynamicTimeInterval$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlDynamicTimeInterval$2(this));
    private final Lazy adControlDynamicTriggerAfterTimeSwitch$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlDynamicTriggerAfterTimeSwitch$2(this));
    private final Lazy adControlEvenInterval$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlEvenInterval$2(this));
    private final Lazy adControlFirstPos$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlFirstPos$2(this));
    private final Lazy adControlFirstPvPos$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlFirstPvPos$2(this));
    private final Lazy adControlInsertAfterRequestSwitch$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlInsertAfterRequestSwitch$2(this));
    private final Lazy adControlInsertAfterRequestWithUserPos$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlInsertAfterRequestWithUserPos$2(this));
    private final Lazy adControlInsertAhead$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlInsertAhead$2(this));
    private final Lazy adControlPvFallbackSwitch$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlPvFallbackSwitch$2(this));
    private final Lazy adControlRefreshFirstPos$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlRefreshFirstPos$2(this));
    private final Lazy adControlRequestAhead$delegate = LazyKt.lazy(new AdAbsPosPlaceHelper$adControlRequestAhead$2(this));

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AdAbsPosPlaceHelper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdPosStrategy.values().length];
            iArr[AdPosStrategy.RESET_SORT.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int getAdControlFirstPvPos() {
        return ((Number) this.adControlFirstPvPos$delegate.getValue()).intValue();
    }

    private final int getAdControlFirstPvPosTimeReady() {
        return ADConfigManager.instance().getGlobalConfInt("ad_control_first_pv_floor_time_ready_" + adControlPlaceDesc().desc(), adControlFirstPvFloorTimeReadyDef()) - 1;
    }

    private final int getAdControlFirstPos() {
        return ((Number) this.adControlFirstPos$delegate.getValue()).intValue();
    }

    private final int getAdControlRefreshFirstPos() {
        return ((Number) this.adControlRefreshFirstPos$delegate.getValue()).intValue();
    }

    private final boolean getAdControlInsertAfterRequestSwitch() {
        return ((Boolean) this.adControlInsertAfterRequestSwitch$delegate.getValue()).booleanValue();
    }

    private final boolean getAdControlInsertAfterRequestWithUserPos() {
        return ((Boolean) this.adControlInsertAfterRequestWithUserPos$delegate.getValue()).booleanValue();
    }

    private final int getAdControlRequestAhead() {
        return ((Number) this.adControlRequestAhead$delegate.getValue()).intValue();
    }

    private final int getAdControlInsertAhead() {
        return ((Number) this.adControlInsertAhead$delegate.getValue()).intValue();
    }

    private final boolean getAdControlPvFallbackSwitch() {
        return ((Boolean) this.adControlPvFallbackSwitch$delegate.getValue()).booleanValue();
    }

    private final AdPosStrategy getAdControlStrategyType() {
        String type = ADConfigManager.instance().getPlaceConfStr(getPlaceId(), "ad_control_pos_strategy_type", adControlStrategyTypeDef().getDesc());
        if (type == null) {
            type = "";
        }
        if (Intrinsics.areEqual((Object) type, (Object) AdPosStrategy.EVEN.getDesc())) {
            return AdPosStrategy.EVEN;
        }
        if (Intrinsics.areEqual((Object) type, (Object) AdPosStrategy.DYNAMIC.getDesc())) {
            return AdPosStrategy.DYNAMIC;
        }
        if (Intrinsics.areEqual((Object) type, (Object) AdPosStrategy.DYNAMIC2.getDesc())) {
            return AdPosStrategy.DYNAMIC2;
        }
        return adControlStrategyTypeDef();
    }

    private final int getAdControlDynamicIntervalMin() {
        return ((Number) this.adControlDynamicIntervalMin$delegate.getValue()).intValue();
    }

    private final int getAdControlDynamicIntervalMax() {
        return ((Number) this.adControlDynamicIntervalMax$delegate.getValue()).intValue();
    }

    private final int getAdControlDynamicTimeInterval() {
        return ((Number) this.adControlDynamicTimeInterval$delegate.getValue()).intValue();
    }

    private final boolean getAdControlDynamicCountAdTimeSwitch() {
        return ((Boolean) this.adControlDynamicCountAdTimeSwitch$delegate.getValue()).booleanValue();
    }

    private final boolean getAdControlDynamicTriggerAfterTimeSwitch() {
        return ((Boolean) this.adControlDynamicTriggerAfterTimeSwitch$delegate.getValue()).booleanValue();
    }

    private final int getAdControlEvenInterval() {
        return ((Number) this.adControlEvenInterval$delegate.getValue()).intValue();
    }

    private final float getAdControlDynamicScreenInterval() {
        return ((Number) this.adControlDynamicScreenInterval$delegate.getValue()).floatValue();
    }

    private final boolean getAdControlResetSortInsertRejectedAbandon() {
        return ADConfigUtil.getPlaceOrGlobalConfInt(getPlaceId(), "ad_control_reset_sort_insert_rejected_abandon", adControlInsertRejectedAbandonDef() ? 1 : 0) == 1;
    }

    private final int getAdControlResetSortTimeInterval() {
        return ADConfigUtil.getGlobalConfIntByDesc("ad_control_reset_sort_time_interval", adControlPlaceDesc().desc(), adControlResetSortTimeIntervalDef());
    }

    private final int getAdControlResetSortTimeInterval2() {
        return ADConfigUtil.getGlobalConfIntByDesc("ad_control_reset_sort_time_interval_2", adControlPlaceDesc().desc(), adControlResetSortTimeIntervalDef2());
    }

    private final boolean getAdControlResetSortRequestAfterInsertRejected() {
        return ADConfigUtil.getPlaceOrGlobalConfInt(getPlaceId(), "ad_control_reset_sort_request_after_insert_rejected", adControlResetSortRequestAfterInsertRejectedDef() ? 1 : 0) == 1;
    }

    public int adControlFirstPvPos() {
        return getAdControlFirstPvPos();
    }

    public int adControlFirstPvFloorDef() {
        return 2;
    }

    public int adControlFirstPvPosTimeReady() {
        return getAdControlFirstPvPosTimeReady();
    }

    public int adControlFirstPvFloorTimeReadyDef() {
        return 2;
    }

    public int adControlFirstPos(AD ad) {
        return getAdControlFirstPos();
    }

    public int adControlFirstFloorDef() {
        return 4;
    }

    public int adControlRefreshFirstPos(AD ad) {
        return getAdControlRefreshFirstPos();
    }

    public int adControlRefreshFirstFloorDef() {
        return 4;
    }

    public AdPosStrategy adControlStrategyType() {
        return getAdControlStrategyType();
    }

    public AdPosStrategy adControlStrategyTypeDef() {
        return AdPosStrategy.DYNAMIC;
    }

    public boolean adControlInsertAfterRequestSwitch() {
        return getAdControlInsertAfterRequestSwitch();
    }

    public boolean adControlInsertAfterRequestSwitchDef() {
        return true;
    }

    public boolean adControlInsertAfterRequestWithUserPosSwitch() {
        return getAdControlInsertAfterRequestWithUserPos();
    }

    public boolean adControlInsertAfterRequestWithUserPosDef() {
        return false;
    }

    public int adControlDynamicIntervalMin(AD ad) {
        return getAdControlDynamicIntervalMin();
    }

    public int adControlDynamicIntervalMinDef() {
        return 3;
    }

    public int adControlDynamicIntervalMax(AD ad) {
        return getAdControlDynamicIntervalMax();
    }

    public int adControlDynamicIntervalMaxDef() {
        return 10;
    }

    public int adControlDynamicTimeInterval(AD ad) {
        return getAdControlDynamicTimeInterval();
    }

    public int adControlDynamicTimeIntervalDef() {
        return 45;
    }

    public boolean adControlDynamicCountAdTimeSwitch() {
        return getAdControlDynamicCountAdTimeSwitch();
    }

    public boolean adControlDynamicCountAdTimeSwitchDef() {
        return true;
    }

    public boolean adControlDynamicTriggerAfterTimeSwitch() {
        return getAdControlDynamicTriggerAfterTimeSwitch();
    }

    public boolean adControlDynamicTriggerAfterTimeSwitchDef() {
        return true;
    }

    public int adControlEvenInterval(AD ad) {
        return getAdControlEvenInterval();
    }

    public int adControlEvenIntervalDef() {
        return 5;
    }

    public int adControlRequestAhead() {
        return getAdControlRequestAhead();
    }

    public int adControlRequestAheadDef() {
        if (WhenMappings.$EnumSwitchMapping$0[adControlStrategyType().ordinal()] == 1) {
            return 1;
        }
        return 2;
    }

    public int adControlInsertAhead() {
        return getAdControlInsertAhead();
    }

    public int adControlInsertAheadDef() {
        return 1;
    }

    public float adControlDynamicScreenInterval(AD ad) {
        return getAdControlDynamicScreenInterval();
    }

    public boolean adControlInsertRejectedAbandon() {
        return getAdControlResetSortInsertRejectedAbandon();
    }

    public boolean adControlInsertRejectedAbandonDef() {
        return true;
    }

    public void adControlSetReqPos(AD ad, int reqPos) {
        Intrinsics.checkNotNullParameter(ad, "ad");
    }

    public int adControlGetReqPos(AD ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        return Integer.MAX_VALUE;
    }

    public void adControlOnResetSortInsertRejected(AdPosInsertCase adPosInsertCase) {
        Intrinsics.checkNotNullParameter(adPosInsertCase, "case");
    }

    public boolean adControl2ndPvIn1stPos() {
        return false;
    }

    public boolean adControlPvFallbackSwitch() {
        return getAdControlPvFallbackSwitch();
    }

    public boolean adControlPvFallbackSwitchDef() {
        return false;
    }

    public float adControlDynamicScreenIntervalDef() {
        return 1.0f;
    }

    public Integer adControlDynamicTimeIntervalBackFloor(AD ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        return null;
    }

    public Integer adControlDynamicBackFloor(AD ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        return null;
    }

    public int adControlResetSortTimeInterval(AD ad) {
        return getAdControlResetSortTimeInterval();
    }

    public int adControlResetSortTimeIntervalDef() {
        return -1;
    }

    public int adControlResetSortTimeInterval2(AD ad) {
        return getAdControlResetSortTimeInterval2();
    }

    public int adControlResetSortTimeIntervalDef2() {
        return -1;
    }

    public boolean adControlResetSortRequestAfterInsertRejected() {
        return getAdControlResetSortRequestAfterInsertRejected();
    }

    public boolean adControlResetSortRequestAfterInsertRejectedDef() {
        return true;
    }
}
