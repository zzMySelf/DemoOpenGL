package com.baidu.searchbox.search.webvideo.player.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.player.widget.VideoVulcanThumbSeekBar;
import com.baidu.searchbox.search.videodetail.R;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u001bJ\u0006\u0010$\u001a\u00020\u001bJ\u001e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/player/component/SearchH5VideoSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "durationView", "Landroid/widget/TextView;", "isSeeking", "", "progressView", "seekBarListener", "Lcom/baidu/searchbox/search/webvideo/player/component/ISearchH5SeekBarListener;", "getSeekBarListener", "()Lcom/baidu/searchbox/search/webvideo/player/component/ISearchH5SeekBarListener;", "setSeekBarListener", "(Lcom/baidu/searchbox/search/webvideo/player/component/ISearchH5SeekBarListener;)V", "seekBarView", "Lcom/baidu/searchbox/player/widget/VideoVulcanThumbSeekBar;", "getLayoutId", "getTextWithSecond", "", "second", "initView", "", "setBufferingPosition", "bufferingPos", "setDuration", "duration", "setMaxDragPosition", "position", "setPosition", "switchToFull", "switchToHalf", "syncPos", "pos", "dur", "buffer", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5VideoSeekBar.kt */
public final class SearchH5VideoSeekBar extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private TextView durationView;
    public boolean isSeeking;
    private TextView progressView;
    private ISearchH5SeekBarListener seekBarListener;
    /* access modifiers changed from: private */
    public VideoVulcanThumbSeekBar seekBarView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SearchH5VideoSeekBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SearchH5VideoSeekBar(Context context, AttributeSet attributeSet) {
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
    public SearchH5VideoSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        initView();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchH5VideoSeekBar(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final ISearchH5SeekBarListener getSeekBarListener() {
        return this.seekBarListener;
    }

    public final void setSeekBarListener(ISearchH5SeekBarListener iSearchH5SeekBarListener) {
        this.seekBarListener = iSearchH5SeekBarListener;
    }

    private final void initView() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        View findViewById = findViewById(R.id.main_progress_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.main_progress_text)");
        this.progressView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.main_duration_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.main_duration_text)");
        this.durationView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.main_view_seekbar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.main_view_seekbar)");
        this.seekBarView = (VideoVulcanThumbSeekBar) findViewById3;
        TextView textView = this.progressView;
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            textView = null;
        }
        textView.setMinWidth((int) FontSizeHelperKt.getVideoScaledSizeRes$default(com.baidu.searchbox.videoplayer.vulcan.R.dimen.videoplayer_vulcan_dp_35, 0, 2, (Object) null));
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar2 = this.seekBarView;
        if (videoVulcanThumbSeekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            videoVulcanThumbSeekBar2 = null;
        }
        videoVulcanThumbSeekBar2.setUiTraceHeight(3);
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar3 = this.seekBarView;
        if (videoVulcanThumbSeekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            videoVulcanThumbSeekBar3 = null;
        }
        videoVulcanThumbSeekBar3.setProgressColor(ContextCompat.getColor(getContext(), com.baidu.searchbox.videoplayer.vulcan.R.color.videoplayer_vulcan_control_seekbar_played_color));
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar4 = this.seekBarView;
        if (videoVulcanThumbSeekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            videoVulcanThumbSeekBar4 = null;
        }
        videoVulcanThumbSeekBar4.setProgressBackgroundColor(ContextCompat.getColor(getContext(), com.baidu.searchbox.videoplayer.vulcan.R.color.videoplayer_vulcan_control_seekbar_bg_color));
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar5 = this.seekBarView;
        if (videoVulcanThumbSeekBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
        } else {
            videoVulcanThumbSeekBar = videoVulcanThumbSeekBar5;
        }
        videoVulcanThumbSeekBar.setOnSeekBarChangeListener(new SearchH5VideoSeekBar$initView$1(this));
    }

    public int getLayoutId() {
        return R.layout.search_video_h5_seek_bar;
    }

    public final void syncPos(int pos, int dur, int buffer) {
        if (!this.isSeeking) {
            setPosition(pos);
            setDuration(dur);
            setBufferingPosition(buffer);
        }
    }

    public final void setMaxDragPosition(int position) {
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar = this.seekBarView;
        if (videoVulcanThumbSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            videoVulcanThumbSeekBar = null;
        }
        videoVulcanThumbSeekBar.setMaxDragPosition(position);
    }

    public final void setPosition(int position) {
        VideoVulcanThumbSeekBar $this$setPosition_u24lambda_u2d0 = this.seekBarView;
        TextView textView = null;
        if ($this$setPosition_u24lambda_u2d0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            $this$setPosition_u24lambda_u2d0 = null;
        }
        $this$setPosition_u24lambda_u2d0.setProgress(position);
        String positionString = getTextWithSecond(position);
        TextView textView2 = this.progressView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            textView2 = null;
        }
        TextView textView3 = textView2;
        if (!StringsKt.isBlank(positionString)) {
            textView = textView2;
        }
        if (textView != null) {
            textView.setText(positionString);
        }
    }

    public final String getTextWithSecond(int second) {
        if (second < 0) {
            return "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(second / 60), Integer.valueOf(second % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    public final void setBufferingPosition(int bufferingPos) {
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar = this.seekBarView;
        if (videoVulcanThumbSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            videoVulcanThumbSeekBar = null;
        }
        videoVulcanThumbSeekBar.setBufferingProgress(bufferingPos);
    }

    public void setDuration(int duration) {
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar = this.seekBarView;
        TextView textView = null;
        if (videoVulcanThumbSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            videoVulcanThumbSeekBar = null;
        }
        videoVulcanThumbSeekBar.setMax((float) duration);
        if (this.durationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("durationView");
        }
        String dt = getTextWithSecond(duration);
        if (!(!StringsKt.isBlank(dt))) {
            dt = null;
        }
        if (dt != null) {
            TextView textView2 = this.durationView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("durationView");
            } else {
                textView = textView2;
            }
            textView.setText(dt);
        }
    }

    public final void switchToFull() {
        TextView textView = this.progressView;
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            textView = null;
        }
        textView.setMinWidth((int) FontSizeHelperKt.getVideoScaledSizeRes$default(com.baidu.searchbox.videoplayer.vulcan.R.dimen.videoplayer_vulcan_dp_35, 0, 2, (Object) null));
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar2 = this.seekBarView;
        if (videoVulcanThumbSeekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            videoVulcanThumbSeekBar2 = null;
        }
        ViewGroup.LayoutParams layoutParams = videoVulcanThumbSeekBar2.getLayoutParams();
        RelativeLayout.LayoutParams params = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (params != null) {
            params.leftMargin = getResources().getDimensionPixelOffset(com.baidu.searchbox.videoplayer.vulcan.R.dimen.videoplayer_vulcan_dp_3);
            params.rightMargin = getResources().getDimensionPixelOffset(com.baidu.searchbox.videoplayer.vulcan.R.dimen.videoplayer_vulcan_dp_1);
            VideoVulcanThumbSeekBar videoVulcanThumbSeekBar3 = this.seekBarView;
            if (videoVulcanThumbSeekBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            } else {
                videoVulcanThumbSeekBar = videoVulcanThumbSeekBar3;
            }
            videoVulcanThumbSeekBar.setLayoutParams(params);
        }
    }

    public final void switchToHalf() {
        TextView textView = this.progressView;
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            textView = null;
        }
        textView.setMinWidth((int) FontSizeHelperKt.getVideoScaledSizeRes$default(com.baidu.searchbox.videoplayer.vulcan.R.dimen.videoplayer_vulcan_dp_0, 0, 2, (Object) null));
        VideoVulcanThumbSeekBar videoVulcanThumbSeekBar2 = this.seekBarView;
        if (videoVulcanThumbSeekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            videoVulcanThumbSeekBar2 = null;
        }
        ViewGroup.LayoutParams layoutParams = videoVulcanThumbSeekBar2.getLayoutParams();
        RelativeLayout.LayoutParams params = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (params != null) {
            params.leftMargin = getResources().getDimensionPixelOffset(com.baidu.searchbox.videoplayer.vulcan.R.dimen.videoplayer_vulcan_dp_3);
            params.rightMargin = getResources().getDimensionPixelOffset(com.baidu.searchbox.videoplayer.vulcan.R.dimen.videoplayer_vulcan_dp_3);
            VideoVulcanThumbSeekBar videoVulcanThumbSeekBar3 = this.seekBarView;
            if (videoVulcanThumbSeekBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBarView");
            } else {
                videoVulcanThumbSeekBar = videoVulcanThumbSeekBar3;
            }
            videoVulcanThumbSeekBar.setLayoutParams(params);
        }
    }
}
