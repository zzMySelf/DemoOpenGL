package com.baidu.live.feed.search.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.LiveSearchModel;
import com.baidu.live.feed.search.model.data.RequestSearchData;
import com.baidu.live.feed.search.presenter.LiveFeedSearchContract;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J \u0010!\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004¨\u0006'²\u0006\u0012\u0010(\u001a\n **\u0004\u0018\u00010)0)X\u0002²\u0006\u0012\u0010(\u001a\n **\u0004\u0018\u00010)0)X\u0002"}, d2 = {"Lcom/baidu/live/feed/search/presenter/LiveFeedSearchPresenter;", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$Presenter;", "searchPage", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;", "(Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;)V", "curInputWords", "", "searchIsCancel", "", "searchModel", "Lcom/baidu/live/feed/search/model/LiveSearchModel;", "getSearchPage", "()Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;", "setSearchPage", "addHistoryRecord", "", "context", "Landroid/content/Context;", "content", "cancelSearch", "deleteAllHistoryRecord", "deleteHistoryRecord", "position", "", "followClick", "searchBean", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "followRealization", "loadHotRank", "loadSearchHotWordsList", "matchSuggestionWords", "words", "onDetach", "searchWord", "pn", "requestData", "Lcom/baidu/live/feed/search/model/data/RequestSearchData;", "showHistoryRecord", "Companion", "lib-live-feed-search_release", "manager", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "kotlin.jvm.PlatformType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFeedSearchPresenter.kt */
public final class LiveFeedSearchPresenter implements LiveFeedSearchContract.Presenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PAGE_FIRST = "0";
    /* access modifiers changed from: private */
    public String curInputWords;
    /* access modifiers changed from: private */
    public boolean searchIsCancel;
    private LiveSearchModel searchModel;
    private LiveFeedSearchContract.ISearchPage searchPage;

    public LiveFeedSearchPresenter(LiveFeedSearchContract.ISearchPage searchPage2) {
        this.searchPage = searchPage2;
        if (searchPage2 != null) {
            searchPage2.setPresenter(this);
        }
        this.searchModel = new LiveSearchModel();
    }

    public final LiveFeedSearchContract.ISearchPage getSearchPage() {
        return this.searchPage;
    }

    public final void setSearchPage(LiveFeedSearchContract.ISearchPage iSearchPage) {
        this.searchPage = iSearchPage;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/live/feed/search/presenter/LiveFeedSearchPresenter$Companion;", "", "()V", "PAGE_FIRST", "", "lib-live-feed-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveFeedSearchPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void loadSearchHotWordsList() {
        this.searchModel.fetchSearchHotWords(new LiveFeedSearchPresenter$loadSearchHotWordsList$1(this));
    }

    public void loadHotRank() {
        this.searchModel.fetchHotRank(new LiveFeedSearchPresenter$loadHotRank$1(this));
    }

    public void matchSuggestionWords(String words) {
        Intrinsics.checkNotNullParameter(words, "words");
        this.curInputWords = words;
        this.searchModel.matchSuggestionWords(words, new LiveFeedSearchPresenter$matchSuggestionWords$1(this));
    }

    public void searchWord(String words, String pn, RequestSearchData requestData) {
        Intrinsics.checkNotNullParameter(words, "words");
        Intrinsics.checkNotNullParameter(pn, "pn");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        this.searchIsCancel = false;
        this.searchModel.fetchSearchResult(words, pn, new LiveFeedSearchPresenter$searchWord$1(this, pn), requestData);
    }

    /* renamed from: followClick$lambda-0  reason: not valid java name */
    private static final AccountManagerService m13921followClick$lambda0(Lazy<? extends AccountManagerService> $manager$delegate) {
        return (AccountManagerService) $manager$delegate.getValue();
    }

    public void followClick(LiveSearchResultInfo searchBean, Context context, int position) {
        Intrinsics.checkNotNullParameter(searchBean, "searchBean");
        Intrinsics.checkNotNullParameter(context, "context");
        Lazy manager$delegate = LazyKt.lazy(LiveFeedSearchPresenter$followClick$manager$2.INSTANCE);
        if (!m13921followClick$lambda0(manager$delegate).isLogin(2)) {
            m13921followClick$lambda0(manager$delegate).login(context, new LiveFeedSearchPresenter$followClick$1(this, searchBean, position));
        } else {
            followRealization(searchBean, position);
        }
    }

    /* renamed from: followRealization$lambda-1  reason: not valid java name */
    private static final AccountManagerService m13922followRealization$lambda1(Lazy<? extends AccountManagerService> $manager$delegate) {
        return (AccountManagerService) $manager$delegate.getValue();
    }

    public final void followRealization(LiveSearchResultInfo searchBean, int position) {
        String str;
        Intrinsics.checkNotNullParameter(searchBean, "searchBean");
        AccountManagerService r1 = m13922followRealization$lambda1(LazyKt.lazy(LiveFeedSearchPresenter$followRealization$manager$2.INSTANCE));
        if (r1 != null) {
            String str2 = searchBean.uid;
            Intrinsics.checkNotNullExpressionValue(str2, "searchBean.uid");
            str = r1.getSocialEncryption(str2, "baiduuid_");
        } else {
            str = null;
        }
        String uk = str;
        LiveSearchModel liveSearchModel = this.searchModel;
        String str3 = searchBean.thirdId;
        Intrinsics.checkNotNullExpressionValue(str3, "searchBean.thirdId");
        Intrinsics.checkNotNull(uk);
        String str4 = searchBean.type;
        Intrinsics.checkNotNullExpressionValue(str4, "searchBean.type");
        String str5 = searchBean.feedId;
        Intrinsics.checkNotNullExpressionValue(str5, "searchBean.feedId");
        liveSearchModel.updateFollowState("", str3, uk, str4, !searchBean.hasFollowed, str5, new LiveFeedSearchPresenter$followRealization$1(this, position));
    }

    public void deleteHistoryRecord(Context context, int position) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences pref = context.getSharedPreferences("FeedSearchHistoryRecord", 0);
        Intrinsics.checkNotNullExpressionValue(pref, "context.getSharedPrefere…rd\",Context.MODE_PRIVATE)");
        SharedPreferences editor = pref;
        int recordCount = editor.getInt("count", 0);
        SharedPreferences.Editor editorWrite = pref.edit();
        Intrinsics.checkNotNullExpressionValue(editorWrite, "pref.edit()");
        for (int i2 = recordCount - position; i2 < 10; i2++) {
            editorWrite.putString(String.valueOf(i2), editor.getString(String.valueOf(i2 + 1), ""));
        }
        editorWrite.putString(String.valueOf(recordCount), "");
        editorWrite.putInt("count", recordCount - 1);
        editorWrite.commit();
    }

    public void deleteAllHistoryRecord(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences pref = context.getSharedPreferences("FeedSearchHistoryRecord", 0);
        Intrinsics.checkNotNullExpressionValue(pref, "context.getSharedPrefere…rd\",Context.MODE_PRIVATE)");
        int recordCount = pref.getInt("count", 0);
        SharedPreferences.Editor editorWrite = pref.edit();
        Intrinsics.checkNotNullExpressionValue(editorWrite, "pref.edit()");
        for (int i2 = 1; i2 < 11; i2++) {
            editorWrite.putString(String.valueOf(i2), "");
        }
        editorWrite.putString(String.valueOf(recordCount), "");
        editorWrite.putInt("count", 0);
        editorWrite.commit();
    }

    public void addHistoryRecord(Context context, String content) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        SharedPreferences pref = context.getSharedPreferences("FeedSearchHistoryRecord", 0);
        Intrinsics.checkNotNullExpressionValue(pref, "context.getSharedPrefere…rd\",Context.MODE_PRIVATE)");
        SharedPreferences editor = pref;
        int recordCount = 0;
        SharedPreferences.Editor editorWrite = pref.edit();
        Intrinsics.checkNotNullExpressionValue(editorWrite, "pref.edit()");
        int i2 = 1;
        while (i2 < 11) {
            if (!StringsKt.equals$default(editor.getString(String.valueOf(i2), ""), content, false, 2, (Object) null)) {
                i2++;
            } else {
                return;
            }
        }
        int i3 = 1;
        while (true) {
            if (i3 >= 11) {
                break;
            } else if (Intrinsics.areEqual((Object) editor.getString(String.valueOf(i3), ""), (Object) "")) {
                recordCount = i3;
                break;
            } else {
                i3++;
            }
        }
        if (recordCount != 0) {
            editorWrite.putString(String.valueOf(recordCount), content);
            editorWrite.putInt("count", recordCount);
        } else {
            for (int i4 = 1; i4 < 10; i4++) {
                editorWrite.putString(String.valueOf(i4), editor.getString(String.valueOf(i4 + 1), ""));
            }
            editorWrite.putString(String.valueOf(10), content);
            editorWrite.putInt("count", 10);
        }
        editorWrite.commit();
    }

    public void showHistoryRecord(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences pref = context.getSharedPreferences("FeedSearchHistoryRecord", 0);
        Intrinsics.checkNotNullExpressionValue(pref, "context.getSharedPrefere…d\", Context.MODE_PRIVATE)");
        int num = pref.getInt("count", 0);
        List recordList = new ArrayList();
        if (num > 0) {
            for (int i2 = num; i2 > 0; i2--) {
                String mRecord = pref.getString(String.valueOf(i2), "");
                if (mRecord != null) {
                    recordList.add(mRecord);
                }
            }
        } else {
            recordList.clear();
            LiveFeedSearchContract.ISearchPage iSearchPage = this.searchPage;
            if (iSearchPage != null) {
                iSearchPage.clearHistoryList();
            }
        }
        List it = recordList;
        LiveFeedSearchContract.ISearchPage iSearchPage2 = this.searchPage;
        if (iSearchPage2 != null) {
            iSearchPage2.setHistoryList(it);
        }
    }

    public void cancelSearch() {
        this.searchIsCancel = true;
        LiveFeedSearchContract.ISearchPage iSearchPage = this.searchPage;
        if (iSearchPage != null) {
            iSearchPage.hideLoading();
        }
    }

    public void onDetach() {
        this.searchPage = null;
    }
}
