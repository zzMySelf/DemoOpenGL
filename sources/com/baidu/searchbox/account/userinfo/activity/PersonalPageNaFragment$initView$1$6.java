package com.baidu.searchbox.account.userinfo.activity;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.account.userinfo.PersonalPageAbTestMgr;
import com.baidu.searchbox.account.userinfo.feed.PersonalPageWebPageView;
import com.baidu.searchbox.account.userinfo.feed.common.CommonListPage;
import com.baidu.searchbox.account.userinfo.layout.NestedScrollingParent2Layout;
import com.baidu.searchbox.account.userinfo.utils.PersonalPageNaUbcUtils;
import com.baidu.searchbox.account.userinfo.view.PersonalPageTopBar;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.feed.container.FeedContainer;
import com.baidu.searchbox.feed.flow.FlowPagerView;
import com.baidu.searchbox.feed.tab.fragment.FeedBaseFragment;
import com.baidu.searchbox.feed.widget.feedflow.IPagerView;
import com.baidu.searchbox.follow.Relation;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.talos.view.scroll.IScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/PersonalPageNaFragment$initView$1$6", "Lcom/baidu/searchbox/account/userinfo/layout/NestedScrollingParent2Layout$ScrollVertically;", "canScrollVertically", "", "headerScrollDy", "", "scrollHeight", "", "currentScrollHeight", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNaFragment.kt */
public final class PersonalPageNaFragment$initView$1$6 implements NestedScrollingParent2Layout.ScrollVertically {
    final /* synthetic */ View $this_run;
    final /* synthetic */ PersonalPageNaFragment this$0;

    PersonalPageNaFragment$initView$1$6(PersonalPageNaFragment $receiver, View $receiver2) {
        this.this$0 = $receiver;
        this.$this_run = $receiver2;
    }

