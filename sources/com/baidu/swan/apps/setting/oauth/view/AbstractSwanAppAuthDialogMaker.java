package com.baidu.swan.apps.setting.oauth.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.aps.invoker.helper.PluginInvokeActivityHelper;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.SwanAppScopeDetailActivity;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.menu.fontsize.FontSizeSettingHelper;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.setting.oauth.ScopeInfo;
import com.baidu.swan.apps.ui.R;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.swan.apps.view.decorate.SwanAppDialogDecorate;
import com.baidu.swan.utils.fontsize.FontSizeImageViewExtKt;
import com.baidu.swan.utils.fontsize.FontSizeTextViewExtKt;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u0000 _2\u00020\u0001:\u0001_B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010;\u001a\u0004\u0018\u00010\u00122\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J2\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GJ4\u0010@\u001a\u00020A2\b\u0010I\u001a\u0004\u0018\u00010D2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GJ:\u0010J\u001a\u0004\u0018\u00010\n2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010K\u001a\u0004\u0018\u0001022\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010L\u001a\u0004\u0018\u00010'2\b\u0010M\u001a\u0004\u0018\u00010\u0018J \u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00122\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\u0006\u0010Q\u001a\u00020\u001dJ \u0010R\u001a\u00020S2\u0006\u0010P\u001a\u00020\u00122\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u0018\u0010T\u001a\u00020S2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H&J \u0010U\u001a\u00020S2\u0006\u0010P\u001a\u00020\u00122\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u000e\u0010V\u001a\u00020S2\u0006\u0010W\u001a\u00020GJ\u000e\u0010X\u001a\u00020S2\u0006\u0010Y\u001a\u00020\u001dJ\u001a\u0010Z\u001a\u00020S2\b\u0010[\u001a\u0004\u0018\u00010\f2\b\u0010>\u001a\u0004\u0018\u00010?J \u0010\\\u001a\u00020S2\u0006\u0010P\u001a\u00020\u00122\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0003J\u0010\u0010]\u001a\u00020S2\u0006\u0010^\u001a\u00020DH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001c\u0010#\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u00107\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006`"}, d2 = {"Lcom/baidu/swan/apps/setting/oauth/view/AbstractSwanAppAuthDialogMaker;", "", "()V", "mAuthCustomView", "Landroid/widget/FrameLayout;", "getMAuthCustomView", "()Landroid/widget/FrameLayout;", "setMAuthCustomView", "(Landroid/widget/FrameLayout;)V", "mAuthDialogBuilder", "Lcom/baidu/swan/apps/res/widget/dialog/SwanAppAlertDialog$Builder;", "mAuthNameView", "Landroid/widget/TextView;", "getMAuthNameView", "()Landroid/widget/TextView;", "setMAuthNameView", "(Landroid/widget/TextView;)V", "mCustomView", "Landroid/view/View;", "getMCustomView", "()Landroid/view/View;", "setMCustomView", "(Landroid/view/View;)V", "mDialogClickListener", "Landroid/content/DialogInterface$OnClickListener;", "mExplainDialogMaker", "Lcom/baidu/swan/apps/setting/oauth/view/SwanAppAuthExplainDialogMaker;", "mExplainDialogShowCallback", "Lcom/baidu/swan/apps/util/typedbox/TypedCallback;", "", "mIsExplainShowing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mMultiAuthAgreementView", "getMMultiAuthAgreementView", "setMMultiAuthAgreementView", "mMultiAuthCustomView", "getMMultiAuthCustomView", "setMMultiAuthCustomView", "mOpenData", "Lorg/json/JSONObject;", "getMOpenData", "()Lorg/json/JSONObject;", "setMOpenData", "(Lorg/json/JSONObject;)V", "mPosButton", "mRootView", "mSubExplainView", "getMSubExplainView", "setMSubExplainView", "mSwanApp", "Lcom/baidu/swan/apps/runtime/SwanApp;", "getMSwanApp", "()Lcom/baidu/swan/apps/runtime/SwanApp;", "setMSwanApp", "(Lcom/baidu/swan/apps/runtime/SwanApp;)V", "mTargetRadio", "", "getMTargetRadio", "()F", "createRootView", "context", "Landroid/content/Context;", "scopeInfo", "Lcom/baidu/swan/apps/setting/oauth/ScopeInfo;", "createSpanText", "Landroid/text/SpannableString;", "spannableText", "detailUrl", "", "keywordColor", "from", "", "end", "keyword", "getAuthDialogBuilder", "swanApp", "openData", "listener", "getExplainView", "Landroid/widget/RelativeLayout;", "rootView", "getPosButtonState", "initBaseView", "", "initCustomView", "initScopeExplain", "setPosButtonListener", "type", "setPosButtonState", "state", "setSubExplainInfoForLayout", "authFunction", "showExplainSplitView", "startScopeDetailActivity", "url", "Companion", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbstractSwanAppAuthDialogMaker.kt */
public abstract class AbstractSwanAppAuthDialogMaker {
    public static final int AUTH_THIRD_PHONE_NUMBER = 2;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String DESC_KEY = "desc";
    private static final String SCOPE_USER_LOCATION_KEY = "scope.userLocation";
    private static final String TAG = "SwanAppAuthDialog";
    private FrameLayout mAuthCustomView;
    private SwanAppAlertDialog.Builder mAuthDialogBuilder;
    private TextView mAuthNameView;
    private View mCustomView;
    private DialogInterface.OnClickListener mDialogClickListener;
    private final SwanAppAuthExplainDialogMaker mExplainDialogMaker = new SwanAppAuthExplainDialogMaker();
    private TypedCallback<Boolean> mExplainDialogShowCallback;
    private final AtomicBoolean mIsExplainShowing = new AtomicBoolean(false);
    private TextView mMultiAuthAgreementView;
    private View mMultiAuthCustomView;
    private JSONObject mOpenData;
    private TextView mPosButton;
    private View mRootView;
    private TextView mSubExplainView;
    private SwanApp mSwanApp;
    private final float mTargetRadio = FontSizeSettingHelper.getFontSizeRadio();

