package fe.mmm.qw.j.vvv;

import fe.mmm.qw.i.qw;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class rg {
    public static String qw(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes());
            return ad.qw(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            qw.th("SHA1Util", e.getMessage(), e);
            return null;
        } catch (Exception e2) {
            qw.th("SHA1Util", e2.getMessage(), e2);
            return null;
        }
    }
}
