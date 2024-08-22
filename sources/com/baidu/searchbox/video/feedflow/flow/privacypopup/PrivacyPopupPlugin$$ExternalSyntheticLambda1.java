package com.baidu.searchbox.video.feedflow.flow.privacypopup;

import androidx.lifecycle.Observer;
import kotlin.Unit;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PrivacyPopupPlugin$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ PrivacyPopupState f$0;
    public final /* synthetic */ PrivacyPopupPlugin f$1;

    public /* synthetic */ PrivacyPopupPlugin$$ExternalSyntheticLambda1(PrivacyPopupState privacyPopupState, PrivacyPopupPlugin privacyPopupPlugin) {
        this.f$0 = privacyPopupState;
        this.f$1 = privacyPopupPlugin;
    }

    public final void onChanged(Object obj) {
        PrivacyPopupPlugin.m6587onAttachToManager$lambda1$lambda0(this.f$0, this.f$1, (Unit) obj);
    }
}
