package com.dxmpay.wallet.base.datamodel;

import android.text.TextUtils;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.Serializable;
import java.math.BigDecimal;

public class UserData implements NoProguard {
    public static final String TAG = "UserData";

    public static class FingerprintAuthInfo implements NoProguard, Serializable {
        public String uafRequest;
    }

    public static class Misc implements NoProguard, Serializable {
        public static final long serialVersionUID = 993460856554011232L;
        public ConfirmButtonMsg msg_pay_btn;
        public String no_mobilepwd_msg;
        public String nopass_msg;
        public String title_url;
        public String trans_need_to_pay;

        public static class ConfirmButtonMsg implements NoProguard, Serializable {
            public String default_msg;
            public String new_card;
            public String nopass;
            public String transfer2card;

            public String getDefault_msg() {
                return this.default_msg;
            }

            public String getNew_card() {
                return this.new_card;
            }

            public String getNopass() {
                return this.nopass;
            }
        }

        public String getInsideTransOrder() {
            return this.trans_need_to_pay;
        }

        public ConfirmButtonMsg getPayButtonMsg() {
            return this.msg_pay_btn;
        }
    }

    public static class SP implements NoProguard, Serializable {
        public static final long serialVersionUID = 993460856554011232L;
        public String goods_name;
        public String seller_user_id;
        public String serial_num;
        public String session_no;
        public String sp_company;
        public String sp_no;

        public String getSellerUserId() {
            return this.seller_user_id;
        }

        public String toString() {
            return "[sp_company=" + this.sp_company + "]";
        }
    }

    public static class UserModel implements NoProguard, Serializable {
        public static final String STATUS_LOGINED = "1";
        public static final long serialVersionUID = -1273103909085078415L;
        public Account account;
        public int age = 0;
        public int auth_status;
        public String authorize_display_name;
        public int balance_pay_status;
        public String balance_support_status = "1";
        public String balance_unsupport_reason;
        public String can_use_pcpwd_verify;
        public String certificate_code;
        public String certificate_code_ec;
        public String certificate_type;
        public String certificate_type_name;
        public DisplayFlag display_flag;
        public String display_name;
        public String enable_fingerprint;
        public FingerprintAuthInfo fingerprint_auth_info;
        public FingerprintMsg fingerprint_msg;
        public int gender;
        public String guide_to_open_fingerprint;
        public int has_mobile_password = 0;
        public int is_authed;
        public String is_login;
        public int is_repaired;
        public String last3_paytype;
        public String login_name;
        public String mobile;
        public String mobile_ec;
        public String mobile_number;
        public String need_pay_password = "1";
        public String passfree_msg;
        public PassFreeProtocol passfree_protocol;
        public String passfree_selected = "1";
        public int pwd_left_count;
        public Score score;
        public int stark_account_level;
        public String stark_auth_msg;
        public String stark_balance_msg;
        public String true_name;
        public String user_id;

        public static class Account implements Serializable {
            public static final long serialVersionUID = 2427773423716342178L;
            public String available_withdraw_amount;
            public String balance_amount;
            public String can_amount;
            public String can_amount3;
            public String freeze_amount;
            public String recv_amount;
            public String recv_create_time;
            public String recv_info;
            public String return_cash_content = "";
            public String return_cash_url = "";
            public String virtual_amount;

            public String getCanAmount() {
                return !TextUtils.isEmpty(this.can_amount) ? this.can_amount : "0";
            }

