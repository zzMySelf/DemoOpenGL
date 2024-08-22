package com.baidu.searchbox.dynamicpublisher.aipanel;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.dynamicpublisher.aipanel.AiPanelView;
import com.baidu.searchbox.publishercomponent.R;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/baidu/searchbox/dynamicpublisher/aipanel/AiPanelView$inputTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPanelView.kt */
public final class AiPanelView$inputTextWatcher$1 implements TextWatcher {
    final /* synthetic */ AiPanelView this$0;

    AiPanelView$inputTextWatcher$1(AiPanelView $receiver) {
        this.this$0 = $receiver;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s != null) {
            AiPanelView aiPanelView = this.this$0;
            CharSequence charSequence = s;
            if (s.length() > 40) {
                EditText access$getAiPromptEditText = aiPanelView.getAiPromptEditText();
                String substring = s.toString().substring(0, 40);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                access$getAiPromptEditText.setText(substring);
                aiPanelView.getAiPromptEditText().setSelection(40);
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.dynamic_publisher_edittext_max_length).show();
            }
        }
    }

    public void afterTextChanged(Editable s) {
        String state;
        CharSequence charSequence = s;
        if (charSequence == null || charSequence.length() == 0) {
            state = AiPanelView.AIState.Companion.getSTATE_INIT();
        } else {
            state = AiPanelView.AIState.Companion.getSTATE_WRITING();
        }
        if (!this.this$0.inputTextEdit) {
            UgcUBCUtils.ugcUbcAiCreate(UgcUBCUtils.UGC_BTN_AI_LAYER, UgcUBCUtils.UGC_BTN_AI_INPUT, this.this$0.templateId, this.this$0.sourceFrom);
            this.this$0.inputTextEdit = true;
        }
        this.this$0.updateAiState(state);
    }
}
