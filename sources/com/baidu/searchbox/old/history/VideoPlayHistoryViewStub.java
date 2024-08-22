package com.baidu.searchbox.old.history;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.searchbox.VideoPlayHistoryActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.old.history.VideoPlayHistoryItem;
import com.baidu.searchbox.player.model.VideoPlayHistoryItemInfo;
import com.baidu.searchbox.video.R;
import com.baidu.searchbox.video.util.VideoDBControlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoPlayHistoryViewStub {
    /* access modifiers changed from: private */
    public VideoHistoryAdapter mAdapter;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<String> mDelList;
    /* access modifiers changed from: private */
    public boolean mEditMode;
    FrameLayout mEmptyView;
    /* access modifiers changed from: private */
    public Handler mHandler;
    ListView mHistoryListView;
    /* access modifiers changed from: private */
    public VideoPlayHistoryActivity mHomeActivity;
    /* access modifiers changed from: private */
    public boolean mSelectAll;
    /* access modifiers changed from: private */
    public VideoPlayHistoryItem.SelectListener mSelectListener;
    private ArrayList<VideoPlayHistoryItemInfo> mVideoList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View root = inflater.inflate(R.layout.video_webapp_video_play_history, (ViewGroup) null);
        this.mContext = inflater.getContext();
        initData();
        this.mHandler = new Handler(this.mContext.getMainLooper());
        this.mHistoryListView = (ListView) root.findViewById(R.id.video_history_listview);
        this.mAdapter = new VideoHistoryAdapter();
        ArrayList<VideoPlayHistoryItemInfo> arrayList = new ArrayList<>();
        this.mVideoList = arrayList;
        this.mAdapter.setData(arrayList);
        this.mHistoryListView.setAdapter(this.mAdapter);
        FrameLayout frameLayout = (FrameLayout) root.findViewById(R.id.empty);
        this.mEmptyView = frameLayout;
        this.mHistoryListView.setEmptyView(frameLayout);
        this.mEditMode = false;
        this.mSelectAll = false;
        this.mDelList = new ArrayList<>();
        return root;
    }

    public void initData() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                if (VideoPlayHistoryViewStub.this.mHandler != null) {
                    VideoPlayHistoryViewStub.this.mHandler.post(new Runnable() {
                        public void run() {
                            VideoPlayHistoryViewStub.this.updateAdapterData();
                            ArrayList<VideoPlayHistoryItemInfo> infoList = VideoPlayHistoryViewStub.this.mAdapter.getData();
                            if (infoList != null) {
                                int count = 0;
                                Iterator<VideoPlayHistoryItemInfo> it = infoList.iterator();
                                while (it.hasNext()) {
                                    if (!TextUtils.isEmpty(it.next().getVid())) {
                                        count++;
                                    }
                                }
                                if (count >= 1) {
                                    VideoPlayHistoryViewStub.this.mHomeActivity.showAddCardDialog();
                                }
                            }
                        }
                    });
                }
            }
        }, "video_play_history_init_thread", 1);
    }

    /* access modifiers changed from: private */
    public void updateAdapterData() {
        boolean z = false;
        List<VideoPlayHistoryItemInfo> result = VideoPlayHistoryManager.getInstance(this.mContext).getFilterPlayHistoryItemInfoList(false);
        this.mVideoList.clear();
        this.mVideoList.addAll(result);
        this.mAdapter.setData(this.mVideoList);
        this.mAdapter.notifyDataSetChanged();
        VideoPlayHistoryActivity videoPlayHistoryActivity = this.mHomeActivity;
        if (this.mVideoList.size() > 0) {
            z = true;
        }
        videoPlayHistoryActivity.setEditButtonVisible(z);
    }

    public void updateUI() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                if (VideoPlayHistoryViewStub.this.mHandler != null) {
                    VideoPlayHistoryViewStub.this.mHandler.post(new Runnable() {
                        public void run() {
                            VideoPlayHistoryViewStub.this.updateAdapterData();
                        }
                    });
                }
            }
        }, "video_history_update_ui", 1);
    }

    public void setHomeActivity(VideoPlayHistoryActivity homeActivity) {
        this.mHomeActivity = homeActivity;
    }

    public ArrayList<VideoPlayHistoryItemInfo> getDisplayInfos() {
        VideoHistoryAdapter videoHistoryAdapter = this.mAdapter;
        if (videoHistoryAdapter != null) {
            return videoHistoryAdapter.getData();
        }
        return null;
    }

    public void cancelEditMode() {
        this.mEditMode = false;
        this.mSelectAll = false;
        ArrayList<String> arrayList = this.mDelList;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mAdapter.notifyDataSetChanged();
    }

    public void enableEditMode() {
        this.mEditMode = true;
        this.mAdapter.notifyDataSetChanged();
    }

    public void selectAll(boolean select) {
        if (select) {
            this.mSelectAll = true;
            this.mDelList.clear();
            Iterator<VideoPlayHistoryItemInfo> it = this.mAdapter.getData().iterator();
            while (it.hasNext()) {
                this.mDelList.add(it.next().getId());
            }
        } else {
            this.mSelectAll = false;
            this.mDelList.clear();
        }
        this.mHomeActivity.setSelectedCount(this.mDelList.size());
        this.mAdapter.notifyDataSetChanged();
    }

    public class VideoHistoryAdapter extends BaseAdapter {
        private ArrayList<VideoPlayHistoryItemInfo> mDataList = new ArrayList<>();

        public VideoHistoryAdapter() {
        }

        public void setData(ArrayList<VideoPlayHistoryItemInfo> dataList) {
            if (dataList != null) {
                this.mDataList.clear();
                this.mDataList.addAll(dataList);
                notifyDataSetChanged();
                return;
            }
            this.mDataList.clear();
        }

        public ArrayList<VideoPlayHistoryItemInfo> getData() {
            return this.mDataList;
        }

        public int getCount() {
            return this.mDataList.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = new VideoPlayHistoryItem(VideoPlayHistoryViewStub.this.mContext);
                if (VideoPlayHistoryViewStub.this.mSelectListener == null) {
                    VideoPlayHistoryItem.SelectListener unused = VideoPlayHistoryViewStub.this.mSelectListener = new VideoPlayHistoryItem.SelectListener() {
                        public void onSelected(String videoId, boolean selected) {
                            if (selected) {
                                VideoPlayHistoryViewStub.this.mDelList.add(videoId);
                                if (VideoPlayHistoryViewStub.this.mDelList.size() == VideoPlayHistoryViewStub.this.mAdapter.getCount()) {
                                    VideoPlayHistoryViewStub.this.mHomeActivity.setAllSelectedBtnState(true);
                                }
                            } else {
                                VideoPlayHistoryViewStub.this.mDelList.remove(videoId);
                                if (VideoPlayHistoryViewStub.this.mDelList.size() != VideoPlayHistoryViewStub.this.mAdapter.getCount()) {
                                    VideoPlayHistoryViewStub.this.mHomeActivity.setAllSelectedBtnState(false);
                                }
                            }
                            VideoPlayHistoryViewStub.this.mHomeActivity.setSelectedCount(VideoPlayHistoryViewStub.this.mDelList.size());
                        }

                        public void onLongClick() {
                            if (!VideoPlayHistoryViewStub.this.mEditMode) {
                                VideoPlayHistoryViewStub.this.mHomeActivity.beginEdit();
                            } else {
                                VideoPlayHistoryViewStub.this.mHomeActivity.endEdit();
                            }
                        }
                    };
                }
                ((VideoPlayHistoryItem) convertView).setSelectListener(VideoPlayHistoryViewStub.this.mSelectListener);
                convertView.setLayoutParams(new AbsListView.LayoutParams(-1, VideoPlayHistoryViewStub.this.mHomeActivity.getResources().getDimensionPixelSize(R.dimen.video_play_history_item_height)));
            }
            VideoPlayHistoryItem item = (VideoPlayHistoryItem) convertView;
            item.updateData(this.mDataList.get(position));
            item.showEditMode(VideoPlayHistoryViewStub.this.mEditMode);
            item.select(VideoPlayHistoryViewStub.this.mSelectAll);
            return item;
        }
    }

    public int getDelCount() {
        ArrayList<String> arrayList = this.mDelList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void delItems() {
        if (this.mDelList != null) {
            ArrayList<VideoPlayHistoryItemInfo> delList = new ArrayList<>();
            Iterator<String> it = this.mDelList.iterator();
            while (it.hasNext()) {
                String videoId = it.next();
                VideoDBControlUtils.getInstance().delPlayHistoryItem(videoId);
                Iterator<VideoPlayHistoryItemInfo> it2 = this.mAdapter.getData().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    VideoPlayHistoryItemInfo info = it2.next();
                    if (TextUtils.equals(info.getId(), videoId)) {
                        delList.add(info);
                        VideoDBControlUtils.getInstance().delPlayHistoryItemByVid(info.getVid());
                        break;
                    }
                }
            }
            this.mAdapter.getData().removeAll(delList);
        }
        if (this.mSelectAll) {
            VideoDBControlUtils.getInstance().delAllPlayHistoryItems();
            ArrayList<String> arrayList = this.mDelList;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.mAdapter.getData().clear();
        }
        this.mEditMode = false;
        this.mAdapter.notifyDataSetChanged();
    }
}
