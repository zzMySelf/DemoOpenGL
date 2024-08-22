package com.baidu.searchbox.lockscreen.voicesearch.searchdata.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.searchbox.lockscreen.LockScreenDismissActivity;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import com.baidu.searchbox.lockscreen.voicesearch.R;
import com.baidu.searchbox.lockscreen.voicesearch.searchdata.ISearchData;
import com.baidu.searchbox.lockscreen.voicesearch.searchdata.bean.SearchOpenApp;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchResultOpenAppViewHolder extends CommVH {
    private static final int COUNT_DOWN_END = 1;
    private static final int COUNT_DOWN_START = 3;
    private static final String TAG = "SearchResultOpenAppViewHolder";
    private Button mCancelOpenAppBtn;
    /* access modifiers changed from: private */
    public String mCountDownStr;
    /* access modifiers changed from: private */
    public Intent mIntent;
    /* access modifiers changed from: private */
    public Button mUnLockOpenAppBtn;
    /* access modifiers changed from: private */
    public TextView mUnlockCountDownTv;
    /* access modifiers changed from: private */
    public TextView mUnlockHintTv;
    /* access modifiers changed from: private */
    public ViewGroup mUnlockOpenAppView;

    public SearchResultOpenAppViewHolder(ViewGroup itemView, ViewGroup parent) {
        super(itemView);
        this.mUnlockOpenAppView = (ViewGroup) itemView.findViewById(R.id.unlockOpenAppView);
        this.mUnLockOpenAppBtn = (Button) itemView.findViewById(R.id.unlockOpenAppBtn);
        this.mCancelOpenAppBtn = (Button) itemView.findViewById(R.id.cancelOpenApp);
        this.mUnlockCountDownTv = (TextView) itemView.findViewById(R.id.openAppCountDownTv);
        this.mUnlockHintTv = (TextView) itemView.findViewById(R.id.unlockOpenAppTv);
        this.mCountDownStr = itemView.getContext().getString(R.string.lockscreen_voicesearch_unlock_open_app_count_down);
    }

    public void bindData(ISearchData searchData) {
        SearchOpenApp searchOpenApp = (SearchOpenApp) searchData;
        final Timer timer = new Timer();
        final AtomicInteger atomicInteger = new AtomicInteger(3);
        this.mUnlockOpenAppView.setVisibility(0);
        this.mIntent = searchOpenApp.mIntent;
        String hintStr = this.mUnlockHintTv.getContext().getString(R.string.lockscreen_voicesearch_unlock_open_app);
        this.mUnlockHintTv.setText(String.format(hintStr, new Object[]{searchOpenApp.mAppName}));
        this.mUnLockOpenAppBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SearchResultOpenAppViewHolder.this.mUnLockOpenAppBtn.getContext().startActivity(SearchResultOpenAppViewHolder.this.mIntent);
                LockScreenDismissActivity.startSelf(SearchResultOpenAppViewHolder.this.mUnLockOpenAppBtn.getContext());
                LockScreenUtil.closeLockScreenActivity(SearchResultOpenAppViewHolder.this.mUnLockOpenAppBtn.getContext());
            }
        });
        this.mCancelOpenAppBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SearchResultOpenAppViewHolder.this.mUnlockOpenAppView.setVisibility(4);
                SearchResultOpenAppViewHolder.this.mUnlockHintTv.setText(R.string.lockscreen_voicesearch_unlock_open_app_cancel);
                timer.cancel();
            }
        });
        timer.schedule(new TimerTask() {
            public void run() {
                if (atomicInteger.decrementAndGet() >= 1) {
                    LockScreenUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            SearchResultOpenAppViewHolder.this.mUnlockCountDownTv.setText(String.format(SearchResultOpenAppViewHolder.this.mCountDownStr, new Object[]{Integer.valueOf(atomicInteger.get())}));
                        }
                    });
                    return;
                }
                timer.cancel();
                if (SearchResultOpenAppViewHolder.this.itemView.getParent() != null && ((ViewGroup) SearchResultOpenAppViewHolder.this.itemView.getParent()).getVisibility() == 0) {
                    SearchResultOpenAppViewHolder.this.mUnLockOpenAppBtn.getContext().startActivity(SearchResultOpenAppViewHolder.this.mIntent);
                    LockScreenUtil.closeLockScreenActivity(SearchResultOpenAppViewHolder.this.mUnLockOpenAppBtn.getContext());
                    LockScreenDismissActivity.startSelf(SearchResultOpenAppViewHolder.this.mUnLockOpenAppBtn.getContext());
                }
            }
        }, 0, 1000);
    }

    public static ViewGroup createView(Context context, ViewGroup parent) {
        return (ViewGroup) LayoutInflater.from(context).inflate(R.layout.lockscreen_item_layout_open_app, parent, false);
    }
}
