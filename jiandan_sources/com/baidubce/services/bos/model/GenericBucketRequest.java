package com.baidubce.services.bos.model;

import com.baidu.android.common.others.IStringUtil;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.util.CheckUtils;

public abstract class GenericBucketRequest extends AbstractBceRequest {
    public static final int MAX_BUCKET_NAME_LENGTH = 63;
    public static final int MIN_BUCKET_NAME_LENGTH = 3;
    public String bucketName;

    public GenericBucketRequest() {
    }

    public static boolean isLowercaseOrDigit(char c) {
        return Character.isDigit(c) || (c >= 'a' && c <= 'z');
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        CheckUtils.isNotNull(str, "bucketName should not be null.");
        String trim = str.trim();
        if (trim.length() < 3) {
            throw new IllegalArgumentException("Invalid bucketNamse:" + trim + ". bucketName should not be less than " + 3 + IStringUtil.CURRENT_PATH);
        } else if (trim.length() > 63) {
            throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should not be greater than " + 63 + IStringUtil.CURRENT_PATH);
        } else if (!isLowercaseOrDigit(trim.charAt(0))) {
            throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should start with a lowercase letter or digit.");
        } else if (isLowercaseOrDigit(trim.charAt(trim.length() - 1))) {
            int i2 = 1;
            while (i2 < trim.length() - 1) {
                char charAt = trim.charAt(i2);
                if (isLowercaseOrDigit(charAt) || charAt == '-') {
                    i2++;
                } else {
                    throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should contain only lowercase leters, digits and hyphens(-).");
                }
            }
            this.bucketName = trim;
        } else {
            throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should end with a lowercase letter or digit.");
        }
    }

    public abstract GenericBucketRequest withBucketName(String str);

    public GenericBucketRequest(String str) {
        setBucketName(str);
    }
}
