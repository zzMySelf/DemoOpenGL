package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BdMenuItem;
import java.util.ArrayList;
import java.util.List;

public abstract class BdMenu {
    public Context mContext;
    public boolean mDismissOnClick = true;
    public List<BdMenuItem> mItems;
    public View.OnKeyListener mKeyClickListener;
    public View mMenu;
    public BdMenuItem.OnItemClickListener mMenuItemClickListener;
    public PopupWindow mPopupWindow;
    public Resources mResources;
    public OnMenuStateChangeListener mStateChangeListener;
    public final View mViewToAttach;

    public interface OnMenuSetChangedListener {
        void onMenuItemUpdated(BdMenuItem bdMenuItem);

        void onMenuSetChanged();
    }

    public interface OnMenuStateChangeListener {
        void onDismissMenu();

        void onShowMenu();
    }

    public class ad implements BdMenuItem.OnItemClickListener {
        public ad() {
        }

        public void onClick(BdMenuItem bdMenuItem) {
            BdMenu.this.dismiss();
            if (BdMenu.this.mMenuItemClickListener != null) {
                BdMenu.this.mMenuItemClickListener.onClick(bdMenuItem);
            }
        }
    }

    public class de implements BdMenuItem.OnItemClickListener {
        public de() {
        }

        public void onClick(BdMenuItem bdMenuItem) {
            BdMenu.this.dismiss();
            if (BdMenu.this.mMenuItemClickListener != null) {
                BdMenu.this.mMenuItemClickListener.onClick(bdMenuItem);
            }
        }
    }

    public class fe implements PopupWindow.OnDismissListener {
        public fe() {
        }

        public void onDismiss() {
            if (BdMenu.this.mStateChangeListener != null) {
                BdMenu.this.mStateChangeListener.onDismissMenu();
            }
        }
    }

    public class qw implements View.OnKeyListener {
        public qw() {
        }

        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1) {
                return false;
            }
            if (i2 != 4 && i2 != 82) {
                return false;
            }
            BdMenu.this.dismiss();
            if (BdMenu.this.mKeyClickListener != null) {
                BdMenu.this.mKeyClickListener.onKey(view, i2, keyEvent);
            }
            return true;
        }
    }

    public class rg implements Runnable {
        public rg() {
        }

        public void run() {
            try {
                BdMenu.this.showMenu(BdMenu.this.mPopupWindow);
            } catch (Exception unused) {
            }
        }
    }

    public BdMenu(View view) {
        this.mViewToAttach = view;
        this.mContext = view.getContext();
        this.mResources = this.mViewToAttach.getResources();
        this.mItems = new ArrayList();
        prepareMenuView(this.mContext);
    }

    private BdMenuItem addInternal(int i2, CharSequence charSequence, Drawable drawable) {
        BdMenuItem bdMenuItem = new BdMenuItem(this.mContext, i2, charSequence, drawable);
        bdMenuItem.setMenu(this);
        if (this.mDismissOnClick) {
            bdMenuItem.setOnClickListener(new ad());
        } else {
            bdMenuItem.setOnClickListener(this.mMenuItemClickListener);
        }
        this.mItems.add(bdMenuItem);
        return bdMenuItem;
    }

    private BdMenuItem addInternal1(int i2, CharSequence charSequence, String str) {
        BdMenuItem bdMenuItem = new BdMenuItem(this.mContext, i2, charSequence, str);
        bdMenuItem.setMenu(this);
        if (this.mDismissOnClick) {
            bdMenuItem.setOnClickListener(new de());
        } else {
            bdMenuItem.setOnClickListener(this.mMenuItemClickListener);
        }
        this.mItems.add(bdMenuItem);
        return bdMenuItem;
    }

    private void prepareMenuView(Context context) {
        View menuView = getMenuView(context);
        this.mMenu = menuView;
        if (menuView instanceof OnMenuSetChangedListener) {
            menuView.setOnKeyListener(new qw());
            return;
        }
        throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
    }

    public BdMenuItem add(int i2, CharSequence charSequence) {
        return addInternal(i2, charSequence, (Drawable) null);
    }

    public void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            try {
                this.mPopupWindow.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public abstract void ensureMenuLoaded(View view, List<BdMenuItem> list);

    public BdMenuItem findItem(int i2) {
        int findItemIndex = findItemIndex(i2);
        if (findItemIndex > -1) {
            return this.mItems.get(findItemIndex);
        }
        return null;
    }

    public int findItemIndex(int i2) {
        int size = this.mItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mItems.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public abstract View getMenuView(Context context);

    public View getView() {
        return this.mMenu;
    }

    public void notifyMenuItemUpdated(BdMenuItem bdMenuItem) {
        ((OnMenuSetChangedListener) this.mMenu).onMenuItemUpdated(bdMenuItem);
    }

    public void notifyMenuSetChanged() {
        ((OnMenuSetChangedListener) this.mMenu).onMenuSetChanged();
    }

    public void removeAllItem() {
        List<BdMenuItem> list = this.mItems;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                removeItemAt(size);
            }
        }
    }

    public void removeItem(int i2) {
        removeItemAt(findItemIndex(i2));
    }

    public void removeItemAt(int i2) {
        if (i2 >= 0 && i2 < this.mItems.size()) {
            this.mItems.remove(i2);
        }
    }

    public void setDismissOnClick(boolean z) {
        this.mDismissOnClick = z;
    }

    public void setMenuItemClickListener(BdMenuItem.OnItemClickListener onItemClickListener) {
        this.mMenuItemClickListener = onItemClickListener;
    }

    public void setMenuStateChangeListener(OnMenuStateChangeListener onMenuStateChangeListener) {
        this.mStateChangeListener = onMenuStateChangeListener;
    }

    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        this.mKeyClickListener = onKeyListener;
    }

    public void show() {
        OnMenuStateChangeListener onMenuStateChangeListener = this.mStateChangeListener;
        if (onMenuStateChangeListener != null) {
            onMenuStateChangeListener.onShowMenu();
        }
        ensureMenuLoaded(this.mMenu, this.mItems);
        dismiss();
        if (this.mPopupWindow == null) {
            PopupWindow popupWindow = new PopupWindow(this.mMenu, -2, -2, true);
            this.mPopupWindow = popupWindow;
            popupWindow.setBackgroundDrawable(this.mResources.getDrawable(ResUtils.drawable(this.mContext, "dxm_wallet_base_service_squared_item_bg")));
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(new fe());
        }
        View view = this.mViewToAttach;
        if (view == null) {
            OnMenuStateChangeListener onMenuStateChangeListener2 = this.mStateChangeListener;
            if (onMenuStateChangeListener2 != null) {
                onMenuStateChangeListener2.onDismissMenu();
                return;
            }
            return;
        }
        view.post(new rg());
        this.mMenu.postInvalidate();
    }

    public abstract void showMenu(PopupWindow popupWindow);

    public void toggle() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            show();
        } else {
            dismiss();
        }
    }

    public BdMenuItem add(int i2, int i3) {
        return addInternal(i2, this.mResources.getString(i3), (Drawable) null);
    }

    public BdMenuItem add(int i2, CharSequence charSequence, Drawable drawable) {
        return addInternal(i2, charSequence, drawable);
    }

    public BdMenuItem add(int i2, int i3, int i4) {
        return addInternal(i2, this.mResources.getString(i3), this.mResources.getDrawable(i4));
    }

    public BdMenuItem add(int i2, CharSequence charSequence, String str) {
        return addInternal1(i2, charSequence, str);
    }
}
