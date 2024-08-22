package com.baidu.searchbox.gamecore.list.viewholder;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.base.GameLibBaseRuntime;
import com.baidu.searchbox.base.widget.SelectorButton;
import com.baidu.searchbox.gamecore.GameCenterRuntime;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.base.datasource.GameDataManager;
import com.baidu.searchbox.gamecore.image.GameImageView;
import com.baidu.searchbox.gamecore.list.model.GameAppItemData;
import com.baidu.searchbox.gamecore.list.model.GameModules;
import com.baidu.searchbox.gamecore.router.GameRouter;
import com.baidu.searchbox.gamecore.ubc.GameCenterUBCUtil;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import com.baidu.searchbox.video.feedflow.tab.tablayout.TabLayoutView;
import java.util.HashMap;

public class GameVerticalRankCardListItemViewHolder extends RecyclerView.ViewHolder {
    private SelectorButton mButton = ((SelectorButton) this.itemView.findViewById(R.id.game_vertical_card_rank_item_play_btn));
    private View mDescDiv1 = this.itemView.findViewById(R.id.game_vertical_card_rank_desc_div1);
    private View mDescDiv2 = this.itemView.findViewById(R.id.game_vertical_card_rank_desc_div2);
    private View mDescDiv3 = this.itemView.findViewById(R.id.game_vertical_card_rank_desc_div3);
    private View mDescShape = this.itemView.findViewById(R.id.game_vertical_rank_card_shape_divider);
    private TextView mDescTag1 = ((TextView) this.itemView.findViewById(R.id.game_vertical_card_rank_desc_tag1));
    private TextView mDescTag2 = ((TextView) this.itemView.findViewById(R.id.game_vertical_card_rank_desc_tag2));
    private TextView mDescTag3 = ((TextView) this.itemView.findViewById(R.id.game_vertical_card_rank_desc_tag3));
    private TextView mDescTag4 = ((TextView) this.itemView.findViewById(R.id.game_vertical_card_rank_desc_tag4));
    private View mDivider = this.itemView.findViewById(R.id.game_vertical_rank_card_divider);
    private GameAppItemData mGameItemData;
    /* access modifiers changed from: private */
    public GameModules mGameModule;
    private GameImageView mIcon;
    private LinearLayout mLinearLayout;
    private int mListPos;
    private GameImageView mMedal = ((GameImageView) this.itemView.findViewById(R.id.game_vertical_card_rank_medal));
    private TextView mRankNumber = ((TextView) this.itemView.findViewById(R.id.game_vertical_card_rank_medal_text));
    private TextView mTitle = ((TextView) this.itemView.findViewById(R.id.game_vertical_card_rank_title));
    private int mViewPagerPos;

