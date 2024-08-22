package com.baidu.searchbox.gamecore.person;

import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.base.BaseViewHolder;
import com.baidu.searchbox.gamecore.person.model.BaseItemData;
import com.baidu.searchbox.gamecore.person.viewholder.FooterViewHolder;
import com.baidu.searchbox.gamecore.person.viewholder.PersonInfoViewHolder;
import com.baidu.searchbox.gamecore.person.viewholder.goods.GoodsViewHolder;
import com.baidu.searchbox.gamecore.person.viewholder.history.HistoryViewHolder;
import com.baidu.searchbox.gamecore.person.viewholder.punchin.PunchInViewHolder;
import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int ITEM_FOOTER = 100;
    public static final int ITEM_GOODS = 4;
    public static final int ITEM_HISTORY = 2;
    private static final int ITEM_INVALID = 404;
    public static final int ITEM_PERSON_INFO = 1;
    public static final int ITEM_PUNCH_IN = 3;
    private boolean mHasFooter = false;
    private final SparseIntArray mLayouts = new SparseIntArray();
    private final List<BaseItemData> mListData = new ArrayList();

    public PersonAdapter() {
        addItemType(404, R.layout.person_invalid);
        addItemType(1, R.layout.person_info);
        addItemType(2, R.layout.history_card_item);
        addItemType(3, R.layout.person_punch_in);
        addItemType(4, R.layout.person_point_reward);
        addItemType(100, R.layout.person_footer);
    }

    public void setData(List<BaseItemData> listData) {
        this.mListData.clear();
        this.mListData.addAll(listData);
        notifyDataSetChanged();
    }

    public void setFooterVisibility() {
        int fixedPos = getItemCount();
        if (!this.mHasFooter && fixedPos > 0) {
            this.mHasFooter = true;
            notifyItemInserted(fixedPos);
        }
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType), parent, false);
        switch (viewType) {
            case 1:
                return new PersonInfoViewHolder(itemView);
            case 2:
                return new HistoryViewHolder(itemView);
            case 3:
                return new PunchInViewHolder(itemView);
            case 4:
                return new GoodsViewHolder(itemView);
            case 100:
                return new FooterViewHolder(itemView);
            default:
                return new BaseViewHolder(itemView) {
                    public void bindData(Object data, int position) {
                        super.bindData(data, position);
                    }

                    public void onTheme() {
                    }
                };
        }
    }

    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bindData(getItemData(position), position);
        holder.onTheme();
    }

    public int getItemCount() {
        return this.mListData.size() + (this.mHasFooter ? 1 : 0);
    }

    public int getItemViewType(int position) {
        if (this.mHasFooter && position >= this.mListData.size()) {
            return 100;
        }
        BaseItemData itemData = this.mListData.get(position);
        int viewType = itemData != null ? itemData.getViewType() : 404;
        if (isValidViewType(viewType)) {
            return viewType;
        }
        return 404;
    }

    public BaseItemData getItemData(int position) {
        if (position < 0 || position >= this.mListData.size()) {
            return null;
        }
        return this.mListData.get(position);
    }

    /* access modifiers changed from: protected */
    public void addItemType(int type, int layoutResId) {
        this.mLayouts.put(type, layoutResId);
    }

    private int getLayoutId(int viewType) {
        return this.mLayouts.get(viewType, 404);
    }

    private boolean isValidViewType(int viewType) {
        int index = this.mLayouts.indexOfKey(viewType);
        return index >= 0 && index < this.mLayouts.size();
    }
}
