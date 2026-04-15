package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class FifoRhymerTest {

    @Test
    public void testCountOut() {
        FifoRhymer rhymer = new FifoRhymer();

        rhymer.countIn(1);
        rhymer.countIn(2);
        rhymer.countIn(3);

        Assert.assertEquals(1, rhymer.countOut());
        Assert.assertEquals(2, rhymer.countOut());
        Assert.assertEquals(3, rhymer.countOut());
    }

    @Test
    public void testCountOutEmpty() {
        FifoRhymer rhymer = new FifoRhymer();
        final int EMPTY_STACK_VALUE = -1;

        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
    }
}