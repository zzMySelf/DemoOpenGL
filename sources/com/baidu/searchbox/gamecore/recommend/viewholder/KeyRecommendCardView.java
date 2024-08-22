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
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.searchbox.gamecore.widget.GameCenterLottieView;
import java.util.HashMap;
import java.util.Map;

public class KeyRecommendCardView extends FrameLayout implements View.OnClickListener {
    private static final float ASPECT_RATIO = 1.63366f;
    private static final int COVER_BOTTOM_ALPHA = 242;
    private static final int PARSE_COLOR = Color.parseColor("#0C000000");
    private static final int PRESSED_NIGHT_COLOR = Color.parseColor("#33000000");
    private int mCorner;
    private RelativeLayout mGameCoverBottomRl;
    private GameImageView mGameCoverImg;
    private FrameLayout mGameCoverLayout;
    private GameCenterLottieView mGameCoverLottie;
    private GameImageView mGameHeadImg;
    private TextView mGameNameTv;
    private TextView mGameNumberTv;
    private LinearLayout mGameTitleTopLl;
    private TextView mGameTitleTopTv;
    private Button mPlayerButton;
    /* access modifiers changed from: private */
    public int mPosition = 0;
    /* access modifiers changed from: private */
    public RecommendItemData mRecommendKeyItemData;

    public KeyRecommendCardView(Context context) {
        super(context);
        initView(context);
    }

