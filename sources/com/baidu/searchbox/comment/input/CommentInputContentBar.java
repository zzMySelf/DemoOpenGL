package com.baidu.searchbox.comment.input;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.data.CommentInputContentBarModel;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.spswitch.emotion.EmotionLoader;
import com.baidu.spswitch.emotion.EmotionType;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u00020\u0018H\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/comment/input/CommentInputContentBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentView", "Landroid/widget/TextView;", "getContentView", "()Landroid/widget/TextView;", "contentView$delegate", "Lkotlin/Lazy;", "userAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getUserAvatar", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "userAvatar$delegate", "buildContent", "", "content", "setData", "", "model", "Lcom/baidu/searchbox/comment/data/CommentInputContentBarModel;", "updateUI", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentInputContentBar.kt */
public final class CommentInputContentBar extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private final Lazy contentView$delegate;
    private final Lazy userAvatar$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CommentInputContentBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CommentInputContentBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentInputContentBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.userAvatar$delegate = LazyKt.lazy(new CommentInputContentBar$userAvatar$2(this));
        this.contentView$delegate = LazyKt.lazy(new CommentInputContentBar$contentView$2(this));
        LayoutInflater.from(context).inflate(R.layout.bdcomment_inputdialog_content_bar_layout, this, true);
        setGravity(16);
        updateUI();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentInputContentBar(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final SimpleDraweeView getUserAvatar() {
        Object value = this.userAvatar$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-userAvatar>(...)");
        return (SimpleDraweeView) value;
    }

    private final TextView getContentView() {
        Object value = this.contentView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-contentView>(...)");
        return (TextView) value;
    }

    public final void setData(CommentInputContentBarModel model) {
        if (model == null || !model.isValid()) {
            setVisibility(8);
            return;
        }
        getUserAvatar().setImageURI(model.getUserIcon());
        getContentView().setText(buildContent(model.getContent()), TextView.BufferType.SPANNABLE);
    }

    private final CharSequence buildContent(CharSequence content) {
        SpannableString parseEmotion = EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, getContext().getApplicationContext(), content, getContentView(), 1.2f);
        Intrinsics.checkNotNullExpressionValue(parseEmotion, "getInstance().parseEmoti…ntentView, EMOTION_RATIO)");
        return parseEmotion;
    }

    private final void updateUI() {
        ViewExtensionsKt.setTextColorRes(getContentView(), com.baidu.searchbox.interaction.styles.R.color.IC254);
        int padding = ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.comment_dimen_15dp);
        setPadding(padding, ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.comment_dimen_7_5dp), padding, 0);
        ViewExtensionsKt.setBackgroundColorRes(this, com.baidu.searchbox.interaction.styles.R.color.IC13);
    }
}
