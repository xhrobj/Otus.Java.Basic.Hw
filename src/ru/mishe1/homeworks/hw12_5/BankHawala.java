package ru.mishe1.homeworks.hw12_5;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;


public class BankHawala {
    private Set<Client> clients;

    BankHawala() {
        clients = new HashSet<Client>();
    }

    void add(Client client) {
        if (clients.contains(client)) return;
        clients.add(client);

        if (client.hasAccount()) return;
        client.addAccount(new AnonymousAccount());
    }

    List getAccounts(Client client) {
        return client.getAccounts();
    }

    Client findClient(AnonymousAccount account) {
        return account.getOwner();
    }

    @Override
    public String toString() {
        var result = "Clients:";
        Iterator<Client> clientsIterator = clients.iterator();
        while(clientsIterator.hasNext()) {
            result += "\n" + clientsIterator.next();
        }
        return result;
    }
}