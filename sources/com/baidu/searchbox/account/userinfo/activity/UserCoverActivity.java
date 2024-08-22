package com.baidu.searchbox.account.userinfo.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.userinfo.command.listener.PersonalPageBgCommandListenerKt;
import com.baidu.searchbox.account.userinfo.event.HeadPhotoResEvent;
import com.baidu.searchbox.account.userinfo.menu.UnitedSchemePersonalPageDispatcher;
import com.baidu.searchbox.account.userinfo.parser.GalleryImageEntityParser;
import com.baidu.searchbox.account.userinfo.view.UserCoverBottomView;
import com.baidu.searchbox.account.userinfo.view.UserCoverHeadView;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.feed.container.creator.PageParams;
import com.baidu.searchbox.feed.tab.FeedNavigationAdapter;
import com.baidu.searchbox.feed.tab.config.DefaultSlidingTabConfig;
import com.baidu.searchbox.feed.tab.config.ISlidingTabConfig;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.feed.tab.update.TabNameImageModel;
import com.baidu.searchbox.kmm.foundation.common.ErrorInfo;
import com.baidu.searchbox.kmm.foundation.common.intents.LoadingState;
import com.baidu.searchbox.kmm.foundation.common.intents.RefreshableListIntent;
import com.baidu.searchbox.kmm.personalpage.shop.api.PersonalPageCoverShopApiKt;
import com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryCategoryEntity;
import com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryImageEntity;
import com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryPositionEntity;
import com.baidu.searchbox.kmm.personalpage.shop.services.PersonalPageCoverShopService;
import com.baidu.searchbox.kmm.personalpage.shop.services.PersonalPageCoverShopServiceKt;
import com.baidu.searchbox.kmm.personalpage.shop.ubc.PersonalPageShopUBCKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.CommonEmptyView;
import com.baidu.searchbox.ui.ShimmerFrameLayout;
import com.baidu.searchbox.ui.viewpager.NoScrollViewPager;
import com.baidu.searchbox.widget.ImmersionHelper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002ijB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020'H\u0002J\n\u0010,\u001a\u0004\u0018\u00010*H\u0002J\b\u0010-\u001a\u00020'H\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020'H\u0002J \u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u00104\u001a\u00020'H\u0002J\b\u00105\u001a\u00020'H\u0002J\b\u00106\u001a\u00020'H\u0002J\u001c\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010<H\u0014J \u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u0016J\b\u0010D\u001a\u00020'H\u0014J\u0010\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020\u001cH\u0016J\b\u0010G\u001a\u00020'H\u0014J\b\u0010H\u001a\u00020'H\u0014J\b\u0010I\u001a\u00020'H\u0014J \u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020L2\u0006\u0010)\u001a\u00020*2\u0006\u0010M\u001a\u00020BH\u0016J \u0010N\u001a\u00020'2\u0006\u0010K\u001a\u00020L2\u0006\u0010)\u001a\u00020*2\u0006\u0010M\u001a\u00020BH\u0016J\b\u0010O\u001a\u00020'H\u0002J\u0010\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020\u001cH\u0016J\u001a\u0010R\u001a\u00020'2\u0006\u0010Q\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0010\u0010U\u001a\u00020'2\u0006\u0010Q\u001a\u00020\u001cH\u0016J\u0010\u0010V\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002J\u0012\u0010W\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010X\u001a\u00020'H\u0002J\b\u0010Y\u001a\u00020'H\u0002J\b\u0010Z\u001a\u00020'H\u0002J\u0012\u0010[\u001a\u00020'2\b\u0010\\\u001a\u0004\u0018\u00010*H\u0003J\u0016\u0010]\u001a\u00020'2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_H\u0002J\b\u0010a\u001a\u00020'H\u0002J \u0010b\u001a\u00020'2\b\u0010c\u001a\u0004\u0018\u00010*2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020`0_H\u0002J\u0010\u0010e\u001a\u00020'2\b\u0010f\u001a\u0004\u0018\u00010\u0011J\u0010\u0010g\u001a\u00020'2\u0006\u0010h\u001a\u00020\u001cH\u0002R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/activity/UserCoverActivity;", "Lcom/baidu/searchbox/appframework/BaseActivity;", "Lcom/baidu/searchbox/feed/tab/FeedNavigationAdapter$IFragmentMaker;", "Lcom/baidu/searchbox/kmm/foundation/common/intents/RefreshableListIntent;", "Lcom/baidu/searchbox/account/userinfo/activity/UserCoverTabItemListener;", "()V", "accountManager", "Lcom/baidu/searchbox/account/BoxAccountManager;", "kotlin.jvm.PlatformType", "getAccountManager", "()Lcom/baidu/searchbox/account/BoxAccountManager;", "accountManager$delegate", "Lkotlin/Lazy;", "activityLifecycle", "com/baidu/searchbox/account/userinfo/activity/UserCoverActivity$activityLifecycle$1", "Lcom/baidu/searchbox/account/userinfo/activity/UserCoverActivity$activityLifecycle$1;", "currentUserAvatar", "", "currentUserNickname", "currentUserType", "feedAdapter", "Lcom/baidu/searchbox/feed/tab/FeedNavigationAdapter;", "galleryImageParser", "Lcom/baidu/searchbox/account/userinfo/parser/GalleryImageEntityParser;", "indexId", "loadingView", "Lcom/baidu/searchbox/ui/ShimmerFrameLayout;", "needRefresh", "", "needSave", "pageSource", "services", "Lcom/baidu/searchbox/kmm/personalpage/shop/services/PersonalPageCoverShopService;", "getServices", "()Lcom/baidu/searchbox/kmm/personalpage/shop/services/PersonalPageCoverShopService;", "services$delegate", "showDressUp", "topImageFrom", "applyImmersion", "", "doItemSelected", "entity", "Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryImageEntity;", "duSetUserCover", "getCurrentSetEntity", "getIntentData", "getSlidingTabConfig", "Lcom/baidu/searchbox/feed/tab/config/ISlidingTabConfig;", "getUserDataFromAccount", "getUsingMapFromParserBean", "", "bean", "hideLoadingView", "initView", "loadUserCoverData", "makeFragment", "Landroidx/fragment/app/Fragment;", "tabInfo", "Lcom/baidu/searchbox/feed/tab/update/MultiTabItemInfo;", "bundle", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "onDataLoaded", "isRefresh", "startRefreshIndex", "", "refreshCount", "onDestroy", "onNightModeChanged", "isNightMode", "onResume", "onStart", "onStop", "onUserCoverTabItemClick", "tab", "Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryCategoryEntity;", "pos", "onUserCoverTabItemShow", "sendHeadPhotoResEvent", "setEmptyViewVisible", "isVisible", "setErrorViewVisible", "errorInfo", "Lcom/baidu/searchbox/kmm/foundation/common/ErrorInfo;", "setLoadingViewVisible", "setUserCover", "setUserInfoData", "setUserInfoViewStyle", "showErrorView", "showLoadingView", "showUserCoverList", "selectedEntity", "updateAdapterUI", "tabPosList", "", "Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryPositionEntity;", "updateTaskCover", "updateUsingAndSelected", "setEntity", "refreshList", "updateUsingBg", "imageId", "useImmersion", "lightStatusBar", "UserCoverMultiTabItemInfo", "UserCoverSlidingTabConfig", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserCoverActivity.kt */
public final class UserCoverActivity extends BaseActivity implements FeedNavigationAdapter.IFragmentMaker, RefreshableListIntent, UserCoverTabItemListener {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy accountManager$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, UserCoverActivity$accountManager$2.INSTANCE);
    private final UserCoverActivity$activityLifecycle$1 activityLifecycle = new UserCoverActivity$activityLifecycle$1(this);
    private String currentUserAvatar;
    private String currentUserNickname;
    /* access modifiers changed from: private */
    public String currentUserType;
    private FeedNavigationAdapter feedAdapter;
    private GalleryImageEntityParser galleryImageParser;
    private String indexId;
    private ShimmerFrameLayout loadingView;
    /* access modifiers changed from: private */
    public boolean needRefresh;
    /* access modifiers changed from: private */
    public boolean needSave;
    /* access modifiers changed from: private */
    public String pageSource;
    private final Lazy services$delegate = LazyKt.lazy(new UserCoverActivity$services$2(this));
    private boolean showDressUp;
    /* access modifiers changed from: private */
    public String topImageFrom = UnitedSchemePersonalPageDispatcher.MENU_ENTRY_GALLERY;

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

    public void endFooterLoading(LoadingState state, boolean needShowRefresh, ErrorInfo errorInfo) {
        RefreshableListIntent.DefaultImpls.endFooterLoading(this, state, needShowRefresh, errorInfo);
    }

    public void endHeaderLoading(LoadingState state, ErrorInfo errorInfo) {
        RefreshableListIntent.DefaultImpls.endHeaderLoading(this, state, errorInfo);
    }

    public void onDataRequestFinished(boolean isRefresh, boolean isCache, ErrorInfo errorInfo) {
        RefreshableListIntent.DefaultImpls.onDataRequestFinished(this, isRefresh, isCache, errorInfo);
    }

    public void scrollToTopAndDoRefresh(boolean isSmooth) {
        RefreshableListIntent.DefaultImpls.scrollToTopAndDoRefresh(this, isSmooth);
    }

    public void setFooterLoadingVisible(boolean isVisible) {
        RefreshableListIntent.DefaultImpls.setFooterLoadingVisible(this, isVisible);
    }

    public void setHeaderLoadingVisible(boolean isVisible) {
        RefreshableListIntent.DefaultImpls.setHeaderLoadingVisible(this, isVisible);
    }

    /* access modifiers changed from: private */
    public final PersonalPageCoverShopService getServices() {
        return (PersonalPageCoverShopService) this.services$delegate.getValue();
    }

    private final BoxAccountManager getAccountManager() {
        return (BoxAccountManager) this.accountManager$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        setPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        super.onCreate(savedInstanceState);
        setContentView(com.baidu.searchbox.account.userinfo.R.layout.activity_user_cover);
        getIntentData();
        initView();
        setEnableSliding(true);
        applyImmersion();
        loadUserCoverData();
        BdBoxActivityManager.registerLifeCycle(this.activityLifecycle);
    }

    private final void getIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(UnitedSchemePersonalPageDispatcher.CURRENT_GALLERY_IMAGE_LIST);
            this.galleryImageParser = serializableExtra instanceof GalleryImageEntityParser ? (GalleryImageEntityParser) serializableExtra : null;
            this.currentUserType = intent.getStringExtra("page");
            this.currentUserAvatar = intent.getStringExtra("avatar");
            this.currentUserNickname = intent.getStringExtra("name");
            this.pageSource = intent.getStringExtra("source");
            this.indexId = intent.getStringExtra("indexId");
            this.needSave = intent.getBooleanExtra(UnitedSchemePersonalPageDispatcher.CURRENT_NEED_SAVE, false);
            this.showDressUp = intent.getBooleanExtra(UnitedSchemePersonalPageDispatcher.CURRENT_SHOW_DRESS_UP, false);
            getUserDataFromAccount();
        }
    }

    private final void getUserDataFromAccount() {
        String str;
        BoxAccountManager accountManager = getAccountManager();
        BoxAccount account = accountManager != null ? accountManager.getBoxAccount() : null;
        if (account != null) {
            CharSequence charSequence = this.currentUserAvatar;
            boolean z = true;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                String dynamicPortrait = account.getDynamicPortrait();
                if (!TextUtils.isEmpty(dynamicPortrait)) {
                    str = dynamicPortrait;
                } else {
                    str = account.getAvatar(false);
                }
                this.currentUserAvatar = str;
            }
            CharSequence charSequence2 = this.currentUserNickname;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                this.currentUserNickname = account.getNickname();
            }
            CharSequence charSequence3 = this.currentUserType;
            if (charSequence3 != null && !StringsKt.isBlank(charSequence3)) {
                z = false;
            }
            if (z) {
                this.currentUserType = PersonalPageCoverShopServiceKt.getUserTypeFromAccount();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void applyImmersion() {
        useImmersion(true);
    }

    public Fragment makeFragment(MultiTabItemInfo tabInfo, Bundle bundle) {
        Intrinsics.checkNotNullParameter(tabInfo, PageParams.KEY_TAB_INFO);
        if (tabInfo instanceof UserCoverMultiTabItemInfo) {
            return new UserCoverFragment((UserCoverMultiTabItemInfo) tabInfo, this);
        }
        return null;
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        setUserInfoViewStyle();
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setViewStyle();
        ((UserCoverBottomView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_bottom_view)).onCoverSelected(getCurrentSetEntity());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (this.needRefresh) {
            updateTaskCover();
            this.needRefresh = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).startAfxOrDynamicImg();
        ((UserCoverBottomView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_bottom_view)).refreshAiCreateValidCount();
        PersonalPageShopUBCKt.shopCoverShowUBC(this.currentUserType, this.pageSource);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.needRefresh = true;
        super.onStop();
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).stopAfxOrDynamicImg();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BdBoxActivityManager.unregisterLifeCycle(this.activityLifecycle);
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).destoryAfxImg();
        getServices().onViewDestroy();
    }

    private final void useImmersion(boolean lightStatusBar) {
        boolean lightStatusBar2 = !NightModeHelper.isNightMode() && lightStatusBar;
        setEnableImmersion(true);
        if (immersionEnabled()) {
            if (this.mImmersionHelper == null) {
                this.mImmersionHelper = new ImmersionHelper(this);
            }
            this.mImmersionHelper.getConfig().setIsShowStatusBar(false);
            this.mImmersionHelper.getConfig().setUseLightStatusBar(lightStatusBar2);
            this.mImmersionHelper.setImmersion();
            setImmersionHelper(this.mImmersionHelper);
        }
    }

    private final void initView() {
        setUserInfoViewStyle();
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setHeadViewListener(new UserCoverActivity$initView$1(this));
        ((UserCoverBottomView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_bottom_view)).setBottomListener(new UserCoverActivity$initView$2(this));
    }

    /* access modifiers changed from: private */
    public final void setUserCover(PersonalPageGalleryImageEntity entity) {
        Map ext = new LinkedHashMap();
        if (entity.getImageId().length() > 0) {
            ext.put(PersonalPageShopUBCKt.UBC_PERSONAL_PAGE_SHOP_EXT_COVER_ID, entity.getImageId());
        }
        String it = entity.getTabName();
        if (it != null) {
            ext.put("tabname", it);
        }
        PersonalPageShopUBCKt.shopFunctionClickUBCWithExt(this.currentUserType, this.pageSource, "set", ext);
        if (this.needSave) {
            duSetUserCover();
        } else {
            sendHeadPhotoResEvent();
        }
    }

    public void onUserCoverTabItemClick(PersonalPageGalleryCategoryEntity tab, PersonalPageGalleryImageEntity entity, int pos) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Map ext = new LinkedHashMap();
        if (entity.getImageId().length() > 0) {
            ext.put(PersonalPageShopUBCKt.UBC_PERSONAL_PAGE_SHOP_EXT_COVER_ID, entity.getImageId());
        }
        String it = tab.getCateTitle();
        if (it != null) {
            ext.put("tabname", it);
        }
        PersonalPageShopUBCKt.shopImageClickUBCWithExt(this.currentUserType, this.pageSource, ext);
        CharSequence imageId = entity.getImageId();
        PersonalPageGalleryImageEntity currentSelectedImageEntity = getServices().getCurrentSelectedImageEntity();
        if (!TextUtils.equals(imageId, currentSelectedImageEntity != null ? currentSelectedImageEntity.getImageId() : null)) {
            doItemSelected(entity);
        }
    }

    public void onUserCoverTabItemShow(PersonalPageGalleryCategoryEntity tab, PersonalPageGalleryImageEntity entity, int pos) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(entity, "entity");
        PersonalPageShopUBCKt.shopImageShowUBC(this.currentUserType, this.pageSource, entity.getImageId());
    }

    private final void doItemSelected(PersonalPageGalleryImageEntity entity) {
        updateAdapterUI(getServices().setSelectedImageItem(entity.getImageId()));
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setUserCoverData(entity);
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setCoverEndTimeIfNeed(entity);
        ((UserCoverBottomView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_bottom_view)).onCoverSelected(entity);
    }

    /* access modifiers changed from: private */
    public final void duSetUserCover() {
        ((UserCoverBottomView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_bottom_view)).onCoverApplyStateChange(true, getServices().getCurrentUsingImageEntity());
        getServices().setPersonalPageCoverShop(new UserCoverActivity$duSetUserCover$1(this), new UserCoverActivity$duSetUserCover$2(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateAdapterUI(java.util.List<com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryPositionEntity> r10) {
        /*
            r9 = this;
            r0 = r10
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x0008:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryPositionEntity r4 = (com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryPositionEntity) r4
            r5 = 0
            com.baidu.searchbox.feed.tab.FeedNavigationAdapter r6 = r9.feedAdapter
            if (r6 == 0) goto L_0x0023
            int r7 = r4.getTabIndex()
            androidx.fragment.app.Fragment r6 = r6.getFragmentByPosition(r7)
            goto L_0x0024
        L_0x0023:
            r6 = 0
        L_0x0024:
            boolean r7 = r6 instanceof com.baidu.searchbox.account.userinfo.activity.UserCoverFragment
            if (r7 == 0) goto L_0x0032
            r7 = r6
            com.baidu.searchbox.account.userinfo.activity.UserCoverFragment r7 = (com.baidu.searchbox.account.userinfo.activity.UserCoverFragment) r7
            int r8 = r4.getPosition()
            r7.updateItemUIByPos(r8)
        L_0x0032:
            goto L_0x0008
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.activity.UserCoverActivity.updateAdapterUI(java.util.List):void");
    }

    private final void setUserInfoViewStyle() {
        ((ConstraintLayout) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.root)).setBackgroundColor(getResources().getColor(R.color.GC9));
        ((ImageView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_top_bg)).setImageResource(com.baidu.searchbox.account.userinfo.R.drawable.user_cover_top_bg);
        ((NoScrollViewPager) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager)).setBackgroundColor(getResources().getColor(R.color.GC9));
        _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_sliding_tab_layout_line).setBackgroundColor(getResources().getColor(R.color.GC34));
    }

    private final void setUserInfoData(PersonalPageGalleryImageEntity entity) {
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setUserInfoData(this.showDressUp, this.currentUserNickname, this.currentUserAvatar);
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setUserCoverData(entity);
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setCoverEndTimeIfNeed(entity);
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setBannerVipData();
        boolean z = true;
        if (entity == null || !entity.isSelected()) {
            z = false;
        }
        if (z) {
            ((UserCoverBottomView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_bottom_view)).onCoverSelected(entity);
        } else {
            ((UserCoverBottomView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_bottom_view)).onCoverSelected((PersonalPageGalleryImageEntity) null);
        }
    }

    /* access modifiers changed from: private */
    public final void sendHeadPhotoResEvent() {
        PersonalPageGalleryImageEntity bean = getServices().getCurrentSelectedImageEntity();
        if (bean != null) {
            String staticBigImgUrl = bean.getStaticBigImgUrl();
            if (staticBigImgUrl == null) {
                staticBigImgUrl = "";
            }
            HeadPhotoResEvent headPhotoResEvent = new HeadPhotoResEvent(UserCoverActivityKt.COVER_UPLOAD_MSG_SUC, "1000", staticBigImgUrl, bean.getDynamicImgUrl(), bean.getAfxUrl(), bean.getMp4Url(), bean.getImageId(), this.topImageFrom);
            headPhotoResEvent.setNeedSet(false);
            BdEventBus.Companion.getDefault().post(headPhotoResEvent);
        }
    }

    private final void loadUserCoverData() {
        getServices().requestCoverShopListData(this.indexId, DefaultSharedPrefsWrapper.getInstance().getBoolean(PersonalPageBgCommandListenerKt.KEY_SWITCH_USE_NEW_API, false));
    }

    private final void updateTaskCover() {
        getServices().updateTaskCoverFromServer(DefaultSharedPrefsWrapper.getInstance().getBoolean(PersonalPageBgCommandListenerKt.KEY_SWITCH_USE_NEW_API, false), new UserCoverActivity$updateTaskCover$1(this), UserCoverActivity$updateTaskCover$2.INSTANCE);
        if (AppConfig.isDebug()) {
            Log.d("UserCoverActivity", "updateTaskCover");
        }
    }

    public final void updateUsingBg(String imageId) {
        if (imageId != null) {
            updateUsingAndSelected(getServices().getCurrentUsingImageEntity(), getServices().setCurrentUsingImageItem(imageId));
        }
    }

    /* access modifiers changed from: private */
    public final void updateUsingAndSelected(PersonalPageGalleryImageEntity setEntity, List<PersonalPageGalleryPositionEntity> refreshList) {
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setUserCoverData(setEntity);
        ((UserCoverHeadView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_head_view)).setCoverEndTimeIfNeed(setEntity);
        updateAdapterUI(refreshList);
        if (getServices().getCurrentSelectedImageEntity() != null) {
            ((UserCoverBottomView) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_bottom_view)).onCoverSelected(getServices().getCurrentSelectedImageEntity());
        }
    }

    /* access modifiers changed from: private */
    public final PersonalPageGalleryImageEntity getCurrentSetEntity() {
        if (getServices().getCurrentSelectedImageEntity() != null) {
            return getServices().getCurrentSelectedImageEntity();
        }
        return getServices().getCurrentUsingImageEntity();
    }

    public void onDataLoaded(boolean isRefresh, int startRefreshIndex, int refreshCount) {
        RefreshableListIntent.DefaultImpls.onDataLoaded(this, isRefresh, startRefreshIndex, refreshCount);
        setUserInfoData(getCurrentSetEntity());
        showUserCoverList(getServices().getCurrentSelectedImageEntity());
    }

    public void setLoadingViewVisible(boolean isVisible) {
        RefreshableListIntent.DefaultImpls.setLoadingViewVisible(this, isVisible);
        if (isVisible) {
            showLoadingView();
        } else {
            hideLoadingView();
        }
    }

    public void setEmptyViewVisible(boolean isVisible) {
        RefreshableListIntent.DefaultImpls.setEmptyViewVisible(this, isVisible);
        if (isVisible) {
            showErrorView();
        }
    }

    public void setErrorViewVisible(boolean isVisible, ErrorInfo errorInfo) {
        RefreshableListIntent.DefaultImpls.setErrorViewVisible(this, isVisible, errorInfo);
        if (isVisible) {
            showErrorView();
        }
    }

    private final Map<String, String> getUsingMapFromParserBean(GalleryImageEntityParser bean) {
        if (bean == null) {
            return null;
        }
        GalleryImageEntityParser it = bean;
        HashMap usingMap = new HashMap();
        String id = it.getId();
        if (id != null) {
            usingMap.put(PersonalPageCoverShopApiKt.PERSONAL_PAGE_IMAGE_ID, id);
        }
        String dynamicImgUrl = it.getDynamicImgUrl();
        if (dynamicImgUrl != null) {
            usingMap.put("dynamicImgUrl", dynamicImgUrl);
        }
        String staticBigImgUrl = it.getStaticBigImgUrl();
        if (staticBigImgUrl != null) {
            usingMap.put("staticBigImgUrl", staticBigImgUrl);
        }
        String afxUrl = it.getAfxUrl();
        if (afxUrl != null) {
            usingMap.put("afxUrl", afxUrl);
        }
        String mp4Url = it.getMp4Url();
        if (mp4Url != null) {
            usingMap.put("mp4Url", mp4Url);
        }
        return usingMap;
    }

    /* JADX WARNING: type inference failed for: r1v22, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showUserCoverList(com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryImageEntity r15) {
        /*
            r14 = this;
            int r0 = com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager
            android.view.View r0 = r14._$_findCachedViewById(r0)
            com.baidu.searchbox.ui.viewpager.NoScrollViewPager r0 = (com.baidu.searchbox.ui.viewpager.NoScrollViewPager) r0
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            int r0 = com.baidu.searchbox.account.userinfo.R.id.user_cover_sliding_tab_layout
            android.view.View r0 = r14._$_findCachedViewById(r0)
            com.baidu.searchbox.feed.tab.SlidingTabLayout r0 = (com.baidu.searchbox.feed.tab.SlidingTabLayout) r0
            if (r0 != 0) goto L_0x0016
            return
        L_0x0016:
            int r0 = com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager
            android.view.View r0 = r14._$_findCachedViewById(r0)
            com.baidu.searchbox.ui.viewpager.NoScrollViewPager r0 = (com.baidu.searchbox.ui.viewpager.NoScrollViewPager) r0
            r1 = 2
            r0.setOverScrollMode(r1)
            com.baidu.searchbox.account.userinfo.activity.UserCoverActivity$showUserCoverList$tabChangeListener$1 r0 = new com.baidu.searchbox.account.userinfo.activity.UserCoverActivity$showUserCoverList$tabChangeListener$1
            r0.<init>(r14)
            int r1 = com.baidu.searchbox.account.userinfo.R.id.user_cover_sliding_tab_layout
            android.view.View r1 = r14._$_findCachedViewById(r1)
            com.baidu.searchbox.feed.tab.SlidingTabLayout r1 = (com.baidu.searchbox.feed.tab.SlidingTabLayout) r1
            com.baidu.searchbox.feed.tab.config.ISlidingTabConfig r2 = r14.getSlidingTabConfig()
            com.baidu.searchbox.feed.tab.SlidingTabLayout r1 = r1.setSlidingTabConfig(r2)
            r2 = r0
            com.baidu.searchbox.feed.tab.SlidingTabLayout$OnTabChangeListener r2 = (com.baidu.searchbox.feed.tab.SlidingTabLayout.OnTabChangeListener) r2
            r1.addOnPageChangeListener(r2)
            com.baidu.searchbox.feed.tab.FeedNavigationAdapter r1 = new com.baidu.searchbox.feed.tab.FeedNavigationAdapter
            androidx.fragment.app.FragmentManager r2 = r14.getSupportFragmentManager()
            int r3 = com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager
            android.view.View r3 = r14._$_findCachedViewById(r3)
            com.baidu.searchbox.ui.viewpager.NoScrollViewPager r3 = (com.baidu.searchbox.ui.viewpager.NoScrollViewPager) r3
            androidx.viewpager.widget.ViewPager r3 = (androidx.viewpager.widget.ViewPager) r3
            r4 = r14
            com.baidu.searchbox.feed.tab.FeedNavigationAdapter$IFragmentMaker r4 = (com.baidu.searchbox.feed.tab.FeedNavigationAdapter.IFragmentMaker) r4
            r1.<init>(r2, r3, r4)
            r2 = r1
            r3 = 0
            com.baidu.searchbox.kmm.personalpage.shop.services.PersonalPageCoverShopService r4 = r14.getServices()
            java.util.List r4 = r4.getDataList()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r5 = 0
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r7)
            r6.<init>(r7)
            java.util.Collection r6 = (java.util.Collection) r6
            r7 = r4
            r8 = 0
            java.util.Iterator r9 = r7.iterator()
        L_0x0073:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x008a
            java.lang.Object r10 = r9.next()
            r11 = r10
            com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryCategoryEntity r11 = (com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryCategoryEntity) r11
            r12 = 0
            com.baidu.searchbox.account.userinfo.activity.UserCoverActivity$UserCoverMultiTabItemInfo r13 = new com.baidu.searchbox.account.userinfo.activity.UserCoverActivity$UserCoverMultiTabItemInfo
            r13.<init>(r11)
            r6.add(r13)
            goto L_0x0073
        L_0x008a:
            java.util.List r6 = (java.util.List) r6
            r2.setTabInfos(r6)
            r14.feedAdapter = r1
            int r1 = com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager
            android.view.View r1 = r14._$_findCachedViewById(r1)
            com.baidu.searchbox.ui.viewpager.NoScrollViewPager r1 = (com.baidu.searchbox.ui.viewpager.NoScrollViewPager) r1
            android.content.res.Resources r2 = r14.getResources()
            int r3 = com.baidu.android.common.ui.style.R.color.GC9
            int r2 = r2.getColor(r3)
            r1.setBackgroundColor(r2)
            int r1 = com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager
            android.view.View r1 = r14._$_findCachedViewById(r1)
            com.baidu.searchbox.ui.viewpager.NoScrollViewPager r1 = (com.baidu.searchbox.ui.viewpager.NoScrollViewPager) r1
            com.baidu.searchbox.feed.tab.FeedNavigationAdapter r2 = r14.feedAdapter
            androidx.viewpager.widget.PagerAdapter r2 = (androidx.viewpager.widget.PagerAdapter) r2
            r1.setAdapter(r2)
            int r1 = com.baidu.searchbox.account.userinfo.R.id.user_cover_sliding_tab_layout
            android.view.View r1 = r14._$_findCachedViewById(r1)
            com.baidu.searchbox.feed.tab.SlidingTabLayout r1 = (com.baidu.searchbox.feed.tab.SlidingTabLayout) r1
            int r2 = com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager
            android.view.View r2 = r14._$_findCachedViewById(r2)
            com.baidu.searchbox.ui.viewpager.NoScrollViewPager r2 = (com.baidu.searchbox.ui.viewpager.NoScrollViewPager) r2
            androidx.viewpager.widget.ViewPager r2 = (androidx.viewpager.widget.ViewPager) r2
            r1.setViewPager(r2)
            r1 = 0
            r2 = 0
            if (r15 == 0) goto L_0x0100
            int r3 = com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager
            android.view.View r3 = r14._$_findCachedViewById(r3)
            com.baidu.searchbox.ui.viewpager.NoScrollViewPager r3 = (com.baidu.searchbox.ui.viewpager.NoScrollViewPager) r3
            r3.setCurrentItem(r2)
            com.baidu.searchbox.feed.tab.FeedNavigationAdapter r3 = r14.feedAdapter
            if (r3 == 0) goto L_0x00e5
            com.baidu.searchbox.feed.tab.update.MultiTabItemInfo r3 = r3.getTabItemInfo(r2)
            goto L_0x00e6
        L_0x00e5:
            r3 = r1
        L_0x00e6:
            r0.onPageSelected(r2, r3)
            com.baidu.searchbox.feed.tab.FeedNavigationAdapter r3 = r14.feedAdapter
            if (r3 == 0) goto L_0x00f1
            androidx.fragment.app.Fragment r1 = r3.getFragmentByPosition(r2)
        L_0x00f1:
            boolean r2 = r1 instanceof com.baidu.searchbox.account.userinfo.activity.UserCoverFragment
            if (r2 == 0) goto L_0x0154
            r2 = r1
            com.baidu.searchbox.account.userinfo.activity.UserCoverFragment r2 = (com.baidu.searchbox.account.userinfo.activity.UserCoverFragment) r2
            int r3 = r15.getPosition()
            r2.scrollToNeedPosItem(r3)
            goto L_0x0154
        L_0x0100:
            com.baidu.searchbox.kmm.personalpage.shop.services.PersonalPageCoverShopService r3 = r14.getServices()
            java.util.List r3 = r3.getDataList()
            r4 = 0
            r5 = 0
            java.util.Iterator r6 = r3.iterator()
        L_0x010e:
            boolean r7 = r6.hasNext()
            r8 = -1
            if (r7 == 0) goto L_0x0128
            java.lang.Object r7 = r6.next()
            r9 = r7
            com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryCategoryEntity r9 = (com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryCategoryEntity) r9
            r10 = 0
            boolean r9 = r9.isVip()
            if (r9 == 0) goto L_0x0124
            goto L_0x0129
        L_0x0124:
            int r5 = r5 + 1
            goto L_0x010e
        L_0x0128:
            r5 = r8
        L_0x0129:
            r3 = r5
            boolean r4 = com.baidu.searchbox.account.userinfo.utils.UserInfoVipUtilsKt.getDuVIP()
            if (r4 == 0) goto L_0x013e
            if (r3 == r8) goto L_0x013e
            int r1 = com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager
            android.view.View r1 = r14._$_findCachedViewById(r1)
            com.baidu.searchbox.ui.viewpager.NoScrollViewPager r1 = (com.baidu.searchbox.ui.viewpager.NoScrollViewPager) r1
            r1.setCurrentItem(r3)
            goto L_0x0154
        L_0x013e:
            int r4 = com.baidu.searchbox.account.userinfo.R.id.user_cover_view_pager
            android.view.View r4 = r14._$_findCachedViewById(r4)
            com.baidu.searchbox.ui.viewpager.NoScrollViewPager r4 = (com.baidu.searchbox.ui.viewpager.NoScrollViewPager) r4
            r4.setCurrentItem(r2)
            com.baidu.searchbox.feed.tab.FeedNavigationAdapter r4 = r14.feedAdapter
            if (r4 == 0) goto L_0x0151
            com.baidu.searchbox.feed.tab.update.MultiTabItemInfo r1 = r4.getTabItemInfo(r2)
        L_0x0151:
            r0.onPageSelected(r2, r1)
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.activity.UserCoverActivity.showUserCoverList(com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryImageEntity):void");
    }

    private final void showLoadingView() {
        if (this.loadingView == null) {
            View inflate = LayoutInflater.from(this).inflate(com.baidu.searchbox.account.R.layout.account_loading_layout, (FrameLayout) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_loading_error_layout), false);
            if (inflate != null) {
                this.loadingView = (ShimmerFrameLayout) inflate;
                Drawable drawable = getResources().getDrawable(com.baidu.android.common.loading.R.drawable.white_shimmer_loading);
                ShimmerFrameLayout shimmerFrameLayout = this.loadingView;
                ImageView shimmerContent = shimmerFrameLayout != null ? (ImageView) shimmerFrameLayout.findViewById(com.baidu.searchbox.account.R.id.shimmer_content) : null;
                if (shimmerContent != null) {
                    shimmerContent.setImageDrawable(drawable);
                }
                ShimmerFrameLayout shimmerFrameLayout2 = this.loadingView;
                if (shimmerFrameLayout2 != null) {
                    shimmerFrameLayout2.setMaskShape(ShimmerFrameLayout.MaskShape.LINEAR);
                }
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
                lp.gravity = 17;
                ShimmerFrameLayout shimmerFrameLayout3 = this.loadingView;
                if (shimmerFrameLayout3 != null) {
                    shimmerFrameLayout3.setLayoutParams(lp);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.ui.ShimmerFrameLayout");
            }
        }
        FrameLayout layout = (FrameLayout) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_loading_error_layout);
        if (layout != null) {
            layout.removeAllViews();
            layout.setVisibility(0);
            layout.setBackgroundColor(getResources().getColor(R.color.GC9));
            layout.addView(this.loadingView);
        }
        ShimmerFrameLayout shimmerFrameLayout4 = this.loadingView;
        if (shimmerFrameLayout4 != null) {
            shimmerFrameLayout4.startShimmerAnimation();
        }
    }

    private final void hideLoadingView() {
        FrameLayout layout = (FrameLayout) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_loading_error_layout);
        if (layout != null) {
            layout.removeAllViews();
            layout.setVisibility(8);
        }
        ShimmerFrameLayout shimmerFrameLayout = this.loadingView;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.stopShimmerAnimation();
        }
        this.loadingView = null;
    }

    private final void showErrorView() {
        FrameLayout layout = (FrameLayout) _$_findCachedViewById(com.baidu.searchbox.account.userinfo.R.id.user_cover_loading_error_layout);
        if (layout != null) {
            layout.removeAllViews();
            layout.setVisibility(0);
            layout.setBackgroundColor(getResources().getColor(R.color.GC9));
            CommonEmptyView commonEmptyView = new CommonEmptyView(this);
            CommonEmptyView $this$showErrorView_u24lambda_u2d18_u24lambda_u2d17 = commonEmptyView;
            FrameLayout.LayoutParams $this$showErrorView_u24lambda_u2d18_u24lambda_u2d17_u24lambda_u2d15 = new FrameLayout.LayoutParams(-1, -1);
            $this$showErrorView_u24lambda_u2d18_u24lambda_u2d17_u24lambda_u2d15.gravity = 17;
            $this$showErrorView_u24lambda_u2d18_u24lambda_u2d17.setLayoutParams($this$showErrorView_u24lambda_u2d18_u24lambda_u2d17_u24lambda_u2d15);
            $this$showErrorView_u24lambda_u2d18_u24lambda_u2d17.setButtonText(com.baidu.searchbox.account.R.string.account_portrait_retry);
            $this$showErrorView_u24lambda_u2d18_u24lambda_u2d17.setTextButtonClickListener(new UserCoverActivity$$ExternalSyntheticLambda0(this));
            layout.addView(commonEmptyView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showErrorView$lambda-18$lambda-17$lambda-16  reason: not valid java name */
    public static final void m14526showErrorView$lambda18$lambda17$lambda16(UserCoverActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadUserCoverData();
    }

    private final ISlidingTabConfig getSlidingTabConfig() {
        return new UserCoverSlidingTabConfig();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/activity/UserCoverActivity$UserCoverMultiTabItemInfo;", "Lcom/baidu/searchbox/feed/tab/update/MultiTabItemInfo;", "data", "Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryCategoryEntity;", "(Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryCategoryEntity;)V", "getData", "()Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryCategoryEntity;", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UserCoverActivity.kt */
    public static final class UserCoverMultiTabItemInfo extends MultiTabItemInfo {
        private final PersonalPageGalleryCategoryEntity data;

        public final PersonalPageGalleryCategoryEntity getData() {
            return this.data;
        }

        public UserCoverMultiTabItemInfo(PersonalPageGalleryCategoryEntity data2) {
            Intrinsics.checkNotNullParameter(data2, "data");
            this.data = data2;
            this.mTitle = data2.getCateTitle();
            this.mId = data2.getCateId() + data2.getCateTitle();
            TabNameImageModel tabNameImageModel = new TabNameImageModel();
            TabNameImageModel $this$_init__u24lambda_u2d3 = tabNameImageModel;
            String it = data2.getTabImageUrl();
            if (it != null) {
                $this$_init__u24lambda_u2d3.setGeneralImage(it);
            }
            String it2 = data2.getTabNightImageUrl();
            if (it2 != null) {
                $this$_init__u24lambda_u2d3.setNightModeImage(it2);
            }
            Integer tabImageAndroidWidth = data2.getTabImageAndroidWidth();
            if (tabImageAndroidWidth != null) {
                $this$_init__u24lambda_u2d3.setDefaultWidth(tabImageAndroidWidth.intValue());
            }
            this.tabNameImgModel = tabNameImageModel;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/activity/UserCoverActivity$UserCoverSlidingTabConfig;", "Lcom/baidu/searchbox/feed/tab/config/DefaultSlidingTabConfig;", "()V", "getNameImg", "", "tabNameImageModel", "Lcom/baidu/searchbox/feed/tab/update/TabNameImageModel;", "getTabIndicatorColor", "", "adapter", "Lcom/baidu/searchbox/feed/tab/FeedNavigationAdapter;", "position", "getTabNormalColor", "getTabSelectedColor", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UserCoverActivity.kt */
    public static final class UserCoverSlidingTabConfig extends DefaultSlidingTabConfig {
        public int getTabIndicatorColor(FeedNavigationAdapter adapter, int position) {
            return AppRuntime.getAppContext().getResources().getColor(R.color.GC7);
        }

        public int getTabSelectedColor(FeedNavigationAdapter adapter, int position) {
            int tabSelectedColor = AppRuntime.getAppContext().getResources().getColor(R.color.GC1);
            MultiTabItemInfo tabItemInfo = adapter != null ? adapter.getTabItemInfo(position) : null;
            if (tabItemInfo == null || !(tabItemInfo instanceof UserCoverMultiTabItemInfo)) {
                return tabSelectedColor;
            }
            if (NightModeHelper.isNightMode()) {
                Number tabSelectedColorAndNight = ((UserCoverMultiTabItemInfo) tabItemInfo).getData().getTabSelectedColorAndNight();
                if (tabSelectedColorAndNight != null) {
                    return tabSelectedColorAndNight.intValue();
                }
                return tabSelectedColor;
            }
            Number tabSelectedColorAnd = ((UserCoverMultiTabItemInfo) tabItemInfo).getData().getTabSelectedColorAnd();
            if (tabSelectedColorAnd != null) {
                return tabSelectedColorAnd.intValue();
            }
            return tabSelectedColor;
        }

        public int getTabNormalColor(FeedNavigationAdapter adapter, int position) {
            return AppRuntime.getAppContext().getResources().getColor(R.color.GC4);
        }

        public String getNameImg(TabNameImageModel tabNameImageModel) {
            Intrinsics.checkNotNullParameter(tabNameImageModel, "tabNameImageModel");
            return tabNameImageModel.getGeneralImage();
        }
    }
}
