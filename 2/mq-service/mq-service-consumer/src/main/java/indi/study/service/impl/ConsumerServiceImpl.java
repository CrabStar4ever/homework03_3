package indi.study.service.impl;

import indi.study.model.Coffee;
import indi.study.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Bean
    Consumer<Coffee> sink() {
        return coffee-> {
            log.info("Rabbit receive coffee:{}, price:{}", coffee.getName(), coffee.getPrice());
        };
    }

    @Bean
    Consumer<Coffee> input() {
        return coffee-> {
            log.info("Kafka receive coffee:{}, price:{}", coffee.getName(), coffee.getPrice());
        };
    }

}
