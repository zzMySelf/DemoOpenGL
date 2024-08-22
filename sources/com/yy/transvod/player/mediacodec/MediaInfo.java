package com.yy.transvod.player.mediacodec;

import com.yy.transvod.player.log.TLog;
import java.nio.ByteBuffer;
import java.util.Locale;

public final class MediaInfo {
    private static final String TAG = MediaInfo.class.getSimpleName();
    public int channels = 0;
    public ByteBuffer data = null;
    public int dataLen = 0;
    public int height = 0;
    public int planeHeight = 0;
    public int planeSize = 0;
    public int planeWidth = 0;
    public int sampleRate = 0;
    public int samples = 0;
    public float speed = 1.0f;
    public int type = 0;
    public int width = 0;

    private static native void native_copy_frame(MediaInfo mediaInfo, MediaInfo mediaInfo2, ByteBuffer[] byteBufferArr);

    private MediaInfo() {
    }

    public static void copyframe(MediaInfo src, MediaInfo dst, ByteBuffer[] buffers) {
        native_copy_frame(src, dst, buffers);
    }

    public static MediaInfo alloc() {
        MediaInfo info = new MediaInfo();
        info.reset();
        return info;
    }

    public static MediaInfo alloc(int type2, int i1, int i2) {
        MediaInfo info = alloc();
        info.type = type2;
        if (isVideo(info)) {
            info.width = i1;
            info.height = i2;
        } else {
            info.sampleRate = i1;
            info.channels = i2;
            info.samples = 1024;
        }
        return info;
    }

    public static boolean isValid(MediaInfo info) {
        int i2 = info.type;
        return i2 > 0 && i2 <= 11;
    }

    public static boolean isVideo(MediaInfo info) {
        switch (info.type) {
            case 1:
            case 5:
                return false;
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
                return true;
            default:
                TLog.error(TAG, "mediainfo type = " + info.type);
                return false;
        }
    }

    private static void java_copy_frame(MediaInfo src, MediaInfo dst, ByteBuffer[] buffers) {
        int limit = src.data.mark().limit();
        int position = src.data.position();
        int i2 = src.type;
        if (i2 == 2) {
            int i3 = src.planeWidth;
            int i4 = dst.planeWidth;
            if (i3 < i4) {
                int height2 = src.height;
                int srcPlaneWidth = src.planeWidth;
                int dstPlaneWidth = dst.planeWidth;
                buffers[0].clear();
                for (int i5 = 0; i5 < height2; i5++) {
                    src.data.limit(position + srcPlaneWidth);
                    int pos = buffers[0].position();
                    buffers[0].put(src.data);
                    position += srcPlaneWidth;
                    buffers[0].position(pos + dstPlaneWidth);
                }
                buffers[0].flip();
                int height3 = height2 >> 1;
                int srcPlaneWidth2 = srcPlaneWidth >> 1;
                int srcPlaneWidth3 = dstPlaneWidth >> 1;
                buffers[1].clear();
                for (int i6 = 0; i6 < height3; i6++) {
                    src.data.limit(position + srcPlaneWidth2);
                    int pos2 = buffers[1].position();
                    buffers[1].put(src.data);
                    position += srcPlaneWidth2;
                    buffers[1].position(pos2 + srcPlaneWidth3);
                }
                buffers[1].flip();
                buffers[2].clear();
                for (int i7 = 0; i7 < height3; i7++) {
                    src.data.limit(position + srcPlaneWidth2);
                    int pos3 = buffers[2].position();
                    buffers[2].put(src.data);
                    position += srcPlaneWidth2;
                    buffers[2].position(pos3 + srcPlaneWidth3);
                }
                buffers[2].flip();
            } else if (i3 == i4) {
                src.data.limit(src.planeSize + position);
                buffers[0].clear();
                buffers[0].put(src.data).flip();
                int i8 = src.planeSize;
                int position2 = position + i8;
                src.data.limit((i8 >> 2) + position2);
                buffers[1].clear();
                buffers[1].put(src.data).flip();
                int i9 = src.planeSize;
                src.data.limit((i9 >> 2) + position2 + (i9 >> 2));
                buffers[2].clear();
                buffers[2].put(src.data).flip();
            }
        } else if (i2 == 3) {
            int i10 = src.planeWidth;
            int i11 = dst.planeWidth;
            if (i10 < i11) {
                int height4 = src.height;
                int srcPlaneWidth4 = src.planeWidth;
                int dstPlaneWidth2 = dst.planeWidth;
                buffers[0].clear();
                for (int i12 = 0; i12 < height4; i12++) {
                    src.data.limit(position + srcPlaneWidth4);
                    int pos4 = buffers[0].position();
                    buffers[0].put(src.data);
                    position += srcPlaneWidth4;
                    buffers[0].position(pos4 + dstPlaneWidth2);
                }
                buffers[0].flip();
                int height5 = height4 >> 1;
                buffers[1].clear();
                for (int i13 = 0; i13 < height5; i13++) {
                    src.data.limit(position + srcPlaneWidth4);
                    int pos5 = buffers[1].position();
                    buffers[1].put(src.data);
                    position += srcPlaneWidth4;
                    buffers[1].position(pos5 + dstPlaneWidth2);
                }
                buffers[1].flip();
            } else if (i10 == i11) {
                src.data.limit(src.planeSize + position);
                buffers[0].clear();
                buffers[0].put(src.data).flip();
                int i14 = src.planeSize;
                src.data.limit((i14 >> 1) + position + i14);
                buffers[1].clear();
                buffers[1].put(src.data).flip();
            }
        }
        src.data.reset().limit(limit);
    }

