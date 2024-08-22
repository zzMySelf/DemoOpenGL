package com.baidu.searchbox.tools.develop.provider.basicinfo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.io.FileUtils;
import com.baidu.disasterrecovery.jnicrash.NativeCrashCapture;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.plugins.reader.ReaderPluginConstants;
import com.baidu.searchbox.ruka.Ruka;
import com.baidu.searchbox.tools.develop.DevelopRuntime;
import com.baidu.voyager.impl.constant.VoyagerConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpOptProvider extends DebugDataGroupProvider {
    private View.OnClickListener mAnrListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (Ruka.isLooperMonitorStarted()) {
                Intent intent = new Intent("com.baidu.searchbox.action.BaiduBlockCanary");
                intent.setFlags(335544320);
                intent.addCategory(ReaderPluginConstants.CATEGORY_DEFAULT);
                v.getContext().startActivity(intent);
            }
        }
    };
    private View.OnClickListener mExpJavaCrashListener = new View.OnClickListener() {
        public void onClick(View v) {
            throw new RuntimeException("make crash");
        }
    };
    private View.OnClickListener mExpNativeCrashListener = new View.OnClickListener() {
        public void onClick(View v) {
            NativeCrashCapture.makeCrash();
        }
    };
    private View.OnClickListener mExpOptCatchListener = new View.OnClickListener() {
        public void onClick(View v) {
            new BoxAlertDialog.Builder(v.getContext()).setTitle((CharSequence) "异常捕获检测").setMessage("这是一个针对插件的异常捕获检测小\n功能,目的是防止部分插件跟框应用在相同进程时增加了全局捕获从而导致部分异常不能正常通过MTJ反应出来的情况;\n检测后若出现闪退现象则认为是有插件全局捕获了不可处理的异常,\n若出现FC则认为没有插件全局捕获异常.").setPositiveButton((CharSequence) "检测", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    throw new NullPointerException("this is a debug test of the exception.");
                }
            }).setNegativeButton((CharSequence) AccountConstants.PROFESSION_APPROVE_DIALOG_CANCEL_TITLE_DEFAULT, (DialogInterface.OnClickListener) null).create().show();
        }
    };
    private View.OnClickListener mExpOptCatchSavedListener = new View.OnClickListener() {
        public void onClick(View arg0) {
            final String logName = "searchbox_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + VoyagerConstant.VOYAGER_FILE_META_SUFFIX;
            final Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    if (msg.what == 1) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "存储/sdcard/baidu/" + logName + "目录下成功!").showToast();
                    }
                }
            };
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                /* Debug info: failed to restart local var, previous not found, register: 10 */
                public void run() {
                    InputStream inputstream;
                    FileOutputStream os;
                    try {
                        String filepath = "/sdcard/baidu/" + logName;
                        inputstream = null;
                        os = null;
                        InputStream inputstream2 = Runtime.getRuntime().exec("logcat -d -v time |grep searchbox > " + filepath).getInputStream();
                        if (inputstream2 != null) {
                            os = new FileOutputStream(new File(filepath));
                            if (FileUtils.copyStream(inputstream2, os) > 0) {
                                handler.sendEmptyMessage(1);
                            }
                        }
                        if (inputstream2 != null) {
                            inputstream2.close();
                        }
                        if (os != null) {
                            os.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    } catch (Throwable th2) {
                        if (inputstream != null) {
                            inputstream.close();
                        }
                        if (os != null) {
                            os.close();
                        }
                        throw th2;
                    }
                }
            }, "saveLogToSdcardThread", 3);
        }
    };
    private View.OnClickListener mLargeBitmapDetectListener = new View.OnClickListener() {
        public void onClick(View v) {
            DevelopRuntime.getDevelopContext().onLargeBitmapDetect();
        }
    };
    private View.OnClickListener mMakeAnrListener = new View.OnClickListener() {
        public void onClick(View v) {
            try {
                Thread.sleep(10000);
            } catch (Exception e2) {
            }
        }
    };
    private View.OnClickListener mXPosedActivityListener = new View.OnClickListener() {
        public void onClick(View v) {
            DevelopRuntime.getDevelopContext().onXPosedActivity();
        }
    };
    private View.OnClickListener mXPosedMemoryListener = new View.OnClickListener() {
        public void onClick(View v) {
            DevelopRuntime.getDevelopContext().onXPosedMemory();
        }
    };

    public String getGroupName() {
        return "异常操作";
    }

    public List<DebugItemInfo> getChildItemList() {
        return getConfigFileInfo();
    }

    private List<DebugItemInfo> getConfigFileInfo() {
        List<DebugItemInfo> itemInfos = new ArrayList<>();
        itemInfos.add(new TextItemInfo((String) null, "查看ANR", this.mAnrListener));
        itemInfos.add(new TextItemInfo((String) null, "触发ANR", this.mMakeAnrListener));
        itemInfos.add(new TextItemInfo((String) null, "抛Java Crash", this.mExpJavaCrashListener));
        itemInfos.add(new TextItemInfo((String) null, "抛Native Crash", this.mExpNativeCrashListener));
        itemInfos.add(new TextItemInfo((String) null, "异常捕获检测", this.mExpOptCatchListener));
        itemInfos.add(new TextItemInfo((String) null, "存储log至本地", this.mExpOptCatchSavedListener));
        itemInfos.add(new TextItemInfo((String) null, "内存图片浏览", this.mXPosedMemoryListener));
        itemInfos.add(new TextItemInfo((String) null, "内存Activity浏览", this.mXPosedActivityListener));
        itemInfos.add(new TextItemInfo((String) null, "大图监测配置", this.mLargeBitmapDetectListener));
        return itemInfos;
    }
}
