package com.baidu.searchbox.live.service;

import com.baidu.live.arch.api.IService;
import com.baidu.searchbox.live.mix.MixRoomInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/service/LiveMixRoomInfoService;", "Lcom/baidu/live/arch/api/IService;", "getRoomInfo", "Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "updateRoomInfo", "", "info", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LiveMixRoomInfoService.kt */
public interface LiveMixRoomInfoService extends IService {
    MixRoomInfo getRoomInfo();

    void updateRoomInfo(MixRoomInfo mixRoomInfo);
}
