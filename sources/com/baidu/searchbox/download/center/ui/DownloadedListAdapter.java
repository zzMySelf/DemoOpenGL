package com.baidu.searchbox.download.center.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.dialog.BdDialog;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.download.DownloadStatisticsUBC;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.compress.archive.exception.BdArchiveException;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.apkcheck.ApkCheckerKt;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.clearcache.util.RedownloadFilter;
import com.baidu.searchbox.download.center.constant.DownloadCenterConstants;
import com.baidu.searchbox.download.center.ioc.IDownloadCenterApp;
import com.baidu.searchbox.download.center.ui.DownloadedSecPageViewHolder;
import com.baidu.searchbox.download.center.ui.dispatcher.DownloadedFileRenameDispatcher;
import com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic;
import com.baidu.searchbox.download.center.ui.video.fusion.model.AbsVideoTemplateModel;
import com.baidu.searchbox.download.center.unzip.DownloadUnzipConstants;
import com.baidu.searchbox.download.center.unzip.DownloadUnzipProgressListener;
import com.baidu.searchbox.download.center.unzip.DownloadUnzipUbc;
import com.baidu.searchbox.download.center.unzip.UnzipUtilsKt;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import com.baidu.searchbox.statistics.DownloadWinStaConstants;
import com.baidu.searchbox.statistics.DownloadWindownUBC;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

