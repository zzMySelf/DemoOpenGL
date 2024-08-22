package com.dxmpay.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BdMenu;
import com.dxmpay.wallet.base.widget.BdMenuItem;
import java.util.List;

public class BdContextMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public boolean mMenuLoaded = false;

    public class qw implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ BdMenuItem f4142ad;

        public qw(BdMenuItem bdMenuItem) {
            this.f4142ad = bdMenuItem;
        }

        public void onClick(View view) {
            BdMenuItem.OnItemClickListener onClickListener = this.f4142ad.getOnClickListener();
            if (onClickListener != null) {
                onClickListener.onClick(this.f4142ad);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        setGravity(17);
        setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public View createSeparator(Context context) {
        View view = new View(context);
        view.setBackgroundResource(ResUtils.color(context, getSeparatorResId()));
        return view;
    }

    public String getBackgroundResId() {
        return "dxm_wallet_base_menu_bg_white_corner";
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        return null;
    }

    public String getMenuItemViewLayoutId() {
        return "dxm_wallet_base_menu_item_view";
    }

    public String getSeparatorResId() {
        return "dxm_wallet_base_menu_item_separateColor";
    }

    public void layoutMenu(List<BdMenuItem> list) {
        if (!this.mMenuLoaded) {
            removeAllViews();
            int size = list.size();
            if (size > 0) {
                Context context = getContext();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(ResUtils.dimen(getContext(), "dxm_wallet_menu_item_width")), 2);
                for (int i2 = 0; i2 < size; i2++) {
                    addView(a(list.get(i2), getMenuItemBackgroudResId(i2, size)));
                    if (i2 < size - 1) {
                        addView(createSeparator(context), layoutParams);
                    }
                }
                this.mMenuLoaded = true;
            }
        }
    }

    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    public void onMenuSetChanged() {
        this.mMenuLoaded = false;
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BdContextMenuView(Context context) {
        super(context);
        a();
    }

    private View a(BdMenuItem bdMenuItem, String str) {
        Context context = getContext();
        TextView textView = (TextView) LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), getMenuItemViewLayoutId()), this, false);
        textView.setText(bdMenuItem.getTitle());
        textView.setTextColor(getResources().getColor(ResUtils.color(getContext(), "dxm_wallet_base_font_text1Color")));
        textView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_base_menu_item_bg_selector"));
        Drawable icon = bdMenuItem.getIcon();
        if (icon != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(icon, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setOnClickListener(new qw(bdMenuItem));
        if (!TextUtils.isEmpty(str)) {
            int paddingBottom = textView.getPaddingBottom();
            int paddingTop = textView.getPaddingTop();
            int paddingRight = textView.getPaddingRight();
            int paddingLeft = textView.getPaddingLeft();
            textView.setBackgroundResource(ResUtils.drawable(context, str));
            textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        return textView;
    }
}