    public abstract void initCustomView(Context context, ScopeInfo scopeInfo);

    public final SwanApp getMSwanApp() {
        return this.mSwanApp;
    }

    public final void setMSwanApp(SwanApp swanApp) {
        this.mSwanApp = swanApp;
    }

    public final TextView getMAuthNameView() {
        return this.mAuthNameView;
    }

    public final void setMAuthNameView(TextView textView) {
        this.mAuthNameView = textView;
    }

    public final JSONObject getMOpenData() {
        return this.mOpenData;
    }

    public final void setMOpenData(JSONObject jSONObject) {
        this.mOpenData = jSONObject;
    }

    public final View getMMultiAuthCustomView() {
        return this.mMultiAuthCustomView;
    }

    public final void setMMultiAuthCustomView(View view2) {
        this.mMultiAuthCustomView = view2;
    }

    public final TextView getMMultiAuthAgreementView() {
        return this.mMultiAuthAgreementView;
    }

    public final void setMMultiAuthAgreementView(TextView textView) {
        this.mMultiAuthAgreementView = textView;
    }

    public final FrameLayout getMAuthCustomView() {
        return this.mAuthCustomView;
    }

    public final void setMAuthCustomView(FrameLayout frameLayout) {
        this.mAuthCustomView = frameLayout;
    }

    public final TextView getMSubExplainView() {
        return this.mSubExplainView;
    }

    public final void setMSubExplainView(TextView textView) {
        this.mSubExplainView = textView;
    }

    public final View getMCustomView() {
        return this.mCustomView;
    }

    public final void setMCustomView(View view2) {
        this.mCustomView = view2;
    }

    public final float getMTargetRadio() {
        return this.mTargetRadio;
    }

