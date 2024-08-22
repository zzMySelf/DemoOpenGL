package com.baidu.swan.apps.impl.extension;

import com.baidu.swan.apps.adlanding.OpenAdMaxViewAction;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.extension.SwanExtensionModuleProvider;
import com.baidu.swan.apps.impl.account.actions.FaceResultVerifyAction;
import com.baidu.swan.apps.impl.account.actions.FaceVerifyAction;
import com.baidu.swan.apps.impl.account.actions.GetBdussAction;
import com.baidu.swan.apps.impl.account.actions.GetStokenAction;
import com.baidu.swan.apps.impl.account.actions.LoginAndGetMobileAction;
import com.baidu.swan.apps.impl.account.actions.ThirdPartyLoginAction;
import com.baidu.swan.apps.impl.activity.action.AddActivityFavoriteAction;
import com.baidu.swan.apps.impl.activity.action.JoinActivityAction;
import com.baidu.swan.apps.impl.activity.action.OperationRequestAction;
import com.baidu.swan.apps.impl.ad.AdRequestAction;
import com.baidu.swan.apps.impl.ai.image.recognize.action.ImageRecognitionAction;
import com.baidu.swan.apps.impl.ai.tts.action.SwanTTSAction;
import com.baidu.swan.apps.impl.ai.voice.recognize.action.VoiceRecognitionAction;
import com.baidu.swan.apps.impl.ar.action.ARCameraDetectContentAction;
import com.baidu.swan.apps.impl.ar.action.ARCameraInsertAction;
import com.baidu.swan.apps.impl.ar.action.ARCameraRemoveAction;
import com.baidu.swan.apps.impl.ar.action.ARCameraStartRecordAction;
import com.baidu.swan.apps.impl.ar.action.ARCameraStopRecordAction;
import com.baidu.swan.apps.impl.ar.action.ARCameraTakePhotoAction;
import com.baidu.swan.apps.impl.ar.action.ARCameraUpdateAction;
import com.baidu.swan.apps.impl.ar.action.ChangeARStatusAction;
import com.baidu.swan.apps.impl.ar.action.SendLuaMsgToARAction;
import com.baidu.swan.apps.impl.channel.SwanAppChannelAction;
import com.baidu.swan.apps.impl.channel.im.SwanAppPullMsgAction;
import com.baidu.swan.apps.impl.operations.action.CloseFullScreenViewAction;
import com.baidu.swan.apps.impl.operations.action.OpenFullScreenViewAction;
import com.baidu.swan.apps.impl.operations.action.PageTransitionAction;
import com.baidu.swan.apps.impl.payment.RequestPolymerPaymentAction;
import com.baidu.swan.apps.impl.plugin.LaunchCloudGameAction;
import com.baidu.swan.apps.impl.push.GetPushSettingStateSyncAction;
import com.baidu.swan.apps.impl.push.GuidePushSettingAction;
import com.baidu.swan.apps.impl.quickpay.actions.QuickPayAction;
import com.baidu.swan.apps.impl.scheme.actions.recommend.actions.RecommendProductsAction;
import com.baidu.swan.apps.impl.scheme.actions.recommend.actions.RecommendSimilarAction;
import com.baidu.swan.apps.impl.setting.actions.PrivateGetUserInfoAction;
import com.baidu.swan.apps.impl.sysinfo.action.GetChannelIdAction;
import com.baidu.swan.apps.ioc.interfaces.ISwanAppExtension;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.impl.SwanApi$$ModulesProvider;
import com.baidu.swan.impl.SwanProcessCallModuleProvider;
import java.util.Map;

