package com.baidu.searchbox.ad.position.strategy;

import com.baidu.searchbox.ad.position.placehelper.AdAbsPosPlaceHelper;
import com.baidu.searchbox.ad.position.type.IAdItemModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u0003*\u0004\b\u0002\u0010\u00042\u00020\u0005B\u001f\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u001bJ\"\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u001dR \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/ad/position/strategy/AdPosStrategyManager;", "E", "AD", "Lcom/baidu/searchbox/ad/position/type/IAdItemModel;", "UGC", "", "helper", "Lcom/baidu/searchbox/ad/position/placehelper/AdAbsPosPlaceHelper;", "(Lcom/baidu/searchbox/ad/position/placehelper/AdAbsPosPlaceHelper;)V", "strategyCollector", "", "", "Lcom/baidu/searchbox/ad/position/strategy/AdAbsPosStrategy;", "onPositionSelected", "", "position", "", "isUp", "", "extra", "Lcom/baidu/searchbox/ad/position/strategy/AdReachPositionExtra;", "setInsertCallback", "callback", "Lcom/baidu/searchbox/ad/position/strategy/OnInsertCallback;", "setRequestCallback", "Lcom/baidu/searchbox/ad/position/strategy/OnRequestCallback;", "tryInsert", "Lcom/baidu/searchbox/ad/position/strategy/AdInsertExtra;", "tryRequest", "Lcom/baidu/searchbox/ad/position/strategy/AdRequestExtra;", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdPosStrategyManager.kt */
public final class AdPosStrategyManager<E, AD extends IAdItemModel, UGC> {
    private final AdAbsPosPlaceHelper<E, AD, UGC> helper;
    private final Map<String, AdAbsPosStrategy<?, ?, ?>> strategyCollector;

    public AdPosStrategyManager(AdAbsPosPlaceHelper<E, AD, UGC> helper2) {
        Intrinsics.checkNotNullParameter(helper2, "helper");
        this.helper = helper2;
        this.strategyCollector = MapsKt.mapOf(new Pair(AdPosStrategy.DYNAMIC.getDesc(), new AdDynamicPosStrategy(helper2)), new Pair(AdPosStrategy.DYNAMIC2.getDesc(), new AdDynamic2PosStrategy(helper2)), new Pair(AdPosStrategy.EVEN.getDesc(), new AdEvenPosStrategy(helper2)), new Pair(AdPosStrategy.DYNAMIC_SCREEN_DISTANCE.getDesc(), new NadScreenDistanceStrategy(helper2)), new Pair(AdPosStrategy.RESET_SORT.getDesc(), new NadResetSortPosStrategy(helper2)));
    }

    public static /* synthetic */ void onPositionSelected$default(AdPosStrategyManager adPosStrategyManager, int i2, boolean z, AdReachPositionExtra adReachPositionExtra, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            adReachPositionExtra = null;
        }
        adPosStrategyManager.onPositionSelected(i2, z, adReachPositionExtra);
    }

    public final void onPositionSelected(int position, boolean isUp, AdReachPositionExtra extra) {
        AdAbsPosStrategy adAbsPosStrategy = this.strategyCollector.get(this.helper.adControlStrategyType().getDesc());
        if (adAbsPosStrategy != null) {
            adAbsPosStrategy.onPositionSelected(position, isUp, extra);
        }
    }

    public static /* synthetic */ void tryRequest$default(AdPosStrategyManager adPosStrategyManager, int i2, boolean z, AdRequestExtra adRequestExtra, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            adRequestExtra = null;
        }
        adPosStrategyManager.tryRequest(i2, z, adRequestExtra);
    }

    public final void tryRequest(int position, boolean isUp, AdRequestExtra extra) {
        AdAbsPosStrategy adAbsPosStrategy = this.strategyCollector.get(this.helper.adControlStrategyType().getDesc());
        if (adAbsPosStrategy != null) {
            adAbsPosStrategy.tryRequest(position, isUp, extra);
        }
    }

    public static /* synthetic */ void tryInsert$default(AdPosStrategyManager adPosStrategyManager, int i2, boolean z, AdInsertExtra adInsertExtra, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            adInsertExtra = null;
        }
        adPosStrategyManager.tryInsert(i2, z, adInsertExtra);
    }

    public final void tryInsert(int position, boolean isUp, AdInsertExtra extra) {
        AdAbsPosStrategy adAbsPosStrategy = this.strategyCollector.get(this.helper.adControlStrategyType().getDesc());
        if (adAbsPosStrategy != null) {
            adAbsPosStrategy.tryInsert(position, isUp, extra);
        }
    }

    public final void setRequestCallback(OnRequestCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        for (AdAbsPosStrategy strategy : CollectionsKt.toList(this.strategyCollector.values())) {
            strategy.setRequestCallback(callback);
        }
    }

    public final void setInsertCallback(OnInsertCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        for (AdAbsPosStrategy strategy : CollectionsKt.toList(this.strategyCollector.values())) {
            strategy.setInsertCallback(callback);
        }
    }
}
