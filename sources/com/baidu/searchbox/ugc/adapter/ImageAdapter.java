package com.baidu.searchbox.ugc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.activity.IUbcAlbumProvider;
import com.baidu.searchbox.ugc.activity.LocalAlbumDelegateActivity;
import com.baidu.searchbox.ugc.activity.LocalPhotoPreviewActivity;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.bridge.IUgcHostInterface;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.dialog.CameraSelectDialog;
import com.baidu.searchbox.ugc.dialog.UgcPermissionDialogUtils;
import com.baidu.searchbox.ugc.model.IAlbumInfo;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.VideoInfo;
import com.baidu.searchbox.ugc.utils.AlbumActivityUtil;
import com.baidu.searchbox.ugc.utils.AlbumUriUtils;
import com.baidu.searchbox.ugc.utils.AlbumViewHelperKt;
import com.baidu.searchbox.ugc.utils.ImageHelper;
import com.baidu.searchbox.ugc.utils.PermissionsUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcPerformanceUbcUtils;
import com.baidu.searchbox.ugc.utils.UgcPermissionUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int GRID_DECORATION = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f);
    private static final int ITEM_TYPE_ACTIVITY = 3;
    private static final int ITEM_TYPE_CAMERA = 0;
    private static final int ITEM_TYPE_IMAGE = 1;
    private static final int ITEM_TYPE_INVALID = -1;
    private static final int ITEM_TYPE_VIDEO = 2;
    public static final String PAYLOAD_REFRESH_PHOTO_SELECTED_CONTAINER = "refresh_photo_selected_container";
    public static final int SPAN_COUNT = 3;
    public static final int UGC_PHOTO_PREVIEW_REQUEST = 32770;
    public static final int UGC_VIDEO_PREVIEW_REQUEST = 32771;
    private static final long VIDEO_MIN_STORAGE_SIZE = 52428800;
    /* access modifiers changed from: private */
    public boolean isHalfAlbum = false;
    private boolean isHideShoot = false;
    /* access modifiers changed from: private */
    public boolean isSelectedOriginal = false;
    /* access modifiers changed from: private */
    public boolean isSupportOriginal = false;
    private final int itemHeight = (DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) / 3);
    private final ArrayList<Object> itemList = new ArrayList<>();
    private final int itemWidth = (DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) / 3);
    /* access modifiers changed from: private */
    public LocalAlbumDelegateActivity.LocalAlbumDelegateListener localAlbumDelegateListener;
    /* access modifiers changed from: private */
    public String mCameraDirection;
    private final long mClickTimeInterval = 1000;
    /* access modifiers changed from: private */
    public Activity mContext;
    /* access modifiers changed from: private */
    public int mFromType;
    private long mLastClickTime = 0;
    /* access modifiers changed from: private */
    public String mLaunchFrom;
    public SelectChangedListener mListener;
    /* access modifiers changed from: private */
    public boolean mNoStatistics;
    /* access modifiers changed from: private */
    public String mPublishType;
    /* access modifiers changed from: private */
    public boolean mSingleSelected;
    private String mSourceFrom;
    /* access modifiers changed from: private */
    public int mType;
    /* access modifiers changed from: private */
    public IUbcAlbumProvider mUbcAlbum;
    /* access modifiers changed from: private */
    public UgcSchemeModel model;
    /* access modifiers changed from: private */
    public OnAlbumActivityClickListener onAlbumActivityClickListener;
    private OnItemClickPermissionEnterListener onItemClickPermissionEnterListener;
    private int preloadThumbnailCount;
    /* access modifiers changed from: private */
    public List<ImageStruct> previewImageList = null;
    private ImageThumbnailLoader thumbnailLoader;
    private final ArrayList<Integer> typeList = new ArrayList<>();
    /* access modifiers changed from: private */
    public AlbumActivityUtil.UgcAlbumActivityModel ugcAlbumActivityModel;

    public interface OnAlbumActivityClickListener {
        void onClick();
    }

    public interface OnItemClickPermissionEnterListener {
        void requestPermission();
    }

    public interface SelectChangedListener {
        public static final int ADD_ACTION = 0;
        public static final int DEL_ACTION = 1;

        void selectChanged(int i2, int i3);
    }

    public ArrayList<Object> getItemList() {
        return this.itemList;
    }

    public void setOnItemClickPermissionEnterListener(OnItemClickPermissionEnterListener listener) {
        this.onItemClickPermissionEnterListener = listener;
    }

    public void updateOriginalData(boolean supportOriginal, boolean selectedOriginal) {
        this.isSupportOriginal = supportOriginal;
        this.isSelectedOriginal = selectedOriginal;
    }

    public void setFromType(int fromType) {
        this.mFromType = fromType;
    }

    public void setUgcAlbumActivityModel(AlbumActivityUtil.UgcAlbumActivityModel ugcAlbumActivityModel2, OnAlbumActivityClickListener onAlbumActivityClickListener2) {
        this.ugcAlbumActivityModel = ugcAlbumActivityModel2;
        this.onAlbumActivityClickListener = onAlbumActivityClickListener2;
    }

    private void checkAddUgcAlbumActivityEnter() {
        AlbumActivityUtil.UgcAlbumActivityModel ugcAlbumActivityModel2 = this.ugcAlbumActivityModel;
        if (ugcAlbumActivityModel2 != null) {
            addElement(ugcAlbumActivityModel2, 3);
        }
    }

    public void setPublishType(String publishType) {
        this.mPublishType = publishType;
    }

    public void setHideShoot(boolean isHideShoot2) {
        this.isHideShoot = isHideShoot2;
    }

    public void setListener(SelectChangedListener l) {
        this.mListener = l;
    }

    public ImageAdapter(IUbcAlbumProvider activity, int fromType, UgcSchemeModel schemeModel, boolean isSingleSelect, boolean noStatistics, String cameraDirection) {
        this.mUbcAlbum = activity;
        this.mContext = activity.getActivity();
        this.mType = fromType;
        this.model = schemeModel;
        this.mSingleSelected = isSingleSelect;
        this.mNoStatistics = noStatistics;
        this.mCameraDirection = cameraDirection;
        if (schemeModel != null) {
            this.mSourceFrom = schemeModel.sourceFrom;
        }
    }

    public void setLocalAlbumDelegateListener(LocalAlbumDelegateActivity.LocalAlbumDelegateListener localAlbumDelegateListener2) {
        this.localAlbumDelegateListener = localAlbumDelegateListener2;
    }

    public void setHalfAlbum(boolean halfAlbum) {
        this.isHalfAlbum = halfAlbum;
    }

    private void checkAddCameraEnter(boolean isShowCamera) {
        if (isShowCamera) {
            addElement(new Object(), 0);
        }
    }

    public void setPhotoData(List<ImageStruct> list, boolean isShowCamera) {
        clearData();
        checkAddCameraEnter(isShowCamera);
        checkAddUgcAlbumActivityEnter();
        checkAddReadMediaPermissionEnter();
        if (list != null && !list.isEmpty()) {
            this.previewImageList = list;
            addElements(list, Collections.nCopies(list.size(), 1));
        }
        notifyDataSetChanged();
    }

    public void updatePhotoData(List<ImageStruct> list) {
        if (list != null && !list.isEmpty()) {
            int notifyStartPosition = getItemCount();
            List<ImageStruct> imageList = getImageList();
            int startPosition = imageList.size();
            int endPosition = list.size();
            if (imageList.size() < list.size()) {
                List<ImageStruct> cacheImages = new ArrayList<>(imageList);
                for (int i2 = startPosition; i2 < endPosition; i2++) {
                    ImageStruct item = list.get(i2);
                    if (item != null) {
                        cacheImages.add(item);
                        addElement(item, 1);
                    }
                }
                this.previewImageList = cacheImages;
                notifyItemRangeInserted(notifyStartPosition, endPosition - startPosition);
            }
        }
    }

    public void setVideoData(List<VideoInfo> list, boolean isShowCamera, String sourceFrom) {
        clearData();
        checkAddCameraEnter(isShowCamera);
        checkAddUgcAlbumActivityEnter();
        checkAddReadMediaPermissionEnter();
        if (list != null && !list.isEmpty()) {
            addElements(list, Collections.nCopies(list.size(), 2));
        }
        this.mLaunchFrom = sourceFrom;
        notifyDataSetChanged();
    }

    public void setAlbumData(List<ImageStruct> imageList, List<VideoInfo> videoList, boolean isShowCamera, String sourceFrom) {
        this.mLaunchFrom = sourceFrom;
        clearData();
        checkAddCameraEnter(isShowCamera);
        checkAddUgcAlbumActivityEnter();
        checkAddReadMediaPermissionEnter();
        List<IAlbumInfo> tempList = new ArrayList<>();
        if (imageList != null && imageList.size() > 0) {
            tempList.addAll(imageList);
            this.previewImageList = new ArrayList(imageList);
        }
        if (videoList != null && videoList.size() > 0) {
            tempList.addAll(videoList);
        }
        Collections.sort(tempList, new ImageAdapter$$ExternalSyntheticLambda0());
        List<Integer> types = new ArrayList<>(Collections.nCopies(tempList.size(), 1));
        for (int i2 = 0; i2 < tempList.size(); i2++) {
            if (!tempList.get(i2).isPhoto()) {
                types.set(i2, 2);
            }
        }
        addElements(tempList, types);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        ArrayList<Object> arrayList = this.itemList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new CameraViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ugc_camera_item, parent, false));
            case 1:
                return new ImageViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ugc_select_item, parent, false));
            case 2:
                return new VideoViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ugc_select_item, parent, false));
            case 3:
                return new ActivityViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ugc_activity_item, parent, false));
            default:
                return new EmptyViewHolder(new View(parent.getContext()));
        }
    }

    public boolean isActivityType(int position) {
        if (!invalidPosition(position) && this.typeList.get(position).intValue() == 3) {
            return true;
        }
        return false;
    }

    public int getItemViewType(int position) {
        if (invalidPosition(position)) {
            return -1;
        }
        return this.typeList.get(position).intValue();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getItemViewHeight());
        UiBaseUtils.setLayoutParams(holder.itemView, layoutParams);
        switch (getItemViewType(position)) {
            case 0:
                if (holder instanceof CameraViewHolder) {
                    onBindCameraHolder((CameraViewHolder) holder, layoutParams);
                    return;
                }
                return;
            case 1:
                if (holder instanceof ImageViewHolder) {
                    onBindImageHolder((ImageViewHolder) holder, position, layoutParams);
                    return;
                }
                return;
            case 2:
                if (holder instanceof VideoViewHolder) {
                    onBindVideoHolder((VideoViewHolder) holder, position, layoutParams);
                    return;
                }
                return;
            case 3:
                if (holder instanceof ActivityViewHolder) {
                    onBindActivityHolder(holder);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private int getItemViewHeight() {
        return (DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) - (GRID_DECORATION * 2)) / 3;
    }

    private void onBindImageHolder(ImageViewHolder holder, int position, FrameLayout.LayoutParams layoutParams) {
        updateUi(holder, holder.itemView);
        UiBaseUtils.setLayoutParams(holder.mImageIv, layoutParams);
        UiBaseUtils.setLayoutParams(holder.unableShadow, layoutParams);
        UiBaseUtils.setVisibility(holder.unableShadow, 8);
        UiBaseUtils.setVisibility(holder.orderNumber, 8);
        UiBaseUtils.setVisibility(holder.selectView, 8);
        UiBaseUtils.setVisibility(holder.rightBottomTipBg, 8);
        Object item = this.itemList.get(position);
        if (item instanceof ImageStruct) {
            updatePhotoItem(holder, (ImageStruct) item);
        }
    }

    private void onBindVideoHolder(VideoViewHolder holder, int position, FrameLayout.LayoutParams layoutParams) {
        updateUi(holder, holder.itemView);
        UiBaseUtils.setLayoutParams(holder.mImageIv, layoutParams);
        UiBaseUtils.setLayoutParams(holder.unableShadow, layoutParams);
        UiBaseUtils.setVisibility(holder.unableShadow, 8);
        UiBaseUtils.setVisibility(holder.orderNumber, 8);
        UiBaseUtils.setVisibility(holder.selectView, 8);
        UiBaseUtils.setVisibility(holder.rightBottomTipBg, 8);
        Object item = this.itemList.get(position);
        if (item instanceof VideoInfo) {
            updateVideoItem(holder, (VideoInfo) item);
        }
    }

    private void onBindCameraHolder(CameraViewHolder holder, FrameLayout.LayoutParams layoutParams) {
        UiBaseUtils.setViewColorResource(holder.itemView, R.color.ugc_white);
        UiBaseUtils.setViewDrawableResource(holder.mCameraEnterIcon, R.drawable.ugc_camera_bg);
        UiBaseUtils.setLayoutParams(holder.mCameraEnterIcon, layoutParams);
        if (holder.mCameraEnterIcon != null) {
            holder.mCameraEnterIcon.setGravity(17);
        }
        UiBaseUtils.setVisibility(holder.mUgcCameraText, 0);
        if (holder.mCameraIcon != null) {
            if (SelectUtil.getSelectedCount() + SelectUtil.getCurrentAlbumSelectedImagesCount() == SelectUtil.maxSelected) {
                holder.mCameraIcon.setImageResource(R.drawable.ugc_camera_unenable_icon);
            } else {
                holder.mCameraIcon.setImageResource(R.drawable.ugc_camera_item_selector);
            }
            if (this.mSingleSelected) {
                if (SelectUtil.getSelectedCount() + SelectUtil.getCurrentAlbumSelectedImagesCount() == 1) {
                    holder.mCameraIcon.setImageResource(R.drawable.ugc_camera_unenable_icon);
                } else {
                    holder.mCameraIcon.setImageResource(R.drawable.ugc_camera_item_selector);
                }
            }
            holder.itemView.setOnClickListener(new ImageAdapter$$ExternalSyntheticLambda1(this));
            return;
        }
        holder.itemView.setOnClickListener(new ImageAdapter$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onBindCameraHolder$1$com-baidu-searchbox-ugc-adapter-ImageAdapter  reason: not valid java name */
    public /* synthetic */ void m4355lambda$onBindCameraHolder$1$combaidusearchboxugcadapterImageAdapter(View v) {
        if (!isNotClickable()) {
            UgcUBCUtils.clickLayerStatistics(3, UgcUBCUtils.mPicChoiceBtnPage, this.mNoStatistics);
            int i2 = this.mType;
            if (i2 == 0) {
                goTakePhoto();
            } else if (i2 == 1 || i2 == 3) {
                goRecordVideo();
            } else if (isOptionalWithVideo() || this.isHideShoot) {
                goTakePhoto();
            } else if (this.mContext != null) {
                new CameraSelectDialog(this.mContext, new CameraSelectDialog.CameraSlectDialogListener() {
                    public void takePhoto() {
                        ImageAdapter.this.goTakePhoto();
                    }

                    public void recordVideo() {
                        ImageAdapter.this.goRecordVideo();
                    }
                }).show();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onBindCameraHolder$2$com-baidu-searchbox-ugc-adapter-ImageAdapter  reason: not valid java name */
    public /* synthetic */ void m4356lambda$onBindCameraHolder$2$combaidusearchboxugcadapterImageAdapter(View v) {
        UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mVideoChoiceBtnPage, this.mNoStatistics);
        goRecordVideo();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        if (payloads == null || payloads.size() <= 0) {
            onBindViewHolder(holder, position);
            return;
        }
        Object payload = payloads.get(0);
        if (payload == null) {
            onBindViewHolder(holder, position);
        } else if (!"refresh_photo_selected_container".equals(payload)) {
            onBindViewHolder(holder, position);
        } else if (getItemViewType(position) == 1 || getItemViewType(position) == 2) {
            Object item = this.itemList.get(position);
            if (!(holder instanceof ImageViewHolder) || !(item instanceof ImageStruct)) {
                onBindViewHolder(holder, position);
                return;
            }
            refreshPhotoSelected((ImageViewHolder) holder, (ImageStruct) item);
        }
    }

    public void notifyItemPhotoSelectedUI() {
        notifyItemRangeChanged(0, getItemCount(), "refresh_photo_selected_container");
    }

    private void refreshPhotoSelected(ImageViewHolder holder, ImageStruct imageStruct) {
        if (holder != null && imageStruct != null) {
            if (!SelectUtil.getCurrentAlbumSelectedImages().contains(imageStruct)) {
                UiBaseUtils.setImageResource(holder.mSelectedCb, R.drawable.ugc_unselect_thumb_icon);
                if (holder.orderNumber != null) {
                    holder.orderNumber.setVisibility(8);
                }
            } else if (!this.mSingleSelected) {
                UiBaseUtils.setImageResource(holder.mSelectedCb, R.drawable.ugc_select_icon_bg);
                UiBaseUtils.setVisibility(holder.orderNumber, 0);
                UiBaseUtils.setTextString(holder.orderNumber, getIndex(imageStruct.contentUri) + "");
            } else {
                UiBaseUtils.setImageResource(holder.mSelectedCb, R.drawable.ugc_selected_icon);
            }
            if (!AlbumViewHelperKt.isMultiChoiceMax(this.isHalfAlbum)) {
                UiBaseUtils.setVisibility(holder.unableShadow, 8);
            } else if (SelectUtil.getCurrentAlbumSelectedImages().contains(imageStruct)) {
                UiBaseUtils.setVisibility(holder.unableShadow, 8);
            } else {
                UiBaseUtils.setVisibility(holder.unableShadow, 0);
            }
        }
    }

    private void onBindActivityHolder(RecyclerView.ViewHolder holder) {
        ActivityViewHolder activityViewHolder = (ActivityViewHolder) holder;
        UiBaseUtils.setViewColorResource(activityViewHolder.activityImageView, R.color.ugc_album_selectitem_bg);
        activityViewHolder.activityImageView.setImageURI(this.ugcAlbumActivityModel.getImageUrl());
        activityViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (AlbumViewHelperKt.isMultiChoiceMax(ImageAdapter.this.isHalfAlbum)) {
                    UniversalToast.makeText((Context) ImageAdapter.this.mContext, (CharSequence) String.format(ImageAdapter.this.mContext.getResources().getString(R.string.ugc_camera_max_select_tip), new Object[]{Integer.valueOf(SelectUtil.maxSelected)})).show();
                    return;
                }
                Router.invoke(AppRuntime.getAppContext(), ImageAdapter.this.ugcAlbumActivityModel.getScheme());
                if (ImageAdapter.this.onAlbumActivityClickListener != null) {
                    ImageAdapter.this.onAlbumActivityClickListener.onClick();
                }
                UgcUBCUtils.ubcUgcPublishBehavior("publish_editor", UgcUBCUtils.UGC_TYPE_ALBUM_ACTIVITY_CLICK, ImageAdapter.this.isHalfAlbum ? "1" : "2");
            }
        });
    }

    private void onBindMediaPermissionHolder(MediaPermissionViewHolder holder, FrameLayout.LayoutParams layoutParams) {
        UiBaseUtils.setViewColorResource(holder.itemView, R.color.ugc_white);
        UiBaseUtils.setViewDrawableResource(holder.mediaPermissionRoot, R.drawable.ugc_camera_bg);
        UiBaseUtils.setLayoutParams(holder.mediaPermissionRoot, layoutParams);
        holder.itemView.setOnClickListener(new ImageAdapter$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onBindMediaPermissionHolder$3$com-baidu-searchbox-ugc-adapter-ImageAdapter  reason: not valid java name */
    public /* synthetic */ void m4357lambda$onBindMediaPermissionHolder$3$combaidusearchboxugcadapterImageAdapter(View v) {
        OnItemClickPermissionEnterListener onItemClickPermissionEnterListener2 = this.onItemClickPermissionEnterListener;
        if (onItemClickPermissionEnterListener2 != null) {
            onItemClickPermissionEnterListener2.requestPermission();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r2.model;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isOptionalWithVideo() {
        /*
            r2 = this;
            int r0 = com.baidu.searchbox.ugc.utils.SelectUtil.getSelectedCount()
            int r1 = com.baidu.searchbox.ugc.utils.SelectUtil.getCurrentAlbumSelectedImagesCount()
            int r0 = r0 + r1
            if (r0 > 0) goto L_0x0016
            com.baidu.searchbox.ugc.webjs.UgcSchemeModel r0 = r2.model
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isHasProduct
            if (r0 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r0 = 0
            goto L_0x0017
        L_0x0016:
            r0 = 1
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.ugc.adapter.ImageAdapter.isOptionalWithVideo():boolean");
    }

    /* access modifiers changed from: private */
    public void goTakePhoto() {
        if (!AlbumViewHelperKt.isMultiChoiceMax(this.isHalfAlbum)) {
            if (!this.mSingleSelected || SelectUtil.getSelectedCount() + SelectUtil.getCurrentAlbumSelectedImagesCount() != 1) {
                String[] permissions = {"android.permission.CAMERA"};
                if (!UgcPermissionUtils.isPermissionGroupGranted(this.mContext, permissions)) {
                    if (this.isHalfAlbum) {
                        UgcUBCUtils.ugcHalCameraClickStatistics("half_album", UgcUBCUtils.UGC_SHOOT_UNAUTHORIZED, this.mSourceFrom);
                    } else {
                        UgcUBCUtils.ugcHalCameraClickStatistics("pic_album", UgcUBCUtils.UGC_SHOOT_UNAUTHORIZED, this.mSourceFrom);
                    }
                    UgcRuntime.getUgcInterface().requestAllPermisson("ugc_pic", permissions, 0, this.mContext, new IUgcHostInterface.AllPermissonCallback() {
                        public void callback(boolean isAllAgree) {
                            if (isAllAgree) {
                                ImageAdapter.this.enterTakePictureView();
                            }
                        }
                    }, 1, (UgcPermissionDialogUtils.UgcPermissionCallback) null);
                    return;
                }
                if (this.isHalfAlbum) {
                    UgcUBCUtils.ugcHalCameraClickStatistics("half_album", UgcUBCUtils.UGC_SHOOT_AUTHORIZED, this.mSourceFrom);
                } else {
                    UgcUBCUtils.ugcHalCameraClickStatistics("pic_album", UgcUBCUtils.UGC_SHOOT_AUTHORIZED, this.mSourceFrom);
                }
                enterTakePictureView();
            }
        }
    }

    /* access modifiers changed from: private */
    public void goRecordVideo() {
        if (StorageUtils.getAvailableExternalMemorySize() < 52428800) {
            UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) this.mContext.getResources().getString(R.string.ugc_camera_no_storage_prompt)).showToast();
        }
        this.model.launchFrom = "album";
        final IPublisherSboxVideoInterface publisherSboxVideoManager = (IPublisherSboxVideoInterface) ServiceManager.getService(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (publisherSboxVideoManager != null) {
            LocalAlbumDelegateActivity.startDelegateActivityForResult(this.mContext, this.localAlbumDelegateListener, new LocalAlbumDelegateActivity.ILocalAlbumDelegateDispatcher() {
                public void dispatch(final Activity activity) {
                    publisherSboxVideoManager.invokeVideoCapture(ImageAdapter.this.model, activity, ImageAdapter.this.mLaunchFrom, new UgcPermissionDialogUtils.UgcPermissionCallback() {
                        public void onClickClose() {
                            activity.finish();
                        }
                    });
                }
            });
        }
    }

    public void updatePhotoItem(final ImageViewHolder holder, final ImageStruct ist) {
        final int position = getImageList().indexOf(ist);
        UiBaseUtils.setVisibility(holder.selectView, 0);
        UiBaseUtils.setImageResource(holder.mSelectedCb, R.drawable.ugc_unselect_thumb_icon);
        if (ist != null) {
            setImageBg(ist.contentUri, holder, position);
            refreshPhotoSelected(holder, ist);
            if (this.mSingleSelected) {
                if (SelectUtil.getSelectedCount() + SelectUtil.getCurrentAlbumSelectedImagesCount() != 1) {
                    UiBaseUtils.setVisibility(holder.unableShadow, 8);
                } else if (SelectUtil.getCurrentAlbumSelectedImages().contains(ist)) {
                    UiBaseUtils.setVisibility(holder.unableShadow, 8);
                } else {
                    UiBaseUtils.setVisibility(holder.unableShadow, 0);
                }
            }
            if (holder.rightBottomTipBg != null) {
                holder.rightBottomTipBg.setVisibility(0);
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) holder.rightBottomTipBg.getLayoutParams();
                params.width = DeviceUtil.ScreenInfo.dp2px(this.mContext, 33.0f);
                params.height = DeviceUtil.ScreenInfo.dp2px(this.mContext, 18.0f);
                holder.rightBottomTipBg.setLayoutParams(params);
            }
            if (!SelectUtil.supportGifLongImg) {
                UiBaseUtils.setVisibility(holder.rightBottomTipBg, 8);
            } else if (ist.isGif()) {
                UiBaseUtils.setTextStringResource(holder.rightBottomTip, R.string.ugc_album_gif_photo);
            } else if (ist.isLargeImage()) {
                UiBaseUtils.setTextStringResource(holder.rightBottomTip, R.string.ugc_album_large_photo);
            } else {
                UiBaseUtils.setVisibility(holder.rightBottomTipBg, 8);
            }
            UiBaseUtils.setOnClickListener(holder.selectView, new View.OnClickListener() {
                public void onClick(View v) {
                    if (SelectUtil.getCurrentAlbumSelectedImages().contains(ist)) {
                        SelectUtil.removeCurrentAlbumSelectedImages(ist);
                        UiBaseUtils.setImageResource(holder.mSelectedCb, R.drawable.ugc_unselect_thumb_icon);
                        if (holder.orderNumber != null) {
                            holder.orderNumber.setVisibility(8);
                        }
                        if (ImageAdapter.this.mListener != null) {
                            ImageAdapter.this.mListener.selectChanged(SelectUtil.getCurrentAlbumSelectedImagesCount(), 1);
                        }
                        ImageAdapter.this.notifyItemPhotoSelectedUI();
                    } else if (AlbumViewHelperKt.isMultiChoiceMax(ImageAdapter.this.isHalfAlbum)) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) String.format(ImageAdapter.this.mContext.getString(R.string.ugc_album_selected_max_photos), new Object[]{Integer.valueOf(SelectUtil.getCurrentAlbumSelectedImagesCount())})).showToast();
                    } else if (ImageAdapter.this.mSingleSelected && SelectUtil.getSelectedCount() + SelectUtil.getCurrentAlbumSelectedImagesCount() >= 1) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) String.format(ImageAdapter.this.mContext.getString(R.string.ugc_album_selected_max_photos), new Object[]{1})).showToast();
                    } else if (AlbumUriUtils.isImageLegal(ist)) {
                        if (!ImageAdapter.this.mSingleSelected) {
                            UiBaseUtils.setImageResource(holder.mSelectedCb, R.drawable.ugc_select_icon_bg);
                            UiBaseUtils.setVisibility(holder.orderNumber, 0);
                            UiBaseUtils.setTextString(holder.orderNumber, ImageAdapter.this.getIndex(ist.contentUri) + "");
                        } else {
                            UiBaseUtils.setImageResource(holder.mSelectedCb, R.drawable.ugc_selected_icon);
                        }
                        SelectUtil.addCurrentAlbumSelectedImages(ist, position);
                        UiBaseUtils.startAnimation(holder.selectCircle, AnimationUtils.loadAnimation(ImageAdapter.this.mContext, R.anim.ugc_checkshake));
                        if (ImageAdapter.this.mListener != null) {
                            ImageAdapter.this.mListener.selectChanged(SelectUtil.getCurrentAlbumSelectedImagesCount(), 0);
                        }
                        ImageAdapter.this.notifyItemPhotoSelectedUI();
                    }
                }
            });
            UiBaseUtils.setOnClickListener(holder.mImageIv, new View.OnClickListener() {
                public void onClick(View view2) {
                    if (!ImageAdapter.this.isNotClickable()) {
                        if (SelectUtil.getSelectedCount() + SelectUtil.getCurrentAlbumSelectedImagesCount() != SelectUtil.maxSelected || (SelectUtil.getSelectedCount() + SelectUtil.getCurrentAlbumSelectedImagesCount() == SelectUtil.maxSelected && SelectUtil.getCurrentAlbumSelectedImages().contains(ist))) {
                            LocalAlbumDelegateActivity.startDelegateActivityForResult(ImageAdapter.this.mContext, ImageAdapter.this.localAlbumDelegateListener, new LocalAlbumDelegateActivity.ILocalAlbumDelegateDispatcher() {
                                public void dispatch(Activity activity) {
                                    if (!(activity == null || activity.getWindow() == null)) {
                                        activity.getWindow().addFlags(Integer.MIN_VALUE);
                                        activity.getWindow().setNavigationBarColor(-16777216);
                                    }
                                    ImageHelper.setImageList(ImageAdapter.this.isHalfAlbum, ImageAdapter.this.previewImageList);
                                    Intent intent = new Intent(activity, LocalPhotoPreviewActivity.class);
                                    intent.putExtra("position", position);
                                    intent.putExtra("from", "album");
                                    intent.putExtra("isSupportSingle", ImageAdapter.this.mSingleSelected);
                                    intent.putExtra("isSupportOriginal", ImageAdapter.this.isSupportOriginal);
                                    intent.putExtra("isSelectedOriginal", ImageAdapter.this.isSelectedOriginal);
                                    intent.putExtra("isHalfAlbum", ImageAdapter.this.isHalfAlbum);
                                    intent.putExtra("publishType", ImageAdapter.this.mPublishType);
                                    intent.putExtra("noStatistics", ImageAdapter.this.mNoStatistics);
                                    intent.putExtra("from_type", ImageAdapter.this.mFromType);
                                    LocalPhotoPreviewActivity.startForResultIfNotRunning(activity, intent, 32770);
                                }
                            }, false);
                        }
                    }
                }
            });
        }
    }

    private void updateVideoItem(ImageViewHolder holder, final VideoInfo vi) {
        final int position = getVideoList().indexOf(vi);
        if (holder.rightBottomTipBg != null) {
            holder.rightBottomTipBg.setVisibility(0);
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) holder.rightBottomTipBg.getLayoutParams();
            params.width = DeviceUtil.ScreenInfo.dp2px(this.mContext, 38.3f);
            params.height = DeviceUtil.ScreenInfo.dp2px(this.mContext, 17.4f);
            holder.rightBottomTipBg.setLayoutParams(params);
        }
        if (vi != null) {
            long[] time = getMinuteAndSecond(vi.duration);
            if (holder.rightBottomTip != null) {
                holder.rightBottomTip.setText(String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Long.valueOf(time[0]), Long.valueOf(time[1])}));
            }
            setImageBg(vi.contentUri, holder, position);
            if (isOptionalWithVideo()) {
                UiBaseUtils.setVisibility(holder.unableShadow, 0);
            } else {
                UiBaseUtils.setVisibility(holder.unableShadow, 8);
            }
            holder.mImageIv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    if (!ImageAdapter.this.isNotClickable()) {
                        if (SelectUtil.getSelectedCount() + SelectUtil.getCurrentAlbumSelectedImagesCount() > 0) {
                            UniversalToast.makeText(ImageAdapter.this.mContext.getApplicationContext(), (CharSequence) ImageAdapter.this.mContext.getString(R.string.ugc_album_photo_single_select_prompt)).showToast();
                        } else if (ImageAdapter.this.model != null && ImageAdapter.this.model.isHasProduct) {
                            UniversalToast.makeText(ImageAdapter.this.mContext.getApplicationContext(), (CharSequence) ImageAdapter.this.mContext.getString(R.string.ugc_album_video_exclusion_tip)).show();
                        } else if (AlbumUriUtils.isVideoLegal(vi)) {
                            if ("plugin".equals(ImageAdapter.this.mLaunchFrom)) {
                                ImageAdapter imageAdapter = ImageAdapter.this;
                                imageAdapter.invokePluginForAlbumResult(imageAdapter.mContext, vi.uriStr, false);
                                ImageAdapter.this.mContext.finish();
                                ImageAdapter.this.mContext.overridePendingTransition(0, 0);
                            } else {
                                LocalAlbumDelegateActivity.startDelegateActivityForResult(ImageAdapter.this.mContext, ImageAdapter.this.localAlbumDelegateListener, new LocalAlbumDelegateActivity.ILocalAlbumDelegateDispatcher() {
                                    public void dispatch(Activity activity) {
                                        Intent intent = new Intent();
                                        intent.putExtra("path", vi.uriStr);
                                        intent.putExtra("size", vi.getSize());
                                        if (TextUtils.equals(ImageAdapter.this.mLaunchFrom, "external")) {
                                            intent.putExtra("from", ImageAdapter.this.mLaunchFrom);
                                        }
                                        ImageAdapter.this.openVideoPreviewActivityForResult(activity, intent, 32771);
                                    }
                                }, false);
                            }
                            if (ImageAdapter.this.mUbcAlbum != null) {
                                UgcPerformanceUbcUtils.ugcAlbumVideoPerfStatistics(ImageAdapter.this.mType, ImageAdapter.this.mLaunchFrom, ImageAdapter.this.mUbcAlbum.getTiming(), ImageAdapter.this.mUbcAlbum.getTotalNum(), position);
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void enterTakePictureView() {
        LocalAlbumDelegateActivity.startDelegateActivityForResult(this.mContext, this.localAlbumDelegateListener, new LocalAlbumDelegateActivity.ILocalAlbumDelegateDispatcher() {
            public void dispatch(Activity activity) {
                ImageHelper.takePicture(activity, 2, ImageAdapter.this.mCameraDirection);
                UgcUBCUtils.ugcPvStatistics(0, UgcUBCUtils.mPublishShootPage, ImageAdapter.this.mNoStatistics);
            }
        });
    }

    /* access modifiers changed from: private */
    public void invokePluginForAlbumResult(Context context, String videoPath, boolean onlyPreview) {
        IPublisherSboxVideoInterface publisherSboxVideoManager = (IPublisherSboxVideoInterface) ServiceManager.getService(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (publisherSboxVideoManager != null) {
            publisherSboxVideoManager.invokePluginForAlbumResult(context, videoPath, onlyPreview);
        }
    }

    /* access modifiers changed from: private */
    public void openVideoPreviewActivityForResult(Activity activity, Intent intent, int requestCode) {
        IPublisherSboxVideoInterface publisherSboxVideoManager = (IPublisherSboxVideoInterface) ServiceManager.getService(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (publisherSboxVideoManager != null) {
            publisherSboxVideoManager.openVideoPreviewActivityForResult(activity, intent, requestCode);
        }
    }

    private void updateUi(ImageViewHolder viewHolder, View view2) {
        UiBaseUtils.setViewColorResource(view2, R.color.ugc_white);
        UiBaseUtils.setViewColorResource(viewHolder.mImageIv, R.color.ugc_album_selectitem_bg);
        UiBaseUtils.setTextColorResource(viewHolder.orderNumber, R.color.ugc_select_number_color);
        UiBaseUtils.setViewDrawableResource(viewHolder.rightBottomTipBg, R.drawable.ugc_video_timelong_bg);
        UiBaseUtils.setTextColorResource(viewHolder.rightBottomTip, R.color.ugc_white);
        UiBaseUtils.setViewColorResource(viewHolder.unableShadow, R.color.ugc_album_unenable_shadow_color);
    }

    private boolean loadThumbnail(Uri uri, ImageViewHolder holder, int position) {
        Activity activity;
        if (uri == null || holder == null || holder.mImageIv == null || (activity = this.mContext) == null || position < 0) {
            return false;
        }
        if (this.preloadThumbnailCount == 0 && this.itemHeight != 0) {
            this.preloadThumbnailCount = (DeviceUtil.ScreenInfo.getDisplayHeight(activity) / this.itemHeight) * 3;
        }
        if (position > this.preloadThumbnailCount) {
            return false;
        }
        if (this.thumbnailLoader == null) {
            this.thumbnailLoader = new ImageThumbnailLoader();
        }
        return this.thumbnailLoader.loadThumbnail(this.mContext.getApplicationContext(), holder.mImageIv, uri, this.itemWidth, this.itemHeight);
    }

    private void setImageBg(Uri uri, ImageViewHolder holder, int position) {
        ImageDecodeOptions decodeOptions = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        ImageRequestBuilder builder = ImageRequestBuilder.newBuilderWithSource(uri);
        builder.setImageDecodeOptions(decodeOptions);
        builder.setLoadThumbnailOnly(true);
        if (holder.mImageIv != null) {
            holder.mImageIv.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(builder.build())).setAutoPlayAnimations(false)).setOldController(holder.mImageIv.getController())).build());
        }
    }

    /* access modifiers changed from: private */
    public int getIndex(Uri uri) {
        for (int i2 = 0; i2 < SelectUtil.getCurrentAlbumSelectedImagesCount(); i2++) {
            if (uri.equals(SelectUtil.getCurrentAlbumSelectedImages().get(i2).contentUri)) {
                return i2 + 1;
            }
        }
        return 0;
    }

    private long[] getMinuteAndSecond(long mils) {
        long mils2 = mils / 1000;
        return new long[]{mils2 / 60, mils2 % 60};
    }

    /* access modifiers changed from: private */
    public boolean isNotClickable() {
        if (this.mLastClickTime == 0) {
            this.mLastClickTime = System.currentTimeMillis();
            return false;
        }
        long now = System.currentTimeMillis();
        if (now - this.mLastClickTime <= 1000) {
            return true;
        }
        this.mLastClickTime = now;
        return false;
    }

    private void addElement(Object bean, int type) {
        addElement(bean, type, -1);
    }

    private void addElement(Object bean, int type, int index) {
        if (index < 0 || index > this.itemList.size()) {
            this.typeList.add(Integer.valueOf(type));
            this.itemList.add(bean);
            return;
        }
        this.typeList.add(index, Integer.valueOf(type));
        this.itemList.add(index, bean);
    }

    private void addElements(List<?> datas, List<Integer> types) {
        if (datas != null && types != null && !datas.isEmpty() && !types.isEmpty() && datas.size() == types.size()) {
            this.typeList.addAll(types);
            this.itemList.addAll(datas);
        }
    }

    private void clearData() {
        this.typeList.clear();
        this.itemList.clear();
    }

    private boolean invalidPosition(int position) {
        return position < 0 || position >= this.typeList.size();
    }

    private List<ImageStruct> getImageList() {
        List<ImageStruct> imageList = new ArrayList<>();
        if (this.itemList.isEmpty()) {
            return imageList;
        }
        for (int i2 = 0; i2 < this.itemList.size(); i2++) {
            Object item = this.itemList.get(i2);
            if (item instanceof ImageStruct) {
                imageList.add((ImageStruct) item);
            }
        }
        return imageList;
    }

    private List<VideoInfo> getVideoList() {
        List<VideoInfo> videoList = new ArrayList<>();
        if (this.itemList.isEmpty()) {
            return videoList;
        }
        for (int i2 = 0; i2 < this.itemList.size(); i2++) {
            Object item = this.itemList.get(i2);
            if (item instanceof VideoInfo) {
                videoList.add((VideoInfo) item);
            }
        }
        return videoList;
    }

    private void checkAddReadMediaPermissionEnter() {
        boolean isOnlyReadUserSelectedImage = PermissionsUtils.isOnlyReadUserSelectedImage(AppRuntime.getAppContext());
    }

    private static class CameraViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mCameraEnterIcon;
        public ImageView mCameraIcon;
        public TextView mUgcCameraText;

        public CameraViewHolder(View itemView) {
            super(itemView);
            this.mCameraEnterIcon = (LinearLayout) itemView.findViewById(R.id.ugc_camera_enter);
            this.mCameraIcon = (ImageView) itemView.findViewById(R.id.ugc_camera_icon);
            this.mUgcCameraText = (TextView) itemView.findViewById(R.id.ugc_camera_text);
        }
    }

    private static class MediaPermissionViewHolder extends RecyclerView.ViewHolder {
        public FrameLayout mediaPermissionRoot;

        public MediaPermissionViewHolder(View itemView) {
            super(itemView);
            this.mediaPermissionRoot = (FrameLayout) itemView.findViewById(R.id.media_permission_root);
        }
    }

    private static class ImageViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView mImageIv;
        public ImageView mSelectedCb;
        public TextView orderNumber;
        public TextView rightBottomTip;
        public View rightBottomTipBg;
        public View selectCircle;
        public View selectView;
        public ImageView unableShadow;

        public ImageViewHolder(View itemView) {
            super(itemView);
            this.mImageIv = (SimpleDraweeView) itemView.findViewById(R.id.ugc_img);
            this.mSelectedCb = (ImageView) itemView.findViewById(R.id.ugc_list_item_cb);
            this.orderNumber = (TextView) itemView.findViewById(R.id.ugc_select_number);
            this.selectView = itemView.findViewById(R.id.ugc_selected_check);
            this.selectCircle = itemView.findViewById(R.id.ugc_select_circle_view);
            this.unableShadow = (ImageView) itemView.findViewById(R.id.ugc_unable_shadow);
            this.rightBottomTipBg = itemView.findViewById(R.id.ugc_video_time_bg);
            this.rightBottomTip = (TextView) itemView.findViewById(R.id.ugc_right_bottom_tip);
        }
    }

    private static class VideoViewHolder extends ImageViewHolder {
        public VideoViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ActivityViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView activityImageView;

        public ActivityViewHolder(View itemView) {
            super(itemView);
            this.activityImageView = (SimpleDraweeView) itemView.findViewById(R.id.ugc_activity_img);
            UgcUBCUtils.ubcUgcPublishBehavior("publish_editor", UgcUBCUtils.UGC_TYPE_ALBUM_ACTIVITY_VIEW, ImageAdapter.this.isHalfAlbum ? "1" : "2");
        }
    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
