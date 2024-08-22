package androidx.core.view;

import android.view.View;

public interface ViewPropertyAnimatorListener {
    void onAnimationCancel(View view2);

    void onAnimationEnd(View view2);

    void onAnimationStart(View view2);
}
