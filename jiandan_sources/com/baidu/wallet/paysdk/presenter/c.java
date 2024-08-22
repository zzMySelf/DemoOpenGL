package com.baidu.wallet.paysdk.presenter;

import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;

public class c extends a {
    public c(AuthorizeSignActivity authorizeSignActivity) {
        super(authorizeSignActivity);
        this.b = 3;
    }

    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.b = 3;
        } else {
            this.b = 4;
        }
    }

    public void b() {
        super.b();
        AuthorizeSignActivity authorizeSignActivity = this.a;
        if (authorizeSignActivity != null) {
            AuthorizeInfoView.b authInfoViewAdapter = authorizeSignActivity.getAuthInfoViewAdapter(1);
            DirectPayContentResponse payResponse = this.a.getPayResponse();
            if (payResponse != null) {
                authInfoViewAdapter.a(payResponse.authorize);
                authInfoViewAdapter.a(payResponse.user);
                Authorize authorize = payResponse.authorize;
                if (authorize != null) {
                    this.a.initActionBarByString(authorize.top_title);
                }
            }
        }
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return true;
    }
}
