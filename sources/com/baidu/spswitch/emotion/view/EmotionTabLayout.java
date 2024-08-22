package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.spswitch.R;
import com.baidu.spswitch.emotion.bean.EmotionTypeModel;
import com.baidu.spswitch.utils.EmotionPanelConfig;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmotionTabLayout extends HorizontalScrollView {
    private static final String DEFAULT_TAB_ID = "emoji";
    public static final String FAVOR_TAB_ID = "favorite";
    public static final String GIF_TAB_ID = "gif";
    private static String sSelectedTabId = "";
    private int currentItem;
    private LinearLayout linearLayout;
    private ViewPager.OnPageChangeListener mInnerListener;
    private int mItemHeight;
    private int mItemWidth;
    /* access modifiers changed from: private */
    public ViewPager.OnPageChangeListener mListener;
    protected EmotionPanelConfig mPanelConfig;
    /* access modifiers changed from: private */
    public List<String> mTabIdList;
    /* access modifiers changed from: private */
    public ViewPager viewPager;

    public EmotionTabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public EmotionTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmotionTabLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.currentItem = 0;
        this.mTabIdList = new ArrayList();
        initView(context);
    }

    public void setPanelConfig(EmotionPanelConfig panelConfig) {
        this.mPanelConfig = panelConfig;
    }

    private void initView(Context context) {
        this.linearLayout = new LinearLayout(context);
        int height = getResources().getDimensionPixelSize(R.dimen.emotion_tab_layout_height);
        int paddingLeft = getResources().getDimensionPixelSize(R.dimen.expression_left_right_margin);
        this.mItemWidth = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_width);
        this.mItemHeight = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_height);
        this.linearLayout.setPadding(paddingLeft, 0, 0, 0);
        addView(this.linearLayout, new ViewGroup.LayoutParams(-1, height));
        addSubTab("emoji", R.drawable.face_bottom, true);
    }

    public SimpleDraweeView addSubTab(final String tabId, int iconResId, boolean toFirstPos) {
        List<String> list;
        SimpleDraweeView tabItem = createItem();
        tabItem.setImageResource(iconResId);
        LinearLayout linearLayout2 = this.linearLayout;
        if (!(linearLayout2 == null || (list = this.mTabIdList) == null)) {
            if (toFirstPos) {
                linearLayout2.addView(tabItem, 0, getItemParams());
                this.mTabIdList.add(0, tabId);
            } else {
                list.add(tabId);
                this.linearLayout.addView(tabItem, getItemParams());
            }
        }
        tabItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (EmotionTabLayout.this.viewPager != null && EmotionTabLayout.this.mTabIdList != null && !TextUtils.isEmpty(tabId)) {
                    int pos = EmotionTabLayout.this.mTabIdList.indexOf(tabId);
                    EmotionTabLayout.this.viewPager.setCurrentItem(pos);
                    EmotionTabLayout.this.ubcReport(pos, "tab_clk");
                }
            }
        });
        return tabItem;
    }

    public void setViewPager(ViewPager viewPager2) {
        this.viewPager = viewPager2;
    }

    public void addData(Map<String, EmotionTypeModel> map) {
        if (!map.isEmpty()) {
            final int pos = this.linearLayout.getChildCount();
            for (EmotionTypeModel model : map.values()) {
                SimpleDraweeView simpleDraweeView = createItem();
                simpleDraweeView.setImageURI(model.getIcon());
                this.linearLayout.addView(simpleDraweeView, getItemParams());
                simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        EmotionTabLayout.this.viewPager.setCurrentItem(pos);
                        EmotionTabLayout.this.ubcReport(pos, "tab_clk");
                    }
                });
                this.mTabIdList.add(model.getId());
                pos++;
            }
        }
    }

    /* access modifiers changed from: private */
    public void ubcReport(int pos, String type) {
        EmotionPanelConfig emotionPanelConfig;
        if (pos < this.mTabIdList.size() && (emotionPanelConfig = this.mPanelConfig) != null) {
            EmotionUbcHelper.doEmotionDynamicUBC(emotionPanelConfig.from, type, this.mPanelConfig.page, this.mPanelConfig.source, this.mTabIdList.get(pos), "");
        }
    }

    public void changeTabByTabId(String tabId) {
        int itemTabIndex = Math.max(this.mTabIdList.indexOf(tabId), 0);
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            if (itemTabIndex == viewPager2.getCurrentItem()) {
                setCurrentItem(itemTabIndex);
            }
            this.viewPager.setCurrentItem(itemTabIndex);
        }
    }

    private SimpleDraweeView createItem() {
        int paddingLeft = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_padding_left);
        int paddingTop = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_padding_top);
        int radius = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_radius);
        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources()).setRoundingParams(RoundingParams.fromCornersRadii((float) radius, (float) radius, (float) radius, (float) radius)).setPlaceholderImage(R.drawable.emotion_preview_placeholder).build();
        SimpleDraweeView draweeView = new SimpleDraweeView(getContext());
        draweeView.setPadding(paddingLeft, paddingTop, paddingLeft, paddingTop);
        draweeView.setHierarchy(hierarchy);
        return draweeView;
    }

    private LinearLayout.LayoutParams getItemParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        params.rightMargin = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_margin_left);
        params.bottomMargin = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_margin_bottom);
        return params;
    }

    /* access modifiers changed from: private */
    public void setCurrentItem(int pos) {
        this.linearLayout.getChildAt(this.currentItem).setBackground((Drawable) null);
        this.currentItem = pos;
        scrollToCenter(pos);
        this.linearLayout.getChildAt(pos).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.emotion_tab_tyep_selected_bg));
        if (pos < this.mTabIdList.size()) {
            sSelectedTabId = this.mTabIdList.get(pos);
        }
        ubcReport(pos, "tab_show");
    }

    private void scrollToCenter(final int position) {
        UiThreadUtils.getMainHandler().post(new Runnable() {
            public void run() {
                View view2 = EmotionTabLayout.this.getItemViewByPos(position);
                if (view2 != null) {
                    EmotionTabLayout.this.smoothScrollTo((view2.getLeft() - (EmotionTabLayout.this.getMeasuredWidth() / 2)) + (view2.getWidth() / 2), 0);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public View getItemViewByPos(int position) {
        return this.linearLayout.getChildAt(position);
    }

    public void setListener(ViewPager.OnPageChangeListener listener) {
        this.mListener = listener;
    }

    public ViewPager.OnPageChangeListener getListener() {
        if (this.mInnerListener == null) {
            this.mInnerListener = new ViewPager.OnPageChangeListener() {
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if (EmotionTabLayout.this.mListener != null) {
                        EmotionTabLayout.this.mListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                }

                public void onPageSelected(int position) {
                    EmotionTabLayout.this.setCurrentItem(position);
                    if (EmotionTabLayout.this.mListener != null) {
                        EmotionTabLayout.this.mListener.onPageSelected(position);
                    }
                }

                public void onPageScrollStateChanged(int state) {
                    if (EmotionTabLayout.this.mListener != null) {
                        EmotionTabLayout.this.mListener.onPageScrollStateChanged(state);
                    }
                }
            };
        }
        return this.mInnerListener;
    }

    public String getSelectedTabId() {
        return sSelectedTabId;
    }

    public static void setSelectedTabId(String tabId) {
        sSelectedTabId = tabId;
    }
}
