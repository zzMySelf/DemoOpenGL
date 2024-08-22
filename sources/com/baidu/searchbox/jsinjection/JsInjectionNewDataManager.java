package com.baidu.searchbox.jsinjection;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.jsinjection.bean.JsInjectionCommonBean;
import com.baidu.searchbox.jsinjection.bean.JsInjectionConfigBean;
import com.baidu.searchbox.pms.bean.PackageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u0017\"\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019JK\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001829\b\u0002\u0010\u001c\u001a3\u0012'\u0012%\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dH\u0002J&\u0010$\u001a\u00020\u00152\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&J$\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` 2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002JI\u0010*\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001827\u0010\u001c\u001a3\u0012'\u0012%\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dH\u0007JK\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u001829\b\u0002\u0010\u001c\u001a3\u0012'\u0012%\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dH\u0002J9\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002!\u00102\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00150\u001dJ1\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u0002002!\u00102\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00150\u001dJ\u0010\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020'H\u0007J\u001a\u0010:\u001a\u00020\u00152\b\u0010;\u001a\u0004\u0018\u0001002\b\u0010<\u001a\u0004\u0018\u00010=J#\u0010>\u001a\u00020\u00152\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u0017\"\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\"\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010;\u001a\u0002002\u0006\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u000200H\u0007J\u0010\u0010C\u001a\u00020\u00152\b\u0010;\u001a\u0004\u0018\u000100R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/baidu/searchbox/jsinjection/JsInjectionNewDataManager;", "", "()V", "commonBeanMap", "Lcom/baidu/searchbox/jsinjection/JsInjectionCommonBeanCache;", "conditionCache", "Lcom/baidu/searchbox/jsinjection/JsInjectionConditionCache;", "configMap", "Lcom/baidu/searchbox/jsinjection/JsInjectionConfigCache;", "countMap", "Lcom/baidu/searchbox/jsinjection/JsInjectionCountCache;", "downloadList", "Lcom/baidu/searchbox/jsinjection/JsInjectionDownloadCache;", "fileMap", "Lcom/baidu/searchbox/jsinjection/JsInjectionFileInfoCache;", "jsContentMap", "Lcom/baidu/searchbox/jsinjection/JsInjectionContentCache;", "lockObj", "sampleMap", "Lcom/baidu/searchbox/jsinjection/JsInjectionSampleCache;", "asyncInitAllData", "", "businessTypes", "", "Lcom/baidu/searchbox/jsinjection/BusinessType;", "([Lcom/baidu/searchbox/jsinjection/BusinessType;)V", "asyncInitData", "businessType", "returnFileList", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/jsinjection/bean/JsInjectionConfigBean$FileInfo;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "configList", "dispatchPackageInfo", "addList", "", "Lcom/baidu/searchbox/pms/bean/PackageInfo;", "updateList", "getDataWithBusinessType", "getFileListByBusinessType", "fileList", "initData", "", "injectJsContent", "packageName", "", "fileName", "inject", "jsContent", "injectSampleValue", "sampleKey", "", "sampleValue", "notifyDownLoadSuccess", "packageInfo", "registerConditionListener", "containerKey", "listener", "Lcom/baidu/searchbox/jsinjection/JsInjectionConditionListener;", "releaseCache", "shouldInjectByCondition", "Lcom/baidu/searchbox/jsinjection/JsInjectionConditionResult;", "fileInfo", "url", "unregisterConditionListener", "lib_js_injection_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsInjectionNewDataManager.kt */
public final class JsInjectionNewDataManager {
    public static final JsInjectionNewDataManager INSTANCE = new JsInjectionNewDataManager();
    private static final JsInjectionCommonBeanCache commonBeanMap = new JsInjectionCommonBeanCache();
    private static final JsInjectionConditionCache conditionCache = new JsInjectionConditionCache();
    private static final JsInjectionConfigCache configMap = new JsInjectionConfigCache();
    private static final JsInjectionCountCache countMap = new JsInjectionCountCache();
    private static final JsInjectionDownloadCache downloadList = new JsInjectionDownloadCache();
    private static final JsInjectionFileInfoCache fileMap = new JsInjectionFileInfoCache();
    private static final JsInjectionContentCache jsContentMap = new JsInjectionContentCache();
    private static final Object lockObj = new Object();
    private static final JsInjectionSampleCache sampleMap = new JsInjectionSampleCache();

    private JsInjectionNewDataManager() {
    }

