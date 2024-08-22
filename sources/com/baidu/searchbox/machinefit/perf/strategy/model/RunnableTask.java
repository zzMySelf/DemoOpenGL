package com.baidu.searchbox.machinefit.perf.strategy.model;

public abstract class RunnableTask implements Runnable {
    private String id;
    private String name;

    public RunnableTask() {
    }

    public RunnableTask(String id2) {
        this.id = id2;
    }

    public RunnableTask(String id2, String name2) {
        this.id = id2;
        this.name = name2;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
