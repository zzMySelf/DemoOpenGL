package com.baidu.searchbox.settings.teenager.guid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.common.matrixstyle.StyleMode;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.appframework.ActionToolBarActivity;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.settings.teenager.command.TeenagerCommandUtil;
import com.baidu.searchbox.settings.teenager.guid.ITeenagerGuidResourceHelper;
import com.baidu.searchbox.settings.teenager.password.PasswordActivity;
import com.baidu.searchbox.settings.teenager.util.IAccountHelper;
import com.baidu.searchbox.settings.teenager.util.ShakeHelper;
import com.baidu.searchbox.settings.teenager.util.StyleModeHelper;
import com.baidu.searchbox.settings.teenager.util.TeenagerConstants;
import com.baidu.searchbox.settings.teenager.util.TeenagerUbcHelper;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.ui.TouchStateListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AsyncKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 62\u00020\u00012\u00020\u00022\u00020\u0003:\u00016B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\"\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010&H\u0015J\b\u0010'\u001a\u00020\u0017H\u0014J\u001a\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u0017H\u0014J\b\u0010/\u001a\u00020\u0017H\u0016J\b\u00100\u001a\u00020\u0017H\u0017J\u0017\u00101\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020\u0017H\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/guid/TeenagerGuidActivity;", "Lcom/baidu/searchbox/appframework/ActionToolBarActivity;", "Lcom/baidu/searchbox/settings/teenager/guid/ITeenagerGuidResourceHelper;", "Lcom/baidu/searchbox/settings/teenager/util/IAccountHelper;", "()V", "hasAgreeAgreement", "", "shakeHelper", "Lcom/baidu/searchbox/settings/teenager/util/ShakeHelper;", "getShakeHelper", "()Lcom/baidu/searchbox/settings/teenager/util/ShakeHelper;", "shakeHelper$delegate", "Lkotlin/Lazy;", "stateChanged", "getStateChanged", "()Z", "setStateChanged", "(Z)V", "touchListener", "Lcom/baidu/searchbox/ui/TouchStateListener;", "fetchHasTeenagerPwd", "fetchTeenagerMode", "gotoPasswordActivity", "", "passwordType", "", "handleGuidOpenBtnClick", "handlePasswordResult", "handleResult", "passwordActionType", "passwordSetFrom", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onNightModeChanged", "isNightMode", "onResume", "onToolBarBackPressed", "setupStyle", "showMiddleToast", "toastTextId", "(Ljava/lang/Integer;)V", "ubcGuidOpenBtnClick", "updateTeenagerGuidOpenBtnState", "Companion", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeenagerGuidActivity.kt */
public class TeenagerGuidActivity extends ActionToolBarActivity implements ITeenagerGuidResourceHelper, IAccountHelper {
    private static final float ALPHA_BTN_AGREEMENT_SELECTED = 1.0f;
    private static final float ALPHA_BTN_AGREEMENT_UN_SELECTED = 0.4f;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DELAY_TOAST = 280;
    private static final int PASSWORD_ACTION_DEFAULT = -1;
    public static final int REQUEST_CODE_PASSWORD = 1000;
    public static final String TAG = "TeenagerGuidActivity";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public boolean hasAgreeAgreement;
    private final Lazy shakeHelper$delegate = LazyKt.lazy(TeenagerGuidActivity$shakeHelper$2.INSTANCE);
    private boolean stateChanged;
    private final TouchStateListener touchListener = new TouchStateListener();

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public int fetchAgreementImgResourceId(boolean hasAgreeAgreement2) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchAgreementImgResourceId(this, hasAgreeAgreement2);
    }

    public int fetchTeenagerGuidContentTextId() {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidContentTextId(this);
    }

    public int fetchTeenagerGuidImgResourceId(boolean teenagerMode) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidImgResourceId(this, teenagerMode);
    }

    public int fetchTeenagerGuidModifyPwdVisibility(boolean teenagerMode, boolean hasPassword) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidModifyPwdVisibility(this, teenagerMode, hasPassword);
    }

    public int fetchTeenagerGuidOpenTextId(boolean teenagerMode) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidOpenTextId(this, teenagerMode);
    }

    public String fetchTeenagerGuidShowFrom(boolean teenagerMode, boolean hasPassword) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidShowFrom(this, teenagerMode, hasPassword);
    }

    public String fetchTeenagerGuidShowPage(boolean teenagerMode, boolean hasPassword) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidShowPage(this, teenagerMode, hasPassword);
    }

    public String fetchTeenagerGuidShowType(boolean teenagerMode, boolean hasPassword) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidShowType(this, teenagerMode, hasPassword);
    }

    public String fetchTeenagerGuidShowValue(boolean teenagerMode, boolean hasPassword) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidShowValue(this, teenagerMode, hasPassword);
    }

    public int fetchTeenagerGuidStateColorId(boolean teenagerMode) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidStateColorId(this, teenagerMode);
    }

    public int fetchTeenagerGuidStateTextId(boolean teenagerMode) {
        return ITeenagerGuidResourceHelper.DefaultImpls.fetchTeenagerGuidStateTextId(this, teenagerMode);
    }

    public void tryLogin(Context context, Function1<? super Boolean, Unit> loginCallback) {
        IAccountHelper.DefaultImpls.tryLogin(this, context, loginCallback);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/guid/TeenagerGuidActivity$Companion;", "", "()V", "ALPHA_BTN_AGREEMENT_SELECTED", "", "ALPHA_BTN_AGREEMENT_UN_SELECTED", "DELAY_TOAST", "", "PASSWORD_ACTION_DEFAULT", "", "REQUEST_CODE_PASSWORD", "TAG", "", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TeenagerGuidActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final ShakeHelper getShakeHelper() {
        return (ShakeHelper) this.shakeHelper$delegate.getValue();
    }

    public boolean getStateChanged() {
        return this.stateChanged;
    }

    public void setStateChanged(boolean z) {
        this.stateChanged = z;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        BaseActivity.setNextPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        super.onCreate(savedInstanceState);
        setEnableSliding(false);
        setContentView(com.baidu.searchbox.settings.teenager.R.layout.setting_teenager_guid_activity);
        BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
        if (bdActionBar != null) {
            bdActionBar.setTitle(getResources().getString(com.baidu.searchbox.settings.teenager.R.string.setting_teenager_title));
        }
        ActionBarExtKt.showActionBarWithoutLeft(this);
        ((TextView) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidAgreementLink)).setOnTouchListener(this.touchListener);
        ((TextView) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidModifyPwd)).setOnTouchListener(this.touchListener);
        ((ConstraintLayout) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidAgreement)).setOnClickListener(new TeenagerGuidActivity$$ExternalSyntheticLambda0(this));
        ((TextView) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidAgreementLink)).setOnClickListener(new TeenagerGuidActivity$$ExternalSyntheticLambda1(this));
        ((TextView) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidOpenBtn)).setOnClickListener(new TeenagerGuidActivity$$ExternalSyntheticLambda2(this));
        ((TextView) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidModifyPwd)).setOnClickListener(new TeenagerGuidActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m3122onCreate$lambda0(TeenagerGuidActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = !this$0.hasAgreeAgreement;
        this$0.hasAgreeAgreement = z;
        ((ImageView) this$0._$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidAgreementImg)).setImageDrawable(this$0.getResources().getDrawable(this$0.fetchAgreementImgResourceId(z)));
        this$0.updateTeenagerGuidOpenBtnState();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m3123onCreate$lambda1(TeenagerGuidActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String agreementUrl = TeenagerCommandUtil.INSTANCE.getAgreementUrl();
        if (agreementUrl.length() > 0) {
            Router.invoke(this$0, agreementUrl);
        } else if (AppConfig.isDebug()) {
            Log.d(TAG, "青少年隐私协议链接不正确，不做跳转");
        }
        if (!this$0.fetchTeenagerMode()) {
            TeenagerUbcHelper.INSTANCE.ubc("agreement", TeenagerConstants.UBC_PAGE_MODE_OFF, "click");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m3124onCreate$lambda2(TeenagerGuidActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.hasAgreeAgreement) {
            this$0.handleGuidOpenBtnClick();
            return;
        }
        this$0.getShakeHelper().startShake((Layer) this$0._$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidAgreementLayer), true, new TeenagerGuidActivity$onCreate$3$1(this$0));
        this$0.ubcGuidOpenBtnClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m3125onCreate$lambda3(TeenagerGuidActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotoPasswordActivity(5);
        if (this$0.fetchTeenagerMode()) {
            TeenagerUbcHelper.INSTANCE.ubc("key_change", "mode_on", "click");
        } else {
            TeenagerUbcHelper.INSTANCE.ubc("key_change", TeenagerConstants.UBC_PAGE_MODE_OFF, "click");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        setupStyle();
        boolean teenagerMode = fetchTeenagerMode();
        boolean hasPassword = fetchHasTeenagerPwd();
        TeenagerUbcHelper.triggerUbc$default(TeenagerUbcHelper.INSTANCE, fetchTeenagerGuidShowType(teenagerMode, hasPassword), fetchTeenagerGuidShowPage(teenagerMode, hasPassword), fetchTeenagerGuidShowValue(teenagerMode, hasPassword), fetchTeenagerGuidShowFrom(teenagerMode, hasPassword), (String) null, 16, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        int passwordActionType;
        if (1000 == requestCode) {
            int passwordSetFrom = -1;
            if (-1 == resultCode) {
                boolean handleResult = false;
                if (data != null) {
                    handleResult = data.getBooleanExtra(PasswordActivity.PASSWORD_HANDLE_RESULT, false);
                }
                if (data != null) {
                    passwordActionType = data.getIntExtra(PasswordActivity.PASSWORD_TYPE_KEY, -1);
                } else {
                    passwordActionType = -1;
                }
                if (data != null) {
                    passwordSetFrom = data.getIntExtra(PasswordActivity.PASSWORD_TYPE_SET_INPUT_FROM_KEY, -1);
                }
                handlePasswordResult(handleResult, passwordActionType, passwordSetFrom);
            } else if (AppConfig.isDebug()) {
                Log.d(TAG, "青少年模式密码界面的resultCode为" + requestCode + "，不做处理");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void handlePasswordResult(boolean handleResult, int passwordActionType, int passwordSetFrom) {
        View decorView;
        Integer toastTextResourceId = null;
        if (handleResult) {
            switch (passwordActionType) {
                case 1:
                    if (passwordSetFrom != 0) {
                        if (1 != passwordSetFrom) {
                            Integer num = null;
                            break;
                        } else {
                            toastTextResourceId = Integer.valueOf(com.baidu.searchbox.settings.teenager.R.string.setting_teenager_action_tip_reset);
                            break;
                        }
                    } else {
                        setStateChanged(true);
                        toastTextResourceId = Integer.valueOf(com.baidu.searchbox.settings.teenager.R.string.setting_teenager_action_tip_opened);
                        break;
                    }
                case 3:
                    setStateChanged(true);
                    toastTextResourceId = Integer.valueOf(com.baidu.searchbox.settings.teenager.R.string.setting_teenager_action_tip_opened);
                    break;
                case 4:
                    setStateChanged(true);
                    toastTextResourceId = Integer.valueOf(com.baidu.searchbox.settings.teenager.R.string.setting_teenager_action_tip_closed);
                    break;
                case 5:
                    toastTextResourceId = Integer.valueOf(com.baidu.searchbox.settings.teenager.R.string.setting_teenager_action_tip_modify);
                    break;
            }
        } else if (5 == passwordActionType) {
            toastTextResourceId = Integer.valueOf(com.baidu.searchbox.settings.teenager.R.string.setting_teenager_action_tip_modify_fail);
        } else if (1 == passwordActionType) {
            toastTextResourceId = Integer.valueOf(com.baidu.searchbox.settings.teenager.R.string.setting_teenager_action_tip_set_fail);
        } else {
            Integer num2 = null;
        }
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.postDelayed(new TeenagerGuidActivity$$ExternalSyntheticLambda4(this, toastTextResourceId), 280);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePasswordResult$lambda-4  reason: not valid java name */
    public static final void m3121handlePasswordResult$lambda4(TeenagerGuidActivity this$0, Integer $toastTextResourceId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showMiddleToast($toastTextResourceId);
    }

    public void onToolBarBackPressed() {
        super.onToolBarBackPressed();
        if (getStateChanged()) {
            StyleModeHelper.INSTANCE.changeStyleUI();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4 && getStateChanged()) {
            StyleModeHelper.INSTANCE.changeStyleUI();
        }
        return super.onKeyDown(keyCode, event);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getShakeHelper().onDestroy();
        super.onDestroy();
    }

    public void setupStyle() {
        AsyncKt.doAsync$default(this, (Function1) null, new TeenagerGuidActivity$setupStyle$1(this), 1, (Object) null);
    }

    public boolean fetchTeenagerMode() {
        return StyleMode.INSTANCE.isTeenagerStyle();
    }

    public boolean fetchHasTeenagerPwd() {
        return TeenagerCommandUtil.INSTANCE.getTeenagerHasPassword();
    }

    /* access modifiers changed from: private */
    public final void updateTeenagerGuidOpenBtnState() {
        if (this.hasAgreeAgreement) {
            ((TextView) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidOpenBtn)).setAlpha(1.0f);
            ((TextView) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidOpenBtn)).setOnTouchListener(this.touchListener);
            return;
        }
        ((TextView) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidOpenBtn)).setAlpha(0.4f);
        ((TextView) _$_findCachedViewById(com.baidu.searchbox.settings.teenager.R.id.teenagerGuidOpenBtn)).setOnTouchListener((View.OnTouchListener) null);
    }

    public void handleGuidOpenBtnClick() {
        if (fetchTeenagerMode()) {
            gotoPasswordActivity(4);
        } else {
            tryLogin(this, new TeenagerGuidActivity$handleGuidOpenBtnClick$1(this));
        }
        ubcGuidOpenBtnClick();
    }

    private final void ubcGuidOpenBtnClick() {
        if (fetchTeenagerMode()) {
            TeenagerUbcHelper.INSTANCE.ubc("off", "mode_on", "click");
        } else {
            TeenagerUbcHelper.INSTANCE.ubc("on", TeenagerConstants.UBC_PAGE_MODE_OFF, "click");
        }
    }

    public void gotoPasswordActivity(int passwordType) {
        Intent intent = new Intent();
        intent.setClass(this, PasswordActivity.class);
        intent.putExtra(PasswordActivity.PASSWORD_TYPE_KEY, passwordType);
        startActivityForResult(intent, 1000);
    }

    /* access modifiers changed from: private */
    public final void showMiddleToast(Integer toastTextId) {
        if (toastTextId != null && !isFinishing() && !isDestroyed()) {
            UniversalToast.makeText((Context) this, toastTextId.intValue()).setLocation(ToastLocation.MIDDLE).show();
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        setupStyle();
    }
}
