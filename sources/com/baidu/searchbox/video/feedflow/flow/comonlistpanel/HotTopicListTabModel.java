package com.baidu.searchbox.video.feedflow.flow.comonlistpanel;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\bP\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÓ\u0002\u0012\"\b\u0002\u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012*\b\u0002\u0010\u0011\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u00120\u0003\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\u001c\b\u0002\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\r\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b¢\u0006\u0002\u0010 J#\u0010P\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00060\u0003HÆ\u0003J+\u0010Q\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u00120\u0003HÆ\u0003J\u000f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003HÆ\u0003J\t\u0010S\u001a\u00020\bHÆ\u0003J\t\u0010T\u001a\u00020\rHÆ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003HÆ\u0003J\t\u0010V\u001a\u00020\rHÆ\u0003J\u001d\u0010W\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0003J\t\u0010X\u001a\u00020\rHÆ\u0003J\u001d\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0003J\t\u0010Z\u001a\u00020\rHÆ\u0003J\t\u0010[\u001a\u00020\bHÆ\u0003J\t\u0010\\\u001a\u00020\rHÆ\u0003J\t\u0010]\u001a\u00020\bHÆ\u0003J\t\u0010^\u001a\u00020\bHÆ\u0003J\t\u0010_\u001a\u00020\bHÆ\u0003J\t\u0010`\u001a\u00020\bHÆ\u0003J\u000f\u0010a\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\t\u0010c\u001a\u00020\rHÆ\u0003J\t\u0010d\u001a\u00020\bHÆ\u0003J×\u0002\u0010e\u001a\u00020\u00002\"\b\u0002\u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\b2*\b\u0002\u0010\u0011\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u00120\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\r2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010\u0019\u001a\u00020\r2\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\b\b\u0002\u0010\u001b\u001a\u00020\r2\u001c\b\u0002\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\bHÆ\u0001J\u0013\u0010f\u001a\u00020\r2\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010h\u001a\u00020iHÖ\u0001J\t\u0010j\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u00101R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u00101R\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R3\u0010\u0011\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u001a\u0010\u0016\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010$\"\u0004\b9\u0010&R4\u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00060\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u00101R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u001a\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00105\"\u0004\b?\u00107R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00105\"\u0004\bA\u00107R.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010(\"\u0004\bC\u0010*R\u001a\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010$\"\u0004\bE\u0010&R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\"\"\u0004\bG\u00101R\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00105\"\u0004\bI\u00107R\u001a\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010$\"\u0004\bK\u0010&R\u001a\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00105\"\u0004\bM\u00107R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00105\"\u0004\bO\u00107¨\u0006k"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/HotTopicListTabModel;", "", "items", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/HotListItemModel;", "Lkotlin/collections/ArrayList;", "tabId", "", "name", "pageType", "layout", "hasPrev", "", "hasNext", "defaultSelect", "icon", "insertItems", "Lkotlin/Pair;", "contentState", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState;", "tabExt", "isExistsOffline", "notifyAdapterChanged", "", "showPoster", "noFirstPageDataItems", "noFirstPageHasPrev", "firstPageStartDataItems", "firstPageStartHasNext", "hasInterval", "moreCmd", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ZLjava/lang/String;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Ljava/lang/String;ZLandroidx/lifecycle/MutableLiveData;ZLjava/util/ArrayList;ZLjava/util/ArrayList;ZZLjava/lang/String;)V", "getContentState", "()Landroidx/lifecycle/MutableLiveData;", "getDefaultSelect", "()Z", "setDefaultSelect", "(Z)V", "getFirstPageStartDataItems", "()Ljava/util/ArrayList;", "setFirstPageStartDataItems", "(Ljava/util/ArrayList;)V", "getFirstPageStartHasNext", "setFirstPageStartHasNext", "getHasInterval", "setHasInterval", "getHasNext", "setHasNext", "(Landroidx/lifecycle/MutableLiveData;)V", "getHasPrev", "setHasPrev", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getInsertItems", "setExistsOffline", "getItems", "setItems", "getLayout", "setLayout", "getMoreCmd", "setMoreCmd", "getName", "setName", "getNoFirstPageDataItems", "setNoFirstPageDataItems", "getNoFirstPageHasPrev", "setNoFirstPageHasPrev", "getNotifyAdapterChanged", "setNotifyAdapterChanged", "getPageType", "setPageType", "getShowPoster", "setShowPoster", "getTabExt", "setTabExt", "getTabId", "setTabId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonListPanelState.kt */
public final class HotTopicListTabModel {
    private final MutableLiveData<CollectionPanelContentState> contentState;
    private boolean defaultSelect;
    private ArrayList<HotListItemModel> firstPageStartDataItems;
    private boolean firstPageStartHasNext;
    private boolean hasInterval;
    private MutableLiveData<Boolean> hasNext;
    private MutableLiveData<Boolean> hasPrev;
    private String icon;
    private final MutableLiveData<Pair<Boolean, ArrayList<HotListItemModel>>> insertItems;
    private boolean isExistsOffline;
    private MutableLiveData<ArrayList<HotListItemModel>> items;
    private String layout;
    private String moreCmd;
    private String name;
    private ArrayList<HotListItemModel> noFirstPageDataItems;
    private boolean noFirstPageHasPrev;
    private MutableLiveData<Unit> notifyAdapterChanged;
    private String pageType;
    private boolean showPoster;
    private String tabExt;
    private String tabId;

