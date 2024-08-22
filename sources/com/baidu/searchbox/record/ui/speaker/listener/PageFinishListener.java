package com.baidu.searchbox.record.ui.speaker.listener;

import android.util.Log;
import com.baidu.searchbox.record.Debug;
import com.baidu.searchbox.record.RecordRuntime;
import com.baidu.searchbox.record.api.ILyrebirdFinishCallback;
import com.baidu.searchbox.record.api.LyrebirdFinishInfo;
import com.baidu.searchbox.record.ui.speaker.presenter.TTSSpeakerContract;

public class PageFinishListener implements ILyrebirdFinishCallback {
    private TTSSpeakerContract.IPresenter presenter;

    public PageFinishListener(TTSSpeakerContract.IPresenter presenter2) {
        this.presenter = presenter2;
    }

    public void pageFinish(boolean isEmptyBackStack, LyrebirdFinishInfo info) {
        if (RecordRuntime.DEBUG) {
            Log.d(Debug.Log.TAG, "pageFinish");
        }
        TTSSpeakerContract.IPresenter iPresenter = this.presenter;
        if (iPresenter != null) {
            if (info != null) {
                iPresenter.onPageFinish(info);
            }
            this.presenter.gotoFinish();
        }
    }
}