    public final SwanAppAlertDialog.Builder getAuthDialogBuilder(Context context, SwanApp swanApp, ScopeInfo scopeInfo, JSONObject openData, DialogInterface.OnClickListener listener) {
        if (context == null || swanApp == null || scopeInfo == null) {
            return null;
        }
        this.mSwanApp = swanApp;
        this.mOpenData = openData;
        this.mDialogClickListener = listener;
        this.mAuthDialogBuilder = new SwanAppAlertDialog.Builder(context);
        View createRootView = createRootView(context, scopeInfo);
        if (createRootView == null) {
            return null;
        }
        View view2 = createRootView;
        SwanAppAlertDialog.Builder it = this.mAuthDialogBuilder;
        if (it != null) {
            it.hideTitle(true);
            it.setView(view2);
            it.setDecorate(new SwanAppDialogDecorate());
            it.setDialogLayoutBackgroundResource(R.drawable.aiapps_action_sheet_bg);
            it.setBtnsVisible(false);
            it.removePadding();
            it.setDividerVisible(false);
        }
        return this.mAuthDialogBuilder;
    }

    private final View createRootView(Context context, ScopeInfo scopeInfo) {
        this.mRootView = View.inflate(context, R.layout.swan_app_auth_dialog_content_common, (ViewGroup) null);
        this.mExplainDialogShowCallback = new AbstractSwanAppAuthDialogMaker$$ExternalSyntheticLambda1(this);
        View rootView = this.mRootView;
        if (rootView != null) {
            this.mSubExplainView = (TextView) rootView.findViewById(R.id.permission_function_new);
            this.mMultiAuthCustomView = rootView.findViewById(R.id.multi_auth_custom_layout);
            this.mMultiAuthAgreementView = (TextView) rootView.findViewById(R.id.multi_auth_agreement_layout);
            this.mAuthCustomView = (FrameLayout) rootView.findViewById(R.id.auth_custom_layout);
            initBaseView(rootView, context, scopeInfo);
            initCustomView(context, scopeInfo);
            initScopeExplain(rootView, context, scopeInfo);
        }
        return this.mRootView;
    }

