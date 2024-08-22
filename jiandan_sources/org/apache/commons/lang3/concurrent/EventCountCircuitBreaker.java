package org.apache.commons.lang3.concurrent;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

public class EventCountCircuitBreaker extends AbstractCircuitBreaker<Integer> {
    public static final Map<AbstractCircuitBreaker.State, StateStrategy> STRATEGY_MAP = createStrategyMap();
    public final AtomicReference<CheckIntervalData> checkIntervalData;
    public final long closingInterval;
    public final int closingThreshold;
    public final long openingInterval;
    public final int openingThreshold;

    public static class CheckIntervalData {
        public final long checkIntervalStart;
        public final int eventCount;

        public CheckIntervalData(int i2, long j) {
            this.eventCount = i2;
            this.checkIntervalStart = j;
        }

        public long getCheckIntervalStart() {
            return this.checkIntervalStart;
        }

        public int getEventCount() {
            return this.eventCount;
        }

        public CheckIntervalData increment(int i2) {
            return i2 != 0 ? new CheckIntervalData(getEventCount() + i2, getCheckIntervalStart()) : this;
        }
    }

    public static abstract class StateStrategy {
        public StateStrategy() {
        }

        public abstract long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker);

        public boolean isCheckIntervalFinished(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, long j) {
            return j - checkIntervalData.getCheckIntervalStart() > fetchCheckInterval(eventCountCircuitBreaker);
        }

        public abstract boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2);
    }

    public static class StateStrategyClosed extends StateStrategy {
        public StateStrategyClosed() {
            super();
        }

        public long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getOpeningInterval();
        }

        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getEventCount() > eventCountCircuitBreaker.getOpeningThreshold();
        }
    }

    public static class StateStrategyOpen extends StateStrategy {
        public StateStrategyOpen() {
            super();
        }

        public long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getClosingInterval();
        }

        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getCheckIntervalStart() != checkIntervalData.getCheckIntervalStart() && checkIntervalData.getEventCount() < eventCountCircuitBreaker.getClosingThreshold();
        }
    }

    public EventCountCircuitBreaker(int i2, long j, TimeUnit timeUnit, int i3, long j2, TimeUnit timeUnit2) {
        this.checkIntervalData = new AtomicReference<>(new CheckIntervalData(0, 0));
        this.openingThreshold = i2;
        this.openingInterval = timeUnit.toNanos(j);
        this.closingThreshold = i3;
        this.closingInterval = timeUnit2.toNanos(j2);
    }

    private void changeStateAndStartNewCheckInterval(AbstractCircuitBreaker.State state) {
        changeState(state);
        this.checkIntervalData.set(new CheckIntervalData(0, now()));
    }

    public static Map<AbstractCircuitBreaker.State, StateStrategy> createStrategyMap() {
        EnumMap enumMap = new EnumMap(AbstractCircuitBreaker.State.class);
        enumMap.put(AbstractCircuitBreaker.State.CLOSED, new StateStrategyClosed());
        enumMap.put(AbstractCircuitBreaker.State.OPEN, new StateStrategyOpen());
        return enumMap;
    }

    private CheckIntervalData nextCheckIntervalData(int i2, CheckIntervalData checkIntervalData2, AbstractCircuitBreaker.State state, long j) {
        if (stateStrategy(state).isCheckIntervalFinished(this, checkIntervalData2, j)) {
            return new CheckIntervalData(i2, j);
        }
        return checkIntervalData2.increment(i2);
    }

    private boolean performStateCheck(int i2) {
        AbstractCircuitBreaker.State state;
        CheckIntervalData checkIntervalData2;
        CheckIntervalData nextCheckIntervalData;
        do {
            long now = now();
            state = this.state.get();
            checkIntervalData2 = this.checkIntervalData.get();
            nextCheckIntervalData = nextCheckIntervalData(i2, checkIntervalData2, state, now);
        } while (!updateCheckIntervalData(checkIntervalData2, nextCheckIntervalData));
        if (stateStrategy(state).isStateTransition(this, checkIntervalData2, nextCheckIntervalData)) {
            state = state.oppositeState();
            changeStateAndStartNewCheckInterval(state);
        }
        return !AbstractCircuitBreaker.isOpen(state);
    }

    public static StateStrategy stateStrategy(AbstractCircuitBreaker.State state) {
        return STRATEGY_MAP.get(state);
    }

    private boolean updateCheckIntervalData(CheckIntervalData checkIntervalData2, CheckIntervalData checkIntervalData3) {
        return checkIntervalData2 == checkIntervalData3 || this.checkIntervalData.compareAndSet(checkIntervalData2, checkIntervalData3);
    }

    public boolean checkState() {
        return performStateCheck(0);
    }

    public void close() {
        super.close();
        this.checkIntervalData.set(new CheckIntervalData(0, now()));
    }

    public long getClosingInterval() {
        return this.closingInterval;
    }

    public int getClosingThreshold() {
        return this.closingThreshold;
    }

    public long getOpeningInterval() {
        return this.openingInterval;
    }

    public int getOpeningThreshold() {
        return this.openingThreshold;
    }

    public long now() {
        return System.nanoTime();
    }

    public void open() {
        super.open();
        this.checkIntervalData.set(new CheckIntervalData(0, now()));
    }

    public boolean incrementAndCheckState(Integer num) throws CircuitBreakingException {
        return performStateCheck(1);
    }

    public boolean incrementAndCheckState() {
        return incrementAndCheckState((Integer) 1);
    }

    public EventCountCircuitBreaker(int i2, long j, TimeUnit timeUnit, int i3) {
        this(i2, j, timeUnit, i3, j, timeUnit);
    }

    public EventCountCircuitBreaker(int i2, long j, TimeUnit timeUnit) {
        this(i2, j, timeUnit, i2);
    }
}
