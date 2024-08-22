package com.baidu.searchbox.gamecore.person.viewholder.goods;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.gamecore.GameCenterRuntime;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.base.BaseViewHolder;
import com.baidu.searchbox.gamecore.image.GameImageView;
import com.baidu.searchbox.gamecore.person.model.GoodItem;
import com.baidu.searchbox.gamecore.router.GameRouter;
import com.baidu.searchbox.gamecore.ubc.GameCenterUBCUtil;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;

public class GoodsGridItemViewHolder extends BaseViewHolder<GoodItem> {
    /* access modifiers changed from: private */
    public GameImageView mGoodImage;
    private TextView mGoodName = ((TextView) this.itemView.findViewById(R.id.game_goods_name));
    private TextView mGoodPrice = ((TextView) this.itemView.findViewById(R.id.game_goods_price));
    private TextView mGoodPriceSuffix = ((TextView) this.itemView.findViewById(R.id.game_goods_price_suffix));

    public GoodsGridItemViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.game_goods_card_item, parent, false));
        GameImageView gameImageView = (GameImageView) this.itemView.findViewById(R.id.game_goods_image);
        this.mGoodImage = gameImageView;
        gameImageView.setRadiusAttr(this.mResources.getDimensionPixelOffset(R.dimen.game_imax_card_corner));
    }

    public void bindData(final GoodItem data, int position) {
        super.bindData(data, position);
        if (data != null && !TextUtils.isEmpty(data.getPic())) {
            this.mGoodImage.setUrl(data.getPic());
            this.mGoodName.setText(data.getGoodsName());
            this.mGoodPrice.setText(GameCenterRuntime.getResources().getString(R.string.game_common_set_text, new Object[]{Long.valueOf(data.getGoodsPrice())}));
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    GameRouter.routerInvoke(GoodsGridItemViewHolder.this.mGoodImage.getContext(), data.getScheme());
                    GameCenterUBCUtil.gameEvent(GameUBCConst.PERSON_CENTER_ID, "click", "goods", GameUBCConst.PAGE_PERSON_CENTER);
                }
            });
            onThemeChange();
        }
    }

    private void onThemeChange() {
        ((TextView) getView(R.id.game_goods_name)).setTextColor(this.mResources.getColor(R.color.game_base_black));
        ((TextView) getView(R.id.game_goods_price)).setTextColor(this.mResources.getColor(R.color.game_person_center_item_price_color));
        ((TextView) getView(R.id.game_goods_price_suffix)).setTextColor(this.mResources.getColor(R.color.game_person_center_item_price_color));
    }
}
