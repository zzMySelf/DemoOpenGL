package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdMenuItem;
import java.util.List;

public class ContextMenuView extends BdContextMenuView {
    public static final String a = "LightappContextMenuView";
    public static final float b = 0.5f;
    public static final float c = 1.0f;
    public int d = 0;

    @SuppressLint({"NewApi"})
    public ContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private View a(final BdMenuItem bdMenuItem) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getMenuItemViewLayoutId()), this, false);
        TextView textView = (TextView) linearLayout.findViewById(ResUtils.id(getContext(), "title"));
        textView.setText(bdMenuItem.getTitle());
        textView.setTextColor(getResources().getColor(ResUtils.color(getContext(), "wallet_base_font_text1Color")));
        NetImageView netImageView = (NetImageView) linearLayout.findViewById(ResUtils.id(getContext(), "icon"));
        if (!TextUtils.isEmpty(bdMenuItem.getIconUrl())) {
            netImageView.setImageUrl(bdMenuItem.getIconUrl());
        } else {
            Drawable icon = bdMenuItem.getIcon();
            if (icon != null) {
                netImageView.setImageDrawable(icon);
            }
        }
        int paddingBottom = linearLayout.getPaddingBottom();
        linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), paddingBottom);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BdMenuItem.OnItemClickListener onClickListener = bdMenuItem.getOnClickListener();
                if (onClickListener != null) {
                    onClickListener.onClick(bdMenuItem);
                }
            }
        });
        return linearLayout;
    }

    public int getMaxMenuItemWidth() {
        return this.d;
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        return "wallet_base_menu_bg_selector";
    }

    public String getMenuItemViewLayoutId() {
        return "wallet_base_menu_item_web_view";
    }

    public String getSeparatorResId() {
        return "wallet_base_separateColor";
    }

    public void layoutMenu(List<BdMenuItem> list) {
        if (!this.mMenuLoaded) {
            removeAllViews();
            int size = list.size();
            if (size > 0) {
                Context context = getContext();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(context, 0.5f));
                for (int i2 = 0; i2 < size; i2++) {
                    View a2 = a(list.get(i2));
                    a2.measure(0, 0);
                    if (this.d < a2.getMeasuredWidth()) {
                        int measuredWidth = a2.getMeasuredWidth();
                        this.d = measuredWidth;
                        a2.setMinimumWidth(measuredWidth);
                    }
                    if (size == 1) {
                        a2.setBackgroundDrawable(ResUtils.getDrawable(context, "wallet_base_one_menu_item_bg"));
                        addView(a2);
                        return;
                    }
                    if (i2 == 0) {
                        a2.setBackgroundDrawable(ResUtils.getDrawable(context, "wallet_base_menu_first_item_bg"));
                    } else if (i2 == size - 1) {
                        a2.setBackgroundDrawable(ResUtils.getDrawable(context, "wallet_base_menu_last_item_bg"));
                    } else {
                        a2.setBackgroundDrawable(ResUtils.getDrawable(context, "wallet_base_menu_item_normal_bg"));
                    }
                    addView(a2);
                    if (i2 < size - 1) {
                        addView(createSeparator(context), layoutParams);
                    }
                }
                this.mMenuLoaded = true;
            }
        }
    }

    public ContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContextMenuView(Context context) {
        super(context);
    }
}
