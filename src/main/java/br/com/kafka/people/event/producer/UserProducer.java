package br.com.kafka.people.event.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import br.com.kafka.people.event.UserAvro;

import java.util.UUID;

@Component
@Slf4j
public class UserProducer {

    @Value("${spring.kafka.producer.topic}")
    private String topicProducer;

    private final KafkaTemplate<String, GenericRecord> kafkaTemplate;

    public UserProducer(KafkaTemplate<String, GenericRecord> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(UserAvro userAvro) {
        String correlationId = "CORRELATION_ID_TEST";

        ProducerRecord<String, GenericRecord> record = new ProducerRecord<>(topicProducer, UUID.randomUUID().toString(), userAvro);
        record.headers().add(new RecordHeader(org.springframework.kafka.support.KafkaHeaders.CORRELATION_ID, correlationId.getBytes()));

        kafkaTemplate.send(record).addCallback(s -> {
                    System.out.println("successfully submitted to the topic " + topicProducer);
                },
                f -> {
                    System.out.println("error sending");
                });
    }

}
