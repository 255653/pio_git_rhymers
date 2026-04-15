package edu.kis.vh.nursery;

/**
 * Klasa reprezentująca stos działająca na zasadzie reguł z gry Wieże Hanoi.
 * Akceptuje tylko te wartości, które są mniejsze lub równe wartości znajdującej się
 * aktualnie na szczycie stosu.
 */

public class HanoiRhymer extends DefaultCountingOutRhymer {

    private int totalRejected = 0;

docs
    /**
     * Zwraca całkowitą liczbę elementów, które zostały odrzucone podczas prób dodania ich do stosu.
     *
     * @return liczba odrzuconych elementów
     */

    public int reportRejected() {
    protected int reportRejected() {
master
        return totalRejected;
    }

    /**
     * Próbuje dodać nowy element do stosu.
     * Jeśli stos nie jest pusty, a dodawana wartość jest większa niż element na szczycie, wartość zostaje odrzucona, a totalRejected rośnie.
     * W przeciwnym razie element jest normalnie dodawany.
     *
     * @param in wartość liczbowa, która ma zostać dodana do stosu
     */
    @Override
    protected void countIn(int in) {
        if (!callCheck() && in > peekABoo())
            totalRejected++;
        else
            super.countIn(in);
    }
}
