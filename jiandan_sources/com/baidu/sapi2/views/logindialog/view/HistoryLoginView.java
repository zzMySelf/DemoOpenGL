package com.baidu.sapi2.views.logindialog.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;

public class HistoryLoginView extends RelativeLayout {
    public static final String j = "quick_login";
    public Context a;
    public Activity b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public LoginHistoryModel h;

    /* renamed from: i  reason: collision with root package name */
    public ILoginConfirmCallback f984i;

    public class a implements AsyncImageLoader.IAsyncImageLoaderListener {
        public a() {
        }

        public void onComplete(Bitmap bitmap) {
            HistoryLoginView.this.d.setImageBitmap(bitmap);
        }
    }

    public HistoryLoginView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextView getTvButton() {
        return this.g;
    }

    public HistoryLoginView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_history, this);
        this.c = findViewById(R.id.sapi_sdk_view_history_login_shade);
        this.d = (ImageView) findViewById(R.id.sapi_sdk_civ_history_portrait);
        this.e = (TextView) findViewById(R.id.sapi_sdk_civ_history_displayname);
        this.f = (TextView) findViewById(R.id.sapi_sdk_civ_history_subtitle);
        this.g = (TextView) findViewById(R.id.sapi_sdk_tv_history_button);
        AnonymousClass1 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                if (HistoryLoginView.this.b != null && HistoryLoginView.this.h != null && HistoryLoginView.this.f984i != null) {
                    HistoryLoginView.this.f984i.onPostLogin(false, new Runnable() {
                        public void run() {
                            final long currentTimeMillis = System.currentTimeMillis();
                            SapiAccountManager.getInstance().loadHistoryActionLoginFromNa(HistoryLoginView.this.h, new LoginHistoryCallback() {
                                public void onLoginFailure() {
                                    if (HistoryLoginView.this.f984i != null) {
                                        com.baidu.sapi2.views.logindialog.utils.a.a("history_login", System.currentTimeMillis() - currentTimeMillis, 1, "失败");
                                        QuickLoginResult quickLoginResult = new QuickLoginResult();
                                        quickLoginResult.setResultCode(-202);
                                        quickLoginResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                                        quickLoginResult.mLoginType = QuickLoginType.HISTORY;
                                        HistoryLoginView.this.f984i.onFailure(quickLoginResult);
                                    }
                                }

                                public void onLoginSuccess(SapiAccount sapiAccount) {
                                    if (HistoryLoginView.this.f984i != null) {
                                        com.baidu.sapi2.views.logindialog.utils.a.a("history_login", System.currentTimeMillis() - currentTimeMillis, 0, "成功");
                                        QuickLoginResult quickLoginResult = new QuickLoginResult();
                                        quickLoginResult.setResultCode(0);
                                        quickLoginResult.setResultMsg("成功");
                                        quickLoginResult.mLoginType = QuickLoginType.HISTORY;
                                        HistoryLoginView.this.f984i.onSuccess(quickLoginResult);
                                    }
                                }
                            });
                        }
                    });
                }
            }
        };
        this.c.setOnClickListener(r0);
        this.g.setOnClickListener(r0);
    }

    private void c() {
        if (this.h != null && this.a != null) {
            ImageManager.getInstance().loadImage(this.a, Uri.parse(this.h.portrait), new a());
            this.e.setText(this.h.displayname);
            this.f.setText("最近登录账号，可一键登录");
        }
    }

    public void a(Activity activity, LoginHistoryModel loginHistoryModel, ILoginConfirmCallback iLoginConfirmCallback) {
        this.b = activity;
        this.h = loginHistoryModel;
        this.f984i = iLoginConfirmCallback;
        c();
    }

    public HistoryLoginView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
        b();
    }

    public void a() {
        this.e.setTextColor(Color.parseColor("#CCFFFFFF"));
        this.f.setTextColor(Color.parseColor("#80FFFFFF"));
        this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_quick_login_dialog_share_bg_dark));
    }
}
