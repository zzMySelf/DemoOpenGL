package com.baidu.searchbox.feed.dependency.iocimpl.feedtts;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdmediacore.controller.MediaParams;
import com.baidu.searchbox.bdmediacore.interfaces.IBDMediaDataProvider;
import com.baidu.searchbox.bdmediacore.utils.MediaDataHelper;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.controller.PageDislikeDataManager;
import com.baidu.searchbox.feed.controller.TabDataManagerFactory;
import com.baidu.searchbox.feed.event.LoadMoreFeedRequest;
import com.baidu.searchbox.feed.model.DeleteItemData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedTtsModel;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.tts.model.TtsModelHelper;
import com.baidu.searchbox.feed.util.FeedUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FeedTtsBaseMediaDataProvider implements IBDMediaDataProvider {
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final String TAG = "BDMEDIA-mainDp";
    protected volatile boolean isLoadingMore;
    protected IFeedTTSModel mCur;
    private int mCurrentIndex;
    protected IFeedTTSModel mNext;
    protected IFeedTTSModel mPrev;
    protected IFeedTTSModel mSnapshotCur;
    private MediaMetadataCompat mTempData;

    private void initPlayList(Bundle params) {
        List<IFeedTTSModel> feedsForTTS = queryNowBizList(params);
        IFeedTTSModel feedTts = findFromBizListByMediaId(feedsForTTS, params.getString(MediaParams.KEY_DATA_ID));
        if (feedTts != null) {
            params.putParcelable(MediaParams.KEY_TARGET_DATA, MediaDataHelper.convertFeetTtsToMeta(feedTts));
            params.setClassLoader(MediaMetadataCompat.class.getClassLoader());
        }
        findReadableFeed(feedsForTTS, params);
    }

    private IFeedTTSModel findFromBizListByMediaId(List<IFeedTTSModel> bizList, String bizId) {
        for (IFeedTTSModel ttsModel : new ArrayList<>(bizList)) {
            if (ttsModel != null && TextUtils.equals(ttsModel.getId(), bizId)) {
                return ttsModel;
            }
        }
        return null;
    }

    public List<IFeedTTSModel> queryNowBizList(Bundle params) {
        if (DEBUG) {
            Log.d(TAG, "queryNowBizList: Bundle = " + params);
        }
        params.setClassLoader(MediaMetadataCompat.class.getClassLoader());
        String channelID = params.getString(MediaParams.KEY_CHANNEL_ID);
        if (TextUtils.isEmpty(channelID)) {
            return new ArrayList();
        }
        List<IFeedTTSModel> feedsForTTS = changeFeedsListForBusiness(FeedDataConverter.convertCombineList2Flat(getTTSFeeds(channelID)), this.mCur);
        removeFeeds(feedsForTTS, getRemoveFeedIds());
        return feedsForTTS;
    }

    private boolean isModelSuiteAutoPlay(IFeedTTSModel feed, boolean skipTopFixed, boolean ignorReaded) {
        if (feed == null) {
            return false;
        }
        if (skipTopFixed && feed.isTopFixed()) {
            return false;
        }
        if ((!feed.isVideoTts() || feed.isAutoVideoTts()) && !feed.getResNotSuitableTts()) {
            return feed.isReadable(ignorReaded);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void findReadableFeed(List<IFeedTTSModel> feedList, Bundle params) {
        Bundle params2;
        List<IFeedTTSModel> list = feedList;
        if (list != null && feedList.size() > 0) {
            if (params == null) {
                params2 = new Bundle();
            } else {
                params2 = params;
            }
            params2.setClassLoader(MediaMetadataCompat.class.getClassLoader());
            IFeedTTSModel toSpeechFeed = findFromBizListByMediaId(list, MediaDataHelper.getIdFromMediaMetadata((MediaMetadataCompat) params2.getParcelable(MediaParams.KEY_TARGET_DATA)));
            boolean skipTopFixed = params2.getBoolean(MediaParams.KEY_SKIPTOPFIX, true);
            int speechingFeedIndex = -1;
            int index = -1;
            Iterator<IFeedTTSModel> it = feedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IFeedTTSModel feed = it.next();
                index++;
                if (feed != null) {
                    if (toSpeechFeed == null) {
                        if (isModelSuiteAutoPlay(feed, skipTopFixed, false)) {
                            speechingFeedIndex = index;
                            break;
                        }
                    } else if (TtsModelHelper.INSTANCE.isFeedEquals(feed, toSpeechFeed)) {
                        speechingFeedIndex = index;
                        break;
                    }
                }
            }
            int size = feedList.size();
            if (speechingFeedIndex < 0 || speechingFeedIndex >= size) {
                this.mCur = null;
                this.mCurrentIndex = -1;
                if (DEBUG) {
                    Log.d(TAG, "findReadableFeed: mCur = " + null);
                }
            } else {
                IFeedTTSModel iFeedTTSModel = list.get(speechingFeedIndex);
                this.mCur = iFeedTTSModel;
                if (DEBUG) {
                    if (iFeedTTSModel != null) {
                        Log.d(TAG, "findReadableFeed: mCur = " + this.mCur.getId() + " - " + speechingFeedIndex + " - " + this.mCur.getTTSShowTitle());
                    } else {
                        Log.d(TAG, "findReadableFeed: mCur = " + null);
                    }
                }
                params2.putInt(MediaParams.KEY_POSITION, speechingFeedIndex);
                this.mCurrentIndex = speechingFeedIndex;
            }
            if (this.mCur == null) {
                this.mPrev = null;
                this.mNext = null;
                return;
            }
            boolean isNextToFirst = params2.getBoolean(MediaParams.KEY_IS_NEXT_TO_FIRST, false);
            if (isNextToFirst) {
                this.mPrev = null;
            } else {
                int preIndex = speechingFeedIndex - 1;
                while (preIndex >= 0 && preIndex < size && !isModelSuiteAutoPlay(list.get(preIndex), true, true)) {
                    preIndex--;
                }
                if (preIndex < 0 || preIndex >= size) {
                    this.mPrev = null;
                } else {
                    this.mPrev = list.get(preIndex);
                    if (DEBUG) {
                        Log.d(TAG, "findReadableFeed: mPrev = " + preIndex + " - " + this.mPrev);
                    }
                }
            }
            int nextIndex = isNextToFirst ? 0 : speechingFeedIndex + 1;
            while (true) {
                if (nextIndex < 0 || nextIndex >= size) {
                } else {
                    Bundle params3 = params2;
                    if (isModelSuiteAutoPlay(list.get(nextIndex), true, false)) {
                        break;
                    }
                    nextIndex++;
                    params2 = params3;
                }
            }
            if (nextIndex < 0 || nextIndex >= size) {
                this.mNext = null;
                return;
            }
            this.mNext = list.get(nextIndex);
            if (DEBUG) {
                Log.d(TAG, "findReadableFeed: mNext = " + nextIndex + " - " + this.mNext);
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<String> getRemoveFeedIds() {
        ArrayList<DeleteItemData> deleteFeeds = PageDislikeDataManager.getInstance().query();
        List<String> deleteFeedIds = new ArrayList<>();
        Iterator<DeleteItemData> it = deleteFeeds.iterator();
        while (it.hasNext()) {
            DeleteItemData deleteItemData = it.next();
            deleteFeedIds.add(deleteItemData.nid + "_" + deleteItemData.tabId);
        }
        return deleteFeedIds;
    }

    /* access modifiers changed from: protected */
    public List<IFeedTTSModel> getTTSFeeds(String tabId) {
        return FeedUtil.toTTSModelList(TabDataManagerFactory.getDataManager(tabId).getHistoryCachedFeeds());
    }

    /* access modifiers changed from: protected */
    public List<IFeedTTSModel> changeFeedsListForBusiness(List<IFeedTTSModel> feeds, IFeedTTSModel speeching) {
        if (feeds != null) {
            FeedTtsModel speechingFeed = (FeedTtsModel) speeching;
            if (speeching != null && !ttsDataInList(speechingFeed, feeds)) {
                if (speeching.isLandingTTS()) {
                    FeedTtsModel topModel = ((FeedTtsModel) speeching).innerModel;
                    if (topModel != null) {
                        FeedBaseModel feedBaseModel = topModel.getFeedBaseModel();
                        FeedBaseModel baseModel = feedBaseModel;
                        if (!(feedBaseModel == null || baseModel.data == null)) {
                            feeds.add(0, topModel);
                        }
                    }
                } else {
                    FeedBaseModel feedBaseModel2 = speechingFeed.getFeedBaseModel();
                    FeedBaseModel baseModel2 = feedBaseModel2;
                    if (!(feedBaseModel2 == null || baseModel2.data == null)) {
                        feeds.add(0, speeching);
                    }
                }
            }
        }
        return feeds;
    }

    /* access modifiers changed from: protected */
    public boolean ttsDataInList(IFeedTTSModel ttsData, List<IFeedTTSModel> list) {
        if (list == null || ttsData == null) {
            return false;
        }
        for (IFeedTTSModel isFeedEquals : list) {
            if (TtsModelHelper.INSTANCE.isFeedEquals(ttsData, isFeedEquals)) {
                return true;
            }
        }
        return false;
    }

    protected static List<IFeedTTSModel> removeFeeds(List<IFeedTTSModel> srcFeeds, List<String> deleteFeedIds) {
        for (int i2 = srcFeeds.size() - 1; i2 >= 0; i2--) {
            IFeedTTSModel feed = srcFeeds.get(i2);
            if (deleteFeedIds.contains(feed.getId() + "_" + feed.getChannelId())) {
                srcFeeds.remove(i2);
            }
        }
        return srcFeeds;
    }

    public MediaMetadataCompat getCurrentData() {
        IFeedTTSModel iFeedTTSModel = this.mCur;
        if (iFeedTTSModel == null) {
            return null;
        }
        return MediaDataHelper.convertFeetTtsToMeta(iFeedTTSModel);
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public List<MediaMetadataCompat> getCurrentList(Bundle bundle) {
        if (this.mCur == null) {
            initPlayList(bundle);
        }
        List<MediaMetadataCompat> result = new ArrayList<>();
        IFeedTTSModel iFeedTTSModel = this.mPrev;
        if (iFeedTTSModel != null) {
            result.add(MediaDataHelper.convertFeetTtsToMeta(iFeedTTSModel));
        }
        IFeedTTSModel iFeedTTSModel2 = this.mCur;
        if (iFeedTTSModel2 != null) {
            result.add(MediaDataHelper.convertFeetTtsToMeta(iFeedTTSModel2));
        }
        IFeedTTSModel iFeedTTSModel3 = this.mNext;
        if (iFeedTTSModel3 != null) {
            result.add(MediaDataHelper.convertFeetTtsToMeta(iFeedTTSModel3));
        }
        return result;
    }

    public MediaMetadataCompat findByIdUpdateIndex(String mediaId, Bundle params) {
        IFeedTTSModel iFeedTTSModel = this.mPrev;
        if (iFeedTTSModel != null && TextUtils.equals(iFeedTTSModel.getId(), mediaId)) {
            return moveToPrevious(params);
        }
        IFeedTTSModel iFeedTTSModel2 = this.mNext;
        if (iFeedTTSModel2 != null && TextUtils.equals(iFeedTTSModel2.getId(), mediaId)) {
            return moveToNext(params);
        }
        if (this.mCur != null) {
            markNowListNoneState();
        }
        List<IFeedTTSModel> bizList = queryNowBizList(params);
        IFeedTTSModel feedTts = findFromBizListByMediaId(bizList, mediaId);
        if (feedTts == null) {
            return null;
        }
        params.putParcelable(MediaParams.KEY_TARGET_DATA, MediaDataHelper.convertFeetTtsToMeta(feedTts));
        params.setClassLoader(MediaMetadataCompat.class.getClassLoader());
        findReadableFeed(bizList, params);
        return MediaDataHelper.convertFeetTtsToMeta(this.mCur);
    }

    public <T> T findMediaByIdNotUpdateIndex(String mediaId, Bundle bundle, Class<T> cls) {
        if (TextUtils.isEmpty(mediaId)) {
            return null;
        }
        IFeedTTSModel iFeedTTSModel = this.mPrev;
        if (iFeedTTSModel != null && TextUtils.equals(iFeedTTSModel.getId(), mediaId)) {
            return this.mPrev;
        }
        IFeedTTSModel iFeedTTSModel2 = this.mCur;
        if (iFeedTTSModel2 != null && TextUtils.equals(iFeedTTSModel2.getId(), mediaId)) {
            return this.mCur;
        }
        IFeedTTSModel iFeedTTSModel3 = this.mNext;
        if (iFeedTTSModel3 == null || !TextUtils.equals(iFeedTTSModel3.getId(), mediaId)) {
            return findFromBizListByMediaId(queryNowBizList(bundle), mediaId);
        }
        return this.mNext;
    }

    public void clearDatas(Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "clearDatas");
        }
        this.mCur = null;
        this.mNext = null;
        this.mPrev = null;
        this.mTempData = null;
        this.isLoadingMore = false;
        this.mCurrentIndex = -1;
    }

    public MediaMetadataCompat getPreviousData(Bundle bundle) {
        IFeedTTSModel iFeedTTSModel = this.mPrev;
        if (iFeedTTSModel == null) {
            return null;
        }
        return MediaDataHelper.convertFeetTtsToMeta(iFeedTTSModel);
    }

    public MediaMetadataCompat getNextData(Bundle bundle) {
        IFeedTTSModel iFeedTTSModel = this.mNext;
        if (iFeedTTSModel == null) {
            return null;
        }
        return MediaDataHelper.convertFeetTtsToMeta(iFeedTTSModel);
    }

    public MediaMetadataCompat getTempData() {
        return this.mTempData;
    }

    public void setTempData(MediaMetadataCompat metadata) {
        this.mTempData = metadata;
    }

    public void delete(MediaMetadataCompat deletedItem, Bundle bundle, IBDMediaDataProvider.DataCallback dataCallback) {
        IFeedTTSModel delTts;
        IFeedTTSModel feedTts;
        if (deletedItem != null && (delTts = (IFeedTTSModel) findMediaByIdNotUpdateIndex(MediaDataHelper.getIdFromMediaMetadata(deletedItem), bundle, IFeedTTSModel.class)) != null) {
            boolean isDelTtsInMem = false;
            IFeedTTSModel targetData = null;
            if (this.mPrev != null && TextUtils.equals(delTts.getId(), this.mPrev.getId())) {
                isDelTtsInMem = true;
                targetData = this.mCur;
            }
            if (!isDelTtsInMem && this.mCur != null && TextUtils.equals(delTts.getId(), this.mCur.getId())) {
                isDelTtsInMem = true;
                IFeedTTSModel iFeedTTSModel = this.mNext;
                if (iFeedTTSModel == null) {
                    iFeedTTSModel = this.mPrev;
                }
                targetData = iFeedTTSModel;
            }
            if (!isDelTtsInMem && this.mNext != null && TextUtils.equals(delTts.getId(), this.mNext.getId())) {
                isDelTtsInMem = true;
                targetData = this.mCur;
            }
            if (isDelTtsInMem) {
                bundle.putString(MediaParams.KEY_CHANNEL_ID, delTts.getChannelId());
                List<IFeedTTSModel> feedsForTTS = queryNowBizList(bundle);
                if (!(targetData == null || (feedTts = findFromBizListByMediaId(feedsForTTS, targetData.getId())) == null)) {
                    bundle.putParcelable(MediaParams.KEY_TARGET_DATA, MediaDataHelper.convertFeetTtsToMeta(feedTts));
                    bundle.setClassLoader(MediaMetadataCompat.class.getClassLoader());
                }
                findReadableFeed(feedsForTTS, bundle);
            }
            dataCallback.onSuccess();
        }
    }

    public void refreshPlayList(Bundle bundle, IBDMediaDataProvider.DataCallback dataCallback) {
        this.isLoadingMore = false;
        IFeedTTSModel iFeedTTSModel = this.mCur;
        String bizId = iFeedTTSModel != null ? iFeedTTSModel.getId() : "";
        List<IFeedTTSModel> feedsForTTS = queryNowBizList(bundle);
        IFeedTTSModel feedTts = null;
        if (!TextUtils.isEmpty(bizId)) {
            feedTts = findFromBizListByMediaId(feedsForTTS, bizId);
        }
        if (feedTts != null) {
            bundle.putParcelable(MediaParams.KEY_TARGET_DATA, MediaDataHelper.convertFeetTtsToMeta(feedTts));
            bundle.setClassLoader(MediaMetadataCompat.class.getClassLoader());
        }
        findReadableFeed(feedsForTTS, bundle);
        if (dataCallback != null) {
            dataCallback.onSuccess();
        }
    }

    public boolean hasPrevious(Bundle bundle) {
        return this.mPrev != null;
    }

    public MediaMetadataCompat moveToPrevious(Bundle bundle) {
        markNowListNoneState();
        IFeedTTSModel targetData = this.mPrev;
        List<IFeedTTSModel> feedsForTTS = queryNowBizList(bundle);
        bundle.putParcelable(MediaParams.KEY_TARGET_DATA, MediaDataHelper.convertFeetTtsToMeta(targetData));
        bundle.setClassLoader(MediaMetadataCompat.class.getClassLoader());
        findReadableFeed(feedsForTTS, bundle);
        return MediaDataHelper.convertFeetTtsToMeta(this.mCur);
    }

    public boolean hasNext(Bundle bundle) {
        return this.mNext != null;
    }

    public MediaMetadataCompat moveToNext(Bundle bundle) {
        markNowListNoneState();
        IFeedTTSModel iFeedTTSModel = this.mNext;
        if (iFeedTTSModel == null) {
            return null;
        }
        IFeedTTSModel targetData = this.mNext;
        bundle.putString(MediaParams.KEY_CHANNEL_ID, iFeedTTSModel.getChannelId());
        List<IFeedTTSModel> feedsForTTS = queryNowBizList(bundle);
        bundle.putParcelable(MediaParams.KEY_TARGET_DATA, MediaDataHelper.convertFeetTtsToMeta(targetData));
        bundle.setClassLoader(MediaMetadataCompat.class.getClassLoader());
        findReadableFeed(feedsForTTS, bundle);
        return MediaDataHelper.convertFeetTtsToMeta(this.mCur);
    }

    public void loadMore(Bundle bundle, IBDMediaDataProvider.DataCallback dataCallback) {
        if (!this.isLoadingMore) {
            if (DEBUG) {
                Log.d(TAG, "loadMore: ");
            }
            this.isLoadingMore = true;
            LoadMoreFeedRequest request = new LoadMoreFeedRequest();
            request.channelId = bundle.getString(MediaParams.KEY_CHANNEL_ID);
            BdEventBus.Companion.getDefault().post(request);
        }
    }

    public void clearDatasExceptSpeeching() {
        this.mPrev = null;
        this.mNext = null;
    }

    public void resetLoadMoreFlag() {
        this.isLoadingMore = false;
    }

    public boolean isLoadingMore() {
        return this.isLoadingMore;
    }

    public <T> List<T> queryMoreItems(Bundle bundle, Class<T> cls) {
        List<IFeedTTSModel> ttsList = queryNowBizList(bundle);
        int prefetchCount = bundle.getInt(MediaParams.KEY_PREFETCH_COUNT);
        String startMid = bundle.getString(MediaParams.KEY_DATA_ID);
        boolean speechingFeedFinded = false;
        List<T> nexts = new ArrayList<>(prefetchCount);
        for (IFeedTTSModel feedBaseModel : ttsList) {
            if (feedBaseModel != null) {
                if (speechingFeedFinded) {
                    if (isModelSuiteAutoPlay(feedBaseModel, true, false)) {
                        nexts.add(feedBaseModel);
                        if (nexts.size() >= prefetchCount) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (TtsModelHelper.INSTANCE.isFeedEquals(feedBaseModel, startMid)) {
                    speechingFeedFinded = true;
                }
            }
        }
        return nexts;
    }

    private void markNowListNoneState() {
        IFeedTTSModel iFeedTTSModel = this.mPrev;
        if (iFeedTTSModel != null) {
            iFeedTTSModel.setTtsState(0);
        }
        IFeedTTSModel iFeedTTSModel2 = this.mCur;
        if (iFeedTTSModel2 != null) {
            iFeedTTSModel2.setTtsState(0);
        }
        IFeedTTSModel iFeedTTSModel3 = this.mNext;
        if (iFeedTTSModel3 != null) {
            iFeedTTSModel3.setTtsState(0);
        }
    }

    public void createSnapshot() {
        this.mSnapshotCur = this.mCur;
    }

    public void restoreFromSnapshot() {
        IFeedTTSModel iFeedTTSModel = this.mSnapshotCur;
        this.mCur = iFeedTTSModel;
        if (iFeedTTSModel != null) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaParams.KEY_CHANNEL_ID, this.mCur.getChannelId());
            refreshPlayList(bundle, (IBDMediaDataProvider.DataCallback) null);
            this.mSnapshotCur = null;
        }
    }
}
