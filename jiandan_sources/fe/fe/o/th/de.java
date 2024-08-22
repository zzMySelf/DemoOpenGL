package fe.fe.o.th;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class de implements FileFilter {
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
