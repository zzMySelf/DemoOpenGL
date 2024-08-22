package fe.mmm.qw.xxx.uk.ppp;

import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.utils.SapiUtils;
import com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate;
import com.google.common.net.MediaType;
import com.tera.scan.filetype.FileType;
import java.io.File;
import java.io.FileFilter;

public class qw implements FileFilter {
    public boolean accept(File file) {
        String lowerCase = file.getName().toLowerCase();
        String lowerCase2 = file.getAbsolutePath().toLowerCase();
        if (file.isDirectory()) {
            if ("dcim".equals(lowerCase) || lowerCase.contains(MediaType.IMAGE_TYPE) || lowerCase.contains("img") || lowerCase.contains(SapiOptions.KEY_CACHE) || lowerCase.endsWith("log") || lowerCase.contains(SapiUtils.KEY_QR_LOGIN_ERROR) || lowerCase.contains(DxmPassManagerDelegate.DXM_KEY_AVATAR) || ad(lowerCase, lowerCase2) || lowerCase.contains("baidumap") || lowerCase.contains("autonavi")) {
                return false;
            }
            return true;
        } else if (lowerCase.contains("log") || lowerCase.contains(SapiUtils.KEY_QR_LOGIN_ERROR)) {
            return false;
        } else {
            return qw(lowerCase);
        }
    }

    public final boolean ad(String str, String str2) {
        if (!"/tencent".contains(str2) || "tencent".equals(str) || "qqfile_recv".equals(str) || "micromsg".equals(str)) {
            return false;
        }
        if (!"/tencent/micromsg".contains(str2) || !"download".equals(str)) {
            return true;
        }
        return false;
    }

    public boolean qw(String str) {
        return FileType.isMiniDoc(str);
    }
}
