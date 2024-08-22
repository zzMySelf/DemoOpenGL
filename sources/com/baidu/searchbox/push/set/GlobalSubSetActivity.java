package com.baidu.searchbox.push.set;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.MessageStatisticUtils;
import com.baidu.searchbox.appframework.ActionToolBarActivity;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.ng.errorview.view.NetworkErrorView;
import com.baidu.searchbox.pad.MessagePadAdapter;
import com.baidu.searchbox.plugins.helper.IMPluginHelper;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.push.set.GlobalSubRejectAdapter;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.unifiedtoolbar.option.BottomBarOptionFloatingBack;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class GlobalSubSetActivity extends ActionToolBarActivity {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    private static final int SOURCE_SHIELD_LIST_PAGE = 3;
    private static final String TAG = "GlobalSubSetActivity";
    /* access modifiers changed from: private */
    public boolean isLoading = false;
    private GlobalSubRejectAdapter.IItemClickListener itemClickListener = new GlobalSubRejectAdapter.IItemClickListener() {
        public void onClick(ChatSession session) {
            if (session != null) {
                try {
                    JSONObject paramsJSONStr = new JSONObject();
                    paramsJSONStr.put("contactor_id", session.getContacter());
                    paramsJSONStr.put("contactor_uid", session.getContacterId());
                    paramsJSONStr.put("contactor_type", session.getChatType());
                    paramsJSONStr.put("source", 3);
                    paramsJSONStr.put("contactor_name", session.getNickName());
                    if (GlobalSubSetActivity.DEBUG) {
                        Log.d(GlobalSubSetActivity.TAG, "open shield activity params: " + paramsJSONStr.toString());
                    }
                    IMPluginHelper.startShieldSetting(paramsJSONStr.toString(), (IMPluginHelper.Callback) null);
                } catch (Exception e2) {
                    if (GlobalSubSetActivity.DEBUG) {
                        Log.e(GlobalSubSetActivity.TAG, "invoke e:" + e2);
                    }
                }
            }
        }
    };
    private GlobalSubRejectAdapter mAdapter;
    private BdShimmerView mBdShimmerView;
    private View mContainerView;
    private ImageView mEmptyImage;
    private TextView mEmptyText;
    private RecyclerView mRecyclerView;
    private NetworkErrorView mReloadLayout;
    private View mViewEmptyLayout;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_gloabl_sub);
        ActionBarExtKt.getBdActionBar(this).setTitle(R.string.message_global_reject_message);
        ActionBarExtKt.showActionBarWithoutLeft(this);
        setEnableSliding(true);
        initView();
        updateTheme();
        this.isLoading = false;
        this.mAdapter.addUserShieldStatistic((ChatSession) null, "show", MessageStatisticUtils.VALUE_USER_SHIELD_SETTINGD_OFF);
    }

    public void onFontSizeChange() {
        super.onFontSizeChange();
        ImageView imageView = this.mEmptyImage;
        if (imageView != null) {
            FontSizeImageViewExtKt.setScaledImageDrawableRes(imageView, 0, R.drawable.message_global_sub_empty_view_portrait);
        }
        TextView textView = this.mEmptyText;
        if (textView != null) {
            FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.message_dimens_14dp);
        }
    }

    private void startShimmerViewAnimation() {
        this.mBdShimmerView.setVisibility(0);
        this.mBdShimmerView.setType(1);
        this.mBdShimmerView.startShimmerAnimation();
    }

    /* access modifiers changed from: private */
    public void stopShimmerViewAnimation(GlobalSubSetActivity refActivity) {
        if (refActivity != null && refActivity.mBdShimmerView.getVisibility() == 0) {
            refActivity.mBdShimmerView.stopShimmerAnimation();
            refActivity.mBdShimmerView.setVisibility(8);
        }
    }

    private void initData() {
        if (!this.isLoading) {
            this.isLoading = true;
            GlobalSubRejectAdapter globalSubRejectAdapter = this.mAdapter;
            if (globalSubRejectAdapter != null && globalSubRejectAdapter.getDataSize() == 0) {
                startShimmerViewAnimation();
            }
            if (RequsetNetworkUtils.isConnected(MessageRuntime.getAppContext())) {
                getUserShieldList();
                return;
            }
            this.isLoading = false;
            stopShimmerViewAnimation(this);
            updateNetworkError(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initData();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MessagePadAdapter.setPaddingStartAndEnd(this, this.mContainerView, 125, 125);
    }

    private static class IMIGetUserShieldListener implements IGetUserShieldListener {
        /* access modifiers changed from: private */
        public WeakReference<GlobalSubSetActivity> mReference;

        private IMIGetUserShieldListener(GlobalSubSetActivity activity) {
            this.mReference = new WeakReference<>(activity);
        }

        public void onResult(final int errorCode, final String errorMessage, final List<ChatSession> shieldUsers) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    GlobalSubSetActivity refActivity;
                    if (IMIGetUserShieldListener.this.mReference != null && (refActivity = (GlobalSubSetActivity) IMIGetUserShieldListener.this.mReference.get()) != null) {
                        boolean unused = refActivity.isLoading = false;
                        refActivity.stopShimmerViewAnimation(refActivity);
                        if (errorCode == 0) {
                            List list = shieldUsers;
                            if (list == null || list.size() <= 0) {
                                refActivity.updateEmptyViewUI(refActivity);
                                return;
                            }
                            if (GlobalSubSetActivity.DEBUG) {
                                Log.d(GlobalSubSetActivity.TAG, "shield user result: " + shieldUsers);
                            }
                            refActivity.updateUI(refActivity.checkData(shieldUsers), refActivity);
                            return;
                        }
                        if (GlobalSubSetActivity.DEBUG) {
                            Log.d(GlobalSubSetActivity.TAG, "get shield user error! ErrorInfo: " + errorMessage);
                        }
                        refActivity.updateNetworkError(refActivity);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void getUserShieldList() {
        IMBoxManager.getUserShieldList(this, 3, new IMIGetUserShieldListener());
    }

    /* access modifiers changed from: private */
    public void updateUI(List<ChatSession> list, GlobalSubSetActivity refActivity) {
        if (refActivity != null) {
            if (list.size() <= 0) {
                refActivity.updateEmptyViewUI(refActivity);
            } else {
                refActivity.updateDataViewUI(list, refActivity);
            }
        }
    }

    public void updateDataViewUI(List<ChatSession> list, GlobalSubSetActivity refActivity) {
        if (refActivity != null) {
            refActivity.mViewEmptyLayout.setVisibility(8);
            refActivity.mReloadLayout.setVisibility(8);
            refActivity.mRecyclerView.setVisibility(0);
            refActivity.mAdapter.setData(list);
            onFontSizeChange();
        }
    }

    public void updateEmptyViewUI(GlobalSubSetActivity refActivity) {
        if (refActivity != null) {
            refActivity.mReloadLayout.setVisibility(8);
            refActivity.mViewEmptyLayout.setVisibility(0);
            refActivity.mRecyclerView.setVisibility(8);
            refActivity.mEmptyText.setText(R.string.message_setting_global_sub_reject_message_empty_text);
            onFontSizeChange();
        }
    }

    public void updateNetworkError(GlobalSubSetActivity refActivity) {
        if (refActivity != null) {
            refActivity.mReloadLayout.setVisibility(0);
            refActivity.mViewEmptyLayout.setVisibility(8);
            refActivity.mRecyclerView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public List<ChatSession> checkData(List<ChatSession> list) {
        if (list != null && list.size() > 0) {
            Iterator<ChatSession> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (TextUtils.isEmpty(iterator.next().getNickName())) {
                    iterator.remove();
                }
            }
        }
        return list;
    }

    private void initView() {
        View findViewById = findViewById(R.id.root);
        this.mContainerView = findViewById;
        MessagePadAdapter.setPaddingStartAndEnd(this, findViewById, 125, 125);
        this.mViewEmptyLayout = findViewById(R.id.empty_global_layout);
        this.mEmptyImage = (ImageView) findViewById(R.id.empty_global_image);
        this.mEmptyText = (TextView) findViewById(R.id.empty_global_text);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.global_reject_recycler);
        this.mBdShimmerView = (BdShimmerView) findViewById(R.id.global_reject_loading);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        GlobalSubRejectAdapter globalSubRejectAdapter = new GlobalSubRejectAdapter(this, this.itemClickListener);
        this.mAdapter = globalSubRejectAdapter;
        this.mRecyclerView.setAdapter(globalSubRejectAdapter);
        NetworkErrorView networkErrorView = (NetworkErrorView) findViewById(R.id.emptyview);
        this.mReloadLayout = networkErrorView;
        networkErrorView.setTitle(R.string.message_net_error);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mReloadLayout.mIcon.setImageDrawable(ResourcesCompat.getDrawable(MessageRuntime.getAppContext().getResources(), R.drawable.bd_im_wifi_icon, (Resources.Theme) null));
        }
        this.mReloadLayout.setReloadClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GlobalSubSetActivity.this.getUserShieldList();
            }
        });
        initBackView();
    }

    private void initBackView() {
        HashMap<String, Object> ext = new HashMap<>();
        ext.put(UnifiedTopBarButton.UBC_EXT_KEY_SECOND_PAGE, "im_set_block");
        UnifiedTopBarButton btn = getUnifiedTopBackButton();
        if (btn != null) {
            btn.ubcBackButtonShow("base", "im", ext);
        } else {
            MessageStatisticUtils.showStatisticUnifiedBackBar(this, "im_set_block");
        }
    }

    private void updateTheme() {
        if (!isFinishing() && this.mEmptyText != null && this.mEmptyImage != null) {
            ((LinearLayout) findViewById(R.id.root)).setBackgroundColor(MessageRuntime.getAppContext().getResources().getColor(R.color.message_setting_background));
            this.mEmptyText.setTextColor(MessageRuntime.getAppContext().getResources().getColor(R.color.message_setting_empty_view_text));
            this.mEmptyImage.setImageDrawable(ResourcesCompat.getDrawable(MessageRuntime.getAppContext().getResources(), R.drawable.message_global_sub_empty_view_portrait, (Resources.Theme) null));
        }
    }

    public static void launchGlobalSubSetActivity(Context context) {
        ActivityUtils.startActivitySafely(context, new Intent(context, GlobalSubSetActivity.class));
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_right, com.baidu.android.common.ui.style.R.anim.slide_out_to_left);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        updateTheme();
        GlobalSubRejectAdapter globalSubRejectAdapter = this.mAdapter;
        if (globalSubRejectAdapter != null) {
            globalSubRejectAdapter.notifyDataSetChanged();
        }
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        UnifiedBottomBarOption option = new BottomBarOptionFloatingBack();
        option.setHideBackWithTopBackExperiment(true);
        return option;
    }
}
