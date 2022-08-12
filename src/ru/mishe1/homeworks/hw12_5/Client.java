package ru.mishe1.homeworks.hw12_5;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class Client {
    static private int id = 0;

    static int nextId() {
        return ++id;
    }
    final int secretCode;

    private String name;
    private int age;

    private List<AnonymousAccount> accounts;

    Client(String name, int age) {
        this.secretCode = nextId();
        this.name = name;
        this.age = age;
        this.accounts = new LinkedList<AnonymousAccount>();
    }

    List<AnonymousAccount> getAccounts() {
        return accounts;
    }

    boolean hasAccount() {
        return !accounts.isEmpty();
    }

    void addAccount(AnonymousAccount account) {
        accounts.add(account);
        account.setOwner(this);
    }

    @Override
    public String toString() {
        var result = "#" + secretCode + " \uD83D\uDE0E " + name + " (age: " + age + ")";
        Iterator<AnonymousAccount> accountsIterator = accounts.iterator();
        while(accountsIterator.hasNext()) {
            result += "\n\t" + accountsIterator.next();
        }
        return result;
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
