package ru.mishe1.homeworks.hw12;

import java.util.*;


public class BankHawala {
    private Map<Client, Set<AnonymousAccount>> clients; // NOTE: у клиента может быть множество счетов
    private Map<AnonymousAccount, Client> accounts; // NOTE: у счёта может быть только один владелец

    BankHawala() {
        clients = new HashMap<Client, Set<AnonymousAccount>>();
        accounts = new HashMap<AnonymousAccount, Client>();
    }

    void add(Client client) {
        final var account = new AnonymousAccount();
        add(client, account);
    }

    void add(Client client, AnonymousAccount account) {
        if (clients.containsKey(client)) {
            clients.get(client).add(account);
            accounts.put(account, client);
            return;
        }
        final var clientAccounts = new HashSet<AnonymousAccount>();
        clientAccounts.add(account);
        clients.put(client, clientAccounts);
        accounts.put(account, client);
    }

    Set getAccounts(Client client) {
        return (Set) clients.get(client);
    }

    Client findClient(AnonymousAccount account) {
        return accounts.get(account);
    }

    @Override
    public String toString() {
        var r = "Clients:";
        for (Map.Entry<Client, Set<AnonymousAccount>> set : clients.entrySet()) {
            r += "\n" + set.getKey().toString();
            Iterator<AnonymousAccount> clientAccountsIterator = set.getValue().iterator();
            while(clientAccountsIterator.hasNext()) {
                r += "\n\t" + clientAccountsIterator.next().toString();
            }
        }
        return r;
    }
}