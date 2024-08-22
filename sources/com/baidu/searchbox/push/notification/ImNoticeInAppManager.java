package com.baidu.searchbox.push.notification;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.growthsystem.wealth.common.constant.WealthVideoYalogConstantKt;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.imsdk.ImMsgReceiverListener;
import com.baidu.searchbox.push.MessageUtils;
import com.baidu.searchbox.push.NotifyInAppStatistic;
import com.baidu.searchbox.push.PushNotificationManager;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.lang.ref.WeakReference;

public class ImNoticeInAppManager {
    private static final int BOTTOM_POPUPWINDOW = 1;
    private static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    private static final int DISMISS_DELAY = 3000;
    public static final long PAID_YULIANGTIXING = 17592191933555L;
    private static final int POPUPWINDOW_HEIGHT_TO_BOTTOM = 51;
    private static final int POPUPWINDOW_LONG_TITLE = 1;
    private static final int POPUPWINDOW_SHORT_TITLE = 0;
    private static final String TAG = "ImNoticeInAppManager";
    private static volatile ImNoticeInAppManager sInstance;
    public WeakReference<PopupWindow> mRefPopupWindow;

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.baidu.searchbox.push.notification.ImNoticeInAppManager getInstance() {
        /*
            java.lang.Class<com.baidu.searchbox.push.notification.ImNoticeInAppManager> r0 = com.baidu.searchbox.push.notification.ImNoticeInAppManager.class
            monitor-enter(r0)
            com.baidu.searchbox.push.notification.ImNoticeInAppManager r1 = sInstance     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.baidu.searchbox.push.notification.ImNoticeInAppManager r1 = sInstance     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.baidu.searchbox.push.notification.ImNoticeInAppManager r1 = new com.baidu.searchbox.push.notification.ImNoticeInAppManager     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            sInstance = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.baidu.searchbox.push.notification.ImNoticeInAppManager r1 = sInstance     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.push.notification.ImNoticeInAppManager.getInstance():com.baidu.searchbox.push.notification.ImNoticeInAppManager");
    }

    public boolean canNotifyInApp(ImMsgReceiverListener.ImMsgItem imMsgItem) {
        return false;
    }

    public boolean canNotifyInAppOfYuliang(ImMsgReceiverListener.ImMsgItem imMsgItem) {
        boolean isAppInForeground = BdBoxActivityManager.isForeground();
        if (DEBUG) {
            Log.i(TAG, "app foreground: " + isAppInForeground);
        }
        return isAppInForeground && !MessageUtils.sYuLiangTiXingForeground && imMsgItem.mTriggerReasonn == 2;
    }

    public void showNotificationInApp(PushNotificationManager.NotificationInfo info, String url) {
        if (info.getImNotifyInAppType() == 1) {
            fetchImgForBottomPopupWindow(MessageRuntime.getAppContext(), info, true, 0, url);
        }
    }

    private void fetchImgForBottomPopupWindow(Context context, PushNotificationManager.NotificationInfo info, boolean autoClose, int type, String url) {
        final Context context2 = context;
        final PushNotificationManager.NotificationInfo notificationInfo = info;
        final boolean z = autoClose;
        final int i2 = type;
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(url), context).subscribe(new BaseBitmapDataSubscriber() {
            /* access modifiers changed from: protected */
            public void onNewResultImpl(Bitmap bitmap) {
                Bitmap b2;
                if (bitmap != null && !bitmap.isRecycled()) {
                    if (bitmap.getConfig() == null) {
                        b2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        b2 = bitmap.copy(bitmap.getConfig(), true);
                    }
                    ImNoticeInAppManager.this.showBottomPopupWindow(context2, notificationInfo, b2, z, i2);
                }
            }

            /* access modifiers changed from: protected */
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                ImNoticeInAppManager.this.showBottomPopupWindow(context2, notificationInfo, (Bitmap) null, z, i2);
            }

