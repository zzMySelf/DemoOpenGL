package com.baidu.searchbox.download.center.ui.fusion.template;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.common.IDataObserver;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.io.PathUtils;
import com.baidu.download.DownloadPermissionHelper;
import com.baidu.download.DownloadStatisticsUBC;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheTips;
import com.baidu.searchbox.download.center.ioc.IDownloadCenterApp;
import com.baidu.searchbox.download.center.ui.DownloadedCategoryAppActivity;
import com.baidu.searchbox.download.center.ui.DownloadedCategorySecActivity;
import com.baidu.searchbox.download.center.ui.DownloadedDocActivity;
import com.baidu.searchbox.download.center.ui.PictureCategoryActivity;
import com.baidu.searchbox.download.center.ui.downloaded.DownloadedCategoryItem;
import com.baidu.searchbox.download.center.ui.fusion.DownloadManagerActivity;
import com.baidu.searchbox.download.center.ui.fusion.adapter.ClassifyAdapter;
import com.baidu.searchbox.download.center.ui.fusion.adapter.RecentDownloadAdapter;
import com.baidu.searchbox.download.center.ui.fusion.manager.ClassifyTemplateTipManager;
import com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic;
import com.baidu.searchbox.download.center.ui.fusion.template.base.ITemplate;
import com.baidu.searchbox.download.center.ui.fusion.template.base.TemplateType;
import com.baidu.searchbox.download.center.unzip.DownloadUnzipActivity;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.util.DownloadByteConverter;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.lightbrowser.RuntimeKt;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0007J.\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0014\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0004\u0012\u00020\"0*H\u0002J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.H\u0016J \u0010/\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002J\u001e\u00103\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000205\u0018\u0001042\u0006\u0010'\u001a\u00020(H\u0002J\b\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020&H\u0002J\u0006\u0010:\u001a\u00020\"J\b\u0010;\u001a\u00020\"H\u0002J\u0006\u0010<\u001a\u00020\"J\u0018\u0010=\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010>\u001a\u00020\u0010H\u0002J\b\u0010?\u001a\u00020\"H\u0002J\u0018\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J\u0006\u0010E\u001a\u00020\"J\u0016\u0010F\u001a\u00020\"2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001e0HH\u0002J\u0012\u0010I\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0003J\b\u0010J\u001a\u00020\"H\u0003R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/fusion/template/ClassificationTemplate;", "Lcom/baidu/searchbox/download/center/ui/fusion/template/base/ITemplate;", "()V", "bubbleManager", "Lcom/baidu/searchbox/ui/bubble/manager/BubbleTextManager;", "classifyAdapter", "Lcom/baidu/searchbox/download/center/ui/fusion/adapter/ClassifyAdapter;", "downloadAdapter", "Lcom/baidu/searchbox/download/center/ui/fusion/adapter/RecentDownloadAdapter;", "downloadArrow", "Landroid/widget/ImageView;", "downloadNum", "Landroid/widget/TextView;", "downloadingObserver", "Lcom/baidu/android/common/IDataObserver;", "isRegisteringDownloadingObserver", "", "mIsHasDoCacheUbc", "mIsHasDoSpaceUbc", "mRootView", "Landroid/view/View;", "mTitleClearCacheView", "Lcom/baidu/searchbox/download/center/ui/fusion/template/ClassificationTitleClearCacheView;", "mTitlePhoneSpaceView", "recentLayout", "Landroid/widget/LinearLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "secondData", "", "Lcom/baidu/searchbox/download/center/ui/downloaded/DownloadedCategoryItem;", "showUnzipBubble", "unfold", "adjustNightMode", "", "itemView", "buildIntent", "category", "", "context", "Landroid/content/Context;", "function", "Lkotlin/Function1;", "Landroid/content/Intent;", "createView", "parent", "Landroid/view/ViewGroup;", "garbageStatistic", "type", "", "source", "getMemoryInfo", "Lkotlin/Pair;", "", "getTemplateType", "Lcom/baidu/searchbox/download/center/ui/fusion/template/base/TemplateType;", "handleOnDownloadComplete", "downloadType", "hideBubble", "registerDownloadingObserver", "showUnzipBubbleIfNeed", "startAnimation", "isOpen", "unregisterDownloadingObserver", "update", "viewHolder", "Lcom/baidu/searchbox/download/center/ui/fusion/adapter/FileManagerHolder;", "templateModel", "Lcom/baidu/searchbox/download/center/ui/fusion/model/AbsTemplateModel;", "updateDownloadingAndDownloadNum", "updateFoldTipText", "categoryItems", "Ljava/util/ArrayList;", "updateGarbageView", "updateSpaceView", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassificationTemplate.kt */
public final class ClassificationTemplate implements ITemplate {
    private BubbleTextManager bubbleManager;
    /* access modifiers changed from: private */
    public ClassifyAdapter classifyAdapter;
    private RecentDownloadAdapter downloadAdapter;
    private ImageView downloadArrow;
    private TextView downloadNum;
    private IDataObserver downloadingObserver;
    private boolean isRegisteringDownloadingObserver;
    private boolean mIsHasDoCacheUbc;
    private boolean mIsHasDoSpaceUbc;
    /* access modifiers changed from: private */
    public View mRootView;
    private ClassificationTitleClearCacheView mTitleClearCacheView;
    private TextView mTitlePhoneSpaceView;
    private LinearLayout recentLayout;
    private RecyclerView recyclerView;
    /* access modifiers changed from: private */
    public final List<DownloadedCategoryItem> secondData = new ArrayList();
    /* access modifiers changed from: private */
    public boolean showUnzipBubble;
    /* access modifiers changed from: private */
    public boolean unfold;

