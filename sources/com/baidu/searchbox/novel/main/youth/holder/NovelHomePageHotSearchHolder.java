package com.baidu.searchbox.novel.main.youth.holder;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.utils.NovelInvokeUtils;
import com.baidu.searchbox.novel.main.youth.bean.NovelHomePageRecommendBaseData;
import com.baidu.searchbox.novel.main.youth.bean.NovelHomePageRecommendHotSearchData;
import com.baidu.searchbox.novel.main.youth.help.INovelOnLoadDataFinishListener;
import com.baidu.searchbox.novel.main.youth.manager.NovelHomePageRecommendTabManager;
import com.baidu.searchbox.novel.stat.ubc.NovelChannelIdManager;
import com.baidu.searchbox.novel.stat.ubc.NovelCustomUbc;
import com.baidu.searchbox.novel.stat.ubc.NovelUbcStatUtils;
import com.baidu.searchbox.novel.view.NovelCommonRowScrollView;
import com.baidu.searchbox.novel.view.NovelCommonTextTitleItemViewOne;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeUtils;
import java.util.List;

public class NovelHomePageHotSearchHolder extends NovelHomePageBaseHolder<NovelHomePageRecommendBaseData> {
    /* access modifiers changed from: private */
    public NovelHomePageRecommendHotSearchData dataList;
    private final View mBackgroundViewBottom;
    /* access modifiers changed from: private */
    public final NovelCommonRowScrollView mScrollView;
    private final NovelCommonTextTitleItemViewOne mTitleView;

    public static View getView(Context context) {
        return View.inflate(context, R.layout.novel_home_page_recommend_hot_search, (ViewGroup) null);
    }

    public NovelHomePageHotSearchHolder(NovelHomePageRecommendTabManager manager, View itemView) {
        super(manager, itemView);
        this.mScrollView = (NovelCommonRowScrollView) itemView.findViewById(R.id.scroll_view);
        this.mTitleView = (NovelCommonTextTitleItemViewOne) itemView.findViewById(R.id.title_view);
        this.mBackgroundViewBottom = itemView.findViewById(R.id.background_view);
    }

    public void bindData(NovelHomePageRecommendBaseData data) {
        if (data instanceof NovelHomePageRecommendHotSearchData) {
            this.dataList = (NovelHomePageRecommendHotSearchData) data;
        }
        NovelHomePageRecommendHotSearchData novelHomePageRecommendHotSearchData = this.dataList;
        if (novelHomePageRecommendHotSearchData != null && novelHomePageRecommendHotSearchData.getDataList() != null) {
            View view2 = this.mBackgroundViewBottom;
            if (view2 != null) {
                view2.setBackground(NovelNightModeUtils.getDrawable(R.drawable.novel_home_page_recommend_item_bg));
            }
            NovelCommonTextTitleItemViewOne novelCommonTextTitleItemViewOne = this.mTitleView;
            if (novelCommonTextTitleItemViewOne != null) {
                novelCommonTextTitleItemViewOne.setTitle(this.dataList.getModuleName());
                this.mTitleView.setMoreText("换一换");
                this.mTitleView.onNightModeChanged();
                this.mTitleView.fontSizeChanged();
                this.mTitleView.setMoreImage(NovelNightModeUtils.getDrawable(R.drawable.novel_home_page_recommend_item_refresh_refresh));
                this.mTitleView.setOnClickListener(new NovelCommonTextTitleItemViewOne.OnTitleItemClickListener() {
                    public void onMoreClick(int type) {
                        if (NovelHomePageHotSearchHolder.this.mManager != null) {
                            NovelHomePageHotSearchHolder.this.mManager.refreshHotSearchText(new INovelOnLoadDataFinishListener<NovelHomePageRecommendHotSearchData>() {
                                public void onLoadFailed() {
                                }

                                public void onLoadSuccess(NovelHomePageRecommendHotSearchData newData) {
                                    if (NovelHomePageHotSearchHolder.this.dataList != null && newData != null) {
                                        List<List<NovelCommonRowScrollView.ItemData>> list = NovelHomePageHotSearchHolder.this.dataList.getDataList();
                                        List<List<NovelCommonRowScrollView.ItemData>> newList = newData.getDataList();
                                        if (list != null && newList != null) {
                                            list.clear();
                                            list.addAll(newList);
                                            if (NovelHomePageHotSearchHolder.this.mScrollView != null) {
                                                NovelHomePageHotSearchHolder.this.mScrollView.post(new Runnable() {
                                                    public void run() {
                                                        NovelHomePageHotSearchHolder.this.mScrollView.setData(NovelHomePageHotSearchHolder.this.dataList.getDataList());
                                                        NovelHomePageHotSearchHolder.this.mScrollView.scrollTo(0, 0);
                                                    }
                                                });
                                                NovelHomePageHotSearchHolder.this.ubcShow();
                                            }
                                        }
                                    }
                                }
                            });
                            NovelUbcStatUtils.ubc5958("novel", "click", "select", "change", "");
                        }
                    }
                });
            }
            NovelCommonRowScrollView novelCommonRowScrollView = this.mScrollView;
            if (novelCommonRowScrollView != null) {
                novelCommonRowScrollView.setData(this.dataList.getDataList());
                this.mScrollView.setOnItemClickListener(new NovelCommonRowScrollView.OnItemClickListener() {
                    public void onItemClick(NovelCommonRowScrollView.ItemData data) {
                        if (data != null) {
                            NovelInvokeUtils.invoke(data.cmd);
                            ArrayMap arrayMap = new ArrayMap();
                            arrayMap.put("hot_search", data.text);
                            NovelUbcStatUtils.ubc5958WithChannelId("novel", "click", "select", NovelCustomUbc.Source.SOURCE_NOVEL_HOME_PAGE_WHOLE_SEARCH, "", arrayMap, NovelChannelIdManager.CHANNEL_ID_VALUE_HOME_PAGE_JINGXUAN);
                        }
                    }
                });
            }
        }
    }

    public void ubcShow() {
        ubcShow("change");
        ubcShow(NovelCustomUbc.Source.SOURCE_NOVEL_HOME_PAGE_WHOLE_SEARCH);
    }

    private void ubcShow(String source) {
        if (isTabShow()) {
            NovelUbcStatUtils.ubc5958("novel", "show", "select", source, "");
        }
    }
}
