package com.baidu.searchbox.account.listener;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.common.matrixstyle.StyleMode;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.dto.CertGuardionDTO;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IGetUserCertInfoListener;
import com.baidu.searchbox.account.R;
import com.baidu.searchbox.account.childguarder.ChildTeenagerConstants;
import com.baidu.searchbox.account.childguarder.ChildTeenagerUbcHelper;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.home.tabs.extend.IHomeTabFun;
import com.baidu.searchbox.settings.teenager.guid.ChildTeenagerGuidActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0012J=\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\nJ\u0006\u0010$\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/account/listener/ChildGuarderDialogUtil;", "", "()V", "HAS_POP", "", "getHAS_POP", "()Z", "setHAS_POP", "(Z)V", "KEY_TEENAGER_HAS_PASSWORD", "", "TAG", "mChildGuarderAuthDialog", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;", "mLoginManager", "Lcom/baidu/searchbox/account/BoxAccountManager;", "kotlin.jvm.PlatformType", "checkAndOpenChildCustodyDialog", "", "getUserCertInfo", "listener", "Lcom/baidu/searchbox/account/IGetUserCertInfoListener;", "goToTeenagerPage", "ifChildToCheckDialog", "loadCertGuardian", "realOpenChildGuarderAuthDialog", "page", "scene", "exclusionType", "Lcom/baidu/searchbox/exclusion/popup/ExclusionType;", "priority", "", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/exclusion/popup/ExclusionType;Ljava/lang/Float;Landroid/content/DialogInterface$OnDismissListener;)Z", "showLogoutDialog", "tryOpenChildGuarderAuthDialog", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChildGuarderDialogUtil.kt */
public final class ChildGuarderDialogUtil {
    private static boolean HAS_POP = false;
    public static final ChildGuarderDialogUtil INSTANCE = new ChildGuarderDialogUtil();
    private static final String KEY_TEENAGER_HAS_PASSWORD = "SETTINGS_TEENAGER_HAS_PASSWORD";
    public static final String TAG = "ChildGuarderDialogUtil";
    /* access modifiers changed from: private */
    public static BdAlertDialog mChildGuarderAuthDialog;
    /* access modifiers changed from: private */
    public static final BoxAccountManager mLoginManager = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE));

    private ChildGuarderDialogUtil() {
    }

    public final boolean getHAS_POP() {
        return HAS_POP;
    }

    public final void setHAS_POP(boolean z) {
        HAS_POP = z;
    }

    @StableApi
    public final void getUserCertInfo(IGetUserCertInfoListener listener) {
        BoxAccountManager boxAccountManager = mLoginManager;
        if (boxAccountManager == null || !boxAccountManager.isLogin(2)) {
            if (listener != null) {
                listener.onFailed(301);
            }
        } else if (StyleMode.INSTANCE.isTeenagerStyle()) {
            SapiAccountManager.getInstance().getAccountService().getCertInfo(new ChildGuarderDialogUtil$getUserCertInfo$1(listener));
        } else if (listener != null) {
            listener.onFailed(302);
        }
    }

    public final void ifChildToCheckDialog() {
        BoxAccount boxAccount;
        BoxAccountManager boxAccountManager = mLoginManager;
        if (boxAccountManager != null && (boxAccount = boxAccountManager.getBoxAccount()) != null && boxAccount.getIsChildAccount()) {
            checkAndOpenChildCustodyDialog();
        }
    }

    public final void checkAndOpenChildCustodyDialog() {
        if (ChildCustodyCommandUtil.INSTANCE.getChildCustodyDialogSwitch()) {
            BoxAccountManager boxAccountManager = mLoginManager;
            if (boxAccountManager != null && boxAccountManager.isLogin(2)) {
                SapiAccountManager.getInstance().getAccountService().getCertInfo(new ChildGuarderDialogUtil$checkAndOpenChildCustodyDialog$1());
            } else if (AppConfig.isDebug()) {
                Log.d(TAG, "【checkAndOpenChildCustodyDialog】用户未登录 return");
            }
        } else if (AppConfig.isDebug()) {
            Log.d(TAG, "【checkAndOpenChildCustodyDialog】: 云控开关 关闭");
        }
    }

    public final void goToTeenagerPage() {
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        Intent intent = new Intent();
        intent.setAction("com.baidu.android.app.account.intent.OPEN_CHILD_TEENAGER");
        intent.putExtra(ChildTeenagerGuidActivity.KEY_ENTER_ACTIVE, false);
        intent.setPackage(activity != null ? activity.getPackageName() : null);
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    public final void tryOpenChildGuarderAuthDialog() {
        String str;
        ChildTeenagerUbcHelper.INSTANCE.ubc("issue", "", "", ChildTeenagerConstants.UBC_FROM_CHILD_TIPS);
        if (!ActivityUtils.isDestroyed(BdBoxActivityManager.getRealTopActivity())) {
            Object service = ServiceManager.getService(IHomeTabFun.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService<IHomeTabFun>(…TabFun.SERVICE_REFERENCE)");
            IHomeTabFun homeTabFun = (IHomeTabFun) service;
            boolean isHomeTab = Intrinsics.areEqual((Object) "Feed", (Object) homeTabFun.getCurrentTabTag());
            boolean isPersonal = Intrinsics.areEqual((Object) "Personal", (Object) homeTabFun.getCurrentTabTag());
            ExclusionType exclusionType = null;
            String scene = isHomeTab ? "scene_home" : isPersonal ? PopupExclusionManagerMap.SCENE_MY : null;
            if (isHomeTab) {
                exclusionType = ExclusionType.HOME_ACCOUNT_CHILD_GUIDE;
            } else if (isPersonal) {
                exclusionType = ExclusionType.MY_CHILD_DIALOG;
            }
            ExclusionType exclusionType2 = exclusionType;
            float priority = isHomeTab ? 0.99f : isPersonal ? 0.1f : 0.0f;
            if (isHomeTab) {
                str = "homepage";
            } else {
                str = isPersonal ? "wode" : "other";
            }
            String page = str;
            if (isHomeTab || isPersonal) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "tryOpenChildDialog: isHomeTab=" + isHomeTab + ", isPersonal=" + isPersonal);
                }
                PopupExclusionManagerMap.getInstance().display(scene, new ChildGuarderDialogUtil$tryOpenChildGuarderAuthDialog$1(exclusionType2, priority, isHomeTab, isPersonal, page, scene));
                return;
            }
            UiThreadUtils.runOnUiThread(new ChildGuarderDialogUtil$$ExternalSyntheticLambda0(page, scene, exclusionType2, priority));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tryOpenChildGuarderAuthDialog$lambda-0  reason: not valid java name */
    public static final void m14354tryOpenChildGuarderAuthDialog$lambda0(String $page, String $scene, ExclusionType $exclusionType, float $priority) {
        Intrinsics.checkNotNullParameter($page, "$page");
        INSTANCE.realOpenChildGuarderAuthDialog($page, $scene, $exclusionType, Float.valueOf($priority), (DialogInterface.OnDismissListener) null);
    }

    public final boolean realOpenChildGuarderAuthDialog(String page, String scene, ExclusionType exclusionType, Float priority, DialogInterface.OnDismissListener dismissListener) {
        BdAlertDialog bdAlertDialog;
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        if (ActivityUtils.isDestroyed(activity) || activity == null) {
            if (dismissListener != null) {
                dismissListener.onDismiss((DialogInterface) null);
            }
            return false;
        }
        BdAlertDialog bdAlertDialog2 = mChildGuarderAuthDialog;
        if (bdAlertDialog2 != null) {
            if ((bdAlertDialog2 != null && bdAlertDialog2.isShowing()) && (bdAlertDialog = mChildGuarderAuthDialog) != null) {
                bdAlertDialog.dismiss();
            }
        }
        BdAlertDialog.Builder message = new BdAlertDialog.Builder(activity).setTitle(R.string.child_guarder_dialog_title).setMessage(R.string.child_guarder_dialog_content);
        String string = activity.getResources().getString(R.string.child_guarder_dialog_exit);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt…hild_guarder_dialog_exit)");
        BdAlertDialog.Builder button = message.setButton(new BdAlertDialog.ButtonItem(string, new ChildGuarderDialogUtil$realOpenChildGuarderAuthDialog$1(page)));
        String string2 = activity.getResources().getString(R.string.child_guarder_dialog_ok);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt….child_guarder_dialog_ok)");
        BdAlertDialog.ButtonItem $this$realOpenChildGuarderAuthDialog_u24lambda_u2d1 = new BdAlertDialog.ButtonItem(string2, new ChildGuarderDialogUtil$realOpenChildGuarderAuthDialog$2(page));
        $this$realOpenChildGuarderAuthDialog_u24lambda_u2d1.setMTextColor(Integer.valueOf(com.baidu.android.common.ui.style.R.color.BC59));
        BdAlertDialog create = button.setButton($this$realOpenChildGuarderAuthDialog_u24lambda_u2d1).create();
        mChildGuarderAuthDialog = create;
        if (create != null) {
            create.setCancelable(false);
        }
        BdAlertDialog bdAlertDialog3 = mChildGuarderAuthDialog;
        if (bdAlertDialog3 != null) {
            bdAlertDialog3.setOnDismissListener(new ChildGuarderDialogUtil$$ExternalSyntheticLambda1(dismissListener));
        }
        BdAlertDialog bdAlertDialog4 = mChildGuarderAuthDialog;
        if (bdAlertDialog4 != null) {
            bdAlertDialog4.show();
        }
        ChildTeenagerUbcHelper.INSTANCE.ubc("show", page, "", ChildTeenagerConstants.UBC_FROM_CHILD_TIPS);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: realOpenChildGuarderAuthDialog$lambda-2  reason: not valid java name */
    public static final void m14353realOpenChildGuarderAuthDialog$lambda2(DialogInterface.OnDismissListener $dismissListener, DialogInterface it) {
        if ($dismissListener != null) {
            $dismissListener.onDismiss((DialogInterface) null);
        }
        mChildGuarderAuthDialog = null;
    }

    public final void showLogoutDialog(String page) {
        String str = page;
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        if (!ActivityUtils.isDestroyed(activity) && activity != null) {
            ViewGroup rootView = new FrameLayout(AppRuntime.getAppContext());
            View inflate = LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.child_logout_layout, rootView, false);
            if (inflate != null) {
                ViewGroup childView = (ViewGroup) inflate;
                SimpleDraweeView avatar = (SimpleDraweeView) childView.findViewById(R.id.avatar);
                TextView name = (TextView) childView.findViewById(R.id.name);
                BoxAccountManager boxAccountManager = mLoginManager;
                String str2 = null;
                BoxAccount boxAccount = boxAccountManager != null ? boxAccountManager.getBoxAccount() : null;
                avatar.setImageURI(boxAccount != null ? boxAccount.getPortrait() : null);
                ((SimpleDraweeView) childView.findViewById(R.id.avatar_over)).setBackgroundResource(R.drawable.child_dialog_avatar_over_bg);
                if (boxAccount != null) {
                    str2 = boxAccount.getNickname();
                }
                name.setText(str2);
                name.setTextColor(activity.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                ((FrameLayout) childView.findViewById(R.id.fr_user_zones)).setBackgroundResource(R.drawable.child_dialog_avatar_bg);
                TextView currentLoginText = (TextView) childView.findViewById(R.id.current_login_txt);
                currentLoginText.setTextColor(activity.getResources().getColor(R.color.BC136));
                currentLoginText.setBackgroundResource(R.drawable.child_dialog_name_bg);
                rootView.addView(childView);
                BdAlertDialog.Builder title = new BdAlertDialog.Builder(activity).setView(rootView).setTitle(R.string.child_guarder_dialog_confirm_title);
                String string = activity.getResources().getString(R.string.child_guarder_dialog_exit);
                Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt…hild_guarder_dialog_exit)");
                BdAlertDialog.Builder button = title.setButton(new BdAlertDialog.ButtonItem(string, new ChildGuarderDialogUtil$showLogoutDialog$1(str)));
                String string2 = activity.getResources().getString(R.string.child_guarder_dialog_ok);
                Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt….child_guarder_dialog_ok)");
                BdAlertDialog.ButtonItem $this$showLogoutDialog_u24lambda_u2d3 = new BdAlertDialog.ButtonItem(string2, new ChildGuarderDialogUtil$showLogoutDialog$2(str));
                $this$showLogoutDialog_u24lambda_u2d3.setMTextColor(Integer.valueOf(com.baidu.android.common.ui.style.R.color.BC59));
                BdAlertDialog $this$showLogoutDialog_u24lambda_u2d4 = button.setButton($this$showLogoutDialog_u24lambda_u2d3).create();
                $this$showLogoutDialog_u24lambda_u2d4.show();
                $this$showLogoutDialog_u24lambda_u2d4.setCancelable(false);
                ChildTeenagerUbcHelper.INSTANCE.ubc("show", str, "", ChildTeenagerConstants.UBC_FROM_LOGOUT_TIPS);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final void loadCertGuardian() {
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        if (AppConfig.isDebug()) {
            Log.d(TAG, "去监护人认证 loadCertGuardian");
        }
        BoxAccountManager boxAccountManager = mLoginManager;
        if (boxAccountManager != null && boxAccountManager.isLogin(2)) {
            CertGuardionDTO dto = new CertGuardionDTO();
            dto.scene = "ppdemo";
            PassportSDK.getInstance().loadCertGuardian(activity, new ChildGuarderDialogUtil$loadCertGuardian$1(activity), dto);
        }
    }
}
