package com.baidu.searchbox.socialshare.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.rewardsystem.newtimer.constants.NewTimerConstants;
import com.baidu.searchbox.socialshare.R;
import com.baidu.searchbox.socialshare.bean.BaiduShareContent;
import com.baidu.searchbox.socialshare.statistics.SocialShareStatisticHelper;
import com.baidu.searchbox.socialshare.utils.ShareUtils;
import com.baidu.searchbox.socialshare.utils.Utils;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.share.core.bean.Theme;
import com.baidu.share.widget.MenuItem;
import com.baidu.share.widget.MenuItemWrapper;
import java.util.List;

public class ShareMenuGridViewAdapter extends ArrayAdapter<MenuItemWrapper> {
    private BaiduShareContent mBaiduShareContent;
    private Context mContext;
    private int mNumColumns;
    public OnItemClickListener mOnItemClickListener;
    private Theme mTheme;

    public interface OnItemClickListener {
        void onItemClick(View view2, int i2);
    }

    public ShareMenuGridViewAdapter(Context context, List<MenuItemWrapper> medias, Theme theme, BaiduShareContent baiduShareContent, int numColumns) {
        super(context, 0, medias);
        this.mContext = context;
        if (theme == null) {
            this.mTheme = Theme.LIGHT;
        }
        this.mTheme = theme;
        this.mNumColumns = numColumns;
        this.mBaiduShareContent = baiduShareContent;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null || convertView.getTag() == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(this.mContext.getApplicationContext()).inflate(R.layout.htwo_line_scroll_share_menu_grid_item, (ViewGroup) null, false);
            View unused = viewHolder.item = convertView;
            BdBaseImageView unused2 = viewHolder.imageView = (BdBaseImageView) convertView.findViewById(R.id.menu_icon_image);
            FrameLayout unused3 = viewHolder.imageArea = (FrameLayout) convertView.findViewById(R.id.image_area);
            TextView unused4 = viewHolder.textView = (TextView) convertView.findViewById(R.id.menu_icon_text);
            BdBaseImageView unused5 = viewHolder.redPacketView = (BdBaseImageView) convertView.findViewById(R.id.menu_redpacket);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (this.mContext != null) {
            viewHolder.redPacketView.setImageDrawable(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.bdsocialshare_redpacket, (Resources.Theme) null));
        }
        MenuItemWrapper item = (MenuItemWrapper) getItem(position);
        setIconSelector(viewHolder.imageView, viewHolder.textView, item);
        convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ShareMenuGridViewAdapter.this.mOnItemClickListener != null) {
                    ShareMenuGridViewAdapter.this.mOnItemClickListener.onItemClick(viewHolder.item, position);
                }
            }
        });
        if (!processRedPacket(item.type, viewHolder.redPacketView)) {
            playAnimator(this.mContext, viewHolder.imageArea, item);
        }
        return convertView;
    }

    private boolean processRedPacket(MenuItem item, BdBaseImageView view2) {
        if (item == null || view2 == null || !ShareUtils.isShareRedPacketOuterShow()) {
            return false;
        }
        if (item == MenuItem.WXTIMELINE || item == MenuItem.WXFRIEND || item == MenuItem.QQFRIEND) {
            if (this.mNumColumns == 5) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view2.getLayoutParams();
                params.rightMargin += Utils.dp2px(3.3f);
                view2.setLayoutParams(params);
            }
            view2.setVisibility(0);
            return true;
        }
        view2.setVisibility(8);
        return false;
    }

    private void playAnimator(Context context, View view2, MenuItemWrapper item) {
        Context context2 = context;
        View view3 = view2;
        MenuItemWrapper menuItemWrapper = item;
        if (context2 == null || view3 == null || menuItemWrapper == null) {
            return;
        }
        BaiduShareContent baiduShareContent = this.mBaiduShareContent;
        if (baiduShareContent != null) {
            String source = SocialShareStatisticHelper.getShareSource(baiduShareContent.getSource());
            String type = menuItemWrapper.type.getName();
            if (Utils.isPanelItemNeedNewAnimation(type, source)) {
                int transY = -DeviceUtils.ScreenInfo.dp2px(context2, 3.0f);
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(view3, "scaleX", new float[]{1.0f, 1.1f, 1.0f, 1.1f, 1.0f, 1.0f, 1.0f, 1.1f, 1.0f, 1.1f, 1.0f});
                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(view3, "scaleY", new float[]{1.0f, 1.1f, 1.0f, 1.1f, 1.0f, 1.0f, 1.0f, 1.1f, 1.0f, 1.1f, 1.0f});
                ObjectAnimator transYAnimator = ObjectAnimator.ofFloat(view3, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{0.0f, (float) transY, 0.0f, (float) transY, 0.0f, 0.0f, 0.0f, (float) transY, 0.0f, (float) transY, 0.0f});
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(scaleXAnimator).with(scaleYAnimator).with(transYAnimator);
                animatorSet.setInterpolator(new LinearInterpolator());
                animatorSet.setDuration(4000);
                animatorSet.start();
            } else if (Utils.isPanelItemNeedAnimation(type, source, true)) {
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(view3, "scaleX", new float[]{1.0f, 0.9f, 1.15f, 1.0f, 1.15f, 1.0f});
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(view3, "scaleY", new float[]{1.0f, 0.9f, 1.15f, 1.0f, 1.15f, 1.0f});
                ObjectAnimator animatorTrans = ObjectAnimator.ofFloat(view3, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{0.0f, 0.0f, (float) (-DeviceUtil.ScreenInfo.dp2px(context2, 4.0f)), 0.0f, (float) (-DeviceUtil.ScreenInfo.dp2px(context2, 3.3f)), 0.0f});
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.play(scaleX).with(scaleY).with(animatorTrans);
                animatorSet2.setDuration(1500);
                animatorSet2.start();
            }
        }
    }

    private void setIconSelector(ImageView icon, TextView textView, MenuItemWrapper item) {
        icon.setImageDrawable(ResourcesCompat.getDrawable(this.mContext.getApplicationContext().getResources(), item.resId, (Resources.Theme) null));
        if (this.mTheme == Theme.DARK) {
            textView.setTextColor(this.mContext.getApplicationContext().getResources().getColorStateList(R.color.bdsocialshare_menu_text_transparent_selector));
        } else {
            textView.setTextColor(this.mContext.getApplicationContext().getResources().getColorStateList(R.color.bdsocialshare_menu_text_selector));
        }
        textView.setText(item.text);
    }

    private class ViewHolder {
        /* access modifiers changed from: private */
        public FrameLayout imageArea;
        /* access modifiers changed from: private */
        public BdBaseImageView imageView;
        /* access modifiers changed from: private */
        public View item;
        /* access modifiers changed from: private */
        public BdBaseImageView redPacketView;
        /* access modifiers changed from: private */
        public TextView textView;

        private ViewHolder() {
        }
    }
}
