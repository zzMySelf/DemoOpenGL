package com.baidu.searchbox.purelisten;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.searchbox.feed.container.FeedContainer;
import com.baidu.searchbox.feed.container.IFeedContainerDelegate;
import com.baidu.searchbox.feed.listener.ManualScrollChangeListener;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.tab.interaction.IRestoreFragmentHandler;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.music.utils.PureListenUbcUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"com/baidu/searchbox/purelisten/PureListenPageView$initFeedContainer$findDelegate$1", "Lcom/baidu/searchbox/feed/container/IFeedContainerDelegate;", "Lcom/baidu/searchbox/feed/tab/interaction/IRestoreFragmentHandler;", "feedContainer", "Lcom/baidu/searchbox/feed/container/FeedContainer;", "getFeedContainer", "()Lcom/baidu/searchbox/feed/container/FeedContainer;", "setFeedContainer", "(Lcom/baidu/searchbox/feed/container/FeedContainer;)V", "getDefaultPos", "", "onPageSelected", "", "position", "onRestoreFragment", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onViewPause", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PureListenPageView.kt */
public final class PureListenPageView$initFeedContainer$findDelegate$1 implements IFeedContainerDelegate, IRestoreFragmentHandler {
    public FeedContainer feedContainer;
    final /* synthetic */ PureListenPageView this$0;

    PureListenPageView$initFeedContainer$findDelegate$1(PureListenPageView $receiver) {
        this.this$0 = $receiver;
    }

    public <T> T asInstanceOrNull(Class<T> clazz) {
        return IFeedContainerDelegate.DefaultImpls.asInstanceOrNull(this, clazz);
    }

    public boolean isManualDragging() {
        return IFeedContainerDelegate.DefaultImpls.isManualDragging(this);
    }

    public void onPageScrollStateChanged(int state) {
        IFeedContainerDelegate.DefaultImpls.onPageScrollStateChanged(this, state);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        IFeedContainerDelegate.DefaultImpls.onPageScrolled(this, position, positionOffset, positionOffsetPixels);
    }

    public void onViewCreate() {
        IFeedContainerDelegate.DefaultImpls.onViewCreate(this);
    }

    public void onViewDestroy() {
        IFeedContainerDelegate.DefaultImpls.onViewDestroy(this);
    }

    public void onViewResume() {
        IFeedContainerDelegate.DefaultImpls.onViewResume(this);
    }

    public void onViewStart() {
        IFeedContainerDelegate.DefaultImpls.onViewStart(this);
    }

    public void onViewStop() {
        IFeedContainerDelegate.DefaultImpls.onViewStop(this);
    }

    public <T> T queryInterface(Class<T> clazz) {
        return IFeedContainerDelegate.DefaultImpls.queryInterface(this, clazz);
    }

    public void setContainer(FeedContainer feedContainer2) {
        IFeedContainerDelegate.DefaultImpls.setContainer(this, feedContainer2);
    }

    public void setManualScrollChangeListener(ManualScrollChangeListener listener) {
        IFeedContainerDelegate.DefaultImpls.setManualScrollChangeListener(this, listener);
    }

    public FeedContainer getFeedContainer() {
        FeedContainer feedContainer2 = this.feedContainer;
        if (feedContainer2 != null) {
            return feedContainer2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feedContainer");
        return null;
    }

    public void setFeedContainer(FeedContainer feedContainer2) {
        Intrinsics.checkNotNullParameter(feedContainer2, "<set-?>");
        this.feedContainer = feedContainer2;
    }

    public int getDefaultPos() {
        MultiTabItemInfo defaultTab = this.this$0.getTabInfoByPos(this.this$0.getDefaultTabPos());
        String str = null;
        PureListenPageViewKt.setCurChannelId(defaultTab != null ? defaultTab.mId : null);
        if (defaultTab != null) {
            str = defaultTab.mId;
        }
        if (str == null) {
            str = "";
        }
        PureListenUbcUtilsKt.pureListenUBCEvent$default("show", this.this$0.getSource(), str, (JSONObject) null, 8, (Object) null);
        return this.this$0.getDefaultTabPos();
    }

    public void onPageSelected(int position) {
        if (position != PureListenPageView.Companion.getSelectPos()) {
            MultiTabItemInfo defaultTab = this.this$0.getTabInfoByPos(position);
            String str = null;
            PureListenPageViewKt.setCurChannelId(defaultTab != null ? defaultTab.mId : null);
            if (defaultTab != null) {
                str = defaultTab.mId;
            }
            if (str == null) {
                str = "";
            }
            PureListenUbcUtilsKt.pureListenUBCEvent$default("show", this.this$0.getSource(), str, (JSONObject) null, 8, (Object) null);
        }
        PureListenPageView.Companion.setSelectPos(position);
    }

    public void onViewPause() {
    }

    public void onRestoreFragment(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        OnLineLog.get(OnLineLog.TAG_TTS).d("PureListenPageView[onRestoreFragment:]兴趣分类恢复重建，FragmentSize:" + fragmentManager.getFragments().size());
        List<Fragment> fragments = fragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "it");
        if (!fragments.isEmpty()) {
            FragmentTransaction $this$onRestoreFragment_u24lambda_u2d1_u24lambda_u2d0 = fragmentManager.beginTransaction();
            for (Fragment fragment : fragments) {
                OnLineLog.get(OnLineLog.TAG_TTS).d("PureListenPageView[onRestoreFragment:]移除不可用Fragment:" + fragment.getTag());
                $this$onRestoreFragment_u24lambda_u2d1_u24lambda_u2d0.remove(fragment);
            }
            $this$onRestoreFragment_u24lambda_u2d1_u24lambda_u2d0.commitNowAllowingStateLoss();
        }
    }
}
