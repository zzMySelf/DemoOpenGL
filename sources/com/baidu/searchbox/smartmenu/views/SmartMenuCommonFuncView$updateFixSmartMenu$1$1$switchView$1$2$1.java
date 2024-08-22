package com.baidu.searchbox.smartmenu.views;

import com.baidu.searchbox.smartmenu.SmartMenuItemEventListener;
import com.baidu.searchbox.smartmenu.manager.SceneStrategy;
import com.baidu.searchbox.smartmenu.manager.SmartMenuMgr;
import com.baidu.searchbox.smartmenu.model.SmartMenuFixedMenuBlockModel;
import com.baidu.searchbox.smartmenu.model.SmartMenuFixedMenuItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuCommonFuncView.kt */
final class SmartMenuCommonFuncView$updateFixSmartMenu$1$1$switchView$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SmartMenuFixedMenuBlockModel $fixedMenuBlockModel;
    final /* synthetic */ SmartMenuItemEventListener $menuItemEventListener;
    final /* synthetic */ SmartMenuFixedMenuItemModel $smartMenuFixedMenuItemModel;
    final /* synthetic */ SmartMenuCommonFuncView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartMenuCommonFuncView$updateFixSmartMenu$1$1$switchView$1$2$1(SmartMenuFixedMenuItemModel smartMenuFixedMenuItemModel, SmartMenuFixedMenuBlockModel smartMenuFixedMenuBlockModel, SmartMenuCommonFuncView smartMenuCommonFuncView, SmartMenuItemEventListener smartMenuItemEventListener) {
        super(0);
        this.$smartMenuFixedMenuItemModel = smartMenuFixedMenuItemModel;
        this.$fixedMenuBlockModel = smartMenuFixedMenuBlockModel;
        this.this$0 = smartMenuCommonFuncView;
        this.$menuItemEventListener = smartMenuItemEventListener;
    }

    public final void invoke() {
        SmartMenuCommonFuncViewKt.addFixedItemRecordEventLog(this.$smartMenuFixedMenuItemModel.getItemId(), this.$fixedMenuBlockModel.getSceneStrategy(), true);
        for (SmartMenuFixedMenuItemModel itemModel : this.this$0.mThirdRowItems) {
            SmartMenuCommonFuncViewKt.addFixedItemRecordEventLog(itemModel.getItemId(), this.$fixedMenuBlockModel.getSceneStrategy(), true);
            SmartMenuItemEventListener smartMenuItemEventListener = this.$menuItemEventListener;
            if (smartMenuItemEventListener != null) {
                smartMenuItemEventListener.onItemShow(itemModel);
            }
        }
        SceneStrategy $this$invoke_u24lambda_u2d0 = this.$fixedMenuBlockModel.getSceneStrategy();
        if ($this$invoke_u24lambda_u2d0 != null) {
            SmartMenuMgr.INSTANCE.recordMenuItemsBlockUnfold($this$invoke_u24lambda_u2d0);
        }
    }
}
