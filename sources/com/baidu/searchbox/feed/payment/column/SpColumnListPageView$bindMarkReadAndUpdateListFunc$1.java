package com.baidu.searchbox.feed.payment.column;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnListViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "itemId", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnListFragment.kt */
final class SpColumnListPageView$bindMarkReadAndUpdateListFunc$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ SpColumnListPageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpColumnListPageView$bindMarkReadAndUpdateListFunc$1(SpColumnListPageView spColumnListPageView) {
        super(1);
        this.this$0 = spColumnListPageView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String itemId) {
        Object obj;
        SpColumnListViewModel spColumnListViewModel;
        String str = itemId;
        Intrinsics.checkNotNullParameter(str, "itemId");
        SpColumnListPage access$getListPage$p = this.this$0.listPage;
        SpColumnListPage spColumnListPage = null;
        if (access$getListPage$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listPage");
            access$getListPage$p = null;
        }
        ArrayList list = access$getListPage$p.getController().obtainDataManager().getDisplayCacheList();
        if (list != null) {
            SpColumnListPageView spColumnListPageView = this.this$0;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((FeedBaseModel) obj).id, (Object) str)) {
                    break;
                }
            }
            FeedBaseModel feedBaseModel = (FeedBaseModel) obj;
            if (feedBaseModel != null) {
                FeedBaseModel model = feedBaseModel;
                if (!model.runtimeStatus.isRead) {
                    model.runtimeStatus.isRead = true;
                    SpColumnListViewModel access$getViewModel$p = spColumnListPageView.viewModel;
                    if (access$getViewModel$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        spColumnListViewModel = null;
                    } else {
                        spColumnListViewModel = access$getViewModel$p;
                    }
                    String str2 = model.id;
                    Intrinsics.checkNotNullExpressionValue(str2, "model.id");
                    SpColumnListViewModel.saveState$default(spColumnListViewModel, str2, false, (String) null, (String) null, (String) null, 30, (Object) null);
                    SpColumnListPage access$getListPage$p2 = spColumnListPageView.listPage;
                    if (access$getListPage$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listPage");
                    } else {
                        spColumnListPage = access$getListPage$p2;
                    }
                    spColumnListPage.notifyDataSetChanged();
                }
            }
        }
    }
}
