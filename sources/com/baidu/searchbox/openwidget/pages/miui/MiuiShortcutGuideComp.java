package com.baidu.searchbox.openwidget.pages.miui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.openwidget.ability_impl.R;
import com.baidu.searchbox.openwidget.pin.utils.MiuiCompatKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0003R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/openwidget/pages/miui/MiuiShortcutGuideComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;)V", "buttonClose", "kotlin.jvm.PlatformType", "buttonSettings", "hasStartSettings", "", "shortcutGuideCallback", "Lcom/baidu/searchbox/openwidget/pages/miui/ShortcutGuideCallback;", "getShortcutGuideCallback", "()Lcom/baidu/searchbox/openwidget/pages/miui/ShortcutGuideCallback;", "setShortcutGuideCallback", "(Lcom/baidu/searchbox/openwidget/pages/miui/ShortcutGuideCallback;)V", "canResolveActivity", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onBindViewModel", "", "viewModel", "onCreate", "onCreateViewModel", "onResume", "startShortcutSettings", "activity", "Landroid/app/Activity;", "lib-openwidget-ability-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiuiShortcutGuideComp.kt */
public final class MiuiShortcutGuideComp extends BaseExtSlaveComponent<BaseViewModel> {
    private final View buttonClose;
    private final View buttonSettings;
    private boolean hasStartSettings;
    private ShortcutGuideCallback shortcutGuideCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MiuiShortcutGuideComp(LifecycleOwner owner, View view2) {
        super(owner, view2);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.buttonSettings = view2.findViewById(R.id.btn_settings);
        this.buttonClose = view2.findViewById(R.id.btn_close);
    }

    public final ShortcutGuideCallback getShortcutGuideCallback() {
        return this.shortcutGuideCallback;
    }

    public final void setShortcutGuideCallback(ShortcutGuideCallback shortcutGuideCallback2) {
        this.shortcutGuideCallback = shortcutGuideCallback2;
    }

    public void onCreate() {
        super.onCreate();
        this.buttonSettings.setOnClickListener(new MiuiShortcutGuideComp$$ExternalSyntheticLambda0(this));
        this.buttonClose.setOnClickListener(new MiuiShortcutGuideComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m1825onCreate$lambda1(MiuiShortcutGuideComp this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Activity $this$onCreate_u24lambda_u2d1_u24lambda_u2d0 = context instanceof Activity ? (Activity) context : null;
        if ($this$onCreate_u24lambda_u2d1_u24lambda_u2d0 != null) {
            this$0.startShortcutSettings($this$onCreate_u24lambda_u2d1_u24lambda_u2d0);
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.content.Context] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1826onCreate$lambda2(com.baidu.searchbox.openwidget.pages.miui.MiuiShortcutGuideComp r4, android.view.View r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.baidu.searchbox.openwidget.pages.miui.ShortcutGuideCallback r0 = r4.shortcutGuideCallback
            r1 = 0
            if (r0 == 0) goto L_0x0011
            r2 = 2
            java.lang.String r3 = "click_close"
            com.baidu.searchbox.openwidget.pages.miui.ShortcutGuideCallback.DefaultImpls.onDenyShortcut$default(r0, r3, r1, r2, r1)
        L_0x0011:
            android.content.Context r0 = r4.getContext()
            boolean r2 = r0 instanceof android.app.Activity
            if (r2 == 0) goto L_0x001c
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
        L_0x001c:
            if (r1 == 0) goto L_0x0021
            r1.finish()
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.openwidget.pages.miui.MiuiShortcutGuideComp.m1826onCreate$lambda2(com.baidu.searchbox.openwidget.pages.miui.MiuiShortcutGuideComp, android.view.View):void");
    }

    private final void startShortcutSettings(Activity activity) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            MiuiShortcutGuideComp $this$startShortcutSettings_u24lambda_u2d3 = this;
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.putExtra("extra_pkgname", $this$startShortcutSettings_u24lambda_u2d3.getContext().getPackageName());
            Context context = $this$startShortcutSettings_u24lambda_u2d3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if ($this$startShortcutSettings_u24lambda_u2d3.canResolveActivity(context, intent)) {
                activity.startActivityForResult(intent, 2000);
                $this$startShortcutSettings_u24lambda_u2d3.hasStartSettings = true;
            } else {
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                Context context2 = $this$startShortcutSettings_u24lambda_u2d3.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                if ($this$startShortcutSettings_u24lambda_u2d3.canResolveActivity(context2, intent)) {
                    activity.startActivityForResult(intent, 2000);
                    $this$startShortcutSettings_u24lambda_u2d3.hasStartSettings = true;
                } else {
                    intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                    Context context3 = $this$startShortcutSettings_u24lambda_u2d3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    if ($this$startShortcutSettings_u24lambda_u2d3.canResolveActivity(context3, intent)) {
                        activity.startActivityForResult(intent, 2000);
                        $this$startShortcutSettings_u24lambda_u2d3.hasStartSettings = true;
                    } else {
                        new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", $this$startShortcutSettings_u24lambda_u2d3.getContext().getPackageName(), (String) null));
                        activity.startActivityForResult(intent, 2000);
                        $this$startShortcutSettings_u24lambda_u2d3.hasStartSettings = true;
                    }
                }
            }
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null) {
            if (MiuiShortcutGuideCompKt.DEBUG) {
                Log.w("MiuiShortcutGuideComp", "start settings fail, error=" + it);
            }
            ShortcutGuideCallback shortcutGuideCallback2 = this.shortcutGuideCallback;
            if (shortcutGuideCallback2 != null) {
                String message = it.getMessage();
                if (message == null) {
                    message = "";
                }
                shortcutGuideCallback2.onDenyShortcut("start_setting_fail", message);
            }
        }
    }

    private final boolean canResolveActivity(Context context, Intent intent) {
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }

    public void onResume() {
        super.onResume();
        if (this.hasStartSettings) {
            this.hasStartSettings = false;
            int newState = MiuiCompatKt.checkMiuiOpAddShortcut();
            if (newState == 0) {
                ShortcutGuideCallback shortcutGuideCallback2 = this.shortcutGuideCallback;
                if (shortcutGuideCallback2 != null) {
                    shortcutGuideCallback2.onAllowShortcut(newState);
                    return;
                }
                return;
            }
            ShortcutGuideCallback shortcutGuideCallback3 = this.shortcutGuideCallback;
            if (shortcutGuideCallback3 != null) {
                shortcutGuideCallback3.onDenyShortcut("cancel", String.valueOf(newState));
            }
        }
    }

    public BaseViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get("MiuiShortcutGuideComp", BaseViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(\"MiuiShortc…aseViewModel::class.java)");
        return (BaseViewModel) viewModel;
    }

    public void onBindViewModel(BaseViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
    }
}
