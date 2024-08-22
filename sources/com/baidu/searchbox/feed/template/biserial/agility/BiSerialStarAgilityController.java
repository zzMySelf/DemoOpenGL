package com.baidu.searchbox.feed.template.biserial.agility;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.biserial.bean.FeedBiSerialAgilityData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.template.biserial.BiSerialItemBgRes;
import com.baidu.searchbox.feed.template.biserial.FeedBiserialScreenUtil;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.layout.GenFrameLayout;
import com.baidu.searchbox.layout.LayoutKt;
import com.baidu.searchbox.ui.BdBaseLottieView;
import com.baidu.searchbox.ui.UnifyTextView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u00015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J$\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0015H\u0016J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0019H\u0016J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u00100\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u000eH\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0017H\u0016J\b\u00104\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012¨\u00066"}, d2 = {"Lcom/baidu/searchbox/feed/template/biserial/agility/BiSerialStarAgilityController;", "Lcom/baidu/searchbox/feed/template/biserial/agility/BaseBiSerialAgilityController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animToken", "Ljava/lang/Object;", "descView", "Lcom/baidu/searchbox/ui/UnifyTextView;", "getDescView", "()Lcom/baidu/searchbox/ui/UnifyTextView;", "descView$delegate", "Lkotlin/Lazy;", "hasInitLottieSize", "", "lottieView", "Lcom/baidu/searchbox/ui/BdBaseLottieView;", "getLottieView", "()Lcom/baidu/searchbox/ui/BdBaseLottieView;", "lottieView$delegate", "changeDesc", "", "clickPosition", "", "createStarItemView", "Landroid/view/View;", "getCustomRequestParams", "Lorg/json/JSONObject;", "position", "getDescColorRes", "getDescText", "", "getItemSize", "getScoreByPosition", "initLottieSizeIfNeed", "makeLottieGone", "onCreateItemView", "onCreateView", "feedBaseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "agilityData", "Lcom/baidu/searchbox/feed/biserial/bean/FeedBiSerialAgilityData;", "agilityType", "Lcom/baidu/searchbox/feed/template/biserial/agility/AgilityType;", "onFontSizeChange", "onItemClicked", "itemView", "showLottieAnim", "updateItemViewUi", "isSelectedState", "updateItemViewsUi", "selectedPos", "updateUi", "ItemViewHolder", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialStarAgilityController.kt */
public final class BiSerialStarAgilityController extends BaseBiSerialAgilityController {
    private final Object animToken = new Object();
    private final Lazy descView$delegate;
    private boolean hasInitLottieSize;
    private final Lazy lottieView$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BiSerialStarAgilityController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.descView$delegate = LazyKt.lazy(new BiSerialStarAgilityController$descView$2(context, this));
        this.lottieView$delegate = LazyKt.lazy(new BiSerialStarAgilityController$lottieView$2(context));
    }

    private final UnifyTextView getDescView() {
        return (UnifyTextView) this.descView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final int getDescColorRes() {
        FeedBiSerialAgilityData agilityData = getAgilityData();
        return (agilityData != null ? agilityData.getLastClickedPosition() : -1) >= 0 ? isAfterReading() ? R.color.FC6 : R.color.FC1 : isAfterReading() ? R.color.FC6 : R.color.FC4;
    }

    /* access modifiers changed from: private */
    public final String getDescText() {
        String subTitle;
        List<FeedBiSerialAgilityData.ItemData> itemList;
        FeedBiSerialAgilityData.ItemData itemData;
        String desc;
        FeedBiSerialAgilityData agilityData = getAgilityData();
        int clickPos = agilityData != null ? agilityData.getLastClickedPosition() : -1;
        if (clickPos >= 0) {
            FeedBiSerialAgilityData agilityData2 = getAgilityData();
            if (agilityData2 == null || (itemList = agilityData2.getItemList()) == null || (itemData = itemList.get(clickPos)) == null || (desc = itemData.getDesc()) == null) {
                return "";
            }
            return desc;
        }
        FeedBiSerialAgilityData agilityData3 = getAgilityData();
        if (agilityData3 == null || (subTitle = agilityData3.getSubTitle()) == null) {
            return "";
        }
        return subTitle;
    }

    private final BdBaseLottieView getLottieView() {
        return (BdBaseLottieView) this.lottieView$delegate.getValue();
    }

    public View onCreateView(FeedBaseModel feedBaseModel, FeedBiSerialAgilityData agilityData, AgilityType agilityType) {
        Intrinsics.checkNotNullParameter(feedBaseModel, "feedBaseModel");
        ViewGroup rootView = (ViewGroup) super.onCreateView(feedBaseModel, agilityData, agilityType);
        LinearLayout agilityContentContainer = getAgilityContentContainer();
        if (agilityContentContainer != null) {
            agilityContentContainer.addView(getDescView());
        }
        rootView.addView(getLottieView());
        return rootView;
    }

    public View onCreateItemView(int position) {
        View itemView = createStarItemView();
        FeedBiSerialAgilityData agilityData = getAgilityData();
        updateItemViewUi(position, itemView, position <= (agilityData != null ? agilityData.getLastClickedPosition() : -1));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
        float marginLeft = ((FeedBiserialScreenUtil.INSTANCE.getTemplateWidth(getContext()) - ((float) (ViewExtensionsKt.getDimensionPixelSize(itemView, R.dimen.F_M_W_X302) * 2))) - ((float) (getItemSize() * 5))) / ((float) 4);
        if (position != 0) {
            lp.leftMargin = (int) marginLeft;
        }
        itemView.setLayoutParams(lp);
        return itemView;
    }

    private final View createStarItemView() {
        int itemSize = getItemSize();
        GenFrameLayout genFrameLayout = new GenFrameLayout(getContext());
        GenFrameLayout $this$createStarItemView_u24lambda_u2d0 = genFrameLayout;
        $this$createStarItemView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutKt.bdBaseLottieView($this$createStarItemView_u24lambda_u2d0, new BiSerialStarAgilityController$createStarItemView$1$1(itemSize));
        return genFrameLayout;
    }

    private final int getItemSize() {
        return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(isRelation() ? com.baidu.searchbox.feed.template.R.dimen.feed_biserial_agility_star_template_size : com.baidu.searchbox.feed.template.R.dimen.feed_biserial_agility_star_size);
    }

    public JSONObject getCustomRequestParams(int position) {
        return null;
    }

    public String getScoreByPosition(int position) {
        return String.valueOf(position + 1);
    }

    public void updateItemViewsUi(int selectedPos) {
        FeedBiSerialAgilityData it = getAgilityData();
        if (it != null) {
            int i2 = 0;
            int size = it.getItemList().size();
            while (i2 < size) {
                View $this$updateItemViewsUi_u24lambda_u2d2_u24lambda_u2d1 = getItemView(i2);
                if ($this$updateItemViewsUi_u24lambda_u2d2_u24lambda_u2d1 != null) {
                    updateItemViewUi(i2, $this$updateItemViewsUi_u24lambda_u2d2_u24lambda_u2d1, i2 <= selectedPos);
                }
                i2++;
            }
        }
    }

    public void onItemClicked(int position, View itemView) {
        boolean isFirstClick;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        FeedBiSerialAgilityData $this$onItemClicked_u24lambda_u2d4 = getAgilityData();
        if ($this$onItemClicked_u24lambda_u2d4 != null && position != $this$onItemClicked_u24lambda_u2d4.getLastClickedPosition()) {
            int i2 = position + 1;
            int size = $this$onItemClicked_u24lambda_u2d4.getItemList().size();
            while (true) {
                isFirstClick = false;
                if (i2 >= size) {
                    break;
                }
                View it = getItemView(i2);
                if (it != null) {
                    updateItemViewUi(i2, it, false);
                }
                i2++;
            }
            showLottieAnim(position);
            changeDesc(position);
            if ($this$onItemClicked_u24lambda_u2d4.getLastClickedPosition() == -1) {
                isFirstClick = true;
            }
            showInvestToast(isFirstClick);
            startVibrator();
            requestAgility(position);
        }
    }

    public void onFontSizeChange() {
        super.onFontSizeChange();
        FontSizeTextViewExtKt.setScaledSizeRes$default(getDescView(), 0, isRelation() ? R.dimen.F_T_X301 : R.dimen.F_T_X058, 0, 4, (Object) null);
        makeLottieGone();
    }

    public void updateUi() {
        super.updateUi();
        ImageView agilityBg = getAgilityBg();
        if (agilityBg != null) {
            ViewExtensionsKt.setDrawableRes(agilityBg, BiSerialItemBgRes.INSTANCE.getEPStyleAgilityYellowBgRes());
        }
        ViewExtensionsKt.setTextColorRes(getDescView(), getDescColorRes());
    }

    private final void updateItemViewUi(int position, View itemView, boolean isSelectedState) {
        if (getItemData(position) != null) {
            ItemViewHolder $this$updateItemViewUi_u24lambda_u2d6_u24lambda_u2d5 = new ItemViewHolder(itemView);
            if (isSelectedState) {
                ViewExtensionsKt.setDrawableRes($this$updateItemViewUi_u24lambda_u2d6_u24lambda_u2d5.getAgilityStarLottie(), com.baidu.searchbox.feed.template.R.drawable.feed_biserial_star_agility_selected);
            } else {
                ViewExtensionsKt.setDrawableRes($this$updateItemViewUi_u24lambda_u2d6_u24lambda_u2d5.getAgilityStarLottie(), com.baidu.searchbox.feed.template.R.drawable.feed_biserial_star_agility_unselected);
            }
        }
    }

    private final void changeDesc(int clickPosition) {
        List<FeedBiSerialAgilityData.ItemData> itemList;
        FeedBiSerialAgilityData.ItemData it;
        int i2;
        FeedBiSerialAgilityData agilityData = getAgilityData();
        if (agilityData != null && (itemList = agilityData.getItemList()) != null && (it = itemList.get(clickPosition)) != null) {
            UnifyTextView $this$changeDesc_u24lambda_u2d8_u24lambda_u2d7 = getDescView();
            $this$changeDesc_u24lambda_u2d8_u24lambda_u2d7.setTextWithUnifiedPadding(it.getDesc(), TextView.BufferType.NORMAL);
            TextView textView = $this$changeDesc_u24lambda_u2d8_u24lambda_u2d7;
            if (isAfterReading()) {
                i2 = R.color.FC6;
            } else {
                i2 = R.color.FC1;
            }
            ViewExtensionsKt.setTextColorRes(textView, i2);
        }
    }

    private final void showLottieAnim(int clickPosition) {
        int i2 = clickPosition;
        UiThreadUtils.getMainHandler().removeCallbacksAndMessages((Object) null);
        if (0 <= i2) {
            int i3 = 0;
            while (true) {
                View itemView = getItemView(i3);
                if (itemView != null) {
                    View itemView2 = itemView;
                    FeedBiSerialAgilityData.ItemData itemData = getItemData(i3);
                    if (itemData != null) {
                        FeedBiSerialAgilityData.ItemData itemData2 = itemData;
                        ItemViewHolder itemViewHolder = new ItemViewHolder(itemView2);
                        if (itemData2.getLottieUrl().length() > 0) {
                            BiSerialStarAgilityController$$ExternalSyntheticLambda1 biSerialStarAgilityController$$ExternalSyntheticLambda1 = r0;
                            Handler mainHandler = UiThreadUtils.getMainHandler();
                            BiSerialStarAgilityController$$ExternalSyntheticLambda1 biSerialStarAgilityController$$ExternalSyntheticLambda12 = new BiSerialStarAgilityController$$ExternalSyntheticLambda1(this, itemViewHolder, itemData2, i3, itemView2);
                            mainHandler.postDelayed(biSerialStarAgilityController$$ExternalSyntheticLambda1, ((long) i3) * 60);
                        } else {
                            ViewExtensionsKt.setDrawableRes(itemViewHolder.getAgilityStarLottie(), com.baidu.searchbox.feed.template.R.drawable.feed_biserial_star_agility_selected);
                        }
                        if (itemData2.getAddLottieUrl().length() > 0) {
                            initLottieSizeIfNeed();
                            UiThreadUtils.getMainHandler().postDelayed(new BiSerialStarAgilityController$$ExternalSyntheticLambda2(this, itemData2), ((long) i3) * 60);
                        }
                    }
                }
                if (i3 != i2) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showLottieAnim$lambda-14$lambda-13$lambda-10  reason: not valid java name */
    public static final void m19552showLottieAnim$lambda14$lambda13$lambda10(BiSerialStarAgilityController this$0, ItemViewHolder $itemViewHolder, FeedBiSerialAgilityData.ItemData $itemData, int $i, View $itemView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($itemViewHolder, "$itemViewHolder");
        Intrinsics.checkNotNullParameter($itemData, "$itemData");
        Intrinsics.checkNotNullParameter($itemView, "$itemView");
        BdBaseLottieView agilityStarLottie = $itemViewHolder.getAgilityStarLottie();
        Intrinsics.checkNotNullExpressionValue(agilityStarLottie, "itemViewHolder.agilityStarLottie");
        this$0.loadLottie(agilityStarLottie, $itemData.getLottieUrl(), new BiSerialStarAgilityController$$ExternalSyntheticLambda0(this$0, $i, $itemView));
    }

    /* access modifiers changed from: private */
    /* renamed from: showLottieAnim$lambda-14$lambda-13$lambda-10$lambda-9  reason: not valid java name */
    public static final void m19553showLottieAnim$lambda14$lambda13$lambda10$lambda9(BiSerialStarAgilityController this$0, int $i, View $itemView, Throwable it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($itemView, "$itemView");
        this$0.updateItemViewUi($i, $itemView, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: showLottieAnim$lambda-14$lambda-13$lambda-12  reason: not valid java name */
    public static final void m19554showLottieAnim$lambda14$lambda13$lambda12(BiSerialStarAgilityController this$0, FeedBiSerialAgilityData.ItemData $itemData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($itemData, "$itemData");
        this$0.getLottieView().setVisibility(0);
        BaseBiSerialAgilityController.loadLottie$default(this$0, this$0.getLottieView(), $itemData.getAddLottieUrl(), (LottieListener) null, 4, (Object) null);
    }

    private final void initLottieSizeIfNeed() {
        if (!this.hasInitLottieSize) {
            this.hasInitLottieSize = true;
            View rootView = getRootView();
            int height = 0;
            int width = rootView != null ? rootView.getMeasuredWidth() : 0;
            View rootView2 = getRootView();
            if (rootView2 != null) {
                height = rootView2.getMeasuredHeight();
            }
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(width, height);
            lp.gravity = 16;
            getLottieView().setLayoutParams(lp);
        }
    }

    private final void makeLottieGone() {
        this.hasInitLottieSize = false;
        getLottieView().setVisibility(8);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/template/biserial/agility/BiSerialStarAgilityController$ItemViewHolder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "agilityStarLottie", "Lcom/baidu/searchbox/ui/BdBaseLottieView;", "kotlin.jvm.PlatformType", "getAgilityStarLottie", "()Lcom/baidu/searchbox/ui/BdBaseLottieView;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialStarAgilityController.kt */
    private static final class ItemViewHolder {
        private final BdBaseLottieView agilityStarLottie;

        public ItemViewHolder(View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.agilityStarLottie = (BdBaseLottieView) itemView.findViewById(com.baidu.searchbox.feed.template.R.id.agility_star_lottie);
        }

        public final BdBaseLottieView getAgilityStarLottie() {
            return this.agilityStarLottie;
        }
    }
}
