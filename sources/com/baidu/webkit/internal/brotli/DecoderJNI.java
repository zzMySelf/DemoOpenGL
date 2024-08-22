package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import java.io.IOException;
import java.nio.ByteBuffer;

public class DecoderJNI implements INoProGuard {

    public enum a {
        ERROR,
        DONE,
        NEEDS_MORE_INPUT,
        NEEDS_MORE_OUTPUT,
        OK
    }

    public static class Wrapper implements INoProGuard {
        private final long[] context;
        private boolean fresh = true;
        private final ByteBuffer inputBuffer;
        private a lastStatus = a.NEEDS_MORE_INPUT;

        public Wrapper(int i2) throws IOException {
            long[] jArr = new long[3];
            this.context = jArr;
            jArr[1] = (long) i2;
            this.inputBuffer = WebSettingsGlobalBlink.kernelBrotliCreate(jArr);
            if (jArr[0] == 0) {
                throw new IOException("failed to initialize native brotli decoder");
            }
        }

        public void push(int i2) throws IOException {
            if (i2 < 0) {
                throw new IOException("negative block length");
            } else if (this.context[0] == 0) {
                throw new IOException("brotli decoder is already destroyed");
            } else if (this.lastStatus != a.NEEDS_MORE_INPUT && this.lastStatus != a.OK) {
                throw new IOException("pushing input to decoder in " + this.lastStatus + " state");
            } else if (this.lastStatus != a.OK || i2 == 0) {
                this.fresh = false;
                WebSettingsGlobalBlink.kernelBrotliPush(this.context, i2);
                parseStatus();
            } else {
                throw new IOException("pushing input to decoder in OK state");
            }
        }

        private void parseStatus() {
            long j2 = this.context[1];
            if (j2 == 1) {
                this.lastStatus = a.DONE;
            } else if (j2 == 2) {
                this.lastStatus = a.NEEDS_MORE_INPUT;
            } else if (j2 == 3) {
                this.lastStatus = a.NEEDS_MORE_OUTPUT;
            } else if (j2 == 4) {
                this.lastStatus = a.OK;
            } else {
                this.lastStatus = a.ERROR;
            }
        }

        public a getStatus() {
            return this.lastStatus;
        }

        public ByteBuffer getInputBuffer() {
            return this.inputBuffer;
        }

        public boolean hasOutput() {
            return this.context[2] != 0;
        }

        public ByteBuffer pull() throws IOException {
            if (this.context[0] == 0) {
                throw new IOException("brotli decoder is already destroyed");
            } else if (this.lastStatus == a.NEEDS_MORE_OUTPUT || hasOutput()) {
                this.fresh = false;
                ByteBuffer kernelBrotliPull = WebSettingsGlobalBlink.kernelBrotliPull(this.context);
                parseStatus();
                return kernelBrotliPull;
            } else {
                throw new IOException("pulling output from decoder in " + this.lastStatus + " state");
            }
        }

        public void destroy() throws IOException {
            long[] jArr = this.context;
            if (jArr[0] != 0) {
                WebSettingsGlobalBlink.kernelBrotliDestroy(jArr);
                this.context[0] = 0;
                return;
            }
            throw new IOException("brotli decoder is already destroyed");
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (this.context[0] != 0) {
                destroy();
            }
            super.finalize();
        }
    }
}
