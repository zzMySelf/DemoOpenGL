package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.template.specbase.FeedSpecTplImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0015J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aH\u0016J0\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001e\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedSearchBackView;", "Lcom/baidu/searchbox/feed/template/specbase/FeedSpecTplImpl;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackText", "Landroid/widget/TextView;", "mDislikeIcon", "Landroid/widget/ImageView;", "mQueryText", "mResultText", "mSearchContent", "Landroid/widget/LinearLayout;", "mSearchIcon", "doCreateView", "Landroid/view/View;", "initInflate", "inflater", "Landroid/view/LayoutInflater;", "root", "Landroid/view/ViewGroup;", "update", "", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "options", "", "", "", "query", "updateUI", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedSearchBackView.kt */
public final class FeedSearchBackView extends FeedSpecTplImpl {
    private TextView mBackText;
    private ImageView mDislikeIcon;
    private TextView mQueryText;
    private TextView mResultText;
    private LinearLayout mSearchContent;
    private ImageView mSearchIcon;

    public FeedSearchBackView(Context context) {
        super(context);
    }

    private final View initInflate(LayoutInflater inflater, ViewGroup root) {
        View inflate = inflater.inflate(R.layout.feed_tpl_search_back, root);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ed_tpl_search_back, root)");
        return inflate;
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        updateUI();
    }

    /* access modifiers changed from: protected */
    public View doCreateView() {
        RelativeLayout root = new RelativeLayout(getContext());
        LayoutInflater from = LayoutInflater.from(getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        initInflate(from, root);
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.feed_search_back_height)));
        root.setGravity(16);
        root.setPadding(getResources().getDimensionPixelSize(R.dimen.feed_template_m1), 0, getResources().getDimensionPixelSize(R.dimen.feed_template_m1), 0);
        View findViewById = root.findViewById(R.id.search_back_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.search_back_text)");
        this.mBackText = (TextView) findViewById;
        View findViewById2 = root.findViewById(R.id.search_back_result);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.search_back_result)");
        this.mResultText = (TextView) findViewById2;
        View findViewById3 = root.findViewById(R.id.search_back_query);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.search_back_query)");
        this.mQueryText = (TextView) findViewById3;
        View findViewById4 = root.findViewById(R.id.search_back_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.search_back_icon)");
        this.mSearchIcon = (ImageView) findViewById4;
        View findViewById5 = root.findViewById(R.id.search_back_close);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.search_back_close)");
        this.mDislikeIcon = (ImageView) findViewById5;
        View findViewById6 = root.findViewById(R.id.search_back_content);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.search_back_content)");
        this.mSearchContent = (LinearLayout) findViewById6;
        View.OnTouchListener touchListener = new FeedSearchBackView$$ExternalSyntheticLambda0();
        LinearLayout linearLayout = this.mSearchContent;
        ImageView imageView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchContent");
            linearLayout = null;
        }
        linearLayout.setOnTouchListener(touchListener);
        ImageView imageView2 = this.mDislikeIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDislikeIcon");
            imageView2 = null;
        }
        imageView2.setOnTouchListener(touchListener);
        View.OnClickListener clickListener = new FeedSearchBackView$$ExternalSyntheticLambda1(this);
        LinearLayout linearLayout2 = this.mSearchContent;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchContent");
            linearLayout2 = null;
        }
        linearLayout2.setOnClickListener(clickListener);
        ImageView imageView3 = this.mDislikeIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDislikeIcon");
        } else {
            imageView = imageView3;
        }
        imageView.setOnClickListener(clickListener);
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: doCreateView$lambda-0  reason: not valid java name */
    public static final boolean m19478doCreateView$lambda0(View v, MotionEvent event) {
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf == null || valueOf.intValue() != 0) {
            if (((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 3)) && v != null) {
                v.setAlpha(1.0f);
            }
        } else if (v != null) {
            v.setAlpha(0.2f);
        }
        if (v != null) {
            return v.onTouchEvent(event);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: doCreateView$lambda-1  reason: not valid java name */
    public static final void m19479doCreateView$lambda1(FeedSearchBackView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mChildViewClickListener != null) {
            this$0.mChildViewClickListener.onClick(it);
        }
    }

    public final void update(FeedBaseModel feedModel, Map<String, Object> options, String query) {
        TextView textView = this.mQueryText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQueryText");
            textView = null;
        }
        textView.setText(query);
        update(feedModel, options);
    }

    private final void updateUI() {
        Resources it = getResources();
        if (it != null) {
            View rootView = getRootView();
            if (rootView != null) {
                rootView.setBackgroundColor(it.getColor(R.color.feed_search_back_bg_color));
            }
            TextView textView = this.mBackText;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBackText");
                textView = null;
            }
            textView.setTextColor(it.getColor(R.color.feed_search_back_text_color));
            TextView textView2 = this.mResultText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mResultText");
                textView2 = null;
            }
            textView2.setTextColor(it.getColor(R.color.feed_search_back_text_color));
            TextView textView3 = this.mQueryText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQueryText");
                textView3 = null;
            }
            textView3.setTextColor(it.getColor(R.color.feed_search_back_query_color));
            ImageView imageView2 = this.mSearchIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchIcon");
                imageView2 = null;
            }
            imageView2.setImageDrawable(it.getDrawable(R.drawable.feed_search_back_icon));
            ImageView imageView3 = this.mDislikeIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDislikeIcon");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(it.getDrawable(R.drawable.feed_search_back_dislike));
        }
    }
}
