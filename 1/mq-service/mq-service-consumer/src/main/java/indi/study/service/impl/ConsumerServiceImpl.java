package indi.study.service.impl;

import indi.study.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Bean
    Consumer<String> sink() {
        return message-> {
            log.info("Consumer receive message:{}", message);
        };
    }

}
