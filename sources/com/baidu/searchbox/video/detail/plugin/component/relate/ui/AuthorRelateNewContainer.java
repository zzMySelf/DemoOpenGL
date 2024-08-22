package com.baidu.searchbox.video.detail.plugin.component.relate.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.feed.styles.Font;
import com.baidu.searchbox.feed.styles.FontUtil;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.ui.UnifyTextView;
import com.baidu.searchbox.video.detail.plugin.component.relate.adapter.AuthorRelateNewAdapter;
import com.baidu.searchbox.video.detail.plugin.component.relate.model.AuthorRelateModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0007J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\b\u0010\u0016\u001a\u00020\u000eH\u0003R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/relate/ui/AuthorRelateNewContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAuthorTV", "Lcom/baidu/searchbox/ui/UnifyTextView;", "mRelateAdapter", "Lcom/baidu/searchbox/video/detail/plugin/component/relate/adapter/AuthorRelateNewAdapter;", "createListView", "", "models", "", "Lcom/baidu/searchbox/video/detail/plugin/component/relate/model/AuthorRelateModel;", "createTopView", "initViews", "onNightModeChanged", "updateByRelates", "updateTopViewsStyle", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorRelateNewContainer.kt */
public final class AuthorRelateNewContainer extends RelativeLayout {
    private UnifyTextView mAuthorTV;
    private AuthorRelateNewAdapter mRelateAdapter;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthorRelateNewContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthorRelateNewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthorRelateNewContainer(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthorRelateNewContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initViews(Context context, List<? extends AuthorRelateModel> models) {
        removeAllViews();
        setPadding(0, context.getResources().getDimensionPixelSize(R.dimen.F_M_H_X02500002), 0, 0);
        createTopView(context);
        createListView(context, models);
        updateTopViewsStyle();
    }

    private final void createListView(Context context, List<? extends AuthorRelateModel> models) {
        RecyclerView mRelateListView = new RecyclerView(context);
        mRelateListView.setVerticalScrollBarEnabled(false);
        mRelateListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        mRelateListView.addItemDecoration(new AuthorRelateNewItemDecoration(context));
        AuthorRelateNewAdapter authorRelateNewAdapter = new AuthorRelateNewAdapter(models);
        this.mRelateAdapter = authorRelateNewAdapter;
        mRelateListView.setAdapter(authorRelateNewAdapter);
        RelativeLayout.LayoutParams listlp = new RelativeLayout.LayoutParams(-1, -2);
        UnifyTextView unifyTextView = this.mAuthorTV;
        if (unifyTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
            unifyTextView = null;
        }
        listlp.addRule(3, unifyTextView.getId());
        addView(mRelateListView, listlp);
    }

    private final void createTopView(Context context) {
        int lrp = context.getResources().getDimensionPixelSize(R.dimen.F_M_H_X066);
        this.mAuthorTV = new UnifyTextView(context);
        RelativeLayout.LayoutParams authorTVlp = new RelativeLayout.LayoutParams(-2, -2);
        authorTVlp.setMargins(lrp, 0, 0, 0);
        UnifyTextView unifyTextView = this.mAuthorTV;
        UnifyTextView unifyTextView2 = null;
        if (unifyTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
            unifyTextView = null;
        }
        unifyTextView.setLayoutParams(authorTVlp);
        if (Build.VERSION.SDK_INT >= 17) {
            UnifyTextView unifyTextView3 = this.mAuthorTV;
            if (unifyTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
                unifyTextView3 = null;
            }
            unifyTextView3.setId(ViewCompat.generateViewId());
        } else {
            UnifyTextView unifyTextView4 = this.mAuthorTV;
            if (unifyTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
                unifyTextView4 = null;
            }
            unifyTextView4.setId(com.baidu.searchbox.video.detail.business.R.id.video_payment_author_relate_title);
        }
        UnifyTextView unifyTextView5 = this.mAuthorTV;
        if (unifyTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
            unifyTextView5 = null;
        }
        unifyTextView5.setTopPadding(0);
        UnifyTextView unifyTextView6 = this.mAuthorTV;
        if (unifyTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
            unifyTextView6 = null;
        }
        unifyTextView6.setBottomPadding(0);
        UnifyTextView unifyTextView7 = this.mAuthorTV;
        if (unifyTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
            unifyTextView7 = null;
        }
        unifyTextView7.setTextWithUnifiedPadding(context.getResources().getString(com.baidu.searchbox.video.detail.business.R.string.video_detail_author_relate_title), TextView.BufferType.NORMAL);
        UnifyTextView unifyTextView8 = this.mAuthorTV;
        if (unifyTextView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
        } else {
            unifyTextView2 = unifyTextView8;
        }
        addView(unifyTextView2, authorTVlp);
    }

    private final void updateTopViewsStyle() {
        if (this.mAuthorTV != null) {
            Resources res = getContext().getResources();
            float fs = (float) res.getDimensionPixelOffset(R.dimen.F_T_X054);
            UnifyTextView unifyTextView = this.mAuthorTV;
            UnifyTextView unifyTextView2 = null;
            if (unifyTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
                unifyTextView = null;
            }
            unifyTextView.setTextSize(0, fs);
            UnifyTextView unifyTextView3 = this.mAuthorTV;
            if (unifyTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
                unifyTextView3 = null;
            }
            unifyTextView3.setTextColor(res.getColor(com.baidu.android.common.ui.style.R.color.GC1));
            UnifyTextView unifyTextView4 = this.mAuthorTV;
            if (unifyTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAuthorTV");
            } else {
                unifyTextView2 = unifyTextView4;
            }
            FontUtil.setFont(unifyTextView2, Font.F_F_X02);
            Bitmap bitmap = BitmapFactory.decodeResource(res, com.baidu.searchbox.video.detail.business.R.drawable.video_payment_title_more);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(res, bitmap);
            BitmapDrawable bitmapDrawableAlpha = new BitmapDrawable(res, bitmap);
            bitmapDrawableAlpha.setAlpha(51);
            StateListDrawable drawable = new StateListDrawable();
            drawable.addState(new int[]{-16842919}, bitmapDrawable);
            drawable.addState(new int[]{16842919}, bitmapDrawableAlpha);
        }
    }

    public final void updateByRelates(List<? extends AuthorRelateModel> models) {
        Intrinsics.checkNotNullParameter(models, "models");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        initViews(context, models);
    }

    public final void onNightModeChanged() {
        updateTopViewsStyle();
        AuthorRelateNewAdapter authorRelateNewAdapter = this.mRelateAdapter;
        if (authorRelateNewAdapter != null) {
            if (authorRelateNewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRelateAdapter");
                authorRelateNewAdapter = null;
            }
            authorRelateNewAdapter.notifyDataSetChanged();
        }
    }
}
