package leakcanary.internal.activity.screen;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.activity.db.IoKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"leakcanary/internal/activity/screen/RenderHeapDumpScreen$createView$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: RenderHeapDumpScreen.kt */
public final class RenderHeapDumpScreen$createView$$inlined$apply$lambda$2 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ViewGroup $container$inlined;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ View $loadingView;
    final /* synthetic */ View $this_apply;
    final /* synthetic */ RenderHeapDumpScreen this$0;

    RenderHeapDumpScreen$createView$$inlined$apply$lambda$2(View $receiver, ImageView $captured_local_variable$2, View $captured_local_variable$3, RenderHeapDumpScreen renderHeapDumpScreen, ViewGroup viewGroup) {
        this.$this_apply = $receiver;
        this.$imageView = $captured_local_variable$2;
        this.$loadingView = $captured_local_variable$3;
        this.this$0 = renderHeapDumpScreen;
        this.$container$inlined = viewGroup;
    }

    public void onGlobalLayout() {
        IoKt.executeOnIo(this.$this_apply, new Function1<Io.OnIo, Unit>(this) {
            final /* synthetic */ RenderHeapDumpScreen$createView$$inlined$apply$lambda$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Io.OnIo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Io.OnIo $this$executeOnIo) {
                Intrinsics.checkParameterIsNotNull($this$executeOnIo, "$receiver");
                HeapDumpRenderer heapDumpRenderer = HeapDumpRenderer.INSTANCE;
                Context context = this.this$0.$this_apply.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                final Bitmap bitmap = heapDumpRenderer.render(context, this.this$0.this$0.heapDumpFile, this.this$0.$this_apply.getMeasuredWidth(), this.this$0.$this_apply.getMeasuredHeight(), 0);
                $this$executeOnIo.updateUi(new Function1<View, Unit>(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((View) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(View $this$updateUi) {
                        Intrinsics.checkParameterIsNotNull($this$updateUi, "$receiver");
                        this.this$0.this$0.$imageView.setImageBitmap(bitmap);
                        View view2 = this.this$0.this$0.$loadingView;
                        Intrinsics.checkExpressionValueIsNotNull(view2, "loadingView");
                        view2.setVisibility(8);
                        ImageView imageView = this.this$0.this$0.$imageView;
                        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                        imageView.setVisibility(0);
                    }
                });
            }
        });
        if (Build.VERSION.SDK_INT >= 16) {
            this.$this_apply.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            this.$this_apply.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }
}
