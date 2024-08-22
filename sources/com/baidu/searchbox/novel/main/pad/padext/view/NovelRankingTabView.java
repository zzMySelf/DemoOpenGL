package com.baidu.searchbox.novel.main.pad.padext.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.pad.bean.NovelHomePageRecommendRankingData;
import com.baidu.searchbox.novel.main.pad.padext.view.NovelCommonTabViewV2;
import com.baidu.searchbox.noveladapter.settingcore.NovelFontSizeSettingsWrapper;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeUtils;
import java.util.List;

public class NovelRankingTabView extends RelativeLayout {
    /* access modifiers changed from: private */
    public RankingClickListener listener;
    private View mMaskView;
    private TextView mMoreView;
    private RelativeLayout mRootLayout;
    private NovelCommonTabViewV2 mTabView;

    public interface RankingClickListener {
        void onMoreClick();

        void onTabSelectChange(int i2);
    }

    public NovelRankingTabView(Context context) {
        super(context);
        initView(context);
    }

    public NovelRankingTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public NovelRankingTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public NovelRankingTabView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.novel_home_page_ranking_tab_view_pad, this);
        this.mRootLayout = (RelativeLayout) findViewById(R.id.rl_root_layout);
        this.mMoreView = (TextView) findViewById(R.id.moreTv);
        this.mTabView = (NovelCommonTabViewV2) findViewById(R.id.tabView);
        this.mMaskView = findViewById(R.id.mask_view);
        TextView textView = this.mMoreView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    if (NovelRankingTabView.this.listener != null) {
                        NovelRankingTabView.this.listener.onMoreClick();
                    }
                }
            });
        }
    }

    public void setTabData(List<NovelHomePageRecommendRankingData.RankingTabData> dataList, int selectTab) {
        NovelCommonTabViewV2 novelCommonTabViewV2 = this.mTabView;
        if (novelCommonTabViewV2 != null) {
            novelCommonTabViewV2.setData(dataList, selectTab);
        }
    }

    public void setRankingTabListener(final RankingClickListener listener2) {
        this.listener = listener2;
        NovelCommonTabViewV2 novelCommonTabViewV2 = this.mTabView;
        if (novelCommonTabViewV2 != null) {
            novelCommonTabViewV2.setOnTabSelectChangedListener(new NovelCommonTabViewV2.OnTabSelectChangedListener() {
                public void onTabSelectChange(int id) {
                    RankingClickListener rankingClickListener = listener2;
                    if (rankingClickListener != null) {
                        rankingClickListener.onTabSelectChange(id);
                    }
                }
            });
        }
    }

    public void onNightModeChanged() {
        TextView textView = this.mMoreView;
        if (textView != null) {
            textView.setTextColor(NovelNightModeUtils.getColor(R.color.NC504));
            this.mMoreView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, NovelNightModeUtils.getDrawable(R.drawable.novel_home_page_recommend_item_more_icon), (Drawable) null);
        }
        View view2 = this.mMaskView;
        if (view2 != null) {
            view2.setBackground(NovelNightModeUtils.getDrawable(R.drawable.novel_comment_rank_tag_recycler_end_bg));
        }
    }

    public void fontSizeChanged() {
        TextView textView = this.mMoreView;
        if (textView != null) {
            NovelFontSizeSettingsWrapper.setTextViewScaledSize(textView, 12.0f);
        }
    }
}
