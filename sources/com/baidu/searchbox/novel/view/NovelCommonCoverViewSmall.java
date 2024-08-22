package com.baidu.searchbox.novel.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.utils.NovelUIUtil;

public class NovelCommonCoverViewSmall extends NovelCommonCoverView {
    private static final int HEIGHT = 141;
    private static final int WIDTH = 105;

    public NovelCommonCoverViewSmall(Context context) {
        super(context);
    }

    public NovelCommonCoverViewSmall(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NovelCommonCoverViewSmall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getCoverWidth() {
        return NovelUIUtil.getDimension(getContext(), R.dimen.novel_dimens_35dp, 105);
    }

    public int getCoverHeight() {
        return NovelUIUtil.getDimension(getContext(), R.dimen.novel_dimens_47dp, 141);
    }
}
