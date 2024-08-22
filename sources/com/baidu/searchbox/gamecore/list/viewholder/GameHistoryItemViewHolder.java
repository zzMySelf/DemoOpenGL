package com.baidu.searchbox.gamecore.list.viewholder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.searchbox.gamecore.GameCenterRuntime;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.base.BaseViewHolder;
import com.baidu.searchbox.gamecore.image.GameImageView;
import com.baidu.searchbox.gamecore.list.model.GameAppItemData;
import com.baidu.searchbox.gamecore.list.model.GameModules;
import com.baidu.searchbox.gamecore.router.GameRouter;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import org.json.JSONException;
import org.json.JSONObject;

public class GameHistoryItemViewHolder extends BaseViewHolder<GameAppItemData> {
    private GameImageView mGameIcon;
    private TextView mGameName = ((TextView) this.itemView.findViewById(R.id.game_history_game_name));
    /* access modifiers changed from: private */
    public GameModules mModules;
    private GameRecommendTextView mRecommendView = ((GameRecommendTextView) this.itemView.findViewById(R.id.game_history_item_recommend));

    public GameHistoryItemViewHolder(GameModules modules, ViewGroup parentView) {
        super(LayoutInflater.from(parentView.getContext()).inflate(R.layout.game_history_card_item, parentView, false));
        this.mModules = modules;
        GameImageView gameImageView = (GameImageView) this.itemView.findViewById(R.id.game_history_item_icon);
        this.mGameIcon = gameImageView;
        gameImageView.setCircleAttr(0, GameCenterRuntime.getResources().getColor(com.baidu.searchbox.base.R.color.game_base_white), (float) GameCenterRuntime.getResources().getDimensionPixelOffset(R.dimen.dimen_1px));
    }

    public void bindData(final GameAppItemData data, final int parentPosition, final int position) {
        super.bindData(data, parentPosition, position);
        if (data != null) {
            this.mGameIcon.setUrl(data.icon);
            this.mGameName.setText(data.appName);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(data.scheme) && GameHistoryItemViewHolder.this.mModules != null) {
                        GameRouter.routerInvoke(GameHistoryItemViewHolder.this.itemView.getContext(), data.scheme);
                        try {
                            JSONObject ext = new JSONObject();
                            ext.put("id", data.resourceKey);
                            ext.put("game_id", data.appId);
                            ext.put("click_type", "card");
                            ext.put(GameUBCConst.EXT_KEY_GAME_TYPE, data.type);
                            GameHistoryItemViewHolder gameHistoryItemViewHolder = GameHistoryItemViewHolder.this;
                            gameHistoryItemViewHolder.ubcItemClick(gameHistoryItemViewHolder.mModules, parentPosition, position, ext);
                            GameHistoryItemViewHolder.this.saveCloudGame();
                        } catch (JSONException e2) {
                        }
                    }
                }
            });
            this.mRecommendView.setVisibility(data.isRecommend ? 0 : 8);
            setCardTheme();
        }
    }

    public void setCardTheme() {
        this.mGameName.setTextColor(this.mResources.getColor(R.color.game_base_black));
    }

    public String generateDisplayId() {
        if (getItemData() == null || this.mModules == null) {
            return null;
        }
        return this.mModules.moduleId + "_" + ((GameAppItemData) getItemData()).resourceKey;
    }

    public static class GameRecommendTextView extends AppCompatTextView {
        private Paint mBgPaint = new Paint();
        private Paint mNightPaint = new Paint();
        private int mRadius;

        public GameRecommendTextView(Context context) {
            super(context);
            init(context);
        }

        public GameRecommendTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public void init(Context context) {
            this.mBgPaint = new Paint();
            this.mNightPaint = new Paint();
            this.mBgPaint.setColor(GameCenterRuntime.getResources().getColor(R.color.game_history_item_recommend));
            this.mNightPaint.setColor(getResources().getColor(R.color.game_lottie_night_layer_color));
            this.mRadius = ((int) GameCenterRuntime.getResources().getDimension(R.dimen.dimen_55dp)) >> 1;
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            int measuredHeight = getMeasuredHeight();
            int i2 = this.mRadius;
            canvas.drawCircle((float) this.mRadius, (float) (measuredHeight - i2), (float) i2, this.mBgPaint);
            super.onDraw(canvas);
            if (GameCenterRuntime.getGameContext().isNightMode()) {
                int measuredHeight2 = getMeasuredHeight();
                int i3 = this.mRadius;
                canvas.drawCircle((float) this.mRadius, (float) (measuredHeight2 - i3), (float) i3, this.mNightPaint);
            }
        }
    }
}
