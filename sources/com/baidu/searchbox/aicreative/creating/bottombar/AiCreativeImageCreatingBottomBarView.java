package com.baidu.searchbox.aicreative.creating.bottombar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.searchbox.publishercomponent.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/aicreative/creating/bottombar/AiCreativeImageCreatingBottomBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBtn", "Landroid/widget/ImageView;", "nextBtn", "Landroid/widget/TextView;", "saveBtn", "setBackBtnOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setNextBtnOnClickListener", "setSaveBtnOnClickListener", "showBackBtnEnable", "enable", "", "showNextBtnEnable", "showSaveBtnEnable", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCreativeImageCreatingBottomBarView.kt */
public final class AiCreativeImageCreatingBottomBarView extends ConstraintLayout {
    public Map<Integer, View> _$_findViewCache;
    private ImageView backBtn;
    private TextView nextBtn;
    private TextView saveBtn;

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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AiCreativeImageCreatingBottomBarView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AiCreativeImageCreatingBottomBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiCreativeImageCreatingBottomBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(R.layout.dynamic_publisher_ai_creative_image_creating_bottom_bar, this);
        this.backBtn = (ImageView) findViewById(R.id.back_btn);
        this.saveBtn = (TextView) findViewById(R.id.save_btn);
        this.nextBtn = (TextView) findViewById(R.id.next_btn);
    }

    public final void setBackBtnOnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ImageView imageView = this.backBtn;
        if (imageView != null) {
            imageView.setOnClickListener(listener);
        }
    }

    public final void setSaveBtnOnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TextView textView = this.saveBtn;
        if (textView != null) {
            textView.setOnClickListener(listener);
        }
    }

    public final void setNextBtnOnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TextView textView = this.nextBtn;
        if (textView != null) {
            textView.setOnClickListener(listener);
        }
    }

    public final void showBackBtnEnable(boolean enable) {
        ImageView imageView = this.backBtn;
        if (imageView != null) {
            imageView.setVisibility(enable ? 0 : 8);
        }
    }

    public final void showSaveBtnEnable(boolean enable) {
        TextView textView = this.saveBtn;
        if (textView != null) {
            textView.setVisibility(enable ? 0 : 8);
        }
    }

    public final void showNextBtnEnable(boolean enable) {
        TextView textView = this.nextBtn;
        if (textView != null) {
            textView.setVisibility(enable ? 0 : 8);
        }
    }
}
