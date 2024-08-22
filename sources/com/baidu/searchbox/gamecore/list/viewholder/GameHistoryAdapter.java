package com.baidu.searchbox.gamecore.list.viewholder;

import android.view.ViewGroup;
import com.baidu.searchbox.gamecore.list.model.GameAppItemData;
import com.baidu.searchbox.gamecore.list.model.GameItemBaseData;
import com.baidu.searchbox.gamecore.list.model.GameModules;
import java.util.List;

public class GameHistoryAdapter extends GameBaseRecyclerViewAdapter<GameHistoryItemViewHolder> {
    private List<GameItemBaseData> mDataList;
    private GameModules mModules;
    private int mParentCardPosition;

    public void bindData(GameModules modules, List<GameItemBaseData> data, int parentCardPosition) {
        this.mModules = modules;
        this.mDataList = data;
        this.mParentCardPosition = parentCardPosition;
    }

    public void onBindViewHolder(GameHistoryItemViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        List<GameItemBaseData> list = this.mDataList;
        if (list != null && position >= 0 && position < list.size()) {
            holder.bindData((GameAppItemData) this.mDataList.get(position), this.mParentCardPosition, position);
        }
    }

    public GameHistoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GameHistoryItemViewHolder(this.mModules, parent);
    }

    public int getItemCount() {
        List<GameItemBaseData> list = this.mDataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
