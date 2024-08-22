package org.apache.commons.lang3;

import java.util.Random;

public class RandomStringUtils {
    public static final Random RANDOM = new Random();

    public static String random(int i2) {
        return random(i2, false, false);
    }

    public static String randomAlphabetic(int i2) {
        return random(i2, true, false);
    }

    public static String randomAlphanumeric(int i2) {
        return random(i2, true, true);
    }

    public static String randomAscii(int i2) {
        return random(i2, 32, 127, false, false);
    }

    public static String randomGraph(int i2) {
        return random(i2, 33, 126, false, false);
    }

    public static String randomNumeric(int i2) {
        return random(i2, false, true);
    }

    public static String randomPrint(int i2) {
        return random(i2, 32, 126, false, false);
    }

    public static String random(int i2, boolean z, boolean z2) {
        return random(i2, 0, 0, z, z2);
    }

    public static String randomAlphabetic(int i2, int i3) {
        return randomAlphabetic(RandomUtils.nextInt(i2, i3));
    }

    public static String randomAlphanumeric(int i2, int i3) {
        return randomAlphanumeric(RandomUtils.nextInt(i2, i3));
    }

    public static String randomAscii(int i2, int i3) {
        return randomAscii(RandomUtils.nextInt(i2, i3));
    }

    public static String randomGraph(int i2, int i3) {
        return randomGraph(RandomUtils.nextInt(i2, i3));
    }

    public static String randomNumeric(int i2, int i3) {
        return randomNumeric(RandomUtils.nextInt(i2, i3));
    }

    public static String randomPrint(int i2, int i3) {
        return randomPrint(RandomUtils.nextInt(i2, i3));
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2) {
        return random(i2, i3, i4, z, z2, (char[]) null, RANDOM);
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2, char... cArr) {
        return random(i2, i3, i4, z, z2, cArr, RANDOM);
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2, char[] cArr, Random random) {
        char c;
        if (i2 == 0) {
            return "";
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Requested random string length " + i2 + " is less than 0.");
        } else if (cArr == null || cArr.length != 0) {
            if (i3 == 0 && i4 == 0) {
                if (cArr != null) {
                    i4 = cArr.length;
                } else if (z || z2) {
                    i4 = 123;
                    i3 = 32;
                } else {
                    i4 = Integer.MAX_VALUE;
                }
            } else if (i4 <= i3) {
                throw new IllegalArgumentException("Parameter end (" + i4 + ") must be greater than start (" + i3 + ")");
            }
            char[] cArr2 = new char[i2];
            int i5 = i4 - i3;
            while (true) {
                int i6 = i2 - 1;
                if (i2 == 0) {
                    return new String(cArr2);
                }
                if (cArr == null) {
                    c = (char) (random.nextInt(i5) + i3);
                } else {
                    c = cArr[random.nextInt(i5) + i3];
                }
                if ((z && Character.isLetter(c)) || ((z2 && Character.isDigit(c)) || (!z && !z2))) {
                    if (c < 56320 || c > 57343) {
                        if (c < 55296 || c > 56191) {
                            if (c < 56192 || c > 56319) {
                                cArr2[i6] = c;
                                i2 = i6;
                            }
                        } else if (i6 != 0) {
                            cArr2[i6] = (char) (random.nextInt(128) + 56320);
                            i6--;
                            cArr2[i6] = c;
                            i2 = i6;
                        }
                    } else if (i6 != 0) {
                        cArr2[i6] = c;
                        i6--;
                        cArr2[i6] = (char) (random.nextInt(128) + 55296);
                        i2 = i6;
                    }
                }
                i6++;
                i2 = i6;
            }
        } else {
            throw new IllegalArgumentException("The chars array must not be empty");
        }
    }

    public static String random(int i2, String str) {
        if (str != null) {
            return random(i2, str.toCharArray());
        }
        return random(i2, 0, 0, false, false, (char[]) null, RANDOM);
    }

    public static String random(int i2, char... cArr) {
        if (cArr == null) {
            return random(i2, 0, 0, false, false, (char[]) null, RANDOM);
        }
        return random(i2, 0, cArr.length, false, false, cArr, RANDOM);
    }
}
