package com.baidu.searchbox.follow.recommend;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.ext.widget.dialog.BottomCloseBtnDialog;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.follow.BatchFollowRequest;
import com.baidu.searchbox.follow.FollowConstant;
import com.baidu.searchbox.follow.FollowUtils;
import com.baidu.searchbox.follow.R;
import com.baidu.searchbox.follow.net.Callback;
import com.baidu.searchbox.follow.recommend.data.FollowRecommendItem;
import com.baidu.searchbox.follow.runtime.FollowRuntime;
import com.baidu.searchbox.ui.TouchStateListener;
import java.util.ArrayList;
import java.util.List;

public class FollowRecommendDialog {
    private static final int DISPLAY_RECOMMEND_ITEM_NUM = 6;
    private static final int UPPER_VIEW_WIDTH = 287;
    private BaseAdapter mAdapter;
    /* access modifiers changed from: private */
    public IBatchFollowListener mBatchFollowListener;
    private View mContentView;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public BottomCloseBtnDialog mDialog;
    private TextView mFollowBtn;
    private GridView mGridView;
    /* access modifiers changed from: private */
    public String mPage;
    /* access modifiers changed from: private */
    public List<FollowRecommendItem> mRecommendItems;
    /* access modifiers changed from: private */
    public String mRequestSource;
    /* access modifiers changed from: private */
    public List<String> mSelectDataIdList = new ArrayList();
    private int mTopDrawableId;

    public interface IBatchFollowListener {
        void onFailure();

        void onSuccess();
    }

    public FollowRecommendDialog(Context context, List<FollowRecommendItem> recommendItems, int topDrawableId, String requestSource, String page, IBatchFollowListener batchFollowListener) {
        if (recommendItems != null && recommendItems.size() != 0) {
            this.mContext = context;
            this.mRecommendItems = recommendItems;
            this.mTopDrawableId = topDrawableId;
            this.mRequestSource = requestSource;
            this.mPage = page;
            this.mBatchFollowListener = batchFollowListener;
        }
    }

