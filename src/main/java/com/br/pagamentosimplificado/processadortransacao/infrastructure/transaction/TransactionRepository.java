package com.br.pagamentosimplificado.processadortransacao.infrastructure.transaction;

import com.br.pagamentosimplificado.processadortransacao.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
