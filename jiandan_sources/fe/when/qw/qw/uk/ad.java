package fe.when.qw.qw.uk;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ad {
    public static ResourceBundle qw;

    public static String qw(String str) {
        ResourceBundle resourceBundle = qw;
        if (resourceBundle == null) {
            return str;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return "Missing message: " + str;
        }
    }
}
