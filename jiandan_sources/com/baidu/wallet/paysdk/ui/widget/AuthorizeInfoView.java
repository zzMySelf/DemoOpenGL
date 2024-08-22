package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import org.apache.commons.lang3.StringUtils;

public class AuthorizeInfoView extends LinearLayout {
    public NetImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public String g = "";
    public String h = "";

    public static class a {

        /* renamed from: com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView$a$a  reason: collision with other inner class name */
        public static class C0169a {
            public static a a = new a();
        }

        public static a a() {
            return C0169a.a;
        }

        public a() {
        }

        public b a(int i2, AuthorizeInfoView authorizeInfoView) {
            if (i2 != 1) {
                return null;
            }
            return new com.baidu.wallet.paysdk.ui.widget.a.a(authorizeInfoView);
        }
    }

    public static abstract class b {
        public AuthorizeInfoView a;

        public b(AuthorizeInfoView authorizeInfoView) {
            this.a = authorizeInfoView;
        }

        public abstract void a(Object obj);
    }

    public AuthorizeInfoView(Context context) {
        super(context);
        a();
    }

    public void refreshView() {
        Authorize authorize;
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null && (authorize = payResponse.authorize) != null) {
            this.a.setImageUrl(authorize.sp_logo_url);
            this.b.setText(authorize.sp_company_title);
            setTips(authorize.authorize_action_desc);
            String[] strArr = authorize.authorize_desc;
            int i2 = 0;
            if (strArr != null && strArr.length > 0) {
                this.d.setText(strArr[0]);
            }
            UserData.UserModel userModel = payResponse.user;
            if (userModel != null) {
                this.f.setText(userModel.authorize_display_name);
            }
            Authorize.AuthDetailInfo authDetailInfo = authorize.detail_info;
            if (authDetailInfo != null) {
                if (!TextUtils.isEmpty(authDetailInfo.introduce)) {
                    this.h += authorize.detail_info.introduce + StringUtils.LF;
                }
                while (true) {
                    String[] strArr2 = authorize.detail_info.detail;
                    if (i2 < strArr2.length) {
                        if (!TextUtils.isEmpty(strArr2[i2])) {
                            this.h += "\n· " + authorize.detail_info.detail[i2];
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setAmount(String str) {
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDesc(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setLogo(String str) {
        NetImageView netImageView = this.a;
        if (netImageView != null) {
            netImageView.setImageUrl(str);
        }
    }

    public void setPhone(String str) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTipMessage(String str) {
        this.h = str;
    }

    public void setTips(String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
        this.g = str;
    }

    public void setTitle(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_authorize_info_view"), this);
        this.a = (NetImageView) findViewById(ResUtils.id(getContext(), "ni_sp_logo"));
        this.b = (TextView) findViewById(ResUtils.id(getContext(), "tv_sp_name"));
        this.c = (TextView) findViewById(ResUtils.id(getContext(), "tv_sp_action"));
        this.d = (TextView) findViewById(ResUtils.id(getContext(), "tv_auth_desc"));
        this.e = (TextView) findViewById(ResUtils.id(getContext(), "tv_amount_tips"));
        this.f = (TextView) findViewById(ResUtils.id(getContext(), "tv_amount_phone"));
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TextUtils.isEmpty(AuthorizeInfoView.this.h)) {
                    PromptTipDialog promptTipDialog = new PromptTipDialog(AuthorizeInfoView.this.getContext());
                    promptTipDialog.setTitleMessage(AuthorizeInfoView.this.g);
                    promptTipDialog.setMessage(AuthorizeInfoView.this.h);
                    promptTipDialog.setButtonMessage(ResUtils.getString(AuthorizeInfoView.this.getContext(), "dxm_ebpay_know"));
                    promptTipDialog.show();
                }
            }
        });
    }

    public AuthorizeInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public AuthorizeInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
