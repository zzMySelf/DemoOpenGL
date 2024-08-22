package com.baidu.growthsystem.wealth.exit;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.checkbox.BdCheckBox;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.common.operation.CommonOperationModel;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.appframework.ActionToolBarActivity;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.toolbar.BaseToolBarItem;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.ubc.UBCManager;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0010J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/growthsystem/wealth/exit/WealthTaskShowSettingActivity;", "Lcom/baidu/searchbox/appframework/ActionToolBarActivity;", "()V", "UBC_ID", "", "accountService", "Lcom/baidu/searchbox/account/BoxAccountManager;", "mCheckBox", "Lcom/baidu/android/ext/widget/checkbox/BdCheckBox;", "mImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mRoot", "Landroid/widget/RelativeLayout;", "mText", "Landroid/widget/TextView;", "clickUbcEvent", "", "type", "value", "enterUbcEvent", "getToolBarItemList", "", "Lcom/baidu/searchbox/toolbar/BaseToolBarItem;", "initActionBar", "initTheme", "isNightMode", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNightModeChanged", "onToolBarItemClick", "view", "Landroid/view/View;", "toolBarItem", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthTaskShowSettingActivity.kt */
public final class WealthTaskShowSettingActivity extends ActionToolBarActivity {
    private final String UBC_ID = "534";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private BoxAccountManager accountService = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE));
    private BdCheckBox mCheckBox;
    private SimpleDraweeView mImage;
    private RelativeLayout mRoot;
    private TextView mText;

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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        BaseActivity.setNextPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        super.onCreate(savedInstanceState);
        setEnableSliding(true);
        setContentView(com.baidu.growthsystem.business.wealthtask.R.layout.bd_wealth_task_show_setting);
        initView();
        initActionBar();
        enterUbcEvent();
    }

    public final void initView() {
        View findViewById = findViewById(com.baidu.growthsystem.business.wealthtask.R.id.bd_wealth_task_show_setting_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.bd_wea…h_task_show_setting_root)");
        this.mRoot = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(com.baidu.growthsystem.business.wealthtask.R.id.bd_wealth_task_show_setting_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.bd_wea…h_task_show_setting_text)");
        this.mText = (TextView) findViewById2;
        View findViewById3 = findViewById(com.baidu.growthsystem.business.wealthtask.R.id.bd_wealth_task_show_setting_img);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.bd_wealth_task_show_setting_img)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById3;
        this.mImage = simpleDraweeView;
        BdCheckBox bdCheckBox = null;
        if (simpleDraweeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImage");
            simpleDraweeView = null;
        }
        simpleDraweeView.setImageURI("https://b.bdstatic.com/searchbox/image/gcp/20230927/2747941179.png");
        View findViewById4 = findViewById(com.baidu.growthsystem.business.wealthtask.R.id.bd_wealth_task_show_setting_checkbox);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.bd_wea…sk_show_setting_checkbox)");
        this.mCheckBox = (BdCheckBox) findViewById4;
        int width = DeviceUtil.ScreenInfo.getDisplayWidth(getExtContext());
        DeviceUtil.ScreenInfo.dp2px(getExtContext(), 25.0f);
        RelativeLayout.LayoutParams layoutParam = new RelativeLayout.LayoutParams(width, width / 3);
        layoutParam.leftMargin = DeviceUtil.ScreenInfo.dp2px(getExtContext(), 15.0f);
        layoutParam.rightMargin = DeviceUtil.ScreenInfo.dp2px(getExtContext(), 10.0f);
        layoutParam.addRule(3, com.baidu.growthsystem.business.wealthtask.R.id.bd_wealth_task_show_setting_rl);
        SimpleDraweeView simpleDraweeView2 = this.mImage;
        if (simpleDraweeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImage");
            simpleDraweeView2 = null;
        }
        simpleDraweeView2.setLayoutParams(layoutParam);
        BdCheckBox bdCheckBox2 = this.mCheckBox;
        if (bdCheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            bdCheckBox2 = null;
        }
        bdCheckBox2.setChecked(!WealthTaskExitManager.INSTANCE.isWealthTaskExit());
        BdCheckBox bdCheckBox3 = this.mCheckBox;
        if (bdCheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
        } else {
            bdCheckBox = bdCheckBox3;
        }
        bdCheckBox.setOnCheckedChangeListener(new WealthTaskShowSettingActivity$$ExternalSyntheticLambda0(this));
        initTheme(NightModeHelper.getNightModeSwitcherState());
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m13670initView$lambda0(WealthTaskShowSettingActivity this$0, CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String type = isChecked ? "task_open_click" : "task_close_click";
        BoxAccountManager boxAccountManager = this$0.accountService;
        boolean z = true;
        if (boxAccountManager == null || !boxAccountManager.isLogin(0)) {
            z = false;
        }
        this$0.clickUbcEvent(type, z ? "login" : "unlogin");
        WealthTaskExitManager.INSTANCE.setWealthTaskExit(!isChecked);
    }

    private final void initActionBar() {
        BdActionBar actionBar = ActionBarExtKt.getBdActionBar(this);
        if (actionBar != null) {
            actionBar.setTitle(getResources().getString(com.baidu.growthsystem.business.wealthtask.R.string.setting_title_wealth_task_title));
            actionBar.setLeftZonesVisibility(8);
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        initTheme(isNightMode);
    }

    public final void initTheme(boolean isNightMode) {
        TextView textView = null;
        if (isNightMode) {
            RelativeLayout relativeLayout = this.mRoot;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRoot");
                relativeLayout = null;
            }
            relativeLayout.setBackgroundColor(Color.parseColor("#F21F1F1F"));
            TextView textView2 = this.mText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mText");
            } else {
                textView = textView2;
            }
            textView.setTextColor(Color.parseColor("#666666"));
            return;
        }
        RelativeLayout relativeLayout2 = this.mRoot;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            relativeLayout2 = null;
        }
        relativeLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        TextView textView3 = this.mText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mText");
        } else {
            textView = textView3;
        }
        textView.setTextColor(Color.parseColor(CommonOperationModel.BOTTOM_BAR_TEXT_DEFAULT_DAY_COLOR));
    }

    public final void enterUbcEvent() {
        try {
            JSONObject data = new JSONObject();
            JSONObject $this$enterUbcEvent_u24lambda_u2d2 = data;
            $this$enterUbcEvent_u24lambda_u2d2.put("from", "tool");
            $this$enterUbcEvent_u24lambda_u2d2.put("type", "enter");
            $this$enterUbcEvent_u24lambda_u2d2.put("value", "task_settings");
            $this$enterUbcEvent_u24lambda_u2d2.put("page", "piggybank_close_set");
            $this$enterUbcEvent_u24lambda_u2d2.put("source", "duoduo_video_task");
            Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
            ((UBCManager) service).onEvent(this.UBC_ID, data);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void clickUbcEvent(String type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            JSONObject data = new JSONObject();
            JSONObject $this$clickUbcEvent_u24lambda_u2d3 = data;
            $this$clickUbcEvent_u24lambda_u2d3.put("from", "tool");
            $this$clickUbcEvent_u24lambda_u2d3.put("type", type);
            $this$clickUbcEvent_u24lambda_u2d3.put("value", value);
            $this$clickUbcEvent_u24lambda_u2d3.put("page", "piggybank_close_set");
            $this$clickUbcEvent_u24lambda_u2d3.put("source", "duoduo_video_task");
            Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
            ((UBCManager) service).onEvent(this.UBC_ID, data);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public List<BaseToolBarItem> getToolBarItemList() {
        ArrayList toolBarItemList = new ArrayList();
        toolBarItemList.add(new BaseToolBarItem(1));
        return toolBarItemList;
    }

    public boolean onToolBarItemClick(View view2, BaseToolBarItem toolBarItem) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(toolBarItem, "toolBarItem");
        if (1 != toolBarItem.getItemId()) {
            return false;
        }
        finish();
        return true;
    }
}
