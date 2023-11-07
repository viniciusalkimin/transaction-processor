package com.br.pagamentosimplificado.processadortransacao.infrastructure.transaction.impl;

import com.br.pagamentosimplificado.processadortransacao.application.transaction.TransactionDataDTO;
import com.br.pagamentosimplificado.processadortransacao.application.transaction.service.TransacationService;
import com.br.pagamentosimplificado.processadortransacao.domain.transaction.Transaction;
import com.br.pagamentosimplificado.processadortransacao.infrastructure.account.AccountRepository;
import com.br.pagamentosimplificado.processadortransacao.infrastructure.transaction.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
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
        var transactSaved = transactionRepository.save(transaction);
        var accountPayer = accountRepository.findById(UUID.fromString(transactionDataDTO.idAccountPayer())).get();
        var accountReceiver = accountRepository.findById(UUID.fromString(transactionDataDTO.idAccountReceiver())).get();
        accountPayer.pay(transactionDataDTO.value());
        accountReceiver.receivePayment(transactionDataDTO.value());
        accountRepository.saveAll(Arrays.asList(accountPayer, accountReceiver));
    }
}
