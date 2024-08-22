package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    public AbstractWindowedCursor zzfn;

    @KeepForSdk
    public CursorWrapper(Cursor cursor) {
        super(cursor);
        for (int i2 = 0; i2 < 10 && (cursor instanceof android.database.CursorWrapper); i2++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            String valueOf = String.valueOf(cursor.getClass().getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown type: ".concat(valueOf) : new String("Unknown type: "));
        } else {
            this.zzfn = (AbstractWindowedCursor) cursor;
        }
    }

    @KeepForSdk
    public void fillWindow(int i2, CursorWindow cursorWindow) {
        this.zzfn.fillWindow(i2, cursorWindow);
    }

    @KeepForSdk
    public CursorWindow getWindow() {
        return this.zzfn.getWindow();
    }

    public /* synthetic */ Cursor getWrappedCursor() {
        return this.zzfn;
    }

    public boolean onMove(int i2, int i3) {
        return this.zzfn.onMove(i2, i3);
    }

    @KeepForSdk
    public void setWindow(CursorWindow cursorWindow) {
        this.zzfn.setWindow(cursorWindow);
    }
}
