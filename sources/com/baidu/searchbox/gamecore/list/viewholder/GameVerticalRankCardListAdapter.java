package com.baidu.searchbox.gamecore.list.viewholder;

import android.view.ViewGroup;
import com.baidu.searchbox.gamecore.list.model.GameAppItemData;
import com.baidu.searchbox.gamecore.list.model.GameModules;
import java.util.List;

public class GameVerticalRankCardListAdapter extends GameBaseRecyclerViewAdapter<GameVerticalRankCardListItemViewHolder> {
    private int mParentCardPosition;
    private List<GameAppItemData> mRankItemDataList;
    private GameModules mRankModule;
    private String mRankTitle;
    private int mViewPagerPosition;

    public void bindData(GameModules rankModule, List<GameAppItemData> rankItemDataList, String rankTitle, int viewPagerPosition, int parentCardPosition) {
        this.mRankModule = rankModule;
        this.mRankItemDataList = rankItemDataList;
        this.mParentCardPosition = parentCardPosition;
        this.mViewPagerPosition = viewPagerPosition;
        this.mRankTitle = rankTitle;
    }

    public GameVerticalRankCardListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GameVerticalRankCardListItemViewHolder(this.mRankModule, parent);
    }

    public void onBindViewHolder(GameVerticalRankCardListItemViewHolder holder, int listPosition) {
        super.onBindViewHolder(holder, listPosition);
        holder.bindData(this.mRankModule, this.mRankItemDataList.get(listPosition), this.mRankTitle, listPosition, this.mViewPagerPosition, this.mParentCardPosition);
    }

    public int getItemCount() {
        List<GameAppItemData> list = this.mRankItemDataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
