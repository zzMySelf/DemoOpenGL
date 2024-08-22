package com.baidu.searchbox.gamecore.recommend.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.base.GameLibBaseRuntime;
import com.baidu.searchbox.base.utils.UIUtils;
import com.baidu.searchbox.gamecore.GameCenterRuntime;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.image.GameImageView;
import com.baidu.searchbox.gamecore.recommend.model.RecommendItemData;
import com.baidu.searchbox.gamecore.router.GameRouter;
import com.baidu.searchbox.gamecore.ubc.GameCenterUBCUtil;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.searchbox.gamecore.util.GamesColorUtils;
import java.util.HashMap;
import java.util.Map;

public class GameRecommendCardView extends FrameLayout implements View.OnClickListener {
    private static final float ASPECT_RATIO = 1.63366f;
    private static final int COVER_BOTTOM_ALPHA = 242;
    private static final int GAME_TITLE_TOP_ALPHA_FF = 204;
    private static final int GAME_TITLE_TOP_ALPHA_ZERO = 0;
    private static final int PARSE_COLOR = Color.parseColor("#0C000000");
    private static final int PRESSED_NIGHT_COLOR = Color.parseColor("#33000000");
    private int mCorner;
    private RelativeLayout mGameCoverBottomRl;
    private GameImageView mGameCoverImg;
    private FrameLayout mGameCoverLayout;
    private TextView mGameDescTopTv;
    private GameImageView mGameHeadImg;
    private TextView mGameNameTv;
    private TextView mGameNumberTv;
    private TextView mGameTitleTv;
    private Button mPlayerButton;
    private int mPosition = -1;
    /* access modifiers changed from: private */
    public RecommendItemData mRecommendItemData;

    public GameRecommendCardView(Context context) {
        super(context);
        initView(context);
    }

