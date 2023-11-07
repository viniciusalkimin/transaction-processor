package com.br.pagamentosimplificado.processadortransacao.infrastructure.amqp;

import com.br.pagamentosimplificado.processadortransacao.application.transaction.service.TransacationService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionListener {

    private TransacationService transacationService;
    @RabbitListener(queues = "transacao")
    public void processarTransacao(){

    }
}
