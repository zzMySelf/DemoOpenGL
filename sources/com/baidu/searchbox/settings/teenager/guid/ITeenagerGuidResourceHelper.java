package com.baidu.searchbox.settings.teenager.guid;

import com.baidu.searchbox.settings.teenager.R;
import com.baidu.searchbox.settings.teenager.util.TeenagerConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/guid/ITeenagerGuidResourceHelper;", "", "fetchAgreementImgResourceId", "", "hasAgreeAgreement", "", "fetchTeenagerGuidContentTextId", "fetchTeenagerGuidImgResourceId", "teenagerMode", "fetchTeenagerGuidModifyPwdVisibility", "hasPassword", "fetchTeenagerGuidOpenTextId", "fetchTeenagerGuidShowFrom", "", "fetchTeenagerGuidShowPage", "fetchTeenagerGuidShowType", "fetchTeenagerGuidShowValue", "fetchTeenagerGuidStateColorId", "fetchTeenagerGuidStateTextId", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ITeenagerGuidResourceHelper.kt */
public interface ITeenagerGuidResourceHelper {
    int fetchAgreementImgResourceId(boolean z);

    int fetchTeenagerGuidContentTextId();

    int fetchTeenagerGuidImgResourceId(boolean z);

    int fetchTeenagerGuidModifyPwdVisibility(boolean z, boolean z2);

    int fetchTeenagerGuidOpenTextId(boolean z);

    String fetchTeenagerGuidShowFrom(boolean z, boolean z2);

    String fetchTeenagerGuidShowPage(boolean z, boolean z2);

    String fetchTeenagerGuidShowType(boolean z, boolean z2);

    String fetchTeenagerGuidShowValue(boolean z, boolean z2);

    int fetchTeenagerGuidStateColorId(boolean z);

    int fetchTeenagerGuidStateTextId(boolean z);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ITeenagerGuidResourceHelper.kt */
    public static final class DefaultImpls {
        public static int fetchTeenagerGuidImgResourceId(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean teenagerMode) {
            if (teenagerMode) {
                return R.drawable.setting_teenager_guid_opened;
            }
            return R.drawable.setting_teenager_guid_closed;
        }

        public static int fetchTeenagerGuidStateTextId(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean teenagerMode) {
            if (teenagerMode) {
                return R.string.setting_teenager_title_opened;
            }
            return R.string.setting_teenager_title_closed;
        }

        public static int fetchTeenagerGuidStateColorId(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean teenagerMode) {
            if (teenagerMode) {
                return com.baidu.android.common.ui.style.R.color.GC68;
            }
            return com.baidu.android.common.ui.style.R.color.GC1;
        }

        public static int fetchTeenagerGuidOpenTextId(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean teenagerMode) {
            if (teenagerMode) {
                return R.string.setting_teenager_close;
            }
            return R.string.setting_teenager_open;
        }

        public static int fetchTeenagerGuidContentTextId(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper) {
            return R.string.setting_teenager_desc_default;
        }

        public static int fetchTeenagerGuidModifyPwdVisibility(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean teenagerMode, boolean hasPassword) {
            if (teenagerMode || hasPassword) {
                return 0;
            }
            return 8;
        }

        public static String fetchTeenagerGuidShowType(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean teenagerMode, boolean hasPassword) {
            if (teenagerMode) {
                return TeenagerConstants.UBC_TYPE_ON_SHOW;
            }
            return TeenagerConstants.UBC_TYPE_OFF_SHOW;
        }

        public static String fetchTeenagerGuidShowPage(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean teenagerMode, boolean hasPassword) {
            if (teenagerMode) {
                return "mode_on";
            }
            return TeenagerConstants.UBC_PAGE_MODE_OFF;
        }

        public static String fetchTeenagerGuidShowFrom(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean teenagerMode, boolean hasPassword) {
            return "tool";
        }

        public static String fetchTeenagerGuidShowValue(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean teenagerMode, boolean hasPassword) {
            return "show";
        }

        public static int fetchAgreementImgResourceId(ITeenagerGuidResourceHelper iTeenagerGuidResourceHelper, boolean hasAgreeAgreement) {
            if (hasAgreeAgreement) {
                return R.drawable.setting_teenager_agreement_selected;
            }
            return R.drawable.setting_teenager_agreement;
        }
    }
}
