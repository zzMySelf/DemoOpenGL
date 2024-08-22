package com.baidu.searchbox.video.detail.plugin.component.general;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.toolbar.BaseToolBarExtKt;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.core.plugin.ComponentAdapter;
import com.baidu.searchbox.video.detail.message.MessageManifest;
import com.baidu.searchbox.video.detail.message.MessageUtils;
import com.baidu.searchbox.video.detail.plugin.component.player.servcie.local.ILocalPlayerService;

public class OfflineComponent extends ComponentAdapter {
    ImageView mImageView;
    TextView mTextView;
    LinearLayout mView;

    public View getView() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.mView = linearLayout;
        linearLayout.setOrientation(1);
        ViewGroup.MarginLayoutParams viewLayoutParams = new LinearLayout.LayoutParams(-1, -1);
        viewLayoutParams.setMargins(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(BaseToolBarExtKt.getBarHeightDimens(true)));
        this.mView.setLayoutParams(viewLayoutParams);
        this.mView.setBackgroundColor(this.mContext.getResources().getColor(R.color.video_detail_bg));
        this.mView.setGravity(17);
        ImageView imageView = new ImageView(this.mContext);
        this.mImageView = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mImageView.setImageResource(com.baidu.searchbox.videoplayer.ui.R.drawable.videoplayer_is_offline);
        this.mView.addView(this.mImageView);
        this.mTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(-2, -2);
        textParam.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.searchbox.feed.core.R.dimen.dimens_17dp);
        this.mTextView.setLayoutParams(textParam);
        this.mTextView.setTextSize(0, this.mContext.getResources().getDimension(com.baidu.searchbox.feed.core.R.dimen.dimens_14dp));
        this.mTextView.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.emptyview_title_text_color));
        this.mTextView.setText(R.string.video_offline);
        this.mView.addView(this.mTextView);
        this.mView.setVisibility(8);
        this.mView.setClickable(true);
        return this.mView;
    }

    public void onNightModeChanged(boolean isNightMode) {
        this.mView.setBackgroundColor(this.mContext.getResources().getColor(R.color.video_detail_bg));
        this.mTextView.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.emptyview_title_text_color));
        this.mImageView.setImageResource(com.baidu.searchbox.videoplayer.ui.R.drawable.videoplayer_is_offline);
    }

    public String getName() {
        return null;
    }

    public String getLayout() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void show() {
        this.mView.bringToFront();
        this.mView.setVisibility(0);
    }

    public void handleMessage(Message message) {
        if (message.what != 16128 || message.arg1 != 16139) {
            return;
        }
        if (this.mComponentManager.currentModel.commonModel == null || this.mComponentManager.currentModel.commonModel.offLine) {
            show();
            this.mComponentManager.notify(MessageUtils.obtainUbcMessage(MessageManifest.UBC.UBC_303));
            ILocalPlayerService service = (ILocalPlayerService) this.mComponentManager.getService(ILocalPlayerService.class);
            if (!(service == null || service.getPlayer() == null)) {
                service.getPlayer().stop();
                service.getPlayer().disableOrientationEventHelper();
            }
            String params = "";
            if (this.mComponentManager.currentModel.intentData != null) {
                params = this.mComponentManager.currentModel.intentData.params;
            }
            this.mComponentManager.notify(MessageUtils.obtainLandingStabilityMessage(MessageManifest.LandingStability.SERVER_META_EXCEPTION, getPd(), params));
            return;
        }
        hide();
    }

    /* access modifiers changed from: protected */
    public void hide() {
        this.mView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public String getPd() {
        if (this.mComponentManager.currentModel == null || this.mComponentManager.currentModel.intentData == null) {
            return null;
        }
        return this.mComponentManager.currentModel.intentData.pd;
    }
}
