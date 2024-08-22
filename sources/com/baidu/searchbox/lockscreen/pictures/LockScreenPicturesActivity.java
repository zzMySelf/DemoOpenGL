package com.baidu.searchbox.lockscreen.pictures;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeConfig;
import com.baidu.searchbox.lockscreen.base.R;
import com.baidu.searchbox.lockscreen.bridge.ILockScreenFavor;
import com.baidu.searchbox.lockscreen.bridge.LockScreenRuntime;
import com.baidu.searchbox.lockscreen.controller.LockScreenLinkageUtils;
import com.baidu.searchbox.lockscreen.pictures.adapter.PicturesPagerAdapter;
import com.baidu.searchbox.lockscreen.pictures.bean.AuthorBean;
import com.baidu.searchbox.lockscreen.pictures.bean.IAtlas;
import com.baidu.searchbox.lockscreen.pictures.bean.PhotoBean;
import com.baidu.searchbox.lockscreen.pictures.bean.PicturesDataBean;
import com.baidu.searchbox.lockscreen.pictures.bean.RelativeAtlas;
import com.baidu.searchbox.lockscreen.pictures.listener.ItemClickListener;
import com.baidu.searchbox.lockscreen.pictures.model.AtlasPhotoRelativeModel;
import com.baidu.searchbox.lockscreen.pictures.model.AtlasRelativeModelResponse;
import com.baidu.searchbox.lockscreen.pictures.statistics.PicturesStatisticsHelper;
import com.baidu.searchbox.lockscreen.pictures.utils.LockScreenPicturesRequest;
import com.baidu.searchbox.lockscreen.pictures.view.PicturesActionBar;
import com.baidu.searchbox.lockscreen.plugin.LockScreenBaseActivity;
import com.baidu.searchbox.lockscreen.statistics.LockScreenHome;
import com.baidu.searchbox.lockscreen.statistics.LockScreenStatisticConstants;
import com.baidu.searchbox.lockscreen.util.ActivityStack;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import com.baidu.searchbox.lockscreen.view.dislike.ActionItemTag;
import com.baidu.searchbox.ng.errorview.view.NetworkErrorView;
import com.baidu.searchbox.picture.component.view.DragView;
import com.baidu.searchbox.picture.component.view.MultiViewPager;
import com.baidu.searchbox.picture.component.view.PictureDescriptionView;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.ubc.Flow;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LockScreenPicturesActivity extends LockScreenBaseActivity implements DragView.OnCloseListener, View.OnClickListener {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = LockScreenUtil.GLOBAL_DEBUG;
    public static final String EXTRA_PICTURES_CONTEXT = "context";
    public static final String EXTRA_PICTURES_ID = "nid";
    private static final String SPLIT_STR = "   ";
    /* access modifiers changed from: private */
    public static final String TAG = LockScreenPicturesActivity.class.getName();
    /* access modifiers changed from: private */
    public boolean isLiked = false;
    /* access modifiers changed from: private */
    public boolean isUnLiked = false;
    /* access modifiers changed from: private */
    public PicturesPagerAdapter mAdapter;
    /* access modifiers changed from: private */
    public Flow mAtlasDurationFlow;
    /* access modifiers changed from: private */
    public List<IAtlas> mAtlasList = new ArrayList();
    /* access modifiers changed from: private */
    public int mAtlasShowType;
    /* access modifiers changed from: private */
    public AuthorBean mAuthor;
    private AbsoluteSizeSpan mBigSizeSpan;
    /* access modifiers changed from: private */
    public String mContextStr;
    /* access modifiers changed from: private */
    public PicturesDataBean mCurrentPicturesData;
    private TextView mDescContentView;
    private Button mDescSimpleDownloadBtn;
    private TextView mDescSimpleIndexView;
    private DragView mDragView;
    private NetworkErrorView mErrorView;
    private String mExt;
    /* access modifiers changed from: private */
    public JSONObject mFavorJson;
    /* access modifiers changed from: private */
    public int mImageShowType;
    /* access modifiers changed from: private */
    public boolean mIsLoadSuccess = false;
    /* access modifiers changed from: private */
    public String mLikeCount;
    /* access modifiers changed from: private */
    public String mLikeStatus;
    /* access modifiers changed from: private */
    public FrameLayout mNetWorkErrorView;
    /* access modifiers changed from: private */
    public String mNid;
    private ItemClickListener mOnClickListener;
    private PictureDescriptionView mPictureDescView;
    /* access modifiers changed from: private */
    public PicturesActionBar mPicturesActionBar;
    private BdShimmerView mProgressBar = null;
    private FrameLayout mRootView;
    private RelativeLayout mSimplePictureDescView;
    private AbsoluteSizeSpan mSmallSizeSpan;
    /* access modifiers changed from: private */
    public MultiViewPager mViewPager;
    RelativeAtlas relativeAtlas;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LockScreenUtil.setViewShowFrontLockView(getActivity());
        setPendingTransition(R.anim.lockscreen_slide_in_from_right, R.anim.lockscreen_hold, R.anim.lockscreen_hold, R.anim.lockscreen_slide_out_to_right);
        setContentView(com.baidu.searchbox.lockscreen.R.layout.lockscreen_pictures_layout);
        initView();
        Intent intent = getIntent();
        if (intent != null) {
            handlePictures(intent);
        } else {
            finish();
        }
        ActivityStack.getInstance().pushActivity(getActivity());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mAtlasDurationFlow = PicturesStatisticsHelper.beginFlow();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        PicturesStatisticsHelper.endFlow(this.mAtlasDurationFlow, this.mNid);
        recordLinkageDuration(this.mNid);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ActivityStack.getInstance().removeActivity(getActivity());
    }

    private void initView() {
        this.mNetWorkErrorView = (FrameLayout) findViewById(com.baidu.searchbox.lockscreen.R.id.pictures_network_error);
        NetworkErrorView networkErrorView = new NetworkErrorView(getActivity());
        this.mErrorView = networkErrorView;
        networkErrorView.updateUI(2);
        DragView mErrorViewDragView = new DragView(getActivity());
        mErrorViewDragView.addView(this.mErrorView);
        this.mNetWorkErrorView.addView(mErrorViewDragView);
        FrameLayout frameLayout = this.mNetWorkErrorView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            this.mErrorView.setReloadClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (NetWorkUtils.isNetworkConnected(LockScreenPicturesActivity.this.getActivity())) {
                        if (LockScreenPicturesActivity.this.mNetWorkErrorView != null) {
                            LockScreenPicturesActivity.this.mNetWorkErrorView.setVisibility(8);
                            View view2 = LockScreenPicturesActivity.this.mNetWorkErrorView.getChildAt(0);
                            if (view2 != null) {
                                view2.setVisibility(8);
                            }
                        }
                        if (LockScreenPicturesActivity.this.mPicturesActionBar != null) {
                            LockScreenPicturesActivity.this.mPicturesActionBar.setVisibility(0);
                        }
                        LockScreenPicturesActivity lockScreenPicturesActivity = LockScreenPicturesActivity.this;
                        lockScreenPicturesActivity.loadPicturesData(lockScreenPicturesActivity.mNid, LockScreenPicturesActivity.this.mContextStr);
                    }
                }
            });
        }
        mErrorViewDragView.setOnCloseListener(new DragView.OnCloseListener() {
            public void onClose() {
                LockScreenPicturesActivity.this.getActivity().finish();
            }

            public void onClosing(int distance) {
                LockScreenPicturesActivity.this.setOtherViewAlpha(distance);
                LockScreenPicturesActivity.this.setBackGroundAlpha(distance);
            }

            public void onDragViewTouchEvent(MotionEvent event) {
            }
        });
        FrameLayout frameLayout2 = (FrameLayout) findViewById(com.baidu.searchbox.lockscreen.R.id.pictures_root_view);
        this.mRootView = frameLayout2;
        frameLayout2.setOnClickListener(this);
        PicturesActionBar picturesActionBar = (PicturesActionBar) findViewById(com.baidu.searchbox.lockscreen.R.id.pictures_actionbar);
        this.mPicturesActionBar = picturesActionBar;
        picturesActionBar.setOnButtonListener(new PicturesActionBar.OnButtonClickListener() {
            public void onClick(PicturesActionBar.ButtonType buttonType) {
                switch (AnonymousClass10.$SwitchMap$com$baidu$searchbox$lockscreen$pictures$view$PicturesActionBar$ButtonType[buttonType.ordinal()]) {
                    case 1:
                        LockScreenPicturesActivity.this.getActivity().finish();
                        return;
                    case 2:
                        LockScreenPicturesActivity.this.doDislike();
                        return;
                    case 3:
                        LockScreenPicturesActivity.this.doLike();
                        return;
                    case 4:
                        LockScreenPicturesActivity.this.doFavor();
                        return;
                    default:
                        return;
                }
            }
        });
        this.mViewPager = (MultiViewPager) findViewById(com.baidu.searchbox.lockscreen.R.id.pictures_viewpager);
        DragView dragView = (DragView) findViewById(com.baidu.searchbox.lockscreen.R.id.drag_view);
        this.mDragView = dragView;
        dragView.setOnCloseListener(this);
        BdShimmerView bdShimmerView = (BdShimmerView) findViewById(com.baidu.searchbox.lockscreen.R.id.picture_load_progressbar);
        this.mProgressBar = bdShimmerView;
        bdShimmerView.setType(0);
        this.mOnClickListener = new ItemClickListener() {
            public void onClick(View itemView, View childView, int position) {
                if (itemView.getId() == R.id.atlas_item_root) {
                    if (LockScreenPicturesActivity.DEBUG) {
                        Log.e(LockScreenPicturesActivity.TAG, "re item");
                    }
                    try {
                        String nid = new JSONObject(Intent.parseUri(new JSONObject(LockScreenPicturesActivity.this.relativeAtlas.mItemList.get(position).cmd).get("intent").toString(), 1).getStringExtra("context")).get("nid").toString();
                        PicturesStatisticsHelper.relativeAtlasClickEvent(LockScreenPicturesActivity.this.mNid, nid);
                        LockScreenPicturesActivity lockScreenPicturesActivity = LockScreenPicturesActivity.this;
                        lockScreenPicturesActivity.recordLinkageDuration(lockScreenPicturesActivity.mNid);
                        LockScreenPicturesActivity.this.loadPicturesData(nid, nid);
                    } catch (JSONException e2) {
                        if (LockScreenUtil.GLOBAL_DEBUG) {
                            Log.d(LockScreenPicturesActivity.TAG, e2.toString());
                        }
                    } catch (URISyntaxException e3) {
                        if (LockScreenUtil.GLOBAL_DEBUG) {
                            Log.d(LockScreenPicturesActivity.TAG, e3.toString());
                        }
                    }
                }
            }
        };
    }

    /* renamed from: com.baidu.searchbox.lockscreen.pictures.LockScreenPicturesActivity$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$lockscreen$pictures$view$PicturesActionBar$ButtonType;

        static {
            int[] iArr = new int[PicturesActionBar.ButtonType.values().length];
            $SwitchMap$com$baidu$searchbox$lockscreen$pictures$view$PicturesActionBar$ButtonType = iArr;
            try {
                iArr[PicturesActionBar.ButtonType.TYPE_CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$lockscreen$pictures$view$PicturesActionBar$ButtonType[PicturesActionBar.ButtonType.TYPE_DISLIKE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$lockscreen$pictures$view$PicturesActionBar$ButtonType[PicturesActionBar.ButtonType.TYPE_LIKE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$lockscreen$pictures$view$PicturesActionBar$ButtonType[PicturesActionBar.ButtonType.TYPE_FAVOR.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private void showLoadingView() {
        this.mProgressBar.startShimmerAnimation(100);
        this.mProgressBar.setVisibility(0);
        this.mPicturesActionBar.setVisibility(4);
    }

    private void hideLoadingView() {
        this.mProgressBar.stopShimmerAnimation();
        this.mPicturesActionBar.setVisibility(0);
        this.mProgressBar.setVisibility(4);
    }

    private void handlePictures(Intent intent) {
        String stringExtra = intent.getStringExtra("context");
        this.mContextStr = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                this.mNid = new JSONObject(this.mContextStr).optString("nid");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.mExt = parseExtFromSlog(intent.getStringExtra("slog"));
        loadPicturesData(this.mNid, this.mContextStr);
    }

    private String parseExtFromSlog(String slog) {
        try {
            return new JSONObject(slog).optString("ext");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void loadPicturesData(String nid, String contextStr) {
        this.mIsLoadSuccess = false;
        this.mFavorJson = null;
        final String oldNid = this.mNid;
        this.mNid = nid;
        showLoadingView();
        Map<String, String> params = new HashMap<>();
        params.put("nid", nid);
        params.put("context", contextStr);
        LockScreenPicturesRequest.getPictures(AppRuntime.getAppContext(), true, params, new LockScreenPicturesRequest.OnRequestCompletedListener<PicturesDataBean>() {
            public void onCompleted(int status, PicturesDataBean result, String errMsg) {
                if (status == 0) {
                    boolean unused = LockScreenPicturesActivity.this.mIsLoadSuccess = true;
                    JSONObject unused2 = LockScreenPicturesActivity.this.mFavorJson = result.getFavorJson();
                    LockScreenPicturesRequest.requestHomeFeedRelativePicture(LockScreenPicturesActivity.this.mNid, new AtlasRelativeModelResponse() {
                        public void onSuccess(AtlasPhotoRelativeModel feedPhotoRelativeModel, int i2) {
                            if (feedPhotoRelativeModel != null && feedPhotoRelativeModel.feedItemPhotoRelativeList != null && feedPhotoRelativeModel.feedItemPhotoRelativeList.size() > 0) {
                                LockScreenPicturesActivity.this.relativeAtlas = new RelativeAtlas(feedPhotoRelativeModel.feedItemPhotoRelativeList);
                                LockScreenPicturesActivity.this.mAtlasList.add(LockScreenPicturesActivity.this.relativeAtlas);
                                LockScreenPicturesActivity.this.mAdapter.notifyDataSetChanged();
                                int currentItem = LockScreenPicturesActivity.this.mViewPager.getCurrentItem();
                                LockScreenPicturesActivity.this.updateDescViewContext((PhotoBean) LockScreenPicturesActivity.this.mAtlasList.get(currentItem), currentItem, LockScreenPicturesActivity.this.mAtlasList.size(), LockScreenPicturesActivity.this.mImageShowType);
                            }
                        }
                    });
                    PicturesDataBean unused3 = LockScreenPicturesActivity.this.mCurrentPicturesData = result;
                    List unused4 = LockScreenPicturesActivity.this.mAtlasList = result.getPhotoList();
                    AuthorBean unused5 = LockScreenPicturesActivity.this.mAuthor = result.getAuthor();
                    String unused6 = LockScreenPicturesActivity.this.mLikeStatus = result.getStatus();
                    String unused7 = LockScreenPicturesActivity.this.mLikeCount = result.getLike();
                    boolean unused8 = LockScreenPicturesActivity.this.isUnLiked = false;
                    boolean unused9 = LockScreenPicturesActivity.this.isLiked = false;
                    LockScreenPicturesActivity.this.checkFavorImageView();
                    LockScreenPicturesActivity.this.initAdapter();
                    PicturesStatisticsHelper.endFlow(LockScreenPicturesActivity.this.mAtlasDurationFlow, oldNid);
                    Flow unused10 = LockScreenPicturesActivity.this.mAtlasDurationFlow = PicturesStatisticsHelper.beginFlow();
                    return;
                }
                LockScreenPicturesActivity.this.handleRequestError();
            }
        });
    }

    /* access modifiers changed from: private */
    public void initAdapter() {
        hideLoadingView();
        PicturesPagerAdapter picturesPagerAdapter = new PicturesPagerAdapter(this, this.mAtlasList);
        this.mAdapter = picturesPagerAdapter;
        picturesPagerAdapter.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setAdapter(this.mAdapter);
        this.mViewPager.setPageMargin((int) getResources().getDimension(com.baidu.searchbox.common.atlas.R.dimen.pciture_view_pager_margin));
        this.mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void onPageSelected(int position) {
                if (((IAtlas) LockScreenPicturesActivity.this.mAtlasList.get(position)) instanceof PhotoBean) {
                    LockScreenPicturesActivity lockScreenPicturesActivity = LockScreenPicturesActivity.this;
                    lockScreenPicturesActivity.updateDescViewVisible(lockScreenPicturesActivity.mImageShowType);
                    LockScreenPicturesActivity lockScreenPicturesActivity2 = LockScreenPicturesActivity.this;
                    lockScreenPicturesActivity2.updateDescViewContext((PhotoBean) LockScreenPicturesActivity.this.mAtlasList.get(position), position, lockScreenPicturesActivity2.mAtlasList.size(), LockScreenPicturesActivity.this.mAtlasShowType);
                } else {
                    PicturesStatisticsHelper.relativeAtlasShowEvent();
                    LockScreenPicturesActivity.this.updateDescViewVisible(3);
                }
                PicturesStatisticsHelper.pictureAlbumSlideEvent(position, LockScreenPicturesActivity.this.mNid);
            }
        });
        AuthorBean authorBean = this.mAuthor;
        if (authorBean != null) {
            this.mPicturesActionBar.configBjhView(authorBean.getName(), this.mAuthor.getIcon(), this.mAuthor.getSource(), this.mAuthor.getCmd());
        }
        this.mPicturesActionBar.configLikeView(this.mLikeStatus, this.mLikeCount);
        updateDescViewVisible(1);
        updateDescViewContext((PhotoBean) this.mAtlasList.get(0), 0, this.mAtlasList.size(), 1);
    }

    /* access modifiers changed from: private */
    public void updateDescViewVisible(int type) {
        if (this.mAtlasShowType != type) {
            this.mAtlasShowType = type;
            switch (type) {
                case 1:
                    getSimplePictureDescView().setVisibility(8);
                    getPictureDescView().setVisibility(0);
                    this.mPicturesActionBar.setVisibility(0);
                    this.mPicturesActionBar.updateItem(type);
                    this.mImageShowType = type;
                    return;
                case 2:
                    getSimplePictureDescView().setVisibility(0);
                    getPictureDescView().setVisibility(8);
                    this.mPicturesActionBar.setVisibility(8);
                    this.mImageShowType = type;
                    return;
                case 3:
                    getSimplePictureDescView().setVisibility(8);
                    getPictureDescView().setVisibility(8);
                    this.mPicturesActionBar.setVisibility(0);
                    this.mPicturesActionBar.updateItem(type);
                    return;
                case 4:
                    getSimplePictureDescView().setVisibility(8);
                    getPictureDescView().setVisibility(8);
                    this.mPicturesActionBar.setVisibility(0);
                    this.mPicturesActionBar.updateItem(type);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateDescViewContext(PhotoBean photo, int index, int count, int type) {
        switch (type) {
            case 1:
                updatePictureDescContent(index, count, photo.getDesc());
                updateIndexView(index, count);
                return;
            case 2:
                updateIndexView(index, count);
                return;
            default:
                return;
        }
    }

    public void updateIndexView(int index, int count) {
        String indexStr = getIndexString(index, count);
        int indexLength = String.valueOf(index).length();
        if (this.mDescSimpleIndexView != null) {
            SpannableString description = new SpannableString(indexStr);
            description.setSpan(this.mBigSizeSpan, 0, ("/".length() + indexLength) - 1, 18);
            description.setSpan(this.mSmallSizeSpan, "/".length() + indexLength, indexStr.length(), 34);
            this.mDescSimpleIndexView.setText(description);
        }
    }

    private void updatePictureDescContent(int index, int count, String content) {
        String indexStr = getIndexString(index, count);
        int length = indexStr.length();
        int indexLength = String.valueOf(index + 1).length();
        SpannableString desc = new SpannableString(indexStr + SPLIT_STR + content);
        desc.setSpan(this.mBigSizeSpan, 0, indexLength, 18);
        desc.setSpan(this.mSmallSizeSpan, ("/".length() + indexLength) - 1, indexStr.length(), 34);
        desc.setSpan(this.mBigSizeSpan, indexStr.length(), length, 34);
        this.mDescContentView.setText(desc);
    }

    private PictureDescriptionView getPictureDescView() {
        PictureDescriptionView pictureDescriptionView = this.mPictureDescView;
        if (pictureDescriptionView == null) {
            PictureDescriptionView pictureDescriptionView2 = (PictureDescriptionView) ((ViewStub) findViewById(com.baidu.searchbox.lockscreen.R.id.picture_desc)).inflate();
            this.mPictureDescView = pictureDescriptionView2;
            this.mDescContentView = (TextView) pictureDescriptionView2.findViewById(R.id.picture_desc_content);
        } else {
            pictureDescriptionView.getLayoutParams().height = getResources().getDimensionPixelSize(com.baidu.searchbox.common.atlas.R.dimen.picture_desc_view_max_size);
            this.mPictureDescView.scrollToTop();
            this.mPictureDescView.requestLayout();
        }
        return this.mPictureDescView;
    }

    private RelativeLayout getSimplePictureDescView() {
        if (this.mSimplePictureDescView == null) {
            RelativeLayout relativeLayout = (RelativeLayout) ((ViewStub) findViewById(com.baidu.searchbox.lockscreen.R.id.pictures_desc_simple)).inflate();
            this.mSimplePictureDescView = relativeLayout;
            this.mDescSimpleIndexView = (TextView) relativeLayout.findViewById(R.id.picture_desc_simple_index);
            Button button = (Button) this.mSimplePictureDescView.findViewById(R.id.picture_desc_simple_download);
            this.mDescSimpleDownloadBtn = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    LockScreenPicturesActivity.this.onDownloadClick();
                }
            });
        }
        return this.mSimplePictureDescView;
    }

    public void onClose() {
        getActivity().finish();
    }

    public void onClosing(int distance) {
        setOtherViewAlpha(distance);
        setBackGroundAlpha(distance);
    }

    public void onDragViewTouchEvent(MotionEvent event) {
    }

    /* access modifiers changed from: private */
    public void setOtherViewAlpha(int distance) {
        View descView = null;
        switch (this.mImageShowType) {
            case 1:
                descView = this.mPictureDescView;
                break;
            case 2:
                descView = this.mSimplePictureDescView;
                break;
            case 3:
                return;
        }
        float ratio = Math.min(1.0f, (((float) Math.abs(distance)) * 1.0f) / 200.0f);
        PicturesActionBar picturesActionBar = this.mPicturesActionBar;
        if (picturesActionBar != null) {
            picturesActionBar.setAlpha(1.0f - ratio);
        }
        if (descView != null) {
            descView.setAlpha(1.0f - ratio);
        }
    }

    public void onClick(View v) {
        switch (this.mImageShowType) {
            case 1:
                this.mImageShowType = 2;
                break;
            case 2:
                this.mImageShowType = 1;
                break;
            case 3:
                return;
        }
        updateDescViewVisible(this.mImageShowType);
    }

    public void finish() {
        super.finish();
        getActivity().overridePendingTransition(0, getExitAnimResId(getActivity()));
    }

    public static void launchLockScreenPictures(Context context, String id, String contextStr) {
        Intent intent = new Intent(context, LockScreenPicturesActivity.class);
        intent.putExtra("nid", id);
        intent.putExtra("context", contextStr);
        ActivityUtils.startActivitySafely(context, intent);
    }

    private String getIndexString(int curIndex, int count) {
        return String.format(Locale.getDefault(), "%d/%d", new Object[]{Integer.valueOf(curIndex + 1), Integer.valueOf(count)});
    }

    private String getCurrentUrl() {
        PhotoBean photo;
        MultiViewPager multiViewPager = this.mViewPager;
        if (multiViewPager == null) {
            return "";
        }
        int index = multiViewPager.getCurrentItem();
        int size = this.mAtlasList.size();
        if (index < 0 || index >= size || (photo = (PhotoBean) this.mAtlasList.get(index)) == null) {
            return null;
        }
        return photo.getImage();
    }

    /* access modifiers changed from: private */
    public void onDownloadClick() {
    }

    /* access modifiers changed from: private */
    public void handleRequestError() {
        hideLoadingView();
        FrameLayout frameLayout = this.mNetWorkErrorView;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            if (this.mNetWorkErrorView.getChildAt(0) != null) {
                this.mNetWorkErrorView.getChildAt(0).setVisibility(0);
            }
        }
        updateDescViewVisible(4);
    }

    /* access modifiers changed from: private */
    public void doLike() {
        if (this.mPicturesActionBar.isLiked()) {
            UniversalToast.makeText((Context) getActivity(), R.string.lockscreen_page_like_tips).showToast();
            return;
        }
        this.mPicturesActionBar.doLikeAnimation();
        String str = (convertStringToIntSafe(this.mLikeCount) + 1) + "";
        this.mLikeCount = str;
        this.mLikeStatus = "like";
        this.mPicturesActionBar.setLikeButtonHasClicked(str);
        if (!this.isLiked) {
            this.isLiked = true;
            LockScreenHome.likeRes(this.mNid, LockScreenStatisticConstants.SOURCE_LIKE_PAGE_PICTURE);
        }
    }

    private int convertStringToIntSafe(String string) {
        if (TextUtils.isEmpty(string)) {
            return 0;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e2) {
            if (!DEBUG) {
                return 0;
            }
            Log.d(TAG, "convert string to int error");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public void doDislike() {
        LockScreenHome.disLikeRes(this.mNid, this.mExt, "-1", (List<ActionItemTag>) null);
        LockScreenLinkageUtils.recordLinkageDislike(this.mNid);
        this.isUnLiked = true;
        UniversalToast.makeText((Context) getActivity(), R.string.lockscreen_page_not_recommended).showToast();
    }

    /* access modifiers changed from: private */
    public void setBackGroundAlpha(int distance) {
        int x = 0;
        int distance2 = Math.abs(distance);
        if (distance2 >= 0 && ((float) distance2) < 300.0f) {
            x = (int) (255.0f - ((((float) distance2) / 300.0f) * 20.0f));
        } else if (((float) distance2) >= 300.0f) {
            x = (int) (((float) 235) - (((((float) distance2) - 300.0f) / 900.0f) * ((float) 235)));
        }
        this.mRootView.getBackground().mutate().setAlpha(x >= 0 ? x : 0);
        float as = ((float) distance2) - 300.0f >= 0.0f ? 1.0f : Math.abs(((float) distance2) / 300.0f);
        int i2 = 255;
        if (((int) (as * 255.0f)) <= 255) {
            i2 = (int) (255.0f * as);
        }
        int alpha = i2;
        FrameLayout frameLayout = this.mNetWorkErrorView;
        if (frameLayout != null) {
            frameLayout.getBackground().mutate().setAlpha(255 - alpha);
        }
    }

    public void setFontSize() {
        int smallFontSize;
        int contentFontSizeInPx;
        int fontSize = FontSizeConfig.getFontSize(getApplicationContext());
        Resources res = LockScreenRuntime.getAppContext().getResources();
        switch (fontSize) {
            case 0:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.lockscreen_picture_browse_content_font_size_small);
                smallFontSize = res.getDimensionPixelSize(R.dimen.lockscreen_total_picture_browse_content_font_size_small);
                break;
            case 1:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.lockscreen_picture_browse_content_font_size_standard);
                smallFontSize = res.getDimensionPixelSize(R.dimen.lockscreen_total_picture_browse_content_font_size_standard);
                break;
            case 2:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.lockscreen_picture_browse_content_font_size_big);
                smallFontSize = res.getDimensionPixelSize(R.dimen.lockscreen_total_picture_browse_content_font_size_big);
                break;
            case 3:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.lockscreen_picture_browse_content_font_size_very_big);
                smallFontSize = res.getDimensionPixelSize(R.dimen.lockscreen_total_picture_browse_content_font_size_very_big);
                break;
            default:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.lockscreen_picture_browse_content_font_size_standard);
                smallFontSize = res.getDimensionPixelSize(R.dimen.lockscreen_total_picture_browse_content_font_size_standard);
                break;
        }
        this.mSmallSizeSpan = new AbsoluteSizeSpan(smallFontSize);
        this.mBigSizeSpan = new AbsoluteSizeSpan(contentFontSizeInPx);
        TextView textView = this.mDescContentView;
        if (textView != null) {
            textView.setTextSize(0, (float) contentFontSizeInPx);
        }
    }

    /* access modifiers changed from: private */
    public void recordLinkageDuration(String nid) {
        Flow flow;
        if (this.mIsLoadSuccess && (flow = this.mAtlasDurationFlow) != null) {
            LockScreenLinkageUtils.recordLinkageDuration(nid, flow.getStartTime());
        }
    }

    /* access modifiers changed from: private */
    public void doFavor() {
        ILockScreenFavor lockScreenFavor = LockScreenRuntime.getLockScreenFavor();
        if (lockScreenFavor != null) {
            lockScreenFavor.addOrCancelFavorToLogin(getActivity(), this.mFavorJson, new ILockScreenFavor.FavorCallBack() {
                public void onFavored(boolean isFavored) {
                    LockScreenLinkageUtils.recordLinkageFavor(LockScreenPicturesActivity.this.mNid, isFavored);
                    if (LockScreenPicturesActivity.this.mPicturesActionBar != null) {
                        LockScreenPicturesActivity.this.mPicturesActionBar.updateFavorImageView(isFavored);
                    }
                }
            }, "atlas");
        }
    }

    /* access modifiers changed from: private */
    public void checkFavorImageView() {
        ILockScreenFavor lockScreenFavor;
        if (this.mPicturesActionBar != null && (lockScreenFavor = LockScreenRuntime.getLockScreenFavor()) != null) {
            lockScreenFavor.checkFavored(LockScreenUtil.getUkey(this.mFavorJson), new ILockScreenFavor.FavorCallBack() {
                public void onFavored(boolean isFavored) {
                    LockScreenPicturesActivity.this.mPicturesActionBar.updateFavorImageView(isFavored);
                    LockScreenLinkageUtils.recordLinkageFavor(LockScreenPicturesActivity.this.mNid, isFavored);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getActivity().overridePendingTransition(getEnterAnimResId(getActivity()), 0);
    }

    public void onAttachedToWindow() {
        getActivity().overridePendingTransition(getEnterAnimResId(getActivity()), 0);
    }
}
