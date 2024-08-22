package com.baidu.titan.sdk.pm;

import com.baidu.titan.sdk.common.TitanConstant;
import com.baidu.titan.sdk.internal.util.Closes;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PatchClassInfo {
    public HashSet<String> instantClassNames;
    public HashSet<String> lazyClassNames;

    public static PatchClassInfo createFromJson(String json) {
        try {
            PatchClassInfo patchClassInfo = new PatchClassInfo();
            JSONObject jsonObject = new JSONObject(json);
            JSONArray lazyArray = jsonObject.getJSONArray(TitanConstant.KEY_LAZY_INIT_CLASS);
            JSONArray instantArray = jsonObject.getJSONArray("instant");
            patchClassInfo.lazyClassNames = new HashSet<>();
            patchClassInfo.instantClassNames = new HashSet<>();
            for (int i2 = 0; i2 < lazyArray.length(); i2++) {
                patchClassInfo.lazyClassNames.add(lazyArray.getString(i2));
            }
            for (int i3 = 0; i3 < instantArray.length(); i3++) {
                patchClassInfo.instantClassNames.add(instantArray.getString(i3));
            }
            return patchClassInfo;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public static PatchClassInfo createFromPatch(File patchFile) {
        try {
            ZipFile patchZip = new ZipFile(patchFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(patchZip.getInputStream(new ZipEntry(TitanConstant.PATCH_CLASS_INFO_PATH))));
            CharArrayWriter caw = new CharArrayWriter();
            char[] buffer = new char[8192];
            while (true) {
                int read = reader.read(buffer);
                int len = read;
                if (read > 0) {
                    caw.write(buffer, 0, len);
                } else {
                    PatchClassInfo pci = createFromJson(caw.toString());
                    Closes.closeQuiet((Reader) reader);
                    Closes.closeQuiet(patchZip);
                    return pci;
                }
            }
        } catch (Exception e2) {
            Closes.closeQuiet((Reader) null);
            Closes.closeQuiet((ZipFile) null);
            return null;
        } catch (Throwable th2) {
            Closes.closeQuiet((Reader) null);
            Closes.closeQuiet((ZipFile) null);
            throw th2;
        }
    }
}
