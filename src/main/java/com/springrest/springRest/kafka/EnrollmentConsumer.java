package com.springrest.springRest.kafka;

import com.springrest.springRest.entities.Enrollment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnrollmentConsumer.class);

    @KafkaListener(topics = "enrollments", groupId = "myGroup")
    public void consume(Enrollment data) {
        LOGGER.info(String.format("Message received -> %s", data.toString()));
    }
}