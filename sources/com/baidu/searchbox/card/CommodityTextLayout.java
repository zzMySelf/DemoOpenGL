package com.baidu.searchbox.card;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.card.model.PayCardModel;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.push.R;
import java.util.ArrayList;
import java.util.Iterator;

public class CommodityTextLayout extends LinearLayout {
    private static int COMMODITY_DATA_INDEX = 1;
    private static int MAX_FIRST_COLUMN_WIDTH = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.msg_pay_notify_producer_name_width);
    private static int MAX_NAME_LINE = 3;
    private static int MAX_TITLE_EMS = 6;
    private static int MAX_TITLE_LINE = 1;
    private static int NAME_VIEW_INDEX = 1;
    private static int PAYMENT_DATA_INDEX = 2;
    private static int PRODUCER_DATA_INDEX = 0;
    private static int TITLE_VIEW_INDEX = 0;
    private final boolean DEBUG = AppConfig.isDebug();
    private final String TAG = "PayNotifyCardView";
    private ViewGroup mCommodityNameLayout;
    private int mFirstColumnWidth = 0;
    private ViewGroup mPaymentLayout;
    private ViewGroup mProducerNameLayout;
    private int mSecColumnLeftMargin = 0;

    public CommodityTextLayout(Context context) {
        super(context);
    }

    public CommodityTextLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommodityTextLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void updateData(ArrayList<PayCardModel.BodyItem> bodys) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (this.DEBUG) {
            Log.d("PayNotifyCardView", "------------------>updateData: ");
        }
        filterInvalidData(bodys);
        if (bodys == null || bodys.size() < 1) {
            setVisibility(8);
            return;
        }
        ArrayList<String> displayLists = new ArrayList<>();
        Iterator<PayCardModel.BodyItem> it = bodys.iterator();
        while (it.hasNext()) {
            displayLists.add(it.next().getMName());
        }
        this.mFirstColumnWidth = 0;
        Iterator<String> it2 = displayLists.iterator();
        while (it2.hasNext()) {
            this.mFirstColumnWidth = Math.max(this.mFirstColumnWidth, getTextLength(it2.next()));
        }
        if (this.mFirstColumnWidth == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int i2 = this.mFirstColumnWidth;
        int i3 = MAX_FIRST_COLUMN_WIDTH;
        if (i2 > i3) {
            i2 = i3;
        }
        this.mFirstColumnWidth = i2;
        this.mSecColumnLeftMargin = i2 + getContext().getResources().getDimensionPixelSize(R.dimen.msg_pay_notify_producer_name_margin_left);
        ViewGroup viewGroup3 = this.mProducerNameLayout;
        if (viewGroup3 == null) {
            this.mProducerNameLayout = buildItemViews(bodys.get(PRODUCER_DATA_INDEX));
        } else {
            updateItemViews(viewGroup3, bodys.get(PRODUCER_DATA_INDEX));
        }
        int size = bodys.size();
        int i4 = COMMODITY_DATA_INDEX;
        if (size >= i4 + 1) {
            ViewGroup viewGroup4 = this.mCommodityNameLayout;
            if (viewGroup4 == null) {
                this.mCommodityNameLayout = buildItemViews(bodys.get(i4));
            } else {
                updateItemViews(viewGroup4, bodys.get(i4));
            }
            ViewGroup viewGroup5 = this.mCommodityNameLayout;
            if (viewGroup5 != null && viewGroup5.getVisibility() == 0 && (viewGroup2 = this.mProducerNameLayout) != null && viewGroup2.getVisibility() == 0) {
                LinearLayout.LayoutParams secondParams = (LinearLayout.LayoutParams) this.mCommodityNameLayout.getLayoutParams();
                secondParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.msg_pay_notify_commodity_name_margin_top);
                this.mCommodityNameLayout.setLayoutParams(secondParams);
            }
            int size2 = bodys.size();
            int i5 = PAYMENT_DATA_INDEX;
            if (size2 >= i5 + 1) {
                ViewGroup viewGroup6 = this.mPaymentLayout;
                if (viewGroup6 == null) {
                    this.mPaymentLayout = buildItemViews(bodys.get(i5));
                } else {
                    updateItemViews(viewGroup6, bodys.get(i5));
                }
                ViewGroup viewGroup7 = this.mPaymentLayout;
                if (viewGroup7 != null && viewGroup7.getVisibility() == 0) {
                    ViewGroup viewGroup8 = this.mProducerNameLayout;
                    if ((viewGroup8 != null && viewGroup8.getVisibility() == 0) || ((viewGroup = this.mCommodityNameLayout) != null && viewGroup.getVisibility() == 0)) {
                        LinearLayout.LayoutParams thirdParams = (LinearLayout.LayoutParams) this.mPaymentLayout.getLayoutParams();
                        thirdParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.msg_pay_notify_commodity_name_margin_top);
                        this.mPaymentLayout.setLayoutParams(thirdParams);
                    }
                }
            }
        }
    }

    private void filterInvalidData(ArrayList<PayCardModel.BodyItem> bodys) {
        if (bodys != null && bodys.size() >= 1) {
            Iterator<PayCardModel.BodyItem> iterator = bodys.iterator();
            while (iterator != null && iterator.hasNext()) {
                PayCardModel.BodyItem item = iterator.next();
                if (TextUtils.isEmpty(item.getMName()) || TextUtils.isEmpty(item.getMValue())) {
                    iterator.remove();
                }
            }
        }
    }

    private void updateItemViews(ViewGroup layout, PayCardModel.BodyItem bodyItem) {
        if (!isDataValid(bodyItem)) {
            layout.setVisibility(8);
            return;
        }
        View firstView = layout.getChildAt(TITLE_VIEW_INDEX);
        FrameLayout.LayoutParams firstParams = (FrameLayout.LayoutParams) firstView.getLayoutParams();
        firstParams.width = this.mFirstColumnWidth;
        firstView.setLayoutParams(firstParams);
        View secondView = layout.getChildAt(NAME_VIEW_INDEX);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) secondView.getLayoutParams();
        params.leftMargin = this.mSecColumnLeftMargin;
        secondView.setLayoutParams(params);
        ((TextView) layout.getChildAt(TITLE_VIEW_INDEX)).setText(bodyItem.getMName());
        ((TextView) layout.getChildAt(NAME_VIEW_INDEX)).setText(bodyItem.getMValue());
        layout.setVisibility(0);
    }

    public void changTextColor() {
        if (this.DEBUG) {
            Log.d("PayNotifyCardView", "------------------>changTextColor: ");
        }
        if (getVisibility() != 8) {
            updateTextColor(this.mProducerNameLayout);
            updateTextColor(this.mCommodityNameLayout);
            updateTextColor(this.mPaymentLayout);
        }
    }

    private void updateTextColor(ViewGroup parent) {
        if (parent != null && parent.getVisibility() != 8) {
            ((TextView) parent.getChildAt(TITLE_VIEW_INDEX)).setTextColor(getContext().getResources().getColor(R.color.msg_pay_notify_producer_name_key_color));
            ((TextView) parent.getChildAt(NAME_VIEW_INDEX)).setTextColor(getContext().getResources().getColor(R.color.msg_pay_notify_source_color));
        }
    }

    private boolean isDataValid(PayCardModel.BodyItem bodyItem) {
        return bodyItem != null && !TextUtils.isEmpty(bodyItem.getMName()) && !TextUtils.isEmpty(bodyItem.getMValue());
    }

    private ViewGroup buildItemViews(PayCardModel.BodyItem item) {
        if (!isDataValid(item)) {
            return null;
        }
        FrameLayout layout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        TextView titleView = new TextView(getContext());
        titleView.setText(item.getMName());
        titleView.setTextColor(getContext().getResources().getColor(R.color.msg_pay_notify_producer_name_key_color));
        titleView.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.msg_pay_notify_producer_name_size));
        titleView.setMaxLines(MAX_TITLE_LINE);
        titleView.setMaxEms(MAX_TITLE_EMS);
        layout.addView(titleView, new FrameLayout.LayoutParams(this.mFirstColumnWidth, -2));
        TextView view2 = new TextView(getContext());
        view2.setText(item.getMValue());
        view2.setTextColor(getContext().getResources().getColor(R.color.msg_pay_notify_source_color));
        view2.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.msg_pay_notify_producer_name_size));
        view2.setMaxLines(MAX_NAME_LINE);
        view2.setEllipsize(TextUtils.TruncateAt.END);
        FrameLayout.LayoutParams viewParams = new FrameLayout.LayoutParams(-2, -2);
        viewParams.leftMargin = this.mSecColumnLeftMargin;
        layout.addView(view2, viewParams);
        addView(layout, layoutParams);
        return layout;
    }

    private int getTextLength(String displayText) {
        Paint mTextPaint = new Paint(1);
        mTextPaint.setColor(getContext().getResources().getColor(R.color.msg_pay_notify_producer_name_key_color));
        mTextPaint.setTextSize((float) getContext().getResources().getDimensionPixelSize(R.dimen.msg_pay_notify_producer_name_size));
        return (int) mTextPaint.measureText(displayText);
    }
}
