package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE = 128;
    GoalVariableAccessor accessor = new GoalVariableAccessor(this);
    private SolverVariable[] arrayGoals = new SolverVariable[128];
    Cache mCache;
    private int numGoals = 0;
    private SolverVariable[] sortArray = new SolverVariable[128];

    class GoalVariableAccessor implements Comparable {
        PriorityGoalRow row;
        SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow row2) {
            this.row = row2;
        }

        public void init(SolverVariable variable2) {
            this.variable = variable2;
        }

        public boolean addToGoal(SolverVariable other, float value) {
            if (this.variable.inGoal) {
                boolean empty = true;
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = this.variable.goalStrengthVector;
                    fArr[i2] = fArr[i2] + (other.goalStrengthVector[i2] * value);
                    if (Math.abs(this.variable.goalStrengthVector[i2]) < 1.0E-4f) {
                        this.variable.goalStrengthVector[i2] = 0.0f;
                    } else {
                        empty = false;
                    }
                }
                if (!empty) {
                    return false;
                }
                PriorityGoalRow.this.removeGoal(this.variable);
                return false;
            }
            for (int i3 = 0; i3 < 9; i3++) {
                float strength = other.goalStrengthVector[i3];
                if (strength != 0.0f) {
                    float v = value * strength;
                    if (Math.abs(v) < 1.0E-4f) {
                        v = 0.0f;
                    }
                    this.variable.goalStrengthVector[i3] = v;
                } else {
                    this.variable.goalStrengthVector[i3] = 0.0f;
                }
            }
            return true;
        }

        public void add(SolverVariable other) {
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.variable.goalStrengthVector;
                fArr[i2] = fArr[i2] + other.goalStrengthVector[i2];
                if (Math.abs(this.variable.goalStrengthVector[i2]) < 1.0E-4f) {
                    this.variable.goalStrengthVector[i2] = 0.0f;
                }
            }
        }

        public final boolean isNegative() {
            for (int i2 = 8; i2 >= 0; i2--) {
                float value = this.variable.goalStrengthVector[i2];
                if (value > 0.0f) {
                    return false;
                }
                if (value < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isSmallerThan(SolverVariable other) {
            int i2 = 8;
            while (i2 >= 0) {
                float comparedValue = other.goalStrengthVector[i2];
                float value = this.variable.goalStrengthVector[i2];
                if (value == comparedValue) {
                    i2--;
                } else if (value < comparedValue) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i2 = 0; i2 < 9; i2++) {
                if (this.variable.goalStrengthVector[i2] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public int compareTo(Object o) {
            return this.variable.id - ((SolverVariable) o).id;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String result = "[ ";
            if (this.variable != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    result = result + this.variable.goalStrengthVector[i2] + " ";
                }
            }
            return result + "] " + this.variable;
        }
    }

    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mCache = cache;
    }

    public boolean isEmpty() {
        return this.numGoals == 0;
    }

    public SolverVariable getPivotCandidate(LinearSystem system, boolean[] avoid) {
        int pivot = -1;
        for (int i2 = 0; i2 < this.numGoals; i2++) {
            SolverVariable variable = this.arrayGoals[i2];
            if (!avoid[variable.id]) {
                this.accessor.init(variable);
                if (pivot == -1) {
                    if (this.accessor.isNegative()) {
                        pivot = i2;
                    }
                } else if (this.accessor.isSmallerThan(this.arrayGoals[pivot])) {
                    pivot = i2;
                }
            }
        }
        if (pivot == -1) {
            return null;
        }
        return this.arrayGoals[pivot];
    }

    public void addError(SolverVariable error) {
        this.accessor.init(error);
        this.accessor.reset();
        error.goalStrengthVector[error.strength] = 1.0f;
        addToGoal(error);
    }

    private final void addToGoal(SolverVariable variable) {
        int i2;
        int i3 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i3 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i4 = this.numGoals;
        solverVariableArr3[i4] = variable;
        int i5 = i4 + 1;
        this.numGoals = i5;
        if (i5 > 1 && solverVariableArr3[i5 - 1].id > variable.id) {
            int i6 = 0;
            while (true) {
                i2 = this.numGoals;
                if (i6 >= i2) {
                    break;
                }
                this.sortArray[i6] = this.arrayGoals[i6];
                i6++;
            }
            Arrays.sort(this.sortArray, 0, i2, new Comparator<SolverVariable>() {
                public int compare(SolverVariable variable1, SolverVariable variable2) {
                    return variable1.id - variable2.id;
                }
            });
            for (int i7 = 0; i7 < this.numGoals; i7++) {
                this.arrayGoals[i7] = this.sortArray[i7];
            }
        }
        variable.inGoal = true;
        variable.addToRow(this);
    }

    /* access modifiers changed from: private */
    public final void removeGoal(SolverVariable variable) {
        int i2 = 0;
        while (i2 < this.numGoals) {
            if (this.arrayGoals[i2] == variable) {
                int j2 = i2;
                while (true) {
                    int i3 = this.numGoals;
                    if (j2 < i3 - 1) {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        solverVariableArr[j2] = solverVariableArr[j2 + 1];
                        j2++;
                    } else {
                        this.numGoals = i3 - 1;
                        variable.inGoal = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    public void updateFromRow(LinearSystem system, ArrayRow definition, boolean removeFromDefinition) {
        SolverVariable goalVariable = definition.variable;
        if (goalVariable != null) {
            ArrayRow.ArrayRowVariables rowVariables = definition.variables;
            int currentSize = rowVariables.getCurrentSize();
            for (int i2 = 0; i2 < currentSize; i2++) {
                SolverVariable solverVariable = rowVariables.getVariable(i2);
                float value = rowVariables.getVariableValue(i2);
                this.accessor.init(solverVariable);
                if (this.accessor.addToGoal(goalVariable, value)) {
                    addToGoal(solverVariable);
                }
                this.constantValue += definition.constantValue * value;
            }
            removeGoal(goalVariable);
        }
    }

    public String toString() {
        String result = "" + " goal -> (" + this.constantValue + ") : ";
        for (int i2 = 0; i2 < this.numGoals; i2++) {
            this.accessor.init(this.arrayGoals[i2]);
            result = result + this.accessor + " ";
        }
        return result;
    }
}
