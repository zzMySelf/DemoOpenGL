package com.baidu.searchbox.frame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.common.ui.style.R;
import com.baidu.search.basic.utils.FastSearchStatus;
import com.baidu.search.basic.utils.QueryUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.hissug.data.utils.HisManager;
import com.baidu.searchbox.hissug.his.HistoryConfig;
import com.baidu.searchbox.hissug.inputbox.model.SearchBoxCommand;
import com.baidu.searchbox.hissug.inputbox.util.FloatSearchboxMode;
import com.baidu.searchbox.hissug.ioc.IBrowser;
import com.baidu.searchbox.hissug.ioc.IOther;
import com.baidu.searchbox.hissug.util.HissugUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchFrameForSearchActivity extends SearchFrame implements ISearchFrameActivity {
    private static final String EXTRA_START_SEARCH_FROM_ANOTHER_ACTIVITY = "com.baidu.searchbox.EXTRA_START_SEARCH_FROM_ANOTHER_ACTIVITY";
    private static final String TAG = "SearchFrameForSearch";
    private static final String TAG_HIS_SYNC_QUERY = "query";
    private boolean mIsDelayingForExecuteCommand = false;
    private boolean mNeedGoHome = true;

    public SearchFrameForSearchActivity(Activity activity, Bundle savedInstance) {
        super(activity, savedInstance);
    }

    public void finish() {
        if (this.mActivity != null) {
            this.mActivity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
    }

    public boolean isFinishing() {
        return this.mActivity != null && this.mActivity.isFinishing();
    }

    public void executeSearchBoxCommand(SearchBoxCommand command) {
        if (command != null && !isDelayingForExecuteCommand()) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "searchbox mode: " + command.currentMode + ", query: " + command.query);
            }
            switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$hissug$inputbox$util$FloatSearchboxMode[command.currentMode.ordinal()]) {
                case 1:
                    HissugUtility.hideInputMethod(getContext(), this.mSearchBox.getEditText());
                    if (FastSearchStatus.isFastSearchAlive()) {
                        FastSearchStatus.resetStatus();
                    } else {
                        if (getIntent() != null && getIntent().getBooleanExtra(EXTRA_START_SEARCH_FROM_ANOTHER_ACTIVITY, false)) {
                            this.mNeedGoHome = false;
                        }
                        if (this.mActivity != null && this.mNeedGoHome) {
                            this.mActivity.startActivity(IOther.Impl.get().buildMainActivityIntent(this.mActivity));
                            if (getIntent().getBooleanExtra("EXTRA_FROM_MULTI_WINDOW", false)) {
                                this.mActivity.overridePendingTransition(R.anim.hold, com.baidu.searchbox.hissug.R.anim.activity_close_exit);
                            } else {
                                this.mActivity.overridePendingTransition(R.anim.hold, 0);
                            }
                        }
                    }
                    finish();
                    return;
                case 2:
                case 3:
                    HissugUtility.hideInputMethod(getContext(), this.mSearchBox.getEditText());
                    executeSearchCommand();
                    this.mIsDelayingForExecuteCommand = true;
                    return;
                case 4:
                    HissugUtility.hideInputMethod(getContext(), this.mSearchBox.getEditText());
                    executeVisitCommand(command);
                    this.mIsDelayingForExecuteCommand = true;
                    return;
                case 5:
                    IOther.Impl.get().enterOnekeyFeedback(this.mActivity);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.searchbox.frame.SearchFrameForSearchActivity$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$hissug$inputbox$util$FloatSearchboxMode;

        static {
            int[] iArr = new int[FloatSearchboxMode.values().length];
            $SwitchMap$com$baidu$searchbox$hissug$inputbox$util$FloatSearchboxMode = iArr;
            try {
                iArr[FloatSearchboxMode.SEARCH_CANCEL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$hissug$inputbox$util$FloatSearchboxMode[FloatSearchboxMode.ABOUT_SETTINGS.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$hissug$inputbox$util$FloatSearchboxMode[FloatSearchboxMode.SEARCH_GO.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$hissug$inputbox$util$FloatSearchboxMode[FloatSearchboxMode.SEARCH_VISIT.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$hissug$inputbox$util$FloatSearchboxMode[FloatSearchboxMode.ONEKEY_UPLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private void executeSearchCommand() {
        HashMap<String, String> params = new HashMap<>();
        addCommonParams(params);
        launchBrowser(getQuery(), params);
        launchSearchStatistic();
    }

    private void executeVisitCommand(SearchBoxCommand command) {
        if (AppConfig.isDebug()) {
            Log.i(TAG, "executeVisitCommand url:" + command.query);
        }
        String url = QueryUtils.getUrlFromQuery(command.query);
        if (!HistoryConfig.isHistoryPrivateMode(getContext())) {
            HisManager.addWebSearchHistory(url, getContext());
        }
        JSONObject dataObject = new JSONObject();
        try {
            dataObject.put("query", url);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        HisManager.doHisSyncAsync(dataObject.toString());
        IBrowser.Impl.get().loadUserInputUrl(getContext(), QueryUtils.addSchemeIfNeed(QueryUtils.fixUrl(url).trim()), command.query, getIntent().getBooleanExtra("EXTRA_FROM_MULTI_WINDOW", false));
        if (FastSearchStatus.isFastSearchAlive()) {
            delayFinish();
        } else {
            finish();
        }
    }

    private boolean isDelayingForExecuteCommand() {
        return this.mIsDelayingForExecuteCommand;
    }

    /* access modifiers changed from: protected */
    public Intent getIntent() {
        if (this.mActivity != null) {
            return this.mActivity.getIntent();
        }
        return new Intent();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 = super.onCreateView(inflater, container, savedInstanceState);
        if (view2 instanceof SearchActivityView) {
            ((SearchActivityView) view2).setSearchFrame(this);
        }
        return view2;
    }
}
