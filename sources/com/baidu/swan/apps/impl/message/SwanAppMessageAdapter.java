package com.baidu.swan.apps.impl.message;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.impl.message.model.SwanAppMessageBaseItem;
import com.baidu.swan.apps.impl.message.viewholder.BaseViewHolder;
import com.baidu.swan.apps.impl.message.viewholder.SwanAppCouponViewHolder;
import com.baidu.swan.apps.impl.message.viewholder.SwanAppEmptyViewHolder;
import com.baidu.swan.apps.impl.message.viewholder.SwanAppInfoListViewHolder;
import com.baidu.swan.apps.impl.message.viewholder.SwanAppPlainTextViewHolder;
import com.baidu.swan.apps.impl.message.viewholder.SwanAppTextImageViewHolder;
import java.util.ArrayList;
import java.util.List;

public class SwanAppMessageAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int ITEM_TYPE_COUPON = 26;
    public static final int ITEM_TYPE_EMPTY_VIEW = 999;
    public static final int ITEM_TYPE_FOOTER = 1000;
    public static final int ITEM_TYPE_INFO_LIST = 21;
    public static final int ITEM_TYPE_PLAIN_TEXT = 0;
    public static final int ITEM_TYPE_TEXT_IMAGE = 8;
    private Context mContext;
    private View mEmptyView;
    private View mFooterView;
    private List<List<SwanAppMessageBaseItem>> mPageItems = new ArrayList();
    private List<SwanAppMessageBaseItem> mTotalItems = new ArrayList();

    public SwanAppMessageAdapter(Context context) {
        this.mContext = context;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new SwanAppPlainTextViewHolder(parent);
            case 8:
                return new SwanAppTextImageViewHolder(parent);
            case 21:
                return new SwanAppInfoListViewHolder(parent);
            case 26:
                return new SwanAppCouponViewHolder(parent);
            case 999:
                return new SwanAppEmptyViewHolder(this.mEmptyView);
            case 1000:
                return new FooterViewHolder(this.mFooterView);
            default:
                return new BaseViewHolder(parent) {
                    public void bindData(Object data, int position) {
                    }
                };
        }
    }

    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (!isShowEmptyView() && position >= 0 && position < this.mTotalItems.size()) {
            SwanAppMessageBaseItem item = this.mTotalItems.get(position);
            holder.bindData(item, position);
            SwanAppMessageUBCUtils.doUbcCardShowStatistic(position, item);
        }
    }

    public int getItemViewType(int position) {
        if (isShowEmptyView()) {
            return 999;
        }
        if (position == this.mTotalItems.size()) {
            return 1000;
        }
        if (position >= 0 && position < this.mTotalItems.size()) {
            switch (this.mTotalItems.get(position).getModuleTYpe()) {
                case 0:
                    return 0;
                case 8:
                    return 8;
                case 21:
                    return 21;
                case 26:
                    return 26;
            }
        }
        return super.getItemViewType(position);
    }

    public int getItemCount() {
        int i2 = 1;
        if (isShowEmptyView()) {
            return 1;
        }
        int count = this.mTotalItems.size();
        if (this.mFooterView == null) {
            i2 = 0;
        }
        return count + i2;
    }

    public void setData(List<SwanAppMessageBaseItem> data) {
        this.mPageItems.clear();
        this.mTotalItems.clear();
        if (data != null) {
            this.mPageItems.add(data);
            this.mTotalItems.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void setData(List<SwanAppMessageBaseItem> data, int pageIndex) {
        if (data != null && data.size() != 0 && pageIndex == this.mPageItems.size()) {
            this.mPageItems.add(data);
            this.mTotalItems.addAll(data);
            notifyPageInsert(pageIndex);
        }
    }

    private void notifyPageInsert(int pageIndex) {
        int startPosition = 0;
        for (int i2 = 0; i2 < pageIndex; i2++) {
            startPosition += this.mPageItems.get(i2).size();
        }
        if (startPosition > 0) {
            notifyItemInserted(startPosition);
        }
    }

    public void setFooterLayout(View footerLayout) {
        if (footerLayout != null && this.mFooterView != footerLayout) {
            this.mFooterView = footerLayout;
        }
    }

    public void setEmptyLayout(View emptyLayout) {
        if (emptyLayout != null && this.mEmptyView != emptyLayout) {
            this.mEmptyView = emptyLayout;
        }
    }

    public boolean isEmptyPage() {
        return this.mPageItems.size() == 0;
    }

    private boolean isShowEmptyView() {
        return isEmptyPage() && this.mTotalItems.size() == 0 && this.mEmptyView != null;
    }

    public long getLastItemMsgId() {
        int size = this.mTotalItems.size();
        if (size > 1) {
            return this.mTotalItems.get(size - 2).getMsgId();
        }
        return 0;
    }

    public class FooterViewHolder extends BaseViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
