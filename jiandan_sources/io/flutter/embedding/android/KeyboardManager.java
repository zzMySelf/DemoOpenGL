package io.flutter.embedding.android;

import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.plugin.editing.TextInputPlugin;
import java.util.HashSet;

public class KeyboardManager {
    public static final String TAG = "KeyboardManager";
    @NonNull
    public final HashSet<KeyEvent> redispatchedEvents = new HashSet<>();
    @NonNull
    public final Responder[] responders;
    @NonNull
    public final TextInputPlugin textInputPlugin;
    public final View view;

    public class PerEventCallbackBuilder {
        public boolean isEventHandled = false;
        @NonNull
        public final KeyEvent keyEvent;
        public int unrepliedCount = KeyboardManager.this.responders.length;

        public class Callback implements Responder.OnKeyEventHandledCallback {
            public boolean isCalled;

            public Callback() {
                this.isCalled = false;
            }

            public void onKeyEventHandled(Boolean bool) {
                if (!this.isCalled) {
                    this.isCalled = true;
                    PerEventCallbackBuilder perEventCallbackBuilder = PerEventCallbackBuilder.this;
                    perEventCallbackBuilder.unrepliedCount--;
                    perEventCallbackBuilder.isEventHandled = bool.booleanValue() | perEventCallbackBuilder.isEventHandled;
                    PerEventCallbackBuilder perEventCallbackBuilder2 = PerEventCallbackBuilder.this;
                    if (perEventCallbackBuilder2.unrepliedCount == 0 && !perEventCallbackBuilder2.isEventHandled) {
                        KeyboardManager.this.onUnhandled(perEventCallbackBuilder2.keyEvent);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
            }
        }

        public PerEventCallbackBuilder(@NonNull KeyEvent keyEvent2) {
            this.keyEvent = keyEvent2;
        }

        public Responder.OnKeyEventHandledCallback buildCallback() {
            return new Callback();
        }
    }

    public interface Responder {

        public interface OnKeyEventHandledCallback {
            void onKeyEventHandled(Boolean bool);
        }

        void handleEvent(@NonNull KeyEvent keyEvent, @NonNull OnKeyEventHandledCallback onKeyEventHandledCallback);
    }

    public KeyboardManager(View view2, @NonNull TextInputPlugin textInputPlugin2, Responder[] responderArr) {
        this.view = view2;
        this.textInputPlugin = textInputPlugin2;
        this.responders = responderArr;
    }

    /* access modifiers changed from: private */
    public void onUnhandled(@NonNull KeyEvent keyEvent) {
        if (!this.textInputPlugin.handleKeyEvent(keyEvent) && this.view != null) {
            this.redispatchedEvents.add(keyEvent);
            this.view.getRootView().dispatchKeyEvent(keyEvent);
            if (this.redispatchedEvents.remove(keyEvent)) {
                Log.w(TAG, "A redispatched key event was consumed before reaching KeyboardManager");
            }
        }
    }

    public void destroy() {
        int size = this.redispatchedEvents.size();
        if (size > 0) {
            Log.w(TAG, "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    public boolean handleEvent(@NonNull KeyEvent keyEvent) {
        if (this.redispatchedEvents.remove(keyEvent)) {
            return false;
        }
        if (this.responders.length > 0) {
            PerEventCallbackBuilder perEventCallbackBuilder = new PerEventCallbackBuilder(keyEvent);
            for (Responder handleEvent : this.responders) {
                handleEvent.handleEvent(keyEvent, perEventCallbackBuilder.buildCallback());
            }
            return true;
        }
        onUnhandled(keyEvent);
        return true;
    }
}
