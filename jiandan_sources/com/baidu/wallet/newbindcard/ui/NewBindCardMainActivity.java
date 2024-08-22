package com.baidu.wallet.newbindcard.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.b.a;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.DxmAddress;
import com.baidu.wallet.paysdk.datamodel.DxmJob;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardProtocolActivity;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.widget.compliance.DxmShowDateActivity;
import com.baidu.wallet.paysdk.ui.widget.compliance.b.b;
import com.baidu.wallet.paysdk.ui.widget.compliance.b.c;
import com.baidu.wallet.paysdk.ui.widget.d;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptImageDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Calendar;

public class NewBindCardMainActivity extends PayBaseActivity implements View.OnClickListener, SafeKeyBoardEditText.OnMyFocusChangeListener {
    public static final String BEAN_TAG = "NewBindCardMainActivity";
    public static final String BIND_CARD_MAIN_HASH_ID = "paySDKInitiativeBindCardMainPage";
    public static final String BIND_CARD_MAIN_HASH_NAME = "填写卡信息页面";
    public static final String BIND_CARD_NUMBER = "bindCardNumber";
    public static final int CARD_DATE_LENGTH = 5;
    public LinearLayout A;
    public LinearLayout B;
    public LinearLayout C;
    public LinearLayout D;
    public LinearLayout E;
    public LinearLayout F;
    public LinearLayout G;
    public LinearLayout H;
    public DivisionEditText I;
    public DivisionEditText J;
    public NetImageView K;
    public View L;
    public View M;
    public View N;
    public View O;
    public View P;
    public View Q;
    public CheckBox R;
    public String S;
    public String T;
    public String U;
    public GetCardInfoResponse.CertificateTypeInfo[] V;
    public GetCardInfoResponse.CertificateTypeInfo W;
    public boolean X = true;
    public boolean Y = true;
    public boolean Z = true;
    public ViewGroup a;
    public View aA;
    public DxmJob aB;
    public DxmAddress aC;
    public d aa;
    public boolean ab = false;
    public a ac;

