package com.baidu.searchbox.feed.tts.ui.delegates;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.bdmediacore.controller.MediaParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.tab.interaction.tts.ITTSActionObserver;
import com.baidu.searchbox.feed.tab.interaction.tts.ITTSListWidgetResponder;
import com.baidu.searchbox.feed.tab.interaction.tts.ITTSPlayerResponder;
import com.baidu.searchbox.feed.tts.FeedTTSUtil;
import com.baidu.searchbox.feed.tts.R;
import com.baidu.searchbox.feed.tts.commonstreams.StreamsCallback;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.interfaces.IFeedTTSContext;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.tts.statistic.FeedTTSStatistic;
import com.baidu.searchbox.feed.tts.ui.FeedTTSDispatcher;
import com.baidu.searchbox.feed.tts.ui.uiobservers.LandpageObserver;
import com.baidu.searchbox.feed.tts.ui.uiobservers.NaAndHnListObserver;
import com.baidu.searchbox.feed.tts.ui.uiobservers.PlayerObserver;
import com.baidu.searchbox.feed.tts.ui.uiobservers.SchemeListObserver;
import com.baidu.searchbox.music.utils.NovelHelper;
import java.util.Iterator;
import java.util.Vector;

public class TTSActionNotifyDelegate implements ITTSUIDelegate {
    private static final boolean DEBUG = TTSRuntime.DEBUG;
    private static final String TAG = "TTS-Controller";
    private static final int TOAST_LONG_TIME = 10;
    /* access modifiers changed from: private */
    public Vector<ITTSActionObserver> mTTSActionObservers = new Vector<>();

    TTSActionNotifyDelegate() {
    }

    private void removeTTSActionObserver(ITTSActionObserver ttsActionObserver) {
        Vector<ITTSActionObserver> vector = this.mTTSActionObservers;
        if (vector != null && vector.contains(ttsActionObserver)) {
            this.mTTSActionObservers.remove(ttsActionObserver);
        }
    }

