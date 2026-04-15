package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.Rhymersfactory;

class RhymersDemo {
    public static final int BOUND = 20;
    public static final int START_I = 1;
    public static final int END_I = 15;
    public static final int START_ZERO_I = 0;
    public static final int END_J = 3;
    public static final int FIFO_RHYMER_IDX = 3;

    public static void main(String[] args) {
        Rhymersfactory factory = new DefaultRhymersFactory();

        testRhymers(factory);

    }

    private static void testRhymers(Rhymersfactory factory) {
        DefaultCountingOutRhymer[] rhymers = { factory.GetStandardRhymer(), factory.GetFalseRhymer(),
                factory.GetFIFORhymer(), factory.GetHanoiRhymer()};

        for (int i = START_I; i < END_I; i++)
            for (int j = START_ZERO_I; j < END_J; j++)
                rhymers[j].countIn(i);

        java.util.Random rn = new java.util.Random();
        for (int i = START_I; i < END_I; i++)
            rhymers[FIFO_RHYMER_IDX].countIn(rn.nextInt(BOUND));

        for (int i = START_ZERO_I; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[FIFO_RHYMER_IDX]).reportRejected());
    }

}