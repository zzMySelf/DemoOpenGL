package com.baidu.searchbox.theme.skin;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.account.userinfo.activity.UserCoverAdapterKt;
import com.baidu.searchbox.home.skincenter.R;
import com.baidu.searchbox.theme.skin.utils.SkinMarketUBCKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/theme/skin/MoreItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "marketUbcFrom", "", "(Landroid/content/Context;Ljava/lang/String;)V", "lib-home-skincenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SkinMarketActivity.kt */
public final class MoreItemView extends FrameLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final String marketUbcFrom;

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
    public MoreItemView(Context context, String marketUbcFrom2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.marketUbcFrom = marketUbcFrom2;
        LayoutInflater.from(context).inflate(R.layout.skin_market_category_item_more, this);
        SpannableString tipsMessage = new SpannableString(context.getResources().getString(R.string.skin_category_bottom_tips));
        tipsMessage.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, com.baidu.android.common.ui.style.R.color.GC7)), 6, 9, 17);
        ((TextView) _$_findCachedViewById(R.id.more_skin_tips)).setText(tipsMessage);
        ((TextView) _$_findCachedViewById(R.id.more_skin_tips)).setTextColor(ContextCompat.getColor(context, com.baidu.android.common.ui.style.R.color.GC1));
        ((ImageView) _$_findCachedViewById(R.id.more_cover_icon)).setImageResource(com.baidu.searchbox.account.R.drawable.more_arrow);
        ((ConstraintLayout) _$_findCachedViewById(R.id.more_tips_layout)).setOnClickListener(new MoreItemView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4300_init_$lambda0(MoreItemView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map paramMap = new LinkedHashMap();
        paramMap.put("sourceFrom", "skinmall");
        paramMap.put(UserCoverAdapterKt.DRESS_TYPE_KEY, "skin");
        SkinMarketActivityKt.goDressUpCenter(paramMap);
        SkinMarketUBCKt.ubc5508$default(this$0.marketUbcFrom, "skin", "click", SkinMarketUBCKt.UBC_VALUE_BOTTOM_GENERATE_AISKIN, (String) null, (JSONObject) null, 48, (Object) null);
    }
}
