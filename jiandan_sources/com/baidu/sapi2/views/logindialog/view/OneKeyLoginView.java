package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;

public class OneKeyLoginView extends LinearLayout {
    public Context a;
    public TextView b;
    public TextView c;
    public ILoginConfirmCallback d;
    public String e;

    public class a implements View.OnClickListener {

        /* renamed from: com.baidu.sapi2.views.logindialog.view.OneKeyLoginView$a$a  reason: collision with other inner class name */
        public class C0043a implements Runnable {

            /* renamed from: com.baidu.sapi2.views.logindialog.view.OneKeyLoginView$a$a$a  reason: collision with other inner class name */
            public class C0044a extends OneKeyLoginCallback {
                public final /* synthetic */ long a;

                public C0044a(long j) {
                    this.a = j;
                }

                public void onFail(OneKeyLoginResult oneKeyLoginResult) {
                    super.onFail(oneKeyLoginResult);
                    if (OneKeyLoginView.this.d != null) {
                        if (TextUtils.isEmpty(OneKeyLoginView.this.e)) {
                            com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login", System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                        } else {
                            com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login_" + OneKeyLoginView.this.e.toLowerCase(), System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                        }
                        QuickLoginResult quickLoginResult = new QuickLoginResult();
                        quickLoginResult.setResultCode(oneKeyLoginResult.getResultCode());
                        quickLoginResult.setResultMsg(oneKeyLoginResult.getResultMsg());
                        quickLoginResult.mLoginType = QuickLoginType.ONEKEY;
                        OneKeyLoginView.this.d.onFailure(quickLoginResult);
                    }
                }

                public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
                    super.onSuccess(oneKeyLoginResult);
                    if (OneKeyLoginView.this.d != null && oneKeyLoginResult != null) {
                        if (TextUtils.isEmpty(OneKeyLoginView.this.e)) {
                            com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login", System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                        } else {
                            com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login_" + OneKeyLoginView.this.e.toLowerCase(), System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                        }
                        QuickLoginResult quickLoginResult = new QuickLoginResult();
                        quickLoginResult.setResultCode(oneKeyLoginResult.getResultCode());
                        quickLoginResult.setResultMsg(oneKeyLoginResult.getResultMsg());
                        quickLoginResult.mLoginType = QuickLoginType.ONEKEY;
                        quickLoginResult.mOperator = OneKeyLoginView.this.e;
                        OneKeyLoginView.this.d.onSuccess(quickLoginResult);
                    }
                }
            }

            public C0043a() {
            }

            public void run() {
                CoreViewRouter.getInstance().loadOneKeyLogin(OneKeyLoginView.this.a, new C0044a(System.currentTimeMillis()));
            }
        }

        public a() {
        }

        public void onClick(View view) {
            if (OneKeyLoginView.this.a != null && OneKeyLoginView.this.d != null) {
                OneKeyLoginView.this.d.onPostLogin(true, new C0043a());
            }
        }
    }

    public OneKeyLoginView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextView getTvButton() {
        return this.c;
    }

    public OneKeyLoginView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_onekey, this);
        setOrientation(1);
        this.b = (TextView) findViewById(R.id.sapi_sdk_tv_onekey_number);
        TextView textView = (TextView) findViewById(R.id.sapi_sdk_tv_onekey_button);
        this.c = textView;
        textView.setOnClickListener(new a());
    }

    public void a(String str, String str2, ILoginConfirmCallback iLoginConfirmCallback) {
        this.b.setText(str);
        this.d = iLoginConfirmCallback;
        this.e = str2;
    }

    public OneKeyLoginView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
        b();
    }

    public void a() {
        this.b.setTextColor(Color.parseColor("#CCFFFFFF"));
    }
}
