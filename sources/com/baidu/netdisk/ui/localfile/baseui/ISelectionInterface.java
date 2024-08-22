package com.baidu.netdisk.ui.localfile.baseui;

import com.baidu.netdisk.localfile.model.FileItem;
import java.util.ArrayList;

public interface ISelectionInterface {
    void addSelectedPosition(int i2);

    FileItem getSelectedFile(int i2);

    ArrayList<FileItem> getSelectedFiles();

    int getSelectedFilesCount();

    boolean isSelected(int i2);

    void removeAllSelectedPositions();

    void removeSelectedPosition(int i2);
}
