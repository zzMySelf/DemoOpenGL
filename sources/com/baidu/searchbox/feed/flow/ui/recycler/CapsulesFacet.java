package com.baidu.searchbox.feed.flow.ui.recycler;

import android.view.ViewGroup;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.event.FeedPullToRefreshEvent;
import com.baidu.searchbox.feed.flow.ui.CapsulesAbility;
import com.baidu.searchbox.feed.refreshex.FloatCapsulesView;

public class CapsulesFacet implements CapsulesAbility {
    private FloatCapsulesView mFloatCapsules;
    private ViewGroup mRootView;

    public static CapsulesFacet create(ViewGroup rootView) {
        CapsulesFacet capsulesFacet = new CapsulesFacet();
        capsulesFacet.setRootView(rootView);
        return capsulesFacet;
    }

    protected CapsulesFacet() {
    }

    public final void setRootView(ViewGroup rootView) {
        this.mRootView = rootView;
    }

    public void attachCapsulesToRoot(FloatCapsulesView.OnCapsulesClick capsulesClick) {
        if (this.mFloatCapsules == null) {
            FloatCapsulesView floatCapsulesView = new FloatCapsulesView(FeedRuntime.getAppContext());
            this.mFloatCapsules = floatCapsulesView;
            floatCapsulesView.setLocation(true);
            this.mFloatCapsules.setClick(capsulesClick);
            this.mFloatCapsules.setAction(new FloatCapsulesView.OnCapsulesAction() {
                public void onAppear(int state) {
                    if (state == 1) {
                        BdEventBus.Companion.getDefault().post(new FeedPullToRefreshEvent(FeedPullToRefreshEvent.REFRESH));
                    }
                }

                public void onSubside(int state) {
                    if (state == 3) {
                        BdEventBus.Companion.getDefault().post(new FeedPullToRefreshEvent(FeedPullToRefreshEvent.ANIMATION_END));
                    }
                }
            });
        }
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.removeView(this.mFloatCapsules);
            this.mRootView.addView(this.mFloatCapsules);
        }
    }

    public int getCapsulesState() {
        FloatCapsulesView floatCapsulesView = this.mFloatCapsules;
        if (floatCapsulesView != null) {
            return floatCapsulesView.getState();
        }
        return 0;
    }

    public void changeCapsulesState(int state) {
        FloatCapsulesView floatCapsulesView = this.mFloatCapsules;
        if (floatCapsulesView != null) {
            floatCapsulesView.changeState(state);
        }
    }

    public void changeCapsulesState(int state, String tips) {
        FloatCapsulesView floatCapsulesView = this.mFloatCapsules;
        if (floatCapsulesView != null) {
            floatCapsulesView.changeState(state, tips);
        }
    }

    public void updateCapsulesUI() {
        FloatCapsulesView floatCapsulesView = this.mFloatCapsules;
        if (floatCapsulesView != null) {
            floatCapsulesView.updateUI();
        }
    }

    public void dismissFailCapsules() {
        FloatCapsulesView floatCapsulesView = this.mFloatCapsules;
        if (floatCapsulesView != null) {
            floatCapsulesView.dismissFailCapsules();
        }
    }

    public void hideCapsulesUI() {
        FloatCapsulesView floatCapsulesView = this.mFloatCapsules;
        if (floatCapsulesView != null) {
            floatCapsulesView.setAlpha(0.0f);
        }
    }

    public void replayCapsulesAlpha() {
        FloatCapsulesView floatCapsulesView = this.mFloatCapsules;
        if (floatCapsulesView != null) {
            floatCapsulesView.setAlpha(1.0f);
        }
    }
}
