package com.baidu.searchbox.lockscreen.voicesearch.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import com.baidu.searchbox.lockscreen.voicesearch.constant.ErrorMapping;
import com.baidu.searchbox.lockscreen.voicesearch.searchdata.bean.SearchDataKeyWord;
import com.baidu.searchbox.lockscreen.voicesearch.view.RequestPermission;

public class VoiceSearchErrorPresenter {
    private static String TAG = VoiceSearchErrorPresenter.class.getSimpleName();
    private LockScreenVoiceSearchPresenter mLockScreenVoiceSearchPresenter;

    public VoiceSearchErrorPresenter(LockScreenVoiceSearchPresenter lockScreenVoiceSearchPresenter) {
        this.mLockScreenVoiceSearchPresenter = lockScreenVoiceSearchPresenter;
    }

    public void handleError(String errorCode) {
        if (!TextUtils.isEmpty(errorCode)) {
            if (LockScreenUtil.GLOBAL_DEBUG) {
                Log.e(TAG, "errorCode:" + errorCode);
            }
            String hintStr = ErrorMapping.sHashMap.get(errorCode);
            if (!TextUtils.isEmpty(hintStr)) {
                this.mLockScreenVoiceSearchPresenter.mSearchDataViewPresenter.mSearchDataAdapter.getList().clear();
                this.mLockScreenVoiceSearchPresenter.mSearchDataViewPresenter.mSearchDataAdapter.getList().add(new SearchDataKeyWord(hintStr, SearchDataKeyWord.TYPE_SEARCH));
                this.mLockScreenVoiceSearchPresenter.mSearchDataViewPresenter.mSearchDataAdapter.notifyDataSetChanged();
            } else if (LockScreenUtil.GLOBAL_DEBUG) {
                this.mLockScreenVoiceSearchPresenter.mSearchDataViewPresenter.mSearchDataAdapter.getList().clear();
                this.mLockScreenVoiceSearchPresenter.mSearchDataViewPresenter.mSearchDataAdapter.getList().add(new SearchDataKeyWord(errorCode, SearchDataKeyWord.TYPE_SEARCH));
                this.mLockScreenVoiceSearchPresenter.mSearchDataViewPresenter.mSearchDataAdapter.notifyDataSetChanged();
            }
            char c2 = 65535;
            switch (errorCode.hashCode()) {
                case 1480516:
                    if (errorCode.equals("0301")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1481480:
                    if (errorCode.equals("0404")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1483399:
                    if (errorCode.equals("0601")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1483400:
                    if (errorCode.equals("0602")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1483401:
                    if (errorCode.equals("0603")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1483402:
                    if (errorCode.equals("0604")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (this.mLockScreenVoiceSearchPresenter.mRequestPermission == null) {
                        this.mLockScreenVoiceSearchPresenter.mRequestPermission = new RequestPermission(this.mLockScreenVoiceSearchPresenter.getActivity());
                    }
                    this.mLockScreenVoiceSearchPresenter.mRequestPermission.mBoxAlertDialog.show();
                    return;
                case 1:
                case 2:
                case 5:
                    return;
                case 3:
                    this.mLockScreenVoiceSearchPresenter.mSearchDataViewPresenter.setSearchDataRvVisible(4);
                    this.mLockScreenVoiceSearchPresenter.mGuideWordPresenter.doGuideShowAnim();
                    return;
                case 4:
                    this.mLockScreenVoiceSearchPresenter.mSearchDataViewPresenter.setSearchDataRvVisible(4);
                    this.mLockScreenVoiceSearchPresenter.mGuideWordPresenter.doGuideShowAnim();
                    return;
                default:
                    this.mLockScreenVoiceSearchPresenter.mSearchDataViewPresenter.setSearchDataRvVisible(4);
                    this.mLockScreenVoiceSearchPresenter.mGuideWordPresenter.doGuideShowAnim();
                    return;
            }
        }
    }
}