    /* renamed from: ad  reason: collision with root package name */
    public String f3581ad;
    public View ae;
    public View af;
    public View ag;
    public View ah;
    public View ai;
    public View aj;
    public View ak;
    public LinearLayout al;
    public LinearLayout am;
    public LinearLayout an;
    public CheckBox ao;
    public LinearLayout ap;
    public LinearLayout aq;
    public TextView ar;
    public TextView as;
    public TextView at;
    public TextView au;
    public TextView av;
    public TextView aw;
    public View ax;
    public View ay;
    public View az;
    public SafeScrollView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f3582i;
    public TextView j;
    public TextView k;
    public TextView l;
    public RelativeLayout m;
    public RelativeLayout n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f3583o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public ImageView s;
    public ImageView t;
    public SafeKeyBoardEditText u;
    public SafeKeyBoardEditText v;
    public SafeKeyBoardEditText w;
    public SafeKeyBoardEditText x;
    public LinearLayout y;
    public LinearLayout z;

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        SafeScrollView safeScrollView;
        if (motionEvent.getAction() == 0) {
            if (this.ac.a((View) this.s, motionEvent)) {
                i();
            } else if (this.ac.a((View) this.f3583o, motionEvent)) {
                this.ac.a(this.u, this.f3583o);
            } else if (this.ac.a((View) this.q, motionEvent)) {
                this.ac.a(this.w, this.q);
            } else if (this.ac.a((View) this.r, motionEvent)) {
                this.ac.a(this.x, this.r);
            } else if (!this.ac.a((View) this.t, motionEvent) && (safeScrollView = this.b) != null && safeScrollView.isShouldHideInput(getCurrentFocus(), motionEvent)) {
                if (this.b.isPopupWindowShowing()) {
                    j();
                } else {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
                    }
                    this.M.setBackgroundColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_E0EA"));
                    this.u.clearFocus();
                }
                this.ac.c(this.u, this.f3583o);
                this.ac.c(this.J, this.s);
                this.ac.c(this.w, this.q);
                this.ac.c(this.x, this.r);
                this.t.setVisibility(8);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i2 != 5) {
            return;
        }
        if (i3 == -8) {
            if (TextUtils.isEmpty(str)) {
                str = getString(ResUtils.string(getActivity(), "dxm_ebpay_no_network"));
            }
            GlobalUtils.toast(this, str);
        } else if (i3 == 16128) {
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, 66, "");
        } else {
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, 12, "");
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 5) {
            this.ac.a(i2, obj, str);
        }
    }

    public void initBankCardInfo(String str, String str2, String str3) {
        this.I.setEnabled(false);
        this.I.setText(this.S);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            this.z.setVisibility(8);
            return;
        }
        this.z.setVisibility(0);
        this.K.setImageUrl(str);
        TextView textView = this.e;
        textView.setText(str2 + " " + str3);
    }

    public void initBindCardUi(String str, UserData.UserModel.DisplayFlag displayFlag) {
        this.T = str;
        if (!TextUtils.isEmpty(str)) {
            this.Z = true;
            this.u.setText(this.T);
        }
        this.ac.a((EditText) this.u);
        if (displayFlag != null) {
            if ("1".equals(displayFlag.true_name)) {
                this.C.setVisibility(8);
            } else if ("2".equals(displayFlag.true_name)) {
                this.C.setVisibility(0);
                this.u.setEnabled(false);
                this.u.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_667A"));
            } else if ("3".equals(displayFlag.true_name)) {
                this.C.setVisibility(0);
                this.u.setEnabled(true);
                this.u.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_2222"));
            }
            if ("1".equals(displayFlag.certificate_type)) {
                this.p.setVisibility(8);
                this.t.setVisibility(8);
            } else if ("2".equals(displayFlag.certificate_type)) {
                this.y.setVisibility(0);
                this.p.setVisibility(8);
                this.t.setVisibility(8);
            } else if ("3".equals(displayFlag.certificate_type)) {
                this.y.setVisibility(0);
                this.p.setVisibility(0);
                String string = ResUtils.getString(this, "wallet_access_select_passport_des");
                AccessibilityUtils.changeRoleDescription(this.A, ResUtils.getString(this, "wallet_access_button"));
                AccessibilityUtils.setGroupDescription(this.A, string);
                if (TextUtils.isEmpty(this.v.getText())) {
                    this.t.setVisibility(8);
                } else {
                    this.t.setVisibility(0);
                }
            }
            if ("1".equals(displayFlag.certificate_code)) {
                this.y.setVisibility(8);
                this.t.setVisibility(8);
            } else if ("2".equals(displayFlag.certificate_code)) {
                this.y.setVisibility(0);
                this.N.setVisibility(8);
                this.v.setEnabled(false);
                this.v.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_667A"));
                this.t.setVisibility(8);
            } else if ("3".equals(displayFlag.certificate_code)) {
                this.y.setVisibility(0);
                this.N.setVisibility(8);
                this.v.setEnabled(true);
                this.v.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_2222"));
                SafeKeyBoardEditText safeKeyBoardEditText = this.v;
                safeKeyBoardEditText.initSafeKeyBoardParams(this.a, this.b, safeKeyBoardEditText, false);
                if (TextUtils.isEmpty(this.v.getText())) {
                    this.t.setVisibility(8);
                } else {
                    this.t.setVisibility(0);
                }
            }
            if ("1".equals(displayFlag.mobile)) {
                this.n.setVisibility(8);
                this.L.setVisibility(8);
                this.B.setVisibility(8);
            } else if ("2".equals(displayFlag.mobile)) {
                this.n.setVisibility(0);
                this.L.setVisibility(0);
                this.J.setEnabled(false);
                this.J.setFormatEnable(false);
                this.J.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_667A"));
                this.J.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
            } else if ("3".equals(displayFlag.mobile)) {
                this.n.setVisibility(0);
                this.L.setVisibility(0);
                this.J.setEnabled(true);
                this.J.setFormatEnable(true);
                this.J.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_2222"));
                this.J.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
                DivisionEditText divisionEditText = this.J;
                divisionEditText.initSafeKeyBoardParams(this.a, this.b, divisionEditText, false);
            }
        }
    }

    public void initCardDateAndCvv2(GetCardInfoResponse.CardItemRequired cardItemRequired) {
        if (cardItemRequired != null) {
            if ("1".equals(cardItemRequired.valid_date)) {
                this.D.setVisibility(0);
                SafeKeyBoardEditText safeKeyBoardEditText = this.w;
                safeKeyBoardEditText.initSafeKeyBoardParams(this.a, this.b, safeKeyBoardEditText, false);
            } else {
                this.D.setVisibility(8);
            }
            if ("1".equals(cardItemRequired.valid_code)) {
                this.E.setVisibility(0);
                SafeKeyBoardEditText safeKeyBoardEditText2 = this.x;
                safeKeyBoardEditText2.initSafeKeyBoardParams(this.a, this.b, safeKeyBoardEditText2, false);
                return;
            }
            this.E.setVisibility(8);
            return;
        }
        this.D.setVisibility(8);
        this.E.setVisibility(8);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (this.m == view) {
            onBackPressed();
        } else if (this.A == view) {
            if (this.p.getVisibility() == 0) {
                a(PayStatServiceEvent.NEW_CERTIFICATE_TYPE_DIALOG, "点击证件类型展示的弹窗");
                g();
            }
        } else if (this.G == view) {
            a(PayStatServiceEvent.NEW_CLICK_BIND_CARD, "点击确认按钮");
            if (this.R.isChecked()) {
                f();
            } else {
                WalletGlobalUtils.safeShowDialog(this, 32, "");
            }
        } else if (this.B == view) {
            if (!TextUtils.isEmpty(this.f.getText().toString().trim())) {
                this.Y = true;
                this.ab = true;
                this.J.setText(this.f.getText().toString());
                this.ab = false;
                this.ac.a((EditText) this.J);
                DivisionEditText divisionEditText = this.J;
                divisionEditText.setSelection(divisionEditText.getText().toString().length());
                this.J.requestFocus();
                this.B.setVisibility(8);
            }
        } else if (this.f3583o == view) {
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_name_tip");
            WalletGlobalUtils.safeShowDialog(this, 14, "");
        } else if (this.s == view) {
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_mobile_tip");
            WalletGlobalUtils.safeShowDialog(this, 13, "");
        } else if (this.q == view) {
            this.mDialogMsg = ResUtils.getString(getActivity(), "new_bindcard_date_tip");
            WalletGlobalUtils.safeShowDialog(this, 56, "");
        } else if (this.r == view) {
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_cvv2_tip");
            WalletGlobalUtils.safeShowDialog(this, 2, "");
        } else {
            ImageView imageView = this.t;
            if (imageView == view) {
                if (imageView.getVisibility() == 0) {
                    this.v.setText("");
                }
            } else if (this.H == view) {
                a(PayStatServiceEvent.NEW_BIND_CARD_CLICK_SAFE_TIP, "点击卡信息页面的“查看个人信息用途”");
                this.ac.b(this);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_cashdesk_new_bind_card_main_activity);
        a a2 = com.baidu.wallet.newbindcard.a.a.a(80, this);
        this.ac = a2;
        if (a2 == null) {
            NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardMainActivity Presenter is null", false);
            finishWithoutAnim();
            return;
        }
        com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.BIND_CARD_GOTO_CONFRIM, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "完成密码或指纹验证或人脸验证", com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), com.baidu.wallet.newbindcard.c.a.c(), com.baidu.wallet.newbindcard.c.a.d(), com.baidu.wallet.newbindcard.c.a.e(), com.baidu.wallet.newbindcard.c.a.f());
        this.ac.a(bundle);
        this.ac.a();
        this.S = getIntent().getStringExtra(BIND_CARD_NUMBER);
        a();
        a(PayStatServiceEvent.NEW_ENTER_BIND_CARD_PAGE, "进入");
        this.ac.a((Context) this);
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 2) {
            return new PromptImageDialog(this);
        }
        if (i2 != 32) {
            if (i2 != 56) {
                if (i2 != 66) {
                    switch (i2) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                            break;
                        default:
                            return super.onCreateDialog(i2);
                    }
                }
            }
            return new PromptTipDialog(this);
        }
        return new PromptDialog(this);
    }

    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(BEAN_TAG);
        d dVar = this.aa;
        if (dVar != null) {
            dVar.dismiss();
            this.aa.a();
            this.aa = null;
        }
        j();
        a aVar = this.ac;
        if (aVar != null) {
            aVar.p();
            this.ac = null;
        }
        this.aB = null;
        this.aC = null;
        super.onDestroy();
    }

    public void onModuleEvent(EventBus.Event event) {
        a aVar;
        if (event != null && (aVar = this.ac) != null) {
            aVar.a(event);
        }
    }

    public void onMyFocusChange(View view, boolean z2) {
        if (view == this.u) {
            this.ac.a(this.M, (int) z2);
            this.ac.a(this.u, this.f3583o);
            if (z2) {
                this.ac.c(this.J, this.s);
                this.ac.c(this.w, this.q);
                this.ac.c(this.x, this.r);
                this.t.setVisibility(8);
                return;
            }
            return;
        }
        SafeKeyBoardEditText safeKeyBoardEditText = this.v;
        if (view == safeKeyBoardEditText) {
            if (z2) {
                if (!safeKeyBoardEditText.isEnabled() || TextUtils.isEmpty(this.v.getText())) {
                    this.t.setVisibility(8);
                } else {
                    this.t.setVisibility(0);
                }
                this.f3582i.setVisibility(8);
                this.N.setVisibility(8);
                this.ac.a(this.N, 1);
                this.ac.c(this.J, this.s);
                this.ac.c(this.w, this.q);
                this.ac.c(this.x, this.r);
            } else if (!this.ac.a(this.y, safeKeyBoardEditText, this.W, this.X) || TextUtils.isEmpty(this.v.getText())) {
                this.f3582i.setVisibility(8);
                this.N.setVisibility(8);
                this.ac.a(this.N, 0);
            } else {
                this.f3582i.setVisibility(0);
                this.N.setVisibility(0);
                this.ac.a(this.N, 2);
            }
        } else if (view == this.I) {
            this.ac.a(this.O, z2 ? 1 : 0);
        } else {
            SafeKeyBoardEditText safeKeyBoardEditText2 = this.w;
            if (view == safeKeyBoardEditText2) {
                this.ac.a(safeKeyBoardEditText2, this.q);
                if (z2) {
                    this.k.setVisibility(8);
                    this.t.setVisibility(8);
                    this.ac.a(this.P, 1);
                    this.ac.c(this.J, this.s);
                    this.ac.c(this.u, this.f3583o);
                    this.ac.c(this.x, this.r);
                } else if (!this.ac.a((View) this.D, this.w) || TextUtils.isEmpty(this.w.getText())) {
                    this.k.setVisibility(8);
                    this.ac.a(this.P, 0);
                } else {
                    this.k.setVisibility(0);
                    this.ac.a(this.P, 2);
                }
            } else {
                SafeKeyBoardEditText safeKeyBoardEditText3 = this.x;
                if (view == safeKeyBoardEditText3) {
                    this.ac.a(safeKeyBoardEditText3, this.r);
                    if (z2) {
                        this.l.setVisibility(8);
                        this.t.setVisibility(8);
                        this.ac.a(this.Q, 1);
                        this.ac.c(this.J, this.s);
                        this.ac.c(this.u, this.f3583o);
                        this.ac.c(this.w, this.q);
                    } else if (!this.ac.b((View) this.E, this.x) || TextUtils.isEmpty(this.x.getText())) {
                        this.l.setVisibility(8);
                        this.ac.a(this.Q, 0);
                    } else {
                        this.l.setVisibility(0);
                        this.ac.a(this.Q, 2);
                    }
                } else if (view == this.J) {
                    i();
                    if (z2) {
                        if (TextUtils.isEmpty(this.J.getRealText())) {
                            d();
                        } else {
                            this.B.setVisibility(8);
                        }
                        this.ac.a(this.L, 1);
                        this.ac.c(this.u, this.f3583o);
                        this.ac.c(this.w, this.q);
                        this.ac.c(this.x, this.r);
                        this.j.setVisibility(8);
                        this.t.setVisibility(8);
                    } else if (!this.ac.a((View) this.n, this.J, this.Y) || TextUtils.isEmpty(this.J.getText())) {
                        this.ac.a(this.L, 0);
                    } else {
                        this.j.setVisibility(0);
                        this.ac.a(this.L, 2);
                    }
                }
            }
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 2) {
            PromptImageDialog promptImageDialog = (PromptImageDialog) dialog;
            promptImageDialog.setMessage(this.mDialogMsg);
            a(PayStatServiceEvent.NEW_SHOW_CVV_DIALOG, "点击cvv后面的提示按钮展示的弹窗");
            promptImageDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_cvv2_tip_title"));
            promptImageDialog.setImage(ResUtils.drawable(getActivity(), "wallet_base_help_cvv"));
        } else if (i2 == 32) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setTitleText(ResUtils.string(getActivity(), "dxm_ebpay_tip"));
            promptDialog.setMessage((CharSequence) "请确认您已经阅读并同意相关协议内容");
            promptDialog.setCanceledOnTouchOutside(false);
            a(PayStatServiceEvent.NEW_SHOW_PROTOCOL_DIALOG, "没有勾选协议，展示的弹窗");
            promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardMainActivity.this.R.setChecked(false);
                    NewBindCardMainActivity.this.a(PayStatServiceEvent.NEW_CLICK_PROTOCOL_DIALOG_CANCEL, "没有勾选协议，展示的弹窗，点击取消按钮");
                    WalletGlobalUtils.safeDismissDialog(NewBindCardMainActivity.this, 32);
                }
            });
            promptDialog.setPositiveBtn("已确认同意", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardMainActivity.this.R.setChecked(true);
                    NewBindCardMainActivity.this.a(PayStatServiceEvent.NEW_CLICK_PROTOCOL_DIALOG_COMIT, "没有勾选协议，展示的弹窗，点击已确认同意按钮");
                    WalletGlobalUtils.safeDismissDialog(NewBindCardMainActivity.this, 32);
                    NewBindCardMainActivity.this.f();
                }
            });
        } else if (i2 == 56) {
            a(PayStatServiceEvent.NEW_SHOW_DATE_DIALOG, "点击date后面的提示按钮展示的弹窗");
            PromptTipDialog promptTipDialog = (PromptTipDialog) dialog;
            promptTipDialog.setMessage(this.mDialogMsg);
            promptTipDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_date_tip_title"));
        } else if (i2 != 66) {
            switch (i2) {
                case 12:
                    PromptDialog promptDialog2 = (PromptDialog) dialog;
                    promptDialog2.setMessage((CharSequence) this.mDialogMsg);
                    promptDialog2.setCanceledOnTouchOutside(false);
                    a(PayStatServiceEvent.NEW_CARD_CHECK_ERR_DIALOG, "card_check接口报错展示的弹窗");
                    promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                        public void onClick(View view) {
                            NewBindCardMainActivity.this.a(PayStatServiceEvent.NEW_CARD_CHECK_ERR_CLICK, "点击card_check接口报错展示的弹窗我知道了按钮");
                            WalletGlobalUtils.safeDismissDialog(NewBindCardMainActivity.this, 12);
                        }
                    });
                    promptDialog2.hideNegativeButton();
                    return;
                case 13:
                    PromptTipDialog promptTipDialog2 = (PromptTipDialog) dialog;
                    promptTipDialog2.setMessage(this.mDialogMsg);
                    a(PayStatServiceEvent.NEW_SHOW_PHONE_DIALOG, "点击手机号后面的提示按钮展示的弹窗");
                    promptTipDialog2.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_bank_phone"));
                    return;
                case 14:
                    PromptTipDialog promptTipDialog3 = (PromptTipDialog) dialog;
                    promptTipDialog3.setMessage(this.mDialogMsg);
                    a(PayStatServiceEvent.NEW_SHOW_NAME_DIALOG, "点击姓名后面的提示按钮展示的弹窗");
                    promptTipDialog3.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_name_title"));
                    return;
                default:
                    super.onPrepareDialog(i2, dialog);
                    return;
            }
        } else {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setTitleText(ResUtils.string(getActivity(), "dxm_service_reminder_tip"));
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            promptDialog3.setCanceledOnTouchOutside(false);
            a(PayStatServiceEvent.NEW_SHOW_CER_ERR_DIALOG, "card_check接口报错16128端上展示弹窗");
            promptDialog3.setNegativeBtn(ResUtils.string(getActivity(), "dxm_not_real_name"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardMainActivity.this.a(PayStatServiceEvent.NEW_CER_ERR_DIALOG_CANCEL, "card_check接口报错16128端上展示弹窗，点击左侧按钮");
                    WalletGlobalUtils.safeDismissDialog(NewBindCardMainActivity.this, 66);
                }
            });
            promptDialog3.setPositiveBtn(ResUtils.string(getActivity(), "dxm_continue_real_name"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardMainActivity.this.a(PayStatServiceEvent.NEW_CER_ERR_DIALOG_CONTINUE, "card_check接口报错16128端上展示弹窗，点击右侧按钮");
                    WalletGlobalUtils.safeDismissDialog(NewBindCardMainActivity.this, 66);
                    NewBindCardMainActivity.this.h();
                }
            });
        }
    }

    public void setBindCardProtocol(final GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo) {
        if (protocolPlatformInfo != null) {
            this.R.setChecked(protocolPlatformInfo.isProtocolCheckedDefault());
            if (protocolPlatformInfo == null || TextUtils.isEmpty(protocolPlatformInfo.prefix) || TextUtils.isEmpty(protocolPlatformInfo.prefix)) {
                this.F.setVisibility(8);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int color = ResUtils.getColor(getActivity(), "wallet_base_font_868e9e");
            spannableStringBuilder.append(protocolPlatformInfo.prefix + " ");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolPlatformInfo.prefix.length(), 33);
            spannableStringBuilder.append("《");
            spannableStringBuilder.append(protocolPlatformInfo.main_title);
            spannableStringBuilder.append("》");
            spannableStringBuilder.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    String str;
                    NewBindCardMainActivity.this.a(PayStatServiceEvent.NEW_CLICK_PROTOCOL, "点击绑卡协议");
                    Intent intent = new Intent(NewBindCardMainActivity.this.getActivity(), BindCardProtocolActivity.class);
                    if (NewBindCardEntry.getInstance().getBindCategory() != null) {
                        intent.putExtra("baidu.wallet.from", NewBindCardEntry.getInstance().getBindCategory().name());
                    } else {
                        intent.putExtra("baidu.wallet.from", PayRequestCache.BindCategory.Initiative.name());
                    }
                    intent.putExtra(BindCardProtocolActivity.PROTOCOL_SNAPSHOT_ID, protocolPlatformInfo.snapshotId);
                    if (!TextUtils.isEmpty(NewBindCardMainActivity.this.T)) {
                        str = NewBindCardMainActivity.this.T;
                    } else {
                        str = NewBindCardMainActivity.this.u.getText().toString();
                    }
                    intent.putExtra("true_name", str);
                    intent.putExtra("identity_code", NewBindCardMainActivity.this.v.getText().toString());
                    intent.putExtra("mobile", NewBindCardMainActivity.this.J.getText().toString());
                    intent.putExtra(BindCardProtocolActivity.IDENTITY_TYPE, NewBindCardMainActivity.this.U);
                    intent.putExtra("card_no", NewBindCardMainActivity.this.S);
                    NewBindCardMainActivity.this.startActivityWithoutAnim(intent);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(ResUtils.getColor(NewBindCardMainActivity.this.getActivity(), "dxm_wallet_base_color_clickable"));
                }
            }, protocolPlatformInfo.prefix.length(), spannableStringBuilder.length(), 33);
            this.g.setEnabled(true);
            this.g.setMovementMethod(LinkMovementMethod.getInstance());
            this.g.setHintTextColor(-1);
            this.g.setText(spannableStringBuilder);
            String str = (TextUtils.isEmpty(protocolPlatformInfo.main_title) || (!protocolPlatformInfo.main_title.endsWith("协议") && !protocolPlatformInfo.main_title.endsWith("协议》"))) ? "协议详情" : "详情";
            TextView textView = this.g;
            textView.setContentDescription("查看" + protocolPlatformInfo.main_title + str);
            return;
        }
        this.F.setVisibility(8);
    }

    public void setCertificateCode(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.X = true;
            this.v.setText(str);
            SafeKeyBoardEditText safeKeyBoardEditText = this.v;
            safeKeyBoardEditText.setSelection(safeKeyBoardEditText.getText().toString().length());
            if (str.contains("*********")) {
                StringBuilder sb = new StringBuilder(str);
                sb.insert(1, " ");
                sb.insert(sb.length() - 1, " ");
                AccessibilityUtils.setEditTextDescription(this.v, sb.toString());
            }
        } else {
            this.X = false;
            this.v.setText("");
        }
        this.ac.a((EditText) this.v);
    }

    public void setCertificateType(String str, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        if (certificateTypeInfoArr != null && certificateTypeInfoArr.length >= 1) {
            this.U = str;
            this.V = certificateTypeInfoArr;
            int i2 = 0;
            if (TextUtils.isEmpty(str)) {
                GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = this.V;
                this.W = certificateTypeInfoArr2[0];
                this.d.setText(certificateTypeInfoArr2[0].description);
                this.ac.a(this.v, this.V[0].type);
                return;
            }
            while (true) {
                GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr3 = this.V;
                if (i2 >= certificateTypeInfoArr3.length) {
                    return;
                }
                if (this.U.equals(certificateTypeInfoArr3[i2].type)) {
                    GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr4 = this.V;
                    this.W = certificateTypeInfoArr4[i2];
                    this.d.setText(certificateTypeInfoArr4[i2].description);
                    this.ac.a(this.v, this.V[i2].type);
                    return;
                }
                i2++;
            }
        }
    }

    public void setPhoneTip(String str, int i2) {
        this.f3581ad = str;
        d();
        if (i2 == 0) {
            this.h.setText("点击填入您的手机号");
        } else {
            this.h.setText("点击填入您的登录手机号");
        }
        this.f.setText(str);
        b(str);
    }

    public void setUserPhone(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Y = true;
            this.J.setText(str);
            a(str);
            this.B.setVisibility(8);
            DivisionEditText divisionEditText = this.J;
            divisionEditText.setSelection(divisionEditText.getText().toString().length());
        } else {
            this.Y = false;
            this.J.setText("");
            if (this.J.hasFocus()) {
                d();
            }
        }
        this.ac.a((EditText) this.J);
    }

    public void showPaySuccessPage(boolean z2, PayResultContent payResultContent, int i2) {
    }

    /* access modifiers changed from: private */
    public void d() {
        if (TextUtils.isEmpty(this.f3581ad)) {
            this.B.setVisibility(8);
        } else {
            this.B.setVisibility(0);
        }
    }

    private void e() {
        this.u.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                NewBindCardMainActivity.this.ac.a((EditText) NewBindCardMainActivity.this.u);
                NewBindCardMainActivity.this.ac.a(NewBindCardMainActivity.this.u, NewBindCardMainActivity.this.f3583o);
                boolean unused = NewBindCardMainActivity.this.Z = false;
                NewBindCardMainActivity.this.c();
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.v.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                String str;
                boolean z = false;
                boolean unused = NewBindCardMainActivity.this.X = false;
                NewBindCardMainActivity.this.ac.a((EditText) NewBindCardMainActivity.this.v);
                if (TextUtils.isEmpty(NewBindCardMainActivity.this.v.getText())) {
                    NewBindCardMainActivity.this.t.setVisibility(8);
                    NewBindCardMainActivity newBindCardMainActivity = NewBindCardMainActivity.this;
                    newBindCardMainActivity.a(0, ResUtils.getString(newBindCardMainActivity, "ebpay_man_tip"));
                } else {
                    NewBindCardMainActivity.this.t.setVisibility(0);
                    NewBindCardMainActivity.this.ac.b(NewBindCardMainActivity.this.v, NewBindCardMainActivity.this.t);
                    if (NewBindCardMainActivity.this.ac.a(NewBindCardMainActivity.this.y, NewBindCardMainActivity.this.v, NewBindCardMainActivity.this.W, NewBindCardMainActivity.this.X) || !"1".equals(NewBindCardMainActivity.this.W.type) || NewBindCardMainActivity.this.v.getText().toString().trim().length() != 18 || editable.toString().contains("*")) {
                        NewBindCardMainActivity newBindCardMainActivity2 = NewBindCardMainActivity.this;
                        newBindCardMainActivity2.a(0, ResUtils.getString(newBindCardMainActivity2, "ebpay_man_tip"));
                    } else {
                        String obj = NewBindCardMainActivity.this.v.getText().toString();
                        int parseInt = Calendar.getInstance().get(1) - Integer.parseInt(obj.subSequence(6, 10).toString());
                        if (Integer.parseInt(obj.subSequence(16, 17).toString()) % 2 == 0) {
                            z = true;
                        }
                        NewBindCardMainActivity newBindCardMainActivity3 = NewBindCardMainActivity.this;
                        if (z) {
                            str = ResUtils.getString(newBindCardMainActivity3, "ebpay_woman_tip");
                        } else {
                            str = ResUtils.getString(newBindCardMainActivity3, "ebpay_man_tip");
                        }
                        NewBindCardMainActivity.this.a(parseInt, str);
                    }
                }
                NewBindCardMainActivity.this.c();
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.J.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                boolean unused = NewBindCardMainActivity.this.Y = false;
                NewBindCardMainActivity.this.i();
                if (TextUtils.isEmpty(NewBindCardMainActivity.this.J.getRealText())) {
                    NewBindCardMainActivity.this.ac.a((EditText) NewBindCardMainActivity.this.J);
                    NewBindCardMainActivity.this.d();
                    NewBindCardMainActivity.this.ac.a(NewBindCardMainActivity.this.L, 1);
                } else {
                    NewBindCardMainActivity.this.ac.a((EditText) NewBindCardMainActivity.this.J);
                    NewBindCardMainActivity.this.B.setVisibility(8);
                    if (NewBindCardMainActivity.this.J.getRealText().contains("*")) {
                        if (!NewBindCardMainActivity.this.ab) {
                            NewBindCardMainActivity.this.J.setText("");
                        }
                        boolean unused2 = NewBindCardMainActivity.this.Y = true;
                        NewBindCardMainActivity.this.ac.a((EditText) NewBindCardMainActivity.this.J);
                        if (NewBindCardMainActivity.this.J.getRealText().length() < 11) {
                            NewBindCardMainActivity.this.G.setEnabled(false);
                            return;
                        }
                    }
                }
                NewBindCardMainActivity.this.c();
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        final StringBuilder sb = new StringBuilder();
        this.w.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                NewBindCardMainActivity.this.ac.a((EditText) NewBindCardMainActivity.this.w);
                NewBindCardMainActivity.this.ac.a(NewBindCardMainActivity.this.w, NewBindCardMainActivity.this.q);
                NewBindCardMainActivity.this.c();
                if (!TextUtils.isEmpty(NewBindCardMainActivity.this.w.getText())) {
                    String obj = NewBindCardMainActivity.this.w.getText().toString();
                    if (!sb.toString().equals(obj)) {
                        StringBuilder sb = sb;
                        sb.delete(0, sb.length());
                        sb.append(obj.replace("/", ""));
                        if (sb.length() > 2) {
                            sb.insert(2, "/");
                        }
                        NewBindCardMainActivity.this.w.setText(sb);
                        NewBindCardMainActivity.this.w.setSelection(sb.length());
                    }
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.x.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                NewBindCardMainActivity.this.ac.a((EditText) NewBindCardMainActivity.this.x);
                NewBindCardMainActivity.this.ac.a(NewBindCardMainActivity.this.x, NewBindCardMainActivity.this.r);
                NewBindCardMainActivity.this.c();
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void f() {
        String str;
        String str2;
        String trim = this.Z ? this.T : this.u.getText().toString().trim();
        GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.W;
        String str3 = certificateTypeInfo != null ? certificateTypeInfo.type : "";
        String trim2 = this.v.getText().toString().trim();
        String realText = this.J.getRealText();
        if (!TextUtils.isEmpty(this.w.getText())) {
            str = this.w.getText().toString().trim().replaceAll("/", "");
        } else {
            str = "";
        }
        String trim3 = this.x.getText().toString().trim();
        String charSequence = this.ar.getText().toString();
        if (this.ao.isChecked()) {
            str2 = ResUtils.getString(this, "ebpay_id_card_long_date_tip");
        } else {
            str2 = this.as.getText().toString();
        }
        this.ac.a(trim, str3, trim2, realText, str, trim3, charSequence, str2, this.au.getText().toString(), ResUtils.getString(this, "ebpay_man_tip").equals(this.at.getText().toString()) ? "1" : "2", this.aC, this.aB);
    }

    private void g() {
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr = this.V;
        if (certificateTypeInfoArr != null && certificateTypeInfoArr.length > 0) {
            j();
            if (this.aa == null) {
                this.aa = new d(this);
            }
            if (this.aa.isShowing()) {
                this.aa.dismiss();
            }
            this.aa.a(this.V);
            this.aa.a((View) this.a);
            a(0.3f);
            this.aa.a((d.a) new d.a() {
                public void a(View view, GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo, int i2) {
                    GetCardInfoResponse.CertificateTypeInfo unused = NewBindCardMainActivity.this.W = certificateTypeInfo;
                    if (certificateTypeInfo != null) {
                        com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_CLICK_CERTIFICATE_TYPE, NewBindCardMainActivity.BIND_CARD_MAIN_HASH_NAME, NewBindCardMainActivity.BIND_CARD_MAIN_HASH_ID, "用户选择的证件类型", com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), com.baidu.wallet.newbindcard.c.a.c(), com.baidu.wallet.newbindcard.c.a.d(), certificateTypeInfo.type);
                        NewBindCardMainActivity.this.ac.a(NewBindCardMainActivity.this.v, certificateTypeInfo.type);
                        NewBindCardMainActivity.this.d.setText(certificateTypeInfo.description);
                        if (!"1".equals(certificateTypeInfo.type)) {
                            NewBindCardMainActivity.this.h();
                        }
                    }
                }
            });
            this.aa.setOnDismissListener(new PopupWindow.OnDismissListener() {
                public void onDismiss() {
                    NewBindCardMainActivity.this.a(PayStatServiceEvent.NEW_CLOSE_CERTIFICATE_TYPE_DIALOG, "关闭证件类型弹窗");
                    NewBindCardMainActivity.this.a(1.0f);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.ac != null && this.W != null) {
            String str = "";
            String obj = (this.C.getVisibility() != 0 || TextUtils.isEmpty(this.u.getText())) ? str : this.u.getText().toString();
            String obj2 = (this.v.getVisibility() != 0 || TextUtils.isEmpty(this.v.getText())) ? str : this.v.getText().toString();
            String obj3 = (this.I.getVisibility() != 0 || TextUtils.isEmpty(this.I.getText())) ? str : this.I.getText().toString();
            String obj4 = (this.n.getVisibility() != 0 || TextUtils.isEmpty(this.J.getText())) ? str : this.J.getText().toString();
            String obj5 = (this.E.getVisibility() != 0 || TextUtils.isEmpty(this.x.getText())) ? str : this.x.getText().toString();
            if (this.D.getVisibility() == 0 && !TextUtils.isEmpty(this.w.getText())) {
                str = this.w.getText().toString();
            }
            this.ac.a(this, obj, this.W.type, obj2, obj3, obj4, obj5, str);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (TextUtils.isEmpty(this.J.getRealText()) || !this.J.isEnabled() || !this.J.hasFocus()) {
            this.ac.c(this.J, this.s);
        } else {
            this.ac.b((SafeKeyBoardEditText) this.J, this.s);
        }
    }

    private void j() {
        SafeScrollView safeScrollView = this.b;
        if (safeScrollView != null && safeScrollView.isPopupWindowShowing()) {
            this.v.clearFocus();
            this.J.clearFocus();
            this.w.clearFocus();
            this.x.clearFocus();
            this.b.dismissKeyBoard();
        }
    }

    private void b() {
        this.v.setUseSafeKeyBoard(true);
        this.v.setUseKeyX(true);
        this.I.setUseSafeKeyBoard(true);
        this.I.setViewType(25);
        this.u.setUseSafeKeyBoard(false);
        this.u.setUseKeyX(false);
        this.J.setUseSafeKeyBoard(true);
        this.J.setViewType(13);
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.C.getVisibility() == 0 && this.u.isEnabled()) {
            if (TextUtils.isEmpty(this.u.getText())) {
                this.G.setEnabled(false);
                return;
            } else if (!CheckUtils.isUserNameAvailable(this.u.getText().toString().trim())) {
                this.G.setEnabled(false);
                return;
            }
        }
        if (this.ac.a(this.y, this.v, this.W, this.X)) {
            if (TextUtils.isEmpty(this.v.getText())) {
                this.G.setEnabled(false);
                return;
            }
            if (!"1".equals(this.W.type) || this.v.getText().toString().trim().length() != 18) {
                this.f3582i.setVisibility(8);
                this.N.setVisibility(8);
                this.ac.a(this.N, 1);
            } else {
                this.f3582i.setVisibility(0);
                this.N.setVisibility(0);
                this.ac.a(this.N, 2);
            }
            this.G.setEnabled(false);
        } else if (this.ac.a((View) this.D, this.w)) {
            if (!TextUtils.isEmpty(this.w.getText())) {
                if (this.w.getText().length() == 5) {
                    this.k.setVisibility(0);
                    this.ac.a(this.P, 2);
                } else {
                    this.k.setVisibility(8);
                    this.ac.a(this.P, 1);
                }
            }
            this.G.setEnabled(false);
        } else if (this.ac.b((View) this.E, this.x)) {
            this.G.setEnabled(false);
        } else if (this.ac.a((View) this.n, this.J, this.Y)) {
            if (!TextUtils.isEmpty(this.J.getRealText())) {
                if (this.J.getRealText().length() == 11) {
                    this.j.setVisibility(0);
                    this.ac.a(this.L, 2);
                } else {
                    this.j.setVisibility(8);
                }
            }
            this.G.setEnabled(false);
        } else {
            a aVar = this.ac;
            if (aVar != null) {
                if (aVar.j() && TextUtils.isEmpty(this.ar.getText())) {
                    this.G.setEnabled(false);
                    return;
                } else if (this.ac.k() && TextUtils.isEmpty(this.as.getText()) && !this.ao.isChecked()) {
                    this.G.setEnabled(false);
                    return;
                } else if (this.ac.m() && TextUtils.isEmpty(this.at.getText())) {
                    this.G.setEnabled(false);
                    return;
                } else if (this.ac.n() && TextUtils.isEmpty(this.av.getText())) {
                    this.G.setEnabled(false);
                    return;
                } else if (this.ac.o() && TextUtils.isEmpty(this.aw.getText())) {
                    this.G.setEnabled(false);
                    return;
                }
            }
            this.G.setEnabled(true);
        }
    }

    private void a() {
        int i2;
        String str;
        UserData.UserModel userModel;
        this.a = (ViewGroup) findViewById(R.id.new_bind_card_main_activity);
        this.b = (SafeScrollView) findViewById(R.id.scroll_bindcard_main);
        this.c = (TextView) findViewById(R.id.tv_red_button_txt);
        this.m = (RelativeLayout) findViewById(R.id.title_left_imgzone2);
        this.C = (LinearLayout) findViewById(R.id.lin_user_name);
        this.f3583o = (ImageView) findViewById(R.id.iv_new_bind_card_name_tip_icon);
        this.u = (SafeKeyBoardEditText) findViewById(R.id.et_new_bind_card_user_name);
        this.y = (LinearLayout) findViewById(R.id.lin_user_id_card);
        this.A = (LinearLayout) findViewById(R.id.lin_user_type);
        this.d = (TextView) findViewById(R.id.tv_user_type);
        this.p = (ImageView) findViewById(R.id.iv_user_type_icon);
        this.v = (SafeKeyBoardEditText) findViewById(R.id.et_new_bind_card_user_id_card);
        this.I = (DivisionEditText) findViewById(R.id.et_new_bank_card_no);
        this.z = (LinearLayout) findViewById(R.id.lin_new_bank_card_info);
        this.K = (NetImageView) findViewById(R.id.iv_new_bankinfo_logo);
        this.e = (TextView) findViewById(R.id.tv_new_bankinfo_name);
        this.D = (LinearLayout) findViewById(R.id.lin_bind_card_date);
        this.q = (ImageView) findViewById(R.id.iv_new_bind_card_date_icon);
        this.w = (SafeKeyBoardEditText) findViewById(R.id.et_new_bind_card_date);
        this.E = (LinearLayout) findViewById(R.id.lin_bind_card_cvv2);
        this.r = (ImageView) findViewById(R.id.iv_new_bind_card_cvv2_icon);
        this.x = (SafeKeyBoardEditText) findViewById(R.id.et_new_bind_card_cvv2);
        this.n = (RelativeLayout) findViewById(R.id.relative_bind_card_phone);
        this.s = (ImageView) findViewById(R.id.iv_new_bind_card_phone_icon);
        this.J = (DivisionEditText) findViewById(R.id.et_new_bank_card_phone);
        this.f = (TextView) findViewById(R.id.tv_bind_card_phone_tip);
        CheckBox checkBox = (CheckBox) findViewById(R.id.cb_new_bind_card_protocol);
        this.R = checkBox;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    NewBindCardMainActivity.this.R.setContentDescription(ResUtils.getString(NewBindCardMainActivity.this, "wallet_access_disagree_protocol"));
                    return;
                }
                NewBindCardMainActivity.this.R.setContentDescription(ResUtils.getString(NewBindCardMainActivity.this, "wallet_access_agree_protocol"));
            }
        });
        TextView textView = (TextView) findViewById(R.id.tv_new_bind_card_protocol);
        this.g = textView;
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(this, "wallet_access_button"));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lin_bind_card_phone_tip);
        this.B = linearLayout;
        AccessibilityUtils.changeRoleDescription(linearLayout, ResUtils.getString(this, "wallet_access_button"));
        this.F = (LinearLayout) findViewById(R.id.lin_bind_card_protocol);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.btn_new_bank_card_submit);
        this.G = linearLayout2;
        AccessibilityUtils.changeRoleDescription(linearLayout2, ResUtils.getString(this, "wallet_access_button"));
        this.G.setContentDescription("确认");
        this.M = findViewById(R.id.view_line_user_name);
        this.N = findViewById(R.id.view_line_user_idcard);
        this.O = findViewById(R.id.view_line_bank_card);
        this.P = findViewById(R.id.view_line_card_date);
        this.Q = findViewById(R.id.view_line_card_cvv2);
        this.L = findViewById(R.id.view_bind_card_phone_line);
        this.h = (TextView) findViewById(R.id.tv_login_user_phone_tip);
        this.f3582i = (TextView) findViewById(R.id.tv_user_type_err);
        this.j = (TextView) findViewById(R.id.tv_phone_err);
        this.k = (TextView) findViewById(R.id.tv_card_date_err);
        this.l = (TextView) findViewById(R.id.tv_card_cvv2_err);
        this.t = (ImageView) findViewById(R.id.iv_new_bind_card_user_clear_icon);
        this.H = (LinearLayout) findViewById(R.id.lin_bind_card_safe_tip);
        this.ae = findViewById(R.id.lin_id_card_start_date_area);
        this.af = findViewById(R.id.lin_id_card_end_date_area);
        this.ag = findViewById(R.id.lin_nationality_area);
        this.ah = findViewById(R.id.lin_gender_area);
        this.al = (LinearLayout) findViewById(R.id.lin_start_date);
        this.am = (LinearLayout) findViewById(R.id.lin_end_date);
        this.an = (LinearLayout) findViewById(R.id.lin_id_card_long_date_area);
        this.ao = (CheckBox) findViewById(R.id.cb_id_card_long_date);
        this.ai = findViewById(R.id.lin_job_and_address);
        this.aj = findViewById(R.id.job_area);
        this.ak = findViewById(R.id.address_area);
        this.ap = (LinearLayout) findViewById(R.id.lin_job);
        this.aq = (LinearLayout) findViewById(R.id.lin_address);
        this.ar = (TextView) findViewById(R.id.tv_id_card_start_date);
        this.as = (TextView) findViewById(R.id.tv_id_card_end_date);
        this.at = (TextView) findViewById(R.id.tv_gender);
        this.au = (TextView) findViewById(R.id.tv_nationality);
        this.av = (TextView) findViewById(R.id.tv_job);
        this.aw = (TextView) findViewById(R.id.tv_address);
        this.ax = findViewById(R.id.view_line_start_date);
        this.ay = findViewById(R.id.view_line_end_date);
        this.az = findViewById(R.id.view_line_nationality);
        this.aA = findViewById(R.id.view_line_job);
        this.G.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.ai.setVisibility(8);
        this.f3583o.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.c.setText("确认");
        if (this.ac.q()) {
            this.G.setBackgroundResource(R.drawable.dxm_wallet_base_red_fa5050_btn);
        } else {
            this.G.setBackgroundResource(R.drawable.dxm_wallet_base_blue_397be6_btn);
        }
        b();
        this.ac.b();
        this.ac.c();
        this.ac.d();
        this.ac.e();
        this.ac.f();
        this.ac.h();
        c();
        this.ac.i();
        this.ac.g();
        this.u.setOnMyFocusChangeListener(this);
        this.v.setOnMyFocusChangeListener(this);
        this.I.setOnMyFocusChangeListener(this);
        this.w.setOnMyFocusChangeListener(this);
        this.x.setOnMyFocusChangeListener(this);
        this.J.setOnMyFocusChangeListener(this);
        e();
        this.ac.a(this.u, this.f3583o);
        i();
        this.ac.a(this.w, this.q);
        this.ac.a(this.x, this.r);
        CardAddResponse instance = CardAddResponse.getInstance();
        int i3 = 0;
        if (instance == null || (userModel = instance.user) == null) {
            i2 = 0;
        } else {
            int i4 = userModel.age;
            i3 = userModel.gender;
            i2 = i4;
        }
        if (i3 == 1) {
            str = ResUtils.getString(this, "ebpay_man_tip");
        } else {
            str = i3 == 2 ? ResUtils.getString(this, "ebpay_woman_tip") : "";
        }
        a(i2, str);
    }

    private void b(boolean z2) {
        int i2 = z2 ? 0 : 8;
        this.ag.setVisibility(i2);
        this.az.setVisibility(i2);
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("****")) {
                sb.insert(10, " ");
                sb.insert(9, " ");
                sb.insert(8, " ");
                sb.insert(7, " ");
                sb.insert(3, " ");
                sb.insert(2, " ");
                sb.insert(1, " ");
            } else {
                for (int length = str.length() - 1; length > 0; length--) {
                    sb.insert(length, " ");
                }
            }
            AccessibilityUtils.setGroupDescription(this.B, this.h.getText() + sb.toString());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        a aVar;
        if (i2 <= 0 || (aVar = this.ac) == null) {
            a(false);
            a(i2, false);
            b(false);
            a(str, false);
            a(i2, false, false);
            a(false, false);
            return;
        }
        a(aVar.j());
        a(i2, this.ac.k());
        b(this.ac.l());
        a(str, this.ac.m());
        a(i2, this.ac.n(), this.ac.o());
        a(this.ac.n(), this.ac.o());
    }

    private void a(boolean z2) {
        int i2 = z2 ? 0 : 8;
        this.ae.setVisibility(i2);
        this.ax.setVisibility(i2);
        this.ar.setText((CharSequence) null);
        this.al.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewBindCardMainActivity.this.a(PayStatServiceEvent.BIND_CARD_CLICK_START_DATE, "点击开始日期");
                Calendar instance = Calendar.getInstance();
                int i2 = Calendar.getInstance().get(1);
                int i3 = Calendar.getInstance().get(2);
                int i4 = Calendar.getInstance().get(5);
                instance.set(DxmShowDateActivity.START_YEAR, 0, 1);
                Calendar instance2 = Calendar.getInstance();
                instance2.set(i2, i3, i4);
                com.baidu.wallet.paysdk.ui.widget.compliance.d.a.a().a(NewBindCardMainActivity.this, instance, instance2, new b() {
                    public void a(int i2, String str) {
                        if (i2 == 0 && !TextUtils.isEmpty(str)) {
                            NewBindCardMainActivity.this.ar.setText(str);
                        }
                        NewBindCardMainActivity.this.c();
                    }
                });
            }
        });
    }

    private void a(int i2, boolean z2) {
        int i3 = z2 ? 0 : 8;
        this.af.setVisibility(i3);
        this.ay.setVisibility(i3);
        this.as.setText((CharSequence) null);
        this.ao.setChecked(false);
        if (i2 > 45) {
            this.as.setHint(ResUtils.getString(this, "ebpay_id_card_end_date_long_hint"));
            this.an.setVisibility(0);
            this.an.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardMainActivity.this.a(PayStatServiceEvent.BIND_CARD_CLICK_LONG_DATE, "点击长期有效");
                    NewBindCardMainActivity.this.ao.setChecked(!NewBindCardMainActivity.this.ao.isChecked());
                    NewBindCardMainActivity.this.as.setText((CharSequence) null);
                    NewBindCardMainActivity.this.c();
                }
            });
            this.ao.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardMainActivity.this.a(PayStatServiceEvent.BIND_CARD_CLICK_LONG_DATE, "点击长期有效");
                    if (NewBindCardMainActivity.this.ao.isChecked()) {
                        NewBindCardMainActivity.this.as.setText((CharSequence) null);
                    }
                    NewBindCardMainActivity.this.c();
                }
            });
        } else {
            this.as.setHint(ResUtils.getString(this, "ebpay_id_card_end_date_hint"));
            this.an.setVisibility(8);
        }
        this.am.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewBindCardMainActivity.this.a(PayStatServiceEvent.BIND_CARD_CLICK_END_DATE, "点击结束日期");
                Calendar instance = Calendar.getInstance();
                int i2 = Calendar.getInstance().get(1);
                int i3 = Calendar.getInstance().get(2);
                int i4 = Calendar.getInstance().get(5);
                instance.set(i2, i3, i4);
                Calendar instance2 = Calendar.getInstance();
                instance2.set(i2 + 20, i3, i4);
                com.baidu.wallet.paysdk.ui.widget.compliance.d.a.a().a(NewBindCardMainActivity.this, instance, instance2, new b() {
                    public void a(int i2, String str) {
                        if (i2 == 0 && !TextUtils.isEmpty(str)) {
                            NewBindCardMainActivity.this.as.setText(str);
                            NewBindCardMainActivity.this.ao.setChecked(false);
                        }
                        NewBindCardMainActivity.this.c();
                    }
                });
            }
        });
    }

    private void a(String str, boolean z2) {
        this.ah.setVisibility(z2 ? 0 : 8);
        this.at.setText(str);
        c();
    }

    private void a(final int i2, boolean z2, boolean z3) {
        if (!z2 && !z3) {
            this.ai.setVisibility(8);
        } else if (z2) {
            this.ai.setVisibility(0);
            this.aj.setVisibility(0);
            this.aA.setVisibility(0);
            this.av.setText((CharSequence) null);
            this.ap.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardMainActivity.this.a(PayStatServiceEvent.BIND_CARD_CLICK_JOB, "点击职业");
                    com.baidu.wallet.paysdk.ui.widget.compliance.d.a.a().a(NewBindCardMainActivity.this, new c() {
                        public void a(int i2, DxmJob dxmJob) {
                            if (i2 == 0 && dxmJob != null) {
                                if ((i2 < 45 || !"10002".equals(dxmJob.lowerJobId)) && (i2 > 16 || !"10003".equals(dxmJob.lowerJobId))) {
                                    DxmJob unused = NewBindCardMainActivity.this.aB = dxmJob;
                                    if (!TextUtils.isEmpty(dxmJob.lowerJobName)) {
                                        NewBindCardMainActivity.this.av.setText(dxmJob.lowerJobName);
                                    } else {
                                        NewBindCardMainActivity.this.av.setText(dxmJob.jobName);
                                    }
                                } else {
                                    DxmJob unused2 = NewBindCardMainActivity.this.aB = null;
                                    NewBindCardMainActivity.this.av.setText((CharSequence) null);
                                    NewBindCardMainActivity newBindCardMainActivity = NewBindCardMainActivity.this;
                                    GlobalUtils.toast(newBindCardMainActivity, ResUtils.getString(newBindCardMainActivity, "dxm_choice_job_err_tip"));
                                }
                                NewBindCardMainActivity.this.c();
                            }
                        }
                    });
                }
            });
        } else {
            this.aj.setVisibility(8);
            this.aA.setVisibility(8);
        }
    }

    private void a(boolean z2, boolean z3) {
        if (z2 || z3) {
            if (!z2 || !z3) {
                this.aA.setVisibility(8);
            }
            if (z3) {
                this.aw.setText((CharSequence) null);
                this.ai.setVisibility(0);
                this.ak.setVisibility(0);
                this.aq.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        NewBindCardMainActivity.this.a(PayStatServiceEvent.BIND_CARD_CLICK_ADDRESS, "点击地址");
                        com.baidu.wallet.paysdk.ui.widget.compliance.d.a a2 = com.baidu.wallet.paysdk.ui.widget.compliance.d.a.a();
                        NewBindCardMainActivity newBindCardMainActivity = NewBindCardMainActivity.this;
                        a2.a(newBindCardMainActivity, newBindCardMainActivity.aC, new com.baidu.wallet.paysdk.ui.widget.compliance.b.a() {
                            public void a(int i2, DxmAddress dxmAddress) {
                                if (i2 == 0 && dxmAddress != null) {
                                    DxmAddress unused = NewBindCardMainActivity.this.aC = dxmAddress;
                                    TextView h = NewBindCardMainActivity.this.aw;
                                    h.setText(dxmAddress.provinceName + dxmAddress.cityName + dxmAddress.countyName + dxmAddress.address);
                                }
                                NewBindCardMainActivity.this.c();
                            }
                        });
                    }
                });
                return;
            }
            this.ak.setVisibility(8);
            return;
        }
        this.ai.setVisibility(8);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            ViewCompat.setAccessibilityDelegate(this.J, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    String obj = NewBindCardMainActivity.this.J.getText().toString();
                    StringBuilder sb = new StringBuilder(obj);
                    if (obj.contains("****")) {
                        sb.insert(12, " ");
                        sb.insert(11, " ");
                        sb.insert(10, " ");
                        sb.insert(3, " ");
                        sb.insert(2, " ");
                        sb.insert(1, " ");
                    } else if (obj.length() == 0) {
                        sb.append(NewBindCardMainActivity.this.J.getHint());
                        accessibilityNodeInfoCompat.setHintText((CharSequence) null);
                    } else {
                        for (int length = obj.length() - 1; length > 0; length--) {
                            sb.insert(length, " ");
                        }
                    }
                    accessibilityNodeInfoCompat.setText(sb);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(float f2) {
        getWindow().addFlags(2);
        this.a.setAlpha(f2);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        com.baidu.wallet.newbindcard.c.a.a(str, BIND_CARD_MAIN_HASH_NAME, BIND_CARD_MAIN_HASH_ID, str2, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), com.baidu.wallet.newbindcard.c.a.c(), com.baidu.wallet.newbindcard.c.a.d());
    }
}
