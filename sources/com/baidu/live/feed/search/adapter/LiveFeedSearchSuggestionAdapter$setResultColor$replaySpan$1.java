package com.baidu.live.feed.search.adapter;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.baidu.live.business.util.CommonUtil;
import com.baidu.live.feed.search.R;
import com.baidu.validation.result.ValidationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$setResultColor$replaySpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "lib-live-feed-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFeedSearchSuggestionAdapter.kt */
public final class LiveFeedSearchSuggestionAdapter$setResultColor$replaySpan$1 extends CharacterStyle {
    final /* synthetic */ LiveFeedSearchSuggestionAdapter this$0;

    LiveFeedSearchSuggestionAdapter$setResultColor$replaySpan$1(LiveFeedSearchSuggestionAdapter $receiver) {
        this.this$0 = $receiver;
    }

    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, ValidationResult.KEY_DATA_DS);
        ds.setColor(this.this$0.getMContext().getResources().getColor(R.color.live_show_FFFF4D6A));
        ds.bgColor = 0;
        ds.setTextSize(CommonUtil.dp2px(this.this$0.getMContext().getResources(), 14.0f));
        ds.setUnderlineText(false);
    }
}
