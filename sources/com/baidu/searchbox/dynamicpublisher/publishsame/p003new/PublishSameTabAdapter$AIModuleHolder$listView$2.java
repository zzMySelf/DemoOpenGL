package com.baidu.searchbox.dynamicpublisher.publishsame.p003new;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.publishercomponent.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.baidu.searchbox.dynamicpublisher.publishsame.new.PublishSameTabAdapter$AIModuleHolder$listView$2  reason: invalid package */
/* compiled from: PublishSameTabAdapter.kt */
final class PublishSameTabAdapter$AIModuleHolder$listView$2 extends Lambda implements Function0<RecyclerView> {
    final /* synthetic */ View $rootView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PublishSameTabAdapter$AIModuleHolder$listView$2(View view2) {
        super(0);
        this.$rootView = view2;
    }

    public final RecyclerView invoke() {
        return (RecyclerView) this.$rootView.findViewById(R.id.rl_list_view);
    }
}
