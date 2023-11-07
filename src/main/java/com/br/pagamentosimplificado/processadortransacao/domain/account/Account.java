package com.br.pagamentosimplificado.processadortransacao.domain.account;

import com.br.pagamentosimplificado.processadortransacao.domain.account.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne
    private User holder;

    @Setter
    BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    public void receivePayment(BigDecimal value) {
        var newValue = this.balance.add(value);
        setBalance(newValue);
    }

    public void pay(BigDecimal value) {
        var newValue = this.balance.subtract(value);
        setBalance(newValue);
    }
}
