package com.baidu.browser.tablayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.browser.R;
import com.baidu.browser.explore.tab.na.tag.data.SearchTagItem;
import com.baidu.browser.tablayout.data.FilterSearchTabItem;
import com.baidu.browser.tablayout.data.FilterSortTabItem;
import com.baidu.browser.tablayout.data.MoreNormalItem;
import com.baidu.browser.tablayout.data.MoreSearchTabItem;
import com.baidu.browser.tablayout.data.MoreSearchTagItem;
import com.baidu.browser.tablayout.data.MoreTitleItem;
import com.baidu.search.basic.utils.ResultPageABTest;
import com.baidu.search.model.GroupCardDefaultConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.favor.data.FavorModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\u0007H\u0016J\u0010\u0010G\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016J\u0018\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0007H\u0016J\u0018\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0007H\u0017J9\u0010N\u001a\u0002042\b\u0010I\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010S\u001a\u00020\u0010¢\u0006\u0002\u0010TR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u001a\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\"\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-RL\u0010.\u001a4\u0012\u0013\u0012\u00110)¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0004\u0012\u000204\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u000b¨\u0006U"}, d2 = {"Lcom/baidu/browser/tablayout/TabMoreAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemBgNormalColor", "", "getItemBgNormalColor", "()I", "setItemBgNormalColor", "(I)V", "itemBgPressColor", "getItemBgPressColor", "setItemBgPressColor", "itemIconAlpha", "", "getItemIconAlpha", "()F", "setItemIconAlpha", "(F)V", "itemSelectedBgColor", "getItemSelectedBgColor", "()Ljava/lang/Integer;", "setItemSelectedBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "itemSelectedStrokeColor", "getItemSelectedStrokeColor", "setItemSelectedStrokeColor", "itemStrokeColor", "getItemStrokeColor", "setItemStrokeColor", "itemTitleColor", "getItemTitleColor", "setItemTitleColor", "itemTxtColor", "getItemTxtColor", "setItemTxtColor", "morelist", "", "Lcom/baidu/browser/tablayout/data/MoreNormalItem;", "getMorelist", "()Ljava/util/List;", "setMorelist", "(Ljava/util/List;)V", "onItemClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "position", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "selectedPd", "", "getSelectedPd", "()Ljava/lang/String;", "setSelectedPd", "(Ljava/lang/String;)V", "selectedTxtColor", "getSelectedTxtColor", "setSelectedTxtColor", "createBgDrawable", "Landroid/graphics/drawable/Drawable;", "isSelected", "", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showTagIcon", "Lcom/baidu/browser/tablayout/MoreTagItemViewHolder;", "searchTagItem", "Lcom/baidu/browser/tablayout/data/MoreSearchTagItem;", "tagColor", "alpha", "(Lcom/baidu/browser/tablayout/MoreTagItemViewHolder;Lcom/baidu/browser/tablayout/data/MoreSearchTagItem;Landroid/content/Context;Ljava/lang/Integer;F)V", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabMoreAdapter.kt */
public final class TabMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private int itemBgNormalColor;
    private int itemBgPressColor;
    private float itemIconAlpha;
    private Integer itemSelectedBgColor;
    private Integer itemSelectedStrokeColor;
    private Integer itemStrokeColor;
    private int itemTitleColor;
    private int itemTxtColor;
    private List<? extends MoreNormalItem> morelist;
    private Function2<? super MoreNormalItem, ? super Integer, Unit> onItemClick;
    private String selectedPd;
    private int selectedTxtColor;

    public TabMoreAdapter(Context context2) {
        int i2;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.itemTitleColor = ContextCompat.getColor(context2, GroupCardDefaultConfig.INSTANCE.getFilterTitleColorId());
        if (ResultPageABTest.isResultPageNewStyle()) {
            i2 = ContextCompat.getColor(context2, GroupCardDefaultConfig.INSTANCE.getFilterTextDefaultColorId());
        } else {
            i2 = ContextCompat.getColor(context2, R.color.more_item_text_dark_bg);
        }
        this.itemTxtColor = i2;
        this.itemIconAlpha = 1.0f;
        this.itemBgNormalColor = ContextCompat.getColor(context2, GroupCardDefaultConfig.INSTANCE.getFilterBtnBgColorNormalId());
        this.itemBgPressColor = ContextCompat.getColor(context2, GroupCardDefaultConfig.INSTANCE.getFilterBtnBgColorPressId());
        this.selectedTxtColor = ContextCompat.getColor(context2, GroupCardDefaultConfig.INSTANCE.getFilterTextSelectedColorId());
    }

    public final List<MoreNormalItem> getMorelist() {
        return this.morelist;
    }

    public final void setMorelist(List<? extends MoreNormalItem> list) {
        this.morelist = list;
    }

    public final Function2<MoreNormalItem, Integer, Unit> getOnItemClick() {
        return this.onItemClick;
    }

    public final void setOnItemClick(Function2<? super MoreNormalItem, ? super Integer, Unit> function2) {
        this.onItemClick = function2;
    }

    public final int getItemTitleColor() {
        return this.itemTitleColor;
    }

    public final void setItemTitleColor(int i2) {
        this.itemTitleColor = i2;
    }

    public final int getItemTxtColor() {
        return this.itemTxtColor;
    }

    public final void setItemTxtColor(int i2) {
        this.itemTxtColor = i2;
    }

    public final float getItemIconAlpha() {
        return this.itemIconAlpha;
    }

    public final void setItemIconAlpha(float f2) {
        this.itemIconAlpha = f2;
    }

    public final int getItemBgNormalColor() {
        return this.itemBgNormalColor;
    }

    public final void setItemBgNormalColor(int i2) {
        this.itemBgNormalColor = i2;
    }

    public final int getItemBgPressColor() {
        return this.itemBgPressColor;
    }

    public final void setItemBgPressColor(int i2) {
        this.itemBgPressColor = i2;
    }

    public final Integer getItemSelectedBgColor() {
        return this.itemSelectedBgColor;
    }

    public final void setItemSelectedBgColor(Integer num) {
        this.itemSelectedBgColor = num;
    }

    public final Integer getItemStrokeColor() {
        return this.itemStrokeColor;
    }

    public final void setItemStrokeColor(Integer num) {
        this.itemStrokeColor = num;
    }

    public final Integer getItemSelectedStrokeColor() {
        return this.itemSelectedStrokeColor;
    }

    public final void setItemSelectedStrokeColor(Integer num) {
        this.itemSelectedStrokeColor = num;
    }

    public final int getSelectedTxtColor() {
        return this.selectedTxtColor;
    }

    public final void setSelectedTxtColor(int i2) {
        this.selectedTxtColor = i2;
    }

    public final String getSelectedPd() {
        return this.selectedPd;
    }

    public final void setSelectedPd(String str) {
        this.selectedPd = str;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        switch (viewType) {
            case 1:
                View inflate = LayoutInflater.from(this.context).inflate(R.layout.search_tab_more_title, (ViewGroup) null, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…_more_title, null, false)");
                return new MoreTitleViewHolder(inflate);
            case 5:
                View inflate2 = LayoutInflater.from(this.context).inflate(R.layout.search_tag_more_item, (ViewGroup) null, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "from(context).inflate(R.…g_more_item, null, false)");
                return new MoreTagItemViewHolder(inflate2);
            default:
                View inflate3 = LayoutInflater.from(this.context).inflate(R.layout.search_tab_more_item, (ViewGroup) null, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "from(context).inflate(R.…b_more_item, null, false)");
                return new MoreItemViewHolder(inflate3);
        }
    }

    public int getItemViewType(int position) {
        MoreNormalItem moreNormalItem;
        List<? extends MoreNormalItem> list = this.morelist;
        if (list == null || (moreNormalItem = (MoreNormalItem) list.get(position)) == null) {
            return 0;
        }
        return moreNormalItem.getType();
    }

    public int getItemCount() {
        List<? extends MoreNormalItem> list = this.morelist;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MoreNormalItem moreNormalItem;
        int topDimen;
        boolean z;
        int i2;
        RecyclerView.ViewHolder viewHolder = holder;
        int i3 = position;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        List<? extends MoreNormalItem> list = this.morelist;
        if (list != null && (moreNormalItem = (MoreNormalItem) list.get(i3)) != null) {
            MoreNormalItem tab = moreNormalItem;
            ConstraintLayout.LayoutParams layoutParams = null;
            if (!(tab instanceof MoreTitleItem) && (viewHolder instanceof MoreItemViewHolder)) {
                if (tab instanceof MoreSearchTagItem) {
                    if (!((MoreSearchTagItem) tab).getItem().isResourceTag()) {
                        z = ((MoreSearchTagItem) tab).getItem().isSelected();
                    } else {
                        z = Intrinsics.areEqual((Object) ((MoreSearchTagItem) tab).getItem().getResourcePd(), (Object) this.selectedPd);
                    }
                } else if (tab instanceof MoreSearchTabItem) {
                    z = Intrinsics.areEqual((Object) ((MoreSearchTabItem) tab).getItem().pd, (Object) this.selectedPd);
                } else if (tab instanceof FilterSortTabItem) {
                    z = ((FilterSortTabItem) tab).getModel().isCheck();
                } else if (tab instanceof FilterSearchTabItem) {
                    z = ((FilterSearchTabItem) tab).getModel().isCheck();
                } else {
                    return;
                }
                boolean selected = z;
                if (selected) {
                    i2 = this.selectedTxtColor;
                } else {
                    i2 = this.itemTxtColor;
                }
                int txtColor = i2;
                if (viewHolder instanceof MoreTagItemViewHolder) {
                    ConstraintLayout searchRootLayout = ((MoreTagItemViewHolder) viewHolder).getSearchRootLayout();
                    if (searchRootLayout != null) {
                        searchRootLayout.setBackground(createBgDrawable(selected));
                    }
                    if (selected) {
                        showTagIcon((MoreTagItemViewHolder) viewHolder, tab instanceof MoreSearchTagItem ? (MoreSearchTagItem) tab : null, this.context, Integer.valueOf(txtColor), 1.0f);
                    } else {
                        showTagIcon((MoreTagItemViewHolder) viewHolder, tab instanceof MoreSearchTagItem ? (MoreSearchTagItem) tab : null, this.context, Integer.valueOf(txtColor), this.itemIconAlpha);
                    }
                } else {
                    TextView searchTab = ((MoreItemViewHolder) viewHolder).getSearchTab();
                    if (searchTab != null) {
                        searchTab.setBackground(createBgDrawable(selected));
                    }
                }
                TextView searchTab2 = ((MoreItemViewHolder) viewHolder).getSearchTab();
                if (searchTab2 != null) {
                    searchTab2.setText(tab.getTitle());
                }
                TextView searchTab3 = ((MoreItemViewHolder) viewHolder).getSearchTab();
                if (searchTab3 != null) {
                    searchTab3.setTextSize(((float) FontSizeHelper.getScaledSize(3, (float) this.context.getResources().getDimensionPixelOffset(R.dimen.dimens_12dp), 2)) / this.context.getResources().getDisplayMetrics().scaledDensity);
                }
                if (selected) {
                    TextView searchTab4 = ((MoreItemViewHolder) viewHolder).getSearchTab();
                    if (searchTab4 != null) {
                        searchTab4.setTypeface(Typeface.defaultFromStyle(1));
                    }
                    View view2 = viewHolder.itemView;
                    if (view2 != null) {
                        view2.setOnClickListener((View.OnClickListener) null);
                    }
                } else {
                    TextView searchTab5 = ((MoreItemViewHolder) viewHolder).getSearchTab();
                    if (searchTab5 != null) {
                        searchTab5.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
                TextView searchTab6 = ((MoreItemViewHolder) viewHolder).getSearchTab();
                if (searchTab6 != null) {
                    searchTab6.setTextColor(txtColor);
                }
                viewHolder.itemView.setOnClickListener(new TabMoreAdapter$$ExternalSyntheticLambda0(tab, this, i3));
            } else if ((tab instanceof MoreTitleItem) && (viewHolder instanceof MoreTitleViewHolder)) {
                TextView searchTittle = ((MoreTitleViewHolder) viewHolder).getSearchTittle();
                if (searchTittle != null) {
                    searchTittle.setText(tab.getTitle());
                }
                TextView searchTittle2 = ((MoreTitleViewHolder) viewHolder).getSearchTittle();
                if (searchTittle2 != null) {
                    FontSizeTextViewExtKt.setScaledSizeRes$default(searchTittle2, 3, R.dimen.dimens_14dp, 0, 4, (Object) null);
                }
                TextView searchTittle3 = ((MoreTitleViewHolder) viewHolder).getSearchTittle();
                if (searchTittle3 != null) {
                    searchTittle3.setTextColor(this.itemTitleColor);
                }
                TextView searchTittle4 = ((MoreTitleViewHolder) viewHolder).getSearchTittle();
                ViewGroup.LayoutParams layoutParams2 = searchTittle4 != null ? searchTittle4.getLayoutParams() : null;
                if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
                    layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
                }
                ConstraintLayout.LayoutParams params = layoutParams;
                if (params != null) {
                    if (i3 != 0) {
                        topDimen = com.baidu.android.common.ui.style.R.dimen.dimens_21dp;
                    } else {
                        topDimen = com.baidu.searchbox.feed.core.R.dimen.dimens_11dp;
                    }
                    Resources resources = this.context.getResources();
                    if (resources != null) {
                        params.topMargin = resources.getDimensionPixelOffset(topDimen);
                        TextView searchTittle5 = ((MoreTitleViewHolder) viewHolder).getSearchTittle();
                        if (searchTittle5 != null) {
                            searchTittle5.setLayoutParams(params);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m13005onBindViewHolder$lambda0(MoreNormalItem $tab, TabMoreAdapter this$0, int $position, View it) {
        Intrinsics.checkNotNullParameter($tab, "$tab");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ($tab instanceof MoreSearchTabItem) {
            this$0.selectedPd = ((MoreSearchTabItem) $tab).getItem().pd;
            Function2<? super MoreNormalItem, ? super Integer, Unit> function2 = this$0.onItemClick;
            if (function2 != null) {
                function2.invoke($tab, Integer.valueOf(((MoreSearchTabItem) $tab).getItem().position));
            }
        } else if ($tab instanceof MoreSearchTagItem) {
            if (((MoreSearchTagItem) $tab).getItem().isResourceTag()) {
                this$0.selectedPd = ((MoreSearchTagItem) $tab).getItem().getResourcePd();
            }
            Function2<? super MoreNormalItem, ? super Integer, Unit> function22 = this$0.onItemClick;
            if (function22 != null) {
                function22.invoke($tab, Integer.valueOf(((MoreSearchTagItem) $tab).getItem().getPos()));
            }
        } else {
            Function2<? super MoreNormalItem, ? super Integer, Unit> function23 = this$0.onItemClick;
            if (function23 != null) {
                function23.invoke($tab, Integer.valueOf($position));
            }
        }
    }

    private final Drawable createBgDrawable(boolean isSelected) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable normalDrawable = new GradientDrawable();
        normalDrawable.setCornerRadius(this.context.getResources().getDimension(R.dimen.dimens_16dp));
        if (isSelected) {
            Integer num = this.itemSelectedBgColor;
            normalDrawable.setColor(num != null ? num.intValue() : this.itemBgNormalColor);
            Integer num2 = this.itemSelectedStrokeColor;
            if (num2 != null) {
                normalDrawable.setStroke(1, num2.intValue());
            }
        } else {
            normalDrawable.setColor(this.itemBgNormalColor);
            Integer num3 = this.itemStrokeColor;
            if (num3 != null) {
                normalDrawable.setStroke(1, num3.intValue());
            }
        }
        int[] iArr = new int[1];
        for (int i2 = 0; i2 < 1; i2++) {
            iArr[i2] = -16842919;
        }
        stateListDrawable.addState(iArr, normalDrawable);
        GradientDrawable pressDrawable = new GradientDrawable();
        pressDrawable.setCornerRadius(this.context.getResources().getDimension(R.dimen.dimens_16dp));
        if (isSelected) {
            Integer num4 = this.itemSelectedBgColor;
            pressDrawable.setColor(num4 != null ? num4.intValue() : this.itemBgPressColor);
            Integer num5 = this.itemSelectedStrokeColor;
            if (num5 != null) {
                pressDrawable.setStroke(1, num5.intValue());
            }
        } else {
            pressDrawable.setColor(this.itemBgPressColor);
            Integer num6 = this.itemStrokeColor;
            if (num6 != null) {
                pressDrawable.setStroke(1, num6.intValue());
            }
        }
        int[] iArr2 = new int[1];
        for (int i3 = 0; i3 < 1; i3++) {
            iArr2[i3] = 16842919;
        }
        stateListDrawable.addState(iArr2, pressDrawable);
        return stateListDrawable;
    }

    public final void showTagIcon(MoreTagItemViewHolder holder, MoreSearchTagItem searchTagItem, Context context2, Integer tagColor, float alpha) {
        SearchTagItem item;
        String iconUrl;
        Intrinsics.checkNotNullParameter(context2, "context");
        if (searchTagItem != null && (item = searchTagItem.getItem()) != null && (iconUrl = item.getTagImg()) != null && holder != null) {
            holder.showTagIcon(iconUrl, context2, tagColor, alpha);
        }
    }
}
