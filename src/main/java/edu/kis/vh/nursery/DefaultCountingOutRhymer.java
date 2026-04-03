package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int CAPACITY = 12;
    private static final int EMPTY = -1;
    private static final int LAST_INDEX = CAPACITY - 1;
    private final int[] numbers = new int[CAPACITY];

    public int total = EMPTY;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY;
    }

    public boolean isFull() {
        return total == LAST_INDEX;
    }

    protected int peekABoo() {
        if (callCheck())
            return EMPTY;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return EMPTY;
        return numbers[total--];
    }

}
