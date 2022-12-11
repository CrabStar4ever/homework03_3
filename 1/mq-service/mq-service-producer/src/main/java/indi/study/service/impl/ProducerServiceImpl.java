package indi.study.service.impl;

import indi.study.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Slf4j
@Service
public class ProducerServiceImpl implements ProducerService {

    private final Sinks.Many<Message<String>> sinks = Sinks.many().multicast().onBackpressureBuffer();

    @Bean
    public Supplier<Flux<Message<String>>> source() {
        return sinks::asFlux;
    }

    @Override
    public void sendMessage(String message) {
        log.info("Producer produce message:{}", message);
        Message<String> msg = MessageBuilder.withPayload(message).build();
    }
}
