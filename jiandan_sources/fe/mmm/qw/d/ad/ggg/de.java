package fe.mmm.qw.d.ad.ggg;

import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public abstract class de implements Cloneable {

    /* renamed from: ad  reason: collision with root package name */
    public String f7682ad;

    /* renamed from: th  reason: collision with root package name */
    public int f7683th;

    /* renamed from: uk  reason: collision with root package name */
    public String f7684uk;

    /* renamed from: yj  reason: collision with root package name */
    public String f7685yj;

    public void ad(View view) {
        de(view);
    }

    public abstract void de(View view);

    /* renamed from: fe */
    public de clone() {
        try {
            return (de) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean rg() {
        return ResUtils.f.equals(this.f7684uk);
    }

    public boolean th() {
        return ResUtils.f719i.equals(this.f7684uk);
    }

    public String toString() {
        return "SkinAttr{attrName='" + this.f7682ad + ExtendedMessageFormat.QUOTE + ", attrValueRefId=" + this.f7683th + ", attrValueRefName='" + this.f7685yj + ExtendedMessageFormat.QUOTE + ", attrValueTypeName='" + this.f7684uk + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    public boolean yj() {
        return ResUtils.e.equals(this.f7684uk) || "mipmap".equals(this.f7684uk);
    }
}
