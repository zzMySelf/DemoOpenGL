package com.baidu.searchbox.mall.comp.his;

import android.view.View;
import com.baidu.android.ext.widget.dialog.BdDialog;
import com.baidu.searchbox.mall.stat.StatisticManager;
import com.baidu.searchbox.mall.stat.StatisticManagerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/mall/comp/his/SearchHisViewModel$alterClearAction$2", "Lcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchHisViewModel.kt */
public final class SearchHisViewModel$alterClearAction$2 implements BdDialog.OnItemClickListener {
    final /* synthetic */ Function1<Boolean, Unit> $callback;

    SearchHisViewModel$alterClearAction$2(Function1<? super Boolean, Unit> $callback2) {
        this.$callback = $callback2;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        StatisticManager.INSTANCE.statHisClick(StatisticManagerKt.STAT_ACTION_HIS_DEL_ALL_CONFORM);
        this.$callback.invoke(true);
    }
}
