package com.baidu.searchbox.search.mix.view;

import com.baidu.searchbox.search.tab.core.manager.IComponentManager;
import com.baidu.searchbox.search.tab.core.message.EventMessage;
import com.baidu.searchbox.search.tab.implement.tplview.ISearchAViewListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/search/mix/view/SearchNaMixListPage$onCreateView$1", "Lcom/baidu/searchbox/search/tab/implement/tplview/ISearchAViewListener;", "onFirstImageScreenPaint", "", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchNaMixListPage.kt */
public final class SearchNaMixListPage$onCreateView$1 implements ISearchAViewListener {
    final /* synthetic */ IComponentManager $manager;
    final /* synthetic */ SearchNaMixListPage this$0;

    SearchNaMixListPage$onCreateView$1(SearchNaMixListPage $receiver, IComponentManager $manager2) {
        this.this$0 = $receiver;
        this.$manager = $manager2;
    }

    public void onFirstImageScreenPaint() {
        if (!this.this$0.hasImagePaint) {
            this.this$0.hasImagePaint = true;
            this.$manager.sendMessage(new EventMessage(17, (Object) null));
        }
    }
}