    public boolean canScrollVertically() {
        RecyclerView recyclerView;
        if (this.this$0.feedContainer != null) {
            FeedContainer access$getFeedContainer$p = this.this$0.feedContainer;
            FeedBaseFragment currentFragment = access$getFeedContainer$p != null ? access$getFeedContainer$p.getCurrentFragment() : null;
            if (currentFragment != null) {
                IPagerView pagerViewImpl = currentFragment.getPagerViewImpl();
                if (pagerViewImpl instanceof FlowPagerView) {
                    return ((FlowPagerView) pagerViewImpl).getPage().canChildScrollUp();
                }
                if (pagerViewImpl instanceof PersonalPageWebPageView) {
                    return !((PersonalPageWebPageView) pagerViewImpl).isScrollToTop();
                }
                if (pagerViewImpl instanceof CommonListPage) {
                    return ((CommonListPage) pagerViewImpl).canRVScrollDown();
                }
                if (!currentFragment.isRN() || (recyclerView = this.this$0.findVerticalScrollableViewByBFS(currentFragment.getRootView())) == null) {
                    return false;
                }
                if (recyclerView instanceof IScroller) {
                    if (((IScroller) recyclerView).getScrollerY() > 0) {
                        return true;
                    }
                    return false;
                } else if (recyclerView.computeVerticalScrollOffset() > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void headerScrollDy(int scrollHeight, int currentScrollHeight) {
        String value;
        int topBarGoneOffset = (this.this$0.mTopSpaceMarginTop - this.this$0.mTopBarHeight) - this.this$0.mStatusBarHeight;
        View view2 = null;
        if (currentScrollHeight >= topBarGoneOffset) {
            View access$getMTopBarLayout$p = this.this$0.mTopBarLayout;
            if (access$getMTopBarLayout$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopBarLayout");
                access$getMTopBarLayout$p = null;
            }
            access$getMTopBarLayout$p.setVisibility(8);
            View access$getMTopBarJokerLayout$p = this.this$0.mTopBarJokerLayout;
            if (access$getMTopBarJokerLayout$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopBarJokerLayout");
            } else {
                view2 = access$getMTopBarJokerLayout$p;
            }
            view2.setVisibility(8);
        } else {
            float rate = ((float) (topBarGoneOffset - currentScrollHeight)) / ((float) topBarGoneOffset);
            View access$getMTopBarLayout$p2 = this.this$0.mTopBarLayout;
            if (access$getMTopBarLayout$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopBarLayout");
                access$getMTopBarLayout$p2 = null;
            }
            access$getMTopBarLayout$p2.setAlpha(rate);
            View access$getMTopBarLayout$p3 = this.this$0.mTopBarLayout;
            if (access$getMTopBarLayout$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopBarLayout");
                access$getMTopBarLayout$p3 = null;
            }
            access$getMTopBarLayout$p3.setVisibility(0);
            View access$getMTopBarJokerLayout$p2 = this.this$0.mTopBarJokerLayout;
            if (access$getMTopBarJokerLayout$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopBarJokerLayout");
            } else {
                view2 = access$getMTopBarJokerLayout$p2;
            }
            view2.setVisibility(0);
        }
        int nestTopBarVisibleOffset = this.this$0.mTopSpaceMarginTop;
        if (this.this$0.nestTopBar == null) {
            this.this$0.initNestTopBar();
        }
        IUpdateStatusBarStyle updateStatusBarStyle = this.this$0.getUpdateStatusBarStyle();
        if (updateStatusBarStyle != null) {
            updateStatusBarStyle.style(!NightModeHelper.isNightMode());
        }
        if (currentScrollHeight == scrollHeight) {
            PersonalPageTopBar access$getNestTopBar$p = this.this$0.nestTopBar;
            if (access$getNestTopBar$p != null) {
                access$getNestTopBar$p.setAlpha(1.0f);
            }
            PersonalPageTopBar access$getNestTopBar$p2 = this.this$0.nestTopBar;
            if (access$getNestTopBar$p2 != null) {
                access$getNestTopBar$p2.setUserInfoAreaAlpha(1.0f);
            }
            PersonalPageTopBar access$getNestTopBar$p3 = this.this$0.nestTopBar;
            if (access$getNestTopBar$p3 != null) {
                access$getNestTopBar$p3.setVisibility(0);
            }
        } else {
            int startDis = nestTopBarVisibleOffset - DeviceUtils.ScreenInfo.getStatusBarHeight();
            float scrollDis = FontSizeHelper.getScaledSize(0, DeviceUtils.ScreenInfo.dp2pxf(this.$this_run.getContext(), 10.0f));
            if (currentScrollHeight < currentScrollHeight - startDis) {
                PersonalPageTopBar access$getNestTopBar$p4 = this.this$0.nestTopBar;
                if (access$getNestTopBar$p4 != null) {
                    access$getNestTopBar$p4.setUserInfoAreaAlpha(0.0f);
                }
            } else {
                float v = ((float) (currentScrollHeight - startDis)) / scrollDis;
                PersonalPageTopBar access$getNestTopBar$p5 = this.this$0.nestTopBar;
                if (access$getNestTopBar$p5 != null) {
                    access$getNestTopBar$p5.setUserInfoAreaAlpha(v);
                }
            }
            float nestBarAlpha = ((float) currentScrollHeight) / (((float) nestTopBarVisibleOffset) - this.this$0.alphaOffset);
            PersonalPageTopBar access$getNestTopBar$p6 = this.this$0.nestTopBar;
            if (access$getNestTopBar$p6 != null) {
                access$getNestTopBar$p6.setAlpha(nestBarAlpha);
            }
            if (nestBarAlpha <= 0.0f) {
                PersonalPageTopBar access$getNestTopBar$p7 = this.this$0.nestTopBar;
                if (access$getNestTopBar$p7 != null) {
                    access$getNestTopBar$p7.setVisibility(8);
                }
            } else {
                PersonalPageTopBar access$getNestTopBar$p8 = this.this$0.nestTopBar;
                if (access$getNestTopBar$p8 != null) {
                    access$getNestTopBar$p8.setVisibility(0);
                }
            }
        }
        if (this.this$0.isTopFollowShow) {
            switch (this.this$0.followActivityType) {
                case 1:
                    value = PersonalPageNaUbcUtils.UBC_VALUE_ADD_RED_PACKET;
                    break;
                case 2:
                    value = PersonalPageNaUbcUtils.UBC_VALUE_ADD_COUPON;
                    break;
                case 3:
                    value = PersonalPageNaUbcUtils.UBC_VALUE_ADD_LOTTERY;
                    break;
                default:
                    if (this.this$0.mRelation != Relation.FOLLOWED_ME) {
                        value = PersonalPageNaUbcUtils.UBC_VALUE_ADD_NONE;
                        break;
                    } else {
                        value = PersonalPageNaUbcUtils.UBC_VALUE_ADD_BY;
                        break;
                    }
            }
            PersonalPageNaFragment.doUbcWithFilter$default(this.this$0, value, PersonalPageNaUbcUtils.UBC_TYPE_UP_CONTENT_SHOW, (JSONObject) null, (String) null, 12, (Object) null);
        } else if (this.this$0.isTopLetterShow) {
            PersonalPageNaFragment.doUbcWithFilter$default(this.this$0, "up", PersonalPageNaUbcUtils.UBC_TYPE_TALK_SHOW, (JSONObject) null, (String) null, 12, (Object) null);
        }
        if (PersonalPageAbTestMgr.INSTANCE.isHitFloatFollowTest() && !this.this$0.isSelfPage && !this.this$0.getRealTimeFollowStatus()) {
            this.this$0.updateFloatFollowAlpha(false, currentScrollHeight);
        }
    }
}