    /* access modifiers changed from: private */
    /* renamed from: createRootView$lambda-1  reason: not valid java name */
    public static final void m8062createRootView$lambda1(AbstractSwanAppAuthDialogMaker this$0, Boolean flag) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AtomicBoolean atomicBoolean = this$0.mIsExplainShowing;
        Intrinsics.checkNotNullExpressionValue(flag, PluginInvokeActivityHelper.EXTRA_FLAG);
        atomicBoolean.getAndSet(flag.booleanValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initBaseView(android.view.View r10, android.content.Context r11, com.baidu.swan.apps.setting.oauth.ScopeInfo r12) {
        /*
            r9 = this;
            java.lang.String r0 = "rootView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "scopeInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = r12.pluginAppName
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = r2
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 != 0) goto L_0x0038
            java.lang.String r0 = r12.pluginIconUrl
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0034
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r0 = r2
            goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            if (r0 != 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r1 = r2
        L_0x0039:
            r0 = r1
            int r1 = com.baidu.swan.apps.ui.R.id.swan_app_icon
            android.view.View r1 = r10.findViewById(r1)
            com.baidu.swan.apps.view.SwanAppRoundedImageView r1 = (com.baidu.swan.apps.view.SwanAppRoundedImageView) r1
            r3 = 0
            if (r1 == 0) goto L_0x009b
            java.lang.String r4 = "SwanAppAuthDialog"
            if (r0 == 0) goto L_0x0050
            java.lang.String r5 = r12.pluginIconUrl
            android.graphics.Bitmap r4 = com.baidu.swan.apps.util.SwanAppUtils.getAppIconByFresco((java.lang.String) r5, (java.lang.String) r4, (boolean) r2)
            goto L_0x0060
        L_0x0050:
            com.baidu.swan.apps.runtime.SwanApp r5 = r9.mSwanApp
            if (r5 == 0) goto L_0x0059
            com.baidu.swan.apps.launch.model.SwanAppLaunchInfo$Impl r5 = r5.getInfo()
            goto L_0x005a
        L_0x0059:
            r5 = r3
        L_0x005a:
            com.baidu.swan.apps.launch.model.SwanAppLaunchInfo r5 = (com.baidu.swan.apps.launch.model.SwanAppLaunchInfo) r5
            android.graphics.Bitmap r4 = com.baidu.swan.apps.util.SwanAppUtils.getAppIconByFresco((com.baidu.swan.apps.launch.model.SwanAppLaunchInfo) r5, (java.lang.String) r4, (boolean) r2)
        L_0x0060:
            android.graphics.drawable.BitmapDrawable r5 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r6 = r11.getResources()
            r5.<init>(r6, r4)
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
            r1.setImageDrawable(r5)
            android.content.res.Resources r5 = r11.getResources()
            int r6 = com.baidu.swan.apps.ui.R.color.swan_app_auth_icon_border
            int r5 = r5.getColor(r6)
            r1.setBorderColor(r5)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            float r6 = r9.mTargetRadio
            com.baidu.swan.utils.fontsize.FontSizeImageViewExtKt.setScaledImage(r5, r6)
            r5 = r1
            android.view.View r5 = (android.view.View) r5
            int r6 = com.baidu.swan.apps.ui.R.dimen.swanapp_scope_icon_size
            int r7 = com.baidu.swan.apps.ui.R.dimen.swanapp_scope_icon_size
            float r8 = r9.mTargetRadio
            com.baidu.swan.utils.fontsize.FontSizeViewExtKt.setScaledSizeRes(r5, r6, r7, r8)
            int r5 = com.baidu.swan.apps.ui.R.dimen.swanapp_scope_icon_corner
            float r6 = r9.mTargetRadio
            int r5 = com.baidu.swan.utils.fontsize.FontSizeHelper.getScaledSizeResInt(r5, r6)
            r1.setCornerRadius(r5)
        L_0x009b:
            int r4 = com.baidu.swan.apps.ui.R.id.swan_app_name
            android.view.View r4 = r10.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x00ce
            r5 = r4
            r6 = 0
            if (r0 == 0) goto L_0x00ae
            java.lang.String r3 = r12.pluginAppName
        L_0x00ab:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L_0x00c2
        L_0x00ae:
            com.baidu.swan.apps.runtime.SwanApp r7 = r9.mSwanApp
            if (r7 == 0) goto L_0x00b6
            java.lang.String r3 = r7.getName()
        L_0x00b6:
            if (r3 != 0) goto L_0x00bb
            java.lang.String r3 = ""
            goto L_0x00ab
        L_0x00bb:
            java.lang.String r7 = "mSwanApp?.name?: \"\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            goto L_0x00ab
        L_0x00c2:
            r5.setText(r3)
            int r3 = com.baidu.swan.apps.ui.R.dimen.swanapp_scope_app_name
            float r7 = r9.mTargetRadio
            com.baidu.swan.utils.fontsize.FontSizeTextViewExtKt.setScaledSizeRes(r5, r3, r7)
        L_0x00ce:
            int r3 = com.baidu.swan.apps.ui.R.id.swan_app_action_text
            android.view.View r3 = r10.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x00df
            int r5 = com.baidu.swan.apps.ui.R.dimen.swanapp_scope_swan_app_action_text
            float r6 = r9.mTargetRadio
            com.baidu.swan.utils.fontsize.FontSizeTextViewExtKt.setScaledSizeRes(r3, r5, r6)
        L_0x00df:
            int r5 = com.baidu.swan.apps.ui.R.id.permission_name
            android.view.View r5 = r10.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r9.mAuthNameView = r5
            if (r5 == 0) goto L_0x0109
            r6 = 0
            int r7 = com.baidu.swan.apps.ui.R.dimen.swanapp_scope_permission_name
            float r8 = r9.mTargetRadio
            com.baidu.swan.utils.fontsize.FontSizeTextViewExtKt.setScaledSizeRes(r5, r7, r8)
            java.lang.String r7 = r12.name
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r5.setText(r7)
            r5.setHighlightColor(r2)
            android.text.method.MovementMethod r7 = android.text.method.LinkMovementMethod.getInstance()
            r5.setMovementMethod(r7)
            r5.setLongClickable(r2)
        L_0x0109:
            int r2 = com.baidu.swan.apps.ui.R.id.auth_negative_button
            android.view.View r2 = r10.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r5 = com.baidu.swan.apps.ui.R.id.auth_positive_button
            android.view.View r5 = r10.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r9.mPosButton = r5
            if (r2 == 0) goto L_0x0122
            float r5 = r9.mTargetRadio
            com.baidu.swan.utils.fontsize.FontSizeTextViewExtKt.setScaledSize(r2, r5)
        L_0x0122:
            android.widget.TextView r5 = r9.mPosButton
            if (r5 == 0) goto L_0x012b
            float r6 = r9.mTargetRadio
            com.baidu.swan.utils.fontsize.FontSizeTextViewExtKt.setScaledSize(r5, r6)
        L_0x012b:
            com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog$Builder r5 = r9.mAuthDialogBuilder
            if (r5 == 0) goto L_0x0138
            r6 = r2
            android.view.View r6 = (android.view.View) r6
            r7 = -2
            android.content.DialogInterface$OnClickListener r8 = r9.mDialogClickListener
            r5.setButtonListener(r6, r7, r8)
        L_0x0138:
            r5 = -1
            r9.setPosButtonListener(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.setting.oauth.view.AbstractSwanAppAuthDialogMaker.initBaseView(android.view.View, android.content.Context, com.baidu.swan.apps.setting.oauth.ScopeInfo):void");
    }

    public void initScopeExplain(View rootView, Context context, ScopeInfo scopeInfo) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scopeInfo, "scopeInfo");
        if (!TextUtils.isEmpty(scopeInfo.explain)) {
            RelativeLayout layout = getExplainView(rootView, context, scopeInfo);
            ViewGroup parent = (ViewGroup) rootView.findViewById(R.id.swan_app_info_layout);
            if (parent != null) {
                parent.addView(layout, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    private final RelativeLayout getExplainView(View rootView, Context context, ScopeInfo scopeInfo) {
        int width = context.getResources().getDimensionPixelSize(R.dimen.swan_auth_explain_image_height);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, width);
        params.addRule(11);
        params.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.swan_auth_explain_image_marginright);
        ImageView explainImg = new ImageView(context);
        explainImg.setImageDrawable(context.getDrawable(R.drawable.swanapp_auth_explain_image));
        explainImg.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FontSizeImageViewExtKt.setScaledImage(explainImg, this.mTargetRadio);
        explainImg.setOnClickListener(new AbstractSwanAppAuthDialogMaker$$ExternalSyntheticLambda2(this, rootView, context, scopeInfo));
        RelativeLayout layout = new RelativeLayout(context);
        layout.addView(explainImg, params);
        return layout;
    }

    /* access modifiers changed from: private */
    /* renamed from: getExplainView$lambda-5  reason: not valid java name */
    public static final void m8063getExplainView$lambda5(AbstractSwanAppAuthDialogMaker this$0, View $rootView, Context $context, ScopeInfo $scopeInfo, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($rootView, "$rootView");
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter($scopeInfo, "$scopeInfo");
        this$0.showExplainSplitView($rootView, $context, $scopeInfo);
    }

    private final void showExplainSplitView(View rootView, Context context, ScopeInfo scopeInfo) {
        LinearLayout detailLayout = (LinearLayout) rootView.findViewById(R.id.permission_detail_layout);
        if (detailLayout != null) {
            detailLayout.setVisibility(8);
        }
        int height = rootView.getMeasuredHeight();
        if (!this.mIsExplainShowing.getAndSet(true)) {
            this.mExplainDialogMaker.showExplainDialog(context, scopeInfo, height, this.mExplainDialogShowCallback);
        }
    }

    public final void setSubExplainInfoForLayout(TextView authFunction, ScopeInfo scopeInfo) {
        Map map;
        if (scopeInfo != null && authFunction != null) {
            if (TextUtils.equals(scopeInfo.id, "mapp_location")) {
                SwanAppConfigData configData = SwanAppController.getInstance().getConfigData();
                if (!((configData != null ? configData.mPermissionConfig : null) == null || (map = configData.mPermissionConfig.permission.get(SCOPE_USER_LOCATION_KEY)) == null)) {
                    String explain = (String) map.get("desc");
                    CharSequence charSequence = explain;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        scopeInfo.subExplain = explain;
                    }
                }
            }
            authFunction.setText(scopeInfo.subExplain);
            authFunction.setVisibility(0);
            FontSizeTextViewExtKt.setScaledSize(authFunction, this.mTargetRadio);
        }
    }

    /* access modifiers changed from: private */
    public final void startScopeDetailActivity(String url) {
        Activity activity;
        ISwanFrameContainer frameContainer = Swan.get().getSwanFrameContainer();
        if (frameContainer != null && (activity = Swan.get().getActivity()) != null) {
            ActivityResultDispatcher dispatcher = frameContainer.getResultDispatcher();
            Intrinsics.checkNotNullExpressionValue(dispatcher, "frameContainer.resultDispatcher");
            Intent intent = new Intent(activity, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", url);
            dispatcher.addConsumer(new AbstractSwanAppAuthDialogMaker$$ExternalSyntheticLambda0());
            SwanAppController.getInstance().requestCollectionPolicyStopFlag();
            dispatcher.startActivityForResult(intent);
            activity.overridePendingTransition(R.anim.aiapps_slide_in_from_right, R.anim.aiapps_hold);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startScopeDetailActivity$lambda-6  reason: not valid java name */
    public static final boolean m8064startScopeDetailActivity$lambda6(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
        SwanAppController.getInstance().requestCollectionPolicyContinueFlag();
        return true;
    }

    public final SpannableString createSpanText(String keyword, String detailUrl, String keywordColor, int from, int end) {
        CharSequence charSequence = keyword;
        if (charSequence == null || charSequence.length() == 0) {
            return new SpannableString("");
        }
        return createSpanText(new SpannableString(keyword), detailUrl, keywordColor, from, end);
    }

    public final SpannableString createSpanText(SpannableString spannableText, String detailUrl, String keywordColor, int from, int end) {
        Intrinsics.checkNotNullParameter(spannableText, "spannableText");
        CharSequence charSequence = detailUrl;
        if (charSequence == null || charSequence.length() == 0) {
            return spannableText;
        }
        spannableText.setSpan(new AbstractSwanAppAuthDialogMaker$createSpanText$clickableSpan$1(this, detailUrl, keywordColor), from, end, 33);
        return spannableText;
    }

    public final boolean getPosButtonState() {
        TextView textView = this.mPosButton;
        if (textView != null) {
            return textView.isEnabled();
        }
        return false;
    }

    public final void setPosButtonState(boolean state) {
        TextView textView = this.mPosButton;
        if (textView != null) {
            textView.setEnabled(state);
        }
    }

    public final void setPosButtonListener(int type) {
        SwanAppAlertDialog.Builder builder = this.mAuthDialogBuilder;
        if (builder != null) {
            builder.setButtonListener(this.mPosButton, type, this.mDialogClickListener);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/swan/apps/setting/oauth/view/AbstractSwanAppAuthDialogMaker$Companion;", "", "()V", "AUTH_THIRD_PHONE_NUMBER", "", "DEBUG", "", "getDEBUG", "()Z", "DESC_KEY", "", "SCOPE_USER_LOCATION_KEY", "TAG", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbstractSwanAppAuthDialogMaker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getDEBUG() {
            return AbstractSwanAppAuthDialogMaker.DEBUG;
        }
    }
}
