package com.baidu.searchbox.dynamicpublisher.text;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.dynamicpublisher.aiimggentxt.AiStyleItemData;
import com.baidu.searchbox.dynamicpublisher.panel.model.TextTplDetailModel;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
import com.baidu.searchbox.ugc.model.LinkInfoItem;
import com.baidu.searchbox.ugc.model.TopicItem;
import com.baidu.talos.core.render.views.rncwebview.RNCWebViewManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B§\u0003\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f0\u0003\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\f0\u0003\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f0\u0003\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0003\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003\u0012\"\b\u0002\u0010\u0015\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00180\u0003\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003\u0012\u001e\b\u0002\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001c0\u0003\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0003\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0003¢\u0006\u0002\u0010'J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003HÆ\u0003J#\u0010@\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00180\u0003HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003HÆ\u0003J\u001f\u0010B\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001c0\u0003HÆ\u0003J\u0011\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003HÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003HÆ\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003HÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0003HÆ\u0003J\u0011\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003HÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020&0\u0003HÆ\u0003J\u0011\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003HÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003HÆ\u0003J\u0019\u0010N\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f0\u0003HÆ\u0003J\u0019\u0010O\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\f0\u0003HÆ\u0003J\u0019\u0010P\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f0\u0003HÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0003HÆ\u0003J«\u0003\u0010S\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00032\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f0\u00032\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\f0\u00032\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f0\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\"\b\u0002\u0010\u0015\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00180\u00032\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00032\u001e\b\u0002\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001c0\u00032\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00032\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00032\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0010\b\u0002\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u00032\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0003HÆ\u0001J\u0013\u0010T\u001a\u00020&2\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020WHÖ\u0001J\t\u0010X\u001a\u00020\u001aHÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R'\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001c0\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010)R!\u0010\r\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R!\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R!\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R+\u0010\u0015\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00180\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010)¨\u0006Y"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/text/TextState;", "", "requestFocus", "Landroidx/lifecycle/MutableLiveData;", "", "initText", "Lcom/baidu/searchbox/dynamicpublisher/text/TextInitModel;", "addTopic", "Lcom/baidu/searchbox/ugc/model/TopicItem;", "addAtUserInfo", "Lcom/baidu/searchbox/ugc/model/AtUserInfoItem;", "initTargetTopics", "", "initTargetAtUsers", "initTargetLinks", "Lcom/baidu/searchbox/ugc/model/LinkInfoItem;", "collection", "restoration", "Lcom/baidu/searchbox/dynamicpublisher/text/TextInfoModel;", "topicBubbleModel", "Lcom/baidu/searchbox/dynamicpublisher/text/TopicBubbleModel;", "textTpl", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/dynamicpublisher/panel/model/TextTplDetailModel;", "Lkotlin/collections/ArrayList;", "groupName", "", "aiData", "Lkotlin/Pair;", "aiSwitch", "sourceFrom", "changeAiIcon", "showImageToText", "aiAnchorPointId", "aiStyleItemData", "Lcom/baidu/searchbox/dynamicpublisher/aiimggentxt/AiStyleItemData;", "showImgGenTtxDialog", "showAiImgGenTxtLoading", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getAddAtUserInfo", "()Landroidx/lifecycle/MutableLiveData;", "getAddTopic", "getAiAnchorPointId", "getAiData", "getAiStyleItemData", "getAiSwitch", "getChangeAiIcon", "getCollection", "getGroupName", "getInitTargetAtUsers", "getInitTargetLinks", "getInitTargetTopics", "getInitText", "getRequestFocus", "getRestoration", "getShowAiImgGenTxtLoading", "getShowImageToText", "getShowImgGenTtxDialog", "getSourceFrom", "getTextTpl", "getTopicBubbleModel", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextState.kt */
public final class TextState {
    private final MutableLiveData<AtUserInfoItem> addAtUserInfo;
    private final MutableLiveData<TopicItem> addTopic;
    private final MutableLiveData<String> aiAnchorPointId;
    private final MutableLiveData<Pair<String, String>> aiData;
    private final MutableLiveData<AiStyleItemData> aiStyleItemData;
    private final MutableLiveData<String> aiSwitch;
    private final MutableLiveData<Unit> changeAiIcon;
    private final MutableLiveData<Unit> collection;
    private final MutableLiveData<String> groupName;
    private final MutableLiveData<List<AtUserInfoItem>> initTargetAtUsers;
    private final MutableLiveData<List<LinkInfoItem>> initTargetLinks;
    private final MutableLiveData<List<TopicItem>> initTargetTopics;
    private final MutableLiveData<TextInitModel> initText;
    private final MutableLiveData<Unit> requestFocus;
    private final MutableLiveData<TextInfoModel> restoration;
    private final MutableLiveData<Boolean> showAiImgGenTxtLoading;
    private final MutableLiveData<Unit> showImageToText;
    private final MutableLiveData<Unit> showImgGenTtxDialog;
    private final MutableLiveData<String> sourceFrom;
    private final MutableLiveData<ArrayList<TextTplDetailModel>> textTpl;
    private final MutableLiveData<TopicBubbleModel> topicBubbleModel;

