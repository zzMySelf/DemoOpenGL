package com.baidu.live.feed.search.recmore;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\u0018\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&J.\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&¨\u0006\u0018"}, d2 = {"Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter;", "", "createAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "getAdapter", "setFollowStatus", "", "position", "", "setSuggestListener", "listener", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;", "setSuggestions", "searchResultList", "", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "suggestionList", "Lcom/baidu/live/feed/search/model/data/LiveSearchSuggestion;", "text", "", "OnSuggestionListener", "lib-live-feed-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ILiveRecSearchSugAdapter.kt */
public interface ILiveRecSearchSugAdapter {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J(\u0010\u000f\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/baidu/live/feed/search/recmore/ILiveRecSearchSugAdapter$OnSuggestionListener;", "", "jumpAuthorView", "", "jumpScheme", "", "onFollowClick", "itemInfo", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "position", "", "onResultClick", "onSuggestionClick", "content", "onSuggestionSelect", "onUbcResult", "resultList", "", "ubcType", "lib-live-feed-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ILiveRecSearchSugAdapter.kt */
    public interface OnSuggestionListener {
        void jumpAuthorView(String str);

        void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i2);

        void onResultClick(LiveSearchResultInfo liveSearchResultInfo);

        void onSuggestionClick(String str, int i2);

        void onSuggestionSelect(String str, int i2);

        void onUbcResult(List<? extends LiveSearchResultInfo> list, int i2, String str);
    }

    RecyclerView.Adapter<RecyclerView.ViewHolder> createAdapter(Context context);

    RecyclerView.Adapter<RecyclerView.ViewHolder> getAdapter();

    void setFollowStatus(int i2);

    void setSuggestListener(OnSuggestionListener onSuggestionListener);

    void setSuggestions(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2, String str);
}
