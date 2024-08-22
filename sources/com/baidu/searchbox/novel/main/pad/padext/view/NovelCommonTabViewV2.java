package com.baidu.searchbox.novel.main.pad.padext.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.searchbox.novel.main.pad.bean.NovelHomePageRecommendRankingData;
import java.util.List;

public class NovelCommonTabViewV2 extends LinearLayout implements View.OnClickListener {
    private static final int DEFAULT_TAB_COUNT = 4;
    private List<NovelHomePageRecommendRankingData.RankingTabData> dataList;
    private OnTabSelectChangedListener mChangeListener;

    public interface OnTabSelectChangedListener {
        void onTabSelectChange(int i2);
    }

    public NovelCommonTabViewV2(Context context) {
        super(context);
        initView();
    }

    public NovelCommonTabViewV2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public NovelCommonTabViewV2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public NovelCommonTabViewV2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        setOrientation(0);
        int index = 0;
        while (index < 4) {
            addTabView(index, index == 3);
            index++;
        }
    }

    public void setData(List<NovelHomePageRecommendRankingData.RankingTabData> dataList2, int selectTab) {
        if (dataList2 != null) {
            this.dataList = dataList2;
            int size = dataList2.size();
            int childCount = getChildCount();
            if (size < childCount) {
                int removeCount = childCount - size;
                for (int index = 0; index < removeCount; index++) {
                    removeViewAt(0);
                }
            } else if (size > childCount) {
                int addCount = size - childCount;
                for (int index2 = 0; index2 < addCount; index2++) {
                    addTabView(0, false);
                }
            }
            int index3 = 0;
            while (index3 < size) {
                View itemView = getChildAt(index3);
                if ((itemView instanceof NovelCommonTabItemView) && index3 < dataList2.size()) {
                    changeSelectTabBg(itemView, dataList2.get(index3), index3 == selectTab, selectTab, true);
                    ((NovelCommonTabItemView) itemView).fontSizeChanged();
                }
                index3++;
            }
        }
    }

    private void addTabView(int index, boolean isEnd) {
        NovelCommonTabItemView itemView = new NovelCommonTabItemView(getContext());
        itemView.setGravity(17);
        itemView.setOnClickListener(this);
        itemView.setSelected(false);
        addView(itemView, index);
    }

    public void setOnTabSelectChangedListener(OnTabSelectChangedListener listener) {
        this.mChangeListener = listener;
    }

    public void onClick(View v) {
        int size = getChildCount();
        for (int index = 0; index < size; index++) {
            View itemView = getChildAt(index);
            List<NovelHomePageRecommendRankingData.RankingTabData> list = this.dataList;
            if (list != null && !list.isEmpty() && this.dataList.size() > index) {
                changeSelectTabBg(itemView, this.dataList.get(index), v == itemView, index, false);
            }
        }
    }

    private void changeSelectTabBg(View view2, NovelHomePageRecommendRankingData.RankingTabData data, boolean isSelected, int selectId, boolean forceUpdate) {
        if (view2 instanceof NovelCommonTabItemView) {
            NovelCommonTabItemView tab = (NovelCommonTabItemView) view2;
            if (isSelected) {
                boolean isChanged = !tab.isSelected();
                if (isChanged || forceUpdate) {
                    tab.setSelected(true);
                    tab.updateView(data, true);
                    OnTabSelectChangedListener onTabSelectChangedListener = this.mChangeListener;
                    if (onTabSelectChangedListener != null && isChanged) {
                        onTabSelectChangedListener.onTabSelectChange(selectId);
                    }
                }
            } else if (tab.isSelected() || forceUpdate) {
                tab.setSelected(false);
                tab.updateView(data, false);
            }
        }
    }
}
