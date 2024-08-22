package com.baidu.searchbox.bigimage.comp.hao;

import android.util.Log;
import com.baidu.searchbox.bigimage.comp.hao.model.ChangeFollowResult;
import com.baidu.searchbox.bigimage.comp.hao.model.RelationApiService;
import com.baidu.searchbox.bigimage.model.BigImageAsset;
import com.baidu.searchbox.bigimage.model.HaoInfo;
import com.baidu.searchbox.bigimage.model.HaoInfoKt;
import com.baidu.searchbox.bigimage.runtime.BigImageRuntime;
import com.baidu.searchbox.bigimage.utils.BigImageTcUtilsKt;
import com.baidu.searchbox.bigimage.utils.BigImageUBCUtilsKt;
import com.baidu.searchbox.datachannel.DataChannel;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0019J\u001d\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0015\u0010#\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0012H\u0000¢\u0006\u0002\b$J\u0012\u0010%\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J#\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0000¢\u0006\u0002\b+J\b\u0010,\u001a\u00020\u001fH\u0002J\u001d\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0012H\u0000¢\u0006\u0002\b/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR2\u0010\r\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\n0\n \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\n0\n\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u00110\u0011X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/hao/HaoInfoManager;", "", "()V", "api", "Lcom/baidu/searchbox/bigimage/comp/hao/model/RelationApiService;", "followChangeReceiver", "com/baidu/searchbox/bigimage/comp/hao/HaoInfoManager$followChangeReceiver$1", "Lcom/baidu/searchbox/bigimage/comp/hao/HaoInfoManager$followChangeReceiver$1;", "followObservable", "Lrx/Observable;", "Lcom/baidu/searchbox/bigimage/model/HaoInfo;", "getFollowObservable", "()Lrx/Observable;", "followSubject", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "unFollowSwitchMap", "", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "", "changeFollow", "Lrx/Single;", "Lcom/baidu/searchbox/bigimage/comp/hao/model/ChangeFollowResult;", "info", "follow", "changeFollow$lib_search_bigimage_release", "isUnFollowEnabled", "haoInfo", "token", "isUnFollowEnabled$lib_search_bigimage_release", "receiveFollowChange", "", "array", "Lorg/json/JSONArray;", "registerReceiver", "release", "release$lib_search_bigimage_release", "sendFollowChange", "syncFollowStates", "changedInfo", "assetList", "", "Lcom/baidu/searchbox/bigimage/model/BigImageAsset;", "syncFollowStates$lib_search_bigimage_release", "unregisterReceiver", "updateUnFollowSwitch", "hao", "updateUnFollowSwitch$lib_search_bigimage_release", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HaoInfoManager.kt */
public final class HaoInfoManager {
    public static final HaoInfoManager INSTANCE = new HaoInfoManager();
    private static final RelationApiService api = new RelationApiService();
    private static final HaoInfoManager$followChangeReceiver$1 followChangeReceiver = new HaoInfoManager$followChangeReceiver$1();
    private static final Observable<HaoInfo> followObservable;
    private static final PublishSubject<HaoInfo> followSubject;
    private static final Map<UniqueId, Map<HaoInfo, Boolean>> unFollowSwitchMap = new LinkedHashMap();

    private HaoInfoManager() {
    }

