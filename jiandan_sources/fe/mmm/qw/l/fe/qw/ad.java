package fe.mmm.qw.l.fe.qw;

import com.tera.scan.framework.ui.view.IBaseView;
import fe.mmm.qw.m.ggg.qw.qw;
import org.json.JSONObject;

public class ad extends qw {
    public ad(IBaseView iBaseView) {
        super(iBaseView);
    }

    public void onAction(fe.mmm.qw.m.ggg.fe.ad adVar) {
        fe.mmm.qw.i.qw.ad("HybridActionClose", "HybridActionClose action");
        if (!isDestroy()) {
            this.mHybridParam = adVar;
            if ("close".equals(adVar.f8046de)) {
                qw(adVar.f8047fe);
            } else {
                handleRecognizeSchemeError(adVar);
            }
        }
    }

    public final void qw(String str) {
        this.mBaseView.getActivity().finish();
        handleHybridCallback(this.mHybridParam, 1, "", new JSONObject());
    }
}