    public View createUpperView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.follow_recommend_layout, (ViewGroup) null, false);
        this.mContentView = inflate;
        ((ImageView) inflate.findViewById(R.id.top_image)).setImageResource(this.mTopDrawableId);
        this.mGridView = (GridView) this.mContentView.findViewById(R.id.recommend_gridview);
        this.mFollowBtn = (TextView) this.mContentView.findViewById(R.id.follow_btn);
        FollowRecommendAdapter followRecommendAdapter = new FollowRecommendAdapter();
        this.mAdapter = followRecommendAdapter;
        this.mGridView.setAdapter(followRecommendAdapter);
        initTheme();
        checkHasSelectedItem();
        this.mFollowBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FollowUtils.followRecommendEvent(FollowConstant.UBC_TYPE_CLICK_ADD, FollowRecommendDialog.this.mPage);
                FollowRecommendDialog.this.mDialog.dismiss();
                BottomCloseBtnDialog unused = FollowRecommendDialog.this.mDialog = null;
                new BatchFollowRequest().batchFollow(FollowRecommendDialog.this.mContext, FollowRecommendDialog.this.mSelectDataIdList, FollowRecommendDialog.this.mRequestSource, new Callback<BaseJsonData>() {
                    public void onSuccess(BaseJsonData response) {
                        if (FollowRecommendDialog.this.mBatchFollowListener != null) {
                            FollowRecommendDialog.this.mBatchFollowListener.onSuccess();
                            IBatchFollowListener unused = FollowRecommendDialog.this.mBatchFollowListener = null;
                        }
                    }

                    public void onFailure() {
                        if (FollowRecommendDialog.this.mBatchFollowListener != null) {
                            FollowRecommendDialog.this.mBatchFollowListener.onFailure();
                            IBatchFollowListener unused = FollowRecommendDialog.this.mBatchFollowListener = null;
                        }
                    }

                    public void onNetworkException() {
                        if (FollowRecommendDialog.this.mBatchFollowListener != null) {
                            FollowRecommendDialog.this.mBatchFollowListener.onFailure();
                            IBatchFollowListener unused = FollowRecommendDialog.this.mBatchFollowListener = null;
                        }
                    }
                });
                Context unused2 = FollowRecommendDialog.this.mContext = null;
            }
        });
        this.mFollowBtn.setOnTouchListener(new TouchStateListener());
        return this.mContentView;
    }

    private void initTheme() {
        this.mContentView.setBackground(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.follow_recommend_dialog_bg, (Resources.Theme) null));
        this.mFollowBtn.setBackground(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.batch_follow_btn_bg, (Resources.Theme) null));
        this.mFollowBtn.setTextColor(this.mContext.getResources().getColor(R.color.follow_interest_btn_color));
    }

    /* access modifiers changed from: private */
    public void checkHasSelectedItem() {
        if (this.mSelectDataIdList.size() == 0) {
            this.mFollowBtn.setEnabled(false);
        } else {
            this.mFollowBtn.setEnabled(true);
        }
    }

    class ViewHolder {
        ImageView logo;
        ImageView selectStatusIcon;
        TextView title;

        ViewHolder() {
        }
    }

    class FollowRecommendAdapter extends BaseAdapter {
        FollowRecommendAdapter() {
        }

        public int getCount() {
            if (FollowRecommendDialog.this.mRecommendItems == null) {
                return 0;
            }
            return FollowRecommendDialog.this.mRecommendItems.size();
        }

        public Object getItem(int position) {
            return FollowRecommendDialog.this.mRecommendItems.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh;
            if (convertView == null) {
                convertView = LayoutInflater.from(FollowRecommendDialog.this.mContext).inflate(R.layout.follow_recommend_item_layout, parent, false);
                vh = new ViewHolder();
                vh.logo = (ImageView) convertView.findViewById(R.id.logo);
                vh.selectStatusIcon = (ImageView) convertView.findViewById(R.id.select_status_icon);
                vh.title = (TextView) convertView.findViewById(R.id.title);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }
            final FollowRecommendItem item = (FollowRecommendItem) FollowRecommendDialog.this.mRecommendItems.get(position);
            vh.logo.setImageURI(Uri.parse(item.logoUrl));
            vh.title.setText(item.title);
            if (item.isSelected) {
                vh.selectStatusIcon.setImageResource(R.drawable.status_selected_icon);
                vh.title.setTextColor(FollowRecommendDialog.this.mContext.getResources().getColor(R.color.follow_recommend_title_selected));
            } else {
                vh.selectStatusIcon.setImageResource(R.drawable.status_unselected_icon);
                vh.title.setTextColor(FollowRecommendDialog.this.mContext.getResources().getColor(R.color.follow_recommend_title_unselected));
            }
            convertView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (item.isSelected) {
                        item.isSelected = false;
                        ((ViewHolder) v.getTag()).selectStatusIcon.setImageResource(R.drawable.status_unselected_icon);
                        ((ViewHolder) v.getTag()).title.setTextColor(FollowRecommendDialog.this.mContext.getResources().getColor(R.color.follow_recommend_title_unselected));
                        FollowRecommendDialog.this.mSelectDataIdList.remove(item.id);
                        FollowUtils.followRecommendEvent("click_cancel", FollowRecommendDialog.this.mPage);
                    } else {
                        item.isSelected = true;
                        ((ViewHolder) v.getTag()).selectStatusIcon.setImageResource(R.drawable.status_selected_icon);
                        ((ViewHolder) v.getTag()).title.setTextColor(FollowRecommendDialog.this.mContext.getResources().getColor(R.color.follow_recommend_title_selected));
                        FollowRecommendDialog.this.mSelectDataIdList.add(item.id);
                        FollowUtils.followRecommendEvent(FollowConstant.UBC_TYPE_CLICK_SELECT, FollowRecommendDialog.this.mPage);
                    }
                    FollowRecommendDialog.this.checkHasSelectedItem();
                }
            });
            return convertView;
        }
    }

    public void show() {
        List<FollowRecommendItem> list = this.mRecommendItems;
        if (list != null && list.size() == 6 && this.mContext != null) {
            for (int i2 = 0; i2 < this.mRecommendItems.size(); i2++) {
                this.mRecommendItems.get(i2).isSelected = true;
                this.mSelectDataIdList.add(this.mRecommendItems.get(i2).id);
            }
            this.mDialog = new BottomCloseBtnDialog.Builder(this.mContext).setUpperView(createUpperView(), new ViewGroup.LayoutParams(DeviceUtil.ScreenInfo.dp2px(this.mContext, 287.0f), -2)).setOnCloseListener(new BottomCloseBtnDialog.OnCloseListener() {
                public void onClose() {
                    FollowUtils.followRecommendEvent("click_close", FollowRecommendDialog.this.mPage);
                    FollowUtils.setRecommendDialogLastCloseTime(FollowRuntime.getAppContext(), System.currentTimeMillis());
                }
            }).show();
            FollowUtils.followRecommendEvent("view", this.mPage);
            FollowUtils.saveRecommendList(FollowRuntime.getAppContext(), this.mRecommendItems);
            FollowUtils.setRecommendDialogLastShowTime(FollowRuntime.getAppContext(), System.currentTimeMillis());
        }
    }
}
