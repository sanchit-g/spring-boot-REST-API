package com.springrest.springRest.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic courseTopic() {
        return TopicBuilder.name("course").build();
    }

    @Bean
    public NewTopic courseJsonTopic() {
        return TopicBuilder.name("course_json").build();
    }

    @Bean
    public NewTopic enrollmentTopic() {
        return TopicBuilder.name("enrollments").build();
    }
}
