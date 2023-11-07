package com.br.pagamentosimplificado.processadortransacao.infrastructure.amqp;

import com.br.pagamentosimplificado.processadortransacao.application.dto.TransactionDataDTO;
import com.br.pagamentosimplificado.processadortransacao.application.transaction.service.TransacationService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionListener {

    private TransacationService transacationService;

    private RabbitTemplate rabbitTemplate;
    @RabbitListener(queues = {"${queue.name}"})
    public void processarTransacao(TransactionDataDTO transactionDataDTO){
        transacationService.processTransaction(transactionDataDTO);
    }
}
