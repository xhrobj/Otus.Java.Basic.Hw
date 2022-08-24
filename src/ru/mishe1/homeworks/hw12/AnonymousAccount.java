package ru.mishe1.homeworks.hw12;

class AnonymousAccount {

    static private int id = 0;

    static int nextNumber() {
        return ++id;
    }

    final int number;

    private int goldenCoins = 0;

    AnonymousAccount() {
        this.number = nextNumber();
    }

    void deposit(int goldenCoins) {
        this.goldenCoins += goldenCoins;
    }

    int withdraw(int goldenCoins) {
        if (goldenCoins > this.goldenCoins) {
            goldenCoins = this.goldenCoins;
            this.goldenCoins = 0;
            return goldenCoins;
        }
        this.goldenCoins -= goldenCoins;
        return goldenCoins;
    }

    // MARK: - @Override

    @Override
    public String toString() {
        return "#" + number + " \uD83D\uDCB0 " + goldenCoins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnonymousAccount that = (AnonymousAccount) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}