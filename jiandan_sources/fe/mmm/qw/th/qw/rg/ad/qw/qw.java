package fe.mmm.qw.th.qw.rg.ad.qw;

import android.content.Context;
import com.tera.scan.component.base.ui.localfile.baseui.ISelectionInterface;
import com.tera.scan.localfile.model.FileItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class qw implements ISelectionInterface {

    /* renamed from: ad  reason: collision with root package name */
    public ISelectionInterface f8332ad;

    /* renamed from: th  reason: collision with root package name */
    public Map<Integer, FileItem> f8333th = new LinkedHashMap();

    public qw(ISelectionInterface iSelectionInterface) {
        this.f8332ad = iSelectionInterface;
    }

    public ArrayList<FileItem> ad() {
        ArrayList<FileItem> arrayList = new ArrayList<>();
        arrayList.addAll(this.f8333th.values());
        return arrayList;
    }

    public int de() {
        return this.f8333th.size();
    }

    public boolean fe(int i2) {
        return this.f8333th.containsKey(Integer.valueOf(i2));
    }

    public FileItem getSelectedFile(Context context, int i2) {
        return this.f8332ad.getSelectedFile(context, i2);
    }

    public void qw(Context context, int i2) {
        FileItem selectedFile = getSelectedFile(context, i2);
        if (selectedFile != null) {
            this.f8333th.put(Integer.valueOf(i2), selectedFile);
        }
    }

    public void rg() {
        this.f8333th.clear();
    }

    public void th(int i2) {
        this.f8333th.remove(Integer.valueOf(i2));
    }
}
