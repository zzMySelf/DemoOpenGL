package com.baidu.swan.games.view.recommend.popview;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.swan.game.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0003J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/swan/games/view/recommend/popview/PandaParkCloseDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mOnClickListener", "Lcom/baidu/swan/games/view/recommend/popview/PandaParkCloseDialog$IOnClickListener;", "alphaChange", "Landroid/view/View$OnTouchListener;", "init", "", "initClickListener", "setOnClickListener", "onClickListener", "IOnClickListener", "lib-swan-game_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PandaParkCloseDialog.kt */
public final class PandaParkCloseDialog extends Dialog {
    private IOnClickListener mOnClickListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/swan/games/view/recommend/popview/PandaParkCloseDialog$IOnClickListener;", "", "onCloseButtonClick", "", "onContinueClick", "onExitButtonClick", "lib-swan-game_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PandaParkCloseDialog.kt */
    public interface IOnClickListener {
        void onCloseButtonClick();

        void onContinueClick();

        void onExitButtonClick();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PandaParkCloseDialog(Context context) {
        super(context, R.style.SwanGameNoTitleDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    private final void init() {
        setContentView(R.layout.aiapps_pandapark_close_dialog);
        setCanceledOnTouchOutside(false);
        initClickListener();
    }

    private final void initClickListener() {
        ((Button) findViewById(R.id.exit_button)).setOnTouchListener(alphaChange());
        ((Button) findViewById(R.id.exit_button)).setOnClickListener(new PandaParkCloseDialog$$ExternalSyntheticLambda1(this));
        ((ImageView) findViewById(R.id.image_close)).setOnTouchListener(alphaChange());
        ((ImageView) findViewById(R.id.image_close)).setOnClickListener(new PandaParkCloseDialog$$ExternalSyntheticLambda2(this));
        ((Button) findViewById(R.id.continue_button)).setOnTouchListener(alphaChange());
        ((Button) findViewById(R.id.continue_button)).setOnClickListener(new PandaParkCloseDialog$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-0  reason: not valid java name */
    public static final void m8094initClickListener$lambda0(PandaParkCloseDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IOnClickListener iOnClickListener = this$0.mOnClickListener;
        if (iOnClickListener != null) {
            iOnClickListener.onExitButtonClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-1  reason: not valid java name */
    public static final void m8095initClickListener$lambda1(PandaParkCloseDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IOnClickListener iOnClickListener = this$0.mOnClickListener;
        if (iOnClickListener != null) {
            iOnClickListener.onCloseButtonClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-2  reason: not valid java name */
    public static final void m8096initClickListener$lambda2(PandaParkCloseDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IOnClickListener iOnClickListener = this$0.mOnClickListener;
        if (iOnClickListener != null) {
            iOnClickListener.onContinueClick();
        }
    }

    public final void setOnClickListener(IOnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.mOnClickListener = onClickListener;
    }

    private final View.OnTouchListener alphaChange() {
        return new PandaParkCloseDialog$$ExternalSyntheticLambda0();
    }

    /* access modifiers changed from: private */
    /* renamed from: alphaChange$lambda-3  reason: not valid java name */
    public static final boolean m8093alphaChange$lambda3(View v, MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                v.setAlpha(0.2f);
                return false;
            case 1:
            case 3:
                v.setAlpha(1.0f);
                return false;
            default:
                return false;
        }
    }
}
