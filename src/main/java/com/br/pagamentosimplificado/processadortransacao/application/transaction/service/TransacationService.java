package com.br.pagamentosimplificado.processadortransacao.application.transaction.service;

import com.br.pagamentosimplificado.processadortransacao.application.dto.TransactionDataDTO;

public interface TransacationService {

    public void processTransaction(TransactionDataDTO transactionDataDTO);
}
