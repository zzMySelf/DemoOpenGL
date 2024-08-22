package com.baidu.searchbox.wordscommand.runtime;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.searchbox.wordscommand.data.CommandContent;
import com.baidu.searchbox.wordscommand.listener.PictureCommandInvokeCallBack;

public interface IWordCommandApp {
    public static final IWordCommandApp EMPTY = new IWordCommandApp() {
        public void getPictureCommandContent(String imagePath, PictureCommandInvokeCallBack callBack) {
        }

        public void handlePreloadSwanApp() {
        }

        public boolean canPreloadSwanApp(String wordCommand) {
            return false;
        }

        public boolean isNewInstall() {
            return false;
        }

        public void doOnShowParseCommandDialogWithPopupExclusion(Context context, CommandContent commandContent) {
            WordCommandManager.getInstance().doOnShowParseCommandDialog(context, commandContent, new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                }
            }, new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialog) {
                }
            });
        }

        public void schemeInvoke(String scheme) {
        }

        public boolean isMainProcess() {
            return true;
        }
    };
    public static final String LOG_TAG = "IWordCommandApp";

    boolean canPreloadSwanApp(String str);

    void doOnShowParseCommandDialogWithPopupExclusion(Context context, CommandContent commandContent);

    void getPictureCommandContent(String str, PictureCommandInvokeCallBack pictureCommandInvokeCallBack);

    void handlePreloadSwanApp();

    boolean isMainProcess();

    boolean isNewInstall();

    void schemeInvoke(String str);

    public static final class Impl {
        private static IWordCommandApp sWordCommandApp = WordCommandRuntime.getWordCommandApp();

        private Impl() {
        }

        public static IWordCommandApp get() {
            if (sWordCommandApp == null) {
                Log.w(IWordCommandApp.LOG_TAG, "Fetch IWordCommandApp implementation failed, IWordCommandApp.EMPTY applied");
                sWordCommandApp = IWordCommandApp.EMPTY;
            }
            return sWordCommandApp;
        }
    }
}