    public GameRecommendCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GameRecommendCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.game_game_recommend_card, this, true);
        this.mCorner = GameCenterRuntime.getResources().getDimensionPixelSize(R.dimen.dimen_4dp);
        this.mGameCoverLayout = (FrameLayout) findViewById(R.id.cover_layout);
        this.mGameCoverImg = (GameImageView) findViewById(R.id.iv_game_cover);
        this.mGameDescTopTv = (TextView) findViewById(R.id.tv_game_desc_top);
        this.mGameTitleTv = (TextView) findViewById(R.id.tv_card_title_top);
        this.mGameCoverBottomRl = (RelativeLayout) findViewById(R.id.game_cover_bottom_rl);
        GameImageView gameImageView = (GameImageView) findViewById(R.id.iv_game_head);
        this.mGameHeadImg = gameImageView;
        gameImageView.setCircleAttr(GameCenterRuntime.getResources().getDimensionPixelOffset(R.dimen.dimen_46dp), GameCenterRuntime.getResources().getColor(R.color.game_item_image_bg_color), (float) GameCenterRuntime.getResources().getDimensionPixelOffset(R.dimen.dimen_1px));
        this.mGameNameTv = (TextView) findViewById(R.id.tv_item_games_name_text);
        this.mGameNumberTv = (TextView) findViewById(R.id.tv_item_number_text);
        this.mPlayerButton = (Button) findViewById(R.id.player_button);
        setOnClickListener(this);
    }

    private void initTheme() {
        Resources resource = GameCenterRuntime.getResources();
        setBackground(resource.getDrawable(R.drawable.game_recommend_card_bg_shap));
        this.mGameCoverLayout.setBackgroundColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_white));
        this.mGameDescTopTv.setTextColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_white));
        this.mGameTitleTv.setTextColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_white));
        this.mGameNameTv.setTextColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_white));
        this.mGameNumberTv.setAlpha(0.4f);
        this.mGameNumberTv.setTextColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_white));
        this.mGameHeadImg.setBackground(resource.getDrawable(R.drawable.game_new_card_item_icon_bg));
        this.mPlayerButton.setBackground(resource.getDrawable(R.drawable.game_begin_button_shap));
        this.mPlayerButton.setTextColor(resource.getColor(R.color.game_game_player_button_color));
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean isNightMode = GameLibBaseRuntime.getGameLibBaseContext().isNightMode();
        switch (ev.getAction()) {
            case 0:
                setForeground(new ColorDrawable(isNightMode ? PRESSED_NIGHT_COLOR : PARSE_COLOR));
                break;
            case 1:
                setForeground((Drawable) null);
                break;
            case 3:
                setForeground((Drawable) null);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void updateData(final RecommendItemData data, final int position) {
        initTheme();
        if (data != null) {
            this.mPosition = position;
            this.mRecommendItemData = data;
            adjustHeight(data.imgRatio);
            this.mGameDescTopTv.setText(data.cardDesc);
            this.mGameTitleTv.setText(data.cardTitle);
            this.mGameCoverImg.setUrl(data.coverUrl);
            this.mGameNameTv.setText(data.appName);
            this.mGameNumberTv.setText(data.playInfo);
            this.mPlayerButton.setText(data.button == null ? "" : data.button.text);
            this.mGameHeadImg.setUrl(data.iconUrl);
            String titleTopBkColor = GamesColorUtils.getColors(data.barColor, data.nightBarColor);
            int i2 = this.mCorner;
            ShapeDrawable gameCoverBottombg = new ShapeDrawable(new RoundRectShape(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) i2, (float) i2, (float) i2, (float) i2}, (RectF) null, (float[]) null));
            try {
                gameCoverBottombg.getPaint().setColor(GamesColorUtils.changeAlpha(Color.parseColor(titleTopBkColor), 242));
            } catch (IllegalArgumentException e2) {
                gameCoverBottombg.getPaint().setColor(GamesColorUtils.changeAlpha(Color.parseColor(GamesColorUtils.getColors((String) null, (String) null)), 242));
            }
            this.mGameCoverBottomRl.setBackground(gameCoverBottombg);
            this.mPlayerButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (GameRecommendCardView.this.mRecommendItemData.button != null && !TextUtils.isEmpty(GameRecommendCardView.this.mRecommendItemData.button.scheme)) {
                        GameCenterUtils.onClickEvent(GameRecommendCardView.this.mRecommendItemData.button.scheme);
                        GameCenterUtils.requestAudioFocus(GameRecommendCardView.this.getContext());
                        GameRouter.routerInvoke(GameRecommendCardView.this.getContext(), GameRecommendCardView.this.mRecommendItemData.button.scheme);
                        if (position >= 0) {
                            HashMap<String, String> ext = new HashMap<>();
                            ext.put(GameUBCConst.EXT_KEY_UPDATE_DAY, GameRecommendCardView.this.mRecommendItemData.startTime);
                            ext.put("id", GameRecommendCardView.this.mRecommendItemData.id);
                            ext.put("location", String.valueOf(position + 1));
                            ext.put("click_type", "button");
                            ext.put(GameUBCConst.EXT_KEY_GAME_TYPE, data.type);
                            GameCenterUBCUtil.gameEvent(GameUBCConst.SHOW_CLICK_ID, "click", GameUBCConst.PAGE_RECOMMEND_PAGE, (Map<String, String>) ext);
                        }
                    }
                }
            });
        }
    }

    private void adjustHeight(float ratio) {
        if (ratio > 0.0f) {
            int height = (int) (((float) (GameCenterRuntime.getResources().getDisplayMetrics().widthPixels - UIUtils.dp2px(getContext(), 30))) / ratio);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, height);
            }
            layoutParams.height = height;
            setLayoutParams(layoutParams);
        }
    }

    public void onClick(View v) {
        if (!TextUtils.isEmpty(this.mRecommendItemData.scheme)) {
            GameCenterUtils.requestAudioFocus(getContext());
            GameRouter.routerInvoke(getContext(), this.mRecommendItemData.scheme);
            GameCenterUtils.onClickEvent(this.mRecommendItemData.scheme);
            if (this.mPosition >= 0) {
                HashMap<String, String> ext = new HashMap<>();
                ext.put(GameUBCConst.EXT_KEY_UPDATE_DAY, this.mRecommendItemData.startTime);
                ext.put("id", this.mRecommendItemData.id);
                ext.put("location", String.valueOf(this.mPosition + 1));
                ext.put("click_type", "card");
                ext.put(GameUBCConst.EXT_KEY_GAME_TYPE, this.mRecommendItemData.type);
                GameCenterUBCUtil.gameEvent(GameUBCConst.SHOW_CLICK_ID, "click", "game", GameUBCConst.PAGE_RECOMMEND_PAGE, (Map<String, String>) ext);
            }
        }
    }
}
