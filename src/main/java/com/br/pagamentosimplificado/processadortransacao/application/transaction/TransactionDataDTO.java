package com.br.pagamentosimplificado.processadortransacao.application.transaction;

import java.math.BigDecimal;

public record TransactionDataDTO(

        String idAccountPayer,

        String idAccountReceiver,

        BigDecimal value) {
}
