package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {
    public static final int BOUND = 20;
    public static final int START_I = 1;
    public static final int END_I = 15;
    public static final int START_ZERO_I = 0;
    public static final int END_J = 3;
    public static final int FIFO_RHYMER_IDX = 3;

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();

        testRhymers(factory);

    }

    private static void testRhymers(RhymersFactory factory) {
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

class DefaultRhymersFactory implements RhymersFactory {

    @Override
    public DefaultCountingOutRhymer GetStandardRhymer() {
        return new DefaultCountingOutRhymer();
    }

    @Override
    public DefaultCountingOutRhymer GetFalseRhymer() {
        return new DefaultCountingOutRhymer();
    }

    @Override
    public DefaultCountingOutRhymer GetFIFORhymer() {
        return new FifoRhymer();
    }

    @Override
    public DefaultCountingOutRhymer GetHanoiRhymer() {
        return new HanoiRhymer();
    }

}