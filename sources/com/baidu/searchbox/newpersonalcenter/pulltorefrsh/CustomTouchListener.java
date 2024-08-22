package com.baidu.searchbox.newpersonalcenter.pulltorefrsh;

import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.newpersonalcenter.CompleteRecyclerView;
import com.baidu.searchbox.newpersonalcenter.adapter.TemplateContentAdapter;
import com.baidu.searchbox.newpersonalcenter.viewholder.FooterLoadingViewHolder;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import org.json.JSONObject;

public class CustomTouchListener implements View.OnTouchListener {
    private final int canRouterSize;
    private final int loadingViewWidth;
    private State mState = State.RESET;
    private CustomLayoutManager manager;
    /* access modifiers changed from: private */
    public PersonalCenterTabModel personalCenterTabModel;
    private CompleteRecyclerView recyclerView;
    private final int threshold;

    public CustomTouchListener(CompleteRecyclerView recyclerView2, CustomLayoutManager manager2, PersonalCenterTabModel personalCenterTabModel2) {
        this.recyclerView = recyclerView2;
        this.manager = manager2;
        this.personalCenterTabModel = personalCenterTabModel2;
        Resources resources = AppRuntime.getAppContext().getResources();
        this.loadingViewWidth = resources.getDimensionPixelSize(R.dimen.personal_pull_max_size);
        this.canRouterSize = resources.getDimensionPixelSize(R.dimen.personal_pull_can_router_size);
        this.threshold = resources.getDimensionPixelSize(R.dimen.personal_pull_arrow_margin_left) + resources.getDimensionPixelSize(R.dimen.personal_pull_arrow_size) + resources.getDimensionPixelSize(R.dimen.personal_pull_arrow_margin_right);
    }

    public boolean onTouch(View v, MotionEvent event) {
        this.recyclerView.setFastSmooth(false);
        TemplateContentAdapter adapter = (TemplateContentAdapter) this.recyclerView.getAdapter();
        if (adapter == null) {
            return false;
        }
        FooterLoadingViewHolder loadingViewHolder = adapter.getLoadingViewHolder();
        final Context context = v.getContext();
        int leftPixels = this.loadingViewWidth - (this.recyclerView.computeHorizontalScrollRange() - (this.recyclerView.computeHorizontalScrollExtent() + this.recyclerView.computeHorizontalScrollOffset()));
        if (event.getAction() == 2) {
            if (leftPixels >= this.threshold) {
                CustomLayoutManager customLayoutManager = this.manager;
                if (customLayoutManager != null) {
                    customLayoutManager.setSpeedRatio(0.4f);
                }
            } else {
                CustomLayoutManager customLayoutManager2 = this.manager;
                if (customLayoutManager2 != null) {
                    customLayoutManager2.setSpeedRatio(1.0f);
                }
            }
            if (loadingViewHolder != null) {
                loadingViewHolder.onPull((float) leftPixels);
            }
            if (this.mState != State.PULL_TO_REFRESH && leftPixels < this.canRouterSize) {
                this.mState = State.PULL_TO_REFRESH;
            } else if (this.mState == State.PULL_TO_REFRESH && leftPixels >= this.canRouterSize) {
                this.mState = State.RELEASE_TO_REFRESH;
                ((Vibrator) context.getSystemService("vibrator")).vibrate(10);
            }
        } else if (event.getAction() == 1) {
            if (leftPixels >= this.threshold) {
                this.recyclerView.setFastSmooth(true);
            } else {
                this.recyclerView.setFastSmooth(false);
            }
            if (leftPixels >= this.canRouterSize && this.mState == State.RELEASE_TO_REFRESH) {
                this.recyclerView.smoothScrollBy(-(leftPixels - this.threshold), 0, (Interpolator) null, 0);
                v.postDelayed(new Runnable() {
                    public void run() {
                        Router.invoke(context, CustomTouchListener.this.personalCenterTabModel.getScheme());
                        PersonCenterUBCStatistic.statisticUBC(CustomTouchListener.this.personalCenterTabModel.getUbcType(), "", "click", (JSONObject) null, CustomTouchListener.this.personalCenterTabModel.getUbcFrom(), CustomTouchListener.this.personalCenterTabModel.getUbcId(), PersonalConstants.PAGE_SLIDE_MORE);
                    }
                }, 100);
            }
            if (loadingViewHolder != null) {
                loadingViewHolder.reset();
            }
            this.mState = State.RESET;
        } else if (event.getAction() == 3) {
            this.recyclerView.setFastSmooth(true);
            if (loadingViewHolder != null) {
                loadingViewHolder.reset();
            }
            this.mState = State.RESET;
        }
        return false;
    }

    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2);
        
        private int mIntValue;

        private State(int intValue) {
            this.mIntValue = intValue;
        }

        /* access modifiers changed from: package-private */
        public int getIntValue() {
            return this.mIntValue;
        }
    }
}
