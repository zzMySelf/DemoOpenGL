package com.baidu.nadcore.lp.reward.ioc;

import com.baidu.nadcore.business.R;
import com.baidu.pyramid.runtime.service.ServiceReference;

public interface INadRewardUIProvider {
    public static final INadRewardUIProvider EMPTY = new INadRewardUIProvider() {
        public int getCountDownLayout() {
            return R.layout.nad_reward_countdown_layout;
        }

        public int getCountDownUI() {
            return R.layout.nad_reward_video_lp_countdown;
        }

        public int getTopTagUI() {
            return R.layout.nad_reward_top_tag;
        }

        public int getCloseIconUI() {
            return R.layout.nad_reward_close_icon;
        }

        public int getAdInfoUI() {
            return R.layout.nad_reward_video_ad_over_layout;
        }

        public int getBtnHeight() {
            return R.dimen.btn_height;
        }

        public int getBtnCornerRadius() {
            return R.dimen.btn_corner_radius;
        }

        public int getBtnTextSize() {
            return R.dimen.btn_text_size;
        }

        public int getTagHeight() {
            return R.dimen.tag_height;
        }

        public int getBottomArrowUI() {
            return R.layout.nad_reward_bottom_arrow;
        }

        public int getDialogUI() {
            return R.layout.nad_reward_video_dialog;
        }

        public int getDialogContentUI() {
            return R.layout.nad_reward_video_dialog_content;
        }

        public int getLottieDialogContentUI() {
            return R.layout.nad_reward_lottie_dialog_content;
        }

        public int getDialogConvertBtnTextSize() {
            return R.dimen.convert_btn_text_size;
        }

        public int getDialogMainBtnTextSize() {
            return R.dimen.main_btn_text_size;
        }

        public int getDialogMainBtnTopMargin() {
            return R.dimen.main_btn_top_margin;
        }

        public int getDialogBottomBtnTextSize() {
            return R.dimen.bottom_btn_text_size;
        }

        public int getDialogMainBtnHeight() {
            return R.dimen.main_btn_height;
        }

        public int getDialogMainBtnWidth() {
            return R.dimen.main_btn_width;
        }

        public int getHalfTailUI() {
            return R.layout.nad_reward_half_tail;
        }

        public int getFullTailUI() {
            return R.layout.nad_reward_full_tail;
        }

        public int getBigCardUI() {
            return R.layout.nad_reward_big_card_layout;
        }

        public int getImageStyleUI() {
            return R.layout.nad_reward_image_style_layout;
        }

        public int getPanelPopUI() {
            return R.layout.nad_panel_pop_view;
        }

        public int getPanelPopTopMargin() {
            return R.dimen.panel_pop_top_margin;
        }

        public int getTopTagText() {
            return R.layout.nad_reward_top_tag_text;
        }

        public int getFestivalUI() {
            return R.layout.nad_reward_festival_layout;
        }

        public int getEnhanceButtonLayoutId() {
            return R.layout.nad_reward_enhance_button_view;
        }

        public int getBigCardBtnCornerRadius() {
            return R.dimen.big_card_btn_corner_radius;
        }

        public int getVerticalImageUI() {
            return R.layout.nad_reward_vertical_image_layout;
        }

        public int getSvTitleUI() {
            return R.layout.nad_reward_sv_title_layout;
        }

        public int getTagTextRadius() {
            return R.dimen.top_tag_text_bg_radius;
        }

        public int getSvTitleTextSize() {
            return R.dimen.sv_title_text_size;
        }

        public int getNoticeBoardUI() {
            return R.layout.nad_reward_notice_board;
        }

        public int getNoticeBoardMarginTop() {
            return R.dimen.nad_dimen_41dp;
        }
    };
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("nad.core", "rewardUI");

    int getAdInfoUI();

    int getBigCardBtnCornerRadius();

    int getBigCardUI();

    int getBottomArrowUI();

    int getBtnCornerRadius();

    int getBtnHeight();

    int getBtnTextSize();

    int getCloseIconUI();

    int getCountDownLayout();

    int getCountDownUI();

    int getDialogBottomBtnTextSize();

    int getDialogContentUI();

    int getDialogConvertBtnTextSize();

    int getDialogMainBtnHeight();

    int getDialogMainBtnTextSize();

    int getDialogMainBtnTopMargin();

    int getDialogMainBtnWidth();

    int getDialogUI();

    int getEnhanceButtonLayoutId();

    int getFestivalUI();

    int getFullTailUI();

    int getHalfTailUI();

    int getImageStyleUI();

    int getLottieDialogContentUI();

    int getNoticeBoardMarginTop();

    int getNoticeBoardUI();

    int getPanelPopTopMargin();

    int getPanelPopUI();

    int getSvTitleTextSize();

    int getSvTitleUI();

    int getTagHeight();

    int getTagTextRadius();

    int getTopTagText();

    int getTopTagUI();

    int getVerticalImageUI();
}
