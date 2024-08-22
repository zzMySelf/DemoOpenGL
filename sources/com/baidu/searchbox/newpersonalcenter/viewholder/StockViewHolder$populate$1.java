package com.baidu.searchbox.newpersonalcenter.viewholder;

import android.content.Context;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StockViewHolder.kt */
final class StockViewHolder$populate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PersonalCenterTabModel $tabModel;
    final /* synthetic */ StockViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StockViewHolder$populate$1(StockViewHolder stockViewHolder, PersonalCenterTabModel personalCenterTabModel, Context context) {
        super(0);
        this.this$0 = stockViewHolder;
        this.$tabModel = personalCenterTabModel;
        this.$context = context;
    }

    public final void invoke() {
        ModuleActionListener moduleActionListener = this.this$0.getModuleActionListener();
        if (moduleActionListener != null) {
            moduleActionListener.onClickMoreListener(this.$tabModel, 0, this.this$0.cardPosition);
        }
        Context context = this.$context;
        PersonalCenterTabModel personalCenterTabModel = this.$tabModel;
        Router.invoke(context, personalCenterTabModel != null ? personalCenterTabModel.getScheme() : null);
    }
}