            public boolean hasCanAmount() {
                if (TextUtils.isEmpty(this.can_amount)) {
                    return false;
                }
                try {
                    if (new BigDecimal(this.can_amount).compareTo(BigDecimal.ZERO) > 0) {
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }

            public boolean isBalanceEnough(String str) {
                if (TextUtils.isEmpty(this.can_amount) || TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    if (new BigDecimal(this.can_amount).compareTo(new BigDecimal(str)) >= 0) {
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }

            public String toString() {
                return "钱包余额信息-->[balance_amount:" + this.balance_amount + "&freeze_amount:" + this.freeze_amount + "&virtual_amount:" + this.virtual_amount + "&can_amount:" + this.can_amount + "&available_withdraw_amount:" + this.available_withdraw_amount + "]";
            }
        }

        public static class DisplayFlag implements Serializable {
            public static final String NOT_SHOW = "1";
            public static final String SHOW_AND_WRITE = "3";
            public static final String SHOW_NOT_WRITE = "2";
            public static final long serialVersionUID = -6111380299465016961L;
            public String certificate_code = "";
            public String certificate_type = "";
            public String mobile = "";
            public String true_name = "";

            public String getCodeFlag() {
                return this.certificate_code;
            }

            public String getMobileFlag() {
                return this.mobile;
            }

            public String getNameFlag() {
                return this.true_name;
            }
        }

        public static class FingerprintMsg implements NoProguard, Serializable {
            public Open open;
            public Reopen reopen;
            public Update update;

            public static class Open implements NoProguard, Serializable {
                public FingerprintProtocol fingerprint_protocol;
                public String[] hints;
                public String subtitle;
                public String title;

                public static class FingerprintProtocol implements NoProguard, Serializable {
                    public String fingerprint_protocol_msg;
                    public String fingerprint_protocol_prefix;
                    public String fingerprint_protocol_url;

                    public String getFingerprintProtocolMsg() {
                        return this.fingerprint_protocol_msg;
                    }

                    public String getFingerprintProtocolPrefix() {
                        return this.fingerprint_protocol_prefix;
                    }

                    public String getFingerprintProtocolUrl() {
                        return this.fingerprint_protocol_url;
                    }
                }

                public FingerprintProtocol getFingerprintProtocol() {
                    return this.fingerprint_protocol;
                }

                public String[] getHints() {
                    return this.hints;
                }

                public String getSubtitle() {
                    return this.subtitle;
                }

                public String getTitle() {
                    return this.title;
                }
            }

            public static class Reopen implements NoProguard, Serializable {
                public FingerprintProtocol fingerprint_protocol;
                public String subtitle;
                public String title;

                public static class FingerprintProtocol implements NoProguard, Serializable {
                    public String fingerprint_protocol_msg;
                    public String fingerprint_protocol_prefix;
                    public String fingerprint_protocol_url;

                    public String getFingerprintProtocolMsg() {
                        return this.fingerprint_protocol_msg;
                    }

                    public String getFingerprintProtocolPrefix() {
                        return this.fingerprint_protocol_prefix;
                    }

                    public String getFingerprintProtocolUrl() {
                        return this.fingerprint_protocol_url;
                    }
                }

                public FingerprintProtocol getFingerprintProtocol() {
                    return this.fingerprint_protocol;
                }

                public String getSubtitle() {
                    return this.subtitle;
                }

                public String getTitle() {
                    return this.title;
                }
            }

            public static class Update implements NoProguard, Serializable {
                public String subtitle;
                public String title;

                public String getSubtitle() {
                    return this.subtitle;
                }

                public String getTitle() {
                    return this.title;
                }
            }

            public Open getOpen() {
                return this.open;
            }

            public Reopen getReopen() {
                return this.reopen;
            }

            public Update getUpdate() {
                return this.update;
            }
        }

        public static class PassFreeProtocol implements NoProguard, Serializable {
            public String passfree_protocol_msg;
            public String passfree_protocol_prefix;
            public String passfree_protocol_url;

            public String getPassfreeProtocolMsg() {
                return this.passfree_protocol_msg;
            }

            public String getPassfreeProtocolPrefix() {
                return this.passfree_protocol_prefix;
            }

            public String getPassfreeProtocolUrl() {
                return this.passfree_protocol_url;
            }
        }

        public static class Score implements Serializable {
            public static final long serialVersionUID = 606605370857740501L;
            public String can_cash;
            public String score_num;
            public String score_tip;

            public boolean hasScore() {
                if (TextUtils.isEmpty(this.score_num) || TextUtils.isEmpty(this.can_cash)) {
                    return false;
                }
                try {
                    if (new BigDecimal(this.score_num).compareTo(BigDecimal.ZERO) > 0) {
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
        }

        public void decrypt() {
            try {
                if (!TextUtils.isEmpty(this.certificate_code_ec)) {
                    this.certificate_code = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.certificate_code_ec));
                }
                if (!TextUtils.isEmpty(this.mobile_ec)) {
                    this.mobile_number = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.mobile_ec));
                }
            } catch (Exception e) {
                LogUtil.e(UserData.TAG, e.getMessage(), e);
            }
        }

        public String getCanAmount() {
            Account account2 = this.account;
            if (account2 == null) {
                return "0";
            }
            return account2.getCanAmount();
        }

        public FingerprintMsg getFingerprintMsg() {
            return this.fingerprint_msg;
        }

        public String getMoneyUrl() {
            Account account2 = this.account;
            return account2 != null ? account2.return_cash_url : "";
        }

        public String getPassfreeMsg() {
            return this.passfree_msg;
        }

        public PassFreeProtocol getPassfreeProtocol() {
            return this.passfree_protocol;
        }

        public boolean getPassfreeSelected() {
            return "1".equals(this.passfree_selected);
        }

        public String getRecvInfo() {
            Account account2 = this.account;
            return account2 != null ? account2.recv_info : "";
        }

        public String getTotalBackContent() {
            Account account2 = this.account;
            return account2 != null ? account2.return_cash_content : "";
        }

        public boolean hasCanAmount() {
            Account account2 = this.account;
            if (account2 == null) {
                return false;
            }
            return account2.hasCanAmount();
        }

        public boolean hasMobilePwd() {
            return this.has_mobile_password == 1;
        }

        public boolean isSupportBalance() {
            return "1".equals(this.balance_support_status);
        }

        public void setHasMobilePwd() {
            this.has_mobile_password = 1;
        }
    }
}
