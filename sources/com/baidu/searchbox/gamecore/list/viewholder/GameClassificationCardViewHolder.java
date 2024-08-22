package com.baidu.searchbox.gamecore.list.viewholder;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.base.widget.SelectorImageButton;
import com.baidu.searchbox.gamecore.GameCenterRuntime;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.list.model.GameClassificationItemData;
import com.baidu.searchbox.gamecore.list.model.GameModules;
import com.baidu.searchbox.gamecore.router.GameRouter;
import com.baidu.searchbox.gamecore.ubc.GameCenterUBCUtil;
import com.baidu.searchbox.gamecore.util.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameClassificationCardViewHolder extends GameBaseSimpleCardHolder {
    private GameClassificationAdapter mAdapter;
    private View mDivider;
    private SelectorImageButton mMoreArea;
    private RecyclerView mTableView;
    private TextView mTitle;
    private RelativeLayout mTitleArea;

    public GameClassificationCardViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.game_classification_card, parent, false));
        init();
    }

    private void init() {
        this.mTitleArea = (RelativeLayout) this.itemView.findViewById(R.id.game_card_title_area);
        this.mTitle = (TextView) this.itemView.findViewById(R.id.game_card_title);
        this.mMoreArea = (SelectorImageButton) this.itemView.findViewById(R.id.game_card_more_area);
        this.mTableView = (RecyclerView) this.itemView.findViewById(R.id.game_classification_table);
        final int leftRightMargin = GameCenterRuntime.getResources().getDimensionPixelOffset(R.dimen.dimen_15dp);
        final int gap = (int) GameCenterRuntime.getResources().getDimension(R.dimen.dimen_7dp);
        setTitlePaddingLeftRight(leftRightMargin, leftRightMargin);
        this.mTableView.addItemDecoration(new RecyclerView.ItemDecoration() {
            public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildAdapterPosition(view2) % 2 != 0) {
                    int i2 = gap;
                    outRect.set(i2 >> 1, 0, leftRightMargin, i2);
                    return;
                }
                int i3 = leftRightMargin;
                int i4 = gap;
                outRect.set(i3, 0, i4 >> 1, i4);
            }
        });
        this.mTableView.setLayoutManager(new GridLayoutManager(this.itemView.getContext(), 2, 1, false));
        GameClassificationAdapter gameClassificationAdapter = new GameClassificationAdapter();
        this.mAdapter = gameClassificationAdapter;
        this.mTableView.setAdapter(gameClassificationAdapter);
    }

    /* access modifiers changed from: package-private */
    public void setPaddingLeftRight(int left, int right) {
        if (this.itemView != null) {
            this.itemView.setPadding(left, this.itemView.getPaddingTop(), right, this.itemView.getPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public void setTitlePaddingLeftRight(int left, int right) {
        RelativeLayout relativeLayout = this.mTitleArea;
        if (relativeLayout != null) {
            relativeLayout.setPadding(left, relativeLayout.getPaddingTop(), right, this.mTitleArea.getPaddingBottom());
        }
    }

    private void setCardTheme() {
        this.mTitle.setTextColor(this.mResources.getColor(R.color.game_base_black));
        this.mMoreArea.setImageDrawable(this.mResources.getDrawable(R.drawable.game_more_btn));
        this.mMoreArea.setPressedAlphaScale(GameCenterRuntime.getGameContext().isNightMode() ? 0.5f : 0.2f);
    }

    public void bindData(final GameModules data, final int position) {
        super.bindData(data, position);
        if (data != null && data.itemList != null) {
            String title = data.moduleName;
            if (!TextUtils.isEmpty(title)) {
                this.mTitle.setText(title);
            }
            if (data.moreData == null || TextUtils.isEmpty(data.moreData.scheme)) {
                this.mMoreArea.setVisibility(8);
            } else {
                this.mMoreArea.setVisibility(0);
                this.mMoreArea.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        GameRouter.routerInvoke(GameClassificationCardViewHolder.this.itemView.getContext(), data.moreData.scheme);
                        GameClassificationCardViewHolder gameClassificationCardViewHolder = GameClassificationCardViewHolder.this;
                        gameClassificationCardViewHolder.ubcMoreClick(position, gameClassificationCardViewHolder.mModule);
                    }
                });
            }
            this.mAdapter.bindData(data.itemList, this.mModule, position);
            this.mAdapter.notifyDataSetChanged();
            setCardTheme();
        }
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> buildGamesDisplayExt() {
        GridLayoutManager layoutManager;
        RecyclerView recyclerView = this.mTableView;
        if (recyclerView == null) {
            return null;
        }
        GridLayoutManager layoutManager2 = (GridLayoutManager) recyclerView.getLayoutManager();
        int startPosition = layoutManager2.findFirstVisibleItemPosition();
        int endPosition = layoutManager2.findLastVisibleItemPosition();
        int colNum = layoutManager2.getSpanCount();
        GameBaseRecyclerViewAdapter adapter = (GameBaseRecyclerViewAdapter) this.mTableView.getAdapter();
        List<String> displayExtStrs = new ArrayList<>();
        int x = startPosition;
        while (x <= endPosition) {
            GameClassificationItemViewHolder holder = (GameClassificationItemViewHolder) adapter.getHolderAtPosition(x);
            if (holder == null || GameCenterUBCUtil.isDisplayEventRecorded(holder.generateDisplayId())) {
                layoutManager = layoutManager2;
            } else if (!ViewUtils.isViewInScreen(holder.itemView)) {
                layoutManager = layoutManager2;
            } else {
                GameClassificationItemData itemData = (GameClassificationItemData) holder.getItemData();
                layoutManager = layoutManager2;
                displayExtStrs.add(GameCenterUBCUtil.buildSingleGameDisplayStr(this.mModule.moduleName, getPositionInParent() + 1, (x % colNum) + 1, itemData.itemId, itemData.type, (x / colNum) + 1, this.mModule.moduleId, this.mModule.moduleType, ""));
                GameCenterUBCUtil.markDisplayEventRecorded(holder.generateDisplayId());
            }
            x++;
            layoutManager2 = layoutManager;
        }
        return GameCenterUBCUtil.buildGameDisplayExt(displayExtStrs);
    }
}