            public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
                super.onCancellation(dataSource);
            }
        }, UiThreadImmediateExecutorService.getInstance());
    }

    /* access modifiers changed from: private */
    public void showBottomPopupWindow(Context context, PushNotificationManager.NotificationInfo info, Bitmap bitmap, boolean autoClose, int type) {
        TextView tvTitle;
        View view2;
        Bitmap bitmap2;
        PopupWindow popupWindow;
        final PushNotificationManager.NotificationInfo notificationInfo = info;
        final boolean z = autoClose;
        int i2 = type;
        WeakReference<PopupWindow> weakReference = this.mRefPopupWindow;
        if (!(weakReference == null || (popupWindow = (PopupWindow) weakReference.get()) == null || !popupWindow.isShowing())) {
            popupWindow.dismiss();
        }
        if (i2 == 1) {
            view2 = LayoutInflater.from(context).inflate(R.layout.im_notify_in_app_title_window, (ViewGroup) null);
            tvTitle = (TextView) view2.findViewById(R.id.dialog_title);
            tvTitle.setText(info.getDescription());
        } else if (i2 == 0) {
            view2 = LayoutInflater.from(context).inflate(R.layout.im_notify_in_app_text_window, (ViewGroup) null);
            tvTitle = (TextView) view2.findViewById(R.id.dialog_title);
            tvTitle.setText(info.getTitle());
            TextView tvContent = (TextView) view2.findViewById(R.id.dialog_message);
            tvContent.setText(info.getDescription());
            tvContent.setTextColor(context.getResources().getColor(R.color.push_dialog_content));
        } else {
            Context context2 = context;
            if (DEBUG) {
                Log.d(TAG, "popupWindow news type is wrong");
                return;
            }
            return;
        }
        if (bitmap == null) {
            bitmap2 = BitmapFactory.decodeResource(context.getResources(), com.baidu.android.common.ui.style.R.drawable.icon);
        } else {
            bitmap2 = bitmap;
        }
        if (bitmap2 != null) {
            ((BdBaseImageView) ((ViewStub) view2.findViewById(R.id.dialog_viewstub)).inflate().findViewById(R.id.img)).setImageBitmap(bitmap2);
            if (i2 == 1) {
                ((RelativeLayout.LayoutParams) tvTitle.getLayoutParams()).addRule(1, R.id.img);
            }
            if (i2 == 0) {
                ((RelativeLayout.LayoutParams) ((RelativeLayout) view2.findViewById(R.id.news_content)).getLayoutParams()).addRule(1, R.id.img);
            }
        }
        BdBaseImageView ivClose = (BdBaseImageView) view2.findViewById(R.id.dialog_close);
        if (NightModeHelper.getNightModeSwitcherState()) {
            ivClose.setImageDrawable(MessageRuntime.getAppContext().getResources().getDrawable(R.drawable.im_notify_in_app_close_night));
        } else {
            ivClose.setImageDrawable(MessageRuntime.getAppContext().getResources().getDrawable(R.drawable.im_notify_in_app_close));
        }
        RelativeLayout rlRoot = (RelativeLayout) view2.findViewById(R.id.searchbox_alert_dialog);
        tvTitle.setTextColor(context.getResources().getColor(R.color.push_dialog_title));
        rlRoot.setBackground(context.getResources().getDrawable(com.baidu.android.common.ui.style.R.drawable.dialog_bg_shadow));
        rlRoot.setPadding(context.getResources().getDimensionPixelSize(R.dimen.bottom_msg_padding_left), 0, 0, 0);
        rlRoot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                long paId = notificationInfo.getPaId();
                NotifyInAppStatistic.clickInStatic(notificationInfo, 1, z, "service");
            }
        });
        ivClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                PopupWindow popupWindow;
                if (!(ImNoticeInAppManager.this.mRefPopupWindow == null || (popupWindow = (PopupWindow) ImNoticeInAppManager.this.mRefPopupWindow.get()) == null || !popupWindow.isShowing())) {
                    popupWindow.dismiss();
                }
                NotifyInAppStatistic.cancelStatic(notificationInfo, 1, z, "service");
            }
        });
        PopupWindow popupWindow2 = new PopupWindow(context);
        popupWindow2.setContentView(view2);
        popupWindow2.setWidth(-1);
        popupWindow2.setHeight(-2);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow2.setAnimationStyle(R.style.im_notice_popupwindow_anim);
        Activity activity = BdBoxActivityManager.getTopActivity();
        NoticeInAppManager pushNoticeInAppManager = NoticeInAppManager.getInstance();
        if (pushNoticeInAppManager.mRefPopupWindow != null) {
            pushNoticeInAppManager.closePopupWindow();
        }
        if (activity != null) {
            View rootView = activity.getWindow().getDecorView();
            if (rootView != null) {
                WindowManager wm = activity.getWindowManager();
                Point point = new Point();
                wm.getDefaultDisplay().getSize(point);
                View view3 = view2;
                int navigationBarHeight = rootView.getBottom() - point.y;
                if (navigationBarHeight > 0) {
                    Point point2 = point;
                    WindowManager windowManager = wm;
                    popupWindow2.showAtLocation(rootView, 80, 0, DeviceUtil.ScreenInfo.dp2px(activity, 51.0f) + navigationBarHeight);
                } else {
                    WindowManager windowManager2 = wm;
                    popupWindow2.showAtLocation(rootView, 80, 0, DeviceUtil.ScreenInfo.dp2px(activity, 51.0f));
                }
                this.mRefPopupWindow = new WeakReference<>(popupWindow2);
                NotifyInAppStatistic.displayStatic(notificationInfo, 1, z, "service");
                if (z) {
                    MessageRuntime.getMessageContext().getMainHandler().postDelayed(new Runnable() {
                        public void run() {
                            ImNoticeInAppManager.this.closePopupWindow();
                        }
                    }, 3000);
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.e(TAG, "popupWindow's rootView is null");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.e(TAG, WealthVideoYalogConstantKt.YALOG_VALUE_ERROR_MSG_ACTIVITY_NULL);
        }
    }

    public void closePopupWindow() {
        try {
            WeakReference<PopupWindow> weakReference = this.mRefPopupWindow;
            if (weakReference != null) {
                PopupWindow popupWindow = (PopupWindow) weakReference.get();
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                this.mRefPopupWindow.clear();
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }
}
