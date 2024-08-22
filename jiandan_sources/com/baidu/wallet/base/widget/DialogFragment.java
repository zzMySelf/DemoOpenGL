package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.widget.dialog.listener.DelegateOnCancleListener;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.BaseFragment;
import com.baidu.wallet.core.beans.BeanErrorContent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import java.util.Objects;

public class DialogFragment extends BaseFragment implements IBeanResponseCallback {
    public static final int DIALOG_NO_NETWORK = 3851;
    public static final int DIALOG_PROMPT = 3843;
    public static final int DIALOG_WAIT_S0 = 0;
    public static final int DIALOG_WAIT_S1 = -1;
    public static final int DIALOG_WAIT_S2 = -2;
    public static final String TAG = "DialogFragment";
    public String mDialogMsg = "";

    public void cancleRequest() {
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i3 == 5003) {
            BaseActivity baseActivity = this.mAct;
            GlobalUtils.toast(baseActivity, ResUtils.getString(baseActivity, "wallet_base_please_login"));
            AccountManager.getInstance(this.mAct).logout();
            WalletLoginHelper.getInstance().logout(false);
        } else if (i3 == -2) {
            BaseActivity baseActivity2 = this.mAct;
            GlobalUtils.toast(baseActivity2, ResUtils.getString(baseActivity2, "fp_get_data_fail"));
        } else if (i3 == -3) {
            BaseActivity baseActivity3 = this.mAct;
            GlobalUtils.toast(baseActivity3, ResUtils.getString(baseActivity3, "fp_get_data_fail"));
        } else if (i3 == -4) {
            BaseActivity baseActivity4 = this.mAct;
            GlobalUtils.toast(baseActivity4, ResUtils.getString(baseActivity4, "fp_get_data_fail"));
        } else if (i3 == -8) {
            WalletGlobalUtils.safeShowDialog(this.mAct, DIALOG_NO_NETWORK, "");
        } else {
            this.mDialogMsg = str;
            if (TextUtils.isEmpty(str)) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "fp_get_data_fail");
            }
            GlobalUtils.toast(getActivity(), this.mDialogMsg);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void initActionBar(View view, String str) {
        BdActionBar bdActionBar = (BdActionBar) view.findViewById(ResUtils.id(this.mAct, "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(ResUtils.string(this.mAct, str));
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(DialogFragment.this.mAct.getActivity());
                    DialogFragment.this.finish();
                }
            });
        }
    }

    public void initHomeActionBar(View view, String str) {
        BdActionBar bdActionBar = (BdActionBar) view.findViewById(ResUtils.id(this.mAct, "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(ResUtils.string(this.mAct, str));
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(DialogFragment.this.mAct.getActivity());
                    DialogFragment.this.finish();
                }
            });
        }
    }

    public void onBeanExecFailure(final int i2, final int i3, final String str) {
        LogUtil.i("BeanActivity", "onBeanExecFailure. bean id = " + i2 + ", err code = " + i3 + ", err msg = " + str);
        BaseActivity baseActivity = this.mAct;
        if (baseActivity != null) {
            baseActivity.runOnUiThread(new Runnable() {
                public void run() {
                    if (DialogFragment.this.mAct != null) {
                        DialogFragment.this.handleFailure(i2, i3, str);
                    }
                }
            });
        }
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        handleFailure(i2, i3, str);
    }

    public void onBeanExecSuccess(final int i2, final Object obj, final String str) {
        BaseActivity baseActivity = this.mAct;
        if (baseActivity != null) {
            baseActivity.runOnUiThread(new Runnable() {
                public void run() {
                    if (DialogFragment.this.mAct != null) {
                        DialogFragment.this.handleResponse(i2, obj, str);
                    }
                }
            });
        }
    }

    public Dialog onCreateDialog(int i2) {
        LogUtil.d(TAG, "onCreateDalog. id = " + i2);
        if (i2 == -2 || i2 == -1 || i2 == 0) {
            return new LoadingDialog(this.mAct);
        }
        return new PromptDialog(this.mAct);
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && event.mEventKey.equals("ev_bean_execut_err_content")) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    public void onPause() {
        super.onPause();
        EventBus.getInstance().unregister((Object) this, "ev_bean_execut_err_content");
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        LogUtil.d(TAG, "onPrepareDialog. id = " + i2);
        if (i2 == -2) {
            LoadingDialog loadingDialog = (LoadingDialog) dialog;
            loadingDialog.setCancelable(true);
            loadingDialog.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    DialogFragment.this.cancleRequest();
                }
            }, loadingDialog));
        } else if (i2 == -1) {
            LoadingDialog loadingDialog2 = (LoadingDialog) dialog;
            loadingDialog2.setCancelable(true);
            loadingDialog2.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    if (DialogFragment.this.mAct != null) {
                        DialogFragment.this.mAct.onBackPressed();
                    }
                }
            }, loadingDialog2));
        } else if (i2 == 0) {
            ((LoadingDialog) dialog).setCancelable(false);
        } else if (i2 == 3851) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) getString(ResUtils.string(this.mAct, "ebpay_no_network")));
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setNegativeBtn(ResUtils.string(this.mAct, "ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(DialogFragment.this.mAct, DialogFragment.DIALOG_NO_NETWORK);
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(this.mAct, "ebpay_setting"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(DialogFragment.this.mAct, DialogFragment.DIALOG_NO_NETWORK);
                    try {
                        DialogFragment.this.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        EventBus.getInstance().register((Object) this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
    }

    public void postEvent(String str, Object obj) {
        EventBus instance = EventBus.getInstance();
        Objects.requireNonNull(instance);
        instance.post(new EventBus.Event(str, obj));
    }
}
