package br.com.acmepay.mapper;

import br.com.acmepay.aplication.domain.models.AccountDomain;

public class App {
    public static void main( String[] args ) {
        AccountDomain account = new AccountDomain();
        account.setId(1L);
        account.setClose(false);
        account.setAgency(1010);
        account.setNumber(203040);

        account.create(account);
        account.getTransactions().forEach(acc -> {
            System.out.println(account.getAgency());
            System.out.println(account.getNumber());
            System.out.println(account.getCreated_at());
        });
    }
}
