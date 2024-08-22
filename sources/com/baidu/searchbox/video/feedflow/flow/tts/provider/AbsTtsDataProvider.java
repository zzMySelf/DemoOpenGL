package com.baidu.searchbox.video.feedflow.flow.tts.provider;

import com.baidu.searchbox.feed.detail.ext.common.RequestParam;
import com.baidu.searchbox.feed.tts.commonstreams.StreamsFacade;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.utils.IterableUtilsKt;
import com.baidu.searchbox.video.feedflow.common.RequestParamsUtils;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.flow.tts.TtsDataUpdateCallBack;
import com.baidu.searchbox.video.feedflow.flow.tts.TtsUtilKt;
import com.baidu.searchbox.video.feedflow.flow.tts.model.FlowTtsRequestData;
import com.baidu.searchbox.video.feedflow.flow.tts.model.TtsModel;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010.\u001a\u00020/2\u0012\u00100\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u000101H\u0002J\u001a\u00102\u001a\u00020/2\u0010\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000701H\u0002J\b\u00103\u001a\u00020/H\u0016J\u0010\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020\rH\u0016J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u0019H&J\"\u00108\u001a\b\u0012\u0004\u0012\u00020*0\u00062\u0012\u00100\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u000101H\u0016J\u0010\u00109\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0019H\u0004J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020*0\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010;\u001a\u00020/H\u0016J\b\u0010<\u001a\u00020/H\u0016J\b\u0010=\u001a\u00020/H\u0016J6\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0010\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0010\u0010@\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000701H\u0002J\u0010\u0010A\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020\rH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010E\u001a\u00020/2\u0010\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000701H\u0002J\u0018\u0010F\u001a\u00020/2\u0006\u00107\u001a\u00020\u00192\u0006\u0010G\u001a\u00020HH\u0004J\f\u0010I\u001a\u00020/*\u00020JH\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0017\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u0010\u0010-\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/tts/provider/AbsTtsDataProvider;", "Lcom/baidu/searchbox/video/feedflow/flow/tts/provider/ITtsDataProvider;", "()V", "callBack", "Lcom/baidu/searchbox/video/feedflow/flow/tts/TtsDataUpdateCallBack;", "dataSource", "", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "getDataSource", "()Ljava/util/List;", "setDataSource", "(Ljava/util/List;)V", "downCTime", "", "hasNext", "", "getHasNext", "()Z", "setHasNext", "(Z)V", "hasPre", "getHasPre", "setHasPre", "isLoading", "pageNumber", "", "getPageNumber", "()I", "setPageNumber", "(I)V", "requestData", "Lcom/baidu/searchbox/video/feedflow/flow/tts/model/FlowTtsRequestData;", "getRequestData", "()Lcom/baidu/searchbox/video/feedflow/flow/tts/model/FlowTtsRequestData;", "setRequestData", "(Lcom/baidu/searchbox/video/feedflow/flow/tts/model/FlowTtsRequestData;)V", "ttsCategory", "getTtsCategory", "()Ljava/lang/String;", "setTtsCategory", "(Ljava/lang/String;)V", "ttsDataSource", "Lcom/baidu/searchbox/video/feedflow/flow/tts/model/TtsModel;", "getTtsDataSource", "setTtsDataSource", "upCTime", "addAllData", "", "list", "", "addStartList", "clean", "delete", "id", "fetchFLowListData", "direction", "getAllowedTtsModelList", "getCursor", "getTTSDataList", "loadCurrent", "loadNext", "loadPre", "removeDuplicate", "oldList", "newList", "setCallback", "setCategory", "category", "setFetchRequestData", "updateCurrent", "updateDataSource", "flowModelResult", "Lcom/baidu/searchbox/video/feedflow/flow/list/FlowModel;", "addCommonExtParams", "Lcom/baidu/searchbox/feed/detail/ext/common/RequestParam;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsTtsDataProvider.kt */
public abstract class AbsTtsDataProvider implements ITtsDataProvider {
    private TtsDataUpdateCallBack callBack;
    private List<ItemModel<?>> dataSource = new ArrayList();
    private String downCTime = "";
    private boolean hasNext;
    private boolean hasPre;
    private boolean isLoading;
    private int pageNumber = 1;
    private FlowTtsRequestData requestData = new FlowTtsRequestData();
    private String ttsCategory = "video_feed";
    private List<TtsModel> ttsDataSource = new ArrayList();
    private String upCTime = "";

    public abstract void fetchFLowListData(int i2);

    /* access modifiers changed from: protected */
    public final List<ItemModel<?>> getDataSource() {
        return this.dataSource;
    }

    /* access modifiers changed from: protected */
    public final void setDataSource(List<ItemModel<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataSource = list;
    }

    /* access modifiers changed from: protected */
    public final List<TtsModel> getTtsDataSource() {
        return this.ttsDataSource;
    }

    /* access modifiers changed from: protected */
    public final void setTtsDataSource(List<TtsModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.ttsDataSource = list;
    }

    /* access modifiers changed from: protected */
    public final FlowTtsRequestData getRequestData() {
        return this.requestData;
    }

