package com.baidu.searchbox.download.center.ui.search.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ui.PictureCategoryHelper;
import com.baidu.searchbox.download.center.ui.search.FileSearchActivity;
import com.baidu.searchbox.download.center.ui.search.helper.FileSearchJumpHelper;
import com.baidu.searchbox.download.center.ui.search.helper.HighlightHelper;
import com.baidu.searchbox.download.center.ui.video.DownloadVideoUtils;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.ui.BdBaseImageView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/search/viewholder/OtherTypeFileViewHolder;", "Lcom/baidu/searchbox/download/center/ui/search/viewholder/SearchBaseHolder;", "Lcom/baidu/searchbox/download/model/CategoryInfoData;", "itemView", "Landroid/view/View;", "listener", "Lcom/baidu/searchbox/download/center/ui/search/viewholder/SearchDownloadListener;", "(Landroid/view/View;Lcom/baidu/searchbox/download/center/ui/search/viewholder/SearchDownloadListener;)V", "getListener", "()Lcom/baidu/searchbox/download/center/ui/search/viewholder/SearchDownloadListener;", "mDateView", "Landroid/widget/TextView;", "mIconView", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "mSizeView", "mTitleView", "update", "", "entity", "position", "", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OtherTypeFileViewHolder.kt */
public final class OtherTypeFileViewHolder extends SearchBaseHolder<CategoryInfoData> {
    private final SearchDownloadListener<CategoryInfoData> listener;
    private final TextView mDateView;
    private final BdBaseImageView mIconView;
    private final TextView mSizeView;
    private final TextView mTitleView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OtherTypeFileViewHolder(View view2, SearchDownloadListener searchDownloadListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, (i2 & 2) != 0 ? null : searchDownloadListener);
    }

    public final SearchDownloadListener<CategoryInfoData> getListener() {
        return this.listener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OtherTypeFileViewHolder(View itemView, SearchDownloadListener<CategoryInfoData> listener2) {
        super(itemView, listener2);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.listener = listener2;
        View findViewById = itemView.findViewById(R.id.other_type_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.other_type_title)");
        this.mTitleView = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.other_type_size);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.other_type_size)");
        this.mSizeView = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.other_type_date);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.other_type_date)");
        this.mDateView = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.other_type_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.other_type_icon)");
        this.mIconView = (BdBaseImageView) findViewById4;
    }

    public void update(CategoryInfoData entity, int position) {
        Object obj;
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.itemView.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), com.baidu.android.common.ui.style.R.color.GC9));
        try {
            Result.Companion companion = Result.Companion;
            String afterText = DownloadHelper.getVariableLengthTitleCutOffWithSuffix(entity.mFileName, entity.mDownloadPath, 20);
            HighlightHelper highlightHelper = HighlightHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(afterText, "afterText");
            highlightHelper.updateRedText(afterText, FileSearchActivity.Companion.getMSearchText(), ContextCompat.getColor(this.itemView.getContext(), com.baidu.android.common.ui.style.R.color.GC1), ContextCompat.getColor(this.itemView.getContext(), com.baidu.android.common.ui.style.R.color.GC8), this.mTitleView);
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8974exceptionOrNullimpl(obj) != null) {
            this.mTitleView.setText(entity.mFileName);
        }
        this.mDateView.setText(PictureCategoryHelper.parseTimeOfMilliSecond(entity.mCompletionTime));
        this.mDateView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), com.baidu.android.common.ui.style.R.color.GC4));
        this.mSizeView.setText(DownloadVideoUtils.convertByte((double) entity.mSize));
        this.mSizeView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), com.baidu.android.common.ui.style.R.color.GC4));
        this.mIconView.setImageResource(DownloadHelper.getIconId(entity.mFileName, entity.mMimeType));
        this.itemView.setOnClickListener(new OtherTypeFileViewHolder$$ExternalSyntheticLambda0(entity, this, position));
    }

    /* access modifiers changed from: private */
    /* renamed from: update$lambda-4  reason: not valid java name */
    public static final void m17689update$lambda4(CategoryInfoData $entity, OtherTypeFileViewHolder this$0, int $position, View it) {
        Intrinsics.checkNotNullParameter($entity, "$entity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileSearchJumpHelper fileSearchJumpHelper = FileSearchJumpHelper.INSTANCE;
        Context context = this$0.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        fileSearchJumpHelper.jumpTo($entity, context);
        SearchDownloadListener<CategoryInfoData> searchDownloadListener = this$0.listener;
        if (searchDownloadListener != null) {
            searchDownloadListener.onItemClick($entity, $position);
        }
    }
}
