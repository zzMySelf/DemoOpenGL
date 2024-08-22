package com.baidu.searchbox.fileviewer.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.appframework.ActionToolBarActivity;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.fileviewer.data.BdFileItemData;
import com.baidu.searchbox.fileviewer.dialog.BdPopupDialogView;
import com.baidu.searchbox.fileviewer.eventbus.Action;
import com.baidu.searchbox.fileviewer.manager.BdFileViewerManager;
import com.baidu.searchbox.fileviewer.pop.BdPManager;
import com.baidu.searchbox.fileviewer.utils.BdFileViewerUtils;
import com.baidu.searchbox.fileviewer.utils.DownloadChangePathUBC;
import com.baidu.searchbox.fileviewer.view.BdFileViewerTitleView;
import com.baidu.searchbox.fileviewer.view.BdFileViewerView;
import com.baidu.searchbox.permission.DangerousPermissionManager;
import com.baidu.searchbox.permission.DangerousPermissionUtils;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.searchbox.unifiedtoolbar.statistic.StatisticHelperKt;
import com.baidu.searchbox.unifiedtoolbar.templates.UnifiedBottomBar;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileViewerActivity extends ActionToolBarActivity {
    public static final String BACK_SLASH = "/";
    public static final int BOTTOM_HEIGHT_DP = 42;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String DEFAULT_DL_SUBDIR_NAME = "downloads";
    public static final String DELETE_FILE = "deleteFileInFileViewerActivity";
    public static final float FILE_VIEW_WEIGHT = 1.0f;
    public static final String KEY_DOWNLOADCENTER_PATH = "downloadcenter_path";
    public static final int KEY_DOWNLOAD_MAKEDIR_CODE = 999;
    public static final String KEY_DOWNLOAD_PATH_ISSCAN_DIRECTORY = "download_path_isscan_directory";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final String TAG = "DownloadHelper";
    public static final String VIEWER_PASS_CHANGE_PATH_FOREVER = "viewer_pass_change_path_forever";
    public static final String VIEWER_PASS_CHANGE_PATH_TITLE = "viewer_pass_change_path_title";
    public static final String VIEWER_PASS_FILE_PATH = "viewer_pass_file_path";
    public static final String VIEWER_PASS_FILE_PATH_RETURN = "viewer_pass_file_path_return";
    public static final String VIEWER_PASS_ONLY_READ = "viewer_pass_only_read";
    /* access modifiers changed from: private */
    public Object deleteLock = new Object();
    /* access modifiers changed from: private */
    public BdFileViewerView mBdFileViewerView;
    private View mBottomView;
    /* access modifiers changed from: private */
    public boolean mChangePathForever;
    /* access modifiers changed from: private */
    public TextView mDeleteTextView;
    private TextView mDetailTextView;
    private View mDivider;
    private String mFilePath;
    /* access modifiers changed from: private */
    public boolean mIsAllSelected = false;
    /* access modifiers changed from: private */
    public boolean mIsEdit;
    private boolean mIsScanDirectory;
    /* access modifiers changed from: private */
    public BdFileViewerManager mManager;
    private boolean mOnlyRead;
    private TextView mRenameTextView;
    DangerousPermissionManager.RequestSystemPermissionCallBack mRequestSystemPermissionCallBack;
    /* access modifiers changed from: private */
    public List<BdFileItemData> mSelectedItems = Collections.synchronizedList(new ArrayList());

    public enum BottomViewStatus {
        SHOW_ALL,
        SHOW_DELETE,
        SHOW_NONE
    }

    public enum BottomViewVisibleStatus {
        SHOW_BACK,
        SHOW_EDIT
    }

    public static void launchSelf(Activity activity, boolean onlyRead, String filePath, String title, boolean isScanDirectory, boolean isChangeForEvery, int requestCode) {
        if (activity != null) {
            if (TextUtils.isEmpty(filePath)) {
                filePath = BdFileViewerUtils.getInnerSDCardRoot();
            }
            if (!TextUtils.isEmpty(filePath)) {
                Intent intent = new Intent(activity, FileViewerActivity.class);
                intent.putExtra(VIEWER_PASS_ONLY_READ, onlyRead);
                intent.putExtra(VIEWER_PASS_FILE_PATH, filePath);
                intent.putExtra(VIEWER_PASS_CHANGE_PATH_FOREVER, isChangeForEvery);
                if (!TextUtils.isEmpty(title)) {
                    intent.putExtra(VIEWER_PASS_CHANGE_PATH_TITLE, title);
                }
                intent.putExtra(KEY_DOWNLOAD_PATH_ISSCAN_DIRECTORY, isScanDirectory);
                activity.startActivityForResult(intent, requestCode);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        setPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        setEnableSliding(true);
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        super.onCreate(savedInstanceState);
        if (!SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            getWindow().setBackgroundDrawableResource(R.color.account_background_color);
            Intent intent = getIntent();
            this.mOnlyRead = intent.getBooleanExtra(VIEWER_PASS_ONLY_READ, false);
            this.mChangePathForever = intent.getBooleanExtra(VIEWER_PASS_CHANGE_PATH_FOREVER, false);
            this.mIsScanDirectory = intent.getBooleanExtra(KEY_DOWNLOAD_PATH_ISSCAN_DIRECTORY, false);
            String stringExtra = intent.getStringExtra(VIEWER_PASS_FILE_PATH);
            this.mFilePath = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.mFilePath = BdFileViewerUtils.getInnerSDCardRoot();
            }
            if (TextUtils.isEmpty(this.mFilePath)) {
                UniversalToast.makeText(getApplicationContext(), (CharSequence) getString(com.baidu.searchbox.fileviewer.R.string.fileviewer_inner_sdcard_check_fail)).showToast();
                finish();
                return;
            }
            BdPManager.getInstance().setActivity(this);
            BdFileViewerManager bdFileViewerManager = new BdFileViewerManager(this);
            this.mManager = bdFileViewerManager;
            BdFileViewerView view2 = bdFileViewerManager.getView();
            this.mBdFileViewerView = view2;
            view2.setScanDirectory(this.mIsScanDirectory);
            this.mBdFileViewerView.setState(this.mOnlyRead);
            if (!TextUtils.isEmpty(intent.getStringExtra(VIEWER_PASS_CHANGE_PATH_TITLE)) && this.mBdFileViewerView.getTitleLayout() != null) {
                this.mBdFileViewerView.getTitleLayout().getTitleTextView().setText(intent.getStringExtra(VIEWER_PASS_CHANGE_PATH_TITLE));
            }
            if (isAllowedPath(this.mFilePath)) {
                scanFolder();
            } else {
                checkPermisson();
            }
            setContentView(addLayout(this.mBdFileViewerView));
            if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
                UnifiedTopBarButton topBackButton = getUnifiedTopBackButton();
                if (topBackButton != null) {
                    HashMap<String, String> extMap = new HashMap<>();
                    extMap.put(UnifiedTopBarButton.UBC_EXT_KEY_SECOND_PAGE, this.mOnlyRead ? DownloadChangePathUBC.SECOND_PAGE_READ_ONLY : DownloadChangePathUBC.SECOND_PAGE_WRITABLE);
                    topBackButton.ubcBackButtonShow("base", "file", extMap);
                    return;
                }
                return;
            }
            bottomBarShowStatistic();
        }
    }

    private void scanFolder() {
        this.mManager.scanFolder(this.mFilePath, this.mIsScanDirectory);
    }

    private void checkPermisson() {
        if (!DangerousPermissionUtils.isPermissionGroupGranted(this, BdFileViewerView.PERMISSIONS_STORAGE)) {
            this.mRequestSystemPermissionCallBack = DangerousPermissionUtils.showPermissionInstrumentWindow("basic", this, BdFileViewerView.PERMISSIONS_STORAGE);
            ActivityCompat.requestPermissions(this, BdFileViewerView.PERMISSIONS_STORAGE, 102);
            return;
        }
        scanFolder();
    }

    private void initEventBusAction() {
        initListItemClickAction();
        initListItemLongClickAction();
        initTitleBarCancelAction();
        initTitleBarChooseAllAction();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
            if (this.mOnlyRead) {
                initDownloadFilePathAction();
            } else {
                initEventBusAction();
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void initDownloadFilePathAction() {
        BdEventBus.Companion.getDefault().lazyRegister(this, Action.ChoosePath.class, 1, new com.baidu.searchbox.bdeventbus.Action<Action.ChoosePath>() {
            public void call(Action.ChoosePath choosePath) {
                Intent intent = new Intent();
                if (FileViewerActivity.this.mManager == null) {
                    FileViewerActivity.this.setResult(404, intent);
                    FileViewerActivity.this.finish();
                    return;
                }
                List<String> p = FileViewerActivity.this.mManager.getPathList();
                if (p == null || p.size() < 1) {
                    FileViewerActivity.this.setResult(404, intent);
                    FileViewerActivity.this.finish();
                    return;
                }
                String path = p.get(p.size() - 1);
                if (FileViewerActivity.this.mChangePathForever) {
                    PreferenceUtils.setString("downloadcenter_path", path);
                }
                intent.putExtra(FileViewerActivity.VIEWER_PASS_FILE_PATH_RETURN, path);
                FileViewerActivity.this.setResult(200, intent);
                FileViewerActivity.this.finish();
            }
        });
    }

    private void initTitleBarChooseAllAction() {
        BdEventBus.Companion.getDefault().lazyRegister(this, Action.BdFileListSelectAll.class, 1, new com.baidu.searchbox.bdeventbus.Action<Action.BdFileListSelectAll>() {
            public void call(Action.BdFileListSelectAll bdFileListSelectAll) {
                if (bdFileListSelectAll != null && bdFileListSelectAll.mSelectedItem != null) {
                    if (bdFileListSelectAll.mSelectedItem.size() <= 0) {
                        boolean unused = FileViewerActivity.this.mIsAllSelected = false;
                        FileViewerActivity.this.mSelectedItems.clear();
                        FileViewerActivity.this.updateBottomTextViewStatus(BottomViewStatus.SHOW_NONE);
                    } else {
                        boolean unused2 = FileViewerActivity.this.mIsAllSelected = true;
                        List unused3 = FileViewerActivity.this.mSelectedItems = bdFileListSelectAll.mSelectedItem;
                        FileViewerActivity.this.updateBottomTextViewStatus(BottomViewStatus.SHOW_DELETE);
                    }
                    FileViewerActivity.this.updateDeleteNum();
                }
            }
        });
    }

    private void initTitleBarCancelAction() {
        BdEventBus.Companion.getDefault().lazyRegister(this, Action.BdFileTitlelViewCancelClick.class, 1, new com.baidu.searchbox.bdeventbus.Action<Action.BdFileTitlelViewCancelClick>() {
            public void call(Action.BdFileTitlelViewCancelClick bdFileTitlelViewCancelClick) {
                FileViewerActivity.this.showNormalStatus();
            }
        });
    }

    private void initListItemLongClickAction() {
        BdEventBus.Companion.getDefault().lazyRegister(this, Action.BdFileListItemLongClick.class, 1, new com.baidu.searchbox.bdeventbus.Action<Action.BdFileListItemLongClick>() {
            public void call(Action.BdFileListItemLongClick bdFileListItemLongClick) {
                boolean unused = FileViewerActivity.this.mIsAllSelected = bdFileListItemLongClick.mListSize == 1;
                boolean unused2 = FileViewerActivity.this.mIsEdit = true;
                FileViewerActivity.this.updateTitleBar(bdFileListItemLongClick.mFileTitleType);
                FileViewerActivity.this.mSelectedItems.clear();
                FileViewerActivity.this.mSelectedItems.add(bdFileListItemLongClick.mBdFileItemData);
                FileViewerActivity.this.updateBottomItemVisibleStatus(BottomViewVisibleStatus.SHOW_EDIT);
                FileViewerActivity.this.updateBottomTextViewStatus(BottomViewStatus.SHOW_ALL);
                FileViewerActivity.this.mBdFileViewerView.setTitleSelectStatus(FileViewerActivity.this.mIsAllSelected);
                FileViewerActivity.this.updateDeleteNum();
            }
        });
    }

    private void initListItemClickAction() {
        BdEventBus.Companion.getDefault().lazyRegister(this, Action.BdFileListItemClick.class, 1, new com.baidu.searchbox.bdeventbus.Action<Action.BdFileListItemClick>() {
            public void call(Action.BdFileListItemClick bdFileListItemClick) {
                if (bdFileListItemClick.mDoSelect) {
                    FileViewerActivity.this.mSelectedItems.add(bdFileListItemClick.mBdFileItemData);
                } else {
                    FileViewerActivity.this.mSelectedItems.remove(bdFileListItemClick.mBdFileItemData);
                }
                int size = FileViewerActivity.this.mSelectedItems.size();
                if (size == 1) {
                    FileViewerActivity.this.updateBottomTextViewStatus(BottomViewStatus.SHOW_ALL);
                } else if (size <= 0) {
                    FileViewerActivity.this.updateBottomTextViewStatus(BottomViewStatus.SHOW_NONE);
                    FileViewerActivity.this.mBdFileViewerView.setTitleSelectStatus(false);
                } else {
                    FileViewerActivity.this.updateBottomTextViewStatus(BottomViewStatus.SHOW_DELETE);
                }
                boolean unused = FileViewerActivity.this.mIsAllSelected = bdFileListItemClick.mListSize == size;
                if (bdFileListItemClick.mListSize > 0 && FileViewerActivity.this.mIsAllSelected) {
                    FileViewerActivity.this.mBdFileViewerView.setTitleSelectStatus(true);
                } else if (bdFileListItemClick.mListSize > 0 && size < bdFileListItemClick.mListSize) {
                    FileViewerActivity.this.mBdFileViewerView.setTitleSelectStatus(false);
                }
                FileViewerActivity.this.updateDeleteNum();
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateDeleteNum() {
        runOnUiThread(new Runnable() {
            public void run() {
                String str = FileViewerActivity.this.getString(com.baidu.searchbox.fileviewer.R.string.fileviewer_file_delete);
                if (FileViewerActivity.this.mSelectedItems.size() == 0) {
                    FileViewerActivity.this.mDeleteTextView.setText(str);
                } else {
                    FileViewerActivity.this.mDeleteTextView.setText(str + FileViewerActivity.LEFT_BRACKET + FileViewerActivity.this.mSelectedItems.size() + ")");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateTitleBar(BdFileViewerTitleView.FileTitleType fileTitleType) {
        this.mBdFileViewerView.setTitleLayoutStatus(fileTitleType);
    }

    /* access modifiers changed from: private */
    public void updateToNormalListStatus() {
        this.mBdFileViewerView.updateToNomalListStatus();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BdPManager.getInstance().onDestroy();
        BdFileViewerManager bdFileViewerManager = this.mManager;
        if (bdFileViewerManager != null) {
            bdFileViewerManager.onDestroy();
            this.mManager = null;
        }
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void onBackPressed() {
        int size;
        if (this.mOnlyRead) {
            super.onBackPressed();
        } else if (this.mIsEdit) {
            showNormalStatus();
        } else {
            BdFileViewerManager bdFileViewerManager = this.mManager;
            if (bdFileViewerManager == null || (size = bdFileViewerManager.getPathList().size()) < 2) {
                super.onBackPressed();
                return;
            }
            BdFileViewerManager bdFileViewerManager2 = this.mManager;
            bdFileViewerManager2.scanFolder(bdFileViewerManager2.getPathList().get(size - 2), false);
        }
    }

    private View addLayout(View contentView) {
        LinearLayout contentLayout = new LinearLayout(this);
        contentLayout.setOrientation(1);
        LinearLayout.LayoutParams lvp = new LinearLayout.LayoutParams(-1, -1);
        lvp.weight = 1.0f;
        contentLayout.addView(contentView, lvp);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, DeviceUtil.ScreenInfo.dp2px(this, 42.0f));
        lp.gravity = 80;
        View child = initBottomView();
        if (child != null) {
            contentLayout.addView(child, lp);
        }
        contentLayout.setBackgroundColor(getResources().getColor(R.color.account_background_color));
        return contentLayout;
    }

    private View initBottomView() {
        View inflate = LayoutInflater.from(this).inflate(com.baidu.searchbox.fileviewer.R.layout.fileviewer_bottom_layout, (ViewGroup) null, false);
        this.mBottomView = inflate;
        if (inflate == null) {
            return null;
        }
        View findViewById = inflate.findViewById(com.baidu.searchbox.fileviewer.R.id.file_viewer_divider_view);
        this.mDivider = findViewById;
        findViewById.setBackgroundResource(R.color.action_bar_title_divider_color);
        TextView textView = (TextView) this.mBottomView.findViewById(com.baidu.searchbox.fileviewer.R.id.file_viewer_delete_view);
        this.mDeleteTextView = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FileViewerActivity.this.showDeleteDialog();
            }
        });
        TextView textView2 = (TextView) this.mBottomView.findViewById(com.baidu.searchbox.fileviewer.R.id.file_viewer_rename_view);
        this.mRenameTextView = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (FileViewerActivity.this.mSelectedItems != null) {
                    final boolean isFile = true;
                    if (FileViewerActivity.this.mSelectedItems.size() == 1) {
                        final BdFileItemData data = (BdFileItemData) FileViewerActivity.this.mSelectedItems.get(0);
                        if (data == null || TextUtils.isEmpty(data.mPath) || TextUtils.isEmpty(data.mName)) {
                            UniversalToast.makeText((Context) FileViewerActivity.this, com.baidu.searchbox.fileviewer.R.string.fileviewer_popup_filename_illegal).showToast();
                            return;
                        }
                        String title = "";
                        if (data.mType == 1) {
                            title = FileViewerActivity.this.getResources().getString(com.baidu.searchbox.fileviewer.R.string.fileviewer_dir_rename_title);
                        } else if (data.mType == 0) {
                            title = FileViewerActivity.this.getResources().getString(com.baidu.searchbox.fileviewer.R.string.fileviewer_file_rename_title);
                        }
                        if (data.mType != 0) {
                            isFile = false;
                        }
                        BdPopupDialogView.getInstance().showInputDialog(title, data.mName, FileViewerActivity.this.getResources().getString(com.baidu.searchbox.fileviewer.R.string.fileviewer_confirm), FileViewerActivity.this.getResources().getString(com.baidu.searchbox.fileviewer.R.string.fileviewer_cancel), new BdPopupDialogView.IInputDialogClickListener() {
                            public void onInputDialogConfirmClickBtn(String inputContent) {
                                FileViewerActivity.this.renameTo(FileViewerActivity.this.getCurrentPath(data.mPath), data.mName, inputContent.trim(), isFile, new BdFileViewerUtils.RenameCallback() {
                                    public void onSuccess() {
                                        FileViewerActivity.this.showNormalStatus();
                                    }

                                    public void onFail(String failInfo) {
                                        if (!TextUtils.isEmpty(failInfo)) {
                                            UniversalToast.makeText((Context) FileViewerActivity.this, (CharSequence) failInfo).showToast();
                                        }
                                    }
                                });
                            }

                            public void onInputNull() {
                                if (isFile) {
                                    UniversalToast.makeText((Context) FileViewerActivity.this, com.baidu.searchbox.fileviewer.R.string.fileviewer_popup_file_name_null).showToast();
                                } else {
                                    UniversalToast.makeText((Context) FileViewerActivity.this, com.baidu.searchbox.fileviewer.R.string.fileviewer_popup_dir_name_null).showToast();
                                }
                            }
                        });
                        return;
                    }
                }
                UniversalToast.makeText((Context) FileViewerActivity.this, com.baidu.searchbox.fileviewer.R.string.fileviewer_popup_filename_illegal).showToast();
            }
        });
        TextView textView3 = (TextView) this.mBottomView.findViewById(com.baidu.searchbox.fileviewer.R.id.file_viewer_detail_view);
        this.mDetailTextView = textView3;
        textView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        this.mBottomView.setBackgroundColor(getResources().getColor(R.color.white));
        updateBottomTextViewStatus(BottomViewStatus.SHOW_NONE);
        updateBottomItemVisibleStatus(BottomViewVisibleStatus.SHOW_BACK);
        return this.mBottomView;
    }

    /* access modifiers changed from: private */
    public void showDeleteDialog() {
        new BoxAlertDialog.Builder(this).setTitle((CharSequence) getString(R.string.del_file)).setMessage(Html.fromHtml(String.format(getString(R.string.del_file_info), new Object[]{Integer.valueOf(this.mSelectedItems.size())}))).setPositiveButton(R.string.delete, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (!FileViewerActivity.this.isFinishing() && dialog != null) {
                    dialog.dismiss();
                    FileViewerActivity.this.doDeleteJob();
                }
            }
        }).setNegativeButton(com.baidu.searchbox.fileviewer.R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public void doDeleteJob() {
        if (this.mIsAllSelected) {
            this.mBdFileViewerView.setTitleLayoutStatus(BdFileViewerTitleView.FileTitleType.NOMAL);
            this.mIsAllSelected = false;
            updateBottomItemVisibleStatus(BottomViewVisibleStatus.SHOW_BACK);
        }
        deleteFile(this.mSelectedItems);
    }

    /* access modifiers changed from: private */
    public String getCurrentPath(String path) {
        int lastInde;
        if (!TextUtils.isEmpty(path) && (lastInde = path.lastIndexOf("/")) != -1) {
            return path.substring(0, lastInde + 1);
        }
        return "";
    }

    private void setTextViewEnable(TextView tv, boolean enable) {
        tv.setClickable(enable);
        if (enable) {
            tv.setTextColor(getResources().getColor(R.color.black));
            tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.common_item_delete_selector, (Resources.Theme) null));
            return;
        }
        tv.setTextColor(getResources().getColor(R.color.delete_disabled));
        tv.setBackground((Drawable) null);
    }

    private void deleteFile(List<BdFileItemData> pathNameList) {
        if (pathNameList == null || pathNameList.size() <= 0) {
            UniversalToast.makeText((Context) this, (CharSequence) getResources().getString(com.baidu.searchbox.fileviewer.R.string.fileviewer_delete_0_fail)).showToast();
            return;
        }
        final List<BdFileItemData> tempDatas = new ArrayList<>();
        tempDatas.addAll(pathNameList);
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                boolean result = false;
                synchronized (FileViewerActivity.this.deleteLock) {
                    for (BdFileItemData itemData : tempDatas) {
                        result = BdFileViewerUtils.deleteFile(itemData.mPath);
                    }
                }
                FileViewerActivity.this.showNormalStatus();
                if (FileViewerActivity.this.mManager == null || !result) {
                    FileViewerActivity fileViewerActivity = FileViewerActivity.this;
                    UniversalToast.makeText((Context) fileViewerActivity, (CharSequence) fileViewerActivity.getResources().getString(com.baidu.searchbox.fileviewer.R.string.fileviewer_delete_fail)).showToast();
                    return;
                }
                FileViewerActivity.this.mManager.scanFolder(FileViewerActivity.this.mManager.getCurrentPath(), false);
            }
        }, DELETE_FILE, 3);
    }

    public void renameTo(String fullPath, String oldName, String newName, boolean isFile, BdFileViewerUtils.RenameCallback renameCallback) {
        if (renameCallback != null) {
            if (TextUtils.isEmpty(fullPath) || TextUtils.isEmpty(oldName) || TextUtils.isEmpty(newName)) {
                renameCallback.onFail(getString(com.baidu.searchbox.fileviewer.R.string.fileviewer_rename_fail));
                return;
            }
            String result = BdFileViewerUtils.renameTo(isFile, fullPath, oldName, newName);
            if (TextUtils.isEmpty(fullPath) || !fullPath.startsWith(fullPath) || !result.equals("成功")) {
                renameCallback.onFail(result);
                return;
            }
            BdFileViewerManager bdFileViewerManager = this.mManager;
            if (bdFileViewerManager != null) {
                bdFileViewerManager.scanFolder(fullPath, false);
                renameCallback.onSuccess();
            }
        }
    }

    public void showNormalStatus() {
        runOnUiThread(new Runnable() {
            public void run() {
                FileViewerActivity.this.updateTitleBar(BdFileViewerTitleView.FileTitleType.NOMAL);
                FileViewerActivity.this.updateToNormalListStatus();
                FileViewerActivity.this.updateBottomItemVisibleStatus(BottomViewVisibleStatus.SHOW_BACK);
                FileViewerActivity.this.mSelectedItems.clear();
                boolean unused = FileViewerActivity.this.mIsEdit = false;
                boolean unused2 = FileViewerActivity.this.mIsAllSelected = false;
            }
        });
    }

    public void updateBottomTextViewStatus(BottomViewStatus bottomViewStatus) {
        switch (AnonymousClass14.$SwitchMap$com$baidu$searchbox$fileviewer$activity$FileViewerActivity$BottomViewStatus[bottomViewStatus.ordinal()]) {
            case 1:
                setTextViewEnable(this.mDeleteTextView, true);
                setTextViewEnable(this.mRenameTextView, true);
                return;
            case 2:
                setTextViewEnable(this.mDeleteTextView, true);
                setTextViewEnable(this.mRenameTextView, false);
                return;
            default:
                setTextViewEnable(this.mDeleteTextView, false);
                setTextViewEnable(this.mRenameTextView, false);
                return;
        }
    }

    /* renamed from: com.baidu.searchbox.fileviewer.activity.FileViewerActivity$14  reason: invalid class name */
    static /* synthetic */ class AnonymousClass14 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$fileviewer$activity$FileViewerActivity$BottomViewStatus;
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$fileviewer$activity$FileViewerActivity$BottomViewVisibleStatus;

        static {
            int[] iArr = new int[BottomViewVisibleStatus.values().length];
            $SwitchMap$com$baidu$searchbox$fileviewer$activity$FileViewerActivity$BottomViewVisibleStatus = iArr;
            try {
                iArr[BottomViewVisibleStatus.SHOW_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$fileviewer$activity$FileViewerActivity$BottomViewVisibleStatus[BottomViewVisibleStatus.SHOW_EDIT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[BottomViewStatus.values().length];
            $SwitchMap$com$baidu$searchbox$fileviewer$activity$FileViewerActivity$BottomViewStatus = iArr2;
            try {
                iArr2[BottomViewStatus.SHOW_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$fileviewer$activity$FileViewerActivity$BottomViewStatus[BottomViewStatus.SHOW_DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$fileviewer$activity$FileViewerActivity$BottomViewStatus[BottomViewStatus.SHOW_NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public void updateBottomItemVisibleStatus(BottomViewVisibleStatus bottomViewVisibleStatus) {
        switch (AnonymousClass14.$SwitchMap$com$baidu$searchbox$fileviewer$activity$FileViewerActivity$BottomViewVisibleStatus[bottomViewVisibleStatus.ordinal()]) {
            case 1:
                this.mBottomView.setVisibility(8);
                this.mDeleteTextView.setVisibility(8);
                this.mRenameTextView.setVisibility(8);
                this.mDetailTextView.setVisibility(8);
                UnifiedBottomBarExtKt.showBottomBar(this);
                return;
            case 2:
                this.mBottomView.setVisibility(0);
                this.mDeleteTextView.setVisibility(0);
                this.mRenameTextView.setVisibility(0);
                UnifiedBottomBarExtKt.dismissBottomBar(this);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == -1 && data != null && data.hasExtra(FileMakeDirActivity.KEY_DOWNLOAD_PATH)) {
            this.mManager.scanFolder(data.getStringExtra(FileMakeDirActivity.KEY_DOWNLOAD_PATH), this.mIsScanDirectory);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        BdFileViewerView bdFileViewerView;
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        DangerousPermissionManager.RequestSystemPermissionCallBack requestSystemPermissionCallBack = this.mRequestSystemPermissionCallBack;
        if (requestSystemPermissionCallBack != null) {
            requestSystemPermissionCallBack.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        if (BdFileViewerView.mRequestSystemPermissionCallBack != null) {
            BdFileViewerView.mRequestSystemPermissionCallBack.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        boolean isAllGranted = true;
        int length = grantResults.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (grantResults[i2] != 0) {
                isAllGranted = false;
                break;
            } else {
                i2++;
            }
        }
        if (!isAllGranted) {
            showPermissionDialog();
        } else if (requestCode == 102) {
            scanFolder();
        } else if (requestCode == 102 && (bdFileViewerView = this.mBdFileViewerView) != null) {
            bdFileViewerView.clickPathItem();
        }
    }

    private boolean isAllowedPath(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        try {
            String externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir("downloads").getParent();
            String dataFileDir = AppRuntime.getAppContext().getFilesDir().getParent();
            if (DEBUG) {
                Log.d("DownloadHelper", " isStoragePrivatePath(String filePath) : \n filePath = " + getDisplayString(filePath) + "\n AppRuntime.getAppContext().getExternalFilesDir(Constants.DEFAULT_DL_SUBDIR_NAME).getPath() = " + getDisplayString(externalFilesDir) + "\n AppRuntime.getAppContext().getFilesDir().getParent() = " + getDisplayString(dataFileDir));
            }
            if (filePath.contains(externalFilesDir) || filePath.contains(dataFileDir)) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("DownloadHelper", " isStoragePrivatePath(String filePath) : \n filePath = " + getDisplayString(filePath) + "\n externalFilesDir = " + getDisplayString("") + "\n dataFileDir = " + getDisplayString(""));
                throw new DebugException("DownloadHelper : isStoragePrivatePath(String filePath) : \n " + e2);
            }
        }
    }

    public static void showPermissionDialog() {
        if (BdBoxActivityManager.getTopActivity() != null) {
            DangerousPermissionUtils.requestGrantPermissionsDialog(BdFileViewerView.SOURCE, "storage", new DangerousPermissionManager.RequestGrantPermissionCallBack() {
                public void isClosed() {
                }

                public void isGranted() {
                }
            });
        }
    }

    public static void openPermissionPage(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        ActivityUtils.startActivitySafely(context, intent);
    }

    public static String getDisplayString(Object object) {
        if (object == null || TextUtils.isEmpty(object.toString())) {
            return "null.";
        }
        return object.toString();
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        UnifiedBottomBarOption barOption = super.getBottomBarOption();
        barOption.setHideBackWithTopBackExperiment(true);
        return barOption;
    }

    private void bottomBarShowStatistic() {
        Map<String, String> datas = new HashMap<>();
        datas.put("from", "base");
        datas.put("page", "file");
        datas.put("ext", StatisticHelperKt.getUnifiedBackSecondPageJSON(this.mOnlyRead ? DownloadChangePathUBC.SECOND_PAGE_READ_ONLY : DownloadChangePathUBC.SECOND_PAGE_WRITABLE));
        UnifiedBottomBar unifiedBottomBar = UnifiedBottomBarExtKt.getBottomBar(this);
        if (unifiedBottomBar != null) {
            unifiedBottomBar.onElementsShowEventStatistic(BottomBarElementID.ELEMENT_ID_BACK, datas);
        }
    }
}
