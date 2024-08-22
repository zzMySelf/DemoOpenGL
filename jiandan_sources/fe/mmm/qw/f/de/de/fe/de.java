package fe.mmm.qw.f.de.de.fe;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public final class de {

    public static class qw {
        public int qw;

        public final void ad(ViewPager viewPager, int i2, int i3, int i4) {
            viewPager.scrollTo((int) ((((float) i2) / ((float) i4)) * ((float) i3)), viewPager.getScrollY());
        }

        public void qw(ViewPager viewPager, int i2) {
            int paddingLeft = (i2 - viewPager.getPaddingLeft()) - viewPager.getPaddingRight();
            if (paddingLeft != 0) {
                int i3 = this.qw;
                if (i3 == 0) {
                    this.qw = paddingLeft;
                } else if (i3 != paddingLeft) {
                    ad(viewPager, viewPager.getScrollX(), paddingLeft, this.qw);
                    this.qw = paddingLeft;
                }
            }
        }
    }

    public static void qw(@NonNull ViewPager viewPager, int i2) {
        if (i2 != viewPager.getPageMargin()) {
            if ((viewPager.getMeasuredWidth() - viewPager.getPaddingLeft()) - viewPager.getPaddingRight() == 0) {
                viewPager.setPageMargin(i2);
                return;
            }
            int scrollX = viewPager.getScrollX();
            viewPager.setPageMargin(i2);
            viewPager.scrollTo(scrollX, viewPager.getScrollY());
        }
    }
}
