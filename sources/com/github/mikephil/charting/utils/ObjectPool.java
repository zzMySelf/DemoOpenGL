package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import java.util.List;

public class ObjectPool<T extends Poolable> {
    private static int ids = 0;
    private int desiredCapacity;
    private T modelObject;
    private Object[] objects;
    private int objectsPointer;
    private int poolId;
    private float replenishPercentage;

    public static abstract class Poolable {
        public static int NO_OWNER = -1;
        int currentOwnerId = NO_OWNER;

        /* access modifiers changed from: protected */
        public abstract Poolable instantiate();
    }

    public int getPoolId() {
        return this.poolId;
    }

    public static synchronized ObjectPool create(int withCapacity, Poolable object) {
        ObjectPool result;
        synchronized (ObjectPool.class) {
            result = new ObjectPool(withCapacity, object);
            int i2 = ids;
            result.poolId = i2;
            ids = i2 + 1;
        }
        return result;
    }

    private ObjectPool(int withCapacity, T object) {
        if (withCapacity > 0) {
            this.desiredCapacity = withCapacity;
            this.objects = new Object[withCapacity];
            this.objectsPointer = 0;
            this.modelObject = object;
            this.replenishPercentage = 1.0f;
            refillPool();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public void setReplenishPercentage(float percentage) {
        float p = percentage;
        if (p > 1.0f) {
            p = 1.0f;
        } else if (p < 0.0f) {
            p = 0.0f;
        }
        this.replenishPercentage = p;
    }

    public float getReplenishPercentage() {
        return this.replenishPercentage;
    }

    private void refillPool() {
        refillPool(this.replenishPercentage);
    }

    private void refillPool(float percentage) {
        int i2 = this.desiredCapacity;
        int portionOfCapacity = (int) (((float) i2) * percentage);
        if (portionOfCapacity < 1) {
            portionOfCapacity = 1;
        } else if (portionOfCapacity > i2) {
            portionOfCapacity = this.desiredCapacity;
        }
        for (int i3 = 0; i3 < portionOfCapacity; i3++) {
            this.objects[i3] = this.modelObject.instantiate();
        }
        this.objectsPointer = portionOfCapacity - 1;
    }

    public synchronized T get() {
        T result;
        if (this.objectsPointer == -1 && this.replenishPercentage > 0.0f) {
            refillPool();
        }
        result = (Poolable) this.objects[this.objectsPointer];
        result.currentOwnerId = Poolable.NO_OWNER;
        this.objectsPointer--;
        return result;
    }

    public synchronized void recycle(T object) {
        if (object.currentOwnerId == Poolable.NO_OWNER) {
            int i2 = this.objectsPointer + 1;
            this.objectsPointer = i2;
            if (i2 >= this.objects.length) {
                resizePool();
            }
            object.currentOwnerId = this.poolId;
            this.objects[this.objectsPointer] = object;
        } else if (object.currentOwnerId == this.poolId) {
            throw new IllegalArgumentException("The object passed is already stored in this pool!");
        } else {
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + object.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
        }
    }

    public synchronized void recycle(List<T> objects2) {
        while (objects2.size() + this.objectsPointer + 1 > this.desiredCapacity) {
            resizePool();
        }
        int objectsListSize = objects2.size();
        int i2 = 0;
        while (i2 < objectsListSize) {
            T object = (Poolable) objects2.get(i2);
            if (object.currentOwnerId == Poolable.NO_OWNER) {
                object.currentOwnerId = this.poolId;
                this.objects[this.objectsPointer + 1 + i2] = object;
                i2++;
            } else if (object.currentOwnerId == this.poolId) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            } else {
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + object.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
            }
        }
        this.objectsPointer += objectsListSize;
    }

    private void resizePool() {
        int oldCapacity = this.desiredCapacity;
        int i2 = this.desiredCapacity * 2;
        this.desiredCapacity = i2;
        Object[] temp = new Object[i2];
        for (int i3 = 0; i3 < oldCapacity; i3++) {
            temp[i3] = this.objects[i3];
        }
        this.objects = temp;
    }

    public int getPoolCapacity() {
        return this.objects.length;
    }

    public int getPoolCount() {
        return this.objectsPointer + 1;
    }
}
