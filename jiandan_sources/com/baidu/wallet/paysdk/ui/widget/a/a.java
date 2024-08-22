package com.baidu.wallet.paysdk.ui.widget.a;

import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
import com.dxmpay.wallet.base.datamodel.UserData;
import org.apache.commons.lang3.StringUtils;

public class a extends AuthorizeInfoView.b {
    public a(AuthorizeInfoView authorizeInfoView) {
        super(authorizeInfoView);
    }

    public void a(Object obj) {
        if (obj != null) {
            if (obj instanceof Authorize) {
                Authorize authorize = (Authorize) obj;
                this.a.setLogo(authorize.sp_logo_url);
                this.a.setTitle(authorize.sp_company_title);
                this.a.setTips(authorize.authorize_action_desc);
                String[] strArr = authorize.authorize_desc;
                int i2 = 0;
                if (strArr != null && strArr.length > 0) {
                    this.a.setDesc(strArr[0]);
                }
                if (authorize.detail_info != null) {
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(authorize.detail_info.introduce)) {
                        sb.append(authorize.detail_info.introduce);
                        sb.append(StringUtils.LF);
                    }
                    while (true) {
                        String[] strArr2 = authorize.detail_info.detail;
                        if (i2 < strArr2.length) {
                            if (!TextUtils.isEmpty(strArr2[i2])) {
                                sb.append("\n· ");
                                sb.append(authorize.detail_info.detail[i2]);
                            }
                            i2++;
                        } else {
                            this.a.setTipMessage(sb.toString());
                            return;
                        }
                    }
                }
            } else if (obj instanceof UserData.UserModel) {
                this.a.setPhone(((UserData.UserModel) obj).authorize_display_name);
            }
        }
    }
}
