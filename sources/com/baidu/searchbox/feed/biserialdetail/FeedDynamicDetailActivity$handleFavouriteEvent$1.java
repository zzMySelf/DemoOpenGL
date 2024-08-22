package com.baidu.searchbox.feed.biserialdetail;

import android.content.Context;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.bookmark.BookMarkLoginUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.favor.callback.FavorDataCallback;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.biserialdetail.model.DynamicDetailFlow;
import com.baidu.searchbox.feed.biserialdetail.net.DynamicDetailDataParse;
import com.baidu.searchbox.sync.FavorUIOperator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/FeedDynamicDetailActivity$handleFavouriteEvent$1", "Lcom/baidu/searchbox/bookmark/BookMarkLoginUtils$OnAllowBookMarkListener;", "allowUseBookMark", "", "loginFail", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedDynamicDetailActivity.kt */
public final class FeedDynamicDetailActivity$handleFavouriteEvent$1 implements BookMarkLoginUtils.OnAllowBookMarkListener {
    final /* synthetic */ DynamicDetailFlow.FavouriteInfo $model;
    final /* synthetic */ FeedDynamicDetailActivity this$0;

    FeedDynamicDetailActivity$handleFavouriteEvent$1(DynamicDetailFlow.FavouriteInfo $model2, FeedDynamicDetailActivity $receiver) {
        this.$model = $model2;
        this.this$0 = $receiver;
    }

    public void allowUseBookMark() {
        Context appContext = AppRuntime.getAppContext();
        FavorModel favor = DynamicDetailDataParse.INSTANCE.toFavorModel(this.$model);
        if (favor == null || favor.shouldFilterUrl()) {
            UniversalToast.makeText(appContext, (CharSequence) appContext.getString(R.string.feed_save_fail)).show();
        } else {
            FavorUIOperator.addOrRemoveFavorAsync((Context) this.this$0, favor, (FavorDataCallback) new FeedDynamicDetailActivity$handleFavouriteEvent$1$allowUseBookMark$1(this.this$0));
        }
    }

    public void loginFail() {
    }
}
