package com.baidu.mms.voicesearch.voice.view.guideresource;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceSkinController;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.guidewordsview.horizontalview.GuideWordsBean;
import com.baidu.mms.voicesearch.voice.bean.dao.AssistantSugBean;
import com.baidu.mms.voicesearch.voice.common.Tools;
import com.baidu.mms.voicesearch.voice.utils.SkinManager;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.hissug.data.model.SearchHistory;
import com.baidu.searchbox.home.tabs.BaseTabItemView;
import com.baidu.speechbundle.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/guideresource/GuideResourceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/mms/voicesearch/voice/view/guideresource/GuideResourceAdapter$MyViewHolder;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lcom/baidu/mms/voicesearch/voice/view/guideresource/GuideResourceDataBean;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "guideItemCallBack", "Lcom/baidu/mms/voicesearch/voice/view/guideresource/GuideResourceAdapter$GuideItemCallBack;", "tagPaint", "Landroid/graphics/Paint;", "textPaint", "getItemCount", "", "getLastItemWidth", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemCallBack", "callBack", "GuideItemCallBack", "MyViewHolder", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuideResourceAdapter.kt */
public final class GuideResourceAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    /* access modifiers changed from: private */
    public ArrayList<GuideResourceDataBean> dataList;
    /* access modifiers changed from: private */
    public GuideItemCallBack guideItemCallBack;
    private Paint tagPaint;
    private Paint textPaint;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/guideresource/GuideResourceAdapter$GuideItemCallBack;", "", "onItemClick", "", "wordItem", "Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/guidewordsview/horizontalview/GuideWordsBean$WordsItemBean;", "historyItem", "Lcom/baidu/searchbox/hissug/data/model/SearchHistory;", "sugItem", "Lcom/baidu/mms/voicesearch/voice/bean/dao/AssistantSugBean$SugItemBean;", "position", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GuideResourceAdapter.kt */
    public interface GuideItemCallBack {
        void onItemClick(GuideWordsBean.WordsItemBean wordsItemBean, SearchHistory searchHistory, AssistantSugBean.SugItemBean sugItemBean, int i2);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006$"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/guideresource/GuideResourceAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "iconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIconView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setIconView", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "itemContentView", "Landroid/widget/RelativeLayout;", "getItemContentView", "()Landroid/widget/RelativeLayout;", "setItemContentView", "(Landroid/widget/RelativeLayout;)V", "itemRootView", "Landroid/widget/LinearLayout;", "getItemRootView", "()Landroid/widget/LinearLayout;", "setItemRootView", "(Landroid/widget/LinearLayout;)V", "tagView", "Landroid/widget/TextView;", "getTagView", "()Landroid/widget/TextView;", "setTagView", "(Landroid/widget/TextView;)V", "titleView", "getTitleView", "setTitleView", "setVisibility", "", "visibility", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GuideResourceAdapter.kt */
    public static final class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView iconView;
        private RelativeLayout itemContentView;
        private LinearLayout itemRootView;
        private TextView tagView;
        private TextView titleView;

        public final LinearLayout getItemRootView() {
            return this.itemRootView;
        }

        public final void setItemRootView(LinearLayout linearLayout) {
            this.itemRootView = linearLayout;
        }

        public final RelativeLayout getItemContentView() {
            return this.itemContentView;
        }

        public final void setItemContentView(RelativeLayout relativeLayout) {
            this.itemContentView = relativeLayout;
        }

        public final TextView getTitleView() {
            return this.titleView;
        }

        public final void setTitleView(TextView textView) {
            this.titleView = textView;
        }

        public final SimpleDraweeView getIconView() {
            return this.iconView;
        }

        public final void setIconView(SimpleDraweeView simpleDraweeView) {
            this.iconView = simpleDraweeView;
        }

        public final TextView getTagView() {
            return this.tagView;
        }

        public final void setTagView(TextView textView) {
            this.tagView = textView;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyViewHolder(View v) {
            super(v);
            Intrinsics.checkNotNullParameter(v, "v");
            this.itemRootView = (LinearLayout) v.findViewById(R.id.guide_resource_item_root);
            this.itemContentView = (RelativeLayout) v.findViewById(R.id.guide_resource_item_container);
            this.titleView = (TextView) v.findViewById(R.id.guide_resource_item_title);
            this.iconView = (SimpleDraweeView) v.findViewById(R.id.guide_resource_item_icon);
            this.tagView = (TextView) v.findViewById(R.id.guide_resource_item_tag);
        }

        public final void setVisibility(int visibility) {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams param = (RecyclerView.LayoutParams) layoutParams;
                if (visibility == 0) {
                    param.width = -2;
                    param.height = -2;
                    param.leftMargin = (int) Tools.dip2px(8.0f);
                    this.itemView.setVisibility(0);
                } else {
                    param.width = 0;
                    param.height = 0;
                    param.leftMargin = 0;
                    this.itemView.setVisibility(8);
                }
                this.itemView.setLayoutParams(param);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
    }

    public GuideResourceAdapter(Context context2, ArrayList<GuideResourceDataBean> dataList2) {
        Intrinsics.checkNotNullParameter(dataList2, "dataList");
        this.context = context2;
        this.dataList = dataList2;
    }

    public final void setItemCallBack(GuideItemCallBack callBack) {
        this.guideItemCallBack = callBack;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.immersion_voice_guide_resource_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(v, "v");
        return new MyViewHolder(v);
    }

    public int getItemCount() {
        return RangesKt.coerceAtMost(this.dataList.size(), 36);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        CharSequence charSequence;
        TextPaint paint;
        AssistantSugBean.SugItemBean sugItem;
        float f2;
        TextPaint paint2;
        SearchHistory historyItem;
        SearchHistory historyItem2;
        SearchHistory historyItem3;
        SearchHistory historyItem4;
        GuideWordsBean.WordsItemBean wordsItem;
        GuideWordsBean.WordsItemBean wordsItem2;
        GuideWordsBean.WordsItemBean wordsItem3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position < this.dataList.size()) {
            String word = "";
            boolean showImg = false;
            float tagLength = 0.0f;
            TextView tagView = holder.getTagView();
            if (tagView != null) {
                tagView.setVisibility(8);
            }
            holder.setVisibility(0);
            GuideResourceDataBean guideResourceDataBean = this.dataList.get(position);
            TextPaint textPaint2 = null;
            boolean z = true;
            if ((guideResourceDataBean != null ? guideResourceDataBean.getWordsItem() : null) != null) {
                GuideResourceDataBean guideResourceDataBean2 = this.dataList.get(position);
                word = (guideResourceDataBean2 == null || (wordsItem3 = guideResourceDataBean2.getWordsItem()) == null) ? null : wordsItem3.upscreen;
                GuideResourceDataBean guideResourceDataBean3 = this.dataList.get(position);
                if ((guideResourceDataBean3 == null || (wordsItem2 = guideResourceDataBean3.getWordsItem()) == null || !wordsItem2.hasIconUrl()) ? false : true) {
                    showImg = true;
                    SimpleDraweeView iconView = holder.getIconView();
                    if (iconView != null) {
                        iconView.setVisibility(0);
                    }
                    int iconDrawable = R.drawable.guide_resource_placeholder_normal;
                    if (SkinManager.getInstance().isNightMode()) {
                        iconDrawable = R.drawable.guide_resource_placeholder_night;
                    }
                    Context context2 = this.context;
                    GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(context2 != null ? context2.getResources() : null).setPlaceholderImage(iconDrawable).setFailureImage(iconDrawable).build();
                    Intrinsics.checkNotNullExpressionValue(hierarchy, "builder\n                …                 .build()");
                    SimpleDraweeView iconView2 = holder.getIconView();
                    if (iconView2 != null) {
                        iconView2.setHierarchy(hierarchy);
                    }
                    SimpleDraweeView iconView3 = holder.getIconView();
                    if (iconView3 != null) {
                        GuideResourceDataBean guideResourceDataBean4 = this.dataList.get(position);
                        iconView3.setImageURI((guideResourceDataBean4 == null || (wordsItem = guideResourceDataBean4.getWordsItem()) == null) ? null : wordsItem.icon_normal);
                    }
                    SimpleDraweeView iconView4 = holder.getIconView();
                    if (iconView4 != null) {
                        iconView4.setVisibility(0);
                    }
                } else {
                    showImg = false;
                    SimpleDraweeView iconView5 = holder.getIconView();
                    if (iconView5 != null) {
                        iconView5.setVisibility(8);
                    }
                }
            }
            GuideResourceDataBean guideResourceDataBean5 = this.dataList.get(position);
            float f3 = 0.0f;
            if ((guideResourceDataBean5 != null ? guideResourceDataBean5.getHistoryItem() : null) != null) {
                GuideResourceDataBean guideResourceDataBean6 = this.dataList.get(position);
                if (guideResourceDataBean6 != null && !guideResourceDataBean6.getCanDisplay()) {
                    holder.setVisibility(8);
                    return;
                }
                showImg = true;
                GuideResourceDataBean guideResourceDataBean7 = this.dataList.get(position);
                word = (guideResourceDataBean7 == null || (historyItem4 = guideResourceDataBean7.getHistoryItem()) == null) ? null : historyItem4.getWord();
                GuideResourceDataBean guideResourceDataBean8 = this.dataList.get(position);
                if (!TextUtils.isEmpty((guideResourceDataBean8 == null || (historyItem3 = guideResourceDataBean8.getHistoryItem()) == null) ? null : historyItem3.getTag())) {
                    TextView tagView2 = holder.getTagView();
                    if (tagView2 != null) {
                        GuideResourceDataBean guideResourceDataBean9 = this.dataList.get(position);
                        tagView2.setText((guideResourceDataBean9 == null || (historyItem2 = guideResourceDataBean9.getHistoryItem()) == null) ? null : historyItem2.getTag());
                    }
                    TextView tagView3 = holder.getTagView();
                    if (tagView3 == null || (paint2 = tagView3.getPaint()) == null) {
                        f2 = 0.0f;
                    } else {
                        GuideResourceDataBean guideResourceDataBean10 = this.dataList.get(position);
                        f2 = paint2.measureText((guideResourceDataBean10 == null || (historyItem = guideResourceDataBean10.getHistoryItem()) == null) ? null : historyItem.getTag());
                    }
                    tagLength = f2;
                    TextView tagView4 = holder.getTagView();
                    this.tagPaint = tagView4 != null ? tagView4.getPaint() : null;
                    TextView tagView5 = holder.getTagView();
                    if (tagView5 != null) {
                        tagView5.setVisibility(0);
                    }
                }
                if (SkinManager.getInstance().isNightMode()) {
                    SimpleDraweeView iconView6 = holder.getIconView();
                    if (iconView6 != null) {
                        iconView6.setActualImageResource(R.drawable.history_item_icon_night);
                    }
                    TextView tagView6 = holder.getTagView();
                    if (tagView6 != null) {
                        tagView6.setTextColor(Color.parseColor("#666666"));
                    }
                } else {
                    SimpleDraweeView iconView7 = holder.getIconView();
                    if (iconView7 != null) {
                        iconView7.setActualImageResource(R.drawable.history_item_icon_normal);
                    }
                    TextView tagView7 = holder.getTagView();
                    if (tagView7 != null) {
                        tagView7.setTextColor(Color.parseColor(BaseTabItemView.GRAY_BADGE_COLOR));
                    }
                }
                SimpleDraweeView iconView8 = holder.getIconView();
                if (iconView8 != null) {
                    iconView8.setVisibility(0);
                }
            }
            GuideResourceDataBean guideResourceDataBean11 = this.dataList.get(position);
            if ((guideResourceDataBean11 != null ? guideResourceDataBean11.getSugItem() : null) != null) {
                GuideResourceDataBean guideResourceDataBean12 = this.dataList.get(position);
                word = (guideResourceDataBean12 == null || (sugItem = guideResourceDataBean12.getSugItem()) == null) ? null : sugItem.query;
                SimpleDraweeView iconView9 = holder.getIconView();
                if (iconView9 != null) {
                    iconView9.setVisibility(8);
                }
            }
            if (word != null && word.length() > 10) {
                if (word.charAt(word.length() - 1) == '\"') {
                    String word2 = word.substring(0, 9);
                    Intrinsics.checkNotNullExpressionValue(word2, "this as java.lang.String…ing(startIndex, endIndex)");
                    word = word2 + "...\"";
                } else {
                    String word3 = word.substring(0, 9);
                    Intrinsics.checkNotNullExpressionValue(word3, "this as java.lang.String…ing(startIndex, endIndex)");
                    word = word3 + "...";
                }
            }
            TextView titleView = holder.getTitleView();
            if (!(titleView == null || (paint = titleView.getPaint()) == null)) {
                f3 = paint.measureText(word == null ? "" : word);
            }
            float textWidth = f3;
            TextView titleView2 = holder.getTitleView();
            this.textPaint = titleView2 != null ? titleView2.getPaint() : null;
            RelativeLayout itemContentView = holder.getItemContentView();
            ViewGroup.LayoutParams layoutParams = itemContentView != null ? itemContentView.getLayoutParams() : null;
            if (layoutParams != null) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) layoutParams;
                lp.width = ((int) textWidth) + ((int) Tools.dip2px(23.0f));
                if (showImg) {
                    lp.width = ((int) textWidth) + ((int) Tools.dip2px(42.0f));
                }
                TextView tagView8 = holder.getTagView();
                if (tagView8 != null && tagView8.getVisibility() == 0) {
                    lp.width = ((int) textWidth) + ((int) Tools.dip2px(58.0f)) + ((int) tagLength);
                }
                TextView titleView3 = holder.getTitleView();
                if (titleView3 != null) {
                    if (word != null) {
                        charSequence = word;
                    }
                    titleView3.setText(charSequence);
                }
                RelativeLayout itemContentView2 = holder.getItemContentView();
                if (itemContentView2 != null) {
                    itemContentView2.setLayoutParams(lp);
                }
                GuideResourceDataBean guideResourceDataBean13 = this.dataList.get(position);
                if (guideResourceDataBean13 == null || guideResourceDataBean13.getType() != 1) {
                    z = false;
                }
                if (!z || position != 0) {
                    TextView titleView4 = holder.getTitleView();
                    if (titleView4 != null) {
                        titleView4.setTextColor(VoiceSkinController.Companion.getInstance().getGuideResourceTextColor());
                    }
                } else if (SkinManager.getInstance().isNightMode()) {
                    TextView titleView5 = holder.getTitleView();
                    if (titleView5 != null) {
                        titleView5.setTextColor(Color.parseColor("#9C0C27"));
                    }
                } else {
                    TextView titleView6 = holder.getTitleView();
                    if (titleView6 != null) {
                        titleView6.setTextColor(Color.parseColor("#F5123D"));
                    }
                }
                RelativeLayout itemContentView3 = holder.getItemContentView();
                if (itemContentView3 != null) {
                    itemContentView3.setBackground(VoiceSkinController.Companion.getInstance().getGuideResourceBgDrawable());
                }
                TextView titleView7 = holder.getTitleView();
                if (titleView7 != null) {
                    textPaint2 = titleView7.getPaint();
                }
                if (textPaint2 != null) {
                    textPaint2.setFakeBoldText(false);
                }
                RelativeLayout itemContentView4 = holder.getItemContentView();
                if (itemContentView4 != null) {
                    itemContentView4.setOnClickListener(new GuideResourceAdapter$onBindViewHolder$1(this, position));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
    }

    public final int getLastItemWidth() {
        if (this.dataList.isEmpty()) {
            return 0;
        }
        try {
            GuideResourceDataBean lastItem = (GuideResourceDataBean) CollectionsKt.last(this.dataList);
            if (lastItem == null) {
                return 0;
            }
            String word = "";
            int totalWidth = 0;
            float f2 = 0.0f;
            String str = null;
            if (lastItem.getHistoryItem() != null && lastItem.getCanDisplay()) {
                SearchHistory historyItem = lastItem.getHistoryItem();
                word = historyItem != null ? historyItem.getWord() : null;
                SearchHistory historyItem2 = lastItem.getHistoryItem();
                String tag = historyItem2 != null ? historyItem2.getTag() : null;
                totalWidth = 0 + ((int) Tools.dip2px(19.0f));
                float tagWidth = 0.0f;
                if (tag != null && !TextUtils.isEmpty(tag)) {
                    Paint paint = this.tagPaint;
                    tagWidth = paint != null ? paint.measureText(tag) : 0.0f;
                }
                if (tagWidth > 1.0f) {
                    totalWidth += ((int) Tools.dip2px(16.0f)) + ((int) tagWidth);
                }
            }
            if (lastItem.getWordsItem() != null) {
                GuideWordsBean.WordsItemBean wordsItem = lastItem.getWordsItem();
                word = wordsItem != null ? wordsItem.upscreen : null;
                GuideWordsBean.WordsItemBean wordsItem2 = lastItem.getWordsItem();
                if (wordsItem2 != null && wordsItem2.hasIconUrl()) {
                    totalWidth += (int) Tools.dip2px(19.0f);
                }
            }
            if (lastItem.getSugItem() != null) {
                AssistantSugBean.SugItemBean sugItem = lastItem.getSugItem();
                if (sugItem != null) {
                    str = sugItem.query;
                }
                word = str;
            }
            if (word != null && word.length() > 10) {
                if (word.charAt(word.length() - 1) == '\"') {
                    String word2 = word.substring(0, 9);
                    Intrinsics.checkNotNullExpressionValue(word2, "this as java.lang.String…ing(startIndex, endIndex)");
                    word = word2 + "...\"";
                } else {
                    String word3 = word.substring(0, 9);
                    Intrinsics.checkNotNullExpressionValue(word3, "this as java.lang.String…ing(startIndex, endIndex)");
                    word = word3 + "...";
                }
            }
            float textWidth = 0.0f;
            if (this.textPaint != null && !TextUtils.isEmpty(word)) {
                Paint paint2 = this.textPaint;
                if (paint2 != null) {
                    f2 = paint2.measureText(word);
                }
                textWidth = f2;
            }
            return totalWidth + ((int) textWidth) + ((int) Tools.dip2px(23.0f));
        } catch (Exception e2) {
            return 0;
        }
    }
}