public class SwanAppExtensionImpl implements ISwanAppExtension {
    public void regActions(UnitedSchemeSwanAppDispatcher dispatcher) {
        dispatcher.regAction(new PrivateGetUserInfoAction(dispatcher));
        dispatcher.regAction(new RecommendSimilarAction(dispatcher));
        dispatcher.regAction(new RecommendProductsAction(dispatcher));
        dispatcher.regAction(new RequestPolymerPaymentAction(dispatcher));
        dispatcher.regAction(new SwanAppChannelAction(dispatcher));
        dispatcher.regAction(new SwanAppPullMsgAction(dispatcher));
        dispatcher.regAction(new ARCameraInsertAction(dispatcher));
        dispatcher.regAction(new ARCameraUpdateAction(dispatcher));
        dispatcher.regAction(new ARCameraTakePhotoAction(dispatcher));
        dispatcher.regAction(new ARCameraStartRecordAction(dispatcher));
        dispatcher.regAction(new ARCameraStopRecordAction(dispatcher));
        dispatcher.regAction(new ARCameraRemoveAction(dispatcher));
        dispatcher.regAction(new SendLuaMsgToARAction(dispatcher));
        dispatcher.regAction(new ChangeARStatusAction(dispatcher));
        dispatcher.regAction(new ARCameraDetectContentAction(dispatcher));
        dispatcher.regAction(new GetChannelIdAction(dispatcher));
        dispatcher.regAction(new VoiceRecognitionAction(dispatcher));
        dispatcher.regAction(new OpenAdMaxViewAction(dispatcher));
        dispatcher.regAction(new GuidePushSettingAction(dispatcher));
        dispatcher.regAction(new ThirdPartyLoginAction(dispatcher));
        dispatcher.regAction(new GetStokenAction(dispatcher));
        dispatcher.regAction(new GetPushSettingStateSyncAction(dispatcher));
        dispatcher.regAction(new ImageRecognitionAction(dispatcher));
        dispatcher.regAction(new LaunchCloudGameAction(dispatcher));
        dispatcher.regAction(new AdRequestAction(dispatcher));
        dispatcher.regAction(new QuickPayAction(dispatcher));
        dispatcher.regAction(new FaceVerifyAction(dispatcher));
        dispatcher.regAction(new FaceResultVerifyAction(dispatcher));
        dispatcher.regAction(new JoinActivityAction(dispatcher));
        dispatcher.regAction(new OperationRequestAction(dispatcher));
        dispatcher.regAction(new AddActivityFavoriteAction(dispatcher));
        dispatcher.regAction(new OpenFullScreenViewAction(dispatcher));
        dispatcher.regAction(new CloseFullScreenViewAction(dispatcher));
        dispatcher.regAction(new SwanTTSAction(dispatcher));
        dispatcher.regAction(new LoginAndGetMobileAction(dispatcher));
        dispatcher.regAction(new GetBdussAction(dispatcher));
        dispatcher.regAction(new PageTransitionAction(dispatcher));
    }

    public Map<String, Object> getWebviewApiModules(ISwanApiContext swanApiContext) {
        Map<String, Object> apiModules = SwanApi$$ModulesProvider.getWebviewApiModules(swanApiContext);
        Map<String, Object> extensionApiModules = SwanExtensionModuleProvider.getWebViewApiModules(swanApiContext);
        if (extensionApiModules == null) {
            return apiModules;
        }
        if (apiModules == null) {
            return extensionApiModules;
        }
        apiModules.putAll(extensionApiModules);
        return apiModules;
    }

    public Map<String, Object> getV8ApiModules(ISwanApiContext swanApiContext) {
        Map<String, Object> apiModules = SwanApi$$ModulesProvider.getV8ApiModules(swanApiContext);
        Map<String, Object> extensionApiModules = SwanExtensionModuleProvider.getV8ApiModules(swanApiContext);
        if (extensionApiModules == null) {
            return apiModules;
        }
        if (apiModules == null) {
            return extensionApiModules;
        }
        apiModules.putAll(extensionApiModules);
        return apiModules;
    }

    public Map<Class, Object> getProcessCallModules() {
        return SwanProcessCallModuleProvider.getModules();
    }
}
