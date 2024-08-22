package com.baidu.searchbox.kmm.home.lv1tab;

import com.baidu.searchbox.kmm.foundation.utils.KmmLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeLv1TabOperationDataMgr.kt */
final class HomeLv1TabOperationDataMgr$setOperationHasClicked$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $tabId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeLv1TabOperationDataMgr$setOperationHasClicked$1(String str) {
        super(0);
        this.$tabId = str;
    }

    public final void invoke() {
        HomeLv1TabOperationModel operationModel = (HomeLv1TabOperationModel) HomeLv1TabOperationDataMgr.operationDataSet.get(this.$tabId);
        if (operationModel != null) {
            boolean hasDisplayed = operationModel.getHasDisplayed();
            if (hasDisplayed) {
                KmmLog.printLog("KMM-运营", "点击了 Tab " + this.$tabId + " 取消该 Tab 的运营飘新展示");
                if (operationModel.isClickNotDisappearResType$com_baidu_searchbox_kmm_business_home()) {
                    operationModel.changeToResourceOnlyType$com_baidu_searchbox_kmm_business_home();
                    HomeLv1TabOperationDataMgr.persistOperationDataFromMemory();
                } else {
                    HomeLv1TabOperationDataMgr.removeOperation(this.$tabId);
                }
                HomeLv1TabOperationDataMgr.saveLastDisplayOperationId(operationModel);
                return;
            }
            KmmLog.printLog("KMM-运营", "忽略 Tab: " + this.$tabId + " 唯一ID：" + operationModel.getIdentification() + " 点击取消，已展示：" + hasDisplayed);
        }
    }
}
