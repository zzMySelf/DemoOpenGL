package com.baidu.searchbox.gamecore.person.viewholder.history;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.base.widget.BdBaseImageView;
import com.baidu.searchbox.gamecore.person.model.PlayHistoryItem;
import com.baidu.searchbox.gamecore.person.viewholder.history.GameHistoryItemViewHolder;
import com.baidu.searchbox.gamecore.ubc.GameCenterUBCUtil;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<GameHistoryItemViewHolder> implements GameHistoryItemViewHolder.ItemClickListener {
    static Comparator<PlayHistoryItem> mComparator = new Comparator<PlayHistoryItem>() {
        public int compare(PlayHistoryItem left, PlayHistoryItem right) {
            if (left.getPlayTime() > right.getPlayTime()) {
                return -1;
            }
            if (left.getPlayTime() < right.getPlayTime()) {
                return 1;
            }
            return 0;
        }
    };
    private BdBaseImageView mCover;
    private int mCurrentPos;
    private String mHeaderTitle;
    private int mItemCountPerPage;
    private List<PlayHistoryItem> mItemDataList;
    private boolean mNeedScrollToStart;
    private ArrayList<Integer> mPageShow;
    private RecyclerView mRecyclerView;

    public HistoryAdapter() {
        this.mItemCountPerPage = 4;
        this.mPageShow = new ArrayList<>();
        this.mItemCountPerPage = GameHistoryUtils.calCountPerPage();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public void setCurrentPos(int curPos) {
        List<PlayHistoryItem> list;
        this.mCurrentPos = curPos;
        int pageIndex = curPos + 1;
        List<PlayHistoryItem> list2 = this.mItemDataList;
        int i2 = this.mItemCountPerPage;
        List<PlayHistoryItem> dataList = list2.subList(curPos * i2, Math.min(i2 * pageIndex, list2.size()));
        int visible = 0;
        if (!GameHistoryUtils.isShowCoverView(dataList, this.mItemDataList, this.mItemCountPerPage, curPos, pageIndex == getItemCount())) {
            visible = 8;
        }
        this.mCover.setVisibility(visible);
        if (!this.mPageShow.contains(Integer.valueOf(pageIndex)) && pageIndex >= 0 && (list = this.mItemDataList) != null && pageIndex < list.size()) {
            this.mPageShow.add(Integer.valueOf(pageIndex));
            ubcGameShow(dataList, pageIndex);
        }
    }

    /* access modifiers changed from: package-private */
    public void setItemDataList(List<PlayHistoryItem> dataList, String headerTitle) {
        Collections.sort(dataList, mComparator);
        this.mItemDataList = dataList;
        this.mHeaderTitle = headerTitle;
    }

    /* access modifiers changed from: package-private */
    public void setCover(BdBaseImageView cover) {
        this.mCover = cover;
    }

    public GameHistoryItemViewHolder onCreateViewHolder(ViewGroup itemView, int viewType) {
        return new GameHistoryItemViewHolder(itemView);
    }

    public int getItemCount() {
        List<PlayHistoryItem> list = this.mItemDataList;
        int i2 = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int size = this.mItemDataList.size() / this.mItemCountPerPage;
        if (this.mItemDataList.size() % this.mItemCountPerPage != 0) {
            i2 = 1;
        }
        return i2 + size;
    }

    public void onBindViewHolder(GameHistoryItemViewHolder holder, int position) {
        List<PlayHistoryItem> list;
        if (holder != null && position >= 0 && (list = this.mItemDataList) != null && position < list.size()) {
            int index = position + 1;
            List<PlayHistoryItem> list2 = this.mItemDataList;
            int i2 = this.mItemCountPerPage;
            List<PlayHistoryItem> dataList = list2.subList(position * i2, Math.min(i2 * index, list2.size()));
            boolean isLast = true;
            if (position != getItemCount() - 1) {
                isLast = false;
            }
            holder.bindData(dataList, position, isLast);
            holder.setClickListener(this);
            if (position == 0) {
                if (!this.mPageShow.contains(Integer.valueOf(index))) {
                    this.mPageShow.add(Integer.valueOf(index));
                    ubcGameShow(dataList, index);
                } else {
                    return;
                }
            }
            if (this.mNeedScrollToStart) {
                this.mRecyclerView.scrollToPosition(0);
                setCurrentPos(0);
                this.mNeedScrollToStart = false;
            }
        }
    }

    private boolean isFullyVisible(int pos) {
        RecyclerView recyclerView = this.mRecyclerView;
        if ((recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition() != pos) && pos != this.mCurrentPos) {
            return false;
        }
        return true;
    }

    public void onItemClicked(int posInsideItem) {
        this.mNeedScrollToStart = true;
    }

    private void ubcGameShow(List<PlayHistoryItem> dataList, int pageIndex) {
        PlayHistoryItem itemData;
        List<String> displayExtStrs = new ArrayList<>();
        if (TextUtils.isEmpty(this.mHeaderTitle)) {
            this.mHeaderTitle = "我的游戏";
        }
        int i2 = 0;
        while (i2 < dataList.size() && (itemData = dataList.get(i2)) != null && !TextUtils.isEmpty(itemData.getAppKey())) {
            String extStr = GameCenterUBCUtil.buildSingleGameDisplayStr(this.mHeaderTitle, pageIndex, i2 + 1, itemData.getAppKey(), itemData.getType(), 0, "", "", "");
            displayExtStrs.add(extStr);
            GameCenterUBCUtil.markDisplayEventRecorded(extStr);
            i2++;
        }
        HashMap<String, String> itemsExt = GameCenterUBCUtil.buildGameDisplayExt(displayExtStrs);
        if (itemsExt != null && !itemsExt.isEmpty()) {
            GameCenterUBCUtil.gameUBCWithSwanVer(GameUBCConst.PERSON_CENTER_ID, "show_items", (String) null, GameUBCConst.PAGE_PERSON_CENTER, itemsExt);
        }
    }
}
