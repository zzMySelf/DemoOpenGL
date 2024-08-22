package com.otaliastudios.cameraview.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.controls.Grid;

public class GridLinesLayout extends View {
    public static final int DEFAULT_COLOR = Color.argb(160, 255, 255, 255);
    public static final float GOLDEN_RATIO_INV = 0.618034f;
    @VisibleForTesting
    public ad callback;
    public int gridColor;
    public Grid gridMode;
    public ColorDrawable horiz;
    public ColorDrawable vert;
    public final float width;

    public interface ad {
        void qw(int i2);
    }

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.otaliastudios.cameraview.controls.Grid[] r0 = com.otaliastudios.cameraview.controls.Grid.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.otaliastudios.cameraview.controls.Grid r1 = com.otaliastudios.cameraview.controls.Grid.OFF     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.otaliastudios.cameraview.controls.Grid r1 = com.otaliastudios.cameraview.controls.Grid.DRAW_3X3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.otaliastudios.cameraview.controls.Grid r1 = com.otaliastudios.cameraview.controls.Grid.DRAW_PHI     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.otaliastudios.cameraview.controls.Grid r1 = com.otaliastudios.cameraview.controls.Grid.DRAW_4X4     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.internal.GridLinesLayout.qw.<clinit>():void");
        }
    }

    public GridLinesLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private int getLineCount() {
        int i2 = qw.qw[this.gridMode.ordinal()];
        if (i2 == 2 || i2 == 3) {
            return 2;
        }
        return i2 != 4 ? 0 : 3;
    }

    private float getLinePosition(int i2) {
        int lineCount = getLineCount();
        if (this.gridMode == Grid.DRAW_PHI) {
            return i2 == 1 ? 0.38196602f : 0.618034f;
        }
        return (1.0f / ((float) (lineCount + 1))) * (((float) i2) + 1.0f);
    }

    public int getGridColor() {
        return this.gridColor;
    }

    @NonNull
    public Grid getGridMode() {
        return this.gridMode;
    }

    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        int lineCount = getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            float linePosition = getLinePosition(i2);
            canvas.translate(0.0f, ((float) getHeight()) * linePosition);
            this.horiz.draw(canvas);
            float f = -linePosition;
            canvas.translate(0.0f, ((float) getHeight()) * f);
            canvas.translate(linePosition * ((float) getWidth()), 0.0f);
            this.vert.draw(canvas);
            canvas.translate(f * ((float) getWidth()), 0.0f);
        }
        ad adVar = this.callback;
        if (adVar != null) {
            adVar.qw(lineCount);
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.horiz.setBounds(i2, 0, i4, (int) this.width);
        this.vert.setBounds(0, i3, (int) this.width, i5);
    }

    public void setGridColor(@ColorInt int i2) {
        this.gridColor = i2;
        this.horiz.setColor(i2);
        this.vert.setColor(i2);
        postInvalidate();
    }

    public void setGridMode(@NonNull Grid grid) {
        this.gridMode = grid;
        postInvalidate();
    }

    public GridLinesLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gridColor = DEFAULT_COLOR;
        this.horiz = new ColorDrawable(this.gridColor);
        this.vert = new ColorDrawable(this.gridColor);
        this.width = TypedValue.applyDimension(1, 0.9f, context.getResources().getDisplayMetrics());
    }
}
