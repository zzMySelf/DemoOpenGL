package fe.rg.qw.o.th.yj;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import fe.rg.qw.o.th.rg.ad;

public class rg extends ad<de> implements Initializable {
    public rg(de deVar) {
        super(deVar);
    }

    @NonNull
    public Class<de> ad() {
        return de.class;
    }

    public void initialize() {
        ((de) this.f4986ad).fe().prepareToDraw();
    }

    public int qw() {
        return ((de) this.f4986ad).uk();
    }

    public void recycle() {
        ((de) this.f4986ad).stop();
        ((de) this.f4986ad).i();
    }
}
