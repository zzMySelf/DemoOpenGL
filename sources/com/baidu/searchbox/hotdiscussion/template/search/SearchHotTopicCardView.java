package com.baidu.searchbox.hotdiscussion.template.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.template.statistic.ITemplateStatistics;
import com.baidu.searchbox.feed.template.statistic.TemplateStatisticsTable;
import com.baidu.searchbox.generalcommunity.context.GCommunityRuntime;
import com.baidu.searchbox.generalcommunity.data.GCommunityRepository;
import com.baidu.searchbox.generalcommunity.ui.HotThickDividerPolicy;
import com.baidu.searchbox.generalcommunity.utils.InjectorUtils;
import com.baidu.searchbox.generalcommunity.utils.UiUtils;
import com.baidu.searchbox.hotdiscussion.template.R;
import com.baidu.searchbox.hotdiscussion.template.search.SearchHotTopicCardData;
import com.baidu.searchbox.hotdiscussion.template.search.SearchHotTopicItemView;
import com.baidu.searchbox.hotdiscussion.ubc.TCStatisticHelper;
import com.baidu.searchbox.hotdiscussion.view.parentview.HotDiscussionConstraintLayout;
import com.baidu.searchbox.ui.TouchStateListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J \u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001aH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001eH\u0002J\u0012\u0010)\u001a\u00020\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u001aH\u0016J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0014H\u0016J(\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010\u00112\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u000204\u0018\u000103H\u0016J\b\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u001aH\u0002J\b\u00107\u001a\u00020\u001aH\u0002J\b\u00108\u001a\u00020\u001aH\u0002J\b\u00109\u001a\u00020\u001aH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/hotdiscussion/template/search/SearchHotTopicCardView;", "Lcom/baidu/searchbox/hotdiscussion/view/parentview/HotDiscussionConstraintLayout;", "Landroid/view/View$OnClickListener;", "Lcom/baidu/searchbox/hotdiscussion/template/search/SearchHotTopicItemView$OnClickCardItemListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "brandTv", "Landroid/widget/TextView;", "cardContext", "cardData", "Lcom/baidu/searchbox/hotdiscussion/template/search/SearchHotTopicCardData;", "changeDataList", "Ljava/util/LinkedList;", "Lcom/baidu/searchbox/hotdiscussion/template/search/SearchHotTopicCardData$TopicItemData;", "changeView", "feedBaseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "headerTv", "mBusiness", "", "mItemViewList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/hotdiscussion/template/search/SearchHotTopicItemView;", "Lkotlin/collections/ArrayList;", "addClickUbc", "", "clickType", "adjustItemConstraintSet", "index", "", "itemId", "baseId", "applyFeedNightMode", "getFeedDividerPolicy", "Lcom/baidu/searchbox/feed/base/FeedTemplate$FeedDividerPolicy;", "getItemView", "itemDataSearch", "initChangeDataList", "initChangeView", "lastItemId", "initView", "onClick", "v", "Landroid/view/View;", "onItemClick", "setChannelId", "business", "update", "feedModel", "options", "", "", "updateContentLayout", "updateDbData", "updateHeaderView", "updateOriginDataList", "updateView", "lib-hotdiscussion-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchHotTopicCardView.kt */
public final class SearchHotTopicCardView extends HotDiscussionConstraintLayout implements View.OnClickListener, SearchHotTopicItemView.OnClickCardItemListener {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private TextView brandTv;
    private Context cardContext;
    private SearchHotTopicCardData cardData;
    private LinkedList<SearchHotTopicCardData.TopicItemData> changeDataList;
    private TextView changeView;
    private FeedBaseModel feedBaseModel;
    private TextView headerTv;
    private String mBusiness;
    private ArrayList<SearchHotTopicItemView> mItemViewList;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public SearchHotTopicCardView(Context context) {
        super(context);
        this.mItemViewList = new ArrayList<>();
        this.changeDataList = new LinkedList<>();
        initView(context);
    }

    private final void initView(Context context) {
        this.cardContext = context;
        LayoutInflater.from(context).inflate(R.layout.search_hot_topic_card_view, this);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        this.headerTv = (TextView) findViewById(R.id.search_reyi_topic_card_header_title);
        this.brandTv = (TextView) findViewById(R.id.search_reyi_topic_card_header_brand);
        TextView textView = (TextView) findViewById(R.id.search_reyi_topic_card_change);
        this.changeView = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.changeView;
        if (textView2 != null) {
            textView2.setOnTouchListener(new TouchStateListener());
        }
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        super.update(feedModel, options);
        if (feedModel != null && feedModel.data != null) {
            this.feedBaseModel = feedModel;
            FeedItemData feedItemData = feedModel.data;
            if (feedItemData != null) {
                this.cardData = (SearchHotTopicCardData) feedItemData;
                updateHeaderView();
                updateContentLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.hotdiscussion.template.search.SearchHotTopicCardData");
        }
    }

    private final void updateHeaderView() {
        SearchHotTopicCardData searchHotTopicCardData = this.cardData;
        Intrinsics.checkNotNull(searchHotTopicCardData);
        if (TextUtils.isEmpty(searchHotTopicCardData.getHeaderTitle())) {
            TextView textView = this.headerTv;
            if (textView != null) {
                SearchHotTopicCardData searchHotTopicCardData2 = this.cardData;
                Intrinsics.checkNotNull(searchHotTopicCardData2);
                textView.setText(searchHotTopicCardData2.getHeaderTitle());
            }
        } else {
            TextView textView2 = this.headerTv;
            if (textView2 != null) {
                textView2.setText(getResources().getString(R.string.search_hot_topic_card_header_title));
            }
        }
        SearchHotTopicCardData searchHotTopicCardData3 = this.cardData;
        Intrinsics.checkNotNull(searchHotTopicCardData3);
        if (TextUtils.isEmpty(searchHotTopicCardData3.getHeaderBrand())) {
            TextView textView3 = this.brandTv;
            if (textView3 != null) {
                SearchHotTopicCardData searchHotTopicCardData4 = this.cardData;
                Intrinsics.checkNotNull(searchHotTopicCardData4);
                textView3.setText(searchHotTopicCardData4.getHeaderBrand());
                return;
            }
            return;
        }
        TextView textView4 = this.brandTv;
        if (textView4 != null) {
            textView4.setText(getResources().getString(R.string.search_hot_topic_card_header_brand));
        }
    }

    private final void updateContentLayout() {
        if (this.headerTv != null) {
            int baseId = HotDiscussionConstraintLayout.generateViewId();
            Iterator<SearchHotTopicItemView> it = this.mItemViewList.iterator();
            while (it.hasNext()) {
                removeView(it.next());
            }
            this.mItemViewList.clear();
            SearchHotTopicCardData it2 = this.cardData;
            if (it2 != null) {
                int i2 = 0;
                while (true) {
                    SearchHotTopicCardData.TopicItemData topicItemData = it2.getTopicDataList().get(i2);
                    Intrinsics.checkNotNullExpressionValue(topicItemData, "it.topicDataList.get(i)");
                    SearchHotTopicItemView itemView = getItemView(topicItemData);
                    int itemId = baseId + i2;
                    if (itemView != null) {
                        itemView.setId(itemId);
                    }
                    addView(itemView);
                    if (itemView != null) {
                        this.mItemViewList.add(itemView);
                    }
                    adjustItemConstraintSet(i2, itemId, baseId);
                    if ((i2 + 1) % 3 == 0) {
                        if (itemView != null) {
                            itemView.showItemDivider(8);
                        }
                    } else if (itemView != null) {
                        itemView.showItemDivider(0);
                    }
                    if (i2 != 2) {
                        i2++;
                    } else {
                        initChangeDataList();
                        initChangeView(baseId + 2);
                        return;
                    }
                }
            }
        }
    }

    private final void adjustItemConstraintSet(int index, int itemId, int baseId) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) this);
        if (index == 0) {
            TextView textView = this.headerTv;
            Intrinsics.checkNotNull(textView);
            constraintSet.connect(itemId, 3, textView.getId(), 4, UiUtils.getDimensionPixelSize(R.dimen.search_hot_topic_card_header_margin_top));
        } else {
            constraintSet.connect(itemId, 3, baseId + (index - 1), 4, 0);
        }
        constraintSet.applyTo(this);
    }

    private final void initChangeDataList() {
        if (this.cardData != null) {
            this.changeDataList.clear();
            SearchHotTopicCardData searchHotTopicCardData = this.cardData;
            Intrinsics.checkNotNull(searchHotTopicCardData);
            int size = searchHotTopicCardData.getTopicDataList().size();
            for (int i2 = 0; i2 < size; i2++) {
                LinkedList<SearchHotTopicCardData.TopicItemData> linkedList = this.changeDataList;
                SearchHotTopicCardData searchHotTopicCardData2 = this.cardData;
                Intrinsics.checkNotNull(searchHotTopicCardData2);
                linkedList.add(searchHotTopicCardData2.getTopicDataList().get(i2));
            }
            int i3 = 0;
            while (true) {
                LinkedList<SearchHotTopicCardData.TopicItemData> linkedList2 = this.changeDataList;
                linkedList2.addLast(linkedList2.removeFirst());
                if (i3 != 2) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getTopicDataList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initChangeView(int r6) {
        /*
            r5 = this;
            com.baidu.searchbox.hotdiscussion.template.search.SearchHotTopicCardData r0 = r5.cardData
            r1 = 0
            if (r0 == 0) goto L_0x0014
            java.util.LinkedList r0 = r0.getTopicDataList()
            if (r0 == 0) goto L_0x0014
            int r0 = r0.size()
            r2 = 3
            if (r0 != r2) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x0022
            android.widget.TextView r0 = r5.changeView
            if (r0 != 0) goto L_0x001c
            goto L_0x0060
        L_0x001c:
            r1 = 8
            r0.setVisibility(r1)
            goto L_0x0060
        L_0x0022:
            android.widget.TextView r0 = r5.changeView
            r2 = 0
            if (r0 == 0) goto L_0x002c
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x002d
        L_0x002c:
            r0 = r2
        L_0x002d:
            if (r0 == 0) goto L_0x0061
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r0 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r0
            r0.topToBottom = r6
            android.widget.TextView r3 = r5.changeView
            if (r3 != 0) goto L_0x0038
            goto L_0x003e
        L_0x0038:
            r4 = r0
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            r3.setLayoutParams(r4)
        L_0x003e:
            android.widget.TextView r3 = r5.changeView
            if (r3 != 0) goto L_0x0043
            goto L_0x0058
        L_0x0043:
            android.content.Context r4 = r5.cardContext
            if (r4 == 0) goto L_0x0053
            android.content.res.Resources r4 = r4.getResources()
            if (r4 == 0) goto L_0x0053
            int r2 = com.baidu.searchbox.hotdiscussion.template.R.string.search_hot_topic_card_change_text
            java.lang.String r2 = r4.getString(r2)
        L_0x0053:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
        L_0x0058:
            android.widget.TextView r2 = r5.changeView
            if (r2 != 0) goto L_0x005d
            goto L_0x0060
        L_0x005d:
            r2.setVisibility(r1)
        L_0x0060:
            return
        L_0x0061:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.hotdiscussion.template.search.SearchHotTopicCardView.initChangeView(int):void");
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        return new HotThickDividerPolicy();
    }

    private final SearchHotTopicItemView getItemView(SearchHotTopicCardData.TopicItemData itemDataSearch) {
        if (this.cardContext == null) {
            return null;
        }
        Context context = this.cardContext;
        Intrinsics.checkNotNull(context);
        SearchHotTopicItemView itemView = new SearchHotTopicItemView(context);
        itemView.updateView(itemDataSearch, this);
        return itemView;
    }

    public void applyFeedNightMode() {
        super.applyFeedNightMode();
        UiUtils.setTextColorResource(this.headerTv, com.baidu.android.common.ui.style.R.color.GC1);
        UiUtils.setTextColorResource(this.changeView, com.baidu.android.common.ui.style.R.color.GC7);
        UiUtils.setTextColorResource(this.brandTv, com.baidu.android.common.ui.style.R.color.GC4);
        TextView textView = this.headerTv;
        if (textView != null) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(GCommunityRuntime.getAppContext(), R.drawable.search_reyi_topic_card_header_img), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        TextView textView2 = this.changeView;
        if (textView2 != null) {
            textView2.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(GCommunityRuntime.getAppContext(), R.drawable.search_reyi_topic_card_refresh_img), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setChannelId(String business) {
        Intrinsics.checkNotNullParameter(business, "business");
        this.mBusiness = business;
    }

    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == R.id.search_reyi_topic_card_change) {
            updateView();
            addClickUbc(TCStatisticHelper.CHANGE_BUTTON);
        }
    }

    private final void updateView() {
        updateOriginDataList();
        int i2 = 0;
        int childCount = getChildCount();
        if (0 <= childCount) {
            while (true) {
                View itemView = getChildAt(i2);
                if (itemView instanceof SearchHotTopicItemView) {
                    SearchHotTopicCardData.TopicItemData itemData = this.changeDataList.getFirst();
                    if (itemData != null) {
                        ((SearchHotTopicItemView) itemView).updateView(itemData, this);
                        LinkedList<SearchHotTopicCardData.TopicItemData> linkedList = this.changeDataList;
                        linkedList.addLast(linkedList.remove());
                    } else {
                        return;
                    }
                }
                if (i2 == childCount) {
                    break;
                }
                i2++;
            }
        }
        updateDbData();
    }

    private final void updateOriginDataList() {
        LinkedList<SearchHotTopicCardData.TopicItemData> topicDataList;
        LinkedList<SearchHotTopicCardData.TopicItemData> topicDataList2;
        SearchHotTopicCardData searchHotTopicCardData = this.cardData;
        if (!(searchHotTopicCardData == null || (topicDataList2 = searchHotTopicCardData.getTopicDataList()) == null)) {
            topicDataList2.clear();
        }
        int size = this.changeDataList.size();
        for (int i2 = 0; i2 < size; i2++) {
            SearchHotTopicCardData searchHotTopicCardData2 = this.cardData;
            if (!(searchHotTopicCardData2 == null || (topicDataList = searchHotTopicCardData2.getTopicDataList()) == null)) {
                topicDataList.add(this.changeDataList.get(i2));
            }
        }
    }

    private final void updateDbData() {
        GCommunityRepository repository = InjectorUtils.provideRepository(GCommunityRuntime.getAppContext(), "hot_spot");
        if (repository != null) {
            FeedBaseModel feedBaseModel2 = this.feedBaseModel;
            repository.updateItemByFeedIdInDb(feedBaseModel2 != null ? feedBaseModel2.id : null, this.feedBaseModel);
        }
    }

    public void onItemClick() {
        addClickUbc(TCStatisticHelper.TOPIC_ITEM);
    }

    private final void addClickUbc(String clickType) {
        ITemplateStatistics templateStatistics = TemplateStatisticsTable.getInstance().get(this.mBusiness);
        if (templateStatistics != null) {
            SearchHotTopicCardData searchHotTopicCardData = this.cardData;
            templateStatistics.clickInteractCardStatistics(clickType, "", searchHotTopicCardData != null ? searchHotTopicCardData.hotSearchInfo : null);
        }
    }
}
