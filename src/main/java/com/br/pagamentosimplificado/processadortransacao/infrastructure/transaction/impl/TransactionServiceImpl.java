package com.br.pagamentosimplificado.processadortransacao.infrastructure.transaction.impl;

import com.br.pagamentosimplificado.processadortransacao.application.dto.TransactionDataDTO;
import com.br.pagamentosimplificado.processadortransacao.application.transaction.service.TransacationService;
import com.br.pagamentosimplificado.processadortransacao.domain.transaction.Transaction;
import com.br.pagamentosimplificado.processadortransacao.infrastructure.account.AccountRepository;
import com.br.pagamentosimplificado.processadortransacao.infrastructure.transaction.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransacationService {

    private AccountRepository accountRepository;

    private TransactionRepository transactionRepository;

    @Override
    public void processTransaction(TransactionDataDTO transactionDataDTO) {
        var transaction = Transaction.builder()
                .payerAccountId(transactionDataDTO.idAccountPayer()).receiverAccountId(transactionDataDTO.idAccountReceiver())
                .transactionValue(transactionDataDTO.value()).moment(LocalDateTime.now())
                .build();
        transactionRepository.save(transaction);
        var payerAccount = accountRepository.findById(UUID.fromString(transaction.getPayerAccountId())).get();
        var receiverAccount = accountRepository.findById(UUID.fromString(transaction.getReceiverAccountId())).get();
        payerAccount.pay(transaction.getTransactionValue());
        receiverAccount.receivePayment(transaction.getTransactionValue());
        accountRepository.saveAll(List.of(payerAccount, receiverAccount));
    }
}
