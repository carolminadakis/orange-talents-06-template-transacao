package br.com.zup.anaminadakis.transacao.novatransacao.listener;

import br.com.zup.anaminadakis.transacao.novatransacao.repository.TransacaoRepository;
import br.com.zup.anaminadakis.transacao.novatransacao.response.EventoDeTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}", groupId = "${spring.kafka.consumer.group-id}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
        transacaoRepository.save(eventoDeTransacao.toModel());
    }
}
