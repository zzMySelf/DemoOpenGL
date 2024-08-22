package com.baidu.searchbox.gamecore.list.viewholder;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.base.GameLibBaseRuntime;
import com.baidu.searchbox.base.widget.SelectorImageButton;
import com.baidu.searchbox.gamecore.GameCenterRuntime;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.base.BaseViewHolder;
import com.baidu.searchbox.gamecore.base.datasource.GameDataManager;
import com.baidu.searchbox.gamecore.list.ChangeClickListener;
import com.baidu.searchbox.gamecore.list.model.GameAppItemData;
import com.baidu.searchbox.gamecore.list.model.GameItemBaseData;
import com.baidu.searchbox.gamecore.list.model.GameModules;
import com.baidu.searchbox.gamecore.router.GameRouter;
import com.baidu.searchbox.gamecore.ubc.GameCenterUBCUtil;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import com.baidu.searchbox.gamecore.ubc.IUbcDisplayStatistic;
import com.baidu.searchbox.gamecore.widget.view.LimitParentSlideRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GameBaseMultipuleCardVHolder<VH extends BaseViewHolder<GameItemBaseData>> extends BaseViewHolder<GameModules> implements IUbcDisplayStatistic {
    private static final boolean DEBUG = false;
    public static final int DEFULT_TYPE_FORE = 4;
    private static final String TAG = "GameBaseItemCardViewHolder";
    private GameBaseMultipuleCardVHolder<VH>.CardItemAdapter mAdapter;
    private LinearLayout mChange;
    /* access modifiers changed from: private */
    public ChangeClickListener mChangeClickListener;
    /* access modifiers changed from: private */
    public ImageView mChangeIcon;
    private TextView mChangeText;
    private TextView mDesc1;
    private TextView mDesc2;
    private TextView mDesc3;
    private LinearLayout mDescArea;
    private View mDivider;
    protected GameModules mModule;
    private SelectorImageButton mMoreArea;
    /* access modifiers changed from: private */
    public int mOffset = 0;
    protected LimitParentSlideRecyclerView mRecyclerView;
    private TextView mTitle;
    private RelativeLayout mTitleArea;

    /* access modifiers changed from: protected */
    public abstract VH createItemViewHolder(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract void setRecyclerView();

    protected GameBaseMultipuleCardVHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item_card, parent, false));
        init();
    }

    private void init() {
        int leftRightMargin = GameCenterRuntime.getResources().getDimensionPixelOffset(R.dimen.dimen_15dp);
        setPaddingLeftRight(leftRightMargin, leftRightMargin);
        this.mRecyclerView = (LimitParentSlideRecyclerView) this.itemView.findViewById(R.id.recycler_view);
        this.mTitleArea = (RelativeLayout) this.itemView.findViewById(R.id.game_card_title_area);
        this.mTitle = (TextView) this.itemView.findViewById(R.id.game_card_title);
        this.mDescArea = (LinearLayout) this.itemView.findViewById(R.id.game_card_desc);
        this.mDesc1 = (TextView) this.itemView.findViewById(R.id.game_card_desc_tex1);
        this.mDesc2 = (TextView) this.itemView.findViewById(R.id.game_card_desc_tex2);
        this.mDesc3 = (TextView) this.itemView.findViewById(R.id.game_card_desc_tex3);
        this.mMoreArea = (SelectorImageButton) this.itemView.findViewById(R.id.game_card_more_area);
        this.mChange = (LinearLayout) this.itemView.findViewById(R.id.game_card_change);
        this.mChangeText = (TextView) this.itemView.findViewById(R.id.game_card_change_text);
        this.mChangeIcon = (ImageView) this.itemView.findViewById(R.id.game_card_change_icon);
        this.mDivider = this.itemView.findViewById(R.id.game_item_card_divider);
        setRecyclerView();
        GameBaseMultipuleCardVHolder<VH>.CardItemAdapter cardItemAdapter = new CardItemAdapter();
        this.mAdapter = cardItemAdapter;
        this.mRecyclerView.setAdapter(cardItemAdapter);
    }

    public void setOnChangeClickListener(ChangeClickListener changeClickListener) {
        this.mChangeClickListener = changeClickListener;
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

    /* access modifiers changed from: package-private */
    public void setDividerMarginLeftRight(int left, int right) {
        View view2 = this.mDivider;
        if (view2 != null) {
            ViewGroup.LayoutParams lp = view2.getLayoutParams();
            if (lp instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) lp).leftMargin = left;
                ((LinearLayout.LayoutParams) lp).rightMargin = right;
            }
        }
    }

    private void setCardTheme() {
        Drawable drawable;
        Resources resource = GameCenterRuntime.getResources();
        boolean isNightMode = GameLibBaseRuntime.getGameLibBaseContext().isNightMode();
        this.mTitle.setTextColor(resource.getColor(R.color.game_base_black));
        this.mChangeText.setTextColor(resource.getColor(R.color.game_gray_color));
        this.mDesc1.setTextColor(resource.getColor(R.color.game_gray_color));
        this.mDesc2.setTextColor(resource.getColor(R.color.game_play_button_text));
        this.mDesc3.setTextColor(resource.getColor(R.color.game_gray_color));
        this.mDivider.setBackgroundColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_transparent));
        this.mMoreArea.setImageDrawable(this.mResources.getDrawable(R.drawable.game_more_btn));
        ImageView imageView = this.mChangeIcon;
        if (isNightMode) {
            drawable = this.mResources.getDrawable(R.drawable.game_change_night);
        } else {
            drawable = this.mResources.getDrawable(R.drawable.game_change);
        }
        imageView.setImageDrawable(drawable);
        this.mMoreArea.setPressedAlphaScale(isNightMode ? 0.5f : 0.2f);
    }

    public void bindData(GameModules data, final int position) {
        super.bindData(data, position);
        if (data != null && this.itemView.getVisibility() == 0) {
            this.mModule = data;
            String title = data.moduleName;
            if (!TextUtils.isEmpty(title)) {
                this.mTitle.setText(title);
            }
            String desc = this.mModule.moduleDesc;
            if (!TextUtils.isEmpty(desc)) {
                this.mDescArea.setVisibility(0);
                String[] descs = desc.split("##");
                this.mDesc1.setText(descs[0] + " ");
                this.mDesc2.setText(descs[1] + " ");
                this.mDesc3.setText(descs[2]);
            } else {
                this.mDescArea.setVisibility(8);
            }
            if (this.mModule.moreData == null) {
                this.mMoreArea.setVisibility(8);
            } else if (!TextUtils.isEmpty(this.mModule.moreData.scheme) && TextUtils.equals("1", this.mModule.moreData.hasmore)) {
                this.mMoreArea.setVisibility(0);
                this.mChange.setVisibility(8);
                this.mMoreArea.setImageResource(R.drawable.game_more_btn);
                this.mMoreArea.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        GameRouter.routerInvoke(GameBaseMultipuleCardVHolder.this.itemView.getContext(), GameBaseMultipuleCardVHolder.this.mModule.moreData.scheme);
                        GameBaseMultipuleCardVHolder gameBaseMultipuleCardVHolder = GameBaseMultipuleCardVHolder.this;
                        gameBaseMultipuleCardVHolder.ubcMoreClick(position, gameBaseMultipuleCardVHolder.mModule);
                    }
                });
            } else if (TextUtils.equals("2", this.mModule.moreData.hasmore)) {
                this.mMoreArea.setVisibility(8);
                this.mChange.setVisibility(0);
                this.mChange.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (GameBaseMultipuleCardVHolder.this.mChangeClickListener != null) {
                            if (TextUtils.isEmpty(GameBaseMultipuleCardVHolder.this.mModule.offset)) {
                                GameBaseMultipuleCardVHolder gameBaseMultipuleCardVHolder = GameBaseMultipuleCardVHolder.this;
                                int unused = gameBaseMultipuleCardVHolder.mOffset = gameBaseMultipuleCardVHolder.mModule.itemList.size();
                            } else {
                                GameBaseMultipuleCardVHolder gameBaseMultipuleCardVHolder2 = GameBaseMultipuleCardVHolder.this;
                                int unused2 = gameBaseMultipuleCardVHolder2.mOffset = Integer.parseInt(gameBaseMultipuleCardVHolder2.mModule.offset);
                            }
                            if (GameBaseMultipuleCardVHolder.this.mModule.itemList != null) {
                                GameBaseMultipuleCardVHolder.this.mChangeClickListener.onChangeClick(position, 200, GameBaseMultipuleCardVHolder.this.mModule.moduleId, GameBaseMultipuleCardVHolder.this.mOffset, GameBaseMultipuleCardVHolder.this.mModule.itemList.size());
                            }
                        }
                        GameBaseMultipuleCardVHolder gameBaseMultipuleCardVHolder3 = GameBaseMultipuleCardVHolder.this;
                        gameBaseMultipuleCardVHolder3.rotateAnim(gameBaseMultipuleCardVHolder3.mChangeIcon);
                        GameBaseMultipuleCardVHolder gameBaseMultipuleCardVHolder4 = GameBaseMultipuleCardVHolder.this;
                        gameBaseMultipuleCardVHolder4.ubcChangeClick(position, gameBaseMultipuleCardVHolder4.mModule, GameBaseMultipuleCardVHolder.this.mModule.moreData.hasmore);
                    }
                });
            }
            if (this.mModule.itemList != null) {
                this.mAdapter.setItemDataList(this.mModule.itemList, position, title);
                this.mAdapter.notifyDataSetChanged();
            }
            setCardTheme();
        }
    }

    public void onDisplayStatistic(int position) {
        GameModules gameModules = this.mModule;
        if (gameModules != null) {
            if (!GameCenterUBCUtil.isDisplayEventRecorded(gameModules.moduleId)) {
                HashMap<String, String> ext = GameCenterUBCUtil.buildModuleDisplayExt(this.mModule.moduleId, getUbcModuleTitle(), (position + 1) + "", this.mModule.moduleType);
                ext.put("logid", GameCenterUBCUtil.getLogId(this.mModule));
                GameModules gameModules2 = this.mModule;
                if (gameModules2 != null && !gameModules2.isNetData) {
                    ext.put("cache", GameDataManager.getInstance().getCurrentDataCacheType());
                }
                ubcGameShow(GameUBCConst.TYPE_SHOW_PARTS, (String) null, GameUBCConst.PAGE_FIND_PAGE, ext);
                GameCenterUBCUtil.markDisplayEventRecorded(this.mModule.moduleId);
            }
            HashMap<String, String> itemsExt = buildGamesDisplayExt();
            if (itemsExt != null && !itemsExt.isEmpty()) {
                itemsExt.put("logid", GameCenterUBCUtil.getLogId(this.mModule));
                GameModules gameModules3 = this.mModule;
                if (gameModules3 != null && !gameModules3.isNetData) {
                    itemsExt.put("cache", GameDataManager.getInstance().getCurrentDataCacheType());
                }
                ubcGameShow("show_items", (String) null, GameUBCConst.PAGE_FIND_PAGE, itemsExt);
            }
        }
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> buildGamesDisplayExt() {
        return new HashMap<>();
    }

    /* access modifiers changed from: protected */
    public String getUbcModuleTitle() {
        GameModules gameModules = this.mModule;
        if (gameModules != null) {
            return gameModules.moduleName;
        }
        return null;
    }

    private class CardItemAdapter extends GameBaseRecyclerViewAdapter<VH> {
        private List<GameAppItemData> mItemDataList;
        private int mRow;
        private String mTitle;

        private CardItemAdapter() {
            this.mRow = 0;
            this.mTitle = "";
        }

        /* access modifiers changed from: package-private */
        public void setItemDataList(ArrayList<GameAppItemData> dataList, int row, String title) {
            this.mItemDataList = dataList;
            this.mRow = row;
            this.mTitle = title;
        }

        public VH onCreateViewHolder(ViewGroup itemView, int viewType) {
            return GameBaseMultipuleCardVHolder.this.createItemViewHolder(itemView);
        }

        public void onBindViewHolder(VH holder, int position) {
            List<GameAppItemData> list;
            super.onBindViewHolder(holder, position);
            if (holder != null && position >= 0 && (list = this.mItemDataList) != null && position < list.size()) {
                holder.bindData(this.mItemDataList.get(position), this.mRow, position, this.mTitle);
            }
        }

        public int getItemCount() {
            List<GameAppItemData> list = this.mItemDataList;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.mItemDataList.size();
        }
    }

    /* access modifiers changed from: private */
    public void rotateAnim(View imageView) {
        Animation anim = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        anim.setDuration(1000);
        anim.setRepeatCount(-1);
        anim.setRepeatMode(1);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setFillAfter(true);
        imageView.startAnimation(anim);
    }

    public void clearAnim() {
        this.mChangeIcon.clearAnimation();
    }
}
