package fe.qw.qw.ggg;

public class ad {
    public static float ad(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow((double) f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int de(float f, int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        float f2 = ((float) ((i2 >> 24) & 255)) / 255.0f;
        float qw = qw(((float) ((i2 >> 16) & 255)) / 255.0f);
        float qw2 = qw(((float) ((i2 >> 8) & 255)) / 255.0f);
        float qw3 = qw(((float) (i2 & 255)) / 255.0f);
        float qw4 = qw(((float) ((i3 >> 16) & 255)) / 255.0f);
        float qw5 = qw(((float) ((i3 >> 8) & 255)) / 255.0f);
        float qw6 = qw3 + (f * (qw(((float) (i3 & 255)) / 255.0f) - qw3));
        return (Math.round(ad(qw + ((qw4 - qw) * f)) * 255.0f) << 16) | (Math.round((f2 + (((((float) ((i3 >> 24) & 255)) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(ad(qw2 + ((qw5 - qw2) * f)) * 255.0f) << 8) | Math.round(ad(qw6) * 255.0f);
    }

    public static float qw(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((double) ((f + 0.055f) / 1.055f), 2.4000000953674316d);
    }
}
