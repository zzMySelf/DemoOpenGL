package com.baidu.searchbox.music.lyric.business.share.comp.sentence;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.music.lyric.business.R;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemComponent;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/music/lyric/business/share/comp/sentence/SharedSentenceComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemComponent;", "Lcom/baidu/searchbox/music/lyric/business/share/comp/sentence/SharedSentenceData;", "Lcom/baidu/searchbox/music/lyric/business/share/comp/sentence/SharedSentenceViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;)V", "selectedBg", "kotlin.jvm.PlatformType", "selectedMarkIv", "Landroid/widget/ImageView;", "sentenceTv", "Landroid/widget/TextView;", "wrapper", "Landroidx/constraintlayout/widget/ConstraintLayout;", "bindBgColor", "", "viewModel", "bindSelectedBg", "bindSentence", "bindShowMark", "bindTextColor", "bindTextStyle", "onBindViewModel", "onCreateView", "onCreateViewModel", "onNightModeChange", "isNightMode", "", "lib-music-lyric-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SharedSentenceComp.kt */
public final class SharedSentenceComp extends BaseExtItemComponent<SharedSentenceData, SharedSentenceViewModel> {
    private final View selectedBg;
    private final ImageView selectedMarkIv;
    private final TextView sentenceTv;
    private final ConstraintLayout wrapper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedSentenceComp(LifecycleOwner owner, View view2) {
        super(owner, view2);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        TextView textView = (TextView) view2.findViewById(R.id.sentence);
        this.sentenceTv = textView;
        this.selectedMarkIv = (ImageView) view2.findViewById(R.id.selected);
        this.wrapper = (ConstraintLayout) view2.findViewById(R.id.wrapper);
        this.selectedBg = view2.findViewById(R.id.selected_bg);
        ((TextView) view2.findViewById(R.id.sentence)).setGravity(GravityCompat.START);
        textView.setTextSize(0, ViewExKt.getDpF(15.6f));
        ViewGroup.LayoutParams layoutParams = ((TextView) view2.findViewById(R.id.sentence)).getLayoutParams();
        ViewGroup.MarginLayoutParams lp = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (lp != null) {
            lp.setMargins(ViewExKt.getDp(30), ViewExKt.getDp(8), ViewExKt.getDp(30), ViewExKt.getDp(8));
            ((TextView) view2.findViewById(R.id.sentence)).setLayoutParams(lp);
        }
    }

    public void onCreateView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public SharedSentenceViewModel onCreateViewModel() {
        return new SharedSentenceViewModel();
    }

    public void onNightModeChange(boolean isNightMode) {
        ResWrapper.setBackground(this.selectedBg, R.drawable.search_music_lyric_selected_single);
    }

    public void onBindViewModel(SharedSentenceViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel(viewModel, owner);
        bindSentence(viewModel, owner);
        bindTextColor(viewModel, owner);
        bindShowMark(viewModel, owner);
        bindBgColor(viewModel, owner);
        bindTextStyle(viewModel, owner);
        bindSelectedBg(viewModel, owner);
    }

    private final void bindSentence(SharedSentenceViewModel viewModel, LifecycleOwner owner) {
        viewModel.getSentence().observe(owner, new SharedSentenceComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindSentence$lambda-2  reason: not valid java name */
    public static final void m1233bindSentence$lambda2(SharedSentenceComp this$0, String sentence) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (sentence != null) {
            this$0.sentenceTv.setText(sentence);
        }
    }

    private final void bindTextColor(SharedSentenceViewModel viewModel, LifecycleOwner owner) {
        viewModel.getSentenceTextColor().observe(owner, new SharedSentenceComp$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindTextColor$lambda-4  reason: not valid java name */
    public static final void m1235bindTextColor$lambda4(SharedSentenceComp this$0, Integer textColor) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (textColor != null) {
            ResWrapper.setTextColor(this$0.sentenceTv, textColor.intValue());
        }
    }

    private final void bindShowMark(SharedSentenceViewModel viewModel, LifecycleOwner owner) {
        viewModel.getShowMark().observe(owner, new SharedSentenceComp$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindShowMark$lambda-5  reason: not valid java name */
    public static final void m1234bindShowMark$lambda5(SharedSentenceComp this$0, Boolean showMark) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ResWrapper.setImageDrawable(this$0.selectedMarkIv, R.drawable.search_music_lyric_selected_mark);
        this$0.selectedMarkIv.setVisibility(Intrinsics.areEqual((Object) true, (Object) showMark) ? 0 : 8);
    }

    private final void bindBgColor(SharedSentenceViewModel viewModel, LifecycleOwner owner) {
        viewModel.getBgColor().observe(owner, new SharedSentenceComp$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindBgColor$lambda-8  reason: not valid java name */
    public static final void m1231bindBgColor$lambda8(SharedSentenceComp this$0, Integer bgColor) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bgColor != null) {
            ResWrapper.setBackgroundColor(this$0.wrapper, bgColor.intValue());
            bgColor.intValue();
            return;
        }
        this$0.wrapper.setBackground((Drawable) null);
    }

    private final void bindTextStyle(SharedSentenceViewModel viewModel, LifecycleOwner owner) {
        viewModel.getSentenceTextStyle().observe(owner, new SharedSentenceComp$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindTextStyle$lambda-10  reason: not valid java name */
    public static final void m1236bindTextStyle$lambda10(SharedSentenceComp this$0, Typeface typeface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (typeface != null) {
            this$0.sentenceTv.setTypeface(typeface);
        }
    }

    private final void bindSelectedBg(SharedSentenceViewModel viewModel, LifecycleOwner owner) {
        viewModel.getShowSelectedBg().observe(owner, new SharedSentenceComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindSelectedBg$lambda-11  reason: not valid java name */
    public static final void m1232bindSelectedBg$lambda11(SharedSentenceComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectedBg.setVisibility(Intrinsics.areEqual((Object) it, (Object) true) ? 0 : 8);
    }
}
