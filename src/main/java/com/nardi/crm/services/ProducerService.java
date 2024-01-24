package com.nardi.crm.services;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Value("${spring.kafka.producer.properties.topic.name}")
    private String KAFKA_TOPIC;

    KafkaTemplate<String, Object> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String eventType, Object value) {
        ProducerRecord<String, Object> record = new ProducerRecord<>(KAFKA_TOPIC, eventType + "#" + value.hashCode(), value);
        record.headers().add("EVENT_TYPE", eventType.getBytes());
        kafkaTemplate.send(record);

        logger.info("Sent message to eventType: {}, key: {}, value: {}", eventType, value.hashCode(), value);
    }
}
