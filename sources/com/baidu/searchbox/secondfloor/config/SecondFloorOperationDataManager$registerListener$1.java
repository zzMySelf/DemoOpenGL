package com.baidu.searchbox.secondfloor.config;

import android.util.Log;
import com.baidu.common.operation.CommonOperationExtModel;
import com.baidu.common.operation.CommonOperationModel;
import com.baidu.common.operation.IApplyListener;
import com.baidu.searchbox.secondfloor.listener.ISecondFloorDataListener;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/secondfloor/config/SecondFloorOperationDataManager$registerListener$1", "Lcom/baidu/common/operation/IApplyListener;", "apply", "", "uis", "Ljava/util/ArrayList;", "Lcom/baidu/common/operation/CommonOperationModel$UIModel;", "config", "Lorg/json/JSONObject;", "extModel", "Lcom/baidu/common/operation/CommonOperationExtModel;", "lib-secondfloor-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecondFloorOperationDataManager.kt */
public final class SecondFloorOperationDataManager$registerListener$1 implements IApplyListener {
    SecondFloorOperationDataManager$registerListener$1() {
    }

    public void apply(ArrayList<CommonOperationModel.UIModel> uis, JSONObject config, CommonOperationExtModel extModel) {
        if (SecondFloorOperationDataManager.DEBUG) {
            Log.d(SecondFloorOperationDataManager.TAG, "receive apply callback uis: " + uis + " config: " + config);
        }
        SecondFloorOperationDataManager.INSTANCE.setMOperationData(new SecondFloorOperationData().parseOperationData(uis, config));
        SecondFloorOperationDataManager.INSTANCE.setSecondFloorSwitch(SecondFloorOperationChecker.INSTANCE.checkOperateData(SecondFloorOperationDataManager.INSTANCE.getMOperationData()));
        if (SecondFloorOperationDataManager.INSTANCE.getSecondFloorSwitch()) {
            SecondFloorOperationDataManager.INSTANCE.setFeedLoadingText();
            SecondFloorOperationChecker.INSTANCE.checkVersion();
            ISecondFloorDataListener mDataListener = SecondFloorOperationDataManager.INSTANCE.getMDataListener();
            if (mDataListener != null) {
                mDataListener.onResponse();
            }
        }
    }
}
