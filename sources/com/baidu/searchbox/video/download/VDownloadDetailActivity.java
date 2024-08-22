package com.baidu.searchbox.video.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.baidu.android.ext.widget.LoadingViewHelper;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.appframework.ActionBarBaseActivity;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.center.ui.video.VideoEpisodeDownloadItemInfo;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.export.IVideoIdentityManager;
import com.baidu.searchbox.video.detail.utils.VideoUrlConfig;
import com.baidu.searchbox.video.download.VideoDownloadConstant;
import com.baidu.searchbox.video.runtime.VideoRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VDownloadDetailActivity extends ActionBarBaseActivity implements OnDataChangedListener, LoaderManager.LoaderCallbacks<HashMap<String, Integer>> {
    public static final boolean DEBUG = VideoRuntime.DEBUG;
    private static final String TAG = "VDownloadDetailActivity";
    public static final String VIDEO_VIDEO_DETAIL_DOWNLOAD_BUTTON_CLICK = "017909";
    /* access modifiers changed from: private */
    public boolean isScrollable = true;
    /* access modifiers changed from: private */
    public VideoEpisodeItemAdapter mAdapter;
    final AdapterView.OnItemClickListener mAdapterItemClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view2, int position, long id) {
            if (VDownloadDetailActivity.this.mIsNetWorkEnable) {
                VideoEpisodeItem subitem = VDownloadDetailActivity.this.mItem.getSubList().get(position);
                if (subitem == null) {
                    return;
                }
                if (subitem.getEpiStatus() == 0) {
                    subitem.setFormat(VDownloadDetailActivity.this.mSelectedformat);
                    subitem.setSite(VDownloadDetailActivity.this.mItem.getSiteName());
                    subitem.setGetURL(true);
                    VDownloadDetailActivity.this.changeEpisodeStatus(subitem, 3);
                    VDownloadDetailActivity.this.getDownloadUrl(subitem);
                } else if (subitem.getEpiStatus() == 2) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) VDownloadDetailActivity.this.getResources().getString(R.string.video_downloaded_tip)).showToast();
                } else {
                    UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) VDownloadDetailActivity.this.getResources().getString(R.string.video_downloading_tip)).showToast();
                }
            } else {
                UniversalToast.makeText(VDownloadDetailActivity.this.mContext.getApplicationContext(), R.string.video_download_no_wifi_tip).showToast();
            }
        }
    };
    LoaderManager.LoaderCallbacks<HashMap<String, Integer>> mCallbacks;
    /* access modifiers changed from: private */
    public Context mContext;
    private VGetDownloadDataManager mDownloadManager;
    private final BroadcastReceiver mEpisodeDownloadCompletedReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (VDownloadDetailActivity.DEBUG) {
                Log.e(VDownloadDetailActivity.TAG, "downloadCompletedReceiver");
            }
            String action = intent.getAction();
            if (action != null && DownloadConstants.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                VDownloadDetailActivity.this.restartLoader();
            }
        }
    };
    private LinearLayout mFooterView;
    /* access modifiers changed from: private */
    public TextView mFormatSelector;
    private GridView mGridView;
    private boolean mIsDesc = true;
    private boolean mIsHasDownloading = false;
    /* access modifiers changed from: private */
    public boolean mIsLast = false;
    private boolean mIsLoadingData = false;
    /* access modifiers changed from: private */
    public boolean mIsNetWorkEnable = true;
    /* access modifiers changed from: private */
    public VideoDownloadItem mItem;
    final BdMenuItem.OnItemClickListener mItemListener = new BdMenuItem.OnItemClickListener() {
        public void onClick(BdMenuItem item) {
            String format = VDownloadDetailActivity.this.mItem.getFormatList().get(item.getItemId());
            String unused = VDownloadDetailActivity.this.mSelectedformat = VideoDownloadConstant.mDictionaryMap.get(format);
            VDownloadDetailActivity.this.mFormatSelector.setText(format);
        }
    };
    private ListView mListView;
    private final BroadcastReceiver mNetChangeReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (NetWorkUtils.getActiveNetworkInfo(context) == null) {
                UniversalToast.makeText(VDownloadDetailActivity.this.mContext.getApplicationContext(), R.string.video_download_no_wifi_tip).showToast();
                boolean unused = VDownloadDetailActivity.this.mIsNetWorkEnable = false;
                return;
            }
            boolean unused2 = VDownloadDetailActivity.this.mIsNetWorkEnable = true;
        }
    };
    private TextView mNewTipTextView;
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() {
        public void onScrollStateChanged(AbsListView view2, int scrollState) {
            if (VDownloadDetailActivity.this.isScrollable && VDownloadDetailActivity.this.mIsLast && scrollState == 0 && VDownloadDetailActivity.this.mItem.isHasNextPage()) {
                boolean unused = VDownloadDetailActivity.this.mIsLast = false;
                VDownloadDetailActivity vDownloadDetailActivity = VDownloadDetailActivity.this;
                vDownloadDetailActivity.loadData(vDownloadDetailActivity.mItem.getSubList().size(), VideoDownloadConstant.LoadDataTYPE.LOADDATA);
            }
        }

        public void onScroll(AbsListView view2, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (firstVisibleItem + visibleItemCount >= totalItemCount - 1 && totalItemCount > 0) {
                boolean unused = VDownloadDetailActivity.this.mIsLast = true;
            }
        }
    };
    private RelativeLayout mRoot;
    /* access modifiers changed from: private */
    public String mSelectedformat;
    private String mSite;
    private String mVid;
    private VideoDownloadMenu mVideoDownloadMenu;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            this.mVid = intent.getExtras().getString("video_id");
            this.mSite = intent.getExtras().getString("site");
        }
        this.mDownloadManager = new VGetDownloadDataManager(this);
        this.mCallbacks = this;
        this.mContext = this;
        BaiduIdentityManager.getInstance(this).getOriginUserAgent();
        registerDownloadCompletedReceiver();
        registerNetWorkChangeReceiver();
        initView();
        loadData(0, VideoDownloadConstant.LoadDataTYPE.INITDATA);
        if (intent.getExtras() == null) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        restartLoader();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void getDownloadUrl(final VideoEpisodeItem subitem) {
        VDownUrlGetInfo info = new VDownUrlGetInfo();
        info.setEpisodeId(subitem.getEpisodeId());
        info.setFormat(subitem.getFormat());
        info.setListener(new VGetDownUrlListener() {
            public void onUrlGet(String url, final int statusCode, final VideoDownloadGMV videoDownloadGMV) {
                subitem.setGetURL(false);
                if (statusCode == 10000) {
                    if (VDownloadDetailActivity.DEBUG) {
                        Log.e(VDownloadDetailActivity.TAG, "url:" + url);
                    }
                    VDownloadDetailActivity.this.downloadVideo(url, subitem);
                    return;
                }
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) VDownloadDetailActivity.this.mContext.getText(R.string.video_download_get_token_fail) + " " + statusCode).showToast();
                        subitem.setEpiStatus(0);
                        VDownloadDetailActivity.this.mAdapter.notifyDataSetChanged();
                        VideoDownloadStatistic.sendVideoDownloadGMVMsg(videoDownloadGMV);
                    }
                });
            }
        });
        VGetDownUrlManager.getInstance().doDownload(info);
    }

    /* access modifiers changed from: protected */
    public void downloadVideo(String url, VideoEpisodeItem subitem) {
        VideoDownloadDBManager.getInstance().downloadVideo(this, url, this.mItem, buildSubInfo(subitem));
    }

    private VideoEpisodeDownloadItemInfo buildSubInfo(VideoEpisodeItem subitem) {
        VideoEpisodeDownloadItemInfo subInfo = new VideoEpisodeDownloadItemInfo();
        subInfo.setVid(this.mItem.getVid());
        subInfo.setEpisodeId(subitem.getEpisodeId());
        subInfo.setEpisodeTitle(subitem.getEpisodeTitle());
        subInfo.setEpisodeNo(subitem.getEpisodeNo());
        subInfo.setPosterUrl(subitem.getPosterUrl());
        subInfo.setFormat(subitem.getFormat());
        subInfo.setSite(this.mSite);
        return subInfo;
    }

    private void updateView() {
        TextView sortText = (TextView) findViewById(com.baidu.searchbox.video.R.id.video_sort);
        if (this.mIsDesc) {
            sortText.setText(getResources().getString(R.string.video_download_sort_asc));
        } else {
            sortText.setText(getResources().getString(R.string.video_download_sort_dec));
        }
        if (this.mItem.getSubList().size() <= 1) {
            sortText.setVisibility(8);
        }
        sortText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VDownloadDetailActivity.this.sort(v);
            }
        });
        ((RelativeLayout) findViewById(com.baidu.searchbox.video.R.id.episode_download_button_layout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(VDownloadDetailActivity.this.getApplicationContext(), DownloadVideoTabActivity.class);
                intent.putExtra("from", VDownloadDetailActivity.class.getName());
                VDownloadDetailActivity.this.startActivity(intent);
                BaseActivity.setNextPendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_right, com.baidu.android.common.ui.style.R.anim.slide_out_to_left, com.baidu.android.common.ui.style.R.anim.slide_in_from_left, com.baidu.android.common.ui.style.R.anim.slide_out_to_right);
            }
        });
        TextView textView = (TextView) findViewById(com.baidu.searchbox.video.R.id.video_format_selector);
        this.mFormatSelector = textView;
        textView.setText(this.mItem.getFormatList().get(0));
        this.mSelectedformat = VideoDownloadConstant.mDictionaryMap.get(this.mItem.getFormatList().get(0));
        this.mFormatSelector.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VDownloadDetailActivity.this.showMenu(v);
            }
        });
        this.mSelectedformat = VideoDownloadConstant.mDictionaryMap.get(this.mItem.getFormatList().get(0));
        this.mAdapter = new VideoEpisodeItemAdapter(this, this.mItem.getSubList(), this.mItem.getCategory());
        if (this.mItem.getCategory().equals("tvplay") || this.mItem.getCategory().equals("comic")) {
            GridView gridView = (GridView) findViewById(com.baidu.searchbox.video.R.id.episode_gridview);
            this.mGridView = gridView;
            gridView.setVisibility(0);
            this.mGridView.setAdapter(this.mAdapter);
            this.mGridView.setOnItemClickListener(this.mAdapterItemClickListener);
            this.mGridView.setOnScrollListener(this.mOnScrollListener);
        } else {
            this.mListView = (ListView) findViewById(com.baidu.searchbox.video.R.id.episode_listview);
            this.mFooterView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(com.baidu.searchbox.video.R.layout.video_download_listview_footer, (ViewGroup) null);
            addFooterView();
            this.mListView.setAdapter(this.mAdapter);
            this.mListView.setOnItemClickListener(this.mAdapterItemClickListener);
            this.mListView.setVisibility(0);
            this.mListView.setOnScrollListener(this.mOnScrollListener);
        }
        this.isScrollable = true;
        this.mNewTipTextView = (TextView) findViewById(com.baidu.searchbox.video.R.id.download_new_tip_txt);
    }

    /* access modifiers changed from: private */
    public void initView() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(com.baidu.searchbox.video.R.layout.video_download_detail, (ViewGroup) null);
        this.mRoot = relativeLayout;
        setContentView((View) relativeLayout);
        initTitleBar();
    }

    private void initTitleBar() {
        setActionBarBackgroundColor(getResources().getColor(com.baidu.searchbox.video.R.color.video_feed_download_detail_titlebar_bg), BdActionBar.ActionbarTemplate.WHITE_TITLE_TEMPLATE);
        setActionBarTitle(R.string.video_download_detail_title);
    }

    /* access modifiers changed from: private */
    public void sort(View v) {
        TextView tempView = (TextView) v;
        if (this.mItem != null) {
            this.mDownloadManager.cancel();
            this.mIsLoadingData = false;
            if (this.mIsDesc) {
                this.mIsDesc = false;
                tempView.setText(getResources().getString(R.string.video_download_sort_dec));
            } else {
                this.mIsDesc = true;
                tempView.setText(getResources().getString(R.string.video_download_sort_asc));
            }
            this.mItem.getSubList().clear();
            this.mAdapter.notifyDataSetChanged();
            LinearLayout linearLayout = this.mFooterView;
            if (linearLayout != null) {
                this.mListView.removeFooterView(linearLayout);
            }
            loadData(0, VideoDownloadConstant.LoadDataTYPE.INITDATA);
        }
    }

    /* access modifiers changed from: private */
    public void loadData(int skip, VideoDownloadConstant.LoadDataTYPE type) {
        if (!this.mIsLoadingData) {
            String sort = "desc";
            if (!this.mIsDesc) {
                sort = "asc";
            }
            String url = IVideoIdentityManager.Impl.get().processUrl(VideoUrlConfig.getVideoDownloadUrl() + "site=" + this.mSite + "&video_id=" + this.mVid + "&order=" + sort + "&skip=" + skip);
            if (type != VideoDownloadConstant.LoadDataTYPE.LOADDATA) {
                LoadingViewHelper.showLoadingView(this.mContext, this.mRoot);
            }
            this.mIsLoadingData = true;
            this.mDownloadManager.getDataFromUrl(url, this, type);
        }
    }

    public void refresh(VideoDownloadItem data, VideoDownloadConstant.LoadDataTYPE type) {
        ListView listView;
        this.mIsLoadingData = false;
        if (type == VideoDownloadConstant.LoadDataTYPE.INITDATA) {
            if (data == null || data.getFormatList().size() <= 0) {
                setContentView(initErrorView());
                initTitleBar();
            } else {
                this.mItem = data;
                Bundle bundle = new Bundle();
                bundle.putString("video_id", this.mItem.getVid());
                if (getSupportLoaderManager().getLoader(0) == null) {
                    getSupportLoaderManager().initLoader(0, bundle, this.mCallbacks);
                } else {
                    restartLoader();
                }
                updateView();
            }
            LoadingViewHelper.removeLoadingView(this.mRoot);
        } else if (type == VideoDownloadConstant.LoadDataTYPE.LOADDATA && data != null && this.mItem.getSubList().size() > 0) {
            removeRepeat(this.mItem.getSubList(), data.getSubList());
            restartLoader();
            this.mItem.setHasNextPage(data.isHasNextPage());
            if (!this.isScrollable) {
                this.isScrollable = true;
            }
            if (!this.mItem.isHasNextPage() && (listView = this.mListView) != null) {
                listView.removeFooterView(this.mFooterView);
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void error(final VideoDownloadConstant.LoadDataTYPE type, VideoDownloadGMV videoDownloadGMV) {
        this.mIsLoadingData = false;
        LoadingViewHelper.removeLoadingView(this.mRoot);
        if (type == VideoDownloadConstant.LoadDataTYPE.INITDATA) {
            setContentView(initErrorView());
            initTitleBar();
        } else if (type == VideoDownloadConstant.LoadDataTYPE.LOADDATA && this.mFooterView != null) {
            changeFooterView(R.string.video_download_footer_error_text, 8);
            this.isScrollable = false;
            this.mFooterView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    VDownloadDetailActivity.this.changeFooterView(R.string.video_download_footer_text, 0);
                    VDownloadDetailActivity vDownloadDetailActivity = VDownloadDetailActivity.this;
                    vDownloadDetailActivity.loadData(vDownloadDetailActivity.mItem.getSubList().size(), type);
                }
            });
        }
        if (DEBUG) {
            Log.d(TAG, "load data error type: " + type);
            Log.d(TAG, "load error downloadGMV: " + videoDownloadGMV);
        }
        VideoDownloadStatistic.sendVideoDownloadGMVMsg(videoDownloadGMV);
    }

    /* access modifiers changed from: private */
    public void restartLoader() {
        if (DEBUG) {
            Log.e(TAG, "initLoader");
        }
        if (this.mItem != null && getSupportLoaderManager().getLoader(0) != null) {
            Bundle bundle = new Bundle();
            bundle.putString("video_id", this.mItem.getVid());
            getSupportLoaderManager().restartLoader(0, bundle, this.mCallbacks);
        }
    }

    public void changeEpisodeStatus(VideoEpisodeItem subitem, int status) {
        subitem.setEpiStatus(status);
        this.mAdapter.notifyDataSetChanged();
    }

    public Loader<HashMap<String, Integer>> onCreateLoader(int arg0, Bundle arg1) {
        return new VideoDownloadDataLoader(this, arg1);
    }

    public void onLoadFinished(Loader<HashMap<String, Integer>> loader, HashMap<String, Integer> map) {
        if (map != null && this.mItem != null) {
            for (int i2 = 0; i2 < this.mItem.getSubList().size(); i2++) {
                if (!this.mItem.getSubList().get(i2).isGetURL()) {
                    if (map.containsKey(this.mItem.getSubList().get(i2).getEpisodeId())) {
                        int status = map.get(this.mItem.getSubList().get(i2).getEpisodeId()).intValue();
                        if (status == 8) {
                            this.mItem.getSubList().get(i2).setEpiStatus(2);
                        } else if (status == 2 || status == 4) {
                            this.mItem.getSubList().get(i2).setEpiStatus(1);
                        } else if (status == 16) {
                            this.mItem.getSubList().get(i2).setEpiStatus(1);
                        } else if (status == 1) {
                            this.mItem.getSubList().get(i2).setEpiStatus(3);
                        }
                    } else {
                        this.mItem.getSubList().get(i2).setEpiStatus(0);
                    }
                }
            }
            this.mAdapter.setData(this.mItem.getSubList());
            updateNewTip(getCount(map));
        }
    }

    public void onLoaderReset(Loader<HashMap<String, Integer>> loader) {
    }

    private int getCount(HashMap<String, Integer> map) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() == 8) {
                count++;
            }
        }
        return map.size() - count;
    }

    private void registerDownloadCompletedReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(DownloadConstants.ACTION_DOWNLOAD_COMPLETE);
        registerReceiver(this.mEpisodeDownloadCompletedReceiver, filter);
    }

    private void unRegisterDownloadCompletedReceiver() {
        unregisterReceiver(this.mEpisodeDownloadCompletedReceiver);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unRegisterDownloadCompletedReceiver();
        unRegisterNetWorkChangeReceiver();
        this.mDownloadManager.cancel();
    }

    private void updateNewTip(int itemCount) {
        if (itemCount != 0) {
            this.mIsHasDownloading = true;
            this.mNewTipTextView.setVisibility(0);
            this.mNewTipTextView.setText(itemCount + "");
            return;
        }
        this.mIsHasDownloading = false;
        this.mNewTipTextView.setVisibility(8);
    }

    private View initErrorView() {
        View errorView = ((LayoutInflater) getSystemService("layout_inflater")).inflate(com.baidu.searchbox.common.res.R.layout.search_box_network_error_view, (ViewGroup) null);
        errorView.setBackgroundColor(Color.parseColor("#edeef0"));
        ((TextView) errorView.findViewById(com.baidu.searchbox.common.res.R.id.empty_btn_reload)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VDownloadDetailActivity.this.initView();
                VDownloadDetailActivity.this.loadData(0, VideoDownloadConstant.LoadDataTYPE.INITDATA);
            }
        });
        return errorView;
    }

    private void registerNetWorkChangeReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
        registerReceiver(this.mNetChangeReceiver, filter);
    }

    private void unRegisterNetWorkChangeReceiver() {
        unregisterReceiver(this.mNetChangeReceiver);
    }

    /* access modifiers changed from: private */
    public void showMenu(View v) {
        this.mVideoDownloadMenu = new VideoDownloadMenu(v);
        int mTopPadding = getResources().getDimensionPixelSize(com.baidu.android.common.ui.style.R.dimen.actionbar_menu_top_padding);
        int[] viewToAttachLocation = new int[2];
        v.getLocationOnScreen(viewToAttachLocation);
        int menuX = (viewToAttachLocation[0] + (v.getWidth() / 2)) - (getResources().getDimensionPixelSize(R.dimen.video_download_popupwindow_width) / 2);
        this.mVideoDownloadMenu.setShowAtLocation(8388659, menuX, viewToAttachLocation[1] + v.getHeight() + mTopPadding);
        for (int i2 = 0; i2 < this.mItem.getFormatList().size(); i2++) {
            this.mVideoDownloadMenu.add(i2, (CharSequence) this.mItem.getFormatList().get(i2));
        }
        this.mVideoDownloadMenu.setMenuItemClickListener(this.mItemListener);
        this.mVideoDownloadMenu.show();
    }

    private void addFooterView() {
        if (this.mItem.isHasNextPage()) {
            this.mListView.addFooterView(this.mFooterView);
        }
    }

    /* access modifiers changed from: private */
    public void changeFooterView(int res, int visible) {
        this.mFooterView.findViewById(com.baidu.searchbox.video.R.id.footer_view_progressbar).setVisibility(visible);
        ((TextView) this.mFooterView.findViewById(com.baidu.searchbox.video.R.id.footer_view_text)).setText(getResources().getString(res));
    }

    private void removeRepeat(List<VideoEpisodeItem> list, List<VideoEpisodeItem> list2) {
        list.removeAll(list2);
        list.addAll(list2);
    }
}
