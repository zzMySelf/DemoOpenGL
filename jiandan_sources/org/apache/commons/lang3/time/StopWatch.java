package org.apache.commons.lang3.time;

import java.util.concurrent.TimeUnit;

public class StopWatch {
    public static final long NANO_2_MILLIS = 1000000;
    public State runningState = State.UNSTARTED;
    public SplitState splitState = SplitState.UNSPLIT;
    public long startTime;
    public long startTimeMillis;
    public long stopTime;

    public enum SplitState {
        SPLIT,
        UNSPLIT
    }

    public enum State {
        UNSTARTED {
            public boolean isStarted() {
                return false;
            }

            public boolean isStopped() {
                return true;
            }

            public boolean isSuspended() {
                return false;
            }
        },
        RUNNING {
            public boolean isStarted() {
                return true;
            }

            public boolean isStopped() {
                return false;
            }

            public boolean isSuspended() {
                return false;
            }
        },
        STOPPED {
            public boolean isStarted() {
                return false;
            }

            public boolean isStopped() {
                return true;
            }

            public boolean isSuspended() {
                return false;
            }
        },
        SUSPENDED {
            public boolean isStarted() {
                return true;
            }

            public boolean isStopped() {
                return false;
            }

            public boolean isSuspended() {
                return true;
            }
        };

        public abstract boolean isStarted();

        public abstract boolean isStopped();

        public abstract boolean isSuspended();
    }

    public static StopWatch createStarted() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }

    public long getNanoTime() {
        long j;
        long j2;
        State state = this.runningState;
        if (state == State.STOPPED || state == State.SUSPENDED) {
            j = this.stopTime;
            j2 = this.startTime;
        } else if (state == State.UNSTARTED) {
            return 0;
        } else {
            if (state == State.RUNNING) {
                j = System.nanoTime();
                j2 = this.startTime;
            } else {
                throw new RuntimeException("Illegal running state has occurred.");
            }
        }
        return j - j2;
    }

    public long getSplitNanoTime() {
        if (this.splitState == SplitState.SPLIT) {
            return this.stopTime - this.startTime;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    }

    public long getSplitTime() {
        return getSplitNanoTime() / 1000000;
    }

    public long getStartTime() {
        if (this.runningState != State.UNSTARTED) {
            return this.startTimeMillis;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public long getTime() {
        return getNanoTime() / 1000000;
    }

    public boolean isStarted() {
        return this.runningState.isStarted();
    }

    public boolean isStopped() {
        return this.runningState.isStopped();
    }

    public boolean isSuspended() {
        return this.runningState.isSuspended();
    }

    public void reset() {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
    }

    public void resume() {
        if (this.runningState == State.SUSPENDED) {
            this.startTime += System.nanoTime() - this.stopTime;
            this.runningState = State.RUNNING;
            return;
        }
        throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }

    public void split() {
        if (this.runningState == State.RUNNING) {
            this.stopTime = System.nanoTime();
            this.splitState = SplitState.SPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void start() {
        State state = this.runningState;
        if (state == State.STOPPED) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        } else if (state == State.UNSTARTED) {
            this.startTime = System.nanoTime();
            this.startTimeMillis = System.currentTimeMillis();
            this.runningState = State.RUNNING;
        } else {
            throw new IllegalStateException("Stopwatch already started. ");
        }
    }

    public void stop() {
        State state = this.runningState;
        if (state == State.RUNNING || state == State.SUSPENDED) {
            if (this.runningState == State.RUNNING) {
                this.stopTime = System.nanoTime();
            }
            this.runningState = State.STOPPED;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void suspend() {
        if (this.runningState == State.RUNNING) {
            this.stopTime = System.nanoTime();
            this.runningState = State.SUSPENDED;
            return;
        }
        throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }

    public String toSplitString() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    public String toString() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public void unsplit() {
        if (this.splitState == SplitState.SPLIT) {
            this.splitState = SplitState.UNSPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch has not been split. ");
    }

    public long getTime(TimeUnit timeUnit) {
        return timeUnit.convert(getNanoTime(), TimeUnit.NANOSECONDS);
    }
}
