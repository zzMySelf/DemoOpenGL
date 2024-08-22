package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    public static final boolean DEBUG = false;
    public static final boolean HASH = true;
    public static float epsilon = 0.001f;
    public int HASH_SIZE = 16;
    public final int NONE = -1;
    public int SIZE = 16;
    public int head = -1;
    public int[] keys = new int[16];
    public final Cache mCache;
    public int mCount = 0;
    public final ArrayRow mRow;
    public int[] next = new int[16];
    public int[] nextKeys = new int[16];
    public int[] previous = new int[16];
    public float[] values = new float[16];
    public int[] variables = new int[16];

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i2) {
        int[] iArr;
        int i3 = solverVariable.id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.nextKeys;
                if (iArr[i4] == -1) {
                    break;
                }
                i4 = iArr[i4];
            }
            iArr[i4] = i2;
        }
        this.nextKeys[i2] = -1;
    }

    private void addVariable(int i2, SolverVariable solverVariable, float f) {
        this.variables[i2] = solverVariable.id;
        this.values[i2] = f;
        this.previous[i2] = -1;
        this.next[i2] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i2 = 0; i2 < this.HASH_SIZE; i2++) {
            if (this.keys[i2] != -1) {
                String str = hashCode() + " hash [" + i2 + "] => ";
                int i3 = this.keys[i2];
                boolean z = false;
                while (!z) {
                    str = str + " " + this.variables[i3];
                    int[] iArr = this.nextKeys;
                    if (iArr[i3] != -1) {
                        i3 = iArr[i3];
                    } else {
                        z = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i2 = 0; i2 < this.SIZE; i2++) {
            if (this.variables[i2] == -1) {
                return i2;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i2 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i2);
        this.values = Arrays.copyOf(this.values, i2);
        this.previous = Arrays.copyOf(this.previous, i2);
        this.next = Arrays.copyOf(this.next, i2);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i2);
        for (int i3 = this.SIZE; i3 < i2; i3++) {
            this.variables[i3] = -1;
            this.nextKeys[i3] = -1;
        }
        this.SIZE = i2;
    }

    private void insertVariable(int i2, SolverVariable solverVariable, float f) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f);
        if (i2 != -1) {
            this.previous[findEmptySlot] = i2;
            int[] iArr = this.next;
            iArr[findEmptySlot] = iArr[i2];
            iArr[i2] = findEmptySlot;
        } else {
            this.previous[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[findEmptySlot] = this.head;
                this.head = findEmptySlot;
            } else {
                this.next[findEmptySlot] = -1;
            }
        }
        int[] iArr2 = this.next;
        if (iArr2[findEmptySlot] != -1) {
            this.previous[iArr2[findEmptySlot]] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int i2 = solverVariable.id;
        int i3 = i2 % this.HASH_SIZE;
        int[] iArr = this.keys;
        int i4 = iArr[i3];
        if (i4 != -1) {
            if (this.variables[i4] == i2) {
                int[] iArr2 = this.nextKeys;
                iArr[i3] = iArr2[i4];
                iArr2[i4] = -1;
                return;
            }
            while (true) {
                int[] iArr3 = this.nextKeys;
                if (iArr3[i4] == -1 || this.variables[iArr3[i4]] == i2) {
                    int[] iArr4 = this.nextKeys;
                    int i5 = iArr4[i4];
                } else {
                    i4 = iArr3[i4];
                }
            }
            int[] iArr42 = this.nextKeys;
            int i52 = iArr42[i4];
            if (i52 != -1 && this.variables[i52] == i2) {
                iArr42[i4] = iArr42[i52];
                iArr42[i52] = -1;
            }
        }
    }

    public void add(SolverVariable solverVariable, float f, boolean z) {
        float f2 = epsilon;
        if (f <= (-f2) || f >= f2) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f);
                return;
            }
            float[] fArr = this.values;
            fArr[indexOf] = fArr[indexOf] + f;
            float f3 = fArr[indexOf];
            float f4 = epsilon;
            if (f3 > (-f4) && fArr[indexOf] < f4) {
                fArr[indexOf] = 0.0f;
                remove(solverVariable, z);
            }
        }
    }

    public void clear() {
        int i2 = this.mCount;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i4 = 0; i4 < this.SIZE; i4++) {
            this.variables[i4] = -1;
            this.nextKeys[i4] = -1;
        }
        for (int i5 = 0; i5 < this.HASH_SIZE; i5++) {
            this.keys[i5] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    public void display() {
        int i2 = this.mCount;
        System.out.print("{ ");
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i3) + " ");
            }
        }
        System.out.println(" }");
    }

    public void divideByAmount(float f) {
        int i2 = this.mCount;
        int i3 = this.head;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.values;
            fArr[i3] = fArr[i3] / f;
            i3 = this.next[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }

    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.mCount;
    }

    public SolverVariable getVariable(int i2) {
        int i3 = this.mCount;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.head;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i4]];
            }
            i4 = this.next[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    public float getVariableValue(int i2) {
        int i3 = this.mCount;
        int i4 = this.head;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.values[i4];
            }
            i4 = this.next[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount == 0) {
            return -1;
        }
        int i2 = solverVariable.id;
        int i3 = this.keys[i2 % this.HASH_SIZE];
        if (i3 == -1) {
            return -1;
        }
        if (this.variables[i3] == i2) {
            return i3;
        }
        while (true) {
            int[] iArr = this.nextKeys;
            if (iArr[i3] == -1 || this.variables[iArr[i3]] == i2) {
                int[] iArr2 = this.nextKeys;
            } else {
                i3 = iArr[i3];
            }
        }
        int[] iArr22 = this.nextKeys;
        if (iArr22[i3] != -1 && this.variables[iArr22[i3]] == i2) {
            return iArr22[i3];
        }
        return -1;
    }

    public void invert() {
        int i2 = this.mCount;
        int i3 = this.head;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.values;
            fArr[i3] = fArr[i3] * -1.0f;
            i3 = this.next[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }

    public void put(SolverVariable solverVariable, float f) {
        float f2 = epsilon;
        if (f <= (-f2) || f >= f2) {
            if (this.mCount == 0) {
                addVariable(0, solverVariable, f);
                addToHashMap(solverVariable, 0);
                this.head = 0;
                return;
            }
            int indexOf = indexOf(solverVariable);
            if (indexOf != -1) {
                this.values[indexOf] = f;
                return;
            }
            if (this.mCount + 1 >= this.SIZE) {
                increaseSize();
            }
            int i2 = this.mCount;
            int i3 = this.head;
            int i4 = -1;
            for (int i5 = 0; i5 < i2; i5++) {
                int[] iArr = this.variables;
                int i6 = iArr[i3];
                int i7 = solverVariable.id;
                if (i6 == i7) {
                    this.values[i3] = f;
                    return;
                }
                if (iArr[i3] < i7) {
                    i4 = i3;
                }
                i3 = this.next[i3];
                if (i3 == -1) {
                    break;
                }
            }
            insertVariable(i4, solverVariable, f);
            return;
        }
        remove(solverVariable, true);
    }

    public float remove(SolverVariable solverVariable, boolean z) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] iArr = this.previous;
        if (iArr[indexOf] != -1) {
            int[] iArr2 = this.next;
            iArr2[iArr[indexOf]] = iArr2[indexOf];
        }
        int[] iArr3 = this.next;
        if (iArr3[indexOf] != -1) {
            int[] iArr4 = this.previous;
            iArr4[iArr3[indexOf]] = iArr4[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f;
    }

    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i2 = this.mCount;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                String str4 = str3 + variable + " = " + getVariableValue(i3) + " ";
                int indexOf = indexOf(variable);
                String str5 = str4 + "[p: ";
                if (this.previous[indexOf] != -1) {
                    str = str5 + this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.next[indexOf] != -1) {
                    str2 = str6 + this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    public float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.variable);
        remove(arrayRow.variable, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i2 = solverVariableValues.head;
        int i3 = 0;
        int i4 = 0;
        while (i3 < currentSize) {
            int[] iArr = solverVariableValues.variables;
            if (iArr[i4] != -1) {
                add(this.mCache.mIndexedVariables[iArr[i4]], solverVariableValues.values[i4] * f, z);
                i3++;
            }
            i4++;
        }
        return f;
    }
}
