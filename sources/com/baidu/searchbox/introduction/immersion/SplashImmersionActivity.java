package com.baidu.searchbox.introduction.immersion;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.appframework.ActionBarBaseActivity;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.introduction.R;
import com.baidu.searchbox.introduction.SplashUtils;
import com.baidu.searchbox.introduction.data.SplashFileManager;
import com.baidu.searchbox.introduction.data.SplashPolicyRecorder;
import com.baidu.searchbox.introduction.data.SplashStyleRecorder;
import com.baidu.searchbox.introduction.immersion.SplashImmersionAdapter;
import com.baidu.searchbox.introduction.immersion.SplashImmersionLayoutManager;
import com.baidu.searchbox.introduction.view.ViewBuilderUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

public class SplashImmersionActivity extends ActionBarBaseActivity {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "SplashImmersionActivity";
    /* access modifiers changed from: private */
    public StringBuffer mAction;
    private SplashImmersionAdapter mAdapter;
    private TextView mBtnSkip;
    /* access modifiers changed from: private */
    public int mCurrentPosition = -1;
    private String mImmersionLottieStyle;
    private String mImmersionLottieUrl;
    private String mImmersionZipUrl;
    /* access modifiers changed from: private */
    public List<SplashImmersionData> mList = new ArrayList();
    /* access modifiers changed from: private */
    public LottieAnimationView mLottieView;
    private SplashImmersionLayoutManager mManager;
    private RecyclerView mRecyclerView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showActionBar(false);
        setEnableSliding(false);
        setEnableImmersion(false);
        getWindow().getDecorView().setSystemUiVisibility(1028);
        getWindow().addFlags(1024);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            lp.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(lp);
        }
        setContentView(R.layout.activity_splash_immersion);
        handleIntent();
        initData();
        if (this.mList == null) {
            BdEventBus.Companion.getDefault().post(new SplashImmersionEvent(1, -1, this.mAction));
            finish();
            return;
        }
        initView();
    }

    private void initView() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottie);
        this.mLottieView = lottieAnimationView;
        ViewBuilderUtil.setStyleNew(lottieAnimationView, SplashStyleRecorder.SplashElements.IMMERSION_LOTTIE, this.mImmersionLottieStyle, true);
        loadImmersionLottie();
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        TextView textView = (TextView) findViewById(R.id.splash_ad_btn_skip);
        this.mBtnSkip = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BdEventBus.Companion.getDefault().post(new SplashImmersionEvent(2, -1, SplashImmersionActivity.this.mAction));
                SplashImmersionActivity.this.finish();
            }
        });
        ViewBuilderUtil.setStyle(this.mBtnSkip, SplashStyleRecorder.SplashElements.SKIP, true);
        SplashImmersionLayoutManager splashImmersionLayoutManager = new SplashImmersionLayoutManager(this, 1);
        this.mManager = splashImmersionLayoutManager;
        this.mRecyclerView.setLayoutManager(splashImmersionLayoutManager);
        SplashImmersionAdapter splashImmersionAdapter = new SplashImmersionAdapter(this, this.mList, this.mImmersionZipUrl);
        this.mAdapter = splashImmersionAdapter;
        splashImmersionAdapter.setOnItemClickListener(new SplashImmersionAdapter.OnItemClickListener() {
            public void onItemClick(int position) {
                BdEventBus.Companion.getDefault().post(new SplashImmersionEvent(3, position, SplashImmersionActivity.this.mAction));
                SplashImmersionActivity.this.finish();
                if (SplashImmersionActivity.DEBUG) {
                    Log.d(SplashImmersionActivity.TAG, "onItemClick:" + position);
                }
            }
        });
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mManager.setOnViewPagerListener(new SplashImmersionLayoutManager.OnViewPagerListener() {
            public void onPageSelected(int position, boolean isTop, boolean isBottom, int dy) {
                if (SplashImmersionActivity.this.mCurrentPosition == 0 && position == 0 && dy < 0) {
                    if (SplashImmersionActivity.DEBUG) {
                        Log.d(SplashImmersionActivity.TAG, "finish to kp");
                    }
                    SplashImmersionActivity.this.mAction.append("_").append(position);
                    BdEventBus.Companion.getDefault().post(new SplashImmersionEvent(4, -1, SplashImmersionActivity.this.mAction));
                    SplashImmersionActivity.this.finish();
                    SplashImmersionActivity.this.overridePendingTransition(R.anim.ad_anim_splash_enter, R.anim.ad_anim_immersion_exit);
                } else if (SplashImmersionActivity.this.mCurrentPosition == SplashImmersionActivity.this.mList.size() - 1 && position == SplashImmersionActivity.this.mList.size() - 1 && dy > 0) {
                    if (SplashImmersionActivity.DEBUG) {
                        Log.d(SplashImmersionActivity.TAG, "jump to h5");
                    }
                    BdEventBus.Companion.getDefault().post(new SplashImmersionEvent(1, -1, SplashImmersionActivity.this.mAction));
                    SplashImmersionActivity.this.finish();
                } else {
                    SplashImmersionActivity.this.mAction.append("_").append(position + 1);
                }
                int unused = SplashImmersionActivity.this.mCurrentPosition = position;
                if (SplashImmersionActivity.DEBUG) {
                    Log.d(SplashImmersionActivity.TAG, "position:" + position + ";isTop:" + isTop + "; isBottom:" + isBottom);
                }
            }
        });
    }

    public void finish() {
        super.finish();
        SplashImmersionAdapter splashImmersionAdapter = this.mAdapter;
        if (splashImmersionAdapter != null) {
            splashImmersionAdapter.stopAllVideoDecoration();
        }
        BdEventBus.Companion.getDefault().unregister(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        SplashImmersionAdapter splashImmersionAdapter = this.mAdapter;
        if (splashImmersionAdapter != null) {
            splashImmersionAdapter.releaseAllVideoDecoration();
        }
    }

    private void handleIntent() {
        Intent intent = getIntent();
        this.mImmersionZipUrl = intent.getStringExtra("immersion_zip_url");
        this.mImmersionLottieUrl = intent.getStringExtra("immersion_lottie_url");
        String action = intent.getStringExtra("immersion_action");
        this.mImmersionLottieStyle = intent.getStringExtra("immersion_style");
        if (TextUtils.isEmpty(action)) {
            this.mAction = new StringBuffer("0");
        } else {
            this.mAction = new StringBuffer(action);
        }
    }

    private void initData() {
        File immersionData = new File(SplashFileManager.getInstance().getSplashSourceFile(this.mImmersionZipUrl).getAbsolutePath(), "data.json");
        this.mList = (List) new Gson().fromJson(SplashUtils.getFileContent(immersionData), new TypeToken<List<SplashImmersionData>>() {
        }.getType());
    }

    public void loadImmersionLottie() {
        File lottieFile = SplashFileManager.getInstance().getSplashSourceFile(this.mImmersionLottieUrl);
        if (lottieFile.exists()) {
            try {
                LottieCompositionFactory.fromZipStream(new ZipInputStream(new FileInputStream(lottieFile.getPath())), (String) null).addListener(new LottieListener<LottieComposition>() {
                    public void onResult(LottieComposition lottieComposition) {
                        if (lottieComposition != null) {
                            SplashImmersionActivity.this.mLottieView.setVisibility(0);
                            SplashImmersionActivity.this.mLottieView.setComposition(lottieComposition);
                            SplashImmersionActivity.this.mLottieView.setRepeatCount(-1);
                            SplashImmersionActivity.this.mLottieView.playAnimation();
                        }
                    }
                });
            } catch (Exception e2) {
                this.mLottieView.setVisibility(8);
            }
        }
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (SplashPolicyRecorder.getInstance().isBackSkipOptOn()) {
            safeFinish();
        }
    }

    public void safeFinish() {
        UiThreadUtil.getMainHandler().post(new Runnable() {
            public void run() {
                if (!SplashImmersionActivity.this.isFinishing()) {
                    SplashImmersionActivity.this.finish();
                }
            }
        });
    }
}
