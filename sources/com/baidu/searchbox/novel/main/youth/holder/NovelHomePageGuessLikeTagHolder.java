package com.baidu.searchbox.novel.main.youth.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.utils.NovelInvokeUtils;
import com.baidu.searchbox.novel.main.utils.NovelSelectedBookStatUtils;
import com.baidu.searchbox.novel.main.youth.bean.NovelHomePageRecommendBaseData;
import com.baidu.searchbox.novel.main.youth.bean.NovelHomePageRecommendGuessLikeData;
import com.baidu.searchbox.novel.main.youth.manager.NovelHomePageRecommendTabManager;
import com.baidu.searchbox.novel.stat.ubc.NovelCustomUbc;
import com.baidu.searchbox.novel.stat.ubc.NovelUbcStatUtils;
import com.baidu.searchbox.novel.view.NovelCommonLeftImageRightTextViewTwoYouth;
import com.baidu.searchbox.novel.view.NovelCommonTextTitleItemViewOneYouth;
import com.baidu.searchbox.novel.view.cardview.RelativeCardView;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeUtils;

public class NovelHomePageGuessLikeTagHolder extends NovelHomePageBaseHolder<NovelHomePageRecommendBaseData> {
    private final View mContentView;
    private final NovelCommonLeftImageRightTextViewTwoYouth mItemView;
    private RelativeCardView mTitleCardView;
    private final NovelCommonTextTitleItemViewOneYouth mTitleView;

    public static View getView(Context context) {
        return View.inflate(context, R.layout.novel_home_page_recommend_guess_like_tag_youth, (ViewGroup) null);
    }

    public NovelHomePageGuessLikeTagHolder(NovelHomePageRecommendTabManager manager, View itemView) {
        super(manager, itemView);
        this.mTitleView = (NovelCommonTextTitleItemViewOneYouth) itemView.findViewById(R.id.title_view);
        this.mItemView = (NovelCommonLeftImageRightTextViewTwoYouth) itemView.findViewById(R.id.item_view);
        this.mContentView = itemView.findViewById(R.id.content_view);
        this.mTitleCardView = (RelativeCardView) itemView.findViewById(R.id.card_View);
    }

    public void bindData(NovelHomePageRecommendBaseData data) {
        int bgResource;
        if (data instanceof NovelHomePageRecommendGuessLikeData) {
            final NovelHomePageRecommendGuessLikeData likeData = (NovelHomePageRecommendGuessLikeData) data;
            boolean hasTitle = true;
            if (this.mContentView != null) {
                int topMargin = 0;
                int bottomMargin = 0;
                int contentPaddingTop = 21;
                switch (likeData.getPositionType()) {
                    case 0:
                        bgResource = R.drawable.novel_home_page_recommend_item_bg_top;
                        topMargin = 12;
                        contentPaddingTop = 0;
                        break;
                    case 1:
                        bgResource = R.drawable.novel_home_page_recommend_item_bg_middle;
                        hasTitle = false;
                        break;
                    case 2:
                        bgResource = R.drawable.novel_home_page_recommend_item_bg_bottom;
                        hasTitle = false;
                        bottomMargin = 12;
                        break;
                    case 3:
                        bgResource = R.drawable.novel_home_page_recommend_item_bg;
                        topMargin = 12;
                        bottomMargin = 12;
                        break;
                    default:
                        bgResource = R.drawable.novel_home_page_recommend_item_bg;
                        break;
                }
                ViewGroup.LayoutParams layoutParams = this.mContentView.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).topMargin = topMargin;
                    ((FrameLayout.LayoutParams) layoutParams).bottomMargin = bottomMargin;
                    this.mContentView.setLayoutParams(layoutParams);
                }
                View view2 = this.mContentView;
                view2.setPadding(view2.getPaddingLeft(), contentPaddingTop, this.mContentView.getPaddingRight(), this.mContentView.getPaddingBottom());
                this.mContentView.setBackground(NovelNightModeUtils.getDrawable(bgResource));
            }
            NovelCommonTextTitleItemViewOneYouth novelCommonTextTitleItemViewOneYouth = this.mTitleView;
            if (novelCommonTextTitleItemViewOneYouth != null) {
                if (hasTitle) {
                    novelCommonTextTitleItemViewOneYouth.setTitleImageUrl(likeData.getImageDay(), likeData.getImageNight());
                    this.mTitleView.setTitle(likeData.getModuleName());
                    this.mTitleView.hideMoreIcon();
                    this.mTitleView.setVisibility(0);
                    this.mTitleView.onNightModeChanged();
                    this.mTitleView.fontSizeChanged();
                } else {
                    novelCommonTextTitleItemViewOneYouth.setVisibility(8);
                }
            }
            RelativeCardView relativeCardView = this.mTitleCardView;
            if (relativeCardView != null) {
                if (hasTitle) {
                    relativeCardView.setVisibility(0);
                    this.mTitleCardView.setCardBackgroundColor(NovelNightModeUtils.getColor(com.baidu.android.common.ui.style.R.color.GC85));
                } else {
                    relativeCardView.setVisibility(8);
                }
            }
            this.mItemView.bindData(likeData);
            this.mItemView.fontSizeChanged();
            this.mItemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    NovelHomePageRecommendGuessLikeData novelHomePageRecommendGuessLikeData = likeData;
                    if (novelHomePageRecommendGuessLikeData != null) {
                        NovelInvokeUtils.invoke(novelHomePageRecommendGuessLikeData.getCmd());
                        NovelHomePageGuessLikeTagHolder.this.ubcClick(likeData.getModuleName(), likeData.getBookId(), likeData.getFirstLineText());
                    }
                }
            });
        }
    }

    public void ubcShow() {
        NovelCommonTextTitleItemViewOneYouth novelCommonTextTitleItemViewOneYouth;
        if (isTabShow() && (novelCommonTextTitleItemViewOneYouth = this.mTitleView) != null && novelCommonTextTitleItemViewOneYouth.getVisibility() == 0) {
            NovelUbcStatUtils.ubc5958("novel", "show", "select", NovelCustomUbc.Source.SOURCE_NOVEL_HOME_PAGE_GUESS_LIKE, "");
        }
    }

    /* access modifiers changed from: private */
    public void ubcClick(String moduleName, String bookId, String title) {
        NovelUbcStatUtils.ubc5958("novel", "click", "select", NovelCustomUbc.Source.SOURCE_NOVEL_HOME_PAGE_GUESS_LIKE, bookId);
        NovelSelectedBookStatUtils.ubc5958GuessLikeClick(moduleName, bookId, title, getAdapterPosition());
    }
}
