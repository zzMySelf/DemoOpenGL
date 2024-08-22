package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Keep
public class FlutterMutatorsStack {
    public List<Path> finalClippingPaths = new ArrayList();
    public Matrix finalMatrix = new Matrix();
    @NonNull
    public List<FlutterMutator> mutators = new ArrayList();

    public enum FlutterMutatorType {
        CLIP_RECT,
        CLIP_RRECT,
        CLIP_PATH,
        TRANSFORM,
        OPACITY
    }

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }

    public List<FlutterMutator> getMutators() {
        return this.mutators;
    }

    public void pushClipRRect(int i2, int i3, int i4, int i5, float[] fArr) {
        Rect rect = new Rect(i2, i3, i4, i5);
        this.mutators.add(new FlutterMutator(rect, fArr));
        Path path = new Path();
        path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRect(int i2, int i3, int i4, int i5) {
        Rect rect = new Rect(i2, i3, i4, i5);
        this.mutators.add(new FlutterMutator(rect));
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushTransform(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        FlutterMutator flutterMutator = new FlutterMutator(matrix);
        this.mutators.add(flutterMutator);
        this.finalMatrix.preConcat(flutterMutator.getMatrix());
    }

    public class FlutterMutator {
        @Nullable
        public Matrix matrix;
        @Nullable
        public Path path;
        @Nullable
        public float[] radiis;
        @Nullable
        public Rect rect;
        public FlutterMutatorType type;

        public FlutterMutator(Rect rect2) {
            this.type = FlutterMutatorType.CLIP_RECT;
            this.rect = rect2;
        }

        public Matrix getMatrix() {
            return this.matrix;
        }

        public Path getPath() {
            return this.path;
        }

        public Rect getRect() {
            return this.rect;
        }

        public FlutterMutatorType getType() {
            return this.type;
        }

        public FlutterMutator(Rect rect2, float[] fArr) {
            this.type = FlutterMutatorType.CLIP_RRECT;
            this.rect = rect2;
            this.radiis = fArr;
        }

        public FlutterMutator(Path path2) {
            this.type = FlutterMutatorType.CLIP_PATH;
            this.path = path2;
        }

        public FlutterMutator(Matrix matrix2) {
            this.type = FlutterMutatorType.TRANSFORM;
            this.matrix = matrix2;
        }
    }
}
