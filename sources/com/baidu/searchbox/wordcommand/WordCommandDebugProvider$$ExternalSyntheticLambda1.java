package com.baidu.searchbox.wordcommand;

import android.view.View;
import android.widget.Toast;
import com.baidu.searchbox.wordscommand.WordCommandManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WordCommandDebugProvider$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final void onClick(View view2) {
        Toast.makeText(view2.getContext(), "当前口令正则表达式是：" + WordCommandManager.getInstance().getWordCommandRegex(), 1).show();
    }
}
