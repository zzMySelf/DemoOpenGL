package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        public boolean onData(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException {
            bufferedSource.skip((long) i3);
            return true;
        }

        public boolean onHeaders(int i2, List<Header> list, boolean z) {
            return true;
        }

        public boolean onRequest(int i2, List<Header> list) {
            return true;
        }

        public void onReset(int i2, ErrorCode errorCode) {
        }
    };

    boolean onData(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException;

    boolean onHeaders(int i2, List<Header> list, boolean z);

    boolean onRequest(int i2, List<Header> list);

    void onReset(int i2, ErrorCode errorCode);
}
