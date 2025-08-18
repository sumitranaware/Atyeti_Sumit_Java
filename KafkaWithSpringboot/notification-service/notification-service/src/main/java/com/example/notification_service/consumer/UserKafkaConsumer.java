package com.example.notification_service.consumer;

import com.example.notification_service.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserKafkaConsumer {
    @KafkaListener(topics = "user-created-topic",groupId = "notification-service")
    public void handleUserCreated(UserCreatedEvent userCreatedEvent){
        log.info("handleUserCreated: {} ",userCreatedEvent);
    }
    @KafkaListener(topics = "user-random-topic", groupId = "notification-service")
    public void handleUserRandomTopic(String message) {
        log.info("message received {} ", message);
    }

    public class UserKafkaConsumer1 {
        @KafkaListener(topics = "user-random-topic", groupId = "notification-service")
        public void handleUserRandomTopic(String message) {
            log.info("message received {} ", message);
        }

        public class UserKafkaConsumer2 {
            @KafkaListener(topics = "user-random-topic", groupId = "notification-service")
            public void handleUserRandomTopic(String message) {
                log.info("message received {} ", message);
            }

            public class UserKafkaConsumer3 {
                @KafkaListener(topics = "user-random-topic", groupId = "notification-service")
                public void handleUserRandomTopic(String message) {
                    log.info("message received {} ", message);
                }


            }

        }
    }
}
