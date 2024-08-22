package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import io.flutter.Log;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.editing.ListenableEditingState;

public class InputConnectionAdaptor extends BaseInputConnection implements ListenableEditingState.EditingStateWatcher {
    public static final String TAG = "InputConnectionAdaptor";
    public int batchEditNestDepth;
    public FlutterTextUtils flutterTextUtils;
    public final KeyboardManager keyboardManager;
    public final int mClient;
    public CursorAnchorInfo.Builder mCursorAnchorInfoBuilder;
    public final ListenableEditingState mEditable;
    public final EditorInfo mEditorInfo;
    public ExtractedTextRequest mExtractRequest;
    public ExtractedText mExtractedText;
    public final View mFlutterView;
    public InputMethodManager mImm;
    public final Layout mLayout;
    public boolean mMonitorCursorUpdate;
    public final TextInputChannel textInputChannel;

    public InputConnectionAdaptor(View view, int i2, TextInputChannel textInputChannel2, KeyboardManager keyboardManager2, ListenableEditingState listenableEditingState, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.mMonitorCursorUpdate = false;
        this.mExtractedText = new ExtractedText();
        this.batchEditNestDepth = 0;
        this.mFlutterView = view;
        this.mClient = i2;
        this.textInputChannel = textInputChannel2;
        this.mEditable = listenableEditingState;
        listenableEditingState.addEditingStateListener(this);
        this.mEditorInfo = editorInfo;
        this.keyboardManager = keyboardManager2;
        this.flutterTextUtils = new FlutterTextUtils(flutterJNI);
        this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    public static int clampIndexToEditable(int i2, Editable editable) {
        int max = Math.max(0, Math.min(editable.length(), i2));
        if (max != i2) {
            Log.d("flutter", "Text selection index was clamped (" + i2 + "->" + max + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
        }
        return max;
    }

    private boolean doPerformContextMenuAction(int i2) {
        if (i2 == 16908319) {
            setSelection(0, this.mEditable.length());
            return true;
        } else if (i2 == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.mEditable);
            int selectionEnd = Selection.getSelectionEnd(this.mEditable);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.mFlutterView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(min, max)));
                this.mEditable.delete(min, max);
                setSelection(min, min);
            }
            return true;
        } else if (i2 == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.mEditable);
            int selectionEnd2 = Selection.getSelectionEnd(this.mEditable);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.mFlutterView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        } else if (i2 != 16908322) {
            return false;
        } else {
            ClipData primaryClip = ((ClipboardManager) this.mFlutterView.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null) {
                CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.mFlutterView.getContext());
                int max2 = Math.max(0, Selection.getSelectionStart(this.mEditable));
                int max3 = Math.max(0, Selection.getSelectionEnd(this.mEditable));
                int min2 = Math.min(max2, max3);
                int max4 = Math.max(max2, max3);
                if (min2 != max4) {
                    this.mEditable.delete(min2, max4);
                }
                this.mEditable.insert(min2, coerceToText);
                int length = min2 + coerceToText.length();
                setSelection(length, length);
            }
            return true;
        }
    }

    private CursorAnchorInfo getCursorAnchorInfo() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        CursorAnchorInfo.Builder builder = this.mCursorAnchorInfoBuilder;
        if (builder == null) {
            this.mCursorAnchorInfoBuilder = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.mCursorAnchorInfoBuilder.setSelectionRange(this.mEditable.getSelectionStart(), this.mEditable.getSelectionEnd());
        int composingStart = this.mEditable.getComposingStart();
        int composingEnd = this.mEditable.getComposingEnd();
        if (composingStart < 0 || composingEnd <= composingStart) {
            this.mCursorAnchorInfoBuilder.setComposingText(-1, "");
        } else {
            this.mCursorAnchorInfoBuilder.setComposingText(composingStart, this.mEditable.toString().subSequence(composingStart, composingEnd));
        }
        return this.mCursorAnchorInfoBuilder.build();
    }

    private ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest) {
        CharSequence charSequence;
        ExtractedText extractedText = this.mExtractedText;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.selectionStart = this.mEditable.getSelectionStart();
        this.mExtractedText.selectionEnd = this.mEditable.getSelectionEnd();
        ExtractedText extractedText2 = this.mExtractedText;
        if (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) {
            charSequence = this.mEditable.toString();
        } else {
            charSequence = this.mEditable;
        }
        extractedText2.text = charSequence;
        return this.mExtractedText;
    }

    private boolean handleHorizontalMovement(boolean z, boolean z2) {
        int i2;
        int selectionStart = Selection.getSelectionStart(this.mEditable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (z) {
            i2 = Math.max(this.flutterTextUtils.getOffsetBefore(this.mEditable, selectionEnd), 0);
        } else {
            i2 = Math.min(this.flutterTextUtils.getOffsetAfter(this.mEditable, selectionEnd), this.mEditable.length());
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        if (z3) {
            setSelection(i2, i2);
        } else {
            setSelection(selectionStart, i2);
        }
        return true;
    }

    private boolean handleVerticalMovement(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.mEditable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        beginBatchEdit();
        if (z3) {
            if (z) {
                Selection.moveUp(this.mEditable, this.mLayout);
            } else {
                Selection.moveDown(this.mEditable, this.mLayout);
            }
            int selectionStart2 = Selection.getSelectionStart(this.mEditable);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z) {
                Selection.extendUp(this.mEditable, this.mLayout);
            } else {
                Selection.extendDown(this.mEditable, this.mLayout);
            }
            setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
        }
        endBatchEdit();
        return true;
    }

    public boolean beginBatchEdit() {
        this.mEditable.beginBatchEdit();
        this.batchEditNestDepth++;
        return super.beginBatchEdit();
    }

    public boolean clearMetaKeyStates(int i2) {
        return super.clearMetaKeyStates(i2);
    }

    public void closeConnection() {
        super.closeConnection();
        this.mEditable.removeEditingStateListener(this);
        while (this.batchEditNestDepth > 0) {
            endBatchEdit();
            this.batchEditNestDepth--;
        }
    }

    public boolean commitText(CharSequence charSequence, int i2) {
        return super.commitText(charSequence, i2);
    }

    public boolean deleteSurroundingText(int i2, int i3) {
        if (this.mEditable.getSelectionStart() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i2, i3);
    }

    public boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        return super.deleteSurroundingTextInCodePoints(i2, i3);
    }

    public void didChangeEditingState(boolean z, boolean z2, boolean z3) {
        this.mImm.updateSelection(this.mFlutterView, this.mEditable.getSelectionStart(), this.mEditable.getSelectionEnd(), this.mEditable.getComposingStart(), this.mEditable.getComposingEnd());
        if (Build.VERSION.SDK_INT >= 21) {
            ExtractedTextRequest extractedTextRequest = this.mExtractRequest;
            if (extractedTextRequest != null) {
                this.mImm.updateExtractedText(this.mFlutterView, extractedTextRequest.token, getExtractedText(extractedTextRequest));
            }
            if (this.mMonitorCursorUpdate) {
                this.mImm.updateCursorAnchorInfo(this.mFlutterView, getCursorAnchorInfo());
            }
        }
    }

    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.batchEditNestDepth--;
        this.mEditable.endBatchEdit();
        return endBatchEdit;
    }

    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    public Editable getEditable() {
        return this.mEditable;
    }

    public boolean handleKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 21) {
                return handleHorizontalMovement(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 22) {
                return handleHorizontalMovement(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return handleVerticalMovement(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return handleVerticalMovement(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                EditorInfo editorInfo = this.mEditorInfo;
                if ((131072 & editorInfo.inputType) == 0) {
                    performEditorAction(editorInfo.imeOptions & 255);
                    return true;
                }
            }
            int selectionStart = Selection.getSelectionStart(this.mEditable);
            int selectionEnd = Selection.getSelectionEnd(this.mEditable);
            int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart < 0 || selectionEnd < 0 || unicodeChar == 0) {
                return false;
            }
            int min = Math.min(selectionStart, selectionEnd);
            int max = Math.max(selectionStart, selectionEnd);
            beginBatchEdit();
            if (min != max) {
                this.mEditable.delete(min, max);
            }
            this.mEditable.insert(min, String.valueOf((char) unicodeChar));
            int i2 = min + 1;
            setSelection(i2, i2);
            endBatchEdit();
            return true;
        } else if (keyEvent.getAction() != 1 || (keyEvent.getKeyCode() != 59 && keyEvent.getKeyCode() != 60)) {
            return false;
        } else {
            int selectionEnd2 = Selection.getSelectionEnd(this.mEditable);
            setSelection(selectionEnd2, selectionEnd2);
            return true;
        }
    }

    public boolean performContextMenuAction(int i2) {
        beginBatchEdit();
        boolean doPerformContextMenuAction = doPerformContextMenuAction(i2);
        endBatchEdit();
        return doPerformContextMenuAction;
    }

    public boolean performEditorAction(int i2) {
        if (i2 == 0) {
            this.textInputChannel.unspecifiedAction(this.mClient);
        } else if (i2 == 1) {
            this.textInputChannel.newline(this.mClient);
        } else if (i2 == 2) {
            this.textInputChannel.go(this.mClient);
        } else if (i2 == 3) {
            this.textInputChannel.search(this.mClient);
        } else if (i2 == 4) {
            this.textInputChannel.send(this.mClient);
        } else if (i2 == 5) {
            this.textInputChannel.next(this.mClient);
        } else if (i2 != 7) {
            this.textInputChannel.done(this.mClient);
        } else {
            this.textInputChannel.previous(this.mClient);
        }
        return true;
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.textInputChannel.performPrivateCommand(this.mClient, str, bundle);
        return true;
    }

    public boolean requestCursorUpdates(int i2) {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if ((i2 & 1) != 0) {
            this.mImm.updateCursorAnchorInfo(this.mFlutterView, getCursorAnchorInfo());
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if (z != this.mMonitorCursorUpdate) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z ? "on" : "off");
            Log.d(TAG, sb.toString());
        }
        this.mMonitorCursorUpdate = z;
        return true;
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.keyboardManager.handleEvent(keyEvent);
    }

    public boolean setComposingRegion(int i2, int i3) {
        return super.setComposingRegion(i2, i3);
    }

    public boolean setComposingText(CharSequence charSequence, int i2) {
        boolean z;
        beginBatchEdit();
        if (charSequence.length() == 0) {
            z = super.commitText(charSequence, i2);
        } else {
            z = super.setComposingText(charSequence, i2);
        }
        endBatchEdit();
        return z;
    }

    public boolean setSelection(int i2, int i3) {
        beginBatchEdit();
        boolean selection = super.setSelection(i2, i3);
        endBatchEdit();
        return selection;
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i2) {
        boolean z = true;
        boolean z2 = (i2 & 1) != 0;
        if (this.mExtractRequest != null) {
            z = false;
        }
        if (z2 == z) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z2 ? "on" : "off");
            Log.d(TAG, sb.toString());
        }
        this.mExtractRequest = z2 ? extractedTextRequest : null;
        return getExtractedText(extractedTextRequest);
    }

    public InputConnectionAdaptor(View view, int i2, TextInputChannel textInputChannel2, KeyboardManager keyboardManager2, ListenableEditingState listenableEditingState, EditorInfo editorInfo) {
        this(view, i2, textInputChannel2, keyboardManager2, listenableEditingState, editorInfo, new FlutterJNI());
    }
}
