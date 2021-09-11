package br.com.kafka.people.configuration;

import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.listener.concurrency}")
    private String concurrency;

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, GenericRecord>> userListenerBean(
            ConsumerFactory<String, GenericRecord> consumerFactory) {

        ConcurrentKafkaListenerContainerFactory<String, GenericRecord> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setConcurrency(Integer.parseInt(concurrency));
        return factory;
    }
}