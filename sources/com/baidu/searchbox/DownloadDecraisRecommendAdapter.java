package com.baidu.searchbox;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.DownloadApkUrlCheckWindow;
import com.baidu.android.ext.widget.downloadbutton.ApkDownloadHandler;
import com.baidu.android.ext.widget.downloadbutton.EllipseDownloadView;
import com.baidu.android.ext.widget.downloadbutton.EllipseDownloadWithStatusButton;
import com.baidu.android.ext.widget.downloadbutton.IDownloadClickListener;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.data.CKModel;
import com.baidu.searchbox.data.DecraisModel;
import com.baidu.searchbox.data.DialogData;
import com.baidu.searchbox.data.RecommendAppInfo;
import com.baidu.searchbox.decrais.DecraisUtils;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.base.R;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.unified.DownloadInfoData;
import com.baidu.searchbox.download.unified.DownloadInfoDatasCallback;
import com.baidu.searchbox.download.unified.DownloadUnifiedManager;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.unified.EventControlInfoForResume;
import com.baidu.searchbox.download.unified.ResumeParams;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadDecraisRecommendAdapter extends RecyclerView.Adapter {
    public static final int MAX_RECOMMEND_COUNT = 3;
    private DialogData dialogData;
    /* access modifiers changed from: private */
    public Context mContext;
    private DecraisModel mDecraisModel;
    /* access modifiers changed from: private */
    public DownloadApkUrlCheckWindow.IDecraisRecommendClick mDecraisRecommendClick;
    private int mDialogType;
    private List<EllipseDownloadWithStatusButton> mDownLoadButton;
    protected DownloadInfoData mOriginDownloadInfoData;
    private ArrayList<RecommendAppInfo> mRecommendAppList;

    public DownloadDecraisRecommendAdapter(Context context, DecraisModel model) {
        ArrayList<RecommendAppInfo> arrayList = new ArrayList<>();
        this.mRecommendAppList = arrayList;
        this.mDecraisModel = model;
        arrayList.clear();
        if (model.recommendAppList != null && model.recommendAppList.size() > 0) {
            this.mRecommendAppList.addAll(model.recommendAppList);
        }
        this.mContext = context;
        this.mDownLoadButton = new ArrayList();
    }

    public void setDialogData(DialogData dialogData2) {
        this.dialogData = dialogData2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DecraisRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.download_decrais_recomend_item, parent, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerView.ViewHolder viewHolder = holder;
        if (viewHolder instanceof DecraisRecommendViewHolder) {
            final RecommendAppInfo apkInfo = this.mRecommendAppList.get(position);
            DecraisRecommendViewHolder viewHolder2 = (DecraisRecommendViewHolder) viewHolder;
            viewHolder2.mTitle.setText(apkInfo.name);
            viewHolder2.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.popup_title_text_color));
            viewHolder2.mIcon.setImageURI(apkInfo.iconUrl);
            viewHolder2.mAppVersion.setText(this.mContext.getResources().getString(R.string.download_version, new Object[]{apkInfo.versionname}));
            viewHolder2.mDevelopName.setText(apkInfo.developername);
            viewHolder2.mDevelopName.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    if (!TextUtils.isEmpty(apkInfo.developername)) {
                        Toast.makeText(DownloadDecraisRecommendAdapter.this.mContext, apkInfo.developername, 0).show();
                    }
                }
            });
            viewHolder2.mPprivacyPolicy.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    BaseRouter.invoke(DownloadDecraisRecommendAdapter.this.mContext, apkInfo.privacyPolicyUrl);
                }
            });
            viewHolder2.mAuthority.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    BaseRouter.invoke(DownloadDecraisRecommendAdapter.this.mContext, apkInfo.authorityUrl);
                }
            });
            viewHolder2.mFuncIntro.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    BaseRouter.invoke(DownloadDecraisRecommendAdapter.this.mContext, apkInfo.funcIntro);
                }
            });
            final CKModel ckModel = new CKModel();
            int touchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
            final CKModel cKModel = ckModel;
            final View view2 = viewHolder2.mDownloadBotton;
            final int[] iArr = new int[2];
            AnonymousClass5 r8 = r0;
            final DecraisRecommendViewHolder decraisRecommendViewHolder = viewHolder2;
            EllipseDownloadView ellipseDownloadView = viewHolder2.mDownloadBotton;
            final int i2 = touchSlop;
            AnonymousClass5 r0 = new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case 0:
                            cKModel.mDownTime = System.currentTimeMillis();
                            view2.getLocationOnScreen(iArr);
                            cKModel.mViewWidth = (long) decraisRecommendViewHolder.itemView.getWidth();
                            cKModel.mViewHeight = (long) decraisRecommendViewHolder.itemView.getHeight();
                            cKModel.mDownX = ((int) event.getX()) + iArr[0];
                            cKModel.mDownY = ((int) event.getY()) + iArr[1];
                            break;
                        case 1:
                            cKModel.mUpTime = System.currentTimeMillis();
                            long ck1 = cKModel.mUpTime - cKModel.mDownTime;
                            cKModel.mUpX = ((int) event.getX()) + iArr[0];
                            cKModel.mUpY = ((int) event.getY()) + iArr[1];
                            if (Math.abs(cKModel.mUpX - cKModel.mDownX) < i2 && Math.abs(cKModel.mUpY - cKModel.mDownY) < i2) {
                                cKModel.buildCKJsonObject();
                                break;
                            } else {
                                cKModel.mTouchMoveNum++;
                                cKModel.mTouchMoveTotaltime += ck1;
                                cKModel.buildCKJsonObject();
                                break;
                            }
                        case 2:
                            if (cKModel.mDownTime == 0) {
                                cKModel.mDownTime = System.currentTimeMillis();
                                break;
                            }
                            break;
                    }
                    return false;
                }
            };
            ellipseDownloadView.setOnTouchListener(r8);
            final EllipseDownloadWithStatusButton downloadButton = new EllipseDownloadWithStatusButton(viewHolder2.mDownloadBotton, (ApkDownloadHandler) null) {
                public void onSuccess(long id, long totalBytes) {
                    super.onSuccess(id, totalBytes);
                    ApkDownloadHandler apkDownloadHandler = null;
                    if (apkDownloadHandler != null) {
                        DownloadDecraisRecommendAdapter.this.queryDownloadInfoDataAsync(apkDownloadHandler.getUri(), false);
                    }
                }
            };
            this.mDownLoadButton.add(downloadButton);
            downloadButton.setPkgName(apkInfo.packageName);
            downloadButton.setVersionCode(String.valueOf(apkInfo.versioncode));
            ApkDownloadHandler handler = new ApkDownloadHandler() {
                public Uri start() {
                    if (DownloadDecraisRecommendAdapter.this.mDecraisRecommendClick != null && !TextUtils.isEmpty(apkInfo.statisticInfo)) {
                        DownloadDecraisRecommendAdapter.this.mDecraisRecommendClick.onDownloadClick(ckModel, apkInfo.statisticInfo, apkInfo);
                    }
                    DownloadDecraisRecommendAdapter.this.startDownload(apkInfo, this, downloadButton, ckModel);
                    return this.mUri;
                }

                public void install() {
                    if (DownloadDecraisRecommendAdapter.this.mOriginDownloadInfoData == null) {
                        DownloadDecraisRecommendAdapter.this.queryDownloadInfoDataAsync(this.mUri, true);
                    } else {
                        DecraisUtils.checkInstallApk(DownloadDecraisRecommendAdapter.this.mOriginDownloadInfoData);
                    }
                }

                public void resume() {
                    EllipseDownloadWithStatusButton ellipseDownloadWithStatusButton = downloadButton;
                    if (ellipseDownloadWithStatusButton == null || ellipseDownloadWithStatusButton.getUri() == null) {
                        super.resume();
                        return;
                    }
                    DownloadUnifiedManager.getInstance().resumeDownload(this.mContext, new ResumeParams(SourceConstant.SOURCE_SEARCH_DECRAIS_APK, true), downloadButton.getUri(), (IDownloadListener) null, (EventControlInfoForResume) null, (EventCallback) null);
                }
            };
            downloadButton.initDownloadStatus(apkInfo.appsearchDownloadURL, DecraisUtils.getUriByUrl(DecraisUtils.getWithoutParamsUrl(apkInfo.appsearchDownloadURL) + apkInfo.packageName), handler, new IDownloadClickListener() {
                public void onClick() {
                }
            });
        } else if (AppConfig.isDebug()) {
            throw new DebugException("The holder is not the DecraisRecommendViewHolder");
        }
    }

    /* access modifiers changed from: private */
    public void queryDownloadInfoDataAsync(Uri mUri, final boolean isCheckInstallApk) {
        DownloadUnifiedManager.getInstance().queryDownloadInfoDataAsync(mUri, (DownloadInfoDatasCallback) new DownloadInfoDatasCallback() {
            public void callback(List<DownloadInfoData> list) {
                if (list != null && list.size() > 0) {
                    DownloadDecraisRecommendAdapter.this.mOriginDownloadInfoData = list.get(0);
                    if (isCheckInstallApk) {
                        DecraisUtils.checkInstallApk(DownloadDecraisRecommendAdapter.this.mOriginDownloadInfoData);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0070 A[Catch:{ Exception -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0088 A[Catch:{ Exception -> 0x0102 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startDownload(final com.baidu.searchbox.data.RecommendAppInfo r11, final com.baidu.android.ext.widget.downloadbutton.ApkDownloadHandler r12, final com.baidu.android.ext.widget.downloadbutton.EllipseDownloadWithStatusButton r13, com.baidu.searchbox.data.CKModel r14) {
        /*
            r10 = this;
            com.baidu.searchbox.data.DecraisModel r0 = r10.mDecraisModel     // Catch:{ Exception -> 0x0102 }
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = r0.extraInfo     // Catch:{ Exception -> 0x0102 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0102 }
            if (r0 == 0) goto L_0x000d
            goto L_0x0017
        L_0x000d:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0102 }
            com.baidu.searchbox.data.DecraisModel r1 = r10.mDecraisModel     // Catch:{ Exception -> 0x0102 }
            java.lang.String r1 = r1.extraInfo     // Catch:{ Exception -> 0x0102 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0102 }
            goto L_0x001c
        L_0x0017:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0102 }
            r0.<init>()     // Catch:{ Exception -> 0x0102 }
        L_0x001c:
            r1 = 1
            if (r11 == 0) goto L_0x004d
            java.lang.String r2 = "package"
            java.lang.String r3 = r11.packageName     // Catch:{ Exception -> 0x0102 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r2 = "icon"
            java.lang.String r3 = r11.iconUrl     // Catch:{ Exception -> 0x0102 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r2 = "versioncode"
            int r3 = r11.versioncode     // Catch:{ Exception -> 0x0102 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r2 = "channel"
            java.lang.String r3 = r11.sourceForBaiduboxapp     // Catch:{ Exception -> 0x0102 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r2 = "2"
            java.lang.String r3 = r11.sourceForBaiduboxapp     // Catch:{ Exception -> 0x0102 }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0102 }
            if (r2 != 0) goto L_0x004d
            java.lang.String r2 = "need_check_apk"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0102 }
        L_0x004d:
            java.lang.String r2 = "source"
            java.lang.String r3 = "apk_recommend"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r2 = "category"
            java.lang.String r3 = "3"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0102 }
            com.baidu.searchbox.download.unified.DownloadParams r2 = new com.baidu.searchbox.download.unified.DownloadParams     // Catch:{ Exception -> 0x0102 }
            r2.<init>()     // Catch:{ Exception -> 0x0102 }
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x0102 }
            r2.setExtraInfo(r3)     // Catch:{ Exception -> 0x0102 }
            r2.setShowStartDownloadToast(r1)     // Catch:{ Exception -> 0x0102 }
            r2.setVisibleInDownloadsUI(r1)     // Catch:{ Exception -> 0x0102 }
            if (r11 == 0) goto L_0x0084
            java.lang.String r3 = r11.name     // Catch:{ Exception -> 0x0102 }
            r2.setTitle(r3)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r3 = r11.appsearchDownloadURL     // Catch:{ Exception -> 0x0102 }
            long r4 = r11.imTimeSign     // Catch:{ Exception -> 0x0102 }
            java.lang.String r3 = com.baidu.searchbox.decrais.AppsearchHelper.addCkOnUrl(r3, r4, r14)     // Catch:{ Exception -> 0x0102 }
            r11.appsearchDownloadURL = r3     // Catch:{ Exception -> 0x0102 }
            java.lang.String r3 = r11.appsearchDownloadURL     // Catch:{ Exception -> 0x0102 }
            r2.setUrl(r3)     // Catch:{ Exception -> 0x0102 }
        L_0x0084:
            com.baidu.searchbox.data.DialogData r3 = r10.dialogData     // Catch:{ Exception -> 0x0102 }
            if (r3 == 0) goto L_0x00ed
            com.baidu.searchbox.data.SailorData r3 = r3.sailorData     // Catch:{ Exception -> 0x0102 }
            java.lang.String r3 = r3.refer     // Catch:{ Exception -> 0x0102 }
            r2.setReferer(r3)     // Catch:{ Exception -> 0x0102 }
            com.baidu.searchbox.data.DialogData r3 = r10.dialogData     // Catch:{ Exception -> 0x0102 }
            com.baidu.searchbox.data.SailorData r3 = r3.sailorData     // Catch:{ Exception -> 0x0102 }
            java.lang.String r3 = r3.userAgent     // Catch:{ Exception -> 0x0102 }
            r2.setUserAgent(r3)     // Catch:{ Exception -> 0x0102 }
            com.baidu.searchbox.data.DialogData r3 = r10.dialogData     // Catch:{ Exception -> 0x0102 }
            com.baidu.searchbox.data.SailorData r3 = r3.sailorData     // Catch:{ Exception -> 0x0102 }
            java.lang.String r3 = r3.mimeType     // Catch:{ Exception -> 0x0102 }
            r2.setMimeType(r3)     // Catch:{ Exception -> 0x0102 }
            com.baidu.searchbox.data.DialogData r3 = r10.dialogData     // Catch:{ Exception -> 0x0102 }
            java.lang.String[] r3 = r3.downloadPath     // Catch:{ Exception -> 0x0102 }
            if (r3 == 0) goto L_0x00b7
            com.baidu.searchbox.data.DialogData r3 = r10.dialogData     // Catch:{ Exception -> 0x0102 }
            java.lang.String[] r3 = r3.downloadPath     // Catch:{ Exception -> 0x0102 }
            int r3 = r3.length     // Catch:{ Exception -> 0x0102 }
            if (r3 >= r1) goto L_0x00af
            goto L_0x00b7
        L_0x00af:
            com.baidu.searchbox.data.DialogData r1 = r10.dialogData     // Catch:{ Exception -> 0x0102 }
            java.lang.String[] r1 = r1.downloadPath     // Catch:{ Exception -> 0x0102 }
            r3 = 0
            r1 = r1[r3]     // Catch:{ Exception -> 0x0102 }
            goto L_0x00b9
        L_0x00b7:
            java.lang.String r1 = ""
        L_0x00b9:
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0102 }
            if (r3 != 0) goto L_0x00ed
            boolean r3 = com.baidu.searchbox.download.util.DownloadMediaHelper.checkDownloadSpecifiedDirectoryValid(r1)     // Catch:{ Exception -> 0x0102 }
            if (r3 == 0) goto L_0x00ed
            r3 = 4
            r2.setDestination(r3)     // Catch:{ Exception -> 0x0102 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0102 }
            r3.<init>()     // Catch:{ Exception -> 0x0102 }
            java.lang.String r4 = "file://"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0102 }
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ Exception -> 0x0102 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0102 }
            com.baidu.searchbox.data.DialogData r4 = r10.dialogData     // Catch:{ Exception -> 0x0102 }
            java.lang.String r4 = r4.fileName     // Catch:{ Exception -> 0x0102 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0102 }
            r2.setFilePathHint(r3)     // Catch:{ Exception -> 0x0102 }
        L_0x00ed:
            com.baidu.searchbox.download.unified.DownloadUnifiedManager r3 = com.baidu.searchbox.download.unified.DownloadUnifiedManager.getInstance()     // Catch:{ Exception -> 0x0102 }
            android.content.Context r4 = r10.mContext     // Catch:{ Exception -> 0x0102 }
            java.lang.String r5 = "search_normal_apk"
            r7 = 0
            r8 = 0
            com.baidu.searchbox.DownloadDecraisRecommendAdapter$10 r9 = new com.baidu.searchbox.DownloadDecraisRecommendAdapter$10     // Catch:{ Exception -> 0x0102 }
            r9.<init>(r13, r12, r11)     // Catch:{ Exception -> 0x0102 }
            r6 = r2
            r3.startDownload(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0102 }
            goto L_0x0103
        L_0x0102:
            r0 = move-exception
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.DownloadDecraisRecommendAdapter.startDownload(com.baidu.searchbox.data.RecommendAppInfo, com.baidu.android.ext.widget.downloadbutton.ApkDownloadHandler, com.baidu.android.ext.widget.downloadbutton.EllipseDownloadWithStatusButton, com.baidu.searchbox.data.CKModel):void");
    }

    public int getItemCount() {
        return Math.min(this.mRecommendAppList.size(), 3);
    }

    public void init(int dialogType) {
        this.mDialogType = dialogType;
    }

    public void setDecraisRecommendClick(DownloadApkUrlCheckWindow.IDecraisRecommendClick click) {
        this.mDecraisRecommendClick = click;
    }

    class DecraisRecommendViewHolder extends RecyclerView.ViewHolder {
        TextView mAppVersion;
        TextView mAuthority;
        TextView mDevelopName;
        EllipseDownloadView mDownloadBotton;
        TextView mFuncIntro;
        SimpleDraweeView mIcon;
        TextView mPprivacyPolicy;
        TextView mTitle;

        public DecraisRecommendViewHolder(View itemView) {
            super(itemView);
            TextView textView = (TextView) itemView.findViewById(R.id.recommend_app_title);
            this.mTitle = textView;
            textView.setTextColor(DownloadDecraisRecommendAdapter.this.mContext.getResources().getColor(R.color.popup_title_text_color));
            this.mDownloadBotton = (EllipseDownloadView) itemView.findViewById(R.id.recommend_app_download_button);
            this.mIcon = (SimpleDraweeView) itemView.findViewById(R.id.recommend_apk_icon);
            this.mAppVersion = (TextView) itemView.findViewById(R.id.recommend_app_version);
            this.mDevelopName = (TextView) itemView.findViewById(R.id.develop_name);
            this.mPprivacyPolicy = (TextView) itemView.findViewById(R.id.privacy_policy);
            this.mAuthority = (TextView) itemView.findViewById(R.id.authority);
            this.mFuncIntro = (TextView) itemView.findViewById(R.id.recommend_app_func);
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setCornersRadius((float) DownloadDecraisRecommendAdapter.this.mContext.getResources().getDimensionPixelOffset(R.dimen.dimens_10dp));
            GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(DownloadDecraisRecommendAdapter.this.mContext.getResources()).build();
            hierarchy.setRoundingParams(roundingParams);
            this.mIcon.setHierarchy(hierarchy);
        }
    }

    public List<String> getRecommendList() {
        List<String> list = new ArrayList<>();
        ArrayList<RecommendAppInfo> arrayList = this.mRecommendAppList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<RecommendAppInfo> it = this.mRecommendAppList.iterator();
            while (it.hasNext()) {
                RecommendAppInfo info = it.next();
                if (list.size() >= 3) {
                    break;
                }
                list.add(info.exp);
            }
        }
        return list;
    }

    public List<RecommendAppInfo> getRealRecommendAppInfoList() {
        List<RecommendAppInfo> list = new ArrayList<>();
        ArrayList<RecommendAppInfo> arrayList = this.mRecommendAppList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<RecommendAppInfo> it = this.mRecommendAppList.iterator();
            while (it.hasNext()) {
                RecommendAppInfo info = it.next();
                if (list.size() >= 3) {
                    break;
                }
                list.add(info);
            }
        }
        return list;
    }
}
