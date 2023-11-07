package com.br.pagamentosimplificado.processadortransacao.domain.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private BigDecimal balance;

    public BigDecimal receivePayment(BigDecimal value) {
        this.balance.add(value);
        return balance;
    }

    public BigDecimal pay(BigDecimal value) {
        this.balance.subtract(value);
        return balance;
    }
}
