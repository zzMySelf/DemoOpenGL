package com.baidu.wallet.paysdk.b;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ab;
import com.baidu.wallet.paysdk.beans.h;
import com.baidu.wallet.paysdk.beans.p;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.a;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.BindCardBaseActivity;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.widget.BankCvv2InfoView;
import com.baidu.wallet.paysdk.ui.widget.BankUserInfoView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;

public class b implements j {
    public p a;
    public h b;
    public ab c;
    public BindCardBaseActivity d;
    public BindFastRequest e;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3595i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3596o = false;
    public boolean p = false;
    public int r = 4;
    public GetCardInfoResponse.CertificateTypeInfo s = null;

    public CharSequence A() {
        String string = ResUtils.getString(this.d, "wallet_base_string_safeguard_entry");
        int indexOf = string.indexOf(ResUtils.getString(this.d, "wallet_base_string_safeguard_click"));
        int length = string.length();
        if (-1 == indexOf) {
            return string;
        }
        AnonymousClass1 r3 = new ClickableSpan() {
            public void onClick(View view) {
                b.this.B();
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ResUtils.getColor(this.d, "dxm_wallet_base_color_clickable"));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(r3, indexOf, length, 17);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, length, 17);
        return spannableStringBuilder;
    }

    public void B() {
        String[] stringArray = ResUtils.getStringArray(this.d, "wallet_base_safeguard_tips");
        if (stringArray != null && 2 <= stringArray.length) {
            String str = stringArray[0];
            StringBuilder sb = new StringBuilder();
            for (int i2 = 1; i2 < stringArray.length - 1; i2++) {
                sb.append(stringArray[i2]);
            }
            String str2 = stringArray[stringArray.length - 1];
            final PromptTipDialog promptTipDialog = new PromptTipDialog(this.d);
            promptTipDialog.setTitleMessage(str);
            promptTipDialog.setMessage(sb.toString());
            promptTipDialog.setButtonMessage(str2);
            promptTipDialog.setDefaultBtnListener(new View.OnClickListener() {
                public void onClick(View view) {
                    promptTipDialog.dismiss();
                }
            });
            promptTipDialog.show();
        }
    }

    public boolean C() {
        return true;
    }

    public String D() {
        return null;
    }

    public boolean E() {
        return true;
    }

    public boolean F() {
        return false;
    }

    public void a() {
    }

    public void a(BindFastRequest bindFastRequest) {
        this.e = bindFastRequest;
    }

    public void a(String... strArr) {
    }

    public void b(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        this.s = certificateTypeInfo;
    }

    public void b(String... strArr) {
    }

    public boolean b() {
        return false;
    }

    public String c() {
        return "";
    }

    public void c(String... strArr) {
        if (this.b == null) {
            this.b = (h) PayBeanFactory.getInstance().getBean((Context) this.d, 5, BindCardBaseActivity.BEAN_TAG);
        }
        this.b.setResponseCallback(this.d);
        StatisticManager.onEvent("callCardCheck");
        b(strArr);
        this.b.a(this.e);
        this.b.execBean();
    }

    public void d(String... strArr) {
        if (this.a == null) {
            this.a = (p) PayBeanFactory.getInstance().getBean((Context) this.d, 4, BindCardBaseActivity.BEAN_TAG);
        }
        this.a.a(this.e);
        this.a.setResponseCallback(this.d);
        a(strArr);
        StatisticManager.onEventStart("getCardInfo");
        this.a.execBean();
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        if (this.a != null) {
            BeanManager.getInstance().removeBean(this.a);
        }
    }

    public boolean g() {
        return !TextUtils.isEmpty(PayDataCache.getInstance().getFormatUserName());
    }

    public String h() {
        return PayDataCache.getInstance().getUserName();
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return this.g;
    }

    public boolean k() {
        return this.f || this.m;
    }

    public boolean l() {
        return this.h || this.l;
    }

    public boolean m() {
        return this.f3595i || this.f3596o;
    }

    public boolean n() {
        return this.j || this.n;
    }

    public void o() {
    }

    public String p() {
        return ResUtils.getString(this.d, "ebpay_card_tip");
    }

    public boolean q() {
        return true;
    }

