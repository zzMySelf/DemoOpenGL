package com.baidu.payment.impl.ext.setting.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.payment.impl.ext.setting.model.PaymentSettingItemModel;
import com.baidu.searchbox.widget.newpreference.SettingFactory;
import com.baidu.searchbox.widget.newpreference.SettingOperateHandle;
import com.baidu.searchbox.widget.newpreference.items.SettingBasePreference;
import com.baidu.searchbox.widget.newpreference.items.SettingNormalPreference;
import com.baidu.searchbox.widget.newpreference.model.SettingGroupModel;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import java.util.ArrayList;
import java.util.Iterator;

public class PaymentSettingAdapter extends RecyclerView.Adapter<PreferenceViewHolder> {
    private Context mContext;
    private SettingOperateHandle mHandle = null;
    private ArrayList<PaymentSettingItemModel> mList = new ArrayList<>();

    public PaymentSettingAdapter(Context context) {
        this.mContext = context;
    }

    private boolean isNeedBottomDecoration(int position) {
        if (position < 0 || position >= this.mList.size() || isCard(position)) {
            if (!isCard(position)) {
                return false;
            }
            if (position == this.mList.size() - 1) {
                return true;
            }
            return false;
        } else if ((position + 1 < this.mList.size() && this.mList.get(position + 1).getType() == SettingItemModel.Type.LEFT_TITLE) || this.mList.get(position).getType() == SettingItemModel.Type.LEFT_TITLE) {
            return false;
        } else {
            if (this.mList.get(position).getMPositionType() == SettingItemModel.PositionType.LAST || this.mList.get(position).getMPositionType() == SettingItemModel.PositionType.SINGLE) {
                return true;
            }
            return false;
        }
    }

    private boolean isNeedTopDecoration(int position) {
        if (position < 0 || position >= this.mList.size() || !isCard(position)) {
            return false;
        }
        if (this.mList.get(position).getMPositionType() == SettingItemModel.PositionType.FIRST || this.mList.get(position).getMPositionType() == SettingItemModel.PositionType.SINGLE) {
            return true;
        }
        return false;
    }

    private boolean isNeedLeftRightMargin(int position) {
        return isCard(position);
    }

    private boolean isCard(int position) {
        if (position < 0 || position >= this.mList.size()) {
            return false;
        }
        return this.mList.get(position).getMIsCard();
    }

    /* access modifiers changed from: package-private */
    public void setOperateHandle(SettingOperateHandle handle) {
        this.mHandle = handle;
    }

    public void setList(ArrayList<SettingGroupModel> list) {
        this.mList.clear();
        Iterator<SettingGroupModel> it = list.iterator();
        while (it.hasNext()) {
            this.mList.addAll(judgeItems(it.next()));
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<PaymentSettingItemModel> judgeItems(SettingGroupModel group) {
        boolean isCard = group.isCard();
        boolean isFontSizeScale = group.isFontSizeScale();
        ArrayList<SettingItemModel> itemList = group.getItemList();
        ArrayList<PaymentSettingItemModel> list = new ArrayList<>();
        Iterator<SettingItemModel> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            SettingItemModel item = iterator.next();
            if (!item.isShow()) {
                iterator.remove();
            } else {
                item.setMIsCard(isCard);
                item.setFontSizeScale(isFontSizeScale);
            }
        }
        if (itemList.size() == 1) {
            PaymentSettingItemModel settingItemModel = (PaymentSettingItemModel) itemList.get(0);
            settingItemModel.setMPositionType(SettingItemModel.PositionType.SINGLE);
            list.add(settingItemModel);
        } else if (itemList.size() >= 2) {
            for (int i2 = 0; i2 < itemList.size(); i2++) {
                PaymentSettingItemModel settingItemModel2 = (PaymentSettingItemModel) itemList.get(i2);
                if (i2 == 0) {
                    itemList.get(i2).setMPositionType(SettingItemModel.PositionType.FIRST);
                } else if (i2 == itemList.size() - 1) {
                    itemList.get(i2).setMPositionType(SettingItemModel.PositionType.LAST);
                } else {
                    itemList.get(i2).setMPositionType(SettingItemModel.PositionType.MIDDLE);
                }
                list.add(settingItemModel2);
            }
        }
        return list;
    }

    public PreferenceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PreferenceViewHolder(SettingFactory.INSTANCE.getPreferenceItem(viewType, this.mContext, this.mHandle));
    }

    public void onBindViewHolder(PreferenceViewHolder holder, int position) {
        PaymentSettingItemModel paymentSettingItemModel = this.mList.get(position);
        holder.setData(this.mList.get(position));
        if (holder.mPreference instanceof SettingNormalPreference) {
            SettingNormalPreference mPreference = (SettingNormalPreference) holder.mPreference;
            if (paymentSettingItemModel.isShowRightDrawable()) {
                mPreference.showRightMoreIndicator();
            } else {
                mPreference.hideRightMoreIndicator();
            }
        }
    }

    public int getItemViewType(int position) {
        return this.mList.get(position).getType().getType();
    }

    public int getItemCount() {
        return this.mList.size();
    }

    public static class PreferenceViewHolder extends RecyclerView.ViewHolder {
        SettingBasePreference mPreference;

        public PreferenceViewHolder(SettingBasePreference settingBasePreference) {
            super(settingBasePreference);
            this.mPreference = settingBasePreference;
        }

        public void setData(SettingItemModel settingItemModel) {
            SettingBasePreference settingBasePreference = this.mPreference;
            if (settingBasePreference != null) {
                settingBasePreference.setData(settingItemModel);
            }
        }
    }
}
