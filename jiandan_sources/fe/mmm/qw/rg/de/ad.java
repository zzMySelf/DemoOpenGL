package fe.mmm.qw.rg.de;

import androidx.lifecycle.Observer;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {
    public final /* synthetic */ TextRecognitionActivity qw;

    public /* synthetic */ ad(TextRecognitionActivity textRecognitionActivity) {
        this.qw = textRecognitionActivity;
    }

    public final void onChanged(Object obj) {
        TextRecognitionActivity.m732initListener$lambda5(this.qw, (List) obj);
    }
}