public class DownloadedListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int BOTTOM_MARGIN_ITEM = 3;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final int DOWNLOADED_ITEM = 0;
    public static final String FILE_SCHEMA = "file://";
    private static final int GUIDE_CLEAR_ITEM = 2;
    private static final int GUIDE_CLEAR_TITLE = 1;
    private static final int HAS_UNZIP_DIR = 1;
    private static final int SECONDS_COUNT_IN_ONE_HOUR = 3600;
    private static final int SECONDS_COUNT_IN_ONE_MIN = 60;
    /* access modifiers changed from: private */
    public static final String TAG = DownloadedListAdapter.class.getSimpleName();
    public static final int TYPE_DOWNLOAD = 0;
    public static final int TYPE_GUIDE_CLEAR = 1;
    /* access modifiers changed from: private */
    public final long mCategory;
    /* access modifiers changed from: private */
    public DownloadedSelectListener mChangeSelectedListener;
    /* access modifiers changed from: private */
    public final Context mContext;
    private int mCurrentType;
    private ArrayList<CategoryInfoData> mDownloadedDataList;
    private List<CategoryInfoData> mGuideClearAdapterList = new ArrayList();
    /* access modifiers changed from: private */
    public boolean mIsEditMode = false;
    private final ItemClickListener mItemClickListener = new ItemClickListener();
    /* access modifiers changed from: private */
    public HandleItemsEventsCallback mItemEventsCallback;
    private RecyclerView mRecyclerView;
    private boolean mShowOpenTime = false;
    /* access modifiers changed from: private */
    public ArrayList<CategoryInfoData> mUnzipDirList;

    interface HandleItemsEventsCallback {
        void deleteItem(CategoryInfoData categoryInfoData);

        void modifyItemNewFlag(long j2);

        void restartItems(CategoryInfoData categoryInfoData);

        void setOpendDocFlag();
    }

    public int getCurrentType() {
        return this.mCurrentType;
    }

    public DownloadedListAdapter(Context context, long category) {
        this.mContext = context;
        this.mCategory = category;
        if (isDownloadTypeZip()) {
            refreshUnzipDirList();
        }
        this.mDownloadedDataList = new ArrayList<>();
    }

    public void changeToGuideClear(List<CategoryInfoData> guideClearList, Set<CategoryInfoData> selectedItems, HashMap<Long, Long> selectedSizeMap) {
        this.mCurrentType = 1;
        this.mGuideClearAdapterList.clear();
        this.mGuideClearAdapterList.addAll(guideClearList);
        handleGuideClearData(this.mGuideClearAdapterList, selectedItems, selectedSizeMap);
        notifyDataSetChanged();
    }

    private void handleGuideClearData(List<CategoryInfoData> guideClearList, Set<CategoryInfoData> selectedItems, HashMap<Long, Long> selectedSizeMap) {
        for (CategoryInfoData data : guideClearList) {
            if (data.guideClearState == 1 || data.guideClearState == 2 || data.guideClearState == 3) {
                selectedItems.add(data);
                data.setSelected(true);
                selectedSizeMap.put(Long.valueOf(data.mId), Long.valueOf(DownloadInfoUtil.getDownloadFileSize(data, 0)));
            }
        }
    }

    public void changeToDownload() {
        this.mCurrentType = 0;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new DownloadedSecPageViewHolder(this.mContext, this.mCategory);
            case 1:
                return new TitleViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.download_title_layout, parent, false));
            case 2:
                return new DownloadedSecPageViewHolder(this.mContext, this.mCategory);
            case 3:
                return new BottomMarginHolder(new View(this.mContext));
            default:
                return new DownloadedSecPageViewHolder(this.mContext, this.mCategory);
        }
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;

        TitleViewHolder(View itemView) {
            super(itemView);
            this.mTitle = (TextView) itemView.findViewById(R.id.download_item_title);
        }

        public void adjustNightMode() {
            this.mTitle.setTextColor(DownloadedListAdapter.this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                bindDownloadItem(holder, position);
                return;
            case 1:
                ((TitleViewHolder) holder).mTitle.setText(this.mContext.getResources().getString(R.string.download_center_guideclear) + FileViewerActivity.LEFT_BRACKET + this.mGuideClearAdapterList.size() + ")");
                ((TitleViewHolder) holder).adjustNightMode();
                return;
            case 2:
                bindGuideClearItem(holder, position);
                return;
            case 3:
                ((BottomMarginHolder) holder).update((AbsVideoTemplateModel) null, position, false, false);
                return;
            default:
                return;
        }
    }

    private void bindDownloadItem(RecyclerView.ViewHolder holder, int position) {
        CategoryInfoData currentInfo;
        ArrayList<CategoryInfoData> arrayList = this.mUnzipDirList;
        if (arrayList != null) {
            int size = arrayList.size();
        }
        if (!isDownloadTypeZip() || this.mIsEditMode) {
            currentInfo = this.mDownloadedDataList.get(position);
        } else if (position == 0) {
            currentInfo = new SpecialItemCreatedFactory().getHasUnZipInfo();
            ubcShowUnZipDir();
        } else {
            currentInfo = this.mDownloadedDataList.get(position - 1);
        }
        DownloadedSecPageViewHolder viewHolder = (DownloadedSecPageViewHolder) holder;
        viewHolder.adjustNightMode();
        viewHolder.setItemClickListener(this.mItemClickListener);
        viewHolder.updateItem(currentInfo, this.mIsEditMode, false);
        viewHolder.setRecycleView(this.mRecyclerView);
        if (this.mShowOpenTime) {
            viewHolder.setCreateTimeText(DownloadingAdapter.getOpenTimeStr(DownloadInfoUtil.getFileOpenTime(currentInfo, currentInfo.mCompletionTime)));
        }
    }

    private void bindGuideClearItem(RecyclerView.ViewHolder holder, int position) {
        DownloadedSecPageViewHolder viewHolder = (DownloadedSecPageViewHolder) holder;
        viewHolder.adjustNightMode();
        viewHolder.setItemClickListener(this.mItemClickListener);
        viewHolder.updateItem(this.mGuideClearAdapterList.get(position - 1), this.mIsEditMode, true);
    }

    public int getItemCount() {
        if (this.mCurrentType == 1) {
            return this.mGuideClearAdapterList.size() + 1;
        }
        if (this.mIsEditMode) {
            return this.mDownloadedDataList.size();
        }
        boolean isDownloadTypeZip = isDownloadTypeZip();
        if ((isDownloadTypeZip ? 1 : 0) + this.mDownloadedDataList.size() == 0) {
            return 0;
        }
        boolean isDownloadTypeZip2 = isDownloadTypeZip();
        return (isDownloadTypeZip2 ? 1 : 0) + this.mDownloadedDataList.size() + 1;
    }

    public int getZipCount() {
        return this.mDownloadedDataList.size();
    }

    public int getRealItemCount() {
        if (this.mCurrentType == 1) {
            return this.mGuideClearAdapterList.size();
        }
        ArrayList<CategoryInfoData> arrayList = this.mUnzipDirList;
        return (arrayList == null ? 0 : arrayList.size()) + this.mDownloadedDataList.size();
    }

    public int getItemViewType(int position) {
        if (this.mCurrentType == 1) {
            if (position == 0) {
                return 1;
            }
            return 2;
        } else if (position != getItemCount() - 1 || this.mIsEditMode) {
            return 0;
        } else {
            return 3;
        }
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public boolean isDownloadTypeZip() {
        return this.mCategory == 8;
    }

    public synchronized void setDownloadedData(List<CategoryInfoData> list) {
        if (list != null) {
            refreshUnzipDirList();
            this.mDownloadedDataList.clear();
            this.mDownloadedDataList.addAll(list);
        }
    }

    public void refreshUnzipDirList() {
        if (isDownloadTypeZip()) {
            if (this.mUnzipDirList == null) {
                this.mUnzipDirList = new ArrayList<>();
            }
            this.mUnzipDirList.clear();
            List<File> unZipScanDirs = DownloadUnzipConstants.INSTANCE.getUnzipScanDirs(this.mContext);
            if (unZipScanDirs != null && !unZipScanDirs.isEmpty()) {
                for (File unzipRootDir : unZipScanDirs) {
                    if (unzipRootDir.exists()) {
                        File[] listFiles = unzipRootDir.listFiles();
                        File[] rootDirFileList = listFiles;
                        if (listFiles != null) {
                            for (File f2 : rootDirFileList) {
                                if (f2.isDirectory()) {
                                    CategoryInfoData data = new CategoryInfoData();
                                    data.mId = (long) f2.hashCode();
                                    data.mDownloadPath = f2.getAbsolutePath();
                                    data.mType = 7;
                                    data.mFileName = f2.getName();
                                    data.mCompletionTime = f2.lastModified();
                                    data.mSize = f2.length();
                                    this.mUnzipDirList.add(data);
                                }
                            }
                        }
                    }
                }
            }
            Collections.sort(this.mUnzipDirList, new Comparator<CategoryInfoData>() {
                public int compare(CategoryInfoData dir1, CategoryInfoData dir2) {
                    if (dir1 == null || dir2 == null || dir2.mCompletionTime == dir1.mCompletionTime) {
                        return 0;
                    }
                    if (dir2.mCompletionTime > dir1.mCompletionTime) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
    }

    public void onSelectedAllClicked(boolean selected, boolean editMode, Set<CategoryInfoData> selectedItems, HashMap<Long, Long> selectedSizeMap) {
        if (this.mCurrentType == 1) {
            for (CategoryInfoData data : this.mGuideClearAdapterList) {
                data.setSelected(selected);
                if (selected && selectedItems.add(data)) {
                    selectedSizeMap.put(Long.valueOf(data.mId), Long.valueOf(DownloadInfoUtil.getDownloadFileSize(data, 0)));
                }
            }
        } else {
            for (int i2 = 0; i2 < this.mDownloadedDataList.size(); i2++) {
                CategoryInfoData info = this.mDownloadedDataList.get(i2);
                info.setSelected(selected);
                if (selected && selectedItems.add(info)) {
                    selectedSizeMap.put(Long.valueOf(info.mId), Long.valueOf(DownloadInfoUtil.getDownloadFileSize(info, 0)));
                }
            }
        }
        setEditMode(editMode);
        notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void onEditableChanged(boolean isEditable) {
        if (!isEditable) {
            if (this.mUnzipDirList != null) {
                for (int i2 = 0; i2 < this.mUnzipDirList.size(); i2++) {
                    CategoryInfoData info = this.mUnzipDirList.get(i2);
                    if (info != null) {
                        info.setSelected(false);
                    }
                }
            }
            for (int i3 = 0; i3 < this.mDownloadedDataList.size(); i3++) {
                CategoryInfoData info2 = this.mDownloadedDataList.get(i3);
                if (info2 != null) {
                    info2.setSelected(false);
                }
            }
            changeToDownload();
        }
        setEditMode(isEditable);
        notifyDataSetChanged();
    }

    public void setEditMode(boolean editMode) {
        this.mIsEditMode = editMode;
    }

    public void showOpenTime(boolean showOpenTime) {
        this.mShowOpenTime = showOpenTime;
    }

    /* access modifiers changed from: package-private */
    public void onFileRename(DownloadedFileRenameDispatcher.FileRenameResult result, boolean editMode) {
        if (this.mUnzipDirList != null) {
            int i2 = 0;
            while (true) {
                if (i2 < this.mUnzipDirList.size()) {
                    CategoryInfoData info = this.mUnzipDirList.get(i2);
                    if (info != null && TextUtils.equals(info.mDownloadPath, result.oldFilePath)) {
                        info.mFileName = result.fileName;
                        info.mDownloadPath = result.filePath;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.mDownloadedDataList.size()) {
                CategoryInfoData info2 = this.mDownloadedDataList.get(i3);
                if (info2 != null && info2.mId == result.downloadId) {
                    info2.mFileName = result.fileName;
                    info2.mDownloadPath = result.filePath;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        setEditMode(editMode);
        notifyDataSetChanged();
    }

    public void clearNewFlag() {
        ArrayList<Long> newFileIds = new ArrayList<>();
        for (int i2 = 0; i2 < this.mDownloadedDataList.size(); i2++) {
            CategoryInfoData info = this.mDownloadedDataList.get(i2);
            if (info != null && info.newFlag) {
                newFileIds.add(Long.valueOf(info.mId));
            }
        }
        int size = newFileIds.size();
        if (size >= 1) {
            long[] ret = new long[size];
            for (int i3 = 0; i3 < size; i3++) {
                ret[i3] = newFileIds.get(i3).longValue();
            }
            IDownloadCenterApp.Impl.get().modifyIsRead(AppRuntime.getAppContext(), ret);
        }
    }

    private String formateTime(int time) {
        int hh = time / SECONDS_COUNT_IN_ONE_HOUR;
        int mm = (time % SECONDS_COUNT_IN_ONE_HOUR) / 60;
        int ss = time % 60;
        if (hh != 0) {
            return String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[]{Integer.valueOf(hh), Integer.valueOf(mm), Integer.valueOf(ss)});
        }
        return String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(mm), Integer.valueOf(ss)});
    }

    private class ItemClickListener implements DownloadedSecPageViewHolder.OnItemClickListener {
        private ItemClickListener() {
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:57:0x0171=Splitter:B:57:0x0171, B:75:0x0272=Splitter:B:75:0x0272} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onItemClick(com.baidu.searchbox.download.center.ui.DownloadedSecPageViewHolder r31, com.baidu.searchbox.download.model.CategoryInfoData r32) {
            /*
                r30 = this;
                r1 = r30
                r2 = r31
                r3 = r32
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                boolean r0 = r0.mIsEditMode
                r4 = 1
                r5 = 0
                if (r0 == 0) goto L_0x004b
                boolean r0 = r32.isHasUnZipItem()
                if (r0 == 0) goto L_0x0017
                return
            L_0x0017:
                boolean r0 = r32.isSelected()
                r0 = r0 ^ r4
                r3.setSelected(r0)
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                com.baidu.searchbox.download.center.ui.DownloadedSelectListener r0 = r0.mChangeSelectedListener
                if (r0 == 0) goto L_0x0030
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                com.baidu.searchbox.download.center.ui.DownloadedSelectListener r0 = r0.mChangeSelectedListener
                r0.changeSelected(r3)
            L_0x0030:
                boolean r0 = r32.isSelected()
                if (r0 == 0) goto L_0x0046
                r2.setChecked(r4)
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                long r4 = r0.mCategory
                java.lang.String r0 = "choose"
                com.baidu.download.DownloadStatisticsUBC.doDownloadCenterChildPageUBC((long) r4, (java.lang.String) r0)
                goto L_0x03a7
            L_0x0046:
                r2.setChecked(r5)
                goto L_0x03a7
            L_0x004b:
                boolean r0 = r3.newFlag
                if (r0 == 0) goto L_0x0064
                r3.newFlag = r5
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter$HandleItemsEventsCallback r0 = r0.mItemEventsCallback
                if (r0 == 0) goto L_0x0064
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter$HandleItemsEventsCallback r0 = r0.mItemEventsCallback
                long r6 = r3.mId
                r0.modifyItemNewFlag(r6)
            L_0x0064:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                java.lang.String r6 = r3.mDownloadPath
                boolean r0 = r0.checkFileAvailable(r6)
                r6 = 7
                if (r0 != 0) goto L_0x00ae
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                boolean r0 = r0.isDownloadTypeZip()
                if (r0 == 0) goto L_0x00a8
                long r8 = r3.mType
                int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r0 != 0) goto L_0x00a8
                boolean r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.DEBUG
                if (r0 == 0) goto L_0x00ae
                java.lang.String r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.TAG
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "unzip target: "
                java.lang.StringBuilder r8 = r8.append(r9)
                java.lang.String r9 = r3.mDownloadInfo
                java.lang.StringBuilder r8 = r8.append(r9)
                java.lang.String r9 = " is not exist. It will create when realy extract"
                java.lang.StringBuilder r8 = r8.append(r9)
                java.lang.String r8 = r8.toString()
                android.util.Log.d(r0, r8)
                goto L_0x00ae
            L_0x00a8:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                r0.showRestartDialog(r3)
                return
            L_0x00ae:
                java.lang.String r0 = r3.mFileName
                java.lang.String r8 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r0)
                com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic r0 = com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic.INSTANCE
                r0.classifySecPageItemClick(r3)
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                long r9 = r0.mCategory
                r11 = 0
                int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                r9 = 4
                if (r0 != 0) goto L_0x00d4
                boolean r0 = com.baidu.searchbox.download.util.FileClassifyHelper.isVideoKernelSupport(r8)
                if (r0 == 0) goto L_0x00d4
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                r0.checkVideoKernel(r3)
                goto L_0x0377
            L_0x00d4:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                long r11 = r0.mCategory
                r13 = 6
                int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r0 != 0) goto L_0x00e7
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                r0.onNovelClick(r3)
                goto L_0x0377
            L_0x00e7:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                long r11 = r0.mCategory
                int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r0 != 0) goto L_0x0124
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                android.content.Context r0 = r0.mContext
                java.lang.String r6 = "local_doc"
                boolean r0 = com.baidu.searchbox.download.center.ui.DownloadInfoUtil.openDocFile(r0, r3, r8, r6)
                if (r0 != 0) goto L_0x010f
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                android.content.Context r0 = r0.mContext
                boolean r0 = com.baidu.searchbox.download.center.ui.DownloadInfoUtil.openFileByThirdActivity(r0, r3)
                if (r0 == 0) goto L_0x010d
                goto L_0x010f
            L_0x010d:
                r4 = r5
                goto L_0x0110
            L_0x010f:
            L_0x0110:
                r0 = r4
                if (r0 == 0) goto L_0x0122
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r4 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                android.content.Context r4 = r4.mContext
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r6 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                long r6 = r6.mCategory
                com.baidu.searchbox.download.center.clean.DownloadedDataUtil.updateDownloadedFileOpenTime(r4, r6, r3)
            L_0x0122:
                goto L_0x0377
            L_0x0124:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                long r11 = r0.mCategory
                r13 = 11
                int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r0 != 0) goto L_0x0137
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                r0.onOfflineWebClick(r3)
                goto L_0x0377
            L_0x0137:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                long r11 = r0.mCategory
                r13 = 3
                int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                java.lang.String r11 = "from"
                if (r0 != 0) goto L_0x0279
                java.lang.String r0 = r3.mExtraInfo     // Catch:{ Exception -> 0x0276 }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0276 }
                if (r0 == 0) goto L_0x0176
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0170 }
                java.lang.String r4 = r3.mExtraInfo     // Catch:{ Exception -> 0x0170 }
                r0.<init>(r4)     // Catch:{ Exception -> 0x0170 }
                com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic r4 = com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic.INSTANCE     // Catch:{ Exception -> 0x0170 }
                java.lang.String r4 = r4.getExtFromBySource()     // Catch:{ Exception -> 0x0170 }
                r0.putOpt(r11, r4)     // Catch:{ Exception -> 0x0170 }
                java.lang.String r12 = "file"
                java.lang.String r13 = "open_file"
                java.lang.String r14 = "local_app"
                java.lang.String r15 = "page_click"
                java.lang.String r16 = "app"
                r17 = r0
                com.baidu.download.DownloadStatisticsUBC.openFileStatisticUbc(r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0170 }
                goto L_0x0171
            L_0x0170:
                r0 = move-exception
            L_0x0171:
                r1.checkInstallApk(r3)     // Catch:{ Exception -> 0x0276 }
                goto L_0x0277
            L_0x0176:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0276 }
                java.lang.String r6 = r3.mExtraInfo     // Catch:{ Exception -> 0x0276 }
                r0.<init>(r6)     // Catch:{ Exception -> 0x0276 }
                r6 = r0
                java.lang.String r0 = "package"
                java.lang.String r0 = r6.optString(r0)     // Catch:{ Exception -> 0x0276 }
                r7 = r0
                java.lang.String r0 = "versioncode"
                java.lang.String r0 = r6.optString(r0)     // Catch:{ Exception -> 0x0276 }
                r15 = r0
                boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0276 }
                if (r0 != 0) goto L_0x0250
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this     // Catch:{ Exception -> 0x0276 }
                android.content.Context r0 = r0.mContext     // Catch:{ Exception -> 0x0276 }
                boolean r0 = com.baidu.searchbox.download.util.ApkUtil.hasInstalled(r0, r7, r15)     // Catch:{ Exception -> 0x0276 }
                if (r0 == 0) goto L_0x0250
                long r11 = r3.mSize     // Catch:{ Exception -> 0x0276 }
                double r11 = (double) r11     // Catch:{ Exception -> 0x0276 }
                java.lang.String r0 = com.baidu.searchbox.download.center.ui.DownloadingAdapter.convertByte(r11)     // Catch:{ Exception -> 0x0276 }
                boolean r11 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.DEBUG     // Catch:{ Exception -> 0x0276 }
                if (r11 == 0) goto L_0x01c7
                java.lang.String r11 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.TAG     // Catch:{ Exception -> 0x0276 }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0276 }
                r12.<init>()     // Catch:{ Exception -> 0x0276 }
                java.lang.String r13 = "apkSize ----> "
                java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x0276 }
                java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ Exception -> 0x0276 }
                java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0276 }
                android.util.Log.d(r11, r12)     // Catch:{ Exception -> 0x0276 }
            L_0x01c7:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r11 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this     // Catch:{ Exception -> 0x0276 }
                android.content.Context r11 = r11.mContext     // Catch:{ Exception -> 0x0276 }
                int r12 = com.baidu.searchbox.download.center.R.string.download_clear_install_pk_size     // Catch:{ Exception -> 0x0276 }
                java.lang.String r11 = r11.getString(r12)     // Catch:{ Exception -> 0x0276 }
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0276 }
                r4[r5] = r0     // Catch:{ Exception -> 0x0276 }
                java.lang.String r4 = java.lang.String.format(r11, r4)     // Catch:{ Exception -> 0x0276 }
                com.baidu.android.ext.widget.dialog.BdDialog$Builder r11 = new com.baidu.android.ext.widget.dialog.BdDialog$Builder     // Catch:{ Exception -> 0x0276 }
                r11.<init>()     // Catch:{ Exception -> 0x0276 }
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r12 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this     // Catch:{ Exception -> 0x0276 }
                android.content.Context r12 = r12.mContext     // Catch:{ Exception -> 0x0276 }
                android.content.res.Resources r12 = r12.getResources()     // Catch:{ Exception -> 0x0276 }
                int r13 = com.baidu.searchbox.download.center.R.string.download_clear_install_pk_title     // Catch:{ Exception -> 0x0276 }
                java.lang.String r12 = r12.getString(r13)     // Catch:{ Exception -> 0x0276 }
                com.baidu.android.ext.widget.dialog.BdDialog$Builder r11 = r11.setTitle((java.lang.String) r12)     // Catch:{ Exception -> 0x0276 }
                com.baidu.android.ext.widget.dialog.BdDialog$Builder r11 = r11.setMessage((java.lang.String) r4)     // Catch:{ Exception -> 0x0276 }
                com.baidu.android.ext.widget.dialog.BdDialog$BottomItem r12 = new com.baidu.android.ext.widget.dialog.BdDialog$BottomItem     // Catch:{ Exception -> 0x0276 }
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r13 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this     // Catch:{ Exception -> 0x0276 }
                android.content.Context r13 = r13.mContext     // Catch:{ Exception -> 0x0276 }
                android.content.res.Resources r13 = r13.getResources()     // Catch:{ Exception -> 0x0276 }
                int r14 = com.baidu.searchbox.download.center.R.string.download_clear_install_pk_cancel     // Catch:{ Exception -> 0x0276 }
                java.lang.String r13 = r13.getString(r14)     // Catch:{ Exception -> 0x0276 }
                int r14 = com.baidu.android.common.ui.style.R.color.GC1     // Catch:{ Exception -> 0x0276 }
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter$ItemClickListener$2 r5 = new com.baidu.searchbox.download.center.ui.DownloadedListAdapter$ItemClickListener$2     // Catch:{ Exception -> 0x0276 }
                r5.<init>(r3)     // Catch:{ Exception -> 0x0276 }
                r12.<init>((java.lang.CharSequence) r13, (int) r14, (com.baidu.android.ext.widget.dialog.BdDialog.OnItemClickListener) r5)     // Catch:{ Exception -> 0x0276 }
                com.baidu.android.ext.widget.dialog.BdDialog$Builder r5 = r11.setButton(r12)     // Catch:{ Exception -> 0x0276 }
                com.baidu.android.ext.widget.dialog.BdDialog$BottomItem r11 = new com.baidu.android.ext.widget.dialog.BdDialog$BottomItem     // Catch:{ Exception -> 0x0276 }
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r12 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this     // Catch:{ Exception -> 0x0276 }
                android.content.Context r12 = r12.mContext     // Catch:{ Exception -> 0x0276 }
                android.content.res.Resources r12 = r12.getResources()     // Catch:{ Exception -> 0x0276 }
                int r13 = com.baidu.searchbox.download.center.R.string.download_clear_install_pk_confirm     // Catch:{ Exception -> 0x0276 }
                java.lang.String r12 = r12.getString(r13)     // Catch:{ Exception -> 0x0276 }
                int r13 = com.baidu.android.common.ui.style.R.color.GC7     // Catch:{ Exception -> 0x0276 }
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter$ItemClickListener$1 r14 = new com.baidu.searchbox.download.center.ui.DownloadedListAdapter$ItemClickListener$1     // Catch:{ Exception -> 0x0276 }
                r14.<init>(r3)     // Catch:{ Exception -> 0x0276 }
                r11.<init>((java.lang.CharSequence) r12, (int) r13, (com.baidu.android.ext.widget.dialog.BdDialog.OnItemClickListener) r14)     // Catch:{ Exception -> 0x0276 }
                com.baidu.android.ext.widget.dialog.BdDialog$Builder r5 = r5.setButton(r11)     // Catch:{ Exception -> 0x0276 }
                r5.show()     // Catch:{ Exception -> 0x0276 }
                java.lang.String r18 = "valid"
                java.lang.String r19 = "show"
                java.lang.String r20 = "installment"
                java.lang.String r21 = ""
                java.lang.String r22 = ""
                long r11 = r3.mSize     // Catch:{ Exception -> 0x0276 }
                r23 = r11
                com.baidu.searchbox.statistics.DownloadWindownUBC.invokeDownload(r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0276 }
                goto L_0x0277
            L_0x0250:
                com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic r0 = com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic.INSTANCE     // Catch:{ Exception -> 0x0270 }
                java.lang.String r0 = r0.getExtFromBySource()     // Catch:{ Exception -> 0x0270 }
                r6.putOpt(r11, r0)     // Catch:{ Exception -> 0x0270 }
                java.lang.String r12 = "file"
                java.lang.String r13 = "open_file"
                java.lang.String r14 = "local_app"
                java.lang.String r0 = "page_click"
                java.lang.String r16 = "app"
                r4 = r15
                r15 = r0
                r17 = r6
                com.baidu.download.DownloadStatisticsUBC.openFileStatisticUbc(r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x026e }
                goto L_0x0272
            L_0x026e:
                r0 = move-exception
                goto L_0x0272
            L_0x0270:
                r0 = move-exception
                r4 = r15
            L_0x0272:
                r1.checkInstallApk(r3)     // Catch:{ Exception -> 0x0276 }
                goto L_0x0277
            L_0x0276:
                r0 = move-exception
            L_0x0277:
                goto L_0x0377
            L_0x0279:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                boolean r0 = r0.isDownloadTypeZip()
                if (r0 == 0) goto L_0x0319
                long r4 = r3.mType
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 != 0) goto L_0x02d0
                com.baidu.searchbox.download.center.unzip.DownloadUnzipActivity$Companion r0 = com.baidu.searchbox.download.center.unzip.DownloadUnzipActivity.Companion
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r4 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                android.content.Context r4 = r4.mContext
                android.app.Activity r4 = (android.app.Activity) r4
                com.baidu.searchbox.download.center.unzip.DownloadUnzipModel r5 = new com.baidu.searchbox.download.center.unzip.DownloadUnzipModel
                java.lang.String r6 = r3.mFileName
                java.lang.String r7 = r3.mDownloadPath
                com.baidu.searchbox.download.center.unzip.DownloadUnzipConstants r11 = com.baidu.searchbox.download.center.unzip.DownloadUnzipConstants.INSTANCE
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r12 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                android.content.Context r12 = r12.mContext
                java.util.List r21 = r11.getUnzipScanDirs(r12)
                r22 = 0
                r23 = 0
                boolean r25 = r32.isHasUnZipItem()
                r26 = 0
                r27 = 0
                boolean r28 = r32.isHasUnZipItem()
                r29 = 1
                java.lang.String r24 = "file"
                r18 = r5
                r19 = r6
                r20 = r7
                r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
                r0.startUnzipActivity(r4, r5)
                boolean r0 = r32.isHasUnZipItem()
                if (r0 == 0) goto L_0x0377
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                r0.ubcClickUnZipDir()
                goto L_0x0377
            L_0x02d0:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x02f2 }
                r0.<init>()     // Catch:{ Exception -> 0x02f2 }
                com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic r4 = com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic.INSTANCE     // Catch:{ Exception -> 0x02f2 }
                java.lang.String r4 = r4.getExtFromBySource()     // Catch:{ Exception -> 0x02f2 }
                r0.putOpt(r11, r4)     // Catch:{ Exception -> 0x02f2 }
                java.lang.String r12 = "file"
                java.lang.String r13 = "open_file"
                java.lang.String r14 = "local_zip"
                java.lang.String r15 = "page_click"
                java.lang.String r16 = "zip"
                r17 = r0
                com.baidu.download.DownloadStatisticsUBC.openFileStatisticUbc(r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x02f2 }
                goto L_0x02fc
            L_0x02f2:
                r0 = move-exception
                boolean r4 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.DEBUG
                if (r4 == 0) goto L_0x02fc
                r0.printStackTrace()
            L_0x02fc:
                com.baidu.searchbox.download.center.unzip.DownloadUnzipConstants r0 = com.baidu.searchbox.download.center.unzip.DownloadUnzipConstants.INSTANCE
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r4 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                android.content.Context r4 = r4.mContext
                boolean r0 = r0.isUsingExternalPubDir(r4)
                if (r0 == 0) goto L_0x0313
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter$ItemClickListener$3 r0 = new com.baidu.searchbox.download.center.ui.DownloadedListAdapter$ItemClickListener$3
                r0.<init>(r3)
                com.baidu.download.DownloadPermissionHelper.checkHasStorageWritePermissionAndRequest(r0)
                goto L_0x0377
            L_0x0313:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                r0.tryToCompressArchive(r3)
                goto L_0x0377
            L_0x0319:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                long r4 = r0.mCategory
                r6 = 1
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 != 0) goto L_0x0360
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0347 }
                r0.<init>()     // Catch:{ Exception -> 0x0347 }
                com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic r4 = com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic.INSTANCE     // Catch:{ Exception -> 0x0347 }
                java.lang.String r4 = r4.getExtFromBySource()     // Catch:{ Exception -> 0x0347 }
                r0.putOpt(r11, r4)     // Catch:{ Exception -> 0x0347 }
                java.lang.String r12 = "file"
                java.lang.String r13 = "open_file"
                java.lang.String r14 = "local_music"
                java.lang.String r15 = "page_click"
                java.lang.String r16 = "music"
                r17 = r0
                com.baidu.download.DownloadStatisticsUBC.openFileStatisticUbc(r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0347 }
                goto L_0x0348
            L_0x0347:
                r0 = move-exception
            L_0x0348:
                com.baidu.searchbox.download.center.guideclear.GuideClearUtil r0 = com.baidu.searchbox.download.center.guideclear.GuideClearUtil.INSTANCE
                boolean r0 = r0.isAssignInstallPackage((com.baidu.searchbox.download.model.CategoryInfoData) r3)
                if (r0 == 0) goto L_0x0356
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                r0.guideClearOtherInstallPackage(r3)
                goto L_0x0377
            L_0x0356:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                android.content.Context r0 = r0.mContext
                com.baidu.searchbox.download.center.ui.DownloadInfoUtil.openFileByThirdActivity(r0, r3)
                goto L_0x0377
            L_0x0360:
                com.baidu.searchbox.download.center.guideclear.GuideClearUtil r0 = com.baidu.searchbox.download.center.guideclear.GuideClearUtil.INSTANCE
                boolean r0 = r0.isAssignInstallPackage((com.baidu.searchbox.download.model.CategoryInfoData) r3)
                if (r0 == 0) goto L_0x036e
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                r0.guideClearOtherInstallPackage(r3)
                goto L_0x0377
            L_0x036e:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                android.content.Context r0 = r0.mContext
                com.baidu.searchbox.download.center.ui.DownloadInfoUtil.openFileByThirdActivity(r0, r3)
            L_0x0377:
                com.baidu.searchbox.download.center.ui.DownloadedListAdapter r0 = com.baidu.searchbox.download.center.ui.DownloadedListAdapter.this
                long r4 = r0.mCategory
                int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r0 == 0) goto L_0x03a1
                com.baidu.searchbox.download.statistics.DownloadActionModel r0 = new com.baidu.searchbox.download.statistics.DownloadActionModel
                r0.<init>()
                long r4 = r3.mId
                r0.downloadId = r4
                java.lang.String r4 = r3.mFileName
                r0.fileName = r4
                java.lang.String r4 = r3.mMimeType
                r0.mimeType = r4
                java.lang.String r4 = r3.mExtraInfo
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 == 0) goto L_0x039d
                java.lang.String r4 = ""
                goto L_0x039f
            L_0x039d:
                java.lang.String r4 = r3.mExtraInfo
            L_0x039f:
                r0.extraInfo = r4
            L_0x03a1:
                com.baidu.searchbox.download.center.ui.fusion.util.FileManagerRecentDataControlUtil r0 = com.baidu.searchbox.download.center.ui.fusion.util.FileManagerRecentDataControlUtil.INSTANCE
                r4 = 0
                r0.updateOpenTime(r3, r4)
            L_0x03a7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.ui.DownloadedListAdapter.ItemClickListener.onItemClick(com.baidu.searchbox.download.center.ui.DownloadedSecPageViewHolder, com.baidu.searchbox.download.model.CategoryInfoData):void");
        }

        private void checkInstallApk(final CategoryInfoData categoryInfoData) {
            if (categoryInfoData != null) {
                if (DownloadedListAdapter.this.mContext instanceof Activity) {
                    ApkCheckerKt.checkApk((Activity) DownloadedListAdapter.this.mContext, categoryInfoData, true, new Function1<Boolean, Unit>() {
                        public Unit invoke(Boolean canInstall) {
                            if (!canInstall.booleanValue()) {
                                return null;
                            }
                            try {
                                JSONObject extraJsonObject = new JSONObject(categoryInfoData.mExtraInfo);
                                extraJsonObject.putOpt("from", DownloadCenterStatistic.INSTANCE.getExtFromBySource());
                                DownloadStatisticsUBC.openFileStatisticUbc("file", DownloadStatisticConstants.UBC_TYPE_START_INSTALL, DownloadStatisticConstants.UBC_PAGE_LOCAL_APP, "page_click", "app", extraJsonObject);
                            } catch (Exception e2) {
                            }
                            ApkUtil.installApk(categoryInfoData.mDownloadPath);
                            DownloadedListAdapter.this.doInstallStatisticsClick();
                            return null;
                        }
                    });
                    return;
                }
                ApkUtil.installApk(categoryInfoData.mDownloadPath);
                DownloadedListAdapter.this.doInstallStatisticsClick();
            }
        }

        public boolean onItemLongClick(DownloadedSecPageViewHolder viewHolder, CategoryInfoData categoryInfoData) {
            if (DownloadedListAdapter.this.mIsEditMode || categoryInfoData.isHasUnZipItem()) {
                return false;
            }
            boolean unused = DownloadedListAdapter.this.mIsEditMode = true;
            categoryInfoData.setSelected(true);
            if (DownloadedListAdapter.this.mChangeSelectedListener != null) {
                DownloadedListAdapter.this.mChangeSelectedListener.changeMode(DownloadedListAdapter.this.mIsEditMode);
                DownloadedListAdapter.this.mChangeSelectedListener.changeSelected(categoryInfoData);
            }
            DownloadedListAdapter.this.notifyDataSetChanged();
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void tryToCompressArchive(final CategoryInfoData categoryInfoData) {
        boolean ret;
        try {
            ret = UnzipUtilsKt.doDecompress(categoryInfoData.mDownloadPath, DownloadUnzipConstants.INSTANCE.getUnzipRootDir(this.mContext).getAbsolutePath(), new DownloadUnzipProgressListener(new Handler(), (BaseActivity) this.mContext, true, true, "file", new DownloadUnzipProgressListener.IUnzipFailListener() {
                public void onUnzipFail() {
                    DownloadInfoUtil.openFileByThirdActivity(DownloadedListAdapter.this.mContext, categoryInfoData);
                }
            }));
            DownloadUnzipUbc.INSTANCE.ubcWithDefaultParams("file", DownloadCenterConstants.UBC_SOURCE_DECOMPRESS, (String) null);
        } catch (BdArchiveException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            UniversalToast.makeText(this.mContext, R.string.download_unzip_error_common).showToast();
            DownloadInfoUtil.openFileByThirdActivity(this.mContext, categoryInfoData);
            ret = true;
        }
        if (!ret) {
            DownloadInfoUtil.openFileByThirdActivity(this.mContext, categoryInfoData);
        }
    }

    private void ubcShowUnZipDir() {
        if (this.mUnzipDirList != null) {
            DownloadUnzipUbc.INSTANCE.ubc(DownloadStatisticConstants.UBC_UNZIP_HAS_UNZIP_ID, "", "", "", "", "show", "" + this.mUnzipDirList.size());
        }
    }

    /* access modifiers changed from: private */
    public void ubcClickUnZipDir() {
        if (this.mUnzipDirList != null) {
            DownloadUnzipUbc.INSTANCE.ubc(DownloadStatisticConstants.UBC_UNZIP_HAS_UNZIP_ID, "", "", "", "", "click", "" + this.mUnzipDirList.size());
        }
    }

    /* access modifiers changed from: private */
    public void doInstallStatisticsClick() {
        DownloadStatisticsUBC.doDownloadCenterChildPageUBC(this.mCategory, DownloadStatisticConstants.UBC_VALUE_APP_INSTALL);
    }

    /* access modifiers changed from: private */
    public void onNovelClick(CategoryInfoData categoryInfoData) {
        this.mItemEventsCallback.setOpendDocFlag();
        IDownloadCenterApp.Impl.get().openNovel((Activity) this.mContext, categoryInfoData);
    }

    /* access modifiers changed from: private */
    public void onOfflineWebClick(CategoryInfoData categoryInfoData) {
        IDownloadCenterApp.Impl.get().loadUrl(this.mContext, "file://" + categoryInfoData.mDownloadPath, false, true);
    }

    /* access modifiers changed from: private */
    public boolean checkFileAvailable(String path) {
        try {
            if (new File(path).exists()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            if (!DEBUG) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void showRestartDialog(final CategoryInfoData categoryInfoData) {
        BoxAlertDialog.Builder dialogBuilder = new BoxAlertDialog.Builder(this.mContext).setTitle(R.string.download_video_continue_title).setNegativeButton(com.baidu.android.common.ui.style.R.string.delete_all, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (DownloadedListAdapter.this.mItemEventsCallback != null) {
                    DownloadedListAdapter.this.mItemEventsCallback.deleteItem(categoryInfoData);
                }
            }
        });
        if (RedownloadFilter.redownloadFilter((int) this.mCategory)) {
            dialogBuilder.setPositiveButton(R.string.download_cancel, (DialogInterface.OnClickListener) null);
        } else {
            dialogBuilder.setPositiveButton(R.string.download_restart, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (DownloadedListAdapter.this.mItemEventsCallback != null) {
                        DownloadedListAdapter.this.mItemEventsCallback.restartItems(categoryInfoData);
                    }
                }
            });
        }
        dialogBuilder.setMessage(R.string.download_file_unavailable);
        dialogBuilder.show(true);
    }

    /* access modifiers changed from: private */
    public void checkVideoKernel(CategoryInfoData categoryInfoData) {
        String path = categoryInfoData.mDownloadPath;
        if (!TextUtils.isEmpty(path)) {
            IDownloadCenterApp.Impl.get().startPlay(this.mContext, "file://" + path, categoryInfoData.mFileName);
        }
    }

    public void setChangeModeListener(DownloadedSelectListener listener) {
        this.mChangeSelectedListener = listener;
    }

    public void setHandleItemsEventsCallback(HandleItemsEventsCallback callback) {
        this.mItemEventsCallback = callback;
    }

    public void deleteData(long... ids) {
        DownloadManagerExt.getInstance().deleteDownloadFile(ids);
    }

    public void addItem(List<CategoryInfoData> list) {
        this.mDownloadedDataList.addAll(list);
        notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public void guideClearOtherInstallPackage(final CategoryInfoData data) {
        String apkSize = DownloadingAdapter.convertByte((double) data.mSize);
        if (DEBUG) {
            Log.d("DownloadingItem", "apkSize ----> " + apkSize);
        }
        String apkMessage = String.format(this.mContext.getString(R.string.download_clear_unable_install_pk_size), new Object[]{apkSize});
        View view2 = LayoutInflater.from(this.mContext).inflate(R.layout.download_unable_install_title_layoout, (ViewGroup) null);
        if (view2 != null) {
            TextView downLoadClearApkMsg = (TextView) view2.findViewById(R.id.download_clear_apk_msg);
            downLoadClearApkMsg.setText(apkMessage);
            downLoadClearApkMsg.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
            new BdDialog.Builder().setView(view2).setButton(new BdDialog.BottomItem((CharSequence) this.mContext.getResources().getString(R.string.download_clear_install_pk_now), com.baidu.android.common.ui.style.R.color.GC7, (BdDialog.OnItemClickListener) new BdDialog.OnItemClickListener() {
                public void onItemClick(View view2) {
                    if (DownloadedListAdapter.this.mItemEventsCallback != null) {
                        DownloadedListAdapter.this.mItemEventsCallback.deleteItem(data);
                    }
                    DownloadWindownUBC.invokeDownload("invalid", "click", "others", "confirm", "", data.mSize);
                }
            })).setButton(new BdDialog.BottomItem((CharSequence) this.mContext.getResources().getString(R.string.download_install_by_other_application), com.baidu.android.common.ui.style.R.color.GC1, (BdDialog.OnItemClickListener) new BdDialog.OnItemClickListener() {
                public void onItemClick(View view2) {
                    DownloadInfoUtil.openFileByThirdActivity(DownloadedListAdapter.this.mContext, data);
                    DownloadWindownUBC.invokeDownload("invalid", "click", "others", DownloadWinStaConstants.ANOTHER, "", data.mSize);
                }
            })).setButton(new BdDialog.BottomItem((CharSequence) this.mContext.getResources().getString(R.string.download_clear_install_pk_cancel), com.baidu.android.common.ui.style.R.color.GC1, (BdDialog.OnItemClickListener) new BdDialog.OnItemClickListener() {
                public void onItemClick(View view2) {
                    DownloadWindownUBC.invokeDownload("invalid", "click", "others", "cancel", "", data.mSize);
                }
            })).show();
            DownloadWindownUBC.invokeDownload("invalid", "show", "others", "", "", data.mSize);
        }
    }

    private final class SpecialItemCreatedFactory {
        private SpecialItemCreatedFactory() {
        }

        /* access modifiers changed from: private */
        public CategoryInfoData getHasUnZipInfo() {
            CategoryInfoData unZipInfo = new CategoryInfoData();
            unZipInfo.mId = -1;
            unZipInfo.mType = 7;
            unZipInfo.mFileName = DownloadedListAdapter.this.mContext.getString(R.string.download_unzip_has_unzip);
            unZipInfo.mDownloadPath = DownloadUnzipConstants.INSTANCE.getUnzipRootDir(DownloadedListAdapter.this.mContext).getAbsolutePath();
            unZipInfo.mSubTitle = DownloadedListAdapter.this.mUnzipDirList.size() + DownloadedListAdapter.this.mContext.getString(R.string.download_unzip_dir_file_content_suffix);
            return unZipInfo;
        }
    }
}
