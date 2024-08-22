package com.baidu.searchbox.qrcode.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.searchbox.qrcode.Res;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import com.baidu.searchbox.qrcode.utils.Utility;
import com.baidu.searchbox.services.scancode.BarcodeFormat;
import com.baidu.searchbox.services.scancode.BarcodeType;
import com.baidu.searchbox.services.scancode.CodeResult;

public class InputView extends FragmentView implements TextView.OnEditorActionListener {
    private static final int INPUT_SHOW_DELAY_TIME = 500;
    /* access modifiers changed from: private */
    public EditText mBarcodeEditText;
    /* access modifiers changed from: private */
    public Button mConfirmButton;

    public interface IInputViewCallbackClient {
        boolean onInputBackClick(View view2);

        boolean onInputConfirmClick(View view2, CodeResult codeResult);
    }

    public InputView(Context context) {
        super(context);
    }

    public InputView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InputView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getContext();
        LayoutInflater.from(context).inflate(ResUtils.getLayoutResId(context, Res.layout.barcode_input_layout), this, true);
        ((TextView) findViewById(ResUtils.getIdResId(context, "title"))).setText(ResUtils.getStringResId(context, Res.string.barcode_manual_input_title));
        findViewById(ResUtils.getIdResId(context, "back")).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                Utility.hideInputMethod(view2.getContext(), InputView.this.mBarcodeEditText);
                if (InputView.this.mCallbackClient != null) {
                    InputView.this.mCallbackClient.onInputBackClick(view2);
                }
            }
        });
        this.mBarcodeEditText = (EditText) findViewById(ResUtils.getIdResId(context, Res.id.barcode_edittext));
        Button button = (Button) findViewById(ResUtils.getIdResId(context, Res.id.barcode_confirm));
        this.mConfirmButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                InputView.this.onConfirmButtonClick(view2);
            }
        });
        this.mBarcodeEditText.setOnEditorActionListener(this);
        this.mBarcodeEditText.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
                if (s != null) {
                    InputView.this.mConfirmButton.setEnabled(s.length() > 0);
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.mBarcodeEditText.requestFocus();
        showInputMethod(true);
    }

    private void showInputMethod(boolean show) {
        this.mBarcodeEditText.postDelayed(new Runnable() {
            public void run() {
                if (InputView.this.isResumed()) {
                    Utility.showInputMethod(InputView.this.mBarcodeEditText.getContext(), InputView.this.mBarcodeEditText);
                }
            }
        }, 500);
    }

    public boolean onEditorAction(TextView view2, int actionId, KeyEvent event) {
        if (6 != actionId && (event == null || event.getKeyCode() != 66)) {
            return false;
        }
        onConfirmButtonClick(view2);
        return true;
    }

    /* access modifiers changed from: private */
    public void onConfirmButtonClick(View view2) {
        Utility.hideInputMethod(view2.getContext(), this.mBarcodeEditText);
        if (this.mCallbackClient != null) {
            this.mCallbackClient.onInputConfirmClick(view2, new CodeResult(this.mBarcodeEditText.getText().toString(), BarcodeType.BAR_CODE, BarcodeFormat.UNKNOW));
        }
    }

    public boolean onBackPressed() {
        this.mBarcodeEditText.setText("");
        return super.onBackPressed();
    }
}
