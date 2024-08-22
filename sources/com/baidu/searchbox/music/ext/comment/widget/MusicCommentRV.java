package com.baidu.searchbox.music.ext.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.comment.definition.ICommonRecyclerView;
import com.baidu.searchbox.comment.params.CommonAttrs;
import com.baidu.searchbox.music.ext.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0001H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/music/ext/comment/widget/MusicCommentRV;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/baidu/searchbox/comment/definition/ICommonRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/baidu/searchbox/comment/params/CommonAttrs;", "getAttrs", "getViewInstance", "notifyNightMode", "", "setAttrs", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicCommentRV.kt */
public final class MusicCommentRV extends RecyclerView implements ICommonRecyclerView {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private CommonAttrs attrs;

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
    public MusicCommentRV(Context context, AttributeSet attrs2) {
        super(context, attrs2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs2, "attrs");
    }

    public RecyclerView getViewInstance() {
        return this;
    }

    public void setAttrs(CommonAttrs attrs2) {
        this.attrs = attrs2;
    }

    public CommonAttrs getAttrs() {
        CommonAttrs commonAttrs = this.attrs;
        return commonAttrs == null ? new CommonAttrs() : commonAttrs;
    }

    public void notifyNightMode() {
        setBackgroundColor(getResources().getColor(R.color.search_music_bg_a));
    }
}
