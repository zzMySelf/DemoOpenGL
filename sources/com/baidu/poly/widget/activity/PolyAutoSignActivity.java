package com.baidu.poly.widget.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.poly.a.l.a;
import com.baidu.poly.util.param.PolyParam;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.poly.widget.autosign.AutoSignChannelListView;
import com.baidu.swan.apps.util.SwanActivityTaskManager;

/* compiled from: SearchBox */
public class PolyAutoSignActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private IChannelAuth f17307a;

    /* renamed from: b  reason: collision with root package name */
    private PolyParam f17308b;

    /* renamed from: c  reason: collision with root package name */
    private AutoSignChannelListView f17309c;

    /* renamed from: d  reason: collision with root package name */
    private int f17310d;

    public static Intent a(Activity activity, PolyParam polyParam, IChannelAuth iChannelAuth) {
        Intent intent = new Intent(activity, PolyAutoSignActivity.class);
        intent.putExtra("key_bundle", polyParam);
        intent.putExtra("key_auth_channel", iChannelAuth);
        intent.putExtra(SwanActivityTaskManager.KEY_TASK_ID, activity.getTaskId());
        return intent;
    }

    private void b() {
        AutoSignChannelListView autoSignChannelListView = new AutoSignChannelListView(this);
        this.f17309c = autoSignChannelListView;
        autoSignChannelListView.setChannelAuth(this.f17307a);
        setContentView(this.f17309c);
        String string = this.f17308b.getUserParams().getString("panelType", "");
        String string2 = this.f17308b.getUserParams().getString("chosenChannel", "");
        this.f17309c.setTaskId(this.f17310d);
        if (!TextUtils.equals(string, "NONE") || TextUtils.isEmpty(string2)) {
            this.f17309c.setPanelType(PolyActivity.HALF_PANEL_TYPE);
            this.f17309c.a(this.f17308b);
            this.f17309c.m();
            return;
        }
        this.f17309c.setPanelType("NONE");
        this.f17309c.a(this.f17308b, string2);
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a.a(getApplicationContext());
        super.onCreate(bundle);
        a();
        b();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        AutoSignChannelListView autoSignChannelListView = this.f17309c;
        if (autoSignChannelListView != null) {
            autoSignChannelListView.j();
        }
    }

    private void a() {
        Intent intent = getIntent();
        this.f17308b = (PolyParam) intent.getParcelableExtra("key_bundle");
        this.f17307a = (IChannelAuth) intent.getSerializableExtra("key_auth_channel");
        this.f17310d = intent.getIntExtra(SwanActivityTaskManager.KEY_TASK_ID, -1);
    }
}
