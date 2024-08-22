package com.baidu.chatsearch.aisearch.resultpage;

import com.baidu.searchbox.search.scheme.UnitedSchemeSearchAdapter;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/baidu/chatsearch/aisearch/resultpage/SSAiSearchBaseContainer$getSchemeSearchAdapter$1", "Lcom/baidu/searchbox/search/scheme/UnitedSchemeSearchAdapter;", "handleJumpToTab", "", "params", "", "handleMultiTabInfo", "handleTransportDurationParams", "", "extClickParams", "lib-chatsearch-resultpage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSAiSearchBaseContainer.kt */
public final class SSAiSearchBaseContainer$getSchemeSearchAdapter$1 implements UnitedSchemeSearchAdapter {
    final /* synthetic */ SSAiSearchBaseContainer this$0;

    SSAiSearchBaseContainer$getSchemeSearchAdapter$1(SSAiSearchBaseContainer $receiver) {
        this.this$0 = $receiver;
    }

    public boolean handleAsyncPageState(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleAsyncPageState(this, params);
    }

    public boolean handleBrowsingDialog(boolean isShow) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleBrowsingDialog(this, isShow);
    }

    public boolean handleCancelPullRefresh(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleCancelPullRefresh(this, params);
    }

    public boolean handleConfig(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleConfig(this, params);
    }

    public String handleGetSpeedLogData(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleGetSpeedLogData(this, params);
    }

    public boolean handleGroupCard(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleGroupCard(this, params);
    }

    public boolean handleGroupCardAnimation(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleGroupCardAnimation(this, params);
    }

    public boolean handleLogHFiveTiming(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleLogHFiveTiming(this, params);
    }

    public void handleOnShowDialogOrToast(boolean isShow, Set<String> positionSet) {
        UnitedSchemeSearchAdapter.DefaultImpls.handleOnShowDialogOrToast(this, isShow, positionSet);
    }

    public boolean handlePlayEasterEgg(JSONObject params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handlePlayEasterEgg(this, params);
    }

    public boolean handlePrerenderAsyncPageState(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handlePrerenderAsyncPageState(this, params);
    }

    public boolean handleProgressCompleted(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleProgressCompleted(this, params);
    }

    public void handleSaveAdHistory(JSONObject params) {
        UnitedSchemeSearchAdapter.DefaultImpls.handleSaveAdHistory(this, params);
    }

    public void handleSearchBarMaskView(JSONObject params) {
        UnitedSchemeSearchAdapter.DefaultImpls.handleSearchBarMaskView(this, params);
    }

    public boolean handleSearchSummaryInfo(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleSearchSummaryInfo(this, params);
    }

    public boolean handleSetMultiModeQuery(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleSetMultiModeQuery(this, params);
    }

    public boolean handleSetQuery(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleSetQuery(this, params);
    }

    public boolean handleSetSpeedLogData(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleSetSpeedLogData(this, params);
    }

    public void handleShowVoiceOperation(JSONObject params) {
        UnitedSchemeSearchAdapter.DefaultImpls.handleShowVoiceOperation(this, params);
    }

    public boolean handleThemeToolBar(String params, UnitedSchemeEntity entity, CallbackHandler callbackHandler) {
        return UnitedSchemeSearchAdapter.DefaultImpls.handleThemeToolBar(this, params, entity, callbackHandler);
    }

    public void handleTransData(JSONObject transData) {
        UnitedSchemeSearchAdapter.DefaultImpls.handleTransData(this, transData);
    }

    public void invokeBrowsingState(boolean open) {
        UnitedSchemeSearchAdapter.DefaultImpls.invokeBrowsingState(this, open);
    }

    public void microChannelNextPageUrlUpdate(String url) {
        UnitedSchemeSearchAdapter.DefaultImpls.microChannelNextPageUrlUpdate(this, url);
    }

    public void microChannelSubscribe(int status) {
        UnitedSchemeSearchAdapter.DefaultImpls.microChannelSubscribe(this, status);
    }

    public void notifyAsyncSearchStarted(int type, String url) {
        UnitedSchemeSearchAdapter.DefaultImpls.notifyAsyncSearchStarted(this, type, url);
    }

    public boolean notifyDefaultGroupCard(String params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.notifyDefaultGroupCard(this, params);
    }

    public boolean onHandleAdUrl(String url, HashMap<String, String> params) {
        return UnitedSchemeSearchAdapter.DefaultImpls.onHandleAdUrl(this, url, params);
    }

    public boolean onHandleAladdinAd(JSONObject paramsJson) {
        return UnitedSchemeSearchAdapter.DefaultImpls.onHandleAladdinAd(this, paramsJson);
    }

    public boolean onLandingPageTTSReady(String jsCallback, String category) {
        return UnitedSchemeSearchAdapter.DefaultImpls.onLandingPageTTSReady(this, jsCallback, category);
    }

    public void pushPst(String params) {
        UnitedSchemeSearchAdapter.DefaultImpls.pushPst(this, params);
    }

    public JSONObject readSstPst(boolean readSst, boolean readPst) {
        return UnitedSchemeSearchAdapter.DefaultImpls.readSstPst(this, readSst, readPst);
    }

    public String registerDataChannel() {
        return UnitedSchemeSearchAdapter.DefaultImpls.registerDataChannel(this);
    }

    public void setVideoTrans(int transcoding) {
        UnitedSchemeSearchAdapter.DefaultImpls.setVideoTrans(this, transcoding);
    }

    public void handleTransportDurationParams(String extClickParams) {
        ISSAiResultPageContainer mIResultPageContainer = this.this$0.getMIResultPageContainer();
        if (mIResultPageContainer != null) {
            mIResultPageContainer.handleTransportDurationParams(extClickParams);
        }
    }

    public boolean handleJumpToTab(String params) {
        ISSAiResultPageContainer mIResultPageContainer = this.this$0.getMIResultPageContainer();
        if (mIResultPageContainer != null) {
            return mIResultPageContainer.handleJumpToTab(params);
        }
        return false;
    }

    public boolean handleMultiTabInfo(String params) {
        ISSAiResultPageContainer mIResultPageContainer = this.this$0.getMIResultPageContainer();
        if (mIResultPageContainer != null) {
            return mIResultPageContainer.handleMultiTabInfo(params);
        }
        return false;
    }
}