    public void prepare() {
        findAndRegisterPlayerObserverNotNull();
        if (((LandpageObserver) findObserverByGroup(LandpageObserver.class)) == null) {
            registTTSActionObserver(LandpageObserver.create());
        }
        if (((SchemeListObserver) findObserverByGroup(SchemeListObserver.class)) == null) {
            registTTSActionObserver(SchemeListObserver.create());
        }
        registTTSActionObserver(TTSRuntime.getInstance().getTTSActionObserver());
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onInitialized();
                    }
                }
            }
        });
    }

    public void onPlayPrev() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.beforeMoveToPlayPrevious();
                    }
                }
            }
        });
    }

    public void onPlayNext(final boolean isAutoPlay) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.beforeMoveToPlayNext(isAutoPlay);
                    }
                }
            }
        });
    }

    public void onPlayInOrder() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.beforeMoveToPlayFirst();
                    }
                }
            }
        });
    }

    public void onPlayTheModel(final IFeedTTSModel theFeed) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.beforeMoveToPlay(theFeed);
                    }
                }
            }
        });
    }

    public void updateRNAndPlayerStatus() {
        if (DEBUG) {
            Log.d(TAG, "NOTIFY:  updateRNAndPlayerStatus");
        }
        if (TTSRuntime.getInstance().isPlayerShown()) {
            String currentTabId = IFeedTTSContext.Impl.get().getCurrentChannelID();
            IFeedTTSModel speechingFeed = FeedTTSDispatcher.getInstance().getSpeechingFeed();
            if (speechingFeed != null && speechingFeed.isLandingTTS() && isFragmentSupportTTS(currentTabId) && !NovelHelper.isNovelSource()) {
                boolean z = true;
                if (TTSRuntime.getInstance().isHNShownTab(currentTabId)) {
                    TTSRuntime.getInstance().setPreNextButtonStatus(false, true);
                    Iterator<ITTSActionObserver> it = new Vector<>(this.mTTSActionObservers).iterator();
                    while (it.hasNext()) {
                        ITTSActionObserver observer = it.next();
                        if (observer != null) {
                            observer.onSpeeched();
                        }
                    }
                    return;
                }
                TTSRuntime instance = TTSRuntime.getInstance();
                boolean z2 = FeedTTSDispatcher.getInstance().getPreReadableFeed() != null;
                if (FeedTTSDispatcher.getInstance().getNextReadableFeed() == null) {
                    z = false;
                }
                instance.setPreNextButtonStatus(z2, z);
            }
        }
    }

    public boolean isFragmentSupportTTS(String tabid) {
        return findAndRegisterNaHNListObserverNotNull().isFragmentSupportTTS(tabid);
    }

    public void onPause() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onPaused();
                    }
                }
            }
        });
    }

    public void onReleased(final boolean completely) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onReleased(completely);
                    }
                }
                TTSRuntime.getInstance().closeTipDialog();
            }
        });
        if (completely) {
            removeAllTTSActionObserver();
        }
    }

    public void onResumed() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onSpeeched();
                    }
                }
            }
        });
    }

    public void onUpdatePlayingParagraph(final int paragraph) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onUpdatePlayingParagraph(paragraph);
                    }
                }
            }
        });
    }

    public void onPlaybackCompleted(final IFeedTTSModel data) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onPlaybackCompleted(data);
                    }
                }
            }
        });
    }

    public void onTabChanged() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onTTSDataSourceChanged();
                    }
                }
            }
        });
    }

    public void addPlayerResponder(ITTSPlayerResponder callback) {
        findAndRegisterPlayerObserverNotNull().addPlayerResponder(callback);
    }

    public void removePlayerResponder(ITTSPlayerResponder callback) {
        PlayerObserver playerObserver = (PlayerObserver) findObserverByGroup(PlayerObserver.class);
        if (playerObserver != null) {
            playerObserver.removePlayerResponder(callback);
        }
    }

    public void setListWidgetResponder(ITTSListWidgetResponder responder) {
        final NaAndHnListObserver listObserver = findAndRegisterNaHNListObserverNotNull();
        listObserver.registToObserveTTS(responder);
        if (FeedTTSDispatcher.getInstance().isNotTTSState()) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    listObserver.onIdle();
                }
            });
        }
    }

    public void onStartReadInner(Bundle bundle) {
        boolean isAuto;
        String reportAction;
        IFeedTTSModel speeching = FeedTTSDispatcher.getInstance().getSpeechingFeed();
        if (speeching != null) {
            String tabId = bundle.getString(MediaParams.KEY_CHANNEL_ID);
            String actionId = bundle.getString(MediaParams.KEY_ACTIONID);
            if (TextUtils.isEmpty(actionId)) {
                isAuto = bundle.getBoolean(MediaParams.KEY_ISAUTOPLAY, false);
            } else {
                isAuto = TextUtils.equals(actionId, "ttsauto");
            }
            if (isAuto) {
                reportAction = "ttsauto";
            } else if (!TextUtils.isEmpty(actionId)) {
                reportAction = actionId;
            } else {
                reportAction = FeedTTSStatistic.TTS_CLK;
            }
            speeching.setAutoPlay(isAuto);
            speeching.setTtsActionId(reportAction);
            String mid = bundle.getString(MediaParams.KEY_DATA_ID);
            int position = bundle.getInt(MediaParams.KEY_POSITION);
            if (!FeedTTSUtil.isMock(mid) && !TTSRuntime.getInstance().isHNShownTab(tabId) && !speeching.isCommonStream()) {
                reportFeedbackAction(reportAction, position);
            } else if (speeching.isEndlessFlowData()) {
                IFeedTTSContext.Impl.get().feedItemReport102(reportAction, position, speeching.getId(), "index");
            }
            if (speeching.isCommonStream()) {
                String category = speeching.getExtInfo("category", (String) null);
                if (!isAuto && TextUtils.equals(category, IFeedTTSContext.CATEGORY_SEARCHLIST)) {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.tts_common_stream_is_loading).setDuration(10).showToast(true);
                        }
                    });
                }
            }
        }
    }

    public void onSpeechProgressAdjust(final int readCount, final int wholeWordCount, final int briefWordCount) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onWordCountUpdated(wholeWordCount, briefWordCount);
                        observer.onUpdateProgress(readCount);
                    }
                }
            }
        });
    }

    public void onSeekToBegin() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onUpdateProgress(0);
                    }
                }
            }
        });
    }

    public void onSeekToEnd() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onUpdateProgress(0);
                    }
                }
            }
        });
    }

    public void onSeekTo() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onSpeeched();
                    }
                }
            }
        });
    }

    public void onFeedItemPlayStatusChange(final int status, final int reason, final String nid) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onStatusChanged(status, reason, nid);
                    }
                }
            }
        });
    }

    public IFeedTTSModel getReadableFeedFromFirstVisible(String tabId, boolean isCompletelyVisible) {
        return findAndRegisterNaHNListObserverNotNull().getReadableFeedFromFirstVisible(tabId, isCompletelyVisible);
    }

    public IFeedTTSModel getReadableFeedFromFirstTitleComplete(String tabId) {
        return findAndRegisterNaHNListObserverNotNull().getReadableFeedFromFirstTitleComplete(tabId);
    }

    public void notifyListRefresh() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onItemPropertiesChanged();
                    }
                }
            }
        });
    }

    public void onLoadMoreFailed() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onError(1);
                    }
                }
            }
        });
    }

    public void onLoadMoreNotRead() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onError(2);
                    }
                }
            }
        });
    }

    public boolean isRNTab(String tabId) {
        return findAndRegisterNaHNListObserverNotNull().isRNTab(tabId);
    }

    public void onSpeakSpecified() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onItemPropertiesChanged();
                    }
                }
            }
        });
    }

    public void onUpdateProgress(final int progress) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onUpdateProgress(progress);
                    }
                }
            }
        });
    }

    public void onSpeechProgressChanged(final String utteranceId, final int progress) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onSpeechProgressChanged(utteranceId, progress);
                    }
                }
            }
        });
    }

    public void updateWordCount(final int wholeWordCount, final int briefWordCount) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onWordCountUpdated(wholeWordCount, briefWordCount);
                    }
                }
            }
        });
    }

    public void onFavorDataChanged(final String flag) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                TTSActionNotifyDelegate.this.findAndRegisterPlayerObserverNotNull().onFavorDataChanged(flag);
            }
        });
    }

    public void onFeedImageChange(final String coverImg) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                TTSActionNotifyDelegate.this.findAndRegisterPlayerObserverNotNull().onFeedImageChange(coverImg);
            }
        });
    }

    public void speechFromStart() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Iterator<ITTSActionObserver> it = new Vector<>(TTSActionNotifyDelegate.this.mTTSActionObservers).iterator();
                while (it.hasNext()) {
                    ITTSActionObserver observer = it.next();
                    if (observer != null) {
                        observer.onStarted();
                    }
                }
            }
        });
    }

    public void registGlobalStreamsCallback(StreamsCallback callback) {
        ((LandpageObserver) findObserverByGroup(LandpageObserver.class)).registCallback(callback);
    }

    /* access modifiers changed from: private */
    public PlayerObserver findAndRegisterPlayerObserverNotNull() {
        PlayerObserver player = (PlayerObserver) findObserverByGroup(PlayerObserver.class);
        if (player != null) {
            return player;
        }
        PlayerObserver player2 = PlayerObserver.create();
        registTTSActionObserverToFirst(player2);
        return player2;
    }

    private NaAndHnListObserver findAndRegisterNaHNListObserverNotNull() {
        NaAndHnListObserver player = (NaAndHnListObserver) findObserverByGroup(NaAndHnListObserver.class);
        if (player != null) {
            return player;
        }
        NaAndHnListObserver player2 = NaAndHnListObserver.create();
        registTTSActionObserver(player2);
        return player2;
    }

    private ITTSActionObserver findObserverByGroup(Class<? extends ITTSActionObserver> clz) {
        if (this.mTTSActionObservers == null) {
            return null;
        }
        Iterator<ITTSActionObserver> it = new Vector<>(this.mTTSActionObservers).iterator();
        while (it.hasNext()) {
            ITTSActionObserver item = it.next();
            if (item != null && item.getClass() == clz) {
                return item;
            }
        }
        return null;
    }

    private void registTTSActionObserver(ITTSActionObserver ttsActionObserver) {
        Vector<ITTSActionObserver> vector = this.mTTSActionObservers;
        if (vector != null && !vector.contains(ttsActionObserver)) {
            this.mTTSActionObservers.add(ttsActionObserver);
        }
    }

    private void registTTSActionObserverToFirst(ITTSActionObserver ttsActionObserver) {
        Vector<ITTSActionObserver> vector = this.mTTSActionObservers;
        if (vector != null && !vector.contains(ttsActionObserver)) {
            this.mTTSActionObservers.add(0, ttsActionObserver);
        }
    }

    private void removeTTSActionObserverByGroup(Class<? extends ITTSActionObserver> clz) {
        if (this.mTTSActionObservers != null) {
            Vector<ITTSActionObserver> copy = new Vector<>(this.mTTSActionObservers);
            for (int i2 = copy.size() - 1; i2 >= 0; i2--) {
                ITTSActionObserver observer = copy.get(i2);
                if (observer != null && observer.getClass() == clz) {
                    copy.remove(i2);
                }
            }
            this.mTTSActionObservers = copy;
        }
    }

    private void removeAllTTSActionObserver() {
        Vector<ITTSActionObserver> vector = this.mTTSActionObservers;
        if (vector != null) {
            vector.clear();
        }
    }

    private void reportFeedbackAction(String action, int position) {
        if (DEBUG) {
            Log.d(TAG, "NOTIFY:  reportFeedbackAction " + action + " " + position);
        }
        if (NetWorkUtils.isNetworkConnected()) {
            IFeedTTSContext.Impl.get().reportFeedAction(FeedTTSDispatcher.getInstance().getSpeechingFeed(), action, position);
        }
    }
}
