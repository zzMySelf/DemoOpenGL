package com.baidu.searchbox.publisher.verify.task;

import android.content.Context;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountToolsCallback;
import com.baidu.searchbox.publisher.verify.AuthSceneConstansKt;
import com.baidu.searchbox.publisher.verify.IPublisherVerifyResultCallback;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/publisher/verify/task/PassRiskFaceTask;", "Lcom/baidu/searchbox/publisher/verify/task/BasePassVerifyTask;", "context", "Landroid/content/Context;", "callback", "Lcom/baidu/searchbox/publisher/verify/IPublisherVerifyResultCallback;", "(Landroid/content/Context;Lcom/baidu/searchbox/publisher/verify/IPublisherVerifyResultCallback;)V", "execute", "", "getAuthScene", "", "creative_plugin_impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PassRiskFaceTask.kt */
public final class PassRiskFaceTask extends BasePassVerifyTask {
    public PassRiskFaceTask(Context context, IPublisherVerifyResultCallback callback) {
        super(context, callback);
    }

    public void execute() {
        if (checkParamsNotNull()) {
            JSONObject ext = new JSONObject();
            JSONObject $this$execute_u24lambda_u2d0 = ext;
            $this$execute_u24lambda_u2d0.put("authid", getAuthId());
            $this$execute_u24lambda_u2d0.put("scene", getAuthScene());
            BoxAccountManager accountManager = getAccountManager();
            if (accountManager != null) {
                accountManager.loadAccountPage(getContext(), 9, getAuthScene(), (IAccountToolsCallback) null, new PassRiskFaceTask$execute$1(this), ext);
            }
        }
    }

    public String getAuthScene() {
        return AuthSceneConstansKt.AUTH_SCENE_BJH_RISK_FACE;
    }
}
