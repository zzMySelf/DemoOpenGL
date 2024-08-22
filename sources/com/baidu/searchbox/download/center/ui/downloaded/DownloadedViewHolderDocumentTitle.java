package com.baidu.searchbox.download.center.ui.downloaded;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.download.DownloadStatisticsUBC;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ui.DownloadedDocActivity;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;

class DownloadedViewHolderDocumentTitle extends DownloadedViewHolderBase implements View.OnClickListener {
    DownloadedViewHolderDocumentTitle(View itemView) {
        super(itemView);
    }

    public void adjustNightMode() {
        View touchView = this.itemView.findViewById(R.id.downloaded_document_touch_view);
        touchView.setOnClickListener(this);
        Resources resources = this.itemView.getContext().getResources();
        ((ImageView) this.itemView.findViewById(R.id.downloaded_document_all_image)).setImageDrawable(resources.getDrawable(R.drawable.download_dir_right_arrow));
        ((TextView) this.itemView.findViewById(R.id.downloaded_document_recent_title)).setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC1));
        touchView.setBackground(resources.getDrawable(R.drawable.downloaded_item_bg_selector));
    }

    public void onClick(View view2) {
        Intent intent = new Intent(view2.getContext(), DownloadedDocActivity.class);
        intent.putExtra(DownloadedDocActivity.EXTRA_ENTER_FROM_RECENT_KEY, true);
        ActivityUtils.startActivitySafely(view2.getContext(), intent);
        BaseActivity.setNextPendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_right, com.baidu.android.common.ui.style.R.anim.slide_out_to_left, com.baidu.android.common.ui.style.R.anim.slide_in_from_left, com.baidu.android.common.ui.style.R.anim.slide_out_to_right);
        doStatisticsClick();
    }

    private void doStatisticsClick() {
        DownloadStatisticsUBC.doDownloadCenterChildPageUBC(DownloadStatisticConstants.UBC_VALUE_FILE_MORE, "page_click");
    }
}
