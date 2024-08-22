package com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.setting;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.mms.voicesearch.voice.common.Tools;
import com.baidu.mms.voicesearch.voice.utils.SkinManager;
import com.baidu.searchbox.story.NovelConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/setting/PlaceHolderTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "changeSkin", "", "initView", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlaceHolderTextView.kt */
public final class PlaceHolderTextView extends AppCompatTextView {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

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
    public PlaceHolderTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlaceHolderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlaceHolderTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    private final void initView() {
        setPadding((int) Tools.dip2px(15.0f), 0, 0, 0);
        setTextSize(Tools.px2sp(getContext(), Tools.dip2px(10.5f)));
        setGravity(16);
        if (SkinManager.getInstance().isNightMode()) {
            setBackgroundColor(Color.parseColor("#121212"));
            setTextColor(Color.parseColor(NovelConstant.AD_RULE_DESCRIPTION_NIGHT));
        } else {
            setBackgroundColor(Color.parseColor("#f5f5f5"));
            setTextColor(Color.parseColor("#525252"));
        }
        setVisibility(8);
        setOnClickListener(new PlaceHolderTextView$$ExternalSyntheticLambda0());
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m14004initView$lambda0(View it) {
    }

    public final void changeSkin() {
        if (SkinManager.getInstance().isNightMode()) {
            setBackgroundColor(Color.parseColor("#121212"));
            setTextColor(Color.parseColor(NovelConstant.AD_RULE_DESCRIPTION_NIGHT));
            return;
        }
        setBackgroundColor(Color.parseColor("#f5f5f5"));
        setTextColor(Color.parseColor("#525252"));
    }
}
