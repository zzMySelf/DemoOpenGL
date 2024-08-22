package com.baidu.searchbox.music.player.lyrics.text;

import com.baidu.talos.core.archivers.tar.TarConstants;

abstract class CharsetRecog2022 extends CharsetRecognizer {
    CharsetRecog2022() {
    }

    /* access modifiers changed from: package-private */
    public int match(byte[] text, int textLen, byte[][] escapeSequences) {
        int hits = 0;
        int misses = 0;
        int shifts = 0;
        int i2 = 0;
        while (i2 < textLen) {
            if (text[i2] == 27) {
                for (byte[] seq : escapeSequences) {
                    if (textLen - i2 >= seq.length) {
                        int j2 = 1;
                        while (j2 < seq.length) {
                            if (seq[j2] == text[i2 + j2]) {
                                j2++;
                            }
                        }
                        hits++;
                        i2 += seq.length - 1;
                        break;
                    }
                }
                misses++;
            }
            if (text[i2] == 14 || text[i2] == 15) {
                shifts++;
                i2++;
            } else {
                i2++;
            }
        }
        if (hits == 0) {
            return 0;
        }
        int quality = ((hits * 100) - (misses * 100)) / (hits + misses);
        if (hits + shifts < 5) {
            quality -= (5 - (hits + shifts)) * 10;
        }
        if (quality < 0) {
            return 0;
        }
        return quality;
    }

    static class CharsetRecog2022CN extends CharsetRecog2022 {
        private byte[][] escapeSequences = {new byte[]{27, 36, 41, 65}, new byte[]{27, 36, 41, 71}, new byte[]{27, 36, 42, 72}, new byte[]{27, 36, 41, 69}, new byte[]{27, 36, 43, 73}, new byte[]{27, 36, 43, 74}, new byte[]{27, 36, 43, TarConstants.LF_GNUTYPE_LONGLINK}, new byte[]{27, 36, 43, TarConstants.LF_GNUTYPE_LONGNAME}, new byte[]{27, 36, 43, 77}, new byte[]{27, 78}, new byte[]{27, 79}};

        CharsetRecog2022CN() {
        }

        /* access modifiers changed from: package-private */
        public String getName() {
            return "ISO-2022-CN";
        }

        /* access modifiers changed from: package-private */
        public CharsetMatch match(CharsetDetector det) {
            int confidence = match(det.fInputBytes, det.fInputLen, this.escapeSequences);
            if (confidence == 0) {
                return null;
            }
            return new CharsetMatch(det, this, confidence);
        }
    }

    static class CharsetRecog2022KR extends CharsetRecog2022 {
        private byte[][] escapeSequences = {new byte[]{27, 36, 41, 67}};

        CharsetRecog2022KR() {
        }

        /* access modifiers changed from: package-private */
        public String getName() {
            return "ISO-2022-KR";
        }

        /* access modifiers changed from: package-private */
        public CharsetMatch match(CharsetDetector det) {
            int confidence = match(det.fInputBytes, det.fInputLen, this.escapeSequences);
            if (confidence == 0) {
                return null;
            }
            return new CharsetMatch(det, this, confidence);
        }
    }

    static class CharsetRecog2022JP extends CharsetRecog2022 {
        private byte[][] escapeSequences = {new byte[]{27, 36, 40, 67}, new byte[]{27, 36, 40, 68}, new byte[]{27, 36, 64}, new byte[]{27, 36, 65}, new byte[]{27, 36, 66}, new byte[]{27, 38, 64}, new byte[]{27, 40, 66}, new byte[]{27, 40, 72}, new byte[]{27, 40, 73}, new byte[]{27, 40, 74}, new byte[]{27, 46, 65}, new byte[]{27, 46, 70}};

        CharsetRecog2022JP() {
        }

        /* access modifiers changed from: package-private */
        public String getName() {
            return "ISO-2022-JP";
        }

        /* access modifiers changed from: package-private */
        public CharsetMatch match(CharsetDetector det) {
            int confidence = match(det.fInputBytes, det.fInputLen, this.escapeSequences);
            if (confidence == 0) {
                return null;
            }
            return new CharsetMatch(det, this, confidence);
        }
    }
}
