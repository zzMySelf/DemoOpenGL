package com.baidu.searchbox.impl;

import android.content.Context;
import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.components.videotranscoding.util.CheckDeadLinkUtilsKt;
import com.baidu.browser.components.videotranscoding.util.SearchMovieAGGUtil;
import com.baidu.browser.components.videotranscoding.util.VideoTransWhiteManager;
import com.baidu.browser.utils.InteractionUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.favor.IFavorManager;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.favorbussiness.api.IFavorBusinessManager;
import com.baidu.searchbox.search.pyramid.ExtraEpisodeModel;
import com.baidu.searchbox.search.pyramid.FavorPlayModel;
import com.baidu.searchbox.search.pyramid.OperatorStatus;
import com.baidu.searchbox.search.pyramid.SearchH5FavorService;
import com.baidu.searchbox.search.webvideo.utils.SearchH5AbManager;
import com.baidu.searchbox.search.webvideo.utils.SearchH5CollectionUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0002J\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2#\b\u0001\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\f2O\b\u0001\u0010\u0011\u001aI\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J8\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00100\u0017H\u0016J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0003J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0003J4\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020\u0004H\u0002J&\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/impl/SearchH5FavorServiceImpl;", "Lcom/baidu/searchbox/search/pyramid/SearchH5FavorService;", "()V", "interceptAddOrRemoveFavor", "", "pageUrl", "", "favorModel", "Lcom/baidu/searchbox/favor/data/FavorModel;", "favorPlayModel", "Lcom/baidu/searchbox/search/pyramid/FavorPlayModel;", "beforeProcess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "favored", "", "callback", "Lkotlin/Function3;", "Lcom/baidu/searchbox/search/pyramid/OperatorStatus;", "operatorStatus", "interceptQueryFavor", "favorStateCallback", "Lkotlin/Function2;", "isFavored", "Lcom/baidu/searchbox/impl/SearchH5FavorServiceImpl$FavorResult;", "manager", "Lcom/baidu/searchbox/favorbussiness/api/IFavorBusinessManager;", "isUrlInVideoTransWhite", "printFavorForDebug", "uk", "logPrefix", "printLogForDebug", "method", "favorStatus", "updateHistoryFavor", "context", "Landroid/content/Context;", "updateMovieFavor", "Companion", "FavorResult", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5FavorServiceImpl.kt */
public final class SearchH5FavorServiceImpl implements SearchH5FavorService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "SearchH5FavorService";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/impl/SearchH5FavorServiceImpl$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "TAG", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchH5FavorServiceImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getDEBUG() {
            return SearchH5FavorServiceImpl.DEBUG;
        }
    }

    public boolean interceptQueryFavor(String pageUrl, FavorPlayModel favorPlayModel, Function2<? super Boolean, ? super FavorModel, Unit> favorStateCallback) {
        Intrinsics.checkNotNullParameter(favorStateCallback, "favorStateCallback");
        if (!SearchH5AbManager.isSearchH5VideoFavorAGG()) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "interceptQueryFavor, caller className=" + Thread.currentThread().getStackTrace()[3].getClassName() + " methodName=" + Thread.currentThread().getStackTrace()[3].getMethodName());
        }
        CharSequence charSequence = pageUrl;
        if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) "about:blank", (Object) pageUrl)) {
            UiThreadUtils.runOnUiThread(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda8(favorStateCallback));
            return true;
        }
        ExecutorUtilsExt.postOnElastic(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda9(this, pageUrl, favorPlayModel, favorStateCallback), "interceptQueryFavor", 0);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: interceptQueryFavor$lambda-0  reason: not valid java name */
    public static final void m20397interceptQueryFavor$lambda0(Function2 $favorStateCallback) {
        Intrinsics.checkNotNullParameter($favorStateCallback, "$favorStateCallback");
        $favorStateCallback.invoke(false, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: interceptQueryFavor$lambda-3  reason: not valid java name */
    public static final void m20398interceptQueryFavor$lambda3(SearchH5FavorServiceImpl this$0, String $pageUrl, FavorPlayModel $favorPlayModel, Function2 $favorStateCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($favorStateCallback, "$favorStateCallback");
        IFavorBusinessManager manager = (IFavorBusinessManager) ServiceManager.getService(IFavorBusinessManager.SERVICE_REFERENCE);
        if (manager == null) {
            UiThreadUtils.runOnUiThread(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda4($favorStateCallback));
            return;
        }
        FavorResult favorResult = this$0.isFavored(manager, $pageUrl, $favorPlayModel);
        boolean favorStatus = favorResult.isFavored();
        FavorModel finalFavorMode = favorResult.getFavorModel();
        if (DEBUG) {
            this$0.printLogForDebug("interceptQueryFavor", $pageUrl, (FavorModel) null, $favorPlayModel, favorStatus);
        }
        UiThreadUtils.runOnUiThread(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda5($favorStateCallback, favorStatus, finalFavorMode));
    }

    /* access modifiers changed from: private */
    /* renamed from: interceptQueryFavor$lambda-3$lambda-1  reason: not valid java name */
    public static final void m20399interceptQueryFavor$lambda3$lambda1(Function2 $favorStateCallback) {
        Intrinsics.checkNotNullParameter($favorStateCallback, "$favorStateCallback");
        $favorStateCallback.invoke(false, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: interceptQueryFavor$lambda-3$lambda-2  reason: not valid java name */
    public static final void m20400interceptQueryFavor$lambda3$lambda2(Function2 $favorStateCallback, boolean $favorStatus, FavorModel $finalFavorMode) {
        Intrinsics.checkNotNullParameter($favorStateCallback, "$favorStateCallback");
        $favorStateCallback.invoke(Boolean.valueOf($favorStatus), $finalFavorMode);
    }

    public boolean interceptAddOrRemoveFavor(String pageUrl, FavorModel favorModel, FavorPlayModel favorPlayModel, Function1<? super Boolean, Unit> beforeProcess, Function3<? super OperatorStatus, ? super Boolean, ? super FavorModel, Unit> callback) {
        Intrinsics.checkNotNullParameter(beforeProcess, "beforeProcess");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!SearchH5AbManager.isSearchH5VideoFavorAGG()) {
            return false;
        }
        CharSequence charSequence = pageUrl;
        if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) "about:blank", (Object) pageUrl) || favorModel == null) {
            UiThreadUtils.runOnUiThread(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda6(callback, favorModel));
            return true;
        }
        ExecutorUtilsExt.postOnElastic(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda7(this, pageUrl, favorPlayModel, favorModel, callback, beforeProcess), "interceptAddOrRemoveFavor", 0);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: interceptAddOrRemoveFavor$lambda-4  reason: not valid java name */
    public static final void m20392interceptAddOrRemoveFavor$lambda4(Function3 $callback, FavorModel $favorModel) {
        Intrinsics.checkNotNullParameter($callback, "$callback");
        $callback.invoke(OperatorStatus.ERROR, false, $favorModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: interceptAddOrRemoveFavor$lambda-8  reason: not valid java name */
    public static final void m20393interceptAddOrRemoveFavor$lambda8(SearchH5FavorServiceImpl this$0, String $pageUrl, FavorPlayModel $favorPlayModel, FavorModel $favorModel, Function3 $callback, Function1 $beforeProcess) {
        FavorModel aggFavor;
        boolean favorStatus;
        OperatorStatus status;
        boolean result;
        boolean z;
        boolean result3;
        boolean result2;
        SearchH5FavorServiceImpl searchH5FavorServiceImpl = this$0;
        String str = $pageUrl;
        FavorPlayModel favorPlayModel = $favorPlayModel;
        FavorModel favorModel = $favorModel;
        Function3 function3 = $callback;
        Function1 function1 = $beforeProcess;
        Intrinsics.checkNotNullParameter(searchH5FavorServiceImpl, "this$0");
        Intrinsics.checkNotNullParameter(function3, "$callback");
        Intrinsics.checkNotNullParameter(function1, "$beforeProcess");
        IFavorBusinessManager manager = (IFavorBusinessManager) ServiceManager.getService(IFavorBusinessManager.SERVICE_REFERENCE);
        if (manager == null) {
            UiThreadUtils.runOnUiThread(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda0(function3, favorModel));
            return;
        }
        boolean favorStatus2 = searchH5FavorServiceImpl.isFavored(manager, str, favorPlayModel).isFavored();
        boolean z2 = DEBUG;
        if (z2) {
            this$0.printLogForDebug("interceptAddOrRemoveFavor", $pageUrl, $favorModel, $favorPlayModel, favorStatus2);
        }
        UiThreadUtils.runOnUiThread(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda1(function1, favorStatus2));
        if (favorPlayModel != null) {
            aggFavor = SearchMovieAGGUtil.Companion.transToMovieFavorModel(str, favorModel, favorPlayModel);
        } else {
            FavorModel favorModel2 = null;
            aggFavor = null;
        }
        if (aggFavor == null) {
            SearchMovieAGGUtil.Companion.addH5VideoFavorInfo(str, favorModel);
        }
        if (favorStatus2) {
            FavorModel favorForVideo = $favorModel.copyFavor();
            favorForVideo.uKey = SearchH5CollectionUtils.getWebVideoUkey($pageUrl);
            favorForVideo.tplId = "search_web_video";
            boolean result4 = manager.deleteFavor(favorModel);
            boolean result22 = manager.deleteFavor(favorForVideo);
            if (aggFavor != null) {
                z = manager.deleteFavor(aggFavor);
            } else {
                z = true;
            }
            boolean result32 = z;
            FavorModel favorVideoForUkNoUnderLine = $favorModel.copyFavor();
            favorForVideo.uKey = SearchH5CollectionUtils.getWebVideoUkeyNoUnderLine($pageUrl);
            favorForVideo.tplId = "search_web_video";
            boolean result42 = manager.deleteFavor(favorVideoForUkNoUnderLine);
            if (z2) {
                StringBuilder sb = new StringBuilder();
                favorStatus = favorStatus2;
                result3 = result32;
                sb.append("取消收藏是否成功：\n 网页收藏取消结果：").append(result4).append(" ，模板：").append(favorModel.tplId).append("，uk：").append(favorModel.uKey).append("\n 网页视频收藏取消结果：").append(result22).append("，模板：").append(favorForVideo.tplId).append("，uk：").append(favorForVideo.uKey).append("\n网页视频ios ukey取消结果：").append(result42).append(", 模板：").append(favorVideoForUkNoUnderLine.tplId).append(", uk：").append(favorVideoForUkNoUnderLine.uKey).append("\n剧集收藏取消结果：").append(result3).append("，模板：").append(aggFavor != null ? aggFavor.tplId : null).append("，uk：");
                sb.append(aggFavor != null ? aggFavor.uKey : null);
                Log.d(TAG, sb.toString());
            } else {
                favorStatus = favorStatus2;
                result3 = result32;
            }
            boolean deleteResult = false;
            while (true) {
                FavorModel model = manager.queryFavorByUrl(str);
                if (model == null) {
                    break;
                }
                boolean r = manager.deleteFavor(model);
                if (r) {
                    deleteResult = true;
                }
                if (DEBUG) {
                    result2 = result22;
                    Log.d(TAG, "取消收藏是否成功：\n 收藏取消结果：" + r + " ，model：" + model + "\n ");
                } else {
                    result2 = result22;
                }
                result22 = result2;
            }
            if (deleteResult || result4 || result22 || result3 || result42) {
                status = OperatorStatus.REMOVE_SUCCESS;
            } else {
                status = OperatorStatus.REMOVE_FAIL;
            }
        } else {
            favorStatus = favorStatus2;
            String str2 = "1";
            if (aggFavor == null) {
                FavorModel.Feature feature = favorModel.feature;
                if (feature != null) {
                    if (!CheckDeadLinkUtilsKt.isDeadLink(favorModel.url)) {
                        str2 = "0";
                    }
                    feature.isDeadLink = str2;
                }
                favorModel.feature.lastUpdateTime = String.valueOf(System.currentTimeMillis());
                if (z2) {
                    Log.d(TAG, "添加收藏非剧集信息：\n 流畅播信息：" + favorModel.feature.smoothVideoParameterJson + " \n 模板id：" + favorModel.tplId);
                }
                result = manager.addOrUpdateFavor(favorModel);
            } else {
                FavorModel.Feature feature2 = aggFavor.feature;
                if (feature2 != null) {
                    if (!CheckDeadLinkUtilsKt.isDeadLink(aggFavor.url)) {
                        str2 = "0";
                    }
                    feature2.isDeadLink = str2;
                }
                aggFavor.feature.lastUpdateTime = String.valueOf(System.currentTimeMillis());
                if (z2) {
                    Log.d(TAG, "添加收藏剧集信息：\n " + favorPlayModel + " \n 模板id：" + aggFavor.tplId);
                }
                result = manager.addOrUpdateFavor(aggFavor);
            }
            if (result) {
                status = OperatorStatus.ADD_SUCCESS;
            } else {
                status = OperatorStatus.ADD_FAIL;
            }
        }
        IFavorBusinessManager iFavorBusinessManager = manager;
        UiThreadUtils.runOnUiThread(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda2(status == OperatorStatus.ADD_SUCCESS || status == OperatorStatus.REMOVE_SUCCESS, $callback, status, favorStatus, aggFavor, $favorModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: interceptAddOrRemoveFavor$lambda-8$lambda-5  reason: not valid java name */
    public static final void m20394interceptAddOrRemoveFavor$lambda8$lambda5(Function3 $callback, FavorModel $favorModel) {
        Intrinsics.checkNotNullParameter($callback, "$callback");
        $callback.invoke(OperatorStatus.ERROR, false, $favorModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: interceptAddOrRemoveFavor$lambda-8$lambda-6  reason: not valid java name */
    public static final void m20395interceptAddOrRemoveFavor$lambda8$lambda6(Function1 $beforeProcess, boolean $favorStatus) {
        Intrinsics.checkNotNullParameter($beforeProcess, "$beforeProcess");
        $beforeProcess.invoke(Boolean.valueOf($favorStatus));
    }

    /* access modifiers changed from: private */
    /* renamed from: interceptAddOrRemoveFavor$lambda-8$lambda-7  reason: not valid java name */
    public static final void m20396interceptAddOrRemoveFavor$lambda8$lambda7(boolean $operatorStatus, Function3 $callback, OperatorStatus $status, boolean $favorStatus, FavorModel $aggFavor, FavorModel $favorModel) {
        Intrinsics.checkNotNullParameter($callback, "$callback");
        Intrinsics.checkNotNullParameter($status, "$status");
        if ($operatorStatus) {
            $callback.invoke($status, Boolean.valueOf(!$favorStatus), $aggFavor == null ? $favorModel : $aggFavor);
        } else {
            $callback.invoke($status, Boolean.valueOf($favorStatus), $aggFavor == null ? $favorModel : $aggFavor);
        }
    }

    public void updateMovieFavor(String pageUrl, FavorPlayModel favorPlayModel) {
        Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
        Intrinsics.checkNotNullParameter(favorPlayModel, "favorPlayModel");
        ExecutorUtilsExt.postOnElastic(new SearchH5FavorServiceImpl$$ExternalSyntheticLambda3(this, pageUrl, favorPlayModel), "updateMovieFavor", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateMovieFavor$lambda-9  reason: not valid java name */
    public static final void m20401updateMovieFavor$lambda9(SearchH5FavorServiceImpl this$0, String $pageUrl, FavorPlayModel $favorPlayModel) {
        FavorModel aggFavor;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($pageUrl, "$pageUrl");
        Intrinsics.checkNotNullParameter($favorPlayModel, "$favorPlayModel");
        IFavorBusinessManager manager = (IFavorBusinessManager) ServiceManager.getService(IFavorBusinessManager.SERVICE_REFERENCE);
        if (manager != null) {
            FavorResult favorResult = this$0.isFavored(manager, $pageUrl, $favorPlayModel);
            boolean z = DEBUG;
            if (z) {
                this$0.printLogForDebug("updateMovieFavor", $pageUrl, (FavorModel) null, $favorPlayModel, favorResult.isFavored());
            }
            if (favorResult.isFavored() && favorResult.getFavorModel() != null && (aggFavor = SearchMovieAGGUtil.Companion.transToMovieFavorModel($pageUrl, favorResult.getFavorModel(), $favorPlayModel)) != null) {
                List oldUkList = CollectionsKt.listOf($pageUrl, SearchH5CollectionUtils.getWebVideoUkey($pageUrl), SearchH5CollectionUtils.getWebVideoUkeyNoUnderLine($pageUrl));
                if (z) {
                    String str = aggFavor.uKey;
                    Intrinsics.checkNotNullExpressionValue(str, "aggFavor.uKey");
                    this$0.printFavorForDebug(str, "beforeUpdateFavor");
                    Log.d(TAG, "更新收藏剧集信息：\n " + $favorPlayModel + " \n 模板id：" + aggFavor.tplId);
                }
                manager.addOrUpdateWithReplaceOldFavor(oldUkList, aggFavor);
                if (z) {
                    String str2 = aggFavor.uKey;
                    Intrinsics.checkNotNullExpressionValue(str2, "aggFavor.uKey");
                    this$0.printFavorForDebug(str2, "afterUpdateFavor");
                }
            }
        }
    }

    public void updateHistoryFavor(Context context, String pageUrl, FavorPlayModel favorPlayModel) {
        if (context != null) {
            CharSequence charSequence = pageUrl;
            if (!(charSequence == null || StringsKt.isBlank(charSequence)) && favorPlayModel != null) {
                if (DEBUG) {
                    Log.d(TAG, "更新历史剧集信息：\n " + favorPlayModel);
                }
                ExtraEpisodeModel extraInfo = favorPlayModel.getExtraInfo();
                InteractionUtils.updateHistory(context, pageUrl, extraInfo != null ? extraInfo.getMainDocTitle() : null, (String) null, (String) null, (HashMap<String, String>) null, favorPlayModel);
            }
        }
    }

    public boolean isUrlInVideoTransWhite(String pageUrl) {
        return VideoTransWhiteManager.INSTANCE.isUrlInWhite(pageUrl);
    }

    private final FavorResult isFavored(IFavorBusinessManager manager, String pageUrl, FavorPlayModel favorPlayModel) {
        boolean z = true;
        if (pageUrl.length() == 0) {
            return new FavorResult(false, (FavorModel) null);
        }
        boolean favored = false;
        FavorModel favorModel = null;
        if (favorPlayModel != null) {
            String uk = SearchMovieAGGUtil.Companion.getFavorUK(favorPlayModel);
            CharSequence charSequence = uk;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                favorModel = manager.queryFavor(uk);
                favored = favorModel != null;
                if (DEBUG && favored) {
                    printFavorForDebug(uk, "是否收藏：" + favored + "， 聚合收藏查询结果");
                }
            }
        }
        if (!favored) {
            favorModel = manager.queryFavorByUrl(pageUrl);
            if (favorModel == null) {
                z = false;
            }
            favored = z;
            if (DEBUG && favored) {
                String str = favorModel.uKey;
                Intrinsics.checkNotNullExpressionValue(str, "favorModel.uKey");
                printFavorForDebug(str, "是否收藏：" + favored + "， 非聚合收藏查询结果");
            }
        }
        return new FavorResult(favored, favorModel);
    }

    private final void printLogForDebug(String method, String pageUrl, FavorModel favorModel, FavorPlayModel favorPlayModel, boolean favorStatus) {
        Log.d(TAG, method + "\n\tpageUrl=" + pageUrl + "\n\tfavorModel=" + favorModel + "\n\tfavorPlayModel=" + favorPlayModel + "\n\tfavorStatus=" + favorStatus);
    }

    private final void printFavorForDebug(String uk, String logPrefix) {
        IFavorManager manager = (IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE);
        if (manager != null) {
            Log.d(TAG, "logPrefix=" + logPrefix + "\n\tuk=" + uk + "\n\tfavorModel=" + manager.queryFavor(uk));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/impl/SearchH5FavorServiceImpl$FavorResult;", "", "isFavored", "", "favorModel", "Lcom/baidu/searchbox/favor/data/FavorModel;", "(ZLcom/baidu/searchbox/favor/data/FavorModel;)V", "getFavorModel", "()Lcom/baidu/searchbox/favor/data/FavorModel;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchH5FavorServiceImpl.kt */
    private static final class FavorResult {
        private final FavorModel favorModel;
        private final boolean isFavored;

        public static /* synthetic */ FavorResult copy$default(FavorResult favorResult, boolean z, FavorModel favorModel2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = favorResult.isFavored;
            }
            if ((i2 & 2) != 0) {
                favorModel2 = favorResult.favorModel;
            }
            return favorResult.copy(z, favorModel2);
        }

        public final boolean component1() {
            return this.isFavored;
        }

        public final FavorModel component2() {
            return this.favorModel;
        }

        public final FavorResult copy(boolean z, FavorModel favorModel2) {
            return new FavorResult(z, favorModel2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FavorResult)) {
                return false;
            }
            FavorResult favorResult = (FavorResult) obj;
            return this.isFavored == favorResult.isFavored && Intrinsics.areEqual((Object) this.favorModel, (Object) favorResult.favorModel);
        }

        public int hashCode() {
            boolean z = this.isFavored;
            if (z) {
                z = true;
            }
            int i2 = (z ? 1 : 0) * true;
            FavorModel favorModel2 = this.favorModel;
            return i2 + (favorModel2 == null ? 0 : favorModel2.hashCode());
        }

        public String toString() {
            return "FavorResult(isFavored=" + this.isFavored + ", favorModel=" + this.favorModel + ')';
        }

        public FavorResult(boolean isFavored2, FavorModel favorModel2) {
            this.isFavored = isFavored2;
            this.favorModel = favorModel2;
        }

        public final boolean isFavored() {
            return this.isFavored;
        }

        public final FavorModel getFavorModel() {
            return this.favorModel;
        }
    }
}
