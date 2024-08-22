package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.ext.widget.menu.BdMenuItemCheck;
import com.baidu.searchbox.common.res.R;
import java.util.List;

public class CommonWhiteMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    private SparseArray<View> mChildView = new SparseArray<>();
    private View mContentView;
    private int mDividerHeight = 1;
    private int mDividerRes;
    private int mItemBgRes;
    private ColorStateList mItemTextColor;
    private boolean mMenuLoaded = false;

    public CommonWhiteMenuView(Context context) {
        super(context);
        init(context);
    }

    public CommonWhiteMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.mContentView = LayoutInflater.from(context).inflate(R.layout.home_skin_menu_layout, this, true);
        initColorAndBg();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void initColorAndBg() {
        this.mItemTextColor = getResources().getColorStateList(R.color.home_skin_menu_text_color);
        this.mDividerRes = R.color.home_skin_menu_item_divider_color;
        this.mItemBgRes = R.drawable.home_skin_setting_item_bg_selector;
        setBackground(getResources().getDrawable(R.drawable.skin_home_menu_bg));
    }

    public void setItemBackground(int itemBackgroundRes) {
        this.mItemBgRes = itemBackgroundRes;
    }

    public void setItemTextColor(int textColorRes) {
        this.mItemTextColor = getResources().getColorStateList(textColorRes);
    }

    public void setItemDivider(int resId, int dividerHeightInPx) {
        this.mDividerRes = resId;
        this.mDividerHeight = dividerHeightInPx;
    }

    public void layoutMenu(List<BdMenuItem> items) {
        initColorAndBg();
        if (!this.mMenuLoaded) {
            removeAllViews();
            this.mChildView.clear();
            Context context = getContext();
            if (this.mDividerHeight < 0) {
                this.mDividerHeight = 1;
            }
            LinearLayout.LayoutParams dParams = new LinearLayout.LayoutParams(-1, this.mDividerHeight);
            int i2 = 0;
            for (final BdMenuItem item : items) {
                View itemView = getMenuItemView(context, item);
                if (item.isEnabled()) {
                    itemView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            CommonWhiteMenuView.this.itemOnclick(item);
                        }
                    });
                }
                addView(itemView);
                this.mChildView.append(item.getItemId(), itemView);
                if (i2 < items.size() - 1) {
                    ImageView divider = new ImageView(context);
                    divider.setBackgroundColor(getResources().getColor(this.mDividerRes));
                    addView(divider, dParams);
                }
                i2++;
            }
            this.mMenuLoaded = true;
        }
    }

    /* access modifiers changed from: protected */
    public View getMenuItemView(Context context, BdMenuItem item) {
        int i2;
        if (item instanceof BdMenuItemCheck) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.skin_menu_checkbox_item, this, false);
            itemView.findViewById(R.id.item).setBackground(getResources().getDrawable(getItemBgRes()));
            TextView titleView = (TextView) itemView.findViewById(R.id.item_title);
            titleView.setText(item.getTitle());
            CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox_id);
            checkBox.setButtonDrawable(getResources().getDrawable(R.drawable.skin_checkbox_private));
            checkBox.setChecked(item.isChecked());
            titleView.setTextColor(getTextColor());
            itemView.setEnabled(true);
            titleView.setEnabled(true);
            return itemView;
        }
        View itemView2 = LayoutInflater.from(context).inflate(R.layout.skin_menu_item, this, false);
        itemView2.findViewById(R.id.item).setBackground(getResources().getDrawable(this.mItemBgRes));
        TextView right = (TextView) itemView2.findViewById(R.id.right_txt);
        right.setText(item.getTitle());
        itemView2.setEnabled(item.isEnabled());
        right.setEnabled(item.isEnabled());
        if (item.isEnabled()) {
            i2 = getResources().getColor(R.color.home_skin_menu_text_color);
        } else {
            i2 = getResources().getColor(R.color.home_skin_menu_text_disable_color);
        }
        right.setTextColor(i2);
        return itemView2;
    }

    /* access modifiers changed from: private */
    public void itemOnclick(BdMenuItem item) {
        BdMenuItem.OnItemClickListener listener = item.getOnClickListener();
        if (listener != null) {
            listener.onClick(item);
        }
    }

    public void onMenuSetChanged() {
        this.mMenuLoaded = false;
    }

    public void onMenuItemUpdated(BdMenuItem item) {
        int i2;
        if (item == null || !(item instanceof BdMenuItemCheck)) {
            View itemView = this.mChildView.get(item.getItemId());
            itemView.findViewById(R.id.item).setBackground(getResources().getDrawable(getItemBgRes()));
            TextView right = (TextView) itemView.findViewById(R.id.right_txt);
            right.setText(item.getTitle());
            itemView.setEnabled(item.isEnabled());
            right.setEnabled(item.isEnabled());
            if (item.isEnabled()) {
                i2 = getResources().getColor(R.color.home_skin_menu_text_color);
            } else {
                i2 = getResources().getColor(R.color.home_skin_menu_text_disable_color);
            }
            right.setTextColor(i2);
            return;
        }
        View itemView2 = this.mChildView.get(item.getItemId());
        if (itemView2 != null) {
            itemView2.findViewById(R.id.item).setBackground(getResources().getDrawable(getItemBgRes()));
            TextView titleView = (TextView) itemView2.findViewById(R.id.item_title);
            titleView.setText(item.getTitle());
            CheckBox checkBox = (CheckBox) itemView2.findViewById(R.id.checkbox_id);
            checkBox.setButtonDrawable(getResources().getDrawable(R.drawable.skin_checkbox_private));
            checkBox.setChecked(item.isChecked());
            titleView.setTextColor(getResources().getColorStateList(R.color.home_skin_menu_text_color));
            itemView2.setEnabled(item.isEnabled());
            titleView.setEnabled(item.isEnabled());
        }
    }

    public ColorStateList getTextColor() {
        return this.mItemTextColor;
    }

    public int getItemBgRes() {
        return this.mItemBgRes;
    }
}
