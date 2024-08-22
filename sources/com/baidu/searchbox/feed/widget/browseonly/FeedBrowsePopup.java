package com.baidu.searchbox.feed.widget.browseonly;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.browser.explore.toptip.TopTipConstantKt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.styles.Font;
import com.baidu.searchbox.feed.styles.FontUtil;
import com.baidu.searchbox.feed.widget.FeedBaseBottomPopup;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.text.LinkTextManager;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0005)*+,-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0002J\u000e\u0010&\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup;", "Lcom/baidu/searchbox/feed/widget/FeedBaseBottomPopup;", "ctx", "Landroid/content/Context;", "parentView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "closeButton", "Landroid/widget/ImageView;", "confirmButton", "Landroid/widget/TextView;", "confirmButtonBgDrawable", "confirmButtonContainer", "Landroid/widget/FrameLayout;", "confirmListener", "Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup$OnPopupConfirmListener;", "data", "Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowseGuideData;", "gradientBgDrawable", "gradientView", "interestRv", "Landroidx/recyclerview/widget/RecyclerView;", "linkTextManager", "Lcom/baidu/searchbox/text/LinkTextManager;", "popupTitle", "privacyTitle", "rvAdapter", "Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup$FeedBrowserGuideAdapter;", "getContent", "parent", "Landroid/view/ViewGroup;", "onClick", "", "v", "onMaskClick", "setConfirmButtonStyle", "setData", "setOnConfirmDismissListener", "listener", "Companion", "FeedBrowserGuideAdapter", "FeedBrowserGuideVH", "GridItemDecoration", "OnPopupConfirmListener", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBrowsePopup.kt */
public final class FeedBrowsePopup extends FeedBaseBottomPopup {
    private static final int BROWSE_GUIDE_COLUMN = 2;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FeedBrowsePopup";
    /* access modifiers changed from: private */
    public static Map<String, Long> paramMap = new LinkedHashMap();
    private GradientDrawable bgDrawable;
    private ImageView closeButton;
    private TextView confirmButton;
    private GradientDrawable confirmButtonBgDrawable;
    private FrameLayout confirmButtonContainer;
    private OnPopupConfirmListener confirmListener;
    private FeedBrowseGuideData data;
    private GradientDrawable gradientBgDrawable;
    private View gradientView;
    private RecyclerView interestRv;
    private LinkTextManager linkTextManager;
    private TextView popupTitle;
    private TextView privacyTitle;
    private FeedBrowserGuideAdapter rvAdapter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup$OnPopupConfirmListener;", "", "onConfirm", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedBrowsePopup.kt */
    public interface OnPopupConfirmListener {
        void onConfirm();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBrowsePopup(Context ctx, View parentView) {
        super(ctx, parentView);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
    }

