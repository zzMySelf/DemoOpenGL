package com.baidu.searchbox.download.center.ui.fusion.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ui.fusion.listener.ModuleActionListener;
import com.baidu.searchbox.download.center.ui.fusion.model.TabTemplateModel;
import com.baidu.searchbox.download.center.ui.fusion.view.ViewTypeConstants;
import com.baidu.searchbox.exclusion.util.DeviceUtil;

public abstract class ContentBaseHolder extends BaseHolder<TabTemplateModel.BodyTemplateInstanceModel> {
    public static final int CONTENT_DIVIDER_WIDTH = 21;
    protected Context context;
    protected int position;
    private int tempCategory;

    public abstract int getContentHeight(int i2);

    public ContentBaseHolder(Context context2, View itemView, ModuleActionListener moduleActionListener) {
        super(itemView, moduleActionListener);
        this.context = context2;
    }

    public void setPosition(int position2) {
        this.position = position2;
    }

    public int getTempCategory() {
        return this.tempCategory;
    }

    public void adjustLayoutParam(int tempCategory2) {
        this.tempCategory = tempCategory2;
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        int width = getContentWidth(getTemplateColumn(tempCategory2));
        int height = getContentHeight(width);
        if ((width > 0 && height > 0) || width == -2 || height == -2) {
            layoutParams.width = width;
            layoutParams.height = height;
            this.itemView.setLayoutParams(layoutParams);
        }
    }

    public int getContentWidth(int column) {
        if (column <= 0) {
            return 0;
        }
        return ((DeviceUtil.getScreenWidth(this.context) - (this.context.getResources().getDimensionPixelOffset(R.dimen.content_margin_left_right) * 2)) - ((column - 1) * 21)) / column;
    }

    public int getTemplateColumn(int tempCategory2) {
        return ViewTypeConstants.getViewTypeColumn(tempCategory2);
    }
}
