package br.com.kafka.people.event.consumer;

import br.com.kafka.people.event.UserAvro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(
        topics = "${spring.kafka.consumer.topic}",
        containerFactory = "userListenerBean"
)
@Slf4j
@RequiredArgsConstructor
public class UserConsumer {

    @KafkaHandler
    public void consumer(@Payload UserAvro userAvro,
                         @Header(KafkaHeaders.CORRELATION_ID) byte[] correlationId){

        System.out.println("consumed event!  correlationId =" + correlationId);
    }
}