    public KeyRecommendCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public KeyRecommendCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.game_key_recommend_card, this, true);
        this.mCorner = GameCenterRuntime.getResources().getDimensionPixelSize(R.dimen.dimen_4dp);
        this.mGameCoverLayout = (FrameLayout) findViewById(R.id.cover_layout);
        GameCenterLottieView gameCenterLottieView = (GameCenterLottieView) findViewById(R.id.game_key_recommend_card_lottie);
        this.mGameCoverLottie = gameCenterLottieView;
        gameCenterLottieView.setLottieCorner((float) this.mCorner);
        this.mGameCoverImg = this.mGameCoverLottie.getImageView();
        this.mGameTitleTopLl = (LinearLayout) findViewById(R.id.ll_game_title_top);
        this.mGameTitleTopTv = (TextView) findViewById(R.id.tv_card_title_top);
        this.mGameCoverBottomRl = (RelativeLayout) findViewById(R.id.game_cover_bottom_rl);
        GameImageView gameImageView = (GameImageView) findViewById(R.id.iv_game_head);
        this.mGameHeadImg = gameImageView;
        gameImageView.setCircleAttr(GameCenterRuntime.getResources().getDimensionPixelOffset(R.dimen.dimen_31dp), GameCenterRuntime.getResources().getColor(R.color.game_item_image_bg_color), (float) GameCenterRuntime.getResources().getDimensionPixelOffset(R.dimen.dimen_1px));
        this.mGameNameTv = (TextView) findViewById(R.id.tv_item_games_name_text);
        this.mGameNumberTv = (TextView) findViewById(R.id.tv_item_number_text);
        this.mPlayerButton = (Button) findViewById(R.id.player_button);
        setOnClickListener(this);
    }

    private void initTheme() {
        Resources resource = GameCenterRuntime.getResources();
        setBackground(resource.getDrawable(R.drawable.game_recommend_card_bg_shap));
        this.mGameTitleTopTv.setTextColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_white));
        this.mGameCoverLayout.setBackgroundColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_white));
        this.mGameNameTv.setTextColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_white));
        this.mGameNumberTv.setAlpha(0.4f);
        this.mGameNumberTv.setTextColor(resource.getColor(com.baidu.searchbox.base.R.color.game_base_white));
        this.mGameCoverImg.setScaleType(ImageView.ScaleType.CENTER);
        this.mGameHeadImg.setBackground(resource.getDrawable(R.drawable.game_new_card_item_icon_bg));
        this.mPlayerButton.setBackground(resource.getDrawable(R.drawable.game_begin_button_shap));
        this.mPlayerButton.setTextColor(resource.getColor(R.color.game_game_player_button_color));
        this.mGameTitleTopTv.setShadowLayer((float) UIUtils.dip2px(getContext(), 1.0f), 0.0f, 0.0f, resource.getColor(R.color.game_game_title_color));
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

    public void updateData(RecommendItemData data, int position) {
        initTheme();
        if (data != null) {
            this.mPosition = position;
            this.mRecommendKeyItemData = data;
            adjustHeight(data.imgRatio);
            this.mGameTitleTopTv.setText(data.cardTitle);
            this.mGameCoverLottie.updateData(data.apsId, data.coverUrl);
            this.mGameNameTv.setText(data.appName);
            this.mGameNumberTv.setText(data.playInfo);
            this.mPlayerButton.setText(data.button == null ? "" : data.button.text);
            this.mGameHeadImg.setUrl(data.iconUrl);
            String titleTopBkColor = GamesColorUtils.getColors(data.barColor, data.nightBarColor);
            int i2 = this.mCorner;
            ShapeDrawable backgroundDrawable = new ShapeDrawable(new RoundRectShape(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) i2, (float) i2, (float) i2, (float) i2}, (RectF) null, (float[]) null));
            try {
                backgroundDrawable.getPaint().setColor(GamesColorUtils.changeAlpha(Color.parseColor(titleTopBkColor), 242));
            } catch (IllegalArgumentException e2) {
                backgroundDrawable.getPaint().setColor(GamesColorUtils.changeAlpha(Color.parseColor(GamesColorUtils.getColors((String) null, (String) null)), 242));
            }
            this.mGameCoverBottomRl.setBackground(backgroundDrawable);
            this.mPlayerButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (KeyRecommendCardView.this.mRecommendKeyItemData.button != null && !TextUtils.isEmpty(KeyRecommendCardView.this.mRecommendKeyItemData.button.scheme)) {
                        GameCenterUtils.requestAudioFocus(KeyRecommendCardView.this.getContext());
                        GameRouter.routerInvoke(KeyRecommendCardView.this.getContext(), KeyRecommendCardView.this.mRecommendKeyItemData.button.scheme);
                    }
                    GameCenterUtils.onClickEvent(KeyRecommendCardView.this.mRecommendKeyItemData.button.scheme);
                    KeyRecommendCardView keyRecommendCardView = KeyRecommendCardView.this;
                    keyRecommendCardView.clickUbc(keyRecommendCardView.mPosition, KeyRecommendCardView.this.mRecommendKeyItemData, "button");
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
        if (!TextUtils.isEmpty(this.mRecommendKeyItemData.scheme)) {
            GameCenterUtils.requestAudioFocus(getContext());
            GameRouter.routerInvoke(getContext(), this.mRecommendKeyItemData.scheme);
        }
        GameCenterUtils.onClickEvent(this.mRecommendKeyItemData.scheme);
        clickUbc(this.mPosition, this.mRecommendKeyItemData, "card");
    }

    /* access modifiers changed from: private */
    public void clickUbc(int position, RecommendItemData itemData, String clickType) {
        if (position >= 0 && itemData != null) {
            HashMap<String, String> ext = new HashMap<>();
            ext.put(GameUBCConst.EXT_KEY_UPDATE_DAY, itemData.startTime);
            ext.put("id", itemData.id);
            ext.put("location", String.valueOf(position + 1));
            ext.put("click_type", clickType);
            ext.put(GameUBCConst.EXT_KEY_GAME_TYPE, itemData.type);
            GameCenterUBCUtil.gameEvent(GameUBCConst.SHOW_CLICK_ID, "click", "game", GameUBCConst.PAGE_RECOMMEND_PAGE, (Map<String, String>) ext);
        }
    }

    public void onUnselected() {
        GameCenterLottieView gameCenterLottieView = this.mGameCoverLottie;
        if (gameCenterLottieView != null) {
            gameCenterLottieView.cancelAnimation();
        }
    }
}
