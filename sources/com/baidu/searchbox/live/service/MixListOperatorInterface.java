package com.baidu.searchbox.live.service;

import com.baidu.live.arch.api.IService;
import com.baidu.searchbox.live.widget.LiveContainer;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH&¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/live/service/MixListOperatorInterface;", "Lcom/baidu/live/arch/api/IService;", "commonEvent", "", "key", "", "ext", "", "doJumpNewLiveRoom", "data", "Lorg/json/JSONObject;", "getListData", "", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "insertRoom", "index", "", "json", "reloadLiveRoom", "reloadSlideList", "removeRoom", "roomId", "scrollToNextLiveRoom", "scrollToPreLiveRoom", "switchLiveListScrollable", "switch", "", "isFromServer", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MixListOperatorInterface.kt */
public interface MixListOperatorInterface extends IService {
    void commonEvent(String str, Object obj);

    void doJumpNewLiveRoom(JSONObject jSONObject);

    List<LiveContainer.LiveItemModel> getListData();

    void insertRoom(int i2, JSONObject jSONObject);

    void reloadLiveRoom(Object obj);

    void reloadSlideList(Object obj);

    void removeRoom(String str);

    void removeRoom(JSONObject jSONObject);

    void scrollToNextLiveRoom();

    void scrollToPreLiveRoom();

    void switchLiveListScrollable(boolean z, boolean z2);
}
