package com.baidu.searchbox.fileviewer.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.fileviewer.R;
import com.baidu.searchbox.fileviewer.data.BdFileItemData;
import com.baidu.searchbox.fileviewer.manager.BdFileViewerListItemManager;
import com.baidu.searchbox.fileviewer.manager.BdFileViewerManager;

public class BdFileViewerListItemView extends FrameLayout implements View.OnClickListener, View.OnLongClickListener {
    private View mBottomLine;
    private Context mContext;
    private ImageView mIconView;
    private BdFileItemData mItemData;
    private BdFileViewerListItemManager mItemManager;
    private TextView mTextView;

    public BdFileViewerListItemView(Context context, BdFileViewerManager fileViewerManager, BdFileItemData itemData) {
        super(context);
        this.mContext = context;
        this.mItemManager = new BdFileViewerListItemManager(context, fileViewerManager, itemData);
        this.mItemData = itemData;
        setMinimumHeight(getResources().getDimensionPixelOffset(R.dimen.file_viewer_item_min_height));
        initResources();
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    private void initResources() {
        RelativeLayout layout = (RelativeLayout) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.file_viewer_item, (ViewGroup) null, false);
        addView(layout, new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.file_viewer_item_min_height)));
        this.mIconView = (ImageView) layout.findViewById(R.id.file_viewer_item_icon);
        this.mTextView = (TextView) layout.findViewById(R.id.file_viewer_item_text);
        BdFileItemData bdFileItemData = this.mItemData;
        if (bdFileItemData != null && !TextUtils.isEmpty(bdFileItemData.mName)) {
            this.mTextView.setText(this.mItemData.mName);
        }
        this.mBottomLine = layout.findViewById(R.id.file_viewer_item_bottom_line);
        onThemeChange();
    }

    private void onThemeChange() {
        if (this.mIconView != null) {
            BdFileItemData bdFileItemData = this.mItemData;
            if (bdFileItemData == null || bdFileItemData.mType != 1) {
                this.mIconView.setBackground(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.file_viewer_file_icon, (Resources.Theme) null));
            } else {
                this.mIconView.setBackground(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.file_viewer_folder_icon, (Resources.Theme) null));
            }
        }
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.searhbox_file_viewer_item_text_color));
        }
        View view2 = this.mBottomLine;
        if (view2 != null) {
            view2.setBackgroundColor(this.mContext.getResources().getColor(R.color.searhbox_file_viewer_line_color));
        }
    }

    public void onClick(View v) {
        BdFileViewerListItemManager bdFileViewerListItemManager = this.mItemManager;
        if (bdFileViewerListItemManager != null) {
            bdFileViewerListItemManager.onItemClick(this.mItemData);
        }
    }

    public boolean onLongClick(View v) {
        BdFileViewerListItemManager bdFileViewerListItemManager = this.mItemManager;
        if (bdFileViewerListItemManager == null) {
            return true;
        }
        bdFileViewerListItemManager.onItemLongClick();
        return true;
    }
}
