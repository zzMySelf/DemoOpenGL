package com.baidu.searchbox.feed.list.db.base;

import java.util.ArrayList;
import java.util.List;

public interface IFeedDBOperate<DataT> {
    void clear(String str);

    void delete(DataT datat, String str);

    void delete(List<DataT> list, String str);

    void insert(DataT datat, String str);

    void insert(List<DataT> list, String str);

    boolean isExist(DataT datat, String str);

    ArrayList<DataT> select(int i2, int i3, String str);

    void update(DataT datat, String str);

    void update(List<DataT> list, String str);
}
