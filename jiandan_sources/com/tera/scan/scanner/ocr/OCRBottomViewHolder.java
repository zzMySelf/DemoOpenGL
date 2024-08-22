package com.tera.scan.scanner.ocr;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.ui.view.widget.UITextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/scanner/ocr/OCRBottomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemview", "Landroid/view/View;", "(Landroid/view/View;)V", "dot", "getDot", "()Landroid/view/View;", "freeTip", "Lcom/tera/scan/ui/view/widget/UITextView;", "getFreeTip", "()Lcom/tera/scan/ui/view/widget/UITextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRBottomViewHolder extends RecyclerView.ViewHolder {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final View f7179ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final UITextView f7180de;
    @NotNull
    public final TextView qw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRBottomViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemview");
        View findViewById = this.itemView.findViewById(R.id.ocr_bottom_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.ocr_bottom_title)");
        this.qw = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.ocr_bottom_dot);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById<View>(R.id.ocr_bottom_dot)");
        this.f7179ad = findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.ocr_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById<UITextView>(R.id.ocr_tip)");
        this.f7180de = (UITextView) findViewById3;
    }

    @NotNull
    public final View getDot() {
        return this.f7179ad;
    }

    @NotNull
    public final UITextView getFreeTip() {
        return this.f7180de;
    }

    @NotNull
    public final TextView getTitle() {
        return this.qw;
    }
}
