package com.baidu.android.common.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.view.BadgeView;

public class CommonMenuItemView extends RelativeLayout {
    private static final int DEFAULT_BADGE_RIGHT_MARGIN = 2;
    private BadgeView mBadgeView;
    private BgIconView mBgIconView;
    private ImageView mIconView;
    private BadgeView mRedDotBadge;
    private TextView mTitleView;

    public CommonMenuItemView(Context context) {
        super(context);
        init();
    }

    public CommonMenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommonMenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setGravity(17);
        LayoutInflater.from(getContext()).inflate(R.layout.common_menu_item_view_layout2, this);
        this.mIconView = (ImageView) findViewById(R.id.common_menu_item_icon);
        this.mBgIconView = (BgIconView) findViewById(R.id.common_menu_item_bg);
        this.mTitleView = (TextView) findViewById(R.id.common_menu_item_title);
        this.mBadgeView = (BadgeView) findViewById(R.id.common_menu_item_badge);
        setBackgroundResource(0);
    }

    public void setIconSupportDark(boolean support) {
        ImageView imageView = this.mIconView;
        if (imageView instanceof BdBaseImageView) {
            ((BdBaseImageView) imageView).setSupportDark(Boolean.valueOf(support));
        }
    }

    public void updateView(CommonMenuItem item, CommonMenuMode mode) {
        if (item != null) {
            this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
            this.mTitleView.setSingleLine();
            setEnabled(item.isEnable());
            this.mIconView.setVisibility(0);
            this.mBgIconView.setVisibility(8);
            updateItemUI(item, mode);
            switch (AnonymousClass1.$SwitchMap$com$baidu$android$common$menu$MenuNewType[item.getNewTip().ordinal()]) {
                case 1:
                    this.mBadgeView.setBadgeMargin(0, -4, fixBadgeRightMargin(item), 0);
                    this.mBadgeView.setType(BadgeView.Type.SMALL_TEXT);
                    this.mBadgeView.setBadgeText(String.valueOf(item.getTip()));
                    this.mBadgeView.setVisibility(0);
                    BadgeView badgeView = this.mRedDotBadge;
                    if (badgeView != null) {
                        badgeView.setVisibility(8);
                        return;
                    }
                    return;
                case 2:
                    if (this.mRedDotBadge == null) {
                        BadgeView badgeView2 = new BadgeView(getContext());
                        this.mRedDotBadge = badgeView2;
                        badgeView2.setType(BadgeView.Type.DOT);
                        this.mRedDotBadge.bindView(this.mIconView);
                        this.mRedDotBadge.setBadgeGravity(53);
                    }
                    this.mBadgeView.setVisibility(8);
                    this.mRedDotBadge.setVisibility(0);
                    return;
                default:
                    this.mBadgeView.setVisibility(8);
                    BadgeView badgeView3 = this.mRedDotBadge;
                    if (badgeView3 != null) {
                        badgeView3.setVisibility(8);
                        return;
                    }
                    return;
            }
        }
    }

    /* renamed from: com.baidu.android.common.menu.CommonMenuItemView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$android$common$menu$MenuNewType;

        static {
            int[] iArr = new int[MenuNewType.values().length];
            $SwitchMap$com$baidu$android$common$menu$MenuNewType = iArr;
            try {
                iArr[MenuNewType.STRING_TIP.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$android$common$menu$MenuNewType[MenuNewType.DOT_TIP.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private void updateItemUI(CommonMenuItem item, CommonMenuMode mode) {
        int i2;
        setAlpha(1.0f);
        this.mTitleView.setText(item.getTitle(getContext()));
        FontSizeTextViewExtKt.setScaledSizeRes(this.mTitleView, 2, R.dimen.dimen_ui_11);
        Drawable icon = getIcon(item, mode);
        if (icon != null) {
            this.mIconView.setImageDrawable(icon);
            this.mIconView.setImageLevel(item.getImgLevel());
        }
        TextView textView = this.mTitleView;
        if (CommonMenuMode.DARK.equals(mode)) {
            i2 = getResources().getColor(R.color.common_menu_item_text_photos);
        } else {
            i2 = item.getTitleColor(getContext());
        }
        textView.setTextColor(i2);
        handleItemIcon(item);
    }

    private Drawable getIcon(CommonMenuItem item, CommonMenuMode mode) {
        if (!CommonMenuMode.DARK.equals(mode) || NightModeHelper.getNightModeSwitcherState()) {
            return item.getIcon(getContext());
        }
        Drawable icon = item.getDarkIcon(getContext());
        if (icon == null) {
            return item.getIcon(getContext());
        }
        return icon;
    }

    private void handleItemIcon(CommonMenuItem item) {
        BgIcon bgIcon = item.mBgIcon;
        if (bgIcon != null) {
            this.mBgIconView.setVisibility(0);
            this.mIconView.setVisibility(8);
            this.mBgIconView.updateViews(bgIcon.mBgIconId, bgIcon.mIconText, R.color.common_menu_multi_incognito_text_color);
        }
    }

    private int fixBadgeRightMargin(CommonMenuItem item) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$android$common$menu$MenuNewType[item.getNewTip().ordinal()]) {
            case 1:
                String tip = item.getTip();
                if (tip == null) {
                    return 0;
                }
                if (TextUtils.isEmpty(tip) || !FontSizeHelper.isFontSizeBigger()) {
                    return 2;
                }
                if (tip.length() > 1) {
                    return 2 - (getLevelInterval() * 4);
                }
                return 2 - (getLevelInterval() * 2);
            case 2:
                String title = item.getTitle(getContext());
                if (title == null) {
                    return 0;
                }
                if (title.length() >= 4) {
                    return 8;
                }
                return 6;
            default:
                return 0;
        }
    }

    private int getLevelInterval() {
        return Math.min(2, FontSizeHelper.getFontSizeType() - 1);
    }
}