    /* access modifiers changed from: protected */
    public final void setRequestData(FlowTtsRequestData flowTtsRequestData) {
        Intrinsics.checkNotNullParameter(flowTtsRequestData, "<set-?>");
        this.requestData = flowTtsRequestData;
    }

    /* access modifiers changed from: protected */
    public final boolean getHasPre() {
        return this.hasPre;
    }

    /* access modifiers changed from: protected */
    public final void setHasPre(boolean z) {
        this.hasPre = z;
    }

    /* access modifiers changed from: protected */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    /* access modifiers changed from: protected */
    public final void setHasNext(boolean z) {
        this.hasNext = z;
    }

    /* access modifiers changed from: protected */
    public final int getPageNumber() {
        return this.pageNumber;
    }

    /* access modifiers changed from: protected */
    public final void setPageNumber(int i2) {
        this.pageNumber = i2;
    }

    /* access modifiers changed from: protected */
    public final String getTtsCategory() {
        return this.ttsCategory;
    }

    /* access modifiers changed from: protected */
    public final void setTtsCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ttsCategory = str;
    }

    public List<TtsModel> getTTSDataList() {
        return this.ttsDataSource;
    }

    public void loadPre() {
        if (!this.isLoading) {
            this.isLoading = true;
            fetchFLowListData(-1);
        }
    }

    public void loadCurrent() {
        if (!this.isLoading) {
            this.isLoading = true;
            fetchFLowListData(0);
        }
    }

    public void loadNext() {
        if (!this.isLoading) {
            this.isLoading = true;
            fetchFLowListData(1);
        }
    }

    public boolean hasPre() {
        return this.hasPre;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public void setFetchRequestData(FlowTtsRequestData requestData2) {
        Intrinsics.checkNotNullParameter(requestData2, "requestData");
        this.dataSource.clear();
        this.ttsDataSource.clear();
        ItemModel currentModel = requestData2.getIntentVideoModel();
        if (currentModel != null) {
            this.dataSource.add(currentModel);
            TtsModel $this$setFetchRequestData_u24lambda_u2d1_u24lambda_u2d0 = TtsUtilKt.transformIntoTtsModel(currentModel, this.ttsCategory);
            if ($this$setFetchRequestData_u24lambda_u2d1_u24lambda_u2d0 != null) {
                this.ttsDataSource.add($this$setFetchRequestData_u24lambda_u2d1_u24lambda_u2d0);
            }
        }
        this.requestData = requestData2;
    }

    public void clean() {
        this.callBack = null;
        this.dataSource.clear();
        this.ttsDataSource.clear();
    }

    public void delete(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        int index = 0;
        for (Object item$iv : this.dataSource) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ItemModel itemModel = (ItemModel) item$iv;
            if (Intrinsics.areEqual((Object) id, (Object) itemModel.getId())) {
                this.dataSource.remove(itemModel);
                this.ttsDataSource.remove(index);
            }
            index = index$iv;
        }
    }

    public void setCallback(TtsDataUpdateCallBack callBack2) {
        Intrinsics.checkNotNullParameter(callBack2, "callBack");
        this.callBack = callBack2;
    }

    public void setCategory(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.ttsCategory = category;
    }

    /* access modifiers changed from: protected */
    public final void updateDataSource(int direction, FlowModel flowModelResult) {
        Intrinsics.checkNotNullParameter(flowModelResult, "flowModelResult");
        switch (direction) {
            case -1:
                this.hasPre = flowModelResult.getHasPrev();
                this.upCTime = flowModelResult.getUpCTime();
                addStartList(removeDuplicate(this.dataSource, flowModelResult.getItems()));
                break;
            case 0:
                this.hasPre = flowModelResult.getHasPrev();
                this.hasNext = flowModelResult.getHasMore();
                this.upCTime = flowModelResult.getUpCTime();
                this.downCTime = flowModelResult.getDownCTime();
                updateCurrent(flowModelResult.getItems());
                break;
            case 1:
                this.hasNext = flowModelResult.getHasMore();
                this.downCTime = flowModelResult.getDownCTime();
                addAllData(removeDuplicate(this.dataSource, flowModelResult.getItems()));
                break;
        }
        this.isLoading = false;
        TtsDataUpdateCallBack ttsDataUpdateCallBack = this.callBack;
        if (ttsDataUpdateCallBack != null) {
            ttsDataUpdateCallBack.refresh();
        }
    }

    private final List<ItemModel<?>> removeDuplicate(List<ItemModel<?>> oldList, List<? extends ItemModel<?>> newList) {
        if (newList.isEmpty()) {
            return new ArrayList<>();
        }
        HashSet set = new HashSet();
        int size = oldList.size();
        for (int i2 = 0; i2 < size; i2++) {
            set.add(oldList.get(i2).getId());
        }
        List tmp = new ArrayList();
        int size2 = newList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (set.add(((ItemModel) newList.get(i3)).getId())) {
                tmp.add(newList.get(i3));
            }
        }
        return tmp;
    }

    private final void addStartList(List<? extends ItemModel<?>> list) {
        List<? extends ItemModel<?>> list2 = list;
        this.dataSource.addAll(0, list2);
        this.ttsDataSource.addAll(0, getAllowedTtsModelList(list2));
    }

    private final void updateCurrent(List<? extends ItemModel<?>> list) {
        com.baidu.searchbox.flowvideo.tts.TtsModel tts;
        String shareInfo;
        List<ItemModel<?>> list2 = this.dataSource;
        IterableUtilsKt.removeAllSafety(list2, 1, list2.size());
        List<TtsModel> list3 = this.ttsDataSource;
        IterableUtilsKt.removeAllSafety(list3, 1, list3.size());
        int index$iv = 0;
        Iterator<? extends ItemModel<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                index$iv = -1;
                break;
            } else if (Intrinsics.areEqual((Object) ((ItemModel) it.next()).getId(), (Object) this.dataSource.get(0).getId())) {
                break;
            } else {
                index$iv++;
            }
        }
        int position = index$iv;
        if (position < 0) {
            addAllData(list);
            return;
        }
        if ((!this.ttsDataSource.isEmpty()) && StringsKt.isBlank(this.ttsDataSource.get(0).getShareInfo())) {
            Object data = ((ItemModel) list.get(position)).getData();
            VideoItemModel videoItemModel = data instanceof VideoItemModel ? (VideoItemModel) data : null;
            if (!(videoItemModel == null || (tts = videoItemModel.getTts()) == null || (shareInfo = tts.getShareInfo()) == null)) {
                this.ttsDataSource.get(0).setShareInfo(shareInfo);
                IFeedTTSModel streamsPlayingModel = StreamsFacade.getStreamsPlayingModel((JSONObject) null);
                if (streamsPlayingModel != null) {
                    streamsPlayingModel.setShareInfo(shareInfo);
                }
            }
        }
        addStartList(list.subList(0, position));
        addAllData(list.subList(position + 1, list.size()));
    }

    private final void addAllData(List<? extends ItemModel<?>> list) {
        if (list != null) {
            List<? extends ItemModel<?>> list2 = list;
            this.dataSource.addAll(list2);
            this.ttsDataSource.addAll(getAllowedTtsModelList(list2));
        }
    }

    public List<TtsModel> getAllowedTtsModelList(List<? extends ItemModel<?>> list) {
        List ttsListModel = new ArrayList();
        List<ItemModel<?>> $this$forEach$iv = TtsUtilKt.filterVideoDataList(list);
        if ($this$forEach$iv != null) {
            for (ItemModel itemModel : $this$forEach$iv) {
                TtsModel $this$getAllowedTtsModelList_u24lambda_u2d8_u24lambda_u2d7 = TtsUtilKt.transformIntoTtsModel(itemModel, this.ttsCategory);
                if ($this$getAllowedTtsModelList_u24lambda_u2d8_u24lambda_u2d7 != null) {
                    ttsListModel.add($this$getAllowedTtsModelList_u24lambda_u2d8_u24lambda_u2d7);
                }
            }
        }
        return ttsListModel;
    }

    /* access modifiers changed from: protected */
    public final String getCursor(int direction) {
        String ctime = "";
        switch (direction) {
            case -1:
                String str = this.upCTime;
                if (str != null) {
                    ctime = str;
                }
                return ctime;
            case 1:
                String str2 = this.downCTime;
                if (str2 != null) {
                    ctime = str2;
                }
                return ctime;
            default:
                return "";
        }
    }

    /* access modifiers changed from: protected */
    public final void addCommonExtParams(RequestParam $this$addCommonExtParams) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter($this$addCommonExtParams, "<this>");
        RequestParamsUtils requestParamsUtils = RequestParamsUtils.INSTANCE;
        IntentData intentData = this.requestData.getIntentData();
        String str3 = null;
        String str4 = intentData != null ? intentData.tpl : null;
        if (str4 == null) {
            str4 = "flowfeed";
        }
        String str5 = str4;
        IntentData intentData2 = this.requestData.getIntentData();
        JSONObject jSONObject = intentData2 != null ? intentData2.extRequest : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObject;
        float deviceStaticScore = VideoFlowUtilsKt.getDeviceStaticScore();
        int playQualityScore = VideoFlowUtilsKt.getPlayQualityScore();
        IntentData intentData3 = this.requestData.getIntentData();
        String str6 = intentData3 != null ? intentData3.page : null;
        if (str6 == null) {
            str6 = "";
        }
        IntentData intentData4 = this.requestData.getIntentData();
        if (intentData4 != null) {
            str3 = intentData4.sessionId;
        }
        String str7 = str3;
        IntentData intentData5 = this.requestData.getIntentData();
        if (intentData5 == null || (str2 = intentData5.entryTypeFrom) == null) {
            str = "";
        } else {
            str = str2;
        }
        requestParamsUtils.addExtParams($this$addCommonExtParams, str5, jSONObject2, deviceStaticScore, playQualityScore, str6, str7, str, true);
    }
}
