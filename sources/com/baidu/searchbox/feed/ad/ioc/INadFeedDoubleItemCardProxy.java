package com.baidu.searchbox.feed.ad.ioc;

import android.view.View;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/ad/ioc/INadFeedDoubleItemCardProxy;", "", "getItemBaseModel", "", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "model", "getItemView", "Landroid/view/View;", "view", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: INadFeedDoubleItemCardProxy.kt */
public interface INadFeedDoubleItemCardProxy {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final INadFeedDoubleItemCardProxy EMPTY = new INadFeedDoubleItemCardProxy$Companion$EMPTY$1();

    List<FeedBaseModel> getItemBaseModel(FeedBaseModel feedBaseModel);

    List<View> getItemView(View view2);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/feed/ad/ioc/INadFeedDoubleItemCardProxy$Companion;", "", "()V", "EMPTY", "Lcom/baidu/searchbox/feed/ad/ioc/INadFeedDoubleItemCardProxy;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: INadFeedDoubleItemCardProxy.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
