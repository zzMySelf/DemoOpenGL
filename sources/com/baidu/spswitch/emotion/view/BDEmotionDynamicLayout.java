package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.view.View;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter;
import com.baidu.spswitch.emotion.bean.EmotionItemModel;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.spswitch.utils.EmotionVipHelper;

public class BDEmotionDynamicLayout extends BDEmotionBaseLayout {
    public BDEmotionDynamicLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public boolean showPreview() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean showDelBtn() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public BDEmotionDynamicAdapter.OnEmotionClickListener getEmotionClickListener() {
        return new BDEmotionDynamicAdapter.OnEmotionClickListener() {
            public void onClick(View view2, int position, Object data) {
                if (data instanceof EmotionItemModel) {
                    final EmotionItemModel itemModel = (EmotionItemModel) data;
                    if (BDEmotionDynamicLayout.this.mTypeModel != null) {
                        EmotionVipHelper.doCheckVip(BDEmotionDynamicLayout.this.getContext(), BDEmotionDynamicLayout.this.mTypeModel.getAuth(), new EmotionVipHelper.OnVipCheckListener() {
                            public void onResult(boolean hasAuthority) {
                                itemModel.setWidth(BDEmotionDynamicLayout.this.getEmotionWidth());
                                itemModel.setHeight(BDEmotionDynamicLayout.this.getEmotionHeight());
                                if (!hasAuthority || GlobalOnItemClickListenerManager.getInstance().getDynamicEmotionClickListener() == null) {
                                    EmotionVipHelper.doBuyVip(BDEmotionDynamicLayout.this.getContext(), BDEmotionDynamicLayout.this.mTypeModel.getAuth(), BDEmotionDynamicLayout.this.mTypeModel.getSchema(), new EmotionVipHelper.OnBuyVipListener() {
                                        public void onResult(boolean status) {
                                            if (status && GlobalOnItemClickListenerManager.getInstance().getDynamicEmotionClickListener() != null) {
                                                GlobalOnItemClickListenerManager.getInstance().getDynamicEmotionClickListener().onEmotionClick(itemModel);
                                            }
                                        }
                                    });
                                } else {
                                    GlobalOnItemClickListenerManager.getInstance().getDynamicEmotionClickListener().onEmotionClick(itemModel);
                                }
                            }
                        });
                        if (BDEmotionDynamicLayout.this.mPanelConfig != null) {
                            EmotionUbcHelper.doEmotionDynamicUBC(BDEmotionDynamicLayout.this.mPanelConfig.from, EmotionUbcHelper.TYPE_MEME_CLK, BDEmotionDynamicLayout.this.mPanelConfig.page, BDEmotionDynamicLayout.this.mPanelConfig.source, "", BDEmotionDynamicLayout.this.mTypeModel.getId() + "-" + itemModel.getId());
                        }
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public BDEmotionDynamicAdapter.OnEmotionDataChangeListener getEmotionDataChangeListener() {
        return null;
    }

    /* access modifiers changed from: private */
    public String getEmotionHeight() {
        return this.mTypeModel != null ? this.mTypeModel.getHeight() : "";
    }

    /* access modifiers changed from: private */
    public String getEmotionWidth() {
        return this.mTypeModel != null ? this.mTypeModel.getWidth() : "";
    }
}
