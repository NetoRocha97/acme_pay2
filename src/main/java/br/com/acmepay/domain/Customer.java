package br.com.acmepay.domain;

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
    private List<br.com.acmepay.domain.Account> accounts;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
