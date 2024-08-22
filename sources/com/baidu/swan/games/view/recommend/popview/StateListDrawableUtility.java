package com.baidu.swan.games.view.recommend.popview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;

public class StateListDrawableUtility extends StateListDrawable {
    private IStateChangeListener mStateChangeListener;
    private View mView = null;

    public interface IStateChangeListener {
        void onStateDefault(View view2);

        void onStatePressed(View view2);
    }

    public StateListDrawableUtility() {
        addState(new int[]{16842919}, new ColorDrawable(0));
        addState(new int[0], new ColorDrawable(0));
    }

    public StateListDrawableUtility(Drawable drawable) {
        addState(new int[]{16842919}, drawable);
        addState(new int[0], drawable);
    }

    public void setView(View aView) {
        this.mView = aView;
    }

    public void setStateChangeListener(IStateChangeListener aStateChangeListener) {
        this.mStateChangeListener = aStateChangeListener;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] stateSet) {
        if (!(this.mView == null || this.mStateChangeListener == null)) {
            if (StateSet.stateSetMatches(new int[]{16842919}, stateSet)) {
                this.mStateChangeListener.onStatePressed(this.mView);
            } else {
                this.mStateChangeListener.onStateDefault(this.mView);
            }
        }
        return super.onStateChange(stateSet);
    }
}