    public View getContent(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        FrameLayout frameLayout = null;
        View inflate = View.inflate(getContext(), R.layout.feed_privacy_pop_layout, (ViewGroup) null);
        View $this$getContent_u24lambda_u2d1 = inflate;
        Drawable drawable = $this$getContent_u24lambda_u2d1.getContext().getResources().getDrawable(R.drawable.feed_browse_guide_content_bg);
        if (drawable != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            this.bgDrawable = gradientDrawable;
            if (gradientDrawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgDrawable");
                gradientDrawable = null;
            }
            $this$getContent_u24lambda_u2d1.setBackground(gradientDrawable);
            GradientDrawable gradientDrawable2 = this.bgDrawable;
            if (gradientDrawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgDrawable");
                gradientDrawable2 = null;
            }
            gradientDrawable2.setColor($this$getContent_u24lambda_u2d1.getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC173));
            View findViewById = $this$getContent_u24lambda_u2d1.findViewById(R.id.feed_browse_interest_rv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.feed_browse_interest_rv)");
            this.interestRv = (RecyclerView) findViewById;
            View findViewById2 = $this$getContent_u24lambda_u2d1.findViewById(R.id.close);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.close)");
            ImageView imageView = (ImageView) findViewById2;
            this.closeButton = imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeButton");
                imageView = null;
            }
            imageView.setOnTouchListener(new TouchStateListener());
            ImageView imageView2 = this.closeButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeButton");
                imageView2 = null;
            }
            ExpandTouchAreaHelper.expandTouchArea($this$getContent_u24lambda_u2d1, imageView2, 0, 0, BdPlayerUtils.dp2px($this$getContent_u24lambda_u2d1, 16.0f), BdPlayerUtils.dp2px($this$getContent_u24lambda_u2d1, 16.0f));
            View findViewById3 = $this$getContent_u24lambda_u2d1.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.title)");
            TextView textView = (TextView) findViewById3;
            this.popupTitle = textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupTitle");
                textView = null;
            }
            FontUtil.setFont(textView, Font.F_F_X01);
            View findViewById4 = $this$getContent_u24lambda_u2d1.findViewById(R.id.privacy_text);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.privacy_text)");
            TextView textView2 = (TextView) findViewById4;
            this.privacyTitle = textView2;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyTitle");
                textView2 = null;
            }
            textView2.setTextColor($this$getContent_u24lambda_u2d1.getContext().getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC2));
            View findViewById5 = $this$getContent_u24lambda_u2d1.findViewById(R.id.gradient_view);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.gradient_view)");
            this.gradientView = findViewById5;
            Drawable drawable2 = $this$getContent_u24lambda_u2d1.getContext().getResources().getDrawable(R.drawable.feed_browse_guide_gradient);
            if (drawable2 != null) {
                this.gradientBgDrawable = (GradientDrawable) drawable2;
                View view2 = this.gradientView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gradientView");
                    view2 = null;
                }
                GradientDrawable gradientDrawable3 = this.gradientBgDrawable;
                if (gradientDrawable3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gradientBgDrawable");
                    gradientDrawable3 = null;
                }
                view2.setBackground(gradientDrawable3);
                int[] colors = {$this$getContent_u24lambda_u2d1.getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC173), $this$getContent_u24lambda_u2d1.getResources().getColor(R.color.feed_transparent_color)};
                GradientDrawable gradientDrawable4 = this.gradientBgDrawable;
                if (gradientDrawable4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gradientBgDrawable");
                    gradientDrawable4 = null;
                }
                gradientDrawable4.setColors(colors);
                String content = $this$getContent_u24lambda_u2d1.getResources().getString(R.string.privacy_operation_guide_prefix) + $this$getContent_u24lambda_u2d1.getResources().getString(com.baidu.searchbox.oem.privacy.R.string.androidm_warmalarm_exp_privacy_mode_common);
                LinkTextManager feedBrowseLinkTextManager = new FeedBrowseLinkTextManager();
                this.linkTextManager = feedBrowseLinkTextManager;
                TextView textView3 = this.privacyTitle;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("privacyTitle");
                    textView3 = null;
                }
                feedBrowseLinkTextManager.apply(textView3, content);
                View findViewById6 = $this$getContent_u24lambda_u2d1.findViewById(R.id.ok_button);
                Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ok_button)");
                this.confirmButton = (TextView) findViewById6;
                View findViewById7 = $this$getContent_u24lambda_u2d1.findViewById(R.id.ok_button_container);
                Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.ok_button_container)");
                this.confirmButtonContainer = (FrameLayout) findViewById7;
                setConfirmButtonStyle();
                TextView textView4 = this.popupTitle;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popupTitle");
                    textView4 = null;
                }
                textView4.setTextColor($this$getContent_u24lambda_u2d1.getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC3));
                ImageView imageView3 = this.closeButton;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("closeButton");
                    imageView3 = null;
                }
                imageView3.setOnClickListener(new FeedBrowsePopup$$ExternalSyntheticLambda0(this));
                FrameLayout frameLayout2 = this.confirmButtonContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmButtonContainer");
                    frameLayout2 = null;
                }
                frameLayout2.setOnTouchListener(new TouchStateListener());
                FrameLayout frameLayout3 = this.confirmButtonContainer;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmButtonContainer");
                } else {
                    frameLayout = frameLayout3;
                }
                frameLayout.setOnClickListener(this);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou…eedBrowsePopup)\n        }");
                return inflate;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    /* access modifiers changed from: private */
    /* renamed from: getContent$lambda-1$lambda-0  reason: not valid java name */
    public static final void m19742getContent$lambda1$lambda0(FeedBrowsePopup this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissPopup();
        FeedBrowseGuideStatistic.INSTANCE.guideWindowClose("close_clk");
        paramMap.clear();
    }

    private final void setConfirmButtonStyle() {
        FrameLayout frameLayout = this.confirmButtonContainer;
        TextView textView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButtonContainer");
            frameLayout = null;
        }
        frameLayout.setBackground(getContext().getResources().getDrawable(R.drawable.feed_browse_guide_ok_bg));
        TextView textView2 = this.confirmButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
            textView2 = null;
        }
        FontUtil.setFont(textView2, Font.F_F_X02);
        TextView textView3 = this.confirmButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        } else {
            textView = textView3;
        }
        textView.setTextColor(getContext().getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC109));
    }

    public void onMaskClick() {
        dismissPopup();
        FeedBrowseGuideStatistic.INSTANCE.guideWindowClose("down");
        paramMap.clear();
    }

    public final void setData(FeedBrowseGuideData data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
        TextView textView = this.popupTitle;
        FeedBrowserGuideAdapter feedBrowserGuideAdapter = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupTitle");
            textView = null;
        }
        textView.setText(data2.getTitle());
        TextView textView2 = this.confirmButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
            textView2 = null;
        }
        textView2.setText(data2.getButtonText());
        this.rvAdapter = new FeedBrowserGuideAdapter(getContext(), data2.getItems());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        RecyclerView recyclerView = this.interestRv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interestRv");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView2 = this.interestRv;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interestRv");
            recyclerView2 = null;
        }
        recyclerView2.addItemDecoration(new GridItemDecoration(getContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X051) / 2, getContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X067), data2.getItems().size()));
        RecyclerView recyclerView3 = this.interestRv;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interestRv");
            recyclerView3 = null;
        }
        FeedBrowserGuideAdapter feedBrowserGuideAdapter2 = this.rvAdapter;
        if (feedBrowserGuideAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
        } else {
            feedBrowserGuideAdapter = feedBrowserGuideAdapter2;
        }
        recyclerView3.setAdapter(feedBrowserGuideAdapter);
    }

    public final void setOnConfirmDismissListener(OnPopupConfirmListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.confirmListener = listener;
    }

    public void onClick(View v) {
        OnPopupConfirmListener onPopupConfirmListener;
        super.onClick(v);
        FrameLayout frameLayout = this.confirmButtonContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButtonContainer");
            frameLayout = null;
        }
        if (Intrinsics.areEqual((Object) v, (Object) frameLayout) && (onPopupConfirmListener = this.confirmListener) != null) {
            onPopupConfirmListener.onConfirm();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup$GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "hSpacing", "", "vSpacing", "size", "(Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup;III)V", "getHSpacing", "()I", "getSize", "getVSpacing", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedBrowsePopup.kt */
    public final class GridItemDecoration extends RecyclerView.ItemDecoration {
        private final int hSpacing;
        private final int size;
        private final int vSpacing;

        public GridItemDecoration(int hSpacing2, int vSpacing2, int size2) {
            this.hSpacing = hSpacing2;
            this.vSpacing = vSpacing2;
            this.size = size2;
        }

        public final int getHSpacing() {
            return this.hSpacing;
        }

        public final int getSize() {
            return this.size;
        }

        public final int getVSpacing() {
            return this.vSpacing;
        }

        public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
            Intrinsics.checkNotNullParameter(state, "state");
            int position = parent.getChildAdapterPosition(view2);
            int curColumn = position % 2;
            boolean lastLine = true;
            if ((position / 2) + 1 < (this.size + 1) / 2) {
                lastLine = false;
            }
            if (curColumn == 0) {
                outRect.right = this.hSpacing;
            } else {
                outRect.left = this.hSpacing;
            }
            if (!lastLine) {
                outRect.bottom = this.vSpacing;
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup$FeedBrowserGuideAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup$FeedBrowserGuideVH;", "context", "Landroid/content/Context;", "items", "", "Lcom/baidu/searchbox/feed/widget/browseonly/BrowseGuideItemData;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedBrowsePopup.kt */
    public static final class FeedBrowserGuideAdapter extends RecyclerView.Adapter<FeedBrowserGuideVH> {
        private final Context context;
        /* access modifiers changed from: private */
        public final List<BrowseGuideItemData> items;

        public FeedBrowserGuideAdapter(Context context2, List<BrowseGuideItemData> items2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(items2, "items");
            this.context = context2;
            this.items = items2;
            FeedBrowsePopup.Companion.getParamMap().put(items2.get(0).getTitle(), Long.valueOf(System.currentTimeMillis()));
        }

        public FeedBrowserGuideVH onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
            FeedBrowseGuideItemView view2 = new FeedBrowseGuideItemView(this.context);
            view2.setOnItemClickListener(new FeedBrowsePopup$FeedBrowserGuideAdapter$onCreateViewHolder$1(this));
            return new FeedBrowserGuideVH(view2);
        }

        public int getItemCount() {
            return this.items.size();
        }

        public void onBindViewHolder(FeedBrowserGuideVH holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            FeedBrowseGuideItemView itemView = (FeedBrowseGuideItemView) holder.itemView;
            itemView.setPosition(position);
            BrowseGuideItemData data = this.items.get(position);
            if (data != null) {
                data.setChecked(position == 0);
                itemView.updateContent(data);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup$FeedBrowserGuideVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedBrowsePopup.kt */
    public static final class FeedBrowserGuideVH extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedBrowserGuideVH(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/feed/widget/browseonly/FeedBrowsePopup$Companion;", "", "()V", "BROWSE_GUIDE_COLUMN", "", "TAG", "", "paramMap", "", "", "getParamMap", "()Ljava/util/Map;", "setParamMap", "(Ljava/util/Map;)V", "getBrowseOnlyPostJson", "Lorg/json/JSONObject;", "setBrowseOnlyPostParams", "", "dataJson", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedBrowsePopup.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Long> getParamMap() {
            return FeedBrowsePopup.paramMap;
        }

        public final void setParamMap(Map<String, Long> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            FeedBrowsePopup.paramMap = map;
        }

        public final void setBrowseOnlyPostParams(JSONObject dataJson) {
            Intrinsics.checkNotNullParameter(dataJson, TopTipConstantKt.DATA_JSON);
            JSONObject browseParam = getBrowseOnlyPostJson();
            if (FeedRuntime.GLOBAL_DEBUG) {
                Log.d(FeedBrowsePopup.TAG, "browseParam: " + browseParam);
            }
            if (browseParam != null) {
                try {
                    dataJson.put("user_attention_refresh_tips", "1");
                    dataJson.put("user_attention_weight", browseParam);
                } catch (JSONException e2) {
                }
                getParamMap().clear();
            }
        }

        private final JSONObject getBrowseOnlyPostJson() {
            if (getParamMap().isEmpty()) {
                return null;
            }
            try {
                JSONObject jsonObject = new JSONObject();
                for (Map.Entry next : getParamMap().entrySet()) {
                    jsonObject.put((String) next.getKey(), ((Number) next.getValue()).longValue());
                }
                if (jsonObject.length() > 0) {
                    return jsonObject;
                }
                return null;
            } catch (JSONException e2) {
            }
        }
    }
}
