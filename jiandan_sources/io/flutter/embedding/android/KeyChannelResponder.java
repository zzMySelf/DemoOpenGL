package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import th.qw.qw.qw.qw;

public class KeyChannelResponder implements KeyboardManager.Responder {
    public static final String TAG = "KeyChannelResponder";
    public int combiningCharacter;
    @NonNull
    public final KeyEventChannel keyEventChannel;

    public KeyChannelResponder(@NonNull KeyEventChannel keyEventChannel2) {
        this.keyEventChannel = keyEventChannel2;
    }

    public Character applyCombiningCharacterToBaseCharacter(int i2) {
        char c = (char) i2;
        if ((Integer.MIN_VALUE & i2) != 0) {
            int i3 = i2 & Integer.MAX_VALUE;
            int i4 = this.combiningCharacter;
            if (i4 != 0) {
                this.combiningCharacter = KeyCharacterMap.getDeadChar(i4, i3);
            } else {
                this.combiningCharacter = i3;
            }
        } else {
            int i5 = this.combiningCharacter;
            if (i5 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i5, i2);
                if (deadChar > 0) {
                    c = (char) deadChar;
                }
                this.combiningCharacter = 0;
            }
        }
        return Character.valueOf(c);
    }

    public void handleEvent(@NonNull KeyEvent keyEvent, @NonNull KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        int action = keyEvent.getAction();
        boolean z = true;
        if (action == 0 || action == 1) {
            KeyEventChannel.FlutterKeyEvent flutterKeyEvent = new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar()));
            if (action == 0) {
                z = false;
            }
            this.keyEventChannel.sendFlutterKeyEvent(flutterKeyEvent, z, new qw(onKeyEventHandledCallback));
            return;
        }
        onKeyEventHandledCallback.onKeyEventHandled(Boolean.FALSE);
    }
}