    public void r() {
        int i2;
        ErrorContentResponse errorContentResponse;
        if ((this instanceof g) || (this instanceof h)) {
            BindFastRequest bindFastRequest = this.e;
            int i3 = 0;
            if (!(bindFastRequest == null || (errorContentResponse = bindFastRequest.mCardInfoUpdateContent) == null)) {
                this.m = errorContentResponse.isNeedValidCode();
                this.l = this.e.mCardInfoUpdateContent.isNeedValidDate();
                this.n = this.e.mCardInfoUpdateContent.isNeedPhoneNum();
                this.f3596o = this.e.mCardInfoUpdateContent.isNeedId();
                this.p = this.e.mCardInfoUpdateContent.isNeedType();
                ErrorContentResponse errorContentResponse2 = this.e.mCardInfoUpdateContent;
                GetCardInfoResponse.CardItemRequired cardItemRequired = errorContentResponse2.card_item_required;
                if (cardItemRequired != null) {
                    this.f = this.f || errorContentResponse2.needUpdate(cardItemRequired.valid_code);
                    this.h = this.h || this.e.mCardInfoUpdateContent.needUpdate(cardItemRequired.valid_date);
                    this.g = this.g || this.e.mCardInfoUpdateContent.needUpdate(cardItemRequired.true_name);
                    this.k = this.k || this.e.mCardInfoUpdateContent.needUpdate(cardItemRequired.certificate_type);
                    this.f3595i = this.f3595i || this.e.mCardInfoUpdateContent.needUpdate(cardItemRequired.certificate_code);
                    this.j = this.j || this.e.mCardInfoUpdateContent.needUpdate(cardItemRequired.mobile);
                }
            }
            BindCardBaseActivity bindCardBaseActivity = this.d;
            if (bindCardBaseActivity != null) {
                if (bindCardBaseActivity.isShowWithHalfScreeen()) {
                    BindCardImplActivity bindCardImplActivity = (BindCardImplActivity) this.d;
                    BankCvv2InfoView bankCvv2InfoView = bindCardImplActivity.mBankCvv2InfoView;
                    BankUserInfoView bankUserInfoView = bindCardImplActivity.mBankUserInfoView;
                    if (this.f) {
                        bankCvv2InfoView.getCvv2InputView().getEditableText().toString();
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (this.h) {
                        i2++;
                        bankCvv2InfoView.getDateInputView().getEditableText().toString();
                    }
                    if (this.f3595i) {
                        i2++;
                        bankUserInfoView.getIdEditText().getEditableText().toString();
                    }
                    if (this.j) {
                        i2++;
                        bankUserInfoView.getMobileEditText().getEditableText().toString();
                    }
                    if (2 < i2 || this.g) {
                        Intent intent = new Intent();
                        if (!this.g) {
                            i3 = i2;
                        }
                        intent.putExtra("halfScreen", i3);
                        intent.putExtra("reasonForChangeCardItem", 2);
                        bindCardImplActivity.updateUiMode(intent);
                    }
                }
                this.d.updateBankTitleInfo((GetCardInfoResponse.CardInfo) null, true);
                this.d.updateCvv2Info(this.m, this.l, this.n);
                this.d.updateCardElement(k(), l(), j(), m(), n());
            }
        }
    }

    public boolean s() {
        BindFastRequest bindFastRequest = this.e;
        return (bindFastRequest == null || bindFastRequest.mCardInfoUpdateContent == null) ? false : true;
    }

    public boolean t() {
        return false;
    }

    public a u() {
        a aVar = new a();
        UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
        if (userInfo != null) {
            aVar.a(userInfo.mobile_number);
            UserData.UserModel.DisplayFlag displayFlag = userInfo.display_flag;
            if (displayFlag != null) {
                aVar.b(displayFlag.getMobileFlag());
            }
        }
        return aVar;
    }

    public GetCardInfoResponse.CertificateTypeInfo[] v() {
        BindFastRequest bindFastRequest = this.e;
        if (bindFastRequest == null) {
            return null;
        }
        if (bindFastRequest.getmBankInfo() != null && this.e.getmBankInfo().channel_info != null) {
            return this.e.getmBankInfo().channel_info.certificate_type_info;
        }
        if (this.e.getmBondCard() != null) {
            return this.e.getmBondCard().certificate_type_info;
        }
        return null;
    }

    public GetCardInfoResponse.CertificateTypeInfo w() {
        GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.s;
        if (certificateTypeInfo != null) {
            return certificateTypeInfo;
        }
        GetCardInfoResponse.CertificateTypeInfo[] v = v();
        if (v == null || v.length <= 0) {
            return null;
        }
        String certificateType = PayDataCache.getInstance().getCertificateType();
        int i2 = 0;
        if (a(certificateType, v)) {
            int length = v.length;
            while (i2 < length) {
                GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo2 = v[i2];
                if (certificateTypeInfo2 == null || !certificateType.equals(certificateTypeInfo2.type)) {
                    i2++;
                } else {
                    this.s = certificateTypeInfo2;
                    return certificateTypeInfo2;
                }
            }
            return null;
        }
        this.s = v[0];
        return v[0];
    }

    public int x() {
        if (v() == null) {
            return 0;
        }
        return v().length;
    }

    public boolean y() {
        return PayDataCache.getInstance().isShowDetection();
    }

    public ArrayList<CharSequence> z() {
        ArrayList<CharSequence> arrayList = new ArrayList<>();
        arrayList.add(A());
        return arrayList;
    }

    public void a(String str) {
        if (this.c == null) {
            this.c = (ab) PayBeanFactory.getInstance().getBean((Context) this.d, 7, BindCardBaseActivity.BEAN_TAG);
        }
        this.c.setResponseCallback(this.d);
        this.c.a(str);
        this.c.execBean();
    }

    public void a(BindCardBaseActivity bindCardBaseActivity) {
        this.d = bindCardBaseActivity;
    }

    public String[] a(int i2) {
        String[] strArr = new String[2];
        String string = ResUtils.getString(this.d, "bd_wallet_bind_card_first");
        if (i2 == 0) {
            string = ResUtils.getString(this.d, "bd_wallet_bind_card_first");
        } else if (i2 == 1) {
            string = ResUtils.getString(this.d, "bd_wallet_bind_card_second");
        }
        String string2 = ResUtils.getString(this.d, "ebpay_pay_checkcard");
        if (i2 == 0) {
            string2 = ResUtils.getString(this.d, "ebpay_pay_checkcard");
        } else if (i2 == 1) {
            string2 = ResUtils.getString(this.d, "dxm_ebpay_pay_next");
        }
        strArr[0] = string;
        strArr[1] = string2;
        return strArr;
    }

    public a a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        if (certificateTypeInfo == null) {
            a aVar = new a();
            UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
            if (userInfo != null) {
                aVar.a(PayDataCache.getInstance().getUserId());
                UserData.UserModel.DisplayFlag displayFlag = userInfo.display_flag;
                if (displayFlag != null) {
                    aVar.b(displayFlag.getCodeFlag());
                }
            }
            return aVar;
        }
        boolean a2 = a(certificateTypeInfo.type, v());
        int x = x();
        a aVar2 = new a();
        UserData.UserModel userInfo2 = PayDataCache.getInstance().getUserInfo();
        if (userInfo2 != null) {
            if (certificateTypeInfo.type.equals(PayDataCache.getInstance().getCertificateType())) {
                aVar2.a(PayDataCache.getInstance().getUserId());
            } else {
                aVar2.a("");
            }
            UserData.UserModel.DisplayFlag displayFlag2 = userInfo2.display_flag;
            if (x <= 1 || !a2) {
                if (displayFlag2 != null) {
                    aVar2.b(displayFlag2.getCodeFlag());
                }
            } else if (certificateTypeInfo.type.equals(PayDataCache.getInstance().getCertificateType())) {
                if (displayFlag2 != null) {
                    aVar2.b(displayFlag2.getCodeFlag());
                }
            } else if (displayFlag2 != null) {
                aVar2.b("4");
            }
        }
        return aVar2;
    }

    public boolean a(String str, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        if (certificateTypeInfoArr != null && certificateTypeInfoArr.length > 0 && !TextUtils.isEmpty(str)) {
            for (GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo : certificateTypeInfoArr) {
                if (certificateTypeInfo != null && str.equals(certificateTypeInfo.type)) {
                    return true;
                }
            }
        }
        return false;
    }
}