    public MediaInfo reset() {
        this.type = 0;
        this.height = 0;
        this.width = 0;
        this.planeHeight = 0;
        this.planeWidth = 0;
        this.sampleRate = 0;
        this.channels = 0;
        this.samples = 0;
        this.dataLen = 0;
        this.planeSize = 0;
        this.data = null;
        return this;
    }

    public boolean isValid() {
        return isValid(this);
    }

    public boolean isVideo() {
        return isVideo(this);
    }

    public MediaInfo copy(MediaInfo info) {
        if (isVideo(info)) {
            this.type = info.type;
            this.width = info.width;
            this.height = info.height;
            int i2 = info.planeWidth;
            int i3 = info.width;
            if (i2 <= i3) {
                i2 = i3;
            }
            this.planeWidth = i2;
            int i4 = info.planeHeight;
            int i5 = info.height;
            if (i4 <= i5) {
                i4 = i5;
            }
            this.planeHeight = i4;
            int i6 = info.planeSize;
            if (i6 <= 0) {
                i6 = i2 * i4;
            }
            this.planeSize = i6;
            this.dataLen = info.dataLen;
        } else {
            this.type = info.type;
            this.sampleRate = info.sampleRate;
            this.samples = info.samples;
            this.channels = info.channels;
            this.dataLen = info.dataLen;
            this.speed = info.speed;
        }
        return this;
    }

    public boolean isChanged(MediaInfo info) {
        int i2 = this.type;
        if (i2 != 0 && info.type != i2) {
            return true;
        }
        if (isVideo(info)) {
            if (this.width == info.width && this.height == info.height && this.planeWidth == info.planeWidth && this.planeHeight == info.planeHeight) {
                return false;
            }
            return true;
        } else if (this.sampleRate == info.sampleRate && info.channels == this.channels) {
            return false;
        } else {
            return true;
        }
    }

    public final String toString() {
        if (isVideo(this)) {
            return String.format(Locale.CHINA, "type:%s, frameSize:%dx%d, planeSize:%dx%d", new Object[]{MediaConst.FRAME_TYPE_TEXT[this.type], Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(this.planeWidth), Integer.valueOf(this.planeHeight)});
        }
        return String.format(Locale.CHINA, "type:%s, sampleRate:%d, samples:%d, channels:%d", new Object[]{MediaConst.FRAME_TYPE_TEXT[this.type], Integer.valueOf(this.sampleRate), Integer.valueOf(this.samples), Integer.valueOf(this.channels)});
    }
}
