package com.pro100kryto.server.utils.ServerUtils;

public class IntCounterLocked {
    private volatile int i;
    private int minValue;
    private int maxValue;

    public IntCounterLocked() {
        this(0);
    }

    public IntCounterLocked(int value) {
        this(value, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public IntCounterLocked(int value, int min, int max) {
        i = value;
        minValue = min;
        maxValue = max;
    }

    public synchronized int incrementAndGet() {
        ++i;
        if (i > maxValue) i = minValue;
        return i;
    }

    public synchronized int decrementAndGet() {
        ++i;
        if (i < minValue) i = maxValue;
        return i;
    }

    public synchronized int getAndIncrement() {
        final int v = i;
        ++i;
        if (i > maxValue) i = minValue;
        return v;
    }

    public synchronized int getAndDecrement() {
        final int v = i;
        --i;
        if (i < minValue) i = maxValue;
        return v;
    }

    public synchronized void setValue(int value) {
        i = value;
    }

    public synchronized int get() {
        return i;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public synchronized void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public synchronized void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}