    public HotTopicListTabModel() {
        this((MutableLiveData) null, (String) null, (String) null, (String) null, (String) null, (MutableLiveData) null, (MutableLiveData) null, false, (String) null, (MutableLiveData) null, (MutableLiveData) null, (String) null, false, (MutableLiveData) null, false, (ArrayList) null, false, (ArrayList) null, false, false, (String) null, 2097151, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HotTopicListTabModel copy$default(HotTopicListTabModel hotTopicListTabModel, MutableLiveData mutableLiveData, String str, String str2, String str3, String str4, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, boolean z, String str5, MutableLiveData mutableLiveData4, MutableLiveData mutableLiveData5, String str6, boolean z2, MutableLiveData mutableLiveData6, boolean z3, ArrayList arrayList, boolean z4, ArrayList arrayList2, boolean z5, boolean z6, String str7, int i2, Object obj) {
        HotTopicListTabModel hotTopicListTabModel2 = hotTopicListTabModel;
        int i3 = i2;
        return hotTopicListTabModel.copy((i3 & 1) != 0 ? hotTopicListTabModel2.items : mutableLiveData, (i3 & 2) != 0 ? hotTopicListTabModel2.tabId : str, (i3 & 4) != 0 ? hotTopicListTabModel2.name : str2, (i3 & 8) != 0 ? hotTopicListTabModel2.pageType : str3, (i3 & 16) != 0 ? hotTopicListTabModel2.layout : str4, (i3 & 32) != 0 ? hotTopicListTabModel2.hasPrev : mutableLiveData2, (i3 & 64) != 0 ? hotTopicListTabModel2.hasNext : mutableLiveData3, (i3 & 128) != 0 ? hotTopicListTabModel2.defaultSelect : z, (i3 & 256) != 0 ? hotTopicListTabModel2.icon : str5, (i3 & 512) != 0 ? hotTopicListTabModel2.insertItems : mutableLiveData4, (i3 & 1024) != 0 ? hotTopicListTabModel2.contentState : mutableLiveData5, (i3 & 2048) != 0 ? hotTopicListTabModel2.tabExt : str6, (i3 & 4096) != 0 ? hotTopicListTabModel2.isExistsOffline : z2, (i3 & 8192) != 0 ? hotTopicListTabModel2.notifyAdapterChanged : mutableLiveData6, (i3 & 16384) != 0 ? hotTopicListTabModel2.showPoster : z3, (i3 & 32768) != 0 ? hotTopicListTabModel2.noFirstPageDataItems : arrayList, (i3 & 65536) != 0 ? hotTopicListTabModel2.noFirstPageHasPrev : z4, (i3 & 131072) != 0 ? hotTopicListTabModel2.firstPageStartDataItems : arrayList2, (i3 & 262144) != 0 ? hotTopicListTabModel2.firstPageStartHasNext : z5, (i3 & 524288) != 0 ? hotTopicListTabModel2.hasInterval : z6, (i3 & 1048576) != 0 ? hotTopicListTabModel2.moreCmd : str7);
    }

    public final MutableLiveData<ArrayList<HotListItemModel>> component1() {
        return this.items;
    }

    public final MutableLiveData<Pair<Boolean, ArrayList<HotListItemModel>>> component10() {
        return this.insertItems;
    }

    public final MutableLiveData<CollectionPanelContentState> component11() {
        return this.contentState;
    }

    public final String component12() {
        return this.tabExt;
    }

    public final boolean component13() {
        return this.isExistsOffline;
    }

    public final MutableLiveData<Unit> component14() {
        return this.notifyAdapterChanged;
    }

    public final boolean component15() {
        return this.showPoster;
    }

    public final ArrayList<HotListItemModel> component16() {
        return this.noFirstPageDataItems;
    }

    public final boolean component17() {
        return this.noFirstPageHasPrev;
    }

    public final ArrayList<HotListItemModel> component18() {
        return this.firstPageStartDataItems;
    }

    public final boolean component19() {
        return this.firstPageStartHasNext;
    }

    public final String component2() {
        return this.tabId;
    }

    public final boolean component20() {
        return this.hasInterval;
    }

    public final String component21() {
        return this.moreCmd;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.pageType;
    }

    public final String component5() {
        return this.layout;
    }

    public final MutableLiveData<Boolean> component6() {
        return this.hasPrev;
    }

    public final MutableLiveData<Boolean> component7() {
        return this.hasNext;
    }

    public final boolean component8() {
        return this.defaultSelect;
    }

    public final String component9() {
        return this.icon;
    }

    public final HotTopicListTabModel copy(MutableLiveData<ArrayList<HotListItemModel>> mutableLiveData, String str, String str2, String str3, String str4, MutableLiveData<Boolean> mutableLiveData2, MutableLiveData<Boolean> mutableLiveData3, boolean z, String str5, MutableLiveData<Pair<Boolean, ArrayList<HotListItemModel>>> mutableLiveData4, MutableLiveData<CollectionPanelContentState> mutableLiveData5, String str6, boolean z2, MutableLiveData<Unit> mutableLiveData6, boolean z3, ArrayList<HotListItemModel> arrayList, boolean z4, ArrayList<HotListItemModel> arrayList2, boolean z5, boolean z6, String str7) {
        MutableLiveData<ArrayList<HotListItemModel>> mutableLiveData7 = mutableLiveData;
        Intrinsics.checkNotNullParameter(mutableLiveData7, "items");
        Intrinsics.checkNotNullParameter(str, "tabId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "pageType");
        Intrinsics.checkNotNullParameter(str4, "layout");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "hasPrev");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "hasNext");
        Intrinsics.checkNotNullParameter(str5, "icon");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "insertItems");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "contentState");
        Intrinsics.checkNotNullParameter(str6, "tabExt");
        Intrinsics.checkNotNullParameter(mutableLiveData6, "notifyAdapterChanged");
        Intrinsics.checkNotNullParameter(str7, "moreCmd");
        return new HotTopicListTabModel(mutableLiveData7, str, str2, str3, str4, mutableLiveData2, mutableLiveData3, z, str5, mutableLiveData4, mutableLiveData5, str6, z2, mutableLiveData6, z3, arrayList, z4, arrayList2, z5, z6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HotTopicListTabModel)) {
            return false;
        }
        HotTopicListTabModel hotTopicListTabModel = (HotTopicListTabModel) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) hotTopicListTabModel.items) && Intrinsics.areEqual((Object) this.tabId, (Object) hotTopicListTabModel.tabId) && Intrinsics.areEqual((Object) this.name, (Object) hotTopicListTabModel.name) && Intrinsics.areEqual((Object) this.pageType, (Object) hotTopicListTabModel.pageType) && Intrinsics.areEqual((Object) this.layout, (Object) hotTopicListTabModel.layout) && Intrinsics.areEqual((Object) this.hasPrev, (Object) hotTopicListTabModel.hasPrev) && Intrinsics.areEqual((Object) this.hasNext, (Object) hotTopicListTabModel.hasNext) && this.defaultSelect == hotTopicListTabModel.defaultSelect && Intrinsics.areEqual((Object) this.icon, (Object) hotTopicListTabModel.icon) && Intrinsics.areEqual((Object) this.insertItems, (Object) hotTopicListTabModel.insertItems) && Intrinsics.areEqual((Object) this.contentState, (Object) hotTopicListTabModel.contentState) && Intrinsics.areEqual((Object) this.tabExt, (Object) hotTopicListTabModel.tabExt) && this.isExistsOffline == hotTopicListTabModel.isExistsOffline && Intrinsics.areEqual((Object) this.notifyAdapterChanged, (Object) hotTopicListTabModel.notifyAdapterChanged) && this.showPoster == hotTopicListTabModel.showPoster && Intrinsics.areEqual((Object) this.noFirstPageDataItems, (Object) hotTopicListTabModel.noFirstPageDataItems) && this.noFirstPageHasPrev == hotTopicListTabModel.noFirstPageHasPrev && Intrinsics.areEqual((Object) this.firstPageStartDataItems, (Object) hotTopicListTabModel.firstPageStartDataItems) && this.firstPageStartHasNext == hotTopicListTabModel.firstPageStartHasNext && this.hasInterval == hotTopicListTabModel.hasInterval && Intrinsics.areEqual((Object) this.moreCmd, (Object) hotTopicListTabModel.moreCmd);
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.items.hashCode() * 31) + this.tabId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.pageType.hashCode()) * 31) + this.layout.hashCode()) * 31) + this.hasPrev.hashCode()) * 31) + this.hasNext.hashCode()) * 31;
        boolean z = this.defaultSelect;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode2 = (((((((((hashCode + (z ? 1 : 0)) * 31) + this.icon.hashCode()) * 31) + this.insertItems.hashCode()) * 31) + this.contentState.hashCode()) * 31) + this.tabExt.hashCode()) * 31;
        boolean z3 = this.isExistsOffline;
        if (z3) {
            z3 = true;
        }
        int hashCode3 = (((hashCode2 + (z3 ? 1 : 0)) * 31) + this.notifyAdapterChanged.hashCode()) * 31;
        boolean z4 = this.showPoster;
        if (z4) {
            z4 = true;
        }
        int i2 = (hashCode3 + (z4 ? 1 : 0)) * 31;
        ArrayList<HotListItemModel> arrayList = this.noFirstPageDataItems;
        int i3 = 0;
        int hashCode4 = (i2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        boolean z5 = this.noFirstPageHasPrev;
        if (z5) {
            z5 = true;
        }
        int i4 = (hashCode4 + (z5 ? 1 : 0)) * 31;
        ArrayList<HotListItemModel> arrayList2 = this.firstPageStartDataItems;
        if (arrayList2 != null) {
            i3 = arrayList2.hashCode();
        }
        int i5 = (i4 + i3) * 31;
        boolean z6 = this.firstPageStartHasNext;
        if (z6) {
            z6 = true;
        }
        int i6 = (i5 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.hasInterval;
        if (!z7) {
            z2 = z7;
        }
        return ((i6 + (z2 ? 1 : 0)) * 31) + this.moreCmd.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HotTopicListTabModel(items=").append(this.items).append(", tabId=").append(this.tabId).append(", name=").append(this.name).append(", pageType=").append(this.pageType).append(", layout=").append(this.layout).append(", hasPrev=").append(this.hasPrev).append(", hasNext=").append(this.hasNext).append(", defaultSelect=").append(this.defaultSelect).append(", icon=").append(this.icon).append(", insertItems=").append(this.insertItems).append(", contentState=").append(this.contentState).append(", tabExt=");
        sb.append(this.tabExt).append(", isExistsOffline=").append(this.isExistsOffline).append(", notifyAdapterChanged=").append(this.notifyAdapterChanged).append(", showPoster=").append(this.showPoster).append(", noFirstPageDataItems=").append(this.noFirstPageDataItems).append(", noFirstPageHasPrev=").append(this.noFirstPageHasPrev).append(", firstPageStartDataItems=").append(this.firstPageStartDataItems).append(", firstPageStartHasNext=").append(this.firstPageStartHasNext).append(", hasInterval=").append(this.hasInterval).append(", moreCmd=").append(this.moreCmd).append(')');
        return sb.toString();
    }

    public HotTopicListTabModel(MutableLiveData<ArrayList<HotListItemModel>> items2, String tabId2, String name2, String pageType2, String layout2, MutableLiveData<Boolean> hasPrev2, MutableLiveData<Boolean> hasNext2, boolean defaultSelect2, String icon2, MutableLiveData<Pair<Boolean, ArrayList<HotListItemModel>>> insertItems2, MutableLiveData<CollectionPanelContentState> contentState2, String tabExt2, boolean isExistsOffline2, MutableLiveData<Unit> notifyAdapterChanged2, boolean showPoster2, ArrayList<HotListItemModel> noFirstPageDataItems2, boolean noFirstPageHasPrev2, ArrayList<HotListItemModel> firstPageStartDataItems2, boolean firstPageStartHasNext2, boolean hasInterval2, String moreCmd2) {
        MutableLiveData<ArrayList<HotListItemModel>> mutableLiveData = items2;
        String str = tabId2;
        String str2 = name2;
        String str3 = pageType2;
        String str4 = layout2;
        MutableLiveData<Boolean> mutableLiveData2 = hasPrev2;
        MutableLiveData<Boolean> mutableLiveData3 = hasNext2;
        String str5 = icon2;
        MutableLiveData<Pair<Boolean, ArrayList<HotListItemModel>>> mutableLiveData4 = insertItems2;
        MutableLiveData<CollectionPanelContentState> mutableLiveData5 = contentState2;
        String str6 = tabExt2;
        MutableLiveData<Unit> mutableLiveData6 = notifyAdapterChanged2;
        String str7 = moreCmd2;
        Intrinsics.checkNotNullParameter(mutableLiveData, "items");
        Intrinsics.checkNotNullParameter(str, "tabId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "pageType");
        Intrinsics.checkNotNullParameter(str4, "layout");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "hasPrev");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "hasNext");
        Intrinsics.checkNotNullParameter(str5, "icon");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "insertItems");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "contentState");
        Intrinsics.checkNotNullParameter(str6, "tabExt");
        Intrinsics.checkNotNullParameter(mutableLiveData6, "notifyAdapterChanged");
        Intrinsics.checkNotNullParameter(str7, "moreCmd");
        this.items = mutableLiveData;
        this.tabId = str;
        this.name = str2;
        this.pageType = str3;
        this.layout = str4;
        this.hasPrev = mutableLiveData2;
        this.hasNext = mutableLiveData3;
        this.defaultSelect = defaultSelect2;
        this.icon = str5;
        this.insertItems = mutableLiveData4;
        this.contentState = mutableLiveData5;
        this.tabExt = str6;
        this.isExistsOffline = isExistsOffline2;
        this.notifyAdapterChanged = mutableLiveData6;
        this.showPoster = showPoster2;
        this.noFirstPageDataItems = noFirstPageDataItems2;
        this.noFirstPageHasPrev = noFirstPageHasPrev2;
        this.firstPageStartDataItems = firstPageStartDataItems2;
        this.firstPageStartHasNext = firstPageStartHasNext2;
        this.hasInterval = hasInterval2;
        this.moreCmd = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HotTopicListTabModel(androidx.lifecycle.MutableLiveData r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, androidx.lifecycle.MutableLiveData r28, androidx.lifecycle.MutableLiveData r29, boolean r30, java.lang.String r31, androidx.lifecycle.MutableLiveData r32, androidx.lifecycle.MutableLiveData r33, java.lang.String r34, boolean r35, androidx.lifecycle.MutableLiveData r36, boolean r37, java.util.ArrayList r38, boolean r39, java.util.ArrayList r40, boolean r41, boolean r42, java.lang.String r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
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
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0016
            r2 = r3
            goto L_0x0018
        L_0x0016:
            r2 = r24
        L_0x0018:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001e
            r4 = r3
            goto L_0x0020
        L_0x001e:
            r4 = r25
        L_0x0020:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0026
            r5 = r3
            goto L_0x0028
        L_0x0026:
            r5 = r26
        L_0x0028:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002e
            r6 = r3
            goto L_0x0030
        L_0x002e:
            r6 = r27
        L_0x0030:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x003a
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            goto L_0x003c
        L_0x003a:
            r7 = r28
        L_0x003c:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0046
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            goto L_0x0048
        L_0x0046:
            r8 = r29
        L_0x0048:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x004e
            r9 = 0
            goto L_0x0050
        L_0x004e:
            r9 = r30
        L_0x0050:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0056
            r11 = r3
            goto L_0x0058
        L_0x0056:
            r11 = r31
        L_0x0058:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0062
            androidx.lifecycle.MutableLiveData r12 = new androidx.lifecycle.MutableLiveData
            r12.<init>()
            goto L_0x0064
        L_0x0062:
            r12 = r32
        L_0x0064:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x006e
            androidx.lifecycle.MutableLiveData r13 = new androidx.lifecycle.MutableLiveData
            r13.<init>()
            goto L_0x0070
        L_0x006e:
            r13 = r33
        L_0x0070:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0076
            r14 = r3
            goto L_0x0078
        L_0x0076:
            r14 = r34
        L_0x0078:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x007e
            r15 = 0
            goto L_0x0080
        L_0x007e:
            r15 = r35
        L_0x0080:
            r10 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x008a
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            goto L_0x008c
        L_0x008a:
            r10 = r36
        L_0x008c:
            r45 = r3
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x0094
            r3 = 0
            goto L_0x0096
        L_0x0094:
            r3 = r37
        L_0x0096:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00a3
            java.util.ArrayList r16 = new java.util.ArrayList
            r16.<init>()
            goto L_0x00a5
        L_0x00a3:
            r16 = r38
        L_0x00a5:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00ae
            r17 = 0
            goto L_0x00b0
        L_0x00ae:
            r17 = r39
        L_0x00b0:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00bc
            java.util.ArrayList r18 = new java.util.ArrayList
            r18.<init>()
            goto L_0x00be
        L_0x00bc:
            r18 = r40
        L_0x00be:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00c7
            r19 = 0
            goto L_0x00c9
        L_0x00c7:
            r19 = r41
        L_0x00c9:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00d2
            r20 = 0
            goto L_0x00d4
        L_0x00d2:
            r20 = r42
        L_0x00d4:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r21
            if (r0 == 0) goto L_0x00dd
            r0 = r45
            goto L_0x00df
        L_0x00dd:
            r0 = r43
        L_0x00df:
            r23 = r1
            r24 = r2
            r25 = r4
            r26 = r5
            r27 = r6
            r28 = r7
            r29 = r8
            r30 = r9
            r31 = r11
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r15
            r36 = r10
            r37 = r3
            r38 = r16
            r39 = r17
            r40 = r18
            r41 = r19
            r42 = r20
            r43 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotTopicListTabModel.<init>(androidx.lifecycle.MutableLiveData, java.lang.String, java.lang.String, java.lang.String, java.lang.String, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, boolean, java.lang.String, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, java.lang.String, boolean, androidx.lifecycle.MutableLiveData, boolean, java.util.ArrayList, boolean, java.util.ArrayList, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<ArrayList<HotListItemModel>> getItems() {
        return this.items;
    }

    public final void setItems(MutableLiveData<ArrayList<HotListItemModel>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.items = mutableLiveData;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final void setTabId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tabId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final void setPageType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageType = str;
    }

    public final String getLayout() {
        return this.layout;
    }

    public final void setLayout(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.layout = str;
    }

    public final MutableLiveData<Boolean> getHasPrev() {
        return this.hasPrev;
    }

    public final void setHasPrev(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.hasPrev = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getHasNext() {
        return this.hasNext;
    }

    public final void setHasNext(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.hasNext = mutableLiveData;
    }

    public final boolean getDefaultSelect() {
        return this.defaultSelect;
    }

    public final void setDefaultSelect(boolean z) {
        this.defaultSelect = z;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final MutableLiveData<Pair<Boolean, ArrayList<HotListItemModel>>> getInsertItems() {
        return this.insertItems;
    }

    public final MutableLiveData<CollectionPanelContentState> getContentState() {
        return this.contentState;
    }

    public final String getTabExt() {
        return this.tabExt;
    }

    public final void setTabExt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tabExt = str;
    }

    public final boolean isExistsOffline() {
        return this.isExistsOffline;
    }

    public final void setExistsOffline(boolean z) {
        this.isExistsOffline = z;
    }

    public final MutableLiveData<Unit> getNotifyAdapterChanged() {
        return this.notifyAdapterChanged;
    }

    public final void setNotifyAdapterChanged(MutableLiveData<Unit> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.notifyAdapterChanged = mutableLiveData;
    }

    public final boolean getShowPoster() {
        return this.showPoster;
    }

    public final void setShowPoster(boolean z) {
        this.showPoster = z;
    }

    public final ArrayList<HotListItemModel> getNoFirstPageDataItems() {
        return this.noFirstPageDataItems;
    }

    public final void setNoFirstPageDataItems(ArrayList<HotListItemModel> arrayList) {
        this.noFirstPageDataItems = arrayList;
    }

    public final boolean getNoFirstPageHasPrev() {
        return this.noFirstPageHasPrev;
    }

    public final void setNoFirstPageHasPrev(boolean z) {
        this.noFirstPageHasPrev = z;
    }

    public final ArrayList<HotListItemModel> getFirstPageStartDataItems() {
        return this.firstPageStartDataItems;
    }

    public final void setFirstPageStartDataItems(ArrayList<HotListItemModel> arrayList) {
        this.firstPageStartDataItems = arrayList;
    }

    public final boolean getFirstPageStartHasNext() {
        return this.firstPageStartHasNext;
    }

    public final void setFirstPageStartHasNext(boolean z) {
        this.firstPageStartHasNext = z;
    }

    public final boolean getHasInterval() {
        return this.hasInterval;
    }

    public final void setHasInterval(boolean z) {
        this.hasInterval = z;
    }

    public final String getMoreCmd() {
        return this.moreCmd;
    }

    public final void setMoreCmd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.moreCmd = str;
    }
}
