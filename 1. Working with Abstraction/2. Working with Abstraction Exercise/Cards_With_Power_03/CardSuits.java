package Cards_With_Power_03;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    CardSuits(int suitPower) {
        this.suitPower = suitPower;
    }

    private int suitPower;

    public int getSuitPower() {
        return suitPower;
    }
}
