package com.baidu.searchbox.feed.biserialdetail.content.banner;

import android.os.Handler;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.feed.biserialdetail.model.DynamicDetailFlow;
import com.baidu.searchbox.feed.biserialdetail.ubc.DynamicDetailStatisticsHelper;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/content/banner/BannerIndexManager$setViews$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannerIndexManager.kt */
public final class BannerIndexManager$setViews$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ TextView $imgIndexView;
    final /* synthetic */ BannerIndexManager this$0;

    BannerIndexManager$setViews$1(BannerIndexManager $receiver, TextView $imgIndexView2) {
        this.this$0 = $receiver;
        this.$imgIndexView = $imgIndexView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.getAdapter();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageScrollStateChanged(int r6) {
        /*
            r5 = this;
            com.baidu.searchbox.feed.biserialdetail.content.banner.BannerIndexManager r0 = r5.this$0
            com.baidu.searchbox.feed.biserialdetail.base.ui.AdjustSizeViewPager r0 = r0.mViewPager
            r1 = 0
            if (r0 == 0) goto L_0x0014
            androidx.viewpager.widget.PagerAdapter r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x0014
            int r0 = r0.getCount()
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            r2 = 1
            if (r0 <= r2) goto L_0x0052
            if (r6 != r2) goto L_0x003b
            com.baidu.searchbox.feed.biserialdetail.content.banner.BannerIndexManager r3 = r5.this$0
            com.baidu.searchbox.feed.biserialdetail.content.DynamicLinkageContent$IDynamicContentListener r3 = r3.scrollListener
            if (r3 == 0) goto L_0x0025
            r3.onBannerDraggingStart()
        L_0x0025:
            com.baidu.searchbox.feed.biserialdetail.content.banner.BannerIndexManager r3 = r5.this$0
            r3.pageHasChanged = r1
            com.baidu.searchbox.feed.biserialdetail.content.banner.BannerIndexManager r3 = r5.this$0
            android.os.Handler r3 = r3.mImgHandler
            if (r3 == 0) goto L_0x0035
            r3.removeMessages(r2)
        L_0x0035:
            android.widget.TextView r2 = r5.$imgIndexView
            r2.setVisibility(r1)
            goto L_0x0052
        L_0x003b:
            if (r6 != 0) goto L_0x0052
            com.baidu.searchbox.feed.biserialdetail.content.banner.BannerIndexManager r1 = r5.this$0
            boolean r1 = r1.pageHasChanged
            if (r1 != 0) goto L_0x0052
            com.baidu.searchbox.feed.biserialdetail.content.banner.BannerIndexManager r1 = r5.this$0
            android.os.Handler r1 = r1.mImgHandler
            if (r1 == 0) goto L_0x0052
            r3 = 2000(0x7d0, double:9.88E-321)
            r1.sendEmptyMessageDelayed(r2, r3)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.biserialdetail.content.banner.BannerIndexManager$setViews$1.onPageScrollStateChanged(int):void");
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        DynamicDetailStatisticsHelper statisticsHelper;
        String str;
        ImageData imageData;
        this.this$0.mCurImageIndex = position;
        this.this$0.pageHasChanged = true;
        BannerPageAdapter $this$onPageSelected_u24lambda_u2d1 = this.this$0.mPagerAdapter;
        if ($this$onPageSelected_u24lambda_u2d1 != null) {
            BannerIndexManager bannerIndexManager = this.this$0;
            $this$onPageSelected_u24lambda_u2d1.stopPlayGif(position);
            $this$onPageSelected_u24lambda_u2d1.startPlayGif(position);
            if (position > 0) {
                $this$onPageSelected_u24lambda_u2d1.stopPlayGif(position - 1);
            }
            bannerIndexManager.updateImageIndexIfNeeded(position, $this$onPageSelected_u24lambda_u2d1.getCount());
            if (position < $this$onPageSelected_u24lambda_u2d1.getCount() - 1) {
                $this$onPageSelected_u24lambda_u2d1.stopPlayGif(position + 1);
            }
            DynamicDetailFlow.DynamicDetailBaseModel model = $this$onPageSelected_u24lambda_u2d1.getDynamicBaseModel();
            if (!(model == null || (statisticsHelper = $this$onPageSelected_u24lambda_u2d1.getStatisticsHelper()) == null)) {
                List data = $this$onPageSelected_u24lambda_u2d1.getData();
                if (data == null || (imageData = (ImageData) data.get(position)) == null || (str = imageData.getType()) == null) {
                    str = "";
                }
                statisticsHelper.slideImageStatistics(model, position, str);
            }
            $this$onPageSelected_u24lambda_u2d1.updatePageSelected(Integer.valueOf(position));
        }
        this.$imgIndexView.setVisibility(0);
        Handler access$getMImgHandler$p = this.this$0.mImgHandler;
        if (access$getMImgHandler$p != null) {
            access$getMImgHandler$p.sendEmptyMessageDelayed(1, 2000);
        }
    }
}
