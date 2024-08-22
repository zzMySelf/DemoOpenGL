package com.baidu.searchbox.search.mix.tplview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.searchbox.search.mix.tplmodel.SearchCardPersonalSearchTipsModel;
import com.baidu.searchbox.search.mix.tplmodel.SearchCardTopResultModel;
import com.baidu.searchbox.search.mix.tplview.toptip.PersonalSearchTipsView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/search/mix/tplview/SearchCardPersonalSearchTipsView;", "Lcom/baidu/searchbox/search/mix/tplview/SearchCardTopResultView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "topResultView", "Lcom/baidu/searchbox/search/mix/tplview/toptip/PersonalSearchTipsView;", "initModel", "", "topResultModel", "Lcom/baidu/searchbox/search/mix/tplmodel/SearchCardTopResultModel;", "initView", "onFontSizeChanged", "onNightModeChanged", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchCardPersonalSearchTipsView.kt */
public final class SearchCardPersonalSearchTipsView extends SearchCardTopResultView {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private PersonalSearchTipsView topResultView;

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
    public SearchCardPersonalSearchTipsView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchCardPersonalSearchTipsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchCardPersonalSearchTipsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PersonalSearchTipsView view2 = new PersonalSearchTipsView(this);
        this.topResultView = view2;
        LayoutInflater.from(context).inflate(view2.getLayoutId(), this);
        view2.initViews(this);
    }

    public void initModel(SearchCardTopResultModel topResultModel) {
        PersonalSearchTipsView personalSearchTipsView;
        Intrinsics.checkNotNullParameter(topResultModel, "topResultModel");
        SearchCardPersonalSearchTipsModel it = topResultModel instanceof SearchCardPersonalSearchTipsModel ? (SearchCardPersonalSearchTipsModel) topResultModel : null;
        if (it != null && (personalSearchTipsView = this.topResultView) != null) {
            personalSearchTipsView.initModel(it);
        }
    }

    public void onNightModeChanged(SearchCardTopResultModel topResultModel) {
        PersonalSearchTipsView personalSearchTipsView;
        Intrinsics.checkNotNullParameter(topResultModel, "topResultModel");
        SearchCardPersonalSearchTipsModel it = topResultModel instanceof SearchCardPersonalSearchTipsModel ? (SearchCardPersonalSearchTipsModel) topResultModel : null;
        if (it != null && (personalSearchTipsView = this.topResultView) != null) {
            personalSearchTipsView.onNightModeChanged(it);
        }
    }

    public void onFontSizeChanged(SearchCardTopResultModel topResultModel) {
        PersonalSearchTipsView personalSearchTipsView;
        Intrinsics.checkNotNullParameter(topResultModel, "topResultModel");
        SearchCardPersonalSearchTipsModel it = topResultModel instanceof SearchCardPersonalSearchTipsModel ? (SearchCardPersonalSearchTipsModel) topResultModel : null;
        if (it != null && (personalSearchTipsView = this.topResultView) != null) {
            personalSearchTipsView.onFontSizeChanged(it);
        }
    }
}
