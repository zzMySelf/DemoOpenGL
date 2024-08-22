package org.apache.commons.lang3.tuple;

public class MutablePair<L, R> extends Pair<L, R> {
    public static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    public MutablePair() {
    }

    public static <L, R> MutablePair<L, R> of(L l, R r) {
        return new MutablePair<>(l, r);
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    public void setLeft(L l) {
        this.left = l;
    }

    public void setRight(R r) {
        this.right = r;
    }

    public R setValue(R r) {
        R right2 = getRight();
        setRight(r);
        return right2;
    }

    public MutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }
}
