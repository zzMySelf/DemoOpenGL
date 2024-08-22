package com.baidu.searchbox.ad.position.strategy;

import com.baidu.searchbox.ad.position.place.IAdPlace;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0004H&J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\nH&J\u0017\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0004H&J\b\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/ad/position/strategy/ICommonPosParams;", "AD", "", "adControlFirstPos", "", "ad", "(Ljava/lang/Object;)I", "adControlFirstPvPos", "adControlFirstPvPosTimeReady", "adControlInsertAfterRequestSwitch", "", "adControlInsertAfterRequestWithUserPosSwitch", "adControlInsertAhead", "adControlNotifyInsert", "", "position", "(Ljava/lang/Object;I)V", "adControlPlaceDesc", "Lcom/baidu/searchbox/ad/position/place/IAdPlace;", "adControlPvFallbackSwitch", "adControlRefreshFirstPos", "adControlRequestAhead", "adControlStrategyType", "Lcom/baidu/searchbox/ad/position/strategy/AdPosStrategy;", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ICommonPosParams.kt */
public interface ICommonPosParams<AD> {
    int adControlFirstPos(AD ad);

    int adControlFirstPvPos();

    int adControlFirstPvPosTimeReady();

    boolean adControlInsertAfterRequestSwitch();

    boolean adControlInsertAfterRequestWithUserPosSwitch();

    int adControlInsertAhead();

    void adControlNotifyInsert(AD ad, int i2);

    IAdPlace adControlPlaceDesc();

    boolean adControlPvFallbackSwitch();

    int adControlRefreshFirstPos(AD ad);

    int adControlRequestAhead();

    AdPosStrategy adControlStrategyType();
}
