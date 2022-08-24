package ru.mishe1.homeworks.hw12;

class Client {
    static private int id = 0;

    static int nextId() {
        return ++id;
    }
    final int secretCode;

    private String name;
    private int age;

    Client(String name, int age) {
        this.secretCode = nextId();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "#" + secretCode + " \uD83D\uDE0E " + name + " (age: " + age + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client that = (Client) o;

        return secretCode == that.secretCode;
    }

    @Override
    public int hashCode() {
        return secretCode;
    }
}
