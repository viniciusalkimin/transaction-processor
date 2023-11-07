package com.br.pagamentosimplificado.processadortransacao.infrastructure.account;

import com.br.pagamentosimplificado.processadortransacao.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
}