    public TextState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 2097151, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TextState copy$default(TextState textState, MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, MutableLiveData mutableLiveData4, MutableLiveData mutableLiveData5, MutableLiveData mutableLiveData6, MutableLiveData mutableLiveData7, MutableLiveData mutableLiveData8, MutableLiveData mutableLiveData9, MutableLiveData mutableLiveData10, MutableLiveData mutableLiveData11, MutableLiveData mutableLiveData12, MutableLiveData mutableLiveData13, MutableLiveData mutableLiveData14, MutableLiveData mutableLiveData15, MutableLiveData mutableLiveData16, MutableLiveData mutableLiveData17, MutableLiveData mutableLiveData18, MutableLiveData mutableLiveData19, MutableLiveData mutableLiveData20, MutableLiveData mutableLiveData21, int i2, Object obj) {
        TextState textState2 = textState;
        int i3 = i2;
        return textState.copy((i3 & 1) != 0 ? textState2.requestFocus : mutableLiveData, (i3 & 2) != 0 ? textState2.initText : mutableLiveData2, (i3 & 4) != 0 ? textState2.addTopic : mutableLiveData3, (i3 & 8) != 0 ? textState2.addAtUserInfo : mutableLiveData4, (i3 & 16) != 0 ? textState2.initTargetTopics : mutableLiveData5, (i3 & 32) != 0 ? textState2.initTargetAtUsers : mutableLiveData6, (i3 & 64) != 0 ? textState2.initTargetLinks : mutableLiveData7, (i3 & 128) != 0 ? textState2.collection : mutableLiveData8, (i3 & 256) != 0 ? textState2.restoration : mutableLiveData9, (i3 & 512) != 0 ? textState2.topicBubbleModel : mutableLiveData10, (i3 & 1024) != 0 ? textState2.textTpl : mutableLiveData11, (i3 & 2048) != 0 ? textState2.groupName : mutableLiveData12, (i3 & 4096) != 0 ? textState2.aiData : mutableLiveData13, (i3 & 8192) != 0 ? textState2.aiSwitch : mutableLiveData14, (i3 & 16384) != 0 ? textState2.sourceFrom : mutableLiveData15, (i3 & 32768) != 0 ? textState2.changeAiIcon : mutableLiveData16, (i3 & 65536) != 0 ? textState2.showImageToText : mutableLiveData17, (i3 & 131072) != 0 ? textState2.aiAnchorPointId : mutableLiveData18, (i3 & 262144) != 0 ? textState2.aiStyleItemData : mutableLiveData19, (i3 & 524288) != 0 ? textState2.showImgGenTtxDialog : mutableLiveData20, (i3 & 1048576) != 0 ? textState2.showAiImgGenTxtLoading : mutableLiveData21);
    }

