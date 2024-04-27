package br.com.acmepay.aplication.domain.models;

import br.com.acmepay.aplication.domain.exception.BalanceToWithdrawException;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDomain {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;
    private Customer customer;
    private List<Card> cards;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private List<String> transactions = new ArrayList<>();


    public void create(AccountDomain account) {
        this.setId(account.id);
        this.setCreated_at(LocalDateTime.now());
        this.setUpdated_at(null);
        this.setCustomer(createCustomer());
        this.setCards(new ArrayList<>());
        this.setBalance(BigDecimal.ZERO);
        this.setNumber(account.number);
        this.setAgency(account.agency);
        this.setClose(account.close);
        this.transactions.add("account created successfully" + LocalDateTime.now());
    }

    public void deposit(BigDecimal amount){

        this.balance = this.balance.add(amount);
        this.transactions.add("deposit successfully" + amount.toString());
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (checkBalance(amount)){
            this.balance = this.balance.subtract(amount);
            this.transactions.add("withdraw successfully" + amount.toString());
        }else {
            this.transactions.add("withdraw successfully" + amount.toString());
            throw new BalanceToWithdrawException("error withdraw");
        }

    }

    public void transfer(AccountDomain targetAccount, BigDecimal amount) throws BalanceToWithdrawException {
        this.withdraw(amount);
        targetAccount.deposit(amount);
        this.transactions.add("transfer successfully" + LocalDateTime.now());
    }

    public String extract(){
        String text = "Extract";
        for(String transiction : transactions) {
            text = text + "\n" + transiction;
        }
        return text;
    }

    private Customer createCustomer(){
        var customer = new Customer();
        customer.setId(1L);
        customer.setName("Carlos Barbosa");
        customer.setEmail("carlos@gmail.com");
        customer.setDocument("03100721403");
        customer.setPhone("83991267778");
        customer.setCreated_at(LocalDateTime.now());
        customer.setUpdated_at(null);
        customer.setAccounts(new ArrayList<>());
        return customer;
    }

    private boolean checkBalance(BigDecimal amount) {
            return this.balance.compareTo(amount) >= 0;
    }
}
