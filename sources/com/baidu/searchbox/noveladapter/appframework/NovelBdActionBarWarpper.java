package com.baidu.searchbox.noveladapter.appframework;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ui.BdActionBar;

public class NovelBdActionBarWarpper implements NoProGuard {
    private BdActionBar mBdActionBar;

    public interface OnDoubleClickListener extends NoProGuard {
        void onDoubleClick(View view2);
    }

    public BdActionBar getBdActionBar() {
        return this.mBdActionBar;
    }

    public View getBdActionBarView() {
        return this.mBdActionBar;
    }

    public NovelBdActionBarWarpper(BdActionBar bar) {
        if (bar != null) {
            this.mBdActionBar = bar;
        }
    }

    public Object getTag() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getTag();
        }
        return null;
    }

    public void setTag(Object tag) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTag(tag);
        }
    }

    public void addView(View child) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.addView(child);
        }
    }

    public void removeView(View view2) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.removeView(view2);
        }
    }

    public void setBackgroundColor(int color) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setBackgroundColor(color);
        }
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getLayoutParams();
        }
        return null;
    }

    public void setLayoutParams(ViewGroup.LayoutParams params) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLayoutParams(params);
        }
    }

    public void setRightMenuVisibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightMenuVisibility(visibility);
        }
    }

    public boolean isRightMeuVisible() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.isRightMeuVisible();
        }
        return false;
    }

    public BdActionBar add(int id, CharSequence title) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.add(id, title);
        }
        return null;
    }

    public BdActionBar add(int id, int titleResId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.add(id, titleResId);
        }
        return null;
    }

    public BdActionBar add(int id, CharSequence title, Drawable icon) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.add(id, title, icon);
        }
        return null;
    }

    public BdActionBar add(int id, int titleResId, int iconResId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.add(id, titleResId, iconResId);
        }
        return null;
    }

    public int findItemIndex(int id) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.findItemIndex(id);
        }
        return 0;
    }

    public void notifyMenuSetChanged() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.notifyMenuSetChanged();
        }
    }

    public BdActionBar removeItem(int id) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.removeItem(id);
        }
        return null;
    }

    public View getTitleTextCenterView() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return (TextView) bdActionBar.findViewById(R.id.title_text_center);
        }
        return null;
    }

    public View getLeftFirstView() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getLeftFirstView();
        }
        return null;
    }

    public View getLeftSecondView() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return (TextView) bdActionBar.findViewById(R.id.left_second_view);
        }
        return null;
    }

    public View getRightTxtView() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightTxtView();
        }
        return null;
    }

    public View getRightImgZone2() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightImgZone2();
        }
        return null;
    }

    public View getRightImgZone1() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightImgZone1();
        }
        return null;
    }

    public void setTitleBarTitleSize(float size) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitleBarTitleSize(size);
        }
    }

    public void setTitleAlignment(int alignment) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitleAlignment(alignment);
        }
    }

    public void setSubTitle(String subtitle) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setSubTitle(subtitle);
        }
    }

    public void setSubTitle(int resid) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setSubTitle(resid);
        }
    }

    public String getSubTitle() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getSubTitle();
        }
        return null;
    }

    public void setSubTitleColor(int color) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setSubTitleColor(color);
        }
    }

    public void setTitle(String title) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitle(title);
        }
    }

    public void setTitle(int resid) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitle(resid);
        }
    }

    public String getTitle() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getTitle();
        }
        return null;
    }

    public void setTitleColor(int colorId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitleColor(colorId);
        }
    }

    public void setTitleSize(int textSize) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitleSize(textSize);
        }
    }

    public void setTitlePadding(int left, int top, int right, int bottom) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitlePadding(left, top, right, bottom);
        }
    }

    public void setTitleShadowLayer(float radius, float dx, float dy, int color) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitleShadowLayer(radius, dx, dy, color);
        }
    }

    public void setRightTxtZone1Text(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1Text(resId);
        }
    }

    public void setRightTxtZone1Text(CharSequence text) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1Text(text);
        }
    }

    public void setRightTxtZone1TextSelector(ColorStateList color) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1TextSelector(color);
        }
    }

    public void setRightTxtZone1TextColor(int color) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1TextColor(color);
        }
    }

    public void setRightTxtZone1TextColorList(ColorStateList aList) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1TextColorList(aList);
        }
    }

    public void setRightTxtZone1TextSize(int textSize) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1TextSize(textSize);
        }
    }

    public void setRightTxtZone1Enable(boolean enabled) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1Enable(enabled);
        }
    }

    public void hideRightTxtZone1Progress() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.hideRightTxtZone1Progress();
        }
    }

    public void showRightTxtZone1Progress() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.showRightTxtZone1Progress();
        }
    }

    public void setRightTxtZone1Visibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1Visibility(visibility);
        }
    }

    public int getRightTxtZone1Visibility() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightTxtZone1Visibility();
        }
        return 0;
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftZoneOnClickListener(onClickListener);
        }
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1OnClickListener(onClickListener);
        }
    }

    public void setRightTxt1OnClickListener(View.OnClickListener onClickListener) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxt1OnClickListener(onClickListener);
        }
    }

    public void setRightTxtZone1Clickable(boolean clickable) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1Clickable(clickable);
        }
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2OnClickListener(onClickListener);
        }
    }

    public void setRightZone2ImageVisibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightZone2ImageVisibility(visibility);
        }
    }

    public void setRightImgZone2ContentDes(String contentDes) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2ContentDes(contentDes);
        }
    }

    public void setRightImgZone1ContentDes(String contentDes) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone1ContentDes(contentDes);
        }
    }

    public void setRightImgZone2Width(int width) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2Width(width);
        }
    }

    public void setRightImgZone2ImgWidth(int width) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2ImgWidth(width);
        }
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone1OnClickListener(onClickListener);
        }
    }

    public void setRightImageZone1Params(int width, int height) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImageZone1Params(width, height);
        }
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImageZone1Params(layoutParams);
        }
    }

    public void setRightImgZone1Enable(boolean enabled) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone1Enable(enabled);
        }
    }

    public void setRightImgZone1Src(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone1Src(resId);
        }
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone1ImageScaleType(scaleType);
        }
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2ImageScaleType(scaleType);
        }
    }

    public void setRightImgZone2Enable(boolean enabled) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2Enable(enabled);
        }
    }

    public void setRightImgZone2Src(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2Src(resId);
        }
    }

    public void setRightImgZone2Url(String url) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2Url(url);
        }
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2ImageSrc(drawable);
        }
    }

    public void setRightImgZone2Params(int leftMargin, int rightMargin, int topMargin) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2Params(leftMargin, rightMargin, topMargin);
        }
    }

    public void setRightImgZone2Visibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2Visibility(visibility);
        }
    }

    public void setRightImgZone1Visibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone1Visibility(visibility);
        }
    }

    public void setRightImgZone2NotifyVisibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone2NotifyVisibility(visibility);
        }
    }

    public int getRightTxtZone1ProgressVisibility() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightTxtZone1ProgressVisibility();
        }
        return 0;
    }

    public int getRightImgZone2NotifyVisibility() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightImgZone2NotifyVisibility();
        }
        return 0;
    }

    public void setLeftZoneImageSrc(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftZoneImageSrc(resId);
        }
    }

    public void setLeftZoneImageSrc(int resId, int width, int height) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftZoneImageSrc(resId, width, height);
        }
    }

    public void setLeftZoneImageSrcPadding(int padding) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftZoneImageSrcPadding(padding);
        }
    }

    public void setLeftZoneImageSrcMinWidth(int minWidth) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftZoneImageSrcMinWidth(minWidth);
        }
    }

    public void setLeftZoneImageSelected(boolean selected) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftZoneImageSelected(selected);
        }
    }

    public boolean isLeftZoneImageSelected() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.isLeftZoneImageSelected();
        }
        return false;
    }

    public void setTxtZoneBackgroundResource(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTxtZoneBackgroundResource(resId);
        }
    }

    public void setTxtZoneBackgroundMinimumWidth(int width) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTxtZoneBackgroundMinimumWidth(width);
        }
    }

    public void setTxtZoneBackgroundMinimumHeight(int height) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTxtZoneBackgroundMinimumHeight(height);
        }
    }

    public void setImgZoneBackgroundResource(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setImgZoneBackgroundResource(resId);
        }
    }

    public void setRightImgZone1ImageSrc(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone1ImageSrc(resId);
        }
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightImgZone1ImageSrc(drawable);
        }
    }

    public void setLeftSecondViewVisibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftSecondViewVisibility(visibility);
        }
    }

    public void setLeftSecondViewText(String text) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftSecondViewText(text);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList color) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftFirstViewSelector(color);
        }
    }

    public void setLeftSecondViewTextSize(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftSecondViewTextSize(resId);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener clickListener) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftSecondViewClickListener(clickListener);
        }
    }

    public void setLeftSecondViewImageSrc(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftSecondViewImageSrc(resId);
        }
    }

    public void setLeftSecondViewImageSrc(int resId, int width, int height) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftSecondViewImageSrc(resId, width, height);
        }
    }

    public void setLeftSecondViewImageSrcPadding(int padding) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftSecondViewImageSrcPadding(padding);
        }
    }

    public void setLeftTitleInvalidate(boolean isLeftTitleInvalidate) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftTitleInvalidate(isLeftTitleInvalidate);
        }
    }

    public void setLeftTitle(String leftTitle) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftTitle(leftTitle);
        }
    }

    public void setRightMenuImageSrc(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightMenuImageSrc(resId);
        }
    }

    public void setOnDoubleClickListener(final OnDoubleClickListener listener) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setOnDoubleClickListener(listener == null ? null : new BdActionBar.OnDoubleClickListener() {
                public void onDoubleClick(View view2) {
                    listener.onDoubleClick(view2);
                }
            });
        }
    }

    public void setLeftFirstViewVisibility(boolean isVisible) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftFirstViewVisibility(isVisible);
        }
    }

    public void setLeftFirstViewVisibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftFirstViewVisibility(visibility);
        }
    }

    public void setRightTxtZone1Background(int resid) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone1Background(resid);
        }
    }

    public void setRightTxtZone2Visibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone2Visibility(visibility);
        }
    }

    public int getRightTxtZone2Visibility() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightTxtZone2Visibility();
        }
        return 0;
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone2OnClickListener(onClickListener);
        }
    }

    public void setRightTxtZone2Text(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone2Text(resId);
        }
    }

    public void setRightTxtZone2TextSize(int textSize) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone2TextSize(textSize);
        }
    }

    public void setRightTxtZone2TextColor(int color) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTxtZone2TextColor(color);
        }
    }

    public void setRightTipsStatus(boolean isShow) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightTipsStatus(isShow);
        }
    }

    public void setLeftZonesVisibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftZonesVisibility(visibility);
        }
    }

    public void setRightMenuClickListner(View.OnClickListener listner) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightMenuClickListner(listner);
        }
    }

    public void applyServerConfig(int config) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.applyServerConfig(config);
        }
    }

    public int getTitleColorId() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getTitleColorId();
        }
        return 0;
    }

    public int getRightMenuImageViewSrcId() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightMenuImageViewSrcId();
        }
        return 0;
    }

    public int getRightImgZone1ImageSrcId() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightImgZone1ImageSrcId();
        }
        return 0;
    }

    public int getRightImgZone2ImageSrcId() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.getRightImgZone2ImageSrcId();
        }
        return 0;
    }

    public boolean isRightZone2Visible() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.isRightZone2Visible();
        }
        return false;
    }

    public boolean isRightImgZone1Visible() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            return bdActionBar.isRightImgZone1Visible();
        }
        return false;
    }

    public void setRightZonesVisibility(int visibility) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setRightZonesVisibility(visibility);
        }
    }
}
