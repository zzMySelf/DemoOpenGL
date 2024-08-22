package com.baidu.searchbox.toolbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import java.util.List;

public class BaseToolBar extends LinearLayout implements View.OnClickListener {
    private int mFontSizeLevel = FontSizeHelper.getFontSizeType();
    private boolean mIsHightToolbarType = false;
    private boolean mIsResponseFontSize = true;
    private List<BaseToolBarItem> mItemList;
    private OnCommonToolItemClickListener mListener;

    public BaseToolBar(Context context, List<BaseToolBarItem> itemList) {
        super(context);
        init(itemList);
    }

    public BaseToolBar(Context context, List<BaseToolBarItem> itemList, boolean isResponseFontSize) {
        super(context);
        this.mIsResponseFontSize = isResponseFontSize;
        init(itemList);
    }

    public BaseToolBar(Context context, List<BaseToolBarItem> itemList, boolean isResponseFontSize, boolean isHightToolbarType) {
        super(context);
        this.mIsResponseFontSize = isResponseFontSize;
        this.mIsHightToolbarType = isHightToolbarType;
        init(itemList);
    }

    private void init(List<BaseToolBarItem> itemList) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelOffset(BaseToolBarExtKt.getBarHeightDimen(this))));
        setPadding(0, 0, 0, 0);
        setGravity(16);
        update(itemList);
    }

    public View createToolBarItemView(int itemId) {
        return new View(getContext());
    }

    public void update(List<BaseToolBarItem> itemList) {
        removeAllViews();
        this.mItemList = itemList;
        if (itemList != null && itemList.size() > 0) {
            for (BaseToolBarItem item : this.mItemList) {
                if (item.getItemView() == null) {
                    item.setItemView(createToolBarItemView(item.getItemId()));
                }
                if (item.getItemView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) item.getItemView().getParent()).removeView(item.getItemView());
                }
                addView(item.getItemView());
                if (!item.isCustomClick()) {
                    item.getItemView().setOnClickListener(this);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsResponseFontSize) {
            BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() {
                public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                    BaseToolBar.this.onFontSizeChange();
                }
            });
            int mTempLevel = this.mFontSizeLevel;
            int fontSizeType = FontSizeHelper.getFontSizeType();
            this.mFontSizeLevel = fontSizeType;
            if (fontSizeType != mTempLevel) {
                onFontSizeChange();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void reset() {
        update(this.mItemList);
    }

    public void setItemClickListener(OnCommonToolItemClickListener listener) {
        this.mListener = listener;
    }

    public View getToolBarItemView(int itemId) {
        for (BaseToolBarItem item : this.mItemList) {
            if (item.getItemId() == itemId) {
                return item.getItemView();
            }
        }
        return null;
    }

    public BaseToolBarItem getToolBarItem(int itemId) {
        for (BaseToolBarItem item : this.mItemList) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    public BaseToolBarItem getToolBarItem(View itemView) {
        for (BaseToolBarItem item : this.mItemList) {
            if (item.getItemView() == itemView) {
                return item;
            }
        }
        return null;
    }

    public void onClick(View v) {
        if (this.mListener != null) {
            this.mListener.onItemClick(v, getToolBarItem(v));
        }
    }

    public boolean getIsResponseFontSize() {
        return this.mIsResponseFontSize;
    }

    public boolean getIsHightToolbarType() {
        return this.mIsHightToolbarType;
    }

    public boolean getIsResponseFontSize(int itemId) {
        BaseToolBarItem item = getToolBarItem(itemId);
        if (item == null) {
            return false;
        }
        return item.isResponseFontSize();
    }

    public void onFontSizeChange() {
        this.mFontSizeLevel = FontSizeHelper.getFontSizeType();
        updateBarHeight();
        List<BaseToolBarItem> list = this.mItemList;
        if (list != null) {
            for (BaseToolBarItem item : list) {
                if (item != null && item.isResponseFontSize()) {
                    item.onFontSizeChange();
                }
            }
        }
    }

    public void setIsResponseFontSize(boolean isResponseFontSize) {
        this.mIsResponseFontSize = isResponseFontSize;
        updateBarHeight();
    }

    private void updateBarHeight() {
        ViewGroup.LayoutParams params = getLayoutParams();
        if (params != null) {
            params.height = getResources().getDimensionPixelOffset(BaseToolBarExtKt.getBarHeightDimen(this));
            setLayoutParams(params);
        }
    }
}