    public GameVerticalRankCardListItemViewHolder(GameModules gameModule, ViewGroup parentView) {
        super(LayoutInflater.from(parentView.getContext()).inflate(R.layout.game_vertical_rank_item_view, parentView, false));
        this.mGameModule = gameModule;
        GameImageView gameImageView = (GameImageView) this.itemView.findViewById(R.id.game_vertical_card_rank_icon);
        this.mIcon = gameImageView;
        gameImageView.setCircleAttr(GameCenterRuntime.getResources().getDimensionPixelOffset(R.dimen.dimen_46dp), GameCenterRuntime.getResources().getColor(R.color.game_item_image_bg_color), (float) GameCenterRuntime.getResources().getDimensionPixelOffset(R.dimen.dimen_1px));
        if (gameModule.moduleType.equals("21")) {
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R.id.game_vertical_card_rank_description_area);
            this.mLinearLayout = linearLayout;
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            params.leftMargin = 0;
            this.mLinearLayout.setLayoutParams(params);
        }
    }

    public void bindData(GameModules module, GameAppItemData gameItemData, String rankTitle, int listPosition, int viewPagerPosition, int parentCardPosition) {
        int descTagListIndex;
        GameModules gameModules = module;
        GameAppItemData gameAppItemData = gameItemData;
        int i2 = listPosition;
        if (gameAppItemData == null || gameAppItemData.button == null) {
            int i3 = viewPagerPosition;
        } else if (gameModules == null) {
            int i4 = viewPagerPosition;
        } else {
            this.mViewPagerPos = viewPagerPosition;
            this.mListPos = i2;
            this.mGameItemData = gameAppItemData;
            Resources resource = GameCenterRuntime.getResources();
            this.mIcon.setUrl(gameAppItemData.icon);
            this.mIcon.setBackground(resource.getDrawable(R.drawable.game_new_card_item_icon_bg));
            if (gameModules.moduleType.equals("21")) {
                setRankNumberView(i2, gameAppItemData.rankIcon);
            }
            this.mTitle.setText(gameAppItemData.appName);
            this.mDescTag1.setText("");
            this.mDescTag2.setText("");
            this.mDescTag3.setText("");
            this.mDescTag4.setText("");
            this.mDescDiv1.setVisibility(4);
            this.mDescDiv2.setVisibility(4);
            this.mDescDiv3.setVisibility(4);
            int descTagListIndex2 = 0;
            int descTagCount = gameAppItemData.descTagList != null ? gameAppItemData.descTagList.size() : 0;
            if (gameAppItemData.obviousTagShow == 1) {
                int color = Color.parseColor(gameAppItemData.obviousTag.color);
                SpannableString spannableString = new SpannableString(gameAppItemData.obviousTag.text);
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 18);
                this.mDescTag1.setText(spannableString);
            } else if (descTagCount > 0) {
                this.mDescTag1.setText(gameAppItemData.descTagList.get(0));
                descTagListIndex2 = 0 + 1;
            } else if (!TextUtils.isEmpty(gameAppItemData.desc)) {
                this.mDescTag1.setText(gameAppItemData.desc);
            }
            if (descTagListIndex2 < descTagCount) {
                this.mDescDiv1.setVisibility(0);
                this.mDescTag2.setText(gameAppItemData.descTagList.get(descTagListIndex2));
                descTagListIndex2++;
                this.mDescTag2.setVisibility(0);
            }
            if (descTagListIndex2 < descTagCount) {
                this.mDescDiv2.setVisibility(0);
                this.mDescTag3.setText(gameAppItemData.descTagList.get(descTagListIndex2));
                this.mDescTag3.setVisibility(0);
                descTagListIndex = descTagListIndex2 + 1;
            } else {
                descTagListIndex = descTagListIndex2;
            }
            if (descTagListIndex < descTagCount) {
                this.mDescDiv3.setVisibility(0);
                this.mDescTag4.setText(gameAppItemData.descTagList.get(descTagListIndex));
                this.mDescTag4.setVisibility(0);
            }
            this.mButton.setText(gameAppItemData.button.text);
            final String type = gameAppItemData.type;
            String buttonScheme = gameAppItemData.button.scheme;
            AnonymousClass1 r15 = r0;
            final String str = buttonScheme;
            SelectorButton selectorButton = this.mButton;
            final GameAppItemData gameAppItemData2 = gameItemData;
            String buttonScheme2 = buttonScheme;
            final String buttonScheme3 = rankTitle;
            String type2 = type;
            int i5 = descTagListIndex;
            final int descTagListIndex3 = listPosition;
            int i6 = descTagCount;
            final int descTagCount2 = viewPagerPosition;
            final int i7 = parentCardPosition;
            AnonymousClass1 r0 = new View.OnClickListener() {
                public void onClick(View v) {
                    GameVerticalRankCardListItemViewHolder gameVerticalRankCardListItemViewHolder = GameVerticalRankCardListItemViewHolder.this;
                    gameVerticalRankCardListItemViewHolder.onClicked("button", gameVerticalRankCardListItemViewHolder.mGameModule, str, gameAppItemData2.resourceKey, buttonScheme3, type, descTagListIndex3, descTagCount2, i7);
                }
            };
            selectorButton.setOnClickListener(r15);
            final String itemScheme = TextUtils.isEmpty(gameAppItemData.scheme) ? buttonScheme2 : gameAppItemData.scheme;
            final GameAppItemData gameAppItemData3 = gameItemData;
            final String str2 = rankTitle;
            final String str3 = type2;
            final int i8 = listPosition;
            final int i9 = viewPagerPosition;
            final int i10 = parentCardPosition;
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GameVerticalRankCardListItemViewHolder gameVerticalRankCardListItemViewHolder = GameVerticalRankCardListItemViewHolder.this;
                    gameVerticalRankCardListItemViewHolder.onClicked("card", gameVerticalRankCardListItemViewHolder.mGameModule, itemScheme, gameAppItemData3.resourceKey, str2, str3, i8, i9, i10);
                }
            });
            this.mDivider.setVisibility(i2 == 0 ? 4 : 0);
            onThemeChange();
        }
    }

    public String generateDisplayId() {
        return this.mGameModule.moduleId + "_" + this.mViewPagerPos + "_" + this.mListPos;
    }

    public GameAppItemData getItemData() {
        return this.mGameItemData;
    }

    public int getViewPagerPos() {
        return this.mViewPagerPos;
    }

    public int getListPos() {
        return this.mListPos;
    }

    /* access modifiers changed from: private */
    public void onClicked(String clickType, GameModules rankModule, String scheme, String appKey, String rankTitle, String type, int listPosition, int viewPagerPosition, int parentCardPosition) {
        GameRouter.routerInvoke(this.itemView.getContext(), scheme);
        HashMap<String, String> ext = new HashMap<>();
        ext.put("title", rankTitle);
        ext.put("col", (viewPagerPosition + 1) + "");
        ext.put("row", (parentCardPosition + 1) + "");
        ext.put(GameUBCConst.EXT_RANK_ROW, (listPosition + 1) + "");
        ext.put("click_type", clickType);
        ext.put("id", appKey);
        GameAppItemData gameAppItemData = this.mGameItemData;
        if (gameAppItemData != null) {
            ext.put("game_id", gameAppItemData.appId);
        }
        ext.put(GameUBCConst.EXT_KEY_GAME_TYPE, type);
        ext.put("module_id", rankModule.moduleId);
        ext.put("module_type", rankModule.moduleType);
        ext.put("logid", GameCenterUBCUtil.getLogId(this.mGameModule));
        GameModules gameModules = this.mGameModule;
        if (gameModules != null && !gameModules.isNetData) {
            ext.put("cache", GameDataManager.getInstance().getCurrentDataCacheType());
        }
        GameCenterUBCUtil.gameUBCWithSwanVer(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "click", GameUBCConst.VALUE_VERTICAL_TEMP, GameUBCConst.PAGE_FIND_PAGE, ext);
        saveCloudGame();
    }

    private void saveCloudGame() {
        GameAppItemData gameAppItemData = this.mGameItemData;
        if (gameAppItemData != null && "4".equals(gameAppItemData.type)) {
            GameDataManager.getInstance().saveCloudCache(this.mGameItemData);
        }
    }

    private void onThemeChange() {
        Resources resources = GameCenterRuntime.getResources();
        this.mTitle.setTextColor(resources.getColor(R.color.game_base_black));
        this.mDivider.setBackgroundColor(resources.getColor(R.color.game_card_gray_line_color));
        if (this.mDescTag1.getVisibility() == 0) {
            this.mDescTag1.setTextColor(resources.getColor(R.color.game_gray_color));
        }
        if (this.mDescTag2.getVisibility() == 0) {
            this.mDescTag2.setTextColor(resources.getColor(R.color.game_gray_color));
        }
        if (this.mDescTag3.getVisibility() == 0) {
            this.mDescTag3.setTextColor(resources.getColor(R.color.game_gray_color));
        }
        if (this.mDescTag4.getVisibility() == 0) {
            this.mDescTag4.setTextColor(resources.getColor(R.color.game_gray_color));
        }
        this.mButton.setTextColor(resources.getColor(R.color.game_play_button_text));
        this.mButton.setBackground(resources.getDrawable(R.drawable.game_card_button_border_bg_selector));
        boolean isNightMode = GameLibBaseRuntime.getGameLibBaseContext().isNightMode();
        this.mButton.setPressedAlphaScale(isNightMode ? 0.5f : 0.2f);
        this.mDescShape.setBackgroundResource(isNightMode ? R.drawable.game_vertical_shape_night : R.drawable.game_vertical_shape);
    }

    public void setRankNumberView(int listPosition, String iconUrl) {
        int i2 = 8;
        this.mMedal.setVisibility(listPosition <= 2 ? 0 : 8);
        TextView textView = this.mRankNumber;
        if (listPosition > 2) {
            i2 = 0;
        }
        textView.setVisibility(i2);
        if (listPosition >= 3) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.mLinearLayout.getLayoutParams();
            params.addRule(1, this.mRankNumber.getId());
            this.mLinearLayout.setLayoutParams(params);
            this.mRankNumber.setText(GameCenterRuntime.getResources().getString(R.string.game_common_set_text, new Object[]{Integer.valueOf(listPosition + 1)}));
        } else if (!TextUtils.isEmpty(iconUrl)) {
            this.mMedal.setUrl(iconUrl);
        } else {
            if (GameLibBaseRuntime.getGameLibBaseContext().isNightMode()) {
                this.mMedal.setColorFilter(TabLayoutView.VALUE_UNDERLINE_COLOR_DEFAULT, PorterDuff.Mode.MULTIPLY);
            }
            Resources resource = GameCenterRuntime.getResources();
            if (listPosition == 0) {
                this.mMedal.setImageDrawable(resource.getDrawable(R.drawable.game_card_rank_first_place));
            } else if (listPosition == 1) {
                this.mMedal.setImageDrawable(resource.getDrawable(R.drawable.game_card_rank_second_place));
            } else if (listPosition == 2) {
                this.mMedal.setImageDrawable(resource.getDrawable(R.drawable.game_card_rank_third_place));
            }
        }
    }
}
