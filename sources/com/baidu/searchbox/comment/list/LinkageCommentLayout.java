package com.baidu.searchbox.comment.list;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.elinkagescroll.ChildLinkageEvent;
import com.baidu.elinkagescroll.ELinkageScrollHandler;
import com.baidu.elinkagescroll.ELinkageScrollLayout;
import com.baidu.elinkagescroll.ELinkageScrollListener;
import com.baidu.elinkagescroll.ELinkageScrollListenerAdapter;
import com.baidu.elinkagescroll.EPosIndicator;
import com.baidu.elinkagescroll.IELinkageScroll;
import com.baidu.elinkagescroll.view.NestedFrameLayout;
import com.baidu.linkagescroll.ILinkageScroll;
import com.baidu.linkagescroll.LinkageChildrenEvent;
import com.baidu.linkagescroll.LinkageScrollHandler;
import com.baidu.linkagescroll.LinkageScrollLayout;
import com.baidu.linkagescroll.LinkageScrollListenerAdapter;
import com.baidu.linkagescroll.PosIndicator;
import com.baidu.nestedscroll.INestedScroll;
import com.baidu.nestedscroll.MultiViewScrollLayout;
import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.data.RefreshChannelData;
import com.baidu.searchbox.comment.definition.CommentCallback;
import com.baidu.searchbox.comment.definition.CommentCommonInterface;
import com.baidu.searchbox.comment.definition.IBDCommentInputController;
import com.baidu.searchbox.comment.definition.ICommonRecyclerView;
import com.baidu.searchbox.comment.definition.ILinkageCommentLayout;
import com.baidu.searchbox.comment.definition.IQuickInputInterface;
import com.baidu.searchbox.comment.definition.toolbar.ICommentBarProxy;
import com.baidu.searchbox.comment.guide.CommentBubbleHelper;
import com.baidu.searchbox.comment.linkagescroll.ICommentNotifyLinkageListener;
import com.baidu.searchbox.comment.linkagescroll.LinkageNotifyCommentListenerStub;
import com.baidu.searchbox.comment.params.CommonAttrs;
import com.baidu.searchbox.comment.presenter.CommonLinkageCommentPresenter;
import com.baidu.searchbox.comment.presenter.ILinkageCommentPresenter;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import com.baidu.searchbox.datachannel.Registry;
import com.baidu.searchbox.ui.animview.util.LinkageControlUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class LinkageCommentLayout extends NestedFrameLayout implements ILinkageScroll, IELinkageScroll, INestedScroll, ILinkageCommentLayout {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = CommentRuntime.GLOBAL_DEBUG;
    public static final String TAG = "LinkageCommentLayout";
    /* access modifiers changed from: private */
    public ELinkageScrollLayout eLinkageScrollLayout;
    /* access modifiers changed from: private */
    public boolean isFlinging;
    /* access modifiers changed from: private */
    public LinkageScrollLayout linkageScrollLayout;
    private CommonAttrs mAttrs;
    protected IBDCommentInputController mCommentInputController;
    private ILinkageCommentPresenter mCommentPresenter;
    private Context mContext;
    /* access modifiers changed from: private */
    public ChildLinkageEvent mELinkageScrollEvent;
    private ELinkageScrollListenerAdapter mELinkageScrollListener;
    /* access modifiers changed from: private */
    public boolean mIsDataReady;
    private ICommonRecyclerView mIterfaceRecyclerView;
    /* access modifiers changed from: private */
    public LinkageNotifyCommentListenerStub mLinkageNotifyCommentListener;
    private LinkageControlUtil.ILinkageOpr mLinkageOpr;
    /* access modifiers changed from: private */
    public LinkageChildrenEvent mLinkageScrollEvent;
    private LinkageScrollListenerAdapter mLinkageScrollListener;
    private HashMap<String, ILinkageCommentPresenter> mPresenterHashMap;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public int mScrollY;
    /* access modifiers changed from: private */
    public MultiViewScrollLayout multiViewScrollLayout;

    static /* synthetic */ int access$612(LinkageCommentLayout x0, int x1) {
        int i2 = x0.mScrollY + x1;
        x0.mScrollY = i2;
        return i2;
    }

    public LinkageCommentLayout(Context context, CommonAttrs mAttrs2) {
        super(context);
        this.mScrollY = 0;
        this.mIsDataReady = false;
        this.isFlinging = false;
        this.mPresenterHashMap = new HashMap<>();
        this.mContext = context;
        setAttrs(mAttrs2);
    }

    public LinkageCommentLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinkageCommentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mScrollY = 0;
        this.mIsDataReady = false;
        this.isFlinging = false;
        this.mPresenterHashMap = new HashMap<>();
        this.mContext = context;
        initView();
    }

    public void onResume() {
        ILinkageCommentPresenter iLinkageCommentPresenter = this.mCommentPresenter;
        if (iLinkageCommentPresenter != null) {
            iLinkageCommentPresenter.onResume();
        }
    }

    public void onPause() {
        ILinkageCommentPresenter iLinkageCommentPresenter = this.mCommentPresenter;
        if (iLinkageCommentPresenter != null) {
            if (iLinkageCommentPresenter.getConditionData() != null && this.mCommentPresenter.getConditionData().isLoading) {
                this.mCommentPresenter.getConditionData().loadingTime = System.currentTimeMillis() - this.mCommentPresenter.getLoadingStartTime();
            }
            this.mCommentPresenter.onPause((String) null);
        }
    }

    public void onDestroy() {
        ILinkageCommentPresenter iLinkageCommentPresenter = this.mCommentPresenter;
        if (iLinkageCommentPresenter != null) {
            iLinkageCommentPresenter.onDestroy();
        }
        unregisterCommentRefresh();
        Context context = this.mContext;
        if (context != null) {
            LinkageControlUtil.stop(context.hashCode());
        }
        this.mPresenterHashMap.clear();
        this.mCommentInputController = null;
    }

    private String getKey() {
        if (this.mAttrs != null) {
            return this.mAttrs.topicId + this.mAttrs.sourceType + this.mAttrs.mKey;
        }
        return null;
    }

    private void initCommentRecyclerView() {
        LinearLayoutManager layout = new LinearLayoutManager(this.mContext, 1, false);
        this.mAttrs.commentScrollWithInputBox = false;
        CommonLinkageCommentPresenter commonLinkageCommentPresenter = new CommonLinkageCommentPresenter(this.mContext, this.mAttrs, layout, (ICommonRecyclerView) null);
        this.mCommentPresenter = commonLinkageCommentPresenter;
        commonLinkageCommentPresenter.setRecyclerRootView(this);
        ICommonRecyclerView recyclerViewInterface = this.mCommentPresenter.getRecyclerViewInterface();
        this.mIterfaceRecyclerView = recyclerViewInterface;
        this.mRecyclerView = recyclerViewInterface.getViewInstance();
        this.mCommentPresenter.setCommentNotifyLinkageListener(new ICommentNotifyLinkageListener() {
            public void notifyLayout() {
                if (LinkageCommentLayout.this.linkageScrollLayout != null) {
                    LinkageCommentLayout.this.linkageScrollLayout.setIsChildrenReady(true);
                }
                if (!LinkageCommentLayout.this.mIsDataReady && LinkageCommentLayout.this.linkageScrollLayout != null && LinkageCommentLayout.this.linkageScrollLayout.isBottomChildShow() && LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.isRecyclerViewShowing = true;
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onViewJustIn();
                }
                if (!(LinkageCommentLayout.this.mIsDataReady || LinkageCommentLayout.this.eLinkageScrollLayout == null || LinkageCommentLayout.this.mLinkageNotifyCommentListener == null)) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.isRecyclerViewShowing = true;
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onViewJustIn();
                }
                if (!(LinkageCommentLayout.this.mIsDataReady || LinkageCommentLayout.this.multiViewScrollLayout == null || LinkageCommentLayout.this.mLinkageNotifyCommentListener == null)) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.isRecyclerViewShowing = true;
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onViewJustIn();
                }
                boolean unused = LinkageCommentLayout.this.mIsDataReady = true;
            }

            public void scrollToBottom() {
                if (LinkageCommentLayout.this.linkageScrollLayout != null) {
                    LinkageCommentLayout.this.linkageScrollLayout.goToBottom();
                }
                if (LinkageCommentLayout.this.eLinkageScrollLayout != null) {
                    LinkageCommentLayout.this.eLinkageScrollLayout.goToAnotherView(1, 0);
                }
                if (LinkageCommentLayout.this.multiViewScrollLayout != null) {
                    LinkageCommentLayout.this.multiViewScrollLayout.goToAnotherView(1, 0);
                }
            }

            public void hideBottom() {
                if (LinkageCommentLayout.this.linkageScrollLayout != null) {
                    LinkageCommentLayout.this.linkageScrollLayout.hideBottomChild();
                }
                if (LinkageCommentLayout.this.eLinkageScrollLayout != null) {
                    LinkageCommentLayout.this.eLinkageScrollLayout.hideSecondChild();
                }
                if (LinkageCommentLayout.this.multiViewScrollLayout != null) {
                    LinkageCommentLayout.this.multiViewScrollLayout.removeChild(1);
                }
            }
        });
        if (this.mAttrs != null && getKey() != null) {
            this.mPresenterHashMap.put(getKey(), this.mCommentPresenter);
        }
    }

    private void initView() {
        ILinkageCommentPresenter presenter;
        if (!(this.mAttrs == null || getKey() == null || (presenter = this.mPresenterHashMap.get(getKey())) == null)) {
            presenter.onDestroy();
        }
        initCommentRecyclerView();
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, -2);
        removeViewIfNeed();
        addView(this.mRecyclerView, lp);
        this.mRecyclerView.setOverScrollMode(2);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                boolean unused = LinkageCommentLayout.this.isFlinging = newState == 2;
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinkageCommentLayout.access$612(LinkageCommentLayout.this, dy);
                if (LinkageCommentLayout.this.linkageScrollLayout != null) {
                    if (!LinkageCommentLayout.this.canScrollVertically(-1) && LinkageCommentLayout.this.mLinkageScrollEvent != null) {
                        LinkageCommentLayout.this.mLinkageScrollEvent.onContentScrollToTop();
                    }
                    if (LinkageCommentLayout.this.mLinkageScrollEvent != null) {
                        LinkageCommentLayout.this.mLinkageScrollEvent.onContentScroll(LinkageCommentLayout.this.mRecyclerView.computeVerticalScrollExtent(), LinkageCommentLayout.this.mRecyclerView.computeVerticalScrollOffset(), LinkageCommentLayout.this.mRecyclerView.computeVerticalScrollRange());
                    }
                } else if (LinkageCommentLayout.this.eLinkageScrollLayout != null) {
                    if (!recyclerView.canScrollVertically(-1)) {
                        LinkageCommentLayout.this.mELinkageScrollEvent.onContentScrollToTop(LinkageCommentLayout.this);
                    }
                    if (!recyclerView.canScrollVertically(1)) {
                        LinkageCommentLayout.this.mELinkageScrollEvent.onContentScrollToBottom(LinkageCommentLayout.this);
                    }
                    LinkageCommentLayout.this.mELinkageScrollEvent.onContentScroll(LinkageCommentLayout.this);
                }
            }
        });
    }

    private void removeViewIfNeed() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    public void setOnLinkageChildrenEvent(LinkageChildrenEvent event) {
        this.mLinkageScrollEvent = event;
    }

    public LinkageScrollHandler provideScrollHandler() {
        return new LinkageScrollHandler() {
            public void flingContentVertically(View target, int velocityY) {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    LinkageCommentLayout.this.mRecyclerView.fling(0, velocityY);
                }
            }

            public void scrollContentBy(View target, int y) {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    LinkageCommentLayout.this.mRecyclerView.scrollBy(0, y);
                }
            }

            public void scrollContentToTop() {
                if (LinkageCommentLayout.DEBUG) {
                    Log.d(LinkageCommentLayout.TAG, "comment scrollContentToTop, scrollY: " + LinkageCommentLayout.this.mScrollY);
                }
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    LinkageCommentLayout.this.mRecyclerView.scrollBy(0, -LinkageCommentLayout.this.mScrollY);
                    int unused = LinkageCommentLayout.this.mScrollY = 0;
                }
            }

            public void scrollContentToBottom() {
            }

            public int getScrollY() {
                return 0;
            }

            public int getContentHeight() {
                return 0;
            }

            public void stopContentScroll(View target) {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    LinkageCommentLayout.this.mRecyclerView.stopScroll();
                }
            }

            public boolean canScrollVertically(int direction) {
                return LinkageCommentLayout.this.canScrollVertically(direction);
            }

            public boolean isFlinging() {
                return LinkageCommentLayout.this.isFlinging;
            }
        };
    }

    public boolean canScrollVertically(int direction) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return false;
        }
        if (direction >= 0 || !recyclerView.canScrollVertically(direction)) {
            return this.mRecyclerView.canScrollVertically(direction);
        }
        if (!this.mRecyclerView.canScrollVertically(direction) || !canScroll()) {
            return false;
        }
        return true;
    }

    private boolean canScroll() {
        if (((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) {
            return false;
        }
        return true;
    }

    public ViewGroup getViewInstance() {
        return this;
    }

    public void setLinkageScrollLayout(final LinkageScrollLayout linkageScrollLayout2) {
        this.linkageScrollLayout = linkageScrollLayout2;
        initScrollListener(linkageScrollLayout2);
        this.mLinkageOpr = new LinkageControlUtil.ILinkageOpr() {
            public boolean isLinakgeControlling() {
                LinkageScrollLayout linkageScrollLayout = linkageScrollLayout2;
                if (linkageScrollLayout == null || linkageScrollLayout.getPosIndicator().isInStartPos() || linkageScrollLayout2.getPosIndicator().isInEndPos()) {
                    return false;
                }
                return true;
            }

            public void enableLinkageScroll() {
                LinkageScrollLayout linkageScrollLayout = linkageScrollLayout2;
                if (linkageScrollLayout != null) {
                    linkageScrollLayout.setIsChildrenReady(true);
                }
            }

            public void disableLinkageScroll() {
                LinkageScrollLayout linkageScrollLayout = linkageScrollLayout2;
                if (linkageScrollLayout != null) {
                    linkageScrollLayout.setIsChildrenReady(false);
                }
            }
        };
        Context context = this.mContext;
        if (context != null) {
            LinkageControlUtil.start(context.hashCode(), this.mLinkageOpr);
        }
    }

    public void setELinkageScrollLayout(ELinkageScrollLayout linkageScrollLayout2) {
        this.eLinkageScrollLayout = linkageScrollLayout2;
        initELinkageScrollListener();
        this.mLinkageOpr = new LinkageControlUtil.ILinkageOpr() {
            public boolean isLinakgeControlling() {
                if (LinkageCommentLayout.this.eLinkageScrollLayout == null || LinkageCommentLayout.this.eLinkageScrollLayout.mPosIndicator.isInStartPos() || LinkageCommentLayout.this.eLinkageScrollLayout.mPosIndicator.isInEndPos()) {
                    return false;
                }
                return true;
            }

            public void enableLinkageScroll() {
            }

            public void disableLinkageScroll() {
            }
        };
        Context context = this.mContext;
        if (context != null) {
            LinkageControlUtil.start(context.hashCode(), this.mLinkageOpr);
        }
    }

    public void setMultiViewScrollLayout(MultiViewScrollLayout linkageScrollLayout2) {
        this.multiViewScrollLayout = linkageScrollLayout2;
        initMultiViewScrollListener();
        this.mLinkageOpr = new LinkageControlUtil.ILinkageOpr() {
            public boolean isLinakgeControlling() {
                if (LinkageCommentLayout.this.multiViewScrollLayout == null || LinkageCommentLayout.this.multiViewScrollLayout.getPosIndicator().isInStartPos() || LinkageCommentLayout.this.multiViewScrollLayout.getPosIndicator().isInEndPos()) {
                    return false;
                }
                return true;
            }

            public void enableLinkageScroll() {
            }

            public void disableLinkageScroll() {
            }
        };
        Context context = this.mContext;
        if (context != null) {
            LinkageControlUtil.start(context.hashCode(), this.mLinkageOpr);
        }
    }

    private void initScrollListener(LinkageScrollLayout linkageScrollLayout2) {
        ILinkageCommentPresenter iLinkageCommentPresenter = this.mCommentPresenter;
        if (iLinkageCommentPresenter != null) {
            this.mLinkageNotifyCommentListener = iLinkageCommentPresenter.getLinkageNotifyCommentListener();
        }
        if (linkageScrollLayout2 != null) {
            LinkageScrollListenerAdapter createScrollListener = createScrollListener();
            this.mLinkageScrollListener = createScrollListener;
            linkageScrollLayout2.addLinkageScrollListener(createScrollListener);
        }
    }

    private void initMultiViewScrollListener() {
        ILinkageCommentPresenter iLinkageCommentPresenter = this.mCommentPresenter;
        if (iLinkageCommentPresenter != null) {
            this.mLinkageNotifyCommentListener = iLinkageCommentPresenter.getLinkageNotifyCommentListener();
        }
        if (this.multiViewScrollLayout != null) {
            ELinkageScrollListenerAdapter createELinkageScrollListener = createELinkageScrollListener();
            this.mELinkageScrollListener = createELinkageScrollListener;
            this.multiViewScrollLayout.addScrollListener(createELinkageScrollListener);
        }
    }

    private void initELinkageScrollListener() {
        ILinkageCommentPresenter iLinkageCommentPresenter = this.mCommentPresenter;
        if (iLinkageCommentPresenter != null) {
            this.mLinkageNotifyCommentListener = iLinkageCommentPresenter.getLinkageNotifyCommentListener();
        }
        if (this.eLinkageScrollLayout != null) {
            ELinkageScrollListenerAdapter createELinkageScrollListener = createELinkageScrollListener();
            this.mELinkageScrollListener = createELinkageScrollListener;
            this.eLinkageScrollLayout.addLinkageScrollListener(createELinkageScrollListener);
        }
    }

    private LinkageScrollListenerAdapter createScrollListener() {
        return new LinkageScrollListenerAdapter() {
            public void onPositionChanged(PosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    float offsetY = 0.0f;
                    float offsetX = posIndicator != null ? posIndicator.getOffsetX() : 0.0f;
                    if (posIndicator != null) {
                        offsetY = posIndicator.getOffsetY();
                    }
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onPositionChanged(offsetX, offsetY);
                }
            }

            public void onBottomJustIn(PosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.isRecyclerViewShowing = true;
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onViewJustIn();
                }
            }

            public void onBottomJustOut(PosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.isRecyclerViewShowing = false;
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onViewJustOut((String) null);
                }
            }

            public void onTopJustOut(PosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.isFullScreen = true;
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onLinkageScrollStatusChange(false);
                }
            }

            public void onTopJustIn(PosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.isFullScreen = false;
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onLinkageScrollStatusChange(true);
                }
            }

            public void onScrollStateChanged(int scrollState, PosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onScrollStateChanged(scrollState);
                }
            }

            public void onSwitchAnimEnd(PosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onSwitchAnimEnd();
                }
            }
        };
    }

    private ELinkageScrollListenerAdapter createELinkageScrollListener() {
        return new ELinkageScrollListenerAdapter() {
            public void onContentScrolled(int dy, EPosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    float offsetY = 0.0f;
                    float offsetX = posIndicator != null ? posIndicator.getOffsetX() : 0.0f;
                    if (posIndicator != null) {
                        offsetY = posIndicator.getOffsetY();
                    }
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onPositionChanged(offsetX, offsetY);
                }
            }

            public void onTargetJustIn(View target, int index, ELinkageScrollListener.Direction direction) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.isFullScreen = false;
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onLinkageScrollStatusChange(true);
                }
            }

            public void onTargetJustOut(View target, int index, ELinkageScrollListener.Direction direction) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.isRecyclerViewShowing = false;
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onViewJustOut((String) null);
                }
            }

            public void onSwitchAnimEnd(EPosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onSwitchAnimEnd();
                }
            }

            public void onScrollStateChanged(int scrollState, EPosIndicator posIndicator) {
                if (LinkageCommentLayout.this.mLinkageNotifyCommentListener != null) {
                    LinkageCommentLayout.this.mLinkageNotifyCommentListener.onScrollStateChanged(scrollState);
                }
            }
        };
    }

    public CommonAttrs getAttrs() {
        return this.mAttrs;
    }

    public void setAttrs(CommonAttrs mAttrs2) {
        this.mAttrs = mAttrs2;
        mAttrs2.isLinkageScroll = true;
        initView();
        registerCommentRefresh();
    }

    public ILinkageCommentPresenter getCommentPresenter() {
        return this.mCommentPresenter;
    }

    public void scrollToPosition(int position) {
        this.mRecyclerView.scrollToPosition(position);
    }

    public void setCommentInputController(IBDCommentInputController commentInputController) {
        this.mCommentInputController = commentInputController;
        ILinkageCommentPresenter iLinkageCommentPresenter = this.mCommentPresenter;
        if (iLinkageCommentPresenter != null) {
            iLinkageCommentPresenter.setCommentInputController(commentInputController);
        }
    }

    private void registerCommentRefresh() {
        Registry.registerNAReceiver(CommentCommonInterface.COMMON_COMMENT_DATACHANNEL_REFRESH_HOSE, (String) null, CommentCommonInterface.COMMON_COMMENT_DATACHANNEL_REFRESH, new RefreshReceiverCallBack(this));
    }

    private void unregisterCommentRefresh() {
        Registry.unregisterReceiver(CommentCommonInterface.COMMON_COMMENT_DATACHANNEL_REFRESH_HOSE, (String) null, CommentCommonInterface.COMMON_COMMENT_DATACHANNEL_REFRESH);
    }

    /* access modifiers changed from: private */
    public void refreshData(String data) {
        RefreshChannelData channelData = RefreshChannelData.parseToData(data);
        if (!(this.mAttrs == null || channelData == null || !TextUtils.equals(channelData.getOldTopicID(), this.mAttrs.topicId))) {
            finish();
            removeAllViews();
            this.mAttrs.topicId = channelData.getNewTopicID();
            ICommentBarProxy originToolbar = null;
            CommentCallback originCallback = null;
            ILinkageCommentPresenter iLinkageCommentPresenter = this.mCommentPresenter;
            if (iLinkageCommentPresenter != null) {
                originToolbar = iLinkageCommentPresenter.getCommentBarProxy();
                originCallback = this.mCommentPresenter.getCommentCallback();
            }
            initView();
            ILinkageCommentPresenter iLinkageCommentPresenter2 = this.mCommentPresenter;
            if (iLinkageCommentPresenter2 != null) {
                iLinkageCommentPresenter2.setCommentBarProxy(originToolbar);
                this.mCommentPresenter.setCommentCallback(originCallback);
                this.mCommentPresenter.setCommentInputController(this.mCommentInputController);
            }
            initScrollListener(this.linkageScrollLayout);
            this.mIsDataReady = false;
        }
        LinkageScrollLayout linkageScrollLayout2 = this.linkageScrollLayout;
        if (linkageScrollLayout2 != null) {
            linkageScrollLayout2.setAnchorToBottomUponIn(false);
        }
    }

    private void finish() {
        ILinkageCommentPresenter iLinkageCommentPresenter = this.mCommentPresenter;
        if (iLinkageCommentPresenter != null) {
            if (iLinkageCommentPresenter.getConditionData() != null && this.mCommentPresenter.getConditionData().isLoading) {
                this.mCommentPresenter.getConditionData().loadingTime = System.currentTimeMillis() - this.mCommentPresenter.getLoadingStartTime();
            }
            this.mCommentPresenter.onPause((String) null);
            if (this.mCommentPresenter.isCloseComment()) {
                ILinkageCommentPresenter iLinkageCommentPresenter2 = this.mCommentPresenter;
                if (!(iLinkageCommentPresenter2 == null || iLinkageCommentPresenter2.getCommentBarProxy() == null)) {
                    this.mCommentPresenter.getCommentBarProxy().setOpenCommentUI();
                }
                LinkageScrollLayout linkageScrollLayout2 = this.linkageScrollLayout;
                if (linkageScrollLayout2 != null) {
                    linkageScrollLayout2.showBottomChild();
                }
            }
            this.mCommentPresenter.onDestroy();
        }
        LinkageScrollLayout linkageScrollLayout3 = this.linkageScrollLayout;
        if (linkageScrollLayout3 != null) {
            linkageScrollLayout3.removeLinkageScrollListener(this.mLinkageScrollListener);
        }
    }

    public void setChildELinkageEvent(ChildLinkageEvent event) {
        this.mELinkageScrollEvent = event;
    }

    public ELinkageScrollHandler provideELinkageScrollHandler() {
        return new ELinkageScrollHandler() {
            public void flingContent(View target, int velocityY) {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    LinkageCommentLayout.this.mRecyclerView.fling(0, velocityY);
                }
            }

            public void scrollContentToTop() {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    LinkageCommentLayout.this.mRecyclerView.scrollToPosition(0);
                }
            }

            public void scrollContentToBottom() {
                RecyclerView.Adapter adapter;
                if (LinkageCommentLayout.this.mRecyclerView != null && (adapter = LinkageCommentLayout.this.mRecyclerView.getAdapter()) != null && adapter.getItemCount() > 0) {
                    LinkageCommentLayout.this.mRecyclerView.scrollToPosition(adapter.getItemCount() - 1);
                }
            }

            public void stopContentScroll(View target) {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    LinkageCommentLayout.this.mRecyclerView.stopScroll();
                }
            }

            public boolean canScrollVertically(int direction) {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    return LinkageCommentLayout.this.mRecyclerView.canScrollVertically(direction);
                }
                return false;
            }

            public boolean isScrollable() {
                return true;
            }

            public int getVerticalScrollExtent() {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    return LinkageCommentLayout.this.mRecyclerView.computeVerticalScrollExtent();
                }
                return 0;
            }

            public int getVerticalScrollOffset() {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    return LinkageCommentLayout.this.mRecyclerView.computeVerticalScrollOffset();
                }
                return 0;
            }

            public int getVerticalScrollRange() {
                if (LinkageCommentLayout.this.mRecyclerView != null) {
                    return LinkageCommentLayout.this.mRecyclerView.computeVerticalScrollRange();
                }
                return 0;
            }

            public void scrollContentBy(View target, int y) {
            }
        };
    }

    public void fling(int velocityY) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.fling(0, velocityY);
        }
    }

    public void scrollToTop() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    public void scrollToBottom() {
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null && adapter.getItemCount() > 0) {
            this.mRecyclerView.scrollToPosition(adapter.getItemCount() - 1);
        }
    }

    public void stopFling() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.stopScroll();
        }
    }

    public boolean isScrollAbleInVertical(int direction) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.canScrollVertically(direction);
        }
        return false;
    }

    public boolean isScrollable() {
        return true;
    }

    public int getVerticalScrollOffset() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.computeVerticalScrollOffset();
        }
        return 0;
    }

    public int getVerticalScrollRange() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.computeVerticalScrollRange();
        }
        return 0;
    }

    public void scrollBy(int y) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.scrollBy(0, y);
        }
    }

    public void scrollTo(int y) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.scrollTo(recyclerView.getScrollX(), y);
        }
    }

    public IQuickInputInterface getQuickInputInterface() {
        return this.mCommentPresenter.getQuickInputInterface();
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        CommentBubbleHelper.dismiss();
        return super.onInterceptTouchEvent(ev);
    }

    static class RefreshReceiverCallBack extends NAReceiverCallback {
        WeakReference<LinkageCommentLayout> mCommentLayout;

        public RefreshReceiverCallBack(LinkageCommentLayout commentLayout) {
            this.mCommentLayout = new WeakReference<>(commentLayout);
        }

        public void onReceive(String action, String data) {
            LinkageCommentLayout commentLayout = getCommentLayout();
            if (commentLayout != null) {
                commentLayout.refreshData(data);
            }
        }

        private LinkageCommentLayout getCommentLayout() {
            WeakReference<LinkageCommentLayout> weakReference = this.mCommentLayout;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            return (LinkageCommentLayout) this.mCommentLayout.get();
        }
    }
}
