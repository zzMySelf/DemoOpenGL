package com.baidu.wallet.lightapp.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class LangBridgeMenuDialog extends Dialog {
    public BdMenuItem.OnItemClickListener a;
    public GridLayout b;
    public TextView c;
    public List<BdMenuItem> d;
    public boolean mMenuLoaded = false;

    public LangBridgeMenuDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        a();
    }

    public void add(int i2, CharSequence charSequence, Drawable drawable) {
        BdMenuItem bdMenuItem = new BdMenuItem(getContext(), i2, charSequence, drawable);
        bdMenuItem.setOnClickListener(new BdMenuItem.OnItemClickListener() {
            public void onClick(BdMenuItem bdMenuItem) {
                LangBridgeMenuDialog.this.dismiss();
                if (LangBridgeMenuDialog.this.a != null) {
                    LangBridgeMenuDialog.this.a.onClick(bdMenuItem);
                }
            }
        });
        this.d.add(bdMenuItem);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public void layoutMenu() {
        if (!this.mMenuLoaded) {
            this.b.removeAllViews();
            if (this.d.size() > 0) {
                for (BdMenuItem a2 : this.d) {
                    this.b.addView(a(a2));
                }
                this.mMenuLoaded = true;
            }
        }
    }

    public void setMenuItemClickListener(BdMenuItem.OnItemClickListener onItemClickListener) {
        this.a = onItemClickListener;
    }

    public void show() {
        try {
            super.show();
        } catch (Exception unused) {
        }
    }

    private void a() {
        this.d = new ArrayList();
        requestWindowFeature(1);
        setContentView(ResUtils.layout(getContext(), "wallet_langbridge_menu"));
        Window window = getWindow();
        window.setWindowAnimations(ResUtils.style(getContext(), "wallet_base_bottom_dialog_anim"));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = window.getWindowManager().getDefaultDisplay().getHeight();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.b = (GridLayout) findViewById(ResUtils.id(getContext(), "menu_grid_layout"));
        this.c = (TextView) findViewById(ResUtils.id(getContext(), "menu_cancel"));
        this.b.setColumnCount(5);
        this.b.setHorizontalSpacing(0);
        this.b.setVerticalSpacing(DisplayUtils.dip2px(getContext(), 0.5f));
        this.b.setSeparateLine(ResUtils.getColor(getContext(), "wallet_base_color_D8D8D8"), DisplayUtils.dip2px(getContext(), 18.0f), 0);
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LangBridgeMenuDialog.this.dismiss();
            }
        });
        layoutMenu();
    }

    public void add(int i2, CharSequence charSequence, String str) {
        BdMenuItem bdMenuItem = new BdMenuItem(getContext(), i2, charSequence, str);
        bdMenuItem.setOnClickListener(new BdMenuItem.OnItemClickListener() {
            public void onClick(BdMenuItem bdMenuItem) {
                LangBridgeMenuDialog.this.dismiss();
                if (LangBridgeMenuDialog.this.a != null) {
                    LangBridgeMenuDialog.this.a.onClick(bdMenuItem);
                }
            }
        });
        this.d.add(bdMenuItem);
    }

    private View a(final BdMenuItem bdMenuItem) {
        Context context = getContext();
        View inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_langbridge_menu_item"), (ViewGroup) null);
        NetImageView netImageView = (NetImageView) inflate.findViewById(ResUtils.id(context, "menu_item_img"));
        ((TextView) inflate.findViewById(ResUtils.id(context, "menu_item_txt"))).setText(bdMenuItem.getTitle());
        if (!TextUtils.isEmpty(bdMenuItem.getIconUrl())) {
            netImageView.setImageUrl(bdMenuItem.getIconUrl());
        } else {
            Drawable icon = bdMenuItem.getIcon();
            if (icon != null) {
                netImageView.setImageDrawable(icon);
            }
        }
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BdMenuItem.OnItemClickListener onClickListener = bdMenuItem.getOnClickListener();
                if (onClickListener != null) {
                    onClickListener.onClick(bdMenuItem);
                }
            }
        });
        return inflate;
    }
}
