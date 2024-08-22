package com.baidu.talos.devtools.bundle.deleter;

import com.baidu.talos.devtools.treeview.model.SelectedItem;
import java.util.List;
import java.util.Map;

public interface IBundleDeleter {
    List<String> deleteBundle(Map<Integer, SelectedItem> map);
}
