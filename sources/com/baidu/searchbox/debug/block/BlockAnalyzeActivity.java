package com.baidu.searchbox.debug.block;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.R;
import java.io.File;

public class BlockAnalyzeActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "BlockAnalyzeActivity";
    private EditText mAutoRestartCountEdt;
    private Button mCreateReportBtn;
    private Button mDeleteReportBtn;
    private EditText mDurationEdt;
    private CheckBox mOpenChk;
    private Button mSaveBtn;
    private View mSettingsLayout;
    private Button mShowLogBtn;
    private EditText mTimeoutEdt;
    private WebView mWebView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_analyze);
        initView();
        initData();
    }

    private void initView() {
        this.mWebView = (WebView) findViewById(R.id.webview);
        this.mOpenChk = (CheckBox) findViewById(R.id.open_chk);
        this.mSaveBtn = (Button) findViewById(R.id.save_btn);
        this.mShowLogBtn = (Button) findViewById(R.id.show_log_btn);
        this.mDurationEdt = (EditText) findViewById(R.id.duration_edt);
        this.mTimeoutEdt = (EditText) findViewById(R.id.timeout_edt);
        this.mSettingsLayout = findViewById(R.id.settings_layout);
        this.mAutoRestartCountEdt = (EditText) findViewById(R.id.auto_restart_count_edt);
        this.mCreateReportBtn = (Button) findViewById(R.id.create_report_btn);
        this.mDeleteReportBtn = (Button) findViewById(R.id.delete_report_btn);
        this.mSaveBtn.setOnClickListener(this);
        this.mShowLogBtn.setOnClickListener(this);
        this.mCreateReportBtn.setOnClickListener(this);
        this.mDeleteReportBtn.setOnClickListener(this);
    }

    private void initData() {
        loadSettings();
    }

    public void onClick(View v) {
        if (v.getId() == R.id.save_btn) {
            saveSettings();
        } else if (v.getId() == R.id.show_log_btn) {
            if (this.mSettingsLayout.getVisibility() == 0) {
                this.mSettingsLayout.setVisibility(8);
                this.mWebView.setVisibility(0);
                this.mShowLogBtn.setText("隐藏报告");
                this.mWebView.loadData(BlockReportManager.readReport(), "text/html", (String) null);
                return;
            }
            this.mSettingsLayout.setVisibility(0);
            this.mWebView.setVisibility(8);
            this.mShowLogBtn.setText("显示报告");
        } else if (v.getId() == R.id.create_report_btn) {
            if (BlockReportManager.createAndSaveReport()) {
                BlockReportManager.deleteTempFiles();
                Toast.makeText(AppRuntime.getAppContext(), "报告创建成功！", 1).show();
                return;
            }
            Toast.makeText(AppRuntime.getAppContext(), "报告创建失败！", 1).show();
        } else if (v.getId() == R.id.delete_report_btn) {
            new AlertDialog.Builder(this).setMessage("确定删除缓存和报告？").setNegativeButton(AccountConstants.PROFESSION_APPROVE_DIALOG_CANCEL_TITLE_DEFAULT, (DialogInterface.OnClickListener) null).setPositiveButton("删除", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    BlockReportManager.deleteTempFiles();
                    File file = BlockReportManager.getReportFile();
                    if (file != null) {
                        file.delete();
                    }
                    Toast.makeText(AppRuntime.getAppContext(), "删除成功", 1).show();
                }
            }).show();
        }
    }

    private void loadSettings() {
        this.mOpenChk.setChecked(BlockDebugUtils.getSp().getBoolean("enable", false));
        this.mDurationEdt.setText(BlockDebugUtils.getSp().getInt(BlockDebugUtils.SP_KEY_ANALYZE_DURATION, 30000) + "");
        this.mTimeoutEdt.setText(BlockDebugUtils.getSp().getInt(BlockDebugUtils.SP_KEY_BLOCK_THRESHOLD, 50) + "");
        this.mAutoRestartCountEdt.setText(BlockDebugUtils.getSp().getInt(BlockDebugUtils.SP_KEY_AUTO_RESTART_TARGET_COUNT, 5) + "");
    }

    private void saveSettings() {
        try {
            int duration = Integer.parseInt(this.mDurationEdt.getText().toString());
            int timeout = Integer.parseInt(this.mTimeoutEdt.getText().toString());
            BlockDebugUtils.getSp().edit().putBoolean("enable", this.mOpenChk.isChecked()).putInt(BlockDebugUtils.SP_KEY_ANALYZE_DURATION, duration).putInt(BlockDebugUtils.SP_KEY_BLOCK_THRESHOLD, timeout).putInt(BlockDebugUtils.SP_KEY_AUTO_RESTART_TARGET_COUNT, Integer.parseInt(this.mAutoRestartCountEdt.getText().toString())).apply();
            Toast.makeText(AppRuntime.getAppContext(), "保存成功!下次启动生效", 0).show();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            Toast.makeText(AppRuntime.getAppContext(), "参数错误", 0).show();
        }
    }
}
