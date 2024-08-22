package com.baidu.searchbox.hissug.inputbox.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.searchbox.hissug.ubc.UbcUserAction;
import com.baidu.searchbox.hissug.ubc.UbcUserActionKt;

public class FloatSearchBoxTextWatcher implements TextWatcher {
    private String beforeS = "";
    private EditText mSearchTextInput;
    private int startSelectionCount = -1;

    public FloatSearchBoxTextWatcher(EditText editText) {
        this.mSearchTextInput = editText;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (s != null && this.mSearchTextInput != null) {
            this.beforeS = s.toString();
            this.startSelectionCount = this.mSearchTextInput.getSelectionEnd() - this.mSearchTextInput.getSelectionStart();
            SugLinkageEditViewHelperKt.beforeTextChange(count, after);
        }
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        if (s == null || this.beforeS == null || this.mSearchTextInput == null) {
            this.beforeS = "";
            this.startSelectionCount = -1;
            return;
        }
        if ((s.length() == 0 && this.beforeS.length() == 1) || (s.length() == 0 && this.startSelectionCount == this.beforeS.length() && this.startSelectionCount > 0)) {
            UbcUserAction.INSTANCE.recordAction(UbcUserActionKt.CLEAR_INPUTBOX);
        }
        if (s.length() > 0 && this.beforeS.length() == 0) {
            UbcUserAction.INSTANCE.recordAction(UbcUserActionKt.INPUT_QUERY);
        }
        this.beforeS = "";
        this.startSelectionCount = -1;
    }
}
