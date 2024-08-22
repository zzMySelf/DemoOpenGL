package com.tera.scan.component.base.ui.localfile.baseui;

import android.content.Context;
import android.database.Cursor;
import androidx.cursoradapter.widget.CursorAdapter;
import com.tera.scan.localfile.model.FileItem;
import fe.mmm.qw.th.qw.rg.ad.qw.qw;
import java.util.ArrayList;

public abstract class LocalFileBaseCursorAdapter extends CursorAdapter implements ISelectionInterface {
    public static final String TAG = "LocalFileBaseCursorAdapter";
    public qw mSelectionImpl = new qw(this);

    public LocalFileBaseCursorAdapter(Context context) {
        super(context, (Cursor) null, false);
    }

    public void addSelectedPosition(Context context, int i2) {
        this.mSelectionImpl.qw(context, i2);
    }

    public int getSelectableCount() {
        return getCount();
    }

    public abstract /* synthetic */ FileItem getSelectedFile(Context context, int i2);

    public ArrayList<FileItem> getSelectedFiles() {
        return this.mSelectionImpl.ad();
    }

    public int getSelectedFilesCount() {
        return this.mSelectionImpl.de();
    }

    public boolean isSelected(int i2) {
        return this.mSelectionImpl.fe(i2);
    }

    public void removeAllSelectedPositions() {
        this.mSelectionImpl.rg();
    }

    public void removeSelectedPosition(int i2) {
        this.mSelectionImpl.th(i2);
    }
}
