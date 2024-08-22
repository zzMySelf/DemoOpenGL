package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.base.widget.BorderTipTextView;
import com.dxmpay.wallet.base.widget.LinkNoScrollMovementMethod;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;

public class PayTypeItemView extends RelativeLayout {
    public static final String MARKING_EVENT_TAG = "营销信息展示";
    public NetImageView a;
    public TextView b;
    public BorderTipTextView c;
    public TextView d;
    public ImageView e;
    public Context mContext;
    public PayTypeItemViewData mData;
    public ProgressBar mProgress;

    public enum ItemViewType implements Serializable {
        BANKCARD,
        BALANCE,
        CREDIT,
        ADD_NEWCARD
    }

    public static class PayTypeItemViewData implements Serializable {
        public static final String MASK_FLAG = "^";
        public CardData.BondCard card;
        public boolean highlight;
        public String hintMsg;
        public String hintUrl;
        public boolean isAvaible;
        public boolean isChecked;
        public boolean isRecommended;
        public String jump_url;
        public String logoUrl;
        public String name;
        public String tips;
        public ItemViewType type;

        public int getEndIndex(String str) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return str.lastIndexOf(MASK_FLAG);
        }

        public int getStartIndex(String str) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return str.indexOf(MASK_FLAG);
        }

        public boolean isNeedToColored() {
            int startIndex = getStartIndex(this.tips);
            int endIndex = getEndIndex(this.tips);
            return (-1 == startIndex || -1 == endIndex || startIndex >= endIndex) ? false : true;
        }

        public String removeSeparator(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int startIndex = getStartIndex(str);
            int endIndex = getEndIndex(str);
            if (startIndex == -1 || endIndex == -1 || startIndex >= endIndex) {
                return str;
            }
            return str.substring(0, startIndex) + str.substring(startIndex + 1, endIndex) + str.substring(endIndex + 1);
        }
    }

    public PayTypeItemView(Context context) {
        super(context.getApplicationContext());
        this.mContext = context.getApplicationContext();
    }

    private void a(PayTypeItemViewData payTypeItemViewData, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        boolean z;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        PayTypeItemViewData payTypeItemViewData2 = payTypeItemViewData;
        View.OnClickListener onClickListener3 = onClickListener2;
        this.mData = payTypeItemViewData2;
        View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_paytype_item_view"), this);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(ResUtils.id(getContext(), "ebpay_mini_progress_bar"));
        this.mProgress = progressBar;
        progressBar.setVisibility(8);
        this.e = (ImageView) inflate.findViewById(ResUtils.id(getContext(), "paytype_select"));
        this.a = (NetImageView) findViewById(ResUtils.id(this.mContext, "ebpay_paytype_logo"));
        this.b = (TextView) findViewById(ResUtils.id(this.mContext, "paytype_name"));
        if (!TextUtils.isEmpty(payTypeItemViewData2.name)) {
            this.b.setText(payTypeItemViewData2.name);
        }
        TextView textView = (TextView) inflate.findViewById(ResUtils.id(getContext(), "paytype_free_amount"));
        if (ItemViewType.BANKCARD == payTypeItemViewData2.type) {
            CardData.BondCard bondCard = payTypeItemViewData2.card;
            z = bondCard != null && !TextUtils.isEmpty(bondCard.channelDiscountDesc);
            if (z) {
                textView.setVisibility(0);
                textView.setText(payTypeItemViewData2.card.channelDiscountDesc);
            } else {
                CardData.BondCard bondCard2 = payTypeItemViewData2.card;
                String str = bondCard2.card_hd_title;
                if (bondCard2 != null && !TextUtils.isEmpty(str)) {
                    textView.setVisibility(0);
                    textView.setText(str);
                    StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PAY_METHOD_MARKING_SHOW_DETAIL, PayTypeActivity.PAY_TYPE_HASH_NAME, PayTypeActivity.PAY_TYPE_HASH_ID, MARKING_EVENT_TAG, StatHelper.getProcesssId(), payTypeItemViewData2.name, str, payTypeItemViewData2.card.bank_name);
                }
            }
        } else {
            z = false;
        }
        inflate.findViewById(ResUtils.id(getContext(), "paytype_recommended")).setVisibility(payTypeItemViewData2.isRecommended ? 0 : 4);
        this.c = (BorderTipTextView) findViewById(ResUtils.id(this.mContext, "paytype_tip"));
        if (TextUtils.isEmpty(payTypeItemViewData2.tips) || (z && payTypeItemViewData2.tips.equals(textView.getText()))) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            if (payTypeItemViewData.isNeedToColored()) {
                a(payTypeItemViewData, onClickListener);
            } else {
                this.c.setText(payTypeItemViewData2.tips, payTypeItemViewData2.highlight);
            }
        }
        this.d = (TextView) findViewById(ResUtils.id(this.mContext, "paytype_hint"));
        if (!TextUtils.isEmpty(payTypeItemViewData2.hintMsg)) {
            this.d.setVisibility(0);
            this.d.setText(payTypeItemViewData2.hintMsg);
            LinearLayout linearLayout = (LinearLayout) this.d.getParent();
            linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), 0);
            if (onClickListener3 != null) {
                this.d.setOnClickListener(onClickListener3);
            }
        } else {
            this.d.setVisibility(8);
        }
        ItemViewType itemViewType = payTypeItemViewData2.type;
        if (itemViewType == ItemViewType.ADD_NEWCARD) {
            this.e.setImageDrawable(ResUtils.getDrawable(this.mContext, "dxm_wallet_base_paytype_item_right_arrow"));
            this.e.setVisibility(0);
            this.a.setImageDrawable(ResUtils.getDrawable(this.mContext, "wallet_base_paytype_add_newcard"));
            this.c.setVisibility(8);
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse == null || (directPayPay = payResponse.pay) == null || (easyPay = directPayPay.easypay) == null || TextUtils.isEmpty(easyPay.bind_card_hd_title)) {
                textView.setVisibility(8);
            } else {
                String str2 = payResponse.pay.easypay.bind_card_hd_title;
                textView.setVisibility(0);
                textView.setText(str2);
                StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PAY_METHOD_MARKING_SHOW_DETAIL, PayTypeActivity.PAY_TYPE_HASH_NAME, PayTypeActivity.PAY_TYPE_HASH_ID, MARKING_EVENT_TAG, StatHelper.getProcesssId(), payTypeItemViewData2.name, str2);
            }
        } else if (itemViewType == ItemViewType.BALANCE) {
            this.a.setImageDrawable(ResUtils.getDrawable(this.mContext, "dxm_wallet_base_paytype_balance"));
        } else if (itemViewType == ItemViewType.CREDIT) {
            this.a.setImageDrawable(ResUtils.getDrawable(this.mContext, "dxm_wallet_base_paytype_credit"));
        } else if (itemViewType == ItemViewType.BANKCARD && !TextUtils.isEmpty(payTypeItemViewData2.logoUrl)) {
            this.a.setImageUrl(payTypeItemViewData2.logoUrl);
        }
        if (payTypeItemViewData2.isAvaible) {
            ViewHelper.setAlpha(inflate, 1.0f);
            if (payTypeItemViewData2.type == ItemViewType.ADD_NEWCARD) {
                this.e.setVisibility(0);
            } else if (payTypeItemViewData2.isChecked) {
                this.e.setVisibility(0);
                this.e.setSelected(true);
            } else {
                this.e.setSelected(false);
                this.e.setVisibility(4);
            }
        } else {
            ViewHelper.setAlphaPartly(inflate, 0.4f, this.c);
            if (payTypeItemViewData.isNeedToColored()) {
                inflate.setEnabled(false);
            } else {
                inflate.setEnabled(true);
            }
            this.e.setVisibility(8);
        }
    }

    public static PayTypeItemView generateItemView(Context context, PayTypeItemViewData payTypeItemViewData, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (context == null) {
            return null;
        }
        PayTypeItemView payTypeItemView = new PayTypeItemView(context);
        payTypeItemView.a(payTypeItemViewData, onClickListener, onClickListener2);
        return payTypeItemView;
    }

    public void setItemState(boolean z) {
        this.e.setVisibility(8);
        if (z) {
            this.mProgress.setVisibility(0);
        } else {
            this.mProgress.setVisibility(8);
        }
    }

    private void a(PayTypeItemViewData payTypeItemViewData, final View.OnClickListener onClickListener) {
        if (payTypeItemViewData != null && !TextUtils.isEmpty(payTypeItemViewData.tips) && payTypeItemViewData.isNeedToColored()) {
            int startIndex = payTypeItemViewData.getStartIndex(payTypeItemViewData.tips);
            int endIndex = payTypeItemViewData.getEndIndex(payTypeItemViewData.tips);
            SpannableString spannableString = new SpannableString(payTypeItemViewData.removeSeparator(payTypeItemViewData.tips));
            int i2 = endIndex - 1;
            spannableString.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    onClickListener.onClick(view);
                }

                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }
            }, startIndex, i2, 18);
            spannableString.setSpan(new ForegroundColorSpan(ResUtils.getColor(this.mContext, "dxm_wallet_base_mainColor")), startIndex, i2, 18);
            if (!TextUtils.isEmpty(payTypeItemViewData.jump_url)) {
                this.c.setClickable(true);
                this.c.setEnabled(true);
            } else {
                this.c.setClickable(false);
                this.c.setEnabled(false);
            }
            this.c.setMovementMethod(new LinkNoScrollMovementMethod());
            this.c.setText(spannableString);
        }
    }
}