    public void doUbcStatistic(String itemId, String type, String source, String value, String ext, String ubcId) {
        ITemplate.DefaultImpls.doUbcStatistic(this, itemId, type, source, value, ext, ubcId);
    }

    public void doUbcWithoutFilterStatistic(String type, String source, String value, String ext) {
        ITemplate.DefaultImpls.doUbcWithoutFilterStatistic(this, type, source, value, ext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
        r1 = r1.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(com.baidu.searchbox.download.center.ui.fusion.adapter.FileManagerHolder r10, com.baidu.searchbox.download.center.ui.fusion.model.AbsTemplateModel r11) {
        /*
            r9 = this;
            java.lang.String r0 = "viewHolder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "templateModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r11 instanceof com.baidu.searchbox.download.center.ui.fusion.model.ClassifyTemplateModel
            if (r0 == 0) goto L_0x0111
            android.view.View r0 = r10.itemView
            android.view.View r1 = r10.itemView
            android.content.Context r1 = r1.getContext()
            r2 = 0
            if (r1 == 0) goto L_0x0028
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0028
            int r3 = com.baidu.searchbox.download.center.R.drawable.download_fusion_classify_bg
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            goto L_0x0029
        L_0x0028:
            r1 = r2
        L_0x0029:
            r0.setBackground(r1)
            android.view.View r0 = r10.itemView
            r9.adjustNightMode(r0)
            r0 = r11
            com.baidu.searchbox.download.center.ui.fusion.model.ClassifyTemplateModel r0 = (com.baidu.searchbox.download.center.ui.fusion.model.ClassifyTemplateModel) r0
            java.util.ArrayList r0 = r0.getCategoryItems()
            java.util.List<com.baidu.searchbox.download.center.ui.downloaded.DownloadedCategoryItem> r1 = r9.secondData
            r1.clear()
            java.util.List<com.baidu.searchbox.download.center.ui.downloaded.DownloadedCategoryItem> r1 = r9.secondData
            int r3 = r0.size()
            r4 = 5
            java.util.List r3 = r0.subList(r4, r3)
            java.lang.String r5 = "itemDatas.subList(5, itemDatas.size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            java.util.Collection r3 = (java.util.Collection) r3
            r1.addAll(r3)
            r9.updateFoldTipText(r0)
            com.baidu.searchbox.download.center.ui.fusion.adapter.ClassifyAdapter r1 = r9.classifyAdapter
            if (r1 == 0) goto L_0x005f
            java.util.List r1 = r1.getCategoryItems()
            goto L_0x0060
        L_0x005f:
            r1 = r2
        L_0x0060:
            if (r1 == 0) goto L_0x0065
            r1.clear()
        L_0x0065:
            boolean r3 = r9.unfold
            r5 = 0
            if (r3 != 0) goto L_0x007d
            java.util.List r3 = r0.subList(r5, r4)
            java.lang.String r4 = "itemDatas.subList(0, 5)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            if (r1 == 0) goto L_0x0085
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            r1.addAll(r4)
            goto L_0x0085
        L_0x007d:
            if (r1 == 0) goto L_0x0085
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            r1.addAll(r3)
        L_0x0085:
            com.baidu.searchbox.download.center.ui.fusion.adapter.ClassifyAdapter r3 = r9.classifyAdapter
            if (r3 != 0) goto L_0x008a
            goto L_0x008f
        L_0x008a:
            boolean r4 = r9.unfold
            r3.setUnfold(r4)
        L_0x008f:
            com.baidu.searchbox.download.center.ui.fusion.adapter.ClassifyAdapter r3 = r9.classifyAdapter
            if (r3 == 0) goto L_0x0096
            r3.notifyDataSetChanged()
        L_0x0096:
            com.baidu.searchbox.download.center.ui.fusion.adapter.RecentDownloadAdapter r3 = r9.downloadAdapter
            if (r3 != 0) goto L_0x00a0
            java.lang.String r3 = "downloadAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r2
        L_0x00a0:
            r4 = r11
            com.baidu.searchbox.download.center.ui.fusion.model.ClassifyTemplateModel r4 = (com.baidu.searchbox.download.center.ui.fusion.model.ClassifyTemplateModel) r4
            java.util.List r4 = r4.getDownloadDatas()
            r3.setDatas(r4)
            r9.updateSpaceView()
            r9.updateDownloadingAndDownloadNum()
            r3 = r11
            com.baidu.searchbox.download.center.ui.fusion.model.ClassifyTemplateModel r3 = (com.baidu.searchbox.download.center.ui.fusion.model.ClassifyTemplateModel) r3
            boolean r3 = r3.isShowClearCacheView()
            r4 = 1
            java.lang.String r6 = "page_show"
            r7 = 8
            if (r3 == 0) goto L_0x00e8
            android.widget.TextView r8 = r9.mTitlePhoneSpaceView
            if (r8 != 0) goto L_0x00c4
            goto L_0x00c7
        L_0x00c4:
            r8.setVisibility(r7)
        L_0x00c7:
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTitleClearCacheView r7 = r9.mTitleClearCacheView
            if (r7 != 0) goto L_0x00cc
            goto L_0x00cf
        L_0x00cc:
            r7.setVisibility(r5)
        L_0x00cf:
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTitleClearCacheView r5 = r9.mTitleClearCacheView
            if (r5 == 0) goto L_0x00d7
            android.content.Context r2 = r5.getContext()
        L_0x00d7:
            if (r2 == 0) goto L_0x0111
            boolean r5 = r9.mIsHasDoCacheUbc
            if (r5 != 0) goto L_0x0111
            java.lang.String r5 = "clear"
            r9.garbageStatistic(r2, r5, r6)
            r9.mIsHasDoCacheUbc = r4
            goto L_0x0111
        L_0x00e8:
            android.widget.TextView r8 = r9.mTitlePhoneSpaceView
            if (r8 != 0) goto L_0x00ed
            goto L_0x00f0
        L_0x00ed:
            r8.setVisibility(r5)
        L_0x00f0:
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTitleClearCacheView r5 = r9.mTitleClearCacheView
            if (r5 != 0) goto L_0x00f5
            goto L_0x00f8
        L_0x00f5:
            r5.setVisibility(r7)
        L_0x00f8:
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTitleClearCacheView r5 = r9.mTitleClearCacheView
            if (r5 == 0) goto L_0x0100
            android.content.Context r2 = r5.getContext()
        L_0x0100:
            if (r2 == 0) goto L_0x0111
            boolean r5 = r9.mIsHasDoSpaceUbc
            if (r5 != 0) goto L_0x0111
            java.lang.String r5 = "space"
            r9.garbageStatistic(r2, r5, r6)
            r9.mIsHasDoSpaceUbc = r4
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate.update(com.baidu.searchbox.download.center.ui.fusion.adapter.FileManagerHolder, com.baidu.searchbox.download.center.ui.fusion.model.AbsTemplateModel):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void garbageStatistic(android.content.Context r16, java.lang.String r17, java.lang.String r18) {
        /*
            r15 = this;
            kotlin.Pair r0 = r15.getMemoryInfo(r16)
            com.baidu.searchbox.config.DefaultSharedPrefsWrapper r1 = com.baidu.searchbox.config.DefaultSharedPrefsWrapper.getInstance()
            java.lang.String r2 = "clear_cache_tips_without_download_key"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.getString(r2, r3)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            if (r2 == 0) goto L_0x0020
            int r2 = r2.length()
            if (r2 != 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r2 = r3
            goto L_0x0021
        L_0x0020:
            r2 = 1
        L_0x0021:
            if (r2 != 0) goto L_0x0056
            int r2 = r1.length()
            r4 = 3
            if (r2 < r4) goto L_0x0056
            int r2 = r1.length()
            int r2 = r2 + -2
            java.lang.String r2 = r1.substring(r3, r2)
            java.lang.String r4 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r5 = "0"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = android.text.TextUtils.equals(r2, r5)
            if (r2 == 0) goto L_0x0047
            goto L_0x0056
        L_0x0047:
            int r2 = r1.length()
            int r2 = r2 + -2
            java.lang.String r2 = r1.substring(r3, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r1 = r2
            goto L_0x0058
        L_0x0056:
            java.lang.String r1 = "0"
        L_0x0058:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r3 = 0
            if (r0 == 0) goto L_0x0067
            java.lang.Object r4 = r0.getFirst()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0068
        L_0x0067:
            r4 = r3
        L_0x0068:
            java.lang.String r5 = "usedspace"
            r2.put(r5, r4)
            if (r0 == 0) goto L_0x0076
            java.lang.Object r3 = r0.getSecond()
            java.lang.Float r3 = (java.lang.Float) r3
        L_0x0076:
            java.lang.String r4 = "totalspace"
            r2.put(r4, r3)
            java.lang.String r3 = "filespace"
            r2.put(r3, r1)
            com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic r3 = com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic.INSTANCE
            java.lang.String r3 = r3.getExtFromBySource()
            java.lang.String r4 = "from"
            r2.putOpt(r4, r3)
            com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic r5 = com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic.INSTANCE
            java.lang.String r11 = r2.toString()
            r12 = 0
            r13 = 64
            r14 = 0
            java.lang.String r6 = "tool"
            java.lang.String r9 = "file"
            java.lang.String r10 = "clear"
            r7 = r17
            r8 = r18
            com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic.downloadCenterStatistic$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate.garbageStatistic(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void updateFoldTipText(ArrayList<DownloadedCategoryItem> categoryItems) {
        Object element$iv;
        boolean z;
        Iterator it = categoryItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            if (9 == ((DownloadedCategoryItem) element$iv).downloadType) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        DownloadedCategoryItem foldCategoryItem = (DownloadedCategoryItem) element$iv;
        if (foldCategoryItem != null) {
            foldCategoryItem.newCount = ClassifyTemplateTipManager.INSTANCE.mergeItemListTipCount(this.secondData);
        }
    }

    /* access modifiers changed from: private */
    public final void updateGarbageView(View itemView) {
        ClassificationTitleClearCacheView classificationTitleClearCacheView;
        String cleanSizeString = DefaultSharedPrefsWrapper.getInstance().getString(ClearCacheTips.CLEAR_CACHE_TIPS_WITHOUT_DOWNLOAD_KEY, "");
        ClassificationTitleClearCacheView classificationTitleClearCacheView2 = this.mTitleClearCacheView;
        if (classificationTitleClearCacheView2 != null) {
            classificationTitleClearCacheView2.setCacheTitle(cleanSizeString);
        }
        Context contextActual = itemView != null ? itemView.getContext() : null;
        if (contextActual != null && (classificationTitleClearCacheView = this.mTitleClearCacheView) != null) {
            classificationTitleClearCacheView.setOnClickedCallback(new ClassificationTemplate$updateGarbageView$1(this, contextActual));
        }
    }

    /* access modifiers changed from: private */
    public final void updateSpaceView() {
        String spaceStr;
        try {
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
            Pair memoryInfo = getMemoryInfo(appContext);
            if (memoryInfo == null || (spaceStr = memoryInfo.getFirst()) == null) {
                spaceStr = PanTemplate.PAN_SPACE_DEFAULT_TEXT;
            }
            TextView textView = this.mTitlePhoneSpaceView;
            if (textView != null) {
                textView.setText("容量：" + spaceStr);
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    public final void showUnzipBubbleIfNeed() {
        ClassifyAdapter classifyAdapter2;
        List $this$indexOfFirst$iv;
        RecyclerView.LayoutManager layoutManager;
        View findViewByPosition;
        View bubbleAnchorView;
        if (this.showUnzipBubble && !DefaultSharedPrefsWrapper.getInstance().getBoolean(DownloadUnzipActivity.HAS_SHOW_GUIDE, false) && (classifyAdapter2 = this.classifyAdapter) != null && ($this$indexOfFirst$iv = classifyAdapter2.getCategoryItems()) != null) {
            int index$iv = 0;
            Iterator<DownloadedCategoryItem> it = $this$indexOfFirst$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    index$iv = -1;
                    break;
                }
                if ((it.next().downloadType == 8 ? 1 : null) != null) {
                    break;
                }
                index$iv++;
            }
            int unzipTypePosition = index$iv;
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null && (layoutManager = recyclerView2.getLayoutManager()) != null && (findViewByPosition = layoutManager.findViewByPosition(unzipTypePosition)) != null && (bubbleAnchorView = findViewByPosition.findViewById(R.id.downloaded_category_image)) != null) {
                BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setAnchorView(bubbleAnchorView).setText(bubbleAnchorView.getContext().getResources().getString(R.string.download_fusion_unzip_folder_tips)).setFontSize(1, 14.0f).setAutoDismiss(true).setAutoDismissInterval(5000).setForceShowPosition(BubblePosition.DOWN).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new ClassificationTemplate$showUnzipBubbleIfNeed$2$1$1(this)).build();
                this.bubbleManager = build;
                if (build != null) {
                    build.showBubble();
                }
                this.showUnzipBubble = false;
                DefaultSharedPrefsWrapper.getInstance().putBoolean(DownloadUnzipActivity.HAS_SHOW_GUIDE, true);
            }
        }
    }

    public final void hideBubble() {
        BubbleTextManager bubbleTextManager = this.bubbleManager;
        if (bubbleTextManager != null) {
            bubbleTextManager.dismissBubble();
        }
    }

    private final Pair<String, Float> getMemoryInfo(Context context) {
        try {
            if (!PathUtils.isExternalStorageWritable()) {
                return null;
            }
            File file = Environment.getExternalStorageDirectory().getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(file, "getExternalStorageDirectory().absoluteFile");
            StatFs stat = new StatFs(file.getPath());
            long totalSpace = stat.getTotalBytes();
            long usedSpace = stat.getTotalBytes() - stat.getFreeBytes();
            String totalMemory = DownloadByteConverter.convertByte((double) totalSpace, 2, false);
            Intrinsics.checkNotNullExpressionValue(totalMemory, "convertByte(\n           …, false\n                )");
            String usedMemory = DownloadByteConverter.convertByte((double) usedSpace, 2, false);
            Intrinsics.checkNotNullExpressionValue(usedMemory, "convertByte(\n           …, false\n                )");
            return new Pair<>(usedMemory + '/' + totalMemory, Float.valueOf(((float) usedSpace) / ((float) totalSpace)));
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
        r5 = r5.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View createView(android.view.ViewGroup r13) {
        /*
            r12 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            android.content.Context r0 = r13.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r0)
            int r2 = com.baidu.searchbox.download.center.R.layout.layout_template_classification
            r3 = 0
            android.view.View r1 = r1.inflate(r2, r13, r3)
            java.lang.String r2 = "from(context)\n          …ification, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r12.mRootView = r1
            java.lang.String r2 = "mRootView"
            r4 = 0
            if (r1 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r4
        L_0x0026:
            android.view.View r5 = r12.mRootView
            if (r5 != 0) goto L_0x002e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = r4
        L_0x002e:
            android.content.Context r5 = r5.getContext()
            if (r5 == 0) goto L_0x0041
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0041
            int r6 = com.baidu.searchbox.download.center.R.drawable.download_fusion_classify_bg
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            goto L_0x0042
        L_0x0041:
            r5 = r4
        L_0x0042:
            r1.setBackground(r5)
            r12.registerDownloadingObserver()
            com.baidu.searchbox.bdeventbus.BdEventBus$Companion r1 = com.baidu.searchbox.bdeventbus.BdEventBus.Companion
            com.baidu.searchbox.bdeventbus.BdEventBus r1 = r1.getDefault()
            java.lang.Class<com.baidu.searchbox.download.center.ui.fusion.data.DataChangedEvent> r5 = com.baidu.searchbox.download.center.ui.fusion.data.DataChangedEvent.class
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$1 r6 = new com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$1
            r6.<init>(r12)
            com.baidu.searchbox.bdeventbus.Action r6 = (com.baidu.searchbox.bdeventbus.Action) r6
            r7 = 1
            r1.register(r12, r5, r7, r6)
            boolean r1 = r0 instanceof androidx.lifecycle.LifecycleOwner
            if (r1 == 0) goto L_0x0070
            r1 = r0
            androidx.lifecycle.LifecycleOwner r1 = (androidx.lifecycle.LifecycleOwner) r1
            androidx.lifecycle.Lifecycle r1 = r1.getLifecycle()
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$2 r5 = new com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$2
            r5.<init>(r12)
            androidx.lifecycle.LifecycleObserver r5 = (androidx.lifecycle.LifecycleObserver) r5
            r1.addObserver(r5)
        L_0x0070:
            android.view.View r1 = r12.mRootView
            if (r1 != 0) goto L_0x0078
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r4
        L_0x0078:
            int r5 = com.baidu.searchbox.download.center.R.id.phoneTitlePhoneSpaceView
            android.view.View r1 = r1.findViewById(r5)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r12.mTitlePhoneSpaceView = r1
            android.view.View r1 = r12.mRootView
            if (r1 != 0) goto L_0x008a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r4
        L_0x008a:
            int r5 = com.baidu.searchbox.download.center.R.id.phoneTitleClearCacheView
            android.view.View r1 = r1.findViewById(r5)
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTitleClearCacheView r1 = (com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTitleClearCacheView) r1
            r12.mTitleClearCacheView = r1
            r12.updateSpaceView()
            android.view.View r1 = r12.mRootView
            if (r1 != 0) goto L_0x009f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r4
        L_0x009f:
            int r5 = com.baidu.searchbox.download.center.R.id.download_recent_layout
            android.view.View r1 = r1.findViewById(r5)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r12.recentLayout = r1
            android.view.View r1 = r12.mRootView
            if (r1 != 0) goto L_0x00b1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r4
        L_0x00b1:
            int r5 = com.baidu.searchbox.download.center.R.id.download_num
            android.view.View r1 = r1.findViewById(r5)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r12.downloadNum = r1
            android.view.View r1 = r12.mRootView
            if (r1 != 0) goto L_0x00c3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r4
        L_0x00c3:
            int r5 = com.baidu.searchbox.download.center.R.id.recent_arrow
            android.view.View r1 = r1.findViewById(r5)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r12.downloadArrow = r1
            android.widget.TextView r1 = r12.downloadNum
            if (r1 != 0) goto L_0x00d2
            goto L_0x00e9
        L_0x00d2:
            android.content.Context r5 = com.baidu.searchbox.lightbrowser.RuntimeKt.getAppContext()
            int r6 = com.baidu.searchbox.download.center.R.string.download_recent_text_all_count
            java.lang.Object[] r8 = new java.lang.Object[r7]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            r8[r3] = r9
            java.lang.String r5 = r5.getString(r6, r8)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x00e9:
            android.widget.LinearLayout r1 = r12.recentLayout
            if (r1 == 0) goto L_0x00f5
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$$ExternalSyntheticLambda7 r5 = new com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$$ExternalSyntheticLambda7
            r5.<init>(r0)
            r1.setOnClickListener(r5)
        L_0x00f5:
            androidx.recyclerview.widget.RecyclerView r1 = new androidx.recyclerview.widget.RecyclerView
            r1.<init>(r0)
            com.baidu.searchbox.download.center.ui.fusion.adapter.RecentDownloadAdapter r5 = new com.baidu.searchbox.download.center.ui.fusion.adapter.RecentDownloadAdapter
            r5.<init>()
            r12.downloadAdapter = r5
            androidx.recyclerview.widget.LinearLayoutManager r5 = new androidx.recyclerview.widget.LinearLayoutManager
            r5.<init>(r0)
            r5.setRecycleChildrenOnDetach(r7)
            r6 = r5
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r6
            r1.setLayoutManager(r6)
            r6 = 3
            r1.setItemViewCacheSize(r6)
            com.baidu.searchbox.download.center.ui.fusion.adapter.RecentDownloadAdapter r6 = r12.downloadAdapter
            if (r6 != 0) goto L_0x011d
            java.lang.String r6 = "downloadAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r6 = r4
        L_0x011d:
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = (androidx.recyclerview.widget.RecyclerView.Adapter) r6
            r1.setAdapter(r6)
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r8 = -2
            r6.<init>(r8, r8)
            r8 = r6
            r9 = 0
            android.content.res.Resources r10 = r0.getResources()
            int r11 = com.baidu.searchbox.download.center.R.dimen.file_manager_classify_recent_margin_top
            int r10 = r10.getDimensionPixelOffset(r11)
            r8.setMargins(r3, r10, r3, r3)
            android.view.ViewGroup$LayoutParams r6 = (android.view.ViewGroup.LayoutParams) r6
            r1.setLayoutParams(r6)
            android.widget.LinearLayout r3 = r12.recentLayout
            if (r3 == 0) goto L_0x0148
            r6 = r1
            android.view.View r6 = (android.view.View) r6
            r3.addView(r6)
        L_0x0148:
            android.view.View r3 = r12.mRootView
            if (r3 != 0) goto L_0x0150
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = r4
        L_0x0150:
            int r6 = com.baidu.searchbox.download.center.R.id.recyclerview_classify
            android.view.View r3 = r3.findViewById(r6)
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3
            r12.recyclerView = r3
            androidx.recyclerview.widget.DefaultItemAnimator r3 = new androidx.recyclerview.widget.DefaultItemAnimator
            r3.<init>()
            r8 = 300(0x12c, double:1.48E-321)
            r3.setAddDuration(r8)
            r3.setRemoveDuration(r8)
            androidx.recyclerview.widget.RecyclerView r6 = r12.recyclerView
            if (r6 != 0) goto L_0x016c
            goto L_0x0172
        L_0x016c:
            r8 = r3
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r8 = (androidx.recyclerview.widget.RecyclerView.ItemAnimator) r8
            r6.setItemAnimator(r8)
        L_0x0172:
            androidx.recyclerview.widget.RecyclerView r6 = r12.recyclerView
            if (r6 != 0) goto L_0x0177
            goto L_0x0185
        L_0x0177:
            android.content.Context r8 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$5 r9 = new com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$5
            r9.<init>(r8)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r9 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r9
            r6.setLayoutManager(r9)
        L_0x0185:
            com.baidu.searchbox.download.center.ui.fusion.adapter.ClassifyAdapter r6 = new com.baidu.searchbox.download.center.ui.fusion.adapter.ClassifyAdapter
            r6.<init>()
            r8 = r6
            r9 = 0
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$6$1 r10 = new com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$6$1
            r10.<init>(r12, r8, r0)
            com.baidu.searchbox.download.center.ui.fusion.adapter.OnCategoryClickCallback r10 = (com.baidu.searchbox.download.center.ui.fusion.adapter.OnCategoryClickCallback) r10
            r8.setCategoryClickCallback(r10)
            r8.setHasStableIds(r7)
            r12.classifyAdapter = r6
            androidx.recyclerview.widget.RecyclerView r8 = r12.recyclerView
            if (r8 != 0) goto L_0x01a1
            goto L_0x01a6
        L_0x01a1:
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = (androidx.recyclerview.widget.RecyclerView.Adapter) r6
            r8.setAdapter(r6)
        L_0x01a6:
            boolean r6 = r0 instanceof android.app.Activity
            if (r6 == 0) goto L_0x01bf
            r6 = r0
            android.app.Activity r6 = (android.app.Activity) r6
            int r8 = com.baidu.searchbox.download.center.R.id.fileManagerRecyclerView
            android.view.View r6 = r6.findViewById(r8)
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$7 r8 = new com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$7
            r8.<init>(r12)
            androidx.recyclerview.widget.RecyclerView$OnScrollListener r8 = (androidx.recyclerview.widget.RecyclerView.OnScrollListener) r8
            r6.addOnScrollListener(r8)
        L_0x01bf:
            android.view.View r6 = r12.mRootView
            if (r6 != 0) goto L_0x01c7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r6 = r4
        L_0x01c7:
            r12.updateGarbageView(r6)
            android.view.View r6 = r12.mRootView
            if (r6 != 0) goto L_0x01d2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r6 = r4
        L_0x01d2:
            r12.adjustNightMode(r6)
            com.baidu.searchbox.bdeventbus.BdEventBus$Companion r6 = com.baidu.searchbox.bdeventbus.BdEventBus.Companion
            com.baidu.searchbox.bdeventbus.BdEventBus r6 = r6.getDefault()
            java.lang.Class<com.baidu.searchbox.download.center.clearcache.ClearCacheDataChangeEvent> r8 = com.baidu.searchbox.download.center.clearcache.ClearCacheDataChangeEvent.class
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$8 r9 = new com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate$createView$8
            r9.<init>(r12)
            com.baidu.searchbox.bdeventbus.Action r9 = (com.baidu.searchbox.bdeventbus.Action) r9
            r6.register(r12, r8, r7, r9)
            android.view.View r6 = r12.mRootView
            if (r6 != 0) goto L_0x01f0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x01f1
        L_0x01f0:
            r4 = r6
        L_0x01f1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate.createView(android.view.ViewGroup):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: createView$lambda-5  reason: not valid java name */
    public static final void m17597createView$lambda5(Context $context, View it) {
        Activity mActivity = $context instanceof Activity ? (Activity) $context : null;
        if (mActivity != null) {
            DownloadPermissionHelper.checkHasSelfDownloadFileReadPermissionAndRequest(mActivity, "file", new ClassificationTemplate$$ExternalSyntheticLambda0($context));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createView$lambda-5$lambda-4  reason: not valid java name */
    public static final void m17598createView$lambda5$lambda4(Context $context, boolean enable) {
        if (enable) {
            ActivityUtils.startActivitySafely((Activity) $context, new Intent($context, DownloadManagerActivity.class));
            DownloadCenterStatistic.INSTANCE.recentDownloadItemClick("more", (CategoryInfoData) null);
        }
    }

    public final void updateDownloadingAndDownloadNum() {
        ExecutorUtilsExt.postOnElastic(new ClassificationTemplate$$ExternalSyntheticLambda4(this), "getDownloadingAndDownloadList", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateDownloadingAndDownloadNum$lambda-9  reason: not valid java name */
    public static final void m17603updateDownloadingAndDownloadNum$lambda9(ClassificationTemplate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UiThreadUtils.runOnUiThread(new ClassificationTemplate$$ExternalSyntheticLambda3(this$0, DownloadCenterUtils.queryDownloadingAndDownloaded(DownloadPermissionHelper.hasSelfDownloadedFileReadPermission(), Integer.MAX_VALUE, true)));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateDownloadingAndDownloadNum$lambda-9$lambda-8  reason: not valid java name */
    public static final void m17604updateDownloadingAndDownloadNum$lambda9$lambda8(ClassificationTemplate this$0, List $list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.downloadNum;
        if (textView != null) {
            textView.setText(RuntimeKt.getAppContext().getString(R.string.download_recent_text_all_count, new Object[]{Integer.valueOf($list.size())}));
        }
    }

    /* access modifiers changed from: private */
    public final void startAnimation(Context context, boolean isOpen) {
        ValueAnimator animation = new ValueAnimator();
        animation.setDuration(300);
        if (isOpen) {
            animation.setIntValues(new int[]{DeviceUtils.ScreenInfo.dp2px(context, 86.0f), DeviceUtils.ScreenInfo.dp2px(context, 166.0f)});
        } else {
            animation.setIntValues(new int[]{DeviceUtils.ScreenInfo.dp2px(context, 166.0f), DeviceUtils.ScreenInfo.dp2px(context, 86.0f)});
        }
        animation.addUpdateListener(new ClassificationTemplate$$ExternalSyntheticLambda8(this));
        animation.addListener(new ClassificationTemplate$startAnimation$2());
        animation.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: startAnimation$lambda-10  reason: not valid java name */
    public static final void m17602startAnimation$lambda10(ClassificationTemplate this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        RecyclerView recyclerView2 = this$0.recyclerView;
        ViewGroup.LayoutParams layoutManager = recyclerView2 != null ? recyclerView2.getLayoutParams() : null;
        if (layoutManager != null) {
            layoutManager.height = ((Integer) it.getAnimatedValue()).intValue();
        }
        RecyclerView recyclerView3 = this$0.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.requestLayout();
        }
    }

    private final void handleOnDownloadComplete(int downloadType) {
        ClassifyAdapter classifyAdapter2;
        int i2 = downloadType;
        ClassifyAdapter classifyAdapter3 = this.classifyAdapter;
        List categoryItemsShowed = classifyAdapter3 != null ? classifyAdapter3.getCategoryItems() : null;
        boolean updatedOnShowedCategoryItems = false;
        if (categoryItemsShowed != null) {
            int index = 0;
            for (Object item$iv : categoryItemsShowed) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DownloadedCategoryItem categoryItem = (DownloadedCategoryItem) item$iv;
                if (categoryItem.downloadType == i2) {
                    updatedOnShowedCategoryItems = true;
                    ClassifyAdapter classifyAdapter4 = this.classifyAdapter;
                    if (classifyAdapter4 != null) {
                        classifyAdapter4.notifyItemChanged(index);
                    }
                    index = index$iv;
                } else {
                    if (categoryItem.downloadType == 5) {
                        DownloadCenterUtils.setOtherDataCount(categoryItem.allCount);
                    }
                    index = index$iv;
                }
            }
        }
        boolean updatedOnSecondCategoryItems = false;
        if (!updatedOnShowedCategoryItems) {
            for (DownloadedCategoryItem categoryItem2 : this.secondData) {
                if (categoryItem2.downloadType == i2) {
                    updatedOnSecondCategoryItems = true;
                } else if (categoryItem2.downloadType == 5) {
                    DownloadCenterUtils.setOtherDataCount(categoryItem2.allCount);
                }
            }
        }
        ArrayList allData = new ArrayList();
        allData.addAll(categoryItemsShowed != null ? categoryItemsShowed : CollectionsKt.emptyList());
        allData.addAll(this.secondData);
        updateFoldTipText(allData);
        if (updatedOnSecondCategoryItems) {
            int i3 = -1;
            if (categoryItemsShowed != null) {
                int index$iv2 = 0;
                Iterator<DownloadedCategoryItem> it = categoryItemsShowed.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (9 == it.next().downloadType) {
                        i3 = index$iv2;
                        break;
                    }
                    index$iv2++;
                }
            }
            int indexOfFoldItem = i3;
            if (indexOfFoldItem >= 0) {
                if (indexOfFoldItem < (categoryItemsShowed != null ? categoryItemsShowed.size() : 0) && (classifyAdapter2 = this.classifyAdapter) != null) {
                    classifyAdapter2.notifyItemChanged(indexOfFoldItem);
                }
            }
        }
        updateSpaceView();
    }

    private final void registerDownloadingObserver() {
        if (!this.isRegisteringDownloadingObserver) {
            this.isRegisteringDownloadingObserver = true;
            if (this.downloadingObserver == null) {
                this.downloadingObserver = new ClassificationTemplate$$ExternalSyntheticLambda5(this);
            }
            ExecutorUtilsExt.postOnElastic(new ClassificationTemplate$$ExternalSyntheticLambda6(this), "ClassificationTemplate.createView", 3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerDownloadingObserver$lambda-15  reason: not valid java name */
    public static final void m17599registerDownloadingObserver$lambda15(ClassificationTemplate this$0, Observable observable, Object data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (data instanceof Intent) {
            UiThreadUtils.runOnUiThread(new ClassificationTemplate$$ExternalSyntheticLambda2(data, this$0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerDownloadingObserver$lambda-15$lambda-14  reason: not valid java name */
    public static final void m17600registerDownloadingObserver$lambda15$lambda14(Object $data, ClassificationTemplate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TextUtils.equals(((Intent) $data).getAction(), DownloadConstants.ACTION_DOWNLOAD_COMPLETE)) {
            int downloadType = ((Intent) $data).getIntExtra(DownloadConstants.KEY_INTENT_DOWNLOAD_CATEGORY, 5);
            if (AppConfig.isDebug()) {
                Log.v("ClassificationTemplate", "receive download complete action. downloadType = " + downloadType);
            }
            try {
                this$0.handleOnDownloadComplete(downloadType);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerDownloadingObserver$lambda-16  reason: not valid java name */
    public static final void m17601registerDownloadingObserver$lambda16(ClassificationTemplate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            IDownloadCenterApp.Impl.get().addDownloadingObserver(this$0.downloadingObserver);
        } catch (Throwable t) {
            if (AppConfig.isDebug()) {
                throw new DebugException("ClassificationTemplate.createView", t);
            }
        }
        this$0.isRegisteringDownloadingObserver = false;
    }

    /* access modifiers changed from: private */
    public final void unregisterDownloadingObserver() {
        if (!this.isRegisteringDownloadingObserver && this.downloadingObserver != null) {
            IDownloadCenterApp.Impl.get().deleteDownloadingObserver(this.downloadingObserver);
        }
    }

    /* access modifiers changed from: private */
    public final void buildIntent(int category, Context context, Function1<? super Intent, Unit> function) {
        DownloadPermissionHelper.requestReadPermissionByType(DownloadCenterStatistic.UBC_TYPE_VALUE_ITEM_CLICK, category, new ClassificationTemplate$$ExternalSyntheticLambda1(function, category, context));
    }

    /* access modifiers changed from: private */
    /* renamed from: buildIntent$lambda-19  reason: not valid java name */
    public static final void m17596buildIntent$lambda19(Function1 $function, int $category, Context $context, boolean enable) {
        Intent intent;
        Intrinsics.checkNotNullParameter($function, "$function");
        Intrinsics.checkNotNullParameter($context, "$context");
        switch ($category) {
            case 0:
                intent = IDownloadCenterApp.Impl.get().getGoDownloadedVideoActivityIntent($context);
                break;
            case 2:
                intent = new Intent($context, PictureCategoryActivity.class);
                break;
            case 3:
                Intent $this$buildIntent_u24lambda_u2d19_u24lambda_u2d17 = new Intent($context, (!IDownloadCenterApp.Impl.get().isAppAssistantSwitchEnabled() || !IDownloadCenterApp.Impl.get().hasInstalledAppAssistant()) ? DownloadedCategorySecActivity.class : DownloadedCategoryAppActivity.class);
                $this$buildIntent_u24lambda_u2d19_u24lambda_u2d17.putExtra(DownloadedCategorySecActivity.EXTRA_TYPE_KEY, (long) $category);
                intent = $this$buildIntent_u24lambda_u2d19_u24lambda_u2d17;
                break;
            case 4:
                intent = new Intent($context, DownloadedDocActivity.class);
                break;
            case 10:
                DownloadStatisticsUBC.doDownloadCenterChildPageUBC(DownloadStatisticConstants.UBC_VALUE_PHONE_STORAGE, "page_click");
                intent = IDownloadCenterApp.Impl.get().getGoFileViewerActivityIntent($context);
                break;
            default:
                Intent $this$buildIntent_u24lambda_u2d19_u24lambda_u2d18 = new Intent($context, DownloadedCategorySecActivity.class);
                $this$buildIntent_u24lambda_u2d19_u24lambda_u2d18.putExtra(DownloadedCategorySecActivity.EXTRA_TYPE_KEY, (long) $category);
                intent = $this$buildIntent_u24lambda_u2d19_u24lambda_u2d18;
                break;
        }
        $function.invoke(intent);
    }

    public TemplateType getTemplateType() {
        return TemplateType.CLASSIFICATION_TEMPLATE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r6.getContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void adjustNightMode(android.view.View r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x000d
            android.content.Context r0 = r6.getContext()
            if (r0 == 0) goto L_0x000d
            android.content.res.Resources r0 = r0.getResources()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0097
            r1 = r0
            r2 = 0
            int r3 = com.baidu.searchbox.download.center.R.id.classify_layout
            android.view.View r3 = r6.findViewById(r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            if (r3 != 0) goto L_0x001d
            goto L_0x0026
        L_0x001d:
            int r4 = com.baidu.searchbox.download.center.R.drawable.download_fusion_classify_bg
            android.graphics.drawable.Drawable r4 = r0.getDrawable(r4)
            r3.setBackground(r4)
        L_0x0026:
            int r3 = com.baidu.searchbox.download.center.R.id.phone_title
            android.view.View r3 = r6.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x0039
            int r4 = com.baidu.android.common.ui.style.R.color.GC1
            int r4 = r0.getColor(r4)
            r3.setTextColor(r4)
        L_0x0039:
            int r3 = com.baidu.searchbox.download.center.R.id.phoneTitleClearCacheView
            android.view.View r3 = r6.findViewById(r3)
            com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTitleClearCacheView r3 = (com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTitleClearCacheView) r3
            if (r3 == 0) goto L_0x0046
            r3.updateNightMode()
        L_0x0046:
            android.widget.TextView r3 = r5.mTitlePhoneSpaceView
            if (r3 == 0) goto L_0x0053
            int r4 = com.baidu.searchbox.download.center.R.color.GC106
            int r4 = r0.getColor(r4)
            r3.setTextColor(r4)
        L_0x0053:
            int r3 = com.baidu.searchbox.download.center.R.id.recent_download_title
            android.view.View r3 = r6.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = com.baidu.android.common.ui.style.R.color.GC1
            int r4 = r0.getColor(r4)
            r3.setTextColor(r4)
            int r3 = com.baidu.searchbox.download.center.R.id.download_num
            android.view.View r3 = r6.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = com.baidu.android.common.ui.style.R.color.GC4
            int r4 = r0.getColor(r4)
            r3.setTextColor(r4)
            int r3 = com.baidu.searchbox.download.center.R.id.recent_arrow
            android.view.View r3 = r6.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            int r4 = com.baidu.searchbox.download.center.R.drawable.template_more_arrow
            android.graphics.drawable.Drawable r4 = r0.getDrawable(r4)
            r3.setImageDrawable(r4)
            int r3 = com.baidu.searchbox.download.center.R.id.recent_divider
            android.view.View r3 = r6.findViewById(r3)
            int r4 = com.baidu.android.common.ui.style.R.color.GC34
            android.graphics.drawable.Drawable r4 = r0.getDrawable(r4)
            r3.setBackground(r4)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.ui.fusion.template.ClassificationTemplate.adjustNightMode(android.view.View):void");
    }
}
