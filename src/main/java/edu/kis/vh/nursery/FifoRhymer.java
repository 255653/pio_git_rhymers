package edu.kis.vh.nursery;

public class FifoRhymer extends DefaultCountingOutRhymer {

    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    // TODO: Zoptymalizować metode, przerzucanie wszystkich elementów dwa razy jest bardzo niewydajne.
    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
