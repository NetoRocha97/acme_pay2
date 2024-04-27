package br.com.acmepay.aplication.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private Long id;
    private String flag;
    private BigDecimal card_limit;
    private AccountDomain account;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
