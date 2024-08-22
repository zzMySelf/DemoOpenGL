package com.baidu.searchbox.schemedispatch.united.module.impl;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.schemedispatch.united.module.UnitedSchemeTalosPopUpFrameAdapter;
import com.baidu.searchbox.schemedispatch.united.module.UnitedSchemeTalosPopUpFrameDispatcher;
import com.baidu.searchbox.schemedispatch.united.module.pyramid.TalosPopupInterface;
import com.baidu.searchbox.talospopupwindow.ITalosFloatViewExternal;
import com.baidu.searchbox.talospopupwindow.ITalosPopViewExternal;
import com.baidu.searchbox.talospopupwindow.TalosPopupWindowMgr;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J0\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/schemedispatch/united/module/impl/TalosPopupImpl;", "Lcom/baidu/searchbox/schemedispatch/united/module/pyramid/TalosPopupInterface;", "()V", "getTalosFloatViewExternel", "Lcom/baidu/searchbox/talospopupwindow/ITalosFloatViewExternal;", "activity", "Landroid/content/Context;", "getTalosPopupViewExternel", "Lcom/baidu/searchbox/talospopupwindow/ITalosPopViewExternal;", "showTalosPopup", "", "action", "", "params", "Landroid/app/Activity;", "adapter", "Lcom/baidu/searchbox/schemedispatch/united/module/UnitedSchemeTalosPopUpFrameAdapter;", "talospopupwindow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosPopupImpl.kt */
public final class TalosPopupImpl implements TalosPopupInterface {
    public void showTalosPopup(String action, String params, Activity activity, UnitedSchemeTalosPopUpFrameAdapter adapter) {
        UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher;
        Object element$iv;
        String str = params;
        CharSequence charSequence = action;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = str;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z && activity != null) {
                UnitedSchemeEntity entity = new UnitedSchemeEntity(new Uri.Builder().scheme("baiduboxapp").appendPath(UnitedSchemeTalosPopUpFrameDispatcher.MODULE_TLS_POPUP_FRAME).appendPath(action).build());
                entity.putParams("params", params);
                List<UnitedSchemeBaseDispatcher> $this$firstOrNull$iv = UnitedSchemeMainDispatcher.injectDispatcherList;
                if ($this$firstOrNull$iv != null) {
                    Iterator it = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            element$iv = null;
                            break;
                        }
                        element$iv = it.next();
                        if (Intrinsics.areEqual((Object) ((UnitedSchemeBaseDispatcher) element$iv).getDispatcherName(), (Object) UnitedSchemeTalosPopUpFrameDispatcher.MODULE_TLS_POPUP_FRAME)) {
                            break;
                        }
                    }
                    unitedSchemeBaseDispatcher = (UnitedSchemeBaseDispatcher) element$iv;
                } else {
                    unitedSchemeBaseDispatcher = null;
                }
                UnitedSchemeTalosPopUpFrameDispatcher popupDispatcher = unitedSchemeBaseDispatcher instanceof UnitedSchemeTalosPopUpFrameDispatcher ? (UnitedSchemeTalosPopUpFrameDispatcher) unitedSchemeBaseDispatcher : null;
                if (popupDispatcher != null) {
                    if (UiThreadUtils.isOnUiThread()) {
                        popupDispatcher.handleShow(activity, action, entity, (CallbackHandler) null, adapter, true);
                    } else {
                        UiThreadUtils.runOnUiThread(new TalosPopupImpl$$ExternalSyntheticLambda0(popupDispatcher, activity, action, entity, adapter));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showTalosPopup$lambda-2  reason: not valid java name */
    public static final void m2737showTalosPopup$lambda2(UnitedSchemeTalosPopUpFrameDispatcher $popupDispatcher, Activity $activity, String $action, UnitedSchemeEntity $entity, UnitedSchemeTalosPopUpFrameAdapter $adapter) {
        Intrinsics.checkNotNullParameter($popupDispatcher, "$popupDispatcher");
        Intrinsics.checkNotNullParameter($entity, "$entity");
        $popupDispatcher.handleShow($activity, $action, $entity, (CallbackHandler) null, $adapter, true);
    }

    public ITalosFloatViewExternal getTalosFloatViewExternel(Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return TalosPopupWindowMgr.getTalosFloatViewExternel(activity);
    }

    public ITalosPopViewExternal getTalosPopupViewExternel(Context activity) {
        UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher;
        Object element$iv;
        Intrinsics.checkNotNullParameter(activity, "activity");
        List<UnitedSchemeBaseDispatcher> $this$firstOrNull$iv = UnitedSchemeMainDispatcher.injectDispatcherList;
        if ($this$firstOrNull$iv != null) {
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it.next();
                if (Intrinsics.areEqual((Object) ((UnitedSchemeBaseDispatcher) element$iv).getDispatcherName(), (Object) UnitedSchemeTalosPopUpFrameDispatcher.MODULE_TLS_POPUP_FRAME)) {
                    break;
                }
            }
            unitedSchemeBaseDispatcher = (UnitedSchemeBaseDispatcher) element$iv;
        } else {
            unitedSchemeBaseDispatcher = null;
        }
        UnitedSchemeTalosPopUpFrameDispatcher unitedSchemeTalosPopUpFrameDispatcher = unitedSchemeBaseDispatcher instanceof UnitedSchemeTalosPopUpFrameDispatcher ? (UnitedSchemeTalosPopUpFrameDispatcher) unitedSchemeBaseDispatcher : null;
        if (unitedSchemeTalosPopUpFrameDispatcher != null) {
            return unitedSchemeTalosPopUpFrameDispatcher.getTalosPopupViewExternel();
        }
        return null;
    }
}
