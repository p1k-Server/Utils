package com.pro100kryto.server.utils.ServerUtils;

public class IntCounterLocked {
    private int i;
    private final int minValue;
    private final int maxValue;
    private final Object locker = new Object();

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

    public int incrementAndGet() {
        synchronized (locker) {
            i++;
            if (i > maxValue) i = minValue;
            return i;
        }
    }

    public int decrementAndGet() {
        synchronized (locker) {
            i--;
            if (i < minValue) i = maxValue;
            return i;
        }
    }

    public void setValue(int value) {
        synchronized (locker) {
            i = value;
        }
    }

    public int get() {
        synchronized (locker) {
            return i;
        }
    }
}