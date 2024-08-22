package com.baidu.searchbox.feed.picture;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.widget.textselect.core.BdTextSelectHelper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.config.FontSizeConfig;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.discovery.picture.LightPictureStatics;
import com.baidu.searchbox.discovery.picture.PictureStatisticConstants;
import com.baidu.searchbox.discovery.picture.widget.BdImgSelectMenu;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.h5.cache.HybridFrescoCache;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemPhoto;
import com.baidu.searchbox.feed.model.FeedPhotoBjhData;
import com.baidu.searchbox.feed.model.FeedPhotoModel;
import com.baidu.searchbox.feed.picture.interfaces.IView;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.statistic.FeedUBCWrapper;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.picture.R;
import com.baidu.searchbox.picture.component.view.PictureDescriptionView;
import com.baidu.searchbox.picture.component.view.PictureOriginButton;
import com.baidu.searchbox.picture.model.PictureInfo;
import com.baidu.searchbox.picture.page.OnViewPagerChangeListener;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.ubc.UBCManager;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PictureDescriptionContainer implements OnViewPagerChangeListener, NightModeChangeListener {
    private static final String FEED_IMG_SOURCE = "feed_image";
    private static final String FEED_IMG_TEXT_PAGE = "text";
    private static final String SPLIT_STR = "   ";
    private AbsoluteSizeSpan mBigSizeSpan;
    private TextView mBjhDetailTitle;
    private TextView mContentView;
    private int mCount;
    private FeedPhotoBjhData mCurrentBjhData;
    private String mCurrentContent;
    /* access modifiers changed from: private */
    public int mCurrentIndex;
    private String mCurrentItemUrl;
    private String mCurrentPageIndex;
    /* access modifiers changed from: private */
    public PictureInfo mCurrentPicInfo;
    /* access modifiers changed from: private */
    public String mCurrentSpdUrl;
    private View mDetailGroupView;
    /* access modifiers changed from: private */
    public Activity mHostActivity;
    private RelativeLayout mLoadOriginContainer;
    private SparseArray<PictureOriginButton> mLoadOriginViews;
    /* access modifiers changed from: private */
    public FeedPhotoModel mModel;
    /* access modifiers changed from: private */
    public OnOriginImageLoadedListener mOriginImageLoadedListener;
    private ViewGroup mParentView;
    private PictureDescriptionView mPictureDescriptionView;
    /* access modifiers changed from: private */
    public RelativeLayout mSimpleDescView;
    private TextView mSimpleIndexView;
    private AbsoluteSizeSpan mSmallSizeSpan;
    private String mSourceTag;
    public BdTextSelectHelper selectHelper;

    interface OnOriginImageLoadedListener {
        void onLoadSuccess(String str);
    }

    public void onCreateView(Activity context, ViewGroup parent) {
        this.mHostActivity = context;
        this.mParentView = parent;
        createDescView(parent);
        setFontSize();
    }

    /* access modifiers changed from: private */
    public void picGoodsStatistic(String nid, String type, int pos) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("from", "feed");
            jsonObject.put("page", "home_ad_pics");
            jsonObject.put("type", type);
            jsonObject.put("nid", nid);
            jsonObject.put("value", pos);
            FeedPhotoBjhData feedPhotoBjhData = this.mCurrentBjhData;
            if (feedPhotoBjhData != null) {
                jsonObject.put("sku_id", feedPhotoBjhData.mSpdSkuId);
                jsonObject.put("tp_src", this.mCurrentBjhData.mTpSrc);
                jsonObject.put("tp_channel", this.mCurrentBjhData.mTpChannel);
                if (this.mCurrentBjhData.mLogExtra != null) {
                    jsonObject.put("log_extra", this.mCurrentBjhData.mLogExtra);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        FeedUBCWrapper.ubcOnEvent(FeedStatisticConstants.UBC_PIC_GOODS, jsonObject.toString());
    }

    private void createDescView(ViewGroup parent) {
        this.mPictureDescriptionView = (PictureDescriptionView) LayoutInflater.from(this.mHostActivity).inflate(R.layout.picture_preview_desc, (ViewGroup) null, false);
        FrameLayout.LayoutParams layoutParam = new FrameLayout.LayoutParams(-1, -2);
        layoutParam.gravity = 80;
        layoutParam.bottomMargin = (int) this.mHostActivity.getResources().getDimension(R.dimen.feed_picture_tool_bar_height);
        parent.addView(this.mPictureDescriptionView, layoutParam);
        this.mDetailGroupView = this.mPictureDescriptionView.findViewById(R.id.picture_bjh_group);
        this.mContentView = (TextView) this.mPictureDescriptionView.findViewById(R.id.picture_content);
        this.mBjhDetailTitle = (TextView) this.mPictureDescriptionView.findViewById(R.id.picture_title);
        initOrRefreshUI();
        this.mPictureDescriptionView.findViewById(R.id.pic_show_detail_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Router.invoke(PictureDescriptionContainer.this.mHostActivity, PictureDescriptionContainer.this.mCurrentSpdUrl);
                if (PictureDescriptionContainer.this.mModel != null) {
                    PictureDescriptionContainer pictureDescriptionContainer = PictureDescriptionContainer.this;
                    pictureDescriptionContainer.picGoodsStatistic(pictureDescriptionContainer.mModel.nid, FeedStatisticConstants.UBC_PIC_GOODS_CLICK, PictureDescriptionContainer.this.mCurrentIndex);
                }
            }
        });
    }

    private void createSimpleDescView(ViewGroup parent) {
        this.mSimpleDescView = (RelativeLayout) LayoutInflater.from(this.mHostActivity).inflate(com.baidu.searchbox.common.atlas.R.layout.picture_preview_desc_simple_new, (ViewGroup) null, false);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, -2);
        lp.gravity = 80;
        lp.bottomMargin = (int) this.mHostActivity.getResources().getDimension(com.baidu.searchbox.feed.core.R.dimen.dimens_16dp);
        parent.addView(this.mSimpleDescView, lp);
        this.mSimpleIndexView = (TextView) this.mSimpleDescView.findViewById(com.baidu.searchbox.common.atlas.R.id.picture_simple_desc_index);
        this.mLoadOriginContainer = (RelativeLayout) this.mSimpleDescView.findViewById(com.baidu.searchbox.common.atlas.R.id.light_picture_load_origin_container);
        initOrRefreshUI();
        this.mSimpleDescView.findViewById(com.baidu.searchbox.common.atlas.R.id.picture_simple_desc_download).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PictureDescriptionContainer.this.onDownloadClick();
            }
        });
        this.mSimpleDescView.findViewById(com.baidu.searchbox.common.atlas.R.id.picture_simple_desc_search_img).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v.setTag(PictureBrowseView.TAG_IMG_SEARCH_CLICK);
                ((View.OnClickListener) PictureDescriptionContainer.this.mSimpleDescView.getContext()).onClick(v);
            }
        });
    }

    public void onNightModeChanged(boolean isNightMode) {
        initOrRefreshUI();
        updatePageIndex(this.mCurrentIndex, this.mCount, this.mCurrentContent);
    }

    private void initOrRefreshUI() {
        TextView textView = this.mContentView;
        if (textView != null) {
            textView.setTextColor(this.mParentView.getResources().getColor(com.baidu.searchbox.common.atlas.R.color.picture_description_content_text_color));
        }
        TextView textView2 = this.mBjhDetailTitle;
        if (textView2 != null) {
            textView2.setTextColor(this.mParentView.getResources().getColor(com.baidu.searchbox.common.atlas.R.color.picture_description_content_text_color));
        }
        TextView textView3 = this.mSimpleIndexView;
        if (textView3 != null) {
            textView3.setTextColor(this.mParentView.getResources().getColor(com.baidu.searchbox.common.lib_atlas_base.R.color.picture_simple_desc_text_color));
        }
        RelativeLayout relativeLayout = this.mSimpleDescView;
        if (!(relativeLayout == null || relativeLayout.findViewById(com.baidu.searchbox.common.atlas.R.id.picture_simple_desc_download) == null)) {
            ((ImageView) this.mSimpleDescView.findViewById(com.baidu.searchbox.common.atlas.R.id.picture_simple_desc_download)).setImageDrawable(this.mParentView.getResources().getDrawable(com.baidu.searchbox.common.atlas.R.drawable.atlas_light_picture_download));
            ((ImageView) this.mSimpleDescView.findViewById(com.baidu.searchbox.common.atlas.R.id.picture_simple_desc_search_img)).setImageDrawable(this.mParentView.getResources().getDrawable(com.baidu.searchbox.common.atlas.R.drawable.atlas_light_picture_recognition_pic));
        }
        PictureDescriptionView pictureDescriptionView = this.mPictureDescriptionView;
        if (pictureDescriptionView != null) {
            pictureDescriptionView.setBackgroundColor(this.mParentView.getResources().getColor(R.color.feed_picture_desc_bg));
        }
    }

    /* access modifiers changed from: private */
    public void onDownloadClick() {
        Activity activity = this.mHostActivity;
        if (activity instanceof IView) {
            ((IView) activity).onDownloadClick(this.mCurrentItemUrl);
        }
    }

    public void onFontSizeChangeEvent(FontSizeChangeMessage event) {
        if (event.messageId == 1) {
            setFontSize();
            this.mPictureDescriptionView.reLayoutAfterFontSizeChange();
        }
    }

    public void onPageSelected(int index, int total, PictureInfo data) {
        this.mCurrentIndex = index;
        this.mCount = total;
        updateDescriptionContent(index, total, data);
        updateDescriptionHeight();
    }

    private void updateDescriptionHeight() {
        this.mPictureDescriptionView.getLayoutParams().height = this.mHostActivity.getResources().getDimensionPixelSize(R.dimen.feed_picture_desc_view_max_size);
        this.mPictureDescriptionView.scrollToTop();
        this.mPictureDescriptionView.requestLayout();
    }

    private void updateDescriptionContent(int index, int total, PictureInfo info) {
        this.mCurrentPicInfo = info;
        String title = "";
        String desc = "";
        if (info != null) {
            title = info.getTitle();
            desc = info.getDescription();
            this.mCurrentItemUrl = info.getUrl();
        }
        int i2 = 0;
        boolean isVisible = !TextUtils.isEmpty(title) || !TextUtils.isEmpty(desc);
        PictureDescriptionView pictureDescriptionView = this.mPictureDescriptionView;
        if (!isVisible) {
            i2 = 8;
        }
        pictureDescriptionView.setVisibility(i2);
        String str = TextUtils.isEmpty(desc) ? title : desc;
        this.mCurrentContent = str;
        if (isVisible) {
            updatePageIndex(index, total, str);
            updateDetailBjh();
        }
    }

    public void updateDetailBjh() {
        FeedItemPhoto item;
        JSONArray dataArray;
        int index = this.mCurrentIndex;
        String key = "index_" + index;
        FeedPhotoModel feedPhotoModel = this.mModel;
        if (feedPhotoModel == null || feedPhotoModel.spdGoodsData == null || this.mModel.spdGoodsData.optJSONObject(key) == null || index < 0) {
            FeedPhotoModel feedPhotoModel2 = this.mModel;
            if (feedPhotoModel2 != null && feedPhotoModel2.feedItemPhotoList != null && this.mModel.feedItemPhotoList.size() > 0 && index >= 0 && index < this.mModel.feedItemPhotoList.size() && (item = this.mModel.feedItemPhotoList.get(index)) != null && item.mSpdData != null && item.mSpdData.size() > 0) {
                FeedPhotoBjhData bjh = item.mSpdData.get(0);
                if (!TextUtils.isEmpty(bjh.mSpdDesc)) {
                    this.mDetailGroupView.setVisibility(0);
                    this.mBjhDetailTitle.setText(bjh.mSpdDesc);
                    this.mCurrentSpdUrl = bjh.mSpdUrl;
                    this.mCurrentBjhData = bjh;
                    picGoodsStatistic(this.mModel.nid, FeedStatisticConstants.UBC_PIC_GOODS_SHOW, index);
                    return;
                }
            }
        } else {
            JSONObject spdJsonObj = this.mModel.spdGoodsData.optJSONObject(key);
            if (!(spdJsonObj == null || (dataArray = spdJsonObj.optJSONArray("data")) == null || dataArray.length() <= 0)) {
                FeedPhotoBjhData bjh2 = FeedPhotoBjhData.parse(dataArray.optJSONObject(0));
                if (!TextUtils.isEmpty(bjh2.mSpdDesc)) {
                    this.mDetailGroupView.setVisibility(0);
                    this.mBjhDetailTitle.setText(bjh2.mSpdDesc);
                    this.mCurrentSpdUrl = bjh2.mSpdUrl;
                    this.mCurrentBjhData = bjh2;
                    picGoodsStatistic(this.mModel.nid, FeedStatisticConstants.UBC_PIC_GOODS_SHOW, index);
                    return;
                }
            }
        }
        this.mDetailGroupView.setVisibility(8);
    }

    private void updatePageIndex(int index, int count, String content) {
        String indexStr = getIndexString(index, count);
        if (index + 1 == count) {
            content = content + this.mSourceTag;
        }
        int totalLength = indexStr.length();
        int indexLength = String.valueOf(index + 1).length();
        String showContent = indexStr + SPLIT_STR + content;
        SpannableString description = new SpannableString(showContent);
        description.setSpan(this.mBigSizeSpan, 0, indexLength, 18);
        description.setSpan(this.mSmallSizeSpan, ("/".length() + indexLength) - 1, indexStr.length(), 34);
        description.setSpan(this.mBigSizeSpan, indexStr.length(), totalLength, 34);
        if (!TextUtils.isEmpty(content) && content.contains(FeedItemPhoto.PRE_ORIGINAL)) {
            PicturePrefixSpan span = new PicturePrefixSpan(createPrefix(), FeedRuntime.getNightMode());
            int originIndex = showContent.indexOf(FeedItemPhoto.PRE_ORIGINAL);
            description.setSpan(span, originIndex, FeedItemPhoto.PRE_ORIGINAL.length() + originIndex, 34);
        }
        setContentText(description);
        this.mCurrentPageIndex = indexStr;
        updateSimpleDescriptionView(indexStr);
    }

    private FeedItemData.PrefixRichTitle createPrefix() {
        FeedItemData.PrefixRichTitle prefixRichTitle = new FeedItemData.PrefixRichTitle();
        Resources resources = this.mHostActivity.getResources();
        prefixRichTitle.tagHeight = (int) resources.getDimension(com.baidu.searchbox.feed.core.R.dimen.dimens_14dp);
        prefixRichTitle.fontSize = (int) resources.getDimension(com.baidu.searchbox.feed.core.R.dimen.dimens_10dp);
        prefixRichTitle.fontColor = resources.getString(R.string.feed_picture_tag_color);
        prefixRichTitle.fontNightColor = resources.getString(R.string.feed_picture_tag_color_night);
        prefixRichTitle.borderColor = resources.getString(R.string.feed_picture_tag_color);
        prefixRichTitle.borderNightColor = resources.getString(R.string.feed_picture_tag_color_night);
        prefixRichTitle.backgroundNighColor = resources.getString(R.string.feed_picture_tag_bg_color);
        prefixRichTitle.backgroundColor = resources.getString(R.string.feed_picture_tag_bg_color);
        prefixRichTitle.content = this.mHostActivity.getResources().getString(R.string.feed_picture_tag_original);
        prefixRichTitle.iconType = "";
        return prefixRichTitle;
    }

    private void updateSimpleDescriptionView(String indexStr) {
        if (this.mSimpleDescView != null) {
            this.mSimpleIndexView.setTextColor(this.mParentView.getResources().getColor(R.color.feed_picture_edit_title_selector_white));
            if (TextUtils.isEmpty(indexStr)) {
                this.mSimpleIndexView.setText("");
            } else {
                SpannableString description = new SpannableString(indexStr);
                String[] tempIndex = indexStr.split("/");
                if (tempIndex.length < 2 || tempIndex[0] == null) {
                    this.mSimpleIndexView.setText(indexStr);
                    return;
                }
                description.setSpan(this.mBigSizeSpan, 0, tempIndex[0].length(), 18);
                description.setSpan(this.mSmallSizeSpan, tempIndex[0].length(), indexStr.length(), 34);
                this.mSimpleIndexView.setText(description);
            }
            initIfShowLoadOriginBtn();
        }
    }

    public void setSourceTag(String source) {
        StringBuilder albumSource = new StringBuilder();
        if (!TextUtils.isEmpty(source)) {
            albumSource.append(String.format(" " + this.mHostActivity.getString(com.baidu.searchbox.common.atlas.R.string.picture_bjh_source_text), new Object[]{source}));
        }
        this.mSourceTag = albumSource.toString();
    }

    private String getIndexString(int curIndex, int count) {
        return String.format(Locale.getDefault(), "%d/%d", new Object[]{Integer.valueOf(curIndex + 1), Integer.valueOf(count)});
    }

    private void setFontSize() {
        int smallFontSize;
        int contentFontSizeInPx;
        String backStr;
        int fontSize = FontSizeConfig.getFontSize(this.mHostActivity);
        Resources res = FeedRuntime.getAppContext().getResources();
        switch (fontSize) {
            case 0:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.feed_picture_browse_content_font_size_small);
                smallFontSize = res.getDimensionPixelSize(R.dimen.feed_total_picture_browse_content_font_size_small);
                break;
            case 1:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.feed_picture_browse_content_font_size_standard);
                smallFontSize = res.getDimensionPixelSize(R.dimen.feed_total_picture_browse_content_font_size_standard);
                break;
            case 2:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.feed_picture_browse_content_font_size_big);
                smallFontSize = res.getDimensionPixelSize(R.dimen.feed_total_picture_browse_content_font_size_big);
                break;
            case 3:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.feed_picture_browse_content_font_size_very_big);
                smallFontSize = res.getDimensionPixelSize(R.dimen.feed_total_picture_browse_content_font_size_very_big);
                break;
            default:
                contentFontSizeInPx = res.getDimensionPixelSize(R.dimen.feed_picture_browse_content_font_size_standard);
                smallFontSize = res.getDimensionPixelSize(R.dimen.feed_total_picture_browse_content_font_size_standard);
                break;
        }
        this.mSmallSizeSpan = new AbsoluteSizeSpan(smallFontSize);
        this.mBigSizeSpan = new AbsoluteSizeSpan(contentFontSizeInPx);
        setContentTextSize(0, contentFontSizeInPx);
        String showStr = "";
        TextView textView = this.mContentView;
        if (!(textView == null || textView.getText() == null)) {
            showStr = this.mContentView.getText().toString();
        }
        int index = 0;
        int count = 0;
        boolean isOver = false;
        try {
            String[] tempStrs = showStr.split(SPLIT_STR);
            if (tempStrs.length >= 2) {
                String frontStr = tempStrs[0];
                if (TextUtils.isEmpty(frontStr)) {
                    return;
                }
                if (frontStr.length() >= 3) {
                    String[] tempFrontStrs = frontStr.trim().split("/");
                    if (tempFrontStrs.length == 2) {
                        index = FeedUtil.convertStringToIntSafe(tempFrontStrs[0]);
                        count = FeedUtil.convertStringToIntSafe(tempFrontStrs[1]);
                        String backStr2 = tempStrs[1];
                        if (!TextUtils.isEmpty(backStr2)) {
                            backStr = backStr2.trim();
                            if (!isOver) {
                                updateTextWhenChangeFont(index, count, backStr);
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            isOver = true;
            backStr = "";
        }
    }

    private void updateTextWhenChangeFont(int index, int count, String content) {
        updatePageIndex(index - 1, count, content);
    }

    public void setDescriptionViewStatus(int mode) {
        if ((mode & 16) == 16) {
            this.mPictureDescriptionView.setVisibility(8);
            RelativeLayout relativeLayout = this.mSimpleDescView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        } else if ((mode & 2) == 2 || (mode & 1) == 1 || (mode & 4) == 4 || (mode & 8) == 8 || (mode & 32) == 32) {
            this.mPictureDescriptionView.setVisibility(8);
            changeSimpleDescView(mode);
        } else {
            this.mPictureDescriptionView.setVisibility(0);
            changeSimpleDescView(mode);
        }
    }

    private void changeSimpleDescView(int mode) {
        if (this.mSimpleDescView == null) {
            createSimpleDescView(this.mParentView);
            updateSimpleDescriptionView(this.mCurrentPageIndex);
        }
        if ((mode & 2) == 2 || (mode & 1) != 1 || (mode & 4) == 4 || (mode & 8) == 8 || (mode & 32) == 32) {
            this.mSimpleDescView.setVisibility(8);
        } else if (this.mSimpleDescView.getVisibility() != 0) {
            this.mSimpleDescView.setVisibility(0);
            LightPictureStatics.searchImgUBC("search", "show", "feedpic");
        }
    }

    private void initIfShowLoadOriginBtn() {
        PictureInfo pictureInfo = this.mCurrentPicInfo;
        if (pictureInfo == null || TextUtils.isEmpty(pictureInfo.getOriginUrl()) || HybridFrescoCache.inFrescoCache(this.mCurrentPicInfo.getOriginUrl()) || this.mCurrentPicInfo.getOriginSize() <= 0) {
            this.mLoadOriginContainer.removeAllViews();
            return;
        }
        if (this.mLoadOriginViews == null) {
            this.mLoadOriginViews = new SparseArray<>();
        }
        PictureOriginButton loadOriginView = this.mLoadOriginViews.get(this.mCurrentIndex);
        if (loadOriginView == null) {
            loadOriginView = new PictureOriginButton(this.mHostActivity);
            loadOriginView.setLoadOriginListener(new PictureOriginButton.LoadOriginImageListener() {
                public void success(String originUrl) {
                    if (PictureDescriptionContainer.this.mOriginImageLoadedListener != null) {
                        PictureDescriptionContainer.this.mOriginImageLoadedListener.onLoadSuccess(originUrl);
                    }
                }
            });
            loadOriginView.setData(this.mCurrentPicInfo);
            this.mLoadOriginViews.put(this.mCurrentIndex, loadOriginView);
            ubcDownLoadEvent("disp", "pic");
            loadOriginView.setLoadOriginPhotoListener(new PictureOriginButton.OnLoadOriginPhotoListener() {
                public void onClick() {
                }

                public void onStart() {
                    PictureDescriptionContainer pictureDescriptionContainer = PictureDescriptionContainer.this;
                    pictureDescriptionContainer.ubcDownLoadEvent("click", pictureDescriptionContainer.mCurrentPicInfo.getSource());
                }

                public void onCancel() {
                    PictureDescriptionContainer pictureDescriptionContainer = PictureDescriptionContainer.this;
                    pictureDescriptionContainer.ubcDownLoadEvent("cancel", pictureDescriptionContainer.mCurrentPicInfo.getSource());
                }

                public void onSuccess() {
                }
            });
        }
        this.mLoadOriginContainer.removeAllViews();
        this.mLoadOriginContainer.addView(loadOriginView);
        loadOriginView.immediatelyShow();
    }

    /* access modifiers changed from: private */
    public void ubcDownLoadEvent(String value, String source) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("from", InvokeStatisticKt.SCHEME_INVOKE_FROM_FEED_LANDING);
            jsonObject.put("value", value);
            jsonObject.put("source", source);
        } catch (JSONException e2) {
            if (FeedRuntime.GLOBAL_DEBUG) {
                e2.printStackTrace();
            }
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(PictureStatisticConstants.PICTURE_LOADING_ORIGIN_EVENT_ID, jsonObject);
    }

    public void onResume() {
        setFontSize();
    }

    private void setContentText(SpannableString description) {
        this.mContentView.setText(description);
        if (this.mContentView != null) {
            this.selectHelper = new BdTextSelectHelper(this.mContentView, -448956929, 855675359, 857233008, 10.0f, true, true, (View) null);
            BdImgSelectMenu imgSelectMenu = new BdImgSelectMenu("feed_image", "text");
            imgSelectMenu.setNid(this.mModel.nid);
            imgSelectMenu.setPageUrl(this.mModel.h5url);
            imgSelectMenu.setImgUrl(this.mCurrentItemUrl);
            imgSelectMenu.bindTextSelectHelper(this.selectHelper);
        }
    }

    public boolean cancelSelectWindow() {
        BdTextSelectHelper bdTextSelectHelper = this.selectHelper;
        if (bdTextSelectHelper == null || !bdTextSelectHelper.isSelecting()) {
            return false;
        }
        this.selectHelper.cancelSelect(true);
        return true;
    }

    public void isInterceptorUpEvent(boolean isHorizontalScroll) {
        BdTextSelectHelper bdTextSelectHelper = this.selectHelper;
        if (bdTextSelectHelper != null) {
            bdTextSelectHelper.isInterceptorUpEvent(isHorizontalScroll);
        }
    }

    private void setContentTextSize(int complexUnitPx, int contentFontSizeInPx) {
        this.mContentView.setTextSize(complexUnitPx, (float) contentFontSizeInPx);
    }

    public void setExtraData(FeedPhotoModel photoModel) {
        this.mModel = photoModel;
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels, int total) {
    }

    public void setOriginImageListener(OnOriginImageLoadedListener listener) {
        this.mOriginImageLoadedListener = listener;
    }
}
