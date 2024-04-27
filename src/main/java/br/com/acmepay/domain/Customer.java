package br.com.acmepay.domain;

import br.com.acmepay.exception.ValidationDocumentException;
import br.com.acmepay.exception.ValidationEmailException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private List<Account> accounts;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private List<Customer> customers;

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}
    public String getDocument() {return document;}
    public List<Account> getAccounts() {return accounts;}
    public LocalDateTime getCreated_at() {return created_at;}
    public LocalDateTime getUpdated_at() {return updated_at;}

    public void createAccount (Customer customer) {
        try{

        }

        this.setId(customer.getId());
        this.setName(customer.getName());
        this.setEmail(customer.getEmail());
        this.setPhone(customer.getPhone());
        this.setDocument(customer.getDocument());
        this.setAccounts(customer.getAccounts());
        this.setCreated_at(customer.getCreated_at());
        this.setUpdated_at(customer.getUpdated_at());
    }

    public void deleteAccount(Customer customer) {

    }

    public void documentValidation(String document) throws ValidationDocumentException{
        for (Customer c: customers){
            if(document.equals(c.document)){
                throw new ValidationDocumentException("validated document");
            }
        }
    }

    public void emailValidation(String email) throws ValidationEmailException{
        for (Customer c: customers){
            if (email.equals(c.email)){
                throw new ValidationEmailException("validated email");
            }
        }
    }
}


/*
CREATE
DELETE
UPDATE
LIST
GETBYCUSTOMERCPF
 */