package com.baidu.swan.apps.media.chooser.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.CheckBox;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.media.chooser.helper.SwanAppChooseConstant;
import com.baidu.swan.apps.media.chooser.helper.SwanAppChooseHelper;
import com.baidu.swan.apps.media.chooser.helper.SwanAppSelectedHelper;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.utils.SwanAppFileUtils;

public class SwanAppChooseOriginBoxView extends CheckBox implements View.OnClickListener {
    private static final float CHOOSE_ORIGIN_ALPHA = 0.5f;
    private static final int CHOOSE_ORIGIN_PADDING_LEFT = SwanAppUIUtils.dp2px(5.0f);
    private static final int CHOOSE_ORIGIN_SIZE = SwanAppUIUtils.dp2px(14.0f);
    private static final float MAX_ALPHA = 1.0f;

    public SwanAppChooseOriginBoxView(Context context) {
        super(context);
    }

    public SwanAppChooseOriginBoxView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwanAppChooseOriginBoxView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SwanAppChooseOriginBoxView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initView() {
        if (!TextUtils.equals(SwanAppChooseHelper.sInvokeAPISource, SwanAppChooseConstant.KEY_API_CHOOSE_IMAGE)) {
            setVisibility(8);
        } else if (SwanAppChooseHelper.sIsEnableChooseOrigin) {
            setDrawable(R.drawable.swanapp_album_choose_origin_selector, 1.0f);
            setChecked(SwanAppChooseHelper.sIsChooseOriginChecked);
            setOnClickListener(this);
            updateSizeUi();
        } else {
            if (SwanAppChooseHelper.mIsCompressed) {
                setVisibility(8);
            } else {
                setDrawable(R.drawable.swanapp_album_choose_origin_pressed, 0.5f);
                setChecked(true);
                setClickable(false);
            }
            updateSizeUi();
        }
    }

    private void setDrawable(int resId, float alpha) {
        Drawable drawable = getResources().getDrawable(resId);
        int i2 = CHOOSE_ORIGIN_SIZE;
        drawable.setBounds(0, 0, i2, i2);
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(CHOOSE_ORIGIN_PADDING_LEFT);
        setAlpha(alpha);
        setText(getResources().getString(R.string.swanapp_album_choose_origin));
    }

    public void onClick(View v) {
        SwanAppChooseHelper.mIsCompressed = !isChecked();
        SwanAppChooseHelper.sIsChooseOriginChecked = isChecked();
        updateSizeUi();
    }

    public void updateSizeUi() {
        if (getVisibility() != 0) {
            return;
        }
        if (!SwanAppChooseHelper.sIsEnableChooseOrigin && !SwanAppChooseHelper.mIsCompressed) {
            return;
        }
        if (!isChecked()) {
            setText(getResources().getString(R.string.swanapp_album_choose_origin));
            return;
        }
        long size = 0;
        ViewParent parent = getParent();
        if (parent instanceof View) {
            int parentId = ((View) parent).getId();
            if (parentId == R.id.album_choose_bottom_action) {
                if (SwanAppSelectedHelper.getSelectedCount() <= 0) {
                    setText(getResources().getString(R.string.swanapp_album_choose_origin));
                    return;
                }
                size = SwanAppSelectedHelper.getSelectedSize();
            } else if (parentId == R.id.album_preview_bottom_action) {
                size = SwanAppChooseHelper.getPreviewSize();
            }
        }
        String sizeStr = SwanAppFileUtils.generateFileSizeText(size);
        if (sizeStr.equals("未知")) {
            setText(getResources().getString(R.string.swanapp_album_choose_origin));
            return;
        }
        setText(getResources().getString(R.string.swanapp_album_choose_origin_show_size, new Object[]{sizeStr}));
    }
}
