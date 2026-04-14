package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int CAPACITY = 12;
    private static final int EMPTY_INDEX = -1;
    private static final int NO_VALUE = -1;
    private static final int LAST_INDEX = CAPACITY - 1;
    private final int[] numbers = new int[CAPACITY];

    private int total = EMPTY_INDEX;

    protected void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    protected boolean callCheck() {
        return total == EMPTY_INDEX;
    }

    protected boolean isFull() {
        return total == LAST_INDEX;
    }

    protected int peekABoo() {
        if (callCheck())
            return NO_VALUE;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return NO_VALUE;
        return numbers[total--];
    }

}
