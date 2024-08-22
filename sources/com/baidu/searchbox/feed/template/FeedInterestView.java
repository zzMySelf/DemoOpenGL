package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.util.android.VibrateUtils;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.IFeedFontAdjustable;
import com.baidu.searchbox.feed.base.IFeedOnUnlikeListener;
import com.baidu.searchbox.feed.base.IFeedTplContainer;
import com.baidu.searchbox.feed.controller.FeedRecyclerViewDelegate;
import com.baidu.searchbox.feed.flow.TimeServer;
import com.baidu.searchbox.feed.flow.assistants.RefreshInfo;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataInterest;
import com.baidu.searchbox.feed.refreshex.RefreshRevolutionary;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.tab.view.FeedThickDividerPolicy;
import com.baidu.searchbox.feed.template.utils.FeedOrderSenseUtil;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.ui.BdBaseImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J\u0012\u0010,\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010.\u001a\u00020(H\u0002J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020(H\u0003J\b\u00104\u001a\u00020(H\u0002J\u0012\u00105\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020(2\u0006\u0010-\u001a\u000206H\u0002J\u0010\u00108\u001a\u00020(2\u0006\u0010-\u001a\u000206H\u0002J\b\u00109\u001a\u00020(H\u0016J\u001c\u0010:\u001a\u00020;2\b\u0010-\u001a\u0004\u0018\u0001062\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020(H\u0016J(\u0010?\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u00152\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010AH\u0016J\b\u0010D\u001a\u00020(H\u0002J\b\u0010E\u001a\u00020(H\u0014R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedInterestView;", "Lcom/baidu/searchbox/feed/template/FeedLinearLayout;", "Landroid/view/View$OnTouchListener;", "Lcom/baidu/searchbox/feed/base/IFeedOnUnlikeListener;", "Lcom/baidu/searchbox/feed/base/IFeedFontAdjustable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomOptionRootView", "Landroid/widget/LinearLayout;", "changeOrCommitBtn", "Landroid/widget/TextView;", "dislikeView", "Landroid/widget/ImageView;", "interestData", "Lcom/baidu/searchbox/feed/model/FeedItemDataInterest;", "interestModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "optionView1", "optionView2", "optionView3", "optionView4", "optionView5", "optionView6", "optionViewList", "", "rootView", "Landroid/view/ViewGroup;", "selectedOptions", "Lcom/baidu/searchbox/feed/model/FeedItemDataInterest$InterestOption;", "titleIcon", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "titleRootView", "titleView", "topOptionRootView", "afterBindViewHolder", "", "feedModel", "assembleSelectedOptions", "changeCommitStatus", "changeOptionStatus", "v", "commitPage", "getFeedDividerPolicy", "Lcom/baidu/searchbox/feed/base/FeedTemplate$FeedDividerPolicy;", "getSelectedOptions", "Lorg/json/JSONObject;", "initInflate", "nextPage", "onClick", "Landroid/view/View;", "onClickCommit", "onClickOption", "onFontSizeChanged", "onTouch", "", "event", "Landroid/view/MotionEvent;", "onUnlike", "update", "options", "", "", "", "updateContent", "updateFeedOrderSense", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedInterestView.kt */
public final class FeedInterestView extends FeedLinearLayout implements View.OnTouchListener, IFeedOnUnlikeListener, IFeedFontAdjustable {
    private LinearLayout bottomOptionRootView;
    private TextView changeOrCommitBtn;
    private ImageView dislikeView;
    /* access modifiers changed from: private */
    public FeedItemDataInterest interestData;
    private FeedBaseModel interestModel;
    private TextView optionView1;
    private TextView optionView2;
    private TextView optionView3;
    private TextView optionView4;
    private TextView optionView5;
    private TextView optionView6;
    private final List<TextView> optionViewList;
    /* access modifiers changed from: private */
    public ViewGroup rootView;
    private final List<FeedItemDataInterest.InterestOption> selectedOptions;
    private BdBaseImageView titleIcon;
    private LinearLayout titleRootView;
    private TextView titleView;
    private LinearLayout topOptionRootView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedInterestView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedInterestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedInterestView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedInterestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.optionViewList = new ArrayList();
        this.interestData = new FeedItemDataInterest();
        this.selectedOptions = new ArrayList();
        initInflate();
    }

    private final void initInflate() {
        View.inflate(getContext(), R.layout.feed_tpl_interest_view, this);
        this.titleRootView = (LinearLayout) findViewById(R.id.title_root);
        this.topOptionRootView = (LinearLayout) findViewById(R.id.top_option_root);
        this.bottomOptionRootView = (LinearLayout) findViewById(R.id.bottom_option_root);
        View findViewById = findViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.root_view)");
        this.rootView = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.title_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.title_icon)");
        this.titleIcon = (BdBaseImageView) findViewById2;
        View findViewById3 = findViewById(R.id.title_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.title_text)");
        this.titleView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.feed_template_base_delete_id);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.feed_template_base_delete_id)");
        ImageView imageView = (ImageView) findViewById4;
        this.dislikeView = imageView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dislikeView");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        View findViewById5 = findViewById(R.id.interest_option_1);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.interest_option_1)");
        TextView textView2 = (TextView) findViewById5;
        this.optionView1 = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView1");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        View findViewById6 = findViewById(R.id.interest_option_2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.interest_option_2)");
        TextView textView3 = (TextView) findViewById6;
        this.optionView2 = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView2");
            textView3 = null;
        }
        textView3.setOnClickListener(this);
        View findViewById7 = findViewById(R.id.interest_option_3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.interest_option_3)");
        TextView textView4 = (TextView) findViewById7;
        this.optionView3 = textView4;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView3");
            textView4 = null;
        }
        textView4.setOnClickListener(this);
        View findViewById8 = findViewById(R.id.interest_option_4);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.interest_option_4)");
        TextView textView5 = (TextView) findViewById8;
        this.optionView4 = textView5;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView4");
            textView5 = null;
        }
        textView5.setOnClickListener(this);
        View findViewById9 = findViewById(R.id.interest_option_5);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.interest_option_5)");
        TextView textView6 = (TextView) findViewById9;
        this.optionView5 = textView6;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView5");
            textView6 = null;
        }
        textView6.setOnClickListener(this);
        View findViewById10 = findViewById(R.id.interest_option_6);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.interest_option_6)");
        TextView textView7 = (TextView) findViewById10;
        this.optionView6 = textView7;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView6");
            textView7 = null;
        }
        textView7.setOnClickListener(this);
        View findViewById11 = findViewById(R.id.change_commit_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.change_commit_btn)");
        TextView textView8 = (TextView) findViewById11;
        this.changeOrCommitBtn = textView8;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
            textView8 = null;
        }
        textView8.setOnClickListener(this);
        TextView textView9 = this.changeOrCommitBtn;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
            textView9 = null;
        }
        textView9.setOnTouchListener(this);
        List<TextView> list = this.optionViewList;
        TextView textView10 = this.optionView1;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView1");
            textView10 = null;
        }
        list.add(textView10);
        List<TextView> list2 = this.optionViewList;
        TextView textView11 = this.optionView2;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView2");
            textView11 = null;
        }
        list2.add(textView11);
        List<TextView> list3 = this.optionViewList;
        TextView textView12 = this.optionView3;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView3");
            textView12 = null;
        }
        list3.add(textView12);
        List<TextView> list4 = this.optionViewList;
        TextView textView13 = this.optionView4;
        if (textView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView4");
            textView13 = null;
        }
        list4.add(textView13);
        List<TextView> list5 = this.optionViewList;
        TextView textView14 = this.optionView5;
        if (textView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView5");
            textView14 = null;
        }
        list5.add(textView14);
        List<TextView> list6 = this.optionViewList;
        TextView textView15 = this.optionView6;
        if (textView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView6");
        } else {
            textView = textView15;
        }
        list6.add(textView);
    }

    /* access modifiers changed from: protected */
    public void updateFeedOrderSense() {
        updateHorizontalPadding(this.titleRootView);
        updateHorizontalPadding(this.topOptionRootView);
        updateHorizontalPadding(this.bottomOptionRootView);
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        super.update(feedModel, options);
        TextView textView = null;
        setOnClickListener((View.OnClickListener) null);
        this.interestModel = feedModel;
        if ((feedModel != null ? feedModel.data : null) instanceof FeedItemDataInterest) {
            FeedItemData feedItemData = feedModel.data;
            if (feedItemData != null) {
                this.interestData = (FeedItemDataInterest) feedItemData;
                TextView textView2 = this.titleView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    textView2 = null;
                }
                textView2.setText(this.interestData.title);
                TextView textView3 = this.titleView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                } else {
                    textView = textView3;
                }
                ViewExtensionsKt.setTextColorRes(textView, R.color.FC1);
                updateContent();
                changeCommitStatus();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedItemDataInterest");
        }
    }

    private final void updateContent() {
        int currPage;
        if (this.interestData.getCurrPage() < this.interestData.getInterestOptions().size()) {
            currPage = this.interestData.getCurrPage();
        } else {
            currPage = 0;
        }
        List optionPage = this.interestData.getInterestOptions().get(currPage);
        this.selectedOptions.clear();
        for (int i2 = 0; i2 < 6; i2++) {
            this.optionViewList.get(i2).setText(((FeedItemDataInterest.InterestOption) optionPage.get(i2)).getDesc());
            this.optionViewList.get(i2).setTag(optionPage.get(i2));
            if (((FeedItemDataInterest.InterestOption) optionPage.get(i2)).getSelected()) {
                this.selectedOptions.add(optionPage.get(i2));
                this.optionViewList.get(i2).setBackground(ViewExtensionsKt.getDrawable(this, R.drawable.feed_interest_item_selected_bg));
                ViewExtensionsKt.setTextColorRes(this.optionViewList.get(i2), R.color.FC17);
                this.optionViewList.get(i2).setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                this.optionViewList.get(i2).setBackground(ViewExtensionsKt.getDrawable(this, R.drawable.feed_interest_item_normal_bg));
                ViewExtensionsKt.setTextColorRes(this.optionViewList.get(i2), R.color.FC1);
                this.optionViewList.get(i2).setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private final void changeOptionStatus(TextView v) {
        if (v != null) {
            TextView it = v;
            if (v.getTag() instanceof FeedItemDataInterest.InterestOption) {
                Object tag = v.getTag();
                if (tag != null) {
                    FeedItemDataInterest.InterestOption optionData = (FeedItemDataInterest.InterestOption) tag;
                    if (optionData.getSelected()) {
                        optionData.setSelected(false);
                        optionData.setSelectStamp(-1);
                        this.selectedOptions.remove(optionData);
                        it.setBackground(ViewExtensionsKt.getDrawable(this, R.drawable.feed_interest_item_normal_bg));
                        ViewExtensionsKt.setTextColorRes(it, R.color.FC1);
                        it.setTypeface(Typeface.DEFAULT);
                        return;
                    }
                    optionData.setSelected(true);
                    optionData.setSelectStamp(TimeServer.Proxy.getDefault().currentTimeMillis());
                    this.selectedOptions.add(optionData);
                    it.setBackground(ViewExtensionsKt.getDrawable(this, R.drawable.feed_interest_item_selected_bg));
                    ViewExtensionsKt.setTextColorRes(it, R.color.FC17);
                    it.setTypeface(Typeface.DEFAULT_BOLD);
                    FeedStatisticCenter.ubcInterestTpl("item_clk", this.interestData.getUserProperty(), (JSONObject) null);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedItemDataInterest.InterestOption");
            }
        }
    }

    private final void changeCommitStatus() {
        TextView textView = null;
        if (this.selectedOptions.size() > 0) {
            TextView textView2 = this.changeOrCommitBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView2 = null;
            }
            textView2.setBackground(ViewExtensionsKt.getDrawable(this, R.drawable.feed_interest_commit_bg));
            TextView textView3 = this.changeOrCommitBtn;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView3 = null;
            }
            ViewExtensionsKt.setTextColorRes(textView3, R.color.FC424);
            TextView textView4 = this.changeOrCommitBtn;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView4 = null;
            }
            textView4.setText(R.string.feed_interest_commit_default);
            TextView textView5 = this.changeOrCommitBtn;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView5 = null;
            }
            textView5.setAlpha(1.0f);
            TextView textView6 = this.changeOrCommitBtn;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
            } else {
                textView = textView6;
            }
            textView.setEnabled(true);
        } else if (this.interestData.getInterestOptions().size() == 1) {
            TextView textView7 = this.changeOrCommitBtn;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView7 = null;
            }
            textView7.setBackground(ViewExtensionsKt.getDrawable(this, R.drawable.feed_interest_commit_bg));
            TextView textView8 = this.changeOrCommitBtn;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView8 = null;
            }
            ViewExtensionsKt.setTextColorRes(textView8, R.color.FC424);
            TextView textView9 = this.changeOrCommitBtn;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView9 = null;
            }
            textView9.setText(R.string.feed_interest_commit_default);
            TextView textView10 = this.changeOrCommitBtn;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView10 = null;
            }
            textView10.setAlpha(0.3f);
            TextView textView11 = this.changeOrCommitBtn;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
            } else {
                textView = textView11;
            }
            textView.setEnabled(false);
        } else {
            TextView textView12 = this.changeOrCommitBtn;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView12 = null;
            }
            textView12.setBackground(ViewExtensionsKt.getDrawable(this, R.drawable.feed_interest_change_bg));
            TextView textView13 = this.changeOrCommitBtn;
            if (textView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView13 = null;
            }
            ViewExtensionsKt.setTextColorRes(textView13, R.color.FC17);
            TextView textView14 = this.changeOrCommitBtn;
            if (textView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView14 = null;
            }
            textView14.setText(R.string.feed_interest_change_default);
            TextView textView15 = this.changeOrCommitBtn;
            if (textView15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                textView15 = null;
            }
            textView15.setAlpha(1.0f);
            TextView textView16 = this.changeOrCommitBtn;
            if (textView16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
            } else {
                textView = textView16;
            }
            textView.setEnabled(true);
        }
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        return FeedThickDividerPolicy.getDefault();
    }

    public void onClick(View v) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        IFeedTplContainer feedTplContainer;
        if (v != null) {
            int id = v.getId();
            if (id == R.id.feed_template_base_delete_id) {
                FeedTemplateImpl feedTemplateImpl = this.mFeedTemplateImplBase;
                if (feedTemplateImpl != null && (feedTplContainer = feedTemplateImpl.getFeedTplContainer()) != null) {
                    feedTplContainer.remove(this.interestModel);
                    return;
                }
                return;
            }
            boolean z5 = false;
            if (id == R.id.interest_option_1) {
                z = true;
            } else {
                z = id == R.id.interest_option_2;
            }
            if (z) {
                z2 = true;
            } else {
                z2 = id == R.id.interest_option_3;
            }
            if (z2) {
                z3 = true;
            } else {
                z3 = id == R.id.interest_option_4;
            }
            if (z3) {
                z4 = true;
            } else {
                z4 = id == R.id.interest_option_5;
            }
            if (z4) {
                z5 = true;
            } else if (id == R.id.interest_option_6) {
                z5 = true;
            }
            if (z5) {
                onClickOption(v);
            } else if (id == R.id.change_commit_btn) {
                onClickCommit(v);
            }
        }
    }

    private final void onClickOption(View v) {
        changeOptionStatus((TextView) v);
        changeCommitStatus();
    }

    private final void onClickCommit(View v) {
        if (this.selectedOptions.size() > 0) {
            commitPage();
        } else if (this.interestData.getInterestOptions().size() > 1) {
            nextPage();
        }
        Object systemService = getContext().getSystemService("vibrator");
        if (systemService != null) {
            new VibrateUtils.Builder((Vibrator) systemService, new long[]{30}, getContext()).amplitudes(new int[]{-1}).build().vibrateStart();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    }

    private final void commitPage() {
        IFeedTplContainer tplContainer;
        IFeedTplContainer feedTplContainer;
        FeedStatisticCenter.ubcInterestTpl("publish_clk", this.interestData.getUserProperty(), getSelectedOptions());
        assembleSelectedOptions();
        FeedTemplateImpl feedTemplateImpl = this.mFeedTemplateImplBase;
        if (!(feedTemplateImpl == null || (feedTplContainer = feedTemplateImpl.getFeedTplContainer()) == null)) {
            feedTplContainer.remove(this.interestModel);
        }
        FeedTemplateImpl feedTemplateImpl2 = this.mFeedTemplateImplBase;
        if (feedTemplateImpl2 != null && (tplContainer = feedTemplateImpl2.getFeedTplContainer()) != null) {
            if (!TextUtils.equals(this.interestData.getRefreshType(), "1") || !RefreshRevolutionary.isReformOpen() || !(tplContainer instanceof FeedRecyclerViewDelegate)) {
                tplContainer.handleAutoRefresh("4", true);
                return;
            }
            RefreshInfo refreshInfo = new RefreshInfo("23");
            refreshInfo.setReformRefreshTip(this.interestData.getRefreshTip());
            ((FeedRecyclerViewDelegate) tplContainer).handleNewRefresh(refreshInfo);
        }
    }

    private final void nextPage() {
        FeedItemDataInterest feedItemDataInterest = this.interestData;
        feedItemDataInterest.setCurrPage((feedItemDataInterest.getCurrPage() + 1) % this.interestData.getInterestOptions().size());
        updateContent();
        FeedStatisticCenter.ubcInterestTpl("change_clk", this.interestData.getUserProperty(), (JSONObject) null);
    }

    private final JSONObject getSelectedOptions() {
        JSONObject tagsObject = new JSONObject();
        JSONArray tagsArray = new JSONArray();
        try {
            for (FeedItemDataInterest.InterestOption option : this.selectedOptions) {
                JSONObject tag = new JSONObject();
                tag.put("tag", option.getDesc());
                tag.put("like", 1);
                tagsArray.put(tag);
            }
            tagsObject.put("tags", tagsArray);
            return tagsObject;
        } catch (JSONException e2) {
            return tagsObject;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = r0.runtimeStatus;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void assembleSelectedOptions() {
        /*
            r6 = this;
            java.util.List<com.baidu.searchbox.feed.model.FeedItemDataInterest$InterestOption> r0 = r6.selectedOptions
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0046
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r6.interestModel
            if (r0 == 0) goto L_0x0017
            com.baidu.searchbox.feed.model.FeedRuntimeStatus r0 = r0.runtimeStatus
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = r0.channelId
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0046
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.util.List<com.baidu.searchbox.feed.model.FeedItemDataInterest$InterestOption> r1 = r6.selectedOptions
            java.util.Iterator r1 = r1.iterator()
        L_0x002b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0043
            java.lang.Object r2 = r1.next()
            com.baidu.searchbox.feed.model.FeedItemDataInterest$InterestOption r2 = (com.baidu.searchbox.feed.model.FeedItemDataInterest.InterestOption) r2
            java.lang.String r3 = r2.getDesc()
            long r4 = r2.getSelectStamp()
            r0.put(r3, r4)
            goto L_0x002b
        L_0x0043:
            com.baidu.searchbox.feed.widget.interestselect.InterestModelManager.saveTplInterestOptions(r0)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.FeedInterestView.assembleSelectedOptions():void");
    }

    public void afterBindViewHolder(FeedBaseModel feedModel) {
        super.afterBindViewHolder(feedModel);
        if (!this.interestData.getDisplayed() && this.mFeedTemplateImplBase != null) {
            ViewGroup viewGroup = this.rootView;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
                viewGroup = null;
            }
            ViewTreeObserver viewTreeObserver = viewGroup.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnPreDrawListener(new FeedInterestView$afterBindViewHolder$1(this));
            }
        }
    }

    public boolean onTouch(View v, MotionEvent event) {
        boolean z = true;
        if (v != null && v.getId() == R.id.change_commit_btn) {
            TextView textView = null;
            Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                TextView textView2 = this.changeOrCommitBtn;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                } else {
                    textView = textView2;
                }
                textView.setAlpha(0.3f);
            } else {
                if ((valueOf == null || valueOf.intValue() != 1) && (valueOf == null || valueOf.intValue() != 3)) {
                    z = false;
                }
                if (z) {
                    TextView textView3 = this.changeOrCommitBtn;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
                    } else {
                        textView = textView3;
                    }
                    textView.setAlpha(1.0f);
                }
            }
        }
        return false;
    }

    public void onUnlike() {
        FeedStatisticCenter.ubcInterestTpl("close_clk", this.interestData.getUserProperty(), (JSONObject) null);
    }

    public void onFontSizeChanged() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        BdBaseImageView bdBaseImageView = this.titleIcon;
        if (bdBaseImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleIcon");
            bdBaseImageView = null;
        }
        FontSizeViewExtKt.setScaledHeightRes$default(bdBaseImageView, 0, com.baidu.searchbox.feed.core.R.dimen.dimens_14dp, 0, 4, (Object) null);
        BdBaseImageView bdBaseImageView2 = this.titleIcon;
        if (bdBaseImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleIcon");
            bdBaseImageView2 = null;
        }
        FontSizeViewExtKt.setScaledWidthRes$default(bdBaseImageView2, 0, com.baidu.searchbox.feed.core.R.dimen.dimens_57dp, 0, 4, (Object) null);
        BdBaseImageView bdBaseImageView3 = this.titleIcon;
        if (bdBaseImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleIcon");
            bdBaseImageView3 = null;
        }
        FontSizeImageViewExtKt.setScaledImageDrawableRes$default(bdBaseImageView3, 0, R.drawable.feed_interest_title_icon, 0, 4, (Object) null);
        TextView textView9 = this.titleView;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        } else {
            textView = textView9;
        }
        FontSizeTextViewExtKt.setScaledSize$default(textView, 0, 0, ViewExtensionsKt.getDimension(this, R.dimen.F_T_X002), 0, 8, (Object) null);
        ImageView imageView = this.dislikeView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dislikeView");
            imageView = null;
        }
        FeedOrderSenseUtil.setDislikePicture(imageView, 2, getFeedModel());
        TextView textView10 = this.optionView1;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView1");
            textView2 = null;
        } else {
            textView2 = textView10;
        }
        FontSizeTextViewExtKt.setScaledSize$default(textView2, 0, 0, ViewExtensionsKt.getDimension(this, R.dimen.F_T_X042), 0, 8, (Object) null);
        TextView textView11 = this.optionView2;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView2");
            textView3 = null;
        } else {
            textView3 = textView11;
        }
        FontSizeTextViewExtKt.setScaledSize$default(textView3, 0, 0, ViewExtensionsKt.getDimension(this, R.dimen.F_T_X042), 0, 8, (Object) null);
        TextView textView12 = this.optionView3;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView3");
            textView4 = null;
        } else {
            textView4 = textView12;
        }
        FontSizeTextViewExtKt.setScaledSize$default(textView4, 0, 0, ViewExtensionsKt.getDimension(this, R.dimen.F_T_X042), 0, 8, (Object) null);
        TextView textView13 = this.optionView4;
        if (textView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView4");
            textView5 = null;
        } else {
            textView5 = textView13;
        }
        FontSizeTextViewExtKt.setScaledSize$default(textView5, 0, 0, ViewExtensionsKt.getDimension(this, R.dimen.F_T_X042), 0, 8, (Object) null);
        TextView textView14 = this.optionView5;
        if (textView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView5");
            textView6 = null;
        } else {
            textView6 = textView14;
        }
        FontSizeTextViewExtKt.setScaledSize$default(textView6, 0, 0, ViewExtensionsKt.getDimension(this, R.dimen.F_T_X042), 0, 8, (Object) null);
        TextView textView15 = this.optionView6;
        if (textView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionView6");
            textView7 = null;
        } else {
            textView7 = textView15;
        }
        FontSizeTextViewExtKt.setScaledSize$default(textView7, 0, 0, ViewExtensionsKt.getDimension(this, R.dimen.F_T_X042), 0, 8, (Object) null);
        TextView textView16 = this.changeOrCommitBtn;
        if (textView16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeOrCommitBtn");
            textView8 = null;
        } else {
            textView8 = textView16;
        }
        FontSizeTextViewExtKt.setScaledSize$default(textView8, 0, 0, ViewExtensionsKt.getDimension(this, R.dimen.F_T_X042), 0, 8, (Object) null);
    }
}
