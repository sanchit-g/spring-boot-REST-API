package com.springrest.springRest.kafka;

import com.springrest.springRest.payload.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @KafkaListener(topics = "course_json", groupId = "myGroup")
    public void consume(Student student) {
        LOGGER.info(String.format("JSON Message received -> %s", student.toString()));
    }
}