    public final void asyncInitAllData(BusinessType... businessTypes) {
        Intrinsics.checkNotNullParameter(businessTypes, "businessTypes");
        ExecutorUtilsExt.postOnElastic(new JsInjectionNewDataManager$$ExternalSyntheticLambda2(businessTypes), JsInjectConstantFileKt.TASK_NAME_UPDATE_CACHE, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: asyncInitAllData$lambda-1  reason: not valid java name */
    public static final void m20613asyncInitAllData$lambda1(BusinessType[] $businessTypes) {
        Intrinsics.checkNotNullParameter($businessTypes, "$businessTypes");
        synchronized (lockObj) {
            if (JsInjectionDelegate.INSTANCE.getDEBUG()) {
                Log.d(JsInjectConstantFileKt.LOG_TAG, "asyncInitAllData");
            }
            for (BusinessType businessType : $businessTypes) {
                if (businessType != null) {
                    initData$default(INSTANCE, businessType, (Function1) null, 2, (Object) null);
                    countMap.addBusinessTypeCount(businessType);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    static /* synthetic */ void asyncInitData$default(JsInjectionNewDataManager jsInjectionNewDataManager, BusinessType businessType, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        jsInjectionNewDataManager.asyncInitData(businessType, function1);
    }

    private final void asyncInitData(BusinessType businessType, Function1<? super ArrayList<JsInjectionConfigBean.FileInfo>, Unit> returnFileList) {
        ExecutorUtilsExt.postOnElastic(new JsInjectionNewDataManager$$ExternalSyntheticLambda1(businessType, returnFileList), JsInjectConstantFileKt.TASK_NAME_UPDATE_CACHE, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: asyncInitData$lambda-3  reason: not valid java name */
    public static final void m20614asyncInitData$lambda3(BusinessType $businessType, Function1 $returnFileList) {
        Intrinsics.checkNotNullParameter($businessType, "$businessType");
        synchronized (lockObj) {
            if (JsInjectionDelegate.INSTANCE.getDEBUG()) {
                Log.i(JsInjectConstantFileKt.LOG_TAG, "asyncInitAllData businessType=" + $businessType);
            }
            INSTANCE.initData($businessType, $returnFileList);
            Unit unit = Unit.INSTANCE;
        }
    }

    static /* synthetic */ boolean initData$default(JsInjectionNewDataManager jsInjectionNewDataManager, BusinessType businessType, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        return jsInjectionNewDataManager.initData(businessType, function1);
    }

    private final boolean initData(BusinessType businessType, Function1<? super ArrayList<JsInjectionConfigBean.FileInfo>, Unit> returnFileList) {
        long startTimestamp = System.currentTimeMillis();
        ArrayList fileList = fileMap.getFileInfoList(businessType);
        if (fileList == null) {
            fileList = getDataWithBusinessType(businessType);
        }
        if (JsInjectionDelegate.INSTANCE.getDEBUG()) {
            Log.i(JsInjectConstantFileKt.LOG_TAG, "asyncInitData businessType=" + businessType + " cost=" + (System.currentTimeMillis() - startTimestamp) + " fileList=" + (fileList != null ? fileList.toString() : null));
        }
        if (returnFileList != null) {
            returnFileList.invoke(fileList);
        }
        commonBeanMap.setInitialized(businessType);
        return true;
    }

    public final void notifyDownLoadSuccess(PackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        synchronized (lockObj) {
            JsInjectionConfigCache jsInjectionConfigCache = configMap;
            String str = packageInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "packageInfo.packageName");
            if (jsInjectionConfigCache.getConfig(str) != null) {
                if (TextUtils.equals(packageInfo.packageName, JsInjectConstantFileKt.JS_INJECTION_PACKAGE_NAME)) {
                    if (JsInjectionDelegate.INSTANCE.getDEBUG()) {
                        Log.i(JsInjectConstantFileKt.LOG_TAG, "notifyDownLoadSuccess is common index");
                    }
                    commonBeanMap.readCommonConfigFromLocal();
                } else {
                    if (JsInjectionDelegate.INSTANCE.getDEBUG()) {
                        Log.i(JsInjectConstantFileKt.LOG_TAG, "notifyDownLoadSuccess is packageName config");
                    }
                    String str2 = packageInfo.packageName;
                    Intrinsics.checkNotNullExpressionValue(str2, "packageInfo.packageName");
                    JsInjectionConfigBean configBean = jsInjectionConfigCache.readConfigFromLocalWithPackageName(str2);
                    fileMap.initFileInfoFromConfigBean(configBean);
                    jsContentMap.initJsContentFromConfigBean(configBean, true);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final ArrayList<JsInjectionConfigBean.FileInfo> getDataWithBusinessType(BusinessType businessType) {
        ArrayList cacheFileList = fileMap.getFileInfoList(businessType);
        if (JsInjectionDelegate.INSTANCE.getDEBUG()) {
            Log.i(JsInjectConstantFileKt.LOG_TAG, "getDataWithBusinessType businessType=" + businessType + " cacheConfigList=" + cacheFileList + " thread=" + Thread.currentThread().getName());
        }
        if (cacheFileList != null) {
            return cacheFileList;
        }
        ArrayList commonBeanList = commonBeanMap.initCommonConfigByBusinessType(businessType);
        String str = null;
        if (commonBeanList != null && (!commonBeanList.isEmpty())) {
            Iterator iterator = commonBeanList.iterator();
            Intrinsics.checkNotNullExpressionValue(iterator, "commonBeanList.iterator()");
            while (iterator.hasNext()) {
                JsInjectionCommonBean commonBean = iterator.next();
                Intrinsics.checkNotNullExpressionValue(commonBean, "iterator.next()");
                String packageName = commonBean.getPackageName();
                downloadList.downloadDelayList(packageName);
                JsInjectionConfigBean configBean = configMap.readConfigFromLocalWithPackageName(packageName);
                fileMap.initFileInfoFromConfigBean(configBean);
                JsInjectionContentCache.initJsContentFromConfigBean$default(jsContentMap, configBean, false, 2, (Object) null);
            }
        }
        ArrayList fileInfoList = fileMap.getFileInfoList(businessType);
        ArrayList it = fileInfoList;
        if (JsInjectionDelegate.INSTANCE.getDEBUG()) {
            StringBuilder append = new StringBuilder().append("getDataWithBusinessType businessType=").append(businessType).append(" fileList=");
            if (it != null) {
                str = it.toString();
            }
            Log.i(JsInjectConstantFileKt.LOG_TAG, append.append(str).append(" thread=").append(Thread.currentThread().getName()).toString());
        }
        return fileInfoList;
    }

    public final void getFileListByBusinessType(BusinessType businessType, Function1<? super ArrayList<JsInjectionConfigBean.FileInfo>, Unit> returnFileList) {
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        ArrayList<JsInjectionConfigBean.FileInfo> fileInfoList = fileMap.getFileInfoList(businessType);
        Collection collection = fileInfoList;
        if ((collection == null || collection.isEmpty()) && !commonBeanMap.isInitialized(businessType)) {
            asyncInitData(businessType, new JsInjectionNewDataManager$getFileListByBusinessType$1(returnFileList));
        } else if (returnFileList != null) {
            returnFileList.invoke(fileInfoList);
        }
    }

    public final void releaseCache(BusinessType... businessTypes) {
        Intrinsics.checkNotNullParameter(businessTypes, "businessTypes");
        if (!(businessTypes.length == 0)) {
            ExecutorUtilsExt.postOnElastic(new JsInjectionNewDataManager$$ExternalSyntheticLambda0(businessTypes), JsInjectConstantFileKt.TASK_NAME_UPDATE_CACHE, 2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: releaseCache$lambda-8  reason: not valid java name */
    public static final void m20615releaseCache$lambda8(BusinessType[] $businessTypes) {
        ArrayList it;
        Intrinsics.checkNotNullParameter($businessTypes, "$businessTypes");
        synchronized (lockObj) {
            long startTimestamp = System.currentTimeMillis();
            for (BusinessType businessType : $businessTypes) {
                if (!(businessType == null || !countMap.decreaseBusinessTpeCount(businessType) || (it = fileMap.getFileInfoList(businessType)) == null)) {
                    Iterator<JsInjectionConfigBean.FileInfo> it2 = it.iterator();
                    while (it2.hasNext()) {
                        JsInjectionConfigBean.FileInfo file = it2.next();
                        jsContentMap.removeContent(file.getPackageName(), file.getFileName());
                    }
                }
            }
            if (JsInjectionDelegate.INSTANCE.getDEBUG()) {
                Log.i(JsInjectConstantFileKt.LOG_TAG, "release cache cost=" + (System.currentTimeMillis() - startTimestamp));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void dispatchPackageInfo(List<? extends PackageInfo> addList, List<? extends PackageInfo> updateList) {
        long startTimestamp = System.currentTimeMillis();
        ArrayList allList = new ArrayList();
        boolean z = false;
        if (addList != null && (addList.isEmpty() ^ true)) {
            allList.addAll(addList);
        }
        if (updateList != null && (!updateList.isEmpty())) {
            z = true;
        }
        if (z) {
            allList.addAll(updateList);
        }
        if (!allList.isEmpty()) {
            downloadList.dispatchPackageInfo(allList);
        }
        if (JsInjectionDelegate.INSTANCE.getDEBUG()) {
            Log.i(JsInjectConstantFileKt.LOG_TAG, "onResultData dispatchPackageInfo allList.size=" + allList.size() + " cost=" + (System.currentTimeMillis() - startTimestamp) + " thread=" + Thread.currentThread().getName());
        }
    }

    public final void injectJsContent(String packageName, String fileName, Function1<? super String, Unit> inject) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(inject, "inject");
        jsContentMap.getContent(packageName, fileName, inject);
    }

    public final void injectSampleValue(String sampleKey, Function1<? super Integer, Unit> inject) {
        Intrinsics.checkNotNullParameter(sampleKey, "sampleKey");
        Intrinsics.checkNotNullParameter(inject, "inject");
        sampleMap.getValue(sampleKey, inject);
    }

    public final void registerConditionListener(String containerKey, JsInjectionConditionListener listener) {
        conditionCache.registerConditionListener(containerKey, listener);
    }

    public final void unregisterConditionListener(String containerKey) {
        conditionCache.unregisterConditionListener(containerKey);
    }

    public final JsInjectionConditionResult shouldInjectByCondition(String containerKey, JsInjectionConfigBean.FileInfo fileInfo, String url) {
        Intrinsics.checkNotNullParameter(containerKey, "containerKey");
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        Intrinsics.checkNotNullParameter(url, "url");
        return conditionCache.shouldInject(containerKey, fileInfo, url);
    }
}
