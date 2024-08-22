package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.baidu.wallet.base.iddetect.beans.IDDetectBean;
import com.baidu.wallet.base.iddetect.beans.IDDetectBeanFactory;
import com.baidu.wallet.base.iddetect.datamodel.IDDetectResponse;
import com.baidu.wallet.base.iddetect.utils.BitmapUtil;
import com.baidu.wallet.base.iddetect.utils.IdcardUtils;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import com.baidu.wallet.base.iddetect.utils.Utils;
import com.baidu.wallet.base.iddetect.view.LaserScannerForScan;
import com.baidu.wallet.base.iddetect.view.SurfaceViewForScan;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.permission.CommonPermissionCallback;
import com.baidu.wallet.utils.ImageUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class IdCardActivity extends BeanActivity implements View.OnClickListener {
    public static final int CAMERA_REQUEST_CODE = 3;
    public static final int DELAY_START_TIME = 2000;
    public static final String KEY_IMG_PATH = "card_img_path";
    public static final String KEY_NAME = "name";
    public static final String KEY_NUMBER = "number";
    public static final int MAX_INTERVAL_TIME = 200;
    public static final int MAX_TIMES = 50;
    public static final int MESSAGE_BACK = 7;
    public static final int MESSAGE_CHECK_SUCCESS = 0;
    public static final int MESSAGE_DEBUG_FOR_SERVER = 3;
    public static final int MESSAGE_DELAY = 2;
    public static final int MESSAGE_DONE = 6;
    public static final int MESSAGE_NOT_RECOGNIZE = 1;
    public static final int MESSAGE_SHOW_TOAST = 4;
    public static final int MESSAGE_TIMES_OUT = 5;
    public static final int RESULT_INNER_ERROR = 3;
    public static final int RESULT_NO_PERMISSION = 2;
    public static final String RESULT_PERMISSION_KEY = "permission_name";
    public static final String TAG = "IdCardActivity";
    public static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1;
    public boolean mCanShoot = true;
    public Bitmap mCardBmp;
    public String mCardImagePath = "";
    public String mCardName;
    public String mCardNumber;
    public String mCardRealPath;
    public Activity mContext;
    public int mCurrentTimes = 0;
    public String mDebugInfo;
    public final Handler mHandler = new MyHandler(this);
    public TextView mHint;
    public boolean mIsDebugForServer = false;
    public boolean mIsProcess = false;
    public boolean mIsResume;
    public boolean mIsStart = false;
    public long mLastTime = 0;
    public View mLeftView;
    public Bitmap mMaskBmp;
    public CommonPermissionCallback mPermissionCallBack = null;
    public CameraSizeInfo mPermissionTest = null;
    public LaserScannerForScan mScanFrame;
    public SurfaceViewForScan mSurfaceView;
    public int mTargetHeight;
    public float mTargetRatioH = -1.0f;
    public float mTargetRatioW = -1.0f;
    public int mTargetWidth;
    public int mTargetXpos;
    public int mTargetYpos;
    public LinearLayout mTitleBar;
    public View mTitleBarMargin;
    public String mToastInfo;
    public View mTopView;

    public static class MyHandler extends Handler {
        public final WeakReference<IdCardActivity> mActivity;

        public MyHandler(IdCardActivity idCardActivity) {
            this.mActivity = new WeakReference<>(idCardActivity);
        }

        public void handleMessage(Message message) {
            IdCardActivity idCardActivity = (IdCardActivity) this.mActivity.get();
            if (idCardActivity != null) {
                int i2 = message.what;
                if (i2 == 0) {
                    LogUtil.i(IdCardActivity.TAG, "成功" + idCardActivity.mCurrentTimes + ";姓名=" + idCardActivity.mCardName + ";号码=" + idCardActivity.mCardNumber);
                    boolean unused = idCardActivity.mCanShoot = false;
                    idCardActivity.mHandler.sendEmptyMessage(6);
                } else if (i2 == 1) {
                    LogUtil.i(IdCardActivity.TAG, "失败" + idCardActivity.mCurrentTimes);
                    boolean unused2 = idCardActivity.mCanShoot = true;
                    boolean unused3 = idCardActivity.mIsProcess = false;
                    idCardActivity.mSurfaceView.autoFocus();
                } else if (i2 == 2) {
                    boolean unused4 = idCardActivity.mIsStart = true;
                } else if (i2 != 3) {
                    if (i2 == 5) {
                        boolean unused5 = idCardActivity.mIsStart = false;
                        idCardActivity.mHandler.sendEmptyMessage(7);
                    } else if (i2 == 6) {
                        idCardActivity.release();
                        Bundle bundle = new Bundle();
                        bundle.putString("name", idCardActivity.mCardName);
                        bundle.putString(IdCardActivity.KEY_IMG_PATH, idCardActivity.mCardRealPath);
                        bundle.putString("number", idCardActivity.mCardNumber);
                        IdCardController.getInstance().success(bundle);
                        idCardActivity.finish();
                    } else if (i2 == 7) {
                        idCardActivity.release();
                        IdCardController.getInstance().fail(0, (Bundle) null);
                        idCardActivity.finish();
                    }
                } else if (idCardActivity.mIsDebugForServer) {
                    idCardActivity.mHint.setText(idCardActivity.mDebugInfo);
                }
            }
        }
    }

    private JSONObject addParams(Bitmap bitmap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(UrlOcrConfig.IdCardKey.IDCARD_PIC, BitmapUtil.getBase64(bitmap));
            jSONObject.put(UrlOcrConfig.IdCardKey.METHODDATA, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(UrlOcrConfig.IdCardKey.OS, SapiDeviceInfo.OS_TYPE);
            jSONObject3.put(UrlOcrConfig.IdCardKey.OS_VERSION, Build.VERSION.RELEASE);
            jSONObject3.put(UrlOcrConfig.IdCardKey.OS_BRAND, Build.BRAND);
            jSONObject3.put(UrlOcrConfig.IdCardKey.OS_MODEL, Build.MODEL);
            jSONObject3.put(UrlOcrConfig.IdCardKey.VERSION_CODE, Utils.getVersionCode(this.mContext));
            jSONObject3.put(UrlOcrConfig.IdCardKey.VERSION_NAME, Utils.getVersionName(this.mContext));
            jSONObject.put("channeldata", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private boolean checkCardInfo() {
        String str = this.mCardName;
        return str != null && !str.equals("");
    }

    private void checkWritePermission(final Activity activity) {
        if (PermissionManager.checkCallingPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            initActivity();
        } else {
            this.mPermissionCallBack = BaiduWalletUtils.requestPermissionsDialog((String) null, getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        if (!PermissionManager.checkCallingOrSelfPermission(activity, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 1)) {
                            IdCardActivity.this.handleNoExternalStoragePermission();
                        }
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        IdCardActivity.this.onRequestPermissionsResult(1, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1});
                    }
                }

                public void isShow(String str, Boolean bool) {
                }

                public void requestResult(String str, Boolean bool) {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void dealData(byte[] bArr, int i2, int i3, int i4) {
        if (!this.mIsProcess) {
            this.mIsProcess = true;
            int i5 = this.mCurrentTimes;
            if (i5 >= 50) {
                this.mHandler.sendEmptyMessage(5);
                return;
            }
            this.mCurrentTimes = i5 + 1;
            Bitmap bitmapFromData = getBitmapFromData(bArr, i2, i3);
            this.mMaskBmp = bitmapFromData;
            Bitmap dealWithSmall = dealWithSmall(bitmapFromData);
            this.mCardBmp = dealWithSmall;
            saveFaceImage(dealWithSmall, this.mCardImagePath, "IdCard");
            IDDetectBean iDDetectBean = (IDDetectBean) IDDetectBeanFactory.getInstance().getBean((Context) this.mContext, (int) IDDetectBeanFactory.BEAN_ID_ID_DETECT, TAG);
            iDDetectBean.setBeanParams(BitmapUtil.getBase64(this.mCardBmp));
            iDDetectBean.setResponseCallback(this);
            iDDetectBean.execBean();
        }
    }

    private void dealResult(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            LogUtil.i(TAG, "data==null");
            this.mHandler.sendEmptyMessage(1);
            return;
        }
        if (this.mIsDebugForServer) {
            try {
                this.mDebugInfo = new String(bArr, "UTF-8");
                this.mHandler.sendEmptyMessage(3);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            LogUtil.i(TAG, "dealResult=:" + new String(bArr, "UTF-8") + "data.length =" + bArr.length);
            JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
            int optInt = jSONObject.optInt("status");
            if (optInt != 0) {
                this.mHandler.sendEmptyMessage(1);
                String optString = jSONObject.optString("msg");
                if (optString == null) {
                    return;
                }
                if (optInt == 2) {
                    LogUtil.d(TAG, "联网错误信息：" + optString);
                    return;
                }
                this.mToastInfo = optString;
                this.mHandler.sendEmptyMessage(4);
            } else if (!jSONObject.isNull("result")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                String optString2 = jSONObject2.optString("id_card");
                this.mCardNumber = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    this.mHandler.sendEmptyMessage(1);
                } else if (IdcardUtils.validateIdCard18(this.mCardNumber)) {
                    this.mCardName = jSONObject2.optString("name");
                    if (checkCardInfo()) {
                        this.mHandler.sendEmptyMessage(0);
                    } else {
                        this.mHandler.sendEmptyMessage(1);
                    }
                } else {
                    this.mHandler.sendEmptyMessage(1);
                }
            } else {
                this.mHandler.sendEmptyMessage(1);
            }
        } catch (Exception unused) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    private Bitmap dealWithSmall(Bitmap bitmap) {
        if (this.mTargetRatioH == -1.0f) {
            initRatio(bitmap.getWidth(), bitmap.getHeight());
        }
        return Bitmap.createBitmap(bitmap, this.mTargetXpos, this.mTargetYpos, this.mTargetWidth, this.mTargetHeight);
    }

    private Bitmap getBitmapFromData(byte[] bArr, int i2, int i3) {
        return Bitmap.createBitmap(ImageUtils.decodeYUV420SP(bArr, i2, i3), i2, i3, Bitmap.Config.ARGB_8888);
    }

    /* access modifiers changed from: private */
    public void handleNoCamaraPermission() {
        Bundle bundle = new Bundle();
        bundle.putString(RESULT_PERMISSION_KEY, "访问相机的权限");
        IdCardController.getInstance().fail(2, bundle);
        dialogPermission();
    }

    /* access modifiers changed from: private */
    public void handleNoExternalStoragePermission() {
        Bundle bundle = new Bundle();
        bundle.putString(RESULT_PERMISSION_KEY, "读写存储卡的权限");
        IdCardController.getInstance().fail(2, bundle);
        finish();
    }

    private void initActivity() {
        try {
            setContentView(ResUtils.layout(this.mContext, "wallet_base_id_detect"));
            initView();
            initData();
        } catch (Exception unused) {
            dialogPermission();
        }
    }

    private void initData() {
        this.mScanFrame.startScan();
        findViewById(ResUtils.id(this.mContext, "back_btn")).setOnClickListener(this);
        this.mSurfaceView.setPreviewCallback(new SurfaceViewForScan.Callback() {
            public void onFrame(byte[] bArr, int i2, int i3, int i4) {
                if (IdCardActivity.this.mIsStart && IdCardActivity.this.mIsResume && IdCardActivity.this.mCanShoot) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - IdCardActivity.this.mLastTime >= 200) {
                        long unused = IdCardActivity.this.mLastTime = currentTimeMillis;
                        IdCardActivity.this.dealData(bArr, i2, i3, i4);
                    }
                }
            }
        });
        if (this.mCanShoot) {
            this.mHandler.sendEmptyMessageDelayed(2, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
        }
    }

    private void initPermission(final Activity activity) {
        if (!PermissionManager.checkCallingPermission(activity, "android.permission.CAMERA")) {
            this.mPermissionCallBack = BaiduWalletUtils.requestPermissionsDialog((String) null, activity, new String[]{"android.permission.CAMERA"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        if (!PermissionManager.checkCallingOrSelfPermission(activity, new String[]{"android.permission.CAMERA"}, 3)) {
                            IdCardActivity.this.handleNoCamaraPermission();
                        }
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        IdCardActivity.this.onRequestPermissionsResult(3, new String[]{"android.permission.CAMERA"}, new int[]{-1});
                    }
                }

                public void isShow(String str, Boolean bool) {
                }

                public void requestResult(String str, Boolean bool) {
                }
            });
        } else if (PermissionManager.checkCallingPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            initActivity();
        } else {
            this.mPermissionCallBack = BaiduWalletUtils.requestPermissionsDialog((String) null, getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        if (!PermissionManager.checkCallingOrSelfPermission(activity, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 1)) {
                            IdCardActivity.this.handleNoExternalStoragePermission();
                        }
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        IdCardActivity.this.onRequestPermissionsResult(1, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1});
                    }
                }

                public void isShow(String str, Boolean bool) {
                }

                public void requestResult(String str, Boolean bool) {
                }
            });
        }
    }

    private void initRatio(int i2, int i3) {
        this.mTargetRatioH = (((float) i3) * 1.0f) / ((float) this.mSurfaceView.getHeight());
        float width = (((float) i2) * 1.0f) / ((float) this.mSurfaceView.getWidth());
        this.mTargetRatioW = width;
        this.mTargetXpos = (int) (width * ((float) this.mLeftView.getWidth()));
        this.mTargetYpos = (int) (this.mTargetRatioH * ((float) (this.mTopView.getHeight() + this.mTitleBar.getHeight())));
        this.mTargetWidth = (int) (this.mTargetRatioW * ((float) this.mScanFrame.getWidth()));
        this.mTargetHeight = (int) (this.mTargetRatioH * ((float) this.mScanFrame.getHeight()));
    }

    private void initView() {
        SurfaceViewForScan surfaceViewForScan = (SurfaceViewForScan) findViewById(ResUtils.id(this.mContext, "surface_view"));
        this.mSurfaceView = surfaceViewForScan;
        surfaceViewForScan.setAttachedActivity(this);
        LaserScannerForScan laserScannerForScan = (LaserScannerForScan) findViewById(ResUtils.id(this.mContext, "frame"));
        this.mScanFrame = laserScannerForScan;
        laserScannerForScan.setAttachedActivity(this);
        this.mTopView = findViewById(ResUtils.id(this.mContext, "view_top"));
        this.mLeftView = findViewById(ResUtils.id(this.mContext, "view_left"));
        this.mTitleBar = (LinearLayout) findViewById(ResUtils.id(this.mContext, "title_bar"));
        this.mHint = (TextView) findViewById(ResUtils.id(this.mContext, "hint"));
        View findViewById = findViewById(ResUtils.id(getActivity(), "title_bar_margin"));
        this.mTitleBarMargin = findViewById;
        setTop(findViewById);
    }

    /* access modifiers changed from: private */
    public void release() {
        this.mScanFrame.stopScan();
        this.mSurfaceView.setPreviewCallback((SurfaceViewForScan.Callback) null);
        this.mSurfaceView.releaseSource();
    }

    private void saveFaceImage(Bitmap bitmap, String str, String str2) {
        File cacheDirectory = StorageUtils.getCacheDirectory(getActivity());
        if (!cacheDirectory.exists()) {
            cacheDirectory.mkdirs();
        }
        String str3 = cacheDirectory.getAbsolutePath() + File.separator + str2 + ".jpg";
        File file = new File(str3);
        if (file.exists()) {
            file.delete();
        }
        System.out.println(str3);
        BitmapUtil.saveImage(this.mContext, bitmap, str3, Bitmap.CompressFormat.JPEG, 70);
        this.mCardRealPath = str3;
    }

    public void dialogPermission() {
        String format = String.format(ResUtils.getString(getActivity(), "wallet_camera_error"), new Object[]{PhoneUtils.getApplicationName(getActivity())});
        this.mDialogMsg = format;
        WalletGlobalUtils.safeShowDialog(this, 3, format);
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 57345) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 57345) {
            if (obj != null && (obj instanceof IDDetectResponse)) {
                IDDetectResponse iDDetectResponse = (IDDetectResponse) obj;
                if (!TextUtils.isEmpty(iDDetectResponse.name) && !TextUtils.isEmpty(iDDetectResponse.id_card) && IdcardUtils.validateIdCard18(iDDetectResponse.id_card)) {
                    this.mCardName = iDDetectResponse.name;
                    this.mCardNumber = iDDetectResponse.id_card;
                    this.mHandler.sendEmptyMessage(0);
                    return;
                }
            }
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public boolean isStatusbarTextColorBlack() {
        return false;
    }

    public void onBackPressed() {
        this.mHandler.sendEmptyMessage(7);
    }

    public void onClick(View view) {
        if (view.getId() == ResUtils.id(this.mContext, "back_btn")) {
            this.mHandler.sendEmptyMessage(7);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getActivity();
        initPermission(getActivity());
        setIsMultiWindowAvailable(false);
        setIsShowMultiWindowTips(true);
        setMultiWindowTipsId("wallet_base_multi_window_close");
    }

    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(TAG);
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.mIsResume = false;
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        super.onPrepareDialog(i2, dialog);
        if (i2 == 3) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    Bundle bundle = new Bundle();
                    if (PermissionManager.checkCallingPermission(IdCardActivity.this.getActivity(), "android.permission.CAMERA")) {
                        IdCardController.getInstance().fail(3, (Bundle) null);
                    } else {
                        bundle.putString(IdCardActivity.RESULT_PERMISSION_KEY, "访问相机的权限");
                        IdCardController.getInstance().fail(2, bundle);
                    }
                    IdCardActivity.this.finish();
                }
            });
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        CommonPermissionCallback commonPermissionCallback = this.mPermissionCallBack;
        if (commonPermissionCallback != null) {
            commonPermissionCallback.onRequestPermissionsResult(i2, strArr, iArr);
            this.mPermissionCallBack = null;
        }
        if (i2 != 1) {
            if (i2 == 3) {
                if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    handleNoCamaraPermission();
                } else {
                    checkWritePermission(getActivity());
                }
            }
        } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            handleNoExternalStoragePermission();
        } else {
            initActivity();
        }
    }

    public void onResume() {
        super.onResume();
        this.mIsResume = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096 A[SYNTHETIC, Splitter:B:46:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009e A[Catch:{ IOException -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3 A[Catch:{ IOException -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae A[SYNTHETIC, Splitter:B:57:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b6 A[Catch:{ IOException -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bb A[Catch:{ IOException -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] sendDataAndGetResult(java.lang.String r8, org.json.JSONObject r9) {
        /*
            r7 = this;
            r0 = 0
            if (r9 == 0) goto L_0x00c3
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            java.net.URLConnection r8 = r1.openConnection()     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            r1 = 1
            r8.setDoInput(r1)     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            r8.setDoOutput(r1)     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            r2 = 30000(0x7530, float:4.2039E-41)
            r8.setConnectTimeout(r2)     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            r8.setReadTimeout(r2)     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            java.lang.String r2 = "POST"
            r8.setRequestMethod(r2)     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            java.io.OutputStream r2 = r8.getOutputStream()     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0083, all -> 0x007e }
            byte[] r9 = r9.getBytes()     // Catch:{ Exception -> 0x0083, all -> 0x007e }
            r2.write(r9)     // Catch:{ Exception -> 0x0083, all -> 0x007e }
            int r9 = r8.getResponseCode()     // Catch:{ Exception -> 0x0083, all -> 0x007e }
            r3 = 200(0xc8, float:2.8E-43)
            if (r9 != r3) goto L_0x0064
            java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x0083, all -> 0x007e }
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0061, all -> 0x005b }
            r9.<init>()     // Catch:{ Exception -> 0x0061, all -> 0x005b }
            r3 = 8192(0x2000, float:1.14794E-41)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0059 }
        L_0x0046:
            int r4 = r8.read(r3)     // Catch:{ Exception -> 0x0059 }
            if (r4 < r1) goto L_0x0051
            r5 = 0
            r9.write(r3, r5, r4)     // Catch:{ Exception -> 0x0059 }
            goto L_0x0046
        L_0x0051:
            byte[] r0 = r9.toByteArray()     // Catch:{ Exception -> 0x0059 }
            r6 = r0
            r0 = r8
            r8 = r6
            goto L_0x0066
        L_0x0059:
            r1 = move-exception
            goto L_0x0091
        L_0x005b:
            r9 = move-exception
            r6 = r0
            r0 = r9
            r9 = r6
            goto L_0x00ac
        L_0x0061:
            r1 = move-exception
            r9 = r0
            goto L_0x0091
        L_0x0064:
            r8 = r0
            r9 = r8
        L_0x0066:
            if (r0 == 0) goto L_0x006e
            r0.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x006e
        L_0x006c:
            r9 = move-exception
            goto L_0x0079
        L_0x006e:
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ IOException -> 0x006c }
        L_0x0073:
            if (r9 == 0) goto L_0x007c
            r9.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x007c
        L_0x0079:
            r9.printStackTrace()
        L_0x007c:
            r0 = r8
            goto L_0x00c3
        L_0x007e:
            r8 = move-exception
            r9 = r0
            r0 = r8
            r8 = r9
            goto L_0x00ac
        L_0x0083:
            r1 = move-exception
            r8 = r0
            r9 = r8
            goto L_0x0091
        L_0x0087:
            r8 = move-exception
            r9 = r0
            r2 = r9
            r0 = r8
            r8 = r2
            goto L_0x00ac
        L_0x008d:
            r1 = move-exception
            r8 = r0
            r9 = r8
            r2 = r9
        L_0x0091:
            r1.printStackTrace()     // Catch:{ all -> 0x00ab }
            if (r8 == 0) goto L_0x009c
            r8.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x009c
        L_0x009a:
            r8 = move-exception
            goto L_0x00a7
        L_0x009c:
            if (r2 == 0) goto L_0x00a1
            r2.close()     // Catch:{ IOException -> 0x009a }
        L_0x00a1:
            if (r9 == 0) goto L_0x00c3
            r9.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00c3
        L_0x00a7:
            r8.printStackTrace()
            goto L_0x00c3
        L_0x00ab:
            r0 = move-exception
        L_0x00ac:
            if (r8 == 0) goto L_0x00b4
            r8.close()     // Catch:{ IOException -> 0x00b2 }
            goto L_0x00b4
        L_0x00b2:
            r8 = move-exception
            goto L_0x00bf
        L_0x00b4:
            if (r2 == 0) goto L_0x00b9
            r2.close()     // Catch:{ IOException -> 0x00b2 }
        L_0x00b9:
            if (r9 == 0) goto L_0x00c2
            r9.close()     // Catch:{ IOException -> 0x00b2 }
            goto L_0x00c2
        L_0x00bf:
            r8.printStackTrace()
        L_0x00c2:
            throw r0
        L_0x00c3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.iddetect.IdCardActivity.sendDataAndGetResult(java.lang.String, org.json.JSONObject):byte[]");
    }

    public void setTop(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(this.mAct)));
            ImmersiveStatusBarManager.setTopBar(getActivity(), view, isStatusbarTextColorBlack());
        }
    }
}
