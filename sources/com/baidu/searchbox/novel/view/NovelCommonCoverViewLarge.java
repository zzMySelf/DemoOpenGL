package com.baidu.searchbox.novel.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.utils.NovelUIUtil;

public class NovelCommonCoverViewLarge extends NovelCommonCoverView {
    private static final int HEIGHT = 279;
    private static final int WIDTH = 210;

    public NovelCommonCoverViewLarge(Context context) {
        super(context);
    }

    public NovelCommonCoverViewLarge(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NovelCommonCoverViewLarge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getCoverWidth() {
        return NovelUIUtil.getDimension(getContext(), R.dimen.novel_dimens_70dp, 210);
    }

    public int getCoverHeight() {
        return NovelUIUtil.getDimension(getContext(), R.dimen.novel_dimens_93dp, HEIGHT);
    }
}
