package com.baidu.searchbox.download.center.ui.search;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u001c\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0010\u001a\u00020\bJ\u001f\u0010\u0011\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0012\"\u00020\n¢\u0006\u0002\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/search/SearchDownloadFileWrapper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "addHisWord", "", "searchWord", "", "clearAllHisWord", "getDownloadFile", "callBack", "Lcom/baidu/searchbox/download/center/ui/search/SearchDownloadFileCallBack;", "getHisSearchWord", "onDestroy", "removeHisWord", "", "([Ljava/lang/String;)V", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchDownloadFileWrapper.kt */
public final class SearchDownloadFileWrapper {
    private final Context context;

    public SearchDownloadFileWrapper() {
        this((Context) null, 1, (DefaultConstructorMarker) null);
    }

    public SearchDownloadFileWrapper(Context context2) {
        this.context = context2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchDownloadFileWrapper(Context context2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : context2);
    }

    public final Context getContext() {
        return this.context;
    }

    public static /* synthetic */ void getDownloadFile$default(SearchDownloadFileWrapper searchDownloadFileWrapper, String str, SearchDownloadFileCallBack searchDownloadFileCallBack, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            searchDownloadFileCallBack = null;
        }
        searchDownloadFileWrapper.getDownloadFile(str, searchDownloadFileCallBack);
    }

    public final void getDownloadFile(String searchWord, SearchDownloadFileCallBack callBack) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        ExecutorUtilsExt.postOnElastic(new SearchDownloadFileWrapper$$ExternalSyntheticLambda3(searchWord, this, callBack), "search_download_task", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: getDownloadFile$lambda-1  reason: not valid java name */
    public static final void m17675getDownloadFile$lambda1(String $searchWord, SearchDownloadFileWrapper this$0, SearchDownloadFileCallBack $callBack) {
        Intrinsics.checkNotNullParameter($searchWord, "$searchWord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List tempList = SearchDownloadHelper.getAllFilesBySearchKeyWord$default(SearchDownloadHelper.INSTANCE, $searchWord, false, false, 6, (Object) null);
        Context context2 = this$0.context;
        if (context2 != null && (context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
            ((Activity) this$0.context).runOnUiThread(new SearchDownloadFileWrapper$$ExternalSyntheticLambda1($callBack, tempList));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getDownloadFile$lambda-1$lambda-0  reason: not valid java name */
    public static final void m17676getDownloadFile$lambda1$lambda0(SearchDownloadFileCallBack $callBack, List $tempList) {
        Intrinsics.checkNotNullParameter($tempList, "$tempList");
        if ($callBack != null) {
            $callBack.queryDownloadCallBack($tempList);
        }
    }

    public static /* synthetic */ void getHisSearchWord$default(SearchDownloadFileWrapper searchDownloadFileWrapper, SearchDownloadFileCallBack searchDownloadFileCallBack, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            searchDownloadFileCallBack = null;
        }
        searchDownloadFileWrapper.getHisSearchWord(searchDownloadFileCallBack);
    }

    public final void getHisSearchWord(SearchDownloadFileCallBack callBack) {
        ExecutorUtilsExt.postOnElastic(new SearchDownloadFileWrapper$$ExternalSyntheticLambda0(this, callBack), "search_download_task", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: getHisSearchWord$lambda-3  reason: not valid java name */
    public static final void m17677getHisSearchWord$lambda3(SearchDownloadFileWrapper this$0, SearchDownloadFileCallBack $callBack) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map tempList = SearchHisHelper.INSTANCE.getSearchHis();
        Context context2 = this$0.context;
        if (context2 != null && (context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
            ((Activity) this$0.context).runOnUiThread(new SearchDownloadFileWrapper$$ExternalSyntheticLambda2($callBack, tempList));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getHisSearchWord$lambda-3$lambda-2  reason: not valid java name */
    public static final void m17678getHisSearchWord$lambda3$lambda2(SearchDownloadFileCallBack $callBack, Map $tempList) {
        Intrinsics.checkNotNullParameter($tempList, "$tempList");
        if ($callBack != null) {
            $callBack.queryHisWordCallBack($tempList);
        }
    }

    public final void addHisWord(String searchWord) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        SearchHisHelper.INSTANCE.addSearchHis(searchWord);
    }

    public final void removeHisWord(String... searchWord) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        SearchHisHelper.INSTANCE.deleteSearchHis((String[]) Arrays.copyOf(searchWord, searchWord.length));
    }

    public final void clearAllHisWord() {
        SearchHisHelper.INSTANCE.clearAllSearchHis();
    }

    public final void onDestroy() {
        SearchHisHelper.INSTANCE.realSaveSp();
    }
}
