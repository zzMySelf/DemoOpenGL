package com.baidu.searchbox.qrcode.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.barcode.R;
import com.baidu.searchbox.qrcode.result.IActionBarRightZoneCallback;
import com.baidu.searchbox.qrcode.result.IResultViewFactory;
import com.baidu.searchbox.qrcode.result.ui.BarcodeResultView;
import com.baidu.searchbox.qrcode.result.ui.BaseChildResultView;
import com.baidu.searchbox.services.scancode.BarcodeType;
import com.baidu.searchbox.services.scancode.CodeResult;
import com.baidu.searchbox.services.scancode.result.ParsedResultType;

public class ResultView extends FragmentView {
    /* access modifiers changed from: private */
    public TextView mBtnShare;
    private BaseChildResultView mChildResultView;
    private boolean mInited = false;
    private CodeResult mResult;
    private IResultViewFactory mResultViewFactory;
    private TextView mTitleView;
    private boolean mValid = false;

    public ResultView(Context context, IResultViewFactory factory) {
        super(context);
        this.mResultViewFactory = factory;
    }

    public ResultView(Context context) {
        super(context);
    }

    public void setResultViewFactory(IResultViewFactory factory) {
        this.mResultViewFactory = factory;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        ViewArgument argument = getArgument();
        if (argument != null && argument.result != null) {
            setResult(argument.result);
        }
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.barcode_result, this, true);
        this.mTitleView = (TextView) findViewById(R.id.title);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                if (ResultView.this.mCallbackClient != null) {
                    ResultView.this.mCallbackClient.onResultBackClick(view2);
                }
            }
        });
        this.mBtnShare = (TextView) findViewById(R.id.clear);
        this.mInited = true;
    }

    /* JADX WARNING: type inference failed for: r4v7, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r4v9, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r4v15, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r4v17, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setResult(com.baidu.searchbox.services.scancode.CodeResult r8) {
        /*
            r7 = this;
            r0 = 0
            boolean r1 = r7.mInited
            if (r1 != 0) goto L_0x0006
            return r0
        L_0x0006:
            android.content.Context r1 = r7.getContext()
            com.baidu.searchbox.qrcode.result.IResultViewFactory r2 = r7.mResultViewFactory
            com.baidu.searchbox.qrcode.result.ui.BaseChildResultView r2 = r2.createResultView(r1, r8)
            if (r2 == 0) goto L_0x0089
            r0 = 1
            r7.mResult = r8
            r3 = 0
            com.baidu.searchbox.qrcode.result.ui.BaseChildResultView r4 = r7.mChildResultView
            if (r4 == 0) goto L_0x0042
            boolean r4 = r4.selfScroll()
            if (r4 == 0) goto L_0x0034
            int r4 = com.baidu.barcode.R.id.result_root
            android.view.View r4 = r7.findViewById(r4)
            r3 = r4
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            int r4 = com.baidu.barcode.R.id.result_container
            android.view.View r4 = r7.findViewById(r4)
            r5 = 0
            r4.setVisibility(r5)
            goto L_0x003d
        L_0x0034:
            int r4 = com.baidu.barcode.R.id.layout_for_fragment
            android.view.View r4 = r7.findViewById(r4)
            r3 = r4
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
        L_0x003d:
            com.baidu.searchbox.qrcode.result.ui.BaseChildResultView r4 = r7.mChildResultView
            r3.removeView(r4)
        L_0x0042:
            r7.mChildResultView = r2
            boolean r4 = r2.selfScroll()
            if (r4 == 0) goto L_0x005f
            int r4 = com.baidu.barcode.R.id.result_root
            android.view.View r4 = r7.findViewById(r4)
            r3 = r4
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            int r4 = com.baidu.barcode.R.id.result_container
            android.view.View r4 = r7.findViewById(r4)
            r5 = 8
            r4.setVisibility(r5)
            goto L_0x0068
        L_0x005f:
            int r4 = com.baidu.barcode.R.id.layout_for_fragment
            android.view.View r4 = r7.findViewById(r4)
            r3 = r4
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
        L_0x0068:
            com.baidu.searchbox.qrcode.result.ui.BaseChildResultView r4 = r7.mChildResultView
            r5 = 0
            r4.onCreate(r5)
            com.baidu.searchbox.qrcode.result.ui.BaseChildResultView r4 = r7.mChildResultView
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r6 = -1
            r5.<init>(r6, r6)
            r3.addView(r4, r5)
            com.baidu.searchbox.qrcode.result.ui.BaseChildResultView r4 = r7.mChildResultView
            com.baidu.searchbox.services.scancode.CodeResult r5 = r7.mResult
            com.baidu.searchbox.qrcode.internal.InternalBarcodeViewCallbackClient r6 = r7.mCallbackClient
            r4.setResult(r5, r6)
            com.baidu.searchbox.qrcode.result.ui.BaseChildResultView r4 = r7.mChildResultView
            com.baidu.searchbox.services.scancode.CodeResult r5 = r7.mResult
            r7.setupTitileBar(r1, r4, r5)
        L_0x0089:
            r7.mValid = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.qrcode.ui.ResultView.setResult(com.baidu.searchbox.services.scancode.CodeResult):boolean");
    }

    private void setupTitileBar(Context context, BaseChildResultView resultView, CodeResult result) {
        this.mBtnShare.setVisibility(4);
        if (result == null) {
            this.mTitleView.setText(R.string.barcode_result_default_title);
            return;
        }
        switch (AnonymousClass3.$SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType[result.getParsedResult().getType().ordinal()]) {
            case 1:
                this.mTitleView.setText(R.string.barcode_uri_result_title);
                return;
            case 2:
                this.mTitleView.setText(R.string.barcode_result_url_file_title);
                return;
            case 3:
                this.mTitleView.setText(R.string.barcode_email_result_title);
                return;
            case 4:
                this.mTitleView.setText(R.string.barcode_address_book_title);
                return;
            case 5:
            case 6:
                setupBarcodeTitleBar(context, resultView);
                return;
            case 7:
                this.mTitleView.setText(R.string.barcode_lightapp_result_title);
                return;
            default:
                if (BarcodeType.BAR_CODE == result.getBarcodeType()) {
                    setupBarcodeTitleBar(context, resultView);
                    return;
                } else {
                    this.mTitleView.setText(R.string.barcode_plaintext_title);
                    return;
                }
        }
    }

    /* renamed from: com.baidu.searchbox.qrcode.ui.ResultView$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType;

        static {
            int[] iArr = new int[ParsedResultType.values().length];
            $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType = iArr;
            try {
                iArr[ParsedResultType.URI.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType[ParsedResultType.WEB_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType[ParsedResultType.EMAIL_ADDRESS.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType[ParsedResultType.ADDRESSBOOK.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType[ParsedResultType.ISBN.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType[ParsedResultType.PRODUCT.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType[ParsedResultType.LIGHTAPP.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$services$scancode$result$ParsedResultType[ParsedResultType.TEXT.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public void setupBarcodeTitleBar(Context context, FragmentView resultView) {
        this.mTitleView.setText(R.string.barcode_product_title);
        this.mBtnShare.setVisibility(0);
        this.mBtnShare.setText(R.string.barcode_button_text_share);
        this.mBtnShare.setTextColor(getResources().getColor(R.color.barcode_result_share_color_disable));
        this.mBtnShare.setClickable(false);
        this.mBtnShare.setEnabled(false);
        if (resultView instanceof BarcodeResultView) {
            ((BarcodeResultView) resultView).setShareButtonCallback(new IActionBarRightZoneCallback() {
                public void setClickListener(View.OnClickListener listener) {
                    ResultView.this.mBtnShare.setOnClickListener(listener);
                }

                public void setClickable(boolean clickable) {
                    ResultView.this.mBtnShare.setClickable(clickable);
                    ResultView.this.mBtnShare.setEnabled(clickable);
                    if (clickable) {
                        ResultView.this.mBtnShare.setTextColor(ResultView.this.getResources().getColor(R.color.barcode_result_share_color));
                    } else {
                        ResultView.this.mBtnShare.setTextColor(ResultView.this.getResources().getColor(R.color.barcode_result_share_color_disable));
                    }
                }
            });
        }
    }

    public boolean isValid() {
        return this.mValid;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.mResult;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean supportCameraPortrait() {
        /*
            r2 = this;
            boolean r0 = super.supportCameraPortrait()
            if (r0 != 0) goto L_0x001f
            com.baidu.searchbox.services.scancode.CodeResult r0 = r2.mResult
            if (r0 == 0) goto L_0x001d
            com.baidu.searchbox.qrcode.decode.DecodeSource r0 = r0.getDecodeSource()
            com.baidu.searchbox.qrcode.decode.DecodeSource r1 = com.baidu.searchbox.qrcode.decode.DecodeSource.BITMAP_CHOOSE
            if (r0 == r1) goto L_0x001d
            com.baidu.searchbox.services.scancode.CodeResult r0 = r2.mResult
            com.baidu.searchbox.qrcode.decode.DecodeSource r0 = r0.getDecodeSource()
            com.baidu.searchbox.qrcode.decode.DecodeSource r1 = com.baidu.searchbox.qrcode.decode.DecodeSource.CAMERA_PREVIEW
            if (r0 == r1) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.qrcode.ui.ResultView.supportCameraPortrait():boolean");
    }

    public void setArguments(ViewArgument argument) {
        super.setArguments(argument);
        if (argument != null) {
            setResultViewFactory(argument.resultViewFactory);
            setResult(argument.result);
        }
    }
}
