package com.baidu.megapp.proxy.activity;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TabActivity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.baidu.megapp.APSClassLoader;
import com.baidu.megapp.ProxyEnvironment;
import com.baidu.megapp.adapter.TabActivityProxyAdapter;
import com.baidu.megapp.api.TargetActivator;
import com.baidu.megapp.hook.LayoutInflaterModifier;
import com.baidu.megapp.hook.SerializableClassFixer;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.megapp.ma.MATabActivity;
import com.baidu.megapp.proxy.content.ContentResolver;
import com.baidu.megapp.util.JavaCalls;
import com.baidu.megapp.util.MegUtils;
import com.baidu.megapp.util.Util;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class TabActivityProxy extends TabActivity implements TabActivityProxyAdapter {
    private String mPackageName;
    private ClassLoader mTargetClassLoader;
    private MATabActivity target;

    public void loadTargetActivity() {
        if (this.target == null && !super.isFinishing()) {
            Intent curIntent = getIntent();
            if (curIntent == null) {
                finish();
                return;
            }
            String targetClassName = null;
            String targetPackageName = null;
            try {
                targetClassName = curIntent.getStringExtra(ProxyEnvironment.EXTRA_TARGET_ACTIVITY);
                targetPackageName = curIntent.getStringExtra(ProxyEnvironment.EXTRA_TARGET_PACKAGNAME);
            } catch (RuntimeException e2) {
            }
            if (TextUtils.isEmpty(targetPackageName)) {
                finish();
                return;
            }
            if (ProxyEnvironment.hasInstance(targetPackageName) && !ProxyEnvironment.checkClassLoader(targetPackageName, getClassLoader())) {
                ProxyEnvironment.removePluginEnvironmentOnly(targetPackageName);
            }
            if (!ProxyEnvironment.hasInstance(targetPackageName)) {
                finish();
                if (TextUtils.isEmpty(targetClassName)) {
                    targetClassName = "";
                }
                Intent intent = new Intent(getIntent());
                intent.setComponent(new ComponentName(targetPackageName, targetClassName));
                Util.genProxyExtIntent(this, intent);
                TargetActivator.loadTargetAndRunForReboot(this, intent);
                return;
            }
            if (!TextUtils.isEmpty(targetPackageName)) {
                this.mPackageName = targetPackageName;
            }
            try {
                APSClassLoader dexClassLoader = ProxyEnvironment.getInstance(targetPackageName).getDexClassLoader();
                this.mTargetClassLoader = dexClassLoader;
                SerializableClassFixer.recover(curIntent, dexClassLoader);
                MATabActivity mATabActivity = (MATabActivity) this.mTargetClassLoader.loadClass(targetClassName).asSubclass(MATabActivity.class).newInstance();
                this.target = mATabActivity;
                mATabActivity.setActivityProxy(this);
                this.target.setTargetPackagename(targetPackageName);
                setTheme(ProxyEnvironment.getInstance(targetPackageName).getTargetActivityThemeResource(targetClassName));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.addContentView(paramView, paramLayoutParams);
        } else {
            super.addContentView(paramView, paramLayoutParams);
        }
    }

    public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.bindService(paramIntent, paramServiceConnection, paramInt);
        }
        return super.bindService(paramIntent, paramServiceConnection, paramInt);
    }

    public void closeContextMenu() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.closeContextMenu();
        } else {
            super.closeContextMenu();
        }
    }

    public void closeOptionsMenu() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.closeOptionsMenu();
        } else {
            super.closeOptionsMenu();
        }
    }

    public PendingIntent createPendingResult(int paramInt1, Intent paramIntent, int paramInt2) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.createPendingResult(paramInt1, paramIntent, paramInt2);
        }
        return super.createPendingResult(paramInt1, paramIntent, paramInt2);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.dispatchGenericMotionEvent(paramMotionEvent);
        }
        return super.dispatchGenericMotionEvent(paramMotionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.dispatchKeyEvent(paramKeyEvent);
        }
        return super.dispatchKeyEvent(paramKeyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.dispatchKeyShortcutEvent(paramKeyEvent);
        }
        return super.dispatchKeyShortcutEvent(paramKeyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
        }
        return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.dispatchTouchEvent(paramMotionEvent);
        }
        return super.dispatchTouchEvent(paramMotionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.dispatchTrackballEvent(paramMotionEvent);
        }
        return super.dispatchTrackballEvent(paramMotionEvent);
    }

    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    }

    public View findViewById(int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.findViewById(paramInt);
        }
        return super.findViewById(paramInt);
    }

    public void finish() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.finish();
        } else {
            super.finish();
        }
    }

    public void finishActivity(int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.finishActivity(paramInt);
        } else {
            super.finishActivity(paramInt);
        }
    }

    public void finishActivityFromChild(Activity paramActivity, int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.finishActivityFromChild(paramActivity, paramInt);
        } else {
            super.finishActivityFromChild(paramActivity, paramInt);
        }
    }

    public void finishFromChild(Activity paramActivity) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.finishFromChild(paramActivity);
        } else {
            super.finishFromChild(paramActivity);
        }
    }

    public Activity getActivity() {
        return this;
    }

    public AssetManager getAssets() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getAssets();
        }
        return super.getAssets();
    }

    public ComponentName getCallingActivity() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getCallingActivity();
        }
        return super.getCallingActivity();
    }

    public String getCallingPackage() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getCallingPackage();
        }
        return super.getCallingPackage();
    }

    public int getChangingConfigurations() {
        return -1;
    }

    public ClassLoader getClassLoader() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getClassLoader();
        }
        return super.getClassLoader();
    }

    public View getCurrentFocus() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getCurrentFocus();
        }
        return super.getCurrentFocus();
    }

    public Intent getIntent() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.getIntent();
        }
        return super.getIntent();
    }

    public LayoutInflater getLayoutInflater() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.getLayoutInflater();
        }
        return super.getLayoutInflater();
    }

    public String getLocalClassName() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.getLocalClassName();
        }
        return super.getLocalClassName();
    }

    public MenuInflater getMenuInflater() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getMenuInflater();
        }
        return super.getMenuInflater();
    }

    public PackageManager getPackageManager() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getPackageManager();
        }
        return super.getPackageManager();
    }

    public SharedPreferences getPreferences(int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getPreferences(paramInt);
        }
        return super.getPreferences(paramInt);
    }

    public int getRequestedOrientation() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getRequestedOrientation();
        }
        return super.getRequestedOrientation();
    }

    public Resources getResources() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getResources();
        }
        return super.getResources();
    }

    public SharedPreferences getSharedPreferences(String name, int mode) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getSharedPreferences(name, mode);
        }
        return super.getSharedPreferences(name, mode);
    }

    public Object getSystemService(String paramString) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getSystemService(paramString);
        }
        return super.getSystemService(paramString);
    }

    public int getTaskId() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.getTaskId();
        }
        return super.getTaskId();
    }

    public int getWallpaperDesiredMinimumHeight() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.getWallpaperDesiredMinimumHeight();
        }
        return super.getWallpaperDesiredMinimumHeight();
    }

    public int getWallpaperDesiredMinimumWidth() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.getWallpaperDesiredMinimumWidth();
        }
        return super.getWallpaperDesiredMinimumWidth();
    }

    public Window getWindow() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.getWindow();
        }
        return super.getWindow();
    }

    public WindowManager getWindowManager() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.getWindowManager();
        }
        return super.getWindowManager();
    }

    public boolean hasWindowFocus() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.hasWindowFocus();
        }
        return super.hasWindowFocus();
    }

    public boolean isFinishing() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.isFinishing();
        }
        return super.isFinishing();
    }

    public boolean isTaskRoot() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.isTaskRoot();
        }
        return super.isTaskRoot();
    }

    public boolean moveTaskToBack(boolean paramBoolean) {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.moveTaskToBack(paramBoolean);
        }
        return super.moveTaskToBack(paramBoolean);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            JavaCalls.invokeMethod(mATabActivity, "onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, new Object[]{Integer.valueOf(requestCode), Integer.valueOf(resultCode), data});
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /* access modifiers changed from: protected */
    public void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            JavaCalls.invokeMethod(mATabActivity, "onApplyThemeResource", new Class[]{Resources.Theme.class, Integer.TYPE, Boolean.TYPE}, new Object[]{paramTheme, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean)});
            return;
        }
        super.onApplyThemeResource(paramTheme, paramInt, paramBoolean);
    }

    public void onAttachedToWindow() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    public void onBackPressed() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            JavaCalls.invokeMethod(mATabActivity, "onChildTitleChanged", new Class[]{Activity.class, CharSequence.class}, new Object[]{paramActivity, paramCharSequence});
            return;
        }
        super.onChildTitleChanged(paramActivity, paramCharSequence);
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onConfigurationChanged(paramConfiguration);
        } else {
            super.onConfigurationChanged(paramConfiguration);
        }
    }

    public void onContentChanged() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    public boolean onContextItemSelected(MenuItem paramMenuItem) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onContextItemSelected(paramMenuItem);
        }
        return super.onContextItemSelected(paramMenuItem);
    }

    public void onContextMenuClosed(Menu paramMenu) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onContextMenuClosed(paramMenu);
        } else {
            super.onContextMenuClosed(paramMenu);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        LayoutInflaterModifier.clearLayoutCache();
        this.target = null;
        loadTargetActivity();
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onCreateBase(bundle);
            JavaCalls.invokeMethod(this.target, "onCreate", new Class[]{Bundle.class}, new Object[]{bundle});
            return;
        }
        super.onCreate(bundle);
    }

    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
        } else {
            super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
        }
    }

    public CharSequence onCreateDescription() {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.onCreateDescription();
        }
        return super.onCreateDescription();
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity == null) {
            return super.onCreateDialog(paramInt);
        }
        return (Dialog) JavaCalls.invokeMethod(mATabActivity, "onCreateDialog", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(paramInt)});
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onCreateOptionsMenu(menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onCreatePanelMenu(paramInt, paramMenu);
        }
        return super.onCreatePanelMenu(paramInt, paramMenu);
    }

    public View onCreatePanelView(int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onCreatePanelView(paramInt);
        }
        return super.onCreatePanelView(paramInt);
    }

    public boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onCreateThumbnail(paramBitmap, paramCanvas);
        }
        return super.onCreateThumbnail(paramBitmap, paramCanvas);
    }

    public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onCreateView(paramString, paramContext, paramAttributeSet);
        }
        return super.onCreateView(paramString, paramContext, paramAttributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onDestroyBase();
            JavaCalls.invokeMethod(this.target, "onDestroy", new Class[0], new Object[0]);
            return;
        }
        super.onDestroy();
    }

    public void onDetachedFromWindow() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onKeyDown(paramInt, paramKeyEvent);
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onKeyLongPress(paramInt, paramKeyEvent);
        }
        return super.onKeyLongPress(paramInt, paramKeyEvent);
    }

    public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
        }
        return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onKeyUp(paramInt, paramKeyEvent);
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    public void onLowMemory() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onMenuItemSelected(paramInt, paramMenuItem);
        }
        return super.onMenuItemSelected(paramInt, paramMenuItem);
    }

    public boolean onMenuOpened(int paramInt, Menu paramMenu) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onMenuOpened(paramInt, paramMenu);
        }
        return super.onMenuOpened(paramInt, paramMenu);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent paramIntent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            JavaCalls.invokeMethod(mATabActivity, PluginInvokerConstants.METHOD_ACTIVITY_ONNEWINTENT, new Class[]{Intent.class}, new Object[]{paramIntent});
            return;
        }
        super.onNewIntent(paramIntent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onOptionsItemSelected(paramMenuItem);
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onOptionsMenuClosed(Menu paramMenu) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onOptionsMenuClosed(paramMenu);
        } else {
            super.onOptionsMenuClosed(paramMenu);
        }
    }

    public void onPanelClosed(int paramInt, Menu paramMenu) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onPanelClosed(paramInt, paramMenu);
        } else {
            super.onPanelClosed(paramInt, paramMenu);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        LayoutInflaterModifier.clearLayoutCache();
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onPauseBase();
            JavaCalls.invokeMethod(this.target, "onPause", new Class[0], new Object[0]);
            return;
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle paramBundle) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onPostCreateBase(paramBundle);
            JavaCalls.invokeMethod(this.target, "onPostCreate", new Class[]{Bundle.class}, new Object[]{paramBundle});
            return;
        }
        super.onPostCreate(paramBundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onPostResumeBase();
            JavaCalls.invokeMethod(this.target, "onPostResume", new Class[0], new Object[0]);
            return;
        }
        super.onPostResume();
    }

    /* access modifiers changed from: protected */
    public void onPrepareDialog(int paramInt, Dialog paramDialog) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onPrepareDialog(paramInt, paramDialog);
        } else {
            super.onPrepareDialog(paramInt, paramDialog);
        }
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onPrepareOptionsMenu(paramMenu);
        }
        return super.onPrepareOptionsMenu(paramMenu);
    }

    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onPreparePanel(paramInt, paramView, paramMenu);
        }
        return super.onPreparePanel(paramInt, paramView, paramMenu);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onRestartBase();
            JavaCalls.invokeMethod(this.target, PluginInvokerConstants.METHOD_ACTIVITY_ONRESTART, new Class[0], new Object[0]);
            return;
        }
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle paramBundle) {
        if (paramBundle != null) {
            paramBundle.setClassLoader(getClassLoader());
        }
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            JavaCalls.invokeMethod(mATabActivity, "onRestoreInstanceState", new Class[]{Bundle.class}, new Object[]{paramBundle});
            return;
        }
        super.onRestoreInstanceState(paramBundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onResumeBase();
            JavaCalls.invokeMethod(this.target, PluginInvokerConstants.METHOD_ACTIVITY_ONRESUME, new Class[0], new Object[0]);
            return;
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle paramBundle) {
        if (paramBundle != null) {
            paramBundle.setClassLoader(getClassLoader());
        }
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            JavaCalls.invokeMethod(mATabActivity, "onSaveInstanceState", new Class[]{Bundle.class}, new Object[]{paramBundle});
            return;
        }
        super.onSaveInstanceState(paramBundle);
    }

    public boolean onSearchRequested() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onSearchRequested();
        }
        return super.onSearchRequested();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onStartBase();
            JavaCalls.invokeMethod(this.target, "onStart", new Class[0], new Object[0]);
            return;
        }
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onStopBase();
            JavaCalls.invokeMethod(this.target, "onStop", new Class[0], new Object[0]);
            return;
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence paramCharSequence, int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            JavaCalls.invokeMethod(mATabActivity, "onTitleChanged", new Class[]{CharSequence.class, Integer.TYPE}, new Object[]{paramCharSequence, Integer.valueOf(paramInt)});
            return;
        }
        super.onTitleChanged(paramCharSequence, paramInt);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onTouchEvent(paramMotionEvent);
        }
        return super.onTouchEvent(paramMotionEvent);
    }

    public boolean onTrackballEvent(MotionEvent paramMotionEvent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.onTrackballEvent(paramMotionEvent);
        }
        return super.onTrackballEvent(paramMotionEvent);
    }

    public void onUserInteraction() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onWindowAttributesChanged(paramLayoutParams);
        } else {
            super.onWindowAttributesChanged(paramLayoutParams);
        }
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onWindowFocusChanged(paramBoolean);
        } else {
            super.onWindowFocusChanged(paramBoolean);
        }
    }

    public void openContextMenu(View paramView) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.openContextMenu(paramView);
        } else {
            super.openContextMenu(paramView);
        }
    }

    public void openOptionsMenu() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    public void overridePendingTransition(int paramInt1, int paramInt2) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.overridePendingTransition(paramInt1, paramInt2);
        } else {
            super.overridePendingTransition(paramInt1, paramInt2);
        }
    }

    public void proxyAddContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        super.addContentView(paramView, paramLayoutParams);
    }

    public boolean proxyBindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt) {
        return super.bindService(paramIntent, paramServiceConnection, paramInt);
    }

    public void proxyCloseContextMenu() {
        super.closeContextMenu();
    }

    public void proxyCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    public PendingIntent proxyCreatePendingResult(int paramInt1, Intent paramIntent, int paramInt2) {
        return super.createPendingResult(paramInt1, paramIntent, paramInt2);
    }

    public boolean proxyDispatchKeyEvent(KeyEvent paramKeyEvent) {
        return super.dispatchKeyEvent(paramKeyEvent);
    }

    public boolean proxyDispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }

    public boolean proxyDispatchTouchEvent(MotionEvent paramMotionEvent) {
        return super.dispatchTouchEvent(paramMotionEvent);
    }

    public boolean proxyDispatchTrackballEvent(MotionEvent paramMotionEvent) {
        return super.dispatchTrackballEvent(paramMotionEvent);
    }

    public View proxyFindViewById(int paramInt) {
        return super.findViewById(paramInt);
    }

    public void proxyFinish() {
        super.finish();
    }

    public void proxyFinishActivity(int paramInt) {
        super.finishActivity(paramInt);
    }

    public void proxyFinishActivityFromChild(Activity paramActivity, int paramInt) {
        super.finishActivityFromChild(paramActivity, paramInt);
    }

    public void proxyFinishFromChild(Activity paramActivity) {
        super.finishFromChild(paramActivity);
    }

    public ComponentName proxyGetCallingActivity() {
        return null;
    }

    public String proxyGetCallingPackage() {
        return super.getCallingPackage();
    }

    public int proxyGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public View proxyGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    public Intent proxyGetIntent() {
        return super.getIntent();
    }

    public Object proxyGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    public LayoutInflater proxyGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    public String proxyGetLocalClassName() {
        return super.getLocalClassName();
    }

    public MenuInflater proxyGetMenuInflater() {
        return super.getMenuInflater();
    }

    public PackageManager proxyGetPackageManager() {
        return super.getPackageManager();
    }

    public SharedPreferences proxyGetPreferences(int paramInt) {
        return super.getPreferences(paramInt);
    }

    public int proxyGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    public Object proxyGetSystemService(String paramString) {
        return super.getSystemService(paramString);
    }

    public int proxyGetTaskId() {
        return super.getTaskId();
    }

    public int proxyGetWallpaperDesiredMinimumHeight() {
        return super.getWallpaperDesiredMinimumHeight();
    }

    public int proxyGetWallpaperDesiredMinimumWidth() {
        return super.getWallpaperDesiredMinimumWidth();
    }

    public Window proxyGetWindow() {
        return super.getWindow();
    }

    public WindowManager proxyGetWindowManager() {
        return super.getWindowManager();
    }

    public boolean proxyHasWindowFocus() {
        return super.hasWindowFocus();
    }

    public boolean proxyIsFinishing() {
        return super.isFinishing();
    }

    public boolean proxyIsTaskRoot() {
        return super.isTaskRoot();
    }

    public boolean proxyMoveTaskToBack(boolean paramBoolean) {
        return super.moveTaskToBack(paramBoolean);
    }

    public void proxyOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void proxyOnApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean) {
        super.onApplyThemeResource(paramTheme, paramInt, paramBoolean);
    }

    public void proxyOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void proxyOnBackPressed() {
        super.onBackPressed();
    }

    public void proxyOnChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence) {
        super.onChildTitleChanged(paramActivity, paramCharSequence);
    }

    public void proxyOnConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
    }

    public void proxyOnContentChanged() {
        super.onContentChanged();
    }

    public boolean proxyOnContextItemSelected(MenuItem paramMenuItem) {
        return super.onContextItemSelected(paramMenuItem);
    }

    public void proxyOnContextMenuClosed(Menu paramMenu) {
        super.onContextMenuClosed(paramMenu);
    }

    public void proxyOnCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public void proxyOnCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    }

    public boolean proxyOnCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean proxyOnCreatePanelMenu(int paramInt, Menu paramMenu) {
        return super.onCreatePanelMenu(paramInt, paramMenu);
    }

    public boolean proxyOnCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas) {
        return super.onCreateThumbnail(paramBitmap, paramCanvas);
    }

    public void proxyOnDestroy() {
        super.onDestroy();
    }

    public void proxyOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public boolean proxyOnKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public boolean proxyOnKeyLongPress(int paramInt, KeyEvent paramKeyEvent) {
        return super.onKeyLongPress(paramInt, paramKeyEvent);
    }

    public boolean proxyOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent) {
        return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    }

    public boolean proxyOnKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    public void proxyOnLowMemory() {
        super.onLowMemory();
    }

    public boolean proxyOnMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        return super.onMenuItemSelected(paramInt, paramMenuItem);
    }

    public boolean proxyOnMenuOpened(int paramInt, Menu paramMenu) {
        return super.onMenuOpened(paramInt, paramMenu);
    }

    public boolean proxyOnOptionsItemSelected(MenuItem paramMenuItem) {
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void proxyOnOptionsMenuClosed(Menu paramMenu) {
        super.onOptionsMenuClosed(paramMenu);
    }

    public void proxyOnPanelClosed(int paramInt, Menu paramMenu) {
        super.onPanelClosed(paramInt, paramMenu);
    }

    public void proxyOnPause() {
        super.onPause();
    }

    public void proxyOnPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
    }

    public void proxyOnPostResume() {
        super.onPostResume();
    }

    public void proxyOnPrepareDialog(int paramInt, Dialog paramDialog) {
        super.onPrepareDialog(paramInt, paramDialog);
    }

    public boolean proxyOnPrepareOptionsMenu(Menu paramMenu) {
        return super.onPrepareOptionsMenu(paramMenu);
    }

    public boolean proxyOnPreparePanel(int paramInt, View paramView, Menu paramMenu) {
        return super.onPreparePanel(paramInt, paramView, paramMenu);
    }

    public void proxyOnRestart() {
        super.onRestart();
    }

    public void proxyOnRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
    }

    public void proxyOnResume() {
        super.onResume();
    }

    public Object proxyOnRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }

    public void proxyOnSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
    }

    public boolean proxyOnSearchRequested() {
        return super.onSearchRequested();
    }

    public void proxyOnStart() {
        super.onStart();
    }

    public void proxyOnStop() {
        super.onStop();
    }

    public void proxyOnTitleChanged(CharSequence paramCharSequence, int paramInt) {
        super.onTitleChanged(paramCharSequence, paramInt);
    }

    public boolean proxyOnTouchEvent(MotionEvent paramMotionEvent) {
        return super.onTouchEvent(paramMotionEvent);
    }

    public boolean proxyOnTrackballEvent(MotionEvent paramMotionEvent) {
        return super.onTrackballEvent(paramMotionEvent);
    }

    public void proxyOnUserInteraction() {
        super.onUserInteraction();
    }

    public void proxyOnWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams) {
        super.onWindowAttributesChanged(paramLayoutParams);
    }

    public void proxyOnWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
    }

    public void proxyOpenContextMenu(View paramView) {
        super.openContextMenu(paramView);
    }

    public void proxyOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    public void proxyOverridePendingTransition(int paramInt1, int paramInt2) {
        super.overridePendingTransition(paramInt1, paramInt2);
    }

    public void proxyRegisterForContextMenu(View paramView) {
        super.registerForContextMenu(paramView);
    }

    public void proxySetContentView(int paramInt) {
        super.setContentView(paramInt);
    }

    public void proxySetContentView(View paramView) {
        super.setContentView(paramView);
    }

    public void proxySetContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        super.setContentView(paramView, paramLayoutParams);
    }

    public void proxySetIntent(Intent paramIntent) {
        super.setIntent(paramIntent);
    }

    public void proxySetRequestedOrientation(int paramInt) {
        super.setRequestedOrientation(paramInt);
    }

    public void proxySetTitle(int paramInt) {
        super.setTitle(paramInt);
    }

    public void proxySetTitle(CharSequence paramCharSequence) {
        super.setTitle(paramCharSequence);
    }

    public void proxySetTitleColor(int paramInt) {
        super.setTitleColor(paramInt);
    }

    public void proxySetVisible(boolean paramBoolean) {
        super.setVisible(paramBoolean);
    }

    public void proxyStartActivity(Intent paramIntent) {
        super.startActivity(paramIntent);
    }

    public void proxyStartActivityForResult(Intent paramIntent, int paramInt) {
        super.startActivityForResult(paramIntent, paramInt);
    }

    public void proxyStartActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt) {
        super.startActivityFromChild(paramActivity, paramIntent, paramInt);
    }

    public boolean proxyStartActivityIfNeeded(Intent paramIntent, int paramInt) {
        return super.startActivityIfNeeded(paramIntent, paramInt);
    }

    public void proxyStartIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3) throws IntentSender.SendIntentException {
        super.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
    }

    public void proxyStartIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
    }

    public void proxyStartIntentSenderFromChild(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(paramActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
    }

    public void proxyStartManagingCursor(Cursor paramCursor) {
        super.startManagingCursor(paramCursor);
    }

    public boolean proxyStartNextMatchingActivity(Intent paramIntent) {
        return super.startNextMatchingActivity(paramIntent);
    }

    public void proxyStartSearch(String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2) {
        super.startSearch(paramString, paramBoolean1, paramBundle, paramBoolean2);
    }

    public ComponentName proxyStartService(Intent paramIntent) {
        return super.startService(paramIntent);
    }

    public void proxyStopManagingCursor(Cursor paramCursor) {
        super.stopManagingCursor(paramCursor);
    }

    public boolean proxyStopService(Intent paramIntent) {
        return super.stopService(paramIntent);
    }

    public void proxyTakeKeyEvents(boolean paramBoolean) {
        super.takeKeyEvents(paramBoolean);
    }

    public void proxyUnregisterForContextMenu(View paramView) {
        super.unregisterForContextMenu(paramView);
    }

    public void registerForContextMenu(View paramView) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.registerForContextMenu(paramView);
        } else {
            super.registerForContextMenu(paramView);
        }
    }

    public void setContentView(int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setContentView(paramInt);
        } else {
            super.setContentView(paramInt);
        }
    }

    public void setContentView(View paramView) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setContentView(paramView);
        } else {
            super.setContentView(paramView);
        }
    }

    public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setContentView(paramView, paramLayoutParams);
        } else {
            super.setContentView(paramView, paramLayoutParams);
        }
    }

    public void setIntent(Intent paramIntent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setIntent(paramIntent);
        } else {
            super.setIntent(paramIntent);
        }
    }

    public void setRequestedOrientation(int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setRequestedOrientation(paramInt);
        } else {
            super.setRequestedOrientation(paramInt);
        }
    }

    public Resources.Theme getTheme() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getTheme();
        }
        return super.getTheme();
    }

    public void setTheme(int resid) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setTheme(resid);
        } else {
            super.setTheme(resid);
        }
    }

    public void setTitle(int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setTitle(paramInt);
        } else {
            super.setTitle(paramInt);
        }
    }

    public void setTitle(CharSequence paramCharSequence) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setTitle(paramCharSequence);
        } else {
            super.setTitle(paramCharSequence);
        }
    }

    public void setTitleColor(int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setTitleColor(paramInt);
        } else {
            super.setTitleColor(paramInt);
        }
    }

    public void setVisible(boolean paramBoolean) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.setVisible(paramBoolean);
        } else {
            super.setVisible(paramBoolean);
        }
    }

    public void startActivity(Intent paramIntent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.startActivity(paramIntent);
        } else {
            super.startActivity(paramIntent);
        }
    }

    public void startActivityForResult(Intent paramIntent, int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.startActivityForResult(paramIntent, paramInt);
        } else {
            super.startActivityForResult(paramIntent, paramInt);
        }
    }

    public void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.startActivityFromChild(paramActivity, paramIntent, paramInt);
        } else {
            super.startActivityFromChild(paramActivity, paramIntent, paramInt);
        }
    }

    public boolean startActivityIfNeeded(Intent paramIntent, int paramInt) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.startActivityIfNeeded(paramIntent, paramInt);
        }
        return super.startActivityIfNeeded(paramIntent, paramInt);
    }

    public void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3) throws IntentSender.SendIntentException {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
        } else {
            super.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
        }
    }

    public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4) throws IntentSender.SendIntentException {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
        } else {
            super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
        }
    }

    public void startManagingCursor(Cursor paramCursor) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.startManagingCursor(paramCursor);
        } else {
            super.startManagingCursor(paramCursor);
        }
    }

    public boolean startNextMatchingActivity(Intent paramIntent) {
        MAActivity localIASFragmentActivity = this.target;
        if (localIASFragmentActivity != null) {
            return localIASFragmentActivity.startNextMatchingActivity(paramIntent);
        }
        return super.startNextMatchingActivity(paramIntent);
    }

    public void startSearch(String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.startSearch(paramString, paramBoolean1, paramBundle, paramBoolean2);
        } else {
            super.startSearch(paramString, paramBoolean1, paramBundle, paramBoolean2);
        }
    }

    public ComponentName startService(Intent paramIntent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.startService(paramIntent);
        }
        return super.startService(paramIntent);
    }

    public void stopManagingCursor(Cursor paramCursor) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.stopManagingCursor(paramCursor);
        } else {
            super.stopManagingCursor(paramCursor);
        }
    }

    public boolean stopService(Intent paramIntent) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.stopService(paramIntent);
        }
        return super.stopService(paramIntent);
    }

    public void takeKeyEvents(boolean paramBoolean) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.takeKeyEvents(paramBoolean);
        } else {
            super.takeKeyEvents(paramBoolean);
        }
    }

    public void unregisterForContextMenu(View paramView) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.unregisterForContextMenu(paramView);
        } else {
            super.unregisterForContextMenu(paramView);
        }
    }

    public MAActivity getMAActivity() {
        return this.target;
    }

    public void proxySetFinishOnTouchOutside(boolean finish) {
        super.setFinishOnTouchOutside(finish);
    }

    public Intent proxyRegisterReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return super.registerReceiver(receiver, filter);
    }

    public void proxyUnregisterReceiver(BroadcastReceiver receiver) {
        try {
            super.unregisterReceiver(receiver);
        } catch (IllegalArgumentException e2) {
            if (MegUtils.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    public MAActivity getTarget() {
        return this.target;
    }

    public SharedPreferences proxyGetSharedPreferences(String name, int mode) {
        return super.getSharedPreferences(name, mode);
    }

    public Context getApplicationContext() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            return mATabActivity.getApplicationContext();
        }
        return super.getApplicationContext();
    }

    public Context proxyGetApplicationContext() {
        return super.getApplicationContext();
    }

    public ActivityGroup getActivityGroup() {
        return this;
    }

    public Activity proxyGetCurrentActivity() {
        return super.getCurrentActivity();
    }

    public TabHost getTabHost() {
        return this.target.getTabHost();
    }

    public TabHost proxyGetTabHost() {
        return super.getTabHost();
    }

    public TabWidget getTabWidget() {
        return this.target.getTabWidget();
    }

    public TabWidget proxyGetTabWidget() {
        return super.getTabWidget();
    }

    public void setDefaultTab(int index) {
        this.target.setDefaultTab(index);
    }

    public void proxySetDefaultTab(int paramInt) {
        super.setDefaultTab(paramInt);
    }

    public void setDefaultTab(String tag) {
        this.target.setDefaultTab(tag);
    }

    public void proxySetDefaultTab(String paramString) {
        super.setDefaultTab(paramString);
    }

    public int proxyCheckSelfPermission(String permission) {
        if (Build.VERSION.SDK_INT >= 23) {
            return super.checkSelfPermission(permission);
        }
        return 0;
    }

    public void proxyRequestPermission(final String[] permissions, final int requestCode) {
        if (Build.VERSION.SDK_INT >= 23) {
            super.requestPermissions(permissions, requestCode);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] grantResults = new int[permissions.length];
                    PackageManager packageManager = TabActivityProxy.this.getPackageManager();
                    String packageName = TabActivityProxy.this.getPackageName();
                    int permissionCount = permissions.length;
                    for (int i2 = 0; i2 < permissionCount; i2++) {
                        grantResults[i2] = packageManager.checkPermission(permissions[i2], packageName);
                    }
                    TabActivityProxy.this.onRequestPermissionsResult(requestCode, permissions, grantResults);
                }
            });
        }
    }

    public boolean proxyShouldShowRequestPermissionRationale(String permission) {
        if (Build.VERSION.SDK_INT >= 23) {
            return super.shouldShowRequestPermissionRationale(permission);
        }
        return false;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onRequestPermissionsResult(requestCode, permissions, grantResults);
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public boolean proxyIsInMultiWindowMode() {
        if (Build.VERSION.SDK_INT >= 24) {
            return super.isInMultiWindowMode();
        }
        return false;
    }

    public boolean proxyIsInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 24) {
            return super.isInPictureInPictureMode();
        }
        return false;
    }

    public void proxyEnterPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 24) {
            super.enterPictureInPictureMode();
        }
    }

    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onMultiWindowModeChanged(isInMultiWindowMode);
        } else {
            super.onMultiWindowModeChanged(isInMultiWindowMode);
        }
    }

    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onPictureInPictureModeChanged(isInPictureInPictureMode);
        } else {
            super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        }
    }

    public boolean proxyIsLocalVoiceInteractionSupported() {
        if (Build.VERSION.SDK_INT >= 24) {
            return super.isLocalVoiceInteractionSupported();
        }
        return false;
    }

    public void proxyStartLocalVoiceInteraction(Bundle privateOptions) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.startLocalVoiceInteraction(privateOptions);
        }
    }

    public void proxyStopLocalVoiceInteraction() {
        if (Build.VERSION.SDK_INT >= 24) {
            super.stopLocalVoiceInteraction();
        }
    }

    public void onLocalVoiceInteractionStarted() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onLocalVoiceInteractionStarted();
        } else {
            super.onLocalVoiceInteractionStarted();
        }
    }

    public void onLocalVoiceInteractionStopped() {
        MATabActivity mATabActivity = this.target;
        if (mATabActivity != null) {
            mATabActivity.onLocalVoiceInteractionStopped();
        } else {
            super.onLocalVoiceInteractionStopped();
        }
    }

    public void proxySetVrModeEnabled(boolean enabled, ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setVrModeEnabled(enabled, requestedComponent);
        }
    }

    public ContentResolver proxyGetContentResolver() {
        return new ContentResolver(getApplicationContext(), getContentResolver(), this.mPackageName);
    }
}
