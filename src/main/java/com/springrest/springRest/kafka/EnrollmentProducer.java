package com.springrest.springRest.kafka;

import com.springrest.springRest.entities.Enrollment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentProducer {
    private KafkaTemplate<String, Enrollment> kafkaTemplate;

    public EnrollmentProducer(KafkaTemplate<String, Enrollment> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Enrollment data) {
        Message<Enrollment> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "enrollments").build();
        kafkaTemplate.send(message);
    }
}