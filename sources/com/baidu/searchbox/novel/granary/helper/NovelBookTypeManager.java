package com.baidu.searchbox.novel.granary.helper;

import android.text.TextUtils;
import com.baidu.searchbox.novel.granary.data.source.local.business.NovelSpBookType;

public class NovelBookTypeManager {
    public static String getBookTypeByGidFromSp(String gid) {
        if (TextUtils.isEmpty(gid)) {
            return null;
        }
        return NovelSpBookType.getSp().getString(NovelSpBookType.Key.KEY_BOOK_TYPE + gid);
    }
}