    public final MutableLiveData<Unit> component1() {
        return this.requestFocus;
    }

    public final MutableLiveData<TopicBubbleModel> component10() {
        return this.topicBubbleModel;
    }

    public final MutableLiveData<ArrayList<TextTplDetailModel>> component11() {
        return this.textTpl;
    }

    public final MutableLiveData<String> component12() {
        return this.groupName;
    }

    public final MutableLiveData<Pair<String, String>> component13() {
        return this.aiData;
    }

    public final MutableLiveData<String> component14() {
        return this.aiSwitch;
    }

    public final MutableLiveData<String> component15() {
        return this.sourceFrom;
    }

    public final MutableLiveData<Unit> component16() {
        return this.changeAiIcon;
    }

    public final MutableLiveData<Unit> component17() {
        return this.showImageToText;
    }

    public final MutableLiveData<String> component18() {
        return this.aiAnchorPointId;
    }

    public final MutableLiveData<AiStyleItemData> component19() {
        return this.aiStyleItemData;
    }

    public final MutableLiveData<TextInitModel> component2() {
        return this.initText;
    }

    public final MutableLiveData<Unit> component20() {
        return this.showImgGenTtxDialog;
    }

    public final MutableLiveData<Boolean> component21() {
        return this.showAiImgGenTxtLoading;
    }

    public final MutableLiveData<TopicItem> component3() {
        return this.addTopic;
    }

    public final MutableLiveData<AtUserInfoItem> component4() {
        return this.addAtUserInfo;
    }

    public final MutableLiveData<List<TopicItem>> component5() {
        return this.initTargetTopics;
    }

    public final MutableLiveData<List<AtUserInfoItem>> component6() {
        return this.initTargetAtUsers;
    }

    public final MutableLiveData<List<LinkInfoItem>> component7() {
        return this.initTargetLinks;
    }

    public final MutableLiveData<Unit> component8() {
        return this.collection;
    }

    public final MutableLiveData<TextInfoModel> component9() {
        return this.restoration;
    }

