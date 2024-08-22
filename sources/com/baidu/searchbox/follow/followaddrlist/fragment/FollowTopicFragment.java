package com.baidu.searchbox.follow.followaddrlist.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.app.account.utils.SoftInputHelper;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.concurrent.task.Task;
import com.baidu.android.util.concurrent.task.TaskManager;
import com.baidu.android.util.concurrent.task.TaskOperation;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.follow.R;
import com.baidu.searchbox.follow.followaddrlist.FollowCenterUBCStaticHelper;
import com.baidu.searchbox.follow.followaddrlist.FollowListRequest;
import com.baidu.searchbox.follow.followaddrlist.adapter.FollowTopicsAdapter;
import com.baidu.searchbox.follow.followaddrlist.data.TopicDbControl;
import com.baidu.searchbox.follow.followaddrlist.data.TopicModel;
import com.baidu.searchbox.follow.followaddrlist.divider.DividerDecoration;
import com.baidu.searchbox.follow.followaddrlist.view.FollowListView;
import com.baidu.searchbox.follow.net.Callback;
import com.baidu.searchbox.follow.runtime.FollowRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.ui.CommonEmptyView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FollowTopicFragment extends FollowBaseFragment {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = FollowRuntime.isDebug();
    /* access modifiers changed from: private */
    public static final String TAG = FollowTopicFragment.class.getSimpleName();
    BoxAccountManager mBoxAccountManager;
    private DividerDecoration mDivider;
    /* access modifiers changed from: private */
    public boolean mFetchAfterLoadCache = false;
    private TextView mFollowTopic;
    private TextView mFollowUser;
    private FollowTopicsAdapter.OnItemListener mItemListener = new FollowTopicsAdapter.OnItemListener() {
        public void onItemClick(int position, TopicModel model) {
            if (FollowTopicFragment.DEBUG) {
                Log.d(FollowTopicFragment.TAG, "onItemClick: position: " + position + " cmd: " + model.getCmd());
            }
            JSONObject ext = new JSONObject();
            if (model != null) {
                try {
                    ext.put("topic_id", model.getId());
                } catch (JSONException e2) {
                }
            }
            FollowCenterUBCStaticHelper.doUBCEvent("topic_clk", "follow", ext, "");
            if (model != null) {
                Router.invoke(FollowRuntime.getAppContext(), model.getCmd());
            }
        }

        public void followFailed(TopicModel model, int errorCode) {
        }

        public void followSuccess(TopicModel model, boolean isFollow) {
            if (model != null) {
                if (FollowTopicFragment.DEBUG) {
                    Log.d(FollowTopicFragment.TAG, "followSuccess: " + isFollow + " third_id: " + model.getThirdId());
                }
                TopicDbControl topicDbControl = new TopicDbControl(FollowRuntime.getAppContext(), FollowTopicFragment.this.mUid);
                if (isFollow) {
                    topicDbControl.insertItem(model);
                    if (FollowTopicFragment.this.mUnFollowNum > 0) {
                        FollowTopicFragment.access$410(FollowTopicFragment.this);
                    }
                    model.setIsFollow("1");
                } else {
                    topicDbControl.deleteItem(model);
                    FollowTopicFragment.access$408(FollowTopicFragment.this);
                    model.setIsFollow("0");
                }
                if (FollowTopicFragment.this.mTopicsAdapter != null && FollowTopicFragment.this.mTopicsAdapter.getItemCount() > 0) {
                    FollowTopicFragment.this.mTopicsAdapter.setUnFollowNum(FollowTopicFragment.this.mUnFollowNum);
                    FollowTopicFragment.this.mTopicsAdapter.notifyItemChanged(0, ((FollowTopicFragment.this.mTopicsAdapter.getItemCount() - FollowTopicFragment.this.mUnFollowNum) - 1) + "");
                }
            }
        }

        public boolean isCurrentTabVisible() {
            return FollowTopicFragment.this.isCurTopicPage();
        }
    };
    private FollowListView.HeaderClickListener mListener;
    private BdShimmerView mLoadingView;
    private CommonEmptyView mNewEmpty;
    private LinearLayout mNewEmptyLayout;
    private RecyclerView mRecyclerView;
    private View mRootView;
    private IAccountStatusChangedListener mStatusChangedListener = new IAccountStatusChangedListener() {
        public void onLoginStatusChanged(boolean oldStatus, boolean newStatus) {
            if (FollowTopicFragment.DEBUG) {
                Log.d(FollowTopicFragment.TAG, "onLoginStatusChanged: oldStatus- " + oldStatus + " / newStatus- " + newStatus);
            }
            FollowTopicFragment followTopicFragment = FollowTopicFragment.this;
            String unused = followTopicFragment.mUid = followTopicFragment.mBoxAccountManager.getSession("BoxAccount_uid");
            FollowTopicFragment.this.loadCacheAndFetchData();
        }
    };
    private View mTopTabView;
    /* access modifiers changed from: private */
    public FollowTopicsAdapter mTopicsAdapter;
    /* access modifiers changed from: private */
    public String mUid;
    /* access modifiers changed from: private */
    public int mUnFollowNum = 0;

    static /* synthetic */ int access$408(FollowTopicFragment x0) {
        int i2 = x0.mUnFollowNum;
        x0.mUnFollowNum = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$410(FollowTopicFragment x0) {
        int i2 = x0.mUnFollowNum;
        x0.mUnFollowNum = i2 - 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public boolean isCurTopicPage() {
        return this.mActionListener != null && (this.mActionListener.isCurrentTabVisible("follow") || this.mActionListener.isCurrentTabVisible("topic"));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.follow_assets_topics_layout, container, false);
        this.mRootView = inflate;
        this.mLoadingView = (BdShimmerView) inflate.findViewById(R.id.loading_view);
        this.mRecyclerView = (RecyclerView) this.mRootView.findViewById(R.id.recycler);
        this.mNewEmptyLayout = (LinearLayout) this.mRootView.findViewById(R.id.new_empty_layout);
        this.mTopTabView = this.mRootView.findViewById(R.id.topic_top_header);
        this.mNewEmpty = (CommonEmptyView) this.mRootView.findViewById(R.id.new_empty);
        this.mFollowUser = (TextView) this.mTopTabView.findViewById(R.id.follow_header_left_text);
        this.mFollowTopic = (TextView) this.mTopTabView.findViewById(R.id.follow_header_right_text);
        this.mFollowUser.setOnClickListener(new FollowTopicFragment$$ExternalSyntheticLambda0(this));
        this.mFollowTopic.setOnClickListener(new FollowTopicFragment$$ExternalSyntheticLambda1(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FollowRuntime.getAppContext());
        DividerDecoration dividerDecoration = new DividerDecoration(FollowRuntime.getAppContext(), true);
        this.mDivider = dividerDecoration;
        this.mRecyclerView.addItemDecoration(dividerDecoration);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        FollowTopicsAdapter followTopicsAdapter = new FollowTopicsAdapter(this.mItemListener);
        this.mTopicsAdapter = followTopicsAdapter;
        followTopicsAdapter.setHeaderClickListener(this.mListener);
        this.mRecyclerView.setAdapter(this.mTopicsAdapter);
        updateUI();
        register();
        return this.mRootView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$0$com-baidu-searchbox-follow-followaddrlist-fragment-FollowTopicFragment  reason: not valid java name */
    public /* synthetic */ void m18902lambda$onCreateView$0$combaidusearchboxfollowfollowaddrlistfragmentFollowTopicFragment(View view2) {
        FollowListView.HeaderClickListener headerClickListener = this.mListener;
        if (headerClickListener != null) {
            headerClickListener.onUserClick();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$1$com-baidu-searchbox-follow-followaddrlist-fragment-FollowTopicFragment  reason: not valid java name */
    public /* synthetic */ void m18903lambda$onCreateView$1$combaidusearchboxfollowfollowaddrlistfragmentFollowTopicFragment(View view2) {
        FollowListView.HeaderClickListener headerClickListener = this.mListener;
        if (headerClickListener != null) {
            headerClickListener.onTopicClick();
        }
    }

    private void register() {
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() {
            public void onNightModeChanged(boolean isNightMode) {
                FollowTopicFragment.this.updateUI();
                if (FollowTopicFragment.this.mTopicsAdapter != null) {
                    FollowTopicFragment.this.mTopicsAdapter.notifyDataSetChanged();
                }
            }
        });
        if (this.mBoxAccountManager == null) {
            this.mBoxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        }
        this.mBoxAccountManager.addLoginStatusChangedListener(this.mStatusChangedListener);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadCacheAndFetchData();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        this.mBoxAccountManager = boxAccountManager;
        this.mUid = boxAccountManager.getSession("BoxAccount_uid");
        if (this.mActionListener != null) {
            this.mActionListener.onLoginViewShow("topic");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        FollowListRequest.getInstance().clearTopicsCallBack();
        BoxAccountManager boxAccountManager = this.mBoxAccountManager;
        if (boxAccountManager != null) {
            boxAccountManager.removeLoginStatusChangedListener(this.mStatusChangedListener);
        }
        this.mListener = null;
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        FollowListRequest.getInstance().clearTopicsCallBack();
        BoxAccountManager boxAccountManager = this.mBoxAccountManager;
        if (boxAccountManager != null) {
            boxAccountManager.removeLoginStatusChangedListener(this.mStatusChangedListener);
        }
        this.mListener = null;
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public void onResume() {
        super.onResume();
        if (!this.mFetchAfterLoadCache) {
            fetchData();
        }
    }

    /* access modifiers changed from: private */
    public void updateUI() {
        View view2 = this.mRootView;
        if (view2 != null) {
            view2.setBackgroundColor(FollowRuntime.getAppContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC9));
        }
        DividerDecoration dividerDecoration = this.mDivider;
        if (dividerDecoration != null) {
            dividerDecoration.onNightModeChange();
        }
        TextView textView = this.mFollowTopic;
        if (textView != null) {
            textView.setTextColor(FollowRuntime.getAppContext().getResources().getColor(R.color.FC17));
            this.mFollowTopic.setTypeface(Typeface.defaultFromStyle(1));
            this.mFollowTopic.setBackground(FollowRuntime.getAppContext().getResources().getDrawable(R.drawable.follow_header_tab_bg));
        }
        TextView textView2 = this.mFollowUser;
        if (textView2 != null) {
            textView2.setTextColor(FollowRuntime.getAppContext().getResources().getColor(R.color.FC26));
            this.mFollowUser.setBackground(FollowRuntime.getAppContext().getResources().getDrawable(R.drawable.follow_header_tab_bg));
        }
    }

    /* access modifiers changed from: private */
    public void fetchData() {
        FollowTopicsAdapter followTopicsAdapter = this.mTopicsAdapter;
        if (followTopicsAdapter != null && followTopicsAdapter.getItemCount() == 0) {
            showLoading();
        }
        this.mUnFollowNum = 0;
        FollowTopicsAdapter followTopicsAdapter2 = this.mTopicsAdapter;
        if (followTopicsAdapter2 != null) {
            followTopicsAdapter2.setUnFollowNum(0);
        }
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                FollowListRequest.getInstance().fetchTopicsList(new Callback<List<TopicModel>>() {
                    public void onSuccess(final List<TopicModel> result) {
                        UiThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                FollowTopicFragment.this.hideLoading();
                                FollowTopicFragment.this.handleTopicListData(result, false);
                            }
                        });
                    }

                    public void onFailure() {
                        UiThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                FollowTopicFragment.this.hideLoading();
                                if (FollowTopicFragment.this.mTopicsAdapter != null && FollowTopicFragment.this.mTopicsAdapter.getItemCount() == 0) {
                                    FollowTopicFragment.this.showNetWorkError();
                                }
                            }
                        });
                    }

                    public void onNetworkException() {
                        UiThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                FollowTopicFragment.this.hideLoading();
                                if (FollowTopicFragment.this.mTopicsAdapter != null && FollowTopicFragment.this.mTopicsAdapter.getItemCount() == 0) {
                                    FollowTopicFragment.this.showNetWorkError();
                                }
                            }
                        });
                    }
                });
            }
        }, "topic_list_request", 1);
    }

    /* access modifiers changed from: private */
    public void loadCacheAndFetchData() {
        this.mFetchAfterLoadCache = true;
        new TaskManager().next(new Task(Task.RunningStatus.WORK_THREAD) {
            public TaskOperation onExecute(TaskOperation operation) {
                return new TaskOperation(new Object[]{new TopicDbControl(FollowRuntime.getAppContext(), FollowTopicFragment.this.mUid).queryCompleteTopicItems()});
            }
        }).next(new Task(Task.RunningStatus.UI_THREAD) {
            public TaskOperation onExecute(TaskOperation operation) {
                FollowTopicFragment.this.handleTopicListData((List) operation.getTaskParams()[0], true);
                FollowTopicFragment.this.fetchData();
                boolean unused = FollowTopicFragment.this.mFetchAfterLoadCache = false;
                return null;
            }
        }).execute();
    }

    /* access modifiers changed from: private */
    public void handleTopicListData(List<TopicModel> topicsModels, boolean isCache) {
        if (this.mRecyclerView != null) {
            boolean showList = topicsModels != null && topicsModels.size() > 0;
            List<TopicModel> packageList = new ArrayList<>();
            if (showList) {
                BdShimmerView bdShimmerView = this.mLoadingView;
                if (bdShimmerView != null) {
                    bdShimmerView.setVisibility(8);
                }
                this.mRecyclerView.setVisibility(0);
                addHeader(topicsModels);
                packageList.addAll(topicsModels);
            } else {
                showNewEmptyView(!isCache);
            }
            FollowTopicsAdapter followTopicsAdapter = this.mTopicsAdapter;
            if (followTopicsAdapter != null) {
                followTopicsAdapter.setData(packageList);
            }
            this.mRecyclerView.post(new Runnable() {
                public void run() {
                    if (FollowTopicFragment.this.mTopicsAdapter != null) {
                        FollowTopicFragment.this.mTopicsAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    private void addHeader(List<TopicModel> list) {
        if (list != null) {
            TopicModel header = new TopicModel();
            header.setConfig(1);
            list.add(0, header);
        }
    }

    private void showLoading() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        CommonEmptyView commonEmptyView = this.mNewEmpty;
        if (commonEmptyView != null) {
            commonEmptyView.setVisibility(8);
        }
        LinearLayout linearLayout = this.mNewEmptyLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        BdShimmerView bdShimmerView = this.mLoadingView;
        if (bdShimmerView != null) {
            bdShimmerView.setType(1);
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.startShimmerAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void hideLoading() {
        BdShimmerView bdShimmerView = this.mLoadingView;
        if (bdShimmerView != null) {
            bdShimmerView.setVisibility(8);
            if (this.mLoadingView.isAnimationStarted()) {
                this.mLoadingView.startShimmerAnimation();
            }
        }
    }

    /* access modifiers changed from: private */
    public void showNetWorkError() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        BdShimmerView bdShimmerView = this.mLoadingView;
        if (bdShimmerView != null) {
            bdShimmerView.setVisibility(8);
        }
        if (this.mNewEmpty != null) {
            this.mNewEmptyLayout.setVisibility(0);
            this.mNewEmpty.setIcon(R.drawable.empty_new_regard_icon);
            this.mNewEmpty.setTitle(R.string.follow_assets_topic_no_more_topics);
            this.mNewEmpty.setVisibility(0);
        }
    }

    private void showNewEmptyView(boolean isUBC) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        BdShimmerView bdShimmerView = this.mLoadingView;
        if (bdShimmerView != null) {
            bdShimmerView.setVisibility(8);
        }
        if (this.mNewEmpty != null) {
            this.mNewEmptyLayout.setVisibility(0);
            this.mNewEmpty.setIcon(R.drawable.empty_new_regard_icon);
            this.mNewEmpty.setTitle(R.string.follow_assets_topic_no_more_topics);
            this.mNewEmpty.setVisibility(0);
        }
        if (isUBC && this.mActionListener != null && this.mActionListener.isCurrentTabVisible("topic")) {
            FollowCenterUBCStaticHelper.doUBCEvent(FollowCenterUBCStaticHelper.VALUE_TYPE_EMPTY_SHOW, FollowCenterUBCStaticHelper.VALUE_PAGE_TOPIC, "");
        }
    }

    public void onFragmentSelected(String page) {
        SoftInputHelper.hideSoftInput(this.mRootView);
        FollowTopicsAdapter followTopicsAdapter = this.mTopicsAdapter;
        if (followTopicsAdapter != null) {
            followTopicsAdapter.resetShowState();
        }
        fetchData();
    }

    public void onFragmentResume() {
        super.onFragmentResume();
        FollowTopicsAdapter followTopicsAdapter = this.mTopicsAdapter;
        if (followTopicsAdapter != null) {
            followTopicsAdapter.resetShowState();
        }
    }

    public void setHeaderClickListener(FollowListView.HeaderClickListener listener) {
        this.mListener = listener;
    }
}
