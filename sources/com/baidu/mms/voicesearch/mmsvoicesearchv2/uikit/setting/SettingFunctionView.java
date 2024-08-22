package com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.setting;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mms.voicesearch.voice.utils.SkinManager;
import com.baidu.speechbundle.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SettingFunctionView extends LinearLayout implements View.OnClickListener {
    public static final int CHECKBOX = 0;
    public static final int IMAGE_ICON = 1;
    public static final int IMAGE_ICON_TEXT = 2;
    private int buttonType;
    private ViewStub buttonViewStub;
    private ImageView iconButton;
    private SettingFunctionViewBuilder mBuilder;
    private boolean mCurrentState;
    private View mDivider;
    private TextView mFunctionHintTextView;
    private CheckBox mFunctionSwitch;
    private TextView mFunctionTitleTextView;
    private ISettingFunctionViewCallback mSettingCallback;
    private LinearLayout mSettingFunctionLayout;
    private ImageView newTag;
    private TextView textIconButtonTitle;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SettingItemButtonType {
    }

    public SettingFunctionView(Context context) {
        super(context);
        this.buttonType = 0;
        initView(context);
    }

    public SettingFunctionView(SettingFunctionViewBuilder builder) {
        super(builder.mContext);
        this.buttonType = builder.btnType;
        this.mSettingCallback = builder.callBack;
        this.mBuilder = builder;
        initView(builder.mContext);
    }

    public SettingFunctionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.buttonType = 0;
        initView(context);
    }

    public SettingFunctionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.buttonType = 0;
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mms_voice_setting_function, this, true);
        this.mSettingFunctionLayout = (LinearLayout) findViewById(R.id.setting_function_layout);
        this.mFunctionTitleTextView = (TextView) findViewById(R.id.setting_function_title);
        SettingFunctionViewBuilder settingFunctionViewBuilder = this.mBuilder;
        if (settingFunctionViewBuilder != null && !TextUtils.isEmpty(settingFunctionViewBuilder.mainTitle)) {
            this.mFunctionTitleTextView.setText(this.mBuilder.mainTitle);
        }
        this.mFunctionHintTextView = (TextView) findViewById(R.id.setting_function_hint);
        SettingFunctionViewBuilder settingFunctionViewBuilder2 = this.mBuilder;
        if (settingFunctionViewBuilder2 != null && !TextUtils.isEmpty(settingFunctionViewBuilder2.subTitle)) {
            this.mFunctionHintTextView.setText(this.mBuilder.subTitle);
        }
        View findViewById = findViewById(R.id.setting_function_top_divider);
        this.mDivider = findViewById;
        SettingFunctionViewBuilder settingFunctionViewBuilder3 = this.mBuilder;
        if (settingFunctionViewBuilder3 != null) {
            findViewById.setVisibility(settingFunctionViewBuilder3.dividerVisibility);
        }
        this.newTag = (ImageView) findViewById(R.id.setting_function_new_tag);
        this.mSettingFunctionLayout.setOnClickListener(this);
        if (this.buttonViewStub == null) {
            switch (this.buttonType) {
                case 0:
                    ViewStub viewStub = (ViewStub) findViewById(R.id.setting_function_checkbox_vs);
                    this.buttonViewStub = viewStub;
                    viewStub.inflate();
                    CheckBox checkBox = (CheckBox) findViewById(R.id.setting_function_checkbox_button);
                    this.mFunctionSwitch = checkBox;
                    checkBox.setClickable(false);
                    SettingFunctionViewBuilder settingFunctionViewBuilder4 = this.mBuilder;
                    if (settingFunctionViewBuilder4 != null) {
                        setChecked(settingFunctionViewBuilder4.checked);
                        return;
                    }
                    return;
                case 1:
                    ViewStub viewStub2 = (ViewStub) findViewById(R.id.setting_function_icon_vs);
                    this.buttonViewStub = viewStub2;
                    viewStub2.inflate();
                    ImageView imageView = (ImageView) findViewById(R.id.setting_function_icon_button);
                    this.iconButton = imageView;
                    SettingFunctionViewBuilder settingFunctionViewBuilder5 = this.mBuilder;
                    if (settingFunctionViewBuilder5 != null) {
                        imageView.setVisibility(settingFunctionViewBuilder5.iconVisibility);
                    }
                    this.iconButton.setClickable(false);
                    return;
                case 2:
                    ViewStub viewStub3 = (ViewStub) findViewById(R.id.setting_function_text_icon_vs);
                    this.buttonViewStub = viewStub3;
                    viewStub3.inflate();
                    TextView textView = (TextView) findViewById(R.id.setting_function_text_icon_text);
                    this.textIconButtonTitle = textView;
                    SettingFunctionViewBuilder settingFunctionViewBuilder6 = this.mBuilder;
                    if (settingFunctionViewBuilder6 != null) {
                        textView.setText(settingFunctionViewBuilder6.iconText);
                    }
                    this.textIconButtonTitle.setClickable(false);
                    ImageView imageView2 = (ImageView) findViewById(R.id.setting_function_text_icon_icon);
                    this.iconButton = imageView2;
                    SettingFunctionViewBuilder settingFunctionViewBuilder7 = this.mBuilder;
                    if (settingFunctionViewBuilder7 != null) {
                        imageView2.setVisibility(settingFunctionViewBuilder7.iconVisibility);
                    }
                    this.iconButton.setClickable(false);
                    return;
                default:
                    return;
            }
        }
    }

    public void changeSkin() {
        if (SkinManager.getInstance().isNightMode()) {
            View view2 = this.mDivider;
            if (view2 != null) {
                view2.setBackgroundColor(getContext().getResources().getColor(R.color.voice_setting_div_color_night));
            }
            ImageView imageView = this.newTag;
            if (imageView != null) {
                imageView.setBackgroundResource(R.drawable.voice_new_setting_new_tag_night);
            }
        } else {
            View view3 = this.mDivider;
            if (view3 != null) {
                view3.setBackgroundColor(getContext().getResources().getColor(R.color.voice_setting_div_color));
            }
            ImageView imageView2 = this.newTag;
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.voice_new_setting_new_tag);
            }
        }
        setViewBackgroundDrawable();
        setTitleTextColor();
        setHintTextColor();
        changeButtonSkin();
    }

    private void setTitleTextColor() {
        if (this.mFunctionTitleTextView != null && getContext() != null) {
            if (SkinManager.getInstance().isNightMode()) {
                this.mFunctionTitleTextView.setTextColor(getContext().getResources().getColor(R.color.voice_setting_title_bar_text_color_night));
            } else {
                this.mFunctionTitleTextView.setTextColor(getContext().getResources().getColor(R.color.voice_setting_title_bar_text_color));
            }
        }
    }

    private void setHintTextColor() {
        if (this.mFunctionHintTextView != null && getContext() != null) {
            if (SkinManager.getInstance().isNightMode()) {
                this.mFunctionHintTextView.setTextColor(Color.parseColor("#444444"));
            } else {
                this.mFunctionHintTextView.setTextColor(getContext().getResources().getColor(R.color.mms_voice_setting_page_subtitle_text_color));
            }
        }
    }

    private void changeButtonSkin() {
        switch (this.buttonType) {
            case 0:
                if (this.mFunctionSwitch != null && getContext() != null) {
                    if (SkinManager.getInstance().isNightMode()) {
                        this.mFunctionSwitch.setBackground(getContext().getResources().getDrawable(R.drawable.mms_voice_night_setting_checkox_style));
                        return;
                    } else {
                        this.mFunctionSwitch.setBackground(getContext().getResources().getDrawable(R.drawable.mms_voice_setting_checkox_style));
                        return;
                    }
                } else {
                    return;
                }
            case 1:
                if (this.iconButton == null) {
                    return;
                }
                if (SkinManager.getInstance().isNightMode()) {
                    SettingFunctionViewBuilder settingFunctionViewBuilder = this.mBuilder;
                    if (settingFunctionViewBuilder == null || settingFunctionViewBuilder.iconResIdNight == -1) {
                        this.iconButton.setImageResource(R.drawable.broadcast_setting_checked_night);
                        return;
                    } else {
                        this.iconButton.setImageResource(this.mBuilder.iconResIdNight);
                        return;
                    }
                } else {
                    SettingFunctionViewBuilder settingFunctionViewBuilder2 = this.mBuilder;
                    if (settingFunctionViewBuilder2 == null || settingFunctionViewBuilder2.iconResIdNormal == -1) {
                        this.iconButton.setImageResource(R.drawable.broadcast_setting_checked_normal);
                        return;
                    } else {
                        this.iconButton.setImageResource(this.mBuilder.iconResIdNormal);
                        return;
                    }
                }
            case 2:
                if (this.iconButton != null) {
                    if (SkinManager.getInstance().isNightMode()) {
                        SettingFunctionViewBuilder settingFunctionViewBuilder3 = this.mBuilder;
                        if (settingFunctionViewBuilder3 == null || settingFunctionViewBuilder3.iconResIdNight == -1) {
                            this.iconButton.setImageResource(R.drawable.broadcast_setting_arrow_icon_night);
                        } else {
                            this.iconButton.setImageResource(this.mBuilder.iconResIdNight);
                        }
                    } else {
                        SettingFunctionViewBuilder settingFunctionViewBuilder4 = this.mBuilder;
                        if (settingFunctionViewBuilder4 == null || settingFunctionViewBuilder4.iconResIdNormal == -1) {
                            this.iconButton.setImageResource(R.drawable.broadcast_setting_arrow_icon_normal);
                        } else {
                            this.iconButton.setImageResource(this.mBuilder.iconResIdNormal);
                        }
                    }
                }
                if (this.textIconButtonTitle == null) {
                    return;
                }
                if (SkinManager.getInstance().isNightMode()) {
                    this.textIconButtonTitle.setTextColor(Color.parseColor("#444444"));
                    return;
                } else {
                    this.textIconButtonTitle.setTextColor(getContext().getResources().getColor(R.color.mms_voice_setting_page_subtitle_text_color));
                    return;
                }
            default:
                return;
        }
    }

    private void setViewBackgroundDrawable() {
        if (this.mSettingFunctionLayout == null) {
            return;
        }
        if (SkinManager.getInstance().isNightMode()) {
            this.mSettingFunctionLayout.setBackground(getContext().getResources().getDrawable(R.drawable.mms_voice_night_selector_tab_background));
        } else {
            this.mSettingFunctionLayout.setBackground(getContext().getResources().getDrawable(R.drawable.mms_voice_selector_tab_background));
        }
    }

    public void setSettingCallback(ISettingFunctionViewCallback mSettingCallback2) {
        this.mSettingCallback = mSettingCallback2;
    }

    public void setChecked(boolean state) {
        this.mCurrentState = state;
        CheckBox checkBox = this.mFunctionSwitch;
        if (checkBox != null) {
            checkBox.setChecked(state);
        }
    }

    public boolean isChecked() {
        return this.mCurrentState;
    }

    public void setTitleText(String titleText) {
        TextView textView = this.mFunctionTitleTextView;
        if (textView != null) {
            textView.setText(titleText);
        }
    }

    public void setHintText(String hintStr) {
        TextView textView = this.mFunctionHintTextView;
        if (textView != null) {
            textView.setText(hintStr);
        }
    }

    public void setCheckBoxID(int id) {
        CheckBox checkBox = this.mFunctionSwitch;
        if (checkBox != null) {
            checkBox.setId(id);
        }
    }

    public void setButtonText(String iconStr) {
        TextView textView;
        if (this.buttonType == 2 && (textView = this.textIconButtonTitle) != null) {
            textView.setText(iconStr == null ? "" : iconStr);
        }
    }

    public void setIconVisibility(int visibility) {
        ImageView imageView = this.iconButton;
        if (imageView != null) {
            imageView.setVisibility(visibility);
        }
    }

    public void setNewTagVisibility(int visibility) {
        ImageView imageView = this.newTag;
        if (imageView != null) {
            imageView.setVisibility(visibility);
        }
    }

    public void onClick(View view2) {
        switch (this.buttonType) {
            case 0:
                ISettingFunctionViewCallback iSettingFunctionViewCallback = this.mSettingCallback;
                if (iSettingFunctionViewCallback == null) {
                    return;
                }
                if (this.mCurrentState) {
                    iSettingFunctionViewCallback.switchOff(hashCode());
                    return;
                } else {
                    iSettingFunctionViewCallback.switchOn(hashCode());
                    return;
                }
            case 1:
                ISettingFunctionViewCallback iSettingFunctionViewCallback2 = this.mSettingCallback;
                if (iSettingFunctionViewCallback2 != null) {
                    iSettingFunctionViewCallback2.onIconButtonClick(hashCode());
                    return;
                }
                return;
            case 2:
                ISettingFunctionViewCallback iSettingFunctionViewCallback3 = this.mSettingCallback;
                if (iSettingFunctionViewCallback3 != null) {
                    iSettingFunctionViewCallback3.onTextIconButtonClick(hashCode());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void recycleView() {
        CheckBox checkBox = this.mFunctionSwitch;
        if (checkBox != null) {
            checkBox.setBackground((Drawable) null);
            this.mFunctionSwitch = null;
        }
        if (this.mSettingCallback != null) {
            this.mSettingCallback = null;
        }
    }

    public void setDividerVisible(int visibleType) {
        View view2 = this.mDivider;
        if (view2 != null) {
            view2.setVisibility(visibleType);
        }
    }

    public static class SettingFunctionViewBuilder {
        /* access modifiers changed from: private */
        public int btnType = 0;
        /* access modifiers changed from: private */
        public ISettingFunctionViewCallback callBack;
        /* access modifiers changed from: private */
        public boolean checked = false;
        /* access modifiers changed from: private */
        public int dividerVisibility = 8;
        /* access modifiers changed from: private */
        public int iconResIdNight = -1;
        /* access modifiers changed from: private */
        public int iconResIdNormal = -1;
        /* access modifiers changed from: private */
        public String iconText = "";
        /* access modifiers changed from: private */
        public int iconVisibility = 8;
        /* access modifiers changed from: private */
        public Context mContext;
        /* access modifiers changed from: private */
        public String mainTitle = "";
        /* access modifiers changed from: private */
        public String subTitle = "";

        public SettingFunctionViewBuilder(Context context) {
            this.mContext = context;
        }

        public SettingFunctionViewBuilder setBtnType(int btnType2) {
            this.btnType = btnType2;
            return this;
        }

        public SettingFunctionViewBuilder setCallBack(ISettingFunctionViewCallback callBack2) {
            this.callBack = callBack2;
            return this;
        }

        public SettingFunctionViewBuilder setMainTitle(String mainTitle2) {
            this.mainTitle = mainTitle2;
            return this;
        }

        public SettingFunctionViewBuilder setSubTitle(String subTitle2) {
            this.subTitle = subTitle2;
            return this;
        }

        public SettingFunctionViewBuilder setIconText(String iconText2) {
            this.iconText = iconText2;
            return this;
        }

        public SettingFunctionViewBuilder setDividerVisibility(int dividerVisibility2) {
            this.dividerVisibility = dividerVisibility2;
            return this;
        }

        public SettingFunctionViewBuilder setChecked(boolean checked2) {
            this.checked = checked2;
            return this;
        }

        public SettingFunctionViewBuilder setIconVisibility(int iconVisibility2) {
            this.iconVisibility = iconVisibility2;
            return this;
        }

        public SettingFunctionViewBuilder setIconResIdNormal(int id) {
            this.iconResIdNormal = id;
            return this;
        }

        public SettingFunctionViewBuilder setIconResIdNight(int id) {
            this.iconResIdNight = id;
            return this;
        }

        public SettingFunctionView build() {
            return new SettingFunctionView(this);
        }
    }
}
