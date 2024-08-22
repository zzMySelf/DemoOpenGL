package com.baidu.searchbox.ugc.view;

import androidx.recyclerview.widget.GridLayoutManager;
import com.baidu.searchbox.ugc.adapter.ImageAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/ugc/view/AlbumView$initRecyclerView$1$1$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "lib-ugc-album_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumView.kt */
public final class AlbumView$initRecyclerView$1$1$1 extends GridLayoutManager.SpanSizeLookup {
    final /* synthetic */ AlbumView this$0;

    AlbumView$initRecyclerView$1$1$1(AlbumView $receiver) {
        this.this$0 = $receiver;
    }

    public int getSpanSize(int position) {
        ImageAdapter access$getMAdapter$p = this.this$0.mAdapter;
        boolean z = false;
        if (access$getMAdapter$p != null && access$getMAdapter$p.isActivityType(position)) {
            z = true;
        }
        return z ? 2 : 1;
    }
}
