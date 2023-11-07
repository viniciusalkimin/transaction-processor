package com.br.pagamentosimplificado.processadortransacao.infrastructure.amqp;

import com.br.pagamentosimplificado.processadortransacao.application.transaction.service.TransacationService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionListener {

    private TransacationService transacationService;
    @RabbitListener(queues = {"${queue.name}"})
    public void processarTransacao(@Payload String transactionData){
        System.out.println(transactionData);
    }
}
