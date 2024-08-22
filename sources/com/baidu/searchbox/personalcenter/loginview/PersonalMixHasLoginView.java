package com.baidu.searchbox.personalcenter.loginview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.baidu.android.app.account.BoxSapiAccountManager;
import com.baidu.android.ext.widget.dialog.BdDialog;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.event.UploadPortraitSuccessEvent;
import com.baidu.searchbox.account.userinfo.activity.PortraitSettingActivity;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdpfont.utils.BDPFont;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.dynamicavatar.RoundDynamicAvatarLayout;
import com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionBasicInfoModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel;
import com.baidu.searchbox.personalcenter.PersonalCenterUbc;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.personalcenter.utils.PersonalAvatarAreaUtil;
import com.baidu.searchbox.personalcenter.utils.PersonalUIUitlsKt;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.BdBaseLottieView;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 t2\u00020\u0001:\u0001tB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010L\u001a\u00020M2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u0011H\u0016J\u0014\u0010O\u001a\u0004\u0018\u00010@2\b\u0010P\u001a\u0004\u0018\u00010@H\u0002J\u0012\u0010Q\u001a\u00020\u00072\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010T\u001a\u0004\u0018\u00010!J\u0012\u0010U\u001a\u00020\u00072\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010V\u001a\u00020M2\u0006\u0010W\u001a\u00020%H\u0002J\b\u0010X\u001a\u00020MH\u0003J\b\u0010Y\u001a\u00020MH\u0002J\b\u0010Z\u001a\u00020MH\u0002J\b\u0010[\u001a\u00020MH\u0016J\b\u0010\\\u001a\u00020MH\u0016J\b\u0010]\u001a\u00020MH\u0016J\"\u0010^\u001a\u00020M2\b\u0010_\u001a\u0004\u0018\u00010@2\u0006\u0010`\u001a\u00020\u00112\u0006\u0010a\u001a\u00020\u0011H\u0002J\b\u0010b\u001a\u00020MH\u0002J$\u0010c\u001a\u00020M2\u0006\u0010d\u001a\u00020\u00182\b\u0010e\u001a\u0004\u0018\u00010@2\b\u0010f\u001a\u0004\u0018\u00010@H\u0002J$\u0010g\u001a\u00020M2\b\u0010h\u001a\u0004\u0018\u00010@2\b\u0010i\u001a\u0004\u0018\u00010@2\u0006\u0010j\u001a\u00020\u0011H\u0002J\u0018\u0010k\u001a\u00020M2\u0006\u0010l\u001a\u00020m2\u0006\u0010j\u001a\u00020\u0011H\u0002J\u0012\u0010n\u001a\u00020M2\b\u0010o\u001a\u0004\u0018\u00010@H\u0003J\b\u0010p\u001a\u00020MH\u0007J\u0010\u0010q\u001a\u00020M2\u0006\u0010j\u001a\u00020\u0011H\u0016J\b\u0010r\u001a\u00020MH\u0016J\b\u0010s\u001a\u00020MH\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n \u001c*\u0004\u0018\u00010000X\u0004¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\n \u001c*\u0004\u0018\u00010202X\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\n \u001c*\u0004\u0018\u00010404X\u0004¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\n \u001c*\u0004\u0018\u00010606X\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\n \u001c*\u0004\u0018\u00010404X\u0004¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\n \u001c*\u0004\u0018\u00010909X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n \u001c*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\n \u001c*\u0004\u0018\u00010<0<X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n \u001c*\u0004\u0018\u00010%0%X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n \u001c*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/baidu/searchbox/personalcenter/loginview/PersonalMixHasLoginView;", "Lcom/baidu/searchbox/personalcenter/loginview/PersonalHasLoginBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarAreaShowType", "gotoPersonalPageClickListener", "Landroid/view/View$OnClickListener;", "getGotoPersonalPageClickListener", "()Landroid/view/View$OnClickListener;", "setGotoPersonalPageClickListener", "(Landroid/view/View$OnClickListener;)V", "hasJumpedPortraitSettingActivity", "", "getHasJumpedPortraitSettingActivity", "()Z", "setHasJumpedPortraitSettingActivity", "(Z)V", "hasTheme", "mAuthentication", "Landroid/widget/TextView;", "mAuthenticationBtn", "mAvatarOrnament", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "mButtonArea", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mContentCount", "mContentCountLayout", "Landroid/widget/LinearLayout;", "getMContentCountLayout", "()Landroid/widget/LinearLayout;", "mContentDistanceView", "Landroid/view/View;", "mContentText", "mCountLayout", "mEditBtn", "mFansCount", "mFansNumLayout", "mFansText", "mFollowCount", "mFollowNumLayout", "mFollowText", "mGotoCenter", "Landroid/widget/ImageView;", "mLoginImg", "Lcom/baidu/searchbox/dynamicavatar/VipDynamicAvatarView;", "mLoginImgClip", "Lcom/baidu/searchbox/dynamicavatar/RoundDynamicAvatarLayout;", "mLoginImgShadow", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "mLoginImgWrapper", "mLoginManager", "Lcom/baidu/searchbox/account/BoxAccountManager;", "mLoginName", "mLoginNameParent", "Landroid/widget/RelativeLayout;", "mLoginView", "mLoginViewContainer", "mUserHomeBaseScheme", "", "getMUserHomeBaseScheme", "()Ljava/lang/String;", "setMUserHomeBaseScheme", "(Ljava/lang/String;)V", "mVIcon", "Lcom/baidu/searchbox/ui/BdBaseLottieView;", "mZanCount", "mZanCountLayout", "mZanText", "personalAvatarAreaUtil", "Lcom/baidu/searchbox/personalcenter/utils/PersonalAvatarAreaUtil;", "changeTheme", "", "hasAFXBg", "formatNickName", "nickname", "getContentBottomDistanceToRootView", "rootView", "Landroid/view/ViewGroup;", "getContentCountLayout", "getContentTopDistanceToRootView", "gotoHomePage", "viewClicked", "initListeners", "initView", "onCountLayoutFontSizeChanged", "onDestroy", "onPause", "onResume", "openUrlWithLightBrowser", "url", "isShowToolBor", "isFullScreen", "registerListener", "setCountLayoutText", "view", "num", "unit", "setLoginDecorateUri", "ornaments", "ornamentsId", "ubcEnable", "setLoginImageUri", "ba", "Lcom/baidu/searchbox/account/data/BoxAccount;", "showThumbsUpDialog", "zanCount", "updateData", "updateLoginStatus", "updateSize", "updateUI", "Companion", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalMixHasLoginView.kt */
public final class PersonalMixHasLoginView extends PersonalHasLoginBaseView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SCHEME_BJH = "baiduboxapp://swan/jEwtEbQQTgu7i8brHEM0Qb9QlliHL0q5/pages/newmodify/index?from=homepage";
    public static final String SCHEME_BJH_H5 = "baiduboxapp://v1/easybrowse/open?from=homepage&layoutfullscreen=1&barcolor=00000000&backlocation=1&newbrowser=1&style=%7B%22toolbaricons%22%3A%7B%22template_id%22%3A2%7D%7D&url=https%3A%2F%2Fbaijiahao.baidu.com%2Fbuilder%2Fh5%2Fpass%2Fauth%2Fmodify%3Ffrom%3Dhaozhuyeronghe";
    /* access modifiers changed from: private */
    public static boolean mNeedAccountRequest;
    public Map<Integer, View> _$_findViewCache;
    private int avatarAreaShowType;
    private View.OnClickListener gotoPersonalPageClickListener;
    private boolean hasJumpedPortraitSettingActivity;
    private boolean hasTheme;
    private final TextView mAuthentication;
    private final TextView mAuthenticationBtn;
    private final SimpleDraweeView mAvatarOrnament;
    private final ConstraintLayout mButtonArea;
    private final TextView mContentCount;
    private final LinearLayout mContentCountLayout;
    private final View mContentDistanceView;
    private final TextView mContentText;
    private final LinearLayout mCountLayout;
    private final TextView mEditBtn;
    private final TextView mFansCount;
    private final LinearLayout mFansNumLayout;
    private final TextView mFansText;
    private final TextView mFollowCount;
    private final LinearLayout mFollowNumLayout;
    private final TextView mFollowText;
    private final ImageView mGotoCenter;
    private final VipDynamicAvatarView mLoginImg;
    private final RoundDynamicAvatarLayout mLoginImgClip;
    private final BdBaseImageView mLoginImgShadow;
    private final RoundDynamicAvatarLayout mLoginImgWrapper;
    /* access modifiers changed from: private */
    public final BoxAccountManager mLoginManager;
    private final TextView mLoginName;
    private final RelativeLayout mLoginNameParent;
    private final View mLoginView;
    private final ConstraintLayout mLoginViewContainer;
    private String mUserHomeBaseScheme;
    private final BdBaseLottieView mVIcon;
    private final TextView mZanCount;
    private final LinearLayout mZanCountLayout;
    private final TextView mZanText;
    private final PersonalAvatarAreaUtil personalAvatarAreaUtil;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PersonalMixHasLoginView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PersonalMixHasLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalMixHasLoginView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View inflate = LayoutInflater.from(context).inflate(R.layout.personal_author_head_has_login_view, this, true);
        this.mLoginView = inflate;
        this.mLoginViewContainer = (ConstraintLayout) inflate.findViewById(R.id.login_view_container);
        this.mLoginImgShadow = (BdBaseImageView) inflate.findViewById(R.id.login_img_shadow);
        View findViewById = inflate.findViewById(R.id.login_img);
        ((VipDynamicAvatarView) findViewById).setOnStartGifCallback(PersonalMixHasLoginView$mLoginImg$1$1.INSTANCE);
        VipDynamicAvatarView vipDynamicAvatarView = (VipDynamicAvatarView) findViewById;
        this.mLoginImg = vipDynamicAvatarView;
        View findViewById2 = inflate.findViewById(R.id.login_img_container);
        RoundDynamicAvatarLayout $this$mLoginImgWrapper_u24lambda_u2d1 = (RoundDynamicAvatarLayout) findViewById2;
        $this$mLoginImgWrapper_u24lambda_u2d1.setCorner((float) DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 29.0f));
        $this$mLoginImgWrapper_u24lambda_u2d1.setStrokeWidth((float) DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 3.0f));
        $this$mLoginImgWrapper_u24lambda_u2d1.setStrokeColor($this$mLoginImgWrapper_u24lambda_u2d1.getResources().getColor(R.color.GC85));
        this.mLoginImgWrapper = (RoundDynamicAvatarLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.login_img_clip);
        ((RoundDynamicAvatarLayout) findViewById3).setStrokeColor(0);
        this.mLoginImgClip = (RoundDynamicAvatarLayout) findViewById3;
        this.mAvatarOrnament = (SimpleDraweeView) inflate.findViewById(R.id.avatar_ornament);
        this.mLoginNameParent = (RelativeLayout) inflate.findViewById(R.id.login_name_parent);
        this.mLoginName = (TextView) inflate.findViewById(R.id.login_name);
        this.mGotoCenter = (ImageView) inflate.findViewById(R.id.goto_center);
        this.mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        this.personalAvatarAreaUtil = new PersonalAvatarAreaUtil();
        this.mUserHomeBaseScheme = "";
        View findViewById4 = inflate.findViewById(R.id.count_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mLoginView.findViewById(R.id.count_layout)");
        this.mCountLayout = (LinearLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.content_count);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mLoginView.findViewById(R.id.content_count)");
        this.mContentCount = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.content_count_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mLoginView.findViewById(R.id.content_count_layout)");
        this.mContentCountLayout = (LinearLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.content_text);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mLoginView.findViewById(R.id.content_text)");
        this.mContentText = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.zan_count_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mLoginView.findViewById(R.id.zan_count_layout)");
        this.mZanCountLayout = (LinearLayout) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.zan_count);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mLoginView.findViewById(R.id.zan_count)");
        this.mZanCount = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.zan_text);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mLoginView.findViewById(R.id.zan_text)");
        this.mZanText = (TextView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.follow_num_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mLoginView.findViewById(R.id.follow_num_layout)");
        this.mFollowNumLayout = (LinearLayout) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.follow_count);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mLoginView.findViewById(R.id.follow_count)");
        this.mFollowCount = (TextView) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.follow_text);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mLoginView.findViewById(R.id.follow_text)");
        this.mFollowText = (TextView) findViewById13;
        View findViewById14 = inflate.findViewById(R.id.fans_num_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mLoginView.findViewById(R.id.fans_num_layout)");
        this.mFansNumLayout = (LinearLayout) findViewById14;
        View findViewById15 = inflate.findViewById(R.id.fans_count);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "mLoginView.findViewById(R.id.fans_count)");
        this.mFansCount = (TextView) findViewById15;
        View findViewById16 = inflate.findViewById(R.id.fans_text);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "mLoginView.findViewById(R.id.fans_text)");
        this.mFansText = (TextView) findViewById16;
        View findViewById17 = inflate.findViewById(R.id.edit_button);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "mLoginView.findViewById(R.id.edit_button)");
        this.mEditBtn = (TextView) findViewById17;
        View findViewById18 = inflate.findViewById(R.id.identification_button);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "mLoginView.findViewById(…id.identification_button)");
        this.mAuthenticationBtn = (TextView) findViewById18;
        View findViewById19 = inflate.findViewById(R.id.authentication);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "mLoginView.findViewById(R.id.authentication)");
        this.mAuthentication = (TextView) findViewById19;
        View findViewById20 = inflate.findViewById(R.id.content_distance_view);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "mLoginView.findViewById(…id.content_distance_view)");
        this.mContentDistanceView = findViewById20;
        View findViewById21 = inflate.findViewById(R.id.button_area);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "mLoginView.findViewById(R.id.button_area)");
        this.mButtonArea = (ConstraintLayout) findViewById21;
        View findViewById22 = inflate.findViewById(R.id.v_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "mLoginView.findViewById(R.id.v_icon)");
        this.mVIcon = (BdBaseLottieView) findViewById22;
        ((GenericDraweeHierarchy) vipDynamicAvatarView.getHierarchy()).setFadeDuration(0);
        initView();
        initListeners();
        registerListener();
        updateData();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PersonalMixHasLoginView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final View.OnClickListener getGotoPersonalPageClickListener() {
        return this.gotoPersonalPageClickListener;
    }

    public final void setGotoPersonalPageClickListener(View.OnClickListener onClickListener) {
        this.gotoPersonalPageClickListener = onClickListener;
    }

    public final boolean getHasJumpedPortraitSettingActivity() {
        return this.hasJumpedPortraitSettingActivity;
    }

    public final void setHasJumpedPortraitSettingActivity(boolean z) {
        this.hasJumpedPortraitSettingActivity = z;
    }

    public final String getMUserHomeBaseScheme() {
        return this.mUserHomeBaseScheme;
    }

    public final void setMUserHomeBaseScheme(String str) {
        this.mUserHomeBaseScheme = str;
    }

    public final LinearLayout getMContentCountLayout() {
        return this.mContentCountLayout;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/personalcenter/loginview/PersonalMixHasLoginView$Companion;", "", "()V", "SCHEME_BJH", "", "SCHEME_BJH_H5", "mNeedAccountRequest", "", "getMNeedAccountRequest", "()Z", "setMNeedAccountRequest", "(Z)V", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalMixHasLoginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getMNeedAccountRequest() {
            return PersonalMixHasLoginView.mNeedAccountRequest;
        }

        public final void setMNeedAccountRequest(boolean z) {
            PersonalMixHasLoginView.mNeedAccountRequest = z;
        }
    }

    private final void initView() {
        this.mContentCount.setTypeface(BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME));
        this.mZanCount.setTypeface(BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME));
        this.mFollowCount.setTypeface(BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME));
        this.mFansCount.setTypeface(BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME));
    }

    private final void initListeners() {
        this.mEditBtn.setOnTouchListener(new TouchStateListener());
        this.mLoginNameParent.setOnTouchListener(new TouchStateListener());
        this.mLoginNameParent.setOnClickListener(new PersonalMixHasLoginView$$ExternalSyntheticLambda3(this));
        this.mLoginImg.setOnClickListener(new PersonalMixHasLoginView$$ExternalSyntheticLambda4(this));
        this.mEditBtn.setOnClickListener(new PersonalMixHasLoginView$$ExternalSyntheticLambda5(this));
        this.mFollowNumLayout.setOnClickListener(new PersonalMixHasLoginView$$ExternalSyntheticLambda6(this));
        this.mFansNumLayout.setOnClickListener(new PersonalMixHasLoginView$$ExternalSyntheticLambda7(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initListeners$lambda-3  reason: not valid java name */
    public static final void m2223initListeners$lambda3(PersonalMixHasLoginView this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.gotoPersonalPageClickListener;
        if (onClickListener != null) {
            if (onClickListener != null) {
                onClickListener.onClick(v);
            }
            PersonCenterUBCStatistic.statisticUBC(PersonalConstants.TYPE_ACCOUNT, (String) null, "nickname", "wode", PersonalConstants.UBC_PERSONAL_HEADER_CLICK);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initListeners$lambda-4  reason: not valid java name */
    public static final void m2224initListeners$lambda4(PersonalMixHasLoginView this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (1 != this$0.avatarAreaShowType) {
            Intrinsics.checkNotNullExpressionValue(v, "v");
            this$0.gotoHomePage(v);
        } else if (this$0.getContext() instanceof Activity) {
            Intent intent = new Intent(this$0.getContext(), PortraitSettingActivity.class);
            intent.putExtra("extra_is_show_tool_bar_key", false);
            this$0.getContext().startActivity(intent);
            this$0.hasJumpedPortraitSettingActivity = true;
            PersonalCenterUbc.clickAvatarGuid();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getBoxAccount();
     */
    /* renamed from: initListeners$lambda-5  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2225initListeners$lambda5(com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView r7, android.view.View r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.baidu.searchbox.account.BoxAccountManager r0 = r7.mLoginManager
            r1 = 0
            if (r0 == 0) goto L_0x0016
            com.baidu.searchbox.account.data.BoxAccount r0 = r0.getBoxAccount()
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.getUserType()
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            java.lang.String r2 = "0"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0048
            android.content.Context r2 = r7.getContext()
            boolean r2 = r2 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0051
            android.content.Intent r2 = new android.content.Intent
            android.content.Context r3 = r7.getContext()
            java.lang.Class<com.baidu.searchbox.account.userinfo.activity.AccountUserInfoEditActivity> r4 = com.baidu.searchbox.account.userinfo.activity.AccountUserInfoEditActivity.class
            r2.<init>(r3, r4)
            android.content.Context r3 = r7.getContext()
            r3.startActivity(r2)
            int r3 = com.baidu.android.common.ui.style.R.anim.slide_in_from_right
            int r4 = com.baidu.android.common.ui.style.R.anim.slide_out_to_left
            int r5 = com.baidu.android.common.ui.style.R.anim.slide_in_from_left
            int r6 = com.baidu.android.common.ui.style.R.anim.slide_out_to_right
            com.baidu.searchbox.appframework.BaseActivity.setNextPendingTransition(r3, r4, r5, r6)
            goto L_0x0051
        L_0x0048:
            android.content.Context r2 = r7.getContext()
            java.lang.String r3 = "baiduboxapp://v1/easybrowse/open?from=homepage&layoutfullscreen=1&barcolor=00000000&backlocation=1&newbrowser=1&style=%7B%22toolbaricons%22%3A%7B%22template_id%22%3A2%7D%7D&url=https%3A%2F%2Fbaijiahao.baidu.com%2Fbuilder%2Fh5%2Fpass%2Fauth%2Fmodify%3Ffrom%3Dhaozhuyeronghe"
            com.baidu.searchbox.Router.invoke(r2, r3)
        L_0x0051:
            java.lang.String r2 = "edit_data"
            java.lang.String r3 = "click"
            java.lang.String r4 = "wode"
            java.lang.String r5 = "192"
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBC(r2, r1, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView.m2225initListeners$lambda5(com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView, android.view.View):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getBoxAccount();
     */
    /* renamed from: initListeners$lambda-6  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2226initListeners$lambda6(com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView r6, android.view.View r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.baidu.searchbox.account.BoxAccountManager r0 = r6.mLoginManager
            r1 = 0
            if (r0 == 0) goto L_0x0016
            com.baidu.searchbox.account.data.BoxAccount r0 = r0.getBoxAccount()
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.getUk()
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.baidu.searchbox.config.HostConfig.getSearchboxHostForHttps()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "/webpage?action=personaljump&type=subscribe&uk="
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "&jump=sub"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 1
            r4 = 0
            r6.openUrlWithLightBrowser(r2, r3, r4)
            java.lang.String r3 = "guanzhu"
            java.lang.String r4 = "wode"
            java.lang.String r5 = "179"
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBC(r3, r1, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView.m2226initListeners$lambda6(com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView, android.view.View):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getBoxAccount();
     */
    /* renamed from: initListeners$lambda-7  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2227initListeners$lambda7(com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView r6, android.view.View r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.baidu.searchbox.account.BoxAccountManager r0 = r6.mLoginManager
            r1 = 0
            if (r0 == 0) goto L_0x0016
            com.baidu.searchbox.account.data.BoxAccount r0 = r0.getBoxAccount()
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.getUk()
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.baidu.searchbox.config.HostConfig.getSearchboxHostForHttps()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "/webpage?action=personaljump&type=subscribe&uk="
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "&jump=fans"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 1
            r4 = 0
            r6.openUrlWithLightBrowser(r2, r3, r4)
            java.lang.String r3 = "fensi"
            java.lang.String r4 = "wode"
            java.lang.String r5 = "179"
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBC(r3, r1, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView.m2227initListeners$lambda7(com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView, android.view.View):void");
    }

    private final void gotoHomePage(View viewClicked) {
        View.OnClickListener onClickListener = this.gotoPersonalPageClickListener;
        if (onClickListener != null) {
            if (onClickListener != null) {
                onClickListener.onClick(viewClicked);
            }
            PersonalCenterUbc.clickHeader("touxiang");
        }
    }

    private final void registerListener() {
        BdEventBus.Companion.getDefault().register(this, UploadPortraitSuccessEvent.class, 1, new PersonalMixHasLoginView$registerListener$1(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00eb, code lost:
        if ((r5 == null || kotlin.text.StringsKt.isBlank(r5)) == false) goto L_0x00ed;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0200  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateData() {
        /*
            r16 = this;
            r0 = r16
            android.widget.TextView r1 = r0.mContentCount
            java.lang.String r2 = "0"
            java.lang.String r3 = ""
            r0.setCountLayoutText(r1, r2, r3)
            android.widget.TextView r1 = r0.mZanCount
            r0.setCountLayoutText(r1, r2, r3)
            android.widget.TextView r1 = r0.mFollowCount
            r0.setCountLayoutText(r1, r2, r3)
            android.widget.TextView r1 = r0.mFansCount
            r0.setCountLayoutText(r1, r2, r3)
            android.widget.TextView r1 = r0.mAuthenticationBtn
            r4 = 8
            r1.setVisibility(r4)
            com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper r1 = com.baidu.searchbox.personal.manager.PersonalizedDataManagerWrapper.INSTANCE
            com.baidu.searchbox.kmm.personalcenter.PersonalCenterDataMgr r1 = r1.getManager()
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterDataWrapper r1 = com.baidu.searchbox.kmm.personalcenter.PersonalCenterDataMgrFusionExtKt.getFusionData(r1)
            if (r1 == 0) goto L_0x024e
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel r1 = r1.getFusionHomeModel()
            if (r1 != 0) goto L_0x0035
            goto L_0x024e
        L_0x0035:
            android.widget.TextView r5 = r0.mAuthenticationBtn
            com.baidu.searchbox.ui.TouchStateListener r6 = new com.baidu.searchbox.ui.TouchStateListener
            r6.<init>()
            android.view.View$OnTouchListener r6 = (android.view.View.OnTouchListener) r6
            r5.setOnTouchListener(r6)
            android.widget.LinearLayout r5 = r0.mContentCountLayout
            com.baidu.searchbox.ui.TouchStateListener r6 = new com.baidu.searchbox.ui.TouchStateListener
            r6.<init>()
            android.view.View$OnTouchListener r6 = (android.view.View.OnTouchListener) r6
            r5.setOnTouchListener(r6)
            android.widget.LinearLayout r5 = r0.mZanCountLayout
            com.baidu.searchbox.ui.TouchStateListener r6 = new com.baidu.searchbox.ui.TouchStateListener
            r6.<init>()
            android.view.View$OnTouchListener r6 = (android.view.View.OnTouchListener) r6
            r5.setOnTouchListener(r6)
            android.widget.LinearLayout r5 = r0.mFollowNumLayout
            com.baidu.searchbox.ui.TouchStateListener r6 = new com.baidu.searchbox.ui.TouchStateListener
            r6.<init>()
            android.view.View$OnTouchListener r6 = (android.view.View.OnTouchListener) r6
            r5.setOnTouchListener(r6)
            android.widget.LinearLayout r5 = r0.mFansNumLayout
            com.baidu.searchbox.ui.TouchStateListener r6 = new com.baidu.searchbox.ui.TouchStateListener
            r6.<init>()
            android.view.View$OnTouchListener r6 = (android.view.View.OnTouchListener) r6
            r5.setOnTouchListener(r6)
            android.widget.TextView r5 = r0.mAuthentication
            com.baidu.searchbox.ui.TouchStateListener r6 = new com.baidu.searchbox.ui.TouchStateListener
            r6.<init>()
            android.view.View$OnTouchListener r6 = (android.view.View.OnTouchListener) r6
            r5.setOnTouchListener(r6)
            java.lang.String r5 = r1.getBaseScheme()
            if (r5 != 0) goto L_0x0084
            r5 = r3
        L_0x0084:
            r0.mUserHomeBaseScheme = r5
            android.widget.TextView r5 = r0.mContentCount
            java.lang.String r6 = r1.getContentNum()
            java.lang.String r7 = r1.getContentNumUnit()
            r0.setCountLayoutText(r5, r6, r7)
            android.widget.TextView r5 = r0.mZanCount
            java.lang.String r6 = r1.getZanNum()
            java.lang.String r7 = r1.getZanNumUnit()
            r0.setCountLayoutText(r5, r6, r7)
            android.widget.TextView r5 = r0.mFollowCount
            java.lang.String r6 = r1.getFollowNum()
            java.lang.String r7 = r1.getFollowNumUnit()
            r0.setCountLayoutText(r5, r6, r7)
            android.widget.TextView r5 = r0.mFansCount
            java.lang.String r6 = r1.getFansNum()
            java.lang.String r7 = r1.getFansNumUnit()
            r0.setCountLayoutText(r5, r6, r7)
            java.lang.String r5 = r1.getAuthCmd()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x00cd
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L_0x00cb
            goto L_0x00cd
        L_0x00cb:
            r5 = r7
            goto L_0x00ce
        L_0x00cd:
            r5 = r6
        L_0x00ce:
            java.lang.String r8 = "192"
            java.lang.String r9 = "wode"
            java.lang.String r10 = "show"
            r11 = 0
            if (r5 == 0) goto L_0x00ed
            java.lang.String r5 = r1.getAuthUrl()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x00ea
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L_0x00e8
            goto L_0x00ea
        L_0x00e8:
            r5 = r7
            goto L_0x00eb
        L_0x00ea:
            r5 = r6
        L_0x00eb:
            if (r5 != 0) goto L_0x014e
        L_0x00ed:
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            r5.element = r3
            java.lang.Boolean r3 = r1.isAuth()
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r12)
            if (r3 == 0) goto L_0x011d
            android.widget.TextView r3 = r0.mAuthenticationBtn
            android.content.Context r12 = r16.getContext()
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.baidu.searchbox.personalcenter.R.string.personal_certification_me
            java.lang.String r12 = r12.getString(r13)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r3.setText(r12)
            java.lang.String r3 = "renzheng_mine"
            r5.element = r3
            goto L_0x0137
        L_0x011d:
            android.widget.TextView r3 = r0.mAuthenticationBtn
            android.content.Context r12 = r16.getContext()
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.baidu.searchbox.personalcenter.R.string.personal_certification_apply
            java.lang.String r12 = r12.getString(r13)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r3.setText(r12)
            java.lang.String r3 = "renzheng_apply"
            r5.element = r3
        L_0x0137:
            T r3 = r5.element
            java.lang.String r3 = (java.lang.String) r3
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBC(r3, r11, r10, r9, r8)
            android.widget.TextView r3 = r0.mAuthenticationBtn
            com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView$$ExternalSyntheticLambda0 r12 = new com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView$$ExternalSyntheticLambda0
            r12.<init>(r0, r1, r5)
            r3.setOnClickListener(r12)
            android.widget.TextView r3 = r0.mAuthenticationBtn
            r3.setVisibility(r7)
        L_0x014e:
            android.widget.LinearLayout r3 = r0.mZanCountLayout
            com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView$$ExternalSyntheticLambda1 r5 = new com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView$$ExternalSyntheticLambda1
            r5.<init>(r0, r1)
            r3.setOnClickListener(r5)
            java.util.List r3 = r1.getBasicInfos()
            if (r3 == 0) goto L_0x0189
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r5 = 0
            java.util.Iterator r12 = r3.iterator()
        L_0x0165:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0185
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionBasicInfoModel r14 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionBasicInfoModel) r14
            r15 = 0
            java.lang.String r6 = r14.getType()
            java.lang.String r4 = "v_intro"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0181
            goto L_0x0186
        L_0x0181:
            r4 = 8
            r6 = 1
            goto L_0x0165
        L_0x0185:
            r13 = r11
        L_0x0186:
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionBasicInfoModel r13 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionBasicInfoModel) r13
            goto L_0x018a
        L_0x0189:
            r13 = r11
        L_0x018a:
            r3 = r13
            if (r3 == 0) goto L_0x01c4
            java.lang.String r4 = r3.getContent()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x019e
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L_0x019c
            goto L_0x019e
        L_0x019c:
            r6 = r7
            goto L_0x019f
        L_0x019e:
            r6 = 1
        L_0x019f:
            if (r6 != 0) goto L_0x01c4
            android.widget.TextView r4 = r0.mAuthentication
            r4.setVisibility(r7)
            android.widget.TextView r4 = r0.mAuthentication
            java.lang.String r5 = r3.getContent()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            android.widget.TextView r4 = r0.mAuthentication
            com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView$$ExternalSyntheticLambda2 r5 = new com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView$$ExternalSyntheticLambda2
            r5.<init>(r0, r3)
            r4.setOnClickListener(r5)
            java.lang.String r4 = "renzheng_data"
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBC(r4, r11, r10, r9, r8)
            goto L_0x01cb
        L_0x01c4:
            android.widget.TextView r4 = r0.mAuthentication
            r5 = 8
            r4.setVisibility(r5)
        L_0x01cb:
            java.lang.String r4 = r1.getVType()
            if (r4 != 0) goto L_0x01d2
            goto L_0x01d3
        L_0x01d2:
            r2 = r4
        L_0x01d3:
            com.baidu.searchbox.ui.BdBaseLottieView r4 = r0.mVIcon
            r4.setVisibility(r7)
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "1"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 == 0) goto L_0x0200
            com.baidu.searchbox.ui.BdBaseLottieView r4 = r0.mVIcon
            int r5 = com.baidu.searchbox.personalcenter.R.drawable.red_v_icon
            r4.setImageResource(r5)
            com.baidu.searchbox.ui.BdBaseLottieView r4 = r0.mVIcon
            java.lang.String r5 = "lottie/red_v_icon_day.json"
            r4.setAnimation((java.lang.String) r5)
            com.baidu.searchbox.ui.BdBaseLottieView r4 = r0.mVIcon
            r5 = 2
            r4.setRepeatCount(r5)
            com.baidu.searchbox.ui.BdBaseLottieView r4 = r0.mVIcon
            r4.playAnimation()
            goto L_0x0246
        L_0x0200:
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "2"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 == 0) goto L_0x0215
            com.baidu.searchbox.ui.BdBaseLottieView r4 = r0.mVIcon
            int r5 = com.baidu.searchbox.personalcenter.R.drawable.blue_v_icon
            r4.setImageResource(r5)
            goto L_0x0246
        L_0x0215:
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "3"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 == 0) goto L_0x022a
            com.baidu.searchbox.ui.BdBaseLottieView r4 = r0.mVIcon
            int r5 = com.baidu.searchbox.personalcenter.R.drawable.yellow_v_icon
            r4.setImageResource(r5)
            goto L_0x0246
        L_0x022a:
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "10"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 == 0) goto L_0x023f
            com.baidu.searchbox.ui.BdBaseLottieView r4 = r0.mVIcon
            int r5 = com.baidu.searchbox.personalcenter.R.drawable.hua_v_icon
            r4.setImageResource(r5)
            goto L_0x0246
        L_0x023f:
            com.baidu.searchbox.ui.BdBaseLottieView r4 = r0.mVIcon
            r5 = 8
            r4.setVisibility(r5)
        L_0x0246:
            java.lang.String r4 = "edit_data"
            com.baidu.searchbox.utils.PersonCenterUBCStatistic.statisticUBC(r4, r11, r10, r9, r8)
            return
        L_0x024e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView.updateData():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: updateData$lambda-9  reason: not valid java name */
    public static final void m2230updateData$lambda9(PersonalMixHasLoginView this$0, PersonalCenterFusionHomeModel $fusionHomeModel, Ref.ObjectRef $authenticationType, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($fusionHomeModel, "$fusionHomeModel");
        Intrinsics.checkNotNullParameter($authenticationType, "$authenticationType");
        Context mContext = this$0.getContext();
        if (mContext != null) {
            if (!TextUtils.isEmpty($fusionHomeModel.getAuthCmd())) {
                Router.invoke(mContext, $fusionHomeModel.getAuthCmd());
            } else {
                this$0.openUrlWithLightBrowser($fusionHomeModel.getAuthUrl(), false, false);
            }
            PersonCenterUBCStatistic.statisticUBC((String) $authenticationType.element, (String) null, "click", "wode", "192");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateData$lambda-10  reason: not valid java name */
    public static final void m2228updateData$lambda10(PersonalMixHasLoginView this$0, PersonalCenterFusionHomeModel $fusionHomeModel, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($fusionHomeModel, "$fusionHomeModel");
        this$0.showThumbsUpDialog($fusionHomeModel.getZanTotalCount());
        PersonCenterUBCStatistic.statisticUBC(PersonalConstants.HUO_ZAN, (String) null, "wode", "179");
    }

    /* access modifiers changed from: private */
    /* renamed from: updateData$lambda-13  reason: not valid java name */
    public static final void m2229updateData$lambda13(PersonalMixHasLoginView this$0, PersonalCenterFusionBasicInfoModel $basicInfo, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context mContext = this$0.getContext();
        if (mContext != null) {
            if (!TextUtils.isEmpty($basicInfo.getCmd())) {
                Router.invoke(mContext, $basicInfo.getCmd());
            } else {
                this$0.openUrlWithLightBrowser($basicInfo.getUrl(), false, true);
            }
            PersonCenterUBCStatistic.statisticUBC(PersonalConstants.RENZHENG_DATA, (String) null, "click", "wode", "192");
        }
    }

    public void onResume() {
        this.hasJumpedPortraitSettingActivity = false;
    }

    public void onPause() {
        this.mLoginImg.setPicStopPlay(false);
    }

    public void onDestroy() {
        BdEventBus.Companion.getDefault().unregister(this);
    }

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    public void updateLoginStatus(boolean ubcEnable) {
        BoxAccount ba = this.mLoginManager.getBoxAccount();
        this.mLoginName.setText(formatNickName(ba.nickname));
        try {
            Intrinsics.checkNotNullExpressionValue(ba, "ba");
            setLoginImageUri(ba, ubcEnable);
            if (mNeedAccountRequest) {
                mNeedAccountRequest = false;
                BoxAccountManager boxAccountManager = this.mLoginManager;
                if (boxAccountManager != null) {
                    ((BoxSapiAccountManager) boxAccountManager).getAccountInfoFromServer(new PersonalMixHasLoginView$updateLoginStatus$1(this, ubcEnable));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.app.account.BoxSapiAccountManager");
            }
            setLoginDecorateUri(ba.getOrnament(), ba.getOrnamentId(), ubcEnable);
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setLoginDecorateUri(String ornaments, String ornamentsId, boolean ubcEnable) {
        String vipValue;
        BoxAccount boxAccount = this.mLoginManager.getBoxAccount();
        if (boxAccount != null) {
            if (TextUtils.isEmpty(ornaments)) {
                this.mAvatarOrnament.setVisibility(8);
                return;
            }
            if (TextUtils.equals("1", boxAccount.getMemberVip())) {
                vipValue = "vip";
            } else {
                vipValue = PersonalConstants.VALUE_NOT_VIP;
            }
            this.mAvatarOrnament.setImageURI(Uri.parse(ornaments));
            this.mAvatarOrnament.setVisibility(0);
            if (ubcEnable) {
                PersonalCenterUbc.showHeaderPendant(ornamentsId, vipValue);
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 12 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d7, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00da, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setLoginImageUri(com.baidu.searchbox.account.data.BoxAccount r13, boolean r14) {
        /*
            r12 = this;
            java.lang.String r0 = r13.portrait
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0017
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r0 = r12.mLoginImg
            com.facebook.drawee.interfaces.DraweeHierarchy r0 = r0.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r0 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r0
            r0.setOverlayImage(r1)
            return
        L_0x0017:
            com.baidu.searchbox.ui.BdBaseImageView r0 = r12.mLoginImgShadow
            int r2 = com.baidu.searchbox.personalcenter.R.drawable.personal_header_avatar_shadow
            r0.setImageResource(r2)
            java.lang.String r0 = "1"
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r3 = r13.getMemberVip()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L_0x00fe
            java.lang.String r2 = r13.dynamicPortrait
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00dd
            java.lang.String r2 = r13.dynamicPortrait
            android.net.Uri r2 = android.net.Uri.parse(r2)
            java.lang.String r3 = r2.toString()
            java.lang.String r4 = "gifUri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r4 = r12.mLoginImg
            android.net.Uri r4 = r4.getPicUri()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r3 = r3.contentEquals(r4)
            if (r3 != 0) goto L_0x011e
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r3 = r12.mLoginImg
            r3.setPicUri(r2)
            com.facebook.imagepipeline.core.ImagePipelineFactory r3 = com.facebook.drawee.backends.pipeline.Fresco.getImagePipelineFactory()
            if (r3 == 0) goto L_0x00db
            com.facebook.cache.disk.FileCache r3 = r3.getMainFileCache()
            if (r3 == 0) goto L_0x00db
            com.facebook.cache.common.SimpleCacheKey r4 = new com.facebook.cache.common.SimpleCacheKey
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r5 = r12.mLoginImg
            android.net.Uri r5 = r5.getPicUri()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r4.<init>(r5)
            com.facebook.cache.common.CacheKey r4 = (com.facebook.cache.common.CacheKey) r4
            com.facebook.binaryresource.BinaryResource r3 = r3.getResource(r4)
            if (r3 == 0) goto L_0x00db
            java.io.InputStream r3 = r3.openStream()
            if (r3 == 0) goto L_0x00db
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = r3
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x00d4 }
            r5 = 0
            android.graphics.Movie r6 = android.graphics.Movie.decodeStream(r4)     // Catch:{ all -> 0x00d4 }
            if (r6 == 0) goto L_0x00d0
            java.lang.String r7 = "decodeStream(it)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ all -> 0x00d4 }
            r7 = 0
            int r8 = r6.width()     // Catch:{ all -> 0x00d4 }
            int r9 = r6.height()     // Catch:{ all -> 0x00d4 }
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x00d4 }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8, r9, r10)     // Catch:{ all -> 0x00d4 }
            java.lang.String r9 = "createBitmap(\n          …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ all -> 0x00d4 }
            android.graphics.Canvas r9 = new android.graphics.Canvas     // Catch:{ all -> 0x00d4 }
            r9.<init>(r8)     // Catch:{ all -> 0x00d4 }
            r10 = 0
            r6.draw(r9, r10, r10)     // Catch:{ all -> 0x00d4 }
            r9.save()     // Catch:{ all -> 0x00d4 }
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r10 = r12.mLoginImg     // Catch:{ all -> 0x00d4 }
            com.facebook.drawee.interfaces.DraweeHierarchy r10 = r10.getHierarchy()     // Catch:{ all -> 0x00d4 }
            com.facebook.drawee.generic.GenericDraweeHierarchy r10 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r10     // Catch:{ all -> 0x00d4 }
            android.graphics.drawable.BitmapDrawable r11 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x00d4 }
            r11.<init>(r8)     // Catch:{ all -> 0x00d4 }
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11     // Catch:{ all -> 0x00d4 }
            r10.setPlaceholderImage((android.graphics.drawable.Drawable) r11)     // Catch:{ all -> 0x00d4 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d4 }
        L_0x00d0:
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            goto L_0x011e
        L_0x00d4:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00d6 }
        L_0x00d6:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            throw r1
        L_0x00db:
            goto L_0x011e
        L_0x00dd:
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r2 = r12.mLoginImg
            java.lang.String r3 = r13.portrait
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r2.setPicUri(r3)
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r2 = r12.mLoginImg
            com.facebook.drawee.interfaces.DraweeHierarchy r2 = r2.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r2 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r2
            android.content.Context r3 = r12.getContext()
            int r4 = com.baidu.searchbox.personalcenter.R.drawable.icon_personal_avatar_default
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r3, r4)
            r2.setPlaceholderImage((android.graphics.drawable.Drawable) r3)
            goto L_0x011e
        L_0x00fe:
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r2 = r12.mLoginImg
            java.lang.String r3 = r13.portrait
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r2.setPicUri(r3)
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r2 = r12.mLoginImg
            com.facebook.drawee.interfaces.DraweeHierarchy r2 = r2.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r2 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r2
            android.content.Context r3 = r12.getContext()
            int r4 = com.baidu.searchbox.personalcenter.R.drawable.icon_personal_avatar_default
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r3, r4)
            r2.setPlaceholderImage((android.graphics.drawable.Drawable) r3)
        L_0x011e:
            boolean r2 = com.baidu.android.app.account.utils.AvatarBusinessUtils.getPersonalCenterIsLoop()
            r3 = 1
            if (r2 == 0) goto L_0x012b
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r2 = r12.mLoginImg
            r2.setLoopPlay(r3)
            goto L_0x013a
        L_0x012b:
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r2 = r12.mLoginImg
            r4 = 0
            r2.setLoopPlay(r4)
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r2 = r12.mLoginImg
            int r4 = com.baidu.android.app.account.utils.AvatarBusinessUtils.getPersonalCenterRepeatCount()
            r2.setPlayCount(r4)
        L_0x013a:
            com.baidu.searchbox.account.BoxAccountManager r2 = r12.mLoginManager
            com.baidu.searchbox.account.data.BoxAccount r2 = r2.getBoxAccount()
            java.lang.String r4 = "mLoginManager.boxAccount"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r4 = r2.getHeadTag()
            com.baidu.searchbox.personalcenter.utils.PersonalAvatarAreaUtil r5 = r12.personalAvatarAreaUtil
            int r5 = r5.avatarAreaShowType(r4)
            r12.avatarAreaShowType = r5
            if (r3 != r5) goto L_0x0179
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r5 = r12.mLoginImg
            int r6 = com.baidu.searchbox.personalcenter.R.drawable.icon_personal_avatar_default
            r5.setActualImageResource(r6)
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r5 = r12.mLoginImg
            com.facebook.drawee.interfaces.DraweeHierarchy r5 = r5.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r5 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r5
            android.content.Context r6 = r12.getContext()
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.baidu.searchbox.personalcenter.R.drawable.avatar_guid_mask
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)
            r5.setOverlayImage(r6)
            if (r14 == 0) goto L_0x0184
            com.baidu.searchbox.personalcenter.PersonalCenterUbc.showAvatarGuid()
            goto L_0x0184
        L_0x0179:
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r5 = r12.mLoginImg
            com.facebook.drawee.interfaces.DraweeHierarchy r5 = r5.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r5 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r5
            r5.setOverlayImage(r1)
        L_0x0184:
            if (r14 == 0) goto L_0x01c8
            if (r4 == 0) goto L_0x01c8
            int r5 = r4.hashCode()
            switch(r5) {
                case 49: goto L_0x01b7;
                case 50: goto L_0x01a4;
                case 51: goto L_0x0190;
                default: goto L_0x018f;
            }
        L_0x018f:
            goto L_0x01c8
        L_0x0190:
            java.lang.String r0 = "3"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0199
            goto L_0x01c8
        L_0x0199:
            java.lang.String r0 = r2.getPortrait()
            java.lang.String r5 = "real_portrait"
            com.baidu.searchbox.personalcenter.PersonalCenterUbc.showHeader(r5, r0, r1)
            goto L_0x01c8
        L_0x01a4:
            java.lang.String r0 = "2"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x01ad
            goto L_0x01c8
        L_0x01ad:
            java.lang.String r0 = r2.getPortrait()
            java.lang.String r5 = "baidubear"
            com.baidu.searchbox.personalcenter.PersonalCenterUbc.showHeader(r5, r0, r1)
            goto L_0x01c8
        L_0x01b7:
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x01be
            goto L_0x01c8
        L_0x01be:
            java.lang.String r0 = r2.getPortrait()
            java.lang.String r5 = "placeholder"
            com.baidu.searchbox.personalcenter.PersonalCenterUbc.showHeader(r5, r0, r1)
        L_0x01c8:
            com.baidu.searchbox.dynamicavatar.VipDynamicAvatarView r0 = r12.mLoginImg
            r0.setPicStartPlay(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personalcenter.loginview.PersonalMixHasLoginView.setLoginImageUri(com.baidu.searchbox.account.data.BoxAccount, boolean):void");
    }

    private final String formatNickName(String nickname) {
        String name = nickname;
        if (TextUtils.isEmpty(nickname)) {
            return getContext().getResources().getString(R.string.default_nick_name);
        }
        return name;
    }

    public void updateUI() {
        if (this.hasTheme) {
            this.mLoginImgWrapper.setStrokeColor(ContextCompat.getColor(getContext(), R.color.BC360));
            this.mLoginName.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mEditBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.BC360));
            this.mAuthenticationBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.BC360));
            this.mGotoCenter.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.icon_personal_arr_right_theme));
            this.mEditBtn.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.personal_has_theme_button_border));
            this.mAuthenticationBtn.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.personal_has_theme_button_border));
            this.mContentCount.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mContentText.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mZanCount.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mZanText.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mFollowCount.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mFollowText.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mFansCount.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mFansText.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mAuthentication.setTextColor(ContextCompat.getColor(getContext(), R.color.GC84));
            this.mContentCount.setShadowLayer(3.0f, 0.0f, 1.0f, ContextCompat.getColor(getContext(), R.color.BC141));
            this.mContentText.setShadowLayer(3.0f, 0.0f, 1.0f, ContextCompat.getColor(getContext(), R.color.BC141));
            this.mZanCount.setShadowLayer(3.0f, 0.0f, 1.0f, ContextCompat.getColor(getContext(), R.color.BC141));
            this.mZanText.setShadowLayer(3.0f, 0.0f, 1.0f, ContextCompat.getColor(getContext(), R.color.BC141));
            this.mFollowCount.setShadowLayer(3.0f, 0.0f, 1.0f, ContextCompat.getColor(getContext(), R.color.BC141));
            this.mFollowText.setShadowLayer(3.0f, 0.0f, 1.0f, ContextCompat.getColor(getContext(), R.color.BC141));
            this.mFansCount.setShadowLayer(3.0f, 0.0f, 1.0f, ContextCompat.getColor(getContext(), R.color.BC141));
            this.mFansText.setShadowLayer(3.0f, 0.0f, 1.0f, ContextCompat.getColor(getContext(), R.color.BC141));
            this.mAuthentication.setShadowLayer(3.0f, 0.0f, 1.0f, ContextCompat.getColor(getContext(), R.color.BC141));
        } else {
            this.mLoginImgWrapper.setStrokeColor(ContextCompat.getColor(getContext(), R.color.GC85));
            this.mLoginName.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mEditBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mAuthenticationBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mGotoCenter.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.icon_personal_arr_right));
            this.mEditBtn.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.personal_button_border));
            this.mAuthenticationBtn.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.personal_button_border));
            this.mContentCount.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mContentText.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mZanCount.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mZanText.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mFollowCount.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mFollowText.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mFansCount.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mFansText.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mAuthentication.setTextColor(ContextCompat.getColor(getContext(), R.color.GC1));
            this.mContentCount.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.mContentText.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.mZanCount.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.mZanText.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.mFollowCount.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.mFollowText.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.mFansCount.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.mFansText.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.mAuthentication.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
        this.mLoginImg.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.background_personal_circle));
    }

    public int getContentTopDistanceToRootView(ViewGroup rootView) {
        return PersonalUIUitlsKt.getTopDistanceToRootView(this.mLoginImgWrapper, rootView);
    }

    public int getContentBottomDistanceToRootView(ViewGroup rootView) {
        return getContentTopDistanceToRootView(rootView) + this.mContentDistanceView.getHeight();
    }

    public void changeTheme(boolean hasTheme2, boolean hasAFXBg) {
        this.hasTheme = hasTheme2;
        updateUI();
    }

    public void updateSize() {
        FontSizeTextViewExtKt.setScaledSizeRes$default(this.mLoginName, 2, R.dimen.login_name_size, 0, 4, (Object) null);
        FontSizeViewExtKt.setScaledSizeRes$default(this.mGotoCenter, 2, R.dimen.goto_center_width, R.dimen.goto_center_width, 0, 8, (Object) null);
        this.mLoginViewContainer.setPadding(0, (int) (getResources().getDimension(R.dimen.login_view_container_padding_top) + (FontSizeHelper.getScaledSize(2, getResources().getDimension(R.dimen.area_header_to_setting_icon_width)) - getResources().getDimension(R.dimen.area_header_to_setting_icon_width))), 0, getResources().getDimensionPixelOffset(R.dimen.login_view_container_padding_bottom));
        FontSizeTextViewExtKt.setScaledSize$default(this.mAuthentication, 0, 1, 12.0f, 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSize$default(this.mEditBtn, 0, 1, 10.0f, 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSize$default(this.mAuthenticationBtn, 0, 1, 10.0f, 0, 8, (Object) null);
        onCountLayoutFontSizeChanged();
    }

    private final void onCountLayoutFontSizeChanged() {
        if (FontSizeHelper.getFontSizeType() >= 3) {
            int childCount = this.mCountLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.mCountLayout.getChildAt(i2);
                LinearLayout numLinearLayout = childAt instanceof LinearLayout ? (LinearLayout) childAt : null;
                if (numLinearLayout != null) {
                    numLinearLayout.setOrientation(1);
                    View childAt2 = numLinearLayout.getChildAt(0);
                    TextView textView = childAt2 instanceof TextView ? (TextView) childAt2 : null;
                    if (textView != null) {
                        FontSizeTextViewExtKt.setScaledSize$default(textView, 0, 1, 17.0f, 0, 8, (Object) null);
                    }
                    View childAt3 = numLinearLayout.getChildAt(1);
                    TextView desText = childAt3 instanceof TextView ? (TextView) childAt3 : null;
                    if (desText != null) {
                        FontSizeTextViewExtKt.setScaledSize$default(desText, 0, 1, 12.0f, 0, 8, (Object) null);
                        ViewGroup.LayoutParams layoutParams = desText.getLayoutParams();
                        LinearLayout.LayoutParams it = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                        if (it != null) {
                            it.topMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 5.0f);
                            it.leftMargin = 0;
                        }
                    }
                }
            }
            return;
        }
        int childCount2 = this.mCountLayout.getChildCount();
        for (int i3 = 0; i3 < childCount2; i3++) {
            View childAt4 = this.mCountLayout.getChildAt(i3);
            LinearLayout numLinearLayout2 = childAt4 instanceof LinearLayout ? (LinearLayout) childAt4 : null;
            if (numLinearLayout2 != null) {
                numLinearLayout2.setOrientation(0);
                View childAt5 = numLinearLayout2.getChildAt(0);
                TextView textView2 = childAt5 instanceof TextView ? (TextView) childAt5 : null;
                if (textView2 != null) {
                    FontSizeTextViewExtKt.setScaledSize$default(textView2, 0, 1, 17.0f, 0, 8, (Object) null);
                }
                View childAt6 = numLinearLayout2.getChildAt(1);
                TextView desText2 = childAt6 instanceof TextView ? (TextView) childAt6 : null;
                if (desText2 != null) {
                    FontSizeTextViewExtKt.setScaledSize$default(desText2, 0, 1, 12.0f, 0, 8, (Object) null);
                    ViewGroup.LayoutParams layoutParams2 = desText2.getLayoutParams();
                    LinearLayout.LayoutParams it2 = layoutParams2 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams2 : null;
                    if (it2 != null) {
                        it2.topMargin = 0;
                        it2.leftMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 2.0f);
                    }
                }
            }
        }
    }

    private final void setCountLayoutText(TextView view2, String num, String unit) {
        CharSequence charSequence = num;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = unit;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                String content = num + unit;
                SpannableStringBuilder spanBuilder = new SpannableStringBuilder(content);
                spanBuilder.setSpan(new RelativeSizeSpan(0.8f), num.length(), content.length(), 18);
                view2.setText(spanBuilder);
                return;
            }
        }
        view2.setText(num);
    }

    private final void openUrlWithLightBrowser(String url, boolean isShowToolBor, boolean isFullScreen) {
        Context mContext;
        if (getContext() != null) {
            CharSequence charSequence = url;
            if ((charSequence == null || charSequence.length() == 0) || (mContext = getContext()) == null) {
                return;
            }
            if (isShowToolBor) {
                Router.invoke(mContext, "baiduboxapp://v1/easybrowse/open?url=" + URLEncoder.encode(url, "UTF-8") + "&style={\"toolbaricons\":{\"tids\":[\"3\"]}}&newbrowser=1");
            } else if (isFullScreen) {
                Router.invoke(mContext, "baiduboxapp://v1/easybrowse/open?url=" + URLEncoder.encode(url, "UTF-8") + "&layoutfullscreen=1&newbrowser=1");
            } else {
                Router.invoke(mContext, "baiduboxapp://v1/easybrowse/open?url=" + URLEncoder.encode(url, "UTF-8") + "&newbrowser=1");
            }
        }
    }

    private final void showThumbsUpDialog(String zanCount) {
        Context mContext;
        String str = zanCount;
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && (mContext = getContext()) != null) {
            View dialogView = LayoutInflater.from(mContext).inflate(R.layout.personal_page_thumb_up_dialog, (ViewGroup) null);
            BdBaseLottieView lottie = (BdBaseLottieView) dialogView.findViewById(R.id.thumb_dialog_lottie);
            TextView name = (TextView) dialogView.findViewById(R.id.thumb_dialog_name);
            BdBaseImageView bg = (BdBaseImageView) dialogView.findViewById(R.id.thumb_dialog_bg);
            ((RelativeLayout) dialogView.findViewById(R.id.root_view)).setMinimumHeight((int) (((float) DeviceUtils.ScreenInfo.getDisplayWidth(mContext)) * 0.567f));
            ViewGroup.LayoutParams lottieParams = lottie.getLayoutParams();
            double lottieHeight = 0.372d * ((double) DeviceUtils.ScreenInfo.getDisplayWidth(mContext));
            double lottieWidth = ((double) DeviceUtils.ScreenInfo.getDisplayWidth(mContext)) * 0.703d;
            lottieParams.height = (int) lottieHeight;
            lottieParams.width = (int) lottieWidth;
            lottie.setLayoutParams(lottieParams);
            bg.setImageResource(R.drawable.personal_page_thumb_up_bg);
            lottie.setAnimation("thumbs/thumbs_up_day.json");
            lottie.setImageAssetsFolder("thumbs/images/");
            lottie.playAnimation();
            name.setText(this.mLoginName.getText());
            name.setTextColor(ContextCompat.getColor(mContext, com.baidu.android.common.ui.style.R.color.GC1));
            double d2 = lottieWidth;
            double d3 = lottieHeight;
            ViewGroup.LayoutParams layoutParams = lottieParams;
            BdBaseImageView bdBaseImageView = bg;
            TextView content = (TextView) dialogView.findViewById(R.id.thumb_dialog_content);
            FontSizeTextViewExtKt.setScaledSize$default(name, 0, 1, 16.0f, 0, 8, (Object) null);
            content.setTextColor(ContextCompat.getColor(mContext, com.baidu.android.common.ui.style.R.color.GC1));
            FontSizeTextViewExtKt.setScaledSize$default(content, 0, 1, 16.0f, 0, 8, (Object) null);
            SpannableStringBuilder spanBuilder = new SpannableStringBuilder("共获得 " + str + " 个赞");
            ForegroundColorSpan color = new ForegroundColorSpan(ContextCompat.getColor(mContext, com.baidu.android.common.ui.style.R.color.GC8));
            RelativeSizeSpan size = new RelativeSizeSpan(1.19f);
            spanBuilder.setSpan(color, 4, zanCount.length() + 4, 18);
            spanBuilder.setSpan(size, 4, zanCount.length() + 4, 18);
            content.setText(spanBuilder);
            BdDialog.BottomItem confirmButton = new BdDialog.BottomItem("我知道了", new PersonalMixHasLoginView$showThumbsUpDialog$1$confirmButton$1());
            confirmButton.setMTextColor(Integer.valueOf(ContextCompat.getColor(mContext, com.baidu.android.common.ui.style.R.color.GC68)));
            new BdDialog.Builder((Class) null, 1, (DefaultConstructorMarker) null).setView(dialogView).setButton(confirmButton).show();
        }
    }

    public final LinearLayout getContentCountLayout() {
        return this.mContentCountLayout;
    }
}
