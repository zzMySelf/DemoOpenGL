package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.base.widget.BorderTipTextView;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import java.util.ArrayList;

public class SelectBindCardLayout extends LinearLayout {
    public BindFastRequest a;
    public boolean b;
    public b c;

    public class BindCardItemView extends LinearLayout {
        public NetImageView b;
        public TextView c;
        public BorderTipTextView d;
        public ProgressBar e;

        public BindCardItemView(Context context) {
            super(context);
            View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_select_bindcard_list_item_view"), this);
            this.b = (NetImageView) inflate.findViewById(ResUtils.id(getContext(), "ebpay_paytype_logo"));
            this.c = (TextView) inflate.findViewById(ResUtils.id(getContext(), "paytype_name"));
            this.d = (BorderTipTextView) inflate.findViewById(ResUtils.id(getContext(), "paytype_tip"));
            ProgressBar progressBar = (ProgressBar) findViewById(ResUtils.id(getContext(), "ebpay_mini_progress_bar"));
            this.e = progressBar;
            progressBar.setVisibility(8);
        }

        public void setData(CardData.BondCard bondCard) {
            this.b.setImageUrl(bondCard.bank_url);
            findViewById(ResUtils.id(getContext(), "paytype_recommended")).setVisibility(bondCard != null && "1".equals(bondCard.is_recommended) ? 0 : 4);
            String cardDesc = bondCard.getCardDesc(getContext(), true);
            this.c.setText(cardDesc);
            AccessibilityUtils.changeRoleDescription(this, ResUtils.getString(getContext(), "wallet_access_button"));
            AccessibilityUtils.setGroupDescription(this, cardDesc + "，双击选择此银行进行支付");
            if (SelectBindCardLayout.this.a.mBindFrom != 4 && SelectBindCardLayout.this.a.mBindFrom != 5) {
                if ("1".equals(bondCard.card_state) && !TextUtils.isEmpty(bondCard.channelDiscountDesc)) {
                    TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "paytype_free_amount"));
                    textView.setVisibility(0);
                    textView.setText(bondCard.channelDiscountDesc);
                }
                if (!TextUtils.isEmpty(bondCard.bank_card_msg)) {
                    this.d.setVisibility(0);
                    this.d.setText(bondCard.bank_card_msg);
                    this.d.setVisibility(0);
                    return;
                }
                this.d.setVisibility(8);
            } else if (bondCard.getCanFindPWDBySms() || TextUtils.isEmpty(bondCard.unsupport_find_pwd_msg)) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.d.setText(bondCard.unsupport_find_pwd_msg);
            }
        }

        public void setProgressBarVisible(boolean z) {
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                progressBar.setVisibility(z ? 0 : 8);
            }
        }
    }

    public class a extends RelativeLayout {
        public a(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_cashdesk_select_bindcard_list_item_view"), this);
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "paytype_select"));
            imageView.setImageDrawable(ResUtils.getDrawable(context, "dxm_wallet_base_paytype_item_right_arrow"));
            imageView.setVisibility(0);
            ((NetImageView) findViewById(ResUtils.id(getContext(), "ebpay_paytype_logo"))).setImageDrawable(ResUtils.getDrawable(context, "wallet_base_paytype_add_newcard"));
            ((TextView) findViewById(ResUtils.id(getContext(), "paytype_tip"))).setVisibility(8);
            ((TextView) findViewById(ResUtils.id(getContext(), "paytype_name"))).setText(ResUtils.getString(getContext(), "wallet_bindcard_usenewcard_tip"));
            findViewById(ResUtils.id(getContext(), "ebpay_mini_progress_bar")).setVisibility(8);
        }
    }

    public interface b {
        void addNewCardClick();

        void enableCardClick(BindCardItemView bindCardItemView, CardData.BondCard bondCard);
    }

    public SelectBindCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdaptetr(CardData.BondCard[] bondCardArr, boolean z) {
        CardData.BondCard[] a2 = a(bondCardArr);
        this.b = false;
        removeAllViews();
        if (a2 != null && a2.length > 0) {
            if (this.a.mBindFrom == 2) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_title_left"), (ViewGroup) null);
                textView.setText(ResUtils.getString(getContext(), "wallet_bindcard_selectcard_tip"));
                int dimension = (int) ResUtils.getDimension(getContext(), "dxm_wallet_base_margin");
                textView.setPadding(dimension, (int) ResUtils.getDimension(getContext(), "dxm_wallet_base_margin"), dimension, 0);
                addView(textView);
            }
            ScrollView scrollView = new ScrollView(getContext());
            addView(scrollView);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            scrollView.addView(linearLayout);
            for (int i2 = 0; i2 < a2.length; i2++) {
                final CardData.BondCard bondCard = a2[i2];
                if (a(bondCard)) {
                    final BindCardItemView bindCardItemView = new BindCardItemView(getContext());
                    bindCardItemView.setData(a2[i2]);
                    bindCardItemView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (SelectBindCardLayout.this.c != null) {
                                SelectBindCardLayout.this.c.enableCardClick(bindCardItemView, bondCard);
                            }
                        }
                    });
                    linearLayout.addView(bindCardItemView);
                } else {
                    a(linearLayout, z);
                    BindCardItemView bindCardItemView2 = new BindCardItemView(getContext());
                    bindCardItemView2.setData(a2[i2]);
                    ViewHelper.setAlpha(bindCardItemView2, 0.4f);
                    bindCardItemView2.setEnabled(false);
                    bindCardItemView2.setClickable(false);
                    linearLayout.addView(bindCardItemView2);
                }
            }
            a(linearLayout, z);
        }
    }

    public void setBindCardItemClickListener(b bVar) {
        this.c = bVar;
    }

    public void setBindFrom(int i2) {
        this.a = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BindFastRequest.categoryToId(BindFastRequest.getCategory(i2)));
    }

    private void a(ViewGroup viewGroup, final boolean z) {
        if (!this.b) {
            a aVar = new a(getContext());
            aVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (!z) {
                ViewHelper.setAlpha(aVar, 0.4f);
            }
            aVar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!z) {
                        GlobalUtils.toast(SelectBindCardLayout.this.getContext(), ResUtils.getString(SelectBindCardLayout.this.getContext(), "ebpay_bank_count_beyond"));
                    } else if (SelectBindCardLayout.this.c != null) {
                        SelectBindCardLayout.this.c.addNewCardClick();
                    }
                }
            });
            viewGroup.addView(aVar);
            AccessibilityUtils.setGroupDescription(aVar, ResUtils.getString(getContext(), "wallet_access_use_new_card_des"));
            AccessibilityUtils.changeRoleDescription(aVar, ResUtils.getString(getContext(), "wallet_access_button"));
            this.b = true;
        }
    }

    private CardData.BondCard[] a(CardData.BondCard[] bondCardArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (bondCardArr == null || bondCardArr.length <= 0) {
            return null;
        }
        for (CardData.BondCard bondCard : bondCardArr) {
            if (a(bondCard)) {
                arrayList.add(bondCard);
            } else {
                arrayList2.add(bondCard);
            }
        }
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        return (CardData.BondCard[]) arrayList3.toArray(new CardData.BondCard[arrayList3.size()]);
    }

    private boolean a(CardData.BondCard bondCard) {
        int i2 = this.a.mBindFrom;
        if (i2 == 4 || i2 == 5) {
            if (bondCard.getCanFindPWDBySms()) {
                return true;
            }
        } else if ("1".equals(bondCard.card_state)) {
            return true;
        }
        return false;
    }
}
