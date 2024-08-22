package com.baidubce.util;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.wallet.paysdk.datamodel.Bank;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Mimetypes {
    public static final String MIMETYPE_OCTET_STREAM = "application/octet-stream";
    public static Mimetypes mimetypes;
    public HashMap<String, String> extensionToMimetypeMap = new HashMap<>();

    public static synchronized Mimetypes getInstance() {
        String str;
        synchronized (Mimetypes.class) {
            if (mimetypes != null) {
                Mimetypes mimetypes2 = mimetypes;
                return mimetypes2;
            }
            Mimetypes mimetypes3 = new Mimetypes();
            mimetypes = mimetypes3;
            InputStream resourceAsStream = mimetypes3.getClass().getResourceAsStream("/mime.types");
            if (resourceAsStream != null) {
                BLog.debug("Loading mime types from file in the classpath: mime.types");
                try {
                    mimetypes.loadAndReplaceMimetypes(resourceAsStream);
                    try {
                        resourceAsStream.close();
                    } catch (IOException e) {
                        e = e;
                        String str2 = "";
                    }
                } catch (IOException e2) {
                    try {
                        BLog.error("Failed to load mime types from file in the classpath: mime.types", (Throwable) e2);
                    } finally {
                        try {
                            resourceAsStream.close();
                        } catch (IOException e3) {
                            str = "";
                            BLog.debug(str, (Throwable) e3);
                        }
                    }
                }
            } else {
                BLog.warn("Unable to find 'mime.types' file in classpath");
            }
            Mimetypes mimetypes4 = mimetypes;
            return mimetypes4;
        }
        Mimetypes mimetypes42 = mimetypes;
        return mimetypes42;
    }

    public String getMimetype(String str) {
        int i2;
        int lastIndexOf = str.lastIndexOf(IStringUtil.CURRENT_PATH);
        if (lastIndexOf <= 0 || (i2 = lastIndexOf + 1) >= str.length()) {
            BLog.debug("File name has no extension, mime type cannot be recognised for: " + str);
        } else {
            String lowerCase = str.substring(i2).toLowerCase();
            if (this.extensionToMimetypeMap.keySet().contains(lowerCase)) {
                String str2 = this.extensionToMimetypeMap.get(lowerCase);
                BLog.debug("Recognised extension '" + lowerCase + "', mimetype is: '" + str2 + "'");
                return str2;
            }
            BLog.debug("Extension '" + lowerCase + "' is unrecognized in mime type listing, using default mime type: '" + MIMETYPE_OCTET_STREAM + "'");
        }
        return MIMETYPE_OCTET_STREAM;
    }

    public void loadAndReplaceMimetypes(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String trim = readLine.trim();
                if (!trim.startsWith(Bank.HOT_BANK_LETTER) && trim.length() != 0) {
                    StringTokenizer stringTokenizer = new StringTokenizer(trim, " \t");
                    if (stringTokenizer.countTokens() > 1) {
                        String nextToken = stringTokenizer.nextToken();
                        while (stringTokenizer.hasMoreTokens()) {
                            String nextToken2 = stringTokenizer.nextToken();
                            this.extensionToMimetypeMap.put(nextToken2.toLowerCase(), nextToken);
                            BLog.debug("Setting mime type for extension '" + nextToken2.toLowerCase() + "' to '" + nextToken + "'");
                        }
                    } else {
                        BLog.debug("Ignoring mimetype with no associated file extensions: '" + trim + "'");
                    }
                }
            } else {
                return;
            }
        }
    }

    public String getMimetype(File file) {
        return getMimetype(file.getName());
    }
}
