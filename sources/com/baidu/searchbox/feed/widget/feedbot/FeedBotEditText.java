package com.baidu.searchbox.feed.widget.feedbot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;

public class FeedBotEditText extends AppCompatEditText {
    private BotCommitBackListener listener;

    public interface BotCommitBackListener {
        void back(AppCompatEditText appCompatEditText);
    }

    public FeedBotEditText(Context context) {
        super(context);
    }

    public FeedBotEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FeedBotEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setBackListener(BotCommitBackListener listener2) {
        this.listener = listener2;
    }

    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        BotCommitBackListener botCommitBackListener;
        if (event.getAction() != 0 || keyCode != 4 || (botCommitBackListener = this.listener) == null) {
            return super.onKeyPreIme(keyCode, event);
        }
        botCommitBackListener.back(this);
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection connection = super.onCreateInputConnection(outAttrs);
        int imeActions = outAttrs.imeOptions & 255;
        if ((imeActions & 4) != 0) {
            outAttrs.imeOptions ^= imeActions;
            outAttrs.imeOptions |= 4;
        }
        if ((outAttrs.imeOptions & 1073741824) != 0) {
            outAttrs.imeOptions &= -1073741825;
        }
        return connection;
    }
}
