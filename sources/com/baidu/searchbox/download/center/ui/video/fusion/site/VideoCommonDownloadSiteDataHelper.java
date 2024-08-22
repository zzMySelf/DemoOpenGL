package com.baidu.searchbox.download.center.ui.video.fusion.site;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.download.center.ui.video.fusion.adapter.ISelectedItemChecker;
import com.baidu.searchbox.download.center.ui.video.fusion.model.AbsVideoTemplateModel;
import com.baidu.searchbox.download.center.ui.video.fusion.model.VideoCommonDownloadSiteModel;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000e\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J \u0010\u0014\u001a\u00020\u00152\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0018\u0012\u0004\u0012\u00020\u00150\u0017J \u0010\u0019\u001a\u00020\u00152\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0018\u0012\u0004\u0012\u00020\u00150\u0017J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000fJ\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000fJ\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0002J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\tH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005`\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/video/fusion/site/VideoCommonDownloadSiteDataHelper;", "Lcom/baidu/searchbox/download/center/ui/video/fusion/adapter/ISelectedItemChecker;", "()V", "commonDownloadSiteList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/download/center/ui/video/fusion/model/AbsVideoTemplateModel;", "Lkotlin/collections/ArrayList;", "commonDownloadSiteMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "selectedItemIdSet", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "checkIsAllSelected", "", "getCommonDownloadSiteByIndex", "index", "", "getSelectedCount", "handleDelete", "", "onDeleteComplete", "Lkotlin/Function1;", "", "loadData", "dataCallback", "onEditableChanged", "isEditable", "onItemSelectStateChangeCallback", "position", "selected", "onSelectedAllClicked", "isSelectedAll", "queryCommonDownloadSiteList", "queryItemSelected", "itemId", "Companion", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonDownloadSiteDataHelper.kt */
public final class VideoCommonDownloadSiteDataHelper implements ISelectedItemChecker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TASK_DELETE_COMMON_DOWNLOAD_SITE = "deleteVideoCommonDownloadSite";
    private static final String TASK_LOAD_COMMON_DOWNLOAD_SITE = "loadVideoCommonDownloadSite";
    private final ArrayList<AbsVideoTemplateModel> commonDownloadSiteList = new ArrayList<>();
    private final HashMap<String, AbsVideoTemplateModel> commonDownloadSiteMap = new HashMap<>();
    private final LinkedHashSet<String> selectedItemIdSet = new LinkedHashSet<>();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/video/fusion/site/VideoCommonDownloadSiteDataHelper$Companion;", "", "()V", "TASK_DELETE_COMMON_DOWNLOAD_SITE", "", "TASK_LOAD_COMMON_DOWNLOAD_SITE", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoCommonDownloadSiteDataHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void loadData(Function1<? super List<? extends AbsVideoTemplateModel>, Unit> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        ExecutorUtilsExt.postOnSerial(new VideoCommonDownloadSiteDataHelper$$ExternalSyntheticLambda2(this, dataCallback), TASK_LOAD_COMMON_DOWNLOAD_SITE);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadData$lambda-2  reason: not valid java name */
    public static final void m17703loadData$lambda2(VideoCommonDownloadSiteDataHelper this$0, Function1 $dataCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($dataCallback, "$dataCallback");
        UiThreadUtils.runOnUiThread(new VideoCommonDownloadSiteDataHelper$$ExternalSyntheticLambda1(this$0, this$0.queryCommonDownloadSiteList(), $dataCallback));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadData$lambda-2$lambda-1  reason: not valid java name */
    public static final void m17704loadData$lambda2$lambda1(VideoCommonDownloadSiteDataHelper this$0, List $dataList, Function1 $dataCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($dataList, "$dataList");
        Intrinsics.checkNotNullParameter($dataCallback, "$dataCallback");
        this$0.commonDownloadSiteList.clear();
        this$0.commonDownloadSiteMap.clear();
        Iterator it = $dataList.iterator();
        while (it.hasNext()) {
            AbsVideoTemplateModel dataItem = (AbsVideoTemplateModel) it.next();
            this$0.commonDownloadSiteList.add(dataItem);
            this$0.commonDownloadSiteMap.put(dataItem.getId(), dataItem);
        }
        $dataCallback.invoke(this$0.commonDownloadSiteList);
    }

    public final int getSelectedCount() {
        return this.selectedItemIdSet.size();
    }

    public final boolean checkIsAllSelected() {
        return this.selectedItemIdSet.size() == this.commonDownloadSiteList.size();
    }

    public final void handleDelete(Function1<? super List<? extends AbsVideoTemplateModel>, Unit> onDeleteComplete) {
        Intrinsics.checkNotNullParameter(onDeleteComplete, "onDeleteComplete");
        ExecutorUtilsExt.postOnSerial(new VideoCommonDownloadSiteDataHelper$$ExternalSyntheticLambda3(this, onDeleteComplete), TASK_DELETE_COMMON_DOWNLOAD_SITE);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleDelete$lambda-6  reason: not valid java name */
    public static final void m17701handleDelete$lambda6(VideoCommonDownloadSiteDataHelper this$0, Function1 $onDeleteComplete) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($onDeleteComplete, "$onDeleteComplete");
        UiThreadUtils.runOnUiThread(new VideoCommonDownloadSiteDataHelper$$ExternalSyntheticLambda0(this$0, VideoCommonDownloadSiteDataHolder.INSTANCE.deleteVideoCommonDownloadSite(this$0.selectedItemIdSet), $onDeleteComplete));
    }

    /* access modifiers changed from: private */
    /* renamed from: handleDelete$lambda-6$lambda-5  reason: not valid java name */
    public static final void m17702handleDelete$lambda6$lambda5(VideoCommonDownloadSiteDataHelper this$0, List $webSiteList, Function1 $onDeleteComplete) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($webSiteList, "$webSiteList");
        Intrinsics.checkNotNullParameter($onDeleteComplete, "$onDeleteComplete");
        this$0.commonDownloadSiteList.clear();
        this$0.commonDownloadSiteMap.clear();
        Iterator it = $webSiteList.iterator();
        while (it.hasNext()) {
            String website = (String) it.next();
            VideoCommonDownloadSiteModel commonDownloadSite = new VideoCommonDownloadSiteModel();
            VideoCommonDownloadSiteModel $this$handleDelete_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3 = commonDownloadSite;
            $this$handleDelete_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.setId(website);
            $this$handleDelete_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.setTitle(website);
            this$0.commonDownloadSiteList.add(commonDownloadSite);
            this$0.commonDownloadSiteMap.put(commonDownloadSite.getId(), commonDownloadSite);
        }
        $onDeleteComplete.invoke(this$0.commonDownloadSiteList);
    }

    public boolean queryItemSelected(String itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return this.selectedItemIdSet.contains(itemId);
    }

    public final void onEditableChanged(boolean isEditable) {
        if (isEditable) {
            this.selectedItemIdSet.clear();
        }
    }

    public final void onSelectedAllClicked(boolean isSelectedAll) {
        this.selectedItemIdSet.clear();
        if (isSelectedAll) {
            this.selectedItemIdSet.addAll(this.commonDownloadSiteMap.keySet());
        }
    }

    public final void onItemSelectStateChangeCallback(int position, boolean selected) {
        AbsVideoTemplateModel targetItem = getCommonDownloadSiteByIndex(position);
        if (targetItem == null) {
            return;
        }
        if (selected) {
            this.selectedItemIdSet.add(targetItem.getId());
        } else {
            this.selectedItemIdSet.remove(targetItem.getId());
        }
    }

    public final AbsVideoTemplateModel getCommonDownloadSiteByIndex(int index) {
        return (AbsVideoTemplateModel) CollectionsKt.getOrNull(this.commonDownloadSiteList, index);
    }

    private final List<AbsVideoTemplateModel> queryCommonDownloadSiteList() {
        Iterable<String> $this$map$iv = VideoCommonDownloadSiteDataHolder.INSTANCE.fetchVideoCommonDownloadSiteList();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (String website : $this$map$iv) {
            VideoCommonDownloadSiteModel videoCommonDownloadSiteModel = new VideoCommonDownloadSiteModel();
            VideoCommonDownloadSiteModel $this$queryCommonDownloadSiteList_u24lambda_u2d9_u24lambda_u2d8 = videoCommonDownloadSiteModel;
            $this$queryCommonDownloadSiteList_u24lambda_u2d9_u24lambda_u2d8.setId(website);
            $this$queryCommonDownloadSiteList_u24lambda_u2d9_u24lambda_u2d8.setTitle(website);
            destination$iv$iv.add(videoCommonDownloadSiteModel);
        }
        return (List) destination$iv$iv;
    }
}
