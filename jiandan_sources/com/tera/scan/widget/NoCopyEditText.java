package com.tera.scan.widget;

import android.content.Context;
import android.os.Build;
import android.text.method.BaseMovementMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;

public class NoCopyEditText extends AppCompatEditText {
    public static final String TAG = "NoCopyEditText";
    public boolean copyEnable = false;
    public MenuItemEventObserver eventObserver;
    public int mCurrentIndex = 0;

    public interface MenuItemEventObserver {
        void qw(int i2);
    }

    public class qw implements ActionMode.Callback {
        public qw() {
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    public NoCopyEditText(Context context) {
        super(context);
        disableDoubleClick();
    }

    private void disableDoubleClick() {
        setCustomSelectionActionModeCallback(new qw());
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public boolean onTextContextMenuItem(int i2) {
        switch (i2) {
            case 16908320:
            case 16908321:
            case 16908341:
                if (this.copyEnable) {
                    return super.onTextContextMenuItem(i2);
                }
                MenuItemEventObserver menuItemEventObserver = this.eventObserver;
                if (menuItemEventObserver == null) {
                    return true;
                }
                menuItemEventObserver.qw(i2);
                return true;
            default:
                return super.onTextContextMenuItem(i2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mCurrentIndex = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerItemEventObserver(MenuItemEventObserver menuItemEventObserver) {
        this.eventObserver = menuItemEventObserver;
    }

    public void setCopyEnable(boolean z) {
        this.copyEnable = z;
        if (Build.VERSION.SDK_INT >= 20 || z) {
            setMovementMethod(getDefaultMovementMethod());
        } else {
            setMovementMethod(new BaseMovementMethod());
        }
    }

    public NoCopyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        disableDoubleClick();
    }
}
