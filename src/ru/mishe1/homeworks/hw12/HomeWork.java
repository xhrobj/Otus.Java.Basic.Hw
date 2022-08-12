/*
    Описание/Пошаговая инструкция выполнения домашнего задания:

    У нас есть банк , в котором хранятся золотые монеты.
    У банка есть клиенты у которых есть имя и нам как банку важно знать их возраст для ограничений на операции.
    У одного клиента может быть несколько счетов на которых хранятся золотые монеты.

    Нужно реализовать следующую функциональность :
        Найти все счета по клиенту (например List getAccounts(Client client) )
        Найти клиента по счету (например Client findClient(Account account) )
        Поиск должен работать максимально быстро(!!!) с использованием стандартных коллекций Java.
        В классах Client и Account должно быть минимальное кол-во полей, достаточное для этой задачи.
 */

package ru.mishe1.homeworks.hw12;

class HomeWork {
    public static void main(String[] args) {
        final var hawala = new BankHawala();

        // Добавим в банк клиента
        final var barry = new Client("Barry", 42);
        hawala.add(barry);

        // Добавим еще пару клиентов
        hawala.add(new Client("Anna", 25));
        hawala.add(new Client("Dexter", 32));

        // Создаем дополнительный счет, добавляем на счет монет и связываем его с одним из клиентов
        final var offshoreAccount = new AnonymousAccount();
        offshoreAccount.deposit(500);
        hawala.add(barry, offshoreAccount);

        System.out.println("\nСтруктура клиентских счетов нашего банка:");
        System.out.println(hawala);

        System.out.println("\nНаходим все счета клиента \"Barry\":");
        System.out.println(hawala.getAccounts(barry));

        System.out.println("\nНаходим клиента по счету:");
        System.out.println(hawala.findClient(offshoreAccount));
    }
}
