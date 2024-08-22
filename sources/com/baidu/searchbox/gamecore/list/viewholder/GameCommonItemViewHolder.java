package com.baidu.searchbox.gamecore.list.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.base.GameLibBaseRuntime;
import com.baidu.searchbox.base.widget.SelectorButton;
import com.baidu.searchbox.gamecore.GameCenterRuntime;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.base.BaseViewHolder;
import com.baidu.searchbox.gamecore.image.GameImageView;
import com.baidu.searchbox.gamecore.list.model.GameAppItemData;
import com.baidu.searchbox.gamecore.list.model.GameItemBaseData;
import com.baidu.searchbox.gamecore.list.model.GameModules;
import com.baidu.searchbox.gamecore.router.GameRouter;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCommonItemViewHolder extends BaseViewHolder<GameItemBaseData> {
    private static final boolean DEBUG = false;
    private LinearLayout mGameArea;
    private GameImageView mGameIcon;
    private TextView mGameName;
    private GameModules mNewCardModule;
    private SelectorButton mPlayButton;
    private TextView mPlayerInfo;

    public GameCommonItemViewHolder(GameModules newCardModule, ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.game_new_card_item, parent, false));
        this.mNewCardModule = newCardModule;
        init();
    }

    private void init() {
        this.mGameArea = (LinearLayout) getView(R.id.game_new_card_item_area);
        GameImageView gameImageView = (GameImageView) getView(R.id.game_new_card_item_icon);
        this.mGameIcon = gameImageView;
        gameImageView.setCircleAttr(this.mResources.getDimensionPixelOffset(R.dimen.dimen_64dp), this.mResources.getColor(R.color.game_item_image_bg_color), (float) this.mResources.getDimensionPixelOffset(R.dimen.dimen_1px));
        this.mGameName = (TextView) getView(R.id.game_new_card_item_game_name);
        this.mPlayerInfo = (TextView) getView(R.id.game_new_card_item_player_info);
        this.mPlayButton = (SelectorButton) getView(R.id.game_new_card_item_game_play_button);
    }

    private void setItemTheme() {
        this.mGameIcon.setBackground(this.mResources.getDrawable(R.drawable.game_new_card_item_icon_bg));
        this.mGameName.setTextColor(this.mResources.getColor(R.color.game_base_black));
        this.mPlayerInfo.setTextColor(this.mResources.getColor(R.color.game_gray_color));
        this.mPlayButton.setTextColor(this.mResources.getColor(R.color.game_play_button_text));
        this.mPlayButton.setBackground(this.mResources.getDrawable(R.drawable.game_card_button_border_bg_selector));
        this.mPlayButton.setPressedAlphaScale(GameLibBaseRuntime.getGameLibBaseContext().isNightMode() ? 0.5f : 0.2f);
    }

    public void bindData(GameItemBaseData data, int row, int col, String title) {
        super.bindData(data, row, col, title);
        if (data != null) {
            if (data instanceof GameAppItemData) {
                GameAppItemData itemData = (GameAppItemData) data;
                if (!TextUtils.isEmpty(itemData.icon)) {
                    this.mGameIcon.setUrl(itemData.icon);
                }
                if (!TextUtils.isEmpty(itemData.appName)) {
                    this.mGameName.setText(itemData.appName);
                }
                if (!TextUtils.isEmpty(itemData.playInfo)) {
                    this.mPlayerInfo.setText(itemData.playInfo);
                    this.mPlayerInfo.setVisibility(0);
                } else {
                    this.mPlayerInfo.setVisibility(8);
                }
                if (itemData.button == null || TextUtils.isEmpty(itemData.button.text) || this.mNewCardModule.buttonShowSwitch != 0) {
                    this.mPlayButton.setVisibility(8);
                } else {
                    if (TextUtils.equals("6", itemData.type)) {
                        this.mPlayButton.setText(GameCenterRuntime.getResources().getString(R.string.game_card_mobile_btntext));
                    } else {
                        this.mPlayButton.setText(itemData.button.text);
                    }
                    this.mPlayButton.setVisibility(0);
                    final GameAppItemData gameAppItemData = itemData;
                    final int i2 = row;
                    final int i3 = col;
                    final String str = title;
                    this.mPlayButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            GameCenterUtils.requestAudioFocus(GameCommonItemViewHolder.this.itemView.getContext());
                            GameRouter.routerInvoke(GameCommonItemViewHolder.this.itemView.getContext(), gameAppItemData.button.scheme);
                            GameCenterUtils.onClickEvent(gameAppItemData.button.scheme);
                            GameCommonItemViewHolder.this.clickUbc(i2, i3, str, gameAppItemData, "button");
                        }
                    });
                }
                final GameAppItemData gameAppItemData2 = itemData;
                final int i4 = row;
                final int i5 = col;
                final String str2 = title;
                this.mGameArea.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (!TextUtils.isEmpty(gameAppItemData2.scheme) && GameCenterUtils.isGameCenterLoadReady(GameCommonItemViewHolder.this.itemView.getContext(), gameAppItemData2.scheme)) {
                            GameRouter.routerInvoke(GameCommonItemViewHolder.this.itemView.getContext(), gameAppItemData2.scheme);
                            GameCenterUtils.onClickEvent(gameAppItemData2.scheme);
                            GameCommonItemViewHolder.this.clickUbc(i4, i5, str2, gameAppItemData2, "card");
                        }
                    }
                });
            }
            setItemTheme();
        }
    }

    public String generateDisplayId() {
        if (this.mNewCardModule == null || getItemData() == null || !(getItemData() instanceof GameAppItemData)) {
            return null;
        }
        return this.mNewCardModule.moduleId + "_" + ((GameAppItemData) getItemData()).resourceKey;
    }

    /* access modifiers changed from: private */
    public void clickUbc(int row, int col, String title, GameAppItemData itemData, String clickType) {
        if (row >= 0 && col >= 0 && !TextUtils.isEmpty(title) && this.mNewCardModule != null) {
            oldUbcItemClick("click", "game", GameUBCConst.PAGE_FIND_PAGE, getExtJSONData(itemData.resourceKey, itemData.appId, itemData.type, row, col, title, clickType));
            try {
                JSONObject ext = new JSONObject();
                ext.put("id", itemData.resourceKey);
                ext.put("game_id", itemData.appId);
                ext.put("click_type", clickType);
                ext.put(GameUBCConst.EXT_KEY_GAME_TYPE, itemData.type);
                ubcItemClick(this.mNewCardModule, row, col, ext);
                saveCloudGame();
            } catch (JSONException e2) {
            }
        }
    }
}