    static {
        PublishSubject<HaoInfo> create = PublishSubject.create();
        followSubject = create;
        Observable<HaoInfo> observeOn = create.doOnSubscribe(new HaoInfoManager$$ExternalSyntheticLambda1()).doOnUnsubscribe(new HaoInfoManager$$ExternalSyntheticLambda2()).share().observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "followSubject.doOnSubscr…dSchedulers.mainThread())");
        followObservable = observeOn;
    }

    public final Observable<HaoInfo> getFollowObservable() {
        return followObservable;
    }

    /* access modifiers changed from: private */
    /* renamed from: followObservable$lambda-0  reason: not valid java name */
    public static final void m16182followObservable$lambda0() {
        INSTANCE.registerReceiver();
    }

    /* access modifiers changed from: private */
    /* renamed from: followObservable$lambda-1  reason: not valid java name */
    public static final void m16183followObservable$lambda1() {
        INSTANCE.unregisterReceiver();
    }

    /* access modifiers changed from: private */
    public final void receiveFollowChange(JSONArray array) {
        int length = array.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject json = array.optJSONObject(i2);
            if (json != null) {
                String id = json.optString("third_id", "");
                String type = json.optString("type", "");
                CharSequence charSequence = id;
                int i3 = 0;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    CharSequence charSequence2 = type;
                    if (!(charSequence2 == null || charSequence2.length() == 0)) {
                        Intrinsics.checkNotNullExpressionValue(id, "id");
                        Intrinsics.checkNotNullExpressionValue(type, "type");
                        HaoInfo data = new HaoInfo(id, type);
                        HaoInfo $this$receiveFollowChange_u24lambda_u2d3_u24lambda_u2d2 = data;
                        String optString = json.optString("is_follow", "");
                        if (!Intrinsics.areEqual((Object) optString, (Object) "0")) {
                            if (Intrinsics.areEqual((Object) optString, (Object) "1")) {
                                i3 = 1;
                            } else {
                                i3 = -1;
                            }
                        }
                        $this$receiveFollowChange_u24lambda_u2d3_u24lambda_u2d2.setFollow(i3);
                        followSubject.onNext(data);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private final void sendFollowChange(HaoInfo haoInfo) {
        if (haoInfo != null) {
            try {
                JSONObject json = new JSONObject();
                JSONArray data = new JSONArray();
                JSONObject item = new JSONObject();
                JSONObject $this$sendFollowChange_u24lambda_u2d4 = item;
                $this$sendFollowChange_u24lambda_u2d4.put("type", haoInfo.getRelationType());
                $this$sendFollowChange_u24lambda_u2d4.put("third_id", haoInfo.getId());
                $this$sendFollowChange_u24lambda_u2d4.put("is_follow", String.valueOf(haoInfo.isFollow()));
                $this$sendFollowChange_u24lambda_u2d4.put("position", HaoInfoKt.FROM_PIC_DETAIL);
                data.put(item);
                json.put("data", data);
                DataChannel.Sender.sendBroadcast(BigImageRuntime.getAppContext(), "com.baidu.channel.foundation.followchanged", json.toString());
            } catch (Throwable t) {
                if (BigImageUBCUtilsKt.getDEBUG()) {
                    Log.d("HaoInfoManager", "send broadcast error " + t.getMessage());
                }
            }
        }
    }

    private final void registerReceiver() {
        try {
            if (BigImageUBCUtilsKt.getDEBUG()) {
                Log.d("HaoInfoManager", "registerReceiver com.baidu.channel.foundation.followchanged");
            }
            DataChannel.Registry.registerNAReceiver("Search_BigImage_Baijiahao_Follow", (String) null, "com.baidu.channel.foundation.followchanged", followChangeReceiver);
        } catch (Throwable t) {
            if (BigImageUBCUtilsKt.getDEBUG()) {
                t.printStackTrace();
            }
        }
    }

    private final void unregisterReceiver() {
        try {
            if (BigImageUBCUtilsKt.getDEBUG()) {
                Log.d("HaoInfoManager", "unregisterReceiver com.baidu.channel.foundation.followchanged");
            }
            DataChannel.Registry.unregisterReceiver("Search_BigImage_Baijiahao_Follow", (String) null, "com.baidu.channel.foundation.followchanged");
        } catch (Throwable t) {
            if (BigImageUBCUtilsKt.getDEBUG()) {
                t.printStackTrace();
            }
        }
    }

    public final Single<ChangeFollowResult> changeFollow$lib_search_bigimage_release(HaoInfo info, boolean follow) {
        Intrinsics.checkNotNullParameter(info, "info");
        Single<R> map = api.changeFollow$lib_search_bigimage_release(info, follow).map(new HaoInfoManager$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNullExpressionValue(map, "api.changeFollow(info, f…         result\n        }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: changeFollow$lambda-5  reason: not valid java name */
    public static final ChangeFollowResult m16181changeFollow$lambda5(ChangeFollowResult result) {
        INSTANCE.sendFollowChange(result != null ? result.getHaoInfo() : null);
        return result;
    }

    public final void syncFollowStates$lib_search_bigimage_release(HaoInfo changedInfo, List<BigImageAsset> assetList) {
        Intrinsics.checkNotNullParameter(changedInfo, "changedInfo");
        Intrinsics.checkNotNullParameter(assetList, "assetList");
        for (BigImageAsset asset : assetList) {
            HaoInfo info = asset.getHaoInfo$lib_search_bigimage_release();
            if (info != null && Intrinsics.areEqual((Object) info, (Object) changedInfo)) {
                info.setFollow(changedInfo.isFollow());
            }
        }
    }

    public final void updateUnFollowSwitch$lib_search_bigimage_release(HaoInfo hao, UniqueId token) {
        Intrinsics.checkNotNullParameter(hao, "hao");
        Intrinsics.checkNotNullParameter(token, "token");
        Map<UniqueId, Map<HaoInfo, Boolean>> map = unFollowSwitchMap;
        Map map2 = map.get(token);
        if (map2 == null) {
            map2 = new LinkedHashMap();
        }
        if (hao.isFollowable() && (!map2.containsKey(hao) || hao.isFollow() == 0)) {
            map2.put(hao, Boolean.valueOf(hao.isFollow() == 0));
        }
        map.put(token, map2);
    }

    public final boolean isUnFollowEnabled$lib_search_bigimage_release(HaoInfo haoInfo, UniqueId token) {
        Intrinsics.checkNotNullParameter(haoInfo, BigImageTcUtilsKt.BIG_IMAGE_HAO_VIEW_POS_INFO);
        Intrinsics.checkNotNullParameter(token, "token");
        Map map = unFollowSwitchMap.get(token);
        if (map != null) {
            return Intrinsics.areEqual(map.get(haoInfo), (Object) true);
        }
        return false;
    }

    public final void release$lib_search_bigimage_release(UniqueId token) {
        Intrinsics.checkNotNullParameter(token, "token");
        unFollowSwitchMap.remove(token);
    }
}