    public final TextState copy(MutableLiveData<Unit> mutableLiveData, MutableLiveData<TextInitModel> mutableLiveData2, MutableLiveData<TopicItem> mutableLiveData3, MutableLiveData<AtUserInfoItem> mutableLiveData4, MutableLiveData<List<TopicItem>> mutableLiveData5, MutableLiveData<List<AtUserInfoItem>> mutableLiveData6, MutableLiveData<List<LinkInfoItem>> mutableLiveData7, MutableLiveData<Unit> mutableLiveData8, MutableLiveData<TextInfoModel> mutableLiveData9, MutableLiveData<TopicBubbleModel> mutableLiveData10, MutableLiveData<ArrayList<TextTplDetailModel>> mutableLiveData11, MutableLiveData<String> mutableLiveData12, MutableLiveData<Pair<String, String>> mutableLiveData13, MutableLiveData<String> mutableLiveData14, MutableLiveData<String> mutableLiveData15, MutableLiveData<Unit> mutableLiveData16, MutableLiveData<Unit> mutableLiveData17, MutableLiveData<String> mutableLiveData18, MutableLiveData<AiStyleItemData> mutableLiveData19, MutableLiveData<Unit> mutableLiveData20, MutableLiveData<Boolean> mutableLiveData21) {
        MutableLiveData<Unit> mutableLiveData22 = mutableLiveData;
        Intrinsics.checkNotNullParameter(mutableLiveData22, RNCWebViewManager.COMMAND_FOCUS);
        Intrinsics.checkNotNullParameter(mutableLiveData2, "initText");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "addTopic");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "addAtUserInfo");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "initTargetTopics");
        Intrinsics.checkNotNullParameter(mutableLiveData6, "initTargetAtUsers");
        Intrinsics.checkNotNullParameter(mutableLiveData7, "initTargetLinks");
        Intrinsics.checkNotNullParameter(mutableLiveData8, "collection");
        Intrinsics.checkNotNullParameter(mutableLiveData9, "restoration");
        Intrinsics.checkNotNullParameter(mutableLiveData10, "topicBubbleModel");
        Intrinsics.checkNotNullParameter(mutableLiveData11, "textTpl");
        Intrinsics.checkNotNullParameter(mutableLiveData12, "groupName");
        Intrinsics.checkNotNullParameter(mutableLiveData13, "aiData");
        Intrinsics.checkNotNullParameter(mutableLiveData14, "aiSwitch");
        Intrinsics.checkNotNullParameter(mutableLiveData15, "sourceFrom");
        Intrinsics.checkNotNullParameter(mutableLiveData16, "changeAiIcon");
        Intrinsics.checkNotNullParameter(mutableLiveData17, "showImageToText");
        Intrinsics.checkNotNullParameter(mutableLiveData18, "aiAnchorPointId");
        Intrinsics.checkNotNullParameter(mutableLiveData19, "aiStyleItemData");
        Intrinsics.checkNotNullParameter(mutableLiveData20, "showImgGenTtxDialog");
        Intrinsics.checkNotNullParameter(mutableLiveData21, "showAiImgGenTxtLoading");
        return new TextState(mutableLiveData22, mutableLiveData2, mutableLiveData3, mutableLiveData4, mutableLiveData5, mutableLiveData6, mutableLiveData7, mutableLiveData8, mutableLiveData9, mutableLiveData10, mutableLiveData11, mutableLiveData12, mutableLiveData13, mutableLiveData14, mutableLiveData15, mutableLiveData16, mutableLiveData17, mutableLiveData18, mutableLiveData19, mutableLiveData20, mutableLiveData21);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextState)) {
            return false;
        }
        TextState textState = (TextState) obj;
        return Intrinsics.areEqual((Object) this.requestFocus, (Object) textState.requestFocus) && Intrinsics.areEqual((Object) this.initText, (Object) textState.initText) && Intrinsics.areEqual((Object) this.addTopic, (Object) textState.addTopic) && Intrinsics.areEqual((Object) this.addAtUserInfo, (Object) textState.addAtUserInfo) && Intrinsics.areEqual((Object) this.initTargetTopics, (Object) textState.initTargetTopics) && Intrinsics.areEqual((Object) this.initTargetAtUsers, (Object) textState.initTargetAtUsers) && Intrinsics.areEqual((Object) this.initTargetLinks, (Object) textState.initTargetLinks) && Intrinsics.areEqual((Object) this.collection, (Object) textState.collection) && Intrinsics.areEqual((Object) this.restoration, (Object) textState.restoration) && Intrinsics.areEqual((Object) this.topicBubbleModel, (Object) textState.topicBubbleModel) && Intrinsics.areEqual((Object) this.textTpl, (Object) textState.textTpl) && Intrinsics.areEqual((Object) this.groupName, (Object) textState.groupName) && Intrinsics.areEqual((Object) this.aiData, (Object) textState.aiData) && Intrinsics.areEqual((Object) this.aiSwitch, (Object) textState.aiSwitch) && Intrinsics.areEqual((Object) this.sourceFrom, (Object) textState.sourceFrom) && Intrinsics.areEqual((Object) this.changeAiIcon, (Object) textState.changeAiIcon) && Intrinsics.areEqual((Object) this.showImageToText, (Object) textState.showImageToText) && Intrinsics.areEqual((Object) this.aiAnchorPointId, (Object) textState.aiAnchorPointId) && Intrinsics.areEqual((Object) this.aiStyleItemData, (Object) textState.aiStyleItemData) && Intrinsics.areEqual((Object) this.showImgGenTtxDialog, (Object) textState.showImgGenTtxDialog) && Intrinsics.areEqual((Object) this.showAiImgGenTxtLoading, (Object) textState.showAiImgGenTxtLoading);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((this.requestFocus.hashCode() * 31) + this.initText.hashCode()) * 31) + this.addTopic.hashCode()) * 31) + this.addAtUserInfo.hashCode()) * 31) + this.initTargetTopics.hashCode()) * 31) + this.initTargetAtUsers.hashCode()) * 31) + this.initTargetLinks.hashCode()) * 31) + this.collection.hashCode()) * 31) + this.restoration.hashCode()) * 31) + this.topicBubbleModel.hashCode()) * 31) + this.textTpl.hashCode()) * 31) + this.groupName.hashCode()) * 31) + this.aiData.hashCode()) * 31) + this.aiSwitch.hashCode()) * 31) + this.sourceFrom.hashCode()) * 31) + this.changeAiIcon.hashCode()) * 31) + this.showImageToText.hashCode()) * 31) + this.aiAnchorPointId.hashCode()) * 31) + this.aiStyleItemData.hashCode()) * 31) + this.showImgGenTtxDialog.hashCode()) * 31) + this.showAiImgGenTxtLoading.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextState(requestFocus=").append(this.requestFocus).append(", initText=").append(this.initText).append(", addTopic=").append(this.addTopic).append(", addAtUserInfo=").append(this.addAtUserInfo).append(", initTargetTopics=").append(this.initTargetTopics).append(", initTargetAtUsers=").append(this.initTargetAtUsers).append(", initTargetLinks=").append(this.initTargetLinks).append(", collection=").append(this.collection).append(", restoration=").append(this.restoration).append(", topicBubbleModel=").append(this.topicBubbleModel).append(", textTpl=").append(this.textTpl).append(", groupName=");
        sb.append(this.groupName).append(", aiData=").append(this.aiData).append(", aiSwitch=").append(this.aiSwitch).append(", sourceFrom=").append(this.sourceFrom).append(", changeAiIcon=").append(this.changeAiIcon).append(", showImageToText=").append(this.showImageToText).append(", aiAnchorPointId=").append(this.aiAnchorPointId).append(", aiStyleItemData=").append(this.aiStyleItemData).append(", showImgGenTtxDialog=").append(this.showImgGenTtxDialog).append(", showAiImgGenTxtLoading=").append(this.showAiImgGenTxtLoading).append(')');
        return sb.toString();
    }

    public TextState(MutableLiveData<Unit> requestFocus2, MutableLiveData<TextInitModel> initText2, MutableLiveData<TopicItem> addTopic2, MutableLiveData<AtUserInfoItem> addAtUserInfo2, MutableLiveData<List<TopicItem>> initTargetTopics2, MutableLiveData<List<AtUserInfoItem>> initTargetAtUsers2, MutableLiveData<List<LinkInfoItem>> initTargetLinks2, MutableLiveData<Unit> collection2, MutableLiveData<TextInfoModel> restoration2, MutableLiveData<TopicBubbleModel> topicBubbleModel2, MutableLiveData<ArrayList<TextTplDetailModel>> textTpl2, MutableLiveData<String> groupName2, MutableLiveData<Pair<String, String>> aiData2, MutableLiveData<String> aiSwitch2, MutableLiveData<String> sourceFrom2, MutableLiveData<Unit> changeAiIcon2, MutableLiveData<Unit> showImageToText2, MutableLiveData<String> aiAnchorPointId2, MutableLiveData<AiStyleItemData> aiStyleItemData2, MutableLiveData<Unit> showImgGenTtxDialog2, MutableLiveData<Boolean> showAiImgGenTxtLoading2) {
        MutableLiveData<Unit> mutableLiveData = requestFocus2;
        MutableLiveData<TextInitModel> mutableLiveData2 = initText2;
        MutableLiveData<TopicItem> mutableLiveData3 = addTopic2;
        MutableLiveData<AtUserInfoItem> mutableLiveData4 = addAtUserInfo2;
        MutableLiveData<List<TopicItem>> mutableLiveData5 = initTargetTopics2;
        MutableLiveData<List<AtUserInfoItem>> mutableLiveData6 = initTargetAtUsers2;
        MutableLiveData<List<LinkInfoItem>> mutableLiveData7 = initTargetLinks2;
        MutableLiveData<Unit> mutableLiveData8 = collection2;
        MutableLiveData<TextInfoModel> mutableLiveData9 = restoration2;
        MutableLiveData<TopicBubbleModel> mutableLiveData10 = topicBubbleModel2;
        MutableLiveData<ArrayList<TextTplDetailModel>> mutableLiveData11 = textTpl2;
        MutableLiveData<String> mutableLiveData12 = groupName2;
        MutableLiveData<Pair<String, String>> mutableLiveData13 = aiData2;
        MutableLiveData<String> mutableLiveData14 = aiSwitch2;
        MutableLiveData<Unit> mutableLiveData15 = changeAiIcon2;
        Intrinsics.checkNotNullParameter(mutableLiveData, RNCWebViewManager.COMMAND_FOCUS);
        Intrinsics.checkNotNullParameter(mutableLiveData2, "initText");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "addTopic");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "addAtUserInfo");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "initTargetTopics");
        Intrinsics.checkNotNullParameter(mutableLiveData6, "initTargetAtUsers");
        Intrinsics.checkNotNullParameter(mutableLiveData7, "initTargetLinks");
        Intrinsics.checkNotNullParameter(mutableLiveData8, "collection");
        Intrinsics.checkNotNullParameter(mutableLiveData9, "restoration");
        Intrinsics.checkNotNullParameter(mutableLiveData10, "topicBubbleModel");
        Intrinsics.checkNotNullParameter(mutableLiveData11, "textTpl");
        Intrinsics.checkNotNullParameter(mutableLiveData12, "groupName");
        Intrinsics.checkNotNullParameter(mutableLiveData13, "aiData");
        Intrinsics.checkNotNullParameter(mutableLiveData14, "aiSwitch");
        Intrinsics.checkNotNullParameter(sourceFrom2, "sourceFrom");
        Intrinsics.checkNotNullParameter(changeAiIcon2, "changeAiIcon");
        Intrinsics.checkNotNullParameter(showImageToText2, "showImageToText");
        Intrinsics.checkNotNullParameter(aiAnchorPointId2, "aiAnchorPointId");
        Intrinsics.checkNotNullParameter(aiStyleItemData2, "aiStyleItemData");
        Intrinsics.checkNotNullParameter(showImgGenTtxDialog2, "showImgGenTtxDialog");
        Intrinsics.checkNotNullParameter(showAiImgGenTxtLoading2, "showAiImgGenTxtLoading");
        this.requestFocus = mutableLiveData;
        this.initText = mutableLiveData2;
        this.addTopic = mutableLiveData3;
        this.addAtUserInfo = mutableLiveData4;
        this.initTargetTopics = mutableLiveData5;
        this.initTargetAtUsers = mutableLiveData6;
        this.initTargetLinks = mutableLiveData7;
        this.collection = mutableLiveData8;
        this.restoration = mutableLiveData9;
        this.topicBubbleModel = mutableLiveData10;
        this.textTpl = mutableLiveData11;
        this.groupName = mutableLiveData12;
        this.aiData = mutableLiveData13;
        this.aiSwitch = mutableLiveData14;
        this.sourceFrom = sourceFrom2;
        this.changeAiIcon = changeAiIcon2;
        this.showImageToText = showImageToText2;
        this.aiAnchorPointId = aiAnchorPointId2;
        this.aiStyleItemData = aiStyleItemData2;
        this.showImgGenTtxDialog = showImgGenTtxDialog2;
        this.showAiImgGenTxtLoading = showAiImgGenTxtLoading2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextState(androidx.lifecycle.MutableLiveData r23, androidx.lifecycle.MutableLiveData r24, androidx.lifecycle.MutableLiveData r25, androidx.lifecycle.MutableLiveData r26, androidx.lifecycle.MutableLiveData r27, androidx.lifecycle.MutableLiveData r28, androidx.lifecycle.MutableLiveData r29, androidx.lifecycle.MutableLiveData r30, androidx.lifecycle.MutableLiveData r31, androidx.lifecycle.MutableLiveData r32, androidx.lifecycle.MutableLiveData r33, androidx.lifecycle.MutableLiveData r34, androidx.lifecycle.MutableLiveData r35, androidx.lifecycle.MutableLiveData r36, androidx.lifecycle.MutableLiveData r37, androidx.lifecycle.MutableLiveData r38, androidx.lifecycle.MutableLiveData r39, androidx.lifecycle.MutableLiveData r40, androidx.lifecycle.MutableLiveData r41, androidx.lifecycle.MutableLiveData r42, androidx.lifecycle.MutableLiveData r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
        /*
            r22 = this;
            r0 = r44
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000e
        L_0x000c:
            r1 = r23
        L_0x000e:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0018
            androidx.lifecycle.MutableLiveData r2 = new androidx.lifecycle.MutableLiveData
            r2.<init>()
            goto L_0x001a
        L_0x0018:
            r2 = r24
        L_0x001a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0024
            androidx.lifecycle.MutableLiveData r3 = new androidx.lifecycle.MutableLiveData
            r3.<init>()
            goto L_0x0026
        L_0x0024:
            r3 = r25
        L_0x0026:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0030
            androidx.lifecycle.MutableLiveData r4 = new androidx.lifecycle.MutableLiveData
            r4.<init>()
            goto L_0x0032
        L_0x0030:
            r4 = r26
        L_0x0032:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x003c
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            goto L_0x003e
        L_0x003c:
            r5 = r27
        L_0x003e:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0048
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            goto L_0x004a
        L_0x0048:
            r6 = r28
        L_0x004a:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0054
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            goto L_0x0056
        L_0x0054:
            r7 = r29
        L_0x0056:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0060
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            goto L_0x0062
        L_0x0060:
            r8 = r30
        L_0x0062:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x006c
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            goto L_0x006e
        L_0x006c:
            r9 = r31
        L_0x006e:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0078
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            goto L_0x007a
        L_0x0078:
            r10 = r32
        L_0x007a:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0084
            androidx.lifecycle.MutableLiveData r11 = new androidx.lifecycle.MutableLiveData
            r11.<init>()
            goto L_0x0086
        L_0x0084:
            r11 = r33
        L_0x0086:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0090
            androidx.lifecycle.MutableLiveData r12 = new androidx.lifecycle.MutableLiveData
            r12.<init>()
            goto L_0x0092
        L_0x0090:
            r12 = r34
        L_0x0092:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x009c
            androidx.lifecycle.MutableLiveData r13 = new androidx.lifecycle.MutableLiveData
            r13.<init>()
            goto L_0x009e
        L_0x009c:
            r13 = r35
        L_0x009e:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x00a8
            androidx.lifecycle.MutableLiveData r14 = new androidx.lifecycle.MutableLiveData
            r14.<init>()
            goto L_0x00aa
        L_0x00a8:
            r14 = r36
        L_0x00aa:
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x00b4
            androidx.lifecycle.MutableLiveData r15 = new androidx.lifecycle.MutableLiveData
            r15.<init>()
            goto L_0x00b6
        L_0x00b4:
            r15 = r37
        L_0x00b6:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00c3
            androidx.lifecycle.MutableLiveData r16 = new androidx.lifecycle.MutableLiveData
            r16.<init>()
            goto L_0x00c5
        L_0x00c3:
            r16 = r38
        L_0x00c5:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00d1
            androidx.lifecycle.MutableLiveData r17 = new androidx.lifecycle.MutableLiveData
            r17.<init>()
            goto L_0x00d3
        L_0x00d1:
            r17 = r39
        L_0x00d3:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00df
            androidx.lifecycle.MutableLiveData r18 = new androidx.lifecycle.MutableLiveData
            r18.<init>()
            goto L_0x00e1
        L_0x00df:
            r18 = r40
        L_0x00e1:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00ed
            androidx.lifecycle.MutableLiveData r19 = new androidx.lifecycle.MutableLiveData
            r19.<init>()
            goto L_0x00ef
        L_0x00ed:
            r19 = r41
        L_0x00ef:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00fb
            androidx.lifecycle.MutableLiveData r20 = new androidx.lifecycle.MutableLiveData
            r20.<init>()
            goto L_0x00fd
        L_0x00fb:
            r20 = r42
        L_0x00fd:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r21
            if (r0 == 0) goto L_0x0109
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            goto L_0x010b
        L_0x0109:
            r0 = r43
        L_0x010b:
            r23 = r1
            r24 = r2
            r25 = r3
            r26 = r4
            r27 = r5
            r28 = r6
            r29 = r7
            r30 = r8
            r31 = r9
            r32 = r10
            r33 = r11
            r34 = r12
            r35 = r13
            r36 = r14
            r37 = r15
            r38 = r16
            r39 = r17
            r40 = r18
            r41 = r19
            r42 = r20
            r43 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.text.TextState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Unit> getRequestFocus() {
        return this.requestFocus;
    }

    public final MutableLiveData<TextInitModel> getInitText() {
        return this.initText;
    }

    public final MutableLiveData<TopicItem> getAddTopic() {
        return this.addTopic;
    }

    public final MutableLiveData<AtUserInfoItem> getAddAtUserInfo() {
        return this.addAtUserInfo;
    }

    public final MutableLiveData<List<TopicItem>> getInitTargetTopics() {
        return this.initTargetTopics;
    }

    public final MutableLiveData<List<AtUserInfoItem>> getInitTargetAtUsers() {
        return this.initTargetAtUsers;
    }

    public final MutableLiveData<List<LinkInfoItem>> getInitTargetLinks() {
        return this.initTargetLinks;
    }

    public final MutableLiveData<Unit> getCollection() {
        return this.collection;
    }

    public final MutableLiveData<TextInfoModel> getRestoration() {
        return this.restoration;
    }

    public final MutableLiveData<TopicBubbleModel> getTopicBubbleModel() {
        return this.topicBubbleModel;
    }

    public final MutableLiveData<ArrayList<TextTplDetailModel>> getTextTpl() {
        return this.textTpl;
    }

    public final MutableLiveData<String> getGroupName() {
        return this.groupName;
    }

    public final MutableLiveData<Pair<String, String>> getAiData() {
        return this.aiData;
    }

    public final MutableLiveData<String> getAiSwitch() {
        return this.aiSwitch;
    }

    public final MutableLiveData<String> getSourceFrom() {
        return this.sourceFrom;
    }

    public final MutableLiveData<Unit> getChangeAiIcon() {
        return this.changeAiIcon;
    }

    public final MutableLiveData<Unit> getShowImageToText() {
        return this.showImageToText;
    }

    public final MutableLiveData<String> getAiAnchorPointId() {
        return this.aiAnchorPointId;
    }

    public final MutableLiveData<AiStyleItemData> getAiStyleItemData() {
        return this.aiStyleItemData;
    }

    public final MutableLiveData<Unit> getShowImgGenTtxDialog() {
        return this.showImgGenTtxDialog;
    }

    public final MutableLiveData<Boolean> getShowAiImgGenTxtLoading() {
        return this.showAiImgGenTxtLoading;
    }
}